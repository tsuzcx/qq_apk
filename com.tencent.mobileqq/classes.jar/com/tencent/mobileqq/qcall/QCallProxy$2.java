package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class QCallProxy$2
  implements Comparator<QCallRecord>
{
  QCallProxy$2(QCallProxy paramQCallProxy) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    if (paramQCallRecord1.type == QCallRecord.TYPE_DATE) {
      return 0;
    }
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.2
 * JD-Core Version:    0.7.0.1
 */