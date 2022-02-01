package com.tencent.mobileqq.vas.font.api.impl;

import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETImageSpan;
import com.etrump.mixlayout.ETSegment;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.mobileqq.vas.font.api.IETFontService;

public class ETFontServiceImpl
  implements IETFontService
{
  public IETDecoration createDecoration(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, IETFont paramIETFont, boolean paramBoolean2)
  {
    return ETDecoration.createDecoration(paramIETEngine, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfIETSegment, paramArrayOfObject, paramBoolean1, paramInt5, paramIETFont, paramBoolean2);
  }
  
  public IETDecoration createDecorationSpace(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont, boolean paramBoolean3)
  {
    return ETDecoration.createDecorationSpace(paramIETEngine, paramString, paramInt1, paramInt2, paramPoint, paramInt3, paramArrayOfPoint, paramInt4, paramArrayOfIETSegment, paramArrayOfObject, paramBoolean1, paramInt5, paramBoolean2, paramIETFont, paramBoolean3);
  }
  
  public IETFont createETFont()
  {
    return new ETFont();
  }
  
  public IETFont createETFont(int paramInt, String paramString, float paramFloat)
  {
    return new ETFont(paramInt, paramString, paramFloat);
  }
  
  public IETFont createETFont(int paramInt1, String paramString, float paramFloat, int paramInt2, Typeface paramTypeface)
  {
    return new ETFont(paramInt1, paramString, paramFloat, paramInt2, paramTypeface);
  }
  
  public IETFont createETFont(IETFont paramIETFont)
  {
    return ETFont.createFont((ETFont)paramIETFont);
  }
  
  public ReplacementSpan createETImageSpan(Drawable paramDrawable)
  {
    return new ETImageSpan(paramDrawable);
  }
  
  public IETSegment createETSegment()
  {
    return new ETSegment();
  }
  
  public IETEngine getETEngineInstance()
  {
    return ETEngine.getInstance();
  }
  
  public IETEngine getInstanceForAnimation()
  {
    return ETEngine.getInstanceForAnimation();
  }
  
  public IETEngine getInstanceForDiyPendant()
  {
    return ETEngine.getInstanceForDiyPendant();
  }
  
  public IETEngine getInstanceForRedPacket()
  {
    return ETEngine.getInstanceForRedPacket();
  }
  
  public IETEngine getInstanceForSpace()
  {
    return ETEngine.getInstanceForSpace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.impl.ETFontServiceImpl
 * JD-Core Version:    0.7.0.1
 */