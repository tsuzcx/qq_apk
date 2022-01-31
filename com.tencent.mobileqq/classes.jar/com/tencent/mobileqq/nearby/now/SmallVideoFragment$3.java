package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import auqc;
import auzx;
import azmo;

class SmallVideoFragment$3
  implements Runnable
{
  SmallVideoFragment$3(SmallVideoFragment paramSmallVideoFragment, long paramLong, auqc paramauqc) {}
  
  public void run()
  {
    azmo localazmo = new azmo(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_time").e(auzx.d);
    String str2 = this.jdField_a_of_type_Long + "";
    int i = this.jdField_a_of_type_Auqc.b();
    String str3 = auzx.a;
    if (TextUtils.equals(auzx.a, "2")) {}
    for (String str1 = auzx.c;; str1 = "")
    {
      localazmo.a(new String[] { str2, String.valueOf(i), str3, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */