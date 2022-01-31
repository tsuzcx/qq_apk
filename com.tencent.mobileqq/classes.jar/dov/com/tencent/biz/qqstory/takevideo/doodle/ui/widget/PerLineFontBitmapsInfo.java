package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Random;

public class PerLineFontBitmapsInfo
{
  public int a;
  public TextPaint a;
  public ArrayList a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public PerLineFontBitmapsInfo(int paramInt1, int paramInt2, Typeface paramTypeface, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_Int = paramInt3;
    this.b = paramInt4;
    this.c = paramInt5;
    this.d = paramInt6;
  }
  
  public static int a()
  {
    Random localRandom = new Random();
    int i = localRandom.nextInt(5);
    int j = localRandom.nextInt(9);
    return localRandom.nextInt(9) + (i * 100 + j * 10);
  }
  
  public static PerLineFontBitmapsInfo a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, AnimStateTypeEvaluator paramAnimStateTypeEvaluator)
  {
    paramTypeface = new PerLineFontBitmapsInfo(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.f = 1;
    paramTypeface.a(paramCharSequence, paramAnimStateTypeEvaluator);
    return paramTypeface;
  }
  
  public static void a(int paramInt, Paint paramPaint)
  {
    if (paramInt == 255)
    {
      paramPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      return;
    }
    paramPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
  }
  
  public void a(CharSequence paramCharSequence, AnimStateTypeEvaluator paramAnimStateTypeEvaluator)
  {
    a(paramCharSequence, paramAnimStateTypeEvaluator, 0);
  }
  
  public void a(CharSequence paramCharSequence, AnimStateTypeEvaluator paramAnimStateTypeEvaluator, int paramInt)
  {
    this.e = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length()));
    if ((paramInt != 0) && (paramInt > this.e)) {}
    for (int j = (paramInt - this.e) / (paramCharSequence.length() - 1);; j = 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int k = 0;
      paramInt = 0;
      while (k < paramCharSequence.length())
      {
        int i = paramCharSequence.charAt(k);
        if (i == 32)
        {
          paramInt = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("0", 0, 1) + paramInt;
          k += 1;
        }
        else
        {
          FontBitmapInfo localFontBitmapInfo = new FontBitmapInfo();
          String str = new String(new char[] { i });
          int m = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str, 0, str.length());
          Object localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
          float f1 = ((Paint.FontMetrics)localObject).bottom;
          float f2 = ((Paint.FontMetrics)localObject).top;
          float f3 = Math.abs(((Paint.FontMetrics)localObject).ascent);
          localObject = Bitmap.createBitmap(m, (int)(f1 - f2), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          BaseApplicationImpl.getContext();
          localCanvas.drawText(str, 0.0F, f3, this.jdField_a_of_type_AndroidTextTextPaint);
          if (this.f == 0)
          {
            localFontBitmapInfo.b = paramAnimStateTypeEvaluator.a("", this.c + a(), this.d, 0, 255, new LinearInterpolator());
            label282:
            localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
            if (k != 0) {
              break label374;
            }
            localFontBitmapInfo.jdField_a_of_type_Int = paramInt;
          }
          for (paramInt = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + paramInt;; paramInt = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + j + paramInt)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localFontBitmapInfo);
            break;
            localFontBitmapInfo.b = paramAnimStateTypeEvaluator.a("", this.c + this.d * k / paramCharSequence.length(), this.d, 0, 255, new LinearInterpolator());
            break label282;
            label374:
            localFontBitmapInfo.jdField_a_of_type_Int = (paramInt + j);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.PerLineFontBitmapsInfo
 * JD-Core Version:    0.7.0.1
 */