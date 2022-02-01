package com.tencent.weiyun.transmission.upload.processor;

import android.content.Context;
import android.media.ExifInterface;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class LocalProcessor
  implements Handler.Callback
{
  private static final int MSG_PROCESS = 11;
  private static final String TAG = "UploadLocalProcessor";
  private static final long TAKEN_TIME_DIFF_60S = 60000L;
  private static SimpleDateFormat sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  private final LocalProcessor.LocalProcessorCallback mCallback;
  private final Context mContext;
  private final ReleaseLooperHandler mHandler;
  
  public LocalProcessor(Context paramContext, LocalProcessor.LocalProcessorCallback paramLocalProcessorCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.mContext = paramContext;
    this.mCallback = paramLocalProcessorCallback;
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
  }
  
  private double convert2Degree(String paramString)
  {
    String[] arrayOfString2 = paramString.split(",", 3);
    paramString = arrayOfString2[0].split("/", 2);
    String[] arrayOfString1 = arrayOfString2[1].split("/", 2);
    arrayOfString2 = arrayOfString2[2].split("/", 2);
    return parseDoubleSafely(paramString[0]) / parseDoubleSafely(paramString[1]) + parseDoubleSafely(arrayOfString1[0]) / parseDoubleSafely(arrayOfString1[1]) / 60.0D + parseDoubleSafely(arrayOfString2[0]) / parseDoubleSafely(arrayOfString2[1]) / 3600.0D;
  }
  
  private double parseDoubleSafely(String paramString)
  {
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (Throwable paramString)
    {
      label7:
      break label7;
    }
    return 0.0D;
  }
  
  private String[] parseExif(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        Object localObject1 = localExifInterface.getAttribute("GPSLongitude");
        localObject3 = localExifInterface.getAttribute("GPSLatitude");
        String str = localExifInterface.getAttribute("GPSLongitudeRef");
        Object localObject4 = localExifInterface.getAttribute("GPSLatitudeRef");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label275;
        }
        d = convert2Degree((String)localObject1);
        if (TextUtils.equals(str, "E"))
        {
          localObject1 = Double.toString(d);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label288;
          }
          d = convert2Degree((String)localObject3);
          if (!TextUtils.equals((CharSequence)localObject4, "N")) {
            break label281;
          }
          localObject3 = Double.toString(d);
          localObject4 = new String[5];
          localObject4[0] = localObject1;
          localObject4[1] = localObject3;
          localObject4[2] = localExifInterface.getAttribute("DateTime");
          localObject4[3] = localExifInterface.getAttribute("ImageWidth");
          localObject4[4] = localExifInterface.getAttribute("ImageLength");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" parseExif success:");
          ((StringBuilder)localObject1).append(Arrays.toString((Object[])localObject4));
          TsLog.d("UploadLocalProcessor", ((StringBuilder)localObject1).toString());
          return localObject4;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" parseExif failed.");
        TsLog.e("UploadLocalProcessor", ((StringBuilder)localObject3).toString(), localThrowable);
        return null;
      }
      double d = 0.0D - d;
      continue;
      label275:
      Object localObject2 = null;
      continue;
      label281:
      d = 0.0D - d;
      continue;
      label288:
      Object localObject3 = null;
    }
  }
  
  private int parseIntSafely(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  private long parseLongSafely(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString)
    {
      label7:
      break label7;
    }
    return 0L;
  }
  
  /* Error */
  @android.annotation.TargetApi(14)
  private int[] parseVideoSizes(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 172	android/media/MediaMetadataRetriever
    //   12: dup
    //   13: invokespecial 173	android/media/MediaMetadataRetriever:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: aload_1
    //   21: invokevirtual 176	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload 4
    //   26: bipush 18
    //   28: invokevirtual 180	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   31: astore_1
    //   32: aload 4
    //   34: bipush 19
    //   36: invokevirtual 180	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   39: astore 5
    //   41: aload_1
    //   42: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +8 -> 53
    //   48: iconst_0
    //   49: istore_2
    //   50: goto +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   58: istore_2
    //   59: aload 5
    //   61: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +8 -> 72
    //   67: iconst_0
    //   68: istore_3
    //   69: goto +10 -> 79
    //   72: aload_0
    //   73: aload 5
    //   75: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   78: istore_3
    //   79: aload 4
    //   81: invokevirtual 185	android/media/MediaMetadataRetriever:release	()V
    //   84: iconst_2
    //   85: newarray int
    //   87: dup
    //   88: iconst_0
    //   89: iload_2
    //   90: iastore
    //   91: dup
    //   92: iconst_1
    //   93: iload_3
    //   94: iastore
    //   95: areturn
    //   96: astore_1
    //   97: goto +19 -> 116
    //   100: astore_1
    //   101: ldc 13
    //   103: ldc 187
    //   105: aload_1
    //   106: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload 4
    //   111: invokevirtual 185	android/media/MediaMetadataRetriever:release	()V
    //   114: aconst_null
    //   115: areturn
    //   116: aload 4
    //   118: invokevirtual 185	android/media/MediaMetadataRetriever:release	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	LocalProcessor
    //   0	123	1	paramString	String
    //   49	41	2	i	int
    //   68	26	3	j	int
    //   16	101	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   39	35	5	str	String
    // Exception table:
    //   from	to	target	type
    //   18	48	96	finally
    //   53	59	96	finally
    //   59	67	96	finally
    //   72	79	96	finally
    //   101	109	96	finally
    //   18	48	100	java/lang/Throwable
    //   53	59	100	java/lang/Throwable
    //   59	67	100	java/lang/Throwable
    //   72	79	100	java/lang/Throwable
  }
  
  /* Error */
  private void processLocalEnsure(UploadJobContext paramUploadJobContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: new 198	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   21: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   24: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 17
    //   29: aload 17
    //   31: invokevirtual 211	java/io/File:exists	()Z
    //   34: istore 4
    //   36: aload 17
    //   38: invokevirtual 214	java/io/File:isDirectory	()Z
    //   41: iconst_1
    //   42: ixor
    //   43: istore 5
    //   45: iload 4
    //   47: ifeq +1718 -> 1765
    //   50: iload 5
    //   52: ifeq +1713 -> 1765
    //   55: aload_1
    //   56: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   59: astore 18
    //   61: aload 18
    //   63: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   66: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: istore_3
    //   70: aconst_null
    //   71: astore 16
    //   73: iload_3
    //   74: ifne +67 -> 141
    //   77: new 198	java/io/File
    //   80: dup
    //   81: aload 18
    //   83: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   86: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 12
    //   91: aload 12
    //   93: invokevirtual 211	java/io/File:exists	()Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifne +30 -> 128
    //   101: aload 18
    //   103: aconst_null
    //   104: putfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   107: aload 18
    //   109: aconst_null
    //   110: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   113: aload 18
    //   115: aconst_null
    //   116: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   119: aload 18
    //   121: lconst_0
    //   122: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   125: goto +18 -> 143
    //   128: aload 18
    //   130: aload 12
    //   132: invokevirtual 231	java/io/File:length	()J
    //   135: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   138: goto +5 -> 143
    //   141: iconst_0
    //   142: istore_3
    //   143: aload 17
    //   145: invokevirtual 234	java/io/File:lastModified	()J
    //   148: lstore 6
    //   150: aload 17
    //   152: invokevirtual 231	java/io/File:length	()J
    //   155: lstore 8
    //   157: aload 18
    //   159: getfield 236	com/tencent/weiyun/transmission/upload/UploadFile:lastModified	J
    //   162: lload 6
    //   164: lcmp
    //   165: ifne +30 -> 195
    //   168: aload 18
    //   170: getfield 239	com/tencent/weiyun/transmission/upload/UploadFile:fileSize	J
    //   173: lload 8
    //   175: lcmp
    //   176: ifne +19 -> 195
    //   179: aload 18
    //   181: getfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   184: ifnonnull +6 -> 190
    //   187: goto +8 -> 195
    //   190: iconst_0
    //   191: istore_2
    //   192: goto +1221 -> 1413
    //   195: aload 18
    //   197: aload 17
    //   199: invokevirtual 234	java/io/File:lastModified	()J
    //   202: putfield 236	com/tencent/weiyun/transmission/upload/UploadFile:lastModified	J
    //   205: aload 18
    //   207: aload 17
    //   209: invokevirtual 245	java/io/File:getName	()Ljava/lang/String;
    //   212: putfield 248	com/tencent/weiyun/transmission/upload/UploadFile:fileName	Ljava/lang/String;
    //   215: aload_0
    //   216: getfield 43	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:mContext	Landroid/content/Context;
    //   219: invokevirtual 254	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   222: astore 19
    //   224: iconst_1
    //   225: anewarray 59	java/lang/String
    //   228: astore 12
    //   230: aload 12
    //   232: iconst_0
    //   233: ldc_w 256
    //   236: aastore
    //   237: iconst_1
    //   238: anewarray 59	java/lang/String
    //   241: astore 15
    //   243: aload 15
    //   245: iconst_0
    //   246: aload 18
    //   248: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   251: aastore
    //   252: aload 19
    //   254: ldc_w 258
    //   257: invokestatic 264	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   260: aload 12
    //   262: ldc_w 266
    //   265: aload 15
    //   267: aconst_null
    //   268: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   271: astore 14
    //   273: aload 14
    //   275: ifnull +20 -> 295
    //   278: aload 14
    //   280: astore 13
    //   282: aload 14
    //   284: invokeinterface 277 1 0
    //   289: ifne +1502 -> 1791
    //   292: goto +3 -> 295
    //   295: aload 14
    //   297: astore 13
    //   299: aload 14
    //   301: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   304: aload 14
    //   306: astore 13
    //   308: aload 19
    //   310: ldc_w 285
    //   313: invokestatic 264	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   316: aload 12
    //   318: ldc_w 266
    //   321: aload 15
    //   323: aconst_null
    //   324: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   327: astore 12
    //   329: aload 12
    //   331: ifnull +1469 -> 1800
    //   334: aload 12
    //   336: astore 13
    //   338: aload 12
    //   340: astore 14
    //   342: aload 12
    //   344: invokeinterface 277 1 0
    //   349: ifeq +1451 -> 1800
    //   352: goto +1443 -> 1795
    //   355: iload_2
    //   356: ifeq +41 -> 397
    //   359: aload 12
    //   361: astore 13
    //   363: aload 12
    //   365: astore 14
    //   367: aload 12
    //   369: iconst_0
    //   370: invokeinterface 288 2 0
    //   375: astore 15
    //   377: aload 15
    //   379: astore 13
    //   381: goto +19 -> 400
    //   384: astore_1
    //   385: goto +1373 -> 1758
    //   388: astore 15
    //   390: aload 14
    //   392: astore 12
    //   394: goto +35 -> 429
    //   397: aconst_null
    //   398: astore 13
    //   400: aload 12
    //   402: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   405: goto +43 -> 448
    //   408: astore 15
    //   410: aload 14
    //   412: astore 12
    //   414: goto +15 -> 429
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 13
    //   421: goto +1337 -> 1758
    //   424: astore 15
    //   426: aconst_null
    //   427: astore 12
    //   429: aload 12
    //   431: astore 13
    //   433: ldc 13
    //   435: aload 15
    //   437: invokestatic 291	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   440: aload 12
    //   442: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   445: aconst_null
    //   446: astore 13
    //   448: aload 13
    //   450: ifnonnull +11 -> 461
    //   453: ldc_w 293
    //   456: astore 12
    //   458: goto +10 -> 468
    //   461: aload 13
    //   463: invokevirtual 296	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   466: astore 12
    //   468: aload 18
    //   470: aload 12
    //   472: putfield 299	com/tencent/weiyun/transmission/upload/UploadFile:mimeType	Ljava/lang/String;
    //   475: aload 12
    //   477: ldc_w 301
    //   480: invokevirtual 305	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   483: ifeq +503 -> 986
    //   486: aload_0
    //   487: aload 19
    //   489: aload 18
    //   491: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   494: invokespecial 309	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryImageInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   497: astore 13
    //   499: aload 13
    //   501: ifnull +177 -> 678
    //   504: aload 13
    //   506: iconst_0
    //   507: aaload
    //   508: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifne +16 -> 527
    //   514: aload 18
    //   516: aload_0
    //   517: aload 13
    //   519: iconst_0
    //   520: aaload
    //   521: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   524: putfield 313	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   527: aload 13
    //   529: iconst_1
    //   530: aaload
    //   531: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: ifne +16 -> 550
    //   537: aload 18
    //   539: aload_0
    //   540: aload 13
    //   542: iconst_1
    //   543: aaload
    //   544: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   547: putfield 316	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   550: aload 13
    //   552: iconst_2
    //   553: aaload
    //   554: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   557: ifne +61 -> 618
    //   560: aload 13
    //   562: iconst_2
    //   563: aaload
    //   564: invokestatic 319	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   567: ifeq +16 -> 583
    //   570: aload_0
    //   571: aload 13
    //   573: iconst_2
    //   574: aaload
    //   575: invokespecial 321	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   578: lstore 8
    //   580: goto +41 -> 621
    //   583: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   586: aload 13
    //   588: iconst_2
    //   589: aaload
    //   590: new 323	java/text/ParsePosition
    //   593: dup
    //   594: iconst_0
    //   595: invokespecial 326	java/text/ParsePosition:<init>	(I)V
    //   598: invokevirtual 330	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   601: astore 14
    //   603: aload 14
    //   605: ifnull +13 -> 618
    //   608: aload 14
    //   610: invokevirtual 335	java/util/Date:getTime	()J
    //   613: lstore 8
    //   615: goto +6 -> 621
    //   618: lconst_0
    //   619: lstore 8
    //   621: aload 13
    //   623: iconst_4
    //   624: aaload
    //   625: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: ifne +16 -> 644
    //   631: aload 18
    //   633: aload_0
    //   634: aload 13
    //   636: iconst_4
    //   637: aaload
    //   638: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   641: putfield 338	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   644: lload 8
    //   646: lstore 6
    //   648: aload 13
    //   650: iconst_5
    //   651: aaload
    //   652: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   655: ifne +26 -> 681
    //   658: aload 18
    //   660: aload_0
    //   661: aload 13
    //   663: iconst_5
    //   664: aaload
    //   665: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   668: putfield 341	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   671: lload 8
    //   673: lstore 6
    //   675: goto +6 -> 681
    //   678: lconst_0
    //   679: lstore 6
    //   681: lload 6
    //   683: lstore 10
    //   685: aload 12
    //   687: ldc_w 343
    //   690: invokevirtual 346	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   693: ifeq +196 -> 889
    //   696: aload_0
    //   697: aload 18
    //   699: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   702: invokespecial 348	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseExif	(Ljava/lang/String;)[Ljava/lang/String;
    //   705: astore 12
    //   707: lload 6
    //   709: lstore 10
    //   711: aload 12
    //   713: ifnull +176 -> 889
    //   716: aload 12
    //   718: iconst_0
    //   719: aaload
    //   720: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   723: ifne +16 -> 739
    //   726: aload 18
    //   728: aload_0
    //   729: aload 12
    //   731: iconst_0
    //   732: aaload
    //   733: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   736: putfield 313	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   739: aload 12
    //   741: iconst_1
    //   742: aaload
    //   743: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   746: ifne +16 -> 762
    //   749: aload 18
    //   751: aload_0
    //   752: aload 12
    //   754: iconst_1
    //   755: aaload
    //   756: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   759: putfield 316	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   762: lload 6
    //   764: lstore 8
    //   766: aload 12
    //   768: iconst_2
    //   769: aaload
    //   770: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   773: ifne +62 -> 835
    //   776: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   779: aload 12
    //   781: iconst_2
    //   782: aaload
    //   783: new 323	java/text/ParsePosition
    //   786: dup
    //   787: iconst_0
    //   788: invokespecial 326	java/text/ParsePosition:<init>	(I)V
    //   791: invokevirtual 330	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   794: astore 14
    //   796: lload 6
    //   798: lstore 8
    //   800: aload 14
    //   802: ifnull +33 -> 835
    //   805: aload 14
    //   807: invokevirtual 335	java/util/Date:getTime	()J
    //   810: lstore 10
    //   812: lload 6
    //   814: lstore 8
    //   816: lload 10
    //   818: lload 6
    //   820: lsub
    //   821: invokestatic 354	java/lang/Math:abs	(J)J
    //   824: ldc2_w 16
    //   827: lcmp
    //   828: ifle +7 -> 835
    //   831: lload 10
    //   833: lstore 8
    //   835: aload 12
    //   837: iconst_3
    //   838: aaload
    //   839: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   842: ifne +16 -> 858
    //   845: aload 18
    //   847: aload_0
    //   848: aload 12
    //   850: iconst_3
    //   851: aaload
    //   852: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   855: putfield 338	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   858: lload 8
    //   860: lstore 10
    //   862: aload 12
    //   864: iconst_4
    //   865: aaload
    //   866: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   869: ifne +20 -> 889
    //   872: aload 18
    //   874: aload_0
    //   875: aload 12
    //   877: iconst_4
    //   878: aaload
    //   879: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   882: putfield 341	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   885: lload 8
    //   887: lstore 10
    //   889: lload 10
    //   891: lstore 6
    //   893: lload 10
    //   895: lconst_0
    //   896: lcmp
    //   897: ifgt +79 -> 976
    //   900: lload 10
    //   902: lstore 6
    //   904: aload 13
    //   906: ifnull +70 -> 976
    //   909: lload 10
    //   911: lstore 6
    //   913: aload 13
    //   915: iconst_3
    //   916: aaload
    //   917: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   920: ifne +56 -> 976
    //   923: aload 13
    //   925: iconst_3
    //   926: aaload
    //   927: invokevirtual 357	java/lang/String:trim	()Ljava/lang/String;
    //   930: astore 12
    //   932: aload_0
    //   933: aload 12
    //   935: invokespecial 321	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   938: lstore 6
    //   940: aload 12
    //   942: invokevirtual 360	java/lang/String:length	()I
    //   945: bipush 8
    //   947: if_icmple +20 -> 967
    //   950: aload 12
    //   952: invokevirtual 360	java/lang/String:length	()I
    //   955: bipush 10
    //   957: if_icmpgt +10 -> 967
    //   960: sipush 1000
    //   963: istore_2
    //   964: goto +5 -> 969
    //   967: iconst_1
    //   968: istore_2
    //   969: iload_2
    //   970: i2l
    //   971: lload 6
    //   973: lmul
    //   974: lstore 6
    //   976: aload 18
    //   978: lload 6
    //   980: putfield 363	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   983: goto +428 -> 1411
    //   986: aload 12
    //   988: ldc_w 365
    //   991: invokevirtual 305	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   994: ifeq +350 -> 1344
    //   997: aload_0
    //   998: aload 19
    //   1000: aload 18
    //   1002: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1005: invokespecial 368	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryVideoInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   1008: astore 12
    //   1010: aload 12
    //   1012: ifnull +260 -> 1272
    //   1015: aload 12
    //   1017: iconst_0
    //   1018: aaload
    //   1019: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1022: ifne +16 -> 1038
    //   1025: aload 18
    //   1027: aload_0
    //   1028: aload 12
    //   1030: iconst_0
    //   1031: aaload
    //   1032: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   1035: putfield 313	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   1038: aload 12
    //   1040: iconst_1
    //   1041: aaload
    //   1042: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1045: ifne +16 -> 1061
    //   1048: aload 18
    //   1050: aload_0
    //   1051: aload 12
    //   1053: iconst_1
    //   1054: aaload
    //   1055: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   1058: putfield 316	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   1061: aload 12
    //   1063: iconst_2
    //   1064: aaload
    //   1065: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1068: ifne +67 -> 1135
    //   1071: aload 12
    //   1073: iconst_2
    //   1074: aaload
    //   1075: invokestatic 319	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   1078: ifeq +19 -> 1097
    //   1081: aload 18
    //   1083: aload_0
    //   1084: aload 12
    //   1086: iconst_2
    //   1087: aaload
    //   1088: invokespecial 321	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1091: putfield 363	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1094: goto +107 -> 1201
    //   1097: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   1100: aload 12
    //   1102: iconst_2
    //   1103: aaload
    //   1104: new 323	java/text/ParsePosition
    //   1107: dup
    //   1108: iconst_0
    //   1109: invokespecial 326	java/text/ParsePosition:<init>	(I)V
    //   1112: invokevirtual 330	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   1115: astore 13
    //   1117: aload 13
    //   1119: ifnull +82 -> 1201
    //   1122: aload 18
    //   1124: aload 13
    //   1126: invokevirtual 335	java/util/Date:getTime	()J
    //   1129: putfield 363	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1132: goto +69 -> 1201
    //   1135: aload 12
    //   1137: iconst_3
    //   1138: aaload
    //   1139: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1142: ifne +59 -> 1201
    //   1145: aload 12
    //   1147: iconst_3
    //   1148: aaload
    //   1149: invokevirtual 357	java/lang/String:trim	()Ljava/lang/String;
    //   1152: astore 13
    //   1154: aload_0
    //   1155: aload 13
    //   1157: invokespecial 321	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1160: lstore 6
    //   1162: aload 13
    //   1164: invokevirtual 360	java/lang/String:length	()I
    //   1167: bipush 8
    //   1169: if_icmple +20 -> 1189
    //   1172: aload 13
    //   1174: invokevirtual 360	java/lang/String:length	()I
    //   1177: bipush 10
    //   1179: if_icmpgt +10 -> 1189
    //   1182: sipush 1000
    //   1185: istore_2
    //   1186: goto +5 -> 1191
    //   1189: iconst_1
    //   1190: istore_2
    //   1191: aload 18
    //   1193: lload 6
    //   1195: iload_2
    //   1196: i2l
    //   1197: lmul
    //   1198: putfield 363	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1201: aload 12
    //   1203: iconst_4
    //   1204: aaload
    //   1205: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1208: ifne +16 -> 1224
    //   1211: aload 18
    //   1213: aload_0
    //   1214: aload 12
    //   1216: iconst_4
    //   1217: aaload
    //   1218: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   1221: putfield 338	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1224: aload 12
    //   1226: iconst_5
    //   1227: aaload
    //   1228: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1231: ifne +16 -> 1247
    //   1234: aload 18
    //   1236: aload_0
    //   1237: aload 12
    //   1239: iconst_5
    //   1240: aaload
    //   1241: invokespecial 182	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   1244: putfield 341	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1247: aload 12
    //   1249: bipush 6
    //   1251: aaload
    //   1252: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1255: ifne +17 -> 1272
    //   1258: aload 18
    //   1260: aload_0
    //   1261: aload 12
    //   1263: bipush 6
    //   1265: aaload
    //   1266: invokespecial 321	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1269: putfield 371	com/tencent/weiyun/transmission/upload/UploadFile:duration	J
    //   1272: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   1275: bipush 14
    //   1277: if_icmplt +8 -> 1285
    //   1280: iconst_1
    //   1281: istore_2
    //   1282: goto +5 -> 1287
    //   1285: iconst_0
    //   1286: istore_2
    //   1287: aload 18
    //   1289: getfield 338	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1292: ifne +119 -> 1411
    //   1295: aload 18
    //   1297: getfield 341	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1300: ifne +111 -> 1411
    //   1303: iload_2
    //   1304: ifeq +107 -> 1411
    //   1307: aload_0
    //   1308: aload 18
    //   1310: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1313: invokespecial 378	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseVideoSizes	(Ljava/lang/String;)[I
    //   1316: astore 12
    //   1318: aload 12
    //   1320: ifnull +91 -> 1411
    //   1323: aload 18
    //   1325: aload 12
    //   1327: iconst_0
    //   1328: iaload
    //   1329: putfield 338	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1332: aload 18
    //   1334: aload 12
    //   1336: iconst_1
    //   1337: iaload
    //   1338: putfield 341	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1341: goto +70 -> 1411
    //   1344: aload 12
    //   1346: ldc_w 380
    //   1349: invokevirtual 305	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1352: ifeq +59 -> 1411
    //   1355: aload_0
    //   1356: aload 19
    //   1358: aload 18
    //   1360: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1363: invokespecial 383	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryAudioInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   1366: astore 12
    //   1368: aload 12
    //   1370: ifnull +41 -> 1411
    //   1373: aload 12
    //   1375: iconst_0
    //   1376: aaload
    //   1377: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1380: ifne +12 -> 1392
    //   1383: aload 18
    //   1385: aload 12
    //   1387: iconst_0
    //   1388: aaload
    //   1389: putfield 386	com/tencent/weiyun/transmission/upload/UploadFile:album	Ljava/lang/String;
    //   1392: aload 12
    //   1394: iconst_1
    //   1395: aaload
    //   1396: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1399: ifne +12 -> 1411
    //   1402: aload 18
    //   1404: aload 12
    //   1406: iconst_1
    //   1407: aaload
    //   1408: putfield 389	com/tencent/weiyun/transmission/upload/UploadFile:artist	Ljava/lang/String;
    //   1411: iconst_1
    //   1412: istore_2
    //   1413: iload_3
    //   1414: ifeq +188 -> 1602
    //   1417: iload_2
    //   1418: ifeq +57 -> 1475
    //   1421: aload 18
    //   1423: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1426: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1429: ifne +19 -> 1448
    //   1432: new 198	java/io/File
    //   1435: dup
    //   1436: aload 18
    //   1438: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1441: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   1444: iconst_0
    //   1445: invokestatic 393	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   1448: aload 18
    //   1450: aconst_null
    //   1451: putfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1454: aload 18
    //   1456: aconst_null
    //   1457: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1460: aload 18
    //   1462: aconst_null
    //   1463: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   1466: aload 18
    //   1468: lconst_0
    //   1469: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   1472: goto +130 -> 1602
    //   1475: aload_1
    //   1476: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1479: invokevirtual 402	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1482: aload 18
    //   1484: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1487: aload_1
    //   1488: invokevirtual 406	com/tencent/weiyun/transmission/upload/UploadJobContext:getCanceledFlag	()Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;
    //   1491: invokestatic 412	com/tencent/weiyun/transmission/upload/UploadHelper:calSliceSha1	(Ljava/lang/String;Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;)[Ljava/lang/String;
    //   1494: astore 13
    //   1496: aload_1
    //   1497: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1500: invokevirtual 415	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1503: aload_1
    //   1504: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   1507: ifeq +4 -> 1511
    //   1510: return
    //   1511: aload_1
    //   1512: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1515: astore 14
    //   1517: aload 13
    //   1519: ifnull +25 -> 1544
    //   1522: aload 13
    //   1524: arraylength
    //   1525: ifgt +6 -> 1531
    //   1528: goto +16 -> 1544
    //   1531: aload 13
    //   1533: aload 13
    //   1535: arraylength
    //   1536: iconst_1
    //   1537: isub
    //   1538: aaload
    //   1539: astore 12
    //   1541: goto +6 -> 1547
    //   1544: aconst_null
    //   1545: astore 12
    //   1547: aload 14
    //   1549: aload 12
    //   1551: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1554: aload_1
    //   1555: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1558: aload 13
    //   1560: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   1563: aload_1
    //   1564: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1567: getfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1570: ifnonnull +32 -> 1602
    //   1573: aload_1
    //   1574: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1577: invokevirtual 402	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1580: aload_1
    //   1581: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1584: aload 18
    //   1586: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1589: invokestatic 418	com/tencent/weiyun/utils/IOUtils:getFileSha1	(Ljava/lang/String;)Ljava/lang/String;
    //   1592: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1595: aload_1
    //   1596: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1599: invokevirtual 415	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1602: iload_2
    //   1603: ifne +24 -> 1627
    //   1606: aload 18
    //   1608: getfield 421	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   1611: ifnull +12 -> 1623
    //   1614: aload 18
    //   1616: getfield 421	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   1619: arraylength
    //   1620: ifgt +124 -> 1744
    //   1623: iload_3
    //   1624: ifne +120 -> 1744
    //   1627: aload_1
    //   1628: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1631: invokevirtual 402	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1634: aload 17
    //   1636: invokevirtual 424	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1639: aload_1
    //   1640: invokevirtual 406	com/tencent/weiyun/transmission/upload/UploadJobContext:getCanceledFlag	()Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;
    //   1643: invokestatic 412	com/tencent/weiyun/transmission/upload/UploadHelper:calSliceSha1	(Ljava/lang/String;Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;)[Ljava/lang/String;
    //   1646: astore 13
    //   1648: aload_1
    //   1649: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1652: invokevirtual 415	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1655: aload_1
    //   1656: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   1659: ifeq +4 -> 1663
    //   1662: return
    //   1663: aload 16
    //   1665: astore 12
    //   1667: aload 13
    //   1669: ifnull +26 -> 1695
    //   1672: aload 13
    //   1674: arraylength
    //   1675: ifgt +10 -> 1685
    //   1678: aload 16
    //   1680: astore 12
    //   1682: goto +13 -> 1695
    //   1685: aload 13
    //   1687: aload 13
    //   1689: arraylength
    //   1690: iconst_1
    //   1691: isub
    //   1692: aaload
    //   1693: astore 12
    //   1695: aload 18
    //   1697: aload 12
    //   1699: putfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   1702: aload 18
    //   1704: aload 13
    //   1706: putfield 421	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   1709: aload 18
    //   1711: getfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   1714: ifnonnull +30 -> 1744
    //   1717: aload_1
    //   1718: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1721: invokevirtual 402	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1724: aload 18
    //   1726: aload 17
    //   1728: invokevirtual 424	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1731: invokestatic 418	com/tencent/weiyun/utils/IOUtils:getFileSha1	(Ljava/lang/String;)Ljava/lang/String;
    //   1734: putfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   1737: aload_1
    //   1738: invokevirtual 397	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1741: invokevirtual 415	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1744: aload 18
    //   1746: aload 17
    //   1748: invokevirtual 231	java/io/File:length	()J
    //   1751: putfield 239	com/tencent/weiyun/transmission/upload/UploadFile:fileSize	J
    //   1754: goto +11 -> 1765
    //   1757: astore_1
    //   1758: aload 13
    //   1760: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   1763: aload_1
    //   1764: athrow
    //   1765: aload_1
    //   1766: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   1769: ifeq +4 -> 1773
    //   1772: return
    //   1773: aload_0
    //   1774: getfield 45	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/LocalProcessor$LocalProcessorCallback;
    //   1777: aload_1
    //   1778: invokevirtual 427	com/tencent/weiyun/transmission/upload/UploadJobContext:dbId	()J
    //   1781: iload 4
    //   1783: iload 5
    //   1785: invokeinterface 433 5 0
    //   1790: return
    //   1791: aload 14
    //   1793: astore 12
    //   1795: iconst_1
    //   1796: istore_2
    //   1797: goto -1442 -> 355
    //   1800: iconst_0
    //   1801: istore_2
    //   1802: goto -1447 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1805	0	this	LocalProcessor
    //   0	1805	1	paramUploadJobContext	UploadJobContext
    //   191	1611	2	i	int
    //   69	1555	3	bool1	boolean
    //   34	1748	4	bool2	boolean
    //   43	1741	5	bool3	boolean
    //   148	1046	6	l1	long
    //   155	731	8	l2	long
    //   683	227	10	l3	long
    //   89	1705	12	localObject1	Object
    //   280	1479	13	localObject2	Object
    //   271	1521	14	localObject3	Object
    //   241	137	15	localObject4	Object
    //   388	1	15	localThrowable1	Throwable
    //   408	1	15	localThrowable2	Throwable
    //   424	12	15	localThrowable3	Throwable
    //   71	1608	16	localObject5	Object
    //   27	1720	17	localFile	java.io.File
    //   59	1686	18	localUploadFile	com.tencent.weiyun.transmission.upload.UploadFile
    //   222	1135	19	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   342	352	384	finally
    //   367	377	384	finally
    //   342	352	388	java/lang/Throwable
    //   367	377	388	java/lang/Throwable
    //   282	292	408	java/lang/Throwable
    //   299	304	408	java/lang/Throwable
    //   308	329	408	java/lang/Throwable
    //   252	273	417	finally
    //   252	273	424	java/lang/Throwable
    //   282	292	1757	finally
    //   299	304	1757	finally
    //   308	329	1757	finally
    //   433	440	1757	finally
  }
  
  /* Error */
  private String[] queryAudioInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +378 -> 379
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: iconst_2
    //   14: anewarray 59	java/lang/String
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_0
    //   22: ldc_w 434
    //   25: aastore
    //   26: aload 9
    //   28: iconst_1
    //   29: ldc_w 435
    //   32: aastore
    //   33: iconst_1
    //   34: anewarray 59	java/lang/String
    //   37: astore 10
    //   39: aload 10
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: aload_1
    //   45: getstatic 441	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   48: aload 9
    //   50: ldc_w 266
    //   53: aload 10
    //   55: aconst_null
    //   56: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 7
    //   61: aload 7
    //   63: ifnull +28 -> 91
    //   66: aload 7
    //   68: astore 6
    //   70: aload 7
    //   72: astore 5
    //   74: aload 7
    //   76: astore 8
    //   78: aload 7
    //   80: invokeinterface 277 1 0
    //   85: ifne +296 -> 381
    //   88: goto +3 -> 91
    //   91: aload 7
    //   93: astore 6
    //   95: aload 7
    //   97: astore 5
    //   99: aload_1
    //   100: getstatic 444	android/provider/MediaStore$Audio$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   103: aload 9
    //   105: ldc_w 266
    //   108: aload 10
    //   110: aconst_null
    //   111: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +36 -> 152
    //   119: aload_1
    //   120: invokeinterface 277 1 0
    //   125: istore 4
    //   127: iload 4
    //   129: ifeq +23 -> 152
    //   132: aload_1
    //   133: astore 8
    //   135: goto +246 -> 381
    //   138: astore_2
    //   139: aload_1
    //   140: astore 5
    //   142: aload_2
    //   143: astore_1
    //   144: goto +228 -> 372
    //   147: astore 7
    //   149: goto +167 -> 316
    //   152: iconst_0
    //   153: istore_3
    //   154: aload_1
    //   155: astore 5
    //   157: iload_3
    //   158: ifeq +132 -> 290
    //   161: aload_1
    //   162: astore 6
    //   164: aload_1
    //   165: astore 5
    //   167: iconst_2
    //   168: anewarray 59	java/lang/String
    //   171: astore 7
    //   173: aload_1
    //   174: astore 6
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: iconst_0
    //   182: aload_1
    //   183: iconst_0
    //   184: invokeinterface 288 2 0
    //   189: aastore
    //   190: aload_1
    //   191: astore 6
    //   193: aload_1
    //   194: astore 5
    //   196: aload 7
    //   198: iconst_1
    //   199: aload_1
    //   200: iconst_1
    //   201: invokeinterface 288 2 0
    //   206: aastore
    //   207: aload_1
    //   208: astore 6
    //   210: aload_1
    //   211: astore 5
    //   213: new 124	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   220: astore 8
    //   222: aload_1
    //   223: astore 6
    //   225: aload_1
    //   226: astore 5
    //   228: aload 8
    //   230: aload_2
    //   231: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: astore 6
    //   238: aload_1
    //   239: astore 5
    //   241: aload 8
    //   243: ldc_w 446
    //   246: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: astore 6
    //   253: aload_1
    //   254: astore 5
    //   256: aload 8
    //   258: aload 7
    //   260: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: astore 6
    //   270: aload_1
    //   271: astore 5
    //   273: ldc 13
    //   275: aload 8
    //   277: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   287: aload 7
    //   289: areturn
    //   290: aload 5
    //   292: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   295: aconst_null
    //   296: areturn
    //   297: astore 7
    //   299: aload 6
    //   301: astore_1
    //   302: goto +14 -> 316
    //   305: astore_1
    //   306: aconst_null
    //   307: astore 5
    //   309: goto +63 -> 372
    //   312: astore 7
    //   314: aconst_null
    //   315: astore_1
    //   316: aload_1
    //   317: astore 5
    //   319: new 124	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   326: astore 6
    //   328: aload_1
    //   329: astore 5
    //   331: aload 6
    //   333: aload_2
    //   334: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_1
    //   339: astore 5
    //   341: aload 6
    //   343: ldc_w 448
    //   346: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_1
    //   351: astore 5
    //   353: ldc 13
    //   355: aload 6
    //   357: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: aload 7
    //   362: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload_1
    //   366: astore 5
    //   368: goto -78 -> 290
    //   371: astore_1
    //   372: aload 5
    //   374: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   377: aload_1
    //   378: athrow
    //   379: aconst_null
    //   380: areturn
    //   381: iconst_1
    //   382: istore_3
    //   383: aload 8
    //   385: astore_1
    //   386: goto -232 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	LocalProcessor
    //   0	389	1	paramContentResolver	android.content.ContentResolver
    //   0	389	2	paramString	String
    //   153	230	3	i	int
    //   125	3	4	bool	boolean
    //   72	301	5	localObject1	Object
    //   68	288	6	localObject2	Object
    //   59	37	7	localCursor	android.database.Cursor
    //   147	1	7	localThrowable1	Throwable
    //   171	117	7	arrayOfString1	String[]
    //   297	1	7	localThrowable2	Throwable
    //   312	49	7	localThrowable3	Throwable
    //   76	308	8	localObject3	Object
    //   17	87	9	arrayOfString2	String[]
    //   37	72	10	arrayOfString3	String[]
    // Exception table:
    //   from	to	target	type
    //   119	127	138	finally
    //   119	127	147	java/lang/Throwable
    //   78	88	297	java/lang/Throwable
    //   99	115	297	java/lang/Throwable
    //   167	173	297	java/lang/Throwable
    //   179	190	297	java/lang/Throwable
    //   196	207	297	java/lang/Throwable
    //   213	222	297	java/lang/Throwable
    //   228	235	297	java/lang/Throwable
    //   241	250	297	java/lang/Throwable
    //   256	267	297	java/lang/Throwable
    //   273	283	297	java/lang/Throwable
    //   44	61	305	finally
    //   44	61	312	java/lang/Throwable
    //   78	88	371	finally
    //   99	115	371	finally
    //   167	173	371	finally
    //   179	190	371	finally
    //   196	207	371	finally
    //   213	222	371	finally
    //   228	235	371	finally
    //   241	250	371	finally
    //   256	267	371	finally
    //   273	283	371	finally
    //   319	328	371	finally
    //   331	338	371	finally
    //   341	350	371	finally
    //   353	365	371	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private String[] queryImageInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +574 -> 575
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +6 -> 14
    //   11: goto +564 -> 575
    //   14: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 16
    //   19: if_icmplt +8 -> 27
    //   22: iconst_1
    //   23: istore_3
    //   24: goto +5 -> 29
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: ifne +35 -> 65
    //   33: aload_2
    //   34: invokestatic 452	com/tencent/weiyun/utils/IOUtils:getImageWidthHeight	(Ljava/lang/String;)[I
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +24 -> 65
    //   44: aload 6
    //   46: iconst_0
    //   47: iaload
    //   48: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   51: astore 7
    //   53: aload 6
    //   55: iconst_1
    //   56: iaload
    //   57: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   60: astore 8
    //   62: goto +9 -> 71
    //   65: aconst_null
    //   66: astore 7
    //   68: aconst_null
    //   69: astore 8
    //   71: iload_3
    //   72: ifeq +55 -> 127
    //   75: bipush 6
    //   77: anewarray 59	java/lang/String
    //   80: astore 9
    //   82: aload 9
    //   84: iconst_0
    //   85: ldc_w 455
    //   88: aastore
    //   89: aload 9
    //   91: iconst_1
    //   92: ldc_w 456
    //   95: aastore
    //   96: aload 9
    //   98: iconst_2
    //   99: ldc_w 458
    //   102: aastore
    //   103: aload 9
    //   105: iconst_3
    //   106: ldc_w 460
    //   109: aastore
    //   110: aload 9
    //   112: iconst_4
    //   113: ldc_w 461
    //   116: aastore
    //   117: aload 9
    //   119: iconst_5
    //   120: ldc_w 462
    //   123: aastore
    //   124: goto +37 -> 161
    //   127: iconst_4
    //   128: anewarray 59	java/lang/String
    //   131: astore 9
    //   133: aload 9
    //   135: iconst_0
    //   136: ldc_w 455
    //   139: aastore
    //   140: aload 9
    //   142: iconst_1
    //   143: ldc_w 456
    //   146: aastore
    //   147: aload 9
    //   149: iconst_2
    //   150: ldc_w 458
    //   153: aastore
    //   154: aload 9
    //   156: iconst_3
    //   157: ldc_w 460
    //   160: aastore
    //   161: iconst_1
    //   162: anewarray 59	java/lang/String
    //   165: astore 10
    //   167: aload 10
    //   169: iconst_0
    //   170: aload_2
    //   171: aastore
    //   172: aload_1
    //   173: getstatic 465	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   176: aload 9
    //   178: ldc_w 266
    //   181: aload 10
    //   183: aconst_null
    //   184: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   187: astore 6
    //   189: aload 6
    //   191: ifnull +16 -> 207
    //   194: aload 6
    //   196: invokeinterface 277 1 0
    //   201: ifne +376 -> 577
    //   204: goto +3 -> 207
    //   207: aload_1
    //   208: getstatic 466	android/provider/MediaStore$Images$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   211: aload 9
    //   213: ldc_w 266
    //   216: aload 10
    //   218: aconst_null
    //   219: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +37 -> 261
    //   227: aload_1
    //   228: invokeinterface 277 1 0
    //   233: istore 5
    //   235: iload 5
    //   237: ifeq +24 -> 261
    //   240: aload_1
    //   241: astore 6
    //   243: goto +334 -> 577
    //   246: astore 6
    //   248: aload_1
    //   249: astore_2
    //   250: aload 6
    //   252: astore_1
    //   253: goto +316 -> 569
    //   256: astore 6
    //   258: goto +260 -> 518
    //   261: iconst_0
    //   262: istore 4
    //   264: aload_1
    //   265: astore 6
    //   267: iload 4
    //   269: ifeq +213 -> 482
    //   272: iload_3
    //   273: ifeq +78 -> 351
    //   276: bipush 6
    //   278: anewarray 59	java/lang/String
    //   281: astore_1
    //   282: aload_1
    //   283: iconst_0
    //   284: aload 6
    //   286: iconst_0
    //   287: invokeinterface 288 2 0
    //   292: aastore
    //   293: aload_1
    //   294: iconst_1
    //   295: aload 6
    //   297: iconst_1
    //   298: invokeinterface 288 2 0
    //   303: aastore
    //   304: aload_1
    //   305: iconst_2
    //   306: aload 6
    //   308: iconst_2
    //   309: invokeinterface 288 2 0
    //   314: aastore
    //   315: aload_1
    //   316: iconst_3
    //   317: aload 6
    //   319: iconst_3
    //   320: invokeinterface 288 2 0
    //   325: aastore
    //   326: aload_1
    //   327: iconst_4
    //   328: aload 6
    //   330: iconst_4
    //   331: invokeinterface 288 2 0
    //   336: aastore
    //   337: aload_1
    //   338: iconst_5
    //   339: aload 6
    //   341: iconst_5
    //   342: invokeinterface 288 2 0
    //   347: aastore
    //   348: goto +63 -> 411
    //   351: bipush 6
    //   353: anewarray 59	java/lang/String
    //   356: astore_1
    //   357: aload_1
    //   358: iconst_0
    //   359: aload 6
    //   361: iconst_0
    //   362: invokeinterface 288 2 0
    //   367: aastore
    //   368: aload_1
    //   369: iconst_1
    //   370: aload 6
    //   372: iconst_1
    //   373: invokeinterface 288 2 0
    //   378: aastore
    //   379: aload_1
    //   380: iconst_2
    //   381: aload 6
    //   383: iconst_2
    //   384: invokeinterface 288 2 0
    //   389: aastore
    //   390: aload_1
    //   391: iconst_3
    //   392: aload 6
    //   394: iconst_3
    //   395: invokeinterface 288 2 0
    //   400: aastore
    //   401: aload_1
    //   402: iconst_4
    //   403: aload 7
    //   405: aastore
    //   406: aload_1
    //   407: iconst_5
    //   408: aload 8
    //   410: aastore
    //   411: new 124	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   418: astore 7
    //   420: aload 7
    //   422: aload_2
    //   423: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 7
    //   429: ldc_w 468
    //   432: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 7
    //   438: aload_1
    //   439: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   442: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc 13
    //   448: aload 7
    //   450: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 6
    //   458: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   461: aload_1
    //   462: areturn
    //   463: astore_1
    //   464: aload 6
    //   466: astore_2
    //   467: goto +102 -> 569
    //   470: astore 7
    //   472: aload 6
    //   474: astore_1
    //   475: aload 7
    //   477: astore 6
    //   479: goto +39 -> 518
    //   482: aload 6
    //   484: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   487: aconst_null
    //   488: areturn
    //   489: astore_1
    //   490: aload 6
    //   492: astore_2
    //   493: goto +76 -> 569
    //   496: astore 7
    //   498: aload 6
    //   500: astore_1
    //   501: aload 7
    //   503: astore 6
    //   505: goto +13 -> 518
    //   508: astore_1
    //   509: aconst_null
    //   510: astore_2
    //   511: goto +58 -> 569
    //   514: astore 6
    //   516: aconst_null
    //   517: astore_1
    //   518: new 124	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   525: astore 7
    //   527: aload 7
    //   529: aload_2
    //   530: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 7
    //   536: ldc_w 470
    //   539: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: ldc 13
    //   545: aload 7
    //   547: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: aload 6
    //   552: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   555: aload_1
    //   556: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   559: goto -72 -> 487
    //   562: astore 6
    //   564: aload_1
    //   565: astore_2
    //   566: aload 6
    //   568: astore_1
    //   569: aload_2
    //   570: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   573: aload_1
    //   574: athrow
    //   575: aconst_null
    //   576: areturn
    //   577: iconst_1
    //   578: istore 4
    //   580: goto -313 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	LocalProcessor
    //   0	583	1	paramContentResolver	android.content.ContentResolver
    //   0	583	2	paramString	String
    //   23	250	3	i	int
    //   262	317	4	j	int
    //   233	3	5	bool	boolean
    //   37	205	6	localObject1	Object
    //   246	5	6	localObject2	Object
    //   256	1	6	localThrowable1	Throwable
    //   265	239	6	localObject3	Object
    //   514	37	6	localThrowable2	Throwable
    //   562	5	6	localObject4	Object
    //   51	398	7	localObject5	Object
    //   470	6	7	localThrowable3	Throwable
    //   496	6	7	localThrowable4	Throwable
    //   525	21	7	localStringBuilder	StringBuilder
    //   60	349	8	str	String
    //   80	132	9	arrayOfString1	String[]
    //   165	52	10	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   227	235	246	finally
    //   227	235	256	java/lang/Throwable
    //   276	348	463	finally
    //   351	401	463	finally
    //   411	456	463	finally
    //   276	348	470	java/lang/Throwable
    //   351	401	470	java/lang/Throwable
    //   411	456	470	java/lang/Throwable
    //   194	204	489	finally
    //   207	223	489	finally
    //   194	204	496	java/lang/Throwable
    //   207	223	496	java/lang/Throwable
    //   172	189	508	finally
    //   172	189	514	java/lang/Throwable
    //   518	555	562	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private String[] queryVideoInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +570 -> 571
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +6 -> 14
    //   11: goto +560 -> 571
    //   14: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 16
    //   19: if_icmplt +8 -> 27
    //   22: iconst_1
    //   23: istore_3
    //   24: goto +5 -> 29
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: ifeq +63 -> 93
    //   33: bipush 7
    //   35: anewarray 59	java/lang/String
    //   38: astore 7
    //   40: aload 7
    //   42: iconst_0
    //   43: ldc_w 455
    //   46: aastore
    //   47: aload 7
    //   49: iconst_1
    //   50: ldc_w 456
    //   53: aastore
    //   54: aload 7
    //   56: iconst_2
    //   57: ldc_w 458
    //   60: aastore
    //   61: aload 7
    //   63: iconst_3
    //   64: ldc_w 460
    //   67: aastore
    //   68: aload 7
    //   70: iconst_4
    //   71: ldc_w 461
    //   74: aastore
    //   75: aload 7
    //   77: iconst_5
    //   78: ldc_w 462
    //   81: aastore
    //   82: aload 7
    //   84: bipush 6
    //   86: ldc_w 471
    //   89: aastore
    //   90: goto +44 -> 134
    //   93: iconst_5
    //   94: anewarray 59	java/lang/String
    //   97: astore 7
    //   99: aload 7
    //   101: iconst_0
    //   102: ldc_w 455
    //   105: aastore
    //   106: aload 7
    //   108: iconst_1
    //   109: ldc_w 456
    //   112: aastore
    //   113: aload 7
    //   115: iconst_2
    //   116: ldc_w 458
    //   119: aastore
    //   120: aload 7
    //   122: iconst_3
    //   123: ldc_w 460
    //   126: aastore
    //   127: aload 7
    //   129: iconst_4
    //   130: ldc_w 471
    //   133: aastore
    //   134: iconst_1
    //   135: anewarray 59	java/lang/String
    //   138: astore 8
    //   140: aload 8
    //   142: iconst_0
    //   143: aload_2
    //   144: aastore
    //   145: aload_1
    //   146: getstatic 474	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   149: aload 7
    //   151: ldc_w 266
    //   154: aload 8
    //   156: aconst_null
    //   157: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore 6
    //   162: aload 6
    //   164: ifnull +16 -> 180
    //   167: aload 6
    //   169: invokeinterface 277 1 0
    //   174: ifne +399 -> 573
    //   177: goto +3 -> 180
    //   180: aload_1
    //   181: getstatic 475	android/provider/MediaStore$Video$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   184: aload 7
    //   186: ldc_w 266
    //   189: aload 8
    //   191: aconst_null
    //   192: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +37 -> 234
    //   200: aload_1
    //   201: invokeinterface 277 1 0
    //   206: istore 5
    //   208: iload 5
    //   210: ifeq +24 -> 234
    //   213: aload_1
    //   214: astore 6
    //   216: goto +357 -> 573
    //   219: astore 6
    //   221: aload_1
    //   222: astore_2
    //   223: aload 6
    //   225: astore_1
    //   226: goto +339 -> 565
    //   229: astore 6
    //   231: goto +283 -> 514
    //   234: iconst_0
    //   235: istore 4
    //   237: aload_1
    //   238: astore 6
    //   240: iload 4
    //   242: ifeq +236 -> 478
    //   245: iload_3
    //   246: ifeq +91 -> 337
    //   249: bipush 7
    //   251: anewarray 59	java/lang/String
    //   254: astore_1
    //   255: aload_1
    //   256: iconst_0
    //   257: aload 6
    //   259: iconst_0
    //   260: invokeinterface 288 2 0
    //   265: aastore
    //   266: aload_1
    //   267: iconst_1
    //   268: aload 6
    //   270: iconst_1
    //   271: invokeinterface 288 2 0
    //   276: aastore
    //   277: aload_1
    //   278: iconst_2
    //   279: aload 6
    //   281: iconst_2
    //   282: invokeinterface 288 2 0
    //   287: aastore
    //   288: aload_1
    //   289: iconst_3
    //   290: aload 6
    //   292: iconst_3
    //   293: invokeinterface 288 2 0
    //   298: aastore
    //   299: aload_1
    //   300: iconst_4
    //   301: aload 6
    //   303: iconst_4
    //   304: invokeinterface 288 2 0
    //   309: aastore
    //   310: aload_1
    //   311: iconst_5
    //   312: aload 6
    //   314: iconst_5
    //   315: invokeinterface 288 2 0
    //   320: aastore
    //   321: aload_1
    //   322: bipush 6
    //   324: aload 6
    //   326: bipush 6
    //   328: invokeinterface 288 2 0
    //   333: aastore
    //   334: goto +73 -> 407
    //   337: bipush 7
    //   339: anewarray 59	java/lang/String
    //   342: astore_1
    //   343: aload_1
    //   344: iconst_0
    //   345: aload 6
    //   347: iconst_0
    //   348: invokeinterface 288 2 0
    //   353: aastore
    //   354: aload_1
    //   355: iconst_1
    //   356: aload 6
    //   358: iconst_1
    //   359: invokeinterface 288 2 0
    //   364: aastore
    //   365: aload_1
    //   366: iconst_2
    //   367: aload 6
    //   369: iconst_2
    //   370: invokeinterface 288 2 0
    //   375: aastore
    //   376: aload_1
    //   377: iconst_3
    //   378: aload 6
    //   380: iconst_3
    //   381: invokeinterface 288 2 0
    //   386: aastore
    //   387: aload_1
    //   388: iconst_4
    //   389: aconst_null
    //   390: aastore
    //   391: aload_1
    //   392: iconst_5
    //   393: aconst_null
    //   394: aastore
    //   395: aload_1
    //   396: bipush 6
    //   398: aload 6
    //   400: iconst_4
    //   401: invokeinterface 288 2 0
    //   406: aastore
    //   407: new 124	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   414: astore 7
    //   416: aload 7
    //   418: aload_2
    //   419: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 7
    //   425: ldc_w 477
    //   428: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 7
    //   434: aload_1
    //   435: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   438: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc 13
    //   444: aload 7
    //   446: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload 6
    //   454: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   457: aload_1
    //   458: areturn
    //   459: astore_1
    //   460: aload 6
    //   462: astore_2
    //   463: goto +102 -> 565
    //   466: astore 7
    //   468: aload 6
    //   470: astore_1
    //   471: aload 7
    //   473: astore 6
    //   475: goto +39 -> 514
    //   478: aload 6
    //   480: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   483: aconst_null
    //   484: areturn
    //   485: astore_1
    //   486: aload 6
    //   488: astore_2
    //   489: goto +76 -> 565
    //   492: astore 7
    //   494: aload 6
    //   496: astore_1
    //   497: aload 7
    //   499: astore 6
    //   501: goto +13 -> 514
    //   504: astore_1
    //   505: aconst_null
    //   506: astore_2
    //   507: goto +58 -> 565
    //   510: astore 6
    //   512: aconst_null
    //   513: astore_1
    //   514: new 124	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   521: astore 7
    //   523: aload 7
    //   525: aload_2
    //   526: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 7
    //   532: ldc_w 479
    //   535: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: ldc 13
    //   541: aload 7
    //   543: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: aload 6
    //   548: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   551: aload_1
    //   552: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   555: goto -72 -> 483
    //   558: astore 6
    //   560: aload_1
    //   561: astore_2
    //   562: aload 6
    //   564: astore_1
    //   565: aload_2
    //   566: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   569: aload_1
    //   570: athrow
    //   571: aconst_null
    //   572: areturn
    //   573: iconst_1
    //   574: istore 4
    //   576: goto -336 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	LocalProcessor
    //   0	579	1	paramContentResolver	android.content.ContentResolver
    //   0	579	2	paramString	String
    //   23	223	3	i	int
    //   235	340	4	j	int
    //   206	3	5	bool	boolean
    //   160	55	6	localObject1	Object
    //   219	5	6	localObject2	Object
    //   229	1	6	localThrowable1	Throwable
    //   238	262	6	localObject3	Object
    //   510	37	6	localThrowable2	Throwable
    //   558	5	6	localObject4	Object
    //   38	407	7	localObject5	Object
    //   466	6	7	localThrowable3	Throwable
    //   492	6	7	localThrowable4	Throwable
    //   521	21	7	localStringBuilder	StringBuilder
    //   138	52	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   200	208	219	finally
    //   200	208	229	java/lang/Throwable
    //   249	334	459	finally
    //   337	387	459	finally
    //   395	407	459	finally
    //   407	452	459	finally
    //   249	334	466	java/lang/Throwable
    //   337	387	466	java/lang/Throwable
    //   395	407	466	java/lang/Throwable
    //   407	452	466	java/lang/Throwable
    //   167	177	485	finally
    //   180	196	485	finally
    //   167	177	492	java/lang/Throwable
    //   180	196	492	java/lang/Throwable
    //   145	162	504	finally
    //   145	162	510	java/lang/Throwable
    //   514	551	558	finally
  }
  
  public void cancelAll()
  {
    this.mHandler.removeMessages(11);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 11)
    {
      processLocalEnsure((UploadJobContext)paramMessage.obj);
      return true;
    }
    return false;
  }
  
  public void processor(UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 11, paramUploadJobContext));
  }
  
  public void release()
  {
    this.mHandler.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.LocalProcessor
 * JD-Core Version:    0.7.0.1
 */