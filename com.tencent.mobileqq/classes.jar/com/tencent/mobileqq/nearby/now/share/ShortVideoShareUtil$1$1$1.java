package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import axby;
import axlb;
import axlc;
import axlq;
import bcsy;

public class ShortVideoShareUtil$1$1$1
  implements Runnable
{
  public ShortVideoShareUtil$1$1$1(axlc paramaxlc, axby paramaxby) {}
  
  public void run()
  {
    bcsy localbcsy = new bcsy(this.jdField_a_of_type_Axlc.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(axlq.d);
    int i = this.jdField_a_of_type_Axby.b();
    String str2 = axlq.a;
    if (TextUtils.equals(axlq.a, "2")) {}
    for (String str1 = axlq.c;; str1 = "")
    {
      localbcsy.a(new String[] { "1", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */