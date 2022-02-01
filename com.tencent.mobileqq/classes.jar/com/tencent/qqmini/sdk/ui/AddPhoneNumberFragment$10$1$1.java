package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$10$1$1
  implements Runnable
{
  AddPhoneNumberFragment$10$1$1(AddPhoneNumberFragment.10.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    if (this.val$result != null)
    {
      localIntent.putExtra("encryptedData", this.val$result.optString("encryptedData"));
      localIntent.putExtra("iv", this.val$result.optString("iv"));
      localIntent.putExtra("phoneNumber", AddPhoneNumberFragment.access$200(this.this$2.this$1.this$0));
      QMLog.d("AddPhoneNumberFragment", "phoneNumber : " + AddPhoneNumberFragment.access$200(this.this$2.this$1.this$0));
    }
    this.this$2.this$1.this$0.getActivity().setResult(-1, localIntent);
    this.this$2.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.10.1.1
 * JD-Core Version:    0.7.0.1
 */