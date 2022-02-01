package com.tencent.mobileqq.troop.honor.widget;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

public class TroopHonorView$WeakViewDownloadListener
  implements URLDrawable.URLDrawableListener
{
  private final WeakReference<ImageView> a;
  
  public TroopHonorView$WeakViewDownloadListener(ImageView paramImageView)
  {
    this.a = new WeakReference(paramImageView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (ImageView)this.a.get();
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = (ImageView)this.a.get();
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (ImageView)this.a.get();
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView.WeakViewDownloadListener
 * JD-Core Version:    0.7.0.1
 */