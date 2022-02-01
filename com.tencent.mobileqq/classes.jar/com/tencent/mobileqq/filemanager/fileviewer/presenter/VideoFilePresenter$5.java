package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFilePresenter$5
  implements SeekBar.OnSeekBarChangeListener
{
  VideoFilePresenter$5(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (VideoFilePresenter.a(this.a) != null))
    {
      VideoFilePresenter.a(this.a, VideoFilePresenter.b(this.a, paramInt));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(VideoFilePresenter.a(this.a));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + VideoFilePresenter.a(this.a) + "]");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((VideoFilePresenter.a(this.a) == null) || (!VideoFilePresenter.a(this.a).isPlaying()))
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    VideoFilePresenter.d(this.a);
    VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_Boolean = VideoFilePresenter.a(this.a).isPlaying();
    VideoFilePresenter.a(this.a).pause();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(null);
    VideoFilePresenter.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoFilePresenter.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      VideoFilePresenter.a(this.a, VideoFilePresenter.b(this.a, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + VideoFilePresenter.a(this.a) + "]");
      }
      VideoFilePresenter.a(this.a).seekTo(VideoFilePresenter.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        VideoFilePresenter.a(this.a).post(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(true);
        VideoFilePresenter.a(this.a).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */