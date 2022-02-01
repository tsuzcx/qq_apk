package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFileViewer$2
  implements View.OnClickListener
{
  VideoFileViewer$2(VideoFileViewer paramVideoFileViewer, String paramString) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.2
 * JD-Core Version:    0.7.0.1
 */