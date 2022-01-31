package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import auqc;
import auzj;
import auzl;
import auzx;
import azmo;

public class ShortVideoShareUtil$1$2$1
  implements Runnable
{
  public ShortVideoShareUtil$1$2$1(auzl paramauzl, auqc paramauqc) {}
  
  public void run()
  {
    azmo localazmo = new azmo(this.jdField_a_of_type_Auzl.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(auzx.d);
    int i = this.jdField_a_of_type_Auqc.b();
    String str2 = auzx.a;
    if (TextUtils.equals(auzx.a, "2")) {}
    for (String str1 = auzx.c;; str1 = "")
    {
      localazmo.a(new String[] { "2", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1
 * JD-Core Version:    0.7.0.1
 */