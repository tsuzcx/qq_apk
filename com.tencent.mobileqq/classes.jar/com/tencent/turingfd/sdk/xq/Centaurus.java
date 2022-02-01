package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import java.util.HashMap;

public class Centaurus
{
  public static final String a;
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ias_");
    localStringBuilder.append(native.a);
    localStringBuilder.append("_");
    localStringBuilder.append("xqMini");
    a = localStringBuilder.toString();
  }
  
  public Centaurus(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 39	com/tencent/turingfd/sdk/xq/Centaurus:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 51	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: ldc 53
    //   20: areturn
    //   21: aload_0
    //   22: aload_1
    //   23: ldc 53
    //   25: invokeinterface 59 3 0
    //   30: astore_0
    //   31: aload_0
    //   32: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +5 -> 40
    //   38: aload_0
    //   39: areturn
    //   40: new 67	java/lang/String
    //   43: dup
    //   44: aload_0
    //   45: invokestatic 72	com/tencent/turingfd/sdk/xq/const:b	(Ljava/lang/String;)[B
    //   48: invokestatic 76	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   51: invokestatic 79	com/tencent/turingfd/sdk/xq/const:a	([B[B)[B
    //   54: ldc 81
    //   56: invokespecial 84	java/lang/String:<init>	([BLjava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: goto -51 -> 12
    //   66: astore_0
    //   67: ldc 53
    //   69: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   0	70	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	9	62	finally
    //   40	60	66	finally
  }
  
  public synchronized<Long> a(Context paramContext)
  {
    System.currentTimeMillis();
    synchronized localsynchronized = new synchronized(6);
    paramContext = a(paramContext, "101").split("_");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
      try
      {
        long l = Long.valueOf(str).longValue();
        localsynchronized.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label62:
        break label62;
      }
      i += 1;
    }
    return localsynchronized;
  }
  
  public void a(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    a(paramContext, "201", localStringBuilder.toString(), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    if (paramBoolean)
    {
      a(paramContext, localHashMap);
      return;
    }
    this.b.post(new Cassiopeia(this, paramContext, localHashMap));
  }
  
  /* Error */
  public final void a(Context paramContext, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 39	com/tencent/turingfd/sdk/xq/Centaurus:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 51	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_1
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_1
    //   20: invokeinterface 159 1 0
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: aload_2
    //   32: invokeinterface 165 1 0
    //   37: invokeinterface 171 1 0
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 177 1 0
    //   49: ifeq +56 -> 105
    //   52: aload_3
    //   53: invokeinterface 181 1 0
    //   58: checkcast 67	java/lang/String
    //   61: astore 4
    //   63: aload_2
    //   64: aload 4
    //   66: invokeinterface 185 2 0
    //   71: checkcast 67	java/lang/String
    //   74: astore 5
    //   76: aload_1
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 188	java/lang/String:getBytes	()[B
    //   84: invokestatic 76	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   87: invokestatic 190	com/tencent/turingfd/sdk/xq/const:b	([B[B)[B
    //   90: invokestatic 193	com/tencent/turingfd/sdk/xq/const:a	([B)Ljava/lang/String;
    //   93: invokeinterface 199 3 0
    //   98: pop
    //   99: goto -56 -> 43
    //   102: goto -59 -> 43
    //   105: aload_1
    //   106: invokeinterface 202 1 0
    //   111: pop
    //   112: return
    //   113: astore_1
    //   114: goto -102 -> 12
    //   117: astore 4
    //   119: goto -17 -> 102
    //   122: astore_1
    //   123: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	Centaurus
    //   0	124	1	paramContext	Context
    //   0	124	2	paramMap	java.util.Map<String, String>
    //   42	11	3	localIterator	java.util.Iterator
    //   61	17	4	str1	String
    //   117	1	4	localObject	Object
    //   74	6	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	9	113	finally
    //   76	99	117	finally
    //   105	112	122	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Centaurus
 * JD-Core Version:    0.7.0.1
 */