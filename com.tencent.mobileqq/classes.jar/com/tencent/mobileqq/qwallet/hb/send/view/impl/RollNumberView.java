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
  private Context a = null;
  private int b;
  private int c = 0;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  private RollNumberView.OnRollListener i;
  private boolean j = true;
  
  public RollNumberView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  public RollNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cA);
    this.f = ((int)paramContext.getDimension(R.styleable.cC, 12.0F));
    this.g = paramContext.getColor(R.styleable.cB, 0);
    paramContext.recycle();
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int k = paramInt % 10;
      localObject = new RollTextView(this.a, this.f, this.g, this.j);
      ((RollTextView)localObject).setListener(this);
      int m = this.d;
      this.d = (m + 1);
      ((RollTextView)localObject).setFactor(m);
      addView((View)localObject, 0);
      m = 4 - new Random().nextInt(3);
      ((RollTextView)localObject).setScope(k + m, k);
      paramInt /= 10;
      k = 0;
      while (paramInt > 0)
      {
        k += 1;
        localObject = new RollTextView(this.a, this.f, this.g, this.j);
        ((RollTextView)localObject).setListener(this);
        int n = this.d;
        this.d = (n + 1);
        ((RollTextView)localObject).setFactor(n);
        n = paramInt % 10;
        ((RollTextView)localObject).setScope(n + m + k, n);
        addView((View)localObject, 0);
        paramInt /= 10;
      }
      return m;
    }
    Object localObject = new Exception("no must be positive");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    this.b = getChildCount();
    int k = 0;
    while (k < this.b)
    {
      View localView = getChildAt(k);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).b();
      }
      k += 1;
    }
  }
  
  public void a(double paramDouble)
  {
    if (paramDouble > 0.0D)
    {
      TextView localTextView = new TextView(this.a);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localTextView.setIncludeFontPadding(false);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setGravity(80);
      localTextView.setTextSize(0, this.f);
      localTextView.setTextColor(this.g);
      int k = (int)paramDouble;
      double d1 = k;
      Double.isNaN(d1);
      int m = (int)Math.round((paramDouble - d1) * 1000.0D) / 10;
      this.e = a(m);
      if (m < 10) {
        a(0);
      }
      localTextView.setText(".");
      localTextView.setContentDescription(HardCodeUtil.a(R.string.cG));
      addView(localTextView, 0);
      k = a(k);
      m = this.e;
      if (k <= m) {
        k = m;
      }
      this.e = k;
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
    if (this.h == this.b - 2)
    {
      RollNumberView.OnRollListener localOnRollListener = this.i;
      if (localOnRollListener != null) {
        localOnRollListener.d();
      }
    }
    this.h += 1;
  }
  
  public void b(double paramDouble)
  {
    int k = 0;
    while (k < this.b)
    {
      View localView = getChildAt(k);
      if ((localView != null) && ((localView instanceof RollTextView))) {
        ((RollTextView)localView).a();
      }
      k += 1;
    }
    this.d = 0;
    removeAllViews();
    try
    {
      this.h = 0;
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
      this.d = paramInt;
    }
  }
  
  public void setIsRool(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setLisener(RollNumberView.OnRollListener paramOnRollListener)
  {
    if (paramOnRollListener != null) {
      this.i = paramOnRollListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView
 * JD-Core Version:    0.7.0.1
 */