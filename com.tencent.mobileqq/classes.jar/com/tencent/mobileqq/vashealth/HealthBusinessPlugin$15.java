package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.TimerTask;

class HealthBusinessPlugin$15
  extends TimerTask
{
  HealthBusinessPlugin$15(HealthBusinessPlugin paramHealthBusinessPlugin, WeakReference paramWeakReference, String paramString, TextView paramTextView1, TextView paramTextView2, SeekBar paramSeekBar) {}
  
  public void run()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString);
    if ((localISuperPlayer != null) && (localTextView != null))
    {
      localTextView.post(new HealthBusinessPlugin.15.1(this, localTextView, localISuperPlayer));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "progress run " + localISuperPlayer.getCurrentPositionMs());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.15
 * JD-Core Version:    0.7.0.1
 */