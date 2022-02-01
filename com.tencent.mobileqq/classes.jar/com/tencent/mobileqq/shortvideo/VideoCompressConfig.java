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
    if (paramVideoInfo.e > 0) {
      i = paramVideoInfo.e;
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
      localCompressInfo.jdField_a_of_type_Float = 1.0F;
      localCompressInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
      localCompressInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
      localCompressInfo.jdField_b_of_type_Long = i;
      if ((paramVideoInfo.jdField_a_of_type_Long > 0L) && (paramVideoInfo.jdField_a_of_type_Long * 8L < paramManageConfig.jdField_a_of_type_Long)) {
        localCompressInfo.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
      } else {
        localCompressInfo.jdField_a_of_type_Long = ((int)(paramManageConfig.jdField_a_of_type_Long / paramVideoInfo.d));
      }
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("getCompressInfo, isRaw, compressInfo.desBitRate = ");
        paramVideoInfo.append(localCompressInfo.jdField_a_of_type_Long);
        QLog.d("VideoCompressConfig", 2, paramVideoInfo.toString());
        return localCompressInfo;
      }
    }
    else
    {
      if (paramVideoInfo.jdField_a_of_type_Int <= paramVideoInfo.jdField_b_of_type_Int) {
        i = paramVideoInfo.jdField_b_of_type_Int;
      } else {
        i = paramVideoInfo.jdField_a_of_type_Int;
      }
      if (i > paramManageConfig.jdField_a_of_type_Int)
      {
        localCompressInfo.jdField_a_of_type_Float = (paramManageConfig.jdField_a_of_type_Int / i);
        localCompressInfo.jdField_a_of_type_Int = ((int)(paramVideoInfo.jdField_a_of_type_Int * localCompressInfo.jdField_a_of_type_Float));
        localCompressInfo.jdField_b_of_type_Int = ((int)(paramVideoInfo.jdField_b_of_type_Int * localCompressInfo.jdField_a_of_type_Float));
      }
      else
      {
        localCompressInfo.jdField_a_of_type_Float = 1.0F;
        localCompressInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
        localCompressInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo,  config.scaleRate = ");
        localStringBuilder.append(localCompressInfo.jdField_a_of_type_Float);
        localStringBuilder.append(", compressInfo.desWidth = ");
        localStringBuilder.append(localCompressInfo.jdField_a_of_type_Int);
        localStringBuilder.append(", compressInfo.desHeight = ");
        localStringBuilder.append(localCompressInfo.jdField_b_of_type_Int);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      if ((paramVideoInfo.e > 0) && (paramVideoInfo.e < paramManageConfig.jdField_b_of_type_Int)) {
        localCompressInfo.jdField_b_of_type_Long = paramVideoInfo.e;
      } else {
        localCompressInfo.jdField_b_of_type_Long = paramManageConfig.jdField_b_of_type_Int;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo, compressInfo.desFPS = ");
        localStringBuilder.append(localCompressInfo.jdField_b_of_type_Long);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      double d1 = localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long;
      double d2 = paramManageConfig.jdField_a_of_type_Double;
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
      if (d2 > paramVideoInfo.jdField_b_of_type_Long) {
        d1 = paramVideoInfo.jdField_b_of_type_Long;
      }
      d2 = d1;
      if (d1 > paramManageConfig.c) {
        d2 = paramManageConfig.c;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCompressInfo, bpsExp real = ");
        localStringBuilder.append(d2);
        QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
      }
      d1 = paramVideoInfo.d;
      Double.isNaN(d1);
      if (d1 * d2 > paramManageConfig.jdField_a_of_type_Long)
      {
        d1 = paramManageConfig.jdField_a_of_type_Long;
        d2 = localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long * paramVideoInfo.d;
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
        if (d2 < paramManageConfig.jdField_b_of_type_Double) {
          d1 = paramManageConfig.jdField_b_of_type_Double;
        }
        d2 = localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long;
        Double.isNaN(d2);
        localCompressInfo.jdField_a_of_type_Long = ((int)(d2 * d1));
      }
      else
      {
        localCompressInfo.jdField_a_of_type_Long = ((int)d2);
      }
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("getCompressInfo,  compressInfo.desBitRate ");
        paramVideoInfo.append(localCompressInfo.jdField_a_of_type_Long);
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
    paramQQAppInterface = SharedPreUtils.l(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
            localManageConfig.jdField_a_of_type_Int = i;
          }
          i = Integer.valueOf(paramQQAppInterface[1]).intValue();
          if (i > 0) {
            localManageConfig.jdField_b_of_type_Int = i;
          }
          double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
          if (d > 0.0D) {
            localManageConfig.jdField_a_of_type_Double = d;
          }
          d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
          if (d > 0.0D) {
            localManageConfig.jdField_b_of_type_Double = d;
          }
          if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
          {
            i = Integer.valueOf(paramQQAppInterface[5]).intValue();
            if (i > 0) {
              localManageConfig.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
            }
          }
          long l;
          if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
          {
            l = Long.valueOf(paramQQAppInterface[7]).longValue();
            if (l > 0L) {
              localManageConfig.c = l;
            }
          }
          if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
          {
            l = Long.valueOf(paramQQAppInterface[8]).longValue();
            if (l > 0L) {
              localManageConfig.jdField_b_of_type_Long = l;
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
      paramQQAppInterface.append(localManageConfig.jdField_a_of_type_Int);
      paramQQAppInterface.append(", maxFPS = ");
      paramQQAppInterface.append(localManageConfig.jdField_b_of_type_Int);
      paramQQAppInterface.append(", maxDensity = ");
      paramQQAppInterface.append(localManageConfig.jdField_a_of_type_Double);
      paramQQAppInterface.append(", minDensity = ");
      paramQQAppInterface.append(localManageConfig.jdField_b_of_type_Double);
      paramQQAppInterface.append(", maxSize = ");
      paramQQAppInterface.append(localManageConfig.jdField_a_of_type_Long);
      paramQQAppInterface.append(", maxBitRate = ");
      paramQQAppInterface.append(localManageConfig.c);
      paramQQAppInterface.append(", minBitRate = ");
      paramQQAppInterface.append(localManageConfig.jdField_b_of_type_Long);
      QLog.d("VideoCompressConfig", 2, paramQQAppInterface.toString());
    }
    return localManageConfig;
  }
  
  /* Error */
  public static VideoCompressConfig.VideoInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc 40
    //   9: iconst_1
    //   10: ldc 208
    //   12: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 210	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 7
    //   27: aload 7
    //   29: invokevirtual 216	java/io/File:exists	()Z
    //   32: ifne +13 -> 45
    //   35: ldc 40
    //   37: iconst_1
    //   38: ldc 218
    //   40: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aconst_null
    //   44: areturn
    //   45: new 16	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo
    //   48: dup
    //   49: invokespecial 219	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:<init>	()V
    //   52: astore 6
    //   54: aload 6
    //   56: aload 7
    //   58: invokevirtual 221	java/io/File:length	()J
    //   61: putfield 63	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Long	J
    //   64: getstatic 226	android/os/Build$VERSION:SDK_INT	I
    //   67: bipush 17
    //   69: if_icmplt +329 -> 398
    //   72: new 228	android/media/MediaMetadataRetriever
    //   75: dup
    //   76: invokespecial 229	android/media/MediaMetadataRetriever:<init>	()V
    //   79: astore 7
    //   81: aload 7
    //   83: aload_0
    //   84: invokevirtual 232	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   87: aload 7
    //   89: bipush 18
    //   91: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   94: astore_0
    //   95: aload 7
    //   97: bipush 19
    //   99: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 7
    //   106: bipush 24
    //   108: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   111: astore 9
    //   113: aload 7
    //   115: bipush 9
    //   117: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   120: astore 10
    //   122: aload 7
    //   124: bipush 32
    //   126: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: astore 11
    //   131: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +102 -> 236
    //   137: new 28	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   144: astore 12
    //   146: aload 12
    //   148: ldc 238
    //   150: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 12
    //   156: aload_0
    //   157: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 12
    //   163: ldc 240
    //   165: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 12
    //   171: aload 8
    //   173: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 12
    //   179: ldc 242
    //   181: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 12
    //   187: aload 9
    //   189: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 12
    //   195: ldc 244
    //   197: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 12
    //   203: aload 10
    //   205: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 12
    //   211: ldc 246
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
    //   239: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   242: invokevirtual 161	java/lang/Integer:intValue	()I
    //   245: putfield 53	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Int	I
    //   248: aload 6
    //   250: aload 8
    //   252: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   255: invokevirtual 161	java/lang/Integer:intValue	()I
    //   258: putfield 57	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_b_of_type_Int	I
    //   261: aload 6
    //   263: aload 9
    //   265: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   268: invokevirtual 161	java/lang/Integer:intValue	()I
    //   271: putfield 248	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   274: aload 10
    //   276: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   279: invokevirtual 161	java/lang/Integer:intValue	()I
    //   282: istore 5
    //   284: iload 5
    //   286: i2d
    //   287: dstore_1
    //   288: dload_1
    //   289: invokestatic 99	java/lang/Double:isNaN	(D)Z
    //   292: pop
    //   293: dload_1
    //   294: ldc2_w 249
    //   297: ddiv
    //   298: ldc2_w 251
    //   301: dadd
    //   302: d2i
    //   303: istore 5
    //   305: aload 6
    //   307: iload 5
    //   309: putfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   312: aload 11
    //   314: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   317: invokevirtual 161	java/lang/Integer:intValue	()I
    //   320: istore 5
    //   322: iload 5
    //   324: i2d
    //   325: dstore_1
    //   326: dload_1
    //   327: invokestatic 99	java/lang/Double:isNaN	(D)Z
    //   330: pop
    //   331: aload 6
    //   333: getfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   336: istore 5
    //   338: iload 5
    //   340: i2d
    //   341: dstore_3
    //   342: dload_3
    //   343: invokestatic 99	java/lang/Double:isNaN	(D)Z
    //   346: pop
    //   347: dload_1
    //   348: dconst_1
    //   349: dmul
    //   350: dload_3
    //   351: ddiv
    //   352: ldc2_w 251
    //   355: dadd
    //   356: d2i
    //   357: istore 5
    //   359: aload 6
    //   361: iload 5
    //   363: putfield 20	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   366: goto +17 -> 383
    //   369: astore_0
    //   370: goto +21 -> 391
    //   373: astore_0
    //   374: ldc 40
    //   376: iconst_1
    //   377: ldc 254
    //   379: aload_0
    //   380: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload 7
    //   385: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   388: goto +160 -> 548
    //   391: aload 7
    //   393: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   396: aload_0
    //   397: athrow
    //   398: aload_0
    //   399: invokestatic 263	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   402: astore_0
    //   403: aload_0
    //   404: ifnull +144 -> 548
    //   407: aload_0
    //   408: ldc_w 265
    //   411: invokevirtual 152	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   414: astore_0
    //   415: aload_0
    //   416: ifnull +132 -> 548
    //   419: aload_0
    //   420: arraylength
    //   421: ifle +127 -> 548
    //   424: aload_0
    //   425: arraylength
    //   426: newarray int
    //   428: astore 7
    //   430: iconst_0
    //   431: istore 5
    //   433: iload 5
    //   435: aload_0
    //   436: arraylength
    //   437: if_icmpge +27 -> 464
    //   440: aload 7
    //   442: iload 5
    //   444: aload_0
    //   445: iload 5
    //   447: aaload
    //   448: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   451: invokevirtual 161	java/lang/Integer:intValue	()I
    //   454: iastore
    //   455: iload 5
    //   457: iconst_1
    //   458: iadd
    //   459: istore 5
    //   461: goto -28 -> 433
    //   464: aload 6
    //   466: aload 7
    //   468: iconst_1
    //   469: iaload
    //   470: putfield 53	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Int	I
    //   473: aload 6
    //   475: aload 7
    //   477: iconst_2
    //   478: iaload
    //   479: putfield 57	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_b_of_type_Int	I
    //   482: aload 6
    //   484: aload 7
    //   486: iconst_3
    //   487: iaload
    //   488: invokestatic 268	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getVideoRotate	(I)Ljava/lang/String;
    //   491: invokestatic 158	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   494: invokevirtual 161	java/lang/Integer:intValue	()I
    //   497: putfield 248	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   500: aload 7
    //   502: iconst_4
    //   503: iaload
    //   504: istore 5
    //   506: iload 5
    //   508: i2d
    //   509: dstore_1
    //   510: dload_1
    //   511: invokestatic 99	java/lang/Double:isNaN	(D)Z
    //   514: pop
    //   515: dload_1
    //   516: ldc2_w 249
    //   519: ddiv
    //   520: ldc2_w 251
    //   523: dadd
    //   524: d2i
    //   525: istore 5
    //   527: aload 6
    //   529: iload 5
    //   531: putfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   534: goto +14 -> 548
    //   537: astore_0
    //   538: ldc 40
    //   540: iconst_1
    //   541: ldc_w 270
    //   544: aload_0
    //   545: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   548: aload 6
    //   550: getfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   553: ifle +24 -> 577
    //   556: aload 6
    //   558: aload 6
    //   560: getfield 63	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Long	J
    //   563: ldc2_w 64
    //   566: lmul
    //   567: aload 6
    //   569: getfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   572: i2l
    //   573: ldiv
    //   574: putfield 69	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_b_of_type_Long	J
    //   577: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +144 -> 724
    //   583: new 28	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   590: astore_0
    //   591: aload_0
    //   592: ldc_w 272
    //   595: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_0
    //   600: aload 6
    //   602: getfield 63	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Long	J
    //   605: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload_0
    //   610: ldc_w 274
    //   613: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload_0
    //   618: aload 6
    //   620: getfield 53	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_a_of_type_Int	I
    //   623: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload_0
    //   628: ldc 240
    //   630: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload_0
    //   635: aload 6
    //   637: getfield 57	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_b_of_type_Int	I
    //   640: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload_0
    //   645: ldc 242
    //   647: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_0
    //   652: aload 6
    //   654: getfield 248	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:c	I
    //   657: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_0
    //   662: ldc 244
    //   664: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload_0
    //   669: aload 6
    //   671: getfield 72	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:d	I
    //   674: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload_0
    //   679: ldc_w 276
    //   682: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_0
    //   687: aload 6
    //   689: getfield 20	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:e	I
    //   692: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload_0
    //   697: ldc_w 278
    //   700: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload_0
    //   705: aload 6
    //   707: getfield 69	com/tencent/mobileqq/shortvideo/VideoCompressConfig$VideoInfo:jdField_b_of_type_Long	J
    //   710: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: ldc 40
    //   716: iconst_2
    //   717: aload_0
    //   718: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: aload 6
    //   726: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	paramString	String
    //   287	229	1	d1	double
    //   341	10	3	d2	double
    //   282	248	5	i	int
    //   52	673	6	localVideoInfo	VideoCompressConfig.VideoInfo
    //   25	476	7	localObject	Object
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
    //   374	383	369	finally
    //   81	236	373	java/lang/Exception
    //   236	284	373	java/lang/Exception
    //   305	322	373	java/lang/Exception
    //   331	338	373	java/lang/Exception
    //   359	366	373	java/lang/Exception
    //   398	403	537	java/lang/Exception
    //   407	415	537	java/lang/Exception
    //   419	430	537	java/lang/Exception
    //   433	455	537	java/lang/Exception
    //   464	500	537	java/lang/Exception
    //   527	534	537	java/lang/Exception
  }
  
  public static boolean a(VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.ManageConfig paramManageConfig)
  {
    if ((paramVideoInfo != null) && (paramManageConfig != null))
    {
      if (paramVideoInfo.jdField_a_of_type_Long * 8L > paramManageConfig.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          paramManageConfig = new StringBuilder();
          paramManageConfig.append("isNeedCompress, true, fileSize > maxSize, fileSize = ");
          paramManageConfig.append(paramVideoInfo.jdField_a_of_type_Long);
          QLog.d("VideoCompressConfig", 2, paramManageConfig.toString());
        }
        return true;
      }
      StringBuilder localStringBuilder;
      if (paramVideoInfo.jdField_b_of_type_Long < paramManageConfig.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress,false, bitRate < minBitRate, bitRate = ");
          localStringBuilder.append(paramVideoInfo.jdField_b_of_type_Long);
          localStringBuilder.append(", minBitRate = ");
          localStringBuilder.append(paramManageConfig.jdField_b_of_type_Long);
          QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
        }
        return false;
      }
      if (paramVideoInfo.jdField_b_of_type_Long > paramManageConfig.c)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress, true, bitRate > maxBitRate, bitRate = ");
          localStringBuilder.append(paramVideoInfo.jdField_b_of_type_Long);
          localStringBuilder.append(", maxBitRate = ");
          localStringBuilder.append(paramManageConfig.c);
          QLog.d("VideoCompressConfig", 2, localStringBuilder.toString());
        }
        return true;
      }
      int i;
      if (paramVideoInfo.e > 0) {
        i = paramVideoInfo.e;
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
      double d1 = paramVideoInfo.jdField_b_of_type_Long;
      double d2 = paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int * i;
      double d3 = paramManageConfig.jdField_a_of_type_Double;
      Double.isNaN(d2);
      if (d1 > d2 * d3 * 1.2D)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedCompress, true, density > 1.2 * maxDensty. bitRate = ");
          localStringBuilder.append(paramVideoInfo.jdField_b_of_type_Long);
          localStringBuilder.append(", width * height * videoFps * maxDensity * 1.2 = ");
          d1 = paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int * i;
          d2 = paramManageConfig.jdField_a_of_type_Double;
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
        localStringBuilder.append(paramVideoInfo.jdField_b_of_type_Long);
        localStringBuilder.append(", width * height * videoFps * maxDensity * 1.2 = ");
        d1 = paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int * i;
        d2 = paramManageConfig.jdField_a_of_type_Double;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */