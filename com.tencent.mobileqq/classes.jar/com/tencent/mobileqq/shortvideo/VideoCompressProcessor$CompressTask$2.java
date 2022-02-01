package com.tencent.mobileqq.shortvideo;

import com.tencent.qphone.base.util.QLog;

class VideoCompressProcessor$CompressTask$2
  implements VideoCompressProcessor.HWCompressUpdateListener
{
  VideoCompressProcessor$CompressTask$2(VideoCompressProcessor.CompressTask paramCompressTask) {}
  
  public void a(float paramFloat)
  {
    if (VideoCompressProcessor.CompressTask.a(this.a) != null) {
      VideoCompressProcessor.CompressTask.a(this.a).a(this.a.a, paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hardware compress finish code: ");
    localStringBuilder.append(paramInt);
    QLog.d("VideoCompressProcessor", 1, localStringBuilder.toString());
    if (VideoCompressProcessor.CompressTask.a(this.a) != null)
    {
      VideoCompressProcessor.CompressTask.a(this.a).a(this.a.a, 1.0F);
      VideoCompressProcessor.CompressTask.a(this.a).a(this.a.a, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask.2
 * JD-Core Version:    0.7.0.1
 */