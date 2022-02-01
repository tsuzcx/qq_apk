package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PttInfoCollector
{
  public static final int CHANGE_VOICE = 4;
  public static final int CLICK_COPY = 3;
  public static final int CLICK_DELETE = 2;
  public static final int CLICK_EAR_MODE = 9;
  public static final int CLICK_FAVORIATE = 1;
  public static final int CLICK_FORWARD = 4;
  public static final int CLICK_HANDS_FREE_MODE = 10;
  public static final int CLICK_MORE = 6;
  public static final int CLICK_STT = 5;
  public static final int DECODE_SILK = 1;
  public static final int DISMISS = 7;
  public static final int ENCODE_SILK = 0;
  public static final int FAILED = 3;
  public static final int FINISH = 1;
  public static final int MORE_FORWARD = 8;
  public static final int PTT_DISCUSSION = 2;
  public static final int PTT_DOWNLOAD_TYPE_CHATHISTORY = 5;
  public static final int PTT_DOWNLOAD_TYPE_LOCK_WINDOW = 7;
  public static final int PTT_DOWNLOAD_TYPE_NORMAL = 1;
  public static final int PTT_DOWNLOAD_TYPE_OPENAPI_NORMAL = 3;
  public static final int PTT_DOWNLOAD_TYPE_OPENAPI_REDOWN = 4;
  public static final int PTT_DOWNLOAD_TYPE_PRE_DOWNLOADER = 6;
  public static final int PTT_DOWNLOAD_TYPE_REDOWN = 2;
  public static final int PTT_FRIENDS = 1;
  public static final int PTT_GROUP = 3;
  public static final int PTT_OTHER = 4;
  public static final int PTT_PV_DOWNLOAD = 2;
  public static final int PTT_PV_PLAY = 1;
  public static final int PTT_PV_PRODUCT_D0 = 3;
  public static final int PTT_PV_PRODUCT_F2 = 4;
  public static final int RECEIVING = 2;
  public static final int RECORD_CHANGE_VOICE = 3;
  public static final int RECORD_OFFLINE = 2;
  public static final int RECORD_STREAM = 1;
  public static final int SOUND_CHANGE = 2;
  public static final String TAG = "PttInfoCollector";
  public static final int VOICE_CHANGING = 4;
  static boolean addedObject;
  public static boolean changeLoadedV7;
  static int consumeCount = 0;
  static long consumedSize;
  static long frameConsumedSize;
  static int gcCount;
  static long gcReleasedSize;
  private static Random random = new Random();
  static PhantomReference<Object> reference;
  static ReferenceQueue<Object> referenceQueue;
  static int releaseCount = 0;
  public static long sCostUntilPrepare;
  public static ConcurrentHashMap<String, Long> sPttSendCostRecorder = new ConcurrentHashMap();
  public static long sTotalSendCost;
  public static boolean silkLoadedV7 = false;
  
  static
  {
    changeLoadedV7 = false;
    sCostUntilPrepare = 0L;
    sTotalSendCost = 0L;
    referenceQueue = new ReferenceQueue();
    gcCount = 0;
    addedObject = false;
    consumedSize = 0L;
    frameConsumedSize = 0L;
    gcReleasedSize = 0L;
  }
  
  private static void checkCurrentMemory()
  {
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      long l1 = localRuntime.freeMemory();
      long l2 = localRuntime.totalMemory();
      if (consumedSize != 0L)
      {
        if (l2 - l1 <= consumedSize) {
          break label64;
        }
        frameConsumedSize += l2 - l1 - consumedSize;
        consumeCount += 1;
      }
      for (;;)
      {
        consumedSize = l2 - l1;
        return;
        label64:
        gcReleasedSize += consumedSize - (l2 - l1);
        releaseCount += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void checkGc()
  {
    if (referenceQueue.poll() != null)
    {
      gcCount += 1;
      addedObject = false;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "gc occurred:" + gcCount);
      }
    }
    if (!addedObject)
    {
      reference = new PhantomReference(new Object(), referenceQueue);
      addedObject = true;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "add object enqueue to detect gc");
      }
    }
  }
  
  private static void innerReportPttItemBuilderType(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", paramInt, 0, "", "", "", "8.5.5");
  }
  
  public static final int mergeDownloadPTTFromType(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 0xF) + paramInt1 * 100;
  }
  
  public static void noteOneFrameProcessed()
  {
    checkGc();
    checkCurrentMemory();
  }
  
  public static void reportCostUntilPrepare(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    long l = SystemClock.uptimeMillis() - sCostUntilPrepare;
    if (l > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localStatisticCollector.collectPerformance("", "PTTCostUntilPrepare", true, l, paramInt, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "COST : " + l + " from : " + paramInt);
      }
    }
  }
  
  public static void reportGcAndMemoryUse(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    if (consumeCount != 0) {}
    for (long l1 = frameConsumedSize / consumeCount;; l1 = 0L)
    {
      if (releaseCount != 0) {}
      for (long l2 = gcReleasedSize / releaseCount;; l2 = 0L)
      {
        localHashMap.put("consumePerFrame", String.valueOf(l1));
        localHashMap.put("releasePerGc", String.valueOf(l2));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (QLog.isColorLevel())
        {
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost gcCount=" + gcCount + " type=" + paramInt1 + " time" + paramInt2);
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost consume=" + l1 + " release=" + l2);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttGcCount", true, paramInt2, gcCount, localHashMap, "");
        gcCount = 0;
        addedObject = false;
        referenceQueue.poll();
        consumedSize = 0L;
        frameConsumedSize = 0L;
        gcReleasedSize = 0L;
        consumeCount = 0;
        releaseCount = 0;
        return;
      }
    }
  }
  
  public static void reportLongPressPtt(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttLongPressFate2", false, 0L, 0L, localHashMap, "");
  }
  
  public static void reportMyCpuArch()
  {
    int i = VcSystemInfo.getCpuArchitecture();
    int j = VcSystemInfo.getNumCores();
    long l1 = VcSystemInfo.getMaxCpuFreq();
    long l2 = DeviceInfoUtil.a() / 1048576L;
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cpuArch", String.valueOf(i));
    localHashMap.put("numCores", String.valueOf(j));
    localHashMap.put("maxFreq", String.valueOf(l1));
    localHashMap.put("memory", String.valueOf(l2));
    localHashMap.put("param_FailCode", String.valueOf(i));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttCpuArch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void reportNoRange(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttNoRangeFailed", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void reportPTTPV(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1C", "0X8005C1C", i * 10 + paramInt1 * 100 + paramInt2, 0, "", "", "", "8.5.5");
      return;
    }
  }
  
  public static void reportPttDownloadStream2Offline(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void reportPttItemBuilderType(QQAppInterface paramQQAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (!(paramMessageRecord instanceof MessageForPtt)) {}
    for (;;)
    {
      return;
      if (paramMessageRecord.getPttStreamFlag() != 10001)
      {
        if (!paramMessageRecord.isSend()) {
          break;
        }
        if (((MessageForPtt)paramMessageRecord).voiceChangeFlag == 1) {}
        while ((i != 0) && (paramInt == 1001))
        {
          innerReportPttItemBuilderType(paramQQAppInterface, 4);
          return;
          i = 0;
        }
      }
    }
    switch (paramInt)
    {
    case 2002: 
    case 2004: 
    default: 
      return;
    case 2001: 
      innerReportPttItemBuilderType(paramQQAppInterface, 2);
      return;
    case 2003: 
      innerReportPttItemBuilderType(paramQQAppInterface, 1);
      return;
    }
    innerReportPttItemBuilderType(paramQQAppInterface, 3);
  }
  
  public static void reportPttPlay(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      paramInt1 = 9999;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", paramInt1, paramInt2, "", "", "", "8.5.5");
      return;
    }
  }
  
  public static void reportPttSendCost(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject = (Long)sPttSendCostRecorder.get(paramString);
        if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
          continue;
        }
        if (!paramBoolean1) {
          continue;
        }
        str = "pttSendTotalCost";
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PttInfoCollector", 2, "report sendcost error" + paramString);
        return;
        if (!paramBoolean1) {
          continue;
        }
        continue;
      }
      l1 = SystemClock.uptimeMillis();
      l2 = ((Long)localObject).longValue();
      localObject = new HashMap();
      ((HashMap)localObject).put("isVoiceChange", String.valueOf(paramInt));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, paramBoolean2, l1 - l2, paramLong, (HashMap)localObject, "");
      if ((!paramBoolean1) || (!sPttSendCostRecorder.containsKey(paramString))) {
        return;
      }
      sPttSendCostRecorder.remove(paramString);
      return;
      str = "offlinePttHandleCost";
      continue;
      paramBoolean2 = true;
    }
  }
  
  public static void reportPttSoUpdate(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (paramString.equals("codecsilk")) {
      if (paramBoolean)
      {
        silkLoadedV7 = true;
        i = 0;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", String.valueOf(i));
      paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
      return;
      silkLoadedV7 = false;
      continue;
      if (paramBoolean)
      {
        changeLoadedV7 = true;
        i = 2;
      }
      else
      {
        i = 3;
        changeLoadedV7 = false;
      }
    }
  }
  
  public static void reportPttUploadType(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 10002L) || (paramLong1 == 10004L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static void reportRecordCounts(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localStatisticCollector.collectPerformance("", "PTTStraightRecordCount", false, 0L, 0L, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.d("PttInfoCollector", 4, "pttStraightRecordCount " + paramInt);
    }
  }
  
  public static void reportSoundProcessCost(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    HashMap localHashMap;
    if (Math.abs(random.nextInt() % 100) < 10)
    {
      int i = VcSystemInfo.getCpuArchitecture();
      int j = VcSystemInfo.getNumCores();
      long l1 = VcSystemInfo.getMaxCpuFreq();
      long l2 = DeviceInfoUtil.a() / 1048576L;
      localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(i));
      localHashMap.put("numCores", String.valueOf(j));
      localHashMap.put("maxFreq", String.valueOf(l1));
      localHashMap.put("memory", String.valueOf(l2));
      if (paramInt2 <= 2) {
        break label180;
      }
    }
    label180:
    for (boolean bool = changeLoadedV7;; bool = silkLoadedV7)
    {
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttInfoCollector
 * JD-Core Version:    0.7.0.1
 */