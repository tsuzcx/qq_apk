package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$12
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$12(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileBaseExpandableListAdapter.CloudItemHolder localCloudItemHolder = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
    Object localObject2 = (WeiYunFileInfo)localCloudItemHolder.a;
    Object localObject1 = QfileBaseCloudFileTabView.e(this.a).getFileManagerDataCenter().c(((WeiYunFileInfo)localObject2).jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      if (localCloudItemHolder.c == 1)
      {
        this.a.a.a().aa();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131692602);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        FileModel.a((FileManagerEntity)localObject1).a(false, this.a.a, new QfileBaseCloudFileTabView.12.1(this, (FileManagerEntity)localObject1));
      }
    }
    for (;;)
    {
      this.a.i();
      break;
      if (localCloudItemHolder.c == 3)
      {
        this.a.a.a().ac();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131692602);
          break;
        }
        FileModel.a((FileManagerEntity)localObject1).a(false, this.a.a, new QfileBaseCloudFileTabView.12.2(this, (FileManagerEntity)localObject1));
        continue;
      }
      if (localCloudItemHolder.c == 0)
      {
        this.a.a.a().Z();
        localObject2 = new FileManagerReporter.FileAssistantReportData();
        ((FileManagerReporter.FileAssistantReportData)localObject2).b = "file_viewer_in";
        ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Int = 73;
        ((FileManagerReporter.FileAssistantReportData)localObject2).c = FileUtil.a(((FileManagerEntity)localObject1).fileName);
        ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
        FileManagerReporter.a(QfileBaseCloudFileTabView.h(this.a).getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject2).b(10001);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).Uuid);
        localObject1 = new Intent(QfileBaseCloudFileTabView.a(this.a), FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
        QfileBaseCloudFileTabView.b(this.a).startActivityForResult((Intent)localObject1, 102);
      }
      else if (localCloudItemHolder.c == 2)
      {
        this.a.a.a().ab();
        QfileBaseCloudFileTabView.i(this.a).getFileManagerEngine().a(((FileManagerEntity)localObject1).nSessionId);
        continue;
        this.a.a.a().aa();
        localObject1 = new QfileBaseCloudFileTabView.12.3(this, (WeiYunFileInfo)localObject2);
        if ((((WeiYunFileInfo)localObject2).jdField_a_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) && (FileManagerUtil.a())) {
          FileManagerUtil.a(false, this.a.a, (FMDialogUtil.FMDialogInterface)localObject1);
        } else {
          ((FMDialogUtil.FMDialogInterface)localObject1).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.12
 * JD-Core Version:    0.7.0.1
 */