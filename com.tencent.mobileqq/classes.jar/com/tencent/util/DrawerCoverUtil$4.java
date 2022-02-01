package com.tencent.util;

import android.widget.ImageView.ScaleType;
import blgc;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$4
  implements Runnable
{
  public DrawerCoverUtil$4(RandomCoverView paramRandomCoverView, blgc paramblgc, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(this.jdField_a_of_type_Blgc);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Blgc.d();
      return;
    }
    this.jdField_a_of_type_Blgc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.4
 * JD-Core Version:    0.7.0.1
 */