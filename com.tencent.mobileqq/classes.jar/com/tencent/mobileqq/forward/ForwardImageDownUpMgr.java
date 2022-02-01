package com.tencent.mobileqq.forward;

import java.util.HashMap;
import java.util.Map;

public class ForwardImageDownUpMgr
{
  private static ForwardImageDownUpMgr a;
  private Map<String, String> b = new HashMap();
  
  public static ForwardImageDownUpMgr a()
  {
    if (a == null) {
      a = new ForwardImageDownUpMgr();
    }
    return a;
  }
  
  public static String a(String paramString)
  {
    ForwardImageDownUpMgr localForwardImageDownUpMgr = a;
    if (localForwardImageDownUpMgr == null) {
      return null;
    }
    paramString = (String)localForwardImageDownUpMgr.b.remove(paramString);
    if (a.b.isEmpty()) {
      a = null;
    }
    return paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardImageDownUpMgr
 * JD-Core Version:    0.7.0.1
 */