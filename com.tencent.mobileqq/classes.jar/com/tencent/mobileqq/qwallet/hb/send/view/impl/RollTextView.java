package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.anim;

public class RollTextView
  extends TextSwitcher
{
  protected boolean a = true;
  private RollTextView.RollViewHandler b = new RollTextView.RollViewHandler(this);
  private Context c = null;
  private RollTextView.OnRollTextChangeListener d = null;
  private int e;
  private int f;
  private int g = 0;
  private int h = 200;
  private int i = 200;
  private int j = 50;
  private int k;
  private boolean l = true;
  
  public RollTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, true);
  }
  
  public RollTextView(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext);
    this.j = paramInt1;
    this.k = paramInt2;
    a(paramContext, paramBoolean);
  }
  
  public RollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, true);
  }
  
  private void setIsRool(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (paramBoolean)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.c, R.anim.b);
      localAnimation.setFillAfter(true);
      setInAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(this.c, R.anim.c);
      localAnimation.setFillAfter(true);
      setOutAnimation(localAnimation);
      return;
    }
    setInAnimation(null);
    setOutAnimation(null);
  }
  
  public void a()
  {
    this.a = false;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    this.c = paramContext;
    setIsRool(paramBoolean);
    setFactory(new RollTextView.1(this, paramBoolean));
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new RollTextView.ContentSupplyThread(this), null, true);
  }
  
  public void setContext(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void setFactor(int paramInt)
  {
    if (paramInt >= 0) {
      this.g = paramInt;
    }
  }
  
  public void setListener(RollTextView.OnRollTextChangeListener paramOnRollTextChangeListener)
  {
    this.d = paramOnRollTextChangeListener;
  }
  
  public void setScope(int paramInt1, int paramInt2)
  {
    if (!this.l)
    {
      this.f = paramInt2;
      this.e = paramInt2;
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView
 * JD-Core Version:    0.7.0.1
 */