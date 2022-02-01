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
      paramContext = new QueryAccount.RegisterFaceResult(this.a, paramContext, paramIntent);
      RegisterManager.a().a(paramContext);
      if (QueryAccount.a(this.a))
      {
        this.a.a.createWaitingDialog(2131716612);
        this.a.a(null, paramContext.a());
      }
      if (this.a.a.phoneNum != null) {
        ReportController.b(this.a.a.getAppRuntime(), "dc00898", "", "", "0X800B7C8", "0X800B7C8", 0, 0, "", "", this.a.a.phoneNum, "");
      }
      return;
    }
    QLog.e("QueryAccount", 1, "registerFaceRecognizeReceiver: face result is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.4
 * JD-Core Version:    0.7.0.1
 */