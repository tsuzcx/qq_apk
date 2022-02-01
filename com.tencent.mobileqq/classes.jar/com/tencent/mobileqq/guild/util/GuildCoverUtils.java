package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import mqq.app.MobileQQ;

public class GuildCoverUtils
{
  public static int a = 1024;
  
  public static int a(int paramInt)
  {
    return (int)(paramInt * 0.5546666F);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (SystemUtil.a())
    {
      localStringBuilder.append(AppConstants.SDCARD_PATH_TROOPPHOTO);
      localStringBuilder.append("tmp/");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("_photo.tmp");
      return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    }
    localStringBuilder.append(MobileQQ.sMobileQQ.getBaseContext().getFilesDir());
    localStringBuilder.append("/tmp/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_photo.tmp");
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    Point localPoint = b(paramActivity, paramInt);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", paramInt);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", a);
    localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    localIntent.putExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", false);
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 50);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", QQGuildPhotoListCustomizationCrop.a);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.TARGET_PATH", a());
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", localPoint.x);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", localPoint.y);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", localPoint.x);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", localPoint.y);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    paramActivity.startActivity(localIntent);
  }
  
  public static Point b(Activity paramActivity, int paramInt)
  {
    Point localPoint = new Point();
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
      i = localDisplayMetrics.widthPixels;
    } else {
      i = localDisplayMetrics.heightPixels;
    }
    if (paramInt != 102)
    {
      paramInt = i - Utils.a(65.0F, paramActivity.getResources());
      localPoint.set(paramInt, paramInt);
      return localPoint;
    }
    localPoint.set(i, a(i));
    return localPoint;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 0) {
      return "上传成功";
    }
    if (paramInt == 1001) {
      return "上传失败，超过修改次数上限";
    }
    return "上传失败，请稍后重试";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildCoverUtils
 * JD-Core Version:    0.7.0.1
 */