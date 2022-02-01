package com.tencent.open.agent;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.open.agent.util.SSOLog;

class BaseCardContainer$2
  extends URLDrawableDownListener.Adapter
{
  BaseCardContainer$2(BaseCardContainer paramBaseCardContainer) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("-->drawabel onLoadCancelled, view: ");
    paramURLDrawable.append(paramView);
    SSOLog.a("BaseCardContainer", new Object[] { paramURLDrawable.toString() });
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("-->drawabel onLoadFailed, view: ");
    paramURLDrawable.append(paramView);
    SSOLog.a("BaseCardContainer", new Object[] { paramURLDrawable.toString() });
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("-->drawabel onLoadInterrupted, view: ");
    paramURLDrawable.append(paramView);
    SSOLog.a("BaseCardContainer", new Object[] { paramURLDrawable.toString() });
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    super.onLoadProgressed(paramView, paramURLDrawable, paramInt);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("-->drawabel onLoadProgressed, view: ");
    paramURLDrawable.append(paramView);
    SSOLog.a("BaseCardContainer", new Object[] { paramURLDrawable.toString() });
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->drawabel onLoadSuccessed, view: ");
    localStringBuilder.append(paramView);
    SSOLog.a("BaseCardContainer", new Object[] { localStringBuilder.toString() });
    this.a.a();
    ((URLImageView)paramView).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.2
 * JD-Core Version:    0.7.0.1
 */