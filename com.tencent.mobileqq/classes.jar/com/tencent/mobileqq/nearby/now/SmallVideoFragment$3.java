package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axup;
import ayek;
import bdlq;

class SmallVideoFragment$3
  implements Runnable
{
  SmallVideoFragment$3(SmallVideoFragment paramSmallVideoFragment, long paramLong, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_time").e(ayek.d);
    String str2 = this.jdField_a_of_type_Long + "";
    int i = this.jdField_a_of_type_Axup.b();
    String str3 = ayek.a;
    if (TextUtils.equals(ayek.a, "2")) {}
    for (String str1 = ayek.c;; str1 = "")
    {
      localbdlq.a(new String[] { str2, String.valueOf(i), str3, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */