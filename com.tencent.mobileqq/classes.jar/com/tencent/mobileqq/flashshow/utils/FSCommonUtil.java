package com.tencent.mobileqq.flashshow.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Time;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FSCommonUtil
{
  public static FeedCloudMeta.StFeed a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e("FSCommonUtil", 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    localStFeed.busiTranparent.set(paramStFeed.busiTranparent.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e("FSCommonUtil", 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public static String a()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = FSHardCodeUtil.a(2131889505);
    } else {
      str = "W";
    }
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / paramInt1;
    float f2 = FSConfig.a("qqflash", "qqflash_show_vertical_video_max_ratio", Integer.valueOf(20)).intValue() / 10.0F;
    float f3 = FSConfig.a("qqflash", "qqflash_show_vertical_video_min_ratio", Integer.valueOf(15)).intValue() / 10.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSize origin size shouldFullScreen():");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(f1);
    localStringBuilder.append("|");
    localStringBuilder.append(f2);
    localStringBuilder.append("|");
    localStringBuilder.append(f3);
    QLog.d("FSCommonUtil", 1, localStringBuilder.toString());
    return (f1 > f3) && (f1 < f2);
  }
  
  public static boolean a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if ((paramStFeed1 != null) && (paramStFeed2 != null)) {
      return paramStFeed1.id.get().equals(paramStFeed2.id.get());
    }
    return false;
  }
  
  public static boolean a(@NonNull FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (a().equals(paramStUser.id.get()));
  }
  
  public static boolean a(String paramString)
  {
    return a().equals(paramString);
  }
  
  public static Drawable b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return FSTransUtils.f().getResources().getDrawable(2130840388);
    }
    Bitmap localBitmap = HostFaceUtils.getBitmapFromCache(HostFaceUtils.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true));
    if (localBitmap != null) {
      return new BitmapDrawable(localBitmap);
    }
    return HostFaceUtils.getFaceDrawable(1, 4, paramString);
  }
  
  public static FeedCloudMeta.StUser b()
  {
    return c();
  }
  
  public static String b(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    if (paramLong == 0L) {
      localObject1 = new Date();
    } else {
      localObject1 = new Date(paramLong);
    }
    localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    paramLong = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(paramLong);
    int i = localTime2.yearDay - 1;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(" ");
    ((StringBuilder)localObject3).append(localTime1.hour);
    ((StringBuilder)localObject3).append(":");
    if (localTime1.minute < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(localTime1.minute);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(localTime1.minute);
    }
    ((StringBuilder)localObject3).append(localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject1 = localObject2;
    if (localTime1.year == localTime2.year)
    {
      if (localTime2.yearDay < localTime1.yearDay) {
        return localObject2;
      }
      if (localTime2.yearDay == localTime1.yearDay)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FSHardCodeUtil.a(2131917319));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      if (localTime1.yearDay == i)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FSHardCodeUtil.a(2131918208));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      if (localTime1.yearDay + 1 == i)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FSHardCodeUtil.a(2131887542));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localTime1.month + 1);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(localTime1.monthDay);
      ((StringBuilder)localObject1).append((String)localObject3);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / paramInt1;
    float f2 = FSConfig.a("qqflash", "qqflash_show_vertical_video_max_ratio", Integer.valueOf(20)).intValue() / 10.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSize origin size shouldFullScreen():");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(f1);
    localStringBuilder.append("|");
    localStringBuilder.append(f2);
    QLog.d("FSCommonUtil", 1, localStringBuilder.toString());
    return f1 >= f2;
  }
  
  public static boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.video.fileId.get()));
  }
  
  public static FeedCloudMeta.StUser c()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(FSTransUtils.a());
    localStUser.nick.set(HostDataTransUtils.getAccountNickName(FSTransUtils.a()));
    return localStUser;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return paramString;
      }
      int i = paramString.indexOf("?");
      if (i == -1) {
        return paramString;
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static int d(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("https://")) {
        return 0;
      }
      if (paramString.startsWith("mqqapi://")) {
        return 1;
      }
    }
    return -1;
  }
  
  public static boolean d()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSCommonUtil
 * JD-Core Version:    0.7.0.1
 */