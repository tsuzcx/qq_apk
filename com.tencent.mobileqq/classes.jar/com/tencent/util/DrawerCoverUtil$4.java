package com.tencent.util;

import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.widget.UpSideDownDrawable;

final class DrawerCoverUtil$4
  implements Runnable
{
  DrawerCoverUtil$4(RandomCoverView paramRandomCoverView, UpSideDownDrawable paramUpSideDownDrawable, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable.resume();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.4
 * JD-Core Version:    0.7.0.1
 */