package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper.SelectCursorTouchHelperListener;
import com.tencent.mobileqq.activity.selectable.SelectableCursor;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;

@SuppressLint({"NewApi", "ResourceAsColor", "Override"})
@TargetApi(11)
public class ContainerView
  extends LinearLayout
  implements SelectCursorTouchHelper.SelectCursorTouchHelperListener, SelectableCursor
{
  public static float a;
  private static final int l = ViewUtils.b(5.0F);
  private static final int m = ViewUtils.b(2.0F);
  private static final int n = ViewUtils.b(28.0F);
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  protected Handler a;
  private SelectableDelegate jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  public AnimationTextView a;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  
  public ContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  @TargetApi(11)
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  private float a()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY();
    Layout localLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLayout();
    if (localLayout != null)
    {
      int i2 = -localLayout.getTopPadding();
      if (i1 <= i2) {
        return (i2 - i1) / this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
      }
      int i3 = localLayout.getLineForVertical(i1 - 1) + 1;
      i2 = localLayout.getLineStart(i3);
      i3 = localLayout.getLineTop(i3);
      return i2 + (i3 - i1) / this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
    }
    return i1 / this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.jdField_b_of_type_Int;
    int i2 = l;
    int i3 = this.jdField_c_of_type_Int;
    int i4 = n;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4 - i2 * 2) && (paramFloat2 <= i3) && (this.jdField_c_of_type_Boolean)) {
      return 1;
    }
    i1 = this.jdField_d_of_type_Int;
    i2 = l;
    i3 = this.jdField_e_of_type_Int;
    i4 = n;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4) && (paramFloat2 <= i3 + i2 * 2) && (this.jdField_d_of_type_Boolean)) {
      return 2;
    }
    return -1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate != null) {
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      if (paramFloat == this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY()) {
        return;
      }
      int i1 = (int)paramFloat;
      int i2 = (int)((paramFloat - i1) * this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight());
      Layout localLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLayout();
      if (localLayout != null)
      {
        i1 = localLayout.getLineForOffset(i1);
        if (i1 == 0) {
          i1 = -localLayout.getTopPadding();
        } else {
          i1 = localLayout.getLineTop(i1);
        }
        new Handler().post(new ContainerView.3(this, i1 - i2));
        return;
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
      new Handler().post(new ContainerView.4(this, i1 * i2));
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = new AnimationTextView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setBackgroundColor(17170445);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setGravity(8388627);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setScroller(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setHighlightColor(1722605812);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setTextSize(1, 32.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setTextColor(-16777216);
    int i1 = AIOUtils.b(10.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setPadding(i1, i1, i1, i1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new ContainerView.1(this));
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (this.g == 1) {
      i2 = this.h;
    } else {
      i2 = this.i;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCursorLocation, touchIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.g);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    if (paramInt3 == -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g, false);
    }
    if (i1 == -1) {
      return;
    }
    if (i1 != i2)
    {
      if (this.g == 1)
      {
        paramInt3 = this.h;
        if (i1 < paramInt3)
        {
          paramInt3 = this.i;
          this.h = i1;
        }
      }
      for (;;)
      {
        i2 = i1;
        i1 = paramInt3;
        paramInt3 = i2;
        break;
        if (i1 > paramInt3)
        {
          paramInt3 = this.i;
          if (i1 < paramInt3)
          {
            this.h = i1;
            continue;
          }
        }
        paramInt3 = this.h;
        if (i1 == paramInt3)
        {
          i1 = this.i;
          break;
        }
        paramInt3 = this.i;
        if (i1 == paramInt3)
        {
          i1 = paramInt3 - 1;
        }
        else
        {
          this.h = paramInt3;
          this.i = i1;
          this.g = 2;
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g);
          break;
          paramInt3 = this.i;
          if (i1 > paramInt3)
          {
            paramInt3 = this.h;
            this.i = i1;
            break;
          }
          if (i1 < paramInt3)
          {
            paramInt3 = this.h;
            if (i1 > paramInt3)
            {
              this.i = i1;
              break;
            }
          }
          paramInt3 = this.i;
          if (i1 == paramInt3)
          {
            i1 = this.h;
          }
          else
          {
            paramInt3 = this.h;
            if (i1 == paramInt3)
            {
              i1 = paramInt3 + 1;
              break;
            }
            this.i = paramInt3;
            this.h = i1;
            this.g = 1;
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update selection, s=");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(", e=");
        localStringBuilder.append(i1);
        QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt3, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b(paramInt1, paramInt2);
      paramInt2 = this.g;
      if (paramInt2 == 1)
      {
        paramInt2 = this.j;
        if (paramInt2 != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2, true);
        }
      }
      else if (paramInt2 == 2)
      {
        paramInt2 = this.k;
        if (paramInt2 != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2, true);
        }
      }
    }
    else
    {
      paramInt2 = this.g;
      if (paramInt2 == 1)
      {
        paramInt2 = this.j;
        if (paramInt2 != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2, false);
        }
      }
      else if (paramInt2 == 2)
      {
        paramInt2 = this.k;
        if (paramInt2 != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2, false);
        }
      }
    }
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
      return -1;
    }
    return new SelectCursorTouchHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_d_of_type_Int;
  }
  
  @NonNull
  public View a()
  {
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getText().toString();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_c_of_type_Boolean = false;
    } else {
      this.jdField_d_of_type_Boolean = false;
    }
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.h = (paramInt1 - paramInt2);
      return;
    }
    this.i = (paramInt1 + paramInt2);
  }
  
  public void a(SelectableDelegate paramSelectableDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate = paramSelectableDelegate;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetScrollView.isScrollFinished();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_c_of_type_Boolean;
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getSelectionEnd() - this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getSelectionStart() > 0;
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_e_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    int[] arrayOfInt;
    if (paramInt3 == 1)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      this.jdField_b_of_type_Int = (paramInt1 - arrayOfInt[0]);
      this.jdField_c_of_type_Int = (paramInt2 - arrayOfInt[1]);
      this.jdField_c_of_type_Boolean = bool;
    }
    else
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      this.jdField_d_of_type_Int = (paramInt1 - arrayOfInt[0]);
      this.jdField_e_of_type_Int = (paramInt2 - arrayOfInt[1]);
      this.jdField_d_of_type_Boolean = bool;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    if (paramInt3 == 1)
    {
      this.j = paramInt2;
    }
    else if (paramInt3 == 2)
    {
      this.k = paramInt2;
    }
    else
    {
      this.j = -1;
      this.k = -1;
    }
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect;
    int i1;
    int i2;
    float f1;
    if (this.jdField_c_of_type_Boolean)
    {
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i1 = this.jdField_b_of_type_Int;
      i2 = m;
      int i3 = this.jdField_c_of_type_Int;
      localRect.set(i1 - i2, i3 - n, i1, i3);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i2 = l;
      paramCanvas.drawCircle(f1, i1 - i2, i2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i1 = this.jdField_d_of_type_Int;
      i2 = this.jdField_e_of_type_Int;
      localRect.set(i1, i2 - n, m + i1, i2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      i2 = l;
      paramCanvas.drawCircle(f1, i1 + i2, i2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.onTouchEvent(paramMotionEvent);
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
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
      requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ScrollView localScrollView = this.jdField_a_of_type_ComTencentWidgetScrollView;
    if ((localScrollView != null) && (localScrollView.getHeight() > getHeight())) {
      return;
    }
    paramInt4 = getHeight();
    int i1 = getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getHeight();
    paramInt3 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getWidth();
    if (paramInt2 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 0) {}
    }
    else
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.measure(paramInt1, paramInt2);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getMeasuredHeight();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getMeasuredWidth();
    }
    if (paramInt2 < paramInt4 * 0.8F)
    {
      if (this.jdField_a_of_type_Boolean) {
        if (paramInt1 < i1) {
          setGravity(17);
        } else {
          setGravity(19);
        }
      }
      this.jdField_a_of_type_Int = (-this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight());
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      setGravity(51);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    int i2;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      i1 = paramMotionEvent.getAction();
      if (this.jdField_e_of_type_Boolean) {
        break label139;
      }
      i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i2 != -1) && (i1 == 0))
      {
        a();
        this.jdField_e_of_type_Boolean = true;
        this.g = i2;
        this.h = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        this.i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
        if (paramMotionEvent.getSource() != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        }
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
    label139:
    a();
    if ((i1 != 1) && (i1 != 3))
    {
      if (i1 == 2)
      {
        int i3 = (int)paramMotionEvent.getRawX();
        i2 = (int)paramMotionEvent.getRawY();
        int i4 = this.g;
        int i5;
        int i6;
        if (i4 == 1)
        {
          i4 = this.jdField_b_of_type_Int;
          i5 = l;
          i6 = this.jdField_c_of_type_Int;
          int i7 = n;
          i1 = i2;
          if (i3 >= i4 - i5 * 3)
          {
            i1 = i2;
            if (i3 <= i4 + i5 * 3)
            {
              i1 = i2;
              if (i2 >= i6 - i7 - i5 * 2)
              {
                i1 = i2;
                if (i2 <= i6 - i7)
                {
                  i1 = i2;
                  if (this.jdField_c_of_type_Boolean) {
                    i1 = i2 + i5 * 2;
                  }
                }
              }
            }
          }
        }
        else
        {
          i1 = i2;
          if (i4 == 2)
          {
            i4 = this.jdField_d_of_type_Int;
            i5 = l;
            i6 = this.jdField_e_of_type_Int;
            i1 = i2;
            if (i3 >= i4 - i5 * 3)
            {
              i1 = i2;
              if (i3 <= i4 + i5 * 3)
              {
                i1 = i2;
                if (i2 >= i6)
                {
                  i1 = i2;
                  if (i2 <= i5 * 2 + i6)
                  {
                    i1 = i2;
                    if (this.jdField_d_of_type_Boolean) {
                      i1 = i2 - i5 * 2;
                    }
                  }
                }
              }
            }
          }
        }
        c(i3, i1, paramMotionEvent.getSource());
        return true;
      }
    }
    else
    {
      this.jdField_e_of_type_Boolean = false;
      this.j = -1;
      this.k = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(-1, true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a();
      if (i1 == 1)
      {
        if (paramMotionEvent.getSource() == -1) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  public void setMsgHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setOutScrollView(ScrollView paramScrollView)
  {
    this.jdField_a_of_type_ComTencentWidgetScrollView = paramScrollView;
    this.jdField_a_of_type_ComTencentWidgetScrollView.setOnScrollStateChangedListener(new ContainerView.2(this));
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(paramCharSequence);
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView
 * JD-Core Version:    0.7.0.1
 */