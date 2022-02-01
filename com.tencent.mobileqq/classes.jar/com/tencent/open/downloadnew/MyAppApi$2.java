package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.LogUtility;

class MyAppApi$2
  extends BroadcastReceiver
{
  MyAppApi$2(MyAppApi paramMyAppApi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.2
 * JD-Core Version:    0.7.0.1
 */