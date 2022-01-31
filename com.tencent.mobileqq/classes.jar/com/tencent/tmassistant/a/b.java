package com.tencent.tmassistant.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.AppExtInfoParam;
import com.tencent.tmassistant.common.jce.SDKDataReportRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmassistantbase.util.p;
import com.tencent.tmassistantbase.util.t;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements f
{
  private static volatile b a = null;
  private PackageManager b;
  private e c = new e();
  private long d = 0L;
  private String e = "";
  private int f = 0;
  private boolean g = false;
  
  private b()
  {
    this.c.a(this);
    try
    {
      Context localContext = GlobalUtil.getInstance().getContext().getApplicationContext();
      this.b = localContext.getPackageManager();
      this.e = localContext.getExternalCacheDir().getParent();
      this.e = new File(this.e).getParent();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private long a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = this.e + File.separator + paramString1;; paramString1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + paramString2) {
      return a.a(new File(paramString1));
    }
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private d a(byte paramByte, AppExtInfoParam paramAppExtInfoParam, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo)
  {
    System.currentTimeMillis();
    d locald = new d(null);
    locald.a = paramPackageInfo.packageName;
    locald.b = paramByte;
    if (paramAppExtInfoParam == null) {
      return locald;
    }
    System.currentTimeMillis();
    int i = paramAppExtInfoParam.flag;
    File localFile = new File(paramApplicationInfo.sourceDir);
    if ((i & 0x1) != 0) {
      locald.c = localFile.length();
    }
    System.currentTimeMillis();
    if ((i & 0x2) != 0) {
      locald.d = b(paramApplicationInfo.packageName);
    }
    System.currentTimeMillis();
    if ((i & 0x4) != 0) {
      locald.e = a(paramApplicationInfo.packageName, paramAppExtInfoParam.oftenUsedPath);
    }
    System.currentTimeMillis();
    if ((i & 0x8) != 0) {
      locald.f = c(paramApplicationInfo.sourceDir);
    }
    System.currentTimeMillis();
    if ((i & 0x10) != 0)
    {
      locald.g = paramPackageInfo.firstInstallTime;
      locald.h = paramPackageInfo.lastUpdateTime;
    }
    if ((i & 0x20) != 0) {
      locald.i = paramPackageInfo.versionCode;
    }
    System.currentTimeMillis();
    if ((i & 0x40) != 0) {
      locald.j = a.a(paramPackageInfo.packageName, paramAppExtInfoParam.targetFileNameList);
    }
    System.currentTimeMillis();
    this.f += 1;
    return locald;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return paramString;
        i = paramString.indexOf(".");
      } while (i == -1);
      i = paramString.indexOf(".", i + 1);
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  private ArrayList<String> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = a((String)paramList.next());
      if (((Map)localObject).containsKey(str)) {
        ((Map)localObject).put(str, Integer.valueOf(((Integer)((Map)localObject).get(str)).intValue() + 1));
      } else {
        ((Map)localObject).put(str, Integer.valueOf(1));
      }
    }
    paramList = ((Map)localObject).entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      if (((Integer)((Map.Entry)localObject).getValue()).intValue() >= 7) {
        localArrayList.add(((Map.Entry)localObject).getKey());
      }
    }
    return localArrayList;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = o.c(this.b.getPackageInfo(paramString, 64).signatures[0].toByteArray()).toLowerCase();
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void b(AppDataReportConfig paramAppDataReportConfig)
  {
    this.g = true;
    long l = System.currentTimeMillis();
    this.f = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1 = this.b.getInstalledPackages(0);
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    System.currentTimeMillis();
    Iterator localIterator = ((List)localObject1).iterator();
    ApplicationInfo localApplicationInfo;
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      localObject1 = null;
      try
      {
        Object localObject2 = this.b.getApplicationInfo(localPackageInfo.packageName, 0);
        localObject1 = localObject2;
        if (localObject1 != null)
        {
          localApplicationInfo = null;
          localObject2 = localApplicationInfo;
          if (paramAppDataReportConfig != null)
          {
            localObject2 = localApplicationInfo;
            if (paramAppDataReportConfig.mapSpecialPkgs != null) {
              localObject2 = (AppExtInfoParam)paramAppDataReportConfig.mapSpecialPkgs.get(localPackageInfo.packageName);
            }
          }
          if (b(((ApplicationInfo)localObject1).flags))
          {
            localArrayList4.add(a((byte)3, (AppExtInfoParam)localObject2, (ApplicationInfo)localObject1, localPackageInfo));
            ((List)localObject4).add(localPackageInfo.packageName);
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
        }
        if (c(((ApplicationInfo)localObject1).flags))
        {
          ((List)localObject3).add(localPackageInfo.packageName);
          localHashMap1.put(localPackageInfo.packageName, localObject1);
          localHashMap2.put(localPackageInfo.packageName, localNameNotFoundException);
          localHashMap3.put(localPackageInfo.packageName, localPackageInfo);
        }
        else
        {
          localArrayList2.add(a((byte)1, localNameNotFoundException, (ApplicationInfo)localObject1, localPackageInfo));
        }
      }
    }
    System.currentTimeMillis();
    paramAppDataReportConfig = a((List)localObject4);
    localObject1 = ((List)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      localApplicationInfo = (ApplicationInfo)localHashMap1.get(str);
      localObject3 = (AppExtInfoParam)localHashMap2.get(str);
      localObject4 = (PackageInfo)localHashMap3.get(str);
      if (paramAppDataReportConfig.contains(a(str))) {
        localArrayList3.add(a((byte)2, (AppExtInfoParam)localObject3, localApplicationInfo, (PackageInfo)localObject4));
      } else {
        localArrayList2.add(a((byte)1, (AppExtInfoParam)localObject3, localApplicationInfo, (PackageInfo)localObject4));
      }
    }
    System.currentTimeMillis();
    localArrayList1.addAll(localArrayList2);
    localArrayList1.addAll(localArrayList3);
    localArrayList1.addAll(localArrayList4);
    paramAppDataReportConfig = new StringBuilder();
    localObject1 = localArrayList1.iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramAppDataReportConfig.append(((d)((Iterator)localObject1).next()).toString());
    }
    System.currentTimeMillis();
    localObject1 = new SDKDataReportRequest();
    ((SDKDataReportRequest)localObject1).appData = paramAppDataReportConfig.toString();
    ((SDKDataReportRequest)localObject1).timeCost = (System.currentTimeMillis() - l);
    ((SDKDataReportRequest)localObject1).uin = GlobalUtil.getUin();
    ((SDKDataReportRequest)localObject1).qimei = GlobalUtil.getInstance().getQimei();
    ((SDKDataReportRequest)localObject1).qadid = GlobalUtil.getInstance().getQadid();
    this.g = this.c.a((SDKDataReportRequest)localObject1);
    System.currentTimeMillis();
  }
  
  private boolean b(int paramInt)
  {
    return ((paramInt & 0x1) != 0) && ((paramInt & 0x80) == 0);
  }
  
  private String c(String paramString)
  {
    paramString = o.b(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.toLowerCase();
  }
  
  private boolean c(int paramInt)
  {
    return ((paramInt & 0x1) != 0) && ((paramInt & 0x80) != 0);
  }
  
  private int d(int paramInt)
  {
    int j = 0;
    if (!t.a()) {
      j = -1;
    }
    for (;;)
    {
      return j;
      if (paramInt == 0) {
        return -2;
      }
      String str = GlobalUtil.getCurrentDay();
      if (!str.equals(Settings.getInstance().getString("analysis_last_ana_day")))
      {
        Settings.getInstance().setString("analysis_last_ana_day", str);
        Settings.getInstance().setInt("analysis_succ_times", 0);
      }
      for (int i = 0; i >= paramInt; i = Settings.getInstance().getInt("analysis_succ_times")) {
        return -3;
      }
    }
  }
  
  public void a(int paramInt)
  {
    ac.c("InfoAnalyzer_", "requestFailed errorCode=" + paramInt);
    this.g = false;
  }
  
  public void a(AppDataReportConfig paramAppDataReportConfig)
  {
    if (!p.a(GlobalUtil.getInstance().getContext())) {
      ac.c("InfoAnalyzer_", "[begin] no available network!");
    }
    int i;
    do
    {
      return;
      long l = System.currentTimeMillis();
      if (l - this.d < 60000L)
      {
        ac.c("InfoAnalyzer_", "[begin] < 60 * 1000");
        return;
      }
      this.d = l;
      if (this.g)
      {
        ac.c("InfoAnalyzer_", "[begin] analyzing ");
        return;
      }
      i = d(paramAppDataReportConfig.frequency);
      ac.c("InfoAnalyzer_", "[begin] ret=" + i + ",cfg.fre=" + paramAppDataReportConfig.frequency + ",today succeed.times=" + Settings.getInstance().getInt("analysis_succ_times"));
    } while (i != 0);
    paramAppDataReportConfig = new Thread(new c(this, paramAppDataReportConfig), m.c.toString());
    paramAppDataReportConfig.setPriority(1);
    paramAppDataReportConfig.start();
  }
  
  public void b()
  {
    ac.c("InfoAnalyzer_", "requestSucceed");
    Settings.getInstance().setInt("analysis_succ_times", Settings.getInstance().getInt("analysis_succ_times") + 1);
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.a.b
 * JD-Core Version:    0.7.0.1
 */