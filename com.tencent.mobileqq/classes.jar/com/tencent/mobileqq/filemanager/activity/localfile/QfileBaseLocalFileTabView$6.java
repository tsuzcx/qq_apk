package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseLocalFileTabView$6
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$6(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFileBaseExpandableListAdapter.LocalItemHolder localLocalItemHolder = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)localLocalItemHolder.jdField_a_of_type_JavaLangObject;
    switch (localLocalItemHolder.c)
    {
    }
    for (;;)
    {
      this.a.i();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a().Z();
      this.a.a(localFileInfo, localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.6
 * JD-Core Version:    0.7.0.1
 */