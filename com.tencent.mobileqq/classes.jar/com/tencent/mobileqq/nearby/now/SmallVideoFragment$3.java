package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axny;
import axxu;
import bdlf;

class SmallVideoFragment$3
  implements Runnable
{
  SmallVideoFragment$3(SmallVideoFragment paramSmallVideoFragment, long paramLong, axny paramaxny) {}
  
  public void run()
  {
    bdlf localbdlf = new bdlf(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_time").e(axxu.d);
    String str2 = this.jdField_a_of_type_Long + "";
    int i = this.jdField_a_of_type_Axny.b();
    String str3 = axxu.a;
    if (TextUtils.equals(axxu.a, "2")) {}
    for (String str1 = axxu.c;; str1 = "")
    {
      localbdlf.a(new String[] { str2, String.valueOf(i), str3, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */