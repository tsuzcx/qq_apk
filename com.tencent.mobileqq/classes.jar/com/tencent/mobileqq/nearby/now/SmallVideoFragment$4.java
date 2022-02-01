package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axup;
import ayek;
import bdlq;

class SmallVideoFragment$4
  implements Runnable
{
  SmallVideoFragment$4(SmallVideoFragment paramSmallVideoFragment, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(ayek.d);
    int i = this.a.b();
    String str2 = ayek.a;
    if (TextUtils.equals(ayek.a, "2")) {}
    for (String str1 = ayek.c;; str1 = "")
    {
      localbdlq.a(new String[] { "3", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */