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
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 17	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_2
    //   11: invokestatic 20	com/tencent/mobileqq/utils/DESUtil:a	([B)[B
    //   14: ldc 22
    //   16: invokespecial 25	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore 4
    //   21: ldc 22
    //   23: invokestatic 31	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: aload 4
    //   31: invokevirtual 35	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   34: new 37	java/io/BufferedInputStream
    //   37: dup
    //   38: new 39	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 45	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 4
    //   51: new 47	java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: astore_0
    //   60: new 50	javax/crypto/CipherInputStream
    //   63: dup
    //   64: aload 4
    //   66: aload_2
    //   67: invokespecial 53	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   70: astore_1
    //   71: sipush 4096
    //   74: newarray byte
    //   76: astore_2
    //   77: aload_0
    //   78: ldc 55
    //   80: ldc 57
    //   82: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   85: invokevirtual 69	java/io/OutputStream:write	([B)V
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 73	javax/crypto/CipherInputStream:read	([B)I
    //   93: istore_3
    //   94: iload_3
    //   95: iconst_m1
    //   96: if_icmpeq +83 -> 179
    //   99: aload_0
    //   100: aload_2
    //   101: iconst_0
    //   102: iload_3
    //   103: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   106: goto -18 -> 88
    //   109: astore 5
    //   111: aload_1
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: aload 5
    //   117: astore_0
    //   118: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +31 -> 152
    //   124: ldc 84
    //   126: iconst_2
    //   127: new 86	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   134: ldc 89
    //   136: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload 4
    //   154: ifnull +8 -> 162
    //   157: aload 4
    //   159: invokevirtual 107	java/io/BufferedInputStream:close	()V
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 108	javax/crypto/CipherInputStream:close	()V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 109	java/io/OutputStream:close	()V
    //   178: return
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 107	java/io/BufferedInputStream:close	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 108	javax/crypto/CipherInputStream:close	()V
    //   197: aload_0
    //   198: ifnull -20 -> 178
    //   201: aload_0
    //   202: invokevirtual 109	java/io/OutputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   211: return
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_1
    //   224: aload 5
    //   226: astore_2
    //   227: aload 4
    //   229: ifnull +8 -> 237
    //   232: aload 4
    //   234: invokevirtual 107	java/io/BufferedInputStream:close	()V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 108	javax/crypto/CipherInputStream:close	()V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 109	java/io/OutputStream:close	()V
    //   253: aload_0
    //   254: athrow
    //   255: astore_1
    //   256: aload_1
    //   257: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   260: goto -7 -> 253
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_1
    //   266: aload 5
    //   268: astore_2
    //   269: goto -42 -> 227
    //   272: astore_2
    //   273: aload_0
    //   274: astore_1
    //   275: aload_2
    //   276: astore_0
    //   277: aload 5
    //   279: astore_2
    //   280: goto -53 -> 227
    //   283: astore_2
    //   284: aload_0
    //   285: astore 5
    //   287: aload_2
    //   288: astore_0
    //   289: aload_1
    //   290: astore_2
    //   291: aload 5
    //   293: astore_1
    //   294: goto -67 -> 227
    //   297: astore_0
    //   298: goto -71 -> 227
    //   301: astore_0
    //   302: aconst_null
    //   303: astore 4
    //   305: aconst_null
    //   306: astore_1
    //   307: aload 6
    //   309: astore_2
    //   310: goto -192 -> 118
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: aload 6
    //   318: astore_2
    //   319: goto -201 -> 118
    //   322: astore_2
    //   323: aload_0
    //   324: astore_1
    //   325: aload_2
    //   326: astore_0
    //   327: aload 6
    //   329: astore_2
    //   330: goto -212 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramFile1	File
    //   0	333	1	paramFile2	File
    //   0	333	2	paramArrayOfByte	byte[]
    //   93	10	3	i	int
    //   19	285	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   109	169	5	localException	java.lang.Exception
    //   285	7	5	localFile	File
    //   4	324	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	88	109	java/lang/Exception
    //   88	94	109	java/lang/Exception
    //   99	106	109	java/lang/Exception
    //   184	189	206	java/io/IOException
    //   193	197	206	java/io/IOException
    //   201	205	206	java/io/IOException
    //   157	162	212	java/io/IOException
    //   166	170	212	java/io/IOException
    //   174	178	212	java/io/IOException
    //   6	51	218	finally
    //   232	237	255	java/io/IOException
    //   241	245	255	java/io/IOException
    //   249	253	255	java/io/IOException
    //   51	60	263	finally
    //   60	71	272	finally
    //   71	88	283	finally
    //   88	94	283	finally
    //   99	106	283	finally
    //   118	152	297	finally
    //   6	51	301	java/lang/Exception
    //   51	60	313	java/lang/Exception
    //   60	71	322	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      if (a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "encrypt had encrypt,file:" + paramString1);
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        Object localObject = paramString1 + ".tmp";
        File localFile = new File(paramString1);
        long l2 = localFile.length() / 1024L;
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        a(localFile, (File)localObject, paramString2.getBytes("UTF-8"));
        FileUtils.a((File)localObject, localFile);
        ((File)localObject).delete();
        if (QLog.isDevelopLevel())
        {
          QLog.d("DESUtil", 4, "DES Encrypt filePath:" + paramString1 + ",key:" + paramString2 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "encrypt had encrypt,file:" + paramString1);
        }
      }
      else
      {
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
          QLog.d("DESUtil", 4, "DES Encrypt filePath:" + paramString1 + ",key:" + paramString3 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: new 39	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload 5
    //   15: astore_0
    //   16: ldc 55
    //   18: ldc 57
    //   20: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   23: astore 6
    //   25: iconst_0
    //   26: istore_1
    //   27: aload 5
    //   29: astore_0
    //   30: iload_1
    //   31: aload 6
    //   33: arraylength
    //   34: if_icmpge +37 -> 71
    //   37: aload 5
    //   39: astore_0
    //   40: aload 5
    //   42: invokevirtual 175	java/io/InputStream:read	()I
    //   45: istore_2
    //   46: iload_2
    //   47: iconst_m1
    //   48: if_icmpeq +13 -> 61
    //   51: aload 6
    //   53: iload_1
    //   54: baload
    //   55: istore_3
    //   56: iload_2
    //   57: iload_3
    //   58: if_icmpeq +6 -> 64
    //   61: iconst_0
    //   62: istore 4
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -41 -> 27
    //   71: aload 5
    //   73: ifnull +8 -> 81
    //   76: aload 5
    //   78: invokevirtual 176	java/io/InputStream:close	()V
    //   81: iload 4
    //   83: ireturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   89: iload 4
    //   91: ireturn
    //   92: astore 6
    //   94: aconst_null
    //   95: astore 5
    //   97: aload 5
    //   99: astore_0
    //   100: invokestatic 121	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   103: ifeq +35 -> 138
    //   106: aload 5
    //   108: astore_0
    //   109: ldc 84
    //   111: iconst_2
    //   112: new 86	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   119: ldc 178
    //   121: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 6
    //   126: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 176	java/io/InputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 176	java/io/InputStream:close	()V
    //   169: aload 5
    //   171: athrow
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   177: goto -8 -> 169
    //   180: astore 5
    //   182: goto -21 -> 161
    //   185: astore 6
    //   187: goto -90 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   26	42	1	i	int
    //   45	14	2	j	int
    //   55	4	3	k	int
    //   1	89	4	bool	boolean
    //   11	133	5	localFileInputStream	java.io.FileInputStream
    //   157	13	5	localObject1	Object
    //   180	1	5	localObject2	Object
    //   23	29	6	arrayOfByte	byte[]
    //   92	33	6	localException1	java.lang.Exception
    //   185	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	81	84	java/io/IOException
    //   3	13	92	java/lang/Exception
    //   143	148	150	java/io/IOException
    //   3	13	157	finally
    //   165	169	172	java/io/IOException
    //   16	25	180	finally
    //   30	37	180	finally
    //   40	46	180	finally
    //   100	106	180	finally
    //   109	138	180	finally
    //   16	25	185	java/lang/Exception
    //   30	37	185	java/lang/Exception
    //   40	46	185	java/lang/Exception
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
    //   19: astore_2
    //   20: ldc 22
    //   22: invokestatic 31	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   25: astore 6
    //   27: aload 6
    //   29: iconst_2
    //   30: aload_2
    //   31: invokevirtual 35	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   34: new 185	java/io/RandomAccessFile
    //   37: dup
    //   38: aload_0
    //   39: ldc 187
    //   41: invokespecial 190	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc 55
    //   48: ldc 57
    //   50: invokevirtual 63	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   53: arraylength
    //   54: i2l
    //   55: invokevirtual 194	java/io/RandomAccessFile:seek	(J)V
    //   58: new 196	javax/crypto/CipherOutputStream
    //   61: dup
    //   62: new 47	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: aload 6
    //   72: invokespecial 199	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   75: astore_0
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore_1
    //   82: aload_2
    //   83: aload_1
    //   84: invokevirtual 200	java/io/RandomAccessFile:read	([B)I
    //   87: istore_3
    //   88: iload_3
    //   89: iconst_m1
    //   90: if_icmpeq +71 -> 161
    //   93: aload_0
    //   94: aload_1
    //   95: iconst_0
    //   96: iload_3
    //   97: invokevirtual 201	javax/crypto/CipherOutputStream:write	([BII)V
    //   100: goto -18 -> 82
    //   103: astore 4
    //   105: aload_2
    //   106: astore_1
    //   107: aload 4
    //   109: astore_2
    //   110: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +31 -> 144
    //   116: ldc 84
    //   118: iconst_2
    //   119: new 86	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   126: ldc 203
    //   128: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: ifnull +7 -> 152
    //   148: aload_0
    //   149: invokevirtual 204	javax/crypto/CipherOutputStream:close	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   160: return
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 204	javax/crypto/CipherOutputStream:close	()V
    //   169: aload_2
    //   170: ifnull -10 -> 160
    //   173: aload_2
    //   174: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   177: return
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   183: return
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   189: return
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_2
    //   193: aload 4
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 204	javax/crypto/CipherOutputStream:close	()V
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   219: goto -7 -> 212
    //   222: astore_0
    //   223: aload 4
    //   225: astore_1
    //   226: goto -30 -> 196
    //   229: astore 4
    //   231: aload_0
    //   232: astore_1
    //   233: aload 4
    //   235: astore_0
    //   236: goto -40 -> 196
    //   239: astore 4
    //   241: aload_1
    //   242: astore_2
    //   243: aload_0
    //   244: astore_1
    //   245: aload 4
    //   247: astore_0
    //   248: goto -52 -> 196
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_0
    //   254: aload 5
    //   256: astore_1
    //   257: goto -147 -> 110
    //   260: astore 4
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_2
    //   265: astore_1
    //   266: aload 4
    //   268: astore_2
    //   269: goto -159 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramFile1	File
    //   0	272	1	paramFile2	File
    //   0	272	2	paramArrayOfByte	byte[]
    //   87	10	3	i	int
    //   1	1	4	localObject1	Object
    //   103	121	4	localException1	java.lang.Exception
    //   229	5	4	localObject2	Object
    //   239	7	4	localObject3	Object
    //   260	7	4	localException2	java.lang.Exception
    //   4	251	5	localObject4	Object
    //   25	46	6	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   76	82	103	java/lang/Exception
    //   82	88	103	java/lang/Exception
    //   93	100	103	java/lang/Exception
    //   165	169	178	java/io/IOException
    //   173	177	178	java/io/IOException
    //   148	152	184	java/io/IOException
    //   156	160	184	java/io/IOException
    //   6	45	190	finally
    //   200	204	214	java/io/IOException
    //   208	212	214	java/io/IOException
    //   45	76	222	finally
    //   76	82	229	finally
    //   82	88	229	finally
    //   93	100	229	finally
    //   110	144	239	finally
    //   6	45	251	java/lang/Exception
    //   45	76	260	java/lang/Exception
  }
  
  public static void b(String paramString1, String paramString2)
  {
    try
    {
      if (!a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "decrypt had no encrypt,file:" + paramString1);
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        Object localObject = paramString1 + ".tmp";
        File localFile = new File(paramString1);
        long l2 = localFile.length() / 1024L;
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        b(localFile, (File)localObject, paramString2.getBytes("UTF-8"));
        FileUtils.a((File)localObject, localFile);
        ((File)localObject).delete();
        if (QLog.isDevelopLevel())
        {
          QLog.d("DESUtil", 4, "DES Decrypt filePath:" + paramString1 + ",key:" + paramString2 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DESUtil
 * JD-Core Version:    0.7.0.1
 */