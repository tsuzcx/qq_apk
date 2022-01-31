package com.tencent.util;

import android.widget.ImageView.ScaleType;
import bfwx;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$4
  implements Runnable
{
  public DrawerCoverUtil$4(RandomCoverView paramRandomCoverView, bfwx parambfwx, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(this.jdField_a_of_type_Bfwx);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfwx.d();
      return;
    }
    this.jdField_a_of_type_Bfwx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.4
 * JD-Core Version:    0.7.0.1
 */