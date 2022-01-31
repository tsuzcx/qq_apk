import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lxk
  extends lwt
{
  public static final int[] a;
  public String a;
  public boolean a;
  public int b;
  public Rect b;
  public boolean b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1966063, -25328, -1966063 };
  }
  
  public lxk(Context paramContext)
  {
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131696264);
  }
  
  public void a(long paramLong)
  {
    paramLong -= this.jdField_a_of_type_Long;
    int j = 0;
    float f2 = 1.0F;
    int i;
    float f1;
    if (paramLong < 500L)
    {
      i = (int)(255L * paramLong / 500L);
      f1 = 0.5F * (float)(500L + paramLong) / 500.0F;
    }
    for (;;)
    {
      a(i);
      b(f1);
      this.d = ((int)(paramLong % 2000L * this.jdField_b_of_type_AndroidGraphicsRect.right / 2000L));
      return;
      if (((paramLong >= 500L) && (paramLong <= 2167L)) || (!this.jdField_a_of_type_Boolean))
      {
        i = 255;
        f1 = f2;
      }
      else
      {
        f1 = f2;
        i = j;
        if (paramLong > 2167L)
        {
          f1 = f2;
          i = j;
          if (paramLong < 2500L)
          {
            f1 = f2;
            i = j;
            if (this.jdField_a_of_type_Boolean)
            {
              i = (int)(255L * (paramLong - 2500L) / -333L);
              f1 = f2;
            }
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    super.a(paramCanvas, paramPaint);
    if (!this.jdField_a_of_type_Boolean)
    {
      paramPaint.setShader(new LinearGradient(0.0F, 0.0F, this.d, 0.0F, jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP));
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, paramPaint);
      paramPaint.setShader(null);
      paramPaint.setColor(-16777216);
      paramPaint.setTextSize(this.jdField_b_of_type_Int);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f1 = this.c;
      float f2 = localFontMetrics.bottom;
      f2 = (localFontMetrics.top + f2 + this.jdField_b_of_type_Int) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsRect.centerX(), f1 - f2, paramPaint);
    }
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (String str = "qav_redpacket_hbsd.png";; str = "qav_redpacket_hbll.png")
    {
      this.jdField_a_of_type_Lxt = new lxt(paramAVRedPacketManager.a(str));
      return;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_b_of_type_Boolean) {}
    paramInt4 = paramInt1 * 214 / 1500;
    int i;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      paramInt3 = 584;
      i = paramInt2 - paramInt3 * paramInt1 / 750;
      if (this.jdField_b_of_type_Boolean) {}
      j = paramInt1 * 1286 / 1500;
      if (!this.jdField_b_of_type_Boolean) {
        break label143;
      }
    }
    label143:
    for (paramInt3 = 364;; paramInt3 = 376)
    {
      a(paramInt4, i, j, paramInt3 * paramInt1 / 750 + i);
      this.jdField_b_of_type_Int = (paramInt1 * 28 / 750);
      this.c = (paramInt2 - paramInt1 * 30 / 750);
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, paramInt2 - paramInt1 * 10 / 750, paramInt1, paramInt2);
      return;
      paramInt3 = 586;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxk
 * JD-Core Version:    0.7.0.1
 */