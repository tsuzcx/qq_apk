package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.lang.ref.WeakReference;

class VideoCompressProcessor$HWCompressProcessor
  implements VideoConverter.Processor
{
  WeakReference<QQAppInterface> a;
  final String b;
  final String c;
  VideoCompressConfig.CompressInfo d;
  VideoCompressProcessor.HWCompressUpdateListener e;
  
  VideoCompressProcessor$HWCompressProcessor(WeakReference<QQAppInterface> paramWeakReference, String paramString1, String paramString2, VideoCompressConfig.CompressInfo paramCompressInfo, VideoCompressProcessor.HWCompressUpdateListener paramHWCompressUpdateListener)
  {
    this.a = paramWeakReference;
    this.b = paramString2;
    this.c = paramString1;
    this.e = paramHWCompressUpdateListener;
    if (paramString2 != null)
    {
      this.d = paramCompressInfo;
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    localVideoConverterConfig.output = this.b;
    localVideoConverterConfig.scaleRate = this.d.e;
    localVideoConverterConfig.videoFrameRate = ((int)this.d.d);
    localVideoConverterConfig.videoBitRate = ((int)this.d.c);
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
    }
    VideoCompressProcessor.HWCompressUpdateListener localHWCompressUpdateListener = this.e;
    if (localHWCompressUpdateListener != null) {
      localHWCompressUpdateListener.a(3);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    paramThrowable = this.e;
    if (paramThrowable != null) {
      paramThrowable.a(2);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask, step: HWCompressProcessor onProgress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (paramInt >= 0) && (paramInt <= 10000)) {
      ((VideoCompressProcessor.HWCompressUpdateListener)localObject).a(paramInt / 10000.0F);
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
    }
    VideoCompressProcessor.HWCompressUpdateListener localHWCompressUpdateListener = this.e;
    if (localHWCompressUpdateListener != null) {
      localHWCompressUpdateListener.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */