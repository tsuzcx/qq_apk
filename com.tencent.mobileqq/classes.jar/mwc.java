import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class mwc
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private mwd jdField_a_of_type_Mwd;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public mwc(View paramView, Paint paramPaint, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.jdField_b_of_type_Int = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.jdField_a_of_type_AndroidViewView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ShimmerView, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.jdField_b_of_type_Int = paramAttributeSet.getColor(0, -1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShimmerTextView", 2, "Error while creating the view:", localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void c()
  {
    float f = -this.jdField_a_of_type_AndroidViewView.getWidth();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_Int;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f, 0.0F, 0.0F, 0.0F, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
  }
  
  public void a()
  {
    c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Mwd != null) {
        this.jdField_a_of_type_Mwd.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public void a(mwd parammwd)
  {
    this.jdField_a_of_type_Mwd = parammwd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getShader() == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(2.0F * this.jdField_a_of_type_Float, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwc
 * JD-Core Version:    0.7.0.1
 */