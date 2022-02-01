package com.tencent.mobileqq.transfile.dns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class DomainData
{
  public static final String DOMAIN_NAME = "n";
  public static final String IP_LIST = "l";
  public String mDomain;
  public ArrayList<IpData> mIpList;
  
  public DomainData(String paramString, ArrayList<IpData> paramArrayList)
  {
    this.mDomain = paramString;
    this.mIpList = paramArrayList;
  }
  
  public static String parse(HashMap<String, DomainData> paramHashMap)
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
        localJSONObject.put("n", localDomainData.mDomain);
        localJSONObject.put("l", IpData.parse(localDomainData.mIpList));
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
  
  public static HashMap<String, DomainData> unParse(String paramString)
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
        localHashMap.put(str, new DomainData(str, IpData.unParse(paramString.getString("l"))));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.DomainData
 * JD-Core Version:    0.7.0.1
 */