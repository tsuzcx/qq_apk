package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

final class QbSdk$1
  extends Handler
{
  QbSdk$1(Looper paramLooper, QbSdk.PreInitCallback paramPreInitCallback, Context paramContext)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramMessage = this.a;
        if (paramMessage == null) {
          return;
        }
        paramMessage.onCoreInitFinished();
        return;
      }
      paramMessage = this.a;
      if (paramMessage != null) {
        bool = false;
      }
    }
    for (;;)
    {
      paramMessage.onViewInitFinished(bool);
      do
      {
        TbsLog.writeLogToDisk();
        return;
        QbSdk.a(TbsExtensionFunctionManager.getInstance().canUseFunction(this.b, "disable_unpreinit.txt"));
        if (QbSdk.j)
        {
          paramMessage = x.a().c();
          if (paramMessage != null) {
            paramMessage.a(this.b);
          }
        }
        paramMessage = this.a;
      } while (paramMessage == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.1
 * JD-Core Version:    0.7.0.1
 */