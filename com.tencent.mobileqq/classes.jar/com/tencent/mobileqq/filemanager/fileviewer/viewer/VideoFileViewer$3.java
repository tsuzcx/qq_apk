package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFileViewer$3
  implements View.OnClickListener
{
  VideoFileViewer$3(VideoFileViewer paramVideoFileViewer) {}
  
  public void onClick(View paramView)
  {
    this.a.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.3
 * JD-Core Version:    0.7.0.1
 */