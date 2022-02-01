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
      paramSeekBar = this.a;
      VideoFilePresenter.a(paramSeekBar, VideoFilePresenter.b(paramSeekBar, paramInt));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(VideoFilePresenter.a(this.a));
      if (QLog.isDevelopLevel())
      {
        paramSeekBar = new StringBuilder();
        paramSeekBar.append("onProgressChanged userPos[");
        paramSeekBar.append(VideoFilePresenter.a(this.a));
        paramSeekBar.append("]");
        QLog.d("#@#@", 1, paramSeekBar.toString());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((VideoFilePresenter.a(this.a) != null) && (VideoFilePresenter.a(this.a).isPlaying()))
    {
      VideoFilePresenter.d(this.a);
      VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      paramSeekBar = this.a;
      paramSeekBar.jdField_a_of_type_Boolean = VideoFilePresenter.a(paramSeekBar).isPlaying();
      VideoFilePresenter.a(this.a).pause();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(null);
      VideoFilePresenter.a(this.a, true);
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoFilePresenter.a(this.a) != null)
    {
      Object localObject = this.a;
      VideoFilePresenter.a((VideoFilePresenter)localObject, VideoFilePresenter.b((VideoFilePresenter)localObject, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mMediaPlayer sekTo [");
        ((StringBuilder)localObject).append(VideoFilePresenter.a(this.a));
        ((StringBuilder)localObject).append("]");
        QLog.d("##########", 1, ((StringBuilder)localObject).toString());
      }
      VideoFilePresenter.a(this.a).seekTo(VideoFilePresenter.a(this.a));
      if (this.a.jdField_a_of_type_Boolean)
      {
        VideoFilePresenter.a(this.a).post(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(true);
        VideoFilePresenter.a(this.a).play();
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */