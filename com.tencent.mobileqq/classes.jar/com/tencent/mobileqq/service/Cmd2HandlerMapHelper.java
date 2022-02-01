package com.tencent.mobileqq.service;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class Cmd2HandlerMapHelper
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static Map<String, Set<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  
  private static Map<String, String[]> a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMobileQQService();
      if (localObject != null)
      {
        localObject = ((MobileQQServiceBase)localObject).getCompatibleCmd2HandlerMap();
        a(jdField_a_of_type_JavaUtilMap, (Map)localObject);
      }
      jdField_a_of_type_Boolean = true;
    }
    return null;
  }
  
  protected static Set<String> a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a();
      paramString = (Set)jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilMap.isEmpty()) {
          a();
        }
        if (paramString2 != null)
        {
          jdField_a_of_type_JavaUtilMap.put(paramString1, new HashSet(Arrays.asList(new String[] { paramString2 })));
          return;
        }
      }
      ((Set)jdField_a_of_type_JavaUtilMap.get(paramString1)).add(paramString2);
    }
  }
  
  public static void a(String paramString, Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return;
    }
    for (;;)
    {
      String str;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        paramSet = paramSet.iterator();
        if (!paramSet.hasNext()) {
          break;
        }
        str = (String)paramSet.next();
        Set localSet = (Set)jdField_a_of_type_JavaUtilMap.get(str);
        if (localSet != null) {
          localSet.add(paramString);
        }
      }
      jdField_a_of_type_JavaUtilMap.put(str, new Cmd2HandlerMapHelper.1(paramString));
    }
  }
  
  public static void a(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilMap.isEmpty()) {
          a();
        }
        if (paramArrayOfString != null)
        {
          jdField_a_of_type_JavaUtilMap.put(paramString, new HashSet(Arrays.asList(paramArrayOfString)));
          return;
        }
      }
      jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  private static void a(Map<String, Set<String>> paramMap, Map<String, String[]> paramMap1)
  {
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Object localObject = (Map.Entry)paramMap1.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String[])((Map.Entry)localObject).getValue();
      if (localObject != null)
      {
        Set localSet = (Set)paramMap.get(str);
        if (localSet == null) {
          paramMap.put(str, new HashSet(Arrays.asList((Object[])localObject)));
        } else {
          localSet.addAll(new HashSet(Arrays.asList((Object[])localObject)));
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.Cmd2HandlerMapHelper
 * JD-Core Version:    0.7.0.1
 */