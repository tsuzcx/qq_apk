package com.tencent.mobileqq.shortvideo.hwcodec;

public class SVHwThumbGen
{
  public String a = null;
  public String b = null;
  public int c = 0;
  public long d = 0L;
  
  /* Error */
  public int a(String paramString1, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: aload 8
    //   5: iconst_0
    //   6: getstatic 35	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 40	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Ljava/lang/String;IILjava/lang/String;ILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   12: astore 8
    //   14: aload 8
    //   16: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +20 -> 39
    //   22: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +11 -> 36
    //   28: ldc 54
    //   30: iconst_2
    //   31: ldc 56
    //   33: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: bipush 254
    //   38: ireturn
    //   39: new 62	java/io/File
    //   42: dup
    //   43: aload 8
    //   45: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 10
    //   50: aload 10
    //   52: invokevirtual 68	java/io/File:exists	()Z
    //   55: ifne +6 -> 61
    //   58: bipush 254
    //   60: ireturn
    //   61: aload 8
    //   63: dload 4
    //   65: dload 6
    //   67: invokestatic 73	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   70: pop
    //   71: aconst_null
    //   72: astore 9
    //   74: aconst_null
    //   75: astore_1
    //   76: new 75	java/io/FileInputStream
    //   79: dup
    //   80: aload 8
    //   82: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   85: astore 8
    //   87: aload_0
    //   88: aload 8
    //   90: aload 10
    //   92: invokevirtual 80	java/io/File:length	()J
    //   95: invokestatic 86	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   98: invokestatic 92	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   101: putfield 17	com/tencent/mobileqq/shortvideo/hwcodec/SVHwThumbGen:a	Ljava/lang/String;
    //   104: aload 8
    //   106: invokevirtual 95	java/io/FileInputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   117: aload_0
    //   118: getfield 17	com/tencent/mobileqq/shortvideo/hwcodec/SVHwThumbGen:a	Ljava/lang/String;
    //   121: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +99 -> 223
    //   127: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +11 -> 141
    //   133: ldc 54
    //   135: iconst_2
    //   136: ldc 100
    //   138: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: iconst_m1
    //   142: ireturn
    //   143: astore_1
    //   144: goto +81 -> 225
    //   147: astore 9
    //   149: goto +22 -> 171
    //   152: astore 9
    //   154: aload_1
    //   155: astore 8
    //   157: aload 9
    //   159: astore_1
    //   160: goto +65 -> 225
    //   163: astore_1
    //   164: aload 9
    //   166: astore 8
    //   168: aload_1
    //   169: astore 9
    //   171: aload 8
    //   173: astore_1
    //   174: aload 9
    //   176: invokevirtual 101	java/io/FileNotFoundException:printStackTrace	()V
    //   179: aload 8
    //   181: ifnull +16 -> 197
    //   184: aload 8
    //   186: invokevirtual 95	java/io/FileInputStream:close	()V
    //   189: goto +8 -> 197
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   197: aload_0
    //   198: getfield 17	com/tencent/mobileqq/shortvideo/hwcodec/SVHwThumbGen:a	Ljava/lang/String;
    //   201: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +19 -> 223
    //   207: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +11 -> 221
    //   213: ldc 54
    //   215: iconst_2
    //   216: ldc 100
    //   218: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iconst_m1
    //   222: ireturn
    //   223: iconst_0
    //   224: ireturn
    //   225: aload 8
    //   227: ifnull +18 -> 245
    //   230: aload 8
    //   232: invokevirtual 95	java/io/FileInputStream:close	()V
    //   235: goto +10 -> 245
    //   238: astore 8
    //   240: aload 8
    //   242: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   245: aload_0
    //   246: getfield 17	com/tencent/mobileqq/shortvideo/hwcodec/SVHwThumbGen:a	Ljava/lang/String;
    //   249: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +19 -> 271
    //   255: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +11 -> 269
    //   261: ldc 54
    //   263: iconst_2
    //   264: ldc 100
    //   266: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: iconst_m1
    //   270: ireturn
    //   271: aload_1
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	SVHwThumbGen
    //   0	273	1	paramString1	String
    //   0	273	2	paramInt1	int
    //   0	273	3	paramInt2	int
    //   0	273	4	paramDouble1	double
    //   0	273	6	paramDouble2	double
    //   0	273	8	paramString2	String
    //   72	1	9	localObject1	Object
    //   147	1	9	localFileNotFoundException	java.io.FileNotFoundException
    //   152	13	9	localObject2	Object
    //   169	6	9	str	String
    //   48	43	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   104	109	112	java/io/IOException
    //   87	104	143	finally
    //   87	104	147	java/io/FileNotFoundException
    //   76	87	152	finally
    //   174	179	152	finally
    //   76	87	163	java/io/FileNotFoundException
    //   184	189	192	java/io/IOException
    //   230	235	238	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwThumbGen
 * JD-Core Version:    0.7.0.1
 */