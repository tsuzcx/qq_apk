package com.tencent.mobileqq.mini.report;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MiniProgramLpReportDC05115$ReportModel
{
  private String androidID = null;
  private String clientVersion = "8.8.17.5770";
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
  private MiniAppConfig miniAppConfig;
  private String networkGateWayIP = "null";
  private String networkSSID = null;
  private String networkType = MiniProgramReportHelper.getNetworkType();
  private long oomErrorNum = 0L;
  private String openID = "null";
  private long pkgDownloadCost;
  private String pkgDownloadResult;
  private String qua = QUA.getQUA3();
  private long relaunchCost;
  private String x5Version = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));
  
  public MiniProgramLpReportDC05115$ReportModel(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  /* Error */
  private void prepareReportRecord()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 137	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:networkSSID	Ljava/lang/String;
    //   6: ifnonnull +16 -> 22
    //   9: aload_0
    //   10: invokestatic 167	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   13: invokevirtual 171	com/tencent/open/adapter/CommonDataAdapter:b	()Landroid/content/Context;
    //   16: invokestatic 177	com/tencent/mobileqq/utils/NetworkUtil:getCurrentWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   19: putfield 137	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:networkSSID	Ljava/lang/String;
    //   22: aload_0
    //   23: getfield 139	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:androidID	Ljava/lang/String;
    //   26: ifnonnull +43 -> 69
    //   29: aload_0
    //   30: invokestatic 167	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   33: invokevirtual 171	com/tencent/open/adapter/CommonDataAdapter:b	()Landroid/content/Context;
    //   36: invokevirtual 183	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   39: ldc 185
    //   41: invokestatic 191	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 139	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:androidID	Ljava/lang/String;
    //   47: goto +22 -> 69
    //   50: astore 7
    //   52: goto +314 -> 366
    //   55: astore 7
    //   57: ldc 193
    //   59: iconst_1
    //   60: aload 7
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 144	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCostList	Ljava/util/List;
    //   73: invokeinterface 205 1 0
    //   78: istore_2
    //   79: lconst_0
    //   80: lstore 5
    //   82: iload_2
    //   83: ifne +63 -> 146
    //   86: aload_0
    //   87: getfield 144	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCostList	Ljava/util/List;
    //   90: invokeinterface 209 1 0
    //   95: istore_1
    //   96: aload_0
    //   97: getfield 144	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCostList	Ljava/util/List;
    //   100: invokeinterface 213 1 0
    //   105: astore 7
    //   107: lconst_0
    //   108: lstore_3
    //   109: aload 7
    //   111: invokeinterface 218 1 0
    //   116: ifeq +22 -> 138
    //   119: lload_3
    //   120: aload 7
    //   122: invokeinterface 222 1 0
    //   127: checkcast 224	java/lang/Long
    //   130: invokevirtual 228	java/lang/Long:longValue	()J
    //   133: ladd
    //   134: lstore_3
    //   135: goto -26 -> 109
    //   138: aload_0
    //   139: lload_3
    //   140: iload_1
    //   141: i2l
    //   142: ldiv
    //   143: putfield 230	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCost	J
    //   146: aload_0
    //   147: getfield 146	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLengths	Ljava/util/List;
    //   150: invokeinterface 205 1 0
    //   155: ifne +61 -> 216
    //   158: aload_0
    //   159: getfield 146	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLengths	Ljava/util/List;
    //   162: invokeinterface 213 1 0
    //   167: astore 7
    //   169: lconst_0
    //   170: lstore_3
    //   171: aload 7
    //   173: invokeinterface 218 1 0
    //   178: ifeq +22 -> 200
    //   181: lload_3
    //   182: aload 7
    //   184: invokeinterface 222 1 0
    //   189: checkcast 224	java/lang/Long
    //   192: invokevirtual 228	java/lang/Long:longValue	()J
    //   195: ladd
    //   196: lstore_3
    //   197: goto -26 -> 171
    //   200: aload_0
    //   201: lload_3
    //   202: aload_0
    //   203: getfield 146	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLengths	Ljava/util/List;
    //   206: invokeinterface 209 1 0
    //   211: i2l
    //   212: ldiv
    //   213: putfield 232	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLength	J
    //   216: aload_0
    //   217: getfield 148	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCostList	Ljava/util/List;
    //   220: invokeinterface 205 1 0
    //   225: ifne +67 -> 292
    //   228: aload_0
    //   229: getfield 148	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCostList	Ljava/util/List;
    //   232: invokeinterface 209 1 0
    //   237: istore_1
    //   238: aload_0
    //   239: getfield 148	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCostList	Ljava/util/List;
    //   242: invokeinterface 213 1 0
    //   247: astore 7
    //   249: lconst_0
    //   250: lstore_3
    //   251: aload 7
    //   253: invokeinterface 218 1 0
    //   258: ifeq +26 -> 284
    //   261: lload_3
    //   262: aload 7
    //   264: invokeinterface 222 1 0
    //   269: checkcast 224	java/lang/Long
    //   272: invokevirtual 228	java/lang/Long:longValue	()J
    //   275: lconst_0
    //   276: invokestatic 238	java/lang/Math:max	(JJ)J
    //   279: ladd
    //   280: lstore_3
    //   281: goto -30 -> 251
    //   284: aload_0
    //   285: lload_3
    //   286: iload_1
    //   287: i2l
    //   288: ldiv
    //   289: putfield 240	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCost	J
    //   292: aload_0
    //   293: getfield 150	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLengths	Ljava/util/List;
    //   296: invokeinterface 205 1 0
    //   301: ifne +62 -> 363
    //   304: aload_0
    //   305: getfield 150	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLengths	Ljava/util/List;
    //   308: invokeinterface 213 1 0
    //   313: astore 7
    //   315: lload 5
    //   317: lstore_3
    //   318: aload 7
    //   320: invokeinterface 218 1 0
    //   325: ifeq +22 -> 347
    //   328: lload_3
    //   329: aload 7
    //   331: invokeinterface 222 1 0
    //   336: checkcast 224	java/lang/Long
    //   339: invokevirtual 228	java/lang/Long:longValue	()J
    //   342: ladd
    //   343: lstore_3
    //   344: goto -26 -> 318
    //   347: aload_0
    //   348: lload_3
    //   349: aload_0
    //   350: getfield 150	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLengths	Ljava/util/List;
    //   353: invokeinterface 209 1 0
    //   358: i2l
    //   359: ldiv
    //   360: putfield 242	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLength	J
    //   363: aload_0
    //   364: monitorexit
    //   365: return
    //   366: aload_0
    //   367: monitorexit
    //   368: goto +6 -> 374
    //   371: aload 7
    //   373: athrow
    //   374: goto -3 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	ReportModel
    //   95	192	1	i	int
    //   78	5	2	bool	boolean
    //   108	241	3	l1	long
    //   80	236	5	l2	long
    //   50	1	7	localObject	Object
    //   55	6	7	localThrowable	java.lang.Throwable
    //   105	267	7	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	22	50	finally
    //   22	47	50	finally
    //   57	69	50	finally
    //   69	79	50	finally
    //   86	107	50	finally
    //   109	135	50	finally
    //   138	146	50	finally
    //   146	169	50	finally
    //   171	197	50	finally
    //   200	216	50	finally
    //   216	249	50	finally
    //   251	281	50	finally
    //   284	292	50	finally
    //   292	315	50	finally
    //   318	344	50	finally
    //   347	363	50	finally
    //   2	22	55	java/lang/Throwable
    //   22	47	55	java/lang/Throwable
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
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
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115.ReportModel
 * JD-Core Version:    0.7.0.1
 */