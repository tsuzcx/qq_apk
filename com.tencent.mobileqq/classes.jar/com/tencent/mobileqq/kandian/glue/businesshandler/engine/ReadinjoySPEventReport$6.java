package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadinjoySPEventReport$6
  implements Runnable
{
  ReadinjoySPEventReport$6(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l;
      try
      {
        int i = ReadinjoySPEventReport.c(this.this$0).size();
        l = i;
        if (l > ReadInJoyHelper.c(RIJQQAppInterfaceUtil.a()))
        {
          l -= ReadInJoyHelper.c(RIJQQAppInterfaceUtil.a());
          if (l > 0L)
          {
            if (ReadinjoySPEventReport.c(this.this$0).size() <= 1) {
              break label308;
            }
            ReadinjoySPEventReport.c(this.this$0).remove(1);
            break label308;
          }
        }
        if (i == 0) {
          ReadinjoySPEventReport.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ReadinjoySPEventReport.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        String str = ReadinjoySPEventReport.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add aio enter or out info, type : ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d(str, 2, localStringBuilder.toString());
        if (this.jdField_a_of_type_JavaUtilList != null) {
          ReadinjoySPEventReport.a(this.this$0, ReadinjoySPEventReport.a(this.this$0, this.jdField_a_of_type_JavaUtilList));
        }
        if ((this.jdField_a_of_type_Int == 0) && (ReadinjoySPEventReport.b(this.this$0)))
        {
          ReadinjoySPEventReport.a(this.this$0, false);
          if (ReadinjoySPEventReport.a(this.this$0) != null)
          {
            ReadinjoySPEventReport.a(this.this$0);
            return;
          }
          ReadinjoySPEventReport.a(this.this$0, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label308:
      l -= 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.6
 * JD-Core Version:    0.7.0.1
 */