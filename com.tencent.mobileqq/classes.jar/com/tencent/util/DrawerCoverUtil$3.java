package com.tencent.util;

import ajjc;
import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import beom;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$3
  implements Runnable
{
  public DrawerCoverUtil$3(BaseActivity paramBaseActivity, Bitmap paramBitmap, RandomCoverView paramRandomCoverView, boolean paramBoolean, ajjc paramajjc, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    beom localbeom = new beom(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(localbeom);
    if (this.jdField_a_of_type_Boolean) {
      localbeom.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajjc.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.strDrawerCardUrl, localbeom);
      return;
      localbeom.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.3
 * JD-Core Version:    0.7.0.1
 */