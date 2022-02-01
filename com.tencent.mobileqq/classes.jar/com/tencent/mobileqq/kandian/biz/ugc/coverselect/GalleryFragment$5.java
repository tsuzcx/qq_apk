package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.imagecrop.GestureCropImageView;
import com.tencent.mobileqq.kandian.base.imagecrop.UCropView;

class GalleryFragment$5
  implements Runnable
{
  GalleryFragment$5(GalleryFragment paramGalleryFragment, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((GalleryFragment.d(this.this$0) != null) && (GalleryFragment.d(this.this$0).getCropImageView() != null)) {
      GalleryFragment.d(this.this$0).getCropImageView().setImageBitmap(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.GalleryFragment.5
 * JD-Core Version:    0.7.0.1
 */