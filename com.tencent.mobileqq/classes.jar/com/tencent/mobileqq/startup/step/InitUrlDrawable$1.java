package com.tencent.mobileqq.startup.step;

import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.log.IQLog;

final class InitUrlDrawable$1
  implements IQLog
{
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, Throwable paramThrowable)
  {
    if ((1 == paramInt2) || (QLog.isColorLevel()))
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 5)
        {
          if (paramInt1 != 6)
          {
            QLog.i(paramString1, paramInt2, paramString2, paramThrowable);
            return;
          }
          QLog.e(paramString1, paramInt2, paramString2, paramThrowable);
          return;
        }
        QLog.w(paramString1, paramInt2, paramString2, paramThrowable);
        return;
      }
      QLog.d(paramString1, paramInt2, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.1
 * JD-Core Version:    0.7.0.1
 */