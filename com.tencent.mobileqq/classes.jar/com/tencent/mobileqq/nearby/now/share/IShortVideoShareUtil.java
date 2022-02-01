package com.tencent.mobileqq.nearby.now.share;

import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppActivity;

@QAPI(process={"all"})
public abstract interface IShortVideoShareUtil
  extends QRouteApi
{
  public static final int NOW_SHORT_VIDEO_REQUEST_CODE = 123;
  public static final int NOW_SHORT_VIDEO_REQUEST_CODE_FOR_SHARE_QZONE = 124;
  
  public abstract Bitmap drawableToBitmap(Drawable paramDrawable);
  
  public abstract Bitmap makeShareBitmap(String paramString);
  
  public abstract void showShareActionSheet(AppInterface paramAppInterface, AppActivity paramAppActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URLDrawable paramURLDrawable, DialogInterface.OnDismissListener paramOnDismissListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil
 * JD-Core Version:    0.7.0.1
 */