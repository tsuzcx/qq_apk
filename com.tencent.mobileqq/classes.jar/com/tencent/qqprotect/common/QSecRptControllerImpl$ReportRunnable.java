package com.tencent.qqprotect.common;

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
  private Vector<QSecRptItem> a = new Vector();
  
  private QSecRptControllerImpl$ReportRunnable(QSecRptControllerImpl paramQSecRptControllerImpl) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          if (this.a.isEmpty()) {
            return;
          }
          Object localObject1 = new SafeReport.ReqBody();
          Iterator localIterator = this.a.iterator();
          break label332;
          if (localIterator.hasNext())
          {
            Object localObject3 = (QSecRptItem)localIterator.next();
            if (localObject3 == null) {
              continue;
            }
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new SafeReport.ReqBody();
            }
            String str = QSecRptController.a(QSecRptController.a(((QSecRptItem)localObject3).jdField_a_of_type_Int));
            localObject2 = new SafeReport.LogItem();
            ((SafeReport.LogItem)localObject2).uint32_rpt_id.set(((QSecRptItem)localObject3).jdField_a_of_type_Int);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(",");
            localStringBuilder.append(((QSecRptItem)localObject3).b);
            localStringBuilder.append(",");
            localStringBuilder.append(((QSecRptItem)localObject3).jdField_a_of_type_JavaLangString);
            localObject3 = localStringBuilder.toString();
            ((SafeReport.LogItem)localObject2).bytes_rpt_data.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
            ((SafeReport.ReqBody)localObject1).LogItem_reportdata.add((MessageMicro)localObject2);
            int k = i + 1;
            int m = j + ((String)localObject3).length();
            if (k != 20)
            {
              i = k;
              localObject2 = localObject1;
              j = m;
              if (m <= 1024) {
                continue;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("QSRPT", 2, String.format("sending...item count: %d, package size: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) }));
            }
            QSecRptControllerImpl.a(this.this$0, (SafeReport.ReqBody)localObject1);
            localObject1 = null;
          }
          else
          {
            if ((i > 0) && (localObject2 != null)) {
              QSecRptControllerImpl.a(this.this$0, (SafeReport.ReqBody)localObject2);
            }
            this.a.removeAllElements();
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label332:
      int i = 0;
      int j = 0;
      Object localObject2 = localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */