package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class VideoFilePresenter$9
  implements AudioManager.OnAudioFocusChangeListener
{
  VideoFilePresenter$9(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (VideoFilePresenter.a(this.a) != null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "onAudioFocusChange:mVideoView null!");
      return;
    }
    boolean bool = VideoFilePresenter.a(this.a).isPlaying();
    if (paramInt == -2)
    {
      if (bool) {
        VideoFilePresenter.a(this.a);
      }
    }
    else if (paramInt == 1)
    {
      if ((!bool) && (this.a.a != null) && ((this.a.a instanceof FileBrowserActivity)) && (((FileBrowserActivity)this.a.a).isResume())) {
        VideoFilePresenter.c(this.a);
      }
    }
    else if ((paramInt == -1) && (bool)) {
      VideoFilePresenter.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.9
 * JD-Core Version:    0.7.0.1
 */