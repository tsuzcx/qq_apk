package com.tencent.securemodule;

import android.content.Context;
import android.os.Build;

public class av
{
  private static String a = "EnvUtil";
  private static long b = -1L;
  private static Integer c;
  
  public static String a()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new String();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("MANUFACTURER ");
    localStringBuilder.append(a());
    localStringBuilder.append(";");
    paramContext = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("ram ");
    localStringBuilder.append(b());
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static long b()
  {
    // Byte code:
    //   0: getstatic 63	com/tencent/securemodule/av:b	J
    //   3: ldc2_w 11
    //   6: lcmp
    //   7: ifne +216 -> 223
    //   10: new 65	java/io/File
    //   13: dup
    //   14: ldc 67
    //   16: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 6
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 74	java/io/File:exists	()Z
    //   35: ifeq +188 -> 223
    //   38: new 76	java/io/DataInputStream
    //   41: dup
    //   42: new 78	java/io/FileInputStream
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 87	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +35 -> 95
    //   63: aload_2
    //   64: invokevirtual 90	java/lang/String:trim	()Ljava/lang/String;
    //   67: ldc 92
    //   69: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   72: iconst_1
    //   73: aaload
    //   74: invokestatic 102	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   77: putstatic 63	com/tencent/securemodule/av:b	J
    //   80: aload_3
    //   81: invokevirtual 105	java/io/DataInputStream:close	()V
    //   84: goto +139 -> 223
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   92: goto +131 -> 223
    //   95: new 59	java/io/IOException
    //   98: dup
    //   99: ldc 110
    //   101: invokespecial 111	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore_2
    //   106: goto +99 -> 205
    //   109: astore 4
    //   111: goto +30 -> 141
    //   114: astore 4
    //   116: goto +48 -> 164
    //   119: astore 4
    //   121: goto +66 -> 187
    //   124: astore 4
    //   126: aload_2
    //   127: astore_3
    //   128: aload 4
    //   130: astore_2
    //   131: goto +74 -> 205
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: aload_2
    //   139: astore 4
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: invokevirtual 112	java/lang/NumberFormatException:printStackTrace	()V
    //   148: aload_3
    //   149: ifnull +74 -> 223
    //   152: aload_3
    //   153: invokevirtual 105	java/io/DataInputStream:close	()V
    //   156: goto +67 -> 223
    //   159: astore 4
    //   161: aload 5
    //   163: astore_3
    //   164: aload_3
    //   165: astore_2
    //   166: aload 4
    //   168: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   171: aload_3
    //   172: ifnull +51 -> 223
    //   175: aload_3
    //   176: invokevirtual 105	java/io/DataInputStream:close	()V
    //   179: goto +44 -> 223
    //   182: astore 4
    //   184: aload 6
    //   186: astore_3
    //   187: aload_3
    //   188: astore_2
    //   189: aload 4
    //   191: invokevirtual 113	java/io/FileNotFoundException:printStackTrace	()V
    //   194: aload_3
    //   195: ifnull +28 -> 223
    //   198: aload_3
    //   199: invokevirtual 105	java/io/DataInputStream:close	()V
    //   202: goto +21 -> 223
    //   205: aload_3
    //   206: ifnull +15 -> 221
    //   209: aload_3
    //   210: invokevirtual 105	java/io/DataInputStream:close	()V
    //   213: goto +8 -> 221
    //   216: astore_3
    //   217: aload_3
    //   218: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   221: aload_2
    //   222: athrow
    //   223: getstatic 63	com/tencent/securemodule/av:b	J
    //   226: lstore_0
    //   227: lload_0
    //   228: lconst_0
    //   229: lcmp
    //   230: ifle +5 -> 235
    //   233: lload_0
    //   234: lreturn
    //   235: lconst_1
    //   236: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   226	8	0	l	long
    //   30	34	2	str	String
    //   87	2	2	localIOException1	java.io.IOException
    //   105	22	2	localObject1	Object
    //   130	1	2	localObject2	Object
    //   134	5	2	localNumberFormatException1	java.lang.NumberFormatException
    //   142	80	2	localObject3	Object
    //   19	191	3	localObject4	Object
    //   216	2	3	localIOException2	java.io.IOException
    //   21	1	4	localObject5	Object
    //   109	1	4	localNumberFormatException2	java.lang.NumberFormatException
    //   114	1	4	localIOException3	java.io.IOException
    //   119	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   124	12	4	localObject6	Object
    //   139	5	4	localObject7	Object
    //   159	8	4	localIOException4	java.io.IOException
    //   182	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   24	138	5	localObject8	Object
    //   27	158	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   80	84	87	java/io/IOException
    //   152	156	87	java/io/IOException
    //   175	179	87	java/io/IOException
    //   198	202	87	java/io/IOException
    //   54	59	105	finally
    //   63	80	105	finally
    //   95	105	105	finally
    //   54	59	109	java/lang/NumberFormatException
    //   63	80	109	java/lang/NumberFormatException
    //   95	105	109	java/lang/NumberFormatException
    //   54	59	114	java/io/IOException
    //   63	80	114	java/io/IOException
    //   95	105	114	java/io/IOException
    //   54	59	119	java/io/FileNotFoundException
    //   63	80	119	java/io/FileNotFoundException
    //   95	105	119	java/io/FileNotFoundException
    //   38	54	124	finally
    //   143	148	124	finally
    //   166	171	124	finally
    //   189	194	124	finally
    //   38	54	134	java/lang/NumberFormatException
    //   38	54	159	java/io/IOException
    //   38	54	182	java/io/FileNotFoundException
    //   209	213	216	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.av
 * JD-Core Version:    0.7.0.1
 */