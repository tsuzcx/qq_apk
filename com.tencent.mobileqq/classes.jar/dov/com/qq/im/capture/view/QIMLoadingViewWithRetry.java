package dov.com.qq.im.capture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import bpvy;
import com.tencent.qphone.base.util.QLog;

public class QIMLoadingViewWithRetry
  extends QIMCommonLoadingView
{
  protected Bitmap a;
  protected int c;
  protected Paint c;
  protected int d;
  protected int e;
  
  public QIMLoadingViewWithRetry(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMLoadingViewWithRetry(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QIMLoadingViewWithRetry(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
      this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      } while (!QLog.isColorLevel());
      QLog.e("QIMLoadingViewWithRetry", 2, "OutOfMemoryError retry bitmap", localOutOfMemoryError.getCause());
    }
  }
  
  protected void b()
  {
    super.b();
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.e = 2130844618;
    a(this.e);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_Long == -1L) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_c_of_type_Int / 2;
      int k = this.jdField_b_of_type_Int;
      int m = this.d / 2;
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, i - j, k - m, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Long == 0L) || (this.jdField_b_of_type_Long == this.jdField_a_of_type_Long));
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      float f = (float)this.jdField_b_of_type_Long * 360.0F / (float)this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    } while (!this.jdField_c_of_type_Boolean);
    if ((this.jdField_b_of_type_Long != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Bpvy != null))
    {
      setProgress(Math.round(this.jdField_a_of_type_Bpvy.a() * (float)this.jdField_a_of_type_Long));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setProgress(long paramLong)
  {
    if ((paramLong == 0L) && (this.jdField_a_of_type_Bpvy != null) && (this.jdField_a_of_type_Bpvy.a == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMLoadingViewWithRetry", 2, "progress=" + paramLong);
      }
      this.jdField_b_of_type_Long = -1L;
      invalidate();
      return;
    }
    super.setProgress(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMLoadingViewWithRetry
 * JD-Core Version:    0.7.0.1
 */