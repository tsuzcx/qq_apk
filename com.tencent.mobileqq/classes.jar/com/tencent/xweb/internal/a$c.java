package com.tencent.xweb.internal;

import android.text.TextUtils;
import org.xwalk.core.XWalkEnvironment;

public class a$c
  extends a.b
{
  static String J;
  
  public static void b(String paramString)
  {
    J = paramString;
  }
  
  public static boolean e()
  {
    return XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(J) ^ true;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(J)) {
      return J;
    }
    return super.a();
  }
  
  protected boolean c()
  {
    return XWalkEnvironment.is64BitRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.a.c
 * JD-Core Version:    0.7.0.1
 */