package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class CustomFastOnClickListener
  implements View.OnClickListener
{
  private long a = 0L;
  
  public abstract void a(View paramView);
  
  public void b(View paramView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a >= 500L)
    {
      a(paramView);
      this.a = l;
    }
    else
    {
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener
 * JD-Core Version:    0.7.0.1
 */