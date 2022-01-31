package com.tencent.mobileqq.business.sougou;

public class DictFileUtil
{
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfByte.length != 4) {
      return k;
    }
    int j = 3;
    for (;;)
    {
      k = i;
      if (j < 0) {
        break;
      }
      k = paramArrayOfByte[j];
      j -= 1;
      i = k & 0xFF | i << 8;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: new 28	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 33	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 36	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: sipush 30720
    //   27: newarray byte
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: invokevirtual 39	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifge +27 -> 64
    //   40: aload_0
    //   41: invokevirtual 42	java/io/FileInputStream:close	()V
    //   44: aload_2
    //   45: invokevirtual 46	java/security/MessageDigest:digest	()[B
    //   48: invokestatic 52	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 55	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   57: ldc 57
    //   59: areturn
    //   60: astore_0
    //   61: ldc 57
    //   63: areturn
    //   64: aload_2
    //   65: aload_3
    //   66: iconst_0
    //   67: iload_1
    //   68: invokevirtual 61	java/security/MessageDigest:update	([BII)V
    //   71: goto -41 -> 30
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: invokevirtual 42	java/io/FileInputStream:close	()V
    //   83: ldc 57
    //   85: areturn
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   91: ldc 57
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   99: goto -55 -> 44
    //   102: astore_2
    //   103: aload_0
    //   104: invokevirtual 42	java/io/FileInputStream:close	()V
    //   107: aload_2
    //   108: athrow
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   114: goto -7 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   35	33	1	i	int
    //   5	60	2	localMessageDigest	java.security.MessageDigest
    //   74	2	2	localIOException	java.io.IOException
    //   102	6	2	localObject	Object
    //   29	37	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	6	52	java/security/NoSuchAlgorithmException
    //   15	24	60	java/io/FileNotFoundException
    //   24	30	74	java/io/IOException
    //   30	36	74	java/io/IOException
    //   64	71	74	java/io/IOException
    //   79	83	86	java/io/IOException
    //   40	44	94	java/io/IOException
    //   24	30	102	finally
    //   30	36	102	finally
    //   64	71	102	finally
    //   75	79	102	finally
    //   103	107	109	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 65	com/tencent/mobileqq/business/sougou/DictFileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4: ldc 67
    //   6: invokevirtual 73	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   9: ifne +19 -> 28
    //   12: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 81
    //   20: iconst_2
    //   21: ldc 83
    //   23: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 89	java/io/FileOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aconst_null
    //   39: astore_3
    //   40: new 92	java/util/zip/GZIPInputStream
    //   43: dup
    //   44: new 33	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   52: invokespecial 96	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_0
    //   56: aload_0
    //   57: astore_3
    //   58: sipush 1024
    //   61: newarray byte
    //   63: astore 5
    //   65: aload_0
    //   66: astore_3
    //   67: aload_0
    //   68: aload 5
    //   70: invokevirtual 97	java/util/zip/GZIPInputStream:read	([B)I
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +110 -> 185
    //   78: aload_0
    //   79: astore_3
    //   80: aload 4
    //   82: aload 5
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 100	java/io/FileOutputStream:write	([BII)V
    //   89: goto -24 -> 65
    //   92: astore_3
    //   93: aload_0
    //   94: astore_3
    //   95: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +30 -> 128
    //   101: aload_0
    //   102: astore_3
    //   103: ldc 81
    //   105: iconst_2
    //   106: new 102	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   113: ldc 105
    //   115: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 114	java/util/zip/GZIPInputStream:close	()V
    //   136: aload 4
    //   138: ifnull -112 -> 26
    //   141: aload 4
    //   143: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_0
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -129 -> 26
    //   158: ldc 81
    //   160: iconst_2
    //   161: new 102	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   168: ldc 105
    //   170: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_1
    //   174: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 114	java/util/zip/GZIPInputStream:close	()V
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_0
    //   206: aload_3
    //   207: astore_0
    //   208: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +11 -> 222
    //   214: ldc 81
    //   216: iconst_2
    //   217: ldc 117
    //   219: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 114	java/util/zip/GZIPInputStream:close	()V
    //   230: aload 4
    //   232: ifnull -206 -> 26
    //   235: aload 4
    //   237: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_0
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_3
    //   248: aload_3
    //   249: ifnull +7 -> 256
    //   252: aload_3
    //   253: invokevirtual 114	java/util/zip/GZIPInputStream:close	()V
    //   256: aload 4
    //   258: ifnull +8 -> 266
    //   261: aload 4
    //   263: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: goto -76 -> 193
    //   272: astore_0
    //   273: goto -70 -> 203
    //   276: astore_0
    //   277: goto -141 -> 136
    //   280: astore_0
    //   281: goto -51 -> 230
    //   284: astore_1
    //   285: goto -29 -> 256
    //   288: astore_1
    //   289: goto -23 -> 266
    //   292: astore_0
    //   293: goto -45 -> 248
    //   296: astore_1
    //   297: aload_0
    //   298: astore_3
    //   299: aload_1
    //   300: astore_0
    //   301: goto -53 -> 248
    //   304: astore_1
    //   305: goto -97 -> 208
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -218 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString1	String
    //   0	314	1	paramString2	String
    //   73	13	2	i	int
    //   39	41	3	str1	String
    //   92	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   94	205	3	str2	String
    //   36	226	4	localFileOutputStream	java.io.FileOutputStream
    //   63	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	65	92	java/io/FileNotFoundException
    //   67	74	92	java/io/FileNotFoundException
    //   80	89	92	java/io/FileNotFoundException
    //   141	146	148	java/io/IOException
    //   28	38	151	java/io/FileNotFoundException
    //   40	56	205	java/io/IOException
    //   235	240	242	java/io/IOException
    //   40	56	245	finally
    //   189	193	268	java/io/IOException
    //   198	203	272	java/io/IOException
    //   132	136	276	java/io/IOException
    //   226	230	280	java/io/IOException
    //   252	256	284	java/io/IOException
    //   261	266	288	java/io/IOException
    //   58	65	292	finally
    //   67	74	292	finally
    //   80	89	292	finally
    //   95	101	292	finally
    //   103	128	292	finally
    //   208	222	296	finally
    //   58	65	304	java/io/IOException
    //   67	74	304	java/io/IOException
    //   80	89	304	java/io/IOException
    //   40	56	308	java/io/FileNotFoundException
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    int i = paramString.lastIndexOf('.');
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (i < paramString.length() - 1) {
        str1 = paramString.substring(i + 1);
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.DictFileUtil
 * JD-Core Version:    0.7.0.1
 */