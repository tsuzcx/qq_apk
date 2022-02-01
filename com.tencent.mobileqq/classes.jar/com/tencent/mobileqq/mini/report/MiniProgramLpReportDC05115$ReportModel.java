package com.tencent.mobileqq.mini.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import bhnv;
import bjjo;
import bmsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MiniProgramLpReportDC05115$ReportModel
{
  private String androidID;
  private String clientVersion = "8.4.5.4745";
  private int cpuAVG;
  private long crashErrorNum;
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
  private int fpsVARI;
  private long gamePrepareCost;
  private long gameUseTime;
  private long httpRequestCost;
  private List<Long> httpRequestCostList = new ArrayList();
  private long httpRequestErrorNum;
  private long httpRequestLength;
  private List<Long> httpRequestLengths = new ArrayList();
  private long httpRequestNum;
  private long jsErrorNum;
  private long launchCost;
  private boolean launchFlag;
  private String launchResult;
  private int memAVG;
  private int memINC;
  private MiniAppConfig miniAppConfig;
  private String networkGateWayIP = "null";
  private String networkSSID;
  private String networkType = MiniProgramReportHelper.getNetworkType();
  private long oomErrorNum;
  private String openID = "null";
  private long pkgDownloadCost;
  private String pkgDownloadResult;
  private String qua = bmsw.a();
  private long relaunchCost;
  private String x5Version = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));
  
  public MiniProgramLpReportDC05115$ReportModel(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  private void prepareReportRecord()
  {
    long l2 = 0L;
    int i;
    long l1;
    try
    {
      if (this.networkSSID == null) {
        this.networkSSID = bhnv.b(bjjo.a().a());
      }
      if (this.androidID == null) {
        this.androidID = Settings.Secure.getString(bjjo.a().a().getContentResolver(), "android_id");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Iterator localIterator1;
        QLog.e("MiniProgramLpReportDC05", 1, localThrowable, new Object[0]);
      }
    }
    finally {}
    if (!this.httpRequestCostList.isEmpty())
    {
      i = this.httpRequestCostList.size();
      localIterator1 = this.httpRequestCostList.iterator();
      for (l1 = 0L; localIterator1.hasNext(); l1 = ((Long)localIterator1.next()).longValue() + l1) {}
      long l3 = i;
      this.httpRequestCost = (l1 / l3);
    }
    Iterator localIterator2;
    if (!this.httpRequestLengths.isEmpty())
    {
      localIterator2 = this.httpRequestLengths.iterator();
      for (l1 = 0L; localIterator2.hasNext(); l1 = ((Long)localIterator2.next()).longValue() + l1) {}
      this.httpRequestLength = (l1 / this.httpRequestLengths.size());
    }
    if (!this.downloadRequestCostList.isEmpty())
    {
      i = this.downloadRequestCostList.size();
      localIterator2 = this.downloadRequestCostList.iterator();
      for (l1 = 0L; localIterator2.hasNext(); l1 = Math.max(((Long)localIterator2.next()).longValue(), 0L) + l1) {}
      this.downloadRequestCost = (l1 / i);
    }
    if (!this.downloadRequestLengths.isEmpty())
    {
      localIterator2 = this.downloadRequestLengths.iterator();
      for (l1 = l2; localIterator2.hasNext(); l1 = ((Long)localIterator2.next()).longValue() + l1) {}
      this.downloadRequestLength = (l1 / this.downloadRequestLengths.size());
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
  
  /* Error */
  public void reportDownloadRequestResult(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 256	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestNum	J
    //   7: lconst_1
    //   8: ladd
    //   9: putfield 256	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestNum	J
    //   12: iload 5
    //   14: ifeq +16 -> 30
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 258	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestErrorNum	J
    //   22: lconst_1
    //   23: ladd
    //   24: putfield 258	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestErrorNum	J
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 134	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCostList	Ljava/util/List;
    //   34: lload_1
    //   35: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokeinterface 265 2 0
    //   43: pop
    //   44: aload_0
    //   45: getfield 136	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLengths	Ljava/util/List;
    //   48: lload_3
    //   49: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokeinterface 265 2 0
    //   57: pop
    //   58: goto -31 -> 27
    //   61: astore 6
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 6
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ReportModel
    //   0	68	1	paramLong1	long
    //   0	68	3	paramLong2	long
    //   0	68	5	paramBoolean	boolean
    //   61	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	61	finally
    //   17	27	61	finally
    //   30	58	61	finally
  }
  
  /* Error */
  public void reportHttpRequestResult(long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 269	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestNum	J
    //   7: lconst_1
    //   8: ladd
    //   9: putfield 269	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestNum	J
    //   12: iload 5
    //   14: ifge +16 -> 30
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 271	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestErrorNum	J
    //   22: lconst_1
    //   23: ladd
    //   24: putfield 271	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestErrorNum	J
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 130	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCostList	Ljava/util/List;
    //   34: lload_1
    //   35: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokeinterface 265 2 0
    //   43: pop
    //   44: aload_0
    //   45: getfield 132	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLengths	Ljava/util/List;
    //   48: lload_3
    //   49: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokeinterface 265 2 0
    //   57: pop
    //   58: goto -31 -> 27
    //   61: astore 6
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 6
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ReportModel
    //   0	68	1	paramLong1	long
    //   0	68	3	paramLong2	long
    //   0	68	5	paramInt	int
    //   61	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	61	finally
    //   17	27	61	finally
    //   30	58	61	finally
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
      this.launchFlag = false;
      this.launchCost = 0L;
      this.launchResult = "";
      this.relaunchCost = 0L;
      this.pkgDownloadCost = 0L;
      this.pkgDownloadResult = "";
      this.gamePrepareCost = 0L;
      this.gameUseTime = 0L;
      this.jsErrorNum = 0L;
      this.oomErrorNum = 0L;
      this.crashErrorNum = 0L;
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
  
  public void setGamePrepareCost(long paramLong)
  {
    this.gamePrepareCost = paramLong;
  }
  
  public void setGameUseTime(long paramLong)
  {
    this.gameUseTime = paramLong;
  }
  
  public void setJsErrorNum()
  {
    this.jsErrorNum += 1L;
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  public String toReportRecord()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    prepareReportRecord();
    int i;
    label60:
    StringBuilder localStringBuilder2;
    if ((this.miniAppConfig != null) && (this.miniAppConfig.config != null))
    {
      localObject = this.miniAppConfig.config.appId;
      localObject = localStringBuilder1.append((String)localObject).append('|');
      if (!this.launchFlag) {
        break label678;
      }
      i = 1;
      localStringBuilder2 = ((StringBuilder)localObject).append(i).append('|').append(this.launchCost).append('|').append(this.relaunchCost).append('|').append(this.pkgDownloadCost).append('|').append(this.pkgDownloadResult).append('|').append(this.gamePrepareCost).append('|').append(this.fpsAVG).append('|').append(this.fpsVARI).append('|').append(this.cpuAVG).append('|').append(this.memAVG).append('|').append(this.memINC).append('|').append(this.httpRequestCost).append('|').append(this.httpRequestNum).append('|').append(this.httpRequestErrorNum).append('|').append(this.httpRequestLength).append('|').append(this.downloadRequestCost).append('|').append(this.downloadRequestNum).append('|').append(this.downloadRequestErrorNum).append('|').append(this.downloadRequestLength).append('|').append(this.jsErrorNum).append('|').append(this.oomErrorNum).append('|').append(this.crashErrorNum).append('|').append(this.launchResult).append('|').append(this.gameUseTime).append('|');
      if ((this.miniAppConfig == null) || (this.miniAppConfig.launchParam == null)) {
        break label683;
      }
      localObject = Integer.valueOf(this.miniAppConfig.launchParam.scene);
      label379:
      localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(NetConnInfoCenter.getServerTimeMillis()).append('|');
      if ((this.miniAppConfig == null) || (this.miniAppConfig.config == null)) {
        break label689;
      }
      localObject = Integer.valueOf(this.miniAppConfig.config.getReportType());
      label434:
      localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(this.networkType).append('|').append(this.qua).append('|').append(this.clientVersion).append('|');
      if ((this.miniAppConfig == null) || (this.miniAppConfig.config == null)) {
        break label695;
      }
      localObject = this.miniAppConfig.config.version;
      label511:
      localStringBuilder2 = localStringBuilder2.append((String)localObject).append('|');
      if ((this.miniAppConfig == null) || (this.miniAppConfig.baseLibInfo == null)) {
        break label701;
      }
    }
    label678:
    label683:
    label689:
    label695:
    label701:
    for (Object localObject = this.miniAppConfig.baseLibInfo.baseLibVersion;; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append('|').append(this.x5Version).append('|').append(this.devicePlatform).append('|').append(this.deviceManufacturer).append('|').append(this.deviceModel).append('|').append(this.deviceVersion).append('|').append(this.networkGateWayIP).append('|').append(this.networkSSID).append('|').append(this.androidID).append('|').append(this.openID);
      return localStringBuilder1.toString();
      localObject = "null";
      break;
      i = 0;
      break label60;
      localObject = "null";
      break label379;
      localObject = "null";
      break label434;
      localObject = "null";
      break label511;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "ReportModel{launchFlag=" + this.launchFlag + ", launchCost=" + this.launchCost + ", relaunchCost=" + this.relaunchCost + ", pkgDownloadCost=" + this.pkgDownloadCost + ", pkgDownloadResult='" + this.pkgDownloadResult + '\'' + ", gamePrepareCost=" + this.gamePrepareCost + ", fpsAVG=" + this.fpsAVG + ", fpsVARI=" + this.fpsVARI + ", cpuAVG=" + this.cpuAVG + ", memAVG=" + this.memAVG + ", memINC=" + this.memINC + ", httpRequestCost=" + this.httpRequestCost + ", httpRequestNum=" + this.httpRequestNum + ", httpRequestErrorNum=" + this.httpRequestErrorNum + ", httpRequestLength=" + this.httpRequestLength + ", downloadRequestCost=" + this.downloadRequestCost + ", downloadRequestNum=" + this.downloadRequestNum + ", downloadRequestErrorNum=" + this.downloadRequestErrorNum + ", downloadRequestLength=" + this.downloadRequestLength + ", jsErrorNum=" + this.jsErrorNum + ", oomErrorNum=" + this.oomErrorNum + ", crashErrorNum=" + this.crashErrorNum + ", launchResult='" + this.launchResult + '\'' + ", gameUseTime=" + this.gameUseTime + ", x5Version='" + this.x5Version + '\'' + ", openID='" + this.openID + '\'' + ", clientVersion='" + this.clientVersion + '\'' + ", devicePlatform='" + this.devicePlatform + '\'' + ", deviceManufacturer='" + this.deviceManufacturer + '\'' + ", deviceModel='" + this.deviceModel + '\'' + ", deviceVersion='" + this.deviceVersion + '\'' + ", qua='" + this.qua + '\'' + ", networkType='" + this.networkType + '\'' + ", networkGateWayIP='" + this.networkGateWayIP + '\'' + ", networkSSID='" + this.networkSSID + '\'' + ", androidID='" + this.androidID + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115.ReportModel
 * JD-Core Version:    0.7.0.1
 */