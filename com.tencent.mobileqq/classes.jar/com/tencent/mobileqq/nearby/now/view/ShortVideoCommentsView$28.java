package com.tencent.mobileqq.nearby.now.view;

import android.text.TextUtils;
import axby;
import axlq;
import bcsy;

class ShortVideoCommentsView$28
  implements Runnable
{
  ShortVideoCommentsView$28(ShortVideoCommentsView paramShortVideoCommentsView, axby paramaxby) {}
  
  public void run()
  {
    bcsy localbcsy = new bcsy(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_com_exp").e(axlq.d);
    int i = this.a.b();
    String str2 = axlq.a;
    if (TextUtils.equals(axlq.a, "2")) {}
    for (String str1 = axlq.c;; str1 = "")
    {
      localbcsy.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.28
 * JD-Core Version:    0.7.0.1
 */