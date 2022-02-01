package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$11
  implements View.OnClickListener
{
  HealthBusinessPlugin$11(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, HealthBusinessPlugin.SportVideoLayoutHolder paramSportVideoLayoutHolder) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = (FrameLayout)this.c.m.get(this.a);
    Object localObject1 = (SeekBar)((FrameLayout)localObject3).findViewById(2131445496);
    Object localObject2 = (TextView)((FrameLayout)localObject3).findViewById(2131442521);
    TextView localTextView1 = (TextView)((FrameLayout)localObject3).findViewById(2131442520);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject3).findViewById(2131442519);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject3).findViewById(2131442518);
    TextView localTextView2 = (TextView)((FrameLayout)localObject3).findViewById(2131442517);
    localObject3 = new HealthBusinessPlugin.11.1(this, (SeekBar)localObject1, (TextView)localObject2, localTextView1, localImageView1, localImageView2, localTextView2);
    boolean bool = this.c.J;
    int i = 2130851145;
    if (!bool)
    {
      if (((ISuperPlayer)this.c.l.get(this.a)).isPlaying()) {
        i = 2130850561;
      }
      localImageView1.setImageResource(i);
      localImageView1.setVisibility(0);
      this.c.J = true;
      ((SeekBar)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView1.setVisibility(0);
      localImageView2.setVisibility(4);
      localTextView2.setVisibility(4);
      if (((ISuperPlayer)this.c.l.get(this.a)).isPlaying())
      {
        this.c.K.removeCallbacksAndMessages(null);
        this.c.K.postDelayed((Runnable)localObject3, 3000L);
      }
    }
    else if (((ISuperPlayer)this.c.l.get(this.a)).isPlaying())
    {
      this.c.K.removeCallbacksAndMessages(null);
      ((ISuperPlayer)this.c.l.get(this.a)).pause();
      this.c.A = true;
      localImageView1.setImageResource(2130851145);
      localImageView1.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "play onclick in video ");
      }
    }
    else
    {
      localObject1 = this.c;
      ((HealthBusinessPlugin)localObject1).A = false;
      ((HealthBusinessPlugin)localObject1).K.removeCallbacksAndMessages(null);
      this.c.K.postDelayed((Runnable)localObject3, 3000L);
      localObject1 = this.c.l.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ((ISuperPlayer)this.c.l.get(localObject2)).pause();
      }
      ((ISuperPlayer)this.c.l.get(this.a)).start();
      this.b.a.setImageResource(2130850561);
      this.b.a.setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.11
 * JD-Core Version:    0.7.0.1
 */