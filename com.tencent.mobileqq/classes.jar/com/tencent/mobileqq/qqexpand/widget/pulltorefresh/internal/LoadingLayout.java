package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.qqexpand.api.R.styleable;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
abstract class LoadingLayout
  extends LoadingLayoutBase
{
  static final Interpolator a = new LinearInterpolator();
  protected final ImageView b;
  protected final ProgressBar c;
  protected final PullToRefreshBase.Mode d;
  protected final PullToRefreshBase.Orientation e;
  private final TextView f;
  private final TextView g;
  private final FrameLayout h;
  private boolean i;
  private CharSequence j;
  private CharSequence k;
  private CharSequence l;
  private CharSequence m;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.d = paramMode;
    this.e = paramOrientation;
    if (LoadingLayout.1.a[paramOrientation.ordinal()] != 1) {
      LayoutInflater.from(paramContext).inflate(2131625612, this);
    } else {
      LayoutInflater.from(paramContext).inflate(2131625611, this);
    }
    this.h = ((FrameLayout)findViewById(2131433269));
    this.f = ((TextView)this.h.findViewById(2131440892));
    this.c = ((ProgressBar)this.h.findViewById(2131440890));
    this.g = ((TextView)this.h.findViewById(2131440891));
    this.b = ((ImageView)this.h.findViewById(2131440887));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    int n;
    if (LoadingLayout.1.b[paramMode.ordinal()] != 1)
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        n = 80;
      } else {
        n = 5;
      }
      localLayoutParams.gravity = n;
      this.j = paramContext.getString(2131893025);
      this.k = paramContext.getString(2131893026);
      this.l = paramContext.getString(2131893027);
    }
    else
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        n = 48;
      } else {
        n = 3;
      }
      localLayoutParams.gravity = n;
      this.j = paramContext.getString(2131893022);
      this.k = paramContext.getString(2131893023);
      this.l = paramContext.getString(2131893024);
    }
    if (paramTypedArray.hasValue(R.styleable.aZ))
    {
      paramOrientation = paramTypedArray.getDrawable(R.styleable.aZ);
      if (paramOrientation != null) {
        ViewCompat.a(this, paramOrientation);
      }
    }
    if (paramTypedArray.hasValue(R.styleable.bd))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(R.styleable.bd, paramOrientation);
      setTextAppearance(paramOrientation.data);
    }
    if (paramTypedArray.hasValue(R.styleable.bk))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(R.styleable.bk, paramOrientation);
      setSubTextAppearance(paramOrientation.data);
    }
    if (paramTypedArray.hasValue(R.styleable.be))
    {
      paramOrientation = paramTypedArray.getColorStateList(R.styleable.be);
      if (paramOrientation != null) {
        setTextColor(paramOrientation);
      }
    }
    if (paramTypedArray.hasValue(R.styleable.bc))
    {
      paramOrientation = paramTypedArray.getColorStateList(R.styleable.bc);
      if (paramOrientation != null) {
        setSubTextColor(paramOrientation);
      }
    }
    paramOrientation = null;
    if (paramTypedArray.hasValue(R.styleable.aU)) {
      paramOrientation = paramTypedArray.getDrawable(R.styleable.aU);
    }
    if (LoadingLayout.1.b[paramMode.ordinal()] != 1)
    {
      if (paramTypedArray.hasValue(R.styleable.aX))
      {
        paramMode = paramTypedArray.getDrawable(R.styleable.aX);
      }
      else
      {
        paramMode = paramOrientation;
        if (paramTypedArray.hasValue(R.styleable.aY)) {
          paramMode = paramTypedArray.getDrawable(R.styleable.aY);
        }
      }
    }
    else if (paramTypedArray.hasValue(R.styleable.aW))
    {
      paramMode = paramTypedArray.getDrawable(R.styleable.aW);
    }
    else
    {
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(R.styleable.aV)) {
        paramMode = paramTypedArray.getDrawable(R.styleable.aV);
      }
    }
    paramOrientation = paramMode;
    if (paramMode == null) {
      paramOrientation = paramContext.getResources().getDrawable(getDefaultDrawableResId());
    }
    setLoadingDrawable(paramOrientation);
    g();
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  private void setSubTextAppearance(int paramInt)
  {
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
    localTextView = this.g;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
    localTextView = this.g;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (!this.i) {
      b(paramFloat);
    }
  }
  
  protected abstract void a(Drawable paramDrawable);
  
  protected abstract void b(float paramFloat);
  
  public final void d()
  {
    g();
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(this.j);
    }
    i();
  }
  
  public final void e()
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(this.l);
    }
    k();
  }
  
  public final void f()
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(this.k);
    }
    if (this.i) {
      ((AnimationDrawable)this.b.getDrawable()).start();
    } else {
      j();
    }
    localTextView = this.g;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public final void g()
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText(this.j);
    }
    this.b.setVisibility(0);
    if (this.i) {
      ((AnimationDrawable)this.b.getDrawable()).stop();
    } else {
      l();
    }
    localTextView = this.g;
    if (localTextView != null)
    {
      if (TextUtils.isEmpty(localTextView.getText()))
      {
        this.g.setVisibility(8);
        return;
      }
      this.g.setVisibility(0);
    }
  }
  
  public final int getContentSize()
  {
    if (LoadingLayout.1.a[this.e.ordinal()] != 1) {
      return this.h.getHeight();
    }
    return this.h.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  public final void h()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setText(this.m);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(4);
    }
  }
  
  protected abstract void i();
  
  protected abstract void j();
  
  protected abstract void k();
  
  protected abstract void l();
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
    this.i = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.f.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.LoadingLayout
 * JD-Core Version:    0.7.0.1
 */