package com.tencent.mobileqq.transfile.dns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class IpData
{
  public int a;
  public String a;
  public int b;
  
  public IpData() {}
  
  public IpData(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static String a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IpData localIpData = (IpData)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localIpData.jdField_a_of_type_JavaLangString);
        if (localIpData.jdField_a_of_type_Int != 0) {
          localJSONObject.put("p", localIpData.jdField_a_of_type_Int);
        }
        if (localIpData.b != 0) {
          localJSONObject.put("f", localIpData.b);
        }
        localJSONArray.put(localJSONObject);
      }
      paramList = localJSONArray.toString();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    return paramList;
  }
  
  public static ArrayList a(String paramString)
  {
    int i = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray(paramString);
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        localArrayList.add(new IpData(paramString.getString("i"), paramString.optInt("p", 0), paramString.optInt("f", 0)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.IpData
 * JD-Core Version:    0.7.0.1
 */