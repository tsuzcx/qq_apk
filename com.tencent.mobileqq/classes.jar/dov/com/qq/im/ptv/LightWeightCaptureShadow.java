package dov.com.qq.im.ptv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import bodx;

public class LightWeightCaptureShadow
  extends View
{
  int jdField_a_of_type_Int = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private int b;
  private int c;
  private int d = bodx.a(14.0F);
  private int e = 0;
  private int f = bodx.a(160.0F);
  private int g = bodx.a(160.0F);
  private int h = -1929379840;
  
  public LightWeightCaptureShadow(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LightWeightCaptureShadow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    setLayerType(1, null);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i = (this.b - this.f) / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(i, 0.0F, 0.0F, this.e);
    i = (this.b - this.f) / 2;
    int j = (this.c - this.g) / 2;
    this.b = this.f;
    this.c = this.g;
    int k = this.jdField_a_of_type_Int / 2;
    float f1 = this.d + k;
    float f2 = k;
    float f3 = this.b;
    paramCanvas.drawLine(i + f1, f2 + j, f3 - f1 + i, f2 + j, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = this.d + k;
    f2 = this.c - k;
    f3 = this.b;
    paramCanvas.drawLine(i + f1, f2 + j, f3 - f1 + i, f2 + j, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = k;
    f2 = this.d + k;
    f3 = this.c;
    paramCanvas.drawLine(i + f1, f2 + j, i + f1, f3 - f2 + j, this.jdField_a_of_type_AndroidGraphicsPaint);
    f1 = this.b - k;
    f2 = this.d + k;
    f3 = this.c;
    paramCanvas.drawLine(i + f1, f2 + j, i + f1, f3 - f2 + j, this.jdField_a_of_type_AndroidGraphicsPaint);
    int m = this.d + this.d;
    RectF localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    RectF localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = k;
    localRectF2.top = f1;
    localRectF1.left = f1;
    localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = k + m;
    localRectF2.bottom = f1;
    localRectF1.right = f1;
    this.jdField_a_of_type_AndroidGraphicsRectF.offset(i, j);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = k;
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.c - (k + m));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (k + m);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.c - k);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset(i, j);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.b - (k + m));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.c - (k + m));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.b - k);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.c - k);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset(i, j);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.b - (k + m));
    this.jdField_a_of_type_AndroidGraphicsRectF.top = k;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.b - k);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (k + m);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset(i, j);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, 90.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b = getWidth();
    this.c = getHeight();
    if (this.b <= 0) {
      return;
    }
    a(paramCanvas);
  }
  
  public void setShadowColor(int paramInt)
  {
    this.e = (0xFFFFFF & paramInt | this.h);
    invalidate();
  }
  
  public void setShadowColorAlpha(int paramInt)
  {
    this.h = paramInt;
    setShadowColor(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureShadow
 * JD-Core Version:    0.7.0.1
 */