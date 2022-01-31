import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class lrw
  extends lrx
{
  private float jdField_a_of_type_Float = 1.0F;
  private final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  protected Canvas a;
  private Paint.FontMetricsInt jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private float b = 15.0F;
  private int k = -1;
  private int l = 2147483647;
  private int m = 2147483647;
  private int n = 2147483647;
  
  public lrw()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.b);
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    a(false);
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.e, this.f, this.jdField_a_of_type_AndroidGraphicsBitmap$Config);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(0.0F, -this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    return localBitmap;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextSize textSize: " + paramFloat);
    }
    this.b = paramFloat;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setText text: " + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(lqo paramlqo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Float < 0.99F) && (Build.VERSION.SDK_INT >= 16)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramlqo.a(3);
        paramlqo.a(this.jdField_a_of_type_Float);
      }
      paramlqo.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
      if (i != 0) {
        paramlqo.c();
      }
      return;
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextColor textColor: " + paramInt);
    }
    this.k = paramInt;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setMaxLength maxLength: " + paramInt);
    }
    this.n = paramInt;
  }
  
  public void e()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      j = mqu.a(this.jdField_a_of_type_JavaLangString);
      i = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      if ((j <= this.n) && (i <= this.l)) {
        break label302;
      }
    }
    label302:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        i = Math.min(Math.max((this.l - (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("..."))) / (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("M")), 1), this.n);
        this.jdField_a_of_type_JavaLangString = (mqu.a(this.jdField_a_of_type_JavaLangString, 0, i) + "...");
        i = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      }
      j = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top;
      if (i <= 0) {
        i = 1;
      }
      for (;;)
      {
        if (j <= 0) {
          j = 1;
        }
        for (;;)
        {
          b(i, j);
          a(i, j);
          if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "refreshText width: " + this.e + ", height: " + this.f + ", maxLength: " + this.n + ", textSize: " + this.b + ", text: " + this.jdField_a_of_type_JavaLangString + ";mMetrics:=" + this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.toString());
          }
          return;
          j = 1;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setWidth width: " + paramInt);
    }
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
  
  public int j()
  {
    return (int)Math.ceil(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.descent - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
  }
  
  public int k()
  {
    return Math.abs(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */