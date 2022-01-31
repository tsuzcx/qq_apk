package com.tencent.mobileqq.nearby.picbrowser;

import asrx;
import asrz;
import com.tencent.image.URLDrawable;

public class PicBrowserImage$3
  implements Runnable
{
  public PicBrowserImage$3(asrx paramasrx, URLDrawable paramURLDrawable, asrz paramasrz, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
      this.jdField_a_of_type_Asrz.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLDrawable.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.3
 * JD-Core Version:    0.7.0.1
 */