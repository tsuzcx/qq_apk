package com.tencent.qmsp.sdk.d;

import android.util.Base64;
import com.tencent.qmsp.sdk.f.k;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class e
{
  private static final byte[] a = { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33 };
  private static final byte[] b = { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
  private static final byte[] c = { 23, 67, -110 };
  
  public static e.b a(DataInputStream paramDataInputStream)
  {
    e.b localb = new e.b(null);
    try
    {
      localb.a = paramDataInputStream.readInt();
      localb.b = paramDataInputStream.readInt();
      localb.c = paramDataInputStream.readInt();
      if (localb.c > 0)
      {
        if (localb.c > 256) {
          return null;
        }
        localb.d = new byte[localb.c];
        paramDataInputStream.read(localb.d);
        return localb;
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
      str = k.a(a);
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(k.a(c)).generatePublic(paramString);
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
        localSignature = Signature.getInstance(k.a(b));
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
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance(k.a(b));
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
    //   0: aload_0
    //   1: invokevirtual 244	java/io/File:exists	()Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: iload 4
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 162	java/io/DataInputStream
    //   19: dup
    //   20: new 246	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 252	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore 5
    //   35: aload_0
    //   36: invokevirtual 255	java/io/DataInputStream:available	()I
    //   39: istore_2
    //   40: iload_2
    //   41: bipush 8
    //   43: if_icmplt +184 -> 227
    //   46: iload_2
    //   47: ldc_w 256
    //   50: if_icmple +6 -> 56
    //   53: goto +174 -> 227
    //   56: aload_0
    //   57: astore 5
    //   59: aload_0
    //   60: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   63: istore_3
    //   64: iload_3
    //   65: ldc_w 257
    //   68: if_icmpeq +16 -> 84
    //   71: aload_0
    //   72: invokevirtual 260	java/io/DataInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    //   84: aload_0
    //   85: astore 5
    //   87: aload_0
    //   88: invokevirtual 166	java/io/DataInputStream:readInt	()I
    //   91: istore_3
    //   92: iload_3
    //   93: ifle +121 -> 214
    //   96: iload_3
    //   97: sipush 256
    //   100: if_icmpgt +114 -> 214
    //   103: iload_2
    //   104: bipush 8
    //   106: isub
    //   107: istore_2
    //   108: iload_3
    //   109: iload_2
    //   110: if_icmplt +6 -> 116
    //   113: goto +101 -> 214
    //   116: aload_0
    //   117: astore 5
    //   119: aload_1
    //   120: invokestatic 262	com/tencent/qmsp/sdk/d/e:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   123: astore_1
    //   124: aload_1
    //   125: ifnonnull +16 -> 141
    //   128: aload_0
    //   129: invokevirtual 260	java/io/DataInputStream:close	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    //   141: aload_0
    //   142: astore 5
    //   144: iload_3
    //   145: newarray byte
    //   147: astore 7
    //   149: aload_0
    //   150: astore 5
    //   152: iload_2
    //   153: iload_3
    //   154: isub
    //   155: newarray byte
    //   157: astore 6
    //   159: aload_0
    //   160: astore 5
    //   162: aload_0
    //   163: aload 7
    //   165: invokevirtual 180	java/io/DataInputStream:read	([B)I
    //   168: pop
    //   169: aload_0
    //   170: astore 5
    //   172: aload_0
    //   173: aload 6
    //   175: invokevirtual 180	java/io/DataInputStream:read	([B)I
    //   178: pop
    //   179: aload_0
    //   180: astore 5
    //   182: aload 6
    //   184: aload 7
    //   186: aload_1
    //   187: invokestatic 264	com/tencent/qmsp/sdk/d/e:a	([B[BLjava/security/PublicKey;)Z
    //   190: istore 4
    //   192: aload_0
    //   193: astore_1
    //   194: iload 4
    //   196: ifeq +68 -> 264
    //   199: aload_0
    //   200: invokevirtual 260	java/io/DataInputStream:close	()V
    //   203: aload 6
    //   205: areturn
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   211: aload 6
    //   213: areturn
    //   214: aload_0
    //   215: invokevirtual 260	java/io/DataInputStream:close	()V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   225: aconst_null
    //   226: areturn
    //   227: aload_0
    //   228: invokevirtual 260	java/io/DataInputStream:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_1
    //   241: goto +10 -> 251
    //   244: astore_0
    //   245: goto +33 -> 278
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_0
    //   252: astore 5
    //   254: aload_1
    //   255: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   258: aload_0
    //   259: ifnull +16 -> 275
    //   262: aload_0
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 260	java/io/DataInputStream:close	()V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   275: aconst_null
    //   276: areturn
    //   277: astore_0
    //   278: aload 5
    //   280: ifnull +16 -> 296
    //   283: aload 5
    //   285: invokevirtual 260	java/io/DataInputStream:close	()V
    //   288: goto +8 -> 296
    //   291: astore_1
    //   292: aload_1
    //   293: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   296: aload_0
    //   297: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramFile	java.io.File
    //   0	298	1	paramString	String
    //   39	116	2	i	int
    //   63	92	3	j	int
    //   4	191	4	bool	boolean
    //   7	277	5	localFile	java.io.File
    //   157	55	6	arrayOfByte1	byte[]
    //   147	38	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   71	75	77	java/io/IOException
    //   128	132	134	java/io/IOException
    //   199	203	206	java/io/IOException
    //   214	218	220	java/io/IOException
    //   227	231	233	java/io/IOException
    //   35	40	240	java/io/IOException
    //   59	64	240	java/io/IOException
    //   87	92	240	java/io/IOException
    //   119	124	240	java/io/IOException
    //   144	149	240	java/io/IOException
    //   152	159	240	java/io/IOException
    //   162	169	240	java/io/IOException
    //   172	179	240	java/io/IOException
    //   182	192	240	java/io/IOException
    //   16	32	244	finally
    //   16	32	248	java/io/IOException
    //   264	268	270	java/io/IOException
    //   35	40	277	finally
    //   59	64	277	finally
    //   87	92	277	finally
    //   119	124	277	finally
    //   144	149	277	finally
    //   152	159	277	finally
    //   162	169	277	finally
    //   172	179	277	finally
    //   182	192	277	finally
    //   254	258	277	finally
    //   283	288	291	java/io/IOException
  }
  
  /* Error */
  public static boolean b(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 244	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 9
    //   18: new 162	java/io/DataInputStream
    //   21: dup
    //   22: new 246	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 252	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore 5
    //   35: aload 9
    //   37: astore 7
    //   39: aload 5
    //   41: astore 6
    //   43: aload 5
    //   45: invokevirtual 255	java/io/DataInputStream:available	()I
    //   48: istore_2
    //   49: iload_2
    //   50: sipush 140
    //   53: if_icmpgt +17 -> 70
    //   56: aload 5
    //   58: invokevirtual 260	java/io/DataInputStream:close	()V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: iload_2
    //   71: sipush 140
    //   74: isub
    //   75: istore_2
    //   76: aload 9
    //   78: astore 7
    //   80: aload 5
    //   82: astore 6
    //   84: aload 5
    //   86: iload_2
    //   87: invokevirtual 269	java/io/DataInputStream:skipBytes	(I)I
    //   90: pop
    //   91: aload 9
    //   93: astore 7
    //   95: aload 5
    //   97: astore 6
    //   99: aload 5
    //   101: invokestatic 271	com/tencent/qmsp/sdk/d/e:a	(Ljava/io/DataInputStream;)Lcom/tencent/qmsp/sdk/d/e$b;
    //   104: astore 10
    //   106: aload 10
    //   108: ifnonnull +17 -> 125
    //   111: aload 5
    //   113: invokevirtual 260	java/io/DataInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload 9
    //   127: astore 7
    //   129: aload 5
    //   131: astore 6
    //   133: aload 10
    //   135: getfield 169	com/tencent/qmsp/sdk/d/e$b:a	I
    //   138: istore_3
    //   139: iload_3
    //   140: ldc_w 257
    //   143: if_icmpeq +17 -> 160
    //   146: aload 5
    //   148: invokevirtual 260	java/io/DataInputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 9
    //   162: astore 7
    //   164: aload 5
    //   166: astore 6
    //   168: aload 10
    //   170: getfield 171	com/tencent/qmsp/sdk/d/e$b:b	I
    //   173: ifle +171 -> 344
    //   176: aload 9
    //   178: astore 7
    //   180: aload 5
    //   182: astore 6
    //   184: aload 10
    //   186: getfield 171	com/tencent/qmsp/sdk/d/e$b:b	I
    //   189: ldc_w 256
    //   192: if_icmple +6 -> 198
    //   195: goto +149 -> 344
    //   198: aload 9
    //   200: astore 7
    //   202: aload 5
    //   204: astore 6
    //   206: aload 10
    //   208: getfield 171	com/tencent/qmsp/sdk/d/e$b:b	I
    //   211: istore_3
    //   212: iload_2
    //   213: iload_3
    //   214: if_icmpeq +17 -> 231
    //   217: aload 5
    //   219: invokevirtual 260	java/io/DataInputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: aload 9
    //   233: astore 7
    //   235: aload 5
    //   237: astore 6
    //   239: aload_1
    //   240: invokestatic 262	com/tencent/qmsp/sdk/d/e:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   243: astore_1
    //   244: aload_1
    //   245: ifnonnull +17 -> 262
    //   248: aload 5
    //   250: invokevirtual 260	java/io/DataInputStream:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_0
    //   256: aload_0
    //   257: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: aload 9
    //   264: astore 7
    //   266: aload 5
    //   268: astore 6
    //   270: new 162	java/io/DataInputStream
    //   273: dup
    //   274: new 246	java/io/FileInputStream
    //   277: dup
    //   278: aload_0
    //   279: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   282: invokespecial 252	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   285: astore_0
    //   286: aload_0
    //   287: aload 10
    //   289: getfield 171	com/tencent/qmsp/sdk/d/e$b:b	I
    //   292: aload 10
    //   294: getfield 176	com/tencent/qmsp/sdk/d/e$b:d	[B
    //   297: aload_1
    //   298: invokestatic 273	com/tencent/qmsp/sdk/d/e:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   301: istore 4
    //   303: aload 5
    //   305: invokevirtual 260	java/io/DataInputStream:close	()V
    //   308: goto +8 -> 316
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   316: aload_0
    //   317: invokevirtual 260	java/io/DataInputStream:close	()V
    //   320: iload 4
    //   322: ireturn
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   328: iload 4
    //   330: ireturn
    //   331: astore_1
    //   332: aload_0
    //   333: astore 7
    //   335: aload_1
    //   336: astore_0
    //   337: goto +96 -> 433
    //   340: astore_1
    //   341: goto +46 -> 387
    //   344: aload 5
    //   346: invokevirtual 260	java/io/DataInputStream:close	()V
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_0
    //   352: aload_0
    //   353: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aload 6
    //   361: astore 5
    //   363: goto +70 -> 433
    //   366: astore_1
    //   367: aload 8
    //   369: astore_0
    //   370: goto +17 -> 387
    //   373: astore_0
    //   374: aconst_null
    //   375: astore 5
    //   377: goto +56 -> 433
    //   380: astore_1
    //   381: aconst_null
    //   382: astore 5
    //   384: aload 8
    //   386: astore_0
    //   387: aload_0
    //   388: astore 7
    //   390: aload 5
    //   392: astore 6
    //   394: aload_1
    //   395: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   398: aload 5
    //   400: ifnull +16 -> 416
    //   403: aload 5
    //   405: invokevirtual 260	java/io/DataInputStream:close	()V
    //   408: goto +8 -> 416
    //   411: astore_1
    //   412: aload_1
    //   413: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   416: aload_0
    //   417: ifnull +14 -> 431
    //   420: aload_0
    //   421: invokevirtual 260	java/io/DataInputStream:close	()V
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_0
    //   427: aload_0
    //   428: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   431: iconst_0
    //   432: ireturn
    //   433: aload 5
    //   435: ifnull +16 -> 451
    //   438: aload 5
    //   440: invokevirtual 260	java/io/DataInputStream:close	()V
    //   443: goto +8 -> 451
    //   446: astore_1
    //   447: aload_1
    //   448: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   451: aload 7
    //   453: ifnull +16 -> 469
    //   456: aload 7
    //   458: invokevirtual 260	java/io/DataInputStream:close	()V
    //   461: goto +8 -> 469
    //   464: astore_1
    //   465: aload_1
    //   466: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   469: aload_0
    //   470: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	paramFile	java.io.File
    //   0	471	1	paramString	String
    //   48	167	2	i	int
    //   138	77	3	j	int
    //   301	28	4	bool	boolean
    //   33	406	5	localObject1	Object
    //   41	352	6	localObject2	Object
    //   13	444	7	localObject3	Object
    //   10	375	8	localObject4	Object
    //   16	247	9	localObject5	Object
    //   104	189	10	localb	e.b
    // Exception table:
    //   from	to	target	type
    //   56	61	63	java/io/IOException
    //   111	116	118	java/io/IOException
    //   146	151	153	java/io/IOException
    //   217	222	224	java/io/IOException
    //   248	253	255	java/io/IOException
    //   303	308	311	java/io/IOException
    //   316	320	323	java/io/IOException
    //   286	303	331	finally
    //   286	303	340	java/io/IOException
    //   344	349	351	java/io/IOException
    //   43	49	358	finally
    //   84	91	358	finally
    //   99	106	358	finally
    //   133	139	358	finally
    //   168	176	358	finally
    //   184	195	358	finally
    //   206	212	358	finally
    //   239	244	358	finally
    //   270	286	358	finally
    //   394	398	358	finally
    //   43	49	366	java/io/IOException
    //   84	91	366	java/io/IOException
    //   99	106	366	java/io/IOException
    //   133	139	366	java/io/IOException
    //   168	176	366	java/io/IOException
    //   184	195	366	java/io/IOException
    //   206	212	366	java/io/IOException
    //   239	244	366	java/io/IOException
    //   270	286	366	java/io/IOException
    //   18	35	373	finally
    //   18	35	380	java/io/IOException
    //   403	408	411	java/io/IOException
    //   420	424	426	java/io/IOException
    //   438	443	446	java/io/IOException
    //   456	461	464	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.e
 * JD-Core Version:    0.7.0.1
 */