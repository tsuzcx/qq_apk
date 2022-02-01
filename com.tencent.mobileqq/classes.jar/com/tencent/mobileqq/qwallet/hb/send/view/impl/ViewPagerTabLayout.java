package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.qqpay.ui.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class ViewPagerTabLayout
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private ViewPagerTabLayout.OnTabSelectListener A;
  private Context a;
  private ViewPager b;
  private LinearLayout c;
  private int d;
  private float e;
  private int f;
  private Rect g = new Rect();
  private Rect h = new Rect();
  private GradientDrawable i = new GradientDrawable();
  private float j;
  private boolean k = false;
  private float l;
  private int m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private int v;
  private int w;
  private int x = 1;
  private int y;
  private boolean z = true;
  
  public ViewPagerTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, String paramString, View paramView)
  {
    TextView localTextView = (TextView)paramView.getTag();
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    paramView.setOnClickListener(new ViewPagerTabLayout.1(this));
    if (this.k) {
      paramString = new LinearLayout.LayoutParams(0, -1, 1.0F);
    } else {
      paramString = new LinearLayout.LayoutParams(-2, -1);
    }
    float f1 = this.l;
    if (f1 > 0.0F) {
      paramString = new LinearLayout.LayoutParams((int)f1, -1);
    }
    this.c.addView(paramView, paramInt, paramString);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = paramContext;
    setFillViewport(true);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.c = new LinearLayout(paramContext);
    addView(this.c);
    b(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    int i1 = 0;
    while (i1 < this.f)
    {
      TextView localTextView = (TextView)this.c.getChildAt(i1).getTag();
      if (localTextView != null)
      {
        if (i1 == this.d) {
          i2 = this.v;
        } else {
          i2 = this.w;
        }
        localTextView.setTextColor(i2);
        localTextView.setTextSize(0, this.u);
        float f1 = this.j;
        localTextView.setPadding((int)f1, 0, (int)f1, 0);
        int i2 = this.x;
        if (i2 == 2) {
          localTextView.getPaint().setFakeBoldText(true);
        } else if (i2 == 0) {
          localTextView.getPaint().setFakeBoldText(false);
        }
      }
      i1 += 1;
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cc);
    this.m = paramContext.getColor(R.styleable.cd, Color.parseColor("#ffffff"));
    this.n = paramContext.getDimension(R.styleable.cf, -1.0F);
    this.o = paramContext.getDimension(R.styleable.cg, -1.0F);
    this.p = paramContext.getDimension(R.styleable.ce, -1.0F);
    this.u = paramContext.getDimension(R.styleable.cl, b(16.0F));
    this.v = paramContext.getColor(R.styleable.cj, Color.parseColor("#FF2051"));
    this.w = paramContext.getColor(R.styleable.ck, Color.parseColor("#F5F6FA"));
    this.l = paramContext.getDimension(R.styleable.ci, a(-1.0F));
    int i2 = R.styleable.ch;
    int i1;
    if ((!this.k) && (this.l <= 0.0F)) {
      i1 = a(15.0F);
    } else {
      i1 = a(0.0F);
    }
    this.j = paramContext.getDimension(i2, i1);
    paramContext.recycle();
  }
  
  private void c()
  {
    if (this.f <= 0) {
      return;
    }
    int i3 = (int)(this.e * this.c.getChildAt(this.d).getWidth());
    int i2 = this.c.getChildAt(this.d).getLeft() + i3;
    int i1;
    if (this.d <= 0)
    {
      i1 = i2;
      if (i3 <= 0) {}
    }
    else
    {
      i1 = getWidth() / 2;
      i3 = getPaddingLeft();
      d();
      i1 = i2 - (i1 - i3) + (this.h.right - this.h.left) / 2;
    }
    if (i1 != this.y)
    {
      this.y = i1;
      scrollTo(i1, 0);
    }
  }
  
  private void d()
  {
    Object localObject1 = this.c.getChildAt(this.d);
    float f4 = ((View)localObject1).getLeft();
    float f3 = ((View)localObject1).getRight();
    int i1 = this.d;
    float f2 = f4;
    float f1 = f3;
    if (i1 < this.f - 1)
    {
      localObject2 = this.c.getChildAt(i1 + 1);
      f2 = ((View)localObject2).getLeft();
      f1 = ((View)localObject2).getRight();
      float f5 = this.e;
      f2 = f4 + (f2 - f4) * f5;
      f1 = f3 + f5 * (f1 - f3);
    }
    Object localObject2 = this.g;
    i1 = (int)f2;
    ((Rect)localObject2).left = i1;
    int i2 = (int)f1;
    ((Rect)localObject2).right = i2;
    localObject2 = this.h;
    ((Rect)localObject2).left = i1;
    ((Rect)localObject2).right = i2;
    if (this.o < 0.0F) {
      return;
    }
    f2 = ((View)localObject1).getLeft() + (((View)localObject1).getWidth() - this.o) / 2.0F;
    i1 = this.d;
    f1 = f2;
    if (i1 < this.f - 1)
    {
      localObject2 = this.c.getChildAt(i1 + 1);
      f1 = f2 + this.e * (((View)localObject1).getWidth() / 2 + ((View)localObject2).getWidth() / 2);
    }
    localObject1 = this.g;
    ((Rect)localObject1).left = ((int)f1);
    ((Rect)localObject1).right = ((int)(((Rect)localObject1).left + this.o));
  }
  
  protected int a(float paramFloat)
  {
    return (int)(paramFloat * this.a.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void a()
  {
    this.c.removeAllViews();
    this.f = this.b.getAdapter().getCount();
    int i1 = 0;
    while (i1 < this.f)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setClipChildren(false);
      localRelativeLayout.setClipToPadding(false);
      TextView localTextView = new TextView(getContext());
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      localObject = this.b.getAdapter().getPageTitle(i1);
      localRelativeLayout.setTag(localTextView);
      if (localObject != null) {
        a(i1, ((CharSequence)localObject).toString(), localRelativeLayout);
      }
      i1 += 1;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.f)
    {
      View localView = this.c.getChildAt(i1);
      boolean bool;
      if (i1 == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      TextView localTextView = (TextView)localView.getTag();
      if (localTextView != null)
      {
        int i2;
        if (bool) {
          i2 = this.v;
        } else {
          i2 = this.w;
        }
        localTextView.setTextColor(i2);
        localView.setFocusable(true);
        String str;
        if (bool) {
          str = "，已选中";
        } else {
          str = "，未选中";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTextView.getText());
        localStringBuilder.append(str);
        localView.setContentDescription(localStringBuilder.toString());
        if (this.x == 1) {
          localTextView.getPaint().setFakeBoldText(bool);
        }
      }
      i1 += 1;
    }
  }
  
  protected int b(float paramFloat)
  {
    return (int)(paramFloat * this.a.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public int getCurrentTab()
  {
    return this.d;
  }
  
  public int getIndicatorColor()
  {
    return this.m;
  }
  
  public float getTextsize()
  {
    return this.u;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.f <= 0) {
        return;
      }
      int i1 = getHeight();
      int i2 = getPaddingLeft();
      d();
      if (this.n < 0.0F) {
        this.n = (i1 - this.r - this.t);
      }
      float f1 = this.n;
      if (f1 > 0.0F)
      {
        float f2 = this.p;
        if ((f2 < 0.0F) || (f2 > f1 / 2.0F)) {
          this.p = (this.n / 2.0F);
        }
        this.i.setColor(this.m);
        this.i.setBounds((int)this.q + i2 + this.g.left, (int)this.r, (int)(i2 + this.g.right - this.s), (int)(this.r + this.n));
        this.i.setCornerRadius(this.p);
        this.i.draw(paramCanvas);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramFloat;
    c();
    invalidate();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" positionOffset:");
      localStringBuilder.append(paramFloat);
      QLog.i("ViewPagerTabLayout", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    a(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected:");
      localStringBuilder.append(paramInt);
      QLog.i("ViewPagerTabLayout", 2, localStringBuilder.toString());
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.d = paramParcelable.getInt("currentTab");
      paramParcelable = paramParcelable.getParcelable("currentState");
      localParcelable = paramParcelable;
      if (this.d != 0)
      {
        localParcelable = paramParcelable;
        if (this.c.getChildCount() > 0)
        {
          a(this.d);
          c();
          localParcelable = paramParcelable;
        }
      }
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("currentState", super.onSaveInstanceState());
    localBundle.putInt("currentTab", this.d);
    return localBundle;
  }
  
  public void setBoldStyle(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setCurrentTab(int paramInt)
  {
    this.d = paramInt;
    this.b.setCurrentItem(paramInt);
  }
  
  public void setCurrentTab(int paramInt, boolean paramBoolean)
  {
    this.d = paramInt;
    this.b.setCurrentItem(paramInt, paramBoolean);
    if (!paramBoolean) {
      onPageScrolled(paramInt, 0.0F, 0);
    }
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
  
  public void setOnTabSelectListener(ViewPagerTabLayout.OnTabSelectListener paramOnTabSelectListener)
  {
    this.A = paramOnTabSelectListener;
  }
  
  public void setScrollOnTabClick(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setTextsize(float paramFloat)
  {
    this.u = b(paramFloat);
    b();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager != null) && (paramViewPager.getAdapter() != null))
    {
      this.b = paramViewPager;
      this.b.setOnPageChangeListener(this);
      a();
      return;
    }
    throw new IllegalStateException("ViewPager or it's adapter can not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewPagerTabLayout
 * JD-Core Version:    0.7.0.1
 */