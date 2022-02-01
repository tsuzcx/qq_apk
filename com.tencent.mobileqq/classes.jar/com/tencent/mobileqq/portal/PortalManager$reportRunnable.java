package com.tencent.mobileqq.portal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import mqq.app.AppRuntime;

public class PortalManager$reportRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SparseArrayCompat<ArrayList<Long>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public PortalManager$reportRunnable(SparseArrayCompat<ArrayList<Long>> paramSparseArrayCompat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.d = paramLong;
    this.jdField_a_of_type_Long = ???;
    boolean bool1;
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
    if (localObject1 != null)
    {
      if (((SparseArrayCompat)localObject1).size() <= 0) {
        return;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
      {
        localObject1 = new ArrayList(100);
        Object localObject2 = new LongSparseArray(60);
        int m = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i);
        Object localObject3 = ((ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(m)).iterator();
        boolean bool1;
        long l1;
        for (;;)
        {
          boolean bool2 = ((Iterator)localObject3).hasNext();
          bool1 = true;
          if (!bool2) {
            break;
          }
          Long localLong = (Long)((Iterator)localObject3).next();
          if (this.jdField_a_of_type_Int == 1) {
            j = 1000;
          } else {
            j = 60000;
          }
          l1 = localLong.longValue();
          long l2 = j;
          l1 = l1 / l2 * l2;
          if (((LongSparseArray)localObject2).a(l1) != null) {
            ((LongSparseArray)localObject2).a(l1, Integer.valueOf(((Integer)((LongSparseArray)localObject2).a(l1)).intValue() + 1));
          } else {
            ((LongSparseArray)localObject2).a(l1, Integer.valueOf(1));
          }
        }
        int k = 0;
        int j = 0;
        while (k < ((LongSparseArray)localObject2).a())
        {
          localObject3 = new RedPacketServlet.BrashReportItem();
          l1 = ((LongSparseArray)localObject2).a(k);
          ((RedPacketServlet.BrashReportItem)localObject3).time = l1;
          ((RedPacketServlet.BrashReportItem)localObject3).count = ((int)((Integer)((LongSparseArray)localObject2).a(l1)).intValue());
          ((ArrayList)localObject1).add(localObject3);
          j += ((RedPacketServlet.BrashReportItem)localObject3).count;
          k += 1;
        }
        localObject2 = PortalManager.a(this.this$0);
        if (this.jdField_a_of_type_Int == 1) {
          k = 1;
        } else {
          k = 0;
        }
        localObject2 = ((Handler)localObject2).obtainMessage(14, m, k, localObject1);
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject3 = new Bundle();
          k = this.b;
          if (k > 0) {
            ((Bundle)localObject3).putInt("k_e_ctr", k);
          }
          k = this.c;
          if (k > 0) {
            ((Bundle)localObject3).putInt("k_h_ctr", k);
          }
          k = this.d;
          if (k > 0) {
            ((Bundle)localObject3).putInt("k_c_ctr", k);
          }
          ((Bundle)localObject3).putLong("k_s_time", this.jdField_a_of_type_Long);
          ((Message)localObject2).setData((Bundle)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("reportRunnable ");
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append(", ");
            ((StringBuilder)localObject3).append(this.c);
            ((StringBuilder)localObject3).append(", ");
            ((StringBuilder)localObject3).append(this.d);
            ((StringBuilder)localObject3).append(", ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("PortalManager", 2, ((StringBuilder)localObject3).toString());
          }
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localObject3 = PortalManager.a(this.this$0);
          j = ((Message)localObject2).arg1;
          if (((Message)localObject2).arg2 != 1) {
            bool1 = false;
          }
          RedPacketServlet.a((AppRuntime)localObject3, j, (ArrayList)localObject1, bool1, ((Message)localObject2).getData());
        }
        else if (!PortalManager.a(this.this$0))
        {
          if (this.jdField_a_of_type_Int == 1) {
            l1 = PortalManager.b;
          } else {
            l1 = PortalManager.c;
          }
          j = (int)l1;
          localObject1 = PortalManager.a(this.this$0);
          if (j <= 0) {
            l1 = 0L;
          } else {
            l1 = new Random().nextInt(j);
          }
          ((Handler)localObject1).sendMessageDelayed((Message)localObject2, l1);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.reportRunnable
 * JD-Core Version:    0.7.0.1
 */