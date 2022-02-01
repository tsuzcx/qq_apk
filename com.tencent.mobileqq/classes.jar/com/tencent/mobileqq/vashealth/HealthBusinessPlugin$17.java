package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.TimerTask;
import six;

class HealthBusinessPlugin$17
  extends TimerTask
{
  HealthBusinessPlugin$17(HealthBusinessPlugin paramHealthBusinessPlugin, WeakReference paramWeakReference, String paramString, TextView paramTextView1, TextView paramTextView2, SeekBar paramSeekBar) {}
  
  public void run()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTextView != null)
    {
      six.a(localTextView, ((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getDuration() - ((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getCurrentPostion());
      six.a(this.jdField_a_of_type_AndroidWidgetTextView, ((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getCurrentPostion());
      six.a(this.b, ((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getDuration());
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * (float)((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getCurrentPostion() / (float)((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getDuration() + 0.5D));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "progress run " + ((TVK_IMediaPlayer)this.this$0.d.get(this.jdField_a_of_type_JavaLangString)).getCurrentPostion());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.17
 * JD-Core Version:    0.7.0.1
 */