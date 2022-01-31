package com.tencent.mobileqq.mini.entry.desktop;

import ajyc;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import bbkx;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;

class MiniAppDesktopLayout$2
  implements DragRecyclerView.DragDeleteListener
{
  MiniAppDesktopLayout$2(MiniAppDesktopLayout paramMiniAppDesktopLayout) {}
  
  public void onDeleteDragComplete()
  {
    MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130840620);
    MiniAppDesktopLayout.access$200(this.this$0).setText(ajyc.a(2131706785));
    MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130840622, 0, 0, 0);
  }
  
  public void onDeleteDragFinish()
  {
    if (!MiniAppDesktopLayout.access$000(this.this$0)) {
      return;
    }
    MiniAppDesktopLayout.access$002(this.this$0, false);
    MiniAppDesktopLayout.access$100(this.this$0).clearAnimation();
    if (MiniAppDesktopLayout.access$100(this.this$0).getHeight() > 0) {}
    for (int i = MiniAppDesktopLayout.access$100(this.this$0).getHeight();; i = bbkx.a(65.0F))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setAnimationListener(new MiniAppDesktopLayout.2.1(this));
      MiniAppDesktopLayout.access$100(this.this$0).setAnimation(localTranslateAnimation);
      localTranslateAnimation.start();
      return;
    }
  }
  
  public void onDeleteDragStart()
  {
    if (MiniAppDesktopLayout.access$000(this.this$0))
    {
      MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130840619);
      MiniAppDesktopLayout.access$200(this.this$0).setText(ajyc.a(2131706784));
      MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130840621, 0, 0, 0);
      return;
    }
    MiniAppDesktopLayout.access$002(this.this$0, true);
    MiniAppDesktopLayout.access$100(this.this$0).setVisibility(0);
    MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130840619);
    MiniAppDesktopLayout.access$100(this.this$0).clearAnimation();
    MiniAppDesktopLayout.access$200(this.this$0).setText(ajyc.a(2131706787));
    MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130840621, 0, 0, 0);
    if (MiniAppDesktopLayout.access$100(this.this$0).getHeight() > 0) {}
    for (int i = MiniAppDesktopLayout.access$100(this.this$0).getHeight();; i = bbkx.a(65.0F))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
      localTranslateAnimation.setDuration(200L);
      MiniAppDesktopLayout.access$100(this.this$0).setAnimation(localTranslateAnimation);
      localTranslateAnimation.start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.2
 * JD-Core Version:    0.7.0.1
 */