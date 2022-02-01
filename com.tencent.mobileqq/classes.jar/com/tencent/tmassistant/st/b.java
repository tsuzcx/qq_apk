package com.tencent.tmassistant.st;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  private static volatile b a;
  
  private b()
  {
    k.a().postDelayed(new c(this), 10000L);
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
  
  private void a(String paramString, com.tencent.tmdownloader.internal.downloadservice.c paramc, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doInstallReportDir]:");
    ((StringBuilder)localObject1).append(paramString);
    ab.c("BoutiqueGameRT", ((StringBuilder)localObject1).toString());
    Object localObject2 = GlobalUtil.getInstance().getContext();
    long l2 = 0L;
    String str = "";
    long l1 = l2;
    localObject1 = str;
    if (localObject2 != null)
    {
      l1 = l2;
      localObject1 = str;
      try
      {
        localObject2 = ((Context)localObject2).getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir;
        l1 = l2;
        localObject1 = str;
        l2 = new File((String)localObject2).length();
        l1 = l2;
        localObject1 = str;
        long l3 = System.currentTimeMillis();
        l1 = l2;
        localObject1 = str;
        str = com.tencent.dlsdk.yybutil.apkchannel.a.a((String)localObject2);
        l1 = l2;
        localObject1 = str;
        StringBuilder localStringBuilder2 = new StringBuilder();
        l1 = l2;
        localObject1 = str;
        localStringBuilder2.append("[doInstallReportDir] Read channelId time cost:");
        l1 = l2;
        localObject1 = str;
        localStringBuilder2.append(System.currentTimeMillis() - l3);
        l1 = l2;
        localObject1 = str;
        localStringBuilder2.append("ms, path = ");
        l1 = l2;
        localObject1 = str;
        localStringBuilder2.append((String)localObject2);
        l1 = l2;
        localObject1 = str;
        ab.c("BoutiqueGameRT", localStringBuilder2.toString());
        l1 = l2;
        localObject1 = str;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doInstallReportDir] read installed fileSize error:");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        ab.e("BoutiqueGameRT", ((StringBuilder)localObject2).toString());
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramLong);
    localStringBuilder1.append("|");
    localStringBuilder1.append(Build.BRAND);
    localStringBuilder1.append("|");
    localStringBuilder1.append(Build.MODEL);
    localStringBuilder1.append("|");
    localStringBuilder1.append(GlobalUtil.getInstance().getImei());
    localStringBuilder1.append("|");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("|");
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("|");
    localStringBuilder1.append(paramc.b);
    localStringBuilder1.append("|");
    localStringBuilder1.append(l1);
    localStringBuilder1.append("|");
    localStringBuilder1.append(paramc.x);
    localStringBuilder1.append("|");
    localStringBuilder1.append(GlobalUtil.getInstance().getAppVersionCode());
    localStringBuilder1.append("|");
    localStringBuilder1.append(paramc.u);
    paramString = localStringBuilder1.toString();
    SDKReportManager2.getInstance().postReport(2005, paramString);
    paramString = new StringBuilder();
    paramString.append(paramc.A);
    paramString.append("SENDED");
    paramc.A = paramString.toString();
    com.tencent.tmdownloader.internal.storage.a.a().a(paramc);
  }
  
  private void b()
  {
    ab.c("BoutiqueGameRT", "do init task");
    Object localObject1 = (BoutiqueGameConfig)com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
    if ((localObject1 != null) && (((BoutiqueGameConfig)localObject1).pkgList != null) && (((BoutiqueGameConfig)localObject1).pkgList.size() != 0)) {
      localObject1 = ((BoutiqueGameConfig)localObject1).pkgList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(str);
      Object localObject3;
      if ((localObject2 != null) && (((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).g == 4)) {
        if ((!TextUtils.isEmpty(((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).A)) && (((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).A.endsWith("SENDED")))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(": task SENDED!");
          ((StringBuilder)localObject3).append(((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).A);
          ab.c("BoutiqueGameRT", ((StringBuilder)localObject3).toString());
        }
        else if (!com.tencent.tmdownloader.internal.downloadservice.a.a(str, 0)) {}
      }
      try
      {
        localObject3 = GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(str, 0);
        long l = ((PackageInfo)localObject3).lastUpdateTime - ((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).u;
        if ((l > 0L) && (l < 86400000L))
        {
          a(str, (com.tencent.tmdownloader.internal.downloadservice.c)localObject2, ((PackageInfo)localObject3).lastUpdateTime);
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(": time ERROR, packageInfo.lastUpdateTime=");
        localStringBuilder.append(((PackageInfo)localObject3).lastUpdateTime);
        localStringBuilder.append("di.mEndTime=");
        localStringBuilder.append(((com.tencent.tmdownloader.internal.downloadservice.c)localObject2).u);
        localStringBuilder.append("time distance=");
        localStringBuilder.append(l);
        ab.c("BoutiqueGameRT", localStringBuilder.toString());
      }
      catch (Throwable localThrowable)
      {
        label324:
        break label324;
      }
      continue;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(": NOT INSTALLED!");
      ab.c("BoutiqueGameRT", ((StringBuilder)localObject2).toString());
      continue;
      ab.c("BoutiqueGameRT", "config pkg is empty!");
    }
  }
  
  public void a(com.tencent.tmdownloader.internal.downloadservice.c paramc, DownloaderTask paramDownloaderTask)
  {
    paramc.u = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(paramc.r)) && (GlobalUtil.isRecommendGame(paramc.r)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[doDownloadSuccReport]");
      ((StringBuilder)localObject1).append(paramc.r);
      ((StringBuilder)localObject1).append("is bgg");
      ab.c("BoutiqueGameRT", ((StringBuilder)localObject1).toString());
      long l2 = 0L;
      Object localObject2 = "";
      localObject1 = localObject2;
      long l1 = l2;
      try
      {
        com.tencent.tmdownloader.internal.storage.a.a().a(paramc);
        localObject1 = localObject2;
        l1 = l2;
        String str = paramDownloaderTask.getSavePath();
        localObject1 = localObject2;
        l1 = l2;
        l2 = new File(str).length();
        localObject1 = localObject2;
        l1 = l2;
        long l3 = System.currentTimeMillis();
        localObject1 = localObject2;
        l1 = l2;
        paramDownloaderTask = com.tencent.dlsdk.yybutil.apkchannel.a.a(str);
        localObject1 = paramDownloaderTask;
        l1 = l2;
        localObject2 = new StringBuilder();
        localObject1 = paramDownloaderTask;
        l1 = l2;
        ((StringBuilder)localObject2).append("[doDownloadSuccReport] Read channelId time cost:");
        localObject1 = paramDownloaderTask;
        l1 = l2;
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l3);
        localObject1 = paramDownloaderTask;
        l1 = l2;
        ((StringBuilder)localObject2).append("ms, path = ");
        localObject1 = paramDownloaderTask;
        l1 = l2;
        ((StringBuilder)localObject2).append(str);
        localObject1 = paramDownloaderTask;
        l1 = l2;
        ab.c("BoutiqueGameRT", ((StringBuilder)localObject2).toString());
        l1 = l2;
      }
      catch (Throwable paramDownloaderTask)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadSuccReport] read dowloaded fileSize error:");
        ((StringBuilder)localObject2).append(paramDownloaderTask.getMessage());
        ab.e("BoutiqueGameRT", ((StringBuilder)localObject2).toString());
        paramDownloaderTask = (DownloaderTask)localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramc.u);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(Build.BRAND);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(Build.MODEL);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(GlobalUtil.getInstance().getImei());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramc.r);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramc.s);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramDownloaderTask);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramc.b);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramc.x);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(GlobalUtil.getInstance().getAppVersionCode());
      paramc = ((StringBuilder)localObject1).toString();
      SDKReportManager2.getInstance().postReport(2004, paramc);
      return;
    }
    ab.e("BoutiqueGameRT", "download complete, mTaskPackageName is empty! || not bgg");
  }
  
  public void a(String paramString)
  {
    com.tencent.tmdownloader.internal.downloadservice.c localc = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(paramString);
    if ((localc != null) && (localc.g == 4) && ((TextUtils.isEmpty(localc.A)) || (!localc.A.endsWith("SENDED"))))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[doInstallSuccReport] di = ");
      ((StringBuilder)localObject1).append(localc.r);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(localc.I);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(localc.s);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(localc.j);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(localc.x);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(localc.b);
      ab.c("BoutiqueGameRT", ((StringBuilder)localObject1).toString());
      if ((!TextUtils.isEmpty(paramString)) && (GlobalUtil.isRecommendGame(paramString)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("install complete, ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" is bgg");
        ab.c("BoutiqueGameRT", ((StringBuilder)localObject1).toString());
        long l2 = 0L;
        Object localObject2 = GlobalUtil.getInstance().getContext();
        String str = "";
        long l1 = l2;
        localObject1 = str;
        if (localObject2 != null)
        {
          l1 = l2;
          localObject1 = str;
          try
          {
            localObject2 = ((Context)localObject2).getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir;
            l1 = l2;
            localObject1 = str;
            l2 = new File((String)localObject2).length();
            l1 = l2;
            localObject1 = str;
            long l3 = System.currentTimeMillis();
            l1 = l2;
            localObject1 = str;
            str = com.tencent.dlsdk.yybutil.apkchannel.a.a((String)localObject2);
            l1 = l2;
            localObject1 = str;
            StringBuilder localStringBuilder2 = new StringBuilder();
            l1 = l2;
            localObject1 = str;
            localStringBuilder2.append("[doInstallSuccReport] Read channelId time cost:");
            l1 = l2;
            localObject1 = str;
            localStringBuilder2.append(System.currentTimeMillis() - l3);
            l1 = l2;
            localObject1 = str;
            localStringBuilder2.append("ms, path = ");
            l1 = l2;
            localObject1 = str;
            localStringBuilder2.append((String)localObject2);
            l1 = l2;
            localObject1 = str;
            ab.c("BoutiqueGameRT", localStringBuilder2.toString());
            l1 = l2;
            localObject1 = str;
          }
          catch (Throwable localThrowable)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[doInstallSuccReport] read installed fileSize error:");
            ((StringBuilder)localObject2).append(localThrowable.getMessage());
            ab.e("BoutiqueGameRT", ((StringBuilder)localObject2).toString());
          }
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(System.currentTimeMillis());
        localStringBuilder1.append("|");
        localStringBuilder1.append(Build.BRAND);
        localStringBuilder1.append("|");
        localStringBuilder1.append(Build.MODEL);
        localStringBuilder1.append("|");
        localStringBuilder1.append(GlobalUtil.getInstance().getImei());
        localStringBuilder1.append("|");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append("|");
        localStringBuilder1.append(localc.s);
        localStringBuilder1.append("|");
        localStringBuilder1.append((String)localObject1);
        localStringBuilder1.append("|");
        localStringBuilder1.append(localc.b);
        localStringBuilder1.append("|");
        localStringBuilder1.append(l1);
        localStringBuilder1.append("|");
        localStringBuilder1.append(localc.x);
        localStringBuilder1.append("|");
        localStringBuilder1.append(GlobalUtil.getInstance().getAppVersionCode());
        localStringBuilder1.append("|");
        localStringBuilder1.append(localc.u);
        paramString = localStringBuilder1.toString();
        SDKReportManager2.getInstance().postReport(2005, paramString);
        paramString = new StringBuilder();
        paramString.append(localc.A);
        paramString.append("SENDED");
        localc.A = paramString.toString();
        com.tencent.tmdownloader.internal.storage.a.a().a(localc);
        return;
      }
      ab.e("BoutiqueGameRT", "install complete, pkgName is empty!");
      return;
    }
    ab.e("BoutiqueGameRT", "[doInstallSuccReport] di is NULL OR di.mStatus != DOWNLOAD_STATUS_SUCCEED OR SENDED!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.st.b
 * JD-Core Version:    0.7.0.1
 */