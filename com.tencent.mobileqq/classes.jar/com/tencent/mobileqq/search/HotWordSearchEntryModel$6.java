package com.tencent.mobileqq.search;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

final class HotWordSearchEntryModel$6
  implements URLDrawable.URLDrawableListener2
{
  HotWordSearchEntryModel$6(SoftReference paramSoftReference, URLDrawable paramURLDrawable, HotWordSearchEntryModel.OnGifPlayListener paramOnGifPlayListener) {}
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {}
    do
    {
      do
      {
        return;
        paramURLDrawable = (URLImageView)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      } while (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof GifDrawable));
      AbstractGifImage localAbstractGifImage = ((GifDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getImage();
      localAbstractGifImage.reset();
      localAbstractGifImage.setStrongGIFPlayOnceListener(new HotWordSearchEntryModel.6.1(this, localAbstractGifImage));
      paramURLDrawable.setVisibility(0);
      paramURLDrawable.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    } while (this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$OnGifPlayListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$OnGifPlayListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.6
 * JD-Core Version:    0.7.0.1
 */