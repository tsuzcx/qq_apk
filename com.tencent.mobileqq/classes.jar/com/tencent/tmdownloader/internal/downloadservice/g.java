package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.table.d;
import java.util.HashMap;

public class g
{
  protected static g a;
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
    Object localObject = d.a();
    String str = (String)((HashMap)localObject).get("isTaskAutoResume");
    if ((str != null) && (str.length() > 0)) {
      this.b = (str.equals("false") ^ true);
    }
    str = (String)((HashMap)localObject).get("isDownloadWifiOnly");
    if ((str != null) && (str.length() > 0)) {
      this.c = (str.equals("false") ^ true);
    }
    localObject = (String)((HashMap)localObject).get("maxTaskNum");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.d = Integer.valueOf((String)localObject).intValue();
    }
  }
  
  public void a(int paramInt)
  {
    g localg = a;
    if (localg.d == paramInt) {
      return;
    }
    localg.d = paramInt;
    d.a("maxTaskNum", String.valueOf(paramInt), "Integer");
  }
  
  public void a(boolean paramBoolean)
  {
    g localg = a;
    if (localg.b == paramBoolean) {
      return;
    }
    localg.b = paramBoolean;
    d.a("isTaskAutoResume", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAutoDownload downloadInfoNetType = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",currentNetType = ");
    localStringBuilder.append(paramString2);
    ab.c("DownloadSetting", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (paramString2.equalsIgnoreCase("WIFI")) {
      return true;
    }
    return (paramString2.contains("net")) && (!paramString1.equalsIgnoreCase("WIFI"));
  }
  
  public void b(boolean paramBoolean)
  {
    g localg = a;
    if (localg.c == paramBoolean) {
      return;
    }
    localg.c = paramBoolean;
    d.a("isDownloadWifiOnly", String.valueOf(paramBoolean), "boolean");
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAutoPause downloadInfoNetType = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",currentNetType = ");
    localStringBuilder.append(paramString2);
    ab.c("DownloadSetting", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return (paramString1.equalsIgnoreCase("WIFI")) && (!paramString2.equalsIgnoreCase("WIFI"));
  }
  
  public boolean c()
  {
    if (this.b)
    {
      String str = b.a();
      if ((str.contains("wifi")) || (str.contains("net"))) {
        return true;
      }
    }
    else if (b.a().contains("wifi"))
    {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.g
 * JD-Core Version:    0.7.0.1
 */