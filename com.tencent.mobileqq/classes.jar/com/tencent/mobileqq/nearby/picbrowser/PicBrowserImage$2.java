package com.tencent.mobileqq.nearby.picbrowser;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class PicBrowserImage$2
  implements URLDrawableDownListener
{
  PicBrowserImage$2(PicBrowserImage paramPicBrowserImage, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 10000)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.b(this.jdField_a_of_type_Int, paramInt / 100);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.2
 * JD-Core Version:    0.7.0.1
 */