package com.tencent.mobileqq.winkpublish.task.compress;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;

class VideoCompressTask$1
  implements Runnable
{
  VideoCompressTask$1(VideoCompressTask paramVideoCompressTask) {}
  
  public void run()
  {
    if (!this.this$0.c) {
      return;
    }
    VideoCompressTask.a(this.this$0);
    QCircleHostQzoneThreadHelper.postRealTimeThreadDelayed(this.this$0.h, VideoCompressTask.b(this.this$0));
    VideoCompressTask.VideoCompressListener localVideoCompressListener = this.this$0.f;
    VideoCompressTask localVideoCompressTask = this.this$0;
    localVideoCompressListener.a(localVideoCompressTask, localVideoCompressTask.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask.1
 * JD-Core Version:    0.7.0.1
 */