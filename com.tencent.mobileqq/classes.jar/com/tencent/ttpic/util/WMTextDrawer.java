package com.tencent.ttpic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.WMElement;
import com.tencent.util.LogUtil;

public class WMTextDrawer
{
  private static final String TAG = WMTextDrawer.class.getSimpleName();
  private TextPaint mTextPaint;
  
  private void adjustTextSize(TextWMElement paramTextWMElement, Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = paramTextWMElement.width / paramString.length();
    int j = i;
    if (localRect.width() < paramTextWMElement.width)
    {
      j = i;
      if (localRect.height() < paramTextWMElement.height)
      {
        while ((localRect.width() < paramTextWMElement.width) && (localRect.height() < paramTextWMElement.height))
        {
          i += 2;
          paramPaint.setTextSize(i);
          paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
        }
        paramPaint.setTextSize(i - 2);
        return;
      }
    }
    while ((localRect.width() > paramTextWMElement.width) || (localRect.height() > paramTextWMElement.height))
    {
      j -= 2;
      paramPaint.setTextSize(j);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
    paramPaint.setTextSize(j);
  }
  
  private float calculateXByAlign(TextWMElement paramTextWMElement, String paramString)
  {
    if ((TextUtils.isEmpty(paramTextWMElement.alignment)) || (paramTextWMElement.alignment.equals("left"))) {}
    do
    {
      return 0.0F;
      if (paramTextWMElement.alignment.equals("center"))
      {
        localRect = new Rect();
        this.mTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
        return paramTextWMElement.width / 2 - localRect.width() / 2;
      }
    } while (!paramTextWMElement.alignment.equals("right"));
    Rect localRect = new Rect();
    this.mTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return paramTextWMElement.width - localRect.width();
  }
  
  private void drawHorizontalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    this.mTextPaint = getStyledPaint(paramTextWMElement, paramString);
    Object localObject;
    int i;
    String str;
    label92:
    label126:
    float f2;
    if (paramTextWMElement.fontSize > 0.0F)
    {
      this.mTextPaint.setTextSize(paramTextWMElement.fontSize);
      localObject = new Rect();
      i = 1;
      str = paramString;
      if (i <= paramString.length())
      {
        this.mTextPaint.getTextBounds(paramString, 0, i, (Rect)localObject);
        if (((Rect)localObject).width() < paramCanvas.getWidth()) {
          break label508;
        }
        if (i - 2 <= 0) {
          break label490;
        }
        i -= 2;
        paramString = paramString.substring(0, i);
        paramString = paramString + "...";
        i = paramString.length();
        str = paramString;
        if (i > 0)
        {
          this.mTextPaint.getTextBounds(paramString, 0, i, (Rect)localObject);
          if (((Rect)localObject).width() >= paramCanvas.getWidth()) {
            break label499;
          }
          str = paramString.substring(0, i);
        }
      }
      label168:
      paramString = this.mTextPaint.getStyle();
      i = this.mTextPaint.getColor();
      localObject = this.mTextPaint.getFontMetrics();
      if (paramTextWMElement.strokeSize > 0.0F)
      {
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setColor(Color.parseColor(paramTextWMElement.strokeColor));
        this.mTextPaint.setStrokeWidth(paramTextWMElement.strokeSize);
        f2 = calculateXByAlign(paramTextWMElement, str);
        f1 = paramTextWMElement.height / 2;
        f3 = ((Paint.FontMetrics)localObject).descent;
        f4 = (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F;
        paramCanvas.drawText(str, 0, str.length(), f2, f1 - f3 + f4, this.mTextPaint);
        if ((((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F <= paramTextWMElement.height / 2) {
          break label533;
        }
        f1 = 0.0F;
        label331:
        setTextRect(paramTextWMElement, f2, f1, str);
      }
      localObject = this.mTextPaint.getFontMetrics();
      this.mTextPaint.setStyle(paramString);
      this.mTextPaint.setColor(i);
      this.mTextPaint.setStrokeWidth(0.0F);
      f2 = calculateXByAlign(paramTextWMElement, str);
      f1 = paramTextWMElement.height / 2;
      float f3 = ((Paint.FontMetrics)localObject).descent;
      float f4 = (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F;
      paramCanvas.drawText(str, 0, str.length(), f2, f1 - f3 + f4, this.mTextPaint);
      if (paramTextWMElement.strokeSize <= 0.0F) {
        if ((((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F <= paramTextWMElement.height / 2) {
          break label559;
        }
      }
    }
    label533:
    label559:
    for (float f1 = 0.0F;; f1 = paramTextWMElement.height / 2 - (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F)
    {
      setTextRect(paramTextWMElement, f2, f1, str);
      return;
      label490:
      i -= 1;
      break label92;
      label499:
      i -= 1;
      break label126;
      label508:
      i += 1;
      break;
      adjustTextSize(paramTextWMElement, this.mTextPaint, paramString);
      str = paramString;
      break label168;
      f1 = paramTextWMElement.height / 2 - (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F;
      break label331;
    }
  }
  
  private void drawNormalVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    this.mTextPaint = getStyledPaint(paramTextWMElement, paramString);
    Paint.Style localStyle = this.mTextPaint.getStyle();
    int i = this.mTextPaint.getColor();
    if (paramTextWMElement.strokeSize > 0.0F)
    {
      this.mTextPaint.setStyle(Paint.Style.STROKE);
      this.mTextPaint.setColor(Color.parseColor(paramTextWMElement.strokeColor));
      this.mTextPaint.setStrokeWidth(paramTextWMElement.strokeSize);
    }
    paramTextWMElement = new TextVerticalLayout(paramString, this.mTextPaint, paramTextWMElement, getAlign(paramTextWMElement));
    paramTextWMElement.draw(paramCanvas);
    this.mTextPaint.setStyle(localStyle);
    this.mTextPaint.setColor(i);
    this.mTextPaint.setStrokeWidth(0.0F);
    paramTextWMElement.draw(paramCanvas);
  }
  
  private void drawRotatedVerticalText(TextWMElement paramTextWMElement, String paramString)
  {
    swapWidthHeight(paramTextWMElement);
    Bitmap localBitmap = Bitmap.createBitmap(paramTextWMElement.width, paramTextWMElement.height, Bitmap.Config.ARGB_8888);
    drawHorizontalText(paramTextWMElement, new Canvas(localBitmap), paramString);
    swapWidthHeight(paramTextWMElement);
    if ((paramTextWMElement.bitmap != null) && (!paramTextWMElement.bitmap.isRecycled())) {
      paramTextWMElement.bitmap.recycle();
    }
    paramTextWMElement.bitmap = rotateBitmap(localBitmap, paramTextWMElement.rotate);
  }
  
  private void drawVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    if ((paramTextWMElement.rotate == 90) || (paramTextWMElement.rotate == -90))
    {
      drawRotatedVerticalText(paramTextWMElement, paramString);
      return;
    }
    drawNormalVerticalText(paramTextWMElement, paramCanvas, paramString);
  }
  
  private Layout.Alignment getAlign(TextWMElement paramTextWMElement)
  {
    Layout.Alignment localAlignment2 = Layout.Alignment.ALIGN_NORMAL;
    Layout.Alignment localAlignment1 = localAlignment2;
    if (!TextUtils.isEmpty(paramTextWMElement.alignment))
    {
      if (!paramTextWMElement.alignment.equals("center")) {
        break label34;
      }
      localAlignment1 = Layout.Alignment.ALIGN_CENTER;
    }
    label34:
    do
    {
      return localAlignment1;
      localAlignment1 = localAlignment2;
    } while (!paramTextWMElement.alignment.equals("down"));
    return Layout.Alignment.ALIGN_OPPOSITE;
  }
  
  private TextPaint getStyledPaint(TextWMElement paramTextWMElement, String paramString)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    if (!TextUtils.isEmpty(paramTextWMElement.fontName)) {}
    try
    {
      if (paramTextWMElement.fontName.equals("sans_serif")) {
        localTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
      }
      for (;;)
      {
        if (paramTextWMElement.fontSize <= 0.0F) {
          break label269;
        }
        localTextPaint.setTextSize(paramTextWMElement.fontSize);
        localTextPaint.setFakeBoldText(paramTextWMElement.fontBold);
        if (!paramTextWMElement.fontItalics) {
          break label280;
        }
        f = 0.5F;
        localTextPaint.setTextSkewX(f);
        if (paramTextWMElement.shadowSize > 0.0F) {
          localTextPaint.setShadowLayer(paramTextWMElement.shadowSize, paramTextWMElement.shadowDx, paramTextWMElement.shadowDy, Color.parseColor(paramTextWMElement.shadowColor));
        }
        localTextPaint.setColor(Color.parseColor(paramTextWMElement.color));
        return localTextPaint;
        if (!paramTextWMElement.fontName.equals("serif")) {
          break;
        }
        localTextPaint.setTypeface(Typeface.create(Typeface.SERIF, 0));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f;
        LogUtil.e(TAG, localException.getMessage());
        continue;
        if (paramTextWMElement.fontName.equals("monospace"))
        {
          localTextPaint.setTypeface(Typeface.create(Typeface.MONOSPACE, 0));
        }
        else
        {
          String str = "fonts/" + paramTextWMElement.fontName + ".ttf";
          localTextPaint.setTypeface(Typeface.createFromAsset(VideoGlobalContext.getContext().getAssets(), str));
          continue;
          label269:
          adjustTextSize(paramTextWMElement, localTextPaint, paramString);
          continue;
          label280:
          f = 0.0F;
        }
      }
    }
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
    } while (localBitmap.equals(paramBitmap));
    paramBitmap.recycle();
    return localBitmap;
  }
  
  private void swapWidthHeight(WMElement paramWMElement)
  {
    int i = paramWMElement.width;
    paramWMElement.width = paramWMElement.height;
    paramWMElement.height = i;
  }
  
  public void drawTextToBitmap(TextWMElement paramTextWMElement, String paramString)
  {
    if ((paramTextWMElement.bitmap == null) || (paramTextWMElement.bitmap.isRecycled())) {
      return;
    }
    paramTextWMElement.bitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(paramTextWMElement.bitmap);
    if (!paramTextWMElement.vertical)
    {
      drawHorizontalText(paramTextWMElement, localCanvas, paramString);
      return;
    }
    drawVerticalText(paramTextWMElement, localCanvas, paramString);
  }
  
  public void setTextRect(TextWMElement paramTextWMElement, float paramFloat1, float paramFloat2, String paramString)
  {
    if (this.mTextPaint == null) {
      return;
    }
    Rect localRect = new Rect();
    this.mTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramTextWMElement.mTextRect.left = paramFloat1;
    paramTextWMElement.mTextRect.top = paramFloat2;
    paramTextWMElement.mTextRect.right = (localRect.width() + paramFloat1);
    paramTextWMElement.mTextRect.bottom = (localRect.height() + paramFloat2);
  }
  
  private class TextVerticalLayout
  {
    private Layout.Alignment mAlign;
    private TextPaint mPaint;
    private String mSource;
    private int mTextSize;
    private WMElement mWMElement;
    
    public TextVerticalLayout(String paramString, TextPaint paramTextPaint, WMElement paramWMElement, Layout.Alignment paramAlignment)
    {
      this.mSource = paramString;
      this.mPaint = paramTextPaint;
      this.mWMElement = paramWMElement;
      this.mAlign = paramAlignment;
    }
    
    public void draw(Canvas paramCanvas)
    {
      Paint.FontMetricsInt localFontMetricsInt = this.mPaint.getFontMetricsInt();
      int i = 0;
      int k = 0;
      int j = 0;
      int m = 0;
      Object localObject;
      int n;
      label146:
      int i1;
      if (this.mWMElement.fontSize > 0.0F)
      {
        this.mTextSize = ((int)this.mWMElement.fontSize);
        this.mPaint.setTextSize(this.mTextSize);
        localObject = localFontMetricsInt;
        j = m;
        i = k;
        if (this.mWMElement.rotate != 90)
        {
          if (this.mWMElement.rotate == -90)
          {
            i = k;
            j = m;
            localObject = localFontMetricsInt;
          }
        }
        else
        {
          n = this.mWMElement.width / 2;
          if (!Layout.Alignment.ALIGN_CENTER.equals(this.mAlign)) {
            break label561;
          }
          m = (this.mWMElement.height + ((Paint.FontMetricsInt)localObject).ascent - (j - 1) * i) / 2;
          i1 = Math.min(j, this.mSource.length());
          if (!Layout.Alignment.ALIGN_CENTER.equals(this.mAlign)) {
            break label609;
          }
          k = m + (j - i1) * i / 2;
        }
      }
      for (;;)
      {
        this.mPaint.setTextSize(this.mTextSize);
        paramCanvas.save();
        j = 0;
        while (j < this.mSource.length())
        {
          localObject = this.mSource.substring(j, j + 1);
          paramCanvas.rotate(this.mWMElement.rotate, n, k);
          paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), n, k, this.mPaint);
          paramCanvas.rotate(-this.mWMElement.rotate, n, k);
          k += i;
          j += 1;
        }
        localFontMetricsInt = this.mPaint.getFontMetricsInt();
        k = localFontMetricsInt.bottom - localFontMetricsInt.top;
        m = (int)Math.floor((this.mWMElement.height - (localFontMetricsInt.bottom - localFontMetricsInt.top)) / k) + 1;
        if (m <= 0) {
          return;
        }
        localObject = localFontMetricsInt;
        j = m;
        i = k;
        if (m >= this.mSource.length()) {
          break;
        }
        this.mSource = this.mSource.substring(0, m - 3);
        this.mSource += "  .    .    .";
        localObject = localFontMetricsInt;
        j = m;
        i = k;
        break;
        this.mTextSize = (this.mWMElement.height / this.mSource.length() * 2);
        localObject = localFontMetricsInt;
        label461:
        if (this.mTextSize > 0)
        {
          this.mPaint.setTextSize(this.mTextSize);
          localObject = this.mPaint.getFontMetricsInt();
          i = ((Paint.FontMetricsInt)localObject).descent - ((Paint.FontMetricsInt)localObject).ascent;
          j = (int)Math.floor((this.mWMElement.height - (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top)) / i) + 1;
          if (j > 0) {
            break label547;
          }
        }
        label547:
        while (this.mSource.length() != j)
        {
          this.mTextSize -= 1;
          break label461;
          break;
        }
        break;
        label561:
        if (Layout.Alignment.ALIGN_OPPOSITE.equals(this.mAlign))
        {
          m = this.mWMElement.height + ((Paint.FontMetricsInt)localObject).ascent - (j - 1) * i;
          break label146;
        }
        m = -((Paint.FontMetricsInt)localObject).ascent;
        break label146;
        label609:
        k = m;
        if (Layout.Alignment.ALIGN_OPPOSITE.equals(this.mAlign)) {
          k = m + (j - i1) * i;
        }
      }
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer
 * JD-Core Version:    0.7.0.1
 */