package com.tencent.mobileqq.util;

import alkv;
import bdcs;
import bdda;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = alkv.a(this.a, alkv.b(BaseApplication.getContext()));
    int i = alkv.c(BaseApplication.getContext());
    String str2 = alkv.a(this.a, i);
    bdda.a(this.b, str1);
    bdda.a(this.b, str2, i, i);
    bdcs.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */