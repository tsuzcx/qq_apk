package com.tencent.qapmsdk.dns.a;

import java.util.List;
import java.util.Map;

public class c
{
  private static c a = new c();
  private Map<String, List<String>> b;
  
  public static c a()
  {
    return a;
  }
  
  public List<String> a(String paramString)
  {
    Map localMap = this.b;
    if (localMap != null) {
      return (List)localMap.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.a.c
 * JD-Core Version:    0.7.0.1
 */