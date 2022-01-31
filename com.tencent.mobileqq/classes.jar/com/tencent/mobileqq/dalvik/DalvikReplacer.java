package com.tencent.mobileqq.dalvik;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;

public class DalvikReplacer
{
  public static final int ERR_ART = 15;
  private static final int ERR_FIND = 6;
  private static final int ERR_FIND_EXC = 7;
  private static final int ERR_GC_HEAP = 18;
  private static final int ERR_HEAP_0 = 20;
  private static final int ERR_HEAP_EXC = 16;
  private static final int ERR_HEAP_SOURCE = 19;
  private static final int ERR_ING = 2;
  private static final int ERR_MAP_EMPTY = 5;
  private static final int ERR_MAP_EXC = 4;
  private static final int ERR_MATCH_LA = 17;
  public static final int ERR_OK = 21;
  private static final int ERR_REP_ALLOC = 8;
  private static final int ERR_REP_EXP = 10;
  private static final int ERR_REP_MMAP = 9;
  private static final int ERR_SO_LOAD = 3;
  private static final int ERR_VER_EXC = 14;
  private static final int ERR_VER_HIT = 12;
  private static final int ERR_VER_MODE = 13;
  public static final int ERR_VIRGIN = 1;
  public static final int SIZE_LINEARALLOC_GINGERBREAD = 5242880;
  public static final int SIZE_LINEARALLOC_ICS = 8388608;
  public static final int SIZE_LINEARALLOC_JB = 16777216;
  private static final int SYSTEM_PAGE_SIZE = 4096;
  public static int sArtHackResult = 1;
  public static int sHeapResult;
  public static int sLaResult = 1;
  public static int sVerifyResult = 1;
  
  static
  {
    sHeapResult = 1;
  }
  
  public static void artHack(Context paramContext, long paramLong1, long paramLong2)
  {
    if (sArtHackResult == 1) {
      if ((paramLong2 <= paramLong1) || (Build.VERSION.SDK_INT != 23)) {
        break label117;
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if (i != 0)
      {
        sArtHackResult = 2;
        localObject = null;
        if (!DalvikInternals.loadLib(paramContext)) {
          break label144;
        }
      }
      try
      {
        long[] arrayOfLong = new MappingReader().getReadableMaps();
        localObject = arrayOfLong;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
        sArtHackResult = i;
        return;
      }
      if ((localObject == null) || (localObject.length <= 1)) {
        break label139;
      }
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLargeMemoryClass();
      i = DalvikInternals.modArtHeap(localObject, (int)paramLong1, i * 1024 * 1024, (int)paramLong2);
      if (i != 0) {
        break;
      }
      sArtHackResult = 21;
      return;
    }
    label139:
    sArtHackResult = 5;
    return;
    label144:
    sArtHackResult = 3;
  }
  
  /* Error */
  public static void dvmHack(Context paramContext, int paramInt, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: getstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   3: iconst_1
    //   4: if_icmpne +303 -> 307
    //   7: getstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   10: iconst_1
    //   11: if_icmpne +296 -> 307
    //   14: iconst_2
    //   15: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   18: iconst_2
    //   19: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   22: iload_2
    //   23: ifeq +285 -> 308
    //   26: getstatic 80	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 20
    //   31: if_icmpgt +277 -> 308
    //   34: iconst_1
    //   35: istore 5
    //   37: lload_3
    //   38: invokestatic 122	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   41: invokevirtual 126	java/lang/Runtime:maxMemory	()J
    //   44: lcmp
    //   45: ifle +269 -> 314
    //   48: getstatic 80	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 20
    //   53: if_icmpgt +261 -> 314
    //   56: iconst_1
    //   57: istore 6
    //   59: iload 5
    //   61: ifne +8 -> 69
    //   64: iload 6
    //   66: ifeq +547 -> 613
    //   69: ldc 128
    //   71: invokestatic 134	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 12
    //   76: aload 12
    //   78: ifnull +535 -> 613
    //   81: aload 12
    //   83: ldc 136
    //   85: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   88: istore_2
    //   89: iload_2
    //   90: ifeq +523 -> 613
    //   93: iconst_0
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 6
    //   99: invokestatic 145	com/tencent/mobileqq/dalvik/DalvikReplacer:getLinearAllocLimit	()I
    //   102: iload_1
    //   103: if_icmpge +222 -> 325
    //   106: iconst_1
    //   107: istore 7
    //   109: iload 5
    //   111: ifne +13 -> 124
    //   114: iload 7
    //   116: ifne +8 -> 124
    //   119: iload 6
    //   121: ifeq +462 -> 583
    //   124: aload_0
    //   125: invokestatic 86	com/tencent/mobileqq/dalvik/DalvikInternals:loadLib	(Landroid/content/Context;)Z
    //   128: istore_2
    //   129: iload_2
    //   130: ifeq +474 -> 604
    //   133: new 88	com/tencent/mobileqq/dalvik/MappingReader
    //   136: dup
    //   137: invokespecial 89	com/tencent/mobileqq/dalvik/MappingReader:<init>	()V
    //   140: astore 12
    //   142: aload 12
    //   144: invokevirtual 93	com/tencent/mobileqq/dalvik/MappingReader:getReadableMaps	()[J
    //   147: astore 14
    //   149: aload 12
    //   151: astore 13
    //   153: aload 14
    //   155: astore 12
    //   157: lconst_0
    //   158: lstore 10
    //   160: iload 7
    //   162: ifeq +284 -> 446
    //   165: iload_2
    //   166: ifeq +270 -> 436
    //   169: aload 12
    //   171: ifnull +255 -> 426
    //   174: aload 12
    //   176: arraylength
    //   177: iconst_1
    //   178: if_icmple +248 -> 426
    //   181: aload 13
    //   183: aload 12
    //   185: invokestatic 149	com/tencent/mobileqq/dalvik/DalvikReplacer:findLinearAllocHeader	(Lcom/tencent/mobileqq/dalvik/MappingReader;[J)J
    //   188: lstore 8
    //   190: lload 8
    //   192: lconst_0
    //   193: lcmp
    //   194: ifgt +161 -> 355
    //   197: lload 8
    //   199: lstore 10
    //   201: bipush 6
    //   203: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   206: iload 6
    //   208: ifeq +335 -> 543
    //   211: iload_2
    //   212: ifeq +59 -> 271
    //   215: aload 12
    //   217: ifnull +319 -> 536
    //   220: aload 12
    //   222: arraylength
    //   223: iconst_1
    //   224: if_icmple +312 -> 536
    //   227: lload 8
    //   229: lstore 10
    //   231: getstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   234: bipush 21
    //   236: if_icmpne +23 -> 259
    //   239: lload 8
    //   241: lstore 10
    //   243: lload 8
    //   245: lconst_0
    //   246: lcmp
    //   247: ifne +12 -> 259
    //   250: aload 13
    //   252: aload 12
    //   254: invokestatic 149	com/tencent/mobileqq/dalvik/DalvikReplacer:findLinearAllocHeader	(Lcom/tencent/mobileqq/dalvik/MappingReader;[J)J
    //   257: lstore 10
    //   259: lload 10
    //   261: lconst_0
    //   262: lcmp
    //   263: ifgt +194 -> 457
    //   266: bipush 6
    //   268: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   271: iload 5
    //   273: ifeq +304 -> 577
    //   276: iload_2
    //   277: ifeq +295 -> 572
    //   280: aload 12
    //   282: ifnull +285 -> 567
    //   285: aload 12
    //   287: arraylength
    //   288: iconst_1
    //   289: if_icmple +278 -> 567
    //   292: aload 12
    //   294: invokestatic 153	com/tencent/mobileqq/dalvik/DalvikInternals:preverify	([J)I
    //   297: istore_1
    //   298: iload_1
    //   299: ifne +252 -> 551
    //   302: bipush 21
    //   304: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   307: return
    //   308: iconst_0
    //   309: istore 5
    //   311: goto -274 -> 37
    //   314: iconst_0
    //   315: istore 6
    //   317: goto -258 -> 59
    //   320: astore 12
    //   322: goto -223 -> 99
    //   325: iconst_0
    //   326: istore 7
    //   328: goto -219 -> 109
    //   331: astore 13
    //   333: aconst_null
    //   334: astore 12
    //   336: aload 13
    //   338: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   341: aconst_null
    //   342: astore 14
    //   344: aload 12
    //   346: astore 13
    //   348: aload 14
    //   350: astore 12
    //   352: goto -195 -> 157
    //   355: lload 8
    //   357: iload_1
    //   358: sipush 4096
    //   361: invokestatic 157	com/tencent/mobileqq/dalvik/DalvikInternals:replace	(JII)I
    //   364: istore_1
    //   365: iload_1
    //   366: ifne +11 -> 377
    //   369: bipush 21
    //   371: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   374: goto -168 -> 206
    //   377: iload_1
    //   378: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   381: goto -175 -> 206
    //   384: astore 14
    //   386: lload 8
    //   388: lstore 10
    //   390: aload 14
    //   392: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   395: lload 8
    //   397: lstore 10
    //   399: bipush 10
    //   401: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   404: goto -198 -> 206
    //   407: astore 14
    //   409: aload 14
    //   411: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   414: bipush 7
    //   416: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   419: lload 10
    //   421: lstore 8
    //   423: goto -217 -> 206
    //   426: iconst_5
    //   427: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   430: lconst_0
    //   431: lstore 8
    //   433: goto -227 -> 206
    //   436: iconst_3
    //   437: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   440: lconst_0
    //   441: lstore 8
    //   443: goto -237 -> 206
    //   446: bipush 21
    //   448: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   451: lconst_0
    //   452: lstore 8
    //   454: goto -248 -> 206
    //   457: aload_0
    //   458: ldc 95
    //   460: invokevirtual 101	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   463: checkcast 103	android/app/ActivityManager
    //   466: invokevirtual 107	android/app/ActivityManager:getLargeMemoryClass	()I
    //   469: sipush 1024
    //   472: imul
    //   473: sipush 1024
    //   476: imul
    //   477: istore_1
    //   478: lload_3
    //   479: iload_1
    //   480: i2l
    //   481: invokestatic 163	java/lang/Math:min	(JJ)J
    //   484: lstore_3
    //   485: aload 12
    //   487: lload 10
    //   489: l2i
    //   490: invokestatic 122	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   493: invokevirtual 126	java/lang/Runtime:maxMemory	()J
    //   496: l2i
    //   497: iload_1
    //   498: lload_3
    //   499: l2i
    //   500: invokestatic 167	com/tencent/mobileqq/dalvik/DalvikInternals:modheap	([JIIII)I
    //   503: istore_1
    //   504: iload_1
    //   505: ifne +24 -> 529
    //   508: bipush 21
    //   510: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   513: goto -242 -> 271
    //   516: astore_0
    //   517: aload_0
    //   518: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   521: bipush 16
    //   523: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   526: goto -255 -> 271
    //   529: iload_1
    //   530: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   533: goto -262 -> 271
    //   536: iconst_5
    //   537: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   540: goto -269 -> 271
    //   543: bipush 21
    //   545: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   548: goto -277 -> 271
    //   551: iload_1
    //   552: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   555: return
    //   556: astore_0
    //   557: aload_0
    //   558: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   561: bipush 14
    //   563: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   566: return
    //   567: iconst_5
    //   568: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   571: return
    //   572: iconst_3
    //   573: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   576: return
    //   577: bipush 21
    //   579: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   582: return
    //   583: bipush 21
    //   585: putstatic 65	com/tencent/mobileqq/dalvik/DalvikReplacer:sHeapResult	I
    //   588: bipush 21
    //   590: putstatic 63	com/tencent/mobileqq/dalvik/DalvikReplacer:sVerifyResult	I
    //   593: bipush 21
    //   595: putstatic 61	com/tencent/mobileqq/dalvik/DalvikReplacer:sLaResult	I
    //   598: return
    //   599: astore 13
    //   601: goto -265 -> 336
    //   604: aconst_null
    //   605: astore 12
    //   607: aconst_null
    //   608: astore 13
    //   610: goto -453 -> 157
    //   613: goto -514 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	paramContext	Context
    //   0	616	1	paramInt	int
    //   0	616	2	paramBoolean	boolean
    //   0	616	3	paramLong	long
    //   35	275	5	i	int
    //   57	259	6	j	int
    //   107	220	7	k	int
    //   188	265	8	l1	long
    //   158	330	10	l2	long
    //   74	219	12	localObject1	Object
    //   320	1	12	localThrowable1	Throwable
    //   334	272	12	localObject2	Object
    //   151	100	13	localObject3	Object
    //   331	6	13	localThrowable2	Throwable
    //   346	1	13	localObject4	Object
    //   599	1	13	localThrowable3	Throwable
    //   608	1	13	localObject5	Object
    //   147	202	14	arrayOfLong	long[]
    //   384	7	14	localThrowable4	Throwable
    //   407	3	14	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   69	76	320	java/lang/Throwable
    //   81	89	320	java/lang/Throwable
    //   133	142	331	java/lang/Throwable
    //   355	365	384	java/lang/Throwable
    //   369	374	384	java/lang/Throwable
    //   377	381	384	java/lang/Throwable
    //   181	190	407	java/lang/Throwable
    //   201	206	407	java/lang/Throwable
    //   390	395	407	java/lang/Throwable
    //   399	404	407	java/lang/Throwable
    //   231	239	516	java/lang/Throwable
    //   250	259	516	java/lang/Throwable
    //   266	271	516	java/lang/Throwable
    //   457	504	516	java/lang/Throwable
    //   508	513	516	java/lang/Throwable
    //   529	533	516	java/lang/Throwable
    //   292	298	556	java/lang/Throwable
    //   302	307	556	java/lang/Throwable
    //   551	555	556	java/lang/Throwable
    //   142	149	599	java/lang/Throwable
  }
  
  private static long findLinearAllocHeader(MappingReader paramMappingReader, long[] paramArrayOfLong)
  {
    Mapping localMapping = paramMappingReader.findMappingByName("LinearAlloc");
    if (localMapping != null)
    {
      paramMappingReader = paramMappingReader.findMappingByName("[heap]");
      long l3 = 0L;
      long l4 = 0L;
      long l2 = l3;
      long l1 = l4;
      if (paramMappingReader != null)
      {
        l2 = l3;
        l1 = l4;
        if (paramMappingReader.readable)
        {
          l2 = paramMappingReader.beginAddr;
          l1 = paramMappingReader.endAddr;
        }
      }
      int i;
      switch (Build.VERSION.SDK_INT)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        return DalvikInternals.find(paramArrayOfLong, 704, 1480, i, 3, 524288, 16777216, l2, l1, 5242880, 16777216, 4100, localMapping.beginAddr);
        i = 20;
        continue;
        i = 24;
      }
    }
    return 0L;
  }
  
  public static int getLinearAllocLimit()
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 11) {
      return 5242880;
    }
    if (i < 16) {
      return 8388608;
    }
    return 16777216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikReplacer
 * JD-Core Version:    0.7.0.1
 */