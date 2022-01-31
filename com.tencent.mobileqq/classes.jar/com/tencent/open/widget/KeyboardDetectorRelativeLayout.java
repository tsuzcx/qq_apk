package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import bfoh;

public class KeyboardDetectorRelativeLayout
  extends RelativeLayout
{
  protected Rect a;
  protected bfoh a;
  
  public KeyboardDetectorRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
  }
  
  public void a(bfoh parambfoh)
  {
    this.jdField_a_of_type_Bfoh = parambfoh;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Activity localActivity = (Activity)super.getContext();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int k = localActivity.getWindowManager().getDefaultDisplay().getHeight();
    if ((this.jdField_a_of_type_Bfoh != null) && (i != 0))
    {
      if (k - j - i <= 100) {
        break label112;
      }
      this.jdField_a_of_type_Bfoh.a(Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.height()) - getPaddingBottom() - getPaddingTop());
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label112:
      this.jdField_a_of_type_Bfoh.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.widget.KeyboardDetectorRelativeLayout
 * JD-Core Version:    0.7.0.1
 */