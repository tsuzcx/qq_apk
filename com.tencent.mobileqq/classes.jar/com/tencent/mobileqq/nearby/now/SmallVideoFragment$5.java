package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import aszf;
import atix;
import axrc;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(atix.d);
    int i = this.a.b();
    String str2 = atix.a;
    if (TextUtils.equals(atix.a, "2")) {}
    for (String str1 = atix.c;; str1 = "")
    {
      localaxrc.a(new String[] { "4", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */