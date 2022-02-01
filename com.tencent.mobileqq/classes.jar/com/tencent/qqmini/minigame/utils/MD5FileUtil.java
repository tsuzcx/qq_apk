package com.tencent.qqmini.minigame.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5FileUtil
{
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest messagedigest = null;
  
  static
  {
    try
    {
      messagedigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char[] arrayOfChar = hexDigits;
    char c1 = arrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = arrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean checkPassword(String paramString1, String paramString2)
  {
    return getMD5String(paramString1).equals(paramString2);
  }
  
  /* Error */
  public static String getFileMD5String(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aload_0
    //   7: ifnull +237 -> 244
    //   10: aload_0
    //   11: invokevirtual 90	java/io/File:exists	()Z
    //   14: ifeq +230 -> 244
    //   17: aload_0
    //   18: invokevirtual 94	java/io/File:length	()J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifle +221 -> 244
    //   26: new 96	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore 8
    //   36: aload 8
    //   38: astore 7
    //   40: aload_0
    //   41: invokevirtual 94	java/io/File:length	()J
    //   44: lstore_1
    //   45: aload 8
    //   47: astore 7
    //   49: sipush 4096
    //   52: newarray byte
    //   54: astore_0
    //   55: lload_1
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +61 -> 119
    //   61: aload 8
    //   63: astore 7
    //   65: aload 8
    //   67: aload_0
    //   68: invokevirtual 103	java/io/FileInputStream:read	([B)I
    //   71: i2l
    //   72: lstore 5
    //   74: lload 5
    //   76: ldc2_w 104
    //   79: lcmp
    //   80: ifeq +39 -> 119
    //   83: lload 5
    //   85: lstore_3
    //   86: lload 5
    //   88: lload_1
    //   89: lcmp
    //   90: ifle +5 -> 95
    //   93: lload_1
    //   94: lstore_3
    //   95: lload_1
    //   96: lload_3
    //   97: lsub
    //   98: lstore_1
    //   99: aload 8
    //   101: astore 7
    //   103: getstatic 32	com/tencent/qqmini/minigame/utils/MD5FileUtil:messagedigest	Ljava/security/MessageDigest;
    //   106: aload_0
    //   107: iconst_0
    //   108: lload_3
    //   109: l2i
    //   110: invokestatic 111	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   113: invokevirtual 115	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   116: goto -61 -> 55
    //   119: aload 8
    //   121: astore 7
    //   123: aload 8
    //   125: invokevirtual 118	java/io/FileInputStream:close	()V
    //   128: aload 8
    //   130: astore 7
    //   132: getstatic 32	com/tencent/qqmini/minigame/utils/MD5FileUtil:messagedigest	Ljava/security/MessageDigest;
    //   135: invokevirtual 122	java/security/MessageDigest:digest	()[B
    //   138: astore 11
    //   140: aload 10
    //   142: astore_0
    //   143: aload 11
    //   145: ifnull +13 -> 158
    //   148: aload 8
    //   150: astore 7
    //   152: aload 11
    //   154: invokestatic 124	com/tencent/qqmini/minigame/utils/MD5FileUtil:bufferToHex	([B)Ljava/lang/String;
    //   157: astore_0
    //   158: aload_0
    //   159: astore 7
    //   161: aload 8
    //   163: invokevirtual 118	java/io/FileInputStream:close	()V
    //   166: aload_0
    //   167: areturn
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   173: aload 7
    //   175: areturn
    //   176: astore 7
    //   178: aload 8
    //   180: astore_0
    //   181: aload 7
    //   183: astore 8
    //   185: goto +14 -> 199
    //   188: astore_0
    //   189: aconst_null
    //   190: astore 7
    //   192: goto +30 -> 222
    //   195: astore 8
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_0
    //   200: astore 7
    //   202: aload 8
    //   204: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   207: aload_0
    //   208: ifnull +36 -> 244
    //   211: aload 9
    //   213: astore 7
    //   215: aload_0
    //   216: invokevirtual 118	java/io/FileInputStream:close	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aload 7
    //   224: ifnull +18 -> 242
    //   227: aload 7
    //   229: invokevirtual 118	java/io/FileInputStream:close	()V
    //   232: goto +10 -> 242
    //   235: astore 7
    //   237: aload 7
    //   239: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   242: aload_0
    //   243: athrow
    //   244: aconst_null
    //   245: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramFile	java.io.File
    //   44	55	1	l1	long
    //   85	24	3	l2	long
    //   72	15	5	l3	long
    //   38	136	7	localObject1	Object
    //   176	6	7	localThrowable1	java.lang.Throwable
    //   190	38	7	localObject2	Object
    //   235	3	7	localIOException	java.io.IOException
    //   34	150	8	localObject3	Object
    //   195	8	8	localThrowable2	java.lang.Throwable
    //   1	211	9	localObject4	Object
    //   4	137	10	localObject5	Object
    //   138	15	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   161	166	168	java/io/IOException
    //   215	219	168	java/io/IOException
    //   40	45	176	java/lang/Throwable
    //   49	55	176	java/lang/Throwable
    //   65	74	176	java/lang/Throwable
    //   103	116	176	java/lang/Throwable
    //   123	128	176	java/lang/Throwable
    //   132	140	176	java/lang/Throwable
    //   152	158	176	java/lang/Throwable
    //   26	36	188	finally
    //   26	36	195	java/lang/Throwable
    //   40	45	221	finally
    //   49	55	221	finally
    //   65	74	221	finally
    //   103	116	221	finally
    //   123	128	221	finally
    //   132	140	221	finally
    //   152	158	221	finally
    //   202	207	221	finally
    //   227	232	235	java/io/IOException
  }
  
  /* Error */
  public static String getFileMd5BigFile(String paramString)
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 9
    //   7: new 96	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore 8
    //   17: aload 8
    //   19: astore 7
    //   21: new 86	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 94	java/io/File:length	()J
    //   32: lstore 5
    //   34: lload 5
    //   36: lstore_3
    //   37: lload 5
    //   39: ldc2_w 138
    //   42: lcmp
    //   43: ifle +7 -> 50
    //   46: ldc2_w 138
    //   49: lstore_3
    //   50: aload 8
    //   52: astore 7
    //   54: sipush 4096
    //   57: newarray byte
    //   59: astore_0
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +51 -> 114
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: aload_0
    //   73: invokevirtual 142	java/io/InputStream:read	([B)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +35 -> 114
    //   82: iload_2
    //   83: istore_1
    //   84: iload_2
    //   85: i2l
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +6 -> 94
    //   91: lload_3
    //   92: l2i
    //   93: istore_1
    //   94: lload_3
    //   95: iload_1
    //   96: i2l
    //   97: lsub
    //   98: lstore_3
    //   99: aload 8
    //   101: astore 7
    //   103: aload 9
    //   105: aload_0
    //   106: iconst_0
    //   107: iload_1
    //   108: invokevirtual 145	java/security/MessageDigest:update	([BII)V
    //   111: goto -51 -> 60
    //   114: aload 8
    //   116: astore 7
    //   118: aload 8
    //   120: invokevirtual 146	java/io/InputStream:close	()V
    //   123: aload 8
    //   125: astore 7
    //   127: aload 9
    //   129: invokevirtual 122	java/security/MessageDigest:digest	()[B
    //   132: invokestatic 124	com/tencent/qqmini/minigame/utils/MD5FileUtil:bufferToHex	([B)Ljava/lang/String;
    //   135: astore_0
    //   136: aload 8
    //   138: invokevirtual 146	java/io/InputStream:close	()V
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: goto +26 -> 170
    //   147: astore_0
    //   148: goto +46 -> 194
    //   151: astore_0
    //   152: goto +58 -> 210
    //   155: astore_0
    //   156: goto +70 -> 226
    //   159: astore_0
    //   160: aconst_null
    //   161: astore 7
    //   163: goto +82 -> 245
    //   166: astore_0
    //   167: aconst_null
    //   168: astore 8
    //   170: aload 8
    //   172: astore 7
    //   174: aload_0
    //   175: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   178: aload 8
    //   180: ifnull +62 -> 242
    //   183: aload 8
    //   185: invokevirtual 146	java/io/InputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aconst_null
    //   192: astore 8
    //   194: aload 8
    //   196: astore 7
    //   198: aload_0
    //   199: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   202: aload 8
    //   204: ifnull +38 -> 242
    //   207: goto -24 -> 183
    //   210: aload 8
    //   212: astore 7
    //   214: aload_0
    //   215: invokevirtual 147	java/io/FileNotFoundException:printStackTrace	()V
    //   218: aload 8
    //   220: ifnull +22 -> 242
    //   223: goto -40 -> 183
    //   226: aload 8
    //   228: astore 7
    //   230: aload_0
    //   231: invokevirtual 148	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   234: aload 8
    //   236: ifnull +6 -> 242
    //   239: goto -56 -> 183
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aload 7
    //   247: ifnull +8 -> 255
    //   250: aload 7
    //   252: invokevirtual 146	java/io/InputStream:close	()V
    //   255: goto +5 -> 260
    //   258: aload_0
    //   259: athrow
    //   260: goto -2 -> 258
    //   263: astore 7
    //   265: aload_0
    //   266: areturn
    //   267: astore_0
    //   268: aconst_null
    //   269: areturn
    //   270: astore 7
    //   272: goto -17 -> 255
    //   275: astore_0
    //   276: aconst_null
    //   277: astore 8
    //   279: goto -69 -> 210
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 8
    //   286: goto -60 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString	String
    //   83	25	1	i	int
    //   76	9	2	j	int
    //   36	63	3	l1	long
    //   32	6	5	l2	long
    //   19	232	7	localFileInputStream1	java.io.FileInputStream
    //   263	1	7	localException1	java.lang.Exception
    //   270	1	7	localException2	java.lang.Exception
    //   15	270	8	localFileInputStream2	java.io.FileInputStream
    //   5	123	9	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   21	34	143	java/lang/Throwable
    //   54	60	143	java/lang/Throwable
    //   70	77	143	java/lang/Throwable
    //   103	111	143	java/lang/Throwable
    //   118	123	143	java/lang/Throwable
    //   127	136	143	java/lang/Throwable
    //   21	34	147	java/io/IOException
    //   54	60	147	java/io/IOException
    //   70	77	147	java/io/IOException
    //   103	111	147	java/io/IOException
    //   118	123	147	java/io/IOException
    //   127	136	147	java/io/IOException
    //   21	34	151	java/io/FileNotFoundException
    //   54	60	151	java/io/FileNotFoundException
    //   70	77	151	java/io/FileNotFoundException
    //   103	111	151	java/io/FileNotFoundException
    //   118	123	151	java/io/FileNotFoundException
    //   127	136	151	java/io/FileNotFoundException
    //   21	34	155	java/security/NoSuchAlgorithmException
    //   54	60	155	java/security/NoSuchAlgorithmException
    //   70	77	155	java/security/NoSuchAlgorithmException
    //   103	111	155	java/security/NoSuchAlgorithmException
    //   118	123	155	java/security/NoSuchAlgorithmException
    //   127	136	155	java/security/NoSuchAlgorithmException
    //   0	17	159	finally
    //   0	17	166	java/lang/Throwable
    //   0	17	190	java/io/IOException
    //   21	34	244	finally
    //   54	60	244	finally
    //   70	77	244	finally
    //   103	111	244	finally
    //   118	123	244	finally
    //   127	136	244	finally
    //   174	178	244	finally
    //   198	202	244	finally
    //   214	218	244	finally
    //   230	234	244	finally
    //   136	141	263	java/lang/Exception
    //   183	188	267	java/lang/Exception
    //   250	255	270	java/lang/Exception
    //   0	17	275	java/io/FileNotFoundException
    //   0	17	282	java/security/NoSuchAlgorithmException
  }
  
  public static String getMD5String(String paramString)
  {
    return getMD5String(paramString.getBytes());
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    messagedigest.update(paramArrayOfByte);
    return bufferToHex(messagedigest.digest());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.MD5FileUtil
 * JD-Core Version:    0.7.0.1
 */