package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class DepthMaskRenderItem
  extends RenderItem
{
  private static final String TAG = "DepthMaskRenderItem";
  private String mMateriaPath;
  private long mStartTime = -1L;
  private int[] mTextIDs;
  private HashMap<String, Integer> mTextureIDMap;
  private HashMap<String, Boolean> mTextureLoadedMap;
  private LinkedHashMap<String, Integer> mTexturesMap;
  private int mlastImageIndex = -1;
  
  public DepthMaskRenderItem(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem, LinkedHashMap<String, Integer> paramLinkedHashMap, String paramString)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
    this.mMateriaPath = paramString;
    if ((paramLinkedHashMap != null) && (paramLinkedHashMap.size() > 0))
    {
      this.mTextureLoadedMap = new HashMap();
      this.mTexturesMap = new LinkedHashMap();
      this.mTextureIDMap = new HashMap();
      paramAEFilterI = paramLinkedHashMap.keySet().iterator();
      while (paramAEFilterI.hasNext())
      {
        paramTriggerCtrlItem = (String)paramAEFilterI.next();
        this.mTexturesMap.put(paramTriggerCtrlItem, paramLinkedHashMap.get(paramTriggerCtrlItem));
        this.mTextureLoadedMap.put(paramTriggerCtrlItem, Boolean.valueOf(false));
        this.mTextureIDMap.put(paramTriggerCtrlItem, Integer.valueOf(0));
      }
    }
  }
  
  public void apply()
  {
    super.apply();
    if ((this.filter instanceof DepthMaskFilter)) {
      ((VideoFilterBase)this.filter).ApplyGLSLFilter();
    }
    if ((this.mTextureIDMap != null) && (this.mTextureIDMap.size() > 0))
    {
      this.mTextIDs = new int[this.mTexturesMap.size()];
      GlUtil.createEtcTexture(this.mTextIDs);
      Iterator localIterator = this.mTextureIDMap.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.mTextureIDMap.put(str, Integer.valueOf(this.mTextIDs[i]));
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    super.clear();
    if ((this.filter instanceof VideoFilterBase)) {
      ((VideoFilterBase)this.filter).clearGLSLSelf();
    }
    if (this.mTextureIDMap != null) {
      this.mTextureIDMap.clear();
    }
    if (this.mTextureLoadedMap != null) {
      this.mTextureLoadedMap.clear();
    }
    if (this.mTexturesMap != null) {
      this.mTexturesMap.clear();
    }
    if (this.mTextIDs != null) {
      GLES20.glDeleteTextures(this.mTextIDs.length, this.mTextIDs, 0);
    }
  }
  
  public boolean loadTexture(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.mMateriaPath == null) {}
    for (;;)
    {
      return false;
      Object localObject = VideoMemoryManager.getInstance().loadImage(paramString, paramInt1);
      if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!paramBoolean)))
      {
        localObject = this.mMateriaPath + File.separator + paramString + "_" + paramInt1 + ".png";
        localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      }
      for (paramInt1 = 1; BitmapUtils.isLegal((Bitmap)localObject); paramInt1 = 0) {
        try
        {
          GlUtil.loadTexture(paramInt2, (Bitmap)localObject);
          if (paramInt1 != 0)
          {
            ((Bitmap)localObject).recycle();
            return true;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtils.e("DepthMaskRenderItem", "getNextFrame:loadTexture Exception:" + localException.getMessage());
            continue;
            VideoMemoryManager.getInstance().recycleBitmap(paramString, (Bitmap)localObject);
          }
        }
      }
    }
  }
  
  public void reset()
  {
    this.mStartTime = -1L;
    this.mlastImageIndex = -1;
  }
  
  public void setDepthMaskParams(Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    if (!(this.filter instanceof DepthMaskFilter)) {
      return;
    }
    DepthMaskFilter localDepthMaskFilter = (DepthMaskFilter)this.filter;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localDepthMaskFilter.setDepthMask(paramBitmap);
    }
    localDepthMaskFilter.setPixelRange(paramArrayOfFloat);
  }
  
  public void updateBitmapTexutre()
  {
    int m = this.triggerCtrlItem.getFrameIndex();
    if ((this.mlastImageIndex == m) || (this.mTexturesMap == null) || (this.mTexturesMap.size() == 0)) {
      return;
    }
    Iterator localIterator = this.mTexturesMap.entrySet().iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        int k = ((Integer)localEntry.getValue()).intValue();
        int j = k;
        if (k <= 0) {
          j = 1;
        }
        try
        {
          if (loadTexture(str, m % j, ((Boolean)this.mTextureLoadedMap.get(str)).booleanValue(), ((Integer)this.mTextureIDMap.get(str)).intValue()))
          {
            this.mTextureLoadedMap.put(str, Boolean.valueOf(true));
            ((DepthMaskFilter)this.filter).updateTexutre(i, ((Integer)this.mTextureIDMap.get(str)).intValue());
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtils.e("DepthMaskRenderItem", localException);
          }
        }
      }
    }
    this.mlastImageIndex = m;
  }
  
  public void updatePreview(Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof PTDetectInfo)) && ((this.filter instanceof DepthMaskFilter)) && (this.triggerCtrlItem.isTriggered()))
    {
      localObject = (PTDetectInfo)paramObject;
      if (this.mStartTime == -1L) {
        this.mStartTime = ((PTDetectInfo)localObject).timestamp;
      }
      float f = (float)(((PTDetectInfo)localObject).timestamp - this.mStartTime);
      ((DepthMaskFilter)this.filter).updateCurTime(0.001F * f);
      if (((PTDetectInfo)localObject).facePoints == null) {
        break label121;
      }
      localObject = VideoMaterialUtil.toFlatArray(((PTDetectInfo)localObject).facePoints);
      if (localObject != null) {
        ((DepthMaskFilter)this.filter).updateFacePoints((float[])localObject);
      }
    }
    for (;;)
    {
      super.updatePreview(paramObject);
      return;
      label121:
      localObject = new float['´'];
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i] = 0.0F;
        i += 1;
      }
      ((DepthMaskFilter)this.filter).updateFacePoints((float[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.DepthMaskRenderItem
 * JD-Core Version:    0.7.0.1
 */