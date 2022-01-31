package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.content.Intent;
import begs;
import bepk;
import besj;
import besl;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3.QQBaselibLoader;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver;
import common.config.service.QzoneConfig;

public class AppBrandTaskPreloadReceiver7
  extends AppBrandMainReceiver
{
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String LOG_TAG = "AppBrandReceiver";
  private static int killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    besl.b("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    begs.a(paramContext.getApplicationContext());
    bepk.a().a(AppBrandUI3.QQBaselibLoader.g());
    localObject = bepk.a().a();
    if (localObject != null) {
      ((besj)localObject).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7
 * JD-Core Version:    0.7.0.1
 */