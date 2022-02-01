package com.tencent.mobileqq.kandian.base.video.player;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class LitePlayer$UiHandler
  extends Handler
{
  private WeakReference<LitePlayer> a;
  
  public LitePlayer$UiHandler(LitePlayer paramLitePlayer)
  {
    this.a = new WeakReference(paramLitePlayer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (this.a.get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(LitePlayer.f((LitePlayer)this.a.get()), 2, "prePlay timeout, try rePlay");
        }
        if ((((LitePlayer)this.a.get()).s()) && (((LitePlayer)this.a.get()).b.E() == LitePlayer.g((LitePlayer)this.a.get())))
        {
          LitePlayer.h((LitePlayer)this.a.get());
          return;
        }
        LitePlayer.a((LitePlayer)this.a.get(), false);
        ((LitePlayer)this.a.get()).a(((LitePlayer)this.a.get()).b);
        LitePlayer.a((LitePlayer)this.a.get(), LitePlayer.g((LitePlayer)this.a.get()));
      }
    }
    else if (this.a.get() != null)
    {
      LitePlayer.c((LitePlayer)this.a.get());
      LitePlayer.e((LitePlayer)this.a.get()).sendEmptyMessageDelayed(0, LitePlayer.d((LitePlayer)this.a.get()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.UiHandler
 * JD-Core Version:    0.7.0.1
 */