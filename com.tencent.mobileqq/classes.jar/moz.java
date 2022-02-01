import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import java.lang.ref.WeakReference;
import java.util.Random;

public class moz
  extends mow
{
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  private int[] jdField_a_of_type_ArrayOfInt;
  private int i;
  
  public moz(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.jdField_a_of_type_ArrayOfInt = new int[] { paramInt1 / 4, (int)(paramInt1 / 3.8D), (int)(paramInt1 / 3.6D), (int)(paramInt1 / 3.4D), (int)(paramInt1 / 3.2D), paramInt1 / 3, (int)(paramInt1 / 2.8D), (int)(paramInt1 / 2.6D) };
    paramInt1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(8);
    this.i = this.jdField_a_of_type_ArrayOfInt[paramInt1];
  }
  
  protected int a(int paramInt)
  {
    lbj.c(this.jdField_a_of_type_JavaLangString, "getSPEED: " + this.i);
    return this.i;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Mos.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Mos.jdField_a_of_type_Float);
    float f1 = -this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.a, 0.0F, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Mos.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    float f2 = this.jdField_a_of_type_Mos.jdField_a_of_type_Float / 6.0F;
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.a, 0.0F + f2, f1 - f2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moz
 * JD-Core Version:    0.7.0.1
 */