package com.tencent.mobileqq.mini.mainpage;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$8$1$1$2
  implements Runnable
{
  AddPhoneNumberFragment$8$1$1$2(AddPhoneNumberFragment.8.1.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    if (this.val$ret != null)
    {
      localIntent.putExtra("encryptedData", this.val$ret.optString("encryptedData"));
      localIntent.putExtra("iv", this.val$ret.optString("iv"));
      localIntent.putExtra("phoneNumber", AddPhoneNumberFragment.access$000(this.this$3.this$2.this$1.this$0));
      QLog.d("AddPhoneNumberFragment", 1, "phoneNumber : " + AddPhoneNumberFragment.access$000(this.this$3.this$2.this$1.this$0));
    }
    this.this$3.this$2.this$1.this$0.getActivity().setResult(-1, localIntent);
    this.this$3.this$2.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1.2
 * JD-Core Version:    0.7.0.1
 */