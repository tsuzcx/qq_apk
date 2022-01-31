package com.tencent.mobileqq.util;

import alpk;
import bdhb;
import bdhj;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = alpk.a(this.a, alpk.b(BaseApplication.getContext()));
    int i = alpk.c(BaseApplication.getContext());
    String str2 = alpk.a(this.a, i);
    bdhj.a(this.b, str1);
    bdhj.a(this.b, str2, i, i);
    bdhb.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */