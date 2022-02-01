package com.tencent.qqmini.sdk.widget;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import org.json.JSONArray;
import org.json.JSONObject;

class AuthDialog$1
  implements IActivityResultListener
{
  AuthDialog$1(AuthDialog paramAuthDialog) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.d("AuthDialog", "doOnActivityResult : " + paramInt1);
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
        QMLog.e("AuthDialog", "REQUEST_CODE_PHONE_MANAGER error, ", paramIntent);
        return true;
      }
      QMLog.e("AuthDialog", "REQUEST_CODE_PHONE_MANAGER " + paramInt2);
      return true;
      if (paramInt1 != 1088) {
        break label325;
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
          QMLog.d("AuthDialog", "REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : " + localJSONObject);
          if (AuthDialog.access$000(this.this$0) != null)
          {
            AuthDialog.access$000(this.this$0).getPhoneNumberList().put(localJSONObject);
            AuthDialog.access$100(this.this$0, AuthDialog.access$000(this.this$0).getPhoneNumberList());
            return true;
          }
        }
        catch (Throwable paramIntent)
        {
          QMLog.e("AuthDialog", "REQUEST_CODE_ADD_PHONENUMBER error, ", paramIntent);
          return true;
        }
      }
    }
    QMLog.e("AuthDialog", "REQUEST_CODE_ADD_PHONENUMBER " + paramInt2);
    return true;
    label325:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.1
 * JD-Core Version:    0.7.0.1
 */