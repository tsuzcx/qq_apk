package com.tencent.util;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import anyl;
import blqp;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$3
  implements Runnable
{
  public DrawerCoverUtil$3(BaseActivity paramBaseActivity, Bitmap paramBitmap, RandomCoverView paramRandomCoverView, boolean paramBoolean, anyl paramanyl, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    blqp localblqp = new blqp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(localblqp);
    if (this.jdField_a_of_type_Boolean) {
      localblqp.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Anyl.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.strDrawerCardUrl, localblqp);
      return;
      localblqp.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.3
 * JD-Core Version:    0.7.0.1
 */