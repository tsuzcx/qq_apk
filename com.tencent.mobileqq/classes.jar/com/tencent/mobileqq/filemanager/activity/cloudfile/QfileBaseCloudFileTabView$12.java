package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
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
    Object localObject2 = (WeiYunFileInfo)localCloudItemHolder.k;
    Object localObject1 = ((IQQFileDataCenter)QfileBaseCloudFileTabView.i(this.a).getRuntimeService(IQQFileDataCenter.class, "")).queryByFileIdForMemory(((WeiYunFileInfo)localObject2).a);
    if (localObject1 != null)
    {
      if (localCloudItemHolder.e == 1)
      {
        this.a.C.A().aa();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131889577);
          break label443;
        }
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked((FileManagerEntity)localObject1, false, this.a.C, new QfileBaseCloudFileTabView.12.1(this, (FileManagerEntity)localObject1));
      }
      else if (localCloudItemHolder.e == 3)
      {
        this.a.C.A().ac();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131889577);
          break label443;
        }
        QfileBaseCloudFileTabView.a(this.a, (FileManagerEntity)localObject1);
      }
      else if (localCloudItemHolder.e == 0)
      {
        this.a.C.A().Z();
        localObject2 = new FileManagerReporter.FileAssistantReportData();
        ((FileManagerReporter.FileAssistantReportData)localObject2).b = "file_viewer_in";
        ((FileManagerReporter.FileAssistantReportData)localObject2).c = 73;
        ((FileManagerReporter.FileAssistantReportData)localObject2).d = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(((FileManagerEntity)localObject1).fileName);
        ((FileManagerReporter.FileAssistantReportData)localObject2).e = ((FileManagerEntity)localObject1).fileSize;
        FileManagerReporter.a(QfileBaseCloudFileTabView.k(this.a).getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject2).b(10001);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).Uuid);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openRencentFileBrowser(QfileBaseCloudFileTabView.l(this.a), (ForwardFileInfo)localObject2);
      }
      else if (localCloudItemHolder.e == 2)
      {
        this.a.C.A().ab();
        ((IQQFileEngine)QfileBaseCloudFileTabView.m(this.a).getRuntimeService(IQQFileEngine.class, "")).pause(((FileManagerEntity)localObject1).nSessionId);
      }
    }
    else
    {
      this.a.C.A().aa();
      localObject1 = new QfileBaseCloudFileTabView.12.2(this, (WeiYunFileInfo)localObject2);
      QfileBaseCloudFileTabView.a(this.a, (WeiYunFileInfo)localObject2, (FMDialogUtil.FMDialogInterface)localObject1);
    }
    this.a.i();
    label443:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.12
 * JD-Core Version:    0.7.0.1
 */