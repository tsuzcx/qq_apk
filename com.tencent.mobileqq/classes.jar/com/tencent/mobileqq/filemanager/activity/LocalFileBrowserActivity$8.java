package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocalFileBrowserActivity$8
  implements View.OnClickListener
{
  LocalFileBrowserActivity$8(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
    Object localObject1 = ((LocalFileAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366919)
    {
      i = 1;
      if (!((FileInfo)localObject1).c()) {
        break label58;
      }
      LocalFileBrowserActivity.a(this.a, ((FileInfo)localObject1).c(), true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label58:
      if ((this.a.f()) && (i == 0))
      {
        if ((this.a.i()) && (!FMDataCache.a(FMDataCache.b)))
        {
          localObject1 = DialogUtil.a(this.a, 2131698166);
          ((QQCustomDialog)localObject1).setPositiveButton(2131694615, new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject1).show();
        }
        else
        {
          if (FMDataCache.a((FileInfo)localObject1)) {
            FMDataCache.b((FileInfo)localObject1);
          }
          for (;;)
          {
            this.a.l();
            if (!this.a.f()) {
              break label230;
            }
            ((LocalFileAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            ((LocalFileAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileInfo)localObject1));
            break;
            if (this.a.h) {
              FMDataCache.b();
            }
            if (((FileInfo)localObject1).a() == -1) {
              ((FileInfo)localObject1).b(FileManagerUtil.a(((FileInfo)localObject1).c()));
            }
            FMDataCache.a((FileInfo)localObject1);
            if (this.a.h) {
              LocalFileBrowserActivity.a(this.a);
            }
          }
          label230:
          ((LocalFileAdapter.LocalFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      else if (!this.a.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(LocalFileBrowserActivity.f, 2, "click too fast , wait a minute.");
        }
      }
      else
      {
        if (this.a.f()) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        this.a.e();
        Object localObject3 = FileManagerUtil.a((FileInfo)localObject1);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(((FileManagerEntity)localObject3).nSessionId);
        localForwardFileInfo.d(3);
        localForwardFileInfo.b(10000);
        localForwardFileInfo.a(((FileInfo)localObject1).c());
        localForwardFileInfo.d(((FileInfo)localObject1).d());
        localForwardFileInfo.d(((FileInfo)localObject1).a());
        localObject2 = new Intent(this.a.getApplicationContext(), FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        if ((((FileManagerEntity)localObject3).nFileType == 0) || (((FileManagerEntity)localObject3).nFileType == 1))
        {
          FMDataCache.a(this.a.b);
          ((Intent)localObject2).putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localObject3 = new FileManagerReporter.FileAssistantReportData();
        ((FileManagerReporter.FileAssistantReportData)localObject3).b = "file_viewer_in";
        ((FileManagerReporter.FileAssistantReportData)localObject3).jdField_a_of_type_Int = 80;
        ((FileManagerReporter.FileAssistantReportData)localObject3).c = FileUtil.a(((FileInfo)localObject1).d());
        ((FileManagerReporter.FileAssistantReportData)localObject3).jdField_a_of_type_Long = ((FileInfo)localObject1).a();
        FileManagerReporter.a(this.a.app.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject3);
        this.a.startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.8
 * JD-Core Version:    0.7.0.1
 */