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
    FileInfo localFileInfo = ((LocalFileAdapter.LocalFileItemHolder)localObject).j;
    int i;
    if (paramView.getId() == 2131433103) {
      i = 1;
    } else {
      i = 0;
    }
    if (localFileInfo.k())
    {
      LocalFileBrowserActivity.a(this.a, localFileInfo.d(), true);
    }
    else if ((this.a.D()) && (i == 0))
    {
      if ((this.a.I()) && (!FMDataCache.c(FMDataCache.b)))
      {
        localObject = DialogUtil.a(this.a, 2131896123);
        ((QQCustomDialog)localObject).setPositiveButton(2131892267, new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).show();
      }
      else
      {
        if (FMDataCache.a(localFileInfo))
        {
          FMDataCache.c(localFileInfo);
        }
        else
        {
          if (this.a.x) {
            FMDataCache.d();
          }
          if (localFileInfo.l() == -1) {
            localFileInfo.b(QQFileManagerUtil.k(localFileInfo.d()));
          }
          FMDataCache.b(localFileInfo);
          if (this.a.x) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        this.a.B();
        if (this.a.D())
        {
          ((LocalFileAdapter.LocalFileItemHolder)localObject).b.setVisibility(0);
          ((LocalFileAdapter.LocalFileItemHolder)localObject).b.setChecked(FMDataCache.a(localFileInfo));
        }
        else
        {
          ((LocalFileAdapter.LocalFileItemHolder)localObject).b.setVisibility(8);
        }
      }
    }
    else if (!this.a.d())
    {
      if (QLog.isColorLevel()) {
        QLog.i(LocalFileBrowserActivity.F, 2, "click too fast , wait a minute.");
      }
    }
    else
    {
      if (this.a.D()) {
        ReportController.b(this.a.p, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      this.a.g();
      if (localFileInfo.l() == -1) {
        localFileInfo.b(QQFileManagerUtil.k(localFileInfo.d()));
      }
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFileBrowserByFileInfo(this.a.getActivity(), localFileInfo, localFileInfo.l(), localFileInfo.d(), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.6
 * JD-Core Version:    0.7.0.1
 */