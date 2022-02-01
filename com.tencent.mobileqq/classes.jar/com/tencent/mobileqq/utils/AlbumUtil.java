package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.TextView;
import anvx;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public class AlbumUtil
  extends QAlbumUtil
{
  public static final long MP_VIDEO_SIZE_LIMIT = 1048576000L;
  public static final int PHOTO_SELECT_ITEM_MAX = 20;
  private static final long QZONE_SHOW_TOAST_DURATION = 2000L;
  private static final String TAG = "AlbumUtil";
  public static final int[] UIN_TYPE_VIDEO_ALL = { 0, 3000, 1 };
  private static long qzoneLastShowVideoQuantityLimitToastTime;
  private static List<LocalMediaInfo> sRecentMediaCache;
  
  public static void RecordLastPosByIntent(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        sLastAlbumPath = paramIntent;
        sLastAlbumRecordTime = System.currentTimeMillis();
      }
    }
  }
  
  public static String buildSelection(List<String> paramList)
  {
    Object localObject1 = new StringBuilder("_data");
    ((StringBuilder)localObject1).append(" IS NOT NULL AND ");
    ((StringBuilder)localObject1).append("_size");
    ((StringBuilder)localObject1).append(" > 0 ");
    Object localObject2 = localObject1;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        ((StringBuilder)localObject1).append(" AND (");
        localObject2 = paramList.iterator();
        paramList = (List<String>)localObject1;
        int i = 1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (i == 0) {
            paramList.append(" OR ");
          }
          for (;;)
          {
            paramList.append(" ( ");
            paramList = createOnSelection("bucket_id", paramList, (String)localObject1);
            paramList.append(" ) ");
            break;
            i = 0;
          }
        }
        paramList.append(" ) ");
        localObject2 = paramList;
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public static boolean checkNumOfMediaOverSize(List<String> paramList, Activity paramActivity, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() >= paramInt))
    {
      QQToast.a(paramActivity, String.format(paramActivity.getResources().getString(2131718130), new Object[] { Integer.valueOf(paramInt) }), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      return true;
    }
    return false;
  }
  
  public static boolean checkOriginImageIsOverSize(LocalMediaInfo paramLocalMediaInfo, long paramLong, Activity paramActivity)
  {
    boolean bool = false;
    if (paramLocalMediaInfo.fileSize > paramLong)
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131694641), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      bool = true;
    }
    return bool;
  }
  
  public static boolean checkRawVideoIsOverSize(LocalMediaInfo paramLocalMediaInfo, long paramLong, Activity paramActivity)
  {
    boolean bool = false;
    if (paramLocalMediaInfo.fileSize > paramLong)
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131718856), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      bool = true;
    }
    return bool;
  }
  
  public static boolean checkVideoForQzoneUploadPhoto(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    return checkVideoForQzoneUploadPhoto(paramContext, paramInt, paramLocalMediaInfo, false);
  }
  
  public static boolean checkVideoForQzoneUploadPhoto(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramLocalMediaInfo != null) && (getMediaType(paramLocalMediaInfo) == 1)) {
      if (!paramBoolean) {
        break label213;
      }
    }
    label213:
    for (int i = getShuoShuoMaxUploadVideoCount();; i = getMaxUploadVideoCount())
    {
      paramBoolean = bool;
      if (paramInt >= i)
      {
        if (System.currentTimeMillis() - qzoneLastShowVideoQuantityLimitToastTime > 2000L)
        {
          QQToast.a(paramContext, anvx.a(2131699720) + i + anvx.a(2131699721), 0).a();
          qzoneLastShowVideoQuantityLimitToastTime = System.currentTimeMillis();
        }
        paramBoolean = false;
      }
      long l = QZoneHelper.getVideoCanUploadSize();
      if (paramLocalMediaInfo.fileSize > l)
      {
        QQToast.a(paramContext, anvx.a(2131699719) + (float)l / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).a();
        paramBoolean = false;
      }
      if (paramLocalMediaInfo.mDuration <= 601000L) {
        break;
      }
      QQToast.a(paramContext, anvx.a(2131699718) + 10L + anvx.a(2131699722), 0).a();
      return false;
    }
    return paramBoolean;
  }
  
  public static boolean checkVideoIsOverSize(LocalMediaInfo paramLocalMediaInfo, long paramLong, Activity paramActivity)
  {
    boolean bool = false;
    if ((paramLocalMediaInfo.fileSize > paramLong) || (paramLocalMediaInfo.mDuration > 1200000L))
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131718834), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      bool = true;
    }
    return bool;
  }
  
  public static void clearCache() {}
  
  public static void clearLastAlbumInfo()
  {
    sLastAlbumPhotoCountMap.clear();
    sLastAlbumPath = null;
    sLastAlbumRecordTime = 0L;
    sLastAlbumId = null;
    sLastAlbumName = null;
  }
  
  private static StringBuilder createOnSelection(String paramString1, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static List<LocalMediaInfo> getAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    return getAlbumPhotos(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, 0, -1, false, null, false);
  }
  
  public static int getCountOfOverSizeLimit(List<String> paramList, int paramInt, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (getMediaType((LocalMediaInfo)localObject) != 1))
      {
        long l = new File(str).length();
        if (l <= paramInt) {
          break label150;
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "sendQualityPicLimit", true, paramInt, l, null, "");
        i += 1;
      }
    }
    label150:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int getCountOfRawVideoOverSize(List<String> paramList, long paramLong, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (getMediaType((LocalMediaInfo)localObject) == 1))
      {
        if (new File(str).length() <= paramLong) {
          break label123;
        }
        i += 1;
      }
    }
    label123:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static URL getFileURL(String paramString)
  {
    Object localObject1 = new File(paramString);
    do
    {
      try
      {
        localObject1 = ((File)localObject1).toURL();
        String str;
        Object localObject2 = localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          str = ((URL)localObject1).toString();
          localObject2 = new URL(str + "?thumb=true");
          return localObject2;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          continue;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPhotoTrace", 2, "path is:" + paramString + ",path->url failed", localMalformedURLException1);
    return localObject1;
  }
  
  public static String getLastAlbumId(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static String getLastAlbumName(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static int getMaxUploadVideoCount()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static void getMediaInfo(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramLocalMediaInfo.mediaHeight = localOptions.outHeight;
      paramLocalMediaInfo.mediaWidth = localOptions.outWidth;
      paramLocalMediaInfo.mMimeType = localOptions.outMimeType;
      paramLocalMediaInfo.addedDate = System.currentTimeMillis();
      paramLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      paramLocalMediaInfo.path = paramString;
      paramLocalMediaInfo.panoramaPhotoType = 3;
      paramLocalMediaInfo.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramLocalMediaInfo)
    {
      QLog.e("AlbumUtil", 2, "decode image error", paramLocalMediaInfo);
    }
  }
  
  public static float getPhotoGorupListCropSpaceRatio()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static int getSelectFileTotolLen(List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l;
      if ((paramHashMap != null) && (NetworkUtils.isNetworkUrl(str))) {
        if (paramHashMap.get(str) != null) {
          l = ((PhotoSendParams)paramHashMap.get(str)).fileSize;
        }
      }
      for (;;)
      {
        i = (int)(i + l);
        if (QLog.isColorLevel()) {
          QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l);
        }
        break;
        QLog.w("_photo", 1, "mSelectedSendParams.get(p) == null path:" + str);
        l = 0L;
        continue;
        paramList = null;
        if (paramMap2 != null) {
          paramList = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((paramList == null) && (paramMap1 != null)) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        l = new File(str).length();
      }
    }
    return i;
  }
  
  public static int getShuoShuoMaxUploadVideoCount()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static boolean hasAlbumMedia(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if ((paramMediaFileFilter != null) && (paramMediaFileFilter.showImage()) && (!getAlbumPhotos(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter).isEmpty())) {}
    while ((paramMediaFileFilter != null) && (paramMediaFileFilter.showVideo()) && (!getAlbumVideos(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, -1L).isEmpty())) {
      return true;
    }
    return false;
  }
  
  public static boolean isVideoUinType(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = UIN_TYPE_VIDEO_ALL;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void putRecordLastPosData(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryAllImages(Context paramContext, int paramInt, List<String> paramList, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 486	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 487	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: invokestatic 489	com/tencent/mobileqq/utils/AlbumUtil:buildSelection	(Ljava/util/List;)Ljava/lang/String;
    //   16: astore_2
    //   17: getstatic 495	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: invokevirtual 501	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc_w 503
    //   30: iload_1
    //   31: invokestatic 505	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   34: invokevirtual 511	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   37: pop
    //   38: aload 6
    //   40: invokevirtual 515	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   43: astore 6
    //   45: aload_0
    //   46: invokevirtual 519	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   49: aload 6
    //   51: getstatic 523	com/tencent/mobileqq/utils/AlbumUtil:columns	[Ljava/lang/String;
    //   54: aload_2
    //   55: aconst_null
    //   56: ldc_w 525
    //   59: invokevirtual 531	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_0
    //   63: aload_0
    //   64: aload 5
    //   66: iconst_0
    //   67: iload_1
    //   68: iconst_0
    //   69: aload_3
    //   70: aconst_null
    //   71: iconst_0
    //   72: invokestatic 535	com/tencent/mobileqq/utils/AlbumUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 540 1 0
    //   85: aload 5
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +14 -> 108
    //   97: ldc 18
    //   99: iconst_2
    //   100: aload_2
    //   101: invokevirtual 543	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   104: aload_2
    //   105: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: ifnull -24 -> 85
    //   112: aload_0
    //   113: invokeinterface 540 1 0
    //   118: aload 5
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +9 -> 135
    //   129: aload_2
    //   130: invokeinterface 540 1 0
    //   135: aload_0
    //   136: athrow
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload_3
    //   141: astore_0
    //   142: goto -17 -> 125
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: aload_3
    //   149: astore_0
    //   150: goto -25 -> 125
    //   153: astore_2
    //   154: goto -63 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	Context
    //   0	157	1	paramInt	int
    //   0	157	2	paramList	List<String>
    //   0	157	3	paramMediaFileFilter	MediaFileFilter
    //   1	122	4	localObject1	Object
    //   10	109	5	localArrayList	java.util.ArrayList
    //   23	27	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	63	88	java/lang/Exception
    //   45	63	121	finally
    //   63	75	137	finally
    //   91	108	145	finally
    //   63	75	153	java/lang/Exception
  }
  
  /* Error */
  public static int queryNumEntries(Context paramContext, android.net.Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 519	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 4
    //   9: aconst_null
    //   10: invokevirtual 531	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokeinterface 551 1 0
    //   22: ifeq +27 -> 49
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: iconst_0
    //   29: invokeinterface 554 2 0
    //   34: istore 5
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 540 1 0
    //   46: iload 5
    //   48: ireturn
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokeinterface 540 1 0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +16 -> 85
    //   72: aload_1
    //   73: astore_0
    //   74: ldc_w 321
    //   77: iconst_2
    //   78: ldc_w 556
    //   81: aload_2
    //   82: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_1
    //   86: ifnull -27 -> 59
    //   89: aload_1
    //   90: invokeinterface 540 1 0
    //   95: goto -36 -> 59
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +9 -> 111
    //   105: aload_0
    //   106: invokeinterface 540 1 0
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: goto -13 -> 101
    //   117: astore_2
    //   118: goto -54 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramUri	android.net.Uri
    //   0	121	2	paramArrayOfString1	String[]
    //   0	121	3	paramString	String
    //   0	121	4	paramArrayOfString2	String[]
    //   34	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   0	14	61	java/lang/Throwable
    //   0	14	98	finally
    //   16	25	113	finally
    //   27	36	113	finally
    //   66	72	113	finally
    //   74	85	113	finally
    //   16	25	117	java/lang/Throwable
    //   27	36	117	java/lang/Throwable
  }
  
  public static List<LocalMediaInfo> queryRecentImages(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    return queryRecentImages(paramContext, paramInt1, paramInt2, paramMediaFileFilter, false, 0, null, false);
  }
  
  public static void reportRawPicAndVideo(int paramInt1, int paramInt2)
  {
    bdla.b(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, paramInt1 + "", paramInt2 + "", "", "");
  }
  
  public static void reportRawVideo()
  {
    bdla.b(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
  }
  
  public static void returnToInitActivity(Activity paramActivity, Class<?> paramClass, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    anim(paramActivity, true, false);
  }
  
  public static void setQualityTvRawPhotoText(TextView paramTextView, List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Activity paramActivity, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    label254:
    label255:
    for (;;)
    {
      LocalMediaInfo localLocalMediaInfo;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (NetworkUtils.isNetworkUrl(str)) {
          continue;
        }
        localLocalMediaInfo = null;
        if (paramMap2 != null) {
          localLocalMediaInfo = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((localLocalMediaInfo != null) || (paramMap1 == null)) {
          break label254;
        }
        localLocalMediaInfo = (LocalMediaInfo)paramMap1.get(str);
      }
      for (;;)
      {
        if ((localLocalMediaInfo == null) || (getMediaType(localLocalMediaInfo) != 1)) {
          break label255;
        }
        break;
        int i = getSelectFileTotolLen(paramList, paramMap1, paramBoolean, paramHashMap, paramMap2);
        if (i == 0) {
          paramTextView.setVisibility(4);
        }
        do
        {
          return;
          paramMap1 = PhotoUtils.getRawPhotoSize(paramActivity, i);
          if (paramMap1.equals("0"))
          {
            paramMap1 = "(999K)";
            paramTextView.setVisibility(4);
          }
          for (;;)
          {
            int j = paramMap1.length();
            i = 0;
            while (i < 6 - j)
            {
              paramMap1 = paramMap1 + " ";
              i += 1;
            }
            paramMap1 = "(" + paramMap1 + ")";
            paramTextView.setVisibility(0);
          }
          paramTextView.setText(paramMap1);
        } while (!paramList.isEmpty());
        paramTextView.setVisibility(4);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */