package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import aszf;
import atik;
import atim;
import atix;
import axrc;

public class ShortVideoShareUtil$1$2$1
  implements Runnable
{
  public ShortVideoShareUtil$1$2$1(atim paramatim, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.jdField_a_of_type_Atim.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(atix.d);
    int i = this.jdField_a_of_type_Aszf.b();
    String str2 = atix.a;
    if (TextUtils.equals(atix.a, "2")) {}
    for (String str1 = atix.c;; str1 = "")
    {
      localaxrc.a(new String[] { "2", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1
 * JD-Core Version:    0.7.0.1
 */