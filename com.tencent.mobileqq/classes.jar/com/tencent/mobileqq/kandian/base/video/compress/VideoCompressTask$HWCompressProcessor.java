package com.tencent.mobileqq.kandian.base.video.compress;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;

class VideoCompressTask$HWCompressProcessor
  implements VideoConverter.Processor
{
  final String a;
  final int b;
  final int c;
  final long d;
  final long e;
  
  VideoCompressTask$HWCompressProcessor(VideoCompressTask paramVideoCompressTask, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.d = paramLong1;
    this.e = paramLong2;
    if (paramInt2 > 0) {
      this.c = paramInt2;
    } else {
      this.c = 30;
    }
    if (paramString != null) {
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  private void a()
  {
    File localFile = new File(this.a);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    localVideoConverterConfig.output = this.a;
    long l = VideoCompressUtil.c(paramInt1, paramInt2);
    int i = VideoCompressUtil.a(paramInt1, paramInt2);
    localVideoConverterConfig.videoBitRate = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localVideoConverterConfig.scaleRate = (i / paramInt2);
    paramInt1 = this.c;
    if (paramInt1 > 30) {
      paramInt1 = 30;
    }
    localVideoConverterConfig.videoFrameRate = paramInt1;
    localVideoConverterConfig.beginTime = this.d;
    localVideoConverterConfig.endTime = this.e;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressTask, step: getEncodeConfig()\n  sourceShortEdge:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", dstResolution:");
      localStringBuilder.append(i);
      localStringBuilder.append(", scaleRate:");
      localStringBuilder.append(localVideoConverterConfig.scaleRate);
      localStringBuilder.append("\n  targetVideoBitRate:");
      localStringBuilder.append(localVideoConverterConfig.videoBitRate);
      localStringBuilder.append(", videoFrameRate:");
      localStringBuilder.append(localVideoConverterConfig.videoFrameRate);
      localStringBuilder.append("\n setRotation:");
      localStringBuilder.append(localVideoConverterConfig.setRotation);
      localStringBuilder.append(", beginTime:");
      localStringBuilder.append(localVideoConverterConfig.beginTime);
      localStringBuilder.append(", endTime:");
      localStringBuilder.append(localVideoConverterConfig.endTime);
      QLog.d("VideoCompressTask", 2, localStringBuilder.toString());
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
    a();
    if (VideoCompressTask.a(this.f) != null) {
      VideoCompressTask.a(this.f).a(6, null, null);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompressTask, step: HWCompressProcessor onFailed:");
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e("VideoCompressTask", 1, localStringBuilder.toString());
  }
  
  public void onProgress(int paramInt)
  {
    if ((VideoCompressTask.a(this.f) != null) && (!this.f.isCancelled())) {
      VideoCompressTask.a(this.f).a(paramInt / 100.0F);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */