package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class PaFlashLightView$RefreshHandler
  extends Handler
{
  private WeakReference<PaFlashLightView> a;
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (PaFlashLightView)this.a.get();
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.g;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMessage.c.setVisibility(0);
        if (paramMessage.h)
        {
          paramMessage.c.startAnimation(paramMessage.d);
          return;
        }
        paramMessage.c.startAnimation(paramMessage.f);
        return;
      }
      paramMessage.b.setVisibility(0);
      if (paramMessage.h)
      {
        paramMessage.b.startAnimation(paramMessage.e);
        return;
      }
      paramMessage.b.startAnimation(paramMessage.f);
      return;
    }
    paramMessage.a.setVisibility(0);
    if (paramMessage.h)
    {
      paramMessage.startAnimation(paramMessage.d);
      return;
    }
    paramMessage.startAnimation(paramMessage.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */