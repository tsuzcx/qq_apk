package com.tencent.mobileqq.qqlive.verified;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class FaceVerifyBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!"qqlive.faceverify".equals(paramIntent.getAction())) {
      return;
    }
    int i = paramIntent.getIntExtra("msg_type", -1);
    paramContext = paramIntent.getStringExtra("app_id");
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    int j = paramIntent.getIntExtra("callback_key", -1);
    if (j == -1) {
      return;
    }
    paramContext = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(paramContext);
    if (paramContext != null)
    {
      if (paramContext.isDestroyed()) {
        return;
      }
      paramContext = paramContext.getQQLiveVerifyModule();
      if (paramContext == null) {
        return;
      }
      if (i != 1000)
      {
        if (i != 1001) {
          return;
        }
        boolean bool = paramIntent.getBooleanExtra("result_flag", false);
        String str = paramIntent.getStringExtra("result_msg");
        paramContext.notifyVerifyResult(j, bool, paramIntent.getIntExtra("result_code", -2), str);
        return;
      }
      ThreadManager.getUIHandler().postDelayed(new FaceVerifyBroadcastReceiver.1(this, paramContext, j), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */