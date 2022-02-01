package com.tencent.mobileqq.flashshow.report.datong;

import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FSDaTongLoginReporter
{
  public static void a()
  {
    QLog.i("FSDaTongLoginReporter", 1, "thirdTabClickLoginReport");
    FSThreadUtils.a(new FSDaTongLoginReporter.1());
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    QLog.i("FSDaTongLoginReporter", 1, "schemaLoginReport");
    FSThreadUtils.a(new FSDaTongLoginReporter.2(paramHashMap));
  }
  
  private static void c(HashMap<String, String> paramHashMap, Map<String, Object> paramMap)
  {
    if (paramHashMap != null)
    {
      if (paramMap == null) {
        return;
      }
      String str = (String)paramHashMap.get("key_scheme");
      if (str == null) {
        return;
      }
      paramHashMap = str;
      if (str.length() > 500) {
        paramHashMap = str.substring(0, 500);
      }
      paramMap.put("ks_schema", paramHashMap);
    }
  }
  
  private static boolean c(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return false;
    }
    if (!paramHashMap.containsKey("ks_is_innerjump")) {
      return false;
    }
    paramHashMap = (String)paramHashMap.get("ks_is_innerjump");
    int i;
    try
    {
      i = Integer.parseInt(paramHashMap);
    }
    catch (NumberFormatException paramHashMap)
    {
      paramHashMap.printStackTrace();
      i = 0;
    }
    return i == 1;
  }
  
  private static void d(HashMap<String, String> paramHashMap, Map<String, Object> paramMap)
  {
    if (paramHashMap != null)
    {
      if (paramMap == null) {
        return;
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        paramMap.put(localEntry.getKey(), localEntry.getValue());
      }
      if (!paramMap.containsKey("ks_main_entrance")) {
        paramMap.put("ks_main_entrance", "others");
      }
      if (!paramMap.containsKey("ks_sub_entrance")) {
        paramMap.put("ks_sub_entrance", "default");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.datong.FSDaTongLoginReporter
 * JD-Core Version:    0.7.0.1
 */