package com.tencent.mobileqq.utils;

public class BaseDeviceInfoUtil
{
  private static long a;
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: getstatic 17	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifne +162 -> 167
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: new 19	java/io/FileReader
    //   16: dup
    //   17: ldc 21
    //   19: invokespecial 24	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: astore_1
    //   25: new 26	java/io/BufferedReader
    //   28: dup
    //   29: aload_0
    //   30: sipush 1024
    //   33: invokespecial 29	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 33	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +24 -> 67
    //   46: aload_1
    //   47: ldc 35
    //   49: invokevirtual 41	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: iconst_1
    //   53: aaload
    //   54: invokestatic 47	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   57: invokevirtual 50	java/lang/Long:longValue	()J
    //   60: ldc2_w 51
    //   63: lmul
    //   64: putstatic 17	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   67: aload_3
    //   68: invokevirtual 55	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 56	java/io/FileReader:close	()V
    //   75: goto +51 -> 126
    //   78: goto +48 -> 126
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: goto +65 -> 149
    //   87: goto +16 -> 103
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_1
    //   95: goto +54 -> 149
    //   98: aconst_null
    //   99: astore_0
    //   100: aload 4
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: aload_0
    //   106: astore_1
    //   107: lconst_0
    //   108: putstatic 17	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 55	java/io/BufferedReader:close	()V
    //   119: aload_0
    //   120: ifnull +6 -> 126
    //   123: goto -52 -> 71
    //   126: getstatic 17	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   129: lconst_0
    //   130: lcmp
    //   131: ifne +36 -> 167
    //   134: ldc2_w 57
    //   137: lreturn
    //   138: astore_3
    //   139: aload_2
    //   140: astore 4
    //   142: aload_1
    //   143: astore_0
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 55	java/io/BufferedReader:close	()V
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 56	java/io/FileReader:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: getstatic 17	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   170: lreturn
    //   171: astore_0
    //   172: goto -74 -> 98
    //   175: astore_1
    //   176: aload 4
    //   178: astore_3
    //   179: goto -76 -> 103
    //   182: astore_1
    //   183: goto -96 -> 87
    //   186: astore_0
    //   187: goto -109 -> 78
    //   190: astore_0
    //   191: goto -26 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	140	0	localObject1	Object
    //   171	1	0	localException1	java.lang.Exception
    //   186	1	0	localException2	java.lang.Exception
    //   190	1	0	localException3	java.lang.Exception
    //   24	130	1	localObject2	Object
    //   175	1	1	localException4	java.lang.Exception
    //   182	1	1	localException5	java.lang.Exception
    //   9	1	2	localObject3	Object
    //   81	1	2	localObject4	Object
    //   90	1	2	localObject5	Object
    //   104	62	2	localObject6	Object
    //   36	80	3	localObject7	Object
    //   138	7	3	localObject8	Object
    //   178	1	3	localObject9	Object
    //   11	166	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	81	finally
    //   46	67	81	finally
    //   13	23	90	finally
    //   25	37	138	finally
    //   107	111	138	finally
    //   13	23	171	java/lang/Exception
    //   25	37	175	java/lang/Exception
    //   37	42	182	java/lang/Exception
    //   46	67	182	java/lang/Exception
    //   67	71	186	java/lang/Exception
    //   71	75	186	java/lang/Exception
    //   115	119	186	java/lang/Exception
    //   153	157	190	java/lang/Exception
    //   161	165	190	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseDeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */