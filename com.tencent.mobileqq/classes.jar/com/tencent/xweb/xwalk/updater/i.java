package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class i
  extends XWebCoreScheduler
{
  static i a;
  
  public static XWebCoreScheduler y()
  {
    if (a == null) {
      a = new i();
    }
    return a;
  }
  
  public c a(a.b paramb)
  {
    StringBuilder localStringBuilder1 = null;
    if (paramb != null)
    {
      String str = a.a("pre_down_abi", "tools");
      Object localObject = this.b;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("predown load abi is ");
      localStringBuilder2.append(str);
      XWalkInitializer.addXWalkInitializeLog((String)localObject, localStringBuilder2.toString());
      localObject = localStringBuilder1;
      if (!TextUtils.isEmpty(str))
      {
        localObject = localStringBuilder1;
        if (!str.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))
        {
          paramb = d.a(paramb, str);
          localObject = paramb;
          if (paramb != null)
          {
            h.a(577L, 240L, 1L);
            localObject = paramb;
          }
        }
      }
      int i = 0;
      if (localObject != null)
      {
        paramb = this.b;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("use pre down load abi schedule:");
        localStringBuilder1.append(((c)localObject).l);
        XWalkInitializer.addXWalkInitializeLog(paramb, localStringBuilder1.toString());
        i = 1;
      }
      paramb = a((c)localObject);
      if ((i != 0) && (paramb == localObject))
      {
        if ("armeabi-v7a".equalsIgnoreCase(((c)localObject).t))
        {
          h.a(577L, 236L, 1L);
          return paramb;
        }
        if ("arm64-v8a".equalsIgnoreCase(((c)localObject).t)) {
          h.a(577L, 237L, 1L);
        }
      }
      return paramb;
    }
    return null;
  }
  
  public String a()
  {
    return "XWebCorePredown";
  }
  
  protected boolean i()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.i
 * JD-Core Version:    0.7.0.1
 */