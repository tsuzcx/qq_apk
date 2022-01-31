package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PayJsPlugin$4$1
  implements MiniAppController.ActivityResultListener
{
  PayJsPlugin$4$1(PayJsPlugin.4 param4) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3002)
    {
      QLog.d("PayJsPlugin", 1, new Object[] { "handleRechargeGame ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL resultCode:", Integer.valueOf(paramInt2) });
      String str2;
      String str1;
      if ((paramInt2 == -1) && (paramIntent != null)) {
        if (paramIntent.getExtras() != null)
        {
          str2 = paramIntent.getStringExtra("mini_response_str");
          str1 = paramIntent.getStringExtra("mini_event_name");
          paramInt1 = paramIntent.getIntExtra("mini_event_seq", -1);
          QLog.d("PayJsPlugin", 1, new Object[] { "handleRechargeGame ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL resStr:", str2, " resEventName:", str1, " resSeq:", Integer.valueOf(paramInt1) });
          if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)) || (paramInt1 == -1)) {}
        }
      }
      for (;;)
      {
        try
        {
          paramIntent = new JSONObject(str2);
          PayJsPlugin.access$400(this.this$1.this$0, paramInt1, str1, paramIntent);
          MiniAppController.getInstance().removeActivityResultListener(this);
          return true;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PayJsPlugin", 1, "doOnActivityResult json error", paramIntent);
          PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$seq, this.this$1.val$eventName, null, "");
          continue;
        }
        PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$seq, this.this$1.val$eventName, null, "");
        continue;
        PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$seq, this.this$1.val$eventName, null, "");
        continue;
        PayJsPlugin.access$200(this.this$1.this$0, this.this$1.val$seq, this.this$1.val$eventName, null, "");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */