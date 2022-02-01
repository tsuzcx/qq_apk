package com.tencent.mobileqq.gamecenter.view;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageSwitcher;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.util.List;

public class QQGameImagePlayHelper
  implements Handler.Callback
{
  private WeakReference<ImageSwitcher> a;
  private WeakReference<ImageSwitcher> b;
  private List<String> c;
  private int d;
  private int e;
  private Handler f;
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameImagePlayHelper", 0, "[handleMessage] set next image");
      }
      int i;
      if ((this.a != null) && (this.a.get() != null))
      {
        paramMessage = (ImageSwitcher)this.a.get();
        i = this.d + 1;
        this.d = i;
        if (i == this.c.size()) {
          this.d = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.c.get(this.d)));
      }
      if ((this.b != null) && (this.b.get() != null))
      {
        paramMessage = (ImageSwitcher)this.b.get();
        i = this.e + 1;
        this.e = i;
        if (i == this.c.size()) {
          this.e = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.c.get(this.e)));
      }
      this.f.removeMessages(1);
      this.f.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    catch (Exception paramMessage)
    {
      label208:
      break label208;
    }
    QLog.e("QQGameImagePlayHelper", 1, "[handleMessage] ");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameImagePlayHelper
 * JD-Core Version:    0.7.0.1
 */