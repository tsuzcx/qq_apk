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
  static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected final ImageView a;
  protected final ProgressBar a;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final PullToRefreshBase.Mode a;
  protected final PullToRefreshBase.Orientation a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private CharSequence c;
  private CharSequence d;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Orientation = paramOrientation;
    if (LoadingLayout.1.a[paramOrientation.ordinal()] != 1) {
      LayoutInflater.from(paramContext).inflate(2131559583, this);
    } else {
      LayoutInflater.from(paramContext).inflate(2131559582, this);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366923));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373283));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373281));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373282));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373278));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int i;
    if (LoadingLayout.1.b[paramMode.ordinal()] != 1)
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        i = 80;
      } else {
        i = 5;
      }
      localLayoutParams.gravity = i;
      this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131695290);
      this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131695291);
      this.c = paramContext.getString(2131695292);
    }
    else
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        i = 48;
      } else {
        i = 3;
      }
      localLayoutParams.gravity = i;
      this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131695287);
      this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131695288);
      this.c = paramContext.getString(2131695289);
    }
    if (paramTypedArray.hasValue(R.styleable.i))
    {
      paramOrientation = paramTypedArray.getDrawable(R.styleable.i);
      if (paramOrientation != null) {
        ViewCompat.a(this, paramOrientation);
      }
    }
    if (paramTypedArray.hasValue(R.styleable.m))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(R.styleable.m, paramOrientation);
      b(paramOrientation.data);
    }
    if (paramTypedArray.hasValue(R.styleable.t))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(R.styleable.t, paramOrientation);
      a(paramOrientation.data);
    }
    if (paramTypedArray.hasValue(R.styleable.n))
    {
      paramOrientation = paramTypedArray.getColorStateList(R.styleable.n);
      if (paramOrientation != null) {
        b(paramOrientation);
      }
    }
    if (paramTypedArray.hasValue(R.styleable.l))
    {
      paramOrientation = paramTypedArray.getColorStateList(R.styleable.l);
      if (paramOrientation != null) {
        a(paramOrientation);
      }
    }
    paramOrientation = null;
    if (paramTypedArray.hasValue(R.styleable.d)) {
      paramOrientation = paramTypedArray.getDrawable(R.styleable.d);
    }
    if (LoadingLayout.1.b[paramMode.ordinal()] != 1)
    {
      if (paramTypedArray.hasValue(R.styleable.g))
      {
        paramMode = paramTypedArray.getDrawable(R.styleable.g);
      }
      else
      {
        paramMode = paramOrientation;
        if (paramTypedArray.hasValue(R.styleable.h)) {
          paramMode = paramTypedArray.getDrawable(R.styleable.h);
        }
      }
    }
    else if (paramTypedArray.hasValue(R.styleable.f))
    {
      paramMode = paramTypedArray.getDrawable(R.styleable.f);
    }
    else
    {
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(R.styleable.e)) {
        paramMode = paramTypedArray.getDrawable(R.styleable.e);
      }
    }
    paramOrientation = paramMode;
    if (paramMode == null) {
      paramOrientation = paramContext.getResources().getDrawable(b());
    }
    setLoadingDrawable(paramOrientation);
    g();
  }
  
  private void a(int paramInt)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  private void b(int paramInt)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void b(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public final int a()
  {
    if (LoadingLayout.1.a[this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Orientation.ordinal()] != 1) {
      return this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
  }
  
  public final void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramFloat);
    }
  }
  
  protected abstract void a(Drawable paramDrawable);
  
  protected abstract int b();
  
  protected abstract void b(float paramFloat);
  
  public final void d()
  {
    g();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    i();
  }
  
  public final void e()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(this.c);
    }
    k();
  }
  
  public final void f()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
    }
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    } else {
      j();
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public final void g()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    } else {
      l();
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (TextUtils.isEmpty(localTextView.getText()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public final void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(this.d);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
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
    a(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Boolean = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.LoadingLayout
 * JD-Core Version:    0.7.0.1
 */