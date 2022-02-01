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
      Object localObject1;
      if (this.a == null) {
        localObject1 = new File(TbsShareManager.getHostCorePathAppDefined());
      } else if (TbsShareManager.isThirdPartyApp(this.b))
      {
        if ((TbsShareManager.c(this.b) != null) && (TbsShareManager.c(this.b).contains("decouple"))) {
          localObject1 = this.c.q(this.a);
        } else {
          localObject1 = this.c;
        }
      }
      else {
        for (localObject2 = this.a;; localObject2 = this.a)
        {
          localObject1 = ((p)localObject1).r((Context)localObject2);
          break;
          localObject1 = this.c;
        }
      }
      Object localObject2 = this.c.r(this.b);
      int i = Build.VERSION.SDK_INT;
      if ((i != 19) && (i < 21)) {
        FileUtil.a((File)localObject1, (File)localObject2, new p.4.1(this));
      }
      FileUtil.a((File)localObject1, (File)localObject2, new p.4.2(this));
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.p.4
 * JD-Core Version:    0.7.0.1
 */