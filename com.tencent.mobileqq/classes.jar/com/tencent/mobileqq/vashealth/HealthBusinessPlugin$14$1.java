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

class HealthBusinessPlugin$14$1
  implements View.OnTouchListener
{
  HealthBusinessPlugin$14$1(HealthBusinessPlugin.14 param14) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.d.m.keySet().iterator();
    while (paramView.hasNext())
    {
      paramMotionEvent = (String)paramView.next();
      SeekBar localSeekBar = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).e;
      TextView localTextView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).f;
      TextView localTextView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).d;
      ImageView localImageView1 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).a;
      ImageView localImageView2 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).b;
      TextView localTextView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).c;
      ImageView localImageView3 = ((HealthBusinessPlugin.SportVideoLayoutHolder)this.a.d.n.get(paramMotionEvent)).g;
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "videoplayer section clicked");
      }
      if (localSeekBar.getVisibility() == 4)
      {
        localSeekBar.setVisibility(0);
        localTextView1.setVisibility(0);
        localTextView2.setVisibility(0);
        localImageView3.setVisibility(0);
        int i;
        if (((ISuperPlayer)this.a.d.l.get(paramMotionEvent)).isPlaying()) {
          i = 2130850561;
        } else {
          i = 2130851145;
        }
        localImageView1.setImageResource(i);
        localImageView1.setVisibility(0);
        this.a.d.J = true;
        localImageView2.setVisibility(4);
        localTextView3.setVisibility(4);
        this.a.d.K.removeCallbacksAndMessages(null);
        paramMotionEvent = new HealthBusinessPlugin.14.1.1(this, localSeekBar, localTextView1, localTextView2, localImageView3, localImageView1, localImageView2, localTextView3);
        this.a.d.K.postDelayed(paramMotionEvent, 3000L);
      }
      else
      {
        localSeekBar.setVisibility(4);
        localTextView1.setVisibility(4);
        localTextView2.setVisibility(4);
        localImageView3.setVisibility(4);
        localImageView1.setVisibility(4);
        this.a.d.J = false;
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.14.1
 * JD-Core Version:    0.7.0.1
 */