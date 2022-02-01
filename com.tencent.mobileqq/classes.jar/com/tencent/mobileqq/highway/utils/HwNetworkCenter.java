package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

public class HwNetworkCenter
{
  public static final String Tag = "NetworkCenter";
  public static HwNetworkCenter sNC;
  private Runnable checkRun = new HwNetworkCenter.1(this);
  private String mApnType = "";
  private Context mContext;
  private Handler mHandler;
  private AtomicInteger mNetworkType = new AtomicInteger(0);
  private HandlerThread mUpdateThread = null;
  
  protected HwNetworkCenter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mUpdateThread = new HandlerThread("Highway-BDH-HwNetworkCenter");
    this.mUpdateThread.start();
    this.mHandler = new Handler(this.mUpdateThread.getLooper());
    this.mHandler.postDelayed(this.checkRun, 60000L);
  }
  
  public static HwNetworkCenter getInstance(Context paramContext)
  {
    if (sNC == null) {
      try
      {
        if (sNC == null) {
          sNC = new HwNetworkCenter(paramContext);
        }
      }
      finally {}
    }
    return sNC;
  }
  
  public String getApnType()
  {
    try
    {
      String str = this.mApnType;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getNetType()
  {
    return this.mNetworkType.get();
  }
  
  public void onDestroy()
  {
    this.mContext = null;
  }
  
  public void onNetChange(Context paramContext)
  {
    try
    {
      updateNetInfo(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public void updateNetInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: invokestatic 107	com/tencent/mobileqq/highway/utils/HwNetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 35	com/tencent/mobileqq/highway/utils/HwNetworkCenter:mNetworkType	Ljava/util/concurrent/atomic/AtomicInteger;
    //   18: iload_2
    //   19: invokevirtual 110	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   22: aload_1
    //   23: ldc 112
    //   25: invokevirtual 118	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 120	android/net/ConnectivityManager
    //   31: invokevirtual 124	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_3
    //   38: ifnull +8 -> 46
    //   41: aload_3
    //   42: invokevirtual 129	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_0
    //   47: aload_1
    //   48: invokestatic 134	com/tencent/mobileqq/highway/utils/BdhUtils:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   51: putfield 39	com/tencent/mobileqq/highway/utils/HwNetworkCenter:mApnType	Ljava/lang/String;
    //   54: goto +16 -> 70
    //   57: astore_1
    //   58: goto +15 -> 73
    //   61: astore_1
    //   62: ldc 136
    //   64: ldc 138
    //   66: aload_1
    //   67: invokestatic 144	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	HwNetworkCenter
    //   0	77	1	paramContext	Context
    //   13	6	2	i	int
    //   34	8	3	localNetworkInfo	android.net.NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   9	35	57	finally
    //   41	46	57	finally
    //   46	54	57	finally
    //   62	70	57	finally
    //   9	35	61	java/lang/Exception
    //   41	46	61	java/lang/Exception
    //   46	54	61	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkCenter
 * JD-Core Version:    0.7.0.1
 */