package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import org.json.JSONArray;
import org.json.JSONObject;

class PhoneNumberManagementFragment$1
  implements IActivityResultListener
{
  PhoneNumberManagementFragment$1(PhoneNumberManagementFragment paramPhoneNumberManagementFragment) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnActivityResult : ");
    ((StringBuilder)localObject).append(paramInt1);
    QMLog.d("PhoneNumberManagementFragment", ((StringBuilder)localObject).toString());
    if (paramInt1 == 1090)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("phoneType", 1);
            ((JSONObject)localObject).put("purePhoneNumber", paramIntent.getStringExtra("phoneNumber"));
            ((JSONObject)localObject).put("countryCode", "+86");
            ((JSONObject)localObject).put("iv", paramIntent.getStringExtra("iv"));
            ((JSONObject)localObject).put("encryptedData", paramIntent.getStringExtra("encryptedData"));
            if (PhoneNumberManagementFragment.access$000(this.this$0) == null) {
              break label227;
            }
            paramIntent = new StringBuilder();
            paramIntent.append("mPhoneNumberArray put : ");
            paramIntent.append(((JSONObject)localObject).toString());
            QMLog.d("PhoneNumberManagementFragment", paramIntent.toString());
            PhoneNumberManagementFragment.access$000(this.this$0).put(localObject);
            PhoneNumberManagementFragment.access$100(this.this$0);
            return true;
          }
          catch (Throwable paramIntent)
          {
            QMLog.e("PhoneNumberManagementFragment", "REQUEST_CODE_ADD_PHONENUMBER error, ", paramIntent);
            return true;
          }
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("REQUEST_CODE_ADD_PHONENUMBER ");
        paramIntent.append(paramInt2);
        QMLog.e("PhoneNumberManagementFragment", paramIntent.toString());
      }
      label227:
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.1
 * JD-Core Version:    0.7.0.1
 */