package com.tencent.qapmsdk.dns.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDnsManager
{
  private static LocalDnsManager sInstance = new LocalDnsManager();
  private Map<String, List<String>> localDnsMap;
  
  public static LocalDnsManager getInstance()
  {
    return sInstance;
  }
  
  public List<String> getIpList(String paramString)
  {
    Map localMap = this.localDnsMap;
    if (localMap != null) {
      return (List)localMap.get(paramString);
    }
    return null;
  }
  
  public void setLocalDnsMap(Map<String, List<String>> paramMap)
  {
    if (paramMap != null) {}
    for (paramMap = new HashMap(paramMap);; paramMap = null)
    {
      this.localDnsMap = paramMap;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.logic.LocalDnsManager
 * JD-Core Version:    0.7.0.1
 */