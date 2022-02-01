package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Filbert
{
  public static Filbert a = new Filbert();
  public static Map<Integer, Integer> b;
  public Map<Integer, Integer> c = new HashMap();
  public Map<Integer, Integer> d = new HashMap();
  public Map<Integer, Integer> e = new HashMap();
  public Durian f;
  
  static
  {
    Object localObject = new HashMap();
    b = (Map)localObject;
    Integer localInteger1 = Integer.valueOf(0);
    ((Map)localObject).put(Integer.valueOf(6), localInteger1);
    b.put(Integer.valueOf(19), localInteger1);
    b.put(Integer.valueOf(10001), localInteger1);
    b.put(Integer.valueOf(17), localInteger1);
    b.put(Integer.valueOf(43), localInteger1);
    Map localMap = b;
    localObject = Integer.valueOf(36);
    localMap.put(localObject, localInteger1);
    b.put(Integer.valueOf(45), localInteger1);
    b.put(Integer.valueOf(114), localInteger1);
    localMap = b;
    Integer localInteger2 = Integer.valueOf(10002);
    localMap.put(localInteger2, localInteger1);
    b.put(Integer.valueOf(10003), localInteger1);
    int i = native.a;
    if (i == 108098)
    {
      b.put(localInteger2, localInteger1);
      return;
    }
    if (i == 105668)
    {
      b.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 105928)
    {
      b.put(localObject, localInteger1);
      b.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 108168)
    {
      b.put(localObject, localInteger1);
      b.put(Integer.valueOf(18), localInteger1);
      b.put(Integer.valueOf(2), localInteger1);
      return;
    }
    if (i == 108388) {
      b.put(Integer.valueOf(40), localInteger1);
    }
  }
  
  public String a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.c.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.c.get(localObject3)).intValue() == 0) {
        ((HashSet)localObject1).add(localObject3);
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    localObject2 = new StringBuilder();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      if (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(",");
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(Context paramContext)
  {
    try
    {
      this.c.clear();
      this.c.putAll(b);
      Fig.b.getClass();
      paramContext = Fig.b.c(paramContext);
      localObject = new HashMap();
      if (paramContext == null) {
        break label334;
      }
      Map localMap = paramContext.i;
      paramContext = localMap;
      if (localMap != null) {}
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        for (;;)
        {
          throw paramContext;
        }
        label334:
        paramContext = (Context)localObject;
      }
    }
    this.c.putAll(paramContext);
    paramContext = this.d.keySet().iterator();
    while (paramContext.hasNext())
    {
      i = ((Integer)paramContext.next()).intValue();
      if (a(i)) {
        this.c.put(Integer.valueOf(i), (Integer)this.d.get(Integer.valueOf(i)));
      }
    }
    paramContext = this.e.keySet().iterator();
    while (paramContext.hasNext())
    {
      i = ((Integer)paramContext.next()).intValue();
      if (a(i)) {
        this.c.put(Integer.valueOf(i), (Integer)this.e.get(Integer.valueOf(i)));
      }
    }
    if (a(17))
    {
      this.c.put(Integer.valueOf(40), Integer.valueOf(0));
      this.c.put(Integer.valueOf(43), Integer.valueOf(0));
    }
    paramContext = this.c.keySet().iterator();
    while (paramContext.hasNext()) {
      localObject = (Integer)paramContext.next();
    }
  }
  
  public boolean a(int paramInt)
  {
    if (!this.c.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
  
  /* Error */
  public boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 124	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   5: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: pop
    //   9: getstatic 124	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   12: aload_1
    //   13: invokevirtual 131	com/tencent/turingfd/sdk/xq/Fig:c	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/Lyra;
    //   16: astore 13
    //   18: ldc2_w 144
    //   21: lstore 8
    //   23: aload 13
    //   25: ifnonnull +6 -> 31
    //   28: goto +20 -> 48
    //   31: aload 13
    //   33: getfield 149	com/tencent/turingfd/sdk/xq/Lyra:j	J
    //   36: lstore 10
    //   38: lload 10
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +570 -> 612
    //   45: goto +3 -> 48
    //   48: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   51: lload 4
    //   53: lsub
    //   54: invokestatic 161	java/lang/Math:abs	(J)J
    //   57: lstore 4
    //   59: lload 4
    //   61: lload 8
    //   63: ldc2_w 162
    //   66: lmul
    //   67: lcmp
    //   68: ifgt +7 -> 75
    //   71: aload_0
    //   72: monitorexit
    //   73: iconst_0
    //   74: ireturn
    //   75: iconst_0
    //   76: newarray byte
    //   78: astore 13
    //   80: new 23	java/util/HashMap
    //   83: dup
    //   84: invokespecial 24	java/util/HashMap:<init>	()V
    //   87: astore 14
    //   89: new 95	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   96: astore 15
    //   98: aload 15
    //   100: ldc 98
    //   102: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 15
    //   108: getstatic 43	com/tencent/turingfd/sdk/xq/native:a	I
    //   111: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 14
    //   117: ldc 165
    //   119: aload 15
    //   121: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload 14
    //   130: ldc 168
    //   132: aload_3
    //   133: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload 14
    //   139: ldc 170
    //   141: getstatic 124	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   144: aload_1
    //   145: invokevirtual 173	com/tencent/turingfd/sdk/xq/Fig:a	(Landroid/content/Context;)Ljava/lang/String;
    //   148: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload 14
    //   154: ldc 175
    //   156: aload 6
    //   158: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: new 177	android/util/SparseArray
    //   165: dup
    //   166: invokespecial 178	android/util/SparseArray:<init>	()V
    //   169: aload_1
    //   170: aload 14
    //   172: iload_2
    //   173: invokestatic 183	com/tencent/turingfd/sdk/xq/TNative$aa:e	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   176: astore_3
    //   177: aload_3
    //   178: invokestatic 188	com/tencent/turingfd/sdk/xq/const:b	(Landroid/util/SparseArray;)I
    //   181: ifeq +9 -> 190
    //   184: aload 13
    //   186: astore_3
    //   187: goto +8 -> 195
    //   190: aload_3
    //   191: invokestatic 191	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;)[B
    //   194: astore_3
    //   195: aload_3
    //   196: arraylength
    //   197: istore 7
    //   199: iconst_1
    //   200: istore 12
    //   202: iload 7
    //   204: ifne +6 -> 210
    //   207: goto +272 -> 479
    //   210: aload_0
    //   211: getfield 193	com/tencent/turingfd/sdk/xq/Filbert:f	Lcom/tencent/turingfd/sdk/xq/Durian;
    //   214: checkcast 195	com/tencent/turingfd/sdk/xq/Coconut
    //   217: getfield 198	com/tencent/turingfd/sdk/xq/Coconut:a	Lcom/tencent/turingfd/sdk/xq/Cranberry;
    //   220: astore 6
    //   222: aload 6
    //   224: getfield 203	com/tencent/turingfd/sdk/xq/Cranberry:d	Lcom/tencent/turingfd/sdk/xq/final;
    //   227: getfield 209	com/tencent/turingfd/sdk/xq/final:q	Z
    //   230: ifne +10 -> 240
    //   233: iconst_0
    //   234: newarray byte
    //   236: astore_3
    //   237: goto +30 -> 267
    //   240: aload 6
    //   242: iconst_4
    //   243: aload_3
    //   244: invokevirtual 212	com/tencent/turingfd/sdk/xq/Cranberry:a	(I[B)Lcom/tencent/turingfd/sdk/xq/Damson;
    //   247: astore_3
    //   248: aload_3
    //   249: getfield 216	com/tencent/turingfd/sdk/xq/Damson:b	I
    //   252: ifeq +10 -> 262
    //   255: iconst_0
    //   256: newarray byte
    //   258: astore_3
    //   259: goto +8 -> 267
    //   262: aload_3
    //   263: getfield 219	com/tencent/turingfd/sdk/xq/Damson:c	[B
    //   266: astore_3
    //   267: iload_2
    //   268: iconst_1
    //   269: if_icmpne +24 -> 293
    //   272: new 177	android/util/SparseArray
    //   275: dup
    //   276: invokespecial 178	android/util/SparseArray:<init>	()V
    //   279: aload_3
    //   280: iload_2
    //   281: invokestatic 222	com/tencent/turingfd/sdk/xq/TNative$aa:f	(Landroid/util/SparseArray;[BI)Landroid/util/SparseArray;
    //   284: astore_3
    //   285: aload_3
    //   286: invokestatic 191	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;)[B
    //   289: astore_3
    //   290: goto +14 -> 304
    //   293: iload_2
    //   294: ifne +6 -> 300
    //   297: goto +7 -> 304
    //   300: iconst_0
    //   301: newarray byte
    //   303: astore_3
    //   304: new 224	com/tencent/turingfd/sdk/xq/Norma
    //   307: dup
    //   308: invokespecial 225	com/tencent/turingfd/sdk/xq/Norma:<init>	()V
    //   311: astore 6
    //   313: aload 6
    //   315: new 227	com/tencent/turingfd/sdk/xq/try
    //   318: dup
    //   319: aload_3
    //   320: invokespecial 230	com/tencent/turingfd/sdk/xq/try:<init>	([B)V
    //   323: invokevirtual 233	com/tencent/turingfd/sdk/xq/Norma:a	(Lcom/tencent/turingfd/sdk/xq/try;)V
    //   326: aload 6
    //   328: getfield 235	com/tencent/turingfd/sdk/xq/Norma:c	I
    //   331: istore_2
    //   332: iload_2
    //   333: ifge +6 -> 339
    //   336: goto +137 -> 473
    //   339: iload_2
    //   340: iconst_1
    //   341: if_icmpne +14 -> 355
    //   344: new 133	com/tencent/turingfd/sdk/xq/Lyra
    //   347: dup
    //   348: invokespecial 236	com/tencent/turingfd/sdk/xq/Lyra:<init>	()V
    //   351: astore_3
    //   352: goto +123 -> 475
    //   355: aload 6
    //   357: getfield 239	com/tencent/turingfd/sdk/xq/Norma:d	Lcom/tencent/turingfd/sdk/xq/Lyra;
    //   360: astore 6
    //   362: aload 6
    //   364: ifnonnull +14 -> 378
    //   367: new 133	com/tencent/turingfd/sdk/xq/Lyra
    //   370: dup
    //   371: invokespecial 236	com/tencent/turingfd/sdk/xq/Lyra:<init>	()V
    //   374: astore_3
    //   375: goto +100 -> 475
    //   378: aload 6
    //   380: getfield 136	com/tencent/turingfd/sdk/xq/Lyra:i	Ljava/util/Map;
    //   383: invokeinterface 64 1 0
    //   388: invokeinterface 70 1 0
    //   393: astore_3
    //   394: aload_3
    //   395: invokeinterface 76 1 0
    //   400: ifeq +17 -> 417
    //   403: aload_3
    //   404: invokeinterface 80 1 0
    //   409: checkcast 28	java/lang/Integer
    //   412: astore 13
    //   414: goto -20 -> 394
    //   417: aload 6
    //   419: getfield 242	com/tencent/turingfd/sdk/xq/Lyra:k	Ljava/util/Map;
    //   422: astore 13
    //   424: aload 6
    //   426: astore_3
    //   427: aload 13
    //   429: ifnull +46 -> 475
    //   432: aload 13
    //   434: invokeinterface 64 1 0
    //   439: invokeinterface 70 1 0
    //   444: astore 13
    //   446: aload 6
    //   448: astore_3
    //   449: aload 13
    //   451: invokeinterface 76 1 0
    //   456: ifeq +19 -> 475
    //   459: aload 13
    //   461: invokeinterface 80 1 0
    //   466: checkcast 244	java/lang/String
    //   469: astore_3
    //   470: goto -24 -> 446
    //   473: aconst_null
    //   474: astore_3
    //   475: aload_3
    //   476: ifnonnull +9 -> 485
    //   479: iconst_0
    //   480: istore 12
    //   482: goto +99 -> 581
    //   485: aload_3
    //   486: getfield 136	com/tencent/turingfd/sdk/xq/Lyra:i	Ljava/util/Map;
    //   489: astore 13
    //   491: getstatic 124	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   494: astore 6
    //   496: aload 13
    //   498: ifnull +60 -> 558
    //   501: aload 13
    //   503: invokeinterface 247 1 0
    //   508: ifne +6 -> 514
    //   511: goto +47 -> 558
    //   514: aload 6
    //   516: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   519: pop
    //   520: new 249	com/tencent/turingfd/sdk/xq/case
    //   523: dup
    //   524: sipush 128
    //   527: invokespecial 252	com/tencent/turingfd/sdk/xq/case:<init>	(I)V
    //   530: astore 13
    //   532: aload_3
    //   533: aload 13
    //   535: invokevirtual 255	com/tencent/turingfd/sdk/xq/Lyra:a	(Lcom/tencent/turingfd/sdk/xq/case;)V
    //   538: aload 13
    //   540: invokevirtual 258	com/tencent/turingfd/sdk/xq/case:a	()[B
    //   543: astore_3
    //   544: aload 6
    //   546: aload_1
    //   547: invokevirtual 173	com/tencent/turingfd/sdk/xq/Fig:a	(Landroid/content/Context;)Ljava/lang/String;
    //   550: aload_3
    //   551: invokestatic 263	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;[B)Z
    //   554: pop
    //   555: goto +26 -> 581
    //   558: aload 6
    //   560: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   563: pop
    //   564: new 265	java/io/File
    //   567: dup
    //   568: aload 6
    //   570: aload_1
    //   571: invokevirtual 173	com/tencent/turingfd/sdk/xq/Fig:a	(Landroid/content/Context;)Ljava/lang/String;
    //   574: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   577: invokevirtual 271	java/io/File:delete	()Z
    //   580: pop
    //   581: aload_0
    //   582: monitorexit
    //   583: iload 12
    //   585: ireturn
    //   586: astore_1
    //   587: aload_0
    //   588: monitorexit
    //   589: goto +5 -> 594
    //   592: aload_1
    //   593: athrow
    //   594: goto -2 -> 592
    //   597: astore_3
    //   598: aload 13
    //   600: astore_3
    //   601: goto -406 -> 195
    //   604: astore_3
    //   605: goto -132 -> 473
    //   608: astore_1
    //   609: goto -28 -> 581
    //   612: lload 10
    //   614: lstore 8
    //   616: goto -568 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	Filbert
    //   0	619	1	paramContext	Context
    //   0	619	2	paramInt	int
    //   0	619	3	paramString1	String
    //   0	619	4	paramLong	long
    //   0	619	6	paramString2	String
    //   197	6	7	i	int
    //   21	594	8	l1	long
    //   36	577	10	l2	long
    //   200	384	12	bool	boolean
    //   16	583	13	localObject	Object
    //   87	84	14	localHashMap	HashMap
    //   96	24	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	18	586	finally
    //   31	38	586	finally
    //   48	59	586	finally
    //   75	162	586	finally
    //   177	184	586	finally
    //   190	195	586	finally
    //   195	199	586	finally
    //   210	237	586	finally
    //   240	259	586	finally
    //   262	267	586	finally
    //   285	290	586	finally
    //   485	496	586	finally
    //   501	511	586	finally
    //   514	555	586	finally
    //   558	564	586	finally
    //   162	177	597	finally
    //   272	285	604	finally
    //   304	332	604	finally
    //   344	352	604	finally
    //   355	362	604	finally
    //   367	375	604	finally
    //   378	394	604	finally
    //   394	414	604	finally
    //   417	424	604	finally
    //   432	446	604	finally
    //   449	470	604	finally
    //   564	581	608	finally
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.e.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Filbert
 * JD-Core Version:    0.7.0.1
 */