package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public class AlbumUtil
  extends QAlbumUtil
{
  public static final int[] a = { 0, 3000, 1, 10014 };
  private static List<LocalMediaInfo> b;
  private static long c;
  
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
        int i = 1;
        localObject2 = paramList.iterator();
        paramList = (List<String>)localObject1;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (i == 0) {
            paramList.append(" OR ");
          } else {
            i = 0;
          }
          paramList.append(" ( ");
          paramList = a("bucket_id", paramList, (String)localObject1);
          paramList.append(" ) ");
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    ReportController.b(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
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
  
  public static boolean a(int paramInt)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLocalMediaInfo != null)
    {
      int i = getMediaType(paramLocalMediaInfo);
      boolean bool3 = true;
      bool1 = bool2;
      if (i == 1)
      {
        if (paramBoolean) {
          i = d();
        } else {
          i = c();
        }
        paramBoolean = bool3;
        StringBuilder localStringBuilder;
        if (paramInt >= i)
        {
          if (System.currentTimeMillis() - c > 2000L)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131898472));
            localStringBuilder.append(i);
            localStringBuilder.append(HardCodeUtil.a(2131898473));
            QQToast.makeText(paramContext, localStringBuilder.toString(), 0).show();
            c = System.currentTimeMillis();
          }
          paramBoolean = false;
        }
        long l = QZoneHelper.getVideoCanUploadSize();
        if (paramLocalMediaInfo.fileSize > l)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131898471));
          localStringBuilder.append((float)l / 1024.0F / 1024.0F / 1024.0F);
          localStringBuilder.append("G的视频");
          QQToast.makeText(paramContext, localStringBuilder.toString(), 0).show();
          paramBoolean = false;
        }
        if (paramLocalMediaInfo.mDuration > 601000L)
        {
          paramLocalMediaInfo = new StringBuilder();
          paramLocalMediaInfo.append(HardCodeUtil.a(2131898470));
          paramLocalMediaInfo.append(10L);
          paramLocalMediaInfo.append(HardCodeUtil.a(2131898474));
          QQToast.makeText(paramContext, paramLocalMediaInfo.toString(), 0).show();
          return false;
        }
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public static boolean a(List<String> paramList, Activity paramActivity, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() >= paramInt))
    {
      QQToast.makeText(paramActivity, String.format(paramActivity.getResources().getString(2131915844), new Object[] { Integer.valueOf(paramInt) }), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    return false;
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
  
  public static int c()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static int d()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static float e()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static void f()
  {
    ReportController.b(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */