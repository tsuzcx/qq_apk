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
    double d1 = 6000;
    double d2 = Math.pow(2.0D, (i - 1) / 2);
    Double.isNaN(d1);
    return (int)(d1 * d2);
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
    RichMediaStrategy.NetPolicy localNetPolicy2 = g2;
    RichMediaStrategy.NetPolicy localNetPolicy1 = localNetPolicy2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        localNetPolicy1 = localNetPolicy2;
        if (paramInt == 2) {
          return localNetPolicy1;
        }
        if (paramInt != 3)
        {
          if ((paramInt != 4) && (paramInt != 5)) {
            return localNetPolicy2;
          }
        }
        else {
          return g3;
        }
      }
      localNetPolicy1 = wifi;
    }
    return localNetPolicy1;
  }
  
  public static int getSleepTime(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int i = paramInt2;
    boolean bool;
    if (!permitRetryWithErrorCode(paramInt1))
    {
      bool = false;
    }
    else
    {
      if (i < paramNetPolicy.getMinTryTime()) {}
      for (;;)
      {
        bool = true;
        break label80;
        if (i >= paramNetPolicy.getMaxTryTime()) {
          break;
        }
        if (paramBoolean)
        {
          if ((paramInt3 >= 3) || (paramLong >= paramNetPolicy.getTimeLimit())) {
            break;
          }
          continue;
        }
        if (paramLong >= paramNetPolicy.getTimeLimit()) {
          break;
        }
      }
    }
    label80:
    int j = paramNetPolicy.getTryInterval();
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = 1;
    }
    double d1 = j;
    double d2 = Math.pow(2.0D, (paramInt2 - 1) / 2);
    Double.isNaN(d1);
    i = (int)(d1 * d2);
    if (!isNetworkError(paramInt1)) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("policy:");
      localStringBuilder.append(paramNetPolicy.getClass().getSimpleName());
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" tryCount:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" elapse:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("isGroup:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" flowTimes:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" canRetry:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" sleeptime:");
      localStringBuilder.append(i);
      QLog.d("RichMediaStrategy", 2, localStringBuilder.toString());
    }
    if (bool) {
      return i;
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
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047);
  }
  
  public static boolean noReportByErrorCode(int paramInt)
  {
    return (paramInt == 9361) || (paramInt == 9037);
  }
  
  private static boolean permitRetryWithErrorCode(int paramInt)
  {
    return (paramInt != 9020) && (paramInt != 9048) && (paramInt != 9042) && (paramInt != 9070) && (paramInt != 9036) && (paramInt != 9063) && (paramInt != 9071) && (paramInt != 9302) && (paramInt != 9072) && (paramInt != 9041) && (paramInt != 9040) && (paramInt != 9037);
  }
  
  public static boolean shouldChangeIp(int paramInt)
  {
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054) || (paramInt == 9014) || (paramInt == 9051) || (paramInt == 9047) || (paramInt == 9360);
  }
  
  public static boolean testMsgUrlDownRetryAndDoSleep(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int i = paramInt2;
    if (!permitRetryWithErrorCode(paramInt1)) {}
    while (i >= 2)
    {
      bool = false;
      break;
    }
    boolean bool = true;
    int j = paramNetPolicy.getTryInterval();
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = 1;
    }
    double d1 = j;
    double d2 = Math.pow(2.0D, (paramInt2 - 1) / 2);
    Double.isNaN(d1);
    i = (int)(d1 * d2);
    if (!isNetworkError(paramInt1)) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgDown policy:");
      localStringBuilder.append(paramNetPolicy.getClass().getSimpleName());
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" tryCount:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" elapse:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("isGroup:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" flowTimes:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" canRetry:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" sleeptime:");
      localStringBuilder.append(i);
      QLog.d("RichMediaStrategy", 2, localStringBuilder.toString());
    }
    if ((bool) && (i > 0))
    {
      paramLong = i;
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
    }
    return bool;
  }
  
  public static boolean testRetryAndDoSleep(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int i = paramInt2;
    boolean bool;
    if (!permitRetryWithErrorCode(paramInt1))
    {
      bool = false;
    }
    else
    {
      if (i < paramNetPolicy.getMinTryTime()) {}
      for (;;)
      {
        bool = true;
        break label80;
        if (i >= paramNetPolicy.getMaxTryTime()) {
          break;
        }
        if (paramBoolean)
        {
          if ((paramInt3 >= 3) || (paramLong >= paramNetPolicy.getTimeLimit())) {
            break;
          }
          continue;
        }
        if (paramLong >= paramNetPolicy.getTimeLimit()) {
          break;
        }
      }
    }
    label80:
    int j = paramNetPolicy.getTryInterval();
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = 1;
    }
    double d1 = j;
    double d2 = Math.pow(2.0D, (paramInt2 - 1) / 2);
    Double.isNaN(d1);
    i = (int)(d1 * d2);
    if (!isNetworkError(paramInt1)) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("policy:");
      localStringBuilder.append(paramNetPolicy.getClass().getSimpleName());
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" tryCount:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" elapse:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("isGroup:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" flowTimes:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" canRetry:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" sleeptime:");
      localStringBuilder.append(i);
      QLog.d("RichMediaStrategy", 2, localStringBuilder.toString());
    }
    if ((bool) && (i > 0))
    {
      paramLong = i;
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
    }
    return bool;
  }
  
  public static void updataFromDpc(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updataFromDpc: dpcString = ");
          localStringBuilder.append(paramString);
          QLog.d("RichMediaStrategy", 2, localStringBuilder.toString());
        }
        paramString = paramString.split("\\|");
        if (paramString != null)
        {
          int i = paramString.length;
          if (i == 3)
          {
            i = 0;
            for (;;)
            {
              if (i < 3) {}
              try
              {
                int j = Integer.valueOf(paramString[i]).intValue();
                if (j <= 0) {
                  return;
                }
                i += 1;
              }
              catch (NumberFormatException paramString)
              {
                QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", paramString);
                break label241;
              }
            }
            TryCount_dpc = Integer.valueOf(paramString[0]).intValue();
            FixSchedulTryCount_dpc = Integer.valueOf(paramString[1]).intValue();
            TryTime_dpc = Integer.valueOf(paramString[2]).intValue() * 1000;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("updataFromDpc: TryCount_dpc = ");
              paramString.append(TryCount_dpc);
              paramString.append(" FixSchedulTryCount_dpc = ");
              paramString.append(FixSchedulTryCount_dpc);
              paramString.append(" TryTime_dpc = ");
              paramString.append(TryTime_dpc);
              QLog.d("RichMediaStrategy", 2, paramString.toString());
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
      }
      label241:
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy
 * JD-Core Version:    0.7.0.1
 */