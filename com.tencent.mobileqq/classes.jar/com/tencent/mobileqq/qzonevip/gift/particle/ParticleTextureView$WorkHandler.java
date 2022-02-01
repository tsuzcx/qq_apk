package com.tencent.mobileqq.qzonevip.gift.particle;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ParticleTextureView$WorkHandler
  extends Handler
{
  private Bitmap[] b;
  
  public ParticleTextureView$WorkHandler(ParticleTextureView paramParticleTextureView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage: MSG_REFRESH_VIEW size = ");
          paramMessage.append(this.a.d.size());
          QLog.i("ParticleTextureView", 1, paramMessage.toString());
          if ((this.a.d.size() > 0) || (!this.a.j)) {
            this.a.f();
          }
        }
        else
        {
          paramMessage = this.a;
          paramMessage.l += 1;
          this.a.b();
          if (this.a.c())
          {
            ParticleTextureView.a(this.a, 2);
            return;
          }
          ParticleTextureView.a(this.a, 4);
        }
      }
      else
      {
        this.a.l = 0;
        QLog.i("ParticleTextureView", 1, "handleMessage: MSG_ADD_DATA");
        this.a.a(this.b);
        ParticleTextureView.a(this.a, 4);
      }
    }
    else
    {
      QLog.i("ParticleTextureView", 1, "handleMessage: MSG_INIT_DATA");
      this.b = this.a.a();
      ParticleTextureView.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView.WorkHandler
 * JD-Core Version:    0.7.0.1
 */