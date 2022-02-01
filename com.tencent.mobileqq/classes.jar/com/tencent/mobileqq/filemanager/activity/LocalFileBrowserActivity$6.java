package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocalFileBrowserActivity$6
  implements View.OnClickListener
{
  LocalFileBrowserActivity$6(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
    FileInfo localFileInfo = ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366781) {
      i = 1;
    } else {
      i = 0;
    }
    if (localFileInfo.d())
    {
      LocalFileBrowserActivity.a(this.a, localFileInfo.c(), true);
    }
    else if ((this.a.f()) && (i == 0))
    {
      if ((this.a.i()) && (!FMDataCache.a(FMDataCache.b)))
      {
        localObject = DialogUtil.a(this.a, 2131698222);
        ((QQCustomDialog)localObject).setPositiveButton(2131694583, new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).show();
      }
      else
      {
        if (FMDataCache.a(localFileInfo))
        {
          FMDataCache.b(localFileInfo);
        }
        else
        {
          if (this.a.h) {
            FMDataCache.b();
          }
          if (localFileInfo.a() == -1) {
            localFileInfo.b(QQFileManagerUtil.b(localFileInfo.c()));
          }
          FMDataCache.a(localFileInfo);
          if (this.a.h) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        this.a.l();
        if (this.a.f())
        {
          ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
        }
        else
        {
          ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
    }
    else if (!this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i(LocalFileBrowserActivity.e, 2, "click too fast , wait a minute.");
      }
    }
    else
    {
      if (this.a.f()) {
        ReportController.b(this.a.a, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      this.a.e();
      if (localFileInfo.a() == -1) {
        localFileInfo.b(QQFileManagerUtil.b(localFileInfo.c()));
      }
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFileBrowserByFileInfo(this.a.getActivity(), localFileInfo, localFileInfo.a(), localFileInfo.c(), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.6
 * JD-Core Version:    0.7.0.1
 */