package com.tencent.mqpsdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class NetUtil
{
  public static String a = "ctnet";
  public static String b = "ctwap";
  public static String c = "cmnet";
  public static String d = "cmwap";
  public static String e = "uninet";
  public static String f = "uniwap";
  public static String g = "3gnet";
  public static String h = "3gwap";
  
  public static int a(Context paramContext)
  {
    int j = AppNetConnInfo.getConnInfo();
    int i = 1;
    if (j != 0)
    {
      if (j == 1) {}
    }
    else
    {
      do
      {
        i = 0;
        break label54;
        i = AppNetConnInfo.getMobileInfo();
        if (i == 1) {
          break label52;
        }
        if (i == 2) {
          break;
        }
      } while (i != 3);
      i = 4;
      break label54;
      i = 3;
      break label54;
      label52:
      i = 2;
    }
    label54:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getNetType ");
      paramContext.append(i);
      QLog.i("NetUtil", 2, paramContext.toString());
    }
    return i;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = AppNetConnInfo.getCurrentAPN();
    if (!TextUtils.isEmpty(paramContext))
    {
      if (paramContext.startsWith(a)) {
        return a;
      }
      if (paramContext.startsWith(b)) {
        return b;
      }
      if (paramContext.startsWith(c)) {
        return c;
      }
      if (paramContext.startsWith(d)) {
        return d;
      }
      if (paramContext.startsWith(e)) {
        return e;
      }
      if (paramContext.startsWith(f)) {
        return f;
      }
      if (paramContext.startsWith(g)) {
        return g;
      }
      if (paramContext.startsWith(h)) {
        return h;
      }
    }
    return "nomatch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqpsdk.util.NetUtil
 * JD-Core Version:    0.7.0.1
 */