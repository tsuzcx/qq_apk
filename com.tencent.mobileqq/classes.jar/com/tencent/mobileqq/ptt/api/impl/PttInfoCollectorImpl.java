package com.tencent.mobileqq.ptt.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qqaudio.QQAudioReporter;
import com.tencent.mobileqq.qqaudio.QQAudioSystemInfo;
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
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class PttInfoCollectorImpl
  implements IPttInfoCollector
{
  public static final String TAG = "PttInfoCollectorImpl";
  public static boolean addedObject = false;
  public static int consumeCount;
  public static long consumedSize;
  public static long frameConsumedSize;
  public static int gcCount;
  public static long gcReleasedSize;
  public static int releaseCount;
  protected static long sCostUntilPrepare;
  public static ConcurrentHashMap<String, Long> sPttSendCostRecorder = new ConcurrentHashMap();
  protected Random random = new Random();
  protected PhantomReference<Object> reference;
  public ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
  
  public static final int mergeDownloadPTTFromType(int paramInt1, int paramInt2)
  {
    return paramInt1 * 100 + (paramInt2 & 0xF);
  }
  
  public void checkCurrentMemory(Runtime paramRuntime)
  {
    try
    {
      long l1 = paramRuntime.freeMemory();
      long l2 = paramRuntime.totalMemory();
      if (consumedSize != 0L)
      {
        long l3 = l2 - l1;
        if (l3 > consumedSize)
        {
          frameConsumedSize += l3 - consumedSize;
          consumeCount += 1;
        }
        else
        {
          gcReleasedSize += consumedSize - l3;
          releaseCount += 1;
        }
      }
      consumedSize = l2 - l1;
      return;
    }
    catch (Exception paramRuntime)
    {
      paramRuntime.printStackTrace();
    }
  }
  
  public void checkGc()
  {
    if (getPoll() != null)
    {
      gcCount += 1;
      addedObject = false;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gc occurred:");
        localStringBuilder.append(gcCount);
        QLog.e("PttInfoCollectorImpl", 2, localStringBuilder.toString());
      }
    }
    if (!addedObject)
    {
      this.reference = new PhantomReference(new Object(), this.referenceQueue);
      addedObject = true;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollectorImpl", 2, "add object enqueue to detect gc");
      }
    }
  }
  
  protected Object getPoll()
  {
    return this.referenceQueue.poll();
  }
  
  @NotNull
  protected HashMap<String, String> getReportHashMap()
  {
    return new HashMap();
  }
  
  @NotNull
  protected HashMap<String, String> getSysReportInfo()
  {
    int i = QQAudioSystemInfo.h();
    int j = QQAudioSystemInfo.g();
    long l1 = QQAudioSystemInfo.f();
    long l2 = DeviceInfoUtil.a() / 1048576L;
    HashMap localHashMap = getReportHashMap();
    localHashMap.put("cpuArch", String.valueOf(i));
    localHashMap.put("numCores", String.valueOf(j));
    localHashMap.put("maxFreq", String.valueOf(l1));
    localHashMap.put("memory", String.valueOf(l2));
    return localHashMap;
  }
  
  public long getsCostUntilPrepare()
  {
    return sCostUntilPrepare;
  }
  
  public void noteOneFrameProcessed()
  {
    checkGc();
    checkCurrentMemory(Runtime.getRuntime());
  }
  
  public void putPttSendCostRecorder(String paramString, Long paramLong)
  {
    sPttSendCostRecorder.put(paramString, paramLong);
  }
  
  protected void realReportInner(long paramLong1, String paramString, boolean paramBoolean, long paramLong2, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, paramBoolean, paramLong2, paramLong1, paramHashMap, "");
  }
  
  public void reportGcAndMemoryUse(int paramInt1, int paramInt2)
  {
    Object localObject = getReportHashMap();
    ((HashMap)localObject).put("type", String.valueOf(paramInt1));
    int i = consumeCount;
    long l1;
    if (i != 0) {
      l1 = frameConsumedSize / i;
    } else {
      l1 = 0L;
    }
    i = releaseCount;
    long l2;
    if (i != 0) {
      l2 = gcReleasedSize / i;
    } else {
      l2 = 0L;
    }
    ((HashMap)localObject).put("consumePerFrame", String.valueOf(l1));
    ((HashMap)localObject).put("releasePerGc", String.valueOf(l2));
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportSoundProcessCost gcCount=");
      localStringBuilder.append(gcCount);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" time");
      localStringBuilder.append(paramInt2);
      QLog.e("PttInfoCollectorImpl", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportSoundProcessCost consume=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" release=");
      localStringBuilder.append(l2);
      QLog.e("PttInfoCollectorImpl", 2, localStringBuilder.toString());
    }
    realReportInner(gcCount, "actPttGcCount", true, paramInt2, (HashMap)localObject);
    gcCount = 0;
    addedObject = false;
    localObject = this.referenceQueue;
    if (localObject != null) {
      ((ReferenceQueue)localObject).poll();
    }
    consumedSize = 0L;
    frameConsumedSize = 0L;
    gcReleasedSize = 0L;
    consumeCount = 0;
    releaseCount = 0;
  }
  
  public void reportNoRange(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    realReportInner(0L, "actPttNoRangeFailed", paramBoolean, 0L, localHashMap);
  }
  
  public void reportPTTPV(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void reportPttSendCost(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = (Long)sPttSendCostRecorder.get(paramString);
        if ((localObject2 != null) && (((Long)localObject2).longValue() > 0L))
        {
          if (!paramBoolean1) {
            break label168;
          }
          localObject1 = "pttSendTotalCost";
          break label173;
          long l1 = SystemClock.uptimeMillis();
          long l2 = ((Long)localObject2).longValue();
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("isVoiceChange", String.valueOf(paramInt));
          ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
          realReportInner(paramLong, (String)localObject1, paramBoolean2, l1 - l2, (HashMap)localObject2);
        }
        if ((paramBoolean1) && (sPttSendCostRecorder.containsKey(paramString)))
        {
          sPttSendCostRecorder.remove(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("report sendcost error");
          ((StringBuilder)localObject1).append(paramString);
          QLog.e("PttInfoCollectorImpl", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label168:
      Object localObject1 = "offlinePttHandleCost";
      label173:
      if (!paramBoolean1) {
        paramBoolean2 = true;
      }
    }
  }
  
  public void reportPttUploadType(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 10002L) || (paramLong1 == 10004L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      realReportInner(paramLong3, "actAllC2CPttUp", paramBoolean, paramLong2, localHashMap);
    }
  }
  
  public void reportSoundProcessCost(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if (Math.abs(this.random.nextInt() % 100) < 10)
    {
      HashMap localHashMap = getSysReportInfo();
      boolean bool;
      if (paramInt2 > 2) {
        bool = QQAudioReporter.b;
      } else {
        bool = QQAudioReporter.a;
      }
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      realReportInner(paramInt1, "actPttProcessFrameCost", true, paramLong1, localHashMap);
    }
  }
  
  public void setsCostUntilPrepare(long paramLong)
  {
    sCostUntilPrepare = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl
 * JD-Core Version:    0.7.0.1
 */