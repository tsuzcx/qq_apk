package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.base.tabs.InterceptListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;

@TargetApi(14)
public abstract class AbsSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] a = { 16842901, 16842904 };
  protected ViewTreeObserver.OnGlobalLayoutListener A = new AbsSlidingIndicator.3(this);
  private int b;
  private int c = 25;
  private int d = 6;
  private InterceptListener e;
  private AbsSlidingIndicator.OnCurrentTabClickListener f;
  protected LinearLayout g;
  protected int h = 0;
  protected int i = 0;
  protected String[] j;
  protected int[] k;
  protected int l = -16777216;
  protected int m = -7829368;
  protected int n = -16776961;
  protected int o = 12;
  protected boolean p;
  protected Paint q;
  protected RectF r;
  protected AbsSlidingIndicator.OnTabListener s;
  protected boolean t = false;
  SparseBooleanArray u = new SparseBooleanArray();
  protected int v = 30;
  protected int w = 4;
  protected AbsSlidingIndicator.OnAddTabListener x;
  Drawable y;
  protected int z;
  
  public AbsSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbsSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new AbsSlidingIndicator.1(this));
    }
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < this.b)
    {
      Object localObject = this.g.getChildAt(i1);
      if ((localObject instanceof RedTouch))
      {
        localObject = (RedTouch)localObject;
        if ((((RedTouch)localObject).getTarget() instanceof TextView)) {
          ((TextView)((RedTouch)localObject).getTarget()).setTextSize(0, this.o);
        }
      }
      i1 += 1;
    }
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.g.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.h())) {
      localRedTouch.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = getResources().getColor(paramInt1);
    this.m = getResources().getColor(paramInt2);
    this.n = getResources().getColor(paramInt3);
    setChooseTabViewTextColor(this.h);
    invalidate();
  }
  
  protected abstract void a(int paramInt, View paramView);
  
  public void a(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = (RedTouch)this.g.findViewById(paramInt);
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.j != null) && (this.k != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i1 = 0;
      for (;;)
      {
        int[] arrayOfInt = this.k;
        if (i1 >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i1] == paramInt)
        {
          this.j[i1] = paramString;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new RedDotTextView(getContext());
    ((RedDotTextView)localObject).setText(paramString);
    ((RedDotTextView)localObject).setGravity(17);
    int i1 = this.v;
    int i2 = this.w;
    ((RedDotTextView)localObject).setPadding(i1, i2, i1, i2);
    ((RedDotTextView)localObject).setSingleLine();
    paramString = new RedTouch(getContext(), (View)localObject).c(53).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
    localObject = this.x;
    if (localObject != null) {
      ((AbsSlidingIndicator.OnAddTabListener)localObject).a(paramString, paramInt1);
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.h;
    if ((i1 != paramInt) && (i1 >= 0))
    {
      this.i = i1;
      this.h = paramInt;
      setChooseTabViewTextColor(paramInt);
      b(this.h);
      if (paramBoolean1)
      {
        a();
      }
      else
      {
        if (this.g.getChildAt(this.h) != null) {
          this.z = getAniStartX();
        }
        invalidate();
      }
      AbsSlidingIndicator.OnTabListener localOnTabListener = this.s;
      if (localOnTabListener != null) {
        localOnTabListener.a(paramInt, paramBoolean2);
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    this.y = getResources().getDrawable(2130840131);
    this.g = new LinearLayout(paramContext);
    this.g.setOrientation(0);
    this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramContext = getContainerPadding();
    this.g.setPadding(paramContext[0], paramContext[1], paramContext[2], paramContext[3]);
    addView(this.g);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  protected void b()
  {
    this.q = new Paint();
    this.q.setAntiAlias(true);
    this.q.setStyle(Paint.Style.FILL);
    this.q.setTextSize(this.o);
    this.r = new RectF();
  }
  
  protected void b(int paramInt)
  {
    if (this.b == 0) {
      return;
    }
    setAccessibilityMsg();
    View localView = this.g.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.d * 3;
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
  
  protected void b(int paramInt, View paramView)
  {
    paramView.setOnClickListener(new AbsSlidingIndicator.2(this, paramInt));
  }
  
  public void c()
  {
    this.g.removeAllViews();
    this.b = this.j.length;
    int i1 = 0;
    while (i1 < this.b)
    {
      a(i1, this.j[i1], this.k[i1]);
      i1 += 1;
    }
    e();
    getViewTreeObserver().addOnGlobalLayoutListener(this.A);
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 255)
    {
      this.c = 255;
      return;
    }
    if (paramInt < 0)
    {
      this.c = 0;
      return;
    }
    this.c = paramInt;
  }
  
  public void d()
  {
    if (this.A != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
      } else {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.A);
      }
      this.A = null;
    }
  }
  
  public void d(int paramInt)
  {
    this.u.put(paramInt, true);
    invalidate();
  }
  
  public void e(int paramInt)
  {
    this.u.delete(paramInt);
    invalidate();
  }
  
  protected abstract int getAniStartX();
  
  protected abstract int[] getContainerPadding();
  
  public int getCurrentPosition()
  {
    return this.h;
  }
  
  protected abstract int getInitAniStartX();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.b == 0) {
        return;
      }
      getHeight();
      this.q.setColor(this.n);
      this.q.setAlpha(this.c);
      if (this.g.getChildAt(this.h) != null) {
        a(paramCanvas);
      }
      int i1 = 0;
      while (i1 < this.b)
      {
        if (this.u.get(i1))
        {
          RedTouch localRedTouch = (RedTouch)this.g.getChildAt(i1);
          TextView localTextView = (TextView)localRedTouch.getTarget();
          int i3 = localRedTouch.getRight();
          int i4 = localTextView.getPaddingRight();
          int i2 = localTextView.getTop();
          i3 = i3 - i4 - this.d;
          i4 = ViewUtils.dip2px(10.0F);
          this.y.setBounds(i3, i2, i3 + i4, i4 + i2);
          this.y.draw(paramCanvas);
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
        localInterceptListener = this.e;
        if (localInterceptListener != null) {
          localInterceptListener.b(false);
        }
      }
    }
    else
    {
      localInterceptListener = this.e;
      if (localInterceptListener != null) {
        localInterceptListener.b(true);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 1) || (i1 == 3))
    {
      InterceptListener localInterceptListener = this.e;
      if (localInterceptListener != null) {
        localInterceptListener.b(false);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.e)
    {
      int i1 = 0;
      while (i1 < this.b)
      {
        View localView = this.g.getChildAt(i1);
        if (localView != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.j[i1]);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131911570));
          String str = ((StringBuilder)localObject).toString();
          localObject = str;
          if (i1 == this.h)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131911571));
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
    this.l = paramInt;
  }
  
  protected void setChooseTabViewTextColor(int paramInt)
  {
    int i2 = this.g.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      TextView localTextView = (TextView)((RedTouch)this.g.getChildAt(i1)).getTarget();
      if (i1 == paramInt) {
        localTextView.setTextColor(this.l);
      } else {
        localTextView.setTextColor(this.m);
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
    this.n = paramInt;
  }
  
  public void setInterceptListener(InterceptListener paramInterceptListener)
  {
    this.e = paramInterceptListener;
  }
  
  public void setItemContentPaddingLR(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setOnAddTabListener(AbsSlidingIndicator.OnAddTabListener paramOnAddTabListener)
  {
    this.x = paramOnAddTabListener;
  }
  
  public void setOnTabClickListener(AbsSlidingIndicator.OnCurrentTabClickListener paramOnCurrentTabClickListener)
  {
    this.f = paramOnCurrentTabClickListener;
  }
  
  public void setOnTabListener(AbsSlidingIndicator.OnTabListener paramOnTabListener)
  {
    this.s = paramOnTabListener;
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
      this.j = ((String[])paramArrayOfString.clone());
      this.k = ((int[])paramArrayOfInt.clone());
      if (this.k.length > 6) {
        this.p = true;
      }
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AbsSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */