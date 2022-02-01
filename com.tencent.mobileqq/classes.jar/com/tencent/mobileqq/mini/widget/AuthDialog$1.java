package com.tencent.mobileqq.mini.widget;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class AuthDialog$1
  implements MiniAppController.ActivityResultListener
{
  AuthDialog$1(AuthDialog paramAuthDialog) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("AuthDialog", 2, "doOnActivityResult : " + paramInt1);
    if (paramInt1 == 1089) {
      if (paramInt2 == -1) {
        if (paramIntent == null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new JSONArray(paramIntent.getStringExtra("phoneNumberArray"));
        if (AuthDialog.access$000(this.this$0) != null)
        {
          AuthDialog.access$000(this.this$0).setPhoneNumberList(paramIntent);
          AuthDialog.access$100(this.this$0, AuthDialog.access$000(this.this$0).getPhoneNumberList());
        }
        return true;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("AuthDialog", 1, "REQUEST_CODE_PHONE_MANAGER error, ", paramIntent);
        return true;
      }
      QLog.e("AuthDialog", 1, "REQUEST_CODE_PHONE_MANAGER " + paramInt2);
      return true;
      if (paramInt1 != 1088) {
        break label331;
      }
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          continue;
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("phoneType", 1);
          localJSONObject.put("purePhoneNumber", paramIntent.getStringExtra("phoneNumber"));
          localJSONObject.put("countryCode", "+86");
          localJSONObject.put("iv", paramIntent.getStringExtra("iv"));
          localJSONObject.put("encryptedData", paramIntent.getStringExtra("encryptedData"));
          QLog.d("AuthDialog", 1, "REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : " + localJSONObject);
          if (AuthDialog.access$000(this.this$0) != null)
          {
            AuthDialog.access$000(this.this$0).getPhoneNumberList().put(localJSONObject);
            AuthDialog.access$100(this.this$0, AuthDialog.access$000(this.this$0).getPhoneNumberList());
            return true;
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("AuthDialog", 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", paramIntent);
          return true;
        }
      }
    }
    QLog.e("AuthDialog", 1, "REQUEST_CODE_ADD_PHONENUMBER " + paramInt2);
    return true;
    label331:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog.1
 * JD-Core Version:    0.7.0.1
 */