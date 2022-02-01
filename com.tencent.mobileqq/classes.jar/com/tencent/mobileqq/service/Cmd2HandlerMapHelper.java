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

public class Cmd2HandlerMapHelper
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static Map<String, Set<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  
  private static Map<String, String[]> a(AppInterface paramAppInterface)
  {
    if ((!jdField_a_of_type_Boolean) && (paramAppInterface != null))
    {
      paramAppInterface = paramAppInterface.getMobileQQService();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getCompatibleCmd2HandlerMap();
        a(jdField_a_of_type_JavaUtilMap, paramAppInterface);
      }
      jdField_a_of_type_Boolean = true;
    }
    return null;
  }
  
  protected static Set<String> a(AppInterface paramAppInterface, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a(paramAppInterface);
      paramAppInterface = (Set)jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramAppInterface;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Set localSet = (Set)jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (localSet == null) {
          jdField_a_of_type_JavaUtilMap.put(paramString1, new HashSet(Arrays.asList(new String[] { paramString2 })));
        } else {
          localSet.add(paramString2);
        }
        return;
      }
    }
  }
  
  public static void a(String paramString, Set<String> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          Set localSet = (Set)jdField_a_of_type_JavaUtilMap.get(str);
          if (localSet != null) {
            localSet.add(paramString);
          } else {
            jdField_a_of_type_JavaUtilMap.put(str, new Cmd2HandlerMapHelper.1(paramString));
          }
        }
        return;
      }
    }
  }
  
  public static void a(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangObject;
    if (paramArrayOfString != null) {}
    try
    {
      jdField_a_of_type_JavaUtilMap.put(paramString, new HashSet(Arrays.asList(paramArrayOfString)));
      break label52;
      jdField_a_of_type_JavaUtilMap.remove(paramString);
      label52:
      return;
    }
    finally {}
  }
  
  private static void a(Map<String, Set<String>> paramMap, Map<String, String[]> paramMap1)
  {
    if (paramMap != null)
    {
      if (paramMap1 == null) {
        return;
      }
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
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.Cmd2HandlerMapHelper
 * JD-Core Version:    0.7.0.1
 */