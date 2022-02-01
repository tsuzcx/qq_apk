package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.OnSingleDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ThemeHbFragment$2
  implements IPreloadImgApi.OnSingleDownloadCallback
{
  ThemeHbFragment$2(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (ThemeHbFragment.e(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back context is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImageBgProcess download back drawable = ");
      localStringBuilder.append(paramObject);
      QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
    }
    if ((paramObject instanceof Drawable))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess image set...");
      }
      ThemeHbFragment.e(this.a).post(new ThemeHbFragment.2.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.2
 * JD-Core Version:    0.7.0.1
 */