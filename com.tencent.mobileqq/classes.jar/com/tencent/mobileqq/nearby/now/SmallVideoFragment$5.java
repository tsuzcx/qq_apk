package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import auul;
import aveg;
import azqx;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, auul paramauul) {}
  
  public void run()
  {
    azqx localazqx = new azqx(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(aveg.d);
    int i = this.a.b();
    String str2 = aveg.a;
    if (TextUtils.equals(aveg.a, "2")) {}
    for (String str1 = aveg.c;; str1 = "")
    {
      localazqx.a(new String[] { "4", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */