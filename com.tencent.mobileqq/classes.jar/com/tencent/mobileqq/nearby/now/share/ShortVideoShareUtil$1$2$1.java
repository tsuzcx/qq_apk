package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import awhw;
import awrd;
import awrf;
import awrs;
import bcek;

public class ShortVideoShareUtil$1$2$1
  implements Runnable
{
  public ShortVideoShareUtil$1$2$1(awrf paramawrf, awhw paramawhw) {}
  
  public void run()
  {
    bcek localbcek = new bcek(this.jdField_a_of_type_Awrf.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(awrs.d);
    int i = this.jdField_a_of_type_Awhw.b();
    String str2 = awrs.a;
    if (TextUtils.equals(awrs.a, "2")) {}
    for (String str1 = awrs.c;; str1 = "")
    {
      localbcek.a(new String[] { "2", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1
 * JD-Core Version:    0.7.0.1
 */