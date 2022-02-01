package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.pic.PictureView;

class AIOFilePictureView$5
  implements IGalleryImageListener
{
  AIOFilePictureView$5(AIOFilePictureView paramAIOFilePictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.e.t.setVisibility(8);
    if (paramBoolean)
    {
      AIOFilePictureView.a(this.e, this.a, this.b, this.c, paramInt);
      return;
    }
    AIOFilePictureView localAIOFilePictureView = this.e;
    if (!AIOFilePictureView.a(localAIOFilePictureView, this.d, localAIOFilePictureView.l.imageView))
    {
      localAIOFilePictureView = this.e;
      if (!AIOFilePictureView.b(localAIOFilePictureView, this.d, localAIOFilePictureView.l.imageView))
      {
        localAIOFilePictureView = this.e;
        AIOFilePictureView.a(localAIOFilePictureView, localAIOFilePictureView.l.imageView);
      }
    }
    AIOFilePictureView.a(this.e, this.d.a, this.d.b, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.5
 * JD-Core Version:    0.7.0.1
 */