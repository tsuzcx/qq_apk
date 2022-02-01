package com.tencent.qqmini.sdk.ui;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Button;

class AddPhoneNumberFragment$1
  implements Runnable
{
  AddPhoneNumberFragment$1(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void run()
  {
    if (AddPhoneNumberFragment.mSecond <= 1)
    {
      AddPhoneNumberFragment.access$000(this.this$0).setText("获取验证码");
      AddPhoneNumberFragment.access$000(this.this$0).setTextColor(Color.parseColor("#181819"));
      AddPhoneNumberFragment.access$000(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$000(this.this$0).setClickable(true);
      return;
    }
    AddPhoneNumberFragment.mSecond -= 1;
    AddPhoneNumberFragment.access$000(this.this$0).setClickable(false);
    AddPhoneNumberFragment.access$000(this.this$0).setText("有效期(" + AddPhoneNumberFragment.mSecond + ")");
    AddPhoneNumberFragment.access$100(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.1
 * JD-Core Version:    0.7.0.1
 */