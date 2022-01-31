import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;

public class fh
{
  private int jdField_a_of_type_Int = -1;
  private CharacterStyle jdField_a_of_type_AndroidTextStyleCharacterStyle;
  private fm jdField_a_of_type_Fm;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = -1;
  private int g;
  private int h;
  
  public fh(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
    if ((paramCharacterStyle instanceof bamw))
    {
      paramCharacterStyle = ((bamw)paramCharacterStyle).a().getBounds();
      this.b = paramCharacterStyle.width();
      this.c = paramCharacterStyle.height();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.e = 2;
      return;
      if ((paramCharacterStyle instanceof aycn))
      {
        paramCharacterStyle = (aycn)paramCharacterStyle;
        this.b = paramCharacterStyle.a();
        this.c = paramCharacterStyle.b();
      }
    }
  }
  
  public fh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = -1;
    this.e = 0;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if ((this.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bamw))
    {
      localObject = (bamw)this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
      paramInt2 += ((bamw)localObject).a().getBounds().height();
      ((bamw)localObject).draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2, paramPaint);
    }
    while (!(this.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof aycn)) {
      return;
    }
    paramPaint.setTextSize(a());
    Object localObject = (aycn)this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
    int i = ((aycn)localObject).b();
    ((aycn)localObject).a = false;
    ((aycn)localObject).draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2 + i, paramPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.reset();
    localPaint.setColor(paramETFont.getColor());
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramETFont.getSize());
    int i = (int)localPaint.getFontMetrics().ascent;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2 - i, localPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramPaint == null) {
      paramPaint = new Paint();
    }
    for (;;)
    {
      paramPaint.reset();
      paramPaint.setColor(paramETFont.getColor());
      paramPaint.setStrokeWidth(paramETFont.getSize() / 12);
      paramInt2 = paramInt2 + paramInt3 - 3;
      paramInt3 = this.b;
      paramCanvas.drawLine(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2, paramPaint);
      return;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    ETFont localETFont = this.jdField_a_of_type_Fm.a();
    if ((localETFont == null) || (paramETEngine == null))
    {
      this.f = 0;
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      this.f = 0;
      return;
    }
    Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
    paramETEngine.native_getFontMetrics(localFontMetrics, localETFont);
    this.f = ((int)Math.abs(localFontMetrics.descent));
  }
  
  public int a()
  {
    ETFont localETFont = this.jdField_a_of_type_Fm.a();
    if (localETFont != null) {
      return localETFont.getSize();
    }
    return 16;
  }
  
  public int a(ETEngine paramETEngine)
  {
    if (this.f < 0) {
      a(paramETEngine);
    }
    return this.f;
  }
  
  public CharacterStyle a()
  {
    return this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
  }
  
  public bamw a()
  {
    if ((this.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bamw)) {
      return (bamw)this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
    }
    return null;
  }
  
  public fm a()
  {
    return this.jdField_a_of_type_Fm;
  }
  
  public String a()
  {
    if (this.e == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.e == 0)
    {
      this.g = paramInt;
      this.h = (this.jdField_a_of_type_JavaLangString.length() + paramInt);
      return;
    }
    this.g = 0;
    this.h = 0;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.jdField_a_of_type_Fm != null))
    {
      localPaint = new Paint();
      if (this.jdField_a_of_type_Fm.a() == true)
      {
        localPaint.setColor(this.jdField_a_of_type_Fm.c());
        localPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.b + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      if (this.jdField_a_of_type_AndroidTextStyleCharacterStyle == null) {
        break label101;
      }
      a(paramCanvas, paramInt1, paramInt2 + paramInt3 - this.c, localPaint);
    }
    label101:
    ETFont localETFont;
    do
    {
      do
      {
        return;
        localETFont = this.jdField_a_of_type_Fm.a();
      } while (localETFont == null);
      if (this.jdField_a_of_type_Fm.b() == true) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
      }
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.e != 1));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    if ((paramETEngine == null) || (paramBitmap == null) || (this.jdField_a_of_type_Fm == null)) {}
    ETFont localETFont;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.e != 0));
      localETFont = this.jdField_a_of_type_Fm.a();
      if (paramETDecoration == null)
      {
        paramETEngine.native_drawText(this.jdField_a_of_type_JavaLangString, paramBitmap, paramInt1, paramInt2, localETFont);
        return;
      }
    } while (1 != paramETDecoration.getDecorationType());
    paramETDecoration.drawFrameText(this.g, this.h, paramBitmap, paramInt1, paramInt2, localETFont);
  }
  
  public void a(fm paramfm)
  {
    this.jdField_a_of_type_Fm = paramfm;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public fo[] a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    if ((2 == this.e) || (1 == this.e))
    {
      paramETEngine = new Rect(paramInt1, paramInt2, this.b + paramInt1, paramInt2 + paramInt3);
      localObject1 = new fo();
      ((fo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((fo)localObject1).jdField_a_of_type_AndroidGraphicsRect = paramETEngine;
      ((fo)localObject1).jdField_a_of_type_Int = paramInt4;
      paramETEngine = new fo[1];
      paramETEngine[0] = localObject1;
      return paramETEngine;
    }
    Object localObject1 = this.jdField_a_of_type_Fm.a();
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(((ETFont)localObject1).getSize());
    int k = this.jdField_a_of_type_JavaLangString.length();
    int[] arrayOfInt = new int[k];
    paramETEngine.native_getTextWidths(this.jdField_a_of_type_JavaLangString, (ETFont)localObject1, (Paint)localObject2, arrayOfInt);
    localObject1 = new fo[k];
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      paramETEngine = (ETEngine)localObject1;
      if (paramInt1 >= k) {
        break;
      }
      j = arrayOfInt[paramInt1] + i;
      paramETEngine = new Rect(i, paramInt2, j, paramInt2 + paramInt3);
      localObject2 = new fo();
      ((fo)localObject2).jdField_a_of_type_Int = paramInt4;
      ((fo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_JavaLangString.charAt(paramInt1));
      ((fo)localObject2).jdField_a_of_type_AndroidGraphicsRect = paramETEngine;
      localObject1[paramInt1] = localObject2;
      paramInt1 += 1;
      i = j;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    if (1 == this.e) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.jdField_a_of_type_Fm != null))
    {
      localPaint = new Paint();
      if (this.jdField_a_of_type_AndroidTextStyleCharacterStyle == null) {
        break label28;
      }
    }
    label28:
    ETFont localETFont;
    do
    {
      return;
      localETFont = this.jdField_a_of_type_Fm.a();
    } while ((localETFont == null) || (this.jdField_a_of_type_Fm.b() != true));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fh
 * JD-Core Version:    0.7.0.1
 */