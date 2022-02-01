import android.graphics.Bitmap;
import android.text.TextUtils;
import com.Vas.ColorFont.FreeTypeLib;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
{
  private static l jdField_a_of_type_L;
  static boolean jdField_a_of_type_Boolean = false;
  private FreeTypeLib jdField_a_of_type_ComVasColorFontFreeTypeLib = new FreeTypeLib();
  public AtomicBoolean a;
  private m jdField_a_of_type_M = new m(this, 8);
  public AtomicBoolean b = new AtomicBoolean(false);
  public AtomicBoolean c = new AtomicBoolean(false);
  
  private l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static l a()
  {
    if (jdField_a_of_type_L == null) {}
    try
    {
      if (jdField_a_of_type_L == null) {
        jdField_a_of_type_L = new l();
      }
      return jdField_a_of_type_L;
    }
    finally {}
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.releaseColorFont(paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getFontColor(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public int a(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getExtraBitmap(paramInt, paramBitmap1, paramBitmap2, 0);
  }
  
  public int a(int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getExtraBitmap(paramInt1, paramBitmap1, paramBitmap2, paramInt2);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty((String)this.jdField_a_of_type_M.get(Integer.valueOf(paramInt))))
    {
      this.jdField_a_of_type_M.put(Integer.valueOf(paramInt), paramString);
      int[] arrayOfInt = new int[5];
      long l1 = System.currentTimeMillis();
      int i = this.jdField_a_of_type_ComVasColorFontFreeTypeLib.initColorFont(paramInt, paramString, arrayOfInt);
      long l2 = System.currentTimeMillis();
      n.a("FastColorFontHelper", "initColorFont cost:" + (l2 - l1) + " fontId=" + paramInt + "  fontWidth:" + arrayOfInt[1] + "  fontHeight:" + arrayOfInt[2] + "  lineSpace:" + arrayOfInt[0] + "  path=" + paramString);
      if (i / 100 >= 2)
      {
        k.b(paramInt, i / 100);
        k.c(paramInt, i % 100);
        k.a(paramInt, arrayOfInt[0]);
        k.e(paramInt, arrayOfInt[1]);
        k.d(paramInt, arrayOfInt[2]);
        k.f(paramInt, arrayOfInt[3]);
        k.g(paramInt, arrayOfInt[4]);
      }
      if ((paramInt >= 8388608) || (paramInt <= -8388608)) {
        n.b("FastColorFontHelper", "为了缓存不出现问题，字体id最好限制在3个字节以内！");
      }
      return i;
    }
    n.a("FastColorFontHelper", "该字体已经初始化  fontId=" + paramInt + "  path=" + paramString);
    return 0;
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, long paramLong, int paramInt2, Bitmap paramBitmap, int[] paramArrayOfInt2)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawSpecialEffectsText(paramInt1, paramArrayOfInt1, paramLong, paramInt2, paramBitmap, paramArrayOfInt2);
  }
  
  public int a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getHiBoomViewSize(paramInt, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap, paramInt2, paramInt3, paramInt4, 0, null, 0);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt6, int paramInt5)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap, paramInt2, paramInt3, 0, paramInt4, paramArrayOfInt6, paramInt5);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt6)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawAnimationText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap1, paramBitmap2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramArrayOfInt6, 0);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, Bitmap paramBitmap, int[] paramArrayOfInt7, int paramInt6)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.renderExpressionBitmap(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramInt2, paramInt3, paramInt4, paramLong, paramInt5, paramBitmap, paramArrayOfInt7, paramInt6);
  }
  
  public int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt7, int paramInt8)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawStrikingText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramBitmap1, paramBitmap2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramArrayOfInt7, paramInt8);
  }
  
  public FreeTypeLib a()
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib;
  }
  
  public void a()
  {
    this.jdField_a_of_type_M.evictAll();
    if (this.c.get())
    {
      this.jdField_a_of_type_ComVasColorFontFreeTypeLib.clearCache();
      n.a("FastColorFontHelper", "clearCache");
    }
  }
  
  public void a(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getTextWidths(paramInt1, paramArrayOfInt1, paramInt2, paramArrayOfInt2);
  }
  
  public int[] a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, long paramLong, int[] paramArrayOfInt4)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getBitmapWH(paramInt, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramLong, paramArrayOfInt4);
  }
  
  public int[] a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7, int[] paramArrayOfInt8, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.calculateExpressionSize(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramArrayOfInt6, paramArrayOfInt7, paramArrayOfInt8, paramInt2, paramInt3, paramInt4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     l
 * JD-Core Version:    0.7.0.1
 */