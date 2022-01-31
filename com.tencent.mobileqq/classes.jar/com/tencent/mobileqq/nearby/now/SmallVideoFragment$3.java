package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import aszd;
import ativ;
import axra;

class SmallVideoFragment$3
  implements Runnable
{
  SmallVideoFragment$3(SmallVideoFragment paramSmallVideoFragment, long paramLong, aszd paramaszd) {}
  
  public void run()
  {
    axra localaxra = new axra(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_time").e(ativ.d);
    String str2 = this.jdField_a_of_type_Long + "";
    int i = this.jdField_a_of_type_Aszd.b();
    String str3 = ativ.a;
    if (TextUtils.equals(ativ.a, "2")) {}
    for (String str1 = ativ.c;; str1 = "")
    {
      localaxra.a(new String[] { str2, String.valueOf(i), str3, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */