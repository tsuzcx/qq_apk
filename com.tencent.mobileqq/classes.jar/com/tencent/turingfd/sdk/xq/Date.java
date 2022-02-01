package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Date
{
  public static final String a;
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("turingfd_conf_");
    localStringBuilder.append(native.a);
    localStringBuilder.append("_");
    localStringBuilder.append("xqMini");
    a = localStringBuilder.toString();
  }
  
  public Date(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public static Set<String> a(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    paramContext = b(paramContext, "701");
    if (TextUtils.isEmpty(paramContext)) {
      return localHashSet;
    }
    localHashSet.addAll(Arrays.asList(paramContext.split("_")));
    return localHashSet;
  }
  
  /* Error */
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 39	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: invokeinterface 92 1 0
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: aload_1
    //   32: invokeinterface 98 1 0
    //   37: invokeinterface 102 1 0
    //   42: astore_2
    //   43: aload_2
    //   44: invokeinterface 108 1 0
    //   49: ifeq +53 -> 102
    //   52: aload_2
    //   53: invokeinterface 112 1 0
    //   58: checkcast 61	java/lang/String
    //   61: astore_3
    //   62: aload_1
    //   63: aload_3
    //   64: invokeinterface 116 2 0
    //   69: checkcast 61	java/lang/String
    //   72: astore 4
    //   74: aload_0
    //   75: aload_3
    //   76: aload 4
    //   78: invokevirtual 120	java/lang/String:getBytes	()[B
    //   81: invokestatic 125	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   84: invokestatic 128	com/tencent/turingfd/sdk/xq/const:b	([B[B)[B
    //   87: invokestatic 131	com/tencent/turingfd/sdk/xq/const:a	([B)Ljava/lang/String;
    //   90: invokeinterface 137 3 0
    //   95: pop
    //   96: goto -53 -> 43
    //   99: goto -56 -> 43
    //   102: aload_0
    //   103: invokeinterface 140 1 0
    //   108: pop
    //   109: return
    //   110: astore_0
    //   111: goto -99 -> 12
    //   114: astore_3
    //   115: goto -16 -> 99
    //   118: astore_0
    //   119: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramMap	Map<String, String>
    //   42	11	2	localIterator	java.util.Iterator
    //   61	15	3	str1	String
    //   114	1	3	localObject	Object
    //   72	5	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	9	110	finally
    //   74	96	114	finally
    //   102	109	118	finally
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 39	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   4: iconst_0
    //   5: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: goto +5 -> 14
    //   12: aconst_null
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: ldc 143
    //   20: areturn
    //   21: aload_0
    //   22: aload_1
    //   23: ldc 143
    //   25: invokeinterface 147 3 0
    //   30: astore_0
    //   31: aload_0
    //   32: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +5 -> 40
    //   38: aload_0
    //   39: areturn
    //   40: new 61	java/lang/String
    //   43: dup
    //   44: aload_0
    //   45: invokestatic 150	com/tencent/turingfd/sdk/xq/const:b	(Ljava/lang/String;)[B
    //   48: invokestatic 125	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   51: invokestatic 152	com/tencent/turingfd/sdk/xq/const:a	([B[B)[B
    //   54: ldc 154
    //   56: invokespecial 157	java/lang/String:<init>	([BLjava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: goto -51 -> 12
    //   66: astore_0
    //   67: ldc 143
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
  
  public final long a(Context paramContext, String paramString)
  {
    paramContext = b(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    finally
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public synchronized<Long> a(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    synchronized localsynchronized = new synchronized(paramInt);
    paramContext = b(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localsynchronized.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label61:
        break label61;
      }
      paramInt += 1;
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
    a(paramContext, "401", localStringBuilder.toString(), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, false);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, paramBoolean);
  }
  
  public final void a(Context paramContext, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.b.post(new Date.do(this, paramContext, paramMap));
  }
  
  /* Error */
  public Chestnut b(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 229
    //   3: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 6
    //   8: aload 6
    //   10: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +10 -> 23
    //   16: iconst_1
    //   17: invokestatic 234	com/tencent/turingfd/sdk/xq/Chestnut:a	(I)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   20: astore_1
    //   21: aload_1
    //   22: areturn
    //   23: lconst_0
    //   24: lstore_2
    //   25: aload_1
    //   26: ldc 236
    //   28: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 164	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   34: invokevirtual 168	java/lang/Long:longValue	()J
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_1
    //   43: ldc 238
    //   45: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload_1
    //   51: ldc 240
    //   53: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 8
    //   58: aload_1
    //   59: ldc 242
    //   61: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 9
    //   66: aload_1
    //   67: ldc 244
    //   69: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: aload_1
    //   75: ldc 246
    //   77: invokestatic 53	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_1
    //   81: new 248	com/tencent/turingfd/sdk/xq/Chestnut$do
    //   84: dup
    //   85: iconst_0
    //   86: invokespecial 249	com/tencent/turingfd/sdk/xq/Chestnut$do:<init>	(I)V
    //   89: astore 11
    //   91: aload 11
    //   93: lload_2
    //   94: putfield 252	com/tencent/turingfd/sdk/xq/Chestnut$do:b	J
    //   97: aload 11
    //   99: aload 6
    //   101: putfield 253	com/tencent/turingfd/sdk/xq/Chestnut$do:a	Ljava/lang/String;
    //   104: aload 11
    //   106: aload 7
    //   108: putfield 256	com/tencent/turingfd/sdk/xq/Chestnut$do:d	Ljava/lang/String;
    //   111: aload 11
    //   113: aload 8
    //   115: putfield 259	com/tencent/turingfd/sdk/xq/Chestnut$do:e	Ljava/lang/String;
    //   118: aload 11
    //   120: aload 9
    //   122: putfield 262	com/tencent/turingfd/sdk/xq/Chestnut$do:f	Ljava/lang/String;
    //   125: aload 11
    //   127: aload 10
    //   129: putfield 264	com/tencent/turingfd/sdk/xq/Chestnut$do:g	Ljava/lang/String;
    //   132: aload 11
    //   134: new 266	com/tencent/turingfd/sdk/xq/Dew
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 269	com/tencent/turingfd/sdk/xq/Dew:<init>	(Ljava/lang/String;)V
    //   142: putfield 273	com/tencent/turingfd/sdk/xq/Chestnut$do:h	Lcom/tencent/turingfd/sdk/xq/Dew;
    //   145: new 231	com/tencent/turingfd/sdk/xq/Chestnut
    //   148: dup
    //   149: aload 11
    //   151: invokespecial 276	com/tencent/turingfd/sdk/xq/Chestnut:<init>	(Lcom/tencent/turingfd/sdk/xq/Chestnut$do;)V
    //   154: astore_1
    //   155: aload_1
    //   156: areturn
    //   157: iconst_1
    //   158: invokestatic 234	com/tencent/turingfd/sdk/xq/Chestnut:a	(I)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   161: areturn
    //   162: astore_1
    //   163: goto -6 -> 157
    //   166: astore 7
    //   168: goto -126 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	Date
    //   0	171	1	paramContext	Context
    //   24	70	2	l1	long
    //   37	3	4	l2	long
    //   6	94	6	str1	String
    //   48	59	7	str2	String
    //   166	1	7	localObject	Object
    //   56	58	8	str3	String
    //   64	57	9	str4	String
    //   72	56	10	str5	String
    //   89	61	11	localdo	Chestnut.do
    // Exception table:
    //   from	to	target	type
    //   0	21	162	finally
    //   42	155	162	finally
    //   25	39	166	finally
  }
  
  public void b(Context paramContext, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localHashMap.put("902", localStringBuilder.toString());
    a(paramContext, localHashMap);
  }
  
  public void c(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "503", localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Date
 * JD-Core Version:    0.7.0.1
 */