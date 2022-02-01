package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public class AlbumUtil
  extends QAlbumUtil
{
  private static long jdField_a_of_type_Long;
  private static List<LocalMediaInfo> jdField_a_of_type_JavaUtilList = null;
  public static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3000, 1 };
  }
  
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static int a(List<String> paramList, int paramInt, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
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
          break label148;
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "sendQualityPicLimit", true, paramInt, l, null, "");
        i += 1;
      }
    }
    label148:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(List<String> paramList, long paramLong, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
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
  
  public static int a(List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
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
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static String a(List<String> paramList)
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
            paramList = a("bucket_id", paramList, (String)localObject1);
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
  
  private static StringBuilder a(String paramString1, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    return queryRecentImages(paramContext, paramInt1, paramInt2, paramMediaFileFilter, false, 0, null, false);
  }
  
  public static void a() {}
  
  public static void a(int paramInt1, int paramInt2)
  {
    ReportController.b(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, paramInt1 + "", paramInt2 + "", "", "");
  }
  
  public static void a(Intent paramIntent)
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
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  public static void a(TextView paramTextView, List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Activity paramActivity, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
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
        int i = a(paramList, paramMap1, paramBoolean, paramHashMap, paramMap2);
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
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, String paramString)
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
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
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
  
  public static boolean a(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramLocalMediaInfo != null) && (getMediaType(paramLocalMediaInfo) == 1)) {
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (int i = b();; i = a())
    {
      paramBoolean = bool;
      if (paramInt >= i)
      {
        if (System.currentTimeMillis() - jdField_a_of_type_Long > 2000L)
        {
          QQToast.a(paramContext, HardCodeUtil.a(2131700298) + i + HardCodeUtil.a(2131700299), 0).a();
          jdField_a_of_type_Long = System.currentTimeMillis();
        }
        paramBoolean = false;
      }
      long l = QZoneHelper.getVideoCanUploadSize();
      if (paramLocalMediaInfo.fileSize > l)
      {
        QQToast.a(paramContext, HardCodeUtil.a(2131700297) + (float)l / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).a();
        paramBoolean = false;
      }
      if (paramLocalMediaInfo.mDuration <= 601000L) {
        break;
      }
      QQToast.a(paramContext, HardCodeUtil.a(2131700296) + 10L + HardCodeUtil.a(2131700300), 0).a();
      return false;
    }
    return paramBoolean;
  }
  
  public static boolean a(List<String> paramList, Activity paramActivity, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() >= paramInt))
    {
      QQToast.a(paramActivity, String.format(paramActivity.getResources().getString(2131718634), new Object[] { Integer.valueOf(paramInt) }), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299166));
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static void b()
  {
    sLastAlbumPhotoCountMap.clear();
    sLastAlbumPath = null;
    sLastAlbumRecordTime = 0L;
    sLastAlbumId = null;
    sLastAlbumName = null;
  }
  
  public static void c()
  {
    ReportController.b(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */