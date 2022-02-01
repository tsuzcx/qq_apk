package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqpay.ui.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class RollNumberView
  extends LinearLayout
  implements RollTextView.OnRollTextChangeListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private RollNumberView.OnRollListener jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView$OnRollListener;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = 0;
  
  public RollNumberView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cc);
    this.e = ((int)paramContext.getDimension(R.styleable.s, 12.0F));
    this.f = paramContext.getColor(R.styleable.r, 0);
    paramContext.recycle();
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramInt % 10;
      localObject = new RollTextView(this.jdField_a_of_type_AndroidContentContext, this.e, this.f, this.jdField_a_of_type_Boolean);
      ((RollTextView)localObject).setListener(this);
      int j = this.c;
      this.c = (j + 1);
      ((RollTextView)localObject).setFactor(j);
      addView((View)localObject, 0);
      j = 4 - new Random().nextInt(3);
      ((RollTextView)localObject).setScope(i + j, i);
      paramInt /= 10;
      i = 0;
      while (paramInt > 0)
      {
        i += 1;
        localObject = new RollTextView(this.jdField_a_of_type_AndroidContentContext, this.e, this.f, this.jdField_a_of_type_Boolean);
        ((RollTextView)localObject).setListener(this);
        int k = this.c;
        this.c = (k + 1);
        ((RollTextView)localObject).setFactor(k);
        k = paramInt % 10;
        ((RollTextView)localObject).setScope(k + j + i, k);
        addView((View)localObject, 0);
        paramInt /= 10;
      }
      return j;
    }
    Object localObject = new Exception("no must be positive");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = getChildCount();
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).b();
      }
      i += 1;
    }
  }
  
  public void a(double paramDouble)
  {
    if (paramDouble > 0.0D)
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localTextView.setIncludeFontPadding(false);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setGravity(80);
      localTextView.setTextSize(0, this.e);
      localTextView.setTextColor(this.f);
      int i = (int)paramDouble;
      double d1 = i;
      Double.isNaN(d1);
      int j = (int)Math.round((paramDouble - d1) * 1000.0D) / 10;
      this.d = a(j);
      if (j < 10) {
        a(0);
      }
      localTextView.setText(".");
      localTextView.setContentDescription(HardCodeUtil.a(R.string.cD));
      addView(localTextView, 0);
      i = a(i);
      j = this.d;
      if (i <= j) {
        i = j;
      }
      this.d = i;
      return;
    }
    throw new Exception("no must be positive");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RollNumberView", 2, "onRollTextComplete---");
    }
    if (this.g == this.jdField_a_of_type_Int - 2)
    {
      RollNumberView.OnRollListener localOnRollListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView$OnRollListener;
      if (localOnRollListener != null) {
        localOnRollListener.c();
      }
    }
    this.g += 1;
  }
  
  public void b(double paramDouble)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).a();
      }
      i += 1;
    }
    this.c = 0;
    removeAllViews();
    try
    {
      this.g = 0;
      a(paramDouble);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setFactor(int paramInt)
  {
    if (paramInt >= 0) {
      this.c = paramInt;
    }
  }
  
  public void setIsRool(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLisener(RollNumberView.OnRollListener paramOnRollListener)
  {
    if (paramOnRollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView$OnRollListener = paramOnRollListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView
 * JD-Core Version:    0.7.0.1
 */