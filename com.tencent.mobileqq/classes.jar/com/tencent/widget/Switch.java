package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CompoundButton;
import bhqv;
import bhxe;
import bhxs;
import com.tencent.mobileqq.R.styleable;

public class Switch
  extends CompoundButton
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Layout jdField_a_of_type_AndroidTextLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
  private bhxs jdField_a_of_type_Bhxs;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Layout jdField_b_of_type_AndroidTextLayout;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public Switch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034955);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidTextTextPaint.density = localResources.getDisplayMetrics().density;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Switch, paramInt, 2131755939);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(5);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(7);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getText(4);
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = "";
    }
    this.jdField_b_of_type_JavaLangCharSequence = paramAttributeSet.getText(3);
    if (this.jdField_b_of_type_JavaLangCharSequence == null) {
      this.jdField_b_of_type_JavaLangCharSequence = "";
    }
    this.jdField_a_of_type_Int = paramAttributeSet.getDimensionPixelSize(6, 0);
    this.jdField_b_of_type_Int = paramAttributeSet.getDimensionPixelSize(0, 0);
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(1, 0);
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      setSwitchTextAppearance(paramContext, paramInt);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.e = paramContext.getScaledTouchSlop();
    this.f = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
    setOnClickListener(new bhxe(this));
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      return 0;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    return this.g - this.i - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right;
  }
  
  private Layout a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_Bhxs != null) {
      paramCharSequence = this.jdField_a_of_type_Bhxs.getTransformation(paramCharSequence, this);
    }
    for (;;)
    {
      return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Typeface localTypeface = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setSwitchTypeface(localTypeface, paramInt2);
      return;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    setChecked(paramBoolean);
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Float >= a() / 2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int n = this.k;
    int i1 = this.e;
    int i2 = this.j + (int)(this.jdField_c_of_type_Float + 0.5F) - this.e;
    int i3 = this.i;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i6 = this.e;
    int i7 = this.m;
    int i8 = this.e;
    return (paramFloat1 > i2) && (paramFloat1 < i3 + i2 + i4 + i5 + i6) && (paramFloat2 > n - i1) && (paramFloat2 < i7 + i8);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.d = 0;
    int n;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
    {
      n = 1;
      a(paramMotionEvent);
      if (n == 0) {
        break label98;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
      if (Math.abs(f1) <= this.f) {
        break label89;
      }
      if (f1 <= 0.0F) {
        break label83;
      }
    }
    for (;;)
    {
      a(bool);
      return;
      n = 0;
      break;
      label83:
      bool = false;
      continue;
      label89:
      bool = a();
    }
    label98:
    a(isChecked());
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = a();; f1 = 0.0F)
    {
      this.jdField_c_of_type_Float = f1;
      return;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingRight()
  {
    int i1 = super.getCompoundPaddingRight() + this.g;
    int n = i1;
    if (!TextUtils.isEmpty(getText())) {
      n = i1 + this.jdField_c_of_type_Int;
    }
    return n;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.j;
    int n = this.k;
    int i5 = this.l;
    int i1 = this.m;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i2, n, i5, i1);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int i4 = i2 + this.jdField_a_of_type_AndroidGraphicsRect.left;
    i2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i6 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    paramCanvas.clipRect(i4, n, i5 - i6, i1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    i6 = (int)this.jdField_c_of_type_Float;
    i5 = i4 - this.jdField_a_of_type_AndroidGraphicsRect.left + i6;
    int i7 = this.i;
    i4 = this.jdField_a_of_type_AndroidGraphicsRect.right + (i4 + i6 + i7);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i5, n, i4, i1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()));
    }
    this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
    if (a()) {}
    for (Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;; localLayout = this.jdField_b_of_type_AndroidTextLayout)
    {
      if (localLayout != null)
      {
        paramCanvas.translate((i5 + i4) / 2 - localLayout.getWidth() / 2, (i2 + n + (i1 - i3)) / 2 - localLayout.getHeight() / 2);
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b(isChecked());
    paramInt3 = getWidth() - getPaddingRight();
    paramInt4 = this.g;
    switch (getGravity() & 0x70)
    {
    default: 
      paramInt2 = getPaddingTop();
      paramInt1 = this.h + paramInt2;
    }
    for (;;)
    {
      this.j = (paramInt3 - paramInt4);
      this.k = paramInt2;
      this.m = paramInt1;
      this.l = paramInt3;
      return;
      paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.h / 2;
      paramInt1 = this.h + paramInt2;
      continue;
      paramInt1 = getHeight() - getPaddingBottom();
      paramInt2 = paramInt1 - this.h;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      this.jdField_a_of_type_AndroidTextLayout = a(this.jdField_a_of_type_JavaLangCharSequence);
    }
    if (this.jdField_b_of_type_AndroidTextLayout == null) {
      this.jdField_b_of_type_AndroidTextLayout = a(this.jdField_b_of_type_JavaLangCharSequence);
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int n = Math.max(Math.max(this.jdField_a_of_type_AndroidTextLayout.getWidth(), this.jdField_b_of_type_AndroidTextLayout.getWidth()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    int i1 = Math.max(Math.max(this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()), this.jdField_a_of_type_Int * 4 + n + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right);
    int i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.i = (n + this.jdField_a_of_type_Int * 2);
    this.g = i1;
    this.h = i2;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i2) {
      setMeasuredDimension(getMeasuredWidth(), i2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      float f1;
      float f2;
      do
      {
        return bool;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((!isEnabled()) || (!a(f1, f2))) {
          break;
        }
        this.d = 1;
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        break;
        switch (this.d)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.jdField_a_of_type_Float) <= this.e) && (Math.abs(f2 - this.jdField_b_of_type_Float) <= this.e)) {
            break;
          }
          this.d = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          return true;
        case 2: 
          f1 = paramMotionEvent.getX();
          f2 = Math.max(0.0F, Math.min(f1 - this.jdField_a_of_type_Float + this.jdField_c_of_type_Float, a()));
        }
      } while (f2 == this.jdField_c_of_type_Float);
      this.jdField_c_of_type_Float = f2;
      this.jdField_a_of_type_Float = f1;
      invalidate();
      return true;
      if (this.d == 2)
      {
        b(paramMotionEvent);
        return true;
      }
      this.d = 0;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    b(isChecked());
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearanceSwitch);
    ColorStateList localColorStateList = paramContext.getColorStateList(2);
    if (localColorStateList != null)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = localColorStateList;
      paramInt = paramContext.getDimensionPixelSize(6, 0);
      if ((paramInt != 0) && (paramInt != this.jdField_a_of_type_AndroidTextTextPaint.getTextSize()))
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
        requestLayout();
      }
      a(paramContext.getInt(8, -1), paramContext.getInt(7, -1));
      if (!paramContext.getBoolean(1, false)) {
        break label130;
      }
      this.jdField_a_of_type_Bhxs = new bhqv(getContext());
      this.jdField_a_of_type_Bhxs.a(true);
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
      break;
      label130:
      this.jdField_a_of_type_Bhxs = null;
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_AndroidTextTextPaint.getTypeface() != paramTypeface)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int n;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setSwitchTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label88;
        }
        n = paramTypeface.getStyle();
        label31:
        paramInt = (n ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.jdField_a_of_type_AndroidTextTextPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.jdField_a_of_type_AndroidTextTextPaint;
        if ((paramInt & 0x2) == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (float f1 = -0.25F;; f1 = 0.0F)
      {
        paramTypeface.setTextSkewX(f1);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        n = 0;
        break label31;
      }
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(false);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (paramDrawable == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.Switch
 * JD-Core Version:    0.7.0.1
 */