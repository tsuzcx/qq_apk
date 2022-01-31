package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import begs;
import bepk;
import besh;
import besj;
import besl;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;

public class AppBrandMainReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    besl.b("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    begs.a(paramContext.getApplicationContext());
    localObject = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
    if (localObject != null) {
      bepk.a().a().setLoginInfo((LoginInfo)localObject);
    }
    localObject = bepk.a().a();
    if (localObject != null) {
      ((besj)localObject).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver
 * JD-Core Version:    0.7.0.1
 */