package com.tencent.qqprotect.qsec;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class QSecFramework$4
  implements QSecFramework.IGoingUpHandler
{
  QSecFramework$4(QSecFramework paramQSecFramework) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramLong1 != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSecFramework", 2, String.format("Native msg, cookie: %08X, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      paramObject1 = String.valueOf(paramLong1);
      if (paramLong2 != 0L)
      {
        QSecFramework.a(this.a).sendMessageDelayed(QSecFramework.a(this.a).obtainMessage(1, paramObject1), paramLong2 * 1000L);
        return 0;
      }
      QSecFramework.a(this.a).sendMessage(QSecFramework.a(this.a).obtainMessage(1, paramObject1));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework.4
 * JD-Core Version:    0.7.0.1
 */