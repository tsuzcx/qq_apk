package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class FileUtils
{
  public static File createDir(File paramFile, String paramString)
  {
    if ((paramFile == null) || (paramString == null) || (paramString.length() == 0)) {
      paramFile = null;
    }
    do
    {
      return paramFile;
      paramString = new File(paramFile, paramString);
      paramFile = paramString;
    } while (paramString.exists());
    paramString.mkdirs();
    return paramString;
  }
  
  public static File getHippyFile(Context paramContext)
  {
    if (paramContext.getApplicationContext() != null) {}
    for (paramContext = paramContext.getApplicationContext().getFilesDir(); paramContext == null; paramContext = paramContext.getFilesDir()) {
      return null;
    }
    return createDir(paramContext, "hippy");
  }
  
  public static long getModifiedTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0L;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.lastModified();
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 68
    //   4: astore 5
    //   6: new 19	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 26	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload 5
    //   24: astore_3
    //   25: aload_3
    //   26: areturn
    //   27: new 70	java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial 71	java/io/ByteArrayOutputStream:<init>	()V
    //   34: astore_2
    //   35: new 73	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 4
    //   45: sipush 4096
    //   48: newarray byte
    //   50: astore_0
    //   51: aload 4
    //   53: aload_0
    //   54: iconst_0
    //   55: aload_0
    //   56: arraylength
    //   57: invokevirtual 80	java/io/FileInputStream:read	([BII)I
    //   60: istore_1
    //   61: iload_1
    //   62: iconst_m1
    //   63: if_icmpeq +51 -> 114
    //   66: aload_2
    //   67: aload_0
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual 84	java/io/ByteArrayOutputStream:write	([BII)V
    //   73: goto -22 -> 51
    //   76: astore_0
    //   77: aload 4
    //   79: astore_3
    //   80: aload_0
    //   81: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 90	java/io/FileInputStream:close	()V
    //   92: aload 5
    //   94: astore_3
    //   95: aload_2
    //   96: ifnull -71 -> 25
    //   99: aload_2
    //   100: invokevirtual 91	java/io/ByteArrayOutputStream:close	()V
    //   103: ldc 68
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   111: ldc 68
    //   113: areturn
    //   114: aload_2
    //   115: invokevirtual 96	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: aload 4
    //   121: ifnull +8 -> 129
    //   124: aload 4
    //   126: invokevirtual 90	java/io/FileInputStream:close	()V
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull -107 -> 25
    //   135: aload_2
    //   136: invokevirtual 91	java/io/ByteArrayOutputStream:close	()V
    //   139: aload_0
    //   140: areturn
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   146: aload_0
    //   147: areturn
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   153: goto -24 -> 129
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   161: goto -69 -> 92
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 90	java/io/FileInputStream:close	()V
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 91	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   192: goto -15 -> 177
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   200: goto -15 -> 185
    //   203: astore_0
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: astore_3
    //   209: aload 4
    //   211: astore_2
    //   212: goto -43 -> 169
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: aload 4
    //   220: astore_2
    //   221: goto -52 -> 169
    //   224: astore_0
    //   225: aload_3
    //   226: astore 4
    //   228: aload_2
    //   229: astore_3
    //   230: aload 4
    //   232: astore_2
    //   233: goto -64 -> 169
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_2
    //   239: goto -159 -> 80
    //   242: astore_0
    //   243: goto -163 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   60	10	1	i	int
    //   34	102	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   141	2	2	localThrowable1	java.lang.Throwable
    //   168	6	2	localObject1	Object
    //   187	2	2	localThrowable2	java.lang.Throwable
    //   195	13	2	localThrowable3	java.lang.Throwable
    //   211	28	2	localObject2	Object
    //   1	130	3	localObject3	Object
    //   148	2	3	localThrowable4	java.lang.Throwable
    //   166	64	3	localObject4	Object
    //   43	188	4	localObject5	Object
    //   4	89	5	str	String
    // Exception table:
    //   from	to	target	type
    //   45	51	76	java/lang/Exception
    //   51	61	76	java/lang/Exception
    //   66	73	76	java/lang/Exception
    //   114	119	76	java/lang/Exception
    //   99	103	106	java/lang/Throwable
    //   135	139	141	java/lang/Throwable
    //   124	129	148	java/lang/Throwable
    //   88	92	156	java/lang/Throwable
    //   27	35	164	finally
    //   173	177	187	java/lang/Throwable
    //   181	185	195	java/lang/Throwable
    //   35	45	203	finally
    //   45	51	215	finally
    //   51	61	215	finally
    //   66	73	215	finally
    //   114	119	215	finally
    //   80	84	224	finally
    //   27	35	236	java/lang/Exception
    //   35	45	242	java/lang/Exception
  }
  
  /* Error */
  public static byte[] readFileToByteArray(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 19	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 26	java/io/File:exists	()Z
    //   17: ifne +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: astore_0
    //   24: new 70	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 71	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_3
    //   32: aload_2
    //   33: astore_0
    //   34: new 73	java/io/FileInputStream
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 4
    //   45: aload_2
    //   46: astore_0
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore 5
    //   54: aload_2
    //   55: astore_0
    //   56: aload 4
    //   58: aload 5
    //   60: iconst_0
    //   61: aload 5
    //   63: arraylength
    //   64: invokevirtual 80	java/io/FileInputStream:read	([BII)I
    //   67: istore_1
    //   68: iload_1
    //   69: iconst_m1
    //   70: if_icmpeq +17 -> 87
    //   73: aload_2
    //   74: astore_0
    //   75: aload_3
    //   76: aload 5
    //   78: iconst_0
    //   79: iload_1
    //   80: invokevirtual 84	java/io/ByteArrayOutputStream:write	([BII)V
    //   83: goto -29 -> 54
    //   86: astore_0
    //   87: aload_2
    //   88: astore_0
    //   89: aload 4
    //   91: invokevirtual 90	java/io/FileInputStream:close	()V
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: invokevirtual 102	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   100: astore_2
    //   101: aload_2
    //   102: astore_0
    //   103: aload_3
    //   104: invokevirtual 91	java/io/ByteArrayOutputStream:close	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   114: aload_0
    //   115: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   67	13	1	i	int
    //   1	107	2	arrayOfByte1	byte[]
    //   109	2	2	localException	java.lang.Exception
    //   31	73	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   10	80	4	localObject	Object
    //   52	25	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	54	86	java/lang/Throwable
    //   56	68	86	java/lang/Throwable
    //   75	83	86	java/lang/Throwable
    //   24	32	109	java/lang/Exception
    //   34	45	109	java/lang/Exception
    //   47	54	109	java/lang/Exception
    //   56	68	109	java/lang/Exception
    //   75	83	109	java/lang/Exception
    //   89	94	109	java/lang/Exception
    //   96	101	109	java/lang/Exception
    //   103	107	109	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */