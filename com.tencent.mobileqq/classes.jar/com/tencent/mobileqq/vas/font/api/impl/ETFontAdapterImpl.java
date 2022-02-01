package com.tencent.mobileqq.vas.font.api.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETDIYUtil;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETImageSpan;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.util.ArrayList;
import java.util.Map;

public class ETFontAdapterImpl
  implements IETFontAdapter
{
  public void drawImage(Canvas paramCanvas, float paramFloat1, float paramFloat2, Object paramObject, Paint paramPaint)
  {
    if ((paramObject instanceof EmoticonSpan))
    {
      paramObject = (EmoticonSpan)paramObject;
      int i = (int)paramFloat2 + paramObject.getDrawable().getBounds().height();
      paramObject.draw(paramCanvas, null, 0, 0, paramFloat1, 0, i, i, null);
      return;
    }
    if ((paramObject instanceof ETImageSpan))
    {
      paramObject = (ETImageSpan)paramObject;
      paramObject.draw(paramCanvas, null, 0, 0, paramFloat1, 0, 0, (int)(paramFloat2 + paramObject.getDrawable().getBounds().height()), paramPaint);
    }
  }
  
  public void drawSignatureSpan(ArrayList<CharacterStyle> paramArrayList, ETFont paramETFont, Paint paramPaint, int paramInt, Canvas paramCanvas)
  {
    paramArrayList = (SignatureActionSpan)paramArrayList.get(paramInt);
    paramPaint.setTextSize(paramETFont.mFontSize);
    paramPaint.setColor(paramETFont.mFontColor);
    paramInt = paramArrayList.b();
    int i = (int)paramArrayList.b;
    paramArrayList.jdField_a_of_type_Boolean = false;
    paramArrayList.draw(paramCanvas, null, 0, 0, paramArrayList.jdField_a_of_type_Float, (int)paramArrayList.b, 0, paramInt + i, paramPaint);
  }
  
  public String getDIYFontImage(String paramString)
  {
    return (String)ETDIYUtil.b.get(paramString);
  }
  
  public int getSpanHeight(CharacterStyle paramCharacterStyle)
  {
    if ((paramCharacterStyle instanceof EmoticonSpan)) {
      return ((EmoticonSpan)paramCharacterStyle).getDrawable().getBounds().height();
    }
    if ((paramCharacterStyle instanceof SignatureActionSpan)) {
      return ((SignatureActionSpan)paramCharacterStyle).b();
    }
    return 0;
  }
  
  public int getSpanWidth(CharacterStyle paramCharacterStyle)
  {
    if ((paramCharacterStyle instanceof EmoticonSpan)) {
      return ((EmoticonSpan)paramCharacterStyle).getDrawable().getBounds().width();
    }
    if ((paramCharacterStyle instanceof SignatureActionSpan)) {
      return ((SignatureActionSpan)paramCharacterStyle).a();
    }
    return 0;
  }
  
  public char getSysEmotcationHead()
  {
    return '\024';
  }
  
  public boolean isInstanceOfEmoticonSpan(CharacterStyle paramCharacterStyle)
  {
    return (paramCharacterStyle != null) && ((paramCharacterStyle instanceof EmoticonSpan));
  }
  
  public boolean isInstanceOfSignatureActionSpan(CharacterStyle paramCharacterStyle)
  {
    return (paramCharacterStyle != null) && ((paramCharacterStyle instanceof SignatureActionSpan));
  }
  
  public void setSignatureActionSpanData(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    if ((paramCharacterStyle instanceof SignatureActionSpan))
    {
      paramCharacterStyle = (SignatureActionSpan)paramCharacterStyle;
      paramCharacterStyle.jdField_a_of_type_Float = paramInt1;
      paramCharacterStyle.b = paramInt2;
    }
  }
  
  public void systemDrawSpan(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, CharacterStyle paramCharacterStyle, int paramInt3)
  {
    if ((paramCharacterStyle instanceof EmoticonSpan))
    {
      paramCharacterStyle = (EmoticonSpan)paramCharacterStyle;
      paramInt2 += paramCharacterStyle.getDrawable().getBounds().height();
      paramCharacterStyle.draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2, paramPaint);
      return;
    }
    if ((paramCharacterStyle instanceof SignatureActionSpan))
    {
      paramPaint.setTextSize(paramInt3);
      paramCharacterStyle = (SignatureActionSpan)paramCharacterStyle;
      paramInt3 = paramCharacterStyle.b();
      paramCharacterStyle.jdField_a_of_type_Boolean = false;
      paramCharacterStyle.draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2 + paramInt3, paramPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.impl.ETFontAdapterImpl
 * JD-Core Version:    0.7.0.1
 */