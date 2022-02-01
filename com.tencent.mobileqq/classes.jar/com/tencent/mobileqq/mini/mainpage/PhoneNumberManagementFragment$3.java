package com.tencent.mobileqq.mini.mainpage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class PhoneNumberManagementFragment$3
  implements DialogInterface.OnClickListener
{
  PhoneNumberManagementFragment$3(PhoneNumberManagementFragment paramPhoneNumberManagementFragment, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("PhoneNumberManagementFragment", 1, " click positiveButton");
    if (PhoneNumberManagementFragment.access$000(this.this$0) != null)
    {
      paramDialogInterface = PhoneNumberManagementFragment.access$000(this.this$0).optJSONObject(this.val$position);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.optString("purePhoneNumber");
        MiniAppCmdUtil.getInstance().delPhoneNumber(PhoneNumberManagementFragment.access$200(this.this$0), paramDialogInterface, new PhoneNumberManagementFragment.3.1(this, paramDialogInterface));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment.3
 * JD-Core Version:    0.7.0.1
 */