package com.tencent.rfw.barrage.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import java.util.HashMap;
import java.util.Map;

public class RFWDrawUtils
{
  public static Paint a;
  private static final Rect b = new Rect();
  private static final TextPaint c = new TextPaint();
  private static final Map<Float, Float> d = new HashMap();
  private static final Map<Float, Float> e = new HashMap();
  private static final Map<Float, Float> f = new HashMap();
  
  static
  {
    a = new Paint();
    a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static float a(float paramFloat)
  {
    c.setTextSize(paramFloat);
    Float localFloat = (Float)d.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = c.getFontMetrics();
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).leading);
      d.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float a(float paramFloat, String paramString)
  {
    c.setTextSize(paramFloat);
    return a(c, paramString);
  }
  
  public static float a(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
  
  public static float a(RFWWindowConfig paramRFWWindowConfig)
  {
    return a(paramRFWWindowConfig.m()) + RFWBarrageContext.a().d() * 2 + paramRFWWindowConfig.n() * 2.0F + paramRFWWindowConfig.o() * 2.0F;
  }
  
  public static void a(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWDrawUtils
 * JD-Core Version:    0.7.0.1
 */