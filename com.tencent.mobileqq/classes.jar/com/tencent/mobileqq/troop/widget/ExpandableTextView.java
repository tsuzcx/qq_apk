package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.impl.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static float c = 0.7F;
  protected TextView a;
  protected TextView b;
  private CharSequence d;
  private boolean e;
  private boolean f = true;
  private int g;
  private int h;
  private int i;
  private int j;
  private String k;
  private String l;
  private int m;
  private float n;
  private boolean o;
  private ExpandableTextView.OnGlobalLayoutListenerByEllipsize p;
  private ExpandableTextView.OnExpandStateListener q;
  private SparseBooleanArray r;
  private int s;
  
  public ExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  @TargetApi(11)
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private int a(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + (paramTextView.getCompoundPaddingTop() + paramTextView.getCompoundPaddingBottom());
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131432667));
    this.a.setEllipsize(TextUtils.TruncateAt.END);
    this.b = ((TextView)findViewById(2131432662));
    TextView localTextView = this.b;
    String str;
    if (this.f) {
      str = this.k;
    } else {
      str = this.l;
    }
    localTextView.setText(str);
    this.b.setOnClickListener(this);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ab);
    this.i = paramAttributeSet.getInt(R.styleable.ag, 7);
    this.m = paramAttributeSet.getInt(R.styleable.ad, 400);
    this.n = paramAttributeSet.getFloat(R.styleable.ac, c);
    this.k = paramAttributeSet.getString(R.styleable.af);
    this.l = paramAttributeSet.getString(R.styleable.ae);
    if (TextUtils.isEmpty(this.k)) {
      this.k = HardCodeUtil.a(2131902263);
    }
    if (TextUtils.isEmpty(this.l)) {
      this.l = "";
    }
    paramAttributeSet.recycle();
    setOrientation(1);
    setVisibility(8);
  }
  
  @TargetApi(11)
  private static void b(View paramView, float paramFloat)
  {
    if (b())
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private static boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public TextView getContentTextView()
  {
    return this.a;
  }
  
  public CharSequence getText()
  {
    TextView localTextView = this.a;
    if (localTextView == null) {
      return null;
    }
    return localTextView.getText();
  }
  
  public void onClick(View paramView)
  {
    if (this.b.getVisibility() == 0)
    {
      this.f ^= true;
      if (this.f)
      {
        this.b.setText(this.k);
      }
      else
      {
        this.b.setText(this.l);
        if (!this.a.getText().equals(this.d)) {
          this.a.setText(this.d);
        }
      }
      Object localObject = this.r;
      if (localObject != null) {
        ((SparseBooleanArray)localObject).put(this.s, this.f);
      }
      localObject = this.q;
      if (localObject != null) {
        ((ExpandableTextView.OnExpandStateListener)localObject).a(this.a, this.b, this.f ^ true);
      }
      this.e = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void onFinishInflate()
  {
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.o;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.e) && (getVisibility() != 8))
    {
      this.e = false;
      this.b.setVisibility(8);
      this.a.setMaxLines(2147483647);
      super.onMeasure(paramInt1, paramInt2);
      if (this.a.getLineCount() <= this.i) {
        return;
      }
      this.h = a(this.a);
      if (this.f)
      {
        this.a.setMaxLines(this.i);
        if (this.p == null) {
          this.p = new ExpandableTextView.OnGlobalLayoutListenerByEllipsize(this.a, this.i);
        }
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
      }
      this.b.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
      if (this.f)
      {
        this.a.post(new ExpandableTextView.1(this));
        this.g = getMeasuredHeight();
      }
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOnExpandStateChangeListener(ExpandableTextView.OnExpandStateListener paramOnExpandStateListener)
  {
    this.q = paramOnExpandStateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 0)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.e = true;
    this.d = paramCharSequence;
    this.a.setText(paramCharSequence);
    int i1;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    setVisibility(i1);
  }
  
  public void setText(CharSequence paramCharSequence, SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    this.r = paramSparseBooleanArray;
    this.s = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.f = bool;
    TextView localTextView = this.b;
    if (this.f) {
      paramSparseBooleanArray = this.k;
    } else {
      paramSparseBooleanArray = this.l;
    }
    localTextView.setText(paramSparseBooleanArray);
    setText(paramCharSequence);
    getLayoutParams().height = -2;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView
 * JD-Core Version:    0.7.0.1
 */