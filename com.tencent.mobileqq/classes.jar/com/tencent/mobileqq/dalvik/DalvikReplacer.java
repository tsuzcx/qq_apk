package com.tencent.mobileqq.dalvik;

import android.os.Build.VERSION;

public class DalvikReplacer
{
  public static int a = 1;
  public static int b = 1;
  
  public static int a()
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
  
  private static long a(MappingReader paramMappingReader, long[] paramArrayOfLong)
  {
    Mapping localMapping = paramMappingReader.a("LinearAlloc");
    if (localMapping != null)
    {
      paramMappingReader = paramMappingReader.a("[heap]");
      long l3 = 0L;
      long l4 = 0L;
      long l2 = l3;
      long l1 = l4;
      if (paramMappingReader != null)
      {
        l2 = l3;
        l1 = l4;
        if (paramMappingReader.jdField_a_of_type_Boolean)
        {
          l2 = paramMappingReader.jdField_a_of_type_Long;
          l1 = paramMappingReader.b;
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
        return DalvikInternals.find(paramArrayOfLong, 704, 1480, i, 3, 524288, 16777216, l2, l1, 5242880, 16777216, 4100, localMapping.jdField_a_of_type_Long);
        i = 20;
        continue;
        i = 24;
      }
    }
    return 0L;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   3: iconst_1
    //   4: if_icmpne +193 -> 197
    //   7: getstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   10: iconst_1
    //   11: if_icmpne +186 -> 197
    //   14: iconst_2
    //   15: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   18: iconst_2
    //   19: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   22: iload_2
    //   23: ifeq +175 -> 198
    //   26: getstatic 23	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 20
    //   31: if_icmpgt +167 -> 198
    //   34: iconst_1
    //   35: istore_3
    //   36: iload_3
    //   37: istore 4
    //   39: iload_3
    //   40: ifeq +36 -> 76
    //   43: ldc 58
    //   45: invokestatic 64	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: iload_3
    //   51: istore 4
    //   53: aload 7
    //   55: ifnull +21 -> 76
    //   58: aload 7
    //   60: ldc 66
    //   62: invokevirtual 72	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: istore_2
    //   66: iload_3
    //   67: istore 4
    //   69: iload_2
    //   70: ifeq +6 -> 76
    //   73: iconst_0
    //   74: istore 4
    //   76: invokestatic 74	com/tencent/mobileqq/dalvik/DalvikReplacer:a	()I
    //   79: iload_1
    //   80: if_icmpge +123 -> 203
    //   83: iconst_1
    //   84: istore_3
    //   85: iload 4
    //   87: ifne +7 -> 94
    //   90: iload_3
    //   91: ifeq +247 -> 338
    //   94: aconst_null
    //   95: astore 7
    //   97: aload_0
    //   98: invokestatic 77	com/tencent/mobileqq/dalvik/DalvikInternals:a	(Landroid/content/Context;)Z
    //   101: istore_2
    //   102: iload_2
    //   103: ifeq +259 -> 362
    //   106: new 31	com/tencent/mobileqq/dalvik/MappingReader
    //   109: dup
    //   110: invokespecial 78	com/tencent/mobileqq/dalvik/MappingReader:<init>	()V
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 81	com/tencent/mobileqq/dalvik/MappingReader:a	()[J
    //   118: astore 8
    //   120: aload_0
    //   121: astore 7
    //   123: aload 8
    //   125: astore_0
    //   126: iload_3
    //   127: ifeq +171 -> 298
    //   130: iload_2
    //   131: ifeq +160 -> 291
    //   134: aload_0
    //   135: ifnull +149 -> 284
    //   138: aload_0
    //   139: arraylength
    //   140: iconst_1
    //   141: if_icmple +143 -> 284
    //   144: aload 7
    //   146: aload_0
    //   147: invokestatic 83	com/tencent/mobileqq/dalvik/DalvikReplacer:a	(Lcom/tencent/mobileqq/dalvik/MappingReader;[J)J
    //   150: lstore 5
    //   152: lload 5
    //   154: lconst_0
    //   155: lcmp
    //   156: ifgt +69 -> 225
    //   159: bipush 6
    //   161: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   164: iload 4
    //   166: ifeq +166 -> 332
    //   169: iload_2
    //   170: ifeq +157 -> 327
    //   173: aload_0
    //   174: ifnull +148 -> 322
    //   177: aload_0
    //   178: arraylength
    //   179: iconst_1
    //   180: if_icmple +142 -> 322
    //   183: aload_0
    //   184: invokestatic 87	com/tencent/mobileqq/dalvik/DalvikInternals:preverify	([J)I
    //   187: istore_1
    //   188: iload_1
    //   189: ifne +117 -> 306
    //   192: bipush 15
    //   194: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   197: return
    //   198: iconst_0
    //   199: istore_3
    //   200: goto -164 -> 36
    //   203: iconst_0
    //   204: istore_3
    //   205: goto -120 -> 85
    //   208: astore 7
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 7
    //   214: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   217: aload_0
    //   218: astore 7
    //   220: aconst_null
    //   221: astore_0
    //   222: goto -96 -> 126
    //   225: lload 5
    //   227: iload_1
    //   228: sipush 4096
    //   231: invokestatic 94	com/tencent/mobileqq/dalvik/DalvikInternals:replace	(JII)I
    //   234: istore_1
    //   235: iload_1
    //   236: ifne +41 -> 277
    //   239: bipush 15
    //   241: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   244: goto -80 -> 164
    //   247: astore 7
    //   249: aload 7
    //   251: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   254: bipush 10
    //   256: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   259: goto -95 -> 164
    //   262: astore 7
    //   264: aload 7
    //   266: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   269: bipush 7
    //   271: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   274: goto -110 -> 164
    //   277: iload_1
    //   278: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   281: goto -117 -> 164
    //   284: iconst_5
    //   285: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   288: goto -124 -> 164
    //   291: iconst_3
    //   292: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   295: goto -131 -> 164
    //   298: bipush 15
    //   300: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   303: goto -139 -> 164
    //   306: iload_1
    //   307: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   310: return
    //   311: astore_0
    //   312: aload_0
    //   313: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   316: bipush 14
    //   318: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   321: return
    //   322: iconst_5
    //   323: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   326: return
    //   327: iconst_3
    //   328: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   331: return
    //   332: bipush 15
    //   334: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   337: return
    //   338: bipush 15
    //   340: putstatic 13	com/tencent/mobileqq/dalvik/DalvikReplacer:b	I
    //   343: bipush 15
    //   345: putstatic 11	com/tencent/mobileqq/dalvik/DalvikReplacer:a	I
    //   348: return
    //   349: astore 7
    //   351: goto -139 -> 212
    //   354: astore 7
    //   356: iload_3
    //   357: istore 4
    //   359: goto -283 -> 76
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -238 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramContext	android.content.Context
    //   0	367	1	paramInt	int
    //   0	367	2	paramBoolean	boolean
    //   35	322	3	i	int
    //   37	321	4	j	int
    //   150	76	5	l	long
    //   48	97	7	localObject	Object
    //   208	5	7	localThrowable1	java.lang.Throwable
    //   218	1	7	localContext	android.content.Context
    //   247	3	7	localThrowable2	java.lang.Throwable
    //   262	3	7	localThrowable3	java.lang.Throwable
    //   349	1	7	localThrowable4	java.lang.Throwable
    //   354	1	7	localThrowable5	java.lang.Throwable
    //   118	6	8	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   106	114	208	java/lang/Throwable
    //   225	235	247	java/lang/Throwable
    //   239	244	247	java/lang/Throwable
    //   277	281	247	java/lang/Throwable
    //   144	152	262	java/lang/Throwable
    //   159	164	262	java/lang/Throwable
    //   249	259	262	java/lang/Throwable
    //   183	188	311	java/lang/Throwable
    //   192	197	311	java/lang/Throwable
    //   306	310	311	java/lang/Throwable
    //   114	120	349	java/lang/Throwable
    //   43	50	354	java/lang/Throwable
    //   58	66	354	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikReplacer
 * JD-Core Version:    0.7.0.1
 */