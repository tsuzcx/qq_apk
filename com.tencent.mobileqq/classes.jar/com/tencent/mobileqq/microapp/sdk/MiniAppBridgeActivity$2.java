package com.tencent.mobileqq.microapp.sdk;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import java.lang.ref.WeakReference;

class MiniAppBridgeActivity$2
  implements ApkgConfigManager.a
{
  MiniAppBridgeActivity$2(MiniAppBridgeActivity paramMiniAppBridgeActivity, WeakReference paramWeakReference, long paramLong) {}
  
  public void onResult(int paramInt, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppBridgeActivity", 2, "MiniAppBridgeActivity getNewestConfig");
    }
    paramString2 = (FragmentActivity)this.val$activityRef.get();
    if ((paramString2 != null) && (!paramString2.isFinishing()))
    {
      if ((MiniAppBridgeActivity.access$100(this.this$0).scene == 1214) && (!ApkgConfigManager.isCanNavigate(paramMiniAppConfig, MiniAppBridgeActivity.access$200(this.this$0))))
      {
        MiniAppBridgeActivity.access$300(this.this$0, "not support navigate");
        return;
      }
      if (paramInt == 0)
      {
        try
        {
          MiniAppController.startApp(paramString2, this.this$0.wrapConfig(paramMiniAppConfig), new MiniAppBridgeActivity.2.1(this, new Handler(Looper.getMainLooper())));
          if (this.val$processRuntime > 5000L) {
            this.this$0.getActivity().finish();
          }
          return;
        }
        catch (Throwable paramMiniAppConfig)
        {
          paramMiniAppConfig.printStackTrace();
        }
      }
      else if (!TextUtils.isEmpty(paramString1))
      {
        paramMiniAppConfig = this.this$0;
        MiniAppBridgeActivity.access$002(paramMiniAppConfig, new FakeUrl(paramMiniAppConfig.getActivity()));
        MiniAppBridgeActivity.access$000(this.this$0).onFakePros(null, paramString1, new MiniAppBridgeActivity.2.2(this));
        MiniAppBridgeActivity.access$400(this.this$0).dismiss();
        return;
      }
      paramMiniAppConfig = this.this$0;
      paramString2 = new StringBuilder();
      paramString2.append("return code error;");
      paramString2.append(paramInt);
      paramString2.append("|");
      paramString2.append(paramString1);
      MiniAppBridgeActivity.access$300(paramMiniAppConfig, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.2
 * JD-Core Version:    0.7.0.1
 */