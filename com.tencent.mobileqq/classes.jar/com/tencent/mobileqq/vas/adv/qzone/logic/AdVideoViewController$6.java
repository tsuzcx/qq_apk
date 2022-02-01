package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;

class AdVideoViewController$6
  implements ImageLoader.ImageLoadListener
{
  AdVideoViewController$6(AdVideoViewController paramAdVideoViewController, ImageView paramImageView, Boolean paramBoolean, AlumBasicData paramAlumBasicData) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null)) {
      AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController).post(new AdVideoViewController.6.1(this, paramDrawable));
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.6
 * JD-Core Version:    0.7.0.1
 */