package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import java.util.HashMap;
import java.util.Map;

class TickerDrawMetrics
{
  private final Paint a;
  private final Map<Character, Float> b = new HashMap(256);
  private float c;
  private float d;
  private int e = 0;
  
  TickerDrawMetrics(Paint paramPaint)
  {
    this.a = paramPaint;
    a();
  }
  
  float a(char paramChar)
  {
    if (paramChar == 0) {
      return 0.0F;
    }
    Float localFloat = (Float)this.b.get(Character.valueOf(paramChar));
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    float f = this.a.measureText(Character.toString(paramChar));
    this.b.put(Character.valueOf(paramChar), Float.valueOf(f));
    return f;
  }
  
  void a()
  {
    this.b.clear();
    Paint.FontMetrics localFontMetrics = this.a.getFontMetrics();
    this.c = (localFontMetrics.bottom - localFontMetrics.top);
    this.d = (-localFontMetrics.top);
  }
  
  void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  float b()
  {
    return this.c;
  }
  
  float c()
  {
    return this.d;
  }
  
  int d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerDrawMetrics
 * JD-Core Version:    0.7.0.1
 */