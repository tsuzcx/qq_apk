package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseLocalFileTabView$2
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$2(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    else
    {
      FileInfo localFileInfo = (FileInfo)paramView.getTag();
      if (localFileInfo != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(null);
        }
        if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteFile(localFileInfo.c()))
        {
          this.a.a(localFileInfo);
        }
        else
        {
          String str = QfileBaseLocalFileTabView.a(this.a).getString(2131692276);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(QQFileManagerUtil.b(localFileInfo.d()));
          localStringBuilder.append(str);
          FMToastUtil.a(localStringBuilder.toString());
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.2
 * JD-Core Version:    0.7.0.1
 */