package com.tencent.ttpic.videoshelf.model.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.libpag.PagUtil;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import com.tencent.view.FilterContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

public class PagVideoShelfProcessor
  implements SurfaceTexture.OnFrameAvailableListener, IVideoShelfProcessor
{
  private static final int MAX_FRAME_PER = 25;
  public static final String PAG_CONTENT_OBJ = "PagVideoShelfProcessor_1";
  public static final String PAG_FILE_DURATION = "PagVideoShelfProcessor_3";
  public static final String PAG_FILE_PATH = "PagVideoShelfProcessor_0";
  public static final String PAG_IMG_LIST = "PagVideoShelfProcessor_4";
  public static final String PAG_RENDER_OBJ = "PagVideoShelfProcessor_2";
  private static final float PER_FRAME_GAP = 40000.0F;
  private static final String TAG = "PagVideoShelfProcessor";
  private BaseFilter copyFilter = new SurfaceTextureFilter();
  private int mDrawCount = 0;
  private long mDuration = 0L;
  private FilterContext mFilterContext;
  private float mFrameGap;
  private int mGetFpsCount = 0;
  private double mLastFlushProgress = -1.0D;
  private boolean mNeedUpdateFrame = false;
  private Frame mOutFrame;
  private PAGFile mPagFile;
  private String mPagFilePath;
  private PAGRenderer mPagRenderer;
  private PAGSurface mPagSurface;
  private int mParsedTxtID;
  private double mProgress = 0.0D;
  private HashMap<String, int[]> mReplaceImgs;
  private SurfaceTexture mSurfaceTexture;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public PagVideoShelfProcessor()
  {
    if (!PagUtil.isSupportPagForVideo()) {
      throw new PagNotSupportSystemException("PagVideoShelfProcessor");
    }
  }
  
  private long getDuration()
  {
    if ((this.mDuration == 0L) && (this.mPagFile != null))
    {
      this.mDuration = this.mPagFile.duration();
      TTPTLogger.i("PagVideoShelfProcessor", "duration:" + this.mDuration);
      if (this.mDuration <= 0L) {
        break label82;
      }
    }
    label82:
    for (float f = 40000.0F / (float)this.mDuration;; f = 0.0F)
    {
      this.mFrameGap = f;
      return this.mDuration;
    }
  }
  
  private void parseImageText(List<NodeGroup> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Iterator localIterator1;
    do
    {
      return;
      localIterator1 = paramList.iterator();
    } while (!localIterator1.hasNext());
    Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
    label48:
    NodeItem localNodeItem;
    if (localIterator2.hasNext())
    {
      localNodeItem = (NodeItem)localIterator2.next();
      if (localNodeItem.type != 1) {
        break label96;
      }
    }
    label96:
    for (paramList = localNodeItem.bitmap;; paramList = localNodeItem.cropBitmap)
    {
      replacesImg(paramList, localNodeItem.indexLayerForPag);
      break label48;
      break;
    }
  }
  
  private void proceeHashMapSetting(HashMap<String, int[]> paramHashMap)
  {
    if (paramHashMap == null) {}
    for (;;)
    {
      return;
      if (this.mPagRenderer == null)
      {
        this.mReplaceImgs = paramHashMap;
        return;
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        Bitmap localBitmap = BitmapUtils.decodeSampledBitmapFromFile((String)localEntry.getKey(), 1080, 1080);
        replacesImg(localBitmap, (int[])localEntry.getValue());
        if (localBitmap != null) {
          localBitmap.recycle();
        }
      }
    }
  }
  
  private void replacesImg(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    try
    {
      if ((this.mPagRenderer != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramArrayOfInt != null))
      {
        paramBitmap = PAGImage.FromBitmap(paramBitmap);
        paramBitmap.setScaleMode(3);
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          if (k < this.mPagFile.numImages()) {
            this.mPagRenderer.replaceImage(k, paramBitmap);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void clear()
  {
    TTPTLogger.i("PagVideoShelfProcessor", "clear:" + this.mProgress);
    this.mFilterContext = null;
    if (this.mPagRenderer != null) {
      this.mPagRenderer.setSurface(null);
    }
    if (this.mPagSurface != null) {
      this.mPagSurface.freeCache();
    }
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.setOnFrameAvailableListener(null);
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    this.mParsedTxtID = 0;
    if (this.copyFilter != null) {
      this.copyFilter.ClearGLSL();
    }
    this.mProgress = 0.0D;
    this.mLastFlushProgress = -1.0D;
    this.mNeedUpdateFrame = false;
    this.mDrawCount = 0;
    this.mGetFpsCount = 0;
  }
  
  public Frame draw()
  {
    if (this.mPagRenderer == null) {}
    while (!this.mNeedUpdateFrame) {
      return null;
    }
    this.mOutFrame = this.copyFilter.RenderProcess(this.mParsedTxtID, this.mVideoWidth, this.mVideoHeight);
    GLES20.glFinish();
    this.mNeedUpdateFrame = false;
    this.mDrawCount += 1;
    return this.mOutFrame;
  }
  
  public long getCurFrameTimeStamp()
  {
    return (this.mProgress * this.mDuration * 0.001D);
  }
  
  public int getProgress()
  {
    int i = (int)(this.mProgress * 100.0D);
    if (i > 1) {
      return i;
    }
    return 1;
  }
  
  public void init(int[] paramArrayOfInt, List<VideoFrameItem> paramList, List<NodeGroup> paramList1)
  {
    TTPTLogger.i("PagVideoShelfProcessor", "init.");
    this.mParsedTxtID = paramArrayOfInt[0];
    this.copyFilter.apply();
    this.mSurfaceTexture = new SurfaceTexture(this.mParsedTxtID);
    this.mSurfaceTexture.setDefaultBufferSize(this.mVideoWidth, this.mVideoHeight);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mPagSurface = PAGSurface.FromSurfaceTexture(this.mSurfaceTexture);
    this.mPagRenderer.setSurface(this.mPagSurface);
    this.mPagRenderer.setMaxFrameRate(25.0F);
    parseImageText(paramList1);
    proceeHashMapSetting(this.mReplaceImgs);
    if (this.mPagFile != null)
    {
      this.mDuration = getDuration();
      this.mPagRenderer.setFile(this.mPagFile);
      this.mPagRenderer.setProgress(0.0D);
    }
  }
  
  public int isPrepareInit()
  {
    this.mPagFile = PAGFile.Load(this.mPagFilePath);
    if (this.mPagFile != null)
    {
      int i = this.mPagFile.tagLevel();
      PAGFile localPAGFile = this.mPagFile;
      if (i > PAGFile.MaxSupportedTagLevel()) {
        return 2;
      }
      this.mPagRenderer = new PAGRenderer();
      if (OfflineConfig.isNeedSoftDecode()) {
        PagUtil.useSoftDecode();
      }
      return 0;
    }
    return 1;
  }
  
  public boolean makeCurrent()
  {
    if (this.mFilterContext != null)
    {
      this.mFilterContext.usecurruntContext();
      return true;
    }
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((makeCurrent()) && (this.mSurfaceTexture != null))
    {
      this.mSurfaceTexture.updateTexImage();
      this.mNeedUpdateFrame = true;
    }
  }
  
  public int parseFrame()
  {
    if ((!this.mNeedUpdateFrame) && (this.mDrawCount == this.mGetFpsCount) && (this.mProgress > this.mLastFlushProgress))
    {
      boolean bool = this.mPagRenderer.flush();
      Log.i("PagVideoShelfProcessor", "parseFrame:flush:" + this.mProgress);
      if (!bool) {
        this.mNeedUpdateFrame = true;
      }
      this.mLastFlushProgress = this.mProgress;
    }
    return 0;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!paramString.equals("PagVideoShelfProcessor_0")) {
                    break;
                  }
                  i = 0;
                  break;
                  if (!paramString.equals("outVideoWidthHeight")) {
                    break;
                  }
                  i = 1;
                  break;
                  if (!paramString.equals("PagVideoShelfProcessor_1")) {
                    break;
                  }
                  i = 2;
                  break;
                  if (!paramString.equals("PagVideoShelfProcessor_2")) {
                    break;
                  }
                  i = 3;
                  break;
                  if (!paramString.equals("PagVideoShelfProcessor_3")) {
                    break;
                  }
                  i = 4;
                  break;
                  if (!paramString.equals("PagVideoShelfProcessor_4")) {
                    break;
                  }
                  i = 5;
                  break;
                } while (!(paramObject instanceof String));
                this.mPagFilePath = ((String)paramObject);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof int[])));
              paramString = (int[])paramObject;
              this.mVideoWidth = paramString[0];
              this.mVideoHeight = paramString[1];
              return;
            } while ((paramObject == null) || (!(paramObject instanceof FilterContext)));
            this.mFilterContext = ((FilterContext)paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof PAGRenderer)));
          this.mPagRenderer = ((PAGRenderer)paramObject);
          if (OfflineConfig.isNeedSoftDecode()) {
            PagUtil.useSoftDecode();
          }
          if (this.mPagSurface != null) {
            this.mPagRenderer.setSurface(this.mPagSurface);
          }
          this.mProgress = this.mPagRenderer.getProgress();
          return;
        } while ((paramObject == null) || (!(paramObject instanceof Long)));
        this.mDuration = ((Long)paramObject).longValue();
        if (this.mDuration > 0L) {}
        for (float f = 40000.0F / (float)this.mDuration;; f = 0.0F)
        {
          this.mFrameGap = f;
          return;
        }
      } while ((paramObject == null) || (!(paramObject instanceof HashMap)));
      paramString = (HashMap)paramObject;
    } while (paramString == null);
    proceeHashMapSetting(paramString);
  }
  
  public boolean updateFrameCursor()
  {
    if ((!this.mNeedUpdateFrame) && (this.mDrawCount > this.mGetFpsCount))
    {
      if (this.mProgress < 1.0D)
      {
        this.mProgress += this.mFrameGap;
        this.mGetFpsCount += 1;
        if (this.mOutFrame != null) {
          this.mOutFrame.unlock();
        }
        if ((this.mPagRenderer == null) || (this.mProgress > 1.0D)) {
          break label97;
        }
        this.mPagRenderer.setProgress(this.mProgress);
      }
    }
    else {
      return true;
    }
    return false;
    label97:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor
 * JD-Core Version:    0.7.0.1
 */