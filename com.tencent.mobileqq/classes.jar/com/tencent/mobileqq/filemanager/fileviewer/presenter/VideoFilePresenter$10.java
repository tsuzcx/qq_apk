package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class VideoFilePresenter$10
  implements Runnable
{
  VideoFilePresenter$10(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void run()
  {
    if (VideoFilePresenter.a(this.this$0) == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(VideoFilePresenter.a(this.this$0).isPlaying());
    if (!VideoFilePresenter.a(this.this$0))
    {
      if (!VideoFilePresenter.a(this.this$0).isPlaying()) {
        return;
      }
      int i = (int)VideoFilePresenter.a(this.this$0).getCurPlayingPos();
      int j = (int)VideoFilePresenter.a(this.this$0).getVideoDurationMs();
      VideoFileViewer localVideoFileViewer = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer;
      long l = i;
      localVideoFileViewer.b(l);
      if ((!VideoFilePresenter.b(this.this$0)) && (l > VideoFilePresenter.a(this.this$0))) {
        VideoFilePresenter.a(this.this$0, l);
      }
      float f = i / j;
      if (f <= 0.001D)
      {
        VideoFilePresenter.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
        return;
      }
      if (i >= VideoFilePresenter.a(this.this$0)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.c((int)(f * 10000.0F));
      }
      VideoFilePresenter.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */