package com.tencent.mobileqq.vashealth;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$13
  implements View.OnTouchListener
{
  HealthBusinessPlugin$13(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("HealthBusinessPlugin", 2, "move clicked");
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("HealthBusinessPlugin", 2, "up clicked");
        }
        this.a.jdField_b_of_type_AndroidGraphicsPoint.x = ((int)paramMotionEvent.getRawX());
        this.a.jdField_b_of_type_AndroidGraphicsPoint.y = ((int)paramMotionEvent.getRawY());
        if ((Math.abs(this.a.a.y - this.a.jdField_b_of_type_AndroidGraphicsPoint.y) < 8) && (Math.abs(this.a.a.x - this.a.jdField_b_of_type_AndroidGraphicsPoint.x) < 8))
        {
          paramView = new Rect();
          paramMotionEvent = this.a.e.keySet().iterator();
          while (paramMotionEvent.hasNext())
          {
            Object localObject = (String)paramMotionEvent.next();
            FrameLayout localFrameLayout = (FrameLayout)this.a.e.get(localObject);
            SeekBar localSeekBar = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_a_of_type_AndroidWidgetSeekBar;
            TextView localTextView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_c_of_type_AndroidWidgetTextView;
            TextView localTextView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_b_of_type_AndroidWidgetTextView;
            ImageView localImageView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_a_of_type_AndroidWidgetImageView;
            ImageView localImageView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_b_of_type_AndroidWidgetImageView;
            TextView localTextView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_a_of_type_AndroidWidgetTextView;
            ImageView localImageView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.f.get(localObject)).jdField_c_of_type_AndroidWidgetImageView;
            localFrameLayout.getGlobalVisibleRect(paramView);
            if ((paramView.contains(this.a.a.x, this.a.a.y)) && (paramView.contains(this.a.jdField_b_of_type_AndroidGraphicsPoint.x, this.a.jdField_b_of_type_AndroidGraphicsPoint.y)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("HealthBusinessPlugin", 2, "videoplayer section clicked");
              }
              if (localSeekBar.getVisibility() == 4)
              {
                localSeekBar.setVisibility(0);
                localTextView1.setVisibility(0);
                localTextView2.setVisibility(0);
                localImageView3.setVisibility(0);
                if (((ISuperPlayer)this.a.jdField_d_of_type_JavaUtilHashMap.get(localObject)).isPlaying()) {
                  i = 2130848894;
                } else {
                  i = 2130849461;
                }
                localImageView1.setImageResource(i);
                localImageView1.setVisibility(0);
                this.a.jdField_d_of_type_Boolean = true;
                localImageView2.setVisibility(4);
                localTextView3.setVisibility(4);
                this.a.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
                localObject = new HealthBusinessPlugin.13.1(this, localSeekBar, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
                this.a.jdField_b_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, 3000L);
              }
              else
              {
                localSeekBar.setVisibility(4);
                localTextView1.setVisibility(4);
                localTextView2.setVisibility(4);
                localImageView3.setVisibility(4);
                localImageView1.setVisibility(4);
                this.a.jdField_d_of_type_Boolean = false;
                localImageView2.setVisibility(0);
                localTextView3.setVisibility(0);
              }
            }
          }
        }
        return false;
      }
    }
    else
    {
      this.a.a.x = ((int)paramMotionEvent.getRawX());
      this.a.a.y = ((int)paramMotionEvent.getRawY());
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "down clicked");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.13
 * JD-Core Version:    0.7.0.1
 */