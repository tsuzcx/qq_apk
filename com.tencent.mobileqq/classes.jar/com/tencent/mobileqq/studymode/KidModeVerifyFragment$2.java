package com.tencent.mobileqq.studymode;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

class KidModeVerifyFragment$2
  implements Runnable
{
  KidModeVerifyFragment$2(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void run()
  {
    if (KidModeVerifyFragment.a <= 1)
    {
      KidModeVerifyFragment.a(this.this$0).setText(2131693450);
      KidModeVerifyFragment.a(this.this$0).setEnabled(true);
      KidModeVerifyFragment.a(this.this$0).setClickable(true);
    }
    do
    {
      return;
      KidModeVerifyFragment.a -= 1;
      KidModeVerifyFragment.a(this.this$0).setText(KidModeVerifyFragment.a(this.this$0, KidModeVerifyFragment.a));
    } while ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing()));
    KidModeVerifyFragment.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */