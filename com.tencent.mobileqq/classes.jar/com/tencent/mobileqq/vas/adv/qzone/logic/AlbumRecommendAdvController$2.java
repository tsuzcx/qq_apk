package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;

class AlbumRecommendAdvController$2
  implements ImageLoader.ImageLoadListener
{
  AlbumRecommendAdvController$2(AlbumRecommendAdvController paramAlbumRecommendAdvController, AlumBasicData paramAlumBasicData) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && (AlbumRecommendAdvController.d(this.b) != null)) {
      AlbumRecommendAdvController.d(this.b).post(new AlbumRecommendAdvController.2.1(this, paramDrawable));
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.2
 * JD-Core Version:    0.7.0.1
 */