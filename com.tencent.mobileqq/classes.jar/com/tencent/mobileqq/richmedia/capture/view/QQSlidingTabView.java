package com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] w = { 16842901, 16842904 };
  private LinearLayout.LayoutParams a = null;
  private LinearLayout b = null;
  private ArrayList<View> c = new ArrayList(5);
  private int d = -7829368;
  private int e = -16777216;
  private int f = Color.parseColor("#E62555");
  private int g = 14;
  private int h = 0;
  private int i = 15;
  private int j = 5;
  private int k = 52;
  private int l = 0;
  private int m = 4;
  private int n = -16776961;
  private int o = 1;
  private int p = -3355444;
  private int q = 0;
  private int r = 0;
  private Paint s = null;
  private int t = 0;
  private int u = 0;
  private QQSlidingTabView.IOnTabCheckListener v;
  private boolean x = false;
  private int y = -1;
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  private void a()
  {
    int i1 = this.r;
    int i2 = this.q;
    if (i1 != i2)
    {
      Object localObject = this.b.getChildAt(i1);
      View localView = this.b.getChildAt(this.q);
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0))
        {
          this.x = true;
          return;
        }
        this.x = false;
        localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QQSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.l = this.b.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new LinearLayout.LayoutParams(-2, -1);
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(0);
    this.b.setLayoutParams(this.a);
    addView(this.b);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.h = ((int)TypedValue.applyDimension(1, this.h, localDisplayMetrics));
    this.k = ((int)TypedValue.applyDimension(1, this.k, localDisplayMetrics));
    this.m = ((int)TypedValue.applyDimension(1, this.m, localDisplayMetrics));
    this.o = ((int)TypedValue.applyDimension(1, this.o, localDisplayMetrics));
    this.i = ((int)TypedValue.applyDimension(1, this.i, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.j = ((int)TypedValue.applyDimension(1, this.j, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, w).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.h = paramContext.getDimensionPixelSize(4, this.h);
    this.i = paramContext.getDimensionPixelSize(3, this.i);
    this.n = paramContext.getColor(0, this.n);
    this.m = paramContext.getDimensionPixelSize(1, this.m);
    this.d = paramContext.getColor(6, this.d);
    this.e = paramContext.getColor(5, this.e);
    this.p = paramContext.getColor(8, this.p);
    this.o = paramContext.getDimensionPixelSize(9, this.o);
    this.g = paramContext.getDimensionPixelSize(7, this.g);
    this.j = paramContext.getDimensionPixelSize(2, this.j);
    paramContext.recycle();
    this.s = new Paint();
    this.s.setAntiAlias(true);
    this.s.setColor(this.n);
    this.s.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.u = ScreenUtil.dip2px(this.t);
  }
  
  private void b(int paramInt)
  {
    View localView = this.b.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.i * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  private void setTabChangeBackgroud(int paramInt)
  {
    int i2 = this.b.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.b.getChildAt(i1);
      Object localObject1 = this.c;
      if ((localObject1 != null) && (i1 < ((ArrayList)localObject1).size()))
      {
        localObject1 = (View)this.c.get(i1);
        if (i1 == paramInt)
        {
          if ((localObject1 instanceof ImageView))
          {
            localObject2 = (Bundle)((View)localObject1).getTag();
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("checked_image_bg_id", 2130848439));
            }
          }
          else if ((localObject1 instanceof RedDotTextView))
          {
            if (this.y == i1) {
              ((RedDotTextView)localObject2).setTextColor(this.f);
            } else {
              ((RedDotTextView)localObject2).setTextColor(this.e);
            }
            ((RedDotTextView)localObject2).a(false);
          }
          else if ((localObject1 instanceof TextView))
          {
            ((TextView)localObject2).setTextColor(this.e);
          }
        }
        else if ((localObject1 instanceof ImageView))
        {
          localObject2 = (Bundle)((View)localObject1).getTag();
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("normal_image_bg_id", 2130848438));
          }
        }
        else if ((localObject1 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject2).setTextColor(this.d);
        }
        else if ((localObject1 instanceof TextView))
        {
          ((TextView)localObject2).setTextColor(this.d);
        }
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      this.q = paramInt;
      setTabChangeBackgroud(paramInt);
      b(paramInt);
      a();
      QQSlidingTabView.IOnTabCheckListener localIOnTabCheckListener = this.v;
      if (localIOnTabCheckListener != null) {
        localIOnTabCheckListener.a(paramInt);
      }
      this.r = this.q;
    }
  }
  
  public int getTabCount()
  {
    return this.c.size();
  }
  
  public ArrayList<View> getmTabItemList()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = getHeight();
    Object localObject = this.b.getChildAt(this.q);
    if (localObject != null)
    {
      if (this.x)
      {
        this.l = ((View)localObject).getLeft();
        b(this.q);
        this.x = false;
      }
      if ((this.q == 0) && (this.l < ((View)localObject).getLeft())) {
        this.l = ((View)localObject).getLeft();
      }
      if (this.y == this.q) {
        i1 = this.f;
      } else {
        i1 = this.n;
      }
      this.s.setColor(i1);
      int i1 = this.l;
      localObject = new RectF(this.j + i1, i2 - this.m, i1 + ((View)localObject).getWidth() - this.j, i2);
      i1 = this.u;
      paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.s);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.n = paramInt;
    this.s.setColor(this.n);
    invalidate();
  }
  
  public void setTabCheckListener(QQSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.v = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */