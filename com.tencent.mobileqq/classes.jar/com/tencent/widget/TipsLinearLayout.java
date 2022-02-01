package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class TipsLinearLayout
  extends LinearLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TipsLinearLayout.TipsLayoutAnimListener jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  public TipsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(long paramLong)
  {
    float f3 = getMeasuredHeight();
    float f1 = f3 / 300.0F;
    f1 = (float)paramLong * f1;
    float f2 = f1;
    if (f1 > f3) {
      f2 = f3;
    }
    int i = this.jdField_b_of_type_Int;
    float f4 = 0.0F;
    f1 = f4;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          f1 = f4;
        } else {
          f1 = -f2;
        }
      }
      else {
        f1 = f2 - f3;
      }
    }
    return (int)f1;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener == null) {
      return;
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsLinearLayout", 2, "ANIM_IN end.");
      }
      this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "ANIM_OUT end.");
    }
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startInAnimation");
    }
    a(1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startOutAnimation");
    }
    a(2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "Draw....");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_Boolean = false;
    }
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (l >= 300L))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      c();
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Int = a(l);
    } else if (this.jdField_b_of_type_Int == 2) {
      this.jdField_a_of_type_Int = (0 - getMeasuredHeight());
    } else {
      this.jdField_a_of_type_Int = 0;
    }
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_a_of_type_Int);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    if (!this.jdField_b_of_type_Boolean) {
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setmTipsLayoutAnimListener(TipsLinearLayout.TipsLayoutAnimListener paramTipsLayoutAnimListener)
  {
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener = paramTipsLayoutAnimListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TipsLinearLayout
 * JD-Core Version:    0.7.0.1
 */