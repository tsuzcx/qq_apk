package com.tencent.weiyun.transmission.upload.processor;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadHelper;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatisticsTimes;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;
import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LocalProcessor
  implements Handler.Callback
{
  private static final int MSG_PROCESS = 1;
  private static final String TAG = "UploadLocalProcessor";
  private static final long TAKEN_TIME_DIFF_60S = 60000L;
  private static SimpleDateFormat sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  private final LocalProcessorCallback mCallback;
  private final Context mContext;
  private final Handler mHandler;
  
  public LocalProcessor(Context paramContext, LocalProcessorCallback paramLocalProcessorCallback)
  {
    this.mContext = paramContext;
    this.mCallback = paramLocalProcessorCallback;
    paramContext = new HandlerThread("upload-local-processor");
    paramContext.start();
    this.mHandler = new Handler(paramContext.getLooper(), this);
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
        String str4 = localExifInterface.getAttribute("GPSLongitude");
        Object localObject = localExifInterface.getAttribute("GPSLatitude");
        String str5 = localExifInterface.getAttribute("GPSLongitudeRef");
        String str3 = localExifInterface.getAttribute("GPSLatitudeRef");
        String str1 = null;
        String str2 = null;
        if (!TextUtils.isEmpty(str4))
        {
          d = convert2Degree(str4);
          if (TextUtils.equals(str5, "E")) {
            str1 = Double.toString(d);
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            d = convert2Degree((String)localObject);
            if (!TextUtils.equals(str3, "N")) {
              break label246;
            }
            str2 = Double.toString(d);
          }
          localObject = new String[5];
          localObject[0] = str1;
          localObject[1] = str2;
          localObject[2] = localExifInterface.getAttribute("DateTime");
          localObject[3] = localExifInterface.getAttribute("ImageWidth");
          localObject[4] = localExifInterface.getAttribute("ImageLength");
          TsLog.d("UploadLocalProcessor", paramString + " parseExif success:" + Arrays.toString((Object[])localObject));
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TsLog.e("UploadLocalProcessor", paramString + " parseExif failed.", localThrowable);
        return null;
      }
      double d = 0.0D - d;
      continue;
      label246:
      d = 0.0D - d;
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
  @TargetApi(14)
  private int[] parseVideoSizes(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 186	android/media/MediaMetadataRetriever
    //   14: dup
    //   15: invokespecial 187	android/media/MediaMetadataRetriever:<init>	()V
    //   18: astore 4
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 190	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   26: aload 4
    //   28: bipush 18
    //   30: invokevirtual 194	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: astore_1
    //   34: aload 4
    //   36: bipush 19
    //   38: invokevirtual 194	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: astore 5
    //   43: aload_1
    //   44: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +30 -> 77
    //   50: iconst_0
    //   51: istore_2
    //   52: aload 5
    //   54: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifeq +29 -> 86
    //   60: aload 4
    //   62: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
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
    //   79: invokespecial 199	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   82: istore_2
    //   83: goto -31 -> 52
    //   86: aload_0
    //   87: aload 5
    //   89: invokespecial 199	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:parseIntSafely	(Ljava/lang/String;)I
    //   92: istore_3
    //   93: goto -33 -> 60
    //   96: astore_1
    //   97: ldc 16
    //   99: ldc 201
    //   101: aload_1
    //   102: invokestatic 165	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload 4
    //   107: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	LocalProcessor
    //   0	120	1	paramString	String
    //   51	32	2	i	int
    //   1	92	3	j	int
    //   18	96	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   41	47	5	str	String
    // Exception table:
    //   from	to	target	type
    //   20	50	96	java/lang/Throwable
    //   52	60	96	java/lang/Throwable
    //   77	83	96	java/lang/Throwable
    //   86	93	96	java/lang/Throwable
    //   20	50	112	finally
    //   52	60	112	finally
    //   77	83	112	finally
    //   86	93	112	finally
    //   97	105	112	finally
  }
  
  private void processLocalEnsure(UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {}
    label4:
    File localFile;
    boolean bool3;
    boolean bool1;
    label46:
    UploadFile localUploadFile;
    label126:
    long l1;
    long l2;
    int i;
    int k;
    ContentResolver localContentResolver;
    Object localObject6;
    Object localObject2;
    int j;
    label373:
    long l3;
    label418:
    label878:
    label895:
    do
    {
      break label4;
      do
      {
        return;
      } while (paramUploadJobContext.isCanceled());
      localFile = new File(paramUploadJobContext.file().localPath);
      bool3 = localFile.exists();
      if (localFile.isDirectory()) {
        break label1114;
      }
      bool1 = true;
      if ((!bool3) || (!bool1)) {
        break label1089;
      }
      localUploadFile = paramUploadJobContext.file();
      boolean bool2 = false;
      if (!TextUtils.isEmpty(localUploadFile.compressedPath))
      {
        localObject1 = new File(localUploadFile.compressedPath);
        bool2 = ((File)localObject1).exists();
        if (bool2) {
          break label1120;
        }
        localUploadFile.compressedPath = null;
        localUploadFile.compressedSha = null;
        localUploadFile.compressedSliceSha = null;
        localUploadFile.compressedSize = 0L;
      }
      l1 = localFile.lastModified();
      l2 = localFile.length();
      i = 0;
      Object localObject7;
      Object localObject5;
      String[] arrayOfString;
      if ((localUploadFile.lastModified != l1) || (localUploadFile.fileSize != l2) || (localUploadFile.sha == null))
      {
        localUploadFile.lastModified = localFile.lastModified();
        localUploadFile.fileName = localFile.getName();
        k = 1;
        localContentResolver = this.mContext.getContentResolver();
        localObject6 = null;
        localObject7 = null;
        localObject2 = null;
        localObject1 = null;
        localObject5 = new String[1];
        localObject5[0] = "mime_type";
        arrayOfString = new String[1];
        arrayOfString[0] = localUploadFile.localPath;
        j = 0;
      }
      try
      {
        localObject3 = localContentResolver.query(MediaStore.Files.getContentUri("external"), (String[])localObject5, "_data=? ", arrayOfString, null);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).moveToNext()) {
            break label1133;
          }
        }
        localObject1 = localObject3;
        localObject2 = localObject3;
        IOUtils.closeSilently((Cursor)localObject3);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject5 = localContentResolver.query(MediaStore.Files.getContentUri("internal"), (String[])localObject5, "_data=? ", arrayOfString, null);
        localObject3 = localObject5;
        i = j;
        if (localObject5 != null)
        {
          localObject3 = localObject5;
          i = j;
          localObject1 = localObject5;
          localObject2 = localObject5;
          if (((Cursor)localObject5).moveToNext())
          {
            i = 1;
            localObject3 = localObject5;
          }
        }
        localObject1 = localObject7;
        if (i != 0)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject5 = ((Cursor)localObject3).getString(0);
          localObject1 = localObject5;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject3;
          localObject2 = localObject1;
          TsLog.e("UploadLocalProcessor", localThrowable);
          IOUtils.closeSilently((Cursor)localObject1);
          localObject1 = localObject6;
        }
      }
      finally
      {
        IOUtils.closeSilently((Cursor)localObject2);
      }
      if (localObject1 != null) {
        break label1171;
      }
      localObject1 = "";
      localUploadFile.mimeType = ((String)localObject1);
      if (!((String)localObject1).startsWith("image")) {
        break label1225;
      }
      l3 = 0L;
      localObject2 = queryImageInfo(localContentResolver, localUploadFile.localPath);
      l1 = l3;
      if (localObject2 != null)
      {
        if (!TextUtils.isEmpty(localObject2[0])) {
          localUploadFile.longitude = parseDoubleSafely(localObject2[0]);
        }
        if (!TextUtils.isEmpty(localObject2[1])) {
          localUploadFile.latitude = parseDoubleSafely(localObject2[1]);
        }
        l2 = l3;
        if (!TextUtils.isEmpty(localObject2[2]))
        {
          if (!TextUtils.isDigitsOnly(localObject2[2])) {
            break label1181;
          }
          l2 = parseLongSafely(localObject2[2]);
        }
        if (!TextUtils.isEmpty(localObject2[4])) {
          localUploadFile.width = parseIntSafely(localObject2[4]);
        }
        l1 = l2;
        if (!TextUtils.isEmpty(localObject2[5]))
        {
          localUploadFile.height = parseIntSafely(localObject2[5]);
          l1 = l2;
        }
      }
      l3 = l1;
      if (((String)localObject1).endsWith("jpeg"))
      {
        localObject1 = parseExif(localUploadFile.localPath);
        l3 = l1;
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(localObject1[0])) {
            localUploadFile.longitude = parseDoubleSafely(localObject1[0]);
          }
          if (!TextUtils.isEmpty(localObject1[1])) {
            localUploadFile.latitude = parseDoubleSafely(localObject1[1]);
          }
          l2 = l1;
          if (!TextUtils.isEmpty(localObject1[2]))
          {
            localObject3 = sFormatter.parse(localObject1[2], new ParsePosition(0));
            l2 = l1;
            if (localObject3 != null)
            {
              l3 = ((Date)localObject3).getTime();
              l2 = l1;
              if (Math.abs(l3 - l1) > 60000L) {
                l2 = l3;
              }
            }
          }
          if (!TextUtils.isEmpty(localObject1[3])) {
            localUploadFile.width = parseIntSafely(localObject1[3]);
          }
          l3 = l2;
          if (!TextUtils.isEmpty(localObject1[4]))
          {
            localUploadFile.height = parseIntSafely(localObject1[4]);
            l3 = l2;
          }
        }
      }
      l1 = l3;
      if (l3 <= 0L)
      {
        l1 = l3;
        if (localObject2 != null)
        {
          l1 = l3;
          if (!TextUtils.isEmpty(localObject2[3]))
          {
            localObject1 = localObject2[3].trim();
            l1 = parseLongSafely((String)localObject1);
            if ((((String)localObject1).length() <= 8) || (((String)localObject1).length() > 10)) {
              break label1220;
            }
            i = 1000;
            l1 *= i;
          }
        }
      }
      localUploadFile.takenTime = l1;
      i = k;
      if (bool2)
      {
        if (i == 0) {
          break label1680;
        }
        if (!TextUtils.isEmpty(localUploadFile.compressedPath)) {
          IOUtils.deleteFile(new File(localUploadFile.compressedPath), false);
        }
        localUploadFile.compressedPath = null;
        localUploadFile.compressedSha = null;
        localUploadFile.compressedSliceSha = null;
        localUploadFile.compressedSize = 0L;
      }
      if ((i == 0) && (((localUploadFile.sliceSha != null) && (localUploadFile.sliceSha.length > 0)) || (bool2))) {
        break;
      }
      paramUploadJobContext.statisticsTimes().onCalShaStart();
      localObject2 = UploadHelper.calSliceSha1(localFile.getAbsolutePath(), paramUploadJobContext.getCanceledFlag());
      paramUploadJobContext.statisticsTimes().onCalShaEnd();
    } while (paramUploadJobContext.isCanceled());
    label541:
    if ((localObject2 == null) || (localObject2.length <= 0)) {}
    for (Object localObject1 = null;; localObject1 = localObject2[(localObject2.length - 1)])
    {
      localUploadFile.sha = ((String)localObject1);
      localUploadFile.sliceSha = ((String[])localObject2);
      if (localUploadFile.sha == null)
      {
        paramUploadJobContext.statisticsTimes().onCalShaStart();
        localUploadFile.sha = IOUtils.getFileSha1(localFile.getAbsolutePath());
        paramUploadJobContext.statisticsTimes().onCalShaEnd();
      }
      localUploadFile.fileSize = localFile.length();
      label1089:
      if (paramUploadJobContext.isCanceled()) {
        break;
      }
      this.mCallback.onLocalResult(paramUploadJobContext.dbId(), bool3, bool1);
      return;
      label1114:
      bool1 = false;
      break label46;
      label1120:
      localUploadFile.compressedSize = ((File)localObject1).length();
      break label126;
      label1133:
      i = 1;
      break label373;
      label1171:
      localObject1 = ((String)localObject1).toLowerCase();
      break label418;
      label1181:
      Object localObject4 = sFormatter.parse(localObject2[2], new ParsePosition(0));
      l2 = l3;
      if (localObject4 == null) {
        break label541;
      }
      l2 = ((Date)localObject4).getTime();
      break label541;
      label1220:
      i = 1;
      break label878;
      label1225:
      if (((String)localObject1).startsWith("video"))
      {
        localObject1 = queryVideoInfo(localContentResolver, localUploadFile.localPath);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(localObject1[0])) {
            localUploadFile.longitude = parseDoubleSafely(localObject1[0]);
          }
          if (!TextUtils.isEmpty(localObject1[1])) {
            localUploadFile.latitude = parseDoubleSafely(localObject1[1]);
          }
          if (TextUtils.isEmpty(localObject1[2])) {
            break label1524;
          }
          if (!TextUtils.isDigitsOnly(localObject1[2])) {
            break label1486;
          }
          localUploadFile.takenTime = parseLongSafely(localObject1[2]);
          if (!TextUtils.isEmpty(localObject1[4])) {
            localUploadFile.width = parseIntSafely(localObject1[4]);
          }
          if (!TextUtils.isEmpty(localObject1[5])) {
            localUploadFile.height = parseIntSafely(localObject1[5]);
          }
          if (!TextUtils.isEmpty(localObject1[6])) {
            localUploadFile.duration = parseLongSafely(localObject1[6]);
          }
        }
        if (Build.VERSION.SDK_INT >= 14) {}
        for (j = 1;; j = 0)
        {
          i = k;
          if (localUploadFile.width != 0) {
            break;
          }
          i = k;
          if (localUploadFile.height != 0) {
            break;
          }
          i = k;
          if (j == 0) {
            break;
          }
          localObject1 = parseVideoSizes(localUploadFile.localPath);
          i = k;
          if (localObject1 == null) {
            break;
          }
          localUploadFile.width = localObject1[0];
          localUploadFile.height = localObject1[1];
          i = k;
          break;
          label1486:
          localObject2 = sFormatter.parse(localObject1[2], new ParsePosition(0));
          if (localObject2 == null) {
            break label1333;
          }
          localUploadFile.takenTime = ((Date)localObject2).getTime();
          break label1333;
          label1524:
          if (TextUtils.isEmpty(localObject1[3])) {
            break label1333;
          }
          localObject2 = localObject1[3].trim();
          l1 = parseLongSafely((String)localObject2);
          if ((((String)localObject2).length() > 8) && (((String)localObject2).length() <= 10)) {}
          for (i = 1000;; i = 1)
          {
            localUploadFile.takenTime = (l1 * i);
            break;
          }
        }
      }
      label1333:
      i = k;
      if (!((String)localObject1).startsWith("audio")) {
        break label895;
      }
      localObject1 = queryAudioInfo(localContentResolver, localUploadFile.localPath);
      i = k;
      if (localObject1 == null) {
        break label895;
      }
      if (!TextUtils.isEmpty(localObject1[0])) {
        localUploadFile.album = localObject1[0];
      }
      i = k;
      if (TextUtils.isEmpty(localObject1[1])) {
        break label895;
      }
      localUploadFile.artist = localObject1[1];
      i = k;
      break label895;
      label1680:
      paramUploadJobContext.statisticsTimes().onCalShaStart();
      localObject2 = UploadHelper.calSliceSha1(localUploadFile.compressedPath, paramUploadJobContext.getCanceledFlag());
      paramUploadJobContext.statisticsTimes().onCalShaEnd();
      if (paramUploadJobContext.isCanceled()) {
        break;
      }
      localObject4 = paramUploadJobContext.file();
      if ((localObject2 == null) || (localObject2.length <= 0)) {}
      for (localObject1 = null;; localObject1 = localObject2[(localObject2.length - 1)])
      {
        ((UploadFile)localObject4).compressedSha = ((String)localObject1);
        paramUploadJobContext.file().compressedSliceSha = ((String[])localObject2);
        if (paramUploadJobContext.file().compressedSha != null) {
          break;
        }
        paramUploadJobContext.statisticsTimes().onCalShaStart();
        paramUploadJobContext.file().compressedSha = IOUtils.getFileSha1(localUploadFile.compressedPath);
        paramUploadJobContext.statisticsTimes().onCalShaEnd();
        break;
      }
    }
  }
  
  private String[] queryAudioInfo(ContentResolver paramContentResolver, String paramString)
  {
    if ((paramContentResolver == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "album";
    arrayOfString1[1] = "artist";
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    localObject2 = null;
    localObject1 = null;
    int j = 0;
    try
    {
      Object localObject3 = paramContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
      int i;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToNext()) {}
      }
      else
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject3 = paramContentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
        paramContentResolver = (ContentResolver)localObject3;
        i = j;
        if (localObject3 != null)
        {
          paramContentResolver = (ContentResolver)localObject3;
          i = j;
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).moveToNext()) {
            i = 1;
          }
        }
      }
      for (paramContentResolver = (ContentResolver)localObject3; i != 0; paramContentResolver = (ContentResolver)localObject3)
      {
        localObject1 = paramContentResolver;
        localObject2 = paramContentResolver;
        localObject3 = new String[2];
        localObject1 = paramContentResolver;
        localObject2 = paramContentResolver;
        localObject3[0] = paramContentResolver.getString(0);
        localObject1 = paramContentResolver;
        localObject2 = paramContentResolver;
        localObject3[1] = paramContentResolver.getString(1);
        localObject1 = paramContentResolver;
        localObject2 = paramContentResolver;
        TsLog.d("UploadLocalProcessor", paramString + " queryAudioInfo success." + Arrays.toString((Object[])localObject3));
        IOUtils.closeSilently(paramContentResolver);
        return localObject3;
        i = 1;
      }
      IOUtils.closeSilently(paramContentResolver);
    }
    catch (Throwable paramContentResolver)
    {
      for (;;)
      {
        localObject2 = localObject1;
        TsLog.e("UploadLocalProcessor", paramString + " queryAudioInfo failed.", paramContentResolver);
        IOUtils.closeSilently((Cursor)localObject1);
      }
    }
    finally
    {
      IOUtils.closeSilently((Cursor)localObject2);
    }
    return null;
  }
  
  @TargetApi(16)
  private String[] queryImageInfo(ContentResolver paramContentResolver, String paramString)
  {
    if ((paramContentResolver == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    int j;
    if (Build.VERSION.SDK_INT >= 16) {
      j = 1;
    }
    for (;;)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject5 = localObject2;
      Object localObject4 = localObject1;
      Object localObject3;
      if (j == 0)
      {
        localObject3 = IOUtils.getImageWidthHeight(paramString);
        localObject5 = localObject2;
        localObject4 = localObject1;
        if (localObject3 != null)
        {
          localObject4 = Integer.toString(localObject3[0]);
          localObject5 = Integer.toString(localObject3[1]);
        }
      }
      String[] arrayOfString1;
      label134:
      String[] arrayOfString2;
      int k;
      if (j != 0)
      {
        arrayOfString1 = new String[6];
        arrayOfString1[0] = "longitude";
        arrayOfString1[1] = "latitude";
        arrayOfString1[2] = "datetaken";
        arrayOfString1[3] = "date_added";
        arrayOfString1[4] = "width";
        arrayOfString1[5] = "height";
        arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        localObject2 = null;
        localObject1 = null;
        k = 0;
      }
      try
      {
        localObject3 = paramContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
        int i;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).moveToNext()) {}
        }
        else
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject3 = paramContentResolver.query(MediaStore.Images.Media.INTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
          paramContentResolver = (ContentResolver)localObject3;
          i = k;
          if (localObject3 != null)
          {
            paramContentResolver = (ContentResolver)localObject3;
            i = k;
            localObject1 = localObject3;
            localObject2 = localObject3;
            if (((Cursor)localObject3).moveToNext())
            {
              i = 1;
              paramContentResolver = (ContentResolver)localObject3;
            }
          }
          label259:
          if (i == 0) {
            break label576;
          }
          if (j == 0) {
            break label480;
          }
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3 = new String[6];
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[0] = paramContentResolver.getString(0);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[1] = paramContentResolver.getString(1);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[2] = paramContentResolver.getString(2);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[3] = paramContentResolver.getString(3);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[4] = paramContentResolver.getString(4);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[5] = paramContentResolver.getString(5);
        }
        for (;;)
        {
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          TsLog.d("UploadLocalProcessor", paramString + " queryImageInfo success." + Arrays.toString((Object[])localObject3));
          IOUtils.closeSilently(paramContentResolver);
          return localObject3;
          j = 0;
          break;
          arrayOfString1 = new String[4];
          arrayOfString1[0] = "longitude";
          arrayOfString1[1] = "latitude";
          arrayOfString1[2] = "datetaken";
          arrayOfString1[3] = "date_added";
          break label134;
          i = 1;
          paramContentResolver = (ContentResolver)localObject3;
          break label259;
          label480:
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3 = new String[6];
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[0] = paramContentResolver.getString(0);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[1] = paramContentResolver.getString(1);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[2] = paramContentResolver.getString(2);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[3] = paramContentResolver.getString(3);
          localObject3[4] = localObject4;
          localObject3[5] = localObject5;
        }
        label576:
        IOUtils.closeSilently(paramContentResolver);
      }
      catch (Throwable paramContentResolver)
      {
        for (;;)
        {
          localObject2 = localObject1;
          TsLog.e("UploadLocalProcessor", paramString + " queryImageInfo failed.", paramContentResolver);
          IOUtils.closeSilently((Cursor)localObject1);
        }
      }
      finally
      {
        IOUtils.closeSilently((Cursor)localObject2);
      }
    }
    return null;
  }
  
  @TargetApi(16)
  private String[] queryVideoInfo(ContentResolver paramContentResolver, String paramString)
  {
    if ((paramContentResolver == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    int j;
    if (Build.VERSION.SDK_INT >= 16) {
      j = 1;
    }
    for (;;)
    {
      String[] arrayOfString1;
      label86:
      String[] arrayOfString2;
      Object localObject2;
      Object localObject1;
      int k;
      if (j != 0)
      {
        arrayOfString1 = new String[7];
        arrayOfString1[0] = "longitude";
        arrayOfString1[1] = "latitude";
        arrayOfString1[2] = "datetaken";
        arrayOfString1[3] = "date_added";
        arrayOfString1[4] = "width";
        arrayOfString1[5] = "height";
        arrayOfString1[6] = "duration";
        arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        localObject2 = null;
        localObject1 = null;
        k = 0;
      }
      try
      {
        Object localObject3 = paramContentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
        int i;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).moveToNext()) {}
        }
        else
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject3 = paramContentResolver.query(MediaStore.Video.Media.INTERNAL_CONTENT_URI, arrayOfString1, "_data=? ", arrayOfString2, null);
          paramContentResolver = (ContentResolver)localObject3;
          i = k;
          if (localObject3 != null)
          {
            paramContentResolver = (ContentResolver)localObject3;
            i = k;
            localObject1 = localObject3;
            localObject2 = localObject3;
            if (((Cursor)localObject3).moveToNext())
            {
              i = 1;
              paramContentResolver = (ContentResolver)localObject3;
            }
          }
          label211:
          if (i == 0) {
            break label570;
          }
          if (j == 0) {
            break label458;
          }
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3 = new String[7];
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[0] = paramContentResolver.getString(0);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[1] = paramContentResolver.getString(1);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[2] = paramContentResolver.getString(2);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[3] = paramContentResolver.getString(3);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[4] = paramContentResolver.getString(4);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[5] = paramContentResolver.getString(5);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[6] = paramContentResolver.getString(6);
        }
        for (;;)
        {
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          TsLog.d("UploadLocalProcessor", paramString + " queryVideoInfo success." + Arrays.toString((Object[])localObject3));
          IOUtils.closeSilently(paramContentResolver);
          return localObject3;
          j = 0;
          break;
          arrayOfString1 = new String[5];
          arrayOfString1[0] = "longitude";
          arrayOfString1[1] = "latitude";
          arrayOfString1[2] = "datetaken";
          arrayOfString1[3] = "date_added";
          arrayOfString1[4] = "duration";
          break label86;
          i = 1;
          paramContentResolver = (ContentResolver)localObject3;
          break label211;
          label458:
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3 = new String[7];
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[0] = paramContentResolver.getString(0);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[1] = paramContentResolver.getString(1);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[2] = paramContentResolver.getString(2);
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[3] = paramContentResolver.getString(3);
          localObject3[4] = null;
          localObject3[5] = null;
          localObject1 = paramContentResolver;
          localObject2 = paramContentResolver;
          localObject3[6] = paramContentResolver.getString(4);
        }
        label570:
        IOUtils.closeSilently(paramContentResolver);
      }
      catch (Throwable paramContentResolver)
      {
        for (;;)
        {
          localObject2 = localObject1;
          TsLog.e("UploadLocalProcessor", paramString + " queryVideoInfo failed.", paramContentResolver);
          IOUtils.closeSilently((Cursor)localObject1);
        }
      }
      finally
      {
        IOUtils.closeSilently((Cursor)localObject2);
      }
    }
    return null;
  }
  
  public void cancelAll()
  {
    this.mHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      processLocalEnsure((UploadJobContext)paramMessage.obj);
    }
    return true;
  }
  
  public void processor(UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    Message.obtain(this.mHandler, 1, paramUploadJobContext).sendToTarget();
  }
  
  public static abstract interface LocalProcessorCallback
  {
    public abstract void onLocalResult(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.LocalProcessor
 * JD-Core Version:    0.7.0.1
 */