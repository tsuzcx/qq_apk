package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axny;
import axxu;
import bdlf;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, axny paramaxny) {}
  
  public void run()
  {
    bdlf localbdlf = new bdlf(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(axxu.d);
    int i = this.a.b();
    String str2 = axxu.a;
    if (TextUtils.equals(axxu.a, "2")) {}
    for (String str1 = axxu.c;; str1 = "")
    {
      localbdlf.a(new String[] { "4", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */