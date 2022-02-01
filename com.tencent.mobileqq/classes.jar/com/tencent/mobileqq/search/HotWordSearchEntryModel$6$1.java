package com.tencent.mobileqq.search;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class HotWordSearchEntryModel$6$1
  implements GifDrawable.OnGIFPlayOnceListener
{
  HotWordSearchEntryModel$6$1(HotWordSearchEntryModel.6 param6, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$6.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$OnGifPlayListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$6.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$OnGifPlayListener.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$6.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    AbstractGifImage.pauseAll();
    ((URLImageView)this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel$6.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.6.1
 * JD-Core Version:    0.7.0.1
 */