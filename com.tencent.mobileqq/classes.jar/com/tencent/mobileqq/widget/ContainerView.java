package com.tencent.mobileqq.widget;

import akte;
import aktf;
import aktg;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.ScrollView;

@SuppressLint({"NewApi", "ResourceAsColor", "Override"})
@TargetApi(11)
public class ContainerView
  extends LinearLayout
{
  public static float a;
  public static boolean a;
  public int a;
  public Handler a;
  public ContainerView.SelectableTextView a;
  private ScrollView a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = "MNC".equals(Build.VERSION.CODENAME);
  }
  
  public ContainerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY();
    Layout localLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLayout();
    if (localLayout != null)
    {
      int j = -localLayout.getTopPadding();
      if (i <= j) {
        return (j - i) / this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight();
      }
      int k = localLayout.getLineForVertical(i - 1) + 1;
      j = localLayout.getLineStart(k);
      k = localLayout.getLineTop(k);
      float f = j;
      return (k - i) / this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight() + f;
    }
    return i / this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight();
  }
  
  private void a(float paramFloat)
  {
    if ((paramFloat == 0.0F) || (paramFloat == this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY())) {
      return;
    }
    int i = (int)paramFloat;
    int j = (int)((paramFloat - i) * this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight());
    Layout localLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLayout();
    if (localLayout != null)
    {
      i = localLayout.getLineForOffset(i);
      if (i == 0) {}
      for (i = -localLayout.getTopPadding();; i = localLayout.getLineTop(i))
      {
        new Handler().post(new aktf(this, i - j));
        return;
      }
    }
    j = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight();
    new Handler().post(new aktg(this, i * j));
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView = new ContainerView.SelectableTextView(this, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView, paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new akte(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetScrollView.isScrollFinished();
  }
  
  public boolean a(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.a(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    jdField_a_of_type_Float = a();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_a_of_type_Int);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentWidgetScrollView != null) && (this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight() > getHeight())) {
      return;
    }
    paramInt4 = getHeight();
    int i = getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getHeight();
    paramInt3 = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getWidth();
    if (paramInt2 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 0) {}
    }
    else
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.measure(paramInt1, paramInt2);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getMeasuredHeight();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getMeasuredWidth();
    }
    if (paramInt2 < paramInt4 * 0.8F) {
      if (paramInt1 < i)
      {
        setGravity(17);
        this.jdField_a_of_type_Int = (-this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLineHeight());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.setVisibility(0);
      return;
      setGravity(19);
      break;
      setGravity(51);
    }
  }
  
  public void setMsgHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setOutScrollView(ScrollView paramScrollView)
  {
    this.jdField_a_of_type_ComTencentWidgetScrollView = paramScrollView;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView
 * JD-Core Version:    0.7.0.1
 */