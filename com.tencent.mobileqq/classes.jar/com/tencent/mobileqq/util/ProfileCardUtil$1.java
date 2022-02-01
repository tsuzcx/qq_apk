package com.tencent.mobileqq.util;

import anip;
import bgmg;
import bgmo;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public void run()
  {
    String str1 = anip.a(this.a, anip.b(BaseApplication.getContext()));
    int i = anip.c(BaseApplication.getContext());
    String str2 = anip.a(this.a, i);
    bgmo.a(this.b, str1);
    bgmo.a(this.b, str2, i, i);
    bgmg.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */