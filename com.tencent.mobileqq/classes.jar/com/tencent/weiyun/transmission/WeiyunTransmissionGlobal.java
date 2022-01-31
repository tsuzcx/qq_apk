package com.tencent.weiyun.transmission;

import android.app.Application;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.OfflineFileHelper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.NetworkUtils.INetworkInfoProvider;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class WeiyunTransmissionGlobal
{
  private static final Lock LOCK = new ReentrantLock();
  private static final String TAG = "WeiyunTransmissionGlobal";
  private static Singleton<WeiyunTransmissionGlobal, Void> sInstance = new Singleton()
  {
    protected WeiyunTransmissionGlobal create(Void paramAnonymousVoid)
    {
      return new WeiyunTransmissionGlobal(null);
    }
  };
  private AppInfo mAppInfo;
  private Application mContext;
  private HostInterface mHostInterface;
  private UploadManager mUploadManager;
  private PowerManager.WakeLock mWakeLock = null;
  private WifiManager.WifiLock mWifiLock = null;
  
  public static WeiyunTransmissionGlobal getInstance()
  {
    return (WeiyunTransmissionGlobal)sInstance.get(null);
  }
  
  /* Error */
  public void acquireWakeLockIfNot()
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:LOCK	Ljava/util/concurrent/locks/Lock;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +25 -> 37
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 75	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mContext	Landroid/app/Application;
    //   20: ldc 77
    //   22: invokevirtual 83	android/app/Application:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   25: checkcast 85	android/os/PowerManager
    //   28: iconst_1
    //   29: ldc 23
    //   31: invokevirtual 89	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   34: putfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   37: aload_0
    //   38: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   41: ifnull +40 -> 81
    //   44: aload_0
    //   45: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   48: invokevirtual 94	android/os/PowerManager$WakeLock:acquire	()V
    //   51: ldc 23
    //   53: new 96	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   60: ldc 99
    //   62: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   69: invokevirtual 107	android/os/PowerManager$WakeLock:isHeld	()Z
    //   72: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   75: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull +39 -> 126
    //   90: aload_0
    //   91: getfield 75	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mContext	Landroid/app/Application;
    //   94: ldc 122
    //   96: invokevirtual 83	android/app/Application:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   99: checkcast 124	android/net/wifi/WifiManager
    //   102: astore_3
    //   103: iconst_1
    //   104: istore_1
    //   105: getstatic 130	android/os/Build$VERSION:SDK_INT	I
    //   108: bipush 12
    //   110: if_icmplt +5 -> 115
    //   113: iconst_3
    //   114: istore_1
    //   115: aload_0
    //   116: aload_3
    //   117: iload_1
    //   118: ldc 23
    //   120: invokevirtual 134	android/net/wifi/WifiManager:createWifiLock	(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;
    //   123: putfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   126: aload_0
    //   127: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +40 -> 172
    //   135: aload_0
    //   136: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   139: invokevirtual 137	android/net/wifi/WifiManager$WifiLock:acquire	()V
    //   142: ldc 23
    //   144: new 96	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   151: ldc 139
    //   153: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   160: invokevirtual 140	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   163: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   166: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_2
    //   173: monitorexit
    //   174: return
    //   175: astore_3
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   181: ldc 23
    //   183: ldc 142
    //   185: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -151 -> 37
    //   191: astore_3
    //   192: aload_2
    //   193: monitorexit
    //   194: aload_3
    //   195: athrow
    //   196: astore_3
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   202: ldc 23
    //   204: ldc 144
    //   206: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -83 -> 126
    //   212: astore_3
    //   213: ldc 23
    //   215: new 96	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   222: ldc 146
    //   224: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   231: invokevirtual 140	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   234: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -71 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	WeiyunTransmissionGlobal
    //   104	14	1	i	int
    //   3	190	2	localLock	Lock
    //   10	122	3	localObject1	Object
    //   175	1	3	localThrowable1	java.lang.Throwable
    //   191	4	3	localObject2	Object
    //   196	1	3	localThrowable2	java.lang.Throwable
    //   212	1	3	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	37	175	java/lang/Throwable
    //   6	11	191	finally
    //   15	37	191	finally
    //   37	81	191	finally
    //   81	86	191	finally
    //   90	103	191	finally
    //   105	113	191	finally
    //   115	126	191	finally
    //   126	131	191	finally
    //   135	172	191	finally
    //   172	174	191	finally
    //   176	188	191	finally
    //   192	194	191	finally
    //   197	209	191	finally
    //   213	243	191	finally
    //   90	103	196	java/lang/Throwable
    //   105	113	196	java/lang/Throwable
    //   115	126	196	java/lang/Throwable
    //   135	172	212	java/lang/Throwable
  }
  
  public AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public Application getApplication()
  {
    return this.mContext;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public HostInterface getHostInterface()
  {
    return this.mHostInterface;
  }
  
  public List<String> getOfflinePath(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return new ArrayList(0);
    }
    return OfflineFileHelper.getOfflineFilePath(paramString1, paramString2, paramString3);
  }
  
  public UploadManager getUploadManager()
  {
    if (this.mUploadManager == null) {
      throw new IllegalStateException("Please call WeiyunLiteGlobal.initTransmission(...) in advance.");
    }
    return this.mUploadManager;
  }
  
  public void initTransmission(AppInfo paramAppInfo, Application paramApplication, HostInterface paramHostInterface, ILog paramILog)
  {
    if ((paramAppInfo == null) || (paramApplication == null) || (paramHostInterface == null)) {
      try
      {
        throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
      }
      finally {}
    }
    this.mAppInfo = paramAppInfo;
    this.mContext = paramApplication;
    this.mHostInterface = paramHostInterface;
    TsLog.setLog(paramILog);
    NetworkUtils.setNetworkInfoProvider(new NetworkUtils.INetworkInfoProvider()
    {
      public NetworkInfo getNetworkInfo(Context paramAnonymousContext)
      {
        return WeiyunTransmissionGlobal.this.mHostInterface.getRecentNetworkInfo();
      }
    });
    WeiyunTransmissionStatus.getInstance().initGlobalStatus(paramApplication);
    this.mUploadManager = UploadManager.getInstance();
    this.mUploadManager.init();
  }
  
  public boolean isNativeUpload()
  {
    return UploadNative.getInstance().isLoaded();
  }
  
  /* Error */
  public void releaseWakeLockIfExist()
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:LOCK	Ljava/util/concurrent/locks/Lock;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +40 -> 52
    //   15: aload_0
    //   16: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   19: invokevirtual 236	android/os/PowerManager$WakeLock:release	()V
    //   22: ldc 23
    //   24: new 96	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   31: ldc 238
    //   33: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: invokevirtual 107	android/os/PowerManager$WakeLock:isHeld	()Z
    //   43: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +40 -> 98
    //   61: aload_0
    //   62: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   65: invokevirtual 239	android/net/wifi/WifiManager$WifiLock:release	()V
    //   68: ldc 23
    //   70: new 96	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   77: ldc 241
    //   79: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   86: invokevirtual 140	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   89: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_1
    //   99: monitorexit
    //   100: return
    //   101: astore_2
    //   102: ldc 23
    //   104: new 96	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   111: ldc 243
    //   113: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   120: invokevirtual 107	android/os/PowerManager$WakeLock:isHeld	()Z
    //   123: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   126: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -80 -> 52
    //   135: astore_2
    //   136: aload_1
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: ldc 23
    //   143: new 96	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   150: ldc 245
    //   152: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 56	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   159: invokevirtual 140	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   162: invokevirtual 110	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 120	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: goto -73 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	WeiyunTransmissionGlobal
    //   3	134	1	localLock	Lock
    //   10	48	2	localObject1	Object
    //   101	1	2	localThrowable1	java.lang.Throwable
    //   135	4	2	localObject2	Object
    //   140	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	52	101	java/lang/Throwable
    //   6	11	135	finally
    //   15	52	135	finally
    //   52	57	135	finally
    //   61	98	135	finally
    //   98	100	135	finally
    //   102	132	135	finally
    //   136	138	135	finally
    //   141	171	135	finally
    //   61	98	140	java/lang/Throwable
  }
  
  public static final class AppInfo
  {
    public String appName;
    public String channelName;
    public boolean isLocal = false;
    public boolean isRdm = false;
    public String qua;
    public int versionCode;
    public String versionName;
    public int wnsAppId;
    
    public AppInfo(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4)
    {
      this.qua = paramString1;
      this.wnsAppId = paramInt1;
      this.appName = paramString2;
      this.versionName = paramString3;
      this.versionCode = paramInt2;
      this.channelName = paramString4;
    }
  }
  
  public static abstract interface HostInterface
  {
    public abstract void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback);
    
    public abstract int getCurrentIsp();
    
    public abstract String getCurrentUid();
    
    public abstract long getCurrentUin();
    
    public abstract NetworkInfo getRecentNetworkInfo();
  }
  
  public static abstract interface UploadServerInfoCallback
  {
    public abstract void onResult(UploadFile paramUploadFile, boolean paramBoolean, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionGlobal
 * JD-Core Version:    0.7.0.1
 */