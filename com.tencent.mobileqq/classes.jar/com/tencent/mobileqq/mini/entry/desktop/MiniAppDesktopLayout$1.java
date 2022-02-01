package com.tencent.mobileqq.mini.entry.desktop;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;
import com.tencent.mobileqq.utils.ViewUtils;

class MiniAppDesktopLayout$1
  implements DragRecyclerView.DragDeleteListener
{
  MiniAppDesktopLayout$1(MiniAppDesktopLayout paramMiniAppDesktopLayout) {}
  
  public void onDeleteDragComplete()
  {
    MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130841003);
    MiniAppDesktopLayout.access$200(this.this$0).setText(anvx.a(2131706259));
    MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130841005, 0, 0, 0);
  }
  
  public void onDeleteDragFinish()
  {
    if (!MiniAppDesktopLayout.access$000(this.this$0)) {
      return;
    }
    MiniAppDesktopLayout.access$002(this.this$0, false);
    MiniAppDesktopLayout.access$100(this.this$0).clearAnimation();
    if (MiniAppDesktopLayout.access$100(this.this$0).getHeight() > 0) {}
    for (int i = MiniAppDesktopLayout.access$100(this.this$0).getHeight();; i = ViewUtils.dip2px(65.0F))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setAnimationListener(new MiniAppDesktopLayout.1.1(this));
      MiniAppDesktopLayout.access$100(this.this$0).setAnimation(localTranslateAnimation);
      localTranslateAnimation.start();
      return;
    }
  }
  
  public void onDeleteDragStart()
  {
    if (MiniAppDesktopLayout.access$000(this.this$0))
    {
      MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130841002);
      MiniAppDesktopLayout.access$200(this.this$0).setText(anvx.a(2131706258));
      MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130841004, 0, 0, 0);
      return;
    }
    MiniAppDesktopLayout.access$002(this.this$0, true);
    MiniAppDesktopLayout.access$100(this.this$0).setVisibility(0);
    MiniAppDesktopLayout.access$100(this.this$0).setBackgroundResource(2130841002);
    MiniAppDesktopLayout.access$100(this.this$0).clearAnimation();
    MiniAppDesktopLayout.access$200(this.this$0).setText(anvx.a(2131706261));
    MiniAppDesktopLayout.access$200(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130841004, 0, 0, 0);
    if (MiniAppDesktopLayout.access$100(this.this$0).getHeight() > 0) {}
    for (int i = MiniAppDesktopLayout.access$100(this.this$0).getHeight();; i = ViewUtils.dip2px(65.0F))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
      localTranslateAnimation.setDuration(200L);
      MiniAppDesktopLayout.access$100(this.this$0).setAnimation(localTranslateAnimation);
      localTranslateAnimation.start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.1
 * JD-Core Version:    0.7.0.1
 */