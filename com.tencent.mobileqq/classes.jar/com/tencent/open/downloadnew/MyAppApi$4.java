package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.LogUtility;

class MyAppApi$4
  extends BroadcastReceiver
{
  MyAppApi$4(MyAppApi paramMyAppApi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("onReceive ---INTENT = ");
    paramContext.append(paramIntent);
    LogUtility.c("MyAppApi", paramContext.toString());
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.4
 * JD-Core Version:    0.7.0.1
 */