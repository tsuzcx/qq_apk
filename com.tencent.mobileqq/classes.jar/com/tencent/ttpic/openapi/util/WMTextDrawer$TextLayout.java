package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.util.WMTokenizer;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Map;

public abstract class WMTextDrawer$TextLayout
{
  protected TextPaint mOuterStrokePaint;
  protected TextPaint mPaint;
  protected TextPaint mStrokePaint;
  protected String mText;
  protected TextWMElement mWMElement;
  protected WMTokenizer mWMTokenizer;
  
  protected WMTextDrawer$TextLayout(TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
  {
    this.mText = paramString;
    this.mWMElement = paramTextWMElement;
    this.mPaint = genPaint(this.mWMElement);
    paramTextWMElement = WMTokenizer.from(this.mText, this.mPaint).setWidth(paramInt1).setHeight(paramInt2).setAlign(this.mWMElement.alignment);
    if (!this.mWMElement.multiRow)
    {
      bool1 = true;
      paramTextWMElement = paramTextWMElement.setSingleLine(bool1).setSpacingPlus(this.mWMElement.kern);
      if (this.mWMElement.vertical != 1) {
        break label141;
      }
    }
    label141:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mWMTokenizer = paramTextWMElement.setVertical(bool1);
      adjustPaintIfNeed();
      this.mWMTokenizer.tokenizer();
      this.mWMTokenizer.doLayout();
      return;
      bool1 = false;
      break;
    }
  }
  
  private void adjustPaintIfNeed()
  {
    if (this.mWMElement.fontFit == 1)
    {
      fontKernCompat();
      this.mWMTokenizer.tokenizer();
      if (!this.mWMTokenizer.isFitIn()) {
        break label377;
      }
      while (this.mWMTokenizer.isFitIn())
      {
        this.mPaint.setTextSize(this.mPaint.getTextSize() + 4.0F);
        fontKernCompat();
        this.mWMTokenizer.tokenizer();
      }
      this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0F);
      fontKernCompat();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.mWMElement.fontName)) && (this.mWMElement.fontName.equals("axis")) && (this.mPaint.getTextSize() - 30.0F > 0.0F)) {
        this.mPaint.setTextSize(this.mPaint.getTextSize() - 30.0F);
      }
      if ((!TextUtils.isEmpty(this.mWMElement.fontName)) && (this.mWMElement.fontName.equals("happytime")) && (this.mPaint.getTextSize() - 20.0F > 0.0F)) {
        this.mPaint.setTextSize(this.mPaint.getTextSize() - 20.0F);
      }
      if (this.mWMElement.strokeSize > 0.0F)
      {
        this.mStrokePaint = new TextPaint(this.mPaint);
        this.mStrokePaint.setShader(null);
        this.mStrokePaint.setMaskFilter(null);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setColor(Color.parseColor(this.mWMElement.strokeColor));
        this.mStrokePaint.setStrokeWidth(this.mWMElement.strokeSize * (this.mPaint.getTextSize() / 20.0F) * 1.2F);
      }
      if (this.mWMElement.outerStrokeSize > 0.0F)
      {
        this.mOuterStrokePaint = new TextPaint(this.mPaint);
        this.mOuterStrokePaint.setShader(null);
        this.mOuterStrokePaint.setMaskFilter(null);
        this.mOuterStrokePaint.setColor(Color.parseColor(this.mWMElement.outerStrokeColor));
      }
      return;
      label377:
      while (!this.mWMTokenizer.isFitIn())
      {
        this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0F);
        fontKernCompat();
        this.mWMTokenizer.tokenizer();
      }
      fontKernCompat();
    }
  }
  
  private TextPaint genPaint(TextWMElement paramTextWMElement)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    if (!TextUtils.isEmpty(paramTextWMElement.fontName)) {}
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = (Typeface)WMTextDrawer.access$300().get(paramTextWMElement.fontName);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (!paramTextWMElement.fontName.equals("sans_serif")) {
              continue;
            }
            if (!WMTextDrawer.access$300().containsKey(paramTextWMElement.fontName)) {
              continue;
            }
            localObject1 = (Typeface)WMTextDrawer.access$300().get(paramTextWMElement.fontName);
          }
          localObject2 = localObject1;
          if (!paramTextWMElement.isLocalFont)
          {
            File localFile = new File(paramTextWMElement.fontName);
            localObject2 = localObject1;
            if (localFile != null)
            {
              localObject2 = localObject1;
              if (localFile.exists()) {
                localObject2 = Typeface.createFromFile(localFile);
              }
            }
          }
          if (localObject2 != null)
          {
            localTextPaint.setTypeface((Typeface)localObject2);
            if (!WMTextDrawer.access$300().containsKey(paramTextWMElement.fontName)) {
              WMTextDrawer.access$300().put(paramTextWMElement.fontName, localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          Object localObject1;
          float f2;
          LogUtils.e(WMTextDrawer.access$400(), localException.getMessage());
          continue;
          float f1 = 40.0F;
          continue;
          f1 = 0.0F;
          continue;
        }
        if (paramTextWMElement.fontSize <= 0.0F) {
          continue;
        }
        f1 = paramTextWMElement.fontSize;
        f2 = f1;
        if (f1 < 4.0F) {
          f2 = f1 + 20.0F;
        }
        localTextPaint.setTextSize(f2);
        if (!TextUtils.isEmpty(paramTextWMElement.shaderBmp))
        {
          localObject1 = paramTextWMElement.shaderBmp.replace("%d", String.valueOf(paramTextWMElement.getFrameIndex()));
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(paramTextWMElement.curShaderBmp)) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().loadImage(paramTextWMElement.itemId, (String)localObject1)))) {
            paramTextWMElement.curShaderBmp = ((String)localObject1);
          }
          localObject1 = VideoMemoryManager.getInstance().loadImage(paramTextWMElement.itemId, paramTextWMElement.curShaderBmp);
          if (BitmapUtils.isLegal((Bitmap)localObject1)) {
            localTextPaint.setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
          }
        }
        localTextPaint.setFakeBoldText(paramTextWMElement.fontBold);
        if (!paramTextWMElement.fontItalics) {
          continue;
        }
        f1 = -0.2F;
        localTextPaint.setTextSkewX(f1);
        localTextPaint.setColor(Color.parseColor(paramTextWMElement.color));
        return localTextPaint;
        localObject1 = Typeface.create(Typeface.SANS_SERIF, 0);
        continue;
        if (paramTextWMElement.fontName.equals("serif"))
        {
          localObject1 = Typeface.create(Typeface.SERIF, 0);
        }
        else
        {
          if (!paramTextWMElement.fontName.equals("monospace")) {
            continue;
          }
          localObject1 = Typeface.create(Typeface.MONOSPACE, 0);
        }
      }
      localObject1 = localObject2;
    } while (!paramTextWMElement.isLocalFont);
    if (paramTextWMElement.fontName.contains(".")) {}
    for (localObject1 = "fonts/" + paramTextWMElement.fontName;; localObject1 = "fonts/" + paramTextWMElement.fontName + ".ttf")
    {
      localObject1 = Typeface.createFromAsset(AEModule.getContext().getAssets(), (String)localObject1);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap;
    Object localObject1;
    Object localObject3;
    if (!TextUtils.isEmpty(this.mWMElement.color))
    {
      localBitmap = this.mWMElement.getIdleBitmap();
      if (BitmapUtils.isLegal(localBitmap))
      {
        localObject1 = new Canvas(localBitmap);
        localObject3 = getPaint();
        if (localObject3 != null)
        {
          if (!TextUtils.isEmpty(this.mWMElement.shadowColor))
          {
            int i = ((Paint)localObject3).getColor();
            ((Paint)localObject3).setColor(Color.parseColor(this.mWMElement.shadowColor));
            draw((Canvas)localObject1, this.mWMElement.shadowDx, this.mWMElement.shadowDy);
            ((Paint)localObject3).setColor(i);
          }
          if (this.mWMElement.blurAmount > 0.0F)
          {
            localObject3 = null;
            localObject1 = localObject3;
            if (!BitmapUtils.isLegal(localBitmap)) {}
          }
        }
      }
    }
    try
    {
      localObject1 = WMTextDrawer.blurBitmap(AEModule.getContext(), localBitmap, this.mWMElement.blurAmount);
      if (BitmapUtils.isLegal((Bitmap)localObject1))
      {
        localObject3 = ByteBuffer.allocate(((Bitmap)localObject1).getRowBytes() * ((Bitmap)localObject1).getHeight());
        ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject3);
        ((Bitmap)localObject1).recycle();
        if (localObject3 != null) {
          ((ByteBuffer)localObject3).rewind();
        }
        if (BitmapUtils.isLegal(localBitmap)) {
          localBitmap.copyPixelsFromBuffer((Buffer)localObject3);
        }
      }
      drawText(paramCanvas, 0.0F, 0.0F);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        LogUtils.e(localRuntimeException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    drawText(paramCanvas, paramFloat1, paramFloat2);
  }
  
  protected void draw(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2)
  {
    if (this.mStrokePaint != null) {
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mStrokePaint);
    }
    if (this.mOuterStrokePaint != null)
    {
      float f = this.mWMElement.outerStrokeSize;
      paramCanvas.drawText(paramString, paramFloat1 - f, paramFloat2 - f, this.mOuterStrokePaint);
      paramCanvas.drawText(paramString, paramFloat1 + f, paramFloat2 - f, this.mOuterStrokePaint);
      paramCanvas.drawText(paramString, paramFloat1 + f, paramFloat2 + f, this.mOuterStrokePaint);
      paramCanvas.drawText(paramString, paramFloat1 - f, f + paramFloat2, this.mOuterStrokePaint);
    }
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mPaint);
  }
  
  protected void drawText(Canvas paramCanvas)
  {
    drawText(paramCanvas, 0.0F, 0.0F);
  }
  
  protected abstract void drawText(Canvas paramCanvas, float paramFloat1, float paramFloat2);
  
  public void fontKernCompat()
  {
    if ("HYHeiLiZhiTiJ".equals(this.mWMElement.fontName)) {
      this.mWMElement.kern = ((int)(this.mWMElement.kern * (this.mPaint.getTextSize() / 141.0F)));
    }
    this.mWMTokenizer.setSpacingPlus(this.mWMElement.kern);
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer.TextLayout
 * JD-Core Version:    0.7.0.1
 */