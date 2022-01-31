package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.content.Intent;
import bdct;
import bdle;
import bdnu;
import bdnw;
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
    bdnw.b("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    bdct.a(paramContext.getApplicationContext(), null);
    bdle.a().a(AppBrandUI3.QQBaselibLoader.g());
    localObject = bdle.a().a();
    if (localObject != null) {
      ((bdnu)localObject).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7
 * JD-Core Version:    0.7.0.1
 */