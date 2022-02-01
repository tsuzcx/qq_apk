package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import azkd;
import com.tencent.qphone.base.util.QLog;

public class SoftInputDetectView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private azkd jdField_a_of_type_Azkd;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d = -1;
  
  public SoftInputDetectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SoftInputDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.c;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
      if (this.b == 0) {
        this.b = paramInt2;
      }
      if (this.d < 0) {
        this.d = this.jdField_a_of_type_AndroidGraphicsRect.top;
      }
      this.c = paramInt2;
      if ((paramInt2 != 0) && (i != 0) && (paramInt2 != i))
      {
        if (this.d != this.jdField_a_of_type_AndroidGraphicsRect.top)
        {
          if (this.jdField_a_of_type_Boolean) {
            this.b -= this.jdField_a_of_type_AndroidGraphicsRect.top - this.d;
          }
          this.d = this.jdField_a_of_type_AndroidGraphicsRect.top;
        }
        if (paramInt2 >= this.b) {
          break label255;
        }
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_Int = (this.b - paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SoftInputDetectView", 2, "Detected layout change. Input Method is showing? " + bool + " Input Method Height is " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Azkd != null) {
        this.jdField_a_of_type_Azkd.a(bool, this.jdField_a_of_type_Int);
      }
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
      return;
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      break;
    }
  }
  
  public void setExcludeStatusBar(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnImStateChangedListener(azkd paramazkd)
  {
    this.jdField_a_of_type_Azkd = paramazkd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SoftInputDetectView
 * JD-Core Version:    0.7.0.1
 */