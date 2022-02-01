package com.tencent.mobileqq.startup.step;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;

class CheckPermission$1
  implements DialogInterface.OnClickListener
{
  CheckPermission$1(CheckPermission paramCheckPermission) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC = true;
    com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI = true;
    if (paramInt == 1)
    {
      if (this.a.checkPermission(CheckPermission.access$000(this.a)))
      {
        CheckPermission.access$002(this.a, null);
        this.a.mDirector.a();
      }
      return;
    }
    CheckPermission.access$000(this.a).superFinish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.CheckPermission.1
 * JD-Core Version:    0.7.0.1
 */