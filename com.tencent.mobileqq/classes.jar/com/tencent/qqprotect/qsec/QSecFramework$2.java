package com.tencent.qqprotect.qsec;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.qqprotect.common.QPMiscUtils;
import mqq.app.MobileQQ;

class QSecFramework$2
  implements CrashProtector.IProtectedMethod
{
  QSecFramework$2(QSecFramework paramQSecFramework) {}
  
  public void a()
  {
    if (QSecFramework.f())
    {
      if (QSecFramework.a(this.a)) {
        return;
      }
      try
      {
        Object[] arrayOfObject = new Object[1];
        if ((QSecFramework.a(1L, 33751040L, QPMiscUtils.b(), 0L, QSecFramework.b(this.a), MobileQQ.sMobileQQ, null, arrayOfObject) == 0) && (arrayOfObject[0] != null) && ((arrayOfObject[0] instanceof Integer)))
        {
          QSecFramework.a(this.a, ((Integer)arrayOfObject[0]).intValue());
          QPMiscUtils.a = QSecFramework.c(this.a);
          QSecFramework.a(this.a, true);
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QSecFramework", 2, String.format("Native ver: %d(%s)", new Object[] { Integer.valueOf(QSecFramework.c(this.a)), QPMiscUtils.b(QSecFramework.c(this.a)) }));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when init native.");
    }
    CommTvRpt.a(1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework.2
 * JD-Core Version:    0.7.0.1
 */