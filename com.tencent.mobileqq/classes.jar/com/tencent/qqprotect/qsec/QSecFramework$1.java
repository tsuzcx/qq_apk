package com.tencent.qqprotect.qsec;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;

final class QSecFramework$1
  implements CrashProtector.IProtectedMethod
{
  public void a()
  {
    if (QSecFramework.a()) {
      return;
    }
    try
    {
      if (!QSecFramework.b()) {
        System.loadLibrary("QSec");
      }
      QSecFramework.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when load native so.");
    }
    CommTvRpt.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework.1
 * JD-Core Version:    0.7.0.1
 */