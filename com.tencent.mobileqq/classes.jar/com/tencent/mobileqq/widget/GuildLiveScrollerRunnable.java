package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.widget.ListView;

public class GuildLiveScrollerRunnable
  extends ScrollerRunnable
{
  public GuildLiveScrollerRunnable(ListView paramListView)
  {
    super(paramListView);
  }
  
  private Drawable a(Context paramContext)
  {
    return paramContext.getResources().getDrawable(2130840920);
  }
  
  private int b(Context paramContext)
  {
    return 0;
  }
  
  private ValueAnimator.AnimatorUpdateListener b(View paramView)
  {
    return new GuildLiveScrollerRunnable.1(this, paramView);
  }
  
  private int c(Context paramContext)
  {
    return 255;
  }
  
  protected void a(View paramView)
  {
    int i;
    int j;
    if (this.k == 2)
    {
      paramView.setBackground(a(paramView.getContext()));
      i = b(paramView.getContext());
      j = c(paramView.getContext());
    }
    else
    {
      paramView.setBackgroundColor(867218367);
      j = 51;
      i = 0;
    }
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { i, j });
    localValueAnimator1.setDuration(300L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { j, i });
    localValueAnimator2.setDuration(400L);
    localValueAnimator1.addUpdateListener(b(paramView));
    localValueAnimator1.addListener(new GuildLiveScrollerRunnable.2(this, paramView, localValueAnimator2));
    localValueAnimator2.addUpdateListener(b(paramView));
    localValueAnimator2.addListener(new GuildLiveScrollerRunnable.3(this, paramView));
    localValueAnimator1.start();
    this.q = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuildLiveScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */