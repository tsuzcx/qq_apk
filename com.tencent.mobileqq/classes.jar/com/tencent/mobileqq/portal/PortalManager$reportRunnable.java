package com.tencent.mobileqq.portal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import bkfu;
import com.tencent.qphone.base.util.QLog;
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
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) || (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() <= 0)) {
      return;
    }
    int i = 0;
    label20:
    Object localObject1;
    Object localObject2;
    int j;
    label171:
    int k;
    if (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject1 = new ArrayList(100);
      localObject2 = new bkfu(60);
      int m = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i);
      Object localObject3 = ((ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(m)).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject3).next();
        if (this.jdField_a_of_type_Int == 1) {}
        for (j = 1000;; j = 60000)
        {
          l = localLong.longValue() / j * j;
          if (((bkfu)localObject2).a(l) == null) {
            break label171;
          }
          ((bkfu)localObject2).a(l, Integer.valueOf(((Integer)((bkfu)localObject2).a(l)).intValue() + 1));
          break;
        }
        ((bkfu)localObject2).a(l, Integer.valueOf(1));
      }
      k = 0;
      j = 0;
      while (k < ((bkfu)localObject2).a())
      {
        localObject3 = new RedPacketServlet.BrashReportItem();
        l = ((bkfu)localObject2).a(k);
        ((RedPacketServlet.BrashReportItem)localObject3).time = l;
        ((RedPacketServlet.BrashReportItem)localObject3).count = ((int)((Integer)((bkfu)localObject2).a(l)).intValue());
        ((ArrayList)localObject1).add(localObject3);
        j += ((RedPacketServlet.BrashReportItem)localObject3).count;
        k += 1;
      }
      localObject2 = PortalManager.a(this.this$0);
      if (this.jdField_a_of_type_Int != 1) {
        break label510;
      }
      k = 1;
      label284:
      localObject2 = ((Handler)localObject2).obtainMessage(14, m, k, localObject1);
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject3 = new Bundle();
        if (this.b > 0) {
          ((Bundle)localObject3).putInt("k_e_ctr", this.b);
        }
        if (this.c > 0) {
          ((Bundle)localObject3).putInt("k_h_ctr", this.c);
        }
        if (this.d > 0) {
          ((Bundle)localObject3).putInt("k_c_ctr", this.d);
        }
        ((Bundle)localObject3).putLong("k_s_time", this.jdField_a_of_type_Long);
        ((Message)localObject2).setData((Bundle)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "reportRunnable " + this.b + ", " + this.c + ", " + this.d + ", " + j);
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label521;
      }
      localObject3 = PortalManager.a(this.this$0);
      j = ((Message)localObject2).arg1;
      if (((Message)localObject2).arg2 != 1) {
        break label515;
      }
      bool = true;
      RedPacketServlet.a((AppRuntime)localObject3, j, (ArrayList)localObject1, bool, ((Message)localObject2).getData());
    }
    label510:
    while (PortalManager.a(this.this$0)) {
      for (;;)
      {
        i += 1;
        break label20;
        break;
        k = 0;
        break label284;
        boolean bool = false;
      }
    }
    label515:
    label521:
    if (this.jdField_a_of_type_Int == 1)
    {
      l = PortalManager.b;
      label544:
      j = (int)l;
      localObject1 = PortalManager.a(this.this$0);
      if (j > 0) {
        break label585;
      }
    }
    label585:
    for (long l = 0L;; l = new Random().nextInt(j))
    {
      ((Handler)localObject1).sendMessageDelayed((Message)localObject2, l);
      break;
      l = PortalManager.c;
      break label544;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.reportRunnable
 * JD-Core Version:    0.7.0.1
 */