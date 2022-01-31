package dov.com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class SimpleProgressBar
  extends View
{
  public static int c = -16737062;
  public static int d = -2083835;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public int b;
  private int e;
  private final int f = -1;
  private final int g = ScreenUtil.a(3.0F);
  private int h = c;
  
  public SimpleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.b) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.b;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = super.getWidth();
    int j = super.getHeight();
    int k = a(this.e, i);
    int m = k / 2;
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = j;
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = m;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (k < i)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = m;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (i - m);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = (i - m);
    this.jdField_a_of_type_AndroidGraphicsRect.right = i;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = super.getWidth();
    int j = super.getHeight();
    int k = a(this.e, i);
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = j;
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = k;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(0, 156, 218));
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (k < i)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = k;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.g + k);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.g + k < i)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = (k + this.g);
      this.jdField_a_of_type_AndroidGraphicsRect.right = i;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(36, 36, 45));
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleProgressBar", 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean) {}
    for (this.e = this.b;; this.e = paramInt)
    {
      postInvalidate();
      return;
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.SimpleProgressBar
 * JD-Core Version:    0.7.0.1
 */