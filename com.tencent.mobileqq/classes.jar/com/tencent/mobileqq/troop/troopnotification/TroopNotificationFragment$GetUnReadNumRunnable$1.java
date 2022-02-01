package com.tencent.mobileqq.troop.troopnotification;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import mqq.util.WeakReference;

class TroopNotificationFragment$GetUnReadNumRunnable$1
  implements Runnable
{
  TroopNotificationFragment$GetUnReadNumRunnable$1(TroopNotificationFragment.GetUnReadNumRunnable paramGetUnReadNumRunnable, int paramInt) {}
  
  public void run()
  {
    if ((TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0).get() != null) && (!((Activity)TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0).get()).isFinishing()))
    {
      TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0).setVisibility(0);
      TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0).setVisibility(0);
      TextView localTextView = TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a);
      localTextView.setText(localStringBuilder.toString());
      if (this.a <= 0) {
        TroopNotificationFragment.GetUnReadNumRunnable.a(this.this$0).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.GetUnReadNumRunnable.1
 * JD-Core Version:    0.7.0.1
 */