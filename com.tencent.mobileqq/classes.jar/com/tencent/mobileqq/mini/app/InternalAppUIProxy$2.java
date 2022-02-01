package com.tencent.mobileqq.mini.app;

import amtj;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class InternalAppUIProxy$2
  implements Runnable
{
  InternalAppUIProxy$2(InternalAppUIProxy paramInternalAppUIProxy, Message paramMessage) {}
  
  public void run()
  {
    try
    {
      String str = (String)this.val$msg.obj;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (str != null) {}
      for (;;)
      {
        QQToast.a(localBaseApplication, 1, str, 1).a();
        InternalAppUIProxy.access$100(this.this$0).postDelayed(new InternalAppUIProxy.2.1(this), 1000L);
        return;
        str = amtj.a(2131704936);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start_AppUIProxy_Internal", 1, "MSG_WHAT_APKG_FAIL exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.InternalAppUIProxy.2
 * JD-Core Version:    0.7.0.1
 */