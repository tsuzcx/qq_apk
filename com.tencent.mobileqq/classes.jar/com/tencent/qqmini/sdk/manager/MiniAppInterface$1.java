package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInterface$1
  implements Runnable
{
  MiniAppInterface$1(MiniAppInterface paramMiniAppInterface, Context paramContext, Configuration paramConfiguration) {}
  
  public void run()
  {
    try
    {
      PreloadResource.g().preload(this.val$context, this.val$configuration);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_MiniAppInterface", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniAppInterface.1
 * JD-Core Version:    0.7.0.1
 */