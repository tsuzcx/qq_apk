package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKHandlerThreadPool
{
  public static final int MAX_COUNT = 3;
  private static final int MAX_USE_SHARE_COUNT = 6;
  private static final String PRE_THREAD_POOL_NAME = "TVK_HandlerThreadPool";
  public static final String TAG = "TVKHandlerThreadPool";
  private static volatile HandlerThread sHandlerThread = null;
  private Map<HandlerThread, Handler> idleHandlerThreadSet = new HashMap();
  private int mShareThreadCount = 0;
  
  public static TVKHandlerThreadPool getInstance()
  {
    return TVKHandlerThreadPool.HOLDER.pool;
  }
  
  private static void initHandlerThread()
  {
    for (;;)
    {
      try
      {
        if (sHandlerThread == null)
        {
          sHandlerThread = new HandlerThread("TVK_ShareThreadPool");
          sHandlerThread.start();
          if (sHandlerThread.getLooper() != null) {}
        }
      }
      finally {}
      try
      {
        sHandlerThread.quit();
        sHandlerThread = new HandlerThread("TVK_ShareThreadPool");
        sHandlerThread.start();
        return;
      }
      finally {}
      if (!sHandlerThread.isAlive()) {
        sHandlerThread.start();
      }
    }
  }
  
  public HandlerThread obtain(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return obtain(str, 5);
  }
  
  public HandlerThread obtain(String paramString, int paramInt)
  {
    if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_handler_pool.getValue()).booleanValue())
    {
      paramString = new HandlerThread(paramString);
      paramString.start();
      return paramString;
    }
    String str = paramString;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          str = "TVK_HandlerThreadPool";
        }
        paramString = this.idleHandlerThreadSet.entrySet().iterator();
        if (!paramString.hasNext()) {
          break label277;
        }
        HandlerThread localHandlerThread = (HandlerThread)((Map.Entry)paramString.next()).getKey();
        if (localHandlerThread != null)
        {
          ((Handler)this.idleHandlerThreadSet.get(localHandlerThread)).removeCallbacksAndMessages(null);
          this.idleHandlerThreadSet.remove(localHandlerThread);
          TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread obtain:" + localHandlerThread.getName());
          localHandlerThread.setName(str);
          localHandlerThread.setPriority(paramInt);
          paramString = localHandlerThread;
          if (localHandlerThread.getLooper() == null)
          {
            localHandlerThread.quit();
            paramString = new TVKHandlerThread(str, paramInt);
            paramString.start();
            TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread obtain:" + str + " create");
          }
          return paramString;
        }
      }
      finally {}
      paramString = new TVKHandlerThread(str, paramInt);
      paramString.start();
      TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread obtain:" + str + " create");
      continue;
      label277:
      paramString = new TVKHandlerThread(str, paramInt);
      paramString.start();
      TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread create:" + str + " create");
    }
  }
  
  public HandlerThread obtainShareThread(String paramString)
  {
    
    try
    {
      if (this.mShareThreadCount >= 6)
      {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = "";
        }
        paramString = obtain(str, 5);
        return paramString;
      }
      this.mShareThreadCount += 1;
      TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread obtainShareThread mShareThreadCount:" + this.mShareThreadCount);
      paramString = sHandlerThread;
      return paramString;
    }
    finally {}
  }
  
  public void quitThread(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {}
    try
    {
      if (paramHandlerThread.isAlive()) {
        paramHandlerThread.quit();
      }
      this.idleHandlerThreadSet.remove(paramHandlerThread);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void recycle(HandlerThread paramHandlerThread, Handler paramHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ifnull +8 -> 14
    //   9: aload_2
    //   10: aconst_null
    //   11: invokevirtual 132	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   14: ldc 2
    //   16: monitorenter
    //   17: aload_1
    //   18: getstatic 26	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:sHandlerThread	Landroid/os/HandlerThread;
    //   21: invokevirtual 191	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +50 -> 74
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 37	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:mShareThreadCount	I
    //   32: iconst_1
    //   33: isub
    //   34: putfield 37	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:mShareThreadCount	I
    //   37: ldc 16
    //   39: new 137	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   46: ldc 193
    //   48: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 37	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:mShareThreadCount	I
    //   55: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 157	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: ldc 2
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: ldc 2
    //   76: monitorexit
    //   77: getstatic 86	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:is_use_handler_pool	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   80: invokevirtual 92	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   83: checkcast 94	java/lang/Boolean
    //   86: invokevirtual 97	java/lang/Boolean:booleanValue	()Z
    //   89: ifne +9 -> 98
    //   92: aload_1
    //   93: invokevirtual 64	android/os/HandlerThread:quit	()Z
    //   96: pop
    //   97: return
    //   98: aload_0
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 35	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:idleHandlerThreadSet	Ljava/util/Map;
    //   104: aload_1
    //   105: invokeinterface 196 2 0
    //   110: ifne +123 -> 233
    //   113: aload_0
    //   114: getfield 35	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:idleHandlerThreadSet	Ljava/util/Map;
    //   117: invokeinterface 200 1 0
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_3
    //   125: if_icmpge +108 -> 233
    //   128: new 128	android/os/Handler
    //   131: dup
    //   132: aload_1
    //   133: invokevirtual 60	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   136: invokespecial 203	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   139: astore_2
    //   140: aload_0
    //   141: getfield 35	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:idleHandlerThreadSet	Ljava/util/Map;
    //   144: aload_1
    //   145: aload_2
    //   146: invokeinterface 207 3 0
    //   151: pop
    //   152: ldc 16
    //   154: new 137	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   161: ldc 140
    //   163: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 148	android/os/HandlerThread:getName	()Ljava/lang/String;
    //   170: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 209
    //   175: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 157	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: monitorexit
    //   186: return
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: astore_2
    //   193: ldc 16
    //   195: new 137	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   202: ldc 211
    //   204: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 148	android/os/HandlerThread:getName	()Ljava/lang/String;
    //   211: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 213
    //   216: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 157	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_1
    //   226: invokevirtual 64	android/os/HandlerThread:quit	()Z
    //   229: pop
    //   230: goto -46 -> 184
    //   233: ldc 16
    //   235: new 137	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   242: ldc 140
    //   244: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 148	android/os/HandlerThread:getName	()Ljava/lang/String;
    //   251: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 213
    //   256: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 157	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 35	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:idleHandlerThreadSet	Ljava/util/Map;
    //   269: aload_1
    //   270: invokeinterface 196 2 0
    //   275: ifeq +14 -> 289
    //   278: aload_0
    //   279: getfield 35	com/tencent/qqlive/tvkplayer/tools/utils/TVKHandlerThreadPool:idleHandlerThreadSet	Ljava/util/Map;
    //   282: aload_1
    //   283: invokeinterface 135 2 0
    //   288: pop
    //   289: aload_1
    //   290: invokevirtual 64	android/os/HandlerThread:quit	()Z
    //   293: pop
    //   294: goto -110 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	TVKHandlerThreadPool
    //   0	297	1	paramHandlerThread	HandlerThread
    //   0	297	2	paramHandler	Handler
    //   122	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   17	67	68	finally
    //   69	72	68	finally
    //   74	77	68	finally
    //   100	123	187	finally
    //   128	184	187	finally
    //   184	186	187	finally
    //   188	190	187	finally
    //   193	230	187	finally
    //   233	289	187	finally
    //   289	294	187	finally
    //   128	184	192	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool
 * JD-Core Version:    0.7.0.1
 */