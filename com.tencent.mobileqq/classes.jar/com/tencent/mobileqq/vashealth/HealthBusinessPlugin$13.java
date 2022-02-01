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
        this.a.u.x = ((int)paramMotionEvent.getRawX());
        this.a.u.y = ((int)paramMotionEvent.getRawY());
        if ((Math.abs(this.a.t.y - this.a.u.y) < 8) && (Math.abs(this.a.t.x - this.a.u.x) < 8))
        {
          paramView = new Rect();
          paramMotionEvent = this.a.m.keySet().iterator();
          while (paramMotionEvent.hasNext())
          {
            Object localObject = (String)paramMotionEvent.next();
            FrameLayout localFrameLayout = (FrameLayout)this.a.m.get(localObject);
            SeekBar localSeekBar = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).e;
            TextView localTextView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).f;
            TextView localTextView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).d;
            ImageView localImageView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).a;
            ImageView localImageView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).b;
            TextView localTextView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).c;
            ImageView localImageView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.n.get(localObject)).g;
            localFrameLayout.getGlobalVisibleRect(paramView);
            if ((paramView.contains(this.a.t.x, this.a.t.y)) && (paramView.contains(this.a.u.x, this.a.u.y)))
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
                if (((ISuperPlayer)this.a.l.get(localObject)).isPlaying()) {
                  i = 2130850561;
                } else {
                  i = 2130851145;
                }
                localImageView1.setImageResource(i);
                localImageView1.setVisibility(0);
                this.a.J = true;
                localImageView2.setVisibility(4);
                localTextView3.setVisibility(4);
                this.a.K.removeCallbacksAndMessages(null);
                localObject = new HealthBusinessPlugin.13.1(this, localSeekBar, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
                this.a.K.postDelayed((Runnable)localObject, 3000L);
              }
              else
              {
                localSeekBar.setVisibility(4);
                localTextView1.setVisibility(4);
                localTextView2.setVisibility(4);
                localImageView3.setVisibility(4);
                localImageView1.setVisibility(4);
                this.a.J = false;
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
      this.a.t.x = ((int)paramMotionEvent.getRawX());
      this.a.t.y = ((int)paramMotionEvent.getRawY());
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "down clicked");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.13
 * JD-Core Version:    0.7.0.1
 */