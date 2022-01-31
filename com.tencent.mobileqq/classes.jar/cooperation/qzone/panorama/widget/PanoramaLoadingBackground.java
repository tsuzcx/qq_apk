package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class PanoramaLoadingBackground
  extends View
{
  public static int a;
  private Paint a;
  private int b = PanoramaLoadingLayout.jdField_a_of_type_Int;
  private int c = PanoramaLoadingLayout.b;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 255;
  
  static
  {
    jdField_a_of_type_Int = 180;
  }
  
  public PanoramaLoadingBackground(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PanoramaLoadingBackground(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.b = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.b);
      } else {
        paramInt = this.b;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.d = paramContext.getResources().getColor(2131165285);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.b / 5);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    int i = this.c / 2;
    int j = localFontMetricsInt.descent;
    int k = (localFontMetricsInt.descent - localFontMetricsInt.ascent) / 2;
    paramCanvas.drawText("360", getWidth() / 2, k + (i - j), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private int b(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.c = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.c);
      } else {
        paramInt = this.c;
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.b / 2, this.b / 2, this.g, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.b / 2, this.b / 2, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.e = (this.b / 2);
    this.f = (this.e - this.e / 5);
    this.g = (this.e - this.e * 2 / 5);
    c(paramCanvas);
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void setContentAlpha(int paramInt)
  {
    this.h = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBackground
 * JD-Core Version:    0.7.0.1
 */