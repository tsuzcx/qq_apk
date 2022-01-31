package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

final class QbSdk$2
  extends Handler
{
  QbSdk$2(Looper paramLooper, QbSdk.PreInitCallback paramPreInitCallback, Context paramContext)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.val$callback != null) {
        this.val$callback.onViewInitFinished(false);
      }
      TbsLog.writeLogToDisk();
      return;
      QbSdk.access$002(TbsExtensionFunctionManager.getInstance().canUseFunction(this.val$context, "disable_unpreinit.txt"));
      if (QbSdk.mNeedCreateX5webviewAfterInit)
      {
        paramMessage = X5CoreEngine.getInstance().wizard();
        if (paramMessage != null) {
          paramMessage.createSDKWebview(this.val$context);
        }
      }
      if (this.val$callback != null) {
        this.val$callback.onViewInitFinished(true);
      }
      TbsLog.writeLogToDisk();
      return;
    } while (this.val$callback == null);
    this.val$callback.onCoreInitFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.2
 * JD-Core Version:    0.7.0.1
 */