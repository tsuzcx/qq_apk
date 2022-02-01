package com.tencent.mobileqq.debug;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class LocalInfoUtils
{
  public static final String a = HardCodeUtil.a(2131699643);
  private static String b;
  private static String c;
  
  public static String a()
  {
    try
    {
      if (TextUtils.isEmpty(b)) {
        a();
      }
      String str = b;
      return str;
    }
    finally {}
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: new 37	java/io/BufferedReader
    //   3: dup
    //   4: new 39	java/io/InputStreamReader
    //   7: dup
    //   8: invokestatic 45	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 49	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc 51
    //   16: invokevirtual 57	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 66	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +96 -> 130
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: ldc 68
    //   42: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   45: istore_0
    //   46: iload_0
    //   47: iconst_m1
    //   48: if_icmple +19 -> 67
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: iload_0
    //   55: bipush 9
    //   57: iadd
    //   58: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: invokevirtual 80	java/lang/String:trim	()Ljava/lang/String;
    //   64: putstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: getstatic 18	com/tencent/mobileqq/debug/LocalInfoUtils:a	Ljava/lang/String;
    //   73: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   76: istore_0
    //   77: iload_0
    //   78: iconst_m1
    //   79: if_icmple +19 -> 98
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: iload_0
    //   86: bipush 9
    //   88: iadd
    //   89: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   92: invokevirtual 80	java/lang/String:trim	()Ljava/lang/String;
    //   95: putstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: ldc 82
    //   103: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   106: istore_0
    //   107: iload_0
    //   108: iconst_m1
    //   109: if_icmple -83 -> 26
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: iload_0
    //   116: iconst_5
    //   117: iadd
    //   118: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   121: invokevirtual 80	java/lang/String:trim	()Ljava/lang/String;
    //   124: putstatic 84	com/tencent/mobileqq/debug/LocalInfoUtils:c	Ljava/lang/String;
    //   127: goto -101 -> 26
    //   130: aload_2
    //   131: invokevirtual 87	java/io/BufferedReader:close	()V
    //   134: goto +38 -> 172
    //   137: astore_3
    //   138: goto +12 -> 150
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_2
    //   144: goto +82 -> 226
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: astore_1
    //   152: aload_3
    //   153: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +15 -> 172
    //   160: aload_2
    //   161: invokevirtual 87	java/io/BufferedReader:close	()V
    //   164: goto +8 -> 172
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   172: new 92	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   179: astore_1
    //   180: aload_1
    //   181: ldc 95
    //   183: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: getstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   191: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: ldc 101
    //   198: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_1
    //   203: getstatic 84	com/tencent/mobileqq/debug/LocalInfoUtils:c	Ljava/lang/String;
    //   206: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 103
    //   212: iconst_2
    //   213: aload_1
    //   214: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_3
    //   222: aload_1
    //   223: astore_2
    //   224: aload_3
    //   225: astore_1
    //   226: aload_2
    //   227: ifnull +15 -> 242
    //   230: aload_2
    //   231: invokevirtual 87	java/io/BufferedReader:close	()V
    //   234: goto +8 -> 242
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   242: goto +5 -> 247
    //   245: aload_1
    //   246: athrow
    //   247: goto -2 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	73	0	i	int
    //   27	87	1	localObject1	Object
    //   141	1	1	localObject2	Object
    //   151	1	1	localObject3	Object
    //   167	2	1	localIOException1	java.io.IOException
    //   179	67	1	localObject4	Object
    //   25	206	2	localObject5	Object
    //   237	2	2	localIOException2	java.io.IOException
    //   32	83	3	str	String
    //   137	1	3	localIOException3	java.io.IOException
    //   147	6	3	localIOException4	java.io.IOException
    //   221	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	137	java/io/IOException
    //   39	46	137	java/io/IOException
    //   53	67	137	java/io/IOException
    //   69	77	137	java/io/IOException
    //   84	98	137	java/io/IOException
    //   100	107	137	java/io/IOException
    //   114	127	137	java/io/IOException
    //   0	26	141	finally
    //   0	26	147	java/io/IOException
    //   130	134	167	java/io/IOException
    //   160	164	167	java/io/IOException
    //   28	33	221	finally
    //   39	46	221	finally
    //   53	67	221	finally
    //   69	77	221	finally
    //   84	98	221	finally
    //   100	107	221	finally
    //   114	127	221	finally
    //   152	156	221	finally
    //   230	234	237	java/io/IOException
  }
  
  public static String b()
  {
    try
    {
      if (TextUtils.isEmpty(c)) {
        a();
      }
      String str = c;
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.LocalInfoUtils
 * JD-Core Version:    0.7.0.1
 */