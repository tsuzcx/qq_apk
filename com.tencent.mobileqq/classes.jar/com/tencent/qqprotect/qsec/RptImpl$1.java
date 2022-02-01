package com.tencent.qqprotect.qsec;

import com.tencent.qphone.base.util.QLog;

class RptImpl$1
  implements QSecFramework.IGoingUpHandler
{
  RptImpl$1(RptImpl paramRptImpl) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.Rpt", 2, String.format("Op: %d, Rid: %d, val: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), (String)paramObject1 }));
      }
      this.a.a((int)paramLong1, (int)paramLong2, (String)paramObject1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.RptImpl.1
 * JD-Core Version:    0.7.0.1
 */