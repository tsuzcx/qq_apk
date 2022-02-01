package com.tencent.mobileqq.startup.step;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppActivity;

class CheckPermission$1
  implements DialogInterface.OnClickListener
{
  CheckPermission$1(CheckPermission paramCheckPermission) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BeaconReport.getInstance().setCollectMac(true);
    BeaconReport.getInstance().setCollectImei(true);
    BeaconReport.getInstance().setCollectAndroidID(true);
    VideoReport.setCollectProcessName(true);
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("PrivacyPolicyHelper User Allow is show & onClick which is");
    paramDialogInterface.append(paramInt);
    QLog.d("CheckPermission", 1, paramDialogInterface.toString());
    if (paramInt == 1)
    {
      paramDialogInterface = this.a;
      if (paramDialogInterface.checkPermission(CheckPermission.access$000(paramDialogInterface)))
      {
        CheckPermission.access$002(this.a, null);
        this.a.mDirector.c();
      }
    }
    else
    {
      CheckPermission.access$000(this.a).superFinish();
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.CheckPermission.1
 * JD-Core Version:    0.7.0.1
 */