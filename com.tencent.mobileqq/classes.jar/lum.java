import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class lum
{
  public float a;
  public int a;
  public long a;
  public Matrix a;
  public Rect a;
  public lvm a;
  public float b;
  public float c;
  public float d = 1.0F;
  
  public lum()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public float a()
  {
    return this.d;
  }
  
  protected float a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) / 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_a_of_type_AndroidGraphicsMatrix.preRotate(this.c, this.jdField_a_of_type_Float, this.b);
    this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(this.d, this.d, this.jdField_a_of_type_Float, this.b);
  }
  
  public void a(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = a(paramInt1, paramInt3);
    float f2 = b(paramInt2, paramInt4);
    paramInt1 = 0;
    if (this.jdField_a_of_type_Float != f1)
    {
      this.jdField_a_of_type_Float = f1;
      paramInt1 = 1;
    }
    if (this.b != f2)
    {
      this.b = f2;
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        a();
      }
      return;
    }
  }
  
  public abstract void a(long paramLong);
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.jdField_a_of_type_Lvm != null)
    {
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
      paramPaint.setAlpha(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Lvm.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
      paramCanvas.restore();
    }
  }
  
  protected float b(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) / 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lvm != null)
    {
      this.jdField_a_of_type_Lvm.a();
      this.jdField_a_of_type_Lvm = null;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
  }
  
  public void b(float paramFloat)
  {
    if (this.d != paramFloat)
    {
      this.d = paramFloat;
      a();
    }
  }
  
  public abstract void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lum
 * JD-Core Version:    0.7.0.1
 */