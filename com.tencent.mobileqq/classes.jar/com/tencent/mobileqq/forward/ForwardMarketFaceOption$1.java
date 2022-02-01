package com.tencent.mobileqq.forward;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.ImageUtil;

class ForwardMarketFaceOption$1
  implements URLDrawable.URLDrawableListener
{
  ForwardMarketFaceOption$1(ForwardMarketFaceOption paramForwardMarketFaceOption) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(ImageUtil.a(paramURLDrawable, 36, 100, this.a.z));
    ForwardMarketFaceOption.a(this.a).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMarketFaceOption.1
 * JD-Core Version:    0.7.0.1
 */