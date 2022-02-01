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
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (VideoFilePresenter.a(this.a) != null)
      {
        boolean bool2 = VideoFilePresenter.a(this.a).isPlaying();
        if (bool2)
        {
          VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          FileManagerReporter.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(VideoFilePresenter.a(this.a));
          VideoFilePresenter.a(this.a);
          label130:
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((VideoFileViewer)localObject).d(bool1);
          break;
          VideoFilePresenter.b(this.a);
          VideoFilePresenter.c(this.a);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
        VideoFilePresenter.a(this.a, (ArrayList[])localObject);
        String str = this.a.a() + "(" + FileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) + ")";
        this.a.a((ArrayList[])localObject, str);
        continue;
        this.a.n();
        continue;
        int i = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
        int j = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
        if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */