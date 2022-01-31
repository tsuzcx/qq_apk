package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import ascz;
import asme;
import asmg;
import asmr;
import awrb;

public class ShortVideoShareUtil$1$2$1
  implements Runnable
{
  public ShortVideoShareUtil$1$2$1(asmg paramasmg, ascz paramascz) {}
  
  public void run()
  {
    awrb localawrb = new awrb(this.jdField_a_of_type_Asmg.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(asmr.d);
    int i = this.jdField_a_of_type_Ascz.b();
    String str2 = asmr.a;
    if (TextUtils.equals(asmr.a, "2")) {}
    for (String str1 = asmr.c;; str1 = "")
    {
      localawrb.a(new String[] { "2", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1
 * JD-Core Version:    0.7.0.1
 */