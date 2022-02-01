package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.widget.ListView.OnSpringBackListener;

public class SimpleLottiePullRefreshHeader
  extends RelativeLayout
  implements IPullRefreshHeaderControl, ListView.OnSpringBackListener
{
  protected RefreshView a;
  public long b = 0L;
  private int c = 0;
  private Context d;
  private int e = 0;
  
  public SimpleLottiePullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
  }
  
  public SimpleLottiePullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.a.a(null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramObject = (RelativeLayout)findViewById(2131444554);
      localObject = (RelativeLayout.LayoutParams)paramObject.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramObject.setBackgroundColor(getResources().getColor(2131168188));
      return;
    }
    if (paramInt == 2)
    {
      paramObject = (View)paramObject;
      localObject = (ViewGroup)findViewById(2131438474);
      if (indexOfChild(paramObject) < 0) {
        ((ViewGroup)localObject).addView(paramObject);
      }
      ((ViewGroup)localObject).setVisibility(0);
      return;
    }
    if (paramInt == 3)
    {
      setLottieProgress(((Float)paramObject).floatValue());
      return;
    }
    if (paramInt == 4)
    {
      ((RelativeLayout)findViewById(2131444554)).setVisibility(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 10)
    {
      removeView((View)paramObject);
      return;
    }
    if (paramInt == 14)
    {
      ((RelativeLayout)findViewById(2131444554)).setBackgroundColor(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 16)
    {
      ((RelativeLayout)findViewById(2131444552)).setBackgroundResource(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 21)
    {
      this.a.setVisibility(8);
      this.e = 2;
      return;
    }
    if (paramInt == 22)
    {
      ((RelativeLayout.LayoutParams)((RelativeLayout)findViewById(2131438474)).getLayoutParams()).bottomMargin = ((Integer)paramObject).intValue();
      return;
    }
    if (paramInt == 24)
    {
      e();
      return;
    }
    if (paramInt == 27) {
      this.a.a((RefreshView.OnLottieEndListener)paramObject);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong)
  {
    this.a.c();
    this.e = 3;
  }
  
  public Object b(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      paramObject = (RelativeLayout)findViewById(2131444554);
      boolean bool;
      if ((paramObject != null) && (paramObject.getVisibility() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    if (paramInt == 8) {
      return Integer.valueOf(indexOfChild((View)paramObject));
    }
    return null;
  }
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
  
  protected void e()
  {
    this.a.b();
  }
  
  public void f() {}
  
  public long g()
  {
    return this.b;
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  protected void onAttachedToWindow() {}
  
  @SuppressLint({"WrongViewCast"})
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((RefreshView)findViewById(2131444567));
  }
  
  public void onSpringBack()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(100L);
    localValueAnimator.addUpdateListener(new SimpleLottiePullRefreshHeader.1(this));
    localValueAnimator.start();
    postDelayed(new SimpleLottiePullRefreshHeader.2(this), 100L);
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  protected void setLottieProgress(float paramFloat)
  {
    RefreshView localRefreshView = this.a;
    int i;
    if (paramFloat >= 0.0F) {
      i = 0;
    } else {
      i = 4;
    }
    localRefreshView.setVisibility(i);
    if (paramFloat < 0.0F) {
      return;
    }
    float f = paramFloat;
    if (paramFloat > 0.5F) {
      f = 0.5F;
    }
    paramFloat = 6.0F * f / 5.0F + 0.4F;
    this.a.setProgress(f);
    this.a.setScaleY(paramFloat);
    this.a.setScaleX(paramFloat);
    this.e = 1;
  }
  
  public void setPullType(int paramInt)
  {
    if (this.c != paramInt) {
      this.c = paramInt;
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */