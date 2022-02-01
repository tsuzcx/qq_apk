package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import axup;
import aydv;
import aydx;
import ayek;
import bdlq;

public class ShortVideoShareUtil$1$2$1
  implements Runnable
{
  public ShortVideoShareUtil$1$2$1(aydx paramaydx, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(this.jdField_a_of_type_Aydx.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(ayek.d);
    int i = this.jdField_a_of_type_Axup.b();
    String str2 = ayek.a;
    if (TextUtils.equals(ayek.a, "2")) {}
    for (String str1 = ayek.c;; str1 = "")
    {
      localbdlq.a(new String[] { "2", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1
 * JD-Core Version:    0.7.0.1
 */