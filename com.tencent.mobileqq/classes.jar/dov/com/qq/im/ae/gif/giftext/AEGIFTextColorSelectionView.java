package dov.com.qq.im.ae.gif.giftext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import bcwh;

public class AEGIFTextColorSelectionView
  extends View
{
  private static String jdField_b_of_type_JavaLangString = "#FFFFFF";
  private static String jdField_c_of_type_JavaLangString = "#FFFFFF";
  private static String jdField_d_of_type_JavaLangString = "#3CB6FF";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private int jdField_d_of_type_Int;
  private int e;
  
  public AEGIFTextColorSelectionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(jdField_c_of_type_JavaLangString));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(jdField_d_of_type_JavaLangString));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(bcwh.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
  }
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue() != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean.booleanValue();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.e, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    this.jdField_b_of_type_Int = View.MeasureSpec.getSize(paramInt2);
    this.e = (this.jdField_a_of_type_Int / 2 - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 1.0F));
    this.jdField_c_of_type_Int = (this.e - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
  }
  
  public void setColor(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(paramString));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextColorSelectionView
 * JD-Core Version:    0.7.0.1
 */