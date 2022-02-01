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
    case 2131376496: 
      int i = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
      int j = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
      if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
      }
      break;
    case 2131372821: 
      if (VideoFilePresenter.a(this.a) != null)
      {
        boolean bool = VideoFilePresenter.a(this.a).isPlaying();
        if (bool)
        {
          VideoFilePresenter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          FileManagerReporter.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(VideoFilePresenter.a(this.a));
          VideoFilePresenter.a(this.a);
        }
        else
        {
          VideoFilePresenter.b(this.a);
          VideoFilePresenter.c(this.a);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(bool ^ true);
      }
      break;
    case 2131370792: 
      ArrayList[] arrayOfArrayList = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
      VideoFilePresenter.a(this.a, arrayOfArrayList);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.a());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.a.a(arrayOfArrayList, (String)localObject);
      break;
    case 2131363336: 
      this.a.n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */