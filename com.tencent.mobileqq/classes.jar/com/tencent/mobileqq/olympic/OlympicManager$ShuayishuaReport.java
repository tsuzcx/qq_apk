package com.tencent.mobileqq.olympic;

import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import azqs;
import bhsk;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class OlympicManager$ShuayishuaReport
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SparseArrayCompat<ArrayList<Long>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public OlympicManager$ShuayishuaReport(AppRuntime paramAppRuntime, SparseArrayCompat<ArrayList<Long>> paramSparseArrayCompat, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramSparseArrayCompat;
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
    this.c = paramLong;
    this.jdField_a_of_type_Long = ???;
    boolean bool1;
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) || (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() <= 0)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    int k;
    int j;
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
      {
        localArrayList1 = new ArrayList(100);
        localArrayList2 = new ArrayList(60);
        localArrayList3 = new ArrayList(1);
        localArrayList4 = new ArrayList(1);
        Object localObject1 = new bhsk(60);
        k = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i);
        Object localObject2 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(k);
        if (localObject2 != null)
        {
          azqs.b(this.this$0.a, "CliOper", "", "", "0X80069C7", "0X80069C7", 0, 0, this.this$0.a.getCurrentAccountUin(), String.valueOf(((ArrayList)localObject2).size()), "", "");
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject2).next();
            if (this.jdField_a_of_type_Int == 1) {}
            for (j = 1000;; j = 60000)
            {
              l = localLong.longValue() / j * j;
              if (((bhsk)localObject1).a(l) == null) {
                break label253;
              }
              ((bhsk)localObject1).a(l, Integer.valueOf(((Integer)((bhsk)localObject1).a(l)).intValue() + 1));
              break;
            }
            label253:
            ((bhsk)localObject1).a(l, Integer.valueOf(1));
          }
        }
        j = 0;
        if (j < ((bhsk)localObject1).a())
        {
          localObject2 = new OlympicServlet.ReportRecord();
          l = ((bhsk)localObject1).a(j);
          ((OlympicServlet.ReportRecord)localObject2).time_stamp = l;
          ((OlympicServlet.ReportRecord)localObject2).count = ((int)((Integer)((bhsk)localObject1).a(l)).intValue());
          if (this.jdField_a_of_type_Int == 1) {
            localArrayList2.add(localObject2);
          }
          for (;;)
          {
            j += 1;
            break;
            localArrayList1.add(localObject2);
          }
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject1 = new OlympicServlet.ReportRecord();
          ((OlympicServlet.ReportRecord)localObject1).time_stamp = this.jdField_a_of_type_Long;
          ((OlympicServlet.ReportRecord)localObject1).count = this.b;
          localArrayList3.add(localObject1);
          localObject1 = new OlympicServlet.ReportRecord();
          ((OlympicServlet.ReportRecord)localObject1).time_stamp = this.jdField_a_of_type_Long;
          ((OlympicServlet.ReportRecord)localObject1).count = this.c;
          localArrayList4.add(localObject1);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label469;
        }
        OlympicServlet.a(this.jdField_a_of_type_MqqAppAppRuntime, k, localArrayList1, localArrayList2, localArrayList3, localArrayList4, null);
        i += 1;
      }
    }
    label469:
    if (this.jdField_a_of_type_Int == 1) {}
    for (long l = OlympicManager.a(this.this$0);; l = OlympicManager.b(this.this$0))
    {
      j = (int)l;
      OlympicManager.a(this.this$0).postDelayed(new OlympicManager.ShuayishuaReport.1(this, k, localArrayList1, localArrayList2, localArrayList3, localArrayList4), j);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.ShuayishuaReport
 * JD-Core Version:    0.7.0.1
 */