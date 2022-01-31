package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import anyc;

public class QIMCommonLoadingView
  extends View
  implements anyc
{
  private static float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 100L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  QIMCommonLoadingProgress jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = a(2.0F, getContext());
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_c_of_type_Int - 16843176, this.jdField_d_of_type_Int - 16843176, this.jdField_c_of_type_Int + 16843176, this.jdField_d_of_type_Int + 16843176);
  private float jdField_c_of_type_Float = a(17.5F, getContext());
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = a(2.5F, getContext());
  private int jdField_d_of_type_Int;
  
  public QIMCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(jdField_a_of_type_Float * paramFloat);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void a()
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress;
    if (localQIMCommonLoadingProgress != null) {
      setProgress(Math.round(localQIMCommonLoadingProgress.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  public void a(QIMCommonLoadingProgress paramQIMCommonLoadingProgress)
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress;
    if (localQIMCommonLoadingProgress != null) {
      localQIMCommonLoadingProgress.a(this);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress = paramQIMCommonLoadingProgress;
    if (paramQIMCommonLoadingProgress != null)
    {
      paramQIMCommonLoadingProgress.b(this);
      setProgress(Math.round(paramQIMCommonLoadingProgress.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Long != this.jdField_a_of_type_Long))
    {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawCircle(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Float - this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      float f = (float)this.jdField_b_of_type_Long * 360.0F / (float)this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Long == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress == null)) {
          break label208;
        }
        setProgress(Math.round(this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress.a() * (float)this.jdField_a_of_type_Long));
      }
    }
    return;
    label208:
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int / 2);
    this.jdField_d_of_type_Int = (this.jdField_b_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    float f = this.jdField_c_of_type_Float - this.jdField_d_of_type_Float;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_c_of_type_Int - f, this.jdField_d_of_type_Int - f, this.jdField_c_of_type_Int + f, f + this.jdField_d_of_type_Int);
  }
  
  public void setCorner(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setMax(int paramInt)
  {
    this.jdField_a_of_type_Long = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    if (paramLong == 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
    this.jdField_b_of_type_Long = paramLong;
    if (this.jdField_b_of_type_Long == this.jdField_a_of_type_Long) {}
    for (;;)
    {
      invalidate();
      return;
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingProgress != null) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */