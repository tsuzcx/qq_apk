package com.tencent.mobileqq.util;

import ajti;
import bbdx;
import bbef;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = ajti.a(this.a, ajti.b(BaseApplication.getContext()));
    int i = ajti.c(BaseApplication.getContext());
    String str2 = ajti.a(this.a, i);
    bbef.a(this.b, str1);
    bbef.a(this.b, str2, i, i);
    bbdx.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */