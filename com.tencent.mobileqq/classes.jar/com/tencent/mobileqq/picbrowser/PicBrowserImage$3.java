package com.tencent.mobileqq.picbrowser;

import com.tencent.image.URLDrawable;

class PicBrowserImage$3
  implements Runnable
{
  PicBrowserImage$3(PicBrowserImage paramPicBrowserImage, URLDrawable paramURLDrawable, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
      this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLDrawable.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserImage.3
 * JD-Core Version:    0.7.0.1
 */