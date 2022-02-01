package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class KSongView$KHandler
  extends Handler
{
  WeakReference<KSongView> a;
  
  public KSongView$KHandler(KSongView paramKSongView)
  {
    this.a = new WeakReference(paramKSongView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = (KSongView)this.a.get();
      if (paramMessage != null)
      {
        if (1 != paramMessage.getState()) {
          return;
        }
        long l = System.currentTimeMillis() - KSongView.a(paramMessage) - paramMessage.a;
        KSHelper.Config localConfig = paramMessage.getConfig();
        paramMessage.a(l);
        if (l >= localConfig.f) {
          KSongView.a(paramMessage, l);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("real_duration = ");
        localStringBuilder.append(l);
        QLog.i("KSongView", 2, localStringBuilder.toString());
        if (l < localConfig.g)
        {
          sendEmptyMessageDelayed(0, 50L);
          return;
        }
        KSongView.a(paramMessage, 3);
        if (KSongView.b(paramMessage) != null) {
          KSongView.b(paramMessage).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView.KHandler
 * JD-Core Version:    0.7.0.1
 */