package com.tencent.mobileqq.qqgift.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class AbstractValidClickListener
  implements View.OnClickListener
{
  private long a = 0L;
  private int b = 0;
  
  public AbstractValidClickListener(int paramInt)
  {
    this.b = paramInt;
  }
  
  public abstract void a(View paramView);
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a >= this.b)
    {
      this.a = System.currentTimeMillis();
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.AbstractValidClickListener
 * JD-Core Version:    0.7.0.1
 */