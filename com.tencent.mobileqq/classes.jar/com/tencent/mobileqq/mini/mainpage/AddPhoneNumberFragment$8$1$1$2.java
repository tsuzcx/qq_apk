package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$8$1$1$2
  implements Runnable
{
  AddPhoneNumberFragment$8$1$1$2(AddPhoneNumberFragment.8.1.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    Object localObject = this.val$ret;
    if (localObject != null)
    {
      localIntent.putExtra("encryptedData", ((JSONObject)localObject).optString("encryptedData"));
      localIntent.putExtra("iv", this.val$ret.optString("iv"));
      localIntent.putExtra("phoneNumber", AddPhoneNumberFragment.access$000(this.this$3.this$2.this$1.this$0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("phoneNumber : ");
      ((StringBuilder)localObject).append(AddPhoneNumberFragment.access$000(this.this$3.this$2.this$1.this$0));
      QLog.d("AddPhoneNumberFragment", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.this$3.this$2.this$1.this$0.getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      ((Activity)localObject).setResult(-1, localIntent);
      ((Activity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1.2
 * JD-Core Version:    0.7.0.1
 */