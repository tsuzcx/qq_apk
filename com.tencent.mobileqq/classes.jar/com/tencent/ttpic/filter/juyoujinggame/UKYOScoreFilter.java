package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.PTFaceLogUtil;
import java.io.File;

public class UKYOScoreFilter
  extends StaticStickerFilter
{
  private static final String TAG = "UKYOFilter";
  private String mImageID;
  
  public UKYOScoreFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    this.mImageID = paramStickerItem.id;
  }
  
  public int getNextFrame(int paramInt)
  {
    if (this.mImageID == null) {
      return this.tex[0];
    }
    Object localObject = VideoMemoryManager.getInstance().loadImage(this.mImageID, paramInt);
    if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.isRenderForBitmap)))
    {
      localObject = FileUtils.genSeperateFileDir(this.dataPath) + this.item.subFolder + File.separator + this.mImageID + "_" + paramInt + ".png";
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    for (int i = 1;; i = 0)
    {
      if (BitmapUtils.isLegal((Bitmap)localObject)) {
        BenchUtil.benchStart("normal loadTexture");
      }
      try
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
        BenchUtil.benchEnd("normal loadTexture");
        if (i != 0)
        {
          ((Bitmap)localObject).recycle();
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
          return this.tex[0];
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          PTFaceLogUtil.e("UKYOFilter", "getNextFrame:loadTexture Exception:" + localException.getMessage());
          continue;
          VideoMemoryManager.getInstance().recycleBitmap(this.mImageID, (Bitmap)localObject);
        }
      }
    }
  }
  
  public void setForceFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setFrameIndex(int paramInt)
  {
    if (this.lastImageIndex < 0) {
      paramInt = 0;
    }
    this.frameIndex = paramInt;
  }
  
  public void setImageID(String paramString)
  {
    this.mImageID = paramString;
    this.lastImageIndex = -1;
  }
  
  public void setItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((!this.item.isDisplacementMaterial()) || (paramObject.displacementMaskFrame == null) || (paramObject.displacementMaskFrame.getLastRenderTextureId() <= 0)) {
        break label119;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture5", paramObject.displacementMaskFrame.getLastRenderTextureId(), 33989));
      addParam(new UniformParam.FloatParam("useDisplacementMask", 1.0F));
    }
    int i;
    for (;;)
    {
      updatePlayer(this.isFirstTriggered);
      i = this.frameIndex;
      if (needRenderTexture()) {
        break;
      }
      clearTextureParam();
      VideoMemoryManager.getInstance().reset(this.mImageID);
      updateTextureParam(0, paramObject.timestamp);
      return;
      label119:
      addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
      addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
    }
    updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
    updateTextureParam(i, paramObject.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScoreFilter
 * JD-Core Version:    0.7.0.1
 */