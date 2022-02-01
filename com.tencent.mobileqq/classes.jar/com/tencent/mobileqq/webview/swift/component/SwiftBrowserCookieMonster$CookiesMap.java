package com.tencent.mobileqq.webview.swift.component;

import java.util.ArrayList;
import java.util.Hashtable;

public class SwiftBrowserCookieMonster$CookiesMap
  extends Hashtable<String, ArrayList<String>>
{
  public void addCookie(String paramString1, String paramString2)
  {
    try
    {
      getCookies(paramString1).add(paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public ArrayList<String> getCookies(String paramString)
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        put(paramString, localArrayList1);
      }
      return localArrayList1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.CookiesMap
 * JD-Core Version:    0.7.0.1
 */