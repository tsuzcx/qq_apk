package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.impl.R.styleable;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RedDotTextView;

@TargetApi(14)
public class GuildDiscoverSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] l = { 16842901, 16842904 };
  private int A = 0;
  private Paint B;
  private RectF C;
  private InterceptListener D;
  private GuildDiscoverSlidingIndicator.OnCurrentTabClickListener E;
  protected LinearLayout a;
  protected int b = 0;
  protected int c = 0;
  protected String[] d;
  protected int[] e;
  protected int f = -16776961;
  protected GuildDiscoverSlidingIndicator.OnTabListener g;
  SparseBooleanArray h = new SparseBooleanArray();
  Drawable i;
  protected int j;
  ViewTreeObserver.OnGlobalLayoutListener k = new GuildDiscoverSlidingIndicator.4(this);
  private int m;
  private int n = -16777216;
  private int o = -7829368;
  private int p = 25;
  private int q = 6;
  private int r = 108;
  private int s = 51;
  private int t = 12;
  private int u = 16;
  private int v = 16;
  private int w = 12;
  private int x = 52;
  private int y = 0;
  private int z = 0;
  
  public GuildDiscoverSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildDiscoverSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildDiscoverSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.x = ((int)TypedValue.applyDimension(1, this.x, (DisplayMetrics)localObject));
    this.r = ((int)TypedValue.applyDimension(1, this.r, (DisplayMetrics)localObject));
    this.s = ((int)TypedValue.applyDimension(1, this.s, (DisplayMetrics)localObject));
    this.t = ((int)TypedValue.applyDimension(1, this.t, (DisplayMetrics)localObject));
    this.u = ((int)TypedValue.applyDimension(1, this.u, (DisplayMetrics)localObject));
    this.v = ((int)TypedValue.applyDimension(1, this.v, (DisplayMetrics)localObject));
    this.q = ((int)TypedValue.applyDimension(1, this.q, (DisplayMetrics)localObject));
    this.w = ((int)TypedValue.applyDimension(2, this.w, (DisplayMetrics)localObject));
    this.y = ((int)TypedValue.applyDimension(1, this.y, (DisplayMetrics)localObject));
    this.z = ((int)TypedValue.applyDimension(1, this.z, (DisplayMetrics)localObject));
    this.A = ((int)TypedValue.applyDimension(1, this.A, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, l);
    this.w = ((TypedArray)localObject).getDimensionPixelSize(0, this.w);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.au);
    this.f = paramAttributeSet.getColor(R.styleable.ax, this.f);
    this.p = paramAttributeSet.getInt(R.styleable.aw, this.p);
    this.n = paramAttributeSet.getColor(R.styleable.av, this.n);
    this.o = paramAttributeSet.getColor(R.styleable.aG, this.o);
    this.u = paramAttributeSet.getDimensionPixelSize(R.styleable.aB, this.u);
    this.v = paramAttributeSet.getDimensionPixelSize(R.styleable.aC, this.v);
    this.r = paramAttributeSet.getDimensionPixelSize(R.styleable.aA, this.r);
    this.s = paramAttributeSet.getDimensionPixelSize(R.styleable.ay, this.s);
    this.t = paramAttributeSet.getDimensionPixelSize(R.styleable.az, this.t);
    this.q = paramAttributeSet.getDimensionPixelSize(R.styleable.aE, this.q);
    this.y = paramAttributeSet.getDimensionPixelSize(R.styleable.aD, this.y);
    this.z = paramAttributeSet.getDimensionPixelSize(R.styleable.aF, this.z);
    this.A = paramAttributeSet.getDimensionPixelSize(R.styleable.cy, this.A);
    paramAttributeSet.recycle();
    paramInt = this.p;
    if (paramInt > 255) {
      this.p = 255;
    } else if (paramInt < 0) {
      this.p = 0;
    }
    c();
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new GuildDiscoverSlidingIndicator.1(this));
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new GuildDiscoverSlidingIndicator.2(this, paramInt));
    int i1 = this.q;
    paramView.setPadding(i1, 0, i1, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    i1 = this.y;
    if (i1 != 0) {
      if (paramInt == 0) {
        localLayoutParams.leftMargin = 0;
      } else {
        localLayoutParams.leftMargin = i1;
      }
    }
    i1 = this.z;
    if (i1 != 0) {
      localLayoutParams.width = i1;
    }
    this.a.addView(paramView, paramInt, localLayoutParams);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setPadding(30, 4, 30, 4);
    localRedDotTextView.setSingleLine();
    paramString = new RedTouch(getContext(), localRedDotTextView).c(53).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
  }
  
  private void a(Context paramContext)
  {
    this.i = getResources().getDrawable(2130840796);
    this.a = new LinearLayout(paramContext);
    this.a.setOrientation(0);
    this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.a;
    int i1 = this.A;
    paramContext.setPadding(i1, 0, i1, 0);
    addView(this.a);
  }
  
  private void c()
  {
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setStyle(Paint.Style.FILL);
    this.B.setTextSize(this.w);
    this.C = new RectF();
  }
  
  private void d()
  {
    int i1 = 0;
    while (i1 < this.m)
    {
      Object localObject = this.a.getChildAt(i1);
      if ((localObject instanceof RedTouch))
      {
        localObject = (RedTouch)localObject;
        if ((((RedTouch)localObject).getTarget() instanceof TextView)) {
          ((TextView)((RedTouch)localObject).getTarget()).setTextSize(0, this.w);
        }
      }
      i1 += 1;
    }
  }
  
  protected void a()
  {
    int i1 = this.c;
    int i2 = this.b;
    if (i1 != i2)
    {
      Object localObject = this.a.getChildAt(i1);
      View localView = this.a.getChildAt(this.b);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new GuildDiscoverSlidingIndicator.3(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.j = this.a.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.m == 0) {
      return;
    }
    setAccessibilityMsg();
    View localView = this.a.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.q * 3;
      int i2 = localView.getRight() - paramInt + i1 - getWidth();
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = getResources().getColor(paramInt1);
    this.o = getResources().getColor(paramInt2);
    this.f = getResources().getColor(paramInt3);
    setChooseTabViewTextColor(this.b);
    invalidate();
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.b;
    if ((i1 != paramInt) && (i1 >= 0))
    {
      this.c = i1;
      this.b = paramInt;
      setChooseTabViewTextColor(paramInt);
      a(this.b);
      if (paramBoolean1)
      {
        a();
      }
      else
      {
        localObject = this.a.getChildAt(this.b);
        if (localObject != null) {
          this.j = ((View)localObject).getLeft();
        }
        invalidate();
      }
      Object localObject = this.g;
      if (localObject != null) {
        ((GuildDiscoverSlidingIndicator.OnTabListener)localObject).a(paramInt, paramBoolean2);
      }
    }
  }
  
  public void b()
  {
    this.a.removeAllViews();
    this.m = this.d.length;
    int i1 = 0;
    while (i1 < this.m)
    {
      a(i1, this.d[i1], this.e[i1]);
      i1 += 1;
    }
    d();
    getViewTreeObserver().addOnGlobalLayoutListener(this.k);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 255)
    {
      this.p = 255;
      return;
    }
    if (paramInt < 0)
    {
      this.p = 0;
      return;
    }
    this.p = paramInt;
  }
  
  public int getCurrentPosition()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.m == 0) {
        return;
      }
      getHeight();
      this.B.setColor(this.f);
      this.B.setAlpha(this.p);
      Object localObject1 = this.a.getChildAt(this.b);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.C;
        i1 = this.j;
        ((RectF)localObject2).set(this.q + i1 - this.t, this.r, i1 + ((View)localObject1).getWidth() - this.q + this.t, this.s);
        paramCanvas.drawRoundRect(this.C, this.u, this.v, this.B);
      }
      int i1 = 0;
      while (i1 < this.m)
      {
        if (this.h.get(i1))
        {
          localObject1 = (RedTouch)this.a.getChildAt(i1);
          localObject2 = (TextView)((RedTouch)localObject1).getTarget();
          int i3 = ((RedTouch)localObject1).getRight();
          int i4 = ((TextView)localObject2).getPaddingRight();
          int i2 = ((TextView)localObject2).getTop();
          i3 = i3 - i4 - this.q;
          i4 = ViewUtils.dip2px(10.0F);
          this.i.setBounds(i3, i2, i3 + i4, i4 + i2);
          this.i.draw(paramCanvas);
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    InterceptListener localInterceptListener;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3))
      {
        localInterceptListener = this.D;
        if (localInterceptListener != null) {
          localInterceptListener.a(false);
        }
      }
    }
    else
    {
      localInterceptListener = this.D;
      if (localInterceptListener != null) {
        localInterceptListener.a(true);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 1) || (i1 == 3))
    {
      InterceptListener localInterceptListener = this.D;
      if (localInterceptListener != null) {
        localInterceptListener.a(false);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.e)
    {
      int i1 = 0;
      while (i1 < this.m)
      {
        View localView = this.a.getChildAt(i1);
        if (localView != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.d[i1]);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131890370));
          String str = ((StringBuilder)localObject).toString();
          localObject = str;
          if (i1 == this.b)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131890371));
            localObject = ((StringBuilder)localObject).toString();
          }
          localView.setContentDescription((CharSequence)localObject);
        }
        i1 += 1;
      }
    }
  }
  
  public void setCheckedTextColor(int paramInt)
  {
    this.n = paramInt;
  }
  
  protected void setChooseTabViewTextColor(int paramInt)
  {
    int i2 = this.a.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      TextView localTextView = (TextView)((RedTouch)this.a.getChildAt(i1)).getTarget();
      if (i1 == paramInt)
      {
        localTextView.setTextColor(this.n);
        localTextView.setTypeface(Typeface.defaultFromStyle(1));
      }
      else
      {
        localTextView.setTextColor(this.o);
        localTextView.setTypeface(Typeface.defaultFromStyle(0));
      }
      i1 += 1;
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setInterceptListener(InterceptListener paramInterceptListener)
  {
    this.D = paramInterceptListener;
  }
  
  public void setOnTabClickListener(GuildDiscoverSlidingIndicator.OnCurrentTabClickListener paramOnCurrentTabClickListener)
  {
    this.E = paramOnCurrentTabClickListener;
  }
  
  public void setOnTabListener(GuildDiscoverSlidingIndicator.OnTabListener paramOnTabListener)
  {
    this.g = paramOnTabListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (paramArrayOfInt != null))
    {
      if (paramArrayOfInt.length != paramArrayOfString.length) {
        return;
      }
      this.d = ((String[])paramArrayOfString.clone());
      this.e = ((int[])paramArrayOfInt.clone());
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */