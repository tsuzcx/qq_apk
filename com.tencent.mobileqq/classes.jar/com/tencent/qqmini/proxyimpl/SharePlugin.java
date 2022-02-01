package com.tencent.qqmini.proxyimpl;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SharePlugin
{
  private static HashMap<Integer, String> a = new HashMap();
  
  public static LocalMediaInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    LocalMediaInfo localLocalMediaInfo = null;
    if (bool) {
      return null;
    }
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      if (!localFile.isFile()) {
        return null;
      }
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramString;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(paramString, localOptions);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("_photo", 1, localOutOfMemoryError, new Object[0]);
      }
      catch (Exception localException)
      {
        QLog.e("_photo", 1, localException, new Object[0]);
      }
      localLocalMediaInfo.mediaWidth = localOptions.outWidth;
      localLocalMediaInfo.mediaHeight = localOptions.outHeight;
      localLocalMediaInfo.mMimeType = PhotoUtils.getImageMimeType(paramString);
      localLocalMediaInfo.fileSize = localFile.length();
      localLocalMediaInfo.modifiedDate = localFile.lastModified();
    }
    return localLocalMediaInfo;
  }
  
  public static PublishMoodInfo a(PublishMoodInfo paramPublishMoodInfo)
  {
    if (paramPublishMoodInfo == null) {
      return null;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    localPublishMoodInfo.mTag = paramPublishMoodInfo.mTag;
    localPublishMoodInfo.mPath = paramPublishMoodInfo.mPath;
    localPublishMoodInfo.mFootnote = paramPublishMoodInfo.mFootnote;
    Object localObject1 = paramPublishMoodInfo.mText;
    int m = 0;
    Object localObject2;
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramPublishMoodInfo.mText)))
    {
      localObject1 = PublishMoodInfo.filterText(paramPublishMoodInfo.mText);
      i = ((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT;
      if (i > 0)
      {
        paramPublishMoodInfo.mText = paramPublishMoodInfo.mText.substring(0, paramPublishMoodInfo.mText.length() - i);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("超出");
        ((StringBuilder)localObject2).append(((String)localObject1).length() - PublishMoodInfo.MOOD_MAX_TEXT_COUNT);
        ((StringBuilder)localObject2).append("个字,截断");
        QLog.i("mini_SharePlugin", 2, ((StringBuilder)localObject2).toString());
        i = 1;
        break label168;
      }
    }
    int i = 0;
    label168:
    localPublishMoodInfo.mText = paramPublishMoodInfo.mText;
    int k = i;
    if (paramPublishMoodInfo.mMediaInfo != null)
    {
      k = i;
      if (paramPublishMoodInfo.mMediaInfo.size() > 0)
      {
        int j = i;
        if (paramPublishMoodInfo.mMediaInfo.size() > PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT)
        {
          j = i | 0x20;
          QLog.i("mini_SharePlugin", 2, "图片+视频个数超出大小");
        }
        localObject1 = new HashMap();
        localObject2 = new ArrayList();
        paramPublishMoodInfo = paramPublishMoodInfo.mMediaInfo.iterator();
        k = 0;
        i = j;
        for (;;)
        {
          j = i;
          if (!paramPublishMoodInfo.hasNext()) {
            break;
          }
          PublishMoodInfo.MediaInfo localMediaInfo = (PublishMoodInfo.MediaInfo)paramPublishMoodInfo.next();
          Object localObject3 = new File(localMediaInfo.mPath);
          if ((((File)localObject3).exists()) && (((File)localObject3).isFile()))
          {
            j = localMediaInfo.mType;
            int n;
            int i1;
            if (j != 1)
            {
              if (j != 2)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("invalid type");
                ((StringBuilder)localObject3).append(localMediaInfo);
                QLog.i("mini_SharePlugin", 2, ((StringBuilder)localObject3).toString());
                j = i;
                n = m;
                i1 = k;
              }
              else
              {
                if (m >= PublishMoodInfo.MOOD_MAX_VIDEO_COUNT)
                {
                  i |= 0x10;
                  QLog.i("mini_SharePlugin", 2, "视频个数超出大小");
                  continue;
                }
                localObject3 = b(localMediaInfo.mPath);
                j = i;
                n = m;
                i1 = k;
                if (localObject3 != null)
                {
                  boolean bool1 = b(((LocalMediaInfo)localObject3).fileSize);
                  boolean bool2 = c(((LocalMediaInfo)localObject3).mDuration);
                  if ((bool1) && (bool2))
                  {
                    ((ArrayList)localObject2).add(localMediaInfo.mPath);
                    ((HashMap)localObject1).put(localMediaInfo.mPath, localObject3);
                    n = m + 1;
                    j = i;
                    i1 = k;
                  }
                  else
                  {
                    j = i;
                    if (!bool1) {
                      j = i | 0x4;
                    }
                    i = j;
                    if (!bool2) {
                      i = j | 0x8;
                    }
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("单个视频大小/时长超出, ");
                    ((StringBuilder)localObject3).append(localMediaInfo);
                    QLog.i("mini_SharePlugin", 2, ((StringBuilder)localObject3).toString());
                    j = i;
                    n = m;
                    i1 = k;
                  }
                }
              }
            }
            else
            {
              localObject3 = a(localMediaInfo.mPath);
              j = i;
              n = m;
              i1 = k;
              if (localObject3 != null) {
                if (a(((LocalMediaInfo)localObject3).fileSize))
                {
                  ((ArrayList)localObject2).add(localMediaInfo.mPath);
                  ((HashMap)localObject1).put(localMediaInfo.mPath, localObject3);
                  i1 = k + 1;
                  j = i;
                  n = m;
                }
                else
                {
                  j = i | 0x2;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("图片超出大小，");
                  ((StringBuilder)localObject3).append(localMediaInfo);
                  QLog.i("mini_SharePlugin", 2, ((StringBuilder)localObject3).toString());
                  i1 = k;
                  n = m;
                }
              }
            }
            i = j;
            m = n;
            k = i1;
            if (i1 + n >= PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT) {
              break;
            }
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("path is not exist, ");
            ((StringBuilder)localObject3).append(localMediaInfo);
            QLog.i("mini_SharePlugin", 2, ((StringBuilder)localObject3).toString());
          }
        }
        k = j;
        if (((HashMap)localObject1).size() > 0)
        {
          localPublishMoodInfo.mAllImageAndVideo = ((ArrayList)localObject2);
          localPublishMoodInfo.mMediaInfoHashMap = ((HashMap)localObject1);
          k = j;
        }
      }
    }
    a(k);
    paramPublishMoodInfo = new StringBuilder();
    paramPublishMoodInfo.append("tip = ");
    paramPublishMoodInfo.append(k);
    QLog.i("mini_SharePlugin", 2, paramPublishMoodInfo.toString());
    return localPublishMoodInfo;
  }
  
  private static void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    AppBrandTask.runTaskOnUiThread(new SharePlugin.1(paramInt));
  }
  
  private static boolean a(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public static LocalMediaInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 31	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 38	java/io/File:exists	()Z
    //   22: ifeq +284 -> 306
    //   25: aload_3
    //   26: invokevirtual 41	java/io/File:isFile	()Z
    //   29: ifne +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: getstatic 271	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 10
    //   39: if_icmple +267 -> 306
    //   42: new 273	android/media/MediaMetadataRetriever
    //   45: dup
    //   46: invokespecial 274	android/media/MediaMetadataRetriever:<init>	()V
    //   49: astore_1
    //   50: new 43	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   53: dup
    //   54: invokespecial 44	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   57: astore_2
    //   58: aload_1
    //   59: aload_0
    //   60: invokevirtual 277	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: aload_0
    //   65: putfield 48	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   68: aload_2
    //   69: aload_1
    //   70: bipush 9
    //   72: invokevirtual 281	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   75: invokestatic 287	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: putfield 212	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   81: aload_2
    //   82: aload_1
    //   83: bipush 12
    //   85: invokevirtual 281	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   88: putfield 90	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   91: aload_2
    //   92: aload_3
    //   93: invokevirtual 94	java/io/File:length	()J
    //   96: putfield 98	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   99: aload_1
    //   100: invokevirtual 290	android/media/MediaMetadataRetriever:release	()V
    //   103: aload_2
    //   104: areturn
    //   105: astore_0
    //   106: new 137	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc_w 292
    //   118: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: aload_0
    //   124: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 151
    //   130: aload_1
    //   131: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 297	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_2
    //   138: areturn
    //   139: astore_0
    //   140: goto +125 -> 265
    //   143: astore_0
    //   144: new 137	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   151: astore_2
    //   152: aload_2
    //   153: ldc_w 299
    //   156: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: aload_0
    //   162: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 151
    //   168: aload_2
    //   169: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 297	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_1
    //   176: invokevirtual 290	android/media/MediaMetadataRetriever:release	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_1
    //   182: new 137	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   189: astore_0
    //   190: goto +50 -> 240
    //   193: astore_0
    //   194: new 137	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   201: astore_2
    //   202: aload_2
    //   203: ldc_w 301
    //   206: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: aload_0
    //   212: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 151
    //   218: aload_2
    //   219: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 297	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_1
    //   226: invokevirtual 290	android/media/MediaMetadataRetriever:release	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore_1
    //   232: new 137	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   239: astore_0
    //   240: aload_0
    //   241: ldc_w 292
    //   244: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 151
    //   256: aload_0
    //   257: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 297	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aconst_null
    //   264: areturn
    //   265: aload_1
    //   266: invokevirtual 290	android/media/MediaMetadataRetriever:release	()V
    //   269: goto +35 -> 304
    //   272: astore_1
    //   273: new 137	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   280: astore_2
    //   281: aload_2
    //   282: ldc_w 292
    //   285: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_2
    //   290: aload_1
    //   291: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 151
    //   297: aload_2
    //   298: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 297	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: athrow
    //   306: aconst_null
    //   307: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString	String
    //   49	127	1	localObject1	Object
    //   181	45	1	localRuntimeException1	java.lang.RuntimeException
    //   231	35	1	localRuntimeException2	java.lang.RuntimeException
    //   272	19	1	localRuntimeException3	java.lang.RuntimeException
    //   57	241	2	localObject2	Object
    //   17	76	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   99	103	105	java/lang/RuntimeException
    //   58	99	139	finally
    //   144	175	139	finally
    //   194	225	139	finally
    //   58	99	143	java/lang/RuntimeException
    //   175	179	181	java/lang/RuntimeException
    //   58	99	193	java/lang/IllegalArgumentException
    //   225	229	231	java/lang/RuntimeException
    //   265	269	272	java/lang/RuntimeException
  }
  
  private static boolean b(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE;
  }
  
  private static boolean c(long paramLong)
  {
    return paramLong <= PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.SharePlugin
 * JD-Core Version:    0.7.0.1
 */