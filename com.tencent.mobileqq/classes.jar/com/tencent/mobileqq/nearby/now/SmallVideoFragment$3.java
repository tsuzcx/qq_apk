package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import aszf;
import atix;
import axrc;

class SmallVideoFragment$3
  implements Runnable
{
  SmallVideoFragment$3(SmallVideoFragment paramSmallVideoFragment, long paramLong, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_time").e(atix.d);
    String str2 = this.jdField_a_of_type_Long + "";
    int i = this.jdField_a_of_type_Aszf.b();
    String str3 = atix.a;
    if (TextUtils.equals(atix.a, "2")) {}
    for (String str1 = atix.c;; str1 = "")
    {
      localaxrc.a(new String[] { str2, String.valueOf(i), str3, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */