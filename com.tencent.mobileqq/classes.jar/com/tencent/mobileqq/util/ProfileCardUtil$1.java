package com.tencent.mobileqq.util;

import anum;
import bhmi;
import bhmq;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public void run()
  {
    String str1 = anum.a(this.a, anum.b(BaseApplication.getContext()));
    int i = anum.c(BaseApplication.getContext());
    String str2 = anum.a(this.a, i);
    bhmq.a(this.b, str1);
    bhmq.a(this.b, str2, i, i);
    bhmi.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */