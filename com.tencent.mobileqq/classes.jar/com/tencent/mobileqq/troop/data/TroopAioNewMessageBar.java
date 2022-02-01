package com.tencent.mobileqq.troop.data;

import android.content.res.Resources;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.MsgUtils;

public class TroopAioNewMessageBar
  extends TroopAioAgent
  implements Animation.AnimationListener
{
  protected static int d = 1;
  protected static int e = 2;
  protected static int f = 0;
  protected static int g = 1;
  protected static int h = 2;
  protected static int i = 3;
  protected static int j;
  protected static final int r = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131298241);
  public LinearLayout k = null;
  public LinearLayout l = null;
  protected RelativeLayout m = null;
  protected TextView n = null;
  protected TextView o = null;
  protected int p = 0;
  protected int q = f;
  protected float s = 0.0F;
  protected boolean t = false;
  protected int u = 0;
  protected Animation v = null;
  protected Animation w = null;
  protected Animation x = null;
  public boolean y = true;
  protected Handler z = new TroopAioNewMessageBar.1(this);
  
  private void a(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == e)
    {
      paramTextView.setText(2131895384);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843412, 0);
      paramTextView.setCompoundDrawablePadding(4);
      paramTextView.setGravity(17);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (paramInt == d)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setGravity(19);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.D.getMessageFacade().getLastMessage(this.F.b, this.F.a);
      if (localObject != null)
      {
        MsgSummary localMsgSummary = new MsgSummary();
        MsgUtils.a(this.E, this.D, (com.tencent.imcore.message.Message)localObject, this.F.a, localMsgSummary, ((com.tencent.imcore.message.Message)localObject).nickName, false, false);
        paramTextView.setText(localMsgSummary.a(this.E));
      }
    }
  }
  
  private void e()
  {
    this.z.removeMessages(j);
    int i1 = this.q;
    if (i1 == g)
    {
      g();
      this.k.setVisibility(0);
      this.l.startAnimation(this.w);
      this.q = i;
      return;
    }
    if (i1 == h)
    {
      this.l.startAnimation(this.w);
      this.q = i;
    }
  }
  
  private void g()
  {
    this.l.clearAnimation();
    this.m.clearAnimation();
  }
  
  protected void a()
  {
    this.s = 0.0F;
    this.v = new TranslateAnimation(0.0F, 0.0F, r, 0.0F);
    this.w = new TranslateAnimation(0.0F, 0.0F, 0.0F, r);
    this.v.setDuration(300L);
    this.w.setDuration(300L);
    this.v.setAnimationListener(this);
    this.w.setAnimationListener(this);
    this.x = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - r);
    this.x.setDuration(300L);
    this.x.setAnimationListener(this);
  }
  
  public void a(int paramInt)
  {
    LinearLayout localLinearLayout = this.k;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(paramInt);
    }
  }
  
  protected void b()
  {
    this.z.removeMessages(j);
    if (this.l != null)
    {
      g();
      this.l.setVisibility(8);
    }
  }
  
  public int c()
  {
    return this.u;
  }
  
  public boolean d()
  {
    return this.l != null;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.s = 0.0F;
    if (paramAnimation.equals(this.w))
    {
      this.k.setVisibility(8);
      this.q = f;
      return;
    }
    if (paramAnimation.equals(this.v))
    {
      this.q = h;
      if (this.p == e)
      {
        paramAnimation = this.z;
        paramAnimation.sendMessageDelayed(android.os.Message.obtain(paramAnimation, j), 3000L);
      }
    }
    else if (paramAnimation.equals(this.x))
    {
      a(this.n, this.p);
      this.o.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation.equals(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar
 * JD-Core Version:    0.7.0.1
 */