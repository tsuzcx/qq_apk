package com.tencent.mobileqq.popanim.state;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class PopDeleteState
  extends BaseState
{
  ObjectAnimator d;
  private DiniFlyAnimationView e = (DiniFlyAnimationView)this.b.findViewById(2131433178);
  private DiniFlyAnimationView f = (DiniFlyAnimationView)this.b.findViewById(2131440505);
  private View g = this.b.findViewById(2131440506);
  private TextView h = (TextView)this.b.findViewById(2131430287);
  private LottieDrawable i;
  private PopAnimState j;
  private int k = this.a.getResources().getDisplayMetrics().heightPixels;
  
  protected PopDeleteState(RelativeLayout paramRelativeLayout, StateContext paramStateContext)
  {
    super(paramRelativeLayout, paramStateContext);
    LottieHelper.a(this.a, "emoc/pop_anim_del_confirm.json", null, 50, 50, 0, new PopDeleteState.1(this));
  }
  
  private void b()
  {
    if (this.c.m) {
      return;
    }
    this.c.m = true;
    this.j.e.a();
    this.j.d.a(this.c.c.typeface).b();
    if (QLog.isColorLevel()) {
      QLog.d("PopDeleteState", 2, "pausePopAnim");
    }
  }
  
  private void c()
  {
    if (!this.c.m) {
      return;
    }
    this.j.e.b();
    ThreadManager.getUIHandler().postDelayed(new PopDeleteState.2(this), 300L);
    if (QLog.isColorLevel()) {
      QLog.d("PopDeleteState", 2, "resumePopAnim");
    }
  }
  
  private void d()
  {
    if (this.g == null) {
      return;
    }
    if (this.d == null)
    {
      float f1 = ViewUtils.dpToPx(95.0F);
      this.d = ObjectAnimator.ofFloat(this.g, "translationY", new float[] { f1 });
      this.d.setDuration(400L);
      this.d.addListener(new PopDeleteState.3(this));
    }
    this.d.start();
  }
  
  protected void a()
  {
    this.f.setImageResource(2130840103);
    this.g.getLayoutParams().height = ViewUtils.dpToPx(85.0F);
    this.g.setBackgroundResource(2130840104);
    this.g.requestLayout();
  }
  
  public void a(BaseState paramBaseState)
  {
    if (!(paramBaseState instanceof PopAnimState))
    {
      QLog.d("PopDeleteState", 1, new Exception(), new Object[] { "preState error, ", paramBaseState });
      return;
    }
    this.j = ((PopAnimState)paramBaseState);
    paramBaseState = this.i;
    if (paramBaseState != null) {
      this.f.setImageDrawable(paramBaseState);
    }
    PopOutAnimViewHelper.a(0, new View[] { this.f });
    this.g.getLayoutParams().height = ViewUtils.dpToPx(95.0F);
    this.g.setBackgroundResource(2130840105);
    this.g.requestLayout();
    PopOutAnimViewHelper.a(4, new View[] { this.e });
    b();
    int m = PopOutEmoticonUtil.a(this.k, this.c.f);
    paramBaseState = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    this.h.setVisibility(0);
    paramBaseState.setMargins(0, 0, 0, m);
    if (!this.c.l)
    {
      this.c.l = true;
      PopOutAnimViewHelper.a("0X800BBA2", this.c.b);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void b(BaseState paramBaseState)
  {
    c();
    if ((paramBaseState instanceof PopAnimState))
    {
      a();
      this.c.m = false;
      PopOutAnimViewHelper.a(0, new View[] { this.e });
      this.h.setVisibility(4);
      return;
    }
    d();
    PopOutAnimViewHelper.a(4, new View[] { this.h, this.e });
    this.j.e.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopDeleteState
 * JD-Core Version:    0.7.0.1
 */