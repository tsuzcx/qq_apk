package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoCompressConfig
{
  public static VideoCompressConfig.CompressInfo a(VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.ManageConfig paramManageConfig, boolean paramBoolean)
  {
    VideoCompressConfig.CompressInfo localCompressInfo = new VideoCompressConfig.CompressInfo();
    int i;
    if (paramVideoInfo.f > 0) {
      i = paramVideoInfo.f;
    } else {
      i = 30;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCompressInfo, videoFps = ");
      localStringBuilder.append(i);
      QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      localCompressInfo.e = 1.0F;
      localCompressInfo.a = paramVideoInfo.b;
      localCompressInfo.b = paramVideoInfo.c;
      localCompressInfo.d = i;
      if ((paramVideoInfo.a > 0L) && (paramVideoInfo.a * 8L < paramManageConfig.e)) {
        localCompressInfo.c = paramVideoInfo.g;
      } else {
        localCompressInfo.c = ((int)(paramManageConfig.e / paramVideoInfo.e));
      }
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("getCompressInfo, isRaw, compressInfo.desBitRate = ");
        paramVideoInfo.append(localCompressInfo.c);
        QLog.d("VideoCompressConfig", 2, paramVideoInfo.toString());
        return localCompressInfo;
      }
    }
    else
    {
      if (paramVideoInfo.b <= paramVideoInfo.c) {
        i = paramVideoInfo.c;
      } else {
        i = paramVideoInfo.b;
      }
      if (i > paramManageConfig.a)
      {
        localCompressInfo.e = (paramManageConfig.a / i);
        localCompressInfo.a = ((int)(paramVideoInfo.b * localCompressInfo.e));
        localCompressInfo.b = ((int)(paramVideoInfo.c * localCompressInfo.e));
      }
      else
      {
        localCompressInfo.e = 1.0F;
        localCompressInfo.a = paramVideoInfo.b;
        localCompressInfo.b = paramVideoInfo.c;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo,  config.scaleRate = ");
        localStringBuilder.append(localCompressInfo.e);
        localStringBuilder.append(", compressInfo.desWidth = ");
        localStringBuilder.append(localCompressInfo.a);
        localStringBuilder.append(", compressInfo.desHeight = ");
        localStringBuilder.append(localCompressInfo.b);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      if ((paramVideoInfo.f > 0) && (paramVideoInfo.f < paramManageConfig.b)) {
        localCompressInfo.d = paramVideoInfo.f;
      } else {
        localCompressInfo.d = paramManageConfig.b;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo, compressInfo.desFPS = ");
        localStringBuilder.append(localCompressInfo.d);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      double d1 = localCompressInfo.a * localCompressInfo.b * localCompressInfo.d;
      double d2 = paramManageConfig.c;
      Double.isNaN(d1);
      d2 = d1 * d2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo, bpsExp = ");
        localStringBuilder.append(d2);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      d1 = d2;
      if (d2 > paramVideoInfo.g) {
        d1 = paramVideoInfo.g;
      }
      d2 = d1;
      if (d1 > paramManageConfig.g) {
        d2 = paramManageConfig.g;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo, bpsExp real = ");
        localStringBuilder.append(d2);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      d1 = paramVideoInfo.e;
      Double.isNaN(d1);
      if (d1 * d2 > paramManageConfig.e)
      {
        d1 = paramManageConfig.e;
        d2 = localCompressInfo.a * localCompressInfo.b * localCompressInfo.d * paramVideoInfo.e;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        if (QLog.isColorLevel())
        {
          paramVideoInfo = new StringBuilder();
          paramVideoInfo.append("getCompressInfo,densityExp = ");
          paramVideoInfo.append(d2);
          QLog.d("VideoCompressConfig", 2, paramVideoInfo.toString());
        }
        d1 = d2;
        if (d2 < paramManageConfig.d) {
          d1 = paramManageConfig.d;
        }
        d2 = localCompressInfo.a * localCompressInfo.b * localCompressInfo.d;
        Double.isNaN(d2);
        localCompressInfo.c = ((int)(d2 * d1));
      }
      else
      {
        localCompressInfo.c = ((int)d2);
      }
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("getCompressInfo,  compressInfo.desBitRate ");
        paramVideoInfo.append(localCompressInfo.c);
        QLog.d("VideoCompressConfig", 2, paramVideoInfo.toString());
      }
    }
    return localCompressInfo;
  }
  
  public static VideoCompressConfig.ManageConfig a(QQAppInterface paramQQAppInterface)
  {
    VideoCompressConfig.ManageConfig localManageConfig = new VideoCompressConfig.ManageConfig();
    if (paramQQAppInterface == null)
    {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
      return localManageConfig;
    }
    paramQQAppInterface = SharedPreUtils.aP(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getManageConfig, compressConfig = ");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 5)) {
        try
        {
          int i = Integer.valueOf(paramQQAppInterface[0]).intValue();
          if (i > 0) {
            localManageConfig.a = i;
          }
          i = Integer.valueOf(paramQQAppInterface[1]).intValue();
          if (i > 0) {
            localManageConfig.b = i;
          }
          double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
          if (d > 0.0D) {
            localManageConfig.c = d;
          }
          d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
          if (d > 0.0D) {
            localManageConfig.d = d;
          }
          if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
          {
            i = Integer.valueOf(paramQQAppInterface[5]).intValue();
            if (i > 0) {
              localManageConfig.e = (i * 1024 * 1024 * 8);
            }
          }
          long l;
          if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
          {
            l = Long.valueOf(paramQQAppInterface[7]).longValue();
            if (l > 0L) {
              localManageConfig.g = l;
            }
          }
          if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
          {
            l = Long.valueOf(paramQQAppInterface[8]).longValue();
            if (l > 0L) {
              localManageConfig.f = l;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressConfig", 2, "getCompressConfigNew -> get VideoCompressConfig Erro", paramQQAppInterface);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getManageConfig, maxLength = ");
      paramQQAppInterface.append(localManageConfig.a);
      paramQQAppInterface.append(", maxFPS = ");
      paramQQAppInterface.append(localManageConfig.b);
      paramQQAppInterface.append(", maxDensity = ");
      paramQQAppInterface.append(localManageConfig.c);
      paramQQAppInterface.append(", minDensity = ");
      paramQQAppInterface.append(localManageConfig.d);
      paramQQAppInterface.append(", maxSize = ");
      paramQQAppInterface.append(localManageConfig.e);
      paramQQAppInterface.append(", maxBitRate = ");
      paramQQAppInterface.append(localManageConfig.g);
      paramQQAppInterface.append(", minBitRate = ");
      paramQQAppInterface.append(localManageConfig.f);
      QLog.d("VideoCompressConfig", 2, paramQQAppInterface.toString());
    }
    return localManageConfig;
  }
  
  /* Error */
  public static VideoCompressConfig.VideoInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc 40
    //   9: iconst_1
    //   10: ldc 214
    //   12: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 216	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 7
    //   27: aload 7
    //   29: invokevirtual 222	java/io/File:exists	()Z
    //   32: ifne +13 -> 45
    //   35: ldc 40
    //   37: iconst_1
    //   38: ldc 224
    //   40: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aconst_null
    //   44: areturn
    //   45: new 16	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo
    //   48: dup
    //   49: invokespecial 225	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:<init>	()V
    //   52: astore 6
    //   54: aload 6
    //   56: aload 7
    //   58: invokevirtual 227	java/io/File:length	()J
    //   61: putfield 66	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:a	J
    //   64: getstatic 232	android/os/Build$VERSION:SDK_INT	I
    //   67: bipush 17
    //   69: if_icmplt +330 -> 399
    //   72: new 234	android/media/MediaMetadataRetriever
    //   75: dup
    //   76: invokespecial 235	android/media/MediaMetadataRetriever:<init>	()V
    //   79: astore 7
    //   81: aload 7
    //   83: aload_0
    //   84: invokevirtual 238	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   87: aload 7
    //   89: bipush 18
    //   91: invokevirtual 242	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   94: astore_0
    //   95: aload 7
    //   97: bipush 19
    //   99: invokevirtual 242	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 7
    //   106: bipush 24
    //   108: invokevirtual 242	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   111: astore 9
    //   113: aload 7
    //   115: bipush 9
    //   117: invokevirtual 242	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   120: astore 10
    //   122: aload 7
    //   124: bipush 32
    //   126: invokevirtual 242	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: astore 11
    //   131: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +102 -> 236
    //   137: new 28	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   144: astore 12
    //   146: aload 12
    //   148: ldc 244
    //   150: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 12
    //   156: aload_0
    //   157: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 12
    //   163: ldc 246
    //   165: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 12
    //   171: aload 8
    //   173: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 12
    //   179: ldc 248
    //   181: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 12
    //   187: aload 9
    //   189: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 12
    //   195: ldc 250
    //   197: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 12
    //   203: aload 10
    //   205: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 12
    //   211: ldc 252
    //   213: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 12
    //   219: aload 11
    //   221: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 40
    //   227: iconst_2
    //   228: aload 12
    //   230: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 6
    //   238: aload_0
    //   239: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   242: invokevirtual 166	java/lang/Integer:intValue	()I
    //   245: putfield 55	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:b	I
    //   248: aload 6
    //   250: aload 8
    //   252: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   255: invokevirtual 166	java/lang/Integer:intValue	()I
    //   258: putfield 60	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   261: aload 6
    //   263: aload 9
    //   265: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   268: invokevirtual 166	java/lang/Integer:intValue	()I
    //   271: putfield 254	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   274: aload 10
    //   276: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   279: invokevirtual 166	java/lang/Integer:intValue	()I
    //   282: istore 5
    //   284: iload 5
    //   286: i2d
    //   287: dstore_1
    //   288: dload_1
    //   289: invokestatic 106	java/lang/Double:isNaN	(D)Z
    //   292: pop
    //   293: dload_1
    //   294: ldc2_w 255
    //   297: ddiv
    //   298: ldc2_w 257
    //   301: dadd
    //   302: d2i
    //   303: istore 5
    //   305: aload 6
    //   307: iload 5
    //   309: putfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   312: aload 11
    //   314: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   317: invokevirtual 166	java/lang/Integer:intValue	()I
    //   320: istore 5
    //   322: iload 5
    //   324: i2d
    //   325: dstore_1
    //   326: dload_1
    //   327: invokestatic 106	java/lang/Double:isNaN	(D)Z
    //   330: pop
    //   331: aload 6
    //   333: getfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   336: istore 5
    //   338: iload 5
    //   340: i2d
    //   341: dstore_3
    //   342: dload_3
    //   343: invokestatic 106	java/lang/Double:isNaN	(D)Z
    //   346: pop
    //   347: dload_1
    //   348: dconst_1
    //   349: dmul
    //   350: dload_3
    //   351: ddiv
    //   352: ldc2_w 257
    //   355: dadd
    //   356: d2i
    //   357: istore 5
    //   359: aload 6
    //   361: iload 5
    //   363: putfield 20	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:f	I
    //   366: goto +18 -> 384
    //   369: astore_0
    //   370: goto +22 -> 392
    //   373: astore_0
    //   374: ldc 40
    //   376: iconst_1
    //   377: ldc_w 260
    //   380: aload_0
    //   381: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload 7
    //   386: invokevirtual 263	android/media/MediaMetadataRetriever:release	()V
    //   389: goto +160 -> 549
    //   392: aload 7
    //   394: invokevirtual 263	android/media/MediaMetadataRetriever:release	()V
    //   397: aload_0
    //   398: athrow
    //   399: aload_0
    //   400: invokestatic 269	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   403: astore_0
    //   404: aload_0
    //   405: ifnull +144 -> 549
    //   408: aload_0
    //   409: ldc_w 271
    //   412: invokevirtual 157	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   415: astore_0
    //   416: aload_0
    //   417: ifnull +132 -> 549
    //   420: aload_0
    //   421: arraylength
    //   422: ifle +127 -> 549
    //   425: aload_0
    //   426: arraylength
    //   427: newarray int
    //   429: astore 7
    //   431: iconst_0
    //   432: istore 5
    //   434: iload 5
    //   436: aload_0
    //   437: arraylength
    //   438: if_icmpge +27 -> 465
    //   441: aload 7
    //   443: iload 5
    //   445: aload_0
    //   446: iload 5
    //   448: aaload
    //   449: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   452: invokevirtual 166	java/lang/Integer:intValue	()I
    //   455: iastore
    //   456: iload 5
    //   458: iconst_1
    //   459: iadd
    //   460: istore 5
    //   462: goto -28 -> 434
    //   465: aload 6
    //   467: aload 7
    //   469: iconst_1
    //   470: iaload
    //   471: putfield 55	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:b	I
    //   474: aload 6
    //   476: aload 7
    //   478: iconst_2
    //   479: iaload
    //   480: putfield 60	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   483: aload 6
    //   485: aload 7
    //   487: iconst_3
    //   488: iaload
    //   489: invokestatic 274	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getVideoRotate	(I)Ljava/lang/String;
    //   492: invokestatic 163	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   495: invokevirtual 166	java/lang/Integer:intValue	()I
    //   498: putfield 254	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   501: aload 7
    //   503: iconst_4
    //   504: iaload
    //   505: istore 5
    //   507: iload 5
    //   509: i2d
    //   510: dstore_1
    //   511: dload_1
    //   512: invokestatic 106	java/lang/Double:isNaN	(D)Z
    //   515: pop
    //   516: dload_1
    //   517: ldc2_w 255
    //   520: ddiv
    //   521: ldc2_w 257
    //   524: dadd
    //   525: d2i
    //   526: istore 5
    //   528: aload 6
    //   530: iload 5
    //   532: putfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   535: goto +14 -> 549
    //   538: astore_0
    //   539: ldc 40
    //   541: iconst_1
    //   542: ldc_w 276
    //   545: aload_0
    //   546: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: aload 6
    //   551: getfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   554: ifle +24 -> 578
    //   557: aload 6
    //   559: aload 6
    //   561: getfield 66	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:a	J
    //   564: ldc2_w 67
    //   567: lmul
    //   568: aload 6
    //   570: getfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   573: i2l
    //   574: ldiv
    //   575: putfield 75	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:g	J
    //   578: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +144 -> 725
    //   584: new 28	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   591: astore_0
    //   592: aload_0
    //   593: ldc_w 278
    //   596: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_0
    //   601: aload 6
    //   603: getfield 66	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:a	J
    //   606: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload_0
    //   611: ldc_w 280
    //   614: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload_0
    //   619: aload 6
    //   621: getfield 55	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:b	I
    //   624: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_0
    //   629: ldc 246
    //   631: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_0
    //   636: aload 6
    //   638: getfield 60	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   641: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload_0
    //   646: ldc 248
    //   648: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_0
    //   653: aload 6
    //   655: getfield 254	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   658: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload_0
    //   663: ldc 250
    //   665: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_0
    //   670: aload 6
    //   672: getfield 79	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   675: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_0
    //   680: ldc_w 282
    //   683: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload_0
    //   688: aload 6
    //   690: getfield 20	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:f	I
    //   693: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload_0
    //   698: ldc_w 284
    //   701: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_0
    //   706: aload 6
    //   708: getfield 75	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:g	J
    //   711: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: ldc 40
    //   717: iconst_2
    //   718: aload_0
    //   719: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: aload 6
    //   727: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	paramString	String
    //   287	230	1	d1	double
    //   341	10	3	d2	double
    //   282	249	5	i	int
    //   52	674	6	localVideoInfo	VideoCompressConfig.VideoInfo
    //   25	477	7	localObject	Object
    //   102	149	8	str1	String
    //   111	153	9	str2	String
    //   120	155	10	str3	String
    //   129	184	11	str4	String
    //   144	85	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	236	369	finally
    //   236	284	369	finally
    //   305	322	369	finally
    //   331	338	369	finally
    //   359	366	369	finally
    //   374	384	369	finally
    //   81	236	373	java/lang/Exception
    //   236	284	373	java/lang/Exception
    //   305	322	373	java/lang/Exception
    //   331	338	373	java/lang/Exception
    //   359	366	373	java/lang/Exception
    //   399	404	538	java/lang/Exception
    //   408	416	538	java/lang/Exception
    //   420	431	538	java/lang/Exception
    //   434	456	538	java/lang/Exception
    //   465	501	538	java/lang/Exception
    //   528	535	538	java/lang/Exception
  }
  
  public static boolean a(VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.ManageConfig paramManageConfig)
  {
    if ((paramVideoInfo != null) && (paramManageConfig != null))
    {
      if (paramVideoInfo.a * 8L > paramManageConfig.e)
      {
        if (QLog.isColorLevel())
        {
          paramManageConfig = new StringBuilder();
          paramManageConfig.append("isNeedCompress, true, fileSize > maxSize, fileSize = ");
          paramManageConfig.append(paramVideoInfo.a);
          QLog.d("VideoCompressConfig", 2, paramManageConfig.toString());
        }
        return true;
      }
      StringBuilder localStringBuilder;
      if (paramVideoInfo.g < paramManageConfig.f)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress,false, bitRate < minBitRate, bitRate = ");
          localStringBuilder.append(paramVideoInfo.g);
          localStringBuilder.append(", minBitRate = ");
          localStringBuilder.append(paramManageConfig.f);
          QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
        }
        return false;
      }
      if (paramVideoInfo.g > paramManageConfig.g)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress, true, bitRate > maxBitRate, bitRate = ");
          localStringBuilder.append(paramVideoInfo.g);
          localStringBuilder.append(", maxBitRate = ");
          localStringBuilder.append(paramManageConfig.g);
          QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
        }
        return true;
      }
      int i;
      if (paramVideoInfo.f > 0) {
        i = paramVideoInfo.f;
      } else {
        i = 30;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedCompress, videoFps = ");
        localStringBuilder.append(i);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      double d1 = paramVideoInfo.g;
      double d2 = paramVideoInfo.b * paramVideoInfo.c * i;
      double d3 = paramManageConfig.c;
      Double.isNaN(d2);
      if (d1 > d2 * d3 * 1.2D)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress, true, density > 1.2 * maxDensty. bitRate = ");
          localStringBuilder.append(paramVideoInfo.g);
          localStringBuilder.append(", width * height * videoFps * maxDensity * 1.2 = ");
          d1 = paramVideoInfo.b * paramVideoInfo.c * i;
          d2 = paramManageConfig.c;
          Double.isNaN(d1);
          localStringBuilder.append(d1 * d2 * 1.2D);
          QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = ");
        localStringBuilder.append(paramVideoInfo.g);
        localStringBuilder.append(", width * height * videoFps * maxDensity * 1.2 = ");
        d1 = paramVideoInfo.b * paramVideoInfo.c * i;
        d2 = paramManageConfig.c;
        Double.isNaN(d1);
        localStringBuilder.append(d1 * d2 * 1.2D);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      return false;
    }
    QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */