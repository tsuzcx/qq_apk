package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class GuildDiscoverSlidingIndicator$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GuildDiscoverSlidingIndicator$4(GuildDiscoverSlidingIndicator paramGuildDiscoverSlidingIndicator) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    Object localObject1 = this.a;
    ((GuildDiscoverSlidingIndicator)localObject1).setChooseTabViewTextColor(((GuildDiscoverSlidingIndicator)localObject1).b);
    localObject1 = this.a;
    ((GuildDiscoverSlidingIndicator)localObject1).a(((GuildDiscoverSlidingIndicator)localObject1).b);
    localObject1 = this.a.a.getChildAt(this.a.b);
    if (localObject1 != null)
    {
      this.a.j = ((View)localObject1).getLeft();
      if (((View)localObject1).getMeasuredWidth() == 0)
      {
        Object localObject2 = this.a;
        ((GuildDiscoverSlidingIndicator)localObject2).j = (GuildDiscoverSlidingIndicator.b((GuildDiscoverSlidingIndicator)localObject2) + (GuildDiscoverSlidingIndicator.c(this.a) + GuildDiscoverSlidingIndicator.d(this.a)) * this.a.b);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onGlobalLayout, x[");
          ((StringBuilder)localObject2).append(this.a.j);
          ((StringBuilder)localObject2).append("], size[");
          ((StringBuilder)localObject2).append(this.a.a.getChildCount());
          ((StringBuilder)localObject2).append("], left[");
          ((StringBuilder)localObject2).append(((View)localObject1).getLeft());
          ((StringBuilder)localObject2).append("], width[");
          ((StringBuilder)localObject2).append(((View)localObject1).getMeasuredWidth());
          ((StringBuilder)localObject2).append("], pos[");
          ((StringBuilder)localObject2).append(this.a.b);
          ((StringBuilder)localObject2).append("], CPlr");
          ((StringBuilder)localObject2).append(GuildDiscoverSlidingIndicator.b(this.a));
          ((StringBuilder)localObject2).append("]");
          QLog.i("GuildDiscoverSlidingIndicator", 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator.4
 * JD-Core Version:    0.7.0.1
 */