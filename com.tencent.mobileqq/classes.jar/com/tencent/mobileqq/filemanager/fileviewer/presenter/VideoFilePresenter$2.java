package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class VideoFilePresenter$2
  implements View.OnClickListener
{
  VideoFilePresenter$2(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131444737: 
      int i = this.a.c.R();
      int j = this.a.c.O();
      if ((i == 6) && (j == 1) && (this.a.c.e() != null)) {
        this.a.c.e().a();
      }
      break;
    case 2131440370: 
      if (VideoFilePresenter.a(this.a) != null)
      {
        boolean bool = VideoFilePresenter.a(this.a).isPlaying();
        if (bool)
        {
          VideoFilePresenter.b(this.a).removeCallbacks(this.a.k);
          FileManagerReporter.a("0X8004BE5");
          this.a.b.abandonAudioFocus(VideoFilePresenter.c(this.a));
          VideoFilePresenter.d(this.a);
        }
        else
        {
          VideoFilePresenter.e(this.a);
          VideoFilePresenter.f(this.a);
        }
        this.a.a.d(bool ^ true);
      }
      break;
    case 2131438098: 
      ArrayList[] arrayOfArrayList = this.a.c.n();
      VideoFilePresenter.a(this.a, arrayOfArrayList);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.q());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(this.a.c.x()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.a.a(arrayOfArrayList, (String)localObject);
      break;
    case 2131429213: 
      this.a.r();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */