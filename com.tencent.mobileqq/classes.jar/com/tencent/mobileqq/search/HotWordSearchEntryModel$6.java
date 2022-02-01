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
    if (this.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    paramURLDrawable = (URLImageView)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getImage();
      localAbstractGifImage.reset();
      localAbstractGifImage.setStrongGIFPlayOnceListener(new HotWordSearchEntryModel.6.1(this, localAbstractGifImage));
      paramURLDrawable.setVisibility(0);
      paramURLDrawable.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$OnGifPlayListener;
      if (paramURLDrawable != null) {
        paramURLDrawable.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.6
 * JD-Core Version:    0.7.0.1
 */