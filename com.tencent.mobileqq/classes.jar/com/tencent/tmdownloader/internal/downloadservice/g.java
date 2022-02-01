package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.table.d;
import java.util.HashMap;

public class g
{
  protected static g a = null;
  protected boolean b = true;
  protected boolean c = false;
  protected int d = 5;
  
  public g()
  {
    d();
  }
  
  public static g a()
  {
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      return localg;
    }
    finally {}
  }
  
  private void d()
  {
    boolean bool2 = false;
    Object localObject = d.a();
    String str = (String)((HashMap)localObject).get("isTaskAutoResume");
    if ((str != null) && (str.length() > 0))
    {
      if (str.equals("false"))
      {
        bool1 = false;
        this.b = bool1;
      }
    }
    else
    {
      str = (String)((HashMap)localObject).get("isDownloadWifiOnly");
      if ((str != null) && (str.length() > 0)) {
        if (!str.equals("false")) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      this.c = bool1;
      localObject = (String)((HashMap)localObject).get("maxTaskNum");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.d = Integer.valueOf((String)localObject).intValue();
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    if (a.d == paramInt) {
      return;
    }
    a.d = paramInt;
    d.a("maxTaskNum", String.valueOf(paramInt), "Integer");
  }
  
  public void a(boolean paramBoolean)
  {
    if (a.b == paramBoolean) {
      return;
    }
    a.b = paramBoolean;
    d.a("isTaskAutoResume", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    ab.c("DownloadSetting", "isAutoDownload downloadInfoNetType = " + paramString1 + ",currentNetType = " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      if (paramString2.equalsIgnoreCase("WIFI")) {
        return true;
      }
    } while ((!paramString2.contains("net")) || (paramString1.equalsIgnoreCase("WIFI")));
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (a.c == paramBoolean) {
      return;
    }
    a.c = paramBoolean;
    d.a("isDownloadWifiOnly", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    ab.c("DownloadSetting", "isAutoPause downloadInfoNetType = " + paramString1 + ",currentNetType = " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    while ((!paramString1.equalsIgnoreCase("WIFI")) || (paramString2.equalsIgnoreCase("WIFI"))) {
      return false;
    }
    return true;
  }
  
  public boolean c()
  {
    if (this.b)
    {
      str = b.a();
      if ((!str.contains("wifi")) && (!str.contains("net"))) {}
    }
    else
    {
      while (b.a().contains("wifi"))
      {
        String str;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.g
 * JD-Core Version:    0.7.0.1
 */