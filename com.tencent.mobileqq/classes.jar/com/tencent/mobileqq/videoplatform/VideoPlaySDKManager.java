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
  private static final int PLATFORM_ID = 170303;
  private static final String TAG = "[VideoPlatForm]VideoPlaySDKManager";
  private static volatile VideoPlaySDKManager mInstance;
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
  
  /* Error */
  public void initSDKAsync(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 38	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mSDKInstalledListenerSet	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   10: aload_2
    //   11: invokevirtual 117	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_0
    //   16: getfield 33	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   19: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   22: iconst_1
    //   23: if_icmpeq +14 -> 37
    //   26: aload_0
    //   27: getfield 33	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   33: iconst_2
    //   34: if_icmpne +48 -> 82
    //   37: invokestatic 125	com/tencent/mobileqq/videoplatform/util/LogUtil:isColorLevel	()Z
    //   40: ifeq +39 -> 79
    //   43: ldc 15
    //   45: iconst_2
    //   46: new 69	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   53: ldc 127
    //   55: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 33	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   62: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   65: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 132
    //   70: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 136	com/tencent/mobileqq/videoplatform/util/LogUtil:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: getfield 33	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   86: iconst_1
    //   87: invokevirtual 139	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   90: new 141	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1
    //   93: dup
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial 143	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1:<init>	(Lcom/tencent/mobileqq/videoplatform/VideoPlaySDKManager;Landroid/content/Context;)V
    //   99: invokestatic 149	com/tencent/mobileqq/videoplatform/util/LoadSoUtil:loadSo	(Lcom/tencent/mobileqq/videoplatform/api/LoadSoCallback;)V
    //   102: goto -23 -> 79
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	VideoPlaySDKManager
    //   0	110	1	paramContext	Context
    //   0	110	2	paramSDKInitListener	SDKInitListener
    // Exception table:
    //   from	to	target	type
    //   6	15	105	finally
    //   15	37	105	finally
    //   37	79	105	finally
    //   82	102	105	finally
  }
  
  /* Error */
  public boolean isSDKReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:get	()I
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
  
  public void removeSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    this.mSDKInstalledListenerSet.remove(paramSDKInitListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */