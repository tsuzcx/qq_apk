package com.tencent.mobileqq.nearby.picbrowser;

import atob;
import atod;
import com.tencent.image.URLDrawable;

public class PicBrowserImage$3
  implements Runnable
{
  public PicBrowserImage$3(atob paramatob, URLDrawable paramURLDrawable, atod paramatod, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
      this.jdField_a_of_type_Atod.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLDrawable.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.3
 * JD-Core Version:    0.7.0.1
 */