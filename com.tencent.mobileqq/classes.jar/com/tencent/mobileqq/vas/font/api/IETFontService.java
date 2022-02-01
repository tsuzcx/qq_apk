package com.tencent.mobileqq.vas.font.api;

import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IETFontService
  extends QRouteApi
{
  public abstract IETDecoration createDecoration(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, IETFont paramIETFont, boolean paramBoolean2);
  
  public abstract IETDecoration createDecorationSpace(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont, boolean paramBoolean3);
  
  public abstract IETFont createETFont();
  
  public abstract IETFont createETFont(int paramInt, String paramString, float paramFloat);
  
  public abstract IETFont createETFont(int paramInt1, String paramString, float paramFloat, int paramInt2, Typeface paramTypeface);
  
  public abstract IETFont createETFont(IETFont paramIETFont);
  
  public abstract ReplacementSpan createETImageSpan(Drawable paramDrawable);
  
  public abstract IETSegment createETSegment();
  
  public abstract IETEngine getETEngineInstance();
  
  public abstract IETEngine getInstanceForAnimation();
  
  public abstract IETEngine getInstanceForDiyPendant();
  
  public abstract IETEngine getInstanceForRedPacket();
  
  public abstract IETEngine getInstanceForSpace();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.IETFontService
 * JD-Core Version:    0.7.0.1
 */