package com.tencent.mobileqq.microapp.sdk;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import java.lang.ref.WeakReference;

class MiniAppBridgeActivity$4
  implements Runnable
{
  MiniAppBridgeActivity$4(MiniAppBridgeActivity paramMiniAppBridgeActivity, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    try
    {
      WeakReference localWeakReference = new WeakReference(this.this$0.getActivity());
      MiniAppController.startApp(this.this$0.getActivity(), this.this$0.wrapConfig(this.val$appConfig), new MiniAppBridgeActivity.4.1(this, new Handler(Looper.getMainLooper()), localWeakReference));
      return;
    }
    catch (MiniAppException localMiniAppException)
    {
      localMiniAppException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.4
 * JD-Core Version:    0.7.0.1
 */