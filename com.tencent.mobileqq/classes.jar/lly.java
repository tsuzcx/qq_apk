import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.av.doodle.MySurfaceView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class lly
{
  public int a;
  public long a;
  public PointF a;
  final String a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = -65536;
  
  public lly()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = "unused";
    this.jdField_b_of_type_Int = 12;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = ("DoodleItem_" + getClass().getSimpleName() + "_" + AudioHelper.b());
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, getClass().getSimpleName());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
  }
  
  public abstract void a(long paramLong);
  
  public void a(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    float f2 = 0.0F;
    int i = paramMySurfaceView.getWidth();
    int j = paramMySurfaceView.getHeight();
    int k = this.d;
    int m = this.c;
    float f3;
    if (i * k < j * m) {
      f3 = i / m;
    }
    for (float f1 = (j - k * f3) / 2.0F;; f1 = 0.0F)
    {
      if (paramCanvas != null)
      {
        paramCanvas.save();
        paramCanvas.translate(f2, f1);
        paramCanvas.scale(f3, f3);
        b(paramCanvas, paramMySurfaceView, paramBoolean);
      }
      try
      {
        paramCanvas.restore();
        return;
      }
      catch (Exception paramCanvas)
      {
        lcg.e(this.jdField_a_of_type_JavaLangString, paramCanvas.getMessage());
      }
      f3 = j / k;
      f2 = (i - m * f3) / 2.0F;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.jdField_a_of_type_AndroidGraphicsPointF.x);
    float f2 = Math.abs(paramFloat2 - this.jdField_a_of_type_AndroidGraphicsPointF.y);
    if ((f1 >= 8.0F) || (f2 >= 8.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        b(paramFloat1, paramFloat2);
        this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
        this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
      }
      return bool;
    }
  }
  
  public abstract void b(float paramFloat1, float paramFloat2);
  
  public abstract void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean);
  
  public abstract void c(float paramFloat1, float paramFloat2);
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ", mPenType[" + this.jdField_a_of_type_Int + "], mPoint[" + this.jdField_a_of_type_AndroidGraphicsPointF.x + "," + this.jdField_a_of_type_AndroidGraphicsPointF.y + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lly
 * JD-Core Version:    0.7.0.1
 */