package com.tencent.xweb.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a$b
{
  public int A = -1;
  public String B = null;
  public String C = null;
  public String D = null;
  public String E = null;
  public int F = -1;
  public int G = -1;
  public String H;
  public String I;
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public String k = "";
  public String l = "";
  public int m = -1;
  public int n = -1;
  public int o = -1;
  public int p = -1;
  public int q = -1;
  public int r = -1;
  public int s = -1;
  public double t = -1.0D;
  public double u = -1.0D;
  public String v = "";
  public String w = "";
  public int x = -1;
  public int y = -1;
  public int z = -1;
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {
      return false;
    }
    return (paramInt2 <= 0) || (paramInt1 >= paramInt2);
  }
  
  static boolean a(String paramString)
  {
    Object localObject2 = Build.BRAND;
    Object localObject1 = "";
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(Build.BRAND);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (Build.MODEL != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(Build.MODEL);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (Build.MANUFACTURER != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if ((paramString != null) && (localObject1 != null) && (!paramString.isEmpty())) {
      return b(paramString, (String)localObject1);
    }
    return false;
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    paramString1 = paramString1.split("\\|");
    if (paramString1 != null)
    {
      if (paramString1.length < 0) {
        return false;
      }
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString2 = paramString2.trim();
      int i2 = paramString1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        CharSequence localCharSequence = paramString1[i1];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.trim().equalsIgnoreCase(paramString2))) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  static boolean b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString1.trim() != null))
    {
      if (paramString1.trim().isEmpty()) {
        return false;
      }
      if (paramString2 != null) {
        if (paramString2.isEmpty()) {
          return false;
        }
      }
    }
    try
    {
      boolean bool = Pattern.compile(paramString1).matcher(paramString2.toUpperCase()).find();
      return bool;
    }
    catch (Exception paramString1)
    {
      label60:
      break label60;
    }
    XWalkEnvironment.addXWalkInitializeLog("ConfigDef", " _IsMatchRex compile strRex failed");
    return false;
  }
  
  public String a()
  {
    return XWalkEnvironment.getRuntimeAbi();
  }
  
  boolean a(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i3 = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int i4 = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    int i5 = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int i6 = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    int i1;
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {
      i1 = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;
    } else {
      i1 = 0;
    }
    int i2;
    if ((!paramBoolean) && (!a(XWalkEnvironment.getGrayValue(), this.m, this.n))) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((a(i3, this.c, this.d)) && (a(i4, this.e, this.f)) && (a(201201, this.a, this.b)) && (a(i5, this.x, this.y)) && (a(i6, this.z, this.A)) && (a(Build.VERSION.SDK_INT, this.g, this.h)) && (a(i1, this.i, this.j)) && (i2 != 0) && (a(XWalkEnvironment.getTodayGrayValue(), this.o, this.p)) && (!a(this.k)) && (!b(this.v, XWalkEnvironment.getPackageName())) && (d()))
    {
      if ((this.s > 0) && (XWalkEnvironment.getUserType() != this.s)) {
        return false;
      }
      Object localObject = this.l;
      if ((localObject != null) && (((String)localObject).trim() != null) && (!this.l.trim().isEmpty()) && (!a(this.l))) {
        return false;
      }
      localObject = this.w;
      if ((localObject != null) && (((String)localObject).trim() != null) && (!this.w.trim().isEmpty()) && (!b(this.w, XWalkEnvironment.getPackageName()))) {
        return false;
      }
      if (((this.q > 0) || (this.r > 0)) && (!a(XWalkEnvironment.getChromiunVersion(), this.q, this.r))) {
        return false;
      }
      if (((c()) || (!TextUtils.isEmpty(this.C))) && (!a(this.C, a())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not match runtimeabis, white abis is ");
        ((StringBuilder)localObject).append(this.C);
        ((StringBuilder)localObject).append(", cur runtime abi is ");
        ((StringBuilder)localObject).append(XWalkEnvironment.getRuntimeAbi());
        Log.i("xweb.internal.ConfigDef", ((StringBuilder)localObject).toString());
        return false;
      }
      if ((!TextUtils.isEmpty(this.B)) && (!a(this.B, XWalkEnvironment.getDeviceAbi())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not match deviceAbis, white abis is ");
        ((StringBuilder)localObject).append(this.B);
        ((StringBuilder)localObject).append(", cur device abi is ");
        ((StringBuilder)localObject).append(XWalkEnvironment.getDeviceAbi());
        Log.i("xweb.internal.ConfigDef", ((StringBuilder)localObject).toString());
        return false;
      }
      if ((!TextUtils.isEmpty(this.E)) && (a(this.E, XWalkEnvironment.getRuntimeAbi())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" match blackRuntimeAbis, black abis is ");
        ((StringBuilder)localObject).append(this.E);
        ((StringBuilder)localObject).append(", cur runtime abi is ");
        ((StringBuilder)localObject).append(a());
        Log.i("xweb.internal.ConfigDef", ((StringBuilder)localObject).toString());
        return false;
      }
      if ((!TextUtils.isEmpty(this.D)) && (a(this.D, XWalkEnvironment.getDeviceAbi())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" match blackDeviceAbis, black abis is ");
        ((StringBuilder)localObject).append(this.D);
        ((StringBuilder)localObject).append(", cur device abi is ");
        ((StringBuilder)localObject).append(XWalkEnvironment.getDeviceAbi());
        Log.i("xweb.internal.ConfigDef", ((StringBuilder)localObject).toString());
        return false;
      }
      i1 = XWalkEnvironment.getAppClientVersion();
      if ((i1 > 0) && (!a(i1, this.F, this.G)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" match AppClientVersion, failed cur client ver is ");
        ((StringBuilder)localObject).append(i1);
        Log.i("xweb.internal.ConfigDef", ((StringBuilder)localObject).toString());
        return false;
      }
      if ((!TextUtils.isEmpty(this.H)) && (!XWalkEnvironment.containsAppInfo(this.H)))
      {
        Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
        return false;
      }
      if ((!TextUtils.isEmpty(this.I)) && (XWalkEnvironment.containsAppInfo(this.I)))
      {
        Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return a(false);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  boolean d()
  {
    if ((!a(this.t)) && (!a(this.u))) {
      return true;
    }
    double d1 = e.b();
    double d2 = this.u;
    if ((d2 > 0.0D) && (d1 > d2)) {
      return false;
    }
    d2 = this.t;
    return (d2 <= 0.0D) || (d1 >= d2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */