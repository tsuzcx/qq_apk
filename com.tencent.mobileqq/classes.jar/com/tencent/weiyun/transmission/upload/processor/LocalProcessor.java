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
    double d1 = parseDoubleSafely(paramString[0]) / parseDoubleSafely(paramString[1]);
    double d2 = parseDoubleSafely(arrayOfString1[0]) / parseDoubleSafely(arrayOfString1[1]) / 60.0D;
    return parseDoubleSafely(arrayOfString2[0]) / parseDoubleSafely(arrayOfString2[1]) / 3600.0D + (d2 + d1);
  }
  
  private double parseDoubleSafely(String paramString)
  {
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (Throwable paramString) {}
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
        String str1 = localExifInterface.getAttribute("GPSLongitude");
        String str2 = localExifInterface.getAttribute("GPSLatitude");
        String str3 = localExifInterface.getAttribute("GPSLongitudeRef");
        Object localObject2 = localExifInterface.getAttribute("GPSLatitudeRef");
        if (TextUtils.isEmpty(str1)) {
          break label253;
        }
        double d = convert2Degree(str1);
        if (TextUtils.equals(str3, "E"))
        {
          str1 = Double.toString(d);
          if (TextUtils.isEmpty(str2)) {
            break label247;
          }
          d = convert2Degree(str2);
          if (TextUtils.equals((CharSequence)localObject2, "N"))
          {
            str2 = Double.toString(d);
            localObject2 = new String[5];
            localObject2[0] = str1;
            localObject2[1] = str2;
            localObject2[2] = localExifInterface.getAttribute("DateTime");
            localObject2[3] = localExifInterface.getAttribute("ImageWidth");
            localObject2[4] = localExifInterface.getAttribute("ImageLength");
            TsLog.d("UploadLocalProcessor", paramString + " parseExif success:" + Arrays.toString((Object[])localObject2));
            return localObject2;
          }
        }
        else
        {
          d = 0.0D - d;
          continue;
        }
        d = 0.0D - d;
        continue;
        str2 = null;
      }
      catch (Throwable localThrowable)
      {
        TsLog.e("UploadLocalProcessor", paramString + " parseExif failed.", localThrowable);
        return null;
      }
      label247:
      continue;
      label253:
      Object localObject1 = null;
    }
  }
  
  private int parseIntSafely(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return 0;
  }
  
  private long parseLongSafely(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
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
    //   45: ifeq +32 -> 77
    //   48: iconst_0
    //   49: istore_2
    //   50: aload 5
    //   52: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifeq +31 -> 86
    //   58: iconst_0
    //   59: istore_3
    //   60: aload 4
    //   62: invokevirtual 183	android/media/MediaMetadataRetriever:release	()V
    //   65: iconst_2
    //   66: newarray int
    //   68: dup
    //   69: iconst_0
    //   70: iload_2
    //   71: iastore
    //   72: dup
    //   73: iconst_1
    //   74: iload_3
    //   75: iastore
    //   76: areturn
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   82: istore_2
    //   83: goto -33 -> 50
    //   86: aload_0
    //   87: aload 5
    //   89: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   92: istore_3
    //   93: goto -33 -> 60
    //   96: astore_1
    //   97: ldc 13
    //   99: ldc 187
    //   101: aload_1
    //   102: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload 4
    //   107: invokevirtual 183	android/media/MediaMetadataRetriever:release	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 183	android/media/MediaMetadataRetriever:release	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	LocalProcessor
    //   0	120	1	paramString	String
    //   49	34	2	i	int
    //   59	34	3	j	int
    //   16	98	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   39	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   18	48	96	java/lang/Throwable
    //   50	58	96	java/lang/Throwable
    //   77	83	96	java/lang/Throwable
    //   86	93	96	java/lang/Throwable
    //   18	48	112	finally
    //   50	58	112	finally
    //   77	83	112	finally
    //   86	93	112	finally
    //   97	105	112	finally
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
    //   9: ifne -5 -> 4
    //   12: new 198	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   20: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   23: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 16
    //   28: aload 16
    //   30: invokevirtual 211	java/io/File:exists	()Z
    //   33: istore 5
    //   35: aload 16
    //   37: invokevirtual 214	java/io/File:isDirectory	()Z
    //   40: ifne +1022 -> 1062
    //   43: iconst_1
    //   44: istore 4
    //   46: iload 5
    //   48: ifeq +989 -> 1037
    //   51: iload 4
    //   53: ifeq +984 -> 1037
    //   56: aload_1
    //   57: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   60: astore 17
    //   62: aload 17
    //   64: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   67: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +1722 -> 1792
    //   73: new 198	java/io/File
    //   76: dup
    //   77: aload 17
    //   79: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   82: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore 12
    //   87: aload 12
    //   89: invokevirtual 211	java/io/File:exists	()Z
    //   92: istore_3
    //   93: iload_3
    //   94: ifne +974 -> 1068
    //   97: aload 17
    //   99: aconst_null
    //   100: putfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   103: aload 17
    //   105: aconst_null
    //   106: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   109: aload 17
    //   111: aconst_null
    //   112: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   115: aload 17
    //   117: lconst_0
    //   118: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   121: aload 16
    //   123: invokevirtual 231	java/io/File:lastModified	()J
    //   126: lstore 6
    //   128: aload 16
    //   130: invokevirtual 234	java/io/File:length	()J
    //   133: lstore 8
    //   135: aload 17
    //   137: getfield 236	com/tencent/weiyun/transmission/upload/UploadFile:lastModified	J
    //   140: lload 6
    //   142: lcmp
    //   143: ifne +22 -> 165
    //   146: aload 17
    //   148: getfield 239	com/tencent/weiyun/transmission/upload/UploadFile:fileSize	J
    //   151: lload 8
    //   153: lcmp
    //   154: ifne +11 -> 165
    //   157: aload 17
    //   159: getfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   162: ifnonnull +1625 -> 1787
    //   165: aload 17
    //   167: aload 16
    //   169: invokevirtual 231	java/io/File:lastModified	()J
    //   172: putfield 236	com/tencent/weiyun/transmission/upload/UploadFile:lastModified	J
    //   175: aload 17
    //   177: aload 16
    //   179: invokevirtual 245	java/io/File:getName	()Ljava/lang/String;
    //   182: putfield 248	com/tencent/weiyun/transmission/upload/UploadFile:fileName	Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 43	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:mContext	Landroid/content/Context;
    //   189: invokevirtual 254	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   192: astore 18
    //   194: aconst_null
    //   195: astore 13
    //   197: iconst_1
    //   198: anewarray 59	java/lang/String
    //   201: astore 14
    //   203: aload 14
    //   205: iconst_0
    //   206: ldc_w 256
    //   209: aastore
    //   210: iconst_1
    //   211: anewarray 59	java/lang/String
    //   214: astore 15
    //   216: aload 15
    //   218: iconst_0
    //   219: aload 17
    //   221: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   224: aastore
    //   225: aload 18
    //   227: ldc_w 258
    //   230: invokestatic 264	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   233: aload 14
    //   235: ldc_w 266
    //   238: aload 15
    //   240: aconst_null
    //   241: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   244: astore 12
    //   246: aload 12
    //   248: ifnull +17 -> 265
    //   251: aload 12
    //   253: astore 13
    //   255: aload 12
    //   257: invokeinterface 277 1 0
    //   262: ifne +819 -> 1081
    //   265: aload 12
    //   267: astore 13
    //   269: aload 12
    //   271: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   274: aload 12
    //   276: astore 13
    //   278: aload 18
    //   280: ldc_w 285
    //   283: invokestatic 264	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   286: aload 14
    //   288: ldc_w 266
    //   291: aload 15
    //   293: aconst_null
    //   294: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   297: astore 14
    //   299: aload 14
    //   301: astore 13
    //   303: aload 13
    //   305: ifnull +1477 -> 1782
    //   308: aload 13
    //   310: astore 12
    //   312: aload 13
    //   314: astore 14
    //   316: aload 13
    //   318: invokeinterface 277 1 0
    //   323: ifeq +1459 -> 1782
    //   326: iconst_1
    //   327: istore_2
    //   328: iload_2
    //   329: ifeq +1447 -> 1776
    //   332: aload 13
    //   334: astore 12
    //   336: aload 13
    //   338: astore 14
    //   340: aload 13
    //   342: iconst_0
    //   343: invokeinterface 288 2 0
    //   348: astore 15
    //   350: aload 15
    //   352: astore 12
    //   354: aload 13
    //   356: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   359: aload 12
    //   361: ifnonnull +764 -> 1125
    //   364: ldc_w 290
    //   367: astore 12
    //   369: aload 17
    //   371: aload 12
    //   373: putfield 293	com/tencent/weiyun/transmission/upload/UploadFile:mimeType	Ljava/lang/String;
    //   376: aload 12
    //   378: ldc_w 295
    //   381: invokevirtual 299	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   384: ifeq +795 -> 1179
    //   387: lconst_0
    //   388: lstore 10
    //   390: aload_0
    //   391: aload 18
    //   393: aload 17
    //   395: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   398: invokespecial 303	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryImageInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   401: astore 13
    //   403: lload 10
    //   405: lstore 6
    //   407: aload 13
    //   409: ifnull +137 -> 546
    //   412: aload 13
    //   414: iconst_0
    //   415: aaload
    //   416: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   419: ifne +16 -> 435
    //   422: aload 17
    //   424: aload_0
    //   425: aload 13
    //   427: iconst_0
    //   428: aaload
    //   429: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   432: putfield 307	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   435: aload 13
    //   437: iconst_1
    //   438: aaload
    //   439: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   442: ifne +16 -> 458
    //   445: aload 17
    //   447: aload_0
    //   448: aload 13
    //   450: iconst_1
    //   451: aaload
    //   452: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   455: putfield 310	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   458: lload 10
    //   460: lstore 8
    //   462: aload 13
    //   464: iconst_2
    //   465: aaload
    //   466: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifne +23 -> 492
    //   472: aload 13
    //   474: iconst_2
    //   475: aaload
    //   476: invokestatic 313	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +656 -> 1135
    //   482: aload_0
    //   483: aload 13
    //   485: iconst_2
    //   486: aaload
    //   487: invokespecial 315	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   490: lstore 8
    //   492: aload 13
    //   494: iconst_4
    //   495: aaload
    //   496: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   499: ifne +16 -> 515
    //   502: aload 17
    //   504: aload_0
    //   505: aload 13
    //   507: iconst_4
    //   508: aaload
    //   509: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   512: putfield 318	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   515: lload 8
    //   517: lstore 6
    //   519: aload 13
    //   521: iconst_5
    //   522: aaload
    //   523: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifne +20 -> 546
    //   529: aload 17
    //   531: aload_0
    //   532: aload 13
    //   534: iconst_5
    //   535: aaload
    //   536: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   539: putfield 321	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   542: lload 8
    //   544: lstore 6
    //   546: lload 6
    //   548: lstore 10
    //   550: aload 12
    //   552: ldc_w 323
    //   555: invokevirtual 326	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   558: ifeq +196 -> 754
    //   561: aload_0
    //   562: aload 17
    //   564: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   567: invokespecial 328	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseExif	(Ljava/lang/String;)[Ljava/lang/String;
    //   570: astore 12
    //   572: lload 6
    //   574: lstore 10
    //   576: aload 12
    //   578: ifnull +176 -> 754
    //   581: aload 12
    //   583: iconst_0
    //   584: aaload
    //   585: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   588: ifne +16 -> 604
    //   591: aload 17
    //   593: aload_0
    //   594: aload 12
    //   596: iconst_0
    //   597: aaload
    //   598: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   601: putfield 307	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   604: aload 12
    //   606: iconst_1
    //   607: aaload
    //   608: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   611: ifne +16 -> 627
    //   614: aload 17
    //   616: aload_0
    //   617: aload 12
    //   619: iconst_1
    //   620: aaload
    //   621: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   624: putfield 310	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   627: lload 6
    //   629: lstore 8
    //   631: aload 12
    //   633: iconst_2
    //   634: aaload
    //   635: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   638: ifne +62 -> 700
    //   641: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   644: aload 12
    //   646: iconst_2
    //   647: aaload
    //   648: new 330	java/text/ParsePosition
    //   651: dup
    //   652: iconst_0
    //   653: invokespecial 333	java/text/ParsePosition:<init>	(I)V
    //   656: invokevirtual 337	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   659: astore 14
    //   661: lload 6
    //   663: lstore 8
    //   665: aload 14
    //   667: ifnull +33 -> 700
    //   670: aload 14
    //   672: invokevirtual 342	java/util/Date:getTime	()J
    //   675: lstore 10
    //   677: lload 6
    //   679: lstore 8
    //   681: lload 10
    //   683: lload 6
    //   685: lsub
    //   686: invokestatic 348	java/lang/Math:abs	(J)J
    //   689: ldc2_w 16
    //   692: lcmp
    //   693: ifle +7 -> 700
    //   696: lload 10
    //   698: lstore 8
    //   700: aload 12
    //   702: iconst_3
    //   703: aaload
    //   704: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   707: ifne +16 -> 723
    //   710: aload 17
    //   712: aload_0
    //   713: aload 12
    //   715: iconst_3
    //   716: aaload
    //   717: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   720: putfield 318	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   723: lload 8
    //   725: lstore 10
    //   727: aload 12
    //   729: iconst_4
    //   730: aaload
    //   731: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   734: ifne +20 -> 754
    //   737: aload 17
    //   739: aload_0
    //   740: aload 12
    //   742: iconst_4
    //   743: aaload
    //   744: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   747: putfield 321	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   750: lload 8
    //   752: lstore 10
    //   754: lload 10
    //   756: lstore 6
    //   758: lload 10
    //   760: lconst_0
    //   761: lcmp
    //   762: ifgt +74 -> 836
    //   765: lload 10
    //   767: lstore 6
    //   769: aload 13
    //   771: ifnull +65 -> 836
    //   774: lload 10
    //   776: lstore 6
    //   778: aload 13
    //   780: iconst_3
    //   781: aaload
    //   782: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   785: ifne +51 -> 836
    //   788: aload 13
    //   790: iconst_3
    //   791: aaload
    //   792: invokevirtual 351	java/lang/String:trim	()Ljava/lang/String;
    //   795: astore 12
    //   797: aload_0
    //   798: aload 12
    //   800: invokespecial 315	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   803: lstore 6
    //   805: aload 12
    //   807: invokevirtual 354	java/lang/String:length	()I
    //   810: bipush 8
    //   812: if_icmple +362 -> 1174
    //   815: aload 12
    //   817: invokevirtual 354	java/lang/String:length	()I
    //   820: bipush 10
    //   822: if_icmpgt +352 -> 1174
    //   825: sipush 1000
    //   828: istore_2
    //   829: iload_2
    //   830: i2l
    //   831: lload 6
    //   833: lmul
    //   834: lstore 6
    //   836: aload 17
    //   838: lload 6
    //   840: putfield 357	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   843: iconst_1
    //   844: istore_2
    //   845: iload_3
    //   846: ifeq +58 -> 904
    //   849: iload_2
    //   850: ifeq +761 -> 1611
    //   853: aload 17
    //   855: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   858: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   861: ifne +19 -> 880
    //   864: new 198	java/io/File
    //   867: dup
    //   868: aload 17
    //   870: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   873: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   876: iconst_0
    //   877: invokestatic 361	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   880: aload 17
    //   882: aconst_null
    //   883: putfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   886: aload 17
    //   888: aconst_null
    //   889: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   892: aload 17
    //   894: aconst_null
    //   895: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   898: aload 17
    //   900: lconst_0
    //   901: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   904: iload_2
    //   905: ifne +24 -> 929
    //   908: aload 17
    //   910: getfield 364	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   913: ifnull +12 -> 925
    //   916: aload 17
    //   918: getfield 364	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   921: arraylength
    //   922: ifgt +105 -> 1027
    //   925: iload_3
    //   926: ifne +101 -> 1027
    //   929: aload_1
    //   930: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   933: invokevirtual 373	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   936: aload 16
    //   938: invokevirtual 376	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   941: aload_1
    //   942: invokevirtual 380	com/tencent/weiyun/transmission/upload/UploadJobContext:getCanceledFlag	()Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;
    //   945: invokestatic 386	com/tencent/weiyun/transmission/upload/UploadHelper:calSliceSha1	(Ljava/lang/String;Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;)[Ljava/lang/String;
    //   948: astore 13
    //   950: aload_1
    //   951: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   954: invokevirtual 389	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   957: aload_1
    //   958: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   961: ifne -957 -> 4
    //   964: aload 13
    //   966: ifnull +9 -> 975
    //   969: aload 13
    //   971: arraylength
    //   972: ifgt +765 -> 1737
    //   975: aconst_null
    //   976: astore 12
    //   978: aload 17
    //   980: aload 12
    //   982: putfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   985: aload 17
    //   987: aload 13
    //   989: putfield 364	com/tencent/weiyun/transmission/upload/UploadFile:sliceSha	[Ljava/lang/String;
    //   992: aload 17
    //   994: getfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   997: ifnonnull +30 -> 1027
    //   1000: aload_1
    //   1001: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1004: invokevirtual 373	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1007: aload 17
    //   1009: aload 16
    //   1011: invokevirtual 376	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1014: invokestatic 392	com/tencent/weiyun/utils/IOUtils:getFileSha1	(Ljava/lang/String;)Ljava/lang/String;
    //   1017: putfield 242	com/tencent/weiyun/transmission/upload/UploadFile:sha	Ljava/lang/String;
    //   1020: aload_1
    //   1021: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1024: invokevirtual 389	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1027: aload 17
    //   1029: aload 16
    //   1031: invokevirtual 234	java/io/File:length	()J
    //   1034: putfield 239	com/tencent/weiyun/transmission/upload/UploadFile:fileSize	J
    //   1037: aload_1
    //   1038: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   1041: ifne -1037 -> 4
    //   1044: aload_0
    //   1045: getfield 45	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:mCallback	Lcom/tencent/weiyun/transmission/upload/processor/LocalProcessor$LocalProcessorCallback;
    //   1048: aload_1
    //   1049: invokevirtual 395	com/tencent/weiyun/transmission/upload/UploadJobContext:dbId	()J
    //   1052: iload 5
    //   1054: iload 4
    //   1056: invokeinterface 401 5 0
    //   1061: return
    //   1062: iconst_0
    //   1063: istore 4
    //   1065: goto -1019 -> 46
    //   1068: aload 17
    //   1070: aload 12
    //   1072: invokevirtual 234	java/io/File:length	()J
    //   1075: putfield 227	com/tencent/weiyun/transmission/upload/UploadFile:compressedSize	J
    //   1078: goto -957 -> 121
    //   1081: iconst_1
    //   1082: istore_2
    //   1083: aload 12
    //   1085: astore 13
    //   1087: goto -759 -> 328
    //   1090: astore 15
    //   1092: aconst_null
    //   1093: astore 13
    //   1095: aload 13
    //   1097: astore 12
    //   1099: ldc 13
    //   1101: aload 15
    //   1103: invokestatic 404	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1106: aload 13
    //   1108: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   1111: aconst_null
    //   1112: astore 12
    //   1114: goto -755 -> 359
    //   1117: astore_1
    //   1118: aload 13
    //   1120: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   1123: aload_1
    //   1124: athrow
    //   1125: aload 12
    //   1127: invokevirtual 407	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1130: astore 12
    //   1132: goto -763 -> 369
    //   1135: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   1138: aload 13
    //   1140: iconst_2
    //   1141: aaload
    //   1142: new 330	java/text/ParsePosition
    //   1145: dup
    //   1146: iconst_0
    //   1147: invokespecial 333	java/text/ParsePosition:<init>	(I)V
    //   1150: invokevirtual 337	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   1153: astore 14
    //   1155: lload 10
    //   1157: lstore 8
    //   1159: aload 14
    //   1161: ifnull -669 -> 492
    //   1164: aload 14
    //   1166: invokevirtual 342	java/util/Date:getTime	()J
    //   1169: lstore 8
    //   1171: goto -679 -> 492
    //   1174: iconst_1
    //   1175: istore_2
    //   1176: goto -347 -> 829
    //   1179: aload 12
    //   1181: ldc_w 409
    //   1184: invokevirtual 299	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1187: ifeq +352 -> 1539
    //   1190: aload_0
    //   1191: aload 18
    //   1193: aload 17
    //   1195: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1198: invokespecial 412	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryVideoInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   1201: astore 12
    //   1203: aload 12
    //   1205: ifnull +153 -> 1358
    //   1208: aload 12
    //   1210: iconst_0
    //   1211: aaload
    //   1212: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1215: ifne +16 -> 1231
    //   1218: aload 17
    //   1220: aload_0
    //   1221: aload 12
    //   1223: iconst_0
    //   1224: aaload
    //   1225: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   1228: putfield 307	com/tencent/weiyun/transmission/upload/UploadFile:longitude	D
    //   1231: aload 12
    //   1233: iconst_1
    //   1234: aaload
    //   1235: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1238: ifne +16 -> 1254
    //   1241: aload 17
    //   1243: aload_0
    //   1244: aload 12
    //   1246: iconst_1
    //   1247: aaload
    //   1248: invokespecial 68	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseDoubleSafely	(Ljava/lang/String;)D
    //   1251: putfield 310	com/tencent/weiyun/transmission/upload/UploadFile:latitude	D
    //   1254: aload 12
    //   1256: iconst_2
    //   1257: aaload
    //   1258: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1261: ifne +204 -> 1465
    //   1264: aload 12
    //   1266: iconst_2
    //   1267: aaload
    //   1268: invokestatic 313	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   1271: ifeq +156 -> 1427
    //   1274: aload 17
    //   1276: aload_0
    //   1277: aload 12
    //   1279: iconst_2
    //   1280: aaload
    //   1281: invokespecial 315	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1284: putfield 357	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1287: aload 12
    //   1289: iconst_4
    //   1290: aaload
    //   1291: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1294: ifne +16 -> 1310
    //   1297: aload 17
    //   1299: aload_0
    //   1300: aload 12
    //   1302: iconst_4
    //   1303: aaload
    //   1304: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   1307: putfield 318	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1310: aload 12
    //   1312: iconst_5
    //   1313: aaload
    //   1314: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1317: ifne +16 -> 1333
    //   1320: aload 17
    //   1322: aload_0
    //   1323: aload 12
    //   1325: iconst_5
    //   1326: aaload
    //   1327: invokespecial 185	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   1330: putfield 321	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1333: aload 12
    //   1335: bipush 6
    //   1337: aaload
    //   1338: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1341: ifne +17 -> 1358
    //   1344: aload 17
    //   1346: aload_0
    //   1347: aload 12
    //   1349: bipush 6
    //   1351: aaload
    //   1352: invokespecial 315	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1355: putfield 415	com/tencent/weiyun/transmission/upload/UploadFile:duration	J
    //   1358: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1361: bipush 14
    //   1363: if_icmplt +171 -> 1534
    //   1366: iconst_1
    //   1367: istore_2
    //   1368: aload 17
    //   1370: getfield 318	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1373: ifne +49 -> 1422
    //   1376: aload 17
    //   1378: getfield 321	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1381: ifne +41 -> 1422
    //   1384: iload_2
    //   1385: ifeq +37 -> 1422
    //   1388: aload_0
    //   1389: aload 17
    //   1391: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1394: invokespecial 422	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseVideoSizes	(Ljava/lang/String;)[I
    //   1397: astore 12
    //   1399: aload 12
    //   1401: ifnull +21 -> 1422
    //   1404: aload 17
    //   1406: aload 12
    //   1408: iconst_0
    //   1409: iaload
    //   1410: putfield 318	com/tencent/weiyun/transmission/upload/UploadFile:width	I
    //   1413: aload 17
    //   1415: aload 12
    //   1417: iconst_1
    //   1418: iaload
    //   1419: putfield 321	com/tencent/weiyun/transmission/upload/UploadFile:height	I
    //   1422: iconst_1
    //   1423: istore_2
    //   1424: goto -579 -> 845
    //   1427: getstatic 37	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:sFormatter	Ljava/text/SimpleDateFormat;
    //   1430: aload 12
    //   1432: iconst_2
    //   1433: aaload
    //   1434: new 330	java/text/ParsePosition
    //   1437: dup
    //   1438: iconst_0
    //   1439: invokespecial 333	java/text/ParsePosition:<init>	(I)V
    //   1442: invokevirtual 337	java/text/SimpleDateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   1445: astore 13
    //   1447: aload 13
    //   1449: ifnull -162 -> 1287
    //   1452: aload 17
    //   1454: aload 13
    //   1456: invokevirtual 342	java/util/Date:getTime	()J
    //   1459: putfield 357	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1462: goto -175 -> 1287
    //   1465: aload 12
    //   1467: iconst_3
    //   1468: aaload
    //   1469: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1472: ifne -185 -> 1287
    //   1475: aload 12
    //   1477: iconst_3
    //   1478: aaload
    //   1479: invokevirtual 351	java/lang/String:trim	()Ljava/lang/String;
    //   1482: astore 13
    //   1484: aload_0
    //   1485: aload 13
    //   1487: invokespecial 315	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseLongSafely	(Ljava/lang/String;)J
    //   1490: lstore 6
    //   1492: aload 13
    //   1494: invokevirtual 354	java/lang/String:length	()I
    //   1497: bipush 8
    //   1499: if_icmple +30 -> 1529
    //   1502: aload 13
    //   1504: invokevirtual 354	java/lang/String:length	()I
    //   1507: bipush 10
    //   1509: if_icmpgt +20 -> 1529
    //   1512: sipush 1000
    //   1515: istore_2
    //   1516: aload 17
    //   1518: lload 6
    //   1520: iload_2
    //   1521: i2l
    //   1522: lmul
    //   1523: putfield 357	com/tencent/weiyun/transmission/upload/UploadFile:takenTime	J
    //   1526: goto -239 -> 1287
    //   1529: iconst_1
    //   1530: istore_2
    //   1531: goto -15 -> 1516
    //   1534: iconst_0
    //   1535: istore_2
    //   1536: goto -168 -> 1368
    //   1539: aload 12
    //   1541: ldc_w 424
    //   1544: invokevirtual 299	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1547: ifeq +59 -> 1606
    //   1550: aload_0
    //   1551: aload 18
    //   1553: aload 17
    //   1555: getfield 207	com/tencent/weiyun/transmission/upload/UploadFile:localPath	Ljava/lang/String;
    //   1558: invokespecial 427	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:queryAudioInfo	(Landroid/content/ContentResolver;Ljava/lang/String;)[Ljava/lang/String;
    //   1561: astore 12
    //   1563: aload 12
    //   1565: ifnull +41 -> 1606
    //   1568: aload 12
    //   1570: iconst_0
    //   1571: aaload
    //   1572: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1575: ifne +12 -> 1587
    //   1578: aload 17
    //   1580: aload 12
    //   1582: iconst_0
    //   1583: aaload
    //   1584: putfield 430	com/tencent/weiyun/transmission/upload/UploadFile:album	Ljava/lang/String;
    //   1587: aload 12
    //   1589: iconst_1
    //   1590: aaload
    //   1591: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1594: ifne +12 -> 1606
    //   1597: aload 17
    //   1599: aload 12
    //   1601: iconst_1
    //   1602: aaload
    //   1603: putfield 433	com/tencent/weiyun/transmission/upload/UploadFile:artist	Ljava/lang/String;
    //   1606: iconst_1
    //   1607: istore_2
    //   1608: goto -763 -> 845
    //   1611: aload_1
    //   1612: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1615: invokevirtual 373	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1618: aload 17
    //   1620: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1623: aload_1
    //   1624: invokevirtual 380	com/tencent/weiyun/transmission/upload/UploadJobContext:getCanceledFlag	()Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;
    //   1627: invokestatic 386	com/tencent/weiyun/transmission/upload/UploadHelper:calSliceSha1	(Ljava/lang/String;Lcom/tencent/weiyun/uploader/xplatform/UploadNative$CanceledFlag;)[Ljava/lang/String;
    //   1630: astore 13
    //   1632: aload_1
    //   1633: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1636: invokevirtual 389	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1639: aload_1
    //   1640: invokevirtual 196	com/tencent/weiyun/transmission/upload/UploadJobContext:isCanceled	()Z
    //   1643: ifne -1639 -> 4
    //   1646: aload_1
    //   1647: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1650: astore 14
    //   1652: aload 13
    //   1654: ifnull +9 -> 1663
    //   1657: aload 13
    //   1659: arraylength
    //   1660: ifgt +64 -> 1724
    //   1663: aconst_null
    //   1664: astore 12
    //   1666: aload 14
    //   1668: aload 12
    //   1670: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1673: aload_1
    //   1674: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1677: aload 13
    //   1679: putfield 224	com/tencent/weiyun/transmission/upload/UploadFile:compressedSliceSha	[Ljava/lang/String;
    //   1682: aload_1
    //   1683: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1686: getfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1689: ifnonnull -785 -> 904
    //   1692: aload_1
    //   1693: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1696: invokevirtual 373	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaStart	()V
    //   1699: aload_1
    //   1700: invokevirtual 202	com/tencent/weiyun/transmission/upload/UploadJobContext:file	()Lcom/tencent/weiyun/transmission/upload/UploadFile;
    //   1703: aload 17
    //   1705: getfield 217	com/tencent/weiyun/transmission/upload/UploadFile:compressedPath	Ljava/lang/String;
    //   1708: invokestatic 392	com/tencent/weiyun/utils/IOUtils:getFileSha1	(Ljava/lang/String;)Ljava/lang/String;
    //   1711: putfield 220	com/tencent/weiyun/transmission/upload/UploadFile:compressedSha	Ljava/lang/String;
    //   1714: aload_1
    //   1715: invokevirtual 368	com/tencent/weiyun/transmission/upload/UploadJobContext:statisticsTimes	()Lcom/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes;
    //   1718: invokevirtual 389	com/tencent/weiyun/transmission/upload/UploadJobContext$StatisticsTimes:onCalShaEnd	()V
    //   1721: goto -817 -> 904
    //   1724: aload 13
    //   1726: aload 13
    //   1728: arraylength
    //   1729: iconst_1
    //   1730: isub
    //   1731: aaload
    //   1732: astore 12
    //   1734: goto -68 -> 1666
    //   1737: aload 13
    //   1739: aload 13
    //   1741: arraylength
    //   1742: iconst_1
    //   1743: isub
    //   1744: aaload
    //   1745: astore 12
    //   1747: goto -769 -> 978
    //   1750: astore_1
    //   1751: aload 12
    //   1753: astore 13
    //   1755: goto -637 -> 1118
    //   1758: astore 15
    //   1760: aload 12
    //   1762: astore 13
    //   1764: goto -669 -> 1095
    //   1767: astore 15
    //   1769: aload 14
    //   1771: astore 13
    //   1773: goto -678 -> 1095
    //   1776: aconst_null
    //   1777: astore 12
    //   1779: goto -1425 -> 354
    //   1782: iconst_0
    //   1783: istore_2
    //   1784: goto -1456 -> 328
    //   1787: iconst_0
    //   1788: istore_2
    //   1789: goto -944 -> 845
    //   1792: iconst_0
    //   1793: istore_3
    //   1794: goto -1673 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1797	0	this	LocalProcessor
    //   0	1797	1	paramUploadJobContext	UploadJobContext
    //   327	1462	2	i	int
    //   92	1702	3	bool1	boolean
    //   44	1020	4	bool2	boolean
    //   33	1020	5	bool3	boolean
    //   126	1393	6	l1	long
    //   133	1037	8	l2	long
    //   388	768	10	l3	long
    //   85	1693	12	localObject1	Object
    //   195	1577	13	localObject2	Object
    //   201	1569	14	localObject3	Object
    //   214	137	15	localObject4	Object
    //   1090	12	15	localThrowable1	Throwable
    //   1758	1	15	localThrowable2	Throwable
    //   1767	1	15	localThrowable3	Throwable
    //   26	1004	16	localFile	java.io.File
    //   60	1644	17	localUploadFile	com.tencent.weiyun.transmission.upload.UploadFile
    //   192	1360	18	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   225	246	1090	java/lang/Throwable
    //   225	246	1117	finally
    //   255	265	1117	finally
    //   269	274	1117	finally
    //   278	299	1117	finally
    //   316	326	1750	finally
    //   340	350	1750	finally
    //   1099	1106	1750	finally
    //   255	265	1758	java/lang/Throwable
    //   269	274	1758	java/lang/Throwable
    //   278	299	1758	java/lang/Throwable
    //   316	326	1767	java/lang/Throwable
    //   340	350	1767	java/lang/Throwable
  }
  
  /* Error */
  private String[] queryAudioInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: iconst_2
    //   14: anewarray 59	java/lang/String
    //   17: astore 5
    //   19: aload 5
    //   21: iconst_0
    //   22: ldc_w 434
    //   25: aastore
    //   26: aload 5
    //   28: iconst_1
    //   29: ldc_w 435
    //   32: aastore
    //   33: iconst_1
    //   34: anewarray 59	java/lang/String
    //   37: astore 6
    //   39: aload 6
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: aload_1
    //   45: getstatic 441	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   48: aload 5
    //   50: ldc_w 266
    //   53: aload 6
    //   55: aconst_null
    //   56: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +13 -> 76
    //   66: aload 4
    //   68: invokeinterface 277 1 0
    //   73: ifne +149 -> 222
    //   76: aload_1
    //   77: getstatic 444	android/provider/MediaStore$Audio$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   80: aload 5
    //   82: ldc_w 266
    //   85: aload 6
    //   87: aconst_null
    //   88: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore_1
    //   92: aload_1
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +214 -> 311
    //   100: aload 4
    //   102: astore_1
    //   103: aload 4
    //   105: astore 5
    //   107: aload 4
    //   109: invokeinterface 277 1 0
    //   114: ifeq +197 -> 311
    //   117: iconst_1
    //   118: istore_3
    //   119: iload_3
    //   120: ifeq +107 -> 227
    //   123: aload 4
    //   125: astore_1
    //   126: aload 4
    //   128: astore 5
    //   130: iconst_2
    //   131: anewarray 59	java/lang/String
    //   134: astore 6
    //   136: aload 4
    //   138: astore_1
    //   139: aload 4
    //   141: astore 5
    //   143: aload 6
    //   145: iconst_0
    //   146: aload 4
    //   148: iconst_0
    //   149: invokeinterface 288 2 0
    //   154: aastore
    //   155: aload 4
    //   157: astore_1
    //   158: aload 4
    //   160: astore 5
    //   162: aload 6
    //   164: iconst_1
    //   165: aload 4
    //   167: iconst_1
    //   168: invokeinterface 288 2 0
    //   173: aastore
    //   174: aload 4
    //   176: astore_1
    //   177: aload 4
    //   179: astore 5
    //   181: ldc 13
    //   183: new 124	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   190: aload_2
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 446
    //   197: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 6
    //   202: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload 4
    //   216: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   219: aload 6
    //   221: areturn
    //   222: iconst_1
    //   223: istore_3
    //   224: goto -105 -> 119
    //   227: aload 4
    //   229: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore 6
    //   236: aconst_null
    //   237: astore 4
    //   239: aload 4
    //   241: astore_1
    //   242: ldc 13
    //   244: new 124	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   251: aload_2
    //   252: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 448
    //   258: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: aload 6
    //   266: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload 4
    //   271: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   274: goto -42 -> 232
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   284: aload_2
    //   285: athrow
    //   286: astore_2
    //   287: aload 4
    //   289: astore_1
    //   290: goto -10 -> 280
    //   293: astore_2
    //   294: goto -14 -> 280
    //   297: astore 6
    //   299: goto -60 -> 239
    //   302: astore 6
    //   304: aload 5
    //   306: astore 4
    //   308: goto -69 -> 239
    //   311: iconst_0
    //   312: istore_3
    //   313: goto -194 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	LocalProcessor
    //   0	316	1	paramContentResolver	android.content.ContentResolver
    //   0	316	2	paramString	String
    //   118	195	3	i	int
    //   59	248	4	localObject1	Object
    //   17	288	5	localObject2	Object
    //   37	183	6	arrayOfString	String[]
    //   234	31	6	localThrowable1	Throwable
    //   297	1	6	localThrowable2	Throwable
    //   302	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	61	234	java/lang/Throwable
    //   44	61	277	finally
    //   66	76	286	finally
    //   76	92	286	finally
    //   107	117	293	finally
    //   130	136	293	finally
    //   143	155	293	finally
    //   162	174	293	finally
    //   181	214	293	finally
    //   242	269	293	finally
    //   66	76	297	java/lang/Throwable
    //   76	92	297	java/lang/Throwable
    //   107	117	302	java/lang/Throwable
    //   130	136	302	java/lang/Throwable
    //   143	155	302	java/lang/Throwable
    //   162	174	302	java/lang/Throwable
    //   181	214	302	java/lang/Throwable
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private String[] queryImageInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 16
    //   18: if_icmplt +365 -> 383
    //   21: iconst_1
    //   22: istore 4
    //   24: iload 4
    //   26: ifne +605 -> 631
    //   29: aload_2
    //   30: invokestatic 452	com/tencent/weiyun/utils/IOUtils:getImageWidthHeight	(Ljava/lang/String;)[I
    //   33: astore 5
    //   35: aload 5
    //   37: ifnull +594 -> 631
    //   40: aload 5
    //   42: iconst_0
    //   43: iaload
    //   44: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   47: astore 8
    //   49: aload 5
    //   51: iconst_1
    //   52: iaload
    //   53: invokestatic 454	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   56: astore 7
    //   58: iload 4
    //   60: ifeq +329 -> 389
    //   63: bipush 6
    //   65: anewarray 59	java/lang/String
    //   68: astore 6
    //   70: aload 6
    //   72: iconst_0
    //   73: ldc_w 455
    //   76: aastore
    //   77: aload 6
    //   79: iconst_1
    //   80: ldc_w 456
    //   83: aastore
    //   84: aload 6
    //   86: iconst_2
    //   87: ldc_w 458
    //   90: aastore
    //   91: aload 6
    //   93: iconst_3
    //   94: ldc_w 460
    //   97: aastore
    //   98: aload 6
    //   100: iconst_4
    //   101: ldc_w 461
    //   104: aastore
    //   105: aload 6
    //   107: iconst_5
    //   108: ldc_w 462
    //   111: aastore
    //   112: iconst_1
    //   113: anewarray 59	java/lang/String
    //   116: astore 9
    //   118: aload 9
    //   120: iconst_0
    //   121: aload_2
    //   122: aastore
    //   123: aload_1
    //   124: getstatic 465	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   127: aload 6
    //   129: ldc_w 266
    //   132: aload 9
    //   134: aconst_null
    //   135: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   138: astore 5
    //   140: aload 5
    //   142: ifnull +13 -> 155
    //   145: aload 5
    //   147: invokeinterface 277 1 0
    //   152: ifne +274 -> 426
    //   155: aload_1
    //   156: getstatic 466	android/provider/MediaStore$Images$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   159: aload 6
    //   161: ldc_w 266
    //   164: aload 9
    //   166: aconst_null
    //   167: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   170: astore_1
    //   171: aload_1
    //   172: astore 5
    //   174: aload 5
    //   176: ifnull +450 -> 626
    //   179: aload 5
    //   181: astore 6
    //   183: aload 5
    //   185: astore_1
    //   186: aload 5
    //   188: invokeinterface 277 1 0
    //   193: ifeq +433 -> 626
    //   196: iconst_1
    //   197: istore_3
    //   198: iload_3
    //   199: ifeq +386 -> 585
    //   202: iload 4
    //   204: ifeq +227 -> 431
    //   207: aload 5
    //   209: astore 6
    //   211: aload 5
    //   213: astore_1
    //   214: bipush 6
    //   216: anewarray 59	java/lang/String
    //   219: astore 7
    //   221: aload 5
    //   223: astore 6
    //   225: aload 5
    //   227: astore_1
    //   228: aload 7
    //   230: iconst_0
    //   231: aload 5
    //   233: iconst_0
    //   234: invokeinterface 288 2 0
    //   239: aastore
    //   240: aload 5
    //   242: astore 6
    //   244: aload 5
    //   246: astore_1
    //   247: aload 7
    //   249: iconst_1
    //   250: aload 5
    //   252: iconst_1
    //   253: invokeinterface 288 2 0
    //   258: aastore
    //   259: aload 5
    //   261: astore 6
    //   263: aload 5
    //   265: astore_1
    //   266: aload 7
    //   268: iconst_2
    //   269: aload 5
    //   271: iconst_2
    //   272: invokeinterface 288 2 0
    //   277: aastore
    //   278: aload 5
    //   280: astore 6
    //   282: aload 5
    //   284: astore_1
    //   285: aload 7
    //   287: iconst_3
    //   288: aload 5
    //   290: iconst_3
    //   291: invokeinterface 288 2 0
    //   296: aastore
    //   297: aload 5
    //   299: astore 6
    //   301: aload 5
    //   303: astore_1
    //   304: aload 7
    //   306: iconst_4
    //   307: aload 5
    //   309: iconst_4
    //   310: invokeinterface 288 2 0
    //   315: aastore
    //   316: aload 5
    //   318: astore 6
    //   320: aload 5
    //   322: astore_1
    //   323: aload 7
    //   325: iconst_5
    //   326: aload 5
    //   328: iconst_5
    //   329: invokeinterface 288 2 0
    //   334: aastore
    //   335: aload 5
    //   337: astore 6
    //   339: aload 5
    //   341: astore_1
    //   342: ldc 13
    //   344: new 124	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   351: aload_2
    //   352: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc_w 468
    //   358: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 7
    //   363: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   366: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 5
    //   377: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   380: aload 7
    //   382: areturn
    //   383: iconst_0
    //   384: istore 4
    //   386: goto -362 -> 24
    //   389: iconst_4
    //   390: anewarray 59	java/lang/String
    //   393: astore 6
    //   395: aload 6
    //   397: iconst_0
    //   398: ldc_w 455
    //   401: aastore
    //   402: aload 6
    //   404: iconst_1
    //   405: ldc_w 456
    //   408: aastore
    //   409: aload 6
    //   411: iconst_2
    //   412: ldc_w 458
    //   415: aastore
    //   416: aload 6
    //   418: iconst_3
    //   419: ldc_w 460
    //   422: aastore
    //   423: goto -311 -> 112
    //   426: iconst_1
    //   427: istore_3
    //   428: goto -230 -> 198
    //   431: aload 5
    //   433: astore 6
    //   435: aload 5
    //   437: astore_1
    //   438: bipush 6
    //   440: anewarray 59	java/lang/String
    //   443: astore 9
    //   445: aload 5
    //   447: astore 6
    //   449: aload 5
    //   451: astore_1
    //   452: aload 9
    //   454: iconst_0
    //   455: aload 5
    //   457: iconst_0
    //   458: invokeinterface 288 2 0
    //   463: aastore
    //   464: aload 5
    //   466: astore 6
    //   468: aload 5
    //   470: astore_1
    //   471: aload 9
    //   473: iconst_1
    //   474: aload 5
    //   476: iconst_1
    //   477: invokeinterface 288 2 0
    //   482: aastore
    //   483: aload 5
    //   485: astore 6
    //   487: aload 5
    //   489: astore_1
    //   490: aload 9
    //   492: iconst_2
    //   493: aload 5
    //   495: iconst_2
    //   496: invokeinterface 288 2 0
    //   501: aastore
    //   502: aload 5
    //   504: astore 6
    //   506: aload 5
    //   508: astore_1
    //   509: aload 9
    //   511: iconst_3
    //   512: aload 5
    //   514: iconst_3
    //   515: invokeinterface 288 2 0
    //   520: aastore
    //   521: aload 9
    //   523: iconst_4
    //   524: aload 8
    //   526: aastore
    //   527: aload 9
    //   529: iconst_5
    //   530: aload 7
    //   532: aastore
    //   533: aload 9
    //   535: astore 7
    //   537: goto -202 -> 335
    //   540: astore_1
    //   541: aload 6
    //   543: astore 5
    //   545: aload_1
    //   546: astore 6
    //   548: aload 5
    //   550: astore_1
    //   551: ldc 13
    //   553: new 124	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   560: aload_2
    //   561: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: ldc_w 470
    //   567: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: aload 6
    //   575: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   578: aload 5
    //   580: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   583: aconst_null
    //   584: areturn
    //   585: aload 5
    //   587: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   590: goto -7 -> 583
    //   593: astore_2
    //   594: aconst_null
    //   595: astore_1
    //   596: aload_1
    //   597: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   600: aload_2
    //   601: athrow
    //   602: astore_2
    //   603: aload 5
    //   605: astore_1
    //   606: goto -10 -> 596
    //   609: astore_2
    //   610: goto -14 -> 596
    //   613: astore 6
    //   615: aconst_null
    //   616: astore 5
    //   618: goto -70 -> 548
    //   621: astore 6
    //   623: goto -75 -> 548
    //   626: iconst_0
    //   627: istore_3
    //   628: goto -430 -> 198
    //   631: aconst_null
    //   632: astore 7
    //   634: aconst_null
    //   635: astore 8
    //   637: goto -579 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	LocalProcessor
    //   0	640	1	paramContentResolver	android.content.ContentResolver
    //   0	640	2	paramString	String
    //   197	431	3	i	int
    //   22	363	4	j	int
    //   33	584	5	localObject1	Object
    //   68	506	6	localObject2	Object
    //   613	1	6	localThrowable1	Throwable
    //   621	1	6	localThrowable2	Throwable
    //   56	577	7	localObject3	Object
    //   47	589	8	str	String
    //   116	418	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   186	196	540	java/lang/Throwable
    //   214	221	540	java/lang/Throwable
    //   228	240	540	java/lang/Throwable
    //   247	259	540	java/lang/Throwable
    //   266	278	540	java/lang/Throwable
    //   285	297	540	java/lang/Throwable
    //   304	316	540	java/lang/Throwable
    //   323	335	540	java/lang/Throwable
    //   342	375	540	java/lang/Throwable
    //   438	445	540	java/lang/Throwable
    //   452	464	540	java/lang/Throwable
    //   471	483	540	java/lang/Throwable
    //   490	502	540	java/lang/Throwable
    //   509	521	540	java/lang/Throwable
    //   123	140	593	finally
    //   145	155	602	finally
    //   155	171	602	finally
    //   186	196	609	finally
    //   214	221	609	finally
    //   228	240	609	finally
    //   247	259	609	finally
    //   266	278	609	finally
    //   285	297	609	finally
    //   304	316	609	finally
    //   323	335	609	finally
    //   342	375	609	finally
    //   438	445	609	finally
    //   452	464	609	finally
    //   471	483	609	finally
    //   490	502	609	finally
    //   509	521	609	finally
    //   551	578	609	finally
    //   123	140	613	java/lang/Throwable
    //   145	155	621	java/lang/Throwable
    //   155	171	621	java/lang/Throwable
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private String[] queryVideoInfo(android.content.ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 16
    //   18: if_icmplt +360 -> 378
    //   21: iconst_1
    //   22: istore 4
    //   24: iload 4
    //   26: ifeq +358 -> 384
    //   29: bipush 7
    //   31: anewarray 59	java/lang/String
    //   34: astore 6
    //   36: aload 6
    //   38: iconst_0
    //   39: ldc_w 455
    //   42: aastore
    //   43: aload 6
    //   45: iconst_1
    //   46: ldc_w 456
    //   49: aastore
    //   50: aload 6
    //   52: iconst_2
    //   53: ldc_w 458
    //   56: aastore
    //   57: aload 6
    //   59: iconst_3
    //   60: ldc_w 460
    //   63: aastore
    //   64: aload 6
    //   66: iconst_4
    //   67: ldc_w 461
    //   70: aastore
    //   71: aload 6
    //   73: iconst_5
    //   74: ldc_w 462
    //   77: aastore
    //   78: aload 6
    //   80: bipush 6
    //   82: ldc_w 471
    //   85: aastore
    //   86: iconst_1
    //   87: anewarray 59	java/lang/String
    //   90: astore 7
    //   92: aload 7
    //   94: iconst_0
    //   95: aload_2
    //   96: aastore
    //   97: aload_1
    //   98: getstatic 474	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   101: aload 6
    //   103: ldc_w 266
    //   106: aload 7
    //   108: aconst_null
    //   109: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore 5
    //   114: aload 5
    //   116: ifnull +13 -> 129
    //   119: aload 5
    //   121: invokeinterface 277 1 0
    //   126: ifne +302 -> 428
    //   129: aload_1
    //   130: getstatic 475	android/provider/MediaStore$Video$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   133: aload 6
    //   135: ldc_w 266
    //   138: aload 7
    //   140: aconst_null
    //   141: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore_1
    //   145: aload_1
    //   146: astore 5
    //   148: aload 5
    //   150: ifnull +492 -> 642
    //   153: aload 5
    //   155: astore 6
    //   157: aload 5
    //   159: astore_1
    //   160: aload 5
    //   162: invokeinterface 277 1 0
    //   167: ifeq +475 -> 642
    //   170: iconst_1
    //   171: istore_3
    //   172: iload_3
    //   173: ifeq +428 -> 601
    //   176: iload 4
    //   178: ifeq +255 -> 433
    //   181: aload 5
    //   183: astore 6
    //   185: aload 5
    //   187: astore_1
    //   188: bipush 7
    //   190: anewarray 59	java/lang/String
    //   193: astore 7
    //   195: aload 5
    //   197: astore 6
    //   199: aload 5
    //   201: astore_1
    //   202: aload 7
    //   204: iconst_0
    //   205: aload 5
    //   207: iconst_0
    //   208: invokeinterface 288 2 0
    //   213: aastore
    //   214: aload 5
    //   216: astore 6
    //   218: aload 5
    //   220: astore_1
    //   221: aload 7
    //   223: iconst_1
    //   224: aload 5
    //   226: iconst_1
    //   227: invokeinterface 288 2 0
    //   232: aastore
    //   233: aload 5
    //   235: astore 6
    //   237: aload 5
    //   239: astore_1
    //   240: aload 7
    //   242: iconst_2
    //   243: aload 5
    //   245: iconst_2
    //   246: invokeinterface 288 2 0
    //   251: aastore
    //   252: aload 5
    //   254: astore 6
    //   256: aload 5
    //   258: astore_1
    //   259: aload 7
    //   261: iconst_3
    //   262: aload 5
    //   264: iconst_3
    //   265: invokeinterface 288 2 0
    //   270: aastore
    //   271: aload 5
    //   273: astore 6
    //   275: aload 5
    //   277: astore_1
    //   278: aload 7
    //   280: iconst_4
    //   281: aload 5
    //   283: iconst_4
    //   284: invokeinterface 288 2 0
    //   289: aastore
    //   290: aload 5
    //   292: astore 6
    //   294: aload 5
    //   296: astore_1
    //   297: aload 7
    //   299: iconst_5
    //   300: aload 5
    //   302: iconst_5
    //   303: invokeinterface 288 2 0
    //   308: aastore
    //   309: aload 5
    //   311: astore 6
    //   313: aload 5
    //   315: astore_1
    //   316: aload 7
    //   318: bipush 6
    //   320: aload 5
    //   322: bipush 6
    //   324: invokeinterface 288 2 0
    //   329: aastore
    //   330: aload 5
    //   332: astore 6
    //   334: aload 5
    //   336: astore_1
    //   337: ldc 13
    //   339: new 124	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   346: aload_2
    //   347: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 477
    //   353: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 7
    //   358: invokestatic 136	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   361: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 145	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload 5
    //   372: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   375: aload 7
    //   377: areturn
    //   378: iconst_0
    //   379: istore 4
    //   381: goto -357 -> 24
    //   384: iconst_5
    //   385: anewarray 59	java/lang/String
    //   388: astore 6
    //   390: aload 6
    //   392: iconst_0
    //   393: ldc_w 455
    //   396: aastore
    //   397: aload 6
    //   399: iconst_1
    //   400: ldc_w 456
    //   403: aastore
    //   404: aload 6
    //   406: iconst_2
    //   407: ldc_w 458
    //   410: aastore
    //   411: aload 6
    //   413: iconst_3
    //   414: ldc_w 460
    //   417: aastore
    //   418: aload 6
    //   420: iconst_4
    //   421: ldc_w 471
    //   424: aastore
    //   425: goto -339 -> 86
    //   428: iconst_1
    //   429: istore_3
    //   430: goto -258 -> 172
    //   433: aload 5
    //   435: astore 6
    //   437: aload 5
    //   439: astore_1
    //   440: bipush 7
    //   442: anewarray 59	java/lang/String
    //   445: astore 7
    //   447: aload 5
    //   449: astore 6
    //   451: aload 5
    //   453: astore_1
    //   454: aload 7
    //   456: iconst_0
    //   457: aload 5
    //   459: iconst_0
    //   460: invokeinterface 288 2 0
    //   465: aastore
    //   466: aload 5
    //   468: astore 6
    //   470: aload 5
    //   472: astore_1
    //   473: aload 7
    //   475: iconst_1
    //   476: aload 5
    //   478: iconst_1
    //   479: invokeinterface 288 2 0
    //   484: aastore
    //   485: aload 5
    //   487: astore 6
    //   489: aload 5
    //   491: astore_1
    //   492: aload 7
    //   494: iconst_2
    //   495: aload 5
    //   497: iconst_2
    //   498: invokeinterface 288 2 0
    //   503: aastore
    //   504: aload 5
    //   506: astore 6
    //   508: aload 5
    //   510: astore_1
    //   511: aload 7
    //   513: iconst_3
    //   514: aload 5
    //   516: iconst_3
    //   517: invokeinterface 288 2 0
    //   522: aastore
    //   523: aload 7
    //   525: iconst_4
    //   526: aconst_null
    //   527: aastore
    //   528: aload 7
    //   530: iconst_5
    //   531: aconst_null
    //   532: aastore
    //   533: aload 5
    //   535: astore 6
    //   537: aload 5
    //   539: astore_1
    //   540: aload 7
    //   542: bipush 6
    //   544: aload 5
    //   546: iconst_4
    //   547: invokeinterface 288 2 0
    //   552: aastore
    //   553: goto -223 -> 330
    //   556: astore_1
    //   557: aload 6
    //   559: astore 5
    //   561: aload_1
    //   562: astore 6
    //   564: aload 5
    //   566: astore_1
    //   567: ldc 13
    //   569: new 124	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   576: aload_2
    //   577: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 479
    //   583: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: aload 6
    //   591: invokestatic 151	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   594: aload 5
    //   596: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   599: aconst_null
    //   600: areturn
    //   601: aload 5
    //   603: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   606: goto -7 -> 599
    //   609: astore_2
    //   610: aconst_null
    //   611: astore_1
    //   612: aload_1
    //   613: invokestatic 283	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   616: aload_2
    //   617: athrow
    //   618: astore_2
    //   619: aload 5
    //   621: astore_1
    //   622: goto -10 -> 612
    //   625: astore_2
    //   626: goto -14 -> 612
    //   629: astore 6
    //   631: aconst_null
    //   632: astore 5
    //   634: goto -70 -> 564
    //   637: astore 6
    //   639: goto -75 -> 564
    //   642: iconst_0
    //   643: istore_3
    //   644: goto -472 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	LocalProcessor
    //   0	647	1	paramContentResolver	android.content.ContentResolver
    //   0	647	2	paramString	String
    //   171	473	3	i	int
    //   22	358	4	j	int
    //   112	521	5	localObject1	Object
    //   34	556	6	localObject2	Object
    //   629	1	6	localThrowable1	Throwable
    //   637	1	6	localThrowable2	Throwable
    //   90	451	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   160	170	556	java/lang/Throwable
    //   188	195	556	java/lang/Throwable
    //   202	214	556	java/lang/Throwable
    //   221	233	556	java/lang/Throwable
    //   240	252	556	java/lang/Throwable
    //   259	271	556	java/lang/Throwable
    //   278	290	556	java/lang/Throwable
    //   297	309	556	java/lang/Throwable
    //   316	330	556	java/lang/Throwable
    //   337	370	556	java/lang/Throwable
    //   440	447	556	java/lang/Throwable
    //   454	466	556	java/lang/Throwable
    //   473	485	556	java/lang/Throwable
    //   492	504	556	java/lang/Throwable
    //   511	523	556	java/lang/Throwable
    //   540	553	556	java/lang/Throwable
    //   97	114	609	finally
    //   119	129	618	finally
    //   129	145	618	finally
    //   160	170	625	finally
    //   188	195	625	finally
    //   202	214	625	finally
    //   221	233	625	finally
    //   240	252	625	finally
    //   259	271	625	finally
    //   278	290	625	finally
    //   297	309	625	finally
    //   316	330	625	finally
    //   337	370	625	finally
    //   440	447	625	finally
    //   454	466	625	finally
    //   473	485	625	finally
    //   492	504	625	finally
    //   511	523	625	finally
    //   540	553	625	finally
    //   567	594	625	finally
    //   97	114	629	java/lang/Throwable
    //   119	129	637	java/lang/Throwable
    //   129	145	637	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.LocalProcessor
 * JD-Core Version:    0.7.0.1
 */