package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.pic.PictureView;

class AIOPictureView$10
  implements IGalleryImageListener
{
  AIOPictureView$10(AIOPictureView paramAIOPictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.e.y.setVisibility(8);
    if (paramBoolean)
    {
      AIOPictureView.a(this.e, this.a, this.b, this.c, paramInt);
      return;
    }
    AIOPictureView localAIOPictureView = this.e;
    if (!AIOPictureView.a(localAIOPictureView, this.d, localAIOPictureView.k.imageView))
    {
      localAIOPictureView = this.e;
      if (!AIOPictureView.a(localAIOPictureView, this.d, localAIOPictureView.k.imageView))
      {
        localAIOPictureView = this.e;
        if (!AIOPictureView.b(localAIOPictureView, this.d, localAIOPictureView.k.imageView))
        {
          localAIOPictureView = this.e;
          AIOPictureView.a(localAIOPictureView, localAIOPictureView.k.imageView);
        }
      }
    }
    AIOPictureView.a(this.e, this.d.a, this.d.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.10
 * JD-Core Version:    0.7.0.1
 */