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
      float f1 = i2;
      return (i3 - i1) / this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight() + f1;
    }
    return i1 / this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.jdField_b_of_type_Int;
    int i2 = l;
    int i3 = this.jdField_b_of_type_Int;
    int i4 = l;
    int i5 = this.jdField_c_of_type_Int;
    int i6 = n;
    int i7 = l;
    int i8 = this.jdField_c_of_type_Int;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i3 + i4 * 3) && (paramFloat2 >= i5 - i6 - i7 * 2) && (paramFloat2 <= i8) && (this.jdField_c_of_type_Boolean)) {
      return 1;
    }
    i1 = this.jdField_d_of_type_Int;
    i2 = l;
    i3 = this.jdField_d_of_type_Int;
    i4 = l;
    i5 = this.jdField_e_of_type_Int;
    i6 = n;
    i7 = this.jdField_e_of_type_Int;
    i8 = l;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i3 + i4 * 3) && (paramFloat2 >= i5 - i6) && (paramFloat2 <= i7 + i8 * 2) && (this.jdField_d_of_type_Boolean)) {
      return 2;
    }
    return -1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
  }
  
  private void a(float paramFloat)
  {
    if ((paramFloat == 0.0F) || (paramFloat == this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY())) {
      return;
    }
    int i1 = (int)paramFloat;
    int i2 = (int)((paramFloat - i1) * this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight());
    Layout localLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLayout();
    if (localLayout != null)
    {
      i1 = localLayout.getLineForOffset(i1);
      if (i1 == 0) {}
      for (i1 = -localLayout.getTopPadding();; i1 = localLayout.getLineTop(i1))
      {
        new Handler().post(new ContainerView.3(this, i1 - i2));
        return;
      }
    }
    i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight();
    new Handler().post(new ContainerView.4(this, i1 * i2));
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
    int i1 = AIOUtils.a(10.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setPadding(i1, i1, i1, i1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new ContainerView.1(this));
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    int i1;
    if (this.g == 1)
    {
      i2 = this.h;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "updateCursorLocation, touchIndex=" + i1 + ", type=" + this.g);
      }
      if (paramInt3 == -1) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g, false);
      }
      if (i1 != -1) {
        break label108;
      }
    }
    label108:
    do
    {
      do
      {
        do
        {
          return;
          i2 = this.i;
          break;
          if (i1 == i2) {
            break label560;
          }
          if (this.g == 1) {
            if (i1 < this.h)
            {
              paramInt3 = this.i;
              this.h = i1;
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatItemLayout", 2, "update selection, s=" + i1 + ", e=" + paramInt3);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(i1, paramInt3);
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b(paramInt1, paramInt2);
            if (this.g != 1) {
              break label528;
            }
            if (this.j == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, this.j, true);
            return;
            if ((i1 > this.h) && (i1 < this.i))
            {
              paramInt3 = this.i;
              this.h = i1;
            }
            else if (i1 == this.h)
            {
              i1 = this.h;
              paramInt3 = this.i;
            }
            else if (i1 == this.i)
            {
              i1 = this.i - 1;
              paramInt3 = this.i;
            }
            else
            {
              i2 = this.i;
              this.h = this.i;
              this.i = i1;
              this.g = 2;
              this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g);
              paramInt3 = i1;
              i1 = i2;
              continue;
              if (i1 > this.i)
              {
                i2 = this.h;
                this.i = i1;
                paramInt3 = i1;
                i1 = i2;
              }
              else if ((i1 < this.i) && (i1 > this.h))
              {
                i2 = this.h;
                this.i = i1;
                paramInt3 = i1;
                i1 = i2;
              }
              else if (i1 == this.i)
              {
                i1 = this.h;
                paramInt3 = this.i;
              }
              else if (i1 == this.h)
              {
                i1 = this.h;
                paramInt3 = this.h + 1;
              }
              else
              {
                paramInt3 = this.h;
                this.i = this.h;
                this.h = i1;
                this.g = 1;
                this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g);
              }
            }
          }
        } while ((this.g != 2) || (this.k == -1));
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, this.k, true);
        return;
        if (this.g != 1) {
          break label592;
        }
      } while (this.j == -1);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, this.j, false);
      return;
    } while ((this.g != 2) || (this.k == -1));
    label528:
    label560:
    label592:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, this.k, false);
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
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_d_of_type_Boolean = false;
    }
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
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      bool = true;
      if (paramInt3 != 1) {
        break label118;
      }
      this.jdField_b_of_type_Int = (paramInt1 - this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_c_of_type_Int = (paramInt2 - this.jdField_a_of_type_ArrayOfInt[1]);
      this.jdField_c_of_type_Boolean = bool;
      label60:
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      if (paramInt3 != 1) {
        break label151;
      }
      this.j = paramInt2;
    }
    for (;;)
    {
      invalidate();
      return;
      bool = false;
      break;
      label118:
      this.jdField_d_of_type_Int = (paramInt1 - this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_e_of_type_Int = (paramInt2 - this.jdField_a_of_type_ArrayOfInt[1]);
      this.jdField_d_of_type_Boolean = bool;
      break label60;
      label151:
      if (paramInt3 == 2)
      {
        this.k = paramInt2;
      }
      else
      {
        this.j = -1;
        this.k = -1;
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_Int - m, this.jdField_c_of_type_Int - n, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.top - l, l, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int - n, this.jdField_d_of_type_Int + m, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.bottom + l, l, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void onDetachedFromWindow()
  {
    jdField_a_of_type_Float = a();
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentWidgetScrollView != null) && (this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight() > getHeight())) {
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
    if (paramInt2 < paramInt4 * 0.8F) {
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramInt1 < i1) {
          setGravity(17);
        }
      }
      else {
        this.jdField_a_of_type_Int = (-this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLineHeight());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
      return;
      setGravity(19);
      break;
      if (this.jdField_a_of_type_Boolean) {
        setGravity(51);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 2;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      int i2 = paramMotionEvent.getAction();
      if (!this.jdField_e_of_type_Boolean)
      {
        i1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((i1 == -1) || (i2 != 0)) {
          break label515;
        }
        a();
        this.jdField_e_of_type_Boolean = true;
        this.g = i1;
        this.h = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        this.i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
        if (paramMotionEvent.getSource() != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.g, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        }
      }
      do
      {
        do
        {
          return true;
          a();
          if ((i2 != 1) && (i2 != 3)) {
            break;
          }
          this.jdField_e_of_type_Boolean = false;
          this.j = -1;
          this.k = -1;
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(-1, true);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a();
        } while (i2 != 1);
        if (paramMotionEvent.getSource() == -1) {}
        for (;;)
        {
          ReportController.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
          return true;
          i1 = 1;
        }
      } while (i2 != 2);
      int i3 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      int i9;
      int i10;
      if (this.g == 1)
      {
        i4 = this.jdField_b_of_type_Int;
        i5 = l;
        i6 = this.jdField_b_of_type_Int;
        i7 = l;
        i8 = this.jdField_c_of_type_Int;
        i9 = n;
        i10 = l;
        int i11 = this.jdField_c_of_type_Int;
        int i12 = n;
        i1 = i2;
        if (i3 >= i4 - i5 * 3)
        {
          i1 = i2;
          if (i3 <= i6 + i7 * 3)
          {
            i1 = i2;
            if (i2 >= i8 - i9 - i10 * 2)
            {
              i1 = i2;
              if (i2 <= i11 - i12)
              {
                i1 = i2;
                if (this.jdField_c_of_type_Boolean) {
                  i1 = i2 + l * 2;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        c(i3, i1, paramMotionEvent.getSource());
        return true;
        i1 = i2;
        if (this.g == 2)
        {
          i4 = this.jdField_d_of_type_Int;
          i5 = l;
          i6 = this.jdField_d_of_type_Int;
          i7 = l;
          i8 = this.jdField_e_of_type_Int;
          i9 = this.jdField_e_of_type_Int;
          i10 = l;
          i1 = i2;
          if (i3 >= i4 - i5 * 3)
          {
            i1 = i2;
            if (i3 <= i6 + i7 * 3)
            {
              i1 = i2;
              if (i2 >= i8)
              {
                i1 = i2;
                if (i2 <= i9 + i10 * 2)
                {
                  i1 = i2;
                  if (this.jdField_d_of_type_Boolean) {
                    i1 = i2 - l * 2;
                  }
                }
              }
            }
          }
        }
      }
    }
    label515:
    return super.onTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView
 * JD-Core Version:    0.7.0.1
 */