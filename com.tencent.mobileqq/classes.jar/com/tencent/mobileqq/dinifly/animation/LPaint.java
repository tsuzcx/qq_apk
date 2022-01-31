package com.tencent.mobileqq.dinifly.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import android.support.annotation.NonNull;

public class LPaint
  extends Paint
{
  public LPaint() {}
  
  public LPaint(int paramInt)
  {
    super(paramInt);
  }
  
  public LPaint(int paramInt, PorterDuff.Mode paramMode)
  {
    super(paramInt);
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public LPaint(PorterDuff.Mode paramMode)
  {
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public void setTextLocales(@NonNull LocaleList paramLocaleList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.LPaint
 * JD-Core Version:    0.7.0.1
 */