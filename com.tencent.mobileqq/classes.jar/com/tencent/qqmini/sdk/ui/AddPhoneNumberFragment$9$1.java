package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$9$1
  implements AsyncResult
{
  AddPhoneNumberFragment$9$1(AddPhoneNumberFragment.9 param9, ChannelProxy paramChannelProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("AddPhoneNumberFragment", "sendVerifySmsCodeRequest isSuccess=" + paramBoolean + "; result=" + paramJSONObject);
    if (paramBoolean)
    {
      paramJSONObject = this.val$proxy;
      String str1 = AddPhoneNumberFragment.access$1100(this.this$1.this$0);
      String str2 = AddPhoneNumberFragment.access$200(this.this$1.this$0);
      if (AddPhoneNumberFragment.access$600(this.this$1.this$0)) {}
      for (int i = 1;; i = 0)
      {
        paramJSONObject.addPhoneNumber(str1, str2, "+86", i, new AddPhoneNumberFragment.9.1.1(this));
        return;
      }
    }
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.9.1.2(this, paramJSONObject.optString("message", "")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.9.1
 * JD-Core Version:    0.7.0.1
 */