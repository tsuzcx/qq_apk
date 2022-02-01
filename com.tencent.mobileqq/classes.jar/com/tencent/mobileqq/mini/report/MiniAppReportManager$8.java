package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MiniAppReportManager$8
  implements Runnable
{
  MiniAppReportManager$8(List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.val$singleDcDataList.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject1 = (APP_REPORT_TRANSFER.SingleDcData)localIterator1.next();
      if ((localObject1 != null) && (((APP_REPORT_TRANSFER.SingleDcData)localObject1).report_data != null))
      {
        int i = 0;
        Iterator localIterator2 = ((APP_REPORT_TRANSFER.SingleDcData)localObject1).report_data.get().iterator();
        Object localObject5 = "";
        Object localObject3 = "";
        localObject1 = localObject3;
        Object localObject2 = localObject1;
        Object localObject6 = localObject2;
        Object localObject7 = localObject2;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        for (;;)
        {
          localObject8 = localObject5;
          localObject9 = localObject3;
          localObject10 = localObject1;
          if (!localIterator2.hasNext()) {
            break;
          }
          COMM.Entry localEntry = (COMM.Entry)localIterator2.next();
          localObject2 = localObject5;
          if ("launchid".equals(localEntry.key.get())) {
            localObject2 = localEntry.value.get();
          }
          Object localObject4 = localObject3;
          if ("appid".equals(localEntry.key.get())) {
            localObject4 = localEntry.value.get();
          }
          int j = i;
          localObject8 = localObject1;
          if ("sub_actiontype".equals(localEntry.key.get()))
          {
            localObject1 = localEntry.value.get();
            if ((!"click".equals(localObject1)) && (!"load".equals(localObject1)) && (!"show".equals(localObject1)) && (!"load_fail".equals(localObject1)))
            {
              localObject8 = localObject2;
              localObject9 = localObject4;
              localObject10 = localObject1;
              if (!"show_fail".equals(localObject1)) {
                break;
              }
            }
            j = 1;
            localObject8 = localObject1;
          }
          localObject9 = localObject7;
          if ("app_type".equals(localEntry.key.get())) {
            localObject9 = localEntry.value.get();
          }
          i = j;
          localObject5 = localObject2;
          localObject3 = localObject4;
          localObject1 = localObject8;
          localObject7 = localObject9;
          if ("app_status".equals(localEntry.key.get()))
          {
            localObject6 = localEntry.value.get();
            i = j;
            localObject5 = localObject2;
            localObject3 = localObject4;
            localObject1 = localObject8;
            localObject7 = localObject9;
          }
        }
        if ((i != 0) && (!TextUtils.isEmpty(localObject8)) && (!TextUtils.isEmpty((CharSequence)localObject9))) {
          localArrayList.add(new MiniAppReportEntity(localObject8, (String)localObject9, localObject10, localObject7, (String)localObject6));
        }
      }
    }
    MiniAppReportManager.access$1000(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.8
 * JD-Core Version:    0.7.0.1
 */