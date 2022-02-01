package com.tencent.mobileqq.business.sougou;

public class DictFileUtil
{
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    if (i != 4) {
      return 0;
    }
    i = 3;
    while (i >= 0)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i -= 1;
    }
    return j;
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
    //   37: ifge +23 -> 60
    //   40: aload_0
    //   41: invokevirtual 42	java/io/FileInputStream:close	()V
    //   44: goto +8 -> 52
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   52: aload_2
    //   53: invokevirtual 49	java/security/MessageDigest:digest	()[B
    //   56: invokestatic 55	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   59: areturn
    //   60: aload_2
    //   61: aload_3
    //   62: iconst_0
    //   63: iload_1
    //   64: invokevirtual 59	java/security/MessageDigest:update	([BII)V
    //   67: goto -37 -> 30
    //   70: astore_2
    //   71: goto +23 -> 94
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: invokevirtual 42	java/io/FileInputStream:close	()V
    //   83: ldc 61
    //   85: areturn
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   91: ldc 61
    //   93: areturn
    //   94: aload_0
    //   95: invokevirtual 42	java/io/FileInputStream:close	()V
    //   98: goto +8 -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   106: aload_2
    //   107: athrow
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 62	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   113: ldc 61
    //   115: areturn
    //   116: astore_0
    //   117: ldc 61
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   35	29	1	i	int
    //   5	56	2	localMessageDigest	java.security.MessageDigest
    //   70	1	2	localObject	Object
    //   74	33	2	localIOException	java.io.IOException
    //   29	33	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/io/IOException
    //   24	30	70	finally
    //   30	36	70	finally
    //   60	67	70	finally
    //   75	79	70	finally
    //   24	30	74	java/io/IOException
    //   30	36	74	java/io/IOException
    //   60	67	74	java/io/IOException
    //   79	83	86	java/io/IOException
    //   94	98	101	java/io/IOException
    //   0	6	108	java/security/NoSuchAlgorithmException
    //   15	24	116	java/io/FileNotFoundException
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
    //   36: astore 6
    //   38: aconst_null
    //   39: astore 4
    //   41: aconst_null
    //   42: astore 5
    //   44: aconst_null
    //   45: astore_3
    //   46: new 92	java/util/zip/GZIPInputStream
    //   49: dup
    //   50: new 33	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 96	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_0
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore_3
    //   68: aload_0
    //   69: aload_3
    //   70: invokevirtual 97	java/util/zip/GZIPInputStream:read	([B)I
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +14 -> 89
    //   78: aload 6
    //   80: aload_3
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 100	java/io/FileOutputStream:write	([BII)V
    //   86: goto -18 -> 68
    //   89: aload_0
    //   90: invokevirtual 101	java/util/zip/GZIPInputStream:close	()V
    //   93: aload 6
    //   95: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   98: iconst_1
    //   99: ireturn
    //   100: astore_1
    //   101: aload_0
    //   102: astore_3
    //   103: aload_1
    //   104: astore_0
    //   105: goto +112 -> 217
    //   108: goto +10 -> 118
    //   111: goto +40 -> 151
    //   114: astore_0
    //   115: goto +102 -> 217
    //   118: aload_0
    //   119: astore_3
    //   120: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +13 -> 136
    //   126: aload_0
    //   127: astore_3
    //   128: ldc 81
    //   130: iconst_2
    //   131: ldc 104
    //   133: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 101	java/util/zip/GZIPInputStream:close	()V
    //   144: aload 6
    //   146: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_0
    //   152: astore_3
    //   153: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +46 -> 202
    //   159: aload_0
    //   160: astore_3
    //   161: new 106	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   168: astore 4
    //   170: aload_0
    //   171: astore_3
    //   172: aload 4
    //   174: ldc 109
    //   176: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_0
    //   181: astore_3
    //   182: aload 4
    //   184: aload_1
    //   185: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: astore_3
    //   191: ldc 81
    //   193: iconst_2
    //   194: aload 4
    //   196: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 101	java/util/zip/GZIPInputStream:close	()V
    //   210: aload 6
    //   212: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 101	java/util/zip/GZIPInputStream:close	()V
    //   225: aload 6
    //   227: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   230: aload_0
    //   231: athrow
    //   232: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +34 -> 269
    //   238: new 106	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   245: astore_0
    //   246: aload_0
    //   247: ldc 109
    //   249: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: ldc 81
    //   261: iconst_2
    //   262: aload_0
    //   263: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_0
    //   272: goto -40 -> 232
    //   275: astore_0
    //   276: aload 5
    //   278: astore_0
    //   279: goto -128 -> 151
    //   282: astore_0
    //   283: aload 4
    //   285: astore_0
    //   286: goto -168 -> 118
    //   289: astore_3
    //   290: goto -179 -> 111
    //   293: astore_1
    //   294: goto -186 -> 108
    //   297: astore_0
    //   298: goto -205 -> 93
    //   301: astore_0
    //   302: goto -204 -> 98
    //   305: astore_0
    //   306: goto -162 -> 144
    //   309: astore_0
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_0
    //   313: goto -103 -> 210
    //   316: astore_0
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_1
    //   320: goto -95 -> 225
    //   323: astore_1
    //   324: goto -94 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString1	String
    //   0	327	1	paramString2	String
    //   73	10	2	i	int
    //   45	177	3	localObject1	Object
    //   289	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   39	245	4	localStringBuilder	java.lang.StringBuilder
    //   42	235	5	localObject2	Object
    //   36	190	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	68	100	finally
    //   68	74	100	finally
    //   78	86	100	finally
    //   46	62	114	finally
    //   120	126	114	finally
    //   128	136	114	finally
    //   153	159	114	finally
    //   161	170	114	finally
    //   172	180	114	finally
    //   182	189	114	finally
    //   191	202	114	finally
    //   28	38	271	java/io/FileNotFoundException
    //   46	62	275	java/io/FileNotFoundException
    //   46	62	282	java/io/IOException
    //   62	68	289	java/io/FileNotFoundException
    //   68	74	289	java/io/FileNotFoundException
    //   78	86	289	java/io/FileNotFoundException
    //   62	68	293	java/io/IOException
    //   68	74	293	java/io/IOException
    //   78	86	293	java/io/IOException
    //   89	93	297	java/io/IOException
    //   93	98	301	java/io/IOException
    //   140	144	305	java/io/IOException
    //   144	149	309	java/io/IOException
    //   206	210	312	java/io/IOException
    //   210	215	316	java/io/IOException
    //   221	225	319	java/io/IOException
    //   225	230	323	java/io/IOException
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.DictFileUtil
 * JD-Core Version:    0.7.0.1
 */