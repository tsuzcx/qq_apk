package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class HealthBusinessPlugin$10
  implements View.OnClickListener
{
  HealthBusinessPlugin$10(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (((ISuperPlayer)this.c.l.get(this.a)).isOutputMute())
    {
      ((ISuperPlayer)this.c.l.get(this.a)).setOutputMute(false);
      ((ImageView)paramView).setImageDrawable(this.b.getResources().getDrawable(2130848167));
    }
    else
    {
      ((ISuperPlayer)this.c.l.get(this.a)).setOutputMute(true);
      ((ImageView)paramView).setImageDrawable(this.b.getResources().getDrawable(2130848166));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.10
 * JD-Core Version:    0.7.0.1
 */