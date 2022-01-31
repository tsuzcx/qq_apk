package com.tencent.mobileqq.mini.appbrand.ui;

import ajjy;
import android.os.Handler;
import android.os.Message;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AppLoadingUI$13
  implements Runnable
{
  AppLoadingUI$13(AppLoadingUI paramAppLoadingUI, Message paramMessage) {}
  
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
            bbmy.a(localBaseApplication, 1, str, 1).a();
            this.this$0.uiHandler.postDelayed(new AppLoadingUI.13.1(this), 1000L);
            return;
          }
          str = ajjy.a(2131634828);
          continue;
        }
        Object localObject = null;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-start_AppLoadingUI", 1, "MSG_WHAT_APKG_FAIL error, ", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.13
 * JD-Core Version:    0.7.0.1
 */