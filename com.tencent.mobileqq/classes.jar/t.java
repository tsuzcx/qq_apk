import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Arrays;

public class t
  extends o
{
  public static boolean a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final HiBoomTextView jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int[] jdField_b_of_type_ArrayOfInt;
  private int[] c;
  private int[] d;
  private int[] e;
  private int[] f;
  
  public t(HiBoomTextView paramHiBoomTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramHiBoomTextView;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.c = new int[2];
    this.d = new int[2];
    this.jdField_e_of_type_ArrayOfInt = new int[3];
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    n.a("HiBoomFont.FounderHiBoomLayout", "drawMissingWord....char:" + String.valueOf((char)paramInt1) + "  code:" + paramInt1 + "  x:" + paramInt2 + "  y:" + paramInt3 + "  width:" + paramInt4 + "  height:" + paramInt5);
    if ((paramInt4 > 0) && (paramInt5 > 0))
    {
      if (this.jdField_b_of_type_AndroidGraphicsCanvas != null) {
        break label260;
      }
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt5);
      char c1 = (char)paramInt1;
      float f1 = paramInt5 / 2.0F;
      float f2 = (this.jdField_a_of_type_AndroidGraphicsPaint.descent() + this.jdField_a_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(c1), paramInt2, f1 - f2 + paramInt3, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (jdField_a_of_type_Boolean)
      {
        Paint localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(-16776961);
        localPaint.setStrokeWidth(1.0F);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5, localPaint);
      }
      return;
      label260:
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void a(String paramString) {}
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ArrayOfInt.length > 0) && (this.jdField_e_of_type_ArrayOfInt[0] > 0) && (this.jdField_e_of_type_ArrayOfInt[1] > 0);
  }
  
  private void d()
  {
    if ((this.f != null) && (this.f.length > 5))
    {
      int i = 1;
      while (i < this.f.length)
      {
        int j = this.f[i];
        int k = this.f[(i + 1)];
        int m = this.f[(i + 2)];
        int n = this.f[(i + 3)];
        int i1 = this.f[(i + 4)];
        if ((j >= 0) && (j < this.jdField_a_of_type_ArrayOfInt.length)) {
          a(this.jdField_a_of_type_ArrayOfInt[j], k, m, n, i1);
        }
        i += 5;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, gj paramgj)
  {
    return 0;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new u(this));
  }
  
  public void a(ETFont paramETFont)
  {
    int j = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
    paramETFont = paramETFont.mText;
    if (TextUtils.isEmpty(paramETFont)) {}
    for (;;)
    {
      return;
      int k = paramETFont.length();
      int i;
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        i = j;
        if (this.jdField_a_of_type_ArrayOfInt.length == k) {}
      }
      else
      {
        this.jdField_a_of_type_ArrayOfInt = new int[k];
        i = j;
      }
      while (i < k)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = paramETFont.charAt(i);
        i += 1;
      }
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    this.f = l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.i);
    if (a())
    {
      a("onDraw.....");
      if (!a(this.jdField_e_of_type_ArrayOfInt[0], this.jdField_e_of_type_ArrayOfInt[1])) {
        return false;
      }
      c();
      d();
      System.nanoTime();
      l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c);
      if (l.jdField_a_of_type_Boolean) {
        System.nanoTime();
      }
      int i = this.jdField_e_of_type_ArrayOfInt[2];
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_b_of_type_ArrayOfInt[0] * 1000 / i - 1, this.jdField_b_of_type_ArrayOfInt[1] * 1000 / i - 1);
      int j;
      switch (v.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.getScaleType().ordinal()])
      {
      default: 
        i = (this.d[0] - this.jdField_b_of_type_ArrayOfInt[0]) / 2;
        j = (this.d[1] - this.jdField_b_of_type_ArrayOfInt[1]) / 2;
        this.jdField_b_of_type_AndroidGraphicsRect.set(i, j, this.jdField_b_of_type_ArrayOfInt[0] + i, this.jdField_b_of_type_ArrayOfInt[1] + j);
      }
      for (;;)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, null);
        if ((this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int == 0)) {
          b();
        }
        return true;
        this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.d[0], this.d[1]);
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.set(this.d[0] - this.jdField_b_of_type_ArrayOfInt[0], 0, this.d[0] - this.jdField_b_of_type_ArrayOfInt[0] + this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1]);
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1]);
        continue;
        float f1 = Math.max(this.d[0] / this.jdField_b_of_type_ArrayOfInt[0] * 1.0F, this.d[1] / this.jdField_b_of_type_ArrayOfInt[1] * 1.0F);
        i = (int)((this.jdField_b_of_type_ArrayOfInt[0] * f1 - this.d[0]) / 2.0F);
        j = (int)((f1 * this.jdField_b_of_type_ArrayOfInt[1] - this.d[1]) / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsRect.set(-i, -j, this.jdField_b_of_type_ArrayOfInt[0] + i, j + this.jdField_b_of_type_ArrayOfInt[1]);
      }
    }
    a(anvx.a(2131704334));
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    label26:
    int[] arrayOfInt1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      i = 1;
      if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
        break label239;
      }
      j = 1;
      if (i == 0) {
        break label245;
      }
      arrayOfInt1 = this.c;
      int[] arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      int[] arrayOfInt3 = this.d;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      arrayOfInt3[0] = paramInt1;
      arrayOfInt2[0] = paramInt1;
      arrayOfInt1[0] = paramInt1;
      label69:
      if (j == 0) {
        break label266;
      }
      arrayOfInt1 = this.c;
      arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt3 = this.d;
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      arrayOfInt3[1] = paramInt1;
      arrayOfInt2[1] = paramInt1;
      arrayOfInt1[1] = paramInt1;
    }
    for (;;)
    {
      if (paramInt3 > 0)
      {
        if ((this.c[0] > paramInt3) || (this.c[0] == 0))
        {
          arrayOfInt1 = this.c;
          this.jdField_b_of_type_ArrayOfInt[0] = paramInt3;
          arrayOfInt1[0] = paramInt3;
        }
        if ((this.c[1] > paramInt3) || (this.c[1] == 0))
        {
          arrayOfInt1 = this.c;
          this.jdField_b_of_type_ArrayOfInt[1] = paramInt3;
          arrayOfInt1[1] = paramInt3;
        }
      }
      if (l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt) != 0) {
        break label287;
      }
      this.d[0] = 0;
      this.d[1] = 0;
      return this.d;
      i = 0;
      break;
      label239:
      j = 0;
      break label26;
      label245:
      arrayOfInt1 = this.c;
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      arrayOfInt1[0] = 0;
      break label69;
      label266:
      arrayOfInt1 = this.c;
      this.jdField_b_of_type_ArrayOfInt[1] = 0;
      arrayOfInt1[1] = 0;
    }
    label287:
    if (i == 0) {
      this.d[0] = this.jdField_b_of_type_ArrayOfInt[0];
    }
    if (j == 0) {
      this.d[1] = this.jdField_b_of_type_ArrayOfInt[1];
    }
    return this.d;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    return new int[0];
  }
  
  public void b()
  {
    if ((this.jdField_e_of_type_ArrayOfInt[0] <= 0) || (this.jdField_e_of_type_ArrayOfInt[1] <= 0))
    {
      a("bitmap宽高异常");
      return;
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      n.b("HiBoomFont.FounderHiBoomLayout", "动画执行中....");
      return;
    }
    if ((this.i[0] > 0) && (this.i[1] > 0))
    {
      h();
      return;
    }
    this.jdField_e_of_type_Int = 0;
    l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.i);
    if ((this.i[0] > 0) && (this.i[1] > 0))
    {
      h();
      return;
    }
    n.a("HiBoomFont.FounderHiBoomLayout", "该字体不支持动画....animInfo:" + Arrays.toString(this.i) + "  ttf path:" + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
  }
  
  public void e()
  {
    super.e();
    n.a("HiBoomFont.FounderHiBoomLayout", "release....");
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_AndroidGraphicsCanvas = null;
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.reset();
      this.jdField_a_of_type_AndroidGraphicsPaint = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     t
 * JD-Core Version:    0.7.0.1
 */