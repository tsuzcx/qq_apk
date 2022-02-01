package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class VideoFilePresenter$6
  implements Runnable
{
  VideoFilePresenter$6(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    if (VideoFilePresenter.a(this.this$0) != null) {
      this.this$0.a.d(VideoFilePresenter.a(this.this$0).isPlaying());
    }
    for (;;)
    {
      VideoFilePresenter.d(this.this$0);
      return;
      this.this$0.a.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */