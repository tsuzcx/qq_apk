package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

public class PttInfoCollector
{
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
  public static final int RECEIVING = 2;
  public static final int SOUND_CHANGE = 2;
  public static final String TAG = "PttInfoCollector";
  public static final int VOICE_CHANGING = 4;
  public static boolean changeLoadedV7 = false;
  private static Random random = new Random();
  public static long sTotalSendCost = 0L;
  public static boolean silkLoadedV7 = false;
  
  private static void innerReportPttItemBuilderType(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", paramInt, 0, "", "", "", "8.8.17");
  }
  
  public static void reportCostUntilPrepare(int paramInt)
  {
    Object localObject = StatisticCollector.getInstance(BaseApplication.getContext());
    long l = SystemClock.uptimeMillis() - ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).getsCostUntilPrepare();
    if (l > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      ((StatisticCollector)localObject).collectPerformance("", "PTTCostUntilPrepare", true, l, paramInt, localHashMap, "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("COST : ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" from : ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("PttInfoCollector", 2, ((StringBuilder)localObject).toString());
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
  
  public static void reportPttDownloadStream2Offline(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void reportPttItemBuilderType(QQAppInterface paramQQAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForPtt)) {
      return;
    }
    if (paramMessageRecord.getPttStreamFlag() == 10001) {
      return;
    }
    boolean bool = paramMessageRecord.isSend();
    int i = 1;
    if (bool)
    {
      if (((MessageForPtt)paramMessageRecord).voiceChangeFlag != 1) {
        i = 0;
      }
      if ((i != 0) && (paramInt == 1001)) {
        innerReportPttItemBuilderType(paramQQAppInterface, 4);
      }
    }
    else
    {
      if (paramInt != 2001)
      {
        if (paramInt != 2003)
        {
          if ((paramInt != 2005) && (paramInt != 2006)) {
            return;
          }
          innerReportPttItemBuilderType(paramQQAppInterface, 3);
          return;
        }
        innerReportPttItemBuilderType(paramQQAppInterface, 1);
        return;
      }
      innerReportPttItemBuilderType(paramQQAppInterface, 2);
    }
  }
  
  public static void reportPttPlay(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      paramInt1 = 9999;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", paramInt1, paramInt2, "", "", "", "8.8.17");
  }
  
  public static void reportPttSoUpdate(boolean paramBoolean, String paramString)
  {
    boolean bool = paramString.equals("codecsilk");
    int i = 1;
    if (bool)
    {
      if (paramBoolean)
      {
        silkLoadedV7 = true;
        i = 0;
      }
      else
      {
        silkLoadedV7 = false;
      }
    }
    else if (paramBoolean)
    {
      changeLoadedV7 = true;
      i = 2;
    }
    else
    {
      i = 3;
      changeLoadedV7 = false;
    }
    paramString = new HashMap();
    paramString.put("param_FailCode", String.valueOf(i));
    paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
  }
  
  public static void reportRecordCounts(int paramInt)
  {
    Object localObject = StatisticCollector.getInstance(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    ((StatisticCollector)localObject).collectPerformance("", "PTTStraightRecordCount", false, 0L, 0L, localHashMap, "");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pttStraightRecordCount ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("PttInfoCollector", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttInfoCollector
 * JD-Core Version:    0.7.0.1
 */