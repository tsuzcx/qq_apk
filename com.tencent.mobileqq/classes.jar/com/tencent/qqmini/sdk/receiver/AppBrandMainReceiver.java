package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bdct;
import bdle;
import bdnu;
import bdnw;

public class AppBrandMainReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    bdnw.b("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    bdct.a(paramContext.getApplicationContext(), null);
    localObject = bdle.a().a();
    if (localObject != null) {
      ((bdnu)localObject).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver
 * JD-Core Version:    0.7.0.1
 */