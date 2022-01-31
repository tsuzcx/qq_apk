package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.caputure.TPCaptureUtils;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.util.Map;

public class TPVideoCapture
  implements ITPImageGeneratorCallback
{
  private Map<Long, TPVideoCapture.TPVideoCaptureCallBack> mCallBackMap;
  private int mHeight = 0;
  private long mOpaque = 0L;
  private long mRequestedTimeMsToleranceAfter = 0L;
  private long mRequestedTimeMsToleranceBefore = 0L;
  private TPImageGenerator mTpImageGenerator = new TPImageGenerator(paramString, this);
  private int mWidth = 0;
  
  public TPVideoCapture(String paramString)
  {
    this.mTpImageGenerator.init();
  }
  
  private TPImageGeneratorParams getParameters()
  {
    TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
    localTPImageGeneratorParams.format = 37;
    localTPImageGeneratorParams.width = this.mWidth;
    localTPImageGeneratorParams.height = this.mHeight;
    localTPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
    localTPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
    return localTPImageGeneratorParams;
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPVideoCapture.TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    this.mOpaque += 1L;
    this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPVideoCaptureCallBack);
    this.mTpImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, getParameters());
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, TPVideoCapture.TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    this.mOpaque += 1L;
    this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPVideoCaptureCallBack);
    this.mTpImageGenerator.generateImagesAsyncForTimes(paramArrayOfLong, this.mOpaque, getParameters());
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    TPVideoCapture.TPVideoCaptureCallBack localTPVideoCaptureCallBack = (TPVideoCapture.TPVideoCaptureCallBack)this.mCallBackMap.get(Long.valueOf(paramLong3));
    if (localTPVideoCaptureCallBack != null)
    {
      if ((paramInt != 0) || (paramTPVideoFrame == null)) {
        break label61;
      }
      localTPVideoCaptureCallBack.onCaptureSuccess(TPCaptureUtils.frame2Bitmaps(paramTPVideoFrame));
    }
    for (;;)
    {
      this.mCallBackMap.remove(Long.valueOf(paramLong3));
      return;
      label61:
      localTPVideoCaptureCallBack.onCaptureError(paramInt);
    }
  }
  
  public void release()
  {
    if (this.mTpImageGenerator != null)
    {
      this.mTpImageGenerator.cancelAllImageGenerations();
      this.mTpImageGenerator.unInit();
      this.mTpImageGenerator = null;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Size is illegal");
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setTimeMsTolerance(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      throw new IllegalArgumentException("Tolerance is illegal");
    }
    this.mRequestedTimeMsToleranceBefore = paramLong1;
    this.mRequestedTimeMsToleranceAfter = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture
 * JD-Core Version:    0.7.0.1
 */