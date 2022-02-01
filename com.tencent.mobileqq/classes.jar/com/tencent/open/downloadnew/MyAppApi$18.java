package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;

class MyAppApi$18
  implements DialogInterface.OnClickListener
{
  MyAppApi$18(MyAppApi paramMyAppApi, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!MyAppApi.m())
    {
      paramDialogInterface = this.g;
      paramDialogInterface.j = new MyAppApi.InstallParams(paramDialogInterface);
      this.g.j.b = true;
      this.g.j.c = true;
      this.g.j.d = null;
      this.g.j.a = this.a;
      this.g.j.e = 2;
      if (this.b)
      {
        this.g.a(this.c, this.d, 0, "", "");
      }
      else
      {
        paramDialogInterface = this.g;
        new MyAppApi.CopyAndInstallTask(paramDialogInterface, this.c, paramDialogInterface.j).execute(new Void[0]);
      }
    }
    else
    {
      this.g.a(this.c, this.e);
    }
    this.g.l = true;
    StaticAnalyz.a("201", StaticAnalyz.a(this.d, "NEWYYB"), this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */