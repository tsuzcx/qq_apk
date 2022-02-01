package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import axny;
import axxf;
import axxg;
import axxu;
import bdlf;

public class ShortVideoShareUtil$1$1$1
  implements Runnable
{
  public ShortVideoShareUtil$1$1$1(axxg paramaxxg, axny paramaxny) {}
  
  public void run()
  {
    bdlf localbdlf = new bdlf(this.jdField_a_of_type_Axxg.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(axxu.d);
    int i = this.jdField_a_of_type_Axny.b();
    String str2 = axxu.a;
    if (TextUtils.equals(axxu.a, "2")) {}
    for (String str1 = axxu.c;; str1 = "")
    {
      localbdlf.a(new String[] { "1", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */