package com.tencent.mobileqq.studymode;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

class KidModeVerifyFragment$2
  implements Runnable
{
  KidModeVerifyFragment$2(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void run()
  {
    if (KidModeVerifyFragment.a <= 1)
    {
      KidModeVerifyFragment.a(this.this$0).setText(2131693558);
      KidModeVerifyFragment.a(this.this$0).setEnabled(true);
      KidModeVerifyFragment.a(this.this$0).setClickable(true);
      return;
    }
    KidModeVerifyFragment.a -= 1;
    KidModeVerifyFragment.a(this.this$0).setText(KidModeVerifyFragment.a(this.this$0, KidModeVerifyFragment.a));
    if ((this.this$0.getBaseActivity() != null) && (!this.this$0.getBaseActivity().isFinishing())) {
      KidModeVerifyFragment.a(this.this$0).postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */