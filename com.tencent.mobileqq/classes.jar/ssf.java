import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;

class ssf
  extends View
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private int b;
  private int c;
  
  public ssf(sse paramsse, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    localPath.reset();
    localPath.moveTo(this.c, 0.0F);
    localPath.lineTo(0.0F, getHeight());
    localPath.lineTo(getWidth(), getHeight());
    localPath.close();
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssf
 * JD-Core Version:    0.7.0.1
 */