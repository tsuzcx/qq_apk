package com.tencent.mobileqq.microapp.sdk;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MiniAppBridgeActivity$3
  implements Runnable
{
  MiniAppBridgeActivity$3(MiniAppBridgeActivity paramMiniAppBridgeActivity, MiniAppConfig paramMiniAppConfig, WeakReference paramWeakReference) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppBridgeActivity", 2, "miniapp process not exist,delay to start");
      }
      if (this.this$0.getActivity() != null)
      {
        if (this.this$0.getActivity().isFinishing()) {
          return;
        }
        MiniAppController.startApp(this.this$0.getActivity(), this.this$0.wrapConfig(this.val$miniConfig), new MiniAppBridgeActivity.3.1(this, new Handler(Looper.getMainLooper())));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      MiniAppBridgeActivity.access$300(this.this$0, "start miniapp error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.3
 * JD-Core Version:    0.7.0.1
 */