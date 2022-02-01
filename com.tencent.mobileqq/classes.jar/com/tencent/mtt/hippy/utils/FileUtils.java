package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class FileUtils
{
  public static File createDir(File paramFile, String paramString)
  {
    if ((paramFile != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramFile = new File(paramFile, paramString);
      if (!paramFile.exists()) {
        paramFile.mkdirs();
      }
      return paramFile;
    }
    return null;
  }
  
  public static File getHippyFile(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    paramContext = localContext.getFilesDir();
    if (paramContext == null) {
      return null;
    }
    return createDir(paramContext, "hippy");
  }
  
  public static long getModifiedTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return 0L;
    }
    return paramString.lastModified();
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: new 19	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 26	java/io/File:exists	()Z
    //   13: istore_2
    //   14: ldc 68
    //   16: astore 7
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: ldc 68
    //   24: areturn
    //   25: new 70	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: invokespecial 71	java/io/ByteArrayOutputStream:<init>	()V
    //   32: astore_0
    //   33: new 73	java/io/FileInputStream
    //   36: dup
    //   37: aload_3
    //   38: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 5
    //   43: aload_0
    //   44: astore_3
    //   45: aload 5
    //   47: astore 4
    //   49: sipush 4096
    //   52: newarray byte
    //   54: astore 6
    //   56: aload_0
    //   57: astore_3
    //   58: aload 5
    //   60: astore 4
    //   62: aload 5
    //   64: aload 6
    //   66: iconst_0
    //   67: aload 6
    //   69: arraylength
    //   70: invokevirtual 80	java/io/FileInputStream:read	([BII)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +20 -> 96
    //   79: aload_0
    //   80: astore_3
    //   81: aload 5
    //   83: astore 4
    //   85: aload_0
    //   86: aload 6
    //   88: iconst_0
    //   89: iload_1
    //   90: invokevirtual 84	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -37 -> 56
    //   96: aload_0
    //   97: astore_3
    //   98: aload 5
    //   100: astore 4
    //   102: aload_0
    //   103: invokevirtual 88	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   106: astore 6
    //   108: aload 5
    //   110: invokevirtual 91	java/io/FileInputStream:close	()V
    //   113: goto +8 -> 121
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   121: aload 6
    //   123: astore_3
    //   124: aload_0
    //   125: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   128: aload 6
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   136: aload_3
    //   137: areturn
    //   138: astore 6
    //   140: goto +37 -> 177
    //   143: astore_3
    //   144: goto +10 -> 154
    //   147: astore_3
    //   148: goto +23 -> 171
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_0
    //   154: aconst_null
    //   155: astore 5
    //   157: aload_3
    //   158: astore 4
    //   160: aload_0
    //   161: astore_3
    //   162: aload 4
    //   164: astore_0
    //   165: goto +60 -> 225
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_0
    //   171: aconst_null
    //   172: astore 5
    //   174: aload_3
    //   175: astore 6
    //   177: aload_0
    //   178: astore_3
    //   179: aload 5
    //   181: astore 4
    //   183: aload 6
    //   185: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   188: aload 5
    //   190: ifnull +16 -> 206
    //   193: aload 5
    //   195: invokevirtual 91	java/io/FileInputStream:close	()V
    //   198: goto +8 -> 206
    //   201: astore_3
    //   202: aload_3
    //   203: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull +10 -> 217
    //   210: aload 7
    //   212: astore_3
    //   213: aload_0
    //   214: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   217: ldc 68
    //   219: areturn
    //   220: astore_0
    //   221: aload 4
    //   223: astore 5
    //   225: aload 5
    //   227: ifnull +18 -> 245
    //   230: aload 5
    //   232: invokevirtual 91	java/io/FileInputStream:close	()V
    //   235: goto +10 -> 245
    //   238: astore 4
    //   240: aload 4
    //   242: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   245: aload_3
    //   246: ifnull +15 -> 261
    //   249: aload_3
    //   250: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   253: goto +8 -> 261
    //   256: astore_3
    //   257: aload_3
    //   258: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   261: goto +5 -> 266
    //   264: aload_0
    //   265: athrow
    //   266: goto -2 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramString	String
    //   73	17	1	i	int
    //   13	6	2	bool	boolean
    //   8	90	3	localObject1	Object
    //   116	2	3	localThrowable1	java.lang.Throwable
    //   123	14	3	localObject2	Object
    //   143	1	3	localObject3	Object
    //   147	1	3	localException1	java.lang.Exception
    //   151	7	3	localObject4	Object
    //   161	1	3	str1	String
    //   168	7	3	localException2	java.lang.Exception
    //   178	1	3	str2	String
    //   201	2	3	localThrowable2	java.lang.Throwable
    //   212	38	3	localObject5	Object
    //   256	2	3	localThrowable3	java.lang.Throwable
    //   47	175	4	localObject6	Object
    //   238	3	4	localThrowable4	java.lang.Throwable
    //   41	190	5	localObject7	Object
    //   54	75	6	localObject8	Object
    //   138	1	6	localException3	java.lang.Exception
    //   175	9	6	localException4	java.lang.Exception
    //   16	195	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   108	113	116	java/lang/Throwable
    //   124	128	131	java/lang/Throwable
    //   213	217	131	java/lang/Throwable
    //   49	56	138	java/lang/Exception
    //   62	74	138	java/lang/Exception
    //   85	93	138	java/lang/Exception
    //   102	108	138	java/lang/Exception
    //   33	43	143	finally
    //   33	43	147	java/lang/Exception
    //   25	33	151	finally
    //   25	33	168	java/lang/Exception
    //   193	198	201	java/lang/Throwable
    //   49	56	220	finally
    //   62	74	220	finally
    //   85	93	220	finally
    //   102	108	220	finally
    //   183	188	220	finally
    //   230	235	238	java/lang/Throwable
    //   249	253	256	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] readFileToByteArray(String paramString)
  {
    // Byte code:
    //   0: new 19	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 26	java/io/File:exists	()Z
    //   15: istore_2
    //   16: aconst_null
    //   17: astore_3
    //   18: iload_2
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_3
    //   25: astore_0
    //   26: new 70	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 71	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 4
    //   35: aload_3
    //   36: astore_0
    //   37: new 73	java/io/FileInputStream
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore 5
    //   48: aload_3
    //   49: astore_0
    //   50: sipush 4096
    //   53: newarray byte
    //   55: astore 6
    //   57: aload_3
    //   58: astore_0
    //   59: aload 5
    //   61: aload 6
    //   63: iconst_0
    //   64: aload 6
    //   66: arraylength
    //   67: invokevirtual 80	java/io/FileInputStream:read	([BII)I
    //   70: istore_1
    //   71: iload_1
    //   72: iconst_m1
    //   73: if_icmpeq +65 -> 138
    //   76: aload_3
    //   77: astore_0
    //   78: aload 4
    //   80: aload 6
    //   82: iconst_0
    //   83: iload_1
    //   84: invokevirtual 84	java/io/ByteArrayOutputStream:write	([BII)V
    //   87: goto -30 -> 57
    //   90: astore 6
    //   92: aload_3
    //   93: astore_0
    //   94: new 100	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   101: astore 7
    //   103: aload_3
    //   104: astore_0
    //   105: aload 7
    //   107: ldc 103
    //   109: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: astore_0
    //   115: aload 7
    //   117: aload 6
    //   119: invokevirtual 110	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: astore_0
    //   128: ldc 112
    //   130: aload 7
    //   132: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 119	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_3
    //   139: astore_0
    //   140: aload 5
    //   142: invokevirtual 91	java/io/FileInputStream:close	()V
    //   145: aload_3
    //   146: astore_0
    //   147: aload 4
    //   149: invokevirtual 123	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   152: astore_3
    //   153: aload_3
    //   154: astore_0
    //   155: aload 4
    //   157: invokevirtual 95	java/io/ByteArrayOutputStream:close	()V
    //   160: aload_3
    //   161: areturn
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   167: aload_0
    //   168: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   70	14	1	i	int
    //   15	4	2	bool	boolean
    //   17	144	3	arrayOfByte1	byte[]
    //   162	2	3	localException	java.lang.Exception
    //   33	123	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   8	133	5	localObject	Object
    //   55	26	6	arrayOfByte2	byte[]
    //   90	28	6	localThrowable	java.lang.Throwable
    //   101	30	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	57	90	java/lang/Throwable
    //   59	71	90	java/lang/Throwable
    //   78	87	90	java/lang/Throwable
    //   26	35	162	java/lang/Exception
    //   37	48	162	java/lang/Exception
    //   50	57	162	java/lang/Exception
    //   59	71	162	java/lang/Exception
    //   78	87	162	java/lang/Exception
    //   94	103	162	java/lang/Exception
    //   105	113	162	java/lang/Exception
    //   115	126	162	java/lang/Exception
    //   128	138	162	java/lang/Exception
    //   140	145	162	java/lang/Exception
    //   147	153	162	java/lang/Exception
    //   155	160	162	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */