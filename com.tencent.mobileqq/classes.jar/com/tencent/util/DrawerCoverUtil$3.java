package com.tencent.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.widget.UpSideDownDrawable;

final class DrawerCoverUtil$3
  implements Runnable
{
  DrawerCoverUtil$3(QBaseActivity paramQBaseActivity, Bitmap paramBitmap, RandomCoverView paramRandomCoverView, boolean paramBoolean, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, Card paramCard) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject == null) {
      return;
    }
    localObject = new UpSideDownDrawable((Context)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable((Drawable)localObject);
    if (this.jdField_a_of_type_Boolean) {
      ((UpSideDownDrawable)localObject).start();
    } else {
      ((UpSideDownDrawable)localObject).stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.strDrawerCardUrl, (UpSideDownDrawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.3
 * JD-Core Version:    0.7.0.1
 */