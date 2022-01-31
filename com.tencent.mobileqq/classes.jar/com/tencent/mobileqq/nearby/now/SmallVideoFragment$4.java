package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import ascz;
import asmr;
import awrb;

class SmallVideoFragment$4
  implements Runnable
{
  SmallVideoFragment$4(SmallVideoFragment paramSmallVideoFragment, ascz paramascz) {}
  
  public void run()
  {
    awrb localawrb = new awrb(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(asmr.d);
    int i = this.a.b();
    String str2 = asmr.a;
    if (TextUtils.equals(asmr.a, "2")) {}
    for (String str1 = asmr.c;; str1 = "")
    {
      localawrb.a(new String[] { "3", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */