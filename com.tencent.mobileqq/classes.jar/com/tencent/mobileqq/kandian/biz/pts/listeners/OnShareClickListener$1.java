package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;

class OnShareClickListener$1
  implements View.OnAttachStateChangeListener
{
  OnShareClickListener$1(OnShareClickListener paramOnShareClickListener) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (OnShareClickListener.a(this.a) != null)
    {
      OnShareClickListener.a(this.a).c();
      OnShareClickListener.a(this.a, null);
    }
    if (OnShareClickListener.b(this.a) != null)
    {
      OnShareClickListener.b(this.a).a();
      OnShareClickListener.a(this.a, null);
    }
    if (OnShareClickListener.c(this.a) != null)
    {
      OnShareClickListener.c(this.a).b();
      OnShareClickListener.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener.1
 * JD-Core Version:    0.7.0.1
 */