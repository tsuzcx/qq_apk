package com.tencent.mobileqq.vashealth;

import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$9
  implements Runnable
{
  HealthBusinessPlugin$9(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ImageView)((FrameLayout)this.this$0.m.get(localObject)).findViewById(2131442519);
      ((ImageView)localObject).setImageResource(2130851145);
      ((ImageView)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.9
 * JD-Core Version:    0.7.0.1
 */