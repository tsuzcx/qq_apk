package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$12$1
  implements View.OnTouchListener
{
  HealthBusinessPlugin$12$1(HealthBusinessPlugin.12 param12) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.a.e.keySet().iterator();
    while (paramView.hasNext())
    {
      paramMotionEvent = (String)paramView.next();
      SeekBar localSeekBar = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetSeekBar;
      TextView localTextView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_c_of_type_AndroidWidgetTextView;
      TextView localTextView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_b_of_type_AndroidWidgetTextView;
      ImageView localImageView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetImageView;
      ImageView localImageView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_b_of_type_AndroidWidgetImageView;
      TextView localTextView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_a_of_type_AndroidWidgetTextView;
      ImageView localImageView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.a.f.get(paramMotionEvent)).jdField_c_of_type_AndroidWidgetImageView;
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "videoplayer section clicked");
      }
      if (localSeekBar.getVisibility() == 4)
      {
        localSeekBar.setVisibility(0);
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(0);
        localImageView3.setVisibility(0);
        if (((ISuperPlayer)this.a.a.jdField_d_of_type_JavaUtilHashMap.get(paramMotionEvent)).isPlaying()) {}
        for (int i = 2130849014;; i = 2130849563)
        {
          localImageView1.setImageResource(i);
          localImageView1.setVisibility(0);
          this.a.a.jdField_d_of_type_Boolean = true;
          localImageView2.setVisibility(4);
          localTextView3.setVisibility(4);
          this.a.a.b.removeCallbacksAndMessages(null);
          paramMotionEvent = new HealthBusinessPlugin.12.1.1(this, localSeekBar, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
          this.a.a.b.postDelayed(paramMotionEvent, 3000L);
          break;
        }
      }
      localSeekBar.setVisibility(4);
      localTextView1.setVisibility(4);
      localTextView2.setVisibility(4);
      localImageView3.setVisibility(4);
      localImageView1.setVisibility(4);
      this.a.a.jdField_d_of_type_Boolean = false;
      localImageView2.setVisibility(0);
      localTextView3.setVisibility(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.12.1
 * JD-Core Version:    0.7.0.1
 */