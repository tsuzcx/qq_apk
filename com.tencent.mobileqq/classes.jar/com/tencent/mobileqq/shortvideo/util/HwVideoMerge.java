package com.tencent.mobileqq.shortvideo.util;

import ahpn;
import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HwVideoMerge
{
  private int jdField_a_of_type_Int;
  private ahpn jdField_a_of_type_Ahpn = new ahpn(null);
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  private String jdField_b_of_type_JavaLangString;
  
  public HwVideoMerge(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    this.jdField_a_of_type_Ahpn.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Ahpn.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      a();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Ahpn.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Ahpn.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    a();
    return -6;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 68	com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 5
    //   8: new 70	java/io/File
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 77	java/io/File:exists	()Z
    //   24: ifeq +311 -> 335
    //   27: aload 4
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 81	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 83	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   42: ldc 86
    //   44: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_0
    //   59: iload_2
    //   60: invokestatic 103	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;I)I
    //   63: pop
    //   64: new 105	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 106	java/util/ArrayList:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: aload 5
    //   77: invokeinterface 112 2 0
    //   82: pop
    //   83: aload 4
    //   85: ldc 114
    //   87: invokeinterface 112 2 0
    //   92: pop
    //   93: aload 4
    //   95: ldc 116
    //   97: invokeinterface 112 2 0
    //   102: pop
    //   103: aload 4
    //   105: ldc 118
    //   107: invokeinterface 112 2 0
    //   112: pop
    //   113: aload 4
    //   115: ldc 120
    //   117: invokeinterface 112 2 0
    //   122: pop
    //   123: aload 4
    //   125: ldc 122
    //   127: invokeinterface 112 2 0
    //   132: pop
    //   133: aload 4
    //   135: aload_0
    //   136: invokeinterface 112 2 0
    //   141: pop
    //   142: aload 4
    //   144: ldc 124
    //   146: invokeinterface 112 2 0
    //   151: pop
    //   152: aload 4
    //   154: ldc 126
    //   156: invokeinterface 112 2 0
    //   161: pop
    //   162: aload 4
    //   164: ldc 128
    //   166: invokeinterface 112 2 0
    //   171: pop
    //   172: aload 4
    //   174: ldc 130
    //   176: invokeinterface 112 2 0
    //   181: pop
    //   182: aload 4
    //   184: aload_1
    //   185: invokeinterface 112 2 0
    //   190: pop
    //   191: aload 4
    //   193: invokestatic 63	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   196: invokestatic 132	com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   199: invokeinterface 112 2 0
    //   204: pop
    //   205: new 134	ahpm
    //   208: dup
    //   209: aconst_null
    //   210: invokespecial 135	ahpm:<init>	(Lahpl;)V
    //   213: astore_0
    //   214: new 137	java/lang/ProcessBuilder
    //   217: dup
    //   218: iconst_0
    //   219: anewarray 139	java/lang/String
    //   222: invokespecial 142	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   225: astore 5
    //   227: aload 5
    //   229: iconst_1
    //   230: invokevirtual 146	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   233: pop
    //   234: aload 5
    //   236: aload 4
    //   238: invokevirtual 150	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   241: pop
    //   242: aload 5
    //   244: invokevirtual 154	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   247: astore 4
    //   249: aload_0
    //   250: aload 4
    //   252: putfield 157	ahpm:a	Ljava/lang/Process;
    //   255: aload_0
    //   256: invokevirtual 158	ahpm:a	()V
    //   259: aload 4
    //   261: invokevirtual 163	java/lang/Process:waitFor	()I
    //   264: pop
    //   265: aload 4
    //   267: invokevirtual 166	java/lang/Process:exitValue	()I
    //   270: istore_2
    //   271: iload_2
    //   272: ifeq +47 -> 319
    //   275: new 70	java/io/File
    //   278: dup
    //   279: aload_1
    //   280: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 77	java/io/File:exists	()Z
    //   288: ifeq +8 -> 296
    //   291: aload_1
    //   292: invokevirtual 169	java/io/File:delete	()Z
    //   295: pop
    //   296: new 83	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   303: ldc 171
    //   305: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_2
    //   309: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aconst_null
    //   316: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_0
    //   320: invokevirtual 176	ahpm:b	()V
    //   323: aload 4
    //   325: ifnull +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 179	java/lang/Process:destroy	()V
    //   333: iload_2
    //   334: ireturn
    //   335: bipush 244
    //   337: ireturn
    //   338: astore_0
    //   339: ldc 181
    //   341: aload_0
    //   342: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   345: bipush 245
    //   347: ireturn
    //   348: astore 5
    //   350: ldc 181
    //   352: aload 5
    //   354: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: goto -92 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramString1	String
    //   0	360	1	paramString2	String
    //   0	360	2	paramInt	int
    //   34	14	3	bool	boolean
    //   17	312	4	localObject1	Object
    //   6	237	5	localObject2	Object
    //   348	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   242	249	338	java/io/IOException
    //   259	265	348	java/lang/InterruptedException
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
  }
  
  private final MediaExtractor a(String paramString)
  {
    if (a(paramString)) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int i = localMediaExtractor.getTrackCount();
      if (i != 1) {
        localMediaExtractor.release();
      }
      return localMediaExtractor;
    }
    catch (IOException localIOException1)
    {
      try
      {
        b("createExtractor:invalid media file:numTracks=" + i + " path=" + paramString, null);
        return null;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localMediaExtractor = null;
        }
      }
      localIOException1 = localIOException1;
      b("createExtractor path:" + paramString, localIOException1);
      localMediaExtractor.release();
      return null;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private static int b(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  public static final int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new HwVideoMerge(paramString1, paramString2).a(null, paramInt);
    int i;
    if ((j == -2) || (j == -4) || (j == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        i = 0;
      }
    }
    do
    {
      return i;
      return -10;
      i = j;
    } while (j != -9);
    return c(paramString1, paramString2, paramString3, paramInt);
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  /* Error */
  private static int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   3: invokestatic 68	com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 70	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 77	java/io/File:exists	()Z
    //   24: ifeq +404 -> 428
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 81	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 83	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   43: ldc 86
    //   45: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 261
    //   56: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 5
    //   61: invokevirtual 265	java/io/File:length	()J
    //   64: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aconst_null
    //   71: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: iload_3
    //   76: invokestatic 103	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;I)I
    //   79: pop
    //   80: new 105	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 106	java/util/ArrayList:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: aload 6
    //   93: invokeinterface 112 2 0
    //   98: pop
    //   99: aload 5
    //   101: ldc 114
    //   103: invokeinterface 112 2 0
    //   108: pop
    //   109: aload 5
    //   111: ldc 116
    //   113: invokeinterface 112 2 0
    //   118: pop
    //   119: aload 5
    //   121: ldc 118
    //   123: invokeinterface 112 2 0
    //   128: pop
    //   129: aload 5
    //   131: ldc 120
    //   133: invokeinterface 112 2 0
    //   138: pop
    //   139: aload 5
    //   141: ldc 122
    //   143: invokeinterface 112 2 0
    //   148: pop
    //   149: aload 5
    //   151: aload_0
    //   152: invokeinterface 112 2 0
    //   157: pop
    //   158: aload 5
    //   160: ldc 122
    //   162: invokeinterface 112 2 0
    //   167: pop
    //   168: aload 5
    //   170: aload_1
    //   171: invokeinterface 112 2 0
    //   176: pop
    //   177: aload 5
    //   179: ldc_w 270
    //   182: invokeinterface 112 2 0
    //   187: pop
    //   188: aload 5
    //   190: ldc_w 272
    //   193: invokeinterface 112 2 0
    //   198: pop
    //   199: aload 5
    //   201: ldc_w 274
    //   204: invokeinterface 112 2 0
    //   209: pop
    //   210: aload 5
    //   212: ldc_w 272
    //   215: invokeinterface 112 2 0
    //   220: pop
    //   221: aload 5
    //   223: aload_2
    //   224: invokeinterface 112 2 0
    //   229: pop
    //   230: aload 5
    //   232: invokestatic 63	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Landroid/content/Context;
    //   235: invokestatic 132	com/tencent/mobileqq/shortvideo/util/FileFFmpegUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   238: invokeinterface 112 2 0
    //   243: pop
    //   244: new 83	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 276
    //   254: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aconst_null
    //   266: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: new 134	ahpm
    //   272: dup
    //   273: aconst_null
    //   274: invokespecial 135	ahpm:<init>	(Lahpl;)V
    //   277: astore_0
    //   278: new 137	java/lang/ProcessBuilder
    //   281: dup
    //   282: iconst_0
    //   283: anewarray 139	java/lang/String
    //   286: invokespecial 142	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: iconst_1
    //   292: invokevirtual 146	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload 5
    //   299: invokevirtual 150	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   302: pop
    //   303: aload_1
    //   304: invokevirtual 154	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   307: astore_1
    //   308: aload_0
    //   309: aload_1
    //   310: putfield 157	ahpm:a	Ljava/lang/Process;
    //   313: aload_0
    //   314: invokevirtual 158	ahpm:a	()V
    //   317: aload_1
    //   318: invokevirtual 163	java/lang/Process:waitFor	()I
    //   321: pop
    //   322: aload_1
    //   323: invokevirtual 166	java/lang/Process:exitValue	()I
    //   326: istore_3
    //   327: iload_3
    //   328: ifeq +50 -> 378
    //   331: new 70	java/io/File
    //   334: dup
    //   335: aload_2
    //   336: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: astore 5
    //   341: aload 5
    //   343: invokevirtual 77	java/io/File:exists	()Z
    //   346: ifeq +9 -> 355
    //   349: aload 5
    //   351: invokevirtual 169	java/io/File:delete	()Z
    //   354: pop
    //   355: new 83	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   362: ldc 171
    //   364: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload_3
    //   368: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aconst_null
    //   375: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   378: new 70	java/io/File
    //   381: dup
    //   382: aload_2
    //   383: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: astore_2
    //   387: new 83	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 281
    //   397: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 77	java/io/File:exists	()Z
    //   404: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: aconst_null
    //   411: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   414: aload_0
    //   415: invokevirtual 176	ahpm:b	()V
    //   418: aload_1
    //   419: ifnull +7 -> 426
    //   422: aload_1
    //   423: invokevirtual 179	java/lang/Process:destroy	()V
    //   426: iload_3
    //   427: ireturn
    //   428: bipush 244
    //   430: ireturn
    //   431: astore_0
    //   432: ldc 181
    //   434: aload_0
    //   435: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   438: bipush 245
    //   440: ireturn
    //   441: astore 5
    //   443: ldc 181
    //   445: aload 5
    //   447: invokestatic 100	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   450: goto -128 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramString1	String
    //   0	453	1	paramString2	String
    //   0	453	2	paramString3	String
    //   0	453	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	333	5	localObject	Object
    //   441	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	86	6	str	String
    // Exception table:
    //   from	to	target	type
    //   303	308	431	java/io/IOException
    //   317	322	441	java/lang/InterruptedException
  }
  
  public int a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = a(this.jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor == null) {
      i = -1;
    }
    MediaFormat localMediaFormat;
    Object localObject;
    int j;
    do
    {
      return i;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidMediaMediaExtractor == null)
      {
        a();
        return -2;
      }
      localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      localObject = localMediaFormat.getString("mime");
      this.jdField_a_of_type_Int = localMediaFormat.getInteger("width");
      this.jdField_b_of_type_Int = localMediaFormat.getInteger("height");
      if (!((String)localObject).startsWith("video/")) {
        break;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      localObject = this.jdField_b_of_type_AndroidMediaMediaExtractor.getTrackFormat(0);
      if (!((MediaFormat)localObject).getString("mime").startsWith("audio/")) {
        break label198;
      }
      this.jdField_b_of_type_AndroidMediaMediaExtractor.selectTrack(0);
      this.jdField_a_of_type_Ahpn.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      j = a();
      i = j;
    } while (j != 0);
    if (!a(paramString))
    {
      a();
      return -9;
      a();
      return -3;
      label198:
      a();
      return -4;
    }
    try
    {
      if (new File(paramString).exists())
      {
        a();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = b(this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_Ahpn.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Ahpn.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      a();
    }
    return -7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */