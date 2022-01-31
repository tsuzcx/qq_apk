import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;

public class lxr
  extends lwt
{
  public LinearGradient a;
  public int b;
  public Rect b;
  public int c;
  public int d;
  public int e;
  
  public lxr()
  {
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void a(long paramLong)
  {
    paramLong -= this.jdField_a_of_type_Long;
    int j = 0;
    int i;
    if ((paramLong > 0L) && (paramLong < 200L))
    {
      i = (int)(255L * paramLong / 200L);
      a(i);
      if (paramLong >= 200L) {
        break label164;
      }
      this.d = ((int)(255L * paramLong / 200L));
    }
    for (;;)
    {
      i = (int)(this.c - paramLong * this.c / 750L);
      a(0, i, this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_Int + i);
      return;
      if ((paramLong >= 200L) && (paramLong <= 700L))
      {
        i = 255;
        break;
      }
      i = j;
      if (paramLong <= 700L) {
        break;
      }
      i = j;
      if (paramLong >= 750L) {
        break;
      }
      i = (int)(255L * (paramLong - 750L) / -50L);
      break;
      label164:
      if ((paramLong >= 200L) && (paramLong <= 650L)) {
        this.d = 255;
      } else if ((paramLong > 650L) && (paramLong < 750L)) {
        this.d = ((int)(255L * (paramLong - 750L) / -100L));
      }
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setAlpha(this.d);
    paramPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, paramPaint);
    paramPaint.setAlpha(255);
    paramPaint.setShader(null);
    super.a(paramCanvas, paramPaint);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
  }
  
  public void b(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      c();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 454 / 750);
    this.c = (paramInt1 * -190 / 750);
    this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2 / 2);
    c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsRect.bottom, this.e, 0, Shader.TileMode.CLAMP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxr
 * JD-Core Version:    0.7.0.1
 */