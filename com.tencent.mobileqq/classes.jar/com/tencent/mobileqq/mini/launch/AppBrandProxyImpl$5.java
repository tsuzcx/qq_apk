package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$5
  implements Runnable
{
  AppBrandProxyImpl$5(AppBrandProxyImpl paramAppBrandProxyImpl, String paramString, CmdCallback paramCmdCallback, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.getService() == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCmd IAppBrandService Connection is Null 1. cmd=");
      ((StringBuilder)localObject).append(this.val$cmd);
      QLog.e("miniapp-process_AppBrandProxy", 1, ((StringBuilder)localObject).toString());
      localObject = this.val$callback;
      if (localObject == null) {
        return;
      }
      try
      {
        ((CmdCallback)localObject).onCmdResult(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      AppBrandProxyImpl.access$000(this.this$0).sendCmd(this.val$cmd, this.val$bundle, this.val$callback);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */