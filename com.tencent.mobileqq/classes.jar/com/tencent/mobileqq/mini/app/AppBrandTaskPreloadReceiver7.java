package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver;

public class AppBrandTaskPreloadReceiver7
  extends AppBrandMainReceiver
{
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String LOG_TAG = "AppBrandReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = new StringBuilder();
    paramIntent.append("AppBrandTaskPreloadReceiver onReceive action: ");
    paramIntent.append(paramContext);
    QLog.i("minisdk-start", 1, paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7
 * JD-Core Version:    0.7.0.1
 */