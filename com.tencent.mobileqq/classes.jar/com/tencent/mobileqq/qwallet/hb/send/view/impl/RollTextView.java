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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private RollTextView.OnRollTextChangeListener jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollTextView$OnRollTextChangeListener = null;
  private RollTextView.RollViewHandler jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollTextView$RollViewHandler = new RollTextView.RollViewHandler(this);
  protected boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  private int d = 200;
  private int e = 200;
  private int f = 50;
  private int g;
  
  public RollTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext, true);
  }
  
  public RollTextView(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.f = paramInt1;
    this.g = paramInt2;
    a(paramContext, paramBoolean);
  }
  
  public RollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext, true);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, R.anim.jdField_b_of_type_Int);
      localAnimation.setFillAfter(true);
      setInAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, R.anim.c);
      localAnimation.setFillAfter(true);
      setOutAnimation(localAnimation);
      return;
    }
    setInAnimation(null);
    setOutAnimation(null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramBoolean);
    setFactory(new RollTextView.1(this, paramBoolean));
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new RollTextView.ContentSupplyThread(this), null, true);
  }
  
  public void setContext(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setFactor(int paramInt)
  {
    if (paramInt >= 0) {
      this.c = paramInt;
    }
  }
  
  public void setListener(RollTextView.OnRollTextChangeListener paramOnRollTextChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollTextView$OnRollTextChangeListener = paramOnRollTextChangeListener;
  }
  
  public void setScope(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_Int = paramInt2;
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView
 * JD-Core Version:    0.7.0.1
 */