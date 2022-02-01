package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

class HealthBusinessPlugin$13
  implements ISuperPlayer.OnVideoPreparedListener
{
  HealthBusinessPlugin$13(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "onVideoPrepared video");
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramISuperPlayer.pause();
      this.a.jdField_a_of_type_AndroidOsHandler.post(this.a.b);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
      paramISuperPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.13
 * JD-Core Version:    0.7.0.1
 */