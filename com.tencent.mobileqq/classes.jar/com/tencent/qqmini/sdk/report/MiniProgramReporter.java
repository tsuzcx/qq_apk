package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JSONUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MiniProgramReporter
{
  private static final int INTENT_EXTRA_LIMITATION_IN_BYTE = 262144;
  private static final int REPORT_COUNT_THRESHOLD = 64;
  private static final int REPORT_COUNT_THRESHOLD_FOR_GAME_CP_REPORT = 1;
  private static final int REPORT_COUNT_THRESHOLD_FOR_THIRD_PARTY = 1;
  private static final String TAG = "MiniProgramReporter";
  private static final MiniProgramReporter ourInstance = new MiniProgramReporter();
  private List<REPORT.SingleDcData> apiReportDcDataListPool = new ArrayList();
  private List<APP_REPORT_TRANSFER.SingleDcData> gameCPReportDcDataListPool = new ArrayList();
  private long lastMiniApiReportTimeMillis = System.currentTimeMillis();
  private long lastReportLaunchDcDataTime = System.currentTimeMillis();
  private long lastReportTimeMillis = System.currentTimeMillis();
  private List<APP_REPORT_TRANSFER.SingleDcData> launchDcDataList = new ArrayList();
  private Map<String, String> launchedMiniAppMap = new HashMap();
  private Handler reportHandler;
  private boolean reportLaunchNeedflush = false;
  private List<APP_REPORT_TRANSFER.SingleDcData> singleDcDataListPool = new ArrayList();
  private List<REPORT.SingleDcData> thirdPartyDcDataListPool = new ArrayList();
  
  private MiniProgramReporter()
  {
    HandlerThread localHandlerThread = new HandlerThread("mini_program_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.reportHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private void checkShouldReportToServer()
  {
    if ((intervalBetweenNowAndLastReportTimeGreaterThan10Minutes()) || (this.singleDcDataListPool.size() >= 64)) {
      performReportToServer();
    }
    if ((System.currentTimeMillis() - this.lastMiniApiReportTimeMillis > TimeUnit.SECONDS.toMillis(600L)) || (this.apiReportDcDataListPool.size() >= 64)) {
      performReportApiReportToServer();
    }
    if (this.thirdPartyDcDataListPool.size() >= 1) {
      performThirdPartyReportToServer();
    }
    if (this.gameCPReportDcDataListPool.size() >= 1) {
      performGameCPReportToServer();
    }
  }
  
  public static MiniProgramReporter getInstance()
  {
    return ourInstance;
  }
  
  private boolean intervalBetweenNowAndLastReportTimeGreaterThan10Minutes()
  {
    return System.currentTimeMillis() - this.lastReportTimeMillis > TimeUnit.SECONDS.toMillis(600L);
  }
  
  private void performDataReportViaSSO(byte[] paramArrayOfByte, List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      RequestServer.getInstance().dataReport(paramArrayOfByte, new MiniProgramReporter.2(this, paramList));
    }
  }
  
  private void performGameCPReportToServer()
  {
    if (!this.gameCPReportDcDataListPool.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.gameCPReportDcDataListPool);
      this.gameCPReportDcDataListPool.clear();
      byte[] arrayOfByte = MiniProgramReportHelper.newDataReportReq(localArrayList).toByteArray();
      if (arrayOfByte.length > 0) {
        performDataReportViaSSO(arrayOfByte, localArrayList);
      }
    }
  }
  
  private void performReportApiReportToServer()
  {
    this.lastMiniApiReportTimeMillis = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.apiReportDcDataListPool.isEmpty())
    {
      localArrayList = new ArrayList(this.apiReportDcDataListPool);
      this.apiReportDcDataListPool.clear();
      localObject2 = MiniProgramReportHelper.newDcReportReq(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((REPORT.StDcReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniProgramReporter", "performReportToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label108;
      }
      performReportViaSSO((byte[])localObject1, localArrayList, "mini_app_apireport", "DcReport");
      return;
      label108:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      QMLog.d("MiniProgramReporter", "performReportToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          REPORT.StDcReportReq localStDcReportReq = MiniProgramReportHelper.newDcReportReq((List)localObject1);
          if (localStDcReportReq != null) {
            performReportViaSSO(localStDcReportReq.toByteArray(), (List)localObject1, "mini_app_apireport", "DcReport");
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void performReportLaunchDcDataToServer()
  {
    this.lastReportLaunchDcDataTime = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.launchDcDataList.isEmpty())
    {
      localArrayList = new ArrayList(this.launchDcDataList);
      this.launchDcDataList.clear();
      localObject2 = MiniProgramReportHelper.newDataReportReq(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniProgramReporter", "performReportLaunchDcDataToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label104;
      }
      performDataReportViaSSO((byte[])localObject1, localArrayList);
      return;
      label104:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      QMLog.d("MiniProgramReporter", "performReportLaunchDcDataToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = MiniProgramReportHelper.newDataReportReq((List)localObject1);
          if (localStDataReportReq != null) {
            performDataReportViaSSO(localStDataReportReq.toByteArray(), (List)localObject1);
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void performReportToServer()
  {
    this.lastReportTimeMillis = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.singleDcDataListPool.isEmpty())
    {
      localArrayList = new ArrayList(this.singleDcDataListPool);
      this.singleDcDataListPool.clear();
      localObject2 = MiniProgramReportHelper.newDataReportReq(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniProgramReporter", "performReportToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label104;
      }
      performDataReportViaSSO((byte[])localObject1, localArrayList);
      return;
      label104:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      QMLog.d("MiniProgramReporter", "performReportToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = MiniProgramReportHelper.newDataReportReq((List)localObject1);
          if (localStDataReportReq != null) {
            performDataReportViaSSO(localStDataReportReq.toByteArray(), (List)localObject1);
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void performReportViaSSO(byte[] paramArrayOfByte, List<REPORT.SingleDcData> paramList, String paramString1, String paramString2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).report(paramArrayOfByte, paramString1, paramString2, new MiniProgramReporter.1(this, paramList));
    }
  }
  
  private void performThirdPartyReportToServer()
  {
    if (!this.thirdPartyDcDataListPool.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.thirdPartyDcDataListPool);
      this.thirdPartyDcDataListPool.clear();
      byte[] arrayOfByte = MiniProgramReportHelper.newThirdDcReportReq(localArrayList).toByteArray();
      if (arrayOfByte.length > 0) {
        performReportViaSSO(arrayOfByte, localArrayList, "mini_app_dcreport", "ThirdDcReport");
      }
    }
  }
  
  private static String prettyDataJSONString(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null) {
      localStringBuilder.append(JSONUtils.convert2JSON(paramSingleDcData));
    }
    return localStringBuilder.toString();
  }
  
  private static String prettyJSONString(REPORT.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null) {
      localStringBuilder.append(JSONUtils.convert2JSON(paramSingleDcData));
    }
    return localStringBuilder.toString();
  }
  
  public void add(REPORT.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new MiniProgramReporter.3(this, paramSingleDcData));
  }
  
  public void addAll(Collection<? extends REPORT.SingleDcData> paramCollection)
  {
    this.reportHandler.post(new MiniProgramReporter.5(this, paramCollection));
  }
  
  public void addData(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new MiniProgramReporter.4(this, paramSingleDcData));
  }
  
  public void addDataAll(Collection<? extends APP_REPORT_TRANSFER.SingleDcData> paramCollection)
  {
    this.reportHandler.post(new MiniProgramReporter.6(this, paramCollection));
  }
  
  public void addDcData(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    try
    {
      this.launchDcDataList.add(paramSingleDcData);
      checkLaunchDcDataConditionAndReport();
      return;
    }
    finally
    {
      paramSingleDcData = finally;
      throw paramSingleDcData;
    }
  }
  
  public void addLaunchMiniAppRecord(String paramString1, String paramString2)
  {
    this.launchedMiniAppMap.put(paramString1, paramString2);
  }
  
  public void checkLaunchDcDataConditionAndReport()
  {
    k = 64;
    i = 10;
    try
    {
      j = WnsConfig.getConfig("qqminiapp", "mini_app_report_time_threshold", 10);
      i = j;
      int m = WnsConfig.getConfig("qqminiapp", "mini_app_report_count_threshold", 64);
      i = m;
      k = j;
      j = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j = k;
        k = i;
      }
    }
    if ((System.currentTimeMillis() - this.lastReportLaunchDcDataTime > TimeUnit.SECONDS.toMillis(k * 60)) || (this.launchDcDataList.size() >= j) || (this.reportLaunchNeedflush))
    {
      reportImmediatelyLaunchDcData();
      this.reportLaunchNeedflush = false;
    }
  }
  
  public void flush()
  {
    this.reportHandler.post(new MiniProgramReporter.7(this));
  }
  
  public String getLaunchMiniAppRecord(String paramString)
  {
    return (String)this.launchedMiniAppMap.get(paramString);
  }
  
  public Handler getReportHandler()
  {
    return this.reportHandler;
  }
  
  public void removeLaunchMiniAppRecord(String paramString)
  {
    this.launchedMiniAppMap.remove(paramString);
  }
  
  public void reportImmediatelyLaunchDcData()
  {
    performReportLaunchDcDataToServer();
  }
  
  public void setReportLaunchNeedflush(boolean paramBoolean)
  {
    this.reportLaunchNeedflush = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter
 * JD-Core Version:    0.7.0.1
 */