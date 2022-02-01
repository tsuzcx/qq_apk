package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.TimerTask;

class HealthBusinessPlugin$17
  extends TimerTask
{
  HealthBusinessPlugin$17(HealthBusinessPlugin paramHealthBusinessPlugin, WeakReference paramWeakReference, String paramString, TextView paramTextView1, TextView paramTextView2, SeekBar paramSeekBar) {}
  
  public void run()
  {
    Object localObject = (TextView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString);
    if ((localISuperPlayer != null) && (localObject != null))
    {
      ((TextView)localObject).post(new HealthBusinessPlugin.17.1(this, (TextView)localObject, localISuperPlayer));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("progress run ");
        ((StringBuilder)localObject).append(localISuperPlayer.getCurrentPositionMs());
        QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.17
 * JD-Core Version:    0.7.0.1
 */