package com.tencent.thumbplayer.caputure;

import android.util.Log;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPThumbCapture
  implements ITPCapture, ITPImageGeneratorCallback
{
  private static final String TAG = "TPThumbPlayer[TPThumbCapture.java]";
  private Map<Long, TPCaptureCallBack> mCallBackMap;
  private TPImageGenerator mImageGenerator;
  private long mOpaque = 0L;
  
  public TPThumbCapture(int paramInt)
  {
    this.mImageGenerator = new TPImageGenerator(paramInt, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.mImageGenerator.init();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", localStringBuilder.toString());
    }
  }
  
  public TPThumbCapture(String paramString)
  {
    this.mImageGenerator = new TPImageGenerator(paramString, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.mImageGenerator.init();
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: ");
      localStringBuilder.append(Log.getStackTraceString(paramString));
      TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", localStringBuilder.toString());
    }
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPImageGeneratorParams localTPImageGeneratorParams = paramTPImageGeneratorParams;
    if (paramTPImageGeneratorParams == null) {}
    try
    {
      localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.format = 37;
      this.mOpaque += 1L;
      this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPCaptureCallBack);
      try
      {
        this.mImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, localTPImageGeneratorParams);
      }
      catch (Exception paramTPImageGeneratorParams)
      {
        paramTPCaptureCallBack = new StringBuilder();
        paramTPCaptureCallBack.append("generateImageAsyncAtTime: ");
        paramTPCaptureCallBack.append(Log.getStackTraceString(paramTPImageGeneratorParams));
        TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", paramTPCaptureCallBack.toString());
      }
      return;
    }
    finally {}
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Long.valueOf(paramLong3));
    if (localTPCaptureCallBack != null) {
      if ((paramInt == 0) && (paramTPVideoFrame != null))
      {
        paramTPVideoFrame = TPCaptureUtils.frame2Bitmap(paramTPVideoFrame);
        if (paramTPVideoFrame != null) {
          localTPCaptureCallBack.onCaptureVideoSuccess(paramTPVideoFrame);
        } else {
          localTPCaptureCallBack.onCaptureVideoFailed(1000001);
        }
      }
      else
      {
        localTPCaptureCallBack.onCaptureVideoFailed(paramInt);
      }
    }
    this.mCallBackMap.remove(Long.valueOf(paramLong3));
  }
  
  public void release()
  {
    try
    {
      this.mImageGenerator.cancelAllImageGenerations();
      this.mImageGenerator.unInit();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release: ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", localStringBuilder.toString());
    }
    this.mCallBackMap.clear();
    this.mImageGenerator = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPThumbCapture
 * JD-Core Version:    0.7.0.1
 */