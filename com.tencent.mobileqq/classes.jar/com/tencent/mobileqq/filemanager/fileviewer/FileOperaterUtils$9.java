package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.GetTeamWorkImportInfoListener;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

final class FileOperaterUtils$9
  implements View.OnClickListener
{
  FileOperaterUtils$9(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean, TeamWorkConvertUtils.GetTeamWorkImportInfoListener paramGetTeamWorkImportInfoListener) {}
  
  public void onClick(View paramView)
  {
    if ((this.a != null) && (this.b != null))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (this.c) {
        TenDocLogReportHelper.a(null, "0X800A21D");
      } else {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
      }
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.d = this.a.getFilePath();
      localTeamWorkFileImportInfo.c = this.a.fileName;
      localTeamWorkFileImportInfo.u = this.a.nFileType;
      if (this.c) {
        localTeamWorkFileImportInfo.n = 8;
      } else {
        localTeamWorkFileImportInfo.n = 5;
      }
      localTeamWorkFileImportInfo.K = this.a.fileSize;
      Activity localActivity = this.b;
      boolean bool1;
      if ((localActivity instanceof FileBrowserActivity))
      {
        boolean bool2 = ((FileBrowserActivity)localActivity).l();
        if ((((FileBrowserActivity)this.b).g()) && (!bool2)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localTeamWorkFileImportInfo.o = bool1;
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      if ((bool1) && (!FileUtils.fileExistsAndNotEmpty(this.a.getFilePath())))
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131917096), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
      }
      else
      {
        if (!TextUtils.isEmpty(this.a.peerUin))
        {
          localTeamWorkFileImportInfo.a = this.a.peerType;
          localTeamWorkFileImportInfo.b = this.a.peerUin;
          localTeamWorkFileImportInfo.j = String.valueOf(this.a.TroopUin);
          localTeamWorkFileImportInfo.g = this.a.strTroopFilePath;
          localTeamWorkFileImportInfo.h = this.a.busId;
          localTeamWorkFileImportInfo.e = this.a.uniseq;
          if (this.a.status != 16) {
            localTeamWorkFileImportInfo.m = true;
          }
        }
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.b, (AppInterface)localObject, localTeamWorkFileImportInfo.n);
        localObject = this.d;
        if (localObject != null) {
          ((TeamWorkConvertUtils.GetTeamWorkImportInfoListener)localObject).a(localTeamWorkFileImportInfo);
        }
      }
    }
    else
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131917091), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.9
 * JD-Core Version:    0.7.0.1
 */