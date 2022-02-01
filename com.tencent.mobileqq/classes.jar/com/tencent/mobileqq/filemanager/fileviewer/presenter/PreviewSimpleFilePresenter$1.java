package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PreviewSimpleFilePresenter$1
  implements View.OnClickListener
{
  PreviewSimpleFilePresenter$1(PreviewSimpleFilePresenter paramPreviewSimpleFilePresenter) {}
  
  public void onClick(View paramView)
  {
    int i = QFileUtils.b(this.a.a.e());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, localStringBuilder.toString(), "", "", "");
    this.a.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewSimpleFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */