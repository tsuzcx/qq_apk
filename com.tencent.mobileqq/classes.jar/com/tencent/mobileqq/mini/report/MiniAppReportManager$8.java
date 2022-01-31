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
    label133:
    label159:
    label337:
    label340:
    label343:
    label346:
    label347:
    for (;;)
    {
      Object localObject;
      String str4;
      String str3;
      String str1;
      String str2;
      int i;
      if (localIterator1.hasNext())
      {
        localObject = (APP_REPORT_TRANSFER.SingleDcData)localIterator1.next();
        if ((localObject != null) && (((APP_REPORT_TRANSFER.SingleDcData)localObject).report_data != null))
        {
          str4 = "";
          str3 = "";
          Iterator localIterator2 = ((APP_REPORT_TRANSFER.SingleDcData)localObject).report_data.get().iterator();
          str1 = "";
          str2 = "";
          localObject = "";
          i = 0;
          for (;;)
          {
            if (!localIterator2.hasNext()) {
              break label346;
            }
            COMM.Entry localEntry = (COMM.Entry)localIterator2.next();
            if (!"launchid".equals(localEntry.key.get())) {
              break label343;
            }
            localObject = localEntry.value.get();
            if (!"appid".equals(localEntry.key.get())) {
              break label340;
            }
            str2 = localEntry.value.get();
            if (!"sub_actiontype".equals(localEntry.key.get())) {
              break label337;
            }
            str1 = localEntry.value.get();
            if ((!"click".equals(str1)) && (!"load".equals(str1)) && (!"show".equals(str1)) && (!"load_fail".equals(str1)) && (!"show_fail".equals(str1))) {
              break;
            }
            i = 1;
            label231:
            if ("app_type".equals(localEntry.key.get())) {
              str4 = localEntry.value.get();
            }
            if ("app_status".equals(localEntry.key.get())) {
              str3 = localEntry.value.get();
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str2))) {
            break label347;
          }
          localArrayList.add(new MiniAppReportEntity((String)localObject, str2, str1, str4, str3));
          break;
          MiniAppReportManager.access$1000(localArrayList);
          return;
          break label231;
          break label159;
          break label133;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.8
 * JD-Core Version:    0.7.0.1
 */