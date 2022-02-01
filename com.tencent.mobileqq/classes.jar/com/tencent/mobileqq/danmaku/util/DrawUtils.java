package com.tencent.mobileqq.danmaku.util;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import java.util.HashMap;
import java.util.Map;

public class DrawUtils
{
  private static int jdField_a_of_type_Int;
  public static Paint a;
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private static final Map<Float, Float> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static Paint b;
  private static final Map<Float, Float> b;
  private static final Map<Float, Float> c;
  
  static
  {
    jdField_b_of_type_JavaUtilMap = new HashMap();
    c = new HashMap();
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static float a(float paramFloat)
  {
    jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    Float localFloat = (Float)jdField_a_of_type_JavaUtilMap.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      jdField_a_of_type_JavaUtilMap.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float a(float paramFloat, String paramString)
  {
    jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    return a(jdField_a_of_type_AndroidTextTextPaint, paramString);
  }
  
  public static float a(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
  
  public static float a(WindowConfig paramWindowConfig)
  {
    return a(paramWindowConfig.c()) + DanmakuContext.a().c() * 2 + paramWindowConfig.d() * 2.0F + paramWindowConfig.e() * 2.0F;
  }
  
  public static void a(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public static void a(Canvas paramCanvas, String paramString)
  {
    if (jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      jdField_b_of_type_AndroidGraphicsPaint.setColor(-256);
      Object localObject = DanmakuDependImp.a().a().a().getDisplayMetrics();
      jdField_b_of_type_AndroidGraphicsPaint.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = jdField_b_of_type_AndroidGraphicsPaint.getFontMetrics();
      jdField_a_of_type_Int = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - jdField_a_of_type_Int, jdField_b_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.DrawUtils
 * JD-Core Version:    0.7.0.1
 */