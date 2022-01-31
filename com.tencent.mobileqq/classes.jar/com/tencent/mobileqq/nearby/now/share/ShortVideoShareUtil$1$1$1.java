package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import auul;
import avds;
import avdt;
import aveg;
import azqx;

public class ShortVideoShareUtil$1$1$1
  implements Runnable
{
  public ShortVideoShareUtil$1$1$1(avdt paramavdt, auul paramauul) {}
  
  public void run()
  {
    azqx localazqx = new azqx(this.jdField_a_of_type_Avdt.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(aveg.d);
    int i = this.jdField_a_of_type_Auul.b();
    String str2 = aveg.a;
    if (TextUtils.equals(aveg.a, "2")) {}
    for (String str1 = aveg.c;; str1 = "")
    {
      localazqx.a(new String[] { "1", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */