package com.tencent.mobileqq.newnearby.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.newnearby.INearbyAlbumHelper;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class NearbyAlbumHelperImpl
  implements INearbyAlbumHelper
{
  private static final int ALBUM_TYPE = 1;
  private static final int QZONE_TYPE = 2;
  private static final String TAG = "NearbyAlbumHelper";
  private static boolean lock;
  private static String picPath;
  private static Promise picPromise;
  private static Promise uploadPromise;
  
  /* Error */
  private static String bitmapToBase64(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +116 -> 119
    //   6: new 36	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 43	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: aload_2
    //   23: invokevirtual 49	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: invokevirtual 52	java/io/ByteArrayOutputStream:flush	()V
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 59	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: iconst_0
    //   46: invokestatic 65	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto +69 -> 121
    //   55: astore_0
    //   56: goto +12 -> 68
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: goto +35 -> 97
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   74: aload_2
    //   75: ifnull +19 -> 94
    //   78: aload_2
    //   79: invokevirtual 52	java/io/ByteArrayOutputStream:flush	()V
    //   82: aload_2
    //   83: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   86: goto +8 -> 94
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: aload_1
    //   98: ifnull +19 -> 117
    //   101: aload_1
    //   102: invokevirtual 52	java/io/ByteArrayOutputStream:flush	()V
    //   105: aload_1
    //   106: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   117: aload_0
    //   118: athrow
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_1
    //   122: ifnull +18 -> 140
    //   125: aload_1
    //   126: invokevirtual 52	java/io/ByteArrayOutputStream:flush	()V
    //   129: aload_1
    //   130: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   140: aload_0
    //   141: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramBitmap	Bitmap
    //   1	105	1	localObject	Object
    //   112	18	1	localIOException1	IOException
    //   135	2	1	localIOException2	IOException
    //   13	70	2	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   16	27	55	java/io/IOException
    //   29	33	55	java/io/IOException
    //   35	39	55	java/io/IOException
    //   41	50	55	java/io/IOException
    //   6	14	59	finally
    //   6	14	65	java/io/IOException
    //   78	86	89	java/io/IOException
    //   16	27	96	finally
    //   29	33	96	finally
    //   35	39	96	finally
    //   41	50	96	finally
    //   70	74	96	finally
    //   101	109	112	java/io/IOException
    //   125	133	135	java/io/IOException
  }
  
  private static Bitmap compressBitmap(Bitmap paramBitmap, double paramDouble)
  {
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    double d1 = ((ByteArrayOutputStream)localObject).toByteArray().length / 1024;
    localObject = paramBitmap;
    if (d1 > paramDouble)
    {
      Double.isNaN(d1);
      paramDouble = d1 / paramDouble;
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      localObject = new Matrix();
      d1 = paramBitmap.getWidth();
      double d2 = Math.sqrt(paramDouble);
      Double.isNaN(d1);
      d1 /= d2;
      d2 = f1;
      Double.isNaN(d2);
      float f3 = (float)(d1 / d2);
      d1 = paramBitmap.getHeight();
      paramDouble = Math.sqrt(paramDouble);
      Double.isNaN(d1);
      paramDouble = d1 / paramDouble;
      d1 = f2;
      Double.isNaN(d1);
      ((Matrix)localObject).postScale(f3, (float)(paramDouble / d1));
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    }
    return localObject;
  }
  
  public static boolean getLock()
  {
    return lock;
  }
  
  public static void onPickPhoto(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    try
    {
      picPath = (String)paramIntent.get(0);
      paramIntent = new FileInputStream(picPath);
      localObject = bitmapToBase64(compressBitmap(BitmapFactory.decodeStream(paramIntent), 25.0D));
      paramIntent.close();
      NearbyHippyCallback.a(picPromise, (String)localObject);
      return;
    }
    catch (IOException paramIntent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPickPhoto error=");
      ((StringBuilder)localObject).append(paramIntent.getMessage().toString());
      QLog.e("NearbyAlbumHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void onPickPhotoFromQZone(Intent paramIntent)
  {
    picPath = paramIntent.getStringExtra("key_cover_selected_img_path");
    if (TextUtils.isEmpty(picPath)) {
      return;
    }
    try
    {
      paramIntent = new FileInputStream(picPath);
      localObject = bitmapToBase64(compressBitmap(BitmapFactory.decodeStream(paramIntent), 25.0D));
      paramIntent.close();
      NearbyHippyCallback.a(picPromise, (String)localObject);
      return;
    }
    catch (IOException paramIntent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPickPhoto error=");
      ((StringBuilder)localObject).append(paramIntent.getMessage().toString());
      QLog.e("NearbyAlbumHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void openAlbum(int paramInt, NearbyActivity paramNearbyActivity, Promise paramPromise)
  {
    setLock(true);
    picPromise = paramPromise;
    if (paramInt == 1)
    {
      selectPhotoFromAlbum(paramNearbyActivity);
      return;
    }
    if (paramInt == 2) {
      selectPhotoFromQZone(paramNearbyActivity);
    }
  }
  
  private static void selectPhotoFromAlbum(NearbyActivity paramNearbyActivity)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramNearbyActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramNearbyActivity.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("nearby_people_photo/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("enter_from", 30);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationNearby.a);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(paramNearbyActivity, false, true);
  }
  
  private static void selectPhotoFromQZone(NearbyActivity paramNearbyActivity)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramNearbyActivity.app.getCurrentAccountUin();
    localUserInfo.nickname = paramNearbyActivity.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", paramNearbyActivity.getString(2131914927));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(paramNearbyActivity, localUserInfo, localBundle, 5);
  }
  
  public static void setLock(boolean paramBoolean)
  {
    lock = paramBoolean;
  }
  
  public static void uploadPicture(NearbyActivity paramNearbyActivity, Promise paramPromise)
  {
    uploadPromise = paramPromise;
    if (TextUtils.isEmpty(picPath)) {
      return;
    }
    new Handler().post(new NearbyAlbumHelperImpl.1(paramNearbyActivity));
  }
  
  public void onUploadPic(int paramInt)
  {
    NearbyHippyCallback.a(uploadPromise, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl
 * JD-Core Version:    0.7.0.1
 */