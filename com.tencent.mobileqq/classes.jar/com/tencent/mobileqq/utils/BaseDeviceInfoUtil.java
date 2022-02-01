package com.tencent.mobileqq.utils;

public class BaseDeviceInfoUtil
{
  private static long a = 0L;
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 10	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +138 -> 147
    //   12: new 19	java/io/FileReader
    //   15: dup
    //   16: ldc 21
    //   18: invokespecial 24	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 26	java/io/BufferedReader
    //   25: dup
    //   26: aload_1
    //   27: sipush 1024
    //   30: invokespecial 29	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 33	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +24 -> 64
    //   43: aload_2
    //   44: ldc 35
    //   46: invokevirtual 41	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: invokestatic 47	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   54: invokevirtual 50	java/lang/Long:longValue	()J
    //   57: ldc2_w 51
    //   60: lmul
    //   61: putstatic 10	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 55	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 56	java/io/FileReader:close	()V
    //   80: getstatic 10	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifne +62 -> 147
    //   88: ldc2_w 57
    //   91: lreturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: lconst_0
    //   100: putstatic 10	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 55	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: ifnull -32 -> 80
    //   115: aload_1
    //   116: invokevirtual 56	java/io/FileReader:close	()V
    //   119: goto -39 -> 80
    //   122: astore_0
    //   123: goto -43 -> 80
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 55	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 56	java/io/FileReader:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: getstatic 10	com/tencent/mobileqq/utils/BaseDeviceInfoUtil:a	J
    //   150: lreturn
    //   151: astore_1
    //   152: goto -7 -> 145
    //   155: astore_0
    //   156: goto -27 -> 129
    //   159: astore_3
    //   160: aload_0
    //   161: astore_2
    //   162: aload_3
    //   163: astore_0
    //   164: goto -35 -> 129
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: aload_3
    //   171: astore_0
    //   172: goto -43 -> 129
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -79 -> 99
    //   181: astore_2
    //   182: goto -83 -> 99
    //   185: astore_0
    //   186: goto -106 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	105	0	localObject1	Object
    //   122	1	0	localException1	java.lang.Exception
    //   126	20	0	localObject2	Object
    //   155	6	0	localObject3	Object
    //   163	9	0	localObject4	Object
    //   175	1	0	localException2	java.lang.Exception
    //   177	1	0	localObject5	Object
    //   185	1	0	localException3	java.lang.Exception
    //   21	56	1	localFileReader	java.io.FileReader
    //   92	1	1	localException4	java.lang.Exception
    //   96	46	1	localObject6	Object
    //   151	1	1	localException5	java.lang.Exception
    //   1	169	2	localObject7	Object
    //   181	1	2	localException6	java.lang.Exception
    //   159	4	3	localObject8	Object
    //   167	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	92	java/lang/Exception
    //   107	111	122	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   12	22	126	finally
    //   133	137	151	java/lang/Exception
    //   141	145	151	java/lang/Exception
    //   22	34	155	finally
    //   34	39	159	finally
    //   43	64	159	finally
    //   99	103	167	finally
    //   22	34	175	java/lang/Exception
    //   34	39	181	java/lang/Exception
    //   43	64	181	java/lang/Exception
    //   68	72	185	java/lang/Exception
    //   76	80	185	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseDeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */