package com.tencent.mobileqq.kandian.biz.daily;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;

class ReadInJoyDailyFragment$3
  extends BroadcastReceiver
{
  ReadInJoyDailyFragment$3(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.getBaseActivity() != null)
    {
      if (ReadInJoyDailyFragment.a(this.a) != null) {
        ReadInJoyDailyFragment.a(this.a).d();
      }
      ReadInJoyDailyFragment.a(this.a, true);
      this.a.getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment.3
 * JD-Core Version:    0.7.0.1
 */