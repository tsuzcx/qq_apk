package com.tencent.mobileqq.nearby.now.share;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class ShortVideoShareUtil$7
  implements URLDrawable.URLDrawableListener
{
  ShortVideoShareUtil$7(String paramString1, IShortVideoShareUtil.OnShareCallBack paramOnShareCallBack, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130845467);
    WXShareHelper.a().a(new ShortVideoShareUtil.7.2(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_suc").LvInd1().reportByVideo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Bitmap localBitmap = ShortVideoShareUtil.a(paramURLDrawable);
    paramURLDrawable = localBitmap;
    if (localBitmap == null) {
      paramURLDrawable = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130845467);
    }
    WXShareHelper.a().a(new ShortVideoShareUtil.7.1(this));
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.b, paramURLDrawable, this.c, this.d);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_suc").LvInd1().reportByVideo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.7
 * JD-Core Version:    0.7.0.1
 */