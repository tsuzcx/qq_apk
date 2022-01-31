package com.tencent.mobileqq.mini.appbrand.ui;

import alud;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AppLoadingUI$14
  implements Runnable
{
  AppLoadingUI$14(AppLoadingUI paramAppLoadingUI, Message paramMessage) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.val$msg.obj != null)
        {
          String str = (String)this.val$msg.obj;
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          if (str != null)
          {
            QQToast.a(localBaseApplication, 1, str, 1).a();
            this.this$0.uiHandler.postDelayed(new AppLoadingUI.14.1(this), 1000L);
            return;
          }
          str = alud.a(2131701006);
          continue;
        }
        Object localObject = null;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-start_AppLoadingUI", 1, "MSG_WHAT_BASELIB_LOAD_FAIL", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.14
 * JD-Core Version:    0.7.0.1
 */