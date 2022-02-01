package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$10
  implements AsyncResult
{
  AddPhoneNumberFragment$10(AddPhoneNumberFragment paramAddPhoneNumberFragment, ChannelProxy paramChannelProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("AddPhoneNumberFragment", "sendVerifySmsCodeRequest isSuccess=" + paramBoolean + "; result=" + paramJSONObject);
    if (paramBoolean)
    {
      paramJSONObject = this.val$proxy;
      String str1 = AddPhoneNumberFragment.access$1200(this.this$0);
      String str2 = AddPhoneNumberFragment.access$200(this.this$0);
      if (AddPhoneNumberFragment.access$600(this.this$0)) {}
      for (int i = 1;; i = 0)
      {
        paramJSONObject.addPhoneNumber(str1, str2, "+86", i, new AddPhoneNumberFragment.10.1(this));
        return;
      }
    }
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.10.2(this, paramJSONObject.optString("message", "")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10
 * JD-Core Version:    0.7.0.1
 */