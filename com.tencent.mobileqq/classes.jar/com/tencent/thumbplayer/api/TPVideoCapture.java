package com.tencent.thumbplayer.api;

import android.util.Log;
import com.tencent.thumbplayer.caputure.TPCaptureUtils;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPVideoCapture
  implements ITPImageGeneratorCallback
{
  private static final String TAG = "TPThumbPlayer[TPVideoCapture.java]";
  private Map<String, TPVideoCapture.TPVideoCaptureCallBack> mCallBackMap = new HashMap();
  private int mHeight = 0;
  private long mOpaque = 0L;
  private long mRequestedTimeMsToleranceAfter = 0L;
  private long mRequestedTimeMsToleranceBefore = 0L;
  private TPImageGenerator mTpImageGenerator = new TPImageGenerator(paramString, this);
  private int mWidth = 0;
  
  public TPVideoCapture(String paramString)
  {
    try
    {
      this.mTpImageGenerator.init();
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", "init: " + Log.getStackTraceString(paramString));
    }
  }
  
  private String generateOpaqueKey(long paramLong1, long paramLong2)
  {
    return "opaque_" + paramLong1 + "time_" + paramLong2;
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
    this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, paramLong), paramTPVideoCaptureCallBack);
    try
    {
      this.mTpImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, getParameters());
      return;
    }
    catch (Exception paramTPVideoCaptureCallBack)
    {
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPVideoCaptureCallBack));
    }
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, TPVideoCapture.TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    this.mOpaque += 1L;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, l), paramTPVideoCaptureCallBack);
      i += 1;
    }
    try
    {
      this.mTpImageGenerator.generateImagesAsyncForTimes(paramArrayOfLong, this.mOpaque, getParameters());
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", "generateImagesAsyncForTimes: " + Log.getStackTraceString(paramArrayOfLong));
    }
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    TPVideoCapture.TPVideoCaptureCallBack localTPVideoCaptureCallBack = (TPVideoCapture.TPVideoCaptureCallBack)this.mCallBackMap.get(generateOpaqueKey(paramLong3, paramLong1));
    if (localTPVideoCaptureCallBack != null)
    {
      if ((paramInt != 0) || (paramTPVideoFrame == null)) {
        break label65;
      }
      localTPVideoCaptureCallBack.onCaptureSuccess(TPCaptureUtils.frame2Bitmaps(paramTPVideoFrame));
    }
    for (;;)
    {
      this.mCallBackMap.remove(generateOpaqueKey(paramLong3, paramLong1));
      return;
      label65:
      localTPVideoCaptureCallBack.onCaptureError(paramInt);
    }
  }
  
  public void release()
  {
    try
    {
      this.mTpImageGenerator.cancelAllImageGenerations();
      this.mTpImageGenerator.unInit();
      this.mCallBackMap.clear();
      this.mTpImageGenerator = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", "release: " + Log.getStackTraceString(localException));
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture
 * JD-Core Version:    0.7.0.1
 */