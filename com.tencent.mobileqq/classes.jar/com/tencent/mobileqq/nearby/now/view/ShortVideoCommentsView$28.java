package com.tencent.mobileqq.nearby.now.view;

import android.text.TextUtils;
import aszf;
import atix;
import axrc;

class ShortVideoCommentsView$28
  implements Runnable
{
  ShortVideoCommentsView$28(ShortVideoCommentsView paramShortVideoCommentsView, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_com_exp").e(atix.d);
    int i = this.a.b();
    String str2 = atix.a;
    if (TextUtils.equals(atix.a, "2")) {}
    for (String str1 = atix.c;; str1 = "")
    {
      localaxrc.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.28
 * JD-Core Version:    0.7.0.1
 */