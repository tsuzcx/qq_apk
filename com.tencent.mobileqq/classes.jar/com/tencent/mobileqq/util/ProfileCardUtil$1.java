package com.tencent.mobileqq.util;

import anri;
import bheg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public void run()
  {
    String str1 = anri.a(this.a, anri.b(BaseApplication.getContext()));
    int i = anri.c(BaseApplication.getContext());
    String str2 = anri.a(this.a, i);
    bheg.a(this.b, str1);
    bheg.a(this.b, str2, i, i);
    FileUtils.delete(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */