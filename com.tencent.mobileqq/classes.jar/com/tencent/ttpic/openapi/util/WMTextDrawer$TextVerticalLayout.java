package com.tencent.ttpic.openapi.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.util.WMTokenizer;
import com.tencent.ttpic.util.WMTokenizer.Token;
import java.util.ArrayList;
import java.util.Iterator;

class WMTextDrawer$TextVerticalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextVerticalLayout(WMTextDrawer paramWMTextDrawer, TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
  {
    super(paramTextWMElement, paramInt1, paramInt2, paramString);
  }
  
  protected void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
    float f4 = this.mWMTokenizer.getFontHeight() / 2.0F;
    float f5 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
    paramCanvas.save();
    Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
    if (localIterator.hasNext())
    {
      WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
      float f6 = localToken.x;
      float f1 = localToken.y + (f4 + f5);
      int i = 0;
      label112:
      float f7;
      float f2;
      if (i < localToken.text.length())
      {
        draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f6 + paramFloat1, f1 + paramFloat2);
        f7 = this.mWMTokenizer.getFontHeight();
        if (this.mWMElement.outerStrokeSize <= 0.0F) {
          break label228;
        }
        f2 = this.mWMElement.outerStrokeSize * 2.0F;
        label183:
        if (this.mWMElement.strokeSize <= 0.0F) {
          break label234;
        }
      }
      label228:
      label234:
      for (float f3 = this.mWMElement.shadowSize * 2.0F;; f3 = 0.0F)
      {
        f1 += f3 + (f7 + f2);
        i += 1;
        break label112;
        break;
        f2 = 0.0F;
        break label183;
      }
    }
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer.TextVerticalLayout
 * JD-Core Version:    0.7.0.1
 */