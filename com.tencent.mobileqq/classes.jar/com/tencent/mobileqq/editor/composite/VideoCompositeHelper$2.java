package com.tencent.mobileqq.editor.composite;

import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.ConvertListener;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.RetCode;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class VideoCompositeHelper$2
  implements VideoStoryPicToVideo.ConvertListener
{
  VideoCompositeHelper$2(VideoCompositeHelper paramVideoCompositeHelper, VideoStoryPicToVideo.RetCode paramRetCode, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.a.a(0);
    this.b.videoRangeEnd = 60000;
    VideoCompositeHelper.a(this.c, "convertImageToVideo ");
  }
  
  public void b(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.a.a(paramRetCode.a());
    VideoCompositeHelper.a(this.c, "convertImageToVideo ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.2
 * JD-Core Version:    0.7.0.1
 */