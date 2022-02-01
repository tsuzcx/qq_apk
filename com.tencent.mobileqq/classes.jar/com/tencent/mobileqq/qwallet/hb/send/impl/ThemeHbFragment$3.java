package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.widget.LinearLayout;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.OnSingleDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ThemeHbFragment$3
  implements IPreloadImgApi.OnSingleDownloadCallback
{
  ThemeHbFragment$3(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAnimFrameBgProcess download back obj = ");
      localStringBuilder.append(paramObject);
      QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
    }
    if (((paramObject instanceof String)) && (ThemeHbFragment.a(this.a) != null)) {
      ThemeHbFragment.a(this.a).post(new ThemeHbFragment.3.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.3
 * JD-Core Version:    0.7.0.1
 */