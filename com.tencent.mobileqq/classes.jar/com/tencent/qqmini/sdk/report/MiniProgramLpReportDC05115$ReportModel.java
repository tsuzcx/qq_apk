package com.tencent.qqmini.sdk.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniProgramLpReportDC05115$ReportModel
{
  private String androidID = Settings.Secure.getString(AppLoaderFactory.g().getContext().getContentResolver(), "android_id");
  private String clientVersion = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  private int cpuAVG;
  private long crashErrorNum = 0L;
  private String deviceManufacturer = Build.MANUFACTURER;
  private String deviceModel = Build.MODEL;
  private String devicePlatform = "android";
  private String deviceVersion = Build.VERSION.RELEASE;
  private long downloadRequestCost;
  private List<Long> downloadRequestCostList = new ArrayList();
  private long downloadRequestErrorNum;
  private long downloadRequestLength;
  private List<Long> downloadRequestLengths = new ArrayList();
  private long downloadRequestNum;
  private int fpsAVG;
  private int fpsVARI = 0;
  private long gamePrepareCost;
  private long gameUseTime;
  private long httpRequestCost;
  private List<Long> httpRequestCostList = new ArrayList();
  private long httpRequestErrorNum;
  private long httpRequestLength;
  private List<Long> httpRequestLengths = new ArrayList();
  private long httpRequestNum;
  private long jsErrorNum = 0L;
  private long launchCost;
  private boolean launchFlag = false;
  private String launchResult;
  private int memAVG;
  private int memINC;
  private MiniAppInfo miniAppConfig;
  private String networkGateWayIP = "null";
  private String networkSSID = NetworkUtil.getCurrentWifiSSID(AppLoaderFactory.g().getContext());
  private String networkType = MiniProgramReportHelper.getNetworkType();
  private long oomErrorNum = 0L;
  private String openID = "null";
  private long pkgDownloadCost;
  private String pkgDownloadResult;
  private String qua = QUAUtil.getPlatformQUA();
  private long relaunchCost;
  private String sdkVersion = QUAUtil.getQUA();
  private String sourceApp = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
  private String sourceUinPlatform = QUAUtil.getLoginType();
  private String sourceVersion = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  private String x5Version = "1.0";
  
  public MiniProgramLpReportDC05115$ReportModel(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppConfig = paramMiniAppInfo;
  }
  
  private void prepareReportRecord()
  {
    try
    {
      this.gamePrepareCost = this.launchCost;
      boolean bool = this.httpRequestCostList.isEmpty();
      long l2 = 0L;
      int i;
      Iterator localIterator;
      long l1;
      if (!bool)
      {
        i = this.httpRequestCostList.size();
        localIterator = this.httpRequestCostList.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 += ((Long)localIterator.next()).longValue()) {}
        this.httpRequestCost = (l1 / i);
      }
      if (!this.httpRequestLengths.isEmpty())
      {
        localIterator = this.httpRequestLengths.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 += ((Long)localIterator.next()).longValue()) {}
        this.httpRequestLength = (l1 / this.httpRequestLengths.size());
      }
      if (!this.downloadRequestCostList.isEmpty())
      {
        i = this.downloadRequestCostList.size();
        localIterator = this.downloadRequestCostList.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 += Math.max(((Long)localIterator.next()).longValue(), 0L)) {}
        this.downloadRequestCost = (l1 / i);
      }
      if (!this.downloadRequestLengths.isEmpty())
      {
        localIterator = this.downloadRequestLengths.iterator();
        for (l1 = l2; localIterator.hasNext(); l1 += ((Long)localIterator.next()).longValue()) {}
        this.downloadRequestLength = (l1 / this.downloadRequestLengths.size());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void reportCPUMemoryFPS(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.cpuAVG = ((int)paramFloat1);
    this.memAVG = ((int)paramFloat2);
    this.memINC = ((int)paramFloat3);
    this.fpsAVG = ((int)paramFloat4);
    this.fpsVARI = ((int)paramFloat5);
  }
  
  public void reportDownloadRequestResult(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      this.downloadRequestNum += 1L;
      if (paramBoolean)
      {
        this.downloadRequestErrorNum += 1L;
      }
      else
      {
        this.downloadRequestCostList.add(Long.valueOf(paramLong1));
        this.downloadRequestLengths.add(Long.valueOf(paramLong2));
      }
      return;
    }
    finally {}
  }
  
  public void reportHttpRequestResult(long paramLong1, long paramLong2, int paramInt)
  {
    try
    {
      this.httpRequestNum += 1L;
      if (paramInt < 0)
      {
        this.httpRequestErrorNum += 1L;
      }
      else
      {
        this.httpRequestCostList.add(Long.valueOf(paramLong1));
        this.httpRequestLengths.add(Long.valueOf(paramLong2));
      }
      return;
    }
    finally {}
  }
  
  public void reportLaunchResult(long paramLong, String paramString)
  {
    this.launchResult = paramString;
    this.launchCost = paramLong;
  }
  
  public void reportPKGDownloadResult(long paramLong, String paramString)
  {
    this.pkgDownloadCost = paramLong;
    this.pkgDownloadResult = paramString;
  }
  
  public void reportReLaunchResult(long paramLong, String paramString)
  {
    this.launchResult = paramString;
    this.relaunchCost = paramLong;
  }
  
  public void reset()
  {
    try
    {
      this.downloadRequestErrorNum = 0L;
      this.downloadRequestNum = 0L;
      this.downloadRequestLengths.clear();
      this.downloadRequestCostList.clear();
      this.httpRequestErrorNum = 0L;
      this.httpRequestNum = 0L;
      this.httpRequestLengths.clear();
      this.httpRequestCostList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setGameUseTime(long paramLong)
  {
    this.gameUseTime = paramLong;
  }
  
  public void setMiniAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppConfig = paramMiniAppInfo;
  }
  
  public String toReportRecord()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportModel{launchFlag=");
    localStringBuilder.append(this.launchFlag);
    localStringBuilder.append(", launchCost=");
    localStringBuilder.append(this.launchCost);
    localStringBuilder.append(", relaunchCost=");
    localStringBuilder.append(this.relaunchCost);
    localStringBuilder.append(", pkgDownloadCost=");
    localStringBuilder.append(this.pkgDownloadCost);
    localStringBuilder.append(", pkgDownloadResult='");
    localStringBuilder.append(this.pkgDownloadResult);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gamePrepareCost=");
    localStringBuilder.append(this.gamePrepareCost);
    localStringBuilder.append(", fpsAVG=");
    localStringBuilder.append(this.fpsAVG);
    localStringBuilder.append(", fpsVARI=");
    localStringBuilder.append(this.fpsVARI);
    localStringBuilder.append(", cpuAVG=");
    localStringBuilder.append(this.cpuAVG);
    localStringBuilder.append(", memAVG=");
    localStringBuilder.append(this.memAVG);
    localStringBuilder.append(", memINC=");
    localStringBuilder.append(this.memINC);
    localStringBuilder.append(", httpRequestCost=");
    localStringBuilder.append(this.httpRequestCost);
    localStringBuilder.append(", httpRequestNum=");
    localStringBuilder.append(this.httpRequestNum);
    localStringBuilder.append(", httpRequestErrorNum=");
    localStringBuilder.append(this.httpRequestErrorNum);
    localStringBuilder.append(", httpRequestLength=");
    localStringBuilder.append(this.httpRequestLength);
    localStringBuilder.append(", downloadRequestCost=");
    localStringBuilder.append(this.downloadRequestCost);
    localStringBuilder.append(", downloadRequestNum=");
    localStringBuilder.append(this.downloadRequestNum);
    localStringBuilder.append(", downloadRequestErrorNum=");
    localStringBuilder.append(this.downloadRequestErrorNum);
    localStringBuilder.append(", downloadRequestLength=");
    localStringBuilder.append(this.downloadRequestLength);
    localStringBuilder.append(", jsErrorNum=");
    localStringBuilder.append(this.jsErrorNum);
    localStringBuilder.append(", oomErrorNum=");
    localStringBuilder.append(this.oomErrorNum);
    localStringBuilder.append(", crashErrorNum=");
    localStringBuilder.append(this.crashErrorNum);
    localStringBuilder.append(", launchResult='");
    localStringBuilder.append(this.launchResult);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameUseTime=");
    localStringBuilder.append(this.gameUseTime);
    localStringBuilder.append(", x5Version='");
    localStringBuilder.append(this.x5Version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", openID='");
    localStringBuilder.append(this.openID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientVersion='");
    localStringBuilder.append(this.clientVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", devicePlatform='");
    localStringBuilder.append(this.devicePlatform);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceManufacturer='");
    localStringBuilder.append(this.deviceManufacturer);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceModel='");
    localStringBuilder.append(this.deviceModel);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceVersion='");
    localStringBuilder.append(this.deviceVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qua='");
    localStringBuilder.append(this.qua);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(this.networkType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkGateWayIP='");
    localStringBuilder.append(this.networkGateWayIP);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkSSID='");
    localStringBuilder.append(this.networkSSID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", androidID='");
    localStringBuilder.append(this.androidID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sdk_version='");
    localStringBuilder.append(this.sdkVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source_app='");
    localStringBuilder.append(this.sourceApp);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source_version='");
    localStringBuilder.append(this.sourceVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source_uin_platform='");
    localStringBuilder.append(this.sourceUinPlatform);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115.ReportModel
 * JD-Core Version:    0.7.0.1
 */