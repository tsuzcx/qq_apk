package com.tencent.mobileqq.danmaku.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import arqu;
import arqx;
import arru;
import arsk;
import artl;
import java.util.HashMap;
import java.util.Map;

public class DrawUtils
{
  public static Paint CLEAR_PAINT;
  public static final int DEBUG_INFO_MARGIN = 10;
  public static final int DEBUG_INFO_TEXT_SIZE = 12;
  public static Paint PAINT_FPS;
  private static final Rect RECT = new Rect();
  private static int TEXT_HEIGHT;
  private static final Map<Float, Float> sTextAscentCache;
  private static final Map<Float, Float> sTextDescentCache;
  private static final Map<Float, Float> sTextHeightCache;
  private static final TextPaint sTextPaint = new TextPaint();
  
  static
  {
    sTextHeightCache = new HashMap();
    sTextAscentCache = new HashMap();
    sTextDescentCache = new HashMap();
    CLEAR_PAINT = new Paint();
    CLEAR_PAINT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static void clearCanvas(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public static void drawDebugText(Canvas paramCanvas, String paramString)
  {
    if (PAINT_FPS == null)
    {
      PAINT_FPS = new Paint();
      PAINT_FPS.setColor(-256);
      Object localObject = arqu.a().a().a().getDisplayMetrics();
      PAINT_FPS.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = PAINT_FPS.getFontMetrics();
      TEXT_HEIGHT = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - TEXT_HEIGHT, PAINT_FPS);
  }
  
  public static boolean drawImage(Canvas paramCanvas, Drawable paramDrawable, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramDrawable != null) && (artl.a()))
    {
      RECT.set((int)paramFloat1, (int)paramFloat2, (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
      try
      {
        paramDrawable.setBounds(RECT);
        paramDrawable.setAlpha(paramInt);
        paramDrawable.draw(paramCanvas);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static float getAscent(float paramFloat)
  {
    sTextPaint.setTextSize(paramFloat);
    Float localFloat2 = (Float)sTextAscentCache.get(Float.valueOf(paramFloat));
    Float localFloat1 = localFloat2;
    if (localFloat2 == null)
    {
      localFloat1 = Float.valueOf(sTextPaint.getFontMetrics().ascent);
      sTextAscentCache.put(Float.valueOf(paramFloat), localFloat1);
    }
    return localFloat1.floatValue();
  }
  
  public static float getDefaultLineHeight(arsk paramarsk)
  {
    return getTextHeight(paramarsk.c()) + arru.a().c() * 2 + paramarsk.d() * 2.0F + paramarsk.e() * 2.0F;
  }
  
  public static float getDescent(float paramFloat)
  {
    sTextPaint.setTextSize(paramFloat);
    Float localFloat2 = (Float)sTextDescentCache.get(Float.valueOf(paramFloat));
    Float localFloat1 = localFloat2;
    if (localFloat2 == null)
    {
      localFloat1 = Float.valueOf(sTextPaint.getFontMetrics().descent);
      sTextDescentCache.put(Float.valueOf(paramFloat), localFloat1);
    }
    return localFloat1.floatValue();
  }
  
  public static RectF getLeftBottomRect(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    if ((paramBitmap == null) || (paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0) || (paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      return localRectF;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (paramFloat2 / 2.0F * f1 * 2.0F / 3.0F > paramFloat1 * f2)
    {
      paramFloat1 = paramFloat1 * 3.0F / 2.0F;
      f1 = f2 * paramFloat1 / f1;
      localRectF.left = 0.0F;
      localRectF.right = paramFloat1;
      localRectF.top = (paramFloat2 - f1);
      localRectF.bottom = f1;
      return localRectF;
    }
    float f3 = paramFloat2 / 2.0F;
    f1 = f1 * f3 / f2;
    localRectF.left = (paramFloat1 - f1 * 2.0F / 3.0F);
    localRectF.right = (f1 / 3.0F + paramFloat1);
    localRectF.top = f3;
    localRectF.bottom = paramFloat2;
    return localRectF;
  }
  
  public static float getTextHeight(float paramFloat)
  {
    sTextPaint.setTextSize(paramFloat);
    Float localFloat = (Float)sTextHeightCache.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = sTextPaint.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      sTextHeightCache.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float getTextHeight(TextPaint paramTextPaint)
  {
    float f1 = paramTextPaint.getTextSize();
    Float localFloat = (Float)sTextHeightCache.get(Float.valueOf(f1));
    paramTextPaint = localFloat;
    if (localFloat == null)
    {
      paramTextPaint = sTextPaint.getFontMetrics();
      float f2 = paramTextPaint.descent;
      float f3 = paramTextPaint.ascent;
      paramTextPaint = Float.valueOf(paramTextPaint.leading + (f2 - f3));
      sTextHeightCache.put(Float.valueOf(f1), paramTextPaint);
    }
    return paramTextPaint.floatValue();
  }
  
  public static float getTextWidth(float paramFloat, String paramString)
  {
    sTextPaint.setTextSize(paramFloat);
    return getTextWidth(sTextPaint, paramString);
  }
  
  public static float getTextWidth(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.DrawUtils
 * JD-Core Version:    0.7.0.1
 */