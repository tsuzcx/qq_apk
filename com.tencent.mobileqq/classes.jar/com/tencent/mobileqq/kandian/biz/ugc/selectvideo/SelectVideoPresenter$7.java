package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.utils.ImageUtil;

class SelectVideoPresenter$7
  implements URLDrawable.URLDrawableListener
{
  SelectVideoPresenter$7(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SelectVideoPresenter.e(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = SelectVideoPresenter.a(this.a, ImageUtil.b(paramURLDrawable.getCurrDrawable()));
    SelectVideoPresenter localSelectVideoPresenter = this.a;
    SelectVideoPresenter.a(localSelectVideoPresenter, paramURLDrawable, SelectVideoPresenter.d(localSelectVideoPresenter).k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.7
 * JD-Core Version:    0.7.0.1
 */