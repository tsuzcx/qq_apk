package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import auqc;
import auzx;
import azmo;

class SmallVideoFragment$4
  implements Runnable
{
  SmallVideoFragment$4(SmallVideoFragment paramSmallVideoFragment, auqc paramauqc) {}
  
  public void run()
  {
    azmo localazmo = new azmo(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(auzx.d);
    int i = this.a.b();
    String str2 = auzx.a;
    if (TextUtils.equals(auzx.a, "2")) {}
    for (String str1 = auzx.c;; str1 = "")
    {
      localazmo.a(new String[] { "3", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */