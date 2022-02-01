package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class DESUtil
{
  /* Error */
  public static void a(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 17	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_2
    //   11: invokestatic 20	com/tencent/mobileqq/utils/DESUtil:a	([B)[B
    //   14: ldc 22
    //   16: invokespecial 25	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore_2
    //   20: ldc 22
    //   22: invokestatic 31	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   25: astore 7
    //   27: aload 7
    //   29: iconst_1
    //   30: aload_2
    //   31: invokevirtual 35	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   34: new 37	java/io/BufferedInputStream
    //   37: dup
    //   38: new 39	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 45	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_2
    //   50: new 47	java/io/FileOutputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore 4
    //   60: new 50	javax/crypto/CipherInputStream
    //   63: dup
    //   64: aload_2
    //   65: aload 7
    //   67: invokespecial 53	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   70: astore_0
    //   71: sipush 4096
    //   74: newarray byte
    //   76: astore_1
    //   77: aload 4
    //   79: ldc 55
    //   81: ldc 57
    //   83: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   86: invokevirtual 69	java/io/OutputStream:write	([B)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 73	javax/crypto/CipherInputStream:read	([B)I
    //   94: istore_3
    //   95: iload_3
    //   96: iconst_m1
    //   97: if_icmpeq +14 -> 111
    //   100: aload 4
    //   102: aload_1
    //   103: iconst_0
    //   104: iload_3
    //   105: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   108: goto -19 -> 89
    //   111: aload_2
    //   112: invokevirtual 79	java/io/BufferedInputStream:close	()V
    //   115: aload_0
    //   116: invokevirtual 80	javax/crypto/CipherInputStream:close	()V
    //   119: aload 4
    //   121: invokevirtual 81	java/io/OutputStream:close	()V
    //   124: return
    //   125: astore_1
    //   126: goto +10 -> 136
    //   129: astore_1
    //   130: goto +12 -> 142
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: goto +130 -> 266
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: goto +44 -> 186
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload 6
    //   150: astore 4
    //   152: goto +114 -> 266
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 5
    //   160: astore 4
    //   162: goto +24 -> 186
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: astore_2
    //   170: aload 6
    //   172: astore 4
    //   174: goto +92 -> 266
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: astore_2
    //   182: aload 5
    //   184: astore 4
    //   186: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +41 -> 230
    //   192: new 89	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   199: astore 5
    //   201: aload 5
    //   203: ldc 92
    //   205: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 5
    //   211: aload_1
    //   212: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 102
    //   221: iconst_2
    //   222: aload 5
    //   224: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_2
    //   231: ifnull +10 -> 241
    //   234: aload_2
    //   235: invokevirtual 79	java/io/BufferedInputStream:close	()V
    //   238: goto +3 -> 241
    //   241: aload_0
    //   242: ifnull +7 -> 249
    //   245: aload_0
    //   246: invokevirtual 80	javax/crypto/CipherInputStream:close	()V
    //   249: aload 4
    //   251: ifnull +13 -> 264
    //   254: aload 4
    //   256: invokevirtual 81	java/io/OutputStream:close	()V
    //   259: return
    //   260: aload_0
    //   261: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   264: return
    //   265: astore_1
    //   266: aload_2
    //   267: ifnull +10 -> 277
    //   270: aload_2
    //   271: invokevirtual 79	java/io/BufferedInputStream:close	()V
    //   274: goto +3 -> 277
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 80	javax/crypto/CipherInputStream:close	()V
    //   285: aload 4
    //   287: ifnull +15 -> 302
    //   290: aload 4
    //   292: invokevirtual 81	java/io/OutputStream:close	()V
    //   295: goto +7 -> 302
    //   298: aload_0
    //   299: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   302: goto +5 -> 307
    //   305: aload_1
    //   306: athrow
    //   307: goto -2 -> 305
    //   310: astore_0
    //   311: goto -51 -> 260
    //   314: astore_0
    //   315: goto -17 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramFile1	File
    //   0	318	1	paramFile2	File
    //   0	318	2	paramArrayOfByte	byte[]
    //   94	11	3	i	int
    //   58	233	4	localObject1	Object
    //   4	219	5	localStringBuilder	StringBuilder
    //   1	170	6	localObject2	Object
    //   25	41	7	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   71	89	125	finally
    //   89	95	125	finally
    //   100	108	125	finally
    //   71	89	129	java/lang/Exception
    //   89	95	129	java/lang/Exception
    //   100	108	129	java/lang/Exception
    //   60	71	133	finally
    //   60	71	139	java/lang/Exception
    //   50	60	145	finally
    //   50	60	155	java/lang/Exception
    //   6	50	165	finally
    //   6	50	177	java/lang/Exception
    //   186	230	265	finally
    //   111	124	310	java/io/IOException
    //   234	238	310	java/io/IOException
    //   245	249	310	java/io/IOException
    //   254	259	310	java/io/IOException
    //   270	274	314	java/io/IOException
    //   281	285	314	java/io/IOException
    //   290	295	314	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1);
      if (bool)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
        paramString2 = new StringBuilder();
        paramString2.append("encrypt had encrypt,file:");
        paramString2.append(paramString1);
        QLog.d("DESUtil", 2, paramString2.toString());
        return;
      }
      long l1 = System.currentTimeMillis();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(".tmp");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new File(paramString1);
      long l2 = ((File)localObject1).length() / 1024L;
      localObject2 = new File((String)localObject2);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      a((File)localObject1, (File)localObject2, paramString2.getBytes("UTF-8"));
      FileUtils.copyFile((File)localObject2, (File)localObject1);
      ((File)localObject2).delete();
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DES Encrypt filePath:");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",key:");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(",costTime:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject1).append(",fileSize:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("KB");
        QLog.d("DESUtil", 4, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = a(paramString1);
      if (bool)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
        paramString2 = new StringBuilder();
        paramString2.append("encrypt had encrypt,file:");
        paramString2.append(paramString1);
        QLog.d("DESUtil", 2, paramString2.toString());
        return;
      }
      long l1 = System.currentTimeMillis();
      File localFile = new File(paramString1);
      long l2 = localFile.length() / 1024L;
      paramString2 = new File(paramString2);
      if (paramString2.exists()) {
        paramString2.delete();
      }
      a(localFile, paramString2, paramString3.getBytes("UTF-8"));
      localFile.delete();
      if (QLog.isDevelopLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("DES Encrypt filePath:");
        paramString2.append(paramString1);
        paramString2.append(",key:");
        paramString2.append(paramString3);
        paramString2.append(",costTime:");
        paramString2.append(System.currentTimeMillis() - l1);
        paramString2.append(",fileSize:");
        paramString2.append(l2);
        paramString2.append("KB");
        QLog.d("DESUtil", 4, paramString2.toString());
        return;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return;
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: new 39	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: ldc 55
    //   17: ldc 57
    //   19: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   22: astore 5
    //   24: iconst_0
    //   25: istore_1
    //   26: iconst_1
    //   27: istore 4
    //   29: iload_1
    //   30: aload 5
    //   32: arraylength
    //   33: if_icmpge +33 -> 66
    //   36: aload_0
    //   37: invokevirtual 176	java/io/InputStream:read	()I
    //   40: istore_2
    //   41: iload_2
    //   42: iconst_m1
    //   43: if_icmpeq +13 -> 56
    //   46: aload 5
    //   48: iload_1
    //   49: baload
    //   50: istore_3
    //   51: iload_2
    //   52: iload_3
    //   53: if_icmpeq +6 -> 59
    //   56: iconst_0
    //   57: istore 4
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -34 -> 29
    //   66: aload_0
    //   67: invokevirtual 177	java/io/InputStream:close	()V
    //   70: goto +8 -> 78
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   78: iload 4
    //   80: ireturn
    //   81: astore 6
    //   83: aload_0
    //   84: astore 5
    //   86: aload 6
    //   88: astore_0
    //   89: goto +94 -> 183
    //   92: astore 6
    //   94: goto +12 -> 106
    //   97: astore_0
    //   98: goto +85 -> 183
    //   101: astore 6
    //   103: aload 7
    //   105: astore_0
    //   106: aload_0
    //   107: astore 5
    //   109: invokestatic 121	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   112: ifeq +54 -> 166
    //   115: aload_0
    //   116: astore 5
    //   118: new 89	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   125: astore 7
    //   127: aload_0
    //   128: astore 5
    //   130: aload 7
    //   132: ldc 179
    //   134: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_0
    //   139: astore 5
    //   141: aload 7
    //   143: aload 6
    //   145: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_0
    //   153: astore 5
    //   155: ldc 102
    //   157: iconst_2
    //   158: aload 7
    //   160: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: ifnull +14 -> 181
    //   170: aload_0
    //   171: invokevirtual 177	java/io/InputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload 5
    //   185: ifnull +18 -> 203
    //   188: aload 5
    //   190: invokevirtual 177	java/io/InputStream:close	()V
    //   193: goto +10 -> 203
    //   196: astore 5
    //   198: aload 5
    //   200: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   203: goto +5 -> 208
    //   206: aload_0
    //   207: athrow
    //   208: goto -2 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString	String
    //   25	38	1	i	int
    //   40	14	2	j	int
    //   50	4	3	k	int
    //   27	52	4	bool	boolean
    //   4	185	5	localObject1	Object
    //   196	3	5	localIOException	java.io.IOException
    //   81	6	6	localObject2	Object
    //   92	1	6	localException1	java.lang.Exception
    //   101	43	6	localException2	java.lang.Exception
    //   1	158	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/io/IOException
    //   15	24	81	finally
    //   29	41	81	finally
    //   15	24	92	java/lang/Exception
    //   29	41	92	java/lang/Exception
    //   6	15	97	finally
    //   109	115	97	finally
    //   118	127	97	finally
    //   130	138	97	finally
    //   141	152	97	finally
    //   155	166	97	finally
    //   6	15	101	java/lang/Exception
    //   170	174	176	java/io/IOException
    //   188	193	196	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    if (arrayOfByte.length > paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      return arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  /* Error */
  public static void b(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 17	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_2
    //   11: invokestatic 20	com/tencent/mobileqq/utils/DESUtil:a	([B)[B
    //   14: ldc 22
    //   16: invokespecial 25	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore 6
    //   21: ldc 22
    //   23: invokestatic 31	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_2
    //   29: aload 6
    //   31: invokevirtual 35	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   34: new 186	java/io/RandomAccessFile
    //   37: dup
    //   38: aload_0
    //   39: ldc 188
    //   41: invokespecial 191	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload_0
    //   46: ldc 55
    //   48: ldc 57
    //   50: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   53: arraylength
    //   54: i2l
    //   55: invokevirtual 195	java/io/RandomAccessFile:seek	(J)V
    //   58: new 197	javax/crypto/CipherOutputStream
    //   61: dup
    //   62: new 47	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: aload_2
    //   71: invokespecial 200	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   74: astore_2
    //   75: sipush 1024
    //   78: newarray byte
    //   80: astore_1
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 201	java/io/RandomAccessFile:read	([B)I
    //   86: istore_3
    //   87: iload_3
    //   88: iconst_m1
    //   89: if_icmpeq +13 -> 102
    //   92: aload_2
    //   93: aload_1
    //   94: iconst_0
    //   95: iload_3
    //   96: invokevirtual 202	javax/crypto/CipherOutputStream:write	([BII)V
    //   99: goto -18 -> 81
    //   102: aload_2
    //   103: invokevirtual 203	javax/crypto/CipherOutputStream:close	()V
    //   106: aload_0
    //   107: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   110: return
    //   111: astore_1
    //   112: goto +119 -> 231
    //   115: astore 4
    //   117: aload_2
    //   118: astore_1
    //   119: goto +14 -> 133
    //   122: astore_1
    //   123: aload 4
    //   125: astore_2
    //   126: goto +105 -> 231
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_0
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: goto +19 -> 156
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_0
    //   143: aload 4
    //   145: astore_2
    //   146: goto +85 -> 231
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_0
    //   153: aload 5
    //   155: astore_2
    //   156: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +38 -> 197
    //   162: new 89	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   169: astore_1
    //   170: aload_1
    //   171: ldc 206
    //   173: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: aload 4
    //   180: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 102
    //   189: iconst_2
    //   190: aload_1
    //   191: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: ifnull +10 -> 208
    //   201: aload_0
    //   202: invokevirtual 203	javax/crypto/CipherOutputStream:close	()V
    //   205: goto +3 -> 208
    //   208: aload_2
    //   209: ifnull +12 -> 221
    //   212: aload_2
    //   213: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   216: return
    //   217: aload_0
    //   218: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   221: return
    //   222: astore_1
    //   223: aload_2
    //   224: astore 4
    //   226: aload_0
    //   227: astore_2
    //   228: aload 4
    //   230: astore_0
    //   231: aload_2
    //   232: ifnull +10 -> 242
    //   235: aload_2
    //   236: invokevirtual 203	javax/crypto/CipherOutputStream:close	()V
    //   239: goto +3 -> 242
    //   242: aload_0
    //   243: ifnull +14 -> 257
    //   246: aload_0
    //   247: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   250: goto +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   257: goto +5 -> 262
    //   260: aload_1
    //   261: athrow
    //   262: goto -2 -> 260
    //   265: astore_0
    //   266: goto -49 -> 217
    //   269: astore_0
    //   270: goto -17 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramFile1	File
    //   0	273	1	paramFile2	File
    //   0	273	2	paramArrayOfByte	byte[]
    //   86	10	3	i	int
    //   1	1	4	localObject1	Object
    //   115	9	4	localException1	java.lang.Exception
    //   129	15	4	localException2	java.lang.Exception
    //   149	30	4	localException3	java.lang.Exception
    //   224	5	4	arrayOfByte	byte[]
    //   4	150	5	localObject2	Object
    //   19	11	6	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
    // Exception table:
    //   from	to	target	type
    //   75	81	111	finally
    //   81	87	111	finally
    //   92	99	111	finally
    //   75	81	115	java/lang/Exception
    //   81	87	115	java/lang/Exception
    //   92	99	115	java/lang/Exception
    //   45	75	122	finally
    //   45	75	129	java/lang/Exception
    //   6	45	140	finally
    //   6	45	149	java/lang/Exception
    //   156	197	222	finally
    //   102	110	265	java/io/IOException
    //   201	205	265	java/io/IOException
    //   212	216	265	java/io/IOException
    //   235	239	269	java/io/IOException
    //   246	250	269	java/io/IOException
  }
  
  public static void b(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1);
      if (!bool)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
        paramString2 = new StringBuilder();
        paramString2.append("decrypt had no encrypt,file:");
        paramString2.append(paramString1);
        QLog.d("DESUtil", 2, paramString2.toString());
        return;
      }
      long l1 = System.currentTimeMillis();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(".tmp");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new File(paramString1);
      long l2 = ((File)localObject1).length() / 1024L;
      localObject2 = new File((String)localObject2);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      b((File)localObject1, (File)localObject2, paramString2.getBytes("UTF-8"));
      FileUtils.copyFile((File)localObject2, (File)localObject1);
      ((File)localObject2).delete();
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DES Decrypt filePath:");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",key:");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(",costTime:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject1).append(",fileSize:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("KB");
        QLog.d("DESUtil", 4, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DESUtil
 * JD-Core Version:    0.7.0.1
 */