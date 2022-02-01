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
  static Map<String, QidCardManager.QidCardReport.ReportData> a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 0;
    b = 0;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("svip_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(2, 2));
    jdField_a_of_type_JavaUtilMap.put("svip_pag.pag", new QidCardManager.QidCardReport.ReportData(2, 1));
    jdField_a_of_type_JavaUtilMap.put("comm_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(1, 2));
    jdField_a_of_type_JavaUtilMap.put("comm_pag.pag", new QidCardManager.QidCardReport.ReportData(1, 1));
    jdField_a_of_type_JavaUtilMap.put("activity_qidbg_pag.pag", new QidCardManager.QidCardReport.ReportData(3, 2));
    jdField_a_of_type_JavaUtilMap.put("activity_pag.pag", new QidCardManager.QidCardReport.ReportData(3, 1));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.endsWith(str))
      {
        paramString = (QidCardManager.QidCardReport.ReportData)jdField_a_of_type_JavaUtilMap.get(str);
        b = paramString.jdField_a_of_type_Int;
        jdField_a_of_type_Int = paramString.b;
        return;
      }
    }
    b = 10;
    jdField_a_of_type_Int = 10;
  }
  
  public static void b(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "", paramString, 0, 0, String.valueOf(b), String.valueOf(jdField_a_of_type_Int), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport
 * JD-Core Version:    0.7.0.1
 */