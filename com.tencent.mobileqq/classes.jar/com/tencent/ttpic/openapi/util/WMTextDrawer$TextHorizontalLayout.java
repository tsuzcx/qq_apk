package com.tencent.ttpic.openapi.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.util.WMTokenizer;
import com.tencent.ttpic.util.WMTokenizer.Token;
import java.util.ArrayList;
import java.util.Iterator;

class WMTextDrawer$TextHorizontalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextHorizontalLayout(WMTextDrawer paramWMTextDrawer, TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
  {
    super(paramTextWMElement, paramInt1, paramInt2, paramString);
  }
  
  protected void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
    float f4 = this.mWMTokenizer.getFontHeight() / 2.0F;
    float f5 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
    Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
    if (localIterator.hasNext())
    {
      WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
      float[] arrayOfFloat = new float[localToken.text.length()];
      this.mPaint.getTextWidths(localToken.text, arrayOfFloat);
      float f1 = localToken.x;
      float f6 = localToken.y;
      int i = 0;
      label128:
      float f7;
      float f8;
      float f2;
      if (i < localToken.text.length())
      {
        draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f1 + paramFloat1, f6 + (f4 + f5) + paramFloat2);
        f7 = arrayOfFloat[i];
        f8 = this.mWMElement.kern;
        if (this.mWMElement.outerStrokeSize <= 0.0F) {
          break label261;
        }
        f2 = this.mWMElement.outerStrokeSize * 2.0F;
        label213:
        if (this.mWMElement.strokeSize <= 0.0F) {
          break label267;
        }
      }
      label261:
      label267:
      for (float f3 = this.mWMElement.shadowSize * 2.0F;; f3 = 0.0F)
      {
        f1 += f3 + (f8 + f7 + f2);
        i += 1;
        break label128;
        break;
        f2 = 0.0F;
        break label213;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer.TextHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */