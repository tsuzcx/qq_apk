package com.tencent.secprotocol.utils;

import android.util.Base64;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class VerifyFileUtil
{
  private static final int MAX_FILE_SIZE = 5242880;
  private static final int MAX_SIGNATURE_LEN = 256;
  private static final byte[] MD5_WITH_RSA_STR_CONST = { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
  private static final byte[] PUGLIC_KEY_CONST = { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33 };
  private static final byte[] RSA_STR_CONST = { 23, 67, -110 };
  private static final int SIGNED_MAGIC_VALUE = 1364419939;
  private static final int SO_SIG_DATA_LEN = 140;
  
  private static PublicKey getPublicKey(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = StringManager.get(PUGLIC_KEY_CONST);
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(StringManager.get(RSA_STR_CONST)).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static VerifyFileUtil.QSecSigData getSigData(DataInputStream paramDataInputStream)
  {
    VerifyFileUtil.QSecSigData localQSecSigData = new VerifyFileUtil.QSecSigData(null);
    try
    {
      localQSecSigData.magicValue = paramDataInputStream.readInt();
      localQSecSigData.origFileLen = paramDataInputStream.readInt();
      localQSecSigData.sigLen = paramDataInputStream.readInt();
      if ((localQSecSigData.sigLen > 0) && (localQSecSigData.sigLen <= 256))
      {
        localQSecSigData.signature = new byte[localQSecSigData.sigLen];
        paramDataInputStream.read(localQSecSigData.signature);
        return localQSecSigData;
      }
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
      return null;
    }
    return null;
  }
  
  private static boolean verifyBuffer(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance(StringManager.get(MD5_WITH_RSA_STR_CONST));
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static byte[] verifyCfgFile(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 255	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 208	java/io/DataInputStream
    //   12: dup
    //   13: new 257	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 263	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload 5
    //   28: astore_0
    //   29: aload 5
    //   31: invokevirtual 266	java/io/DataInputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: bipush 8
    //   38: if_icmplt +9 -> 47
    //   41: iload_2
    //   42: ldc 7
    //   44: if_icmple +22 -> 66
    //   47: aload 5
    //   49: ifnull -42 -> 7
    //   52: aload 5
    //   54: invokevirtual 269	java/io/DataInputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload 5
    //   68: astore_0
    //   69: aload 5
    //   71: invokevirtual 212	java/io/DataInputStream:readInt	()I
    //   74: istore_3
    //   75: iload_3
    //   76: ldc 15
    //   78: if_icmpeq +22 -> 100
    //   81: aload 5
    //   83: ifnull -76 -> 7
    //   86: aload 5
    //   88: invokevirtual 269	java/io/DataInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: aload 5
    //   102: astore_0
    //   103: aload 5
    //   105: invokevirtual 212	java/io/DataInputStream:readInt	()I
    //   108: istore_3
    //   109: iload_3
    //   110: ifle +18 -> 128
    //   113: iload_3
    //   114: sipush 256
    //   117: if_icmpgt +11 -> 128
    //   120: iload_3
    //   121: iload_2
    //   122: bipush 8
    //   124: isub
    //   125: if_icmplt +22 -> 147
    //   128: aload 5
    //   130: ifnull -123 -> 7
    //   133: aload 5
    //   135: invokevirtual 269	java/io/DataInputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: astore_0
    //   150: aload_1
    //   151: invokestatic 271	com/tencent/secprotocol/utils/VerifyFileUtil:getPublicKey	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnonnull +22 -> 180
    //   161: aload 5
    //   163: ifnull -156 -> 7
    //   166: aload 5
    //   168: invokevirtual 269	java/io/DataInputStream:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: aload 5
    //   182: astore_0
    //   183: iload_3
    //   184: newarray byte
    //   186: astore 7
    //   188: aload 5
    //   190: astore_0
    //   191: iload_2
    //   192: bipush 8
    //   194: isub
    //   195: iload_3
    //   196: isub
    //   197: newarray byte
    //   199: astore_1
    //   200: aload 5
    //   202: astore_0
    //   203: aload 5
    //   205: aload 7
    //   207: invokevirtual 228	java/io/DataInputStream:read	([B)I
    //   210: pop
    //   211: aload 5
    //   213: astore_0
    //   214: aload 5
    //   216: aload_1
    //   217: invokevirtual 228	java/io/DataInputStream:read	([B)I
    //   220: pop
    //   221: aload 5
    //   223: astore_0
    //   224: aload_1
    //   225: aload 7
    //   227: aload 6
    //   229: invokestatic 273	com/tencent/secprotocol/utils/VerifyFileUtil:verifyBuffer	([B[BLjava/security/PublicKey;)Z
    //   232: istore 4
    //   234: iload 4
    //   236: ifeq +23 -> 259
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 269	java/io/DataInputStream:close	()V
    //   249: aload_1
    //   250: areturn
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   256: goto -7 -> 249
    //   259: aload 5
    //   261: ifnull -254 -> 7
    //   264: aload 5
    //   266: invokevirtual 269	java/io/DataInputStream:close	()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   276: aconst_null
    //   277: areturn
    //   278: astore 6
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_1
    //   283: astore_0
    //   284: aload 6
    //   286: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   289: aload_1
    //   290: ifnull -283 -> 7
    //   293: aload_1
    //   294: invokevirtual 269	java/io/DataInputStream:close	()V
    //   297: aconst_null
    //   298: areturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   304: aconst_null
    //   305: areturn
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_0
    //   309: aload_0
    //   310: ifnull +7 -> 317
    //   313: aload_0
    //   314: invokevirtual 269	java/io/DataInputStream:close	()V
    //   317: aload_1
    //   318: athrow
    //   319: astore_0
    //   320: aload_0
    //   321: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   324: goto -7 -> 317
    //   327: astore_1
    //   328: goto -19 -> 309
    //   331: astore 6
    //   333: aload 5
    //   335: astore_1
    //   336: goto -54 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramFile	java.io.File
    //   0	339	1	paramString	String
    //   34	161	2	i	int
    //   74	123	3	j	int
    //   232	3	4	bool	boolean
    //   24	310	5	localDataInputStream	DataInputStream
    //   154	74	6	localPublicKey	PublicKey
    //   278	7	6	localIOException1	IOException
    //   331	1	6	localIOException2	IOException
    //   186	40	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	57	59	java/io/IOException
    //   86	91	93	java/io/IOException
    //   133	138	140	java/io/IOException
    //   166	171	173	java/io/IOException
    //   244	249	251	java/io/IOException
    //   264	269	271	java/io/IOException
    //   9	26	278	java/io/IOException
    //   293	297	299	java/io/IOException
    //   9	26	306	finally
    //   313	317	319	java/io/IOException
    //   29	35	327	finally
    //   69	75	327	finally
    //   103	109	327	finally
    //   150	156	327	finally
    //   183	188	327	finally
    //   191	200	327	finally
    //   203	211	327	finally
    //   214	221	327	finally
    //   224	234	327	finally
    //   284	289	327	finally
    //   29	35	331	java/io/IOException
    //   69	75	331	java/io/IOException
    //   103	109	331	java/io/IOException
    //   150	156	331	java/io/IOException
    //   183	188	331	java/io/IOException
    //   191	200	331	java/io/IOException
    //   203	211	331	java/io/IOException
    //   214	221	331	java/io/IOException
    //   224	234	331	java/io/IOException
  }
  
  /* Error */
  public static boolean verifySoFile(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: invokevirtual 255	java/io/File:exists	()Z
    //   13: ifne +6 -> 19
    //   16: iload 4
    //   18: ireturn
    //   19: new 208	java/io/DataInputStream
    //   22: dup
    //   23: new 257	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 263	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 6
    //   36: aload 6
    //   38: invokevirtual 266	java/io/DataInputStream:available	()I
    //   41: istore_2
    //   42: iload_2
    //   43: sipush 140
    //   46: if_icmpgt +40 -> 86
    //   49: aload 6
    //   51: ifnull +8 -> 59
    //   54: aload 6
    //   56: invokevirtual 269	java/io/DataInputStream:close	()V
    //   59: iconst_0
    //   60: ifeq -44 -> 16
    //   63: new 277	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   83: goto -24 -> 59
    //   86: iload_2
    //   87: sipush 140
    //   90: isub
    //   91: istore_2
    //   92: aload 6
    //   94: iload_2
    //   95: invokevirtual 282	java/io/DataInputStream:skipBytes	(I)I
    //   98: pop
    //   99: aload 6
    //   101: invokestatic 284	com/tencent/secprotocol/utils/VerifyFileUtil:getSigData	(Ljava/io/DataInputStream;)Lcom/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData;
    //   104: astore 8
    //   106: aload 8
    //   108: ifnonnull +40 -> 148
    //   111: aload 6
    //   113: ifnull +8 -> 121
    //   116: aload 6
    //   118: invokevirtual 269	java/io/DataInputStream:close	()V
    //   121: iconst_0
    //   122: ifeq -106 -> 16
    //   125: new 277	java/lang/NullPointerException
    //   128: dup
    //   129: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   145: goto -24 -> 121
    //   148: aload 8
    //   150: getfield 215	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:magicValue	I
    //   153: istore_3
    //   154: iload_3
    //   155: ldc 15
    //   157: if_icmpeq +40 -> 197
    //   160: aload 6
    //   162: ifnull +8 -> 170
    //   165: aload 6
    //   167: invokevirtual 269	java/io/DataInputStream:close	()V
    //   170: iconst_0
    //   171: ifeq -155 -> 16
    //   174: new 277	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   194: goto -24 -> 170
    //   197: aload 8
    //   199: getfield 218	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:origFileLen	I
    //   202: ifle +15 -> 217
    //   205: aload 8
    //   207: getfield 218	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:origFileLen	I
    //   210: istore_3
    //   211: iload_3
    //   212: ldc 7
    //   214: if_icmple +40 -> 254
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 269	java/io/DataInputStream:close	()V
    //   227: iconst_0
    //   228: ifeq -212 -> 16
    //   231: new 277	java/lang/NullPointerException
    //   234: dup
    //   235: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   238: athrow
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   251: goto -24 -> 227
    //   254: aload 8
    //   256: getfield 218	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:origFileLen	I
    //   259: istore_3
    //   260: iload_2
    //   261: iload_3
    //   262: if_icmpeq +40 -> 302
    //   265: aload 6
    //   267: ifnull +8 -> 275
    //   270: aload 6
    //   272: invokevirtual 269	java/io/DataInputStream:close	()V
    //   275: iconst_0
    //   276: ifeq -260 -> 16
    //   279: new 277	java/lang/NullPointerException
    //   282: dup
    //   283: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   286: athrow
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   292: iconst_0
    //   293: ireturn
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   299: goto -24 -> 275
    //   302: aload_1
    //   303: invokestatic 271	com/tencent/secprotocol/utils/VerifyFileUtil:getPublicKey	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   306: astore_1
    //   307: aload_1
    //   308: ifnonnull +40 -> 348
    //   311: aload 6
    //   313: ifnull +8 -> 321
    //   316: aload 6
    //   318: invokevirtual 269	java/io/DataInputStream:close	()V
    //   321: iconst_0
    //   322: ifeq -306 -> 16
    //   325: new 277	java/lang/NullPointerException
    //   328: dup
    //   329: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   332: athrow
    //   333: astore_0
    //   334: aload_0
    //   335: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   338: iconst_0
    //   339: ireturn
    //   340: astore_0
    //   341: aload_0
    //   342: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   345: goto -24 -> 321
    //   348: new 208	java/io/DataInputStream
    //   351: dup
    //   352: new 257	java/io/FileInputStream
    //   355: dup
    //   356: aload_0
    //   357: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   360: invokespecial 263	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   363: astore_0
    //   364: aload_0
    //   365: aload 8
    //   367: getfield 218	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:origFileLen	I
    //   370: aload 8
    //   372: getfield 224	com/tencent/secprotocol/utils/VerifyFileUtil$QSecSigData:signature	[B
    //   375: aload_1
    //   376: invokestatic 288	com/tencent/secprotocol/utils/VerifyFileUtil:verifyStream	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   379: istore 5
    //   381: aload 6
    //   383: ifnull +8 -> 391
    //   386: aload 6
    //   388: invokevirtual 269	java/io/DataInputStream:close	()V
    //   391: iload 5
    //   393: istore 4
    //   395: aload_0
    //   396: ifnull -380 -> 16
    //   399: aload_0
    //   400: invokevirtual 269	java/io/DataInputStream:close	()V
    //   403: iload 5
    //   405: ireturn
    //   406: astore_0
    //   407: aload_0
    //   408: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   411: iload 5
    //   413: ireturn
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   419: goto -28 -> 391
    //   422: astore 6
    //   424: aconst_null
    //   425: astore_0
    //   426: aload 8
    //   428: astore_1
    //   429: aload 6
    //   431: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   434: aload_1
    //   435: ifnull +7 -> 442
    //   438: aload_1
    //   439: invokevirtual 269	java/io/DataInputStream:close	()V
    //   442: aload_0
    //   443: ifnull -427 -> 16
    //   446: aload_0
    //   447: invokevirtual 269	java/io/DataInputStream:close	()V
    //   450: iconst_0
    //   451: ireturn
    //   452: astore_0
    //   453: aload_0
    //   454: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   457: iconst_0
    //   458: ireturn
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   464: goto -22 -> 442
    //   467: astore_0
    //   468: aconst_null
    //   469: astore 6
    //   471: aload 7
    //   473: astore_1
    //   474: aload 6
    //   476: ifnull +8 -> 484
    //   479: aload 6
    //   481: invokevirtual 269	java/io/DataInputStream:close	()V
    //   484: aload_1
    //   485: ifnull +7 -> 492
    //   488: aload_1
    //   489: invokevirtual 269	java/io/DataInputStream:close	()V
    //   492: aload_0
    //   493: athrow
    //   494: astore 6
    //   496: aload 6
    //   498: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   501: goto -17 -> 484
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   509: goto -17 -> 492
    //   512: astore_0
    //   513: aload 7
    //   515: astore_1
    //   516: goto -42 -> 474
    //   519: astore 7
    //   521: aload_0
    //   522: astore_1
    //   523: aload 7
    //   525: astore_0
    //   526: goto -52 -> 474
    //   529: astore 7
    //   531: aload_1
    //   532: astore 6
    //   534: aload_0
    //   535: astore_1
    //   536: aload 7
    //   538: astore_0
    //   539: goto -65 -> 474
    //   542: astore 7
    //   544: aconst_null
    //   545: astore_0
    //   546: aload 6
    //   548: astore_1
    //   549: aload 7
    //   551: astore 6
    //   553: goto -124 -> 429
    //   556: astore 7
    //   558: aload 6
    //   560: astore_1
    //   561: aload 7
    //   563: astore 6
    //   565: goto -136 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	paramFile	java.io.File
    //   0	568	1	paramString	String
    //   41	222	2	i	int
    //   153	110	3	j	int
    //   7	387	4	bool1	boolean
    //   379	33	5	bool2	boolean
    //   34	353	6	localDataInputStream	DataInputStream
    //   422	8	6	localIOException1	IOException
    //   469	11	6	localObject1	Object
    //   494	3	6	localIOException2	IOException
    //   532	32	6	localObject2	Object
    //   1	513	7	localObject3	Object
    //   519	5	7	localObject4	Object
    //   529	8	7	localObject5	Object
    //   542	8	7	localIOException3	IOException
    //   556	6	7	localIOException4	IOException
    //   4	423	8	localQSecSigData	VerifyFileUtil.QSecSigData
    // Exception table:
    //   from	to	target	type
    //   63	71	71	java/io/IOException
    //   54	59	78	java/io/IOException
    //   125	133	133	java/io/IOException
    //   116	121	140	java/io/IOException
    //   174	182	182	java/io/IOException
    //   165	170	189	java/io/IOException
    //   231	239	239	java/io/IOException
    //   222	227	246	java/io/IOException
    //   279	287	287	java/io/IOException
    //   270	275	294	java/io/IOException
    //   325	333	333	java/io/IOException
    //   316	321	340	java/io/IOException
    //   399	403	406	java/io/IOException
    //   386	391	414	java/io/IOException
    //   19	36	422	java/io/IOException
    //   446	450	452	java/io/IOException
    //   438	442	459	java/io/IOException
    //   19	36	467	finally
    //   479	484	494	java/io/IOException
    //   488	492	504	java/io/IOException
    //   36	42	512	finally
    //   92	106	512	finally
    //   148	154	512	finally
    //   197	211	512	finally
    //   254	260	512	finally
    //   302	307	512	finally
    //   348	364	512	finally
    //   364	381	519	finally
    //   429	434	529	finally
    //   36	42	542	java/io/IOException
    //   92	106	542	java/io/IOException
    //   148	154	542	java/io/IOException
    //   197	211	542	java/io/IOException
    //   254	260	542	java/io/IOException
    //   302	307	542	java/io/IOException
    //   348	364	542	java/io/IOException
    //   364	381	556	java/io/IOException
  }
  
  private static boolean verifyStream(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    for (;;)
    {
      int i;
      try
      {
        localSignature = Signature.getInstance(StringManager.get(MD5_WITH_RSA_STR_CONST));
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192)
        {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
          break label83;
          return localSignature.verify(paramArrayOfByte);
        }
        else
        {
          i = paramDataInputStream.read(paramPublicKey);
        }
      }
      catch (Exception paramDataInputStream)
      {
        Signature localSignature;
        paramDataInputStream.printStackTrace();
        return false;
      }
      localSignature.update(paramPublicKey, 0, i);
      paramInt -= i;
      continue;
      label83:
      if (i != 0) {
        if (i != -1) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.secprotocol.utils.VerifyFileUtil
 * JD-Core Version:    0.7.0.1
 */