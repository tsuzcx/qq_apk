package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsInstaller$4
  extends Thread
{
  TbsInstaller$4(TbsInstaller paramTbsInstaller, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      File localFile1;
      if (this.val$hostCtx == null) {
        localFile1 = new File(TbsShareManager.getHostCorePathAppDefined());
      }
      for (;;)
      {
        File localFile2 = this.this$0.getTbsCoreShareDir(this.val$callerCtx);
        int i = Build.VERSION.SDK_INT;
        if ((i != 19) && (i < 21)) {
          FileUtil.copyFiles(localFile1, localFile2, new TbsInstaller.4.1(this));
        }
        FileUtil.copyFiles(localFile1, localFile2, new TbsInstaller.4.2(this));
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        return;
        if (TbsShareManager.isThirdPartyApp(this.val$callerCtx))
        {
          if ((TbsShareManager.getAvailableTbsCorePath(this.val$callerCtx) != null) && (TbsShareManager.getAvailableTbsCorePath(this.val$callerCtx).contains("decouple"))) {
            localFile1 = this.this$0.getCoreShareDecoupleDir(this.val$hostCtx);
          } else {
            localFile1 = this.this$0.getTbsCoreShareDir(this.val$hostCtx);
          }
        }
        else {
          localFile1 = this.this$0.getTbsCoreShareDir(this.val$hostCtx);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInstaller.4
 * JD-Core Version:    0.7.0.1
 */