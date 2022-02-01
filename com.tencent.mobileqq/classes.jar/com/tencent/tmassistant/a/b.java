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
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.n;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmassistantbase.util.s;
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
  private static volatile b a;
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
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.e);
      paramString2.append(File.separator);
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramString1.append(File.separator);
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    return a.a(new File(paramString1));
  }
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf(".");
    if (i == -1) {
      return paramString;
    }
    i = paramString.indexOf(".", i + 1);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  private ArrayList<String> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashMap();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
    }
    return localArrayList;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = n.c(this.b.getPackageInfo(paramString, 64).signatures[0].toByteArray()).toLowerCase();
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
    Object localObject5 = new ArrayList();
    Object localObject4 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    System.currentTimeMillis();
    Iterator localIterator = ((List)localObject1).iterator();
    ApplicationInfo localApplicationInfo;
    Object localObject3;
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      localApplicationInfo = null;
      try
      {
        localObject1 = this.b;
        try
        {
          localObject1 = ((PackageManager)localObject1).getApplicationInfo(localPackageInfo.packageName, 0);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1) {}
        localNameNotFoundException2.printStackTrace();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      localObject2 = null;
      if (localObject2 != null) {
        for (;;)
        {
          localObject3 = localApplicationInfo;
          if (paramAppDataReportConfig != null)
          {
            localObject3 = localApplicationInfo;
            if (paramAppDataReportConfig.mapSpecialPkgs != null) {
              localObject3 = (AppExtInfoParam)paramAppDataReportConfig.mapSpecialPkgs.get(localPackageInfo.packageName);
            }
          }
          if (b(((ApplicationInfo)localObject2).flags))
          {
            localArrayList4.add(a((byte)3, (AppExtInfoParam)localObject3, (ApplicationInfo)localObject2, localPackageInfo));
            ((List)localObject5).add(localPackageInfo.packageName);
          }
          else if (c(((ApplicationInfo)localObject2).flags))
          {
            ((List)localObject4).add(localPackageInfo.packageName);
            localHashMap1.put(localPackageInfo.packageName, localObject2);
            localHashMap2.put(localPackageInfo.packageName, localObject3);
            localHashMap3.put(localPackageInfo.packageName, localPackageInfo);
          }
          else
          {
            localArrayList2.add(a((byte)1, (AppExtInfoParam)localObject3, (ApplicationInfo)localObject2, localPackageInfo));
          }
        }
      }
    }
    System.currentTimeMillis();
    paramAppDataReportConfig = a((List)localObject5);
    Object localObject2 = ((List)localObject4).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localApplicationInfo = (ApplicationInfo)localHashMap1.get(localObject3);
      localObject4 = (AppExtInfoParam)localHashMap2.get(localObject3);
      localObject5 = (PackageInfo)localHashMap3.get(localObject3);
      if (paramAppDataReportConfig.contains(a((String)localObject3))) {
        localArrayList3.add(a((byte)2, (AppExtInfoParam)localObject4, localApplicationInfo, (PackageInfo)localObject5));
      } else {
        localArrayList2.add(a((byte)1, (AppExtInfoParam)localObject4, localApplicationInfo, (PackageInfo)localObject5));
      }
    }
    System.currentTimeMillis();
    localArrayList1.addAll(localArrayList2);
    localArrayList1.addAll(localArrayList3);
    localArrayList1.addAll(localArrayList4);
    paramAppDataReportConfig = new StringBuilder();
    localObject2 = localArrayList1.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramAppDataReportConfig.append(((d)((Iterator)localObject2).next()).toString());
    }
    System.currentTimeMillis();
    localObject2 = new SDKDataReportRequest();
    ((SDKDataReportRequest)localObject2).appData = paramAppDataReportConfig.toString();
    ((SDKDataReportRequest)localObject2).timeCost = (System.currentTimeMillis() - l);
    ((SDKDataReportRequest)localObject2).uin = GlobalUtil.getUin();
    ((SDKDataReportRequest)localObject2).qimei = GlobalUtil.getInstance().getQimei();
    ((SDKDataReportRequest)localObject2).qadid = GlobalUtil.getInstance().getQadid();
    this.g = this.c.a((SDKDataReportRequest)localObject2);
    System.currentTimeMillis();
  }
  
  private boolean b(int paramInt)
  {
    return ((paramInt & 0x1) != 0) && ((paramInt & 0x80) == 0);
  }
  
  private String c(String paramString)
  {
    paramString = n.b(paramString);
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
    if (!s.a()) {
      return -1;
    }
    if (paramInt == 0) {
      return -2;
    }
    String str = GlobalUtil.getCurrentDay();
    int i;
    if (!str.equals(Settings.getInstance().getString("analysis_last_ana_day")))
    {
      Settings.getInstance().setString("analysis_last_ana_day", str);
      Settings.getInstance().setInt("analysis_succ_times", 0);
      i = 0;
    }
    else
    {
      i = Settings.getInstance().getInt("analysis_succ_times");
    }
    if (i >= paramInt) {
      return -3;
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFailed errorCode=");
    localStringBuilder.append(paramInt);
    ab.c("InfoAnalyzer_", localStringBuilder.toString());
    this.g = false;
  }
  
  public void a(AppDataReportConfig paramAppDataReportConfig)
  {
    if (!o.a(GlobalUtil.getInstance().getContext()))
    {
      ab.c("InfoAnalyzer_", "[begin] no available network!");
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.d < 60000L)
    {
      ab.c("InfoAnalyzer_", "[begin] < 60 * 1000");
      return;
    }
    this.d = l;
    if (this.g)
    {
      ab.c("InfoAnalyzer_", "[begin] analyzing ");
      return;
    }
    int i = d(paramAppDataReportConfig.frequency);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[begin] ret=");
    localStringBuilder.append(i);
    localStringBuilder.append(",cfg.fre=");
    localStringBuilder.append(paramAppDataReportConfig.frequency);
    localStringBuilder.append(",today succeed.times=");
    localStringBuilder.append(Settings.getInstance().getInt("analysis_succ_times"));
    ab.c("InfoAnalyzer_", localStringBuilder.toString());
    if (i == 0)
    {
      paramAppDataReportConfig = new Thread(new c(this, paramAppDataReportConfig), l.c.toString());
      paramAppDataReportConfig.setPriority(1);
      paramAppDataReportConfig.start();
    }
  }
  
  public void b()
  {
    ab.c("InfoAnalyzer_", "requestSucceed");
    Settings.getInstance().setInt("analysis_succ_times", Settings.getInstance().getInt("analysis_succ_times") + 1);
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.a.b
 * JD-Core Version:    0.7.0.1
 */