package com.tencent.qqmusic.mediaplayer.codec.wav;

public class WaveReader
{
  private static final String TAG = "WaveReader";
  private static final int WAV_FORMAT = 1463899717;
  private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
  private static final int WAV_HEADER_CHUNK_ID = 1380533830;
  private static final int WAV_HEADER_SIZE = 50;
  
  private static short byteToShortLE(byte paramByte1, byte paramByte2)
  {
    return (short)(paramByte1 & 0xFF | (paramByte2 & 0xFF) << 8);
  }
  
  /* Error */
  public static boolean isWavFormat(String paramString)
  {
    // Byte code:
    //   0: bipush 50
    //   2: newarray byte
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: new 30	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_3
    //   20: iconst_0
    //   21: invokestatic 37	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   24: istore_1
    //   25: iload_1
    //   26: ldc 15
    //   28: if_icmpeq +48 -> 76
    //   31: new 39	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 42
    //   42: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: iload_1
    //   48: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 8
    //   54: aload_2
    //   55: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 59	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokevirtual 64	java/io/InputStream:close	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_0
    //   68: ldc 8
    //   70: aload_0
    //   71: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_3
    //   77: bipush 8
    //   79: invokestatic 37	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   82: istore_1
    //   83: iload_1
    //   84: ldc 11
    //   86: if_icmpeq +48 -> 134
    //   89: new 39	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   96: astore_2
    //   97: aload_2
    //   98: ldc 70
    //   100: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: iload_1
    //   106: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 8
    //   112: aload_2
    //   113: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 59	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokevirtual 64	java/io/InputStream:close	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_0
    //   126: ldc 8
    //   128: aload_0
    //   129: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: bipush 12
    //   137: invokestatic 37	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   140: istore_1
    //   141: iload_1
    //   142: ldc 13
    //   144: if_icmpeq +48 -> 192
    //   147: new 39	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   154: astore_2
    //   155: aload_2
    //   156: ldc 72
    //   158: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_2
    //   163: iload_1
    //   164: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 8
    //   170: aload_2
    //   171: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 59	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: invokevirtual 64	java/io/InputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: ldc 8
    //   186: aload_0
    //   187: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: iconst_0
    //   191: ireturn
    //   192: aload_3
    //   193: bipush 16
    //   195: invokestatic 75	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedIntLE	([BI)I
    //   198: istore_1
    //   199: new 39	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: ldc 77
    //   210: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: iload_1
    //   216: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: ldc 8
    //   222: aload_2
    //   223: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 59	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_3
    //   230: bipush 20
    //   232: invokestatic 81	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedShortLE	([BI)S
    //   235: istore_1
    //   236: new 39	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   243: astore_2
    //   244: aload_2
    //   245: ldc 83
    //   247: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_2
    //   252: iload_1
    //   253: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 8
    //   259: aload_2
    //   260: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 59	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: invokevirtual 64	java/io/InputStream:close	()V
    //   270: iconst_1
    //   271: ireturn
    //   272: astore_0
    //   273: ldc 8
    //   275: aload_0
    //   276: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: iconst_1
    //   280: ireturn
    //   281: astore_2
    //   282: goto +46 -> 328
    //   285: astore_3
    //   286: goto +15 -> 301
    //   289: astore_3
    //   290: aload_2
    //   291: astore_0
    //   292: aload_3
    //   293: astore_2
    //   294: goto +34 -> 328
    //   297: astore_3
    //   298: aload 4
    //   300: astore_0
    //   301: aload_0
    //   302: astore_2
    //   303: ldc 8
    //   305: aload_3
    //   306: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   309: aload_0
    //   310: ifnull +16 -> 326
    //   313: aload_0
    //   314: invokevirtual 64	java/io/InputStream:close	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: ldc 8
    //   322: aload_0
    //   323: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload_0
    //   329: ifnull +17 -> 346
    //   332: aload_0
    //   333: invokevirtual 64	java/io/InputStream:close	()V
    //   336: goto +10 -> 346
    //   339: astore_0
    //   340: ldc 8
    //   342: aload_0
    //   343: invokestatic 68	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   346: aload_2
    //   347: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramString	String
    //   24	229	1	i	int
    //   9	251	2	localStringBuilder	java.lang.StringBuilder
    //   281	10	2	localObject1	Object
    //   293	54	2	localObject2	Object
    //   4	226	3	arrayOfByte	byte[]
    //   285	1	3	localException1	java.lang.Exception
    //   289	4	3	localObject3	Object
    //   297	9	3	localException2	java.lang.Exception
    //   6	293	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/Exception
    //   119	123	125	java/lang/Exception
    //   177	181	183	java/lang/Exception
    //   266	270	272	java/lang/Exception
    //   19	25	281	finally
    //   31	61	281	finally
    //   76	83	281	finally
    //   89	119	281	finally
    //   134	141	281	finally
    //   147	177	281	finally
    //   192	266	281	finally
    //   19	25	285	java/lang/Exception
    //   31	61	285	java/lang/Exception
    //   76	83	285	java/lang/Exception
    //   89	119	285	java/lang/Exception
    //   134	141	285	java/lang/Exception
    //   147	177	285	java/lang/Exception
    //   192	266	285	java/lang/Exception
    //   10	19	289	finally
    //   303	309	289	finally
    //   10	19	297	java/lang/Exception
    //   313	317	319	java/lang/Exception
    //   332	336	339	java/lang/Exception
  }
  
  private static int readUnsignedInt(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 4 > paramArrayOfByte.length) {
      return -1;
    }
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private static int readUnsignedIntLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 4 > paramArrayOfByte.length) {
      return -1;
    }
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  private static short readUnsignedShortLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 2 > paramArrayOfByte.length) {
      return -1;
    }
    return byteToShortLE(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WaveReader
 * JD-Core Version:    0.7.0.1
 */