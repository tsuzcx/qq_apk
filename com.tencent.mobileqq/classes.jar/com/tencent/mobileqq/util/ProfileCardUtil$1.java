package com.tencent.mobileqq.util;

import ajfi;
import bace;
import bacm;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = ajfi.a(this.a, ajfi.b(BaseApplication.getContext()));
    int i = ajfi.c(BaseApplication.getContext());
    String str2 = ajfi.a(this.a, i);
    bacm.a(this.b, str1);
    bacm.a(this.b, str2, i, i);
    bace.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */