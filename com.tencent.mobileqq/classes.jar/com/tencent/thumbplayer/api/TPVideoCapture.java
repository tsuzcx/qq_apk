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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: ");
      localStringBuilder.append(Log.getStackTraceString(paramString));
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", localStringBuilder.toString());
    }
  }
  
  private String generateOpaqueKey(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opaque_");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("time_");
    localStringBuilder.append(paramLong2);
    return localStringBuilder.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateImageAsyncAtTime: ");
      localStringBuilder.append(Log.getStackTraceString(paramTPVideoCaptureCallBack));
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", localStringBuilder.toString());
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
      paramTPVideoCaptureCallBack = new StringBuilder();
      paramTPVideoCaptureCallBack.append("generateImagesAsyncForTimes: ");
      paramTPVideoCaptureCallBack.append(Log.getStackTraceString(paramArrayOfLong));
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", paramTPVideoCaptureCallBack.toString());
    }
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    TPVideoCapture.TPVideoCaptureCallBack localTPVideoCaptureCallBack = (TPVideoCapture.TPVideoCaptureCallBack)this.mCallBackMap.get(generateOpaqueKey(paramLong3, paramLong1));
    if (localTPVideoCaptureCallBack != null) {
      if ((paramInt == 0) && (paramTPVideoFrame != null)) {
        localTPVideoCaptureCallBack.onCaptureSuccess(TPCaptureUtils.frame2Bitmaps(paramTPVideoFrame));
      } else {
        localTPVideoCaptureCallBack.onCaptureError(paramInt);
      }
    }
    this.mCallBackMap.remove(generateOpaqueKey(paramLong3, paramLong1));
  }
  
  public void release()
  {
    try
    {
      this.mTpImageGenerator.cancelAllImageGenerations();
      this.mTpImageGenerator.unInit();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release: ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      TPLogUtil.e("TPThumbPlayer[TPVideoCapture.java]", localStringBuilder.toString());
    }
    this.mCallBackMap.clear();
    this.mTpImageGenerator = null;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      return;
    }
    throw new IllegalArgumentException("Size is illegal");
  }
  
  public void setTimeMsTolerance(long paramLong1, long paramLong2)
  {
    if (paramLong1 <= paramLong2)
    {
      this.mRequestedTimeMsToleranceBefore = paramLong1;
      this.mRequestedTimeMsToleranceAfter = paramLong2;
      return;
    }
    throw new IllegalArgumentException("Tolerance is illegal");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture
 * JD-Core Version:    0.7.0.1
 */