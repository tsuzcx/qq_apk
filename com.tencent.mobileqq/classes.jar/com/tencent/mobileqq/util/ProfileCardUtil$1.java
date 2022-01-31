package com.tencent.mobileqq.util;

import ajtk;
import bbdj;
import bbdr;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = ajtk.a(this.a, ajtk.b(BaseApplication.getContext()));
    int i = ajtk.c(BaseApplication.getContext());
    String str2 = ajtk.a(this.a, i);
    bbdr.a(this.b, str1);
    bbdr.a(this.b, str2, i, i);
    bbdj.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */