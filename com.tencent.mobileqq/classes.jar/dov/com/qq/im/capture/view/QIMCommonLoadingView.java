package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import blwn;
import blwo;

public class QIMCommonLoadingView
  extends View
  implements blwo
{
  private static float jdField_d_of_type_Float;
  protected float a;
  protected int a;
  protected long a;
  protected Paint a;
  protected Path a;
  protected RectF a;
  blwn jdField_a_of_type_Blwn;
  boolean jdField_a_of_type_Boolean = false;
  protected float b;
  protected int b;
  protected long b;
  protected Paint b;
  protected RectF b;
  boolean b;
  protected float c;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  
  public QIMCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int - 16843176, this.jdField_b_of_type_Int - 16843176, this.jdField_a_of_type_Int + 16843176, this.jdField_b_of_type_Int + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int - 16843176, this.jdField_b_of_type_Int - 16843176, this.jdField_a_of_type_Int + 16843176, this.jdField_b_of_type_Int + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int - 16843176, this.jdField_b_of_type_Int - 16843176, this.jdField_a_of_type_Int + 16843176, this.jdField_b_of_type_Int + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (jdField_d_of_type_Float == 0.0F) {
      jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(jdField_d_of_type_Float * paramFloat);
  }
  
  public void a()
  {
    blwn localblwn = this.jdField_a_of_type_Blwn;
    if (localblwn != null) {
      setProgress(Math.round(localblwn.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  public void a(blwn paramblwn)
  {
    blwn localblwn = this.jdField_a_of_type_Blwn;
    if (localblwn != null) {
      localblwn.a(this);
    }
    this.jdField_a_of_type_Blwn = paramblwn;
    if (paramblwn != null)
    {
      paramblwn.b(this);
      setProgress(Math.round(paramblwn.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Long != this.jdField_a_of_type_Long))
      {
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
        float f = (float)this.jdField_b_of_type_Long * 360.0F / (float)this.jdField_a_of_type_Long;
        if (this.jdField_b_of_type_Boolean)
        {
          paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
          paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
        while (this.jdField_c_of_type_Boolean)
        {
          if ((this.jdField_b_of_type_Long == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_Blwn == null)) {
            break label262;
          }
          setProgress(Math.round(this.jdField_a_of_type_Blwn.a() * (float)this.jdField_a_of_type_Long));
          return;
          paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
      }
    }
    label262:
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = (this.jdField_c_of_type_Int / 2);
    this.jdField_b_of_type_Int = (this.jdField_d_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    float f = this.jdField_b_of_type_Float - this.jdField_c_of_type_Float;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int - f, this.jdField_b_of_type_Int - f, this.jdField_a_of_type_Int + f, f + this.jdField_b_of_type_Int);
  }
  
  public void setBgColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setBgCorner(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
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
      if (this.jdField_a_of_type_Blwn != null) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setProgressSizeAndMode(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    paramFloat1 = this.jdField_b_of_type_Float - this.jdField_c_of_type_Float;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int - paramFloat1, this.jdField_b_of_type_Int - paramFloat1, this.jdField_a_of_type_Int + paramFloat1, paramFloat1 + this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */