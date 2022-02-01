package com.tencent.qqmini.proxyimpl;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ChannelProxyImpl$16
  implements Runnable
{
  ChannelProxyImpl$16(ChannelProxyImpl paramChannelProxyImpl, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    try
    {
      Drawable localDrawable = this.a.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof ApngDrawable)) && (((ApngDrawable)localDrawable).getImage() != null))
      {
        ApngImage.playByTag(32);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ChannelProxyImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.16
 * JD-Core Version:    0.7.0.1
 */