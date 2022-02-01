package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class SoLoaderLogic
{
  private static HashMap<String, SoLoadInfo> a = new HashMap();
  private static Map<String, AsyncFailInfo> b = new HashMap();
  private static Set<String> o = new SoLoaderLogic.2();
  private LoadParam c;
  private LoadParam.LoadItem d;
  private OnLoadListener e;
  private boolean f = false;
  private String g;
  private long h;
  private SoLoadInfo i = SoLoadInfo.sDefault;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private int m = 0;
  private int n = 0;
  
  private int a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    int i1 = a(paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadConfigSo] res=");
      localStringBuilder.append(i1);
      localStringBuilder.append(",filePath=");
      localStringBuilder.append(paramSoLoadInfo.soPathToLoad);
      QLog.d("SoLoadWidget.SoLoaderLogic", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (i1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, this.g, paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (i1 == 0)
    {
      SoDataUtil.a(paramLoadItem, paramSoLoadInfo.soPathToLoad);
      SoLoadUtils.a(paramLoadItem, paramSoLoadInfo);
      SoLoadUtils.e(paramLoadItem.name);
      return i1;
    }
    if (b(paramLoadItem)) {
      return 0;
    }
    return i1;
  }
  
  private int a(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    this.i = b(paramSoLoadInfo);
    int i2 = this.i.curCode;
    if (i2 == 0) {
      return a(this.d, this.i);
    }
    int i1 = i2;
    if (i2 == 2)
    {
      i1 = i2;
      if (a(this.d)) {
        i1 = 0;
      }
    }
    return i1;
  }
  
  private int a(String paramString, LoadParam.LoadItem paramLoadItem)
  {
    boolean bool = new File(paramString).exists();
    if ((!bool) && (d(paramString))) {
      return 5;
    }
    if ((paramLoadItem.lops.flag & 0x1) != 0)
    {
      if (((paramLoadItem.lops.flag & 0x2) != 0) && (!o.contains(paramLoadItem.name)))
      {
        paramString = paramLoadItem.lops;
        paramString.flag &= 0xFFFFFFFD;
      }
      return 0;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[System.load] loadItem:");
      localStringBuilder.append(paramLoadItem);
      localStringBuilder.append(",exists:");
      localStringBuilder.append(bool);
      QLog.i("SoLoadWidget.SoLoaderLogic", 1, localStringBuilder.toString());
      System.load(paramString);
      paramString = paramLoadItem.lops;
      paramString.flag |= 0x2;
      if (d()) {
        a.put(paramLoadItem.name, this.i);
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      this.g = SoDataUtil.a(paramString);
      QLog.e("SoLoadWidget.SoLoaderLogic", 1, this.g);
    }
    return 6;
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str;
    if (paramInt == 6) {
      str = this.g;
    } else if (!TextUtils.isEmpty(this.i.failDetail)) {
      str = this.i.failDetail;
    } else {
      str = null;
    }
    return a(paramInt, str);
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    this.f = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.h;
    Object localObject1 = this.c;
    long l3 = ((LoadParam)localObject1).mReportSeq;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ver=");
    ((StringBuilder)localObject2).append(this.i.getVer());
    SoReportUtil.a((LoadParam)localObject1, l3, ((StringBuilder)localObject2).toString(), "load.item.load", this.d.name, paramInt, paramString);
    if (paramInt != 0) {
      b(paramInt);
    }
    paramString = c(paramInt);
    localObject1 = this.e;
    if (localObject1 != null) {
      ((OnLoadListener)localObject1).onLoadResult(paramInt, paramString);
    }
    if (!LoadParam.isCloseReport(this.c))
    {
      localObject1 = this.d.name;
      int i1 = this.c.mCallType;
      localObject2 = this.i.getVer();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(c());
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(l1 - l2);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i.subErrCode);
      localStringBuilder.append("");
      ReportController.b(null, "dc00899", "SoLoad", "", "resSingle", (String)localObject1, i1, paramInt, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
    }
    return paramString;
  }
  
  @Deprecated
  public static List<String> a()
  {
    return new LinkedList(a.keySet());
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, LoadParam.LoadItem paramLoadItem)
  {
    if (this.j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.name);
      localStringBuilder.append("_");
      localStringBuilder.append(this.i.soDetailInfo.ver);
      localStringBuilder.append("_");
      localStringBuilder.append(this.k);
      localStringBuilder.append("_");
      localStringBuilder.append(this.l);
      localStringBuilder.append("_");
      localStringBuilder.append(this.n);
      localStringBuilder.append("_");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("_");
      localStringBuilder.append(this.i.soDetailInfo.testFlag);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLoadItem.lops.flag);
      localStringBuilder.append("_");
      localStringBuilder.append(this.m);
      paramLoadItem = new StringBuilder();
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      paramLoadItem.append(MobileQQ.processName);
      paramLoadItem.append("_");
      paramLoadItem.append(SoDataUtil.b(paramString2));
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[testNoExist] skey=");
        paramString2.append(localStringBuilder);
        paramString2.append(",step=");
        paramString2.append(paramLoadItem);
        QLog.i("SoLoadWidget.SoLoaderLogic", 2, paramString2.toString());
      }
      SoReportUtil.a(localStringBuilder.toString(), "qqwallet", "SoLoadNotExist", paramLoadItem.toString(), null, this.i.soDetailInfo.testFlag, paramString1);
    }
  }
  
  private boolean a(LoadParam.LoadItem paramLoadItem)
  {
    String str = paramLoadItem.lops.getOldSoPath();
    boolean bool3 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (new File(str).exists())
      {
        int i1 = a(str, paramLoadItem);
        paramLoadItem = this.c;
        SoReportUtil.a(paramLoadItem, paramLoadItem.mReportSeq, null, "load.item.load.oldpath", null, i1, null);
        bool1 = bool2;
        if (i1 == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private SoLoadInfo b(SoLoadInfo paramSoLoadInfo)
  {
    Object localObject = paramSoLoadInfo;
    if (paramSoLoadInfo == null)
    {
      paramSoLoadInfo = SoLoadInfo.sDefault;
      localObject = paramSoLoadInfo;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSoLoadInfo is null");
        ((StringBuilder)localObject).append(new Exception());
        QLog.e("SoLoadWidget.SoLoaderLogic", 2, ((StringBuilder)localObject).toString());
        localObject = paramSoLoadInfo;
      }
    }
    this.i = ((SoLoadInfo)localObject);
    return localObject;
  }
  
  private void b(int paramInt)
  {
    if (this.c.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC)
    {
      Object localObject2 = (AsyncFailInfo)b.get(this.d.name);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new AsyncFailInfo();
      }
      boolean bool = NetworkUtil.isNetSupport(MobileQQ.sMobileQQ);
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      int i1 = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[onLoadResult]AsyncFailInfo:");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(",name:");
        ((StringBuilder)localObject2).append(this.d.name);
        ((StringBuilder)localObject2).append(",isNetSupport:");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(",curTime=");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(",netType=");
        ((StringBuilder)localObject2).append(i1);
        QLog.i("SoLoadWidget.SoLoaderLogic", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        ((AsyncFailInfo)localObject1).lastFailCode = paramInt;
        ((AsyncFailInfo)localObject1).netType = i1;
        ((AsyncFailInfo)localObject1).lastFailTime = l1;
        ((AsyncFailInfo)localObject1).lastSubFailCode = this.i.subErrCode;
        b.put(this.d.name, localObject1);
      }
    }
  }
  
  private void b(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    this.c = paramLoadParam;
    this.e = paramOnLoadListener;
    this.h = NetConnInfoCenter.getServerTimeMillis();
    this.d = ((LoadParam.LoadItem)paramLoadParam.mLoadItems.get(0));
    paramLoadParam = this.c;
    SoReportUtil.a(paramLoadParam, paramLoadParam.mReportSeq, null, "load.item.start", this.d.name, 0, null);
  }
  
  private boolean b()
  {
    if (a.containsKey(this.d.name))
    {
      this.i = b((SoLoadInfo)a.get(this.d.name));
      Object localObject = this.i;
      if (localObject != null) {
        ((SoLoadInfo)localObject).isFirstlyLoad = false;
      }
      localObject = this.d.lops;
      ((LoadOptions)localObject).flag |= 0x2;
      return true;
    }
    return false;
  }
  
  private boolean b(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool3 = paramLoadItem.lops.isLoadLastSuccWhenFail;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      String str = SoDataUtil.a(paramLoadItem);
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        int i1 = a(str, paramLoadItem);
        paramLoadItem = this.c;
        SoReportUtil.a(paramLoadItem, paramLoadItem.mReportSeq, null, "load.item.load.last", null, i1, null);
        bool1 = bool2;
        if (i1 == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private int c()
  {
    if (!this.i.isFirstlyLoad) {
      return 3;
    }
    if (this.i.isNeedDownload) {
      return 1;
    }
    return 2;
  }
  
  private LoadExtResult c(int paramInt)
  {
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.d.name, this.i, this.d.lops);
    if (this.c.mCallType == LoadParam.CALL_TYPE_SYNC) {
      localLoadExtResult.failInfo = ((AsyncFailInfo)b.get(this.d.name));
    }
    return localLoadExtResult;
  }
  
  public static String c(String paramString)
  {
    paramString = (SoLoadInfo)a.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.getVer();
  }
  
  private boolean d()
  {
    if (this.i.soDetailInfo.relatedFileInfo == null) {
      return true;
    }
    return !TextUtils.isEmpty(this.i.rFileFolder);
  }
  
  private boolean d(String paramString)
  {
    return true;
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    b(paramLoadParam, null);
    if (b()) {
      return a(0);
    }
    return a(a(new GetSoLoadInfoTaskSync(this.c, this.d).c()));
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    b(paramLoadParam, paramOnLoadListener);
    if (b())
    {
      a(0);
      return;
    }
    new GetSoLoadInfoTaskAsync(this.c, this.d).a(new SoLoaderLogic.1(this));
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    String str1 = this.d.name;
    String str2 = this.d.soFileName;
    bool1 = bool2;
    if (!TextUtils.isEmpty(str1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str2))
      {
        bool1 = bool2;
        if (paramString.contains(str2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(String paramString)
  {
    if ((!this.f) && (this.c.mCallType != LoadParam.CALL_TYPE_SYNC))
    {
      a(8, paramString);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ver=");
      localStringBuilder.append(this.i.getVer());
      SoReportUtil.a(null, localStringBuilder.toString(), "SoLoadModule", "SoLoadSingle", "Exception", this.d.name, 2, paramString);
    }
    SoCrashInfo.a(this.d.name, this.i.getVer(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderLogic
 * JD-Core Version:    0.7.0.1
 */