package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlaySDKManager
{
  public static final int BIZID = 20160518;
  public static final int ERR_CODE_FILE_EXPIRED = 14011001;
  public static final int ERR_VIDEO_FILE_DAMAGED = 11022003;
  private static final int PLATFORM_ID = 170303;
  private static final String TAG = "[VideoPlatForm]VideoPlaySDKManager";
  private static volatile VideoPlaySDKManager mInstance;
  private boolean mIsSoLoadSuc;
  private CopyOnWriteArraySet<SDKInitListener> mSDKInstalledListenerSet = new CopyOnWriteArraySet();
  private AtomicInteger mState = new AtomicInteger(0);
  
  public static VideoPlaySDKManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new VideoPlaySDKManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void initSDK(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SuperPlayerSDKMgr.setLibLoader(new VideoPlaySDKManager.2(this));
      SuperPlayerSDKMgr.initSDK(paramContext, 170303, paramContext.getApplicationContext().getExternalCacheDir() + "/superplayer");
      SuperPlayerSDKMgr.setOnLogListener(new VideoPlaySDKManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("[VideoPlatForm]VideoPlaySDKManager", 1, "setLibLoader err.", localException);
      }
    }
  }
  
  public void addSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    if (paramSDKInitListener != null) {
      this.mSDKInstalledListenerSet.add(paramSDKInitListener);
    }
  }
  
  /* Error */
  public void initSDKAsync(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 129	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:addSDKInstalledListener	(Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   7: aload_0
    //   8: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 133	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_1
    //   15: if_icmpeq +14 -> 29
    //   18: aload_0
    //   19: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: invokevirtual 133	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   25: iconst_2
    //   26: if_icmpne +48 -> 74
    //   29: invokestatic 137	com/tencent/mobileqq/videoplatform/util/LogUtil:isColorLevel	()Z
    //   32: ifeq +39 -> 71
    //   35: ldc 17
    //   37: iconst_2
    //   38: new 77	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   45: ldc 139
    //   47: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   54: invokevirtual 133	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   57: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc 144
    //   62: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 148	com/tencent/mobileqq/videoplatform/util/LogUtil:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   78: iconst_1
    //   79: invokevirtual 151	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   82: new 153	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1
    //   85: dup
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 155	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1:<init>	(Lcom/tencent/mobileqq/videoplatform/VideoPlaySDKManager;Landroid/content/Context;)V
    //   91: invokestatic 161	com/tencent/mobileqq/videoplatform/util/LoadSoUtil:loadSo	(Lcom/tencent/mobileqq/videoplatform/api/LoadSoCallback;)V
    //   94: goto -23 -> 71
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	VideoPlaySDKManager
    //   0	102	1	paramContext	Context
    //   0	102	2	paramSDKInitListener	SDKInitListener
    // Exception table:
    //   from	to	target	type
    //   2	29	97	finally
    //   29	71	97	finally
    //   74	94	97	finally
  }
  
  /* Error */
  public boolean isSDKReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 133	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_1
    //   10: iload_1
    //   11: iconst_2
    //   12: if_icmpne +9 -> 21
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoPlaySDKManager
    //   9	4	1	i	int
    //   16	7	2	bool	boolean
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	26	finally
  }
  
  public boolean isSoLoadSuc()
  {
    return this.mIsSoLoadSuc;
  }
  
  public void removeSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    this.mSDKInstalledListenerSet.remove(paramSDKInitListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */