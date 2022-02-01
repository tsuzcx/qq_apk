import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;

public class lus
  extends lum
{
  public Path a;
  public RectF a;
  public String a;
  lut a;
  public boolean a;
  public int b;
  public long b;
  public volatile boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  public lus()
  {
    this.jdField_b_of_type_Long = 3000L;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    a(255);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a(long paramLong)
  {
    long l1 = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long == 0L) {}
    int i1;
    do
    {
      return;
      i1 = (int)((paramLong - l1) * this.g / this.jdField_b_of_type_Long - this.c);
      a(this.f, i1, this.f + this.jdField_b_of_type_Int, this.c + i1);
      if ((this.jdField_a_of_type_Lut != null) && (this.jdField_b_of_type_Boolean) && (i1 > this.c))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Lut.a();
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameParticleEmoji", 2, "call onShow  top = " + i1 + ",mHeight = " + this.c);
        }
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (i1 + this.n);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.top + this.i);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.f + this.jdField_b_of_type_Int / 2 - this.l / 2, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.f + this.jdField_b_of_type_Int / 2 + this.l / 2, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.f + this.jdField_b_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsRectF.bottom + this.m);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    super.a(paramCanvas, paramPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      paramPaint.setColor(-706970);
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.j, this.j, paramPaint);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
      paramPaint.setColor(-3398);
      paramPaint.setTextSize(this.k);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
      float f2 = localFontMetrics.ascent;
      f2 = (localFontMetrics.descent + f2) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), f1 - f2, paramPaint);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsRectF = null;
    this.jdField_a_of_type_AndroidGraphicsPath = null;
    this.jdField_a_of_type_Lut = null;
  }
  
  public void b(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      c();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 176 / 750);
    this.c = (paramInt1 * 176 / 750);
    this.e = paramInt1;
    this.g = (this.c + paramInt2);
    c();
    this.h = (paramInt1 * 360 / 750);
    this.i = (paramInt1 * 70 / 750);
    this.j = (paramInt1 * 5 / 750);
    this.k = (paramInt1 * 32 / 750);
    this.l = (paramInt1 * 28 / 750);
    this.m = (paramInt1 * 16 / 750);
    this.n = (paramInt1 * -143 / 750);
    this.o = (paramInt1 * 10 / 750);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_b_of_type_Long != paramLong) {
      this.jdField_b_of_type_Long = paramLong;
    }
    QLog.d("RedPacketGameParticleEmoji", 2, "WL_DEBUG setDuration duration = " + paramLong);
  }
  
  public void c()
  {
    this.f = ((this.e - this.jdField_b_of_type_Int * 3) * (this.d + 1) / 4 + this.jdField_b_of_type_Int * this.d);
    int i3 = this.f + this.jdField_b_of_type_Int / 2 - this.h / 2;
    int i1 = this.h + i3;
    int i2 = i3;
    if (i3 < this.o)
    {
      i2 = this.o;
      i1 = this.h + i2;
    }
    i3 = i1;
    if (i1 > this.e - this.o)
    {
      i3 = this.e - this.o;
      i2 = i3 - this.h;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.left = i2;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = i3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lus
 * JD-Core Version:    0.7.0.1
 */