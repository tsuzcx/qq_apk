package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import behj;
import beqb;
import besy;
import beta;
import betc;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;

public class AppBrandMainReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    betc.b("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    behj.a(paramContext.getApplicationContext());
    localObject = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
    if (localObject != null) {
      beqb.a().a().setLoginInfo((LoginInfo)localObject);
    }
    localObject = beqb.a().a();
    if (localObject != null) {
      ((beta)localObject).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver
 * JD-Core Version:    0.7.0.1
 */