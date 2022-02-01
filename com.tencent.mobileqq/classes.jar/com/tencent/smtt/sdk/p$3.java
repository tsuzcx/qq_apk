package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class p$3
  extends Handler
{
  p$3(p paramp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QbSdk.setTBSInstallingStatus(true);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
          Object[] arrayOfObject = (Object[])paramMessage.obj;
          this.a.a((Context)arrayOfObject[0], (File)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          QbSdk.setTBSInstallingStatus(false);
          super.handleMessage(paramMessage);
          return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
        paramMessage = (Object[])paramMessage.obj;
        this.a.b((Context)paramMessage[0], (Bundle)paramMessage[1]);
        return;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
      paramMessage = (Object[])paramMessage.obj;
      p.a(this.a, (Context)paramMessage[0], (Context)paramMessage[1], ((Integer)paramMessage[2]).intValue());
      return;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
    paramMessage = (Object[])paramMessage.obj;
    p.a(this.a, (Context)paramMessage[0], (String)paramMessage[1], ((Integer)paramMessage[2]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.p.3
 * JD-Core Version:    0.7.0.1
 */