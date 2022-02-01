package com.tencent.mobileqq.util;

import amov;
import bfvo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public void run()
  {
    String str1 = amov.a(this.a, amov.b(BaseApplication.getContext()));
    int i = amov.c(BaseApplication.getContext());
    String str2 = amov.a(this.a, i);
    bfvo.a(this.b, str1);
    bfvo.a(this.b, str2, i, i);
    FileUtils.delete(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */