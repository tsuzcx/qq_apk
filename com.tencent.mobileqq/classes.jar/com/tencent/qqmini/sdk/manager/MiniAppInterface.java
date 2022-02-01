package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppInterface;

@MiniKeep
public class MiniAppInterface
  implements IMiniAppInterface
{
  private static final String TAG = "minisdk-start_MiniAppInterface";
  
  public void onCreate(Context paramContext, Configuration paramConfiguration)
  {
    QMLog.w("minisdk-start_MiniAppInterface", "onCreate");
    ThreadManager.getSubThreadHandler().post(new MiniAppInterface.1(this, paramContext, paramConfiguration));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniAppInterface
 * JD-Core Version:    0.7.0.1
 */