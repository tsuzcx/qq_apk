package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import cooperation.qwallet.plugin.QWalletPicHelper;

class HongBaoPanel$2
  implements URLDrawable.URLDrawableListener
{
  HongBaoPanel$2(HongBaoPanel paramHongBaoPanel, RedPacketInfo paramRedPacketInfo, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = QWalletPicHelper.getDrawableForAIO(this.a.resPath, URLDrawableHelperConstants.a);
    HongBaoPanel.a(this.c).setImageDrawable(paramURLDrawable);
    ((URLDrawable)this.b).setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.2
 * JD-Core Version:    0.7.0.1
 */