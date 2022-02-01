package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
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
  private static final int REPORT_COUNT_THRESHOLD_FOR_SUBSCRIBE_REPORT = 5;
  private static final int REPORT_COUNT_THRESHOLD_FOR_THIRD_PARTY = 1;
  private static final String TAG = "MiniProgramReporter";
  private static final boolean VERBOSE = false;
  private static final MiniProgramReporter ourInstance = new MiniProgramReporter();
  private List<REPORT.SingleDcData> apiReportDcDataListPool = new ArrayList();
  private List<APP_REPORT_TRANSFER.SingleDcData> gameCPReportDcDataListPool = new ArrayList();
  private long lastMiniApiReportTimeMillis = System.currentTimeMillis();
  private long lastReportLaunchDcDataTime = System.currentTimeMillis();
  private long lastReportTimeMillis = System.currentTimeMillis();
  private long lastSubscribeReportTimeMillis = System.currentTimeMillis();
  private List<APP_REPORT_TRANSFER.SingleDcData> launchDcDataList = new ArrayList();
  private Map<String, String> launchedMiniAppMap = new HashMap();
  private Handler reportHandler;
  private boolean reportLaunchNeedflush = false;
  private List<APP_REPORT_TRANSFER.SingleDcData> singleDcDataListPool = new ArrayList();
  private List<REPORT.SingleDcData> subscribeDcDataListPool = new ArrayList();
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
    if ((System.currentTimeMillis() - this.lastSubscribeReportTimeMillis > TimeUnit.SECONDS.toMillis(180L)) || (this.subscribeDcDataListPool.size() >= 5)) {
      performSubscribeReportToServer();
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
      MiniAppCmdUtil.getInstance().performDataReport(paramArrayOfByte, new MiniProgramReporter.2(this, paramList));
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
    if (!this.apiReportDcDataListPool.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.apiReportDcDataListPool);
      this.apiReportDcDataListPool.clear();
      Object localObject2 = MiniProgramReportHelper.newDcReportReq(localArrayList);
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          localObject2 = ((REPORT.StDcReportReq)localObject2).toByteArray();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("MiniProgramReporter", 2, "performReportToServer", localException);
        }
        if (localObject1 == null) {
          return;
        }
        if (localObject1.length <= 262144)
        {
          performReportViaSSO((byte[])localObject1, localArrayList, "MiniLogSvr.mini_app_apireport.DcReport");
          return;
        }
        int i = localObject1.length / 262144 + 1;
        int m = localArrayList.size() / i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("performReportToServer: split into ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" count");
        QLog.d("MiniProgramReporter", 2, ((StringBuilder)localObject1).toString());
        i = m;
        int k = 0;
        while (i <= localArrayList.size())
        {
          if ((k < i) && (k >= 0) && (i <= localArrayList.size()))
          {
            localObject1 = localArrayList.subList(k, i);
            REPORT.StDcReportReq localStDcReportReq = MiniProgramReportHelper.newDcReportReq((List)localObject1);
            if (localStDcReportReq != null) {
              performReportViaSSO(localStDcReportReq.toByteArray(), (List)localObject1, "MiniLogSvr.mini_app_apireport.DcReport");
            }
          }
          k = i + m;
          int j = k;
          if (k > localArrayList.size()) {
            j = localArrayList.size();
          }
          k = i;
          i = j;
        }
      }
    }
  }
  
  private void performReportLaunchDcDataToServer()
  {
    this.lastReportLaunchDcDataTime = System.currentTimeMillis();
    if (!this.launchDcDataList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.launchDcDataList);
      MiniAppReportManager.recordReportItemToDB(localArrayList);
      this.launchDcDataList.clear();
      Object localObject2 = MiniProgramReportHelper.newDataReportReq(localArrayList);
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("MiniProgramReporter", 2, "performReportLaunchDcDataToServer", localException);
        }
        if (localObject1 == null) {
          return;
        }
        if (localObject1.length <= 262144)
        {
          performDataReportViaSSO((byte[])localObject1, localArrayList);
          return;
        }
        int i = localObject1.length / 262144 + 1;
        int m = localArrayList.size() / i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("performReportLaunchDcDataToServer: split into ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" count");
        QLog.d("MiniProgramReporter", 2, ((StringBuilder)localObject1).toString());
        i = m;
        int k = 0;
        while (i <= localArrayList.size())
        {
          if ((k < i) && (k >= 0) && (i <= localArrayList.size()))
          {
            localObject1 = localArrayList.subList(k, i);
            APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = MiniProgramReportHelper.newDataReportReq((List)localObject1);
            if (localStDataReportReq != null) {
              performDataReportViaSSO(localStDataReportReq.toByteArray(), (List)localObject1);
            }
          }
          k = i + m;
          int j = k;
          if (k > localArrayList.size()) {
            j = localArrayList.size();
          }
          k = i;
          i = j;
        }
      }
    }
  }
  
  private void performReportToServer()
  {
    this.lastReportTimeMillis = System.currentTimeMillis();
    if (!this.singleDcDataListPool.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.singleDcDataListPool);
      this.singleDcDataListPool.clear();
      Object localObject2 = MiniProgramReportHelper.newDataReportReq(localArrayList);
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("MiniProgramReporter", 2, "performReportToServer", localException);
        }
        if (localObject1 == null) {
          return;
        }
        if (localObject1.length <= 262144)
        {
          performDataReportViaSSO((byte[])localObject1, localArrayList);
          return;
        }
        int i = localObject1.length / 262144 + 1;
        int m = localArrayList.size() / i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("performReportToServer: split into ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" count");
        QLog.d("MiniProgramReporter", 2, ((StringBuilder)localObject1).toString());
        i = m;
        int k = 0;
        while (i <= localArrayList.size())
        {
          if ((k < i) && (k >= 0) && (i <= localArrayList.size()))
          {
            localObject1 = localArrayList.subList(k, i);
            APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = MiniProgramReportHelper.newDataReportReq((List)localObject1);
            if (localStDataReportReq != null) {
              performDataReportViaSSO(localStDataReportReq.toByteArray(), (List)localObject1);
            }
          }
          k = i + m;
          int j = k;
          if (k > localArrayList.size()) {
            j = localArrayList.size();
          }
          k = i;
          i = j;
        }
      }
    }
  }
  
  private void performReportViaSSO(byte[] paramArrayOfByte, List<REPORT.SingleDcData> paramList, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      MiniAppCmdUtil.getInstance().performReport(paramArrayOfByte, new MiniProgramReporter.1(this, paramList), paramString);
    }
  }
  
  private void performSubscribeReportToServer()
  {
    this.lastSubscribeReportTimeMillis = System.currentTimeMillis();
    if (!this.subscribeDcDataListPool.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.subscribeDcDataListPool);
      this.subscribeDcDataListPool.clear();
      Object localObject2 = MiniProgramReportHelper.newDcReportReq(localArrayList);
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          localObject2 = ((REPORT.StDcReportReq)localObject2).toByteArray();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("MiniProgramReporter", 2, "performReportToServer", localException);
        }
        if (localObject1 == null) {
          return;
        }
        if (localObject1.length <= 262144)
        {
          performReportViaSSO((byte[])localObject1, localArrayList, "LightAppSvc.mini_app_dcreport.DcReport");
          QLog.d("MiniProgramReporter", 2, "performSubscribeReportToServer via SSO");
          return;
        }
        int i = localObject1.length / 262144 + 1;
        int m = localArrayList.size() / i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("performSubscribeReportToServer: split into ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" count");
        QLog.d("MiniProgramReporter", 2, ((StringBuilder)localObject1).toString());
        i = m;
        int k = 0;
        while (i <= localArrayList.size())
        {
          if ((k < i) && (k >= 0) && (i <= localArrayList.size()))
          {
            localObject1 = localArrayList.subList(k, i);
            REPORT.StDcReportReq localStDcReportReq = MiniProgramReportHelper.newDcReportReq((List)localObject1);
            if (localStDcReportReq != null) {
              performReportViaSSO(localStDcReportReq.toByteArray(), (List)localObject1, "LightAppSvc.mini_app_dcreport.DcReport");
            }
          }
          k = i + m;
          int j = k;
          if (k > localArrayList.size()) {
            j = localArrayList.size();
          }
          k = i;
          i = j;
        }
      }
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
        performReportViaSSO(arrayOfByte, localArrayList, "LightAppSvc.mini_app_dcreport.ThirdDcReport");
      }
    }
  }
  
  private static String prettyDataJSONString(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null) {
      localStringBuilder.append(JSONUtils.a(paramSingleDcData));
    }
    return localStringBuilder.toString();
  }
  
  private static String prettyJSONString(REPORT.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null) {
      localStringBuilder.append(JSONUtils.a(paramSingleDcData));
    }
    return localStringBuilder.toString();
  }
  
  public void add(REPORT.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new MiniProgramReporter.3(this, paramSingleDcData));
  }
  
  public void addAll(Collection<? extends REPORT.SingleDcData> paramCollection)
  {
    this.reportHandler.post(new MiniProgramReporter.6(this, paramCollection));
  }
  
  public void addData(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new MiniProgramReporter.5(this, paramSingleDcData));
  }
  
  public void addDataAll(Collection<? extends APP_REPORT_TRANSFER.SingleDcData> paramCollection)
  {
    this.reportHandler.post(new MiniProgramReporter.7(this, paramCollection));
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
  
  public void batchAddAll(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    this.reportHandler.post(new MiniProgramReporter.4(this, paramList));
  }
  
  public void checkLaunchDcDataConditionAndReport()
  {
    k = 64;
    int i = 10;
    try
    {
      j = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_time_threshold", 10);
      i = j;
      int m = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_count_threshold", 64);
      i = j;
      j = m;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j = k;
      }
    }
    if ((System.currentTimeMillis() - this.lastReportLaunchDcDataTime > TimeUnit.SECONDS.toMillis(i * 60)) || (this.launchDcDataList.size() >= j) || (this.reportLaunchNeedflush))
    {
      reportImmediatelyLaunchDcData();
      this.reportLaunchNeedflush = false;
    }
  }
  
  public void flush()
  {
    this.reportHandler.post(new MiniProgramReporter.8(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter
 * JD-Core Version:    0.7.0.1
 */