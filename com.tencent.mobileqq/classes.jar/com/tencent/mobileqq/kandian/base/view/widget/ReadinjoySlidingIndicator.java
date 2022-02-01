package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ReadinjoySlidingIndicator
  extends FrameLayout
{
  private static final int[] a = { 16842901, 16842904 };
  private LinearLayout b;
  private int c;
  private int d = 0;
  private int e = 0;
  private String[] f;
  private int[] g;
  private LinearLayout.LayoutParams h;
  private int i = -16777216;
  private int j = -7829368;
  private int k = 18;
  private int l = 18;
  private int m = 4;
  private int n = -16776961;
  private Paint o;
  private ReadinjoySlidingIndicator.OnIndicatorChangeListener p;
  private LinearLayout q;
  private ImageView r;
  private int s;
  
  public ReadinjoySlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.m = ((int)TypedValue.applyDimension(1, this.m, (DisplayMetrics)localObject));
    this.k = ((int)TypedValue.applyDimension(1, this.k, (DisplayMetrics)localObject));
    this.l = ((int)TypedValue.applyDimension(2, this.l, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    this.l = ((TypedArray)localObject).getDimensionPixelSize(0, this.l);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ReadingJoySlidingIndicator);
    this.n = paramAttributeSet.getColor(2, this.n);
    this.i = paramAttributeSet.getColor(1, this.i);
    this.j = paramAttributeSet.getColor(4, this.j);
    this.m = paramAttributeSet.getDimensionPixelSize(0, this.m);
    this.k = paramAttributeSet.getDimensionPixelSize(3, this.k);
    paramAttributeSet.recycle();
    a();
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new ReadinjoySlidingIndicator.1(this));
    }
  }
  
  private void a()
  {
    this.o = new Paint();
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL);
    this.o.setTextSize(this.l);
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    this.b.addView(paramView, paramInt, this.h);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setMaxLines(1);
    int i1 = this.k;
    localTextView.setPadding(i1, 0, i1, 0);
    localTextView.setTextSize(0, this.l);
    localTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt3 + 3) });
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject = paramString;
    if (paramString.length() > paramInt3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, paramInt3));
      ((StringBuilder)localObject).append("...");
      localObject = ((StringBuilder)localObject).toString();
    }
    localTextView.setText((CharSequence)localObject);
    paramString = new RedTouch(getContext(), localTextView).c(53).b(8.0F).c(12.0F).a(true).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
  }
  
  private void a(Context paramContext)
  {
    this.h = new LinearLayout.LayoutParams(-2, -1);
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(0);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.b.setGravity(1);
    b();
  }
  
  private void b()
  {
    this.q = new LinearLayout(getContext());
    this.q.setOrientation(0);
    this.q.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 1));
    this.q.addView(this.b);
    this.q.addView(getTabsContainerBtnImage());
    addView(this.q);
  }
  
  private void b(int paramInt)
  {
    this.b.removeAllViews();
    this.c = this.f.length;
    int i1 = 0;
    while (i1 < this.c)
    {
      a(i1, this.f[i1], this.g[i1], paramInt);
      i1 += 1;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new ReadinjoySlidingIndicator.3(this));
  }
  
  private void c()
  {
    ImageView localImageView = this.r;
    if (localImageView != null)
    {
      localImageView.setColorFilter(this.i);
      QLog.d("tag", 2, new Object[] { "color: ", Integer.valueOf(this.i) });
    }
  }
  
  private void d()
  {
    int i1 = this.e;
    int i2 = this.d;
    if (i1 != i2)
    {
      Object localObject = this.b.getChildAt(i1);
      View localView = this.b.getChildAt(this.d);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new ReadinjoySlidingIndicator.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.s = this.b.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  private void setChooseTabViewTextColor(int paramInt)
  {
    int i2 = this.b.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      TextView localTextView = (TextView)((RedTouch)this.b.getChildAt(i1)).getTarget();
      if (i1 == paramInt) {
        localTextView.setTextColor(this.i);
      } else {
        localTextView.setTextColor(this.j);
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.b.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.h())) {
      localRedTouch.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = getResources().getColor(paramInt1);
    this.j = (this.i & 0xFFFFFF | 0x99000000);
    this.n = getResources().getColor(paramInt3);
    setChooseTabViewTextColor(this.d);
    c();
    invalidate();
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = this.d;
    this.d = paramInt;
    int i1 = this.d;
    if ((i1 != this.e) && (i1 >= 0))
    {
      localObject = (RedTouch)this.b.getChildAt(i1);
      setChooseTabViewTextColor(paramInt);
      if (paramBoolean1)
      {
        d();
      }
      else
      {
        this.s = ((RedTouch)localObject).getLeft();
        invalidate();
      }
    }
    Object localObject = this.p;
    if (localObject != null) {
      ((ReadinjoySlidingIndicator.OnIndicatorChangeListener)localObject).a(this.e, this.d, paramBoolean2);
    }
  }
  
  public int getCurrentPosition()
  {
    return this.d;
  }
  
  public int getPrePosition()
  {
    return this.e;
  }
  
  public ImageView getTabsContainerBtnImage()
  {
    if (this.r == null)
    {
      this.r = new ImageView(getContext());
      c();
      this.r.setImageResource(2130851516);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.b(7.0F, getResources()), AIOUtils.b(7.0F, getResources()));
      localLayoutParams.gravity = 16;
      localLayoutParams.leftMargin = (-AIOUtils.b(11.0F, getResources()));
      this.r.setLayoutParams(localLayoutParams);
    }
    return this.r;
  }
  
  public LinearLayout getTabsContainerWrapper()
  {
    return this.q;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.c == 0) {
        return;
      }
      getHeight();
      this.o.setColor(this.n);
    }
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.e)
    {
      int i1 = 0;
      while (i1 < this.c)
      {
        View localView = this.b.getChildAt(i1);
        if (localView != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.f[i1]);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131910483));
          String str = ((StringBuilder)localObject).toString();
          localObject = str;
          if (i1 == this.d)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131910612));
            localObject = ((StringBuilder)localObject).toString();
          }
          localView.setContentDescription((CharSequence)localObject);
        }
        i1 += 1;
      }
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void setOnIndicatorChangeListener(ReadinjoySlidingIndicator.OnIndicatorChangeListener paramOnIndicatorChangeListener)
  {
    this.p = paramOnIndicatorChangeListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (paramArrayOfInt != null))
    {
      if (paramArrayOfInt.length != paramArrayOfString.length) {
        return;
      }
      this.f = ((String[])paramArrayOfString.clone());
      this.g = ((int[])paramArrayOfInt.clone());
      b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator
 * JD-Core Version:    0.7.0.1
 */