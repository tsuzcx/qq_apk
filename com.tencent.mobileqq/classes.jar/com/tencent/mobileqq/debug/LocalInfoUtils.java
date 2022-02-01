package com.tencent.mobileqq.debug;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class LocalInfoUtils
{
  public static final String a = HardCodeUtil.a(2131699538);
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
    //   34: ifnull +160 -> 194
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: ldc 68
    //   42: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   45: istore_0
    //   46: iload_0
    //   47: iconst_m1
    //   48: if_icmple +22 -> 70
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: iload_0
    //   55: ldc 68
    //   57: invokevirtual 78	java/lang/String:length	()I
    //   60: iadd
    //   61: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 84	java/lang/String:trim	()Ljava/lang/String;
    //   67: putstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: getstatic 18	com/tencent/mobileqq/debug/LocalInfoUtils:a	Ljava/lang/String;
    //   76: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   79: istore_0
    //   80: iload_0
    //   81: iconst_m1
    //   82: if_icmple +22 -> 104
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: iload_0
    //   89: ldc 68
    //   91: invokevirtual 78	java/lang/String:length	()I
    //   94: iadd
    //   95: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   98: invokevirtual 84	java/lang/String:trim	()Ljava/lang/String;
    //   101: putstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   104: aload_2
    //   105: astore_1
    //   106: aload_3
    //   107: ldc 86
    //   109: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   112: istore_0
    //   113: iload_0
    //   114: iconst_m1
    //   115: if_icmple -89 -> 26
    //   118: aload_2
    //   119: astore_1
    //   120: aload_3
    //   121: iload_0
    //   122: ldc 86
    //   124: invokevirtual 78	java/lang/String:length	()I
    //   127: iadd
    //   128: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   131: invokevirtual 84	java/lang/String:trim	()Ljava/lang/String;
    //   134: putstatic 88	com/tencent/mobileqq/debug/LocalInfoUtils:c	Ljava/lang/String;
    //   137: goto -111 -> 26
    //   140: astore_3
    //   141: aload_2
    //   142: astore_1
    //   143: aload_3
    //   144: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 94	java/io/BufferedReader:close	()V
    //   155: ldc 96
    //   157: iconst_2
    //   158: new 98	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   165: ldc 101
    //   167: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 25	com/tencent/mobileqq/debug/LocalInfoUtils:b	Ljava/lang/String;
    //   173: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 107
    //   178: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 88	com/tencent/mobileqq/debug/LocalInfoUtils:c	Ljava/lang/String;
    //   184: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: return
    //   194: aload_2
    //   195: ifnull -40 -> 155
    //   198: aload_2
    //   199: invokevirtual 94	java/io/BufferedReader:close	()V
    //   202: goto -47 -> 155
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   210: goto -55 -> 155
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   218: goto -63 -> 155
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 94	java/io/BufferedReader:close	()V
    //   232: aload_2
    //   233: athrow
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   239: goto -7 -> 232
    //   242: astore_2
    //   243: goto -19 -> 224
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_2
    //   249: goto -108 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	83	0	i	int
    //   27	116	1	localBufferedReader1	java.io.BufferedReader
    //   205	2	1	localIOException1	java.io.IOException
    //   213	2	1	localIOException2	java.io.IOException
    //   223	6	1	localObject1	Object
    //   234	2	1	localIOException3	java.io.IOException
    //   25	174	2	localBufferedReader2	java.io.BufferedReader
    //   221	12	2	localObject2	Object
    //   242	1	2	localObject3	Object
    //   248	1	2	localObject4	Object
    //   32	89	3	str	String
    //   140	4	3	localIOException4	java.io.IOException
    //   246	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   28	33	140	java/io/IOException
    //   39	46	140	java/io/IOException
    //   53	70	140	java/io/IOException
    //   72	80	140	java/io/IOException
    //   87	104	140	java/io/IOException
    //   106	113	140	java/io/IOException
    //   120	137	140	java/io/IOException
    //   198	202	205	java/io/IOException
    //   151	155	213	java/io/IOException
    //   0	26	221	finally
    //   228	232	234	java/io/IOException
    //   28	33	242	finally
    //   39	46	242	finally
    //   53	70	242	finally
    //   72	80	242	finally
    //   87	104	242	finally
    //   106	113	242	finally
    //   120	137	242	finally
    //   143	147	242	finally
    //   0	26	246	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.LocalInfoUtils
 * JD-Core Version:    0.7.0.1
 */