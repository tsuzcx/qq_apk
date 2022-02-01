package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class PhoneNumberManagementFragment$3$1
  implements AsyncResult
{
  PhoneNumberManagementFragment$3$1(PhoneNumberManagementFragment.3 param3, String paramString) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuccess : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("; result : ");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("; purePhoneNumber : ");
    localStringBuilder.append(this.val$purePhoneNumber);
    QMLog.d("PhoneNumberManagementFragment", localStringBuilder.toString());
    if (paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new PhoneNumberManagementFragment.3.1.1(this));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new PhoneNumberManagementFragment.3.1.2(this, paramJSONObject.optString("errMsg")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3.1
 * JD-Core Version:    0.7.0.1
 */