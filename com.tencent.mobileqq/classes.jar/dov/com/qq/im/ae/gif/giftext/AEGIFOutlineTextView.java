package dov.com.qq.im.ae.gif.giftext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import bkwr;

public class AEGIFOutlineTextView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_b_of_type_JavaLangString = "#00FFFFFF";
  private boolean jdField_b_of_type_Boolean = true;
  private float c;
  
  public AEGIFOutlineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    while ((localRect.width() + paramInt3 > paramInt1 * 1.0F) || (localRect.height() + paramInt3 > paramInt2 * 1.0F))
    {
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    setFontStyle();
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_AndroidTextTextPaint.getTextSize());
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, Color.parseColor(this.jdField_b_of_type_JavaLangString));
    }
    float f1;
    int i;
    for (;;)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      i = this.jdField_a_of_type_JavaLangString.indexOf("\r\n");
      if (i >= 0) {
        break label339;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidTextTextPaint, getWidth(), getHeight(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
    float f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
    }
    a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    for (;;)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
      return;
      label339:
      String str1 = this.jdField_a_of_type_JavaLangString.substring(0, i);
      String str2 = this.jdField_a_of_type_JavaLangString.substring("\r\n".length() + i);
      a(str1, this.jdField_b_of_type_AndroidTextTextPaint, getWidth(), getHeight() / 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, str1, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str1)) / 2.0F, getHeight() * 0.35F - f1 / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      }
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str1, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1)) / 2.0F, getHeight() * 0.35F - f1 / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, str2, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str2)) / 2.0F, getHeight() * 0.75F - f1 / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      }
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str2, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str2)) / 2.0F, getHeight() * 0.75F - f1 / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void setFontStyle()
  {
    Typeface localTypeface = bkwr.a().a("jianqiaohei.ttf");
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
  }
  
  public void setOutlineColor(String paramString)
  {
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void setOutlineWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setShadowParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setStroke(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.trim();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
      invalidate();
    }
  }
  
  public void setTextColor(String paramString)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView
 * JD-Core Version:    0.7.0.1
 */