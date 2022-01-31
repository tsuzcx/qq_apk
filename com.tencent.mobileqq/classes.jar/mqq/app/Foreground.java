package mqq.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Foreground
  implements Handler.Callback
{
  private static final int DELAY_BROADCAST = 100;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "ApplicationLife";
  private static Context sContext;
  public static int sCountActivity;
  public static int sCountResume;
  private static Handler sHandler;
  private static String sProcessName;
  private static WeakReference<Activity> sTopActivity;
  
  public static Activity getTopActivity()
  {
    if (sTopActivity != null) {
      return (Activity)sTopActivity.get();
    }
    return null;
  }
  
  public static void init(Context paramContext, Looper paramLooper, String paramString)
  {
    if (sHandler == null) {
      try
      {
        if (sHandler == null)
        {
          sContext = paramContext;
          sProcessName = paramString;
          sHandler = new Handler(paramLooper, new Foreground());
        }
        return;
      }
      finally {}
    }
  }
  
  public static void onPause(AppRuntime paramAppRuntime)
  {
    int i = sCountResume - 1;
    sCountResume = i;
    if ((i <= 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = true;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
    }
  }
  
  public static void onResume(AppRuntime paramAppRuntime)
  {
    int i = sCountResume + 1;
    sCountResume = i;
    if ((i > 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackground_Pause = false;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackground_Pause = paramAppRuntime.isBackground_Pause;
      }
    }
  }
  
  public static void onStart(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    sTopActivity = new WeakReference(paramActivity);
    sCountActivity += 1;
    if ((sCountActivity == 1) || (sCountActivity == 2))
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(0xFFFFFFFF & l), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  public static void onStop(AppRuntime paramAppRuntime)
  {
    int i = sCountActivity - 1;
    sCountActivity = i;
    if (i == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(0xFFFFFFFF & l), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  public static void setReady()
  {
    if (sCountActivity > 0)
    {
      l = SystemClock.uptimeMillis();
      localMessage = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), null);
      sHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    long l = SystemClock.uptimeMillis();
    Message localMessage = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), null);
    sHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public static void updateRuntimeState(AppRuntime paramAppRuntime)
  {
    boolean bool2 = true;
    if (paramAppRuntime != null)
    {
      if (sCountResume <= 0)
      {
        bool1 = true;
        paramAppRuntime.isBackground_Pause = bool1;
        if (sCountActivity > 0) {
          break label91;
        }
      }
      label91:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAppRuntime.isBackground_Stop = bool1;
        Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
        while (localIterator.hasNext())
        {
          AppRuntime localAppRuntime = (AppRuntime)localIterator.next();
          localAppRuntime.isBackground_Pause = paramAppRuntime.isBackground_Pause;
          localAppRuntime.isBackground_Stop = paramAppRuntime.isBackground_Stop;
        }
        bool1 = false;
        break;
      }
    }
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 135	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 64	mqq/app/AppRuntime
    //   7: astore 4
    //   9: aload_1
    //   10: getfield 138	android/os/Message:arg1	I
    //   13: i2l
    //   14: bipush 32
    //   16: lshl
    //   17: aload_1
    //   18: getfield 141	android/os/Message:arg2	I
    //   21: i2l
    //   22: ldc2_w 108
    //   25: land
    //   26: lor
    //   27: lstore_2
    //   28: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +67 -> 98
    //   34: ldc 148
    //   36: iconst_2
    //   37: new 150	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   44: aload_1
    //   45: getfield 154	android/os/Message:what	I
    //   48: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc 160
    //   53: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 52	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   59: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 160
    //   64: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload_2
    //   68: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc 160
    //   73: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 101	mqq/app/Foreground:sCountActivity	I
    //   79: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc 168
    //   84: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 4
    //   89: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: getfield 154	android/os/Message:what	I
    //   102: tableswitch	default:+22 -> 124, 0:+121->223, 1:+24->126
    //   125: ireturn
    //   126: getstatic 101	mqq/app/Foreground:sCountActivity	I
    //   129: ifle +94 -> 223
    //   132: aload 4
    //   134: ifnull +54 -> 188
    //   137: aload 4
    //   139: getfield 125	mqq/app/AppRuntime:isBackground_Stop	Z
    //   142: ifeq +46 -> 188
    //   145: aload 4
    //   147: invokevirtual 182	mqq/app/AppRuntime:onRunningForeground	()V
    //   150: aload 4
    //   152: getfield 72	mqq/app/AppRuntime:subRuntimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   155: invokevirtual 78	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   158: invokeinterface 84 1 0
    //   163: astore_1
    //   164: aload_1
    //   165: invokeinterface 90 1 0
    //   170: ifeq +18 -> 188
    //   173: aload_1
    //   174: invokeinterface 93 1 0
    //   179: checkcast 64	mqq/app/AppRuntime
    //   182: invokevirtual 182	mqq/app/AppRuntime:onRunningForeground	()V
    //   185: goto -21 -> 164
    //   188: new 184	android/content/Intent
    //   191: dup
    //   192: ldc 186
    //   194: invokespecial 189	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   197: astore_1
    //   198: aload_1
    //   199: ldc 191
    //   201: getstatic 52	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   204: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   207: pop
    //   208: aload_1
    //   209: ldc 197
    //   211: lload_2
    //   212: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   215: pop
    //   216: getstatic 50	mqq/app/Foreground:sContext	Landroid/content/Context;
    //   219: aload_1
    //   220: invokevirtual 206	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   223: getstatic 101	mqq/app/Foreground:sCountActivity	I
    //   226: ifne -102 -> 124
    //   229: aload 4
    //   231: ifnull +46 -> 277
    //   234: aload 4
    //   236: invokevirtual 209	mqq/app/AppRuntime:onRunningBackground	()V
    //   239: aload 4
    //   241: getfield 72	mqq/app/AppRuntime:subRuntimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   244: invokevirtual 78	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   247: invokeinterface 84 1 0
    //   252: astore_1
    //   253: aload_1
    //   254: invokeinterface 90 1 0
    //   259: ifeq +18 -> 277
    //   262: aload_1
    //   263: invokeinterface 93 1 0
    //   268: checkcast 64	mqq/app/AppRuntime
    //   271: invokevirtual 209	mqq/app/AppRuntime:onRunningBackground	()V
    //   274: goto -21 -> 253
    //   277: new 184	android/content/Intent
    //   280: dup
    //   281: ldc 211
    //   283: invokespecial 189	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   286: astore_1
    //   287: aload_1
    //   288: ldc 191
    //   290: getstatic 52	mqq/app/Foreground:sProcessName	Ljava/lang/String;
    //   293: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   296: pop
    //   297: aload_1
    //   298: ldc 197
    //   300: lload_2
    //   301: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   304: pop
    //   305: getstatic 50	mqq/app/Foreground:sContext	Landroid/content/Context;
    //   308: aload_1
    //   309: invokevirtual 206	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   312: goto -188 -> 124
    //   315: astore_1
    //   316: goto -192 -> 124
    //   319: astore_1
    //   320: goto -196 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	Foreground
    //   0	323	1	paramMessage	Message
    //   27	274	2	l	long
    //   7	233	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   277	287	315	java/lang/Exception
    //   287	312	319	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.Foreground
 * JD-Core Version:    0.7.0.1
 */