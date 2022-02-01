package com.tribe.async.async;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.SparseArray;
import com.tribe.async.log.SLog;
import java.util.concurrent.TimeUnit;

public class ExecutorConfig$NetworkExecutorConfig
  implements ExecutorConfig
{
  private static final int DEFAULT_THREAD_COUNT = 3;
  private static final int NETWORK_TYPE_2G = 4;
  private static final int NETWORK_TYPE_3G = 3;
  private static final int NETWORK_TYPE_4G = 2;
  private static final int NETWORK_TYPE_UNKNOWN = 5;
  private static final int NETWORK_TYPE_WIFI = 1;
  private static final int NO_NETWORK = 0;
  private static final SparseArray<Integer> sThreadCountMap = new SparseArray(6);
  private Context mApplication;
  private NetworkInfo mNetworkInfo;
  
  static
  {
    SparseArray localSparseArray = sThreadCountMap;
    Integer localInteger = Integer.valueOf(3);
    localSparseArray.append(0, localInteger);
    sThreadCountMap.append(1, Integer.valueOf(5));
    sThreadCountMap.append(2, Integer.valueOf(4));
    sThreadCountMap.append(3, localInteger);
    sThreadCountMap.append(4, Integer.valueOf(2));
    sThreadCountMap.append(5, localInteger);
  }
  
  public ExecutorConfig$NetworkExecutorConfig(Context paramContext)
  {
    this.mApplication = paramContext;
  }
  
  private static int getCurrentNetType(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnectedOrConnecting()))
    {
      int i = paramNetworkInfo.getType();
      if (i != 0)
      {
        if ((i != 1) && (i != 6) && (i != 9)) {
          return 5;
        }
        return 1;
      }
      i = paramNetworkInfo.getSubtype();
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          return 5;
        case 13: 
        case 14: 
        case 15: 
          return 2;
        }
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        return 3;
      }
      return 4;
    }
    return 0;
  }
  
  private int getThreadCount(NetworkInfo paramNetworkInfo)
  {
    return ((Integer)sThreadCountMap.get(getCurrentNetType(paramNetworkInfo))).intValue();
  }
  
  public int getAliveTime()
  {
    return 15000;
  }
  
  public int getCore()
  {
    this.mNetworkInfo = ((ConnectivityManager)this.mApplication.getSystemService("connectivity")).getActiveNetworkInfo();
    int i = getThreadCount(this.mNetworkInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("network core = ");
    localStringBuilder.append(i);
    SLog.d("ExecutorConfig", localStringBuilder.toString());
    return i;
  }
  
  public int getMaximum()
  {
    int i = getCore() * 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("network max = ");
    localStringBuilder.append(i);
    SLog.d("ExecutorConfig", localStringBuilder.toString());
    return i;
  }
  
  public TimeUnit getTimeUnit()
  {
    return TimeUnit.MILLISECONDS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.async.ExecutorConfig.NetworkExecutorConfig
 * JD-Core Version:    0.7.0.1
 */