package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;

public class TPDownloadProxyFactory
{
  private static final String FILE_NAME = "TPDownloadProxyFactory";
  private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
  private static TPDLProxyBindServiceCallback mCallback = null;
  private static boolean mCanUseAIDL;
  private static ServiceConnection mConnection = new TPDownloadProxyFactory.1();
  private static boolean mIsReadyForDownload;
  private static Object mMapObject = new Object();
  private static boolean mUseService;
  private static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap;
  private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap();
  
  static
  {
    mvTPDownloadProxyClientMap = new HashMap();
    mUseService = false;
    mCanUseAIDL = false;
    mIsReadyForDownload = false;
  }
  
  /* Error */
  public static boolean canUseService()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 41	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mUseService	Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifne +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 43	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCanUseAIDL	Z
    //   21: ifne +8 -> 29
    //   24: iconst_0
    //   25: istore_0
    //   26: goto -13 -> 13
    //   29: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +46 -> 80
    //   37: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   40: invokeinterface 77 1 0
    //   45: pop
    //   46: goto -33 -> 13
    //   49: astore_2
    //   50: ldc 8
    //   52: iconst_0
    //   53: ldc 79
    //   55: new 81	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   62: ldc 84
    //   64: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 92	java/lang/Throwable:toString	()Ljava/lang/String;
    //   71: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 99	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_0
    //   82: goto -69 -> 13
    //   85: astore_2
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	81	0	bool1	boolean
    //   8	2	1	bool2	boolean
    //   32	2	2	localTPDownloadProxyFactoryAidl	TPDownloadProxyFactoryAidl
    //   49	19	2	localThrowable	Throwable
    //   85	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   37	46	49	java/lang/Throwable
    //   5	9	85	finally
    //   18	24	85	finally
    //   29	33	85	finally
    //   37	46	85	finally
    //   50	80	85	finally
  }
  
  public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback paramTPDLProxyBindServiceCallback)
  {
    Context localContext = TPDownloadProxyHelper.getContext();
    if (localContext == null)
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService get context null!");
      return false;
    }
    mCallback = paramTPDLProxyBindServiceCallback;
    StringBuilder localStringBuilder = new StringBuilder().append("ensurePlayManagerService ");
    if (localContext == null) {}
    for (paramTPDLProxyBindServiceCallback = "context is null";; paramTPDLProxyBindServiceCallback = "ok")
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", paramTPDLProxyBindServiceCallback);
      try
      {
        paramTPDLProxyBindServiceCallback = new Intent(localContext, TPDownloadProxyService.class);
        localContext.startService(paramTPDLProxyBindServiceCallback);
        if (!localContext.bindService(paramTPDLProxyBindServiceCallback, mConnection, 1)) {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService bind service failed!");
        }
        return true;
      }
      catch (Throwable paramTPDLProxyBindServiceCallback)
      {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService failed, error:" + paramTPDLProxyBindServiceCallback.toString());
      }
    }
    return false;
  }
  
  public static boolean getCanUseAIDL()
  {
    try
    {
      boolean bool = mCanUseAIDL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getNativeVersion()
  {
    if (!mUseService) {
      return TPDownloadProxyNative.getInstance().getNativeVersion();
    }
    if (!mCanUseAIDL) {
      return TPDownloadProxyNative.getInstance().getNativeVersion();
    }
    if (downloadProxyFactoryAidl != null) {
      try
      {
        String str = downloadProxyFactoryAidl.getNativeVersion();
        return str;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getNativeVersion failed, error:" + localThrowable.toString());
      }
    }
    return TPDownloadProxyNative.getInstance().getNativeVersion();
  }
  
  public static ITPDownloadProxy getTPDownloadProxy(int paramInt)
  {
    if (paramInt <= 0)
    {
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy is invalid, serviceType:" + paramInt);
      return null;
    }
    if (mUseService)
    {
      if (mCanUseAIDL) {
        try
        {
          ITPDownloadProxy localITPDownloadProxy1 = getTPDownloadProxyService(paramInt);
          return localITPDownloadProxy1;
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, error:" + localThrowable.toString());
          return null;
        }
      }
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, can't use aidl!");
      return null;
    }
    synchronized (mMapObject)
    {
      ITPDownloadProxy localITPDownloadProxy2 = (ITPDownloadProxy)mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
      Object localObject1 = localITPDownloadProxy2;
      if (localITPDownloadProxy2 == null)
      {
        localObject1 = new TPDownloadProxy(paramInt);
        mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
      }
      return localObject1;
    }
  }
  
  private static ITPDownloadProxy getTPDownloadProxyService(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (downloadProxyFactoryAidl != null) {
          synchronized (mvTPDownloadProxyClientMap)
          {
            TPDownloadProxyClient localTPDownloadProxyClient3 = (TPDownloadProxyClient)mvTPDownloadProxyClientMap.get(Integer.valueOf(paramInt));
            TPDownloadProxyClient localTPDownloadProxyClient1 = localTPDownloadProxyClient3;
            if (localTPDownloadProxyClient3 == null) {}
            try
            {
              localTPDownloadProxyClient1 = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(paramInt));
              mvTPDownloadProxyClientMap.put(Integer.valueOf(paramInt), localTPDownloadProxyClient1);
              return localTPDownloadProxyClient1;
            }
            catch (Throwable localThrowable)
            {
              TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, error:" + localThrowable.toString());
              TPDownloadProxyClient localTPDownloadProxyClient2 = localTPDownloadProxyClient3;
              continue;
            }
          }
        }
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, aidl is null!");
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static boolean getUseService()
  {
    return mUseService;
  }
  
  /* Error */
  public static boolean isReadyForDownload()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 41	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mUseService	Z
    //   8: ifne +41 -> 49
    //   11: ldc 8
    //   13: iconst_0
    //   14: ldc 79
    //   16: new 81	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   23: ldc 203
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: getstatic 45	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mIsReadyForDownload	Z
    //   31: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 112	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   40: getstatic 45	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mIsReadyForDownload	Z
    //   43: istore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: iload_0
    //   48: ireturn
    //   49: iload_1
    //   50: istore_0
    //   51: getstatic 43	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCanUseAIDL	Z
    //   54: ifeq -10 -> 44
    //   57: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   60: astore_2
    //   61: iload_1
    //   62: istore_0
    //   63: aload_2
    //   64: ifnull -20 -> 44
    //   67: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   70: invokeinterface 208 1 0
    //   75: istore_0
    //   76: goto -32 -> 44
    //   79: astore_2
    //   80: ldc 8
    //   82: iconst_0
    //   83: ldc 79
    //   85: new 81	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   92: ldc 210
    //   94: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 92	java/lang/Throwable:toString	()Ljava/lang/String;
    //   101: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 99	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   110: iload_1
    //   111: istore_0
    //   112: goto -68 -> 44
    //   115: astore_2
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	69	0	bool1	boolean
    //   1	110	1	bool2	boolean
    //   60	4	2	localTPDownloadProxyFactoryAidl	TPDownloadProxyFactoryAidl
    //   79	19	2	localThrowable	Throwable
    //   115	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	76	79	java/lang/Throwable
    //   5	44	115	finally
    //   51	61	115	finally
    //   67	76	115	finally
    //   80	110	115	finally
  }
  
  /* Error */
  public static boolean isReadyForPlay()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 41	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mUseService	Z
    //   8: ifne +42 -> 50
    //   11: invokestatic 147	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   14: invokevirtual 213	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isReadyForWork	()Z
    //   17: istore_0
    //   18: ldc 8
    //   20: iconst_0
    //   21: ldc 79
    //   23: new 81	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   30: ldc 215
    //   32: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_0
    //   36: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 112	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_0
    //   49: ireturn
    //   50: iload_1
    //   51: istore_0
    //   52: getstatic 43	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCanUseAIDL	Z
    //   55: ifeq -10 -> 45
    //   58: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   61: astore_2
    //   62: iload_1
    //   63: istore_0
    //   64: aload_2
    //   65: ifnull -20 -> 45
    //   68: getstatic 57	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   71: invokeinterface 77 1 0
    //   76: istore_0
    //   77: goto -32 -> 45
    //   80: astore_2
    //   81: ldc 8
    //   83: iconst_0
    //   84: ldc 79
    //   86: new 81	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   93: ldc 217
    //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 92	java/lang/Throwable:toString	()Ljava/lang/String;
    //   102: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 99	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   111: iload_1
    //   112: istore_0
    //   113: goto -68 -> 45
    //   116: astore_2
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	96	0	bool1	boolean
    //   1	111	1	bool2	boolean
    //   61	4	2	localTPDownloadProxyFactoryAidl	TPDownloadProxyFactoryAidl
    //   80	19	2	localThrowable	Throwable
    //   116	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	77	80	java/lang/Throwable
    //   5	45	116	finally
    //   52	62	116	finally
    //   68	77	116	finally
    //   81	111	116	finally
  }
  
  private static void setCanUseAIDL(boolean paramBoolean)
  {
    try
    {
      mCanUseAIDL = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setReadyForDownload(boolean paramBoolean)
  {
    try
    {
      mIsReadyForDownload = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    mUseService = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory
 * JD-Core Version:    0.7.0.1
 */