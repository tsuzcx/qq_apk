package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;

public class RichMediaStrategy
{
  public static final int EOF_EXTRA_RETRY_LIMIT = 5;
  public static final int FIX_SCHEDULE_TRY_COUNT = 3;
  private static int FixSchedulTryCount_dpc = 6;
  public static final int MOBLIE_CONCURRENT_LIMIT = 3;
  public static final int NETWORK_CHG_RETRY_LIMIT = 3;
  public static final int NO_MSF_SUGGEST_RETRY = 450000;
  public static final int POST_DATA_TIMEOUT = 89500;
  public static final int RESPONSE_TIMEOUT = 90000;
  public static final int RICH_BUSI_RETRY = 2;
  public static final int RICH_URL_DOWN_RETRY = 2;
  public static final int TIME_SPACE = 25;
  public static final int TRY_COUNT = 9;
  public static final int TRY_TIME = 480000;
  private static int TryCount_dpc = 18;
  private static int TryTime_dpc = 600000;
  public static RichMediaStrategy.NetPolicy g2 = new RichMediaStrategy.G2();
  public static RichMediaStrategy.NetPolicy g3 = new RichMediaStrategy.G3();
  public static RichMediaStrategy.NetPolicy wifi = new RichMediaStrategy.WIFI();
  
  public static int getDelayTIme(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    return (int)(6000 * Math.pow(2.0D, (i - 1) / 2));
  }
  
  public static int getFixSchedulTryCount_dpc()
  {
    try
    {
      int i = FixSchedulTryCount_dpc;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static RichMediaStrategy.NetPolicy getPolicy(int paramInt)
  {
    RichMediaStrategy.NetPolicy localNetPolicy = g2;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return localNetPolicy;
    case 1: 
    case 4: 
    case 5: 
      return wifi;
    }
    return g3;
  }
  
  public static int getSleepTime(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (!permitRetryWithErrorCode(paramInt1)) {
      bool = false;
    }
    for (;;)
    {
      int j = paramNetPolicy.getTryInterval();
      int i = paramInt2;
      if (paramInt2 == 0) {
        i = 1;
      }
      paramInt2 = (int)(j * Math.pow(2.0D, (i - 1) / 2));
      if (!isNetworkError(paramInt1)) {
        paramInt2 = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + i + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + paramInt2);
      }
      if (!bool) {
        break;
      }
      return paramInt2;
      if (paramInt2 < paramNetPolicy.getMinTryTime()) {
        bool = true;
      } else if (paramInt2 >= paramNetPolicy.getMaxTryTime()) {
        bool = false;
      } else if (paramBoolean)
      {
        if ((paramInt3 < 3) && (paramLong < paramNetPolicy.getTimeLimit())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (paramLong < paramNetPolicy.getTimeLimit()) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return -1;
  }
  
  public static int getTryCount_dpc()
  {
    try
    {
      int i = TryCount_dpc;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getTryTime_dpc()
  {
    try
    {
      int i = TryTime_dpc;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isNetworkError(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean noReportByErrorCode(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9361) || (paramInt == 9037)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean permitRetryWithErrorCode(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 9020) || (paramInt == 9048) || (paramInt == 9042) || (paramInt == 9070) || (paramInt == 9036) || (paramInt == 9063) || (paramInt == 9071) || (paramInt == 9302) || (paramInt == 9072) || (paramInt == 9041) || (paramInt == 9040) || (paramInt == 9037)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean shouldChangeIp(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054) || (paramInt == 9014) || (paramInt == 9051) || (paramInt == 9047) || (paramInt == 9360)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean testMsgUrlDownRetryAndDoSleep(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (!permitRetryWithErrorCode(paramInt1)) {
      bool = false;
    }
    for (;;)
    {
      int j = paramNetPolicy.getTryInterval();
      int i = paramInt2;
      if (paramInt2 == 0) {
        i = 1;
      }
      paramInt2 = (int)(j * Math.pow(2.0D, (i - 1) / 2));
      if (!isNetworkError(paramInt1)) {
        paramInt2 = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "msgDown policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + i + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + paramInt2);
      }
      if ((bool) && (paramInt2 > 0)) {
        paramLong = paramInt2;
      }
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
      if (paramInt2 < 2) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return bool;
  }
  
  public static boolean testRetryAndDoSleep(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (!permitRetryWithErrorCode(paramInt1)) {
      bool = false;
    }
    for (;;)
    {
      int j = paramNetPolicy.getTryInterval();
      int i = paramInt2;
      if (paramInt2 == 0) {
        i = 1;
      }
      paramInt2 = (int)(j * Math.pow(2.0D, (i - 1) / 2));
      if (!isNetworkError(paramInt1)) {
        paramInt2 = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + i + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + paramInt2);
      }
      if ((bool) && (paramInt2 > 0)) {
        paramLong = paramInt2;
      }
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
      if (paramInt2 < paramNetPolicy.getMinTryTime()) {
        bool = true;
      } else if (paramInt2 >= paramNetPolicy.getMaxTryTime()) {
        bool = false;
      } else if (paramBoolean)
      {
        if ((paramInt3 < 3) && (paramLong < paramNetPolicy.getTimeLimit())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (paramLong < paramNetPolicy.getTimeLimit()) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return bool;
  }
  
  public static void updataFromDpc(String paramString)
  {
    int i = 0;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.length() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString = " + paramString);
          }
          paramString = paramString.split("\\|");
          int j;
          if (paramString != null)
          {
            j = paramString.length;
            if (j == 3) {
              if (i >= 3) {
                continue;
              }
            }
          }
          try
          {
            j = Integer.valueOf(paramString[i]).intValue();
            if (j > 0) {
              continue;
            }
          }
          catch (NumberFormatException paramString)
          {
            QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", paramString);
            continue;
          }
          return;
          i += 1;
          continue;
          TryCount_dpc = Integer.valueOf(paramString[0]).intValue();
          FixSchedulTryCount_dpc = Integer.valueOf(paramString[1]).intValue();
          TryTime_dpc = Integer.valueOf(paramString[2]).intValue() * 1000;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RichMediaStrategy", 2, "updataFromDpc: TryCount_dpc = " + TryCount_dpc + " FixSchedulTryCount_dpc = " + FixSchedulTryCount_dpc + " TryTime_dpc = " + TryTime_dpc);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy
 * JD-Core Version:    0.7.0.1
 */