package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axby;
import axlq;
import bcsy;

class SmallVideoFragment$4
  implements Runnable
{
  SmallVideoFragment$4(SmallVideoFragment paramSmallVideoFragment, axby paramaxby) {}
  
  public void run()
  {
    bcsy localbcsy = new bcsy(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(axlq.d);
    int i = this.a.b();
    String str2 = axlq.a;
    if (TextUtils.equals(axlq.a, "2")) {}
    for (String str1 = axlq.c;; str1 = "")
    {
      localbcsy.a(new String[] { "3", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */