package com.tencent.mobileqq.richmediabrowser.presenter;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOPicturePresenter$1
  implements IGalleryImageListener
{
  AIOPicturePresenter$1(AIOPicturePresenter paramAIOPicturePresenter, URLDrawable paramURLDrawable) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.b.e.y.setVisibility(8);
    if (paramBoolean)
    {
      this.b.a(paramInt, this.a);
      paramInt = this.a.getExifOrientation();
      if ((this.b.e.k != null) && (this.b.e.k.imageView != null)) {
        this.b.e.k.imageView.initDrawable(this.a, this.b.e.i, this.b.e.j, BrowserUtils.a(paramInt));
      }
    }
    else
    {
      QQToast.makeText(this.b.e.c, this.b.e.c.getString(2131915746), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter.1
 * JD-Core Version:    0.7.0.1
 */