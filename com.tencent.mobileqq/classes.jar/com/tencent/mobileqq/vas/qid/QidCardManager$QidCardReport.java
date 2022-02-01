package com.tencent.mobileqq.vas.qid;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QidCardManager$QidCardReport
{
  public static int a;
  public static int b;
  static Map<String, QidCardManager.QidCardReport.ReportData> c = new HashMap();
  
  static
  {
    c.put("svip_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(2, 2));
    c.put("svip_pag.pag", new QidCardManager.QidCardReport.ReportData(2, 1));
    c.put("comm_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(1, 2));
    c.put("comm_pag.pag", new QidCardManager.QidCardReport.ReportData(1, 1));
    c.put("activity_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(3, 2));
    c.put("activity_pag.pag", new QidCardManager.QidCardReport.ReportData(3, 1));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.endsWith(str))
      {
        paramString = (QidCardManager.QidCardReport.ReportData)c.get(str);
        b = paramString.a;
        a = paramString.b;
        return;
      }
    }
    b = 10;
    a = 10;
  }
  
  public static void b(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "", paramString, 0, 0, String.valueOf(b), String.valueOf(a), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport
 * JD-Core Version:    0.7.0.1
 */