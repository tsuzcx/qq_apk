package com.tencent.mobileqq.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QueryAccount$4
  extends BroadcastReceiver
{
  QueryAccount$4(QueryAccount paramQueryAccount) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!paramContext.getPackageName().equals(paramIntent.getPackage())) {
      return;
    }
    QueryAccount.a(this.a, true);
    paramContext = paramIntent.getStringExtra("reg_sig");
    paramIntent = paramIntent.getStringExtra("face_result");
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramIntent)))
    {
      paramContext = new QueryAccount.RegisterFaceResult(paramContext, paramIntent);
      RegisterManager.b().a(paramContext);
      if (QueryAccount.b(this.a))
      {
        this.a.h.createWaitingDialog(2131914075);
        this.a.a(null, paramContext.a());
      }
      if (this.a.h.phoneNum != null) {
        ReportController.b(this.a.h.getAppRuntime(), "dc00898", "", "", "0X800B7C8", "0X800B7C8", 0, 0, "", "", this.a.h.phoneNum, "");
      }
      return;
    }
    QLog.e("QueryAccount", 1, "registerFaceRecognizeReceiver: face result is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.4
 * JD-Core Version:    0.7.0.1
 */