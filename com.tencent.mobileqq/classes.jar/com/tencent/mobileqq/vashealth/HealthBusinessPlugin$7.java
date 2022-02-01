package com.tencent.mobileqq.vashealth;

import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$7
  implements Runnable
{
  HealthBusinessPlugin$7(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ImageView)((FrameLayout)this.this$0.e.get(localObject)).findViewById(2131374812);
      ((ImageView)localObject).setImageResource(2130849563);
      ((ImageView)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.7
 * JD-Core Version:    0.7.0.1
 */