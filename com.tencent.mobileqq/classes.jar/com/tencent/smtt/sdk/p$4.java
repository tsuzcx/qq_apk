package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class p$4
  extends Thread
{
  p$4(p paramp, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      File localFile1;
      if (this.a == null) {
        localFile1 = new File(TbsShareManager.getHostCorePathAppDefined());
      }
      for (;;)
      {
        File localFile2 = this.c.q(this.b);
        int i = Build.VERSION.SDK_INT;
        if ((i != 19) && (i < 21)) {
          FileUtil.a(localFile1, localFile2, new p.4.1(this));
        }
        FileUtil.a(localFile1, localFile2, new p.4.2(this));
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        return;
        if (TbsShareManager.isThirdPartyApp(this.b))
        {
          if ((TbsShareManager.c(this.b) != null) && (TbsShareManager.c(this.b).contains("decouple"))) {
            localFile1 = this.c.p(this.a);
          } else {
            localFile1 = this.c.q(this.a);
          }
        }
        else {
          localFile1 = this.c.q(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.p.4
 * JD-Core Version:    0.7.0.1
 */