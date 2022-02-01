package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.qphone.base.util.QLog;

class FFmpegExecuteAsyncTask$1
  implements Runnable
{
  FFmpegExecuteAsyncTask$1(FFmpegExecuteAsyncTask paramFFmpegExecuteAsyncTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ThreadName:");
      localStringBuilder.append(Thread.currentThread().getName());
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, localStringBuilder.toString());
    }
    this.this$0.ffmpegExecuteResponseHandler.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */