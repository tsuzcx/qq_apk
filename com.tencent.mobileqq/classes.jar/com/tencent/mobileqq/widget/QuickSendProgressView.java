package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;

public class QuickSendProgressView
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private QuickSendProgressView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_c_of_type_Int;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_d_of_type_Int;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_e_of_type_Int;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_f_of_type_Int;
  private Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_g_of_type_Int;
  private Drawable jdField_g_of_type_AndroidGraphicsDrawableDrawable;
  private int h;
  private int i;
  private int j;
  
  public QuickSendProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    int k = getWidth();
    int m = getHeight();
    if ((k <= 0) || (m <= 0)) {
      return;
    }
    k = Math.min(k, m);
    this.j = ((int)Math.ceil(a(paramFloat, -k / 2.0F, k / 2.0F)));
    invalidate();
  }
  
  private void a(Canvas paramCanvas)
  {
    int m;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      k = getWidth();
      m = getHeight();
      if ((k > 0) && (m > 0)) {}
    }
    else
    {
      return;
    }
    int k = Math.min(k, m);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, k / 2.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, @ColorInt int paramInt)
  {
    int k = getWidth();
    int m = getHeight();
    if ((k <= 0) || (m <= 0)) {
      return;
    }
    k = Math.min(k, m);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.h, this.h, k - this.h, k - this.h);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.jdField_b_of_type_Int * 1.0F / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    int m;
    if (paramDrawable != null)
    {
      k = getWidth();
      m = getHeight();
      if ((k > 0) && (m > 0)) {}
    }
    else
    {
      return;
    }
    this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    int k = Math.min(k, m);
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k - this.jdField_g_of_type_Int * 2 - this.h * 2, k - this.jdField_g_of_type_Int * 2 - this.h * 2);
    this.jdField_a_of_type_AndroidGraphicsRect.offset((k - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k - this.h * 2 - this.i * 2, k - this.h * 2 - this.i * 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.offset((k - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
      paramDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      paramCanvas.translate(this.j, -this.j);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k - this.jdField_g_of_type_Int * 2 - this.h * 2 - this.i * 2, k - this.jdField_g_of_type_Int * 2 - this.h * 2 - this.i * 2);
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(getDrawableState()))) {
      invalidateDrawable(paramDrawable);
    }
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(StateSet.NOTHING));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_g_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void b(Canvas paramCanvas)
  {
    int k = getWidth();
    int m = getHeight();
    if ((k <= 0) || (m <= 0)) {
      return;
    }
    k = Math.min(k, m);
    Drawable localDrawable;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k - this.h * 2, k - this.h * 2);
      this.jdField_a_of_type_AndroidGraphicsRect.offset((k - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
      paramCanvas.save();
      localDrawable = null;
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        localDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k - this.jdField_g_of_type_Int * 2 - this.h * 2, k - this.jdField_g_of_type_Int * 2 - this.h * 2);
      break;
      localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      continue;
      localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      continue;
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    a(this.jdField_g_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void c(Canvas paramCanvas)
  {
    int k = getWidth();
    int m = getHeight();
    if ((k <= 0) || (m <= 0)) {}
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      k = Math.min(k, m);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.h, this.h, k - this.h, k - this.h);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
      continue;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.h = a(2.0F, getResources());
    this.jdField_g_of_type_Int = a(3.0F, getResources());
    this.i = a(1.0F, getResources());
    this.jdField_a_of_type_JavaLangString = getResources().getString(2131692551);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846095);
    this.jdField_c_of_type_Int = Color.parseColor("#19BAFF");
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846097);
    this.jdField_e_of_type_Int = Color.parseColor("#3300CAFC");
    this.jdField_f_of_type_Int = Color.parseColor("#33FF596A");
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846093);
    this.jdField_d_of_type_Int = Color.parseColor("#FF596A");
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(a(14.0F, getResources()));
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165586));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846096);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846099);
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846094);
    setContentDescription(getResources().getString(2131690786));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.jdField_g_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_g_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = null;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = new QuickSendProgressView.RefreshProgressRunnable();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = null;
    b(paramCanvas);
    c(paramCanvas);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(paramCanvas, this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
      return;
    case 1: 
      a(paramCanvas, this.jdField_e_of_type_AndroidGraphicsDrawableDrawable);
      a(paramCanvas, this.jdField_c_of_type_Int);
      return;
    case 2: 
      a(paramCanvas, this.jdField_f_of_type_AndroidGraphicsDrawableDrawable);
      a(paramCanvas, this.jdField_d_of_type_Int);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 1;
    int k;
    int m;
    if (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      k = 0;
      m = 0;
    }
    for (;;)
    {
      int i5 = getPaddingLeft();
      int i6 = getPaddingRight();
      n = getPaddingTop();
      int i1 = getPaddingBottom();
      int i7 = this.jdField_g_of_type_Int;
      int i8 = this.h;
      int i9 = this.i;
      int i2 = this.jdField_g_of_type_Int;
      int i3 = this.h;
      int i4 = this.i;
      m = Math.max(m + (i5 + i6 + i7 * 2 + i8 * 2 + i9 * 2), getSuggestedMinimumWidth());
      n = Math.max(k + (n + i1 + i2 * 2 + i3 * 2 + i4 * 2), getSuggestedMinimumHeight());
      k = resolveSizeAndState(m, paramInt1, 0);
      paramInt2 = resolveSizeAndState(n, paramInt2, 0);
      paramInt1 = k;
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = k;
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          paramInt1 = k;
          if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
            paramInt1 = Math.max(k, (int)this.jdField_b_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString) + this.h);
          }
        }
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      i1 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      m = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      k = i1;
      if (i1 <= 0) {
        k = 1;
      }
      if (m <= 0)
      {
        m = k;
        k = n;
      }
      else
      {
        n = k;
        k = m;
        m = n;
      }
    }
  }
  
  public void setProgress(@IntRange(from=0L, to=100L) int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Int >= 100) {
      this.jdField_b_of_type_Int = 100;
    }
    invalidate();
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    setStatus(paramInt, true);
  }
  
  public void setStatus(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.j = 0;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      setContentDescription(getResources().getString(2131690786));
      label42:
      c();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = null;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = new QuickSendProgressView.RefreshProgressRunnable();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a(this);
      }
      if (this.jdField_a_of_type_Int != 3) {
        break label194;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean != bool)
      {
        this.jdField_a_of_type_Boolean = bool;
        requestLayout();
      }
      if (!paramBoolean) {
        break;
      }
      invalidate();
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        setContentDescription(getResources().getString(2131690755));
        break label42;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        setContentDescription(getResources().getString(2131718065));
        break label42;
      }
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label42;
      }
      setContentDescription(this.jdField_a_of_type_JavaLangString);
      break label42;
      label194:
      bool = false;
    }
  }
  
  public void setSuccessText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setmArcStrokeWidth(int paramInt)
  {
    this.h = paramInt;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    int k;
    if (paramDrawable != null) {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_g_of_type_AndroidGraphicsDrawableDrawable == paramDrawable)) {
        k = 1;
      }
    }
    for (;;)
    {
      if ((k != 0) || (super.verifyDrawable(paramDrawable))) {
        bool = true;
      }
      return bool;
      k = 0;
      continue;
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView
 * JD-Core Version:    0.7.0.1
 */