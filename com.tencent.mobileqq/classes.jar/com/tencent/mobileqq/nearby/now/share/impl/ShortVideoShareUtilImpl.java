package com.tencent.mobileqq.nearby.now.share.impl;

import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil;
import mqq.app.AppActivity;

public class ShortVideoShareUtilImpl
  implements IShortVideoShareUtil
{
  public Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    return ShortVideoShareUtil.a(paramDrawable);
  }
  
  public Bitmap makeShareBitmap(String paramString)
  {
    return ShortVideoShareUtil.a(paramString);
  }
  
  public void showShareActionSheet(AppInterface paramAppInterface, AppActivity paramAppActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URLDrawable paramURLDrawable, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ShortVideoShareUtil.a((QQAppInterface)paramAppInterface, (BaseActivity)paramAppActivity, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURLDrawable, paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.impl.ShortVideoShareUtilImpl
 * JD-Core Version:    0.7.0.1
 */