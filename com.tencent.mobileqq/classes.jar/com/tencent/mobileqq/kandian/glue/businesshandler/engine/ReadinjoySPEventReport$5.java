package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadinjoySPEventReport$5
  implements Runnable
{
  ReadinjoySPEventReport$5(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = ReadinjoySPEventReport.a(this.this$0);
    Object localObject1 = Integer.valueOf(0);
    if (localObject2 != null)
    {
      if (((Integer)ReadinjoySPEventReport.a(this.this$0).second).intValue() == this.a) {
        return;
      }
      if (((Integer)ReadinjoySPEventReport.a(this.this$0).second).intValue() >= this.a)
      {
        i = 0;
        break label77;
      }
    }
    int i = 1;
    label77:
    int j = ReadinjoySPEventReport.b(this.this$0).size();
    long l1 = j;
    if (l1 > ReadInJoyHelper.am(RIJQQAppInterfaceUtil.e())) {
      for (l1 -= ReadInJoyHelper.am(RIJQQAppInterfaceUtil.e()); l1 > 0L; l1 -= 1L) {
        if (ReadinjoySPEventReport.b(this.this$0).size() > 1) {
          ReadinjoySPEventReport.b(this.this$0).remove(1);
        }
      }
    }
    ReadinjoySPEventReport.a(this.this$0, false);
    if (j == 0) {
      ReadinjoySPEventReport.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), localObject1));
    }
    ReadinjoySPEventReport.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.a)));
    ReadinjoySPEventReport.b(this.this$0).add(ReadinjoySPEventReport.a(this.this$0));
    localObject2 = ReadinjoySPEventReport.class.getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update msg tab total red pnt change, cnt : ");
    localStringBuilder.append(this.a);
    QLog.d((String)localObject2, 2, localStringBuilder.toString());
    int k = RIJMergeKanDianMessage.b();
    if (k < 0) {
      return;
    }
    int m = this.a;
    j = k;
    if (k > m) {
      j = m;
    }
    k = ReadinjoySPEventReport.c(this.this$0).size();
    l1 = k;
    if (l1 > ReadInJoyHelper.an(RIJQQAppInterfaceUtil.e())) {
      for (l1 -= ReadInJoyHelper.an(RIJQQAppInterfaceUtil.e()); l1 > 0L; l1 -= 1L) {
        if (ReadinjoySPEventReport.c(this.this$0).size() > 1) {
          ReadinjoySPEventReport.c(this.this$0).remove(1);
        }
      }
    }
    if ((ReadinjoySPEventReport.d(this.this$0) != null) && (((Integer)ReadinjoySPEventReport.d(this.this$0).second).intValue() == j)) {
      return;
    }
    if (k == 0) {
      ReadinjoySPEventReport.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), localObject1));
    }
    ReadinjoySPEventReport.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
    ReadinjoySPEventReport.c(this.this$0).add(ReadinjoySPEventReport.d(this.this$0));
    localObject1 = ReadinjoySPEventReport.class.getSimpleName();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("update msg tab first screen red pnt change, cnt : ");
    ((StringBuilder)localObject2).append(j);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    j = ReadInJoyHelper.y();
    if ((this.a <= j) && (!ReadinjoySPEventReport.e(this.this$0)) && (i == 0))
    {
      if ((ReadinjoySPEventReport.f(this.this$0) != null) && (ReadinjoySPEventReport.f(this.this$0).size() > 0))
      {
        i = ((Integer)((Pair)ReadinjoySPEventReport.f(this.this$0).get(ReadinjoySPEventReport.f(this.this$0).size() - 1)).second).intValue();
        l1 = ((Long)((Pair)ReadinjoySPEventReport.f(this.this$0).get(0)).first).longValue();
        long l2 = ((Long)((Pair)ReadinjoySPEventReport.f(this.this$0).get(ReadinjoySPEventReport.f(this.this$0).size() - 1)).first).longValue();
        if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
        {
          ReadinjoySPEventReport.a(this.this$0, true);
          return;
        }
      }
      if (ReadinjoySPEventReport.g(this.this$0) == null) {
        ReadinjoySPEventReport.a(this.this$0, 0);
      } else {
        ReadinjoySPEventReport.h(this.this$0);
      }
    }
    ReadinjoySPEventReport.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.5
 * JD-Core Version:    0.7.0.1
 */