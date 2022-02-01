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
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
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
    return paramFloat2 + paramFloat1 * (paramFloat3 - paramFloat2);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    int k = getWidth();
    int m = getHeight();
    if (k > 0)
    {
      if (m <= 0) {
        return;
      }
      k = Math.min(k, m);
      this.j = ((int)Math.ceil(a(paramFloat, -k / 2.0F, k / 2.0F)));
      invalidate();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      int k = getWidth();
      int m = getHeight();
      if (k > 0)
      {
        if (m <= 0) {
          return;
        }
        k = Math.min(k, m);
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, k / 2.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  private void a(Canvas paramCanvas, @ColorInt int paramInt)
  {
    int k = getWidth();
    int m = getHeight();
    if (k > 0)
    {
      if (m <= 0) {
        return;
      }
      k = Math.min(k, m);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      paramInt = this.h;
      localRectF.set(paramInt, paramInt, k - paramInt, k - paramInt);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.jdField_b_of_type_Int * 1.0F / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int k = getWidth();
      int m = getHeight();
      if (k > 0)
      {
        if (m <= 0) {
          return;
        }
        this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        k = Math.min(k, m);
        paramCanvas.save();
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        m = this.jdField_g_of_type_Int;
        int n = this.h;
        localRect.set(0, 0, k - m * 2 - n * 2, k - m * 2 - n * 2);
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.offset((k - localRect.width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
        this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        if (this.jdField_a_of_type_Int == 0)
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          m = this.h;
          n = this.i;
          localRect.set(0, 0, k - m * 2 - n * 2, k - m * 2 - n * 2);
        }
        else
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          m = this.jdField_g_of_type_Int;
          n = this.h;
          int i1 = this.i;
          localRect.set(0, 0, k - m * 2 - n * 2 - i1 * 2, k - m * 2 - n * 2 - i1 * 2);
        }
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.offset((k - localRect.width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
        paramDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        k = this.j;
        paramCanvas.translate(k, -k);
        paramDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
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
    if (k > 0)
    {
      if (m <= 0) {
        return;
      }
      k = Math.min(k, m);
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        m = this.h;
        ((Rect)localObject).set(0, 0, k - m * 2, k - m * 2);
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        m = this.jdField_g_of_type_Int;
        int n = this.h;
        ((Rect)localObject).set(0, 0, k - m * 2 - n * 2, k - m * 2 - n * 2);
      }
      Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).offset((k - ((Rect)localObject).width()) / 2, (k - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2);
      paramCanvas.save();
      localObject = null;
      k = this.jdField_a_of_type_Int;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k == 2) {
            localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
        else {
          localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        }
      }
      else {
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramCanvas.restore();
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
    if (k > 0)
    {
      if (m <= 0) {
        return;
      }
      int n = this.jdField_a_of_type_Int;
      if ((n != 1) && (n != 2)) {
        return;
      }
      n = this.jdField_a_of_type_Int;
      if (n != 1)
      {
        if (n == 2) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
        }
      }
      else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
      }
      k = Math.min(k, m);
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      m = this.h;
      localRectF.set(m, m, k - m, k - m);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.h = a(2.0F, getResources());
    this.jdField_g_of_type_Int = a(3.0F, getResources());
    this.i = a(1.0F, getResources());
    this.jdField_a_of_type_JavaLangString = getResources().getString(2131716519);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846293);
    this.jdField_c_of_type_Int = Color.parseColor("#19BAFF");
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846295);
    this.jdField_e_of_type_Int = Color.parseColor("#3300CAFC");
    this.jdField_f_of_type_Int = Color.parseColor("#33FF596A");
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846291);
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
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165563));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846294);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846297);
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846292);
    setContentDescription(getResources().getString(2131716518));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.jdField_g_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QuickSendProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable;
    if (localRefreshProgressRunnable != null)
    {
      localRefreshProgressRunnable.a();
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
    QuickSendProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable;
    if (localRefreshProgressRunnable != null)
    {
      localRefreshProgressRunnable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = null;
    b(paramCanvas);
    c(paramCanvas);
    int k = this.jdField_a_of_type_Int;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          a(paramCanvas, this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
          return;
        }
        a(paramCanvas);
        return;
      }
      a(paramCanvas, this.jdField_f_of_type_AndroidGraphicsDrawableDrawable);
      a(paramCanvas, this.jdField_d_of_type_Int);
      return;
    }
    a(paramCanvas, this.jdField_e_of_type_AndroidGraphicsDrawableDrawable);
    a(paramCanvas, this.jdField_c_of_type_Int);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    int k = 1;
    if (localObject == null)
    {
      m = 0;
      k = 0;
    }
    else
    {
      i1 = ((Drawable)localObject).getIntrinsicWidth();
      n = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      m = i1;
      if (i1 <= 0) {
        m = 1;
      }
      if (n > 0) {
        k = n;
      }
    }
    int i5 = getPaddingLeft();
    int i6 = getPaddingRight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    int i2 = this.jdField_g_of_type_Int;
    int i3 = this.h;
    int i4 = this.i;
    int m = Math.max(m + (i5 + i6 + i2 * 2 + i3 * 2 + i4 * 2), getSuggestedMinimumWidth());
    n = Math.max(k + (n + i1 + i2 * 2 + i3 * 2 + i4 * 2), getSuggestedMinimumHeight());
    k = resolveSizeAndState(m, paramInt1, 0);
    paramInt2 = resolveSizeAndState(n, paramInt2, 0);
    paramInt1 = k;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramInt1 = k;
      if (localObject != null)
      {
        Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        paramInt1 = k;
        if (localPaint != null) {
          paramInt1 = Math.max(k, (int)localPaint.measureText((String)localObject) + this.h);
        }
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    boolean bool = false;
    this.j = 0;
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 0)
    {
      setContentDescription(getResources().getString(2131716518));
    }
    else if (paramInt == 1)
    {
      setContentDescription(getResources().getString(2131716517));
    }
    else if (paramInt == 2)
    {
      setContentDescription(getResources().getString(2131718226));
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        setContentDescription((CharSequence)localObject);
      }
    }
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable;
    if (localObject != null)
    {
      ((QuickSendProgressView.RefreshProgressRunnable)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = null;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable = new QuickSendProgressView.RefreshProgressRunnable();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView$RefreshProgressRunnable.a(this);
    }
    if (this.jdField_a_of_type_Int == 3) {
      bool = true;
    }
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      requestLayout();
    }
    if (paramBoolean) {
      invalidate();
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
    boolean bool = true;
    int k;
    if ((paramDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (this.jdField_g_of_type_AndroidGraphicsDrawableDrawable == paramDrawable))) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0)
    {
      if (super.verifyDrawable(paramDrawable)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView
 * JD-Core Version:    0.7.0.1
 */