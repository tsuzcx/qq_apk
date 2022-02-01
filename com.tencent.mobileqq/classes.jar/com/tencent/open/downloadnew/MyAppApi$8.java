package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;

class MyAppApi$8
  implements DialogInterface.OnClickListener
{
  MyAppApi$8(MyAppApi paramMyAppApi, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!MyAppApi.m())
    {
      paramDialogInterface = this.l;
      paramDialogInterface.j = new MyAppApi.InstallParams(paramDialogInterface);
      this.l.j.b = this.a;
      this.l.j.c = true;
      this.l.j.d = this.b;
      this.l.j.a = this.c;
      this.l.j.e = this.d;
      if (this.e)
      {
        paramDialogInterface = this.c.getString(DownloadConstants.q);
        this.l.a(this.f, this.g, 0, this.h, paramDialogInterface);
        if ((this.l.k != null) && (this.l.k.isShowing())) {
          this.l.k.a(0, 1);
        }
      }
      else
      {
        paramDialogInterface = this.l;
        new MyAppApi.CopyAndInstallTask(paramDialogInterface, this.f, paramDialogInterface.j).execute(new Void[0]);
      }
    }
    else
    {
      if ((!ControlPolicyUtil.l()) && (!this.i))
      {
        paramDialogInterface = this.b;
        if (paramDialogInterface != null) {
          paramDialogInterface.onClick(null, 0);
        }
      }
      else if (this.d == 0)
      {
        this.l.a(this.f, this.c, this.a, this.j);
      }
      else
      {
        this.l.b(this.f, this.c, this.a, this.j);
      }
      if ((this.l.k != null) && (this.l.k.isShowing())) {
        this.l.k.dismiss();
      }
    }
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append(this.c.getString(DownloadConstants.f));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.c.getString(DownloadConstants.c));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.c.getString(DownloadConstants.d));
    paramDialogInterface = paramDialogInterface.toString();
    this.l.l = true;
    StaticAnalyz.a("201", StaticAnalyz.a(this.g, "NEWYYB"), this.h);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    localStringBuilder.append("|");
    localStringBuilder.append(100);
    localStringBuilder.append("|");
    localStringBuilder.append(paramDialogInterface);
    paramDialogInterface = localStringBuilder.toString();
    AppCircleReportManager.a().a(25, paramDialogInterface);
    ReportController.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
    if (this.k == 1)
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append(this.c.getString("pageId"));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.c.getString("moduleId"));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.c.getString(DownloadConstants.f));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.c.getString(DownloadConstants.c));
      paramDialogInterface.append("_");
      paramDialogInterface.append(this.c.getString(DownloadConstants.d));
      paramDialogInterface = paramDialogInterface.toString();
      AppCenterReporter.b("6006", "1", "0", this.g, paramDialogInterface);
    }
    if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.g)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.g))) {
      GameCenterUtils.a(null, "765", "205010", this.h, "76501", "1", "156");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.8
 * JD-Core Version:    0.7.0.1
 */