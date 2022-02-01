package com.tencent.qqprotect.singleupdate;

import android.util.Base64;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class VerifyFileUtil
{
  public static VerifyFileUtil.QSecSigData a(DataInputStream paramDataInputStream)
  {
    VerifyFileUtil.QSecSigData localQSecSigData = new VerifyFileUtil.QSecSigData(null);
    try
    {
      localQSecSigData.jdField_a_of_type_Int = paramDataInputStream.readInt();
      localQSecSigData.b = paramDataInputStream.readInt();
      localQSecSigData.c = paramDataInputStream.readInt();
      if (localQSecSigData.c > 0)
      {
        if (localQSecSigData.c > 256) {
          return null;
        }
        localQSecSigData.jdField_a_of_type_ArrayOfByte = new byte[localQSecSigData.c];
        paramDataInputStream.read(localQSecSigData.jdField_a_of_type_ArrayOfByte);
        return localQSecSigData;
      }
      return null;
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
    }
    return null;
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMz0GiKqUQnpnsCh5sqYlVDmKi1yjICNkkFbzAeTaWf/pENkUTT19LE8FWn48C63UOCHQuUf67qygCFUApW5+20WD5SacBfdzmufohcCAzfH7J5zeN0AqOMgo7+k7I+oIpZqnHMrb1vBlvHb+79ct7PP+DqSPbjr+dQUcO6rNkjwIDAQAB";
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean a(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i;
    for (;;)
    {
      try
      {
        localSignature = Signature.getInstance("MD5withRSA");
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192) {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
        } else {
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
    }
    for (;;)
    {
      boolean bool = localSignature.verify(paramArrayOfByte);
      return bool;
      if (i != 0) {
        if (i != -1) {
          break;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 102	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: new 20	java/io/DataInputStream
    //   18: dup
    //   19: new 104	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 113	java/io/DataInputStream:available	()I
    //   37: istore_2
    //   38: iload_2
    //   39: sipush 140
    //   42: if_icmpgt +17 -> 59
    //   45: aload 5
    //   47: invokevirtual 116	java/io/DataInputStream:close	()V
    //   50: iconst_0
    //   51: ireturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: iload_2
    //   60: sipush 140
    //   63: isub
    //   64: istore_2
    //   65: aload 5
    //   67: iload_2
    //   68: invokevirtual 120	java/io/DataInputStream:skipBytes	(I)I
    //   71: pop
    //   72: aload 5
    //   74: invokestatic 122	com/tencent/qqprotect/singleupdate/VerifyFileUtil:a	(Ljava/io/DataInputStream;)Lcom/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData;
    //   77: astore 7
    //   79: aload 7
    //   81: ifnonnull +17 -> 98
    //   84: aload 5
    //   86: invokevirtual 116	java/io/DataInputStream:close	()V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: aload 7
    //   100: getfield 27	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:jdField_a_of_type_Int	I
    //   103: istore_3
    //   104: iload_3
    //   105: ldc 123
    //   107: if_icmpeq +17 -> 124
    //   110: aload 5
    //   112: invokevirtual 116	java/io/DataInputStream:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload 7
    //   126: getfield 30	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:b	I
    //   129: ifle +133 -> 262
    //   132: aload 7
    //   134: getfield 30	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:b	I
    //   137: ldc 124
    //   139: if_icmple +6 -> 145
    //   142: goto +120 -> 262
    //   145: aload 7
    //   147: getfield 30	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:b	I
    //   150: istore_3
    //   151: iload_2
    //   152: iload_3
    //   153: if_icmpeq +17 -> 170
    //   156: aload 5
    //   158: invokevirtual 116	java/io/DataInputStream:close	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_1
    //   171: invokestatic 126	com/tencent/qqprotect/singleupdate/VerifyFileUtil:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnonnull +17 -> 193
    //   179: aload 5
    //   181: invokevirtual 116	java/io/DataInputStream:close	()V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: new 20	java/io/DataInputStream
    //   196: dup
    //   197: new 104	java/io/FileInputStream
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   205: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   208: astore_0
    //   209: aload_0
    //   210: aload 7
    //   212: getfield 30	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:b	I
    //   215: aload 7
    //   217: getfield 36	com/tencent/qqprotect/singleupdate/VerifyFileUtil$QSecSigData:jdField_a_of_type_ArrayOfByte	[B
    //   220: aload_1
    //   221: invokestatic 128	com/tencent/qqprotect/singleupdate/VerifyFileUtil:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   224: istore 4
    //   226: aload 5
    //   228: invokevirtual 116	java/io/DataInputStream:close	()V
    //   231: goto +8 -> 239
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   239: aload_0
    //   240: invokevirtual 116	java/io/DataInputStream:close	()V
    //   243: iload 4
    //   245: ireturn
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   251: iload 4
    //   253: ireturn
    //   254: astore_1
    //   255: goto +91 -> 346
    //   258: astore_1
    //   259: goto +27 -> 286
    //   262: aload 5
    //   264: invokevirtual 116	java/io/DataInputStream:close	()V
    //   267: iconst_0
    //   268: ireturn
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_0
    //   277: aload 6
    //   279: astore_1
    //   280: goto +74 -> 354
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_0
    //   286: goto +20 -> 306
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 5
    //   293: aload 6
    //   295: astore_1
    //   296: goto +58 -> 354
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_0
    //   302: aload 7
    //   304: astore 5
    //   306: aload_1
    //   307: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   310: aload 5
    //   312: ifnull +16 -> 328
    //   315: aload 5
    //   317: invokevirtual 116	java/io/DataInputStream:close	()V
    //   320: goto +8 -> 328
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   328: aload_0
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: invokevirtual 116	java/io/DataInputStream:close	()V
    //   336: iconst_0
    //   337: ireturn
    //   338: astore_0
    //   339: aload_0
    //   340: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore_1
    //   346: aload_0
    //   347: astore 6
    //   349: aload_1
    //   350: astore_0
    //   351: aload 6
    //   353: astore_1
    //   354: aload 5
    //   356: ifnull +18 -> 374
    //   359: aload 5
    //   361: invokevirtual 116	java/io/DataInputStream:close	()V
    //   364: goto +10 -> 374
    //   367: astore 5
    //   369: aload 5
    //   371: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   374: aload_1
    //   375: ifnull +15 -> 390
    //   378: aload_1
    //   379: invokevirtual 116	java/io/DataInputStream:close	()V
    //   382: goto +8 -> 390
    //   385: astore_1
    //   386: aload_1
    //   387: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   390: aload_0
    //   391: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramFile	java.io.File
    //   0	392	1	paramString	String
    //   37	117	2	i	int
    //   103	51	3	j	int
    //   224	28	4	bool	boolean
    //   30	330	5	localObject	Object
    //   367	3	5	localIOException	IOException
    //   10	342	6	localFile	java.io.File
    //   13	290	7	localQSecSigData	VerifyFileUtil.QSecSigData
    // Exception table:
    //   from	to	target	type
    //   45	50	52	java/io/IOException
    //   84	89	91	java/io/IOException
    //   110	115	117	java/io/IOException
    //   156	161	163	java/io/IOException
    //   179	184	186	java/io/IOException
    //   226	231	234	java/io/IOException
    //   239	243	246	java/io/IOException
    //   209	226	254	finally
    //   209	226	258	java/io/IOException
    //   262	267	269	java/io/IOException
    //   32	38	276	finally
    //   65	79	276	finally
    //   98	104	276	finally
    //   124	142	276	finally
    //   145	151	276	finally
    //   170	175	276	finally
    //   193	209	276	finally
    //   32	38	283	java/io/IOException
    //   65	79	283	java/io/IOException
    //   98	104	283	java/io/IOException
    //   124	142	283	java/io/IOException
    //   145	151	283	java/io/IOException
    //   170	175	283	java/io/IOException
    //   193	209	283	java/io/IOException
    //   15	32	289	finally
    //   15	32	299	java/io/IOException
    //   315	320	323	java/io/IOException
    //   332	336	338	java/io/IOException
    //   306	310	345	finally
    //   359	364	367	java/io/IOException
    //   378	382	385	java/io/IOException
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance("MD5withRSA");
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
  public static byte[] a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 20	java/io/DataInputStream
    //   3: dup
    //   4: new 104	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 5
    //   17: aload 5
    //   19: astore_0
    //   20: aload 5
    //   22: invokevirtual 113	java/io/DataInputStream:available	()I
    //   25: istore_2
    //   26: iload_2
    //   27: bipush 8
    //   29: if_icmplt +193 -> 222
    //   32: iload_2
    //   33: ldc 124
    //   35: if_icmple +6 -> 41
    //   38: goto +184 -> 222
    //   41: aload 5
    //   43: astore_0
    //   44: aload 5
    //   46: invokevirtual 24	java/io/DataInputStream:readInt	()I
    //   49: istore_3
    //   50: iload_3
    //   51: ldc 123
    //   53: if_icmpeq +17 -> 70
    //   56: aload 5
    //   58: invokevirtual 116	java/io/DataInputStream:close	()V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload 5
    //   72: astore_0
    //   73: aload 5
    //   75: invokevirtual 24	java/io/DataInputStream:readInt	()I
    //   78: istore_3
    //   79: iload_3
    //   80: ifle +128 -> 208
    //   83: iload_3
    //   84: sipush 256
    //   87: if_icmpgt +121 -> 208
    //   90: iload_2
    //   91: bipush 8
    //   93: isub
    //   94: istore_2
    //   95: iload_3
    //   96: iload_2
    //   97: if_icmplt +6 -> 103
    //   100: goto +108 -> 208
    //   103: aload 5
    //   105: astore_0
    //   106: aload_1
    //   107: invokestatic 126	com/tencent/qqprotect/singleupdate/VerifyFileUtil:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   110: astore 6
    //   112: aload 6
    //   114: ifnonnull +17 -> 131
    //   117: aload 5
    //   119: invokevirtual 116	java/io/DataInputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: aload 5
    //   133: astore_0
    //   134: iload_3
    //   135: newarray byte
    //   137: astore 7
    //   139: aload 5
    //   141: astore_0
    //   142: iload_2
    //   143: iload_3
    //   144: isub
    //   145: newarray byte
    //   147: astore_1
    //   148: aload 5
    //   150: astore_0
    //   151: aload 5
    //   153: aload 7
    //   155: invokevirtual 40	java/io/DataInputStream:read	([B)I
    //   158: pop
    //   159: aload 5
    //   161: astore_0
    //   162: aload 5
    //   164: aload_1
    //   165: invokevirtual 40	java/io/DataInputStream:read	([B)I
    //   168: pop
    //   169: aload 5
    //   171: astore_0
    //   172: aload_1
    //   173: aload 7
    //   175: aload 6
    //   177: invokestatic 134	com/tencent/qqprotect/singleupdate/VerifyFileUtil:a	([B[BLjava/security/PublicKey;)Z
    //   180: istore 4
    //   182: iload 4
    //   184: ifeq +17 -> 201
    //   187: aload 5
    //   189: invokevirtual 116	java/io/DataInputStream:close	()V
    //   192: aload_1
    //   193: areturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   199: aload_1
    //   200: areturn
    //   201: aload 5
    //   203: invokevirtual 116	java/io/DataInputStream:close	()V
    //   206: aconst_null
    //   207: areturn
    //   208: aload 5
    //   210: invokevirtual 116	java/io/DataInputStream:close	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   220: aconst_null
    //   221: areturn
    //   222: aload 5
    //   224: invokevirtual 116	java/io/DataInputStream:close	()V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: aload 5
    //   239: astore_1
    //   240: aload_0
    //   241: astore 5
    //   243: goto +13 -> 256
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_0
    //   249: goto +32 -> 281
    //   252: astore 5
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: astore_0
    //   258: aload 5
    //   260: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   263: aload_1
    //   264: ifnull +14 -> 278
    //   267: aload_1
    //   268: invokevirtual 116	java/io/DataInputStream:close	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aload_0
    //   275: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_1
    //   281: aload_0
    //   282: ifnull +15 -> 297
    //   285: aload_0
    //   286: invokevirtual 116	java/io/DataInputStream:close	()V
    //   289: goto +8 -> 297
    //   292: astore_0
    //   293: aload_0
    //   294: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   297: aload_1
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramFile	java.io.File
    //   0	299	1	paramString	String
    //   25	120	2	i	int
    //   49	96	3	j	int
    //   180	3	4	bool	boolean
    //   15	227	5	localObject	Object
    //   252	7	5	localIOException	IOException
    //   110	66	6	localPublicKey	PublicKey
    //   137	37	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   56	61	63	java/io/IOException
    //   117	122	124	java/io/IOException
    //   187	192	194	java/io/IOException
    //   208	213	215	java/io/IOException
    //   222	227	229	java/io/IOException
    //   20	26	236	java/io/IOException
    //   44	50	236	java/io/IOException
    //   73	79	236	java/io/IOException
    //   106	112	236	java/io/IOException
    //   134	139	236	java/io/IOException
    //   142	148	236	java/io/IOException
    //   151	159	236	java/io/IOException
    //   162	169	236	java/io/IOException
    //   172	182	236	java/io/IOException
    //   0	17	246	finally
    //   0	17	252	java/io/IOException
    //   201	206	273	java/io/IOException
    //   267	271	273	java/io/IOException
    //   20	26	280	finally
    //   44	50	280	finally
    //   73	79	280	finally
    //   106	112	280	finally
    //   134	139	280	finally
    //   142	148	280	finally
    //   151	159	280	finally
    //   162	169	280	finally
    //   172	182	280	finally
    //   258	263	280	finally
    //   285	289	292	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.VerifyFileUtil
 * JD-Core Version:    0.7.0.1
 */