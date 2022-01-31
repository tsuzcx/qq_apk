package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import anob;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class FoodAloneTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float = 0.73F;
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "#ffffff";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_b_of_type_Float = 0.31F;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public FoodAloneTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * paramFloat);
  }
  
  private void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramTypeface);
    this.d = a(48.75F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.d);
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("呢"));
    this.e = a(27.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.e);
    this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("呢"));
    this.f = a(18.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.f);
    this.c = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("呢"));
    this.j = a(0.0F);
    this.k = a(0.0F);
    this.g = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.98D));
    this.h = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.98D));
  }
  
  public float a()
  {
    return this.g;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = a(paramInt, new anob(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int n = paramString.length();
    int m;
    if (n > 10)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 10));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(10, Math.min(n, 20)));
      this.i = this.f;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.i);
      this.l = this.c;
      paramInt = this.l;
      m = this.j + paramInt * 2;
      paramInt = this.l * 10 + this.k * 9;
    }
    while (paramInt > this.h * this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, paramInt - this.jdField_a_of_type_Float * this.h, this.g, this.h * (1.0F - this.jdField_a_of_type_Float) + paramInt);
      paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
      f1 = this.g - m;
      f2 = this.jdField_b_of_type_Float;
      f3 = this.g;
      f4 = this.jdField_b_of_type_Float;
      paramString.set(f1 * f2, 0.0F, m * (1.0F - this.jdField_b_of_type_Float) + f3 * f4, paramInt);
      return;
      int i1;
      if (n > 5)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.i = this.e;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.i);
        this.l = this.jdField_b_of_type_Int;
        m = this.l * 1;
        paramInt = this.l;
        i1 = this.k;
        paramInt = Math.max(n - 1, 0) * i1 + paramInt * n;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.i = this.d;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.i);
        this.l = this.jdField_a_of_type_Int;
        m = this.l * 1;
        paramInt = n;
        if (n == 0) {
          paramInt = 2;
        }
        n = this.l;
        i1 = this.k;
        paramInt = Math.max(paramInt - 1, 0) * i1 + n * paramInt;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.g, this.h);
    paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f1 = this.g - m;
    float f2 = this.jdField_b_of_type_Float;
    float f3 = (this.h * this.jdField_a_of_type_Float - paramInt) / 2.0F;
    float f4 = this.g;
    float f5 = this.jdField_b_of_type_Float;
    float f6 = m;
    float f7 = this.jdField_b_of_type_Float;
    float f8 = this.h;
    float f9 = this.jdField_a_of_type_Float;
    paramString.set(f1 * f2, f3, f6 * (1.0F - f7) + f4 * f5, (paramInt + f8 * f9) / 2.0F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Object localObject = new Rect();
    ((Rect)localObject).set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    if (b(0)) {
      paramCanvas.drawRoundRect(new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left, this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_b_of_type_AndroidGraphicsRectF.right, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + this.l * 0.1F), 6.0F, 6.0F, a());
    }
    int n = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.left + 0.5D * this.l);
    int m = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.l);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      int i4 = ((String)localObject).length();
      int i3 = 0;
      int i2 = m;
      m = i3;
      while (m < i4)
      {
        paramCanvas.drawText(((String)localObject).substring(m, m + 1), n, i2, this.jdField_a_of_type_AndroidTextTextPaint);
        i2 += this.l + this.k;
        m += 1;
      }
      i2 = this.l;
      i3 = this.j;
      m = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.l);
      i1 -= 1;
      n += i2 + i3;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.bottom - Math.min(this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.FoodAloneTextItem
 * JD-Core Version:    0.7.0.1
 */