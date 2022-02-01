package com.tencent.mobileqq.vas.font.api;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IETFontAdapter
  extends QRouteApi
{
  public abstract void drawImage(Canvas paramCanvas, float paramFloat1, float paramFloat2, Object paramObject, Paint paramPaint);
  
  public abstract void drawSignatureSpan(ArrayList<CharacterStyle> paramArrayList, ETFont paramETFont, Paint paramPaint, int paramInt, Canvas paramCanvas);
  
  public abstract String getDIYFontImage(String paramString);
  
  public abstract int getSpanHeight(CharacterStyle paramCharacterStyle);
  
  public abstract int getSpanWidth(CharacterStyle paramCharacterStyle);
  
  public abstract char getSysEmotcationHead();
  
  public abstract boolean isInstanceOfEmoticonSpan(CharacterStyle paramCharacterStyle);
  
  public abstract boolean isInstanceOfSignatureActionSpan(CharacterStyle paramCharacterStyle);
  
  public abstract void setSignatureActionSpanData(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle);
  
  public abstract void systemDrawSpan(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, CharacterStyle paramCharacterStyle, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.IETFontAdapter
 * JD-Core Version:    0.7.0.1
 */