package com.tencent.mobileqq.transfile.dns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class DomainData
{
  public String a;
  public ArrayList a;
  
  public DomainData(String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public static String a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        DomainData localDomainData = (DomainData)paramHashMap.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", localDomainData.jdField_a_of_type_JavaLangString);
        localJSONObject.put("l", IpData.a(localDomainData.jdField_a_of_type_JavaUtilArrayList));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      return null;
    }
    return paramHashMap;
  }
  
  public static HashMap a(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localHashMap;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        String str = paramString.getString("n");
        localHashMap.put(str, new DomainData(str, IpData.a(paramString.getString("l"))));
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.DomainData
 * JD-Core Version:    0.7.0.1
 */