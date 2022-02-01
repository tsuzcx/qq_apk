package com.tencent.xweb;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xwalk.core.Log;

public class q
{
  static List<String> a = new ArrayList();
  static List<String> b = new ArrayList();
  static HashSet<String> c = new HashSet();
  static HashSet<String> d = new HashSet();
  static boolean e;
  
  static
  {
    b();
  }
  
  static List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split(",");
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return localArrayList;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence.trim());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    try
    {
      e = false;
      a = new ArrayList();
      b = new ArrayList();
      c = new HashSet();
      d = new HashSet();
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static boolean b()
  {
    String str1;
    String str2;
    String str3;
    String str4;
    label105:
    try
    {
      bool = e;
      if (bool) {
        return true;
      }
    }
    finally {}
    try
    {
      str1 = a.a("white_list_host_suffix", "toolsmp");
      str2 = a.a("black_list_host_suffix", "toolsmp");
      str3 = a.a("white_list_host", "toolsmp");
      str4 = a.a("black_list_host", "toolsmp");
      a.addAll(a(str1));
      b.addAll(a(str2));
      c.addAll(a(str3));
      d.addAll(a(str4));
      e = true;
    }
    catch (Exception localException)
    {
      break label105;
    }
    Log.e("UrlDispatcher", "init failed ");
    boolean bool = e;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.q
 * JD-Core Version:    0.7.0.1
 */