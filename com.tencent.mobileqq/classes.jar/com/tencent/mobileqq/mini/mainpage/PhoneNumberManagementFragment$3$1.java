package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PhoneNumberManagementFragment$3$1
  implements MiniAppCmdInterface
{
  PhoneNumberManagementFragment$3$1(PhoneNumberManagementFragment.3 param3, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuc : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("; ret : ");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("; purePhoneNumber : ");
    localStringBuilder.append(this.val$purePhoneNumber);
    QLog.d("PhoneNumberManagementFragment", 1, localStringBuilder.toString());
    if (paramBoolean) {
      AppBrandTask.runTaskOnUiThread(new PhoneNumberManagementFragment.3.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment.3.1
 * JD-Core Version:    0.7.0.1
 */