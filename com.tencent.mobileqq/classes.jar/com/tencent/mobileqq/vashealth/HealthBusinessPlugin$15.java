package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

class HealthBusinessPlugin$15
  implements ISuperPlayer.OnVideoPreparedListener
{
  HealthBusinessPlugin$15(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "onVideoPrepared video");
    }
    if (this.a.g)
    {
      paramISuperPlayer.pause();
      this.a.z.post(this.a.y);
    }
    else
    {
      paramISuperPlayer.start();
    }
    paramISuperPlayer = this.a;
    paramISuperPlayer.g = false;
    paramISuperPlayer.z.postDelayed(this.a.x, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.15
 * JD-Core Version:    0.7.0.1
 */