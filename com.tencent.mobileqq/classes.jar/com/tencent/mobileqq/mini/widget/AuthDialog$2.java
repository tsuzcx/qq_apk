package com.tencent.mobileqq.mini.widget;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class AuthDialog$2
  implements MiniAppController.ActivityResultListener
{
  AuthDialog$2(AuthDialog paramAuthDialog) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnActivityResult : ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("AuthDialog", 2, ((StringBuilder)localObject).toString());
    if (paramInt1 == 1089)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          try
          {
            paramIntent = new JSONArray(paramIntent.getStringExtra("phoneNumberArray"));
            if (AuthDialog.access$700(this.this$0) == null) {
              break label149;
            }
            AuthDialog.access$700(this.this$0).setPhoneNumberList(paramIntent);
            AuthDialog.access$800(this.this$0, AuthDialog.access$700(this.this$0).getPhoneNumberList());
            return true;
          }
          catch (Throwable paramIntent)
          {
            QLog.e("AuthDialog", 1, "REQUEST_CODE_PHONE_MANAGER error, ", paramIntent);
            return true;
          }
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("REQUEST_CODE_PHONE_MANAGER ");
        paramIntent.append(paramInt2);
        QLog.e("AuthDialog", 1, paramIntent.toString());
      }
      label149:
      return true;
    }
    if (paramInt1 == 1088)
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
            paramIntent = new StringBuilder();
            paramIntent.append("REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : ");
            paramIntent.append(localObject);
            QLog.d("AuthDialog", 1, paramIntent.toString());
            if (AuthDialog.access$700(this.this$0) == null) {
              break label357;
            }
            AuthDialog.access$700(this.this$0).getPhoneNumberList().put(localObject);
            AuthDialog.access$800(this.this$0, AuthDialog.access$700(this.this$0).getPhoneNumberList());
            return true;
          }
          catch (Throwable paramIntent)
          {
            QLog.e("AuthDialog", 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", paramIntent);
            return true;
          }
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("REQUEST_CODE_ADD_PHONENUMBER ");
        paramIntent.append(paramInt2);
        QLog.e("AuthDialog", 1, paramIntent.toString());
      }
      label357:
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog.2
 * JD-Core Version:    0.7.0.1
 */