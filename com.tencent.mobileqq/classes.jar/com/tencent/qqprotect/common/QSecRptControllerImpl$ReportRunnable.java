package com.tencent.qqprotect.common;

import bkac;
import bkag;
import com.tencent.ims.SafeReport.LogItem;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;

class QSecRptControllerImpl$ReportRunnable
  implements Runnable
{
  private Vector<bkag> a = new Vector();
  
  private QSecRptControllerImpl$ReportRunnable(QSecRptControllerImpl paramQSecRptControllerImpl) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          break label298;
        }
        if (this.a.isEmpty()) {
          return;
        }
        localObject2 = new SafeReport.ReqBody();
        Iterator localIterator = this.a.iterator();
        int i = 0;
        int j = 0;
        if (localIterator.hasNext())
        {
          Object localObject3 = (bkag)localIterator.next();
          if (localObject3 == null) {
            continue;
          }
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new SafeReport.ReqBody();
          }
          String str = bkac.a(bkac.a(((bkag)localObject3).jdField_a_of_type_Int));
          localObject2 = new SafeReport.LogItem();
          ((SafeReport.LogItem)localObject2).uint32_rpt_id.set(((bkag)localObject3).jdField_a_of_type_Int);
          localObject3 = str + "," + ((bkag)localObject3).b + "," + ((bkag)localObject3).jdField_a_of_type_JavaLangString;
          ((SafeReport.LogItem)localObject2).bytes_rpt_data.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
          ((SafeReport.ReqBody)localObject1).LogItem_reportdata.add((MessageMicro)localObject2);
          j += 1;
          i = ((String)localObject3).length() + i;
          if ((j == 20) || (i > 1024))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QSRPT", 2, String.format("sending...item count: %d, package size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
            }
            QSecRptControllerImpl.a(this.this$0, (SafeReport.ReqBody)localObject1);
            localObject1 = null;
            i = 0;
            j = 0;
            break label299;
          }
        }
        else
        {
          if ((j > 0) && (localObject2 != null)) {
            QSecRptControllerImpl.a(this.this$0, (SafeReport.ReqBody)localObject2);
          }
          this.a.removeAllElements();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      break label299;
      label298:
      return;
      label299:
      Object localObject2 = localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */