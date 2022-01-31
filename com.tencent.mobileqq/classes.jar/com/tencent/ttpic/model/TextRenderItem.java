package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.opengl.GLES20;
import android.text.TextPaint;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Random;

public class TextRenderItem
{
  private int canvasHeight;
  private int canvasWidth;
  private int itemHeight = 100;
  private int itemWidth = 300;
  private boolean positionInited = false;
  private int positionX;
  private int positionY;
  private float randomDirection;
  private RenderParam renderParam = new RenderParam();
  private int tex;
  
  private float getTextWidth(Paint paramPaint, String paramString)
  {
    float[] arrayOfFloat = new float[paramString.length()];
    paramPaint.getTextWidths(paramString, arrayOfFloat);
    float f = 0.0F;
    int i = 0;
    while (i < paramString.length())
    {
      f += arrayOfFloat[i];
      i += 1;
    }
    return f;
  }
  
  public void clear()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public void init()
  {
    this.randomDirection = (new Random().nextFloat() * 2.0F - 1.0F);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.tex = arrayOfInt[0];
    this.renderParam.texture = this.tex;
    this.renderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
  }
  
  public boolean isOutOfCanvas()
  {
    return (this.positionX + this.itemWidth / 2 < 0) || (this.positionX - this.itemWidth / 2 > this.canvasWidth) || (this.positionY + this.itemHeight / 2 < 0) || (this.positionY - this.itemHeight / 2 > this.canvasHeight);
  }
  
  public void setText(String paramString)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.itemWidth, this.itemHeight, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(60.0F);
    localTextPaint.setFakeBoldText(true);
    localTextPaint.setColor(-1);
    Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
    localCanvas.drawText(paramString, 0, paramString.length(), this.itemWidth / 2 - (int)(getTextWidth(localTextPaint, paramString) / 2.0F), this.itemHeight / 2 - localFontMetrics.descent + (localFontMetrics.descent - localFontMetrics.ascent) / 2.0F, localTextPaint);
    GlUtil.loadTexture(this.tex, localBitmap);
    localBitmap.recycle();
  }
  
  public void update()
  {
    this.positionX = ((int)(this.positionX + 5.0F * this.randomDirection));
    this.positionY -= 7;
    float f1 = this.positionX - this.itemWidth / 2;
    float f2 = this.positionY - this.itemHeight / 2;
    float f3 = this.itemWidth;
    float f4 = this.itemHeight;
    this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.canvasWidth, this.canvasHeight);
  }
  
  public void updatePosition(float paramFloat1, float paramFloat2)
  {
    this.positionX = ((int)paramFloat1);
    this.positionY = ((int)paramFloat2);
    paramFloat1 = this.positionX - this.itemWidth / 2;
    paramFloat2 = this.positionY - this.itemHeight / 2;
    float f1 = this.itemWidth;
    float f2 = this.itemHeight;
    this.renderParam.position = AlgoUtils.calPositionsTriangles(paramFloat1, f2 + paramFloat2, paramFloat1 + f1, paramFloat2, this.canvasWidth, this.canvasHeight);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.canvasWidth = paramInt1;
    this.canvasHeight = paramInt2;
    if (!this.positionInited)
    {
      this.positionX = (this.canvasWidth / 2);
      this.positionY = this.canvasHeight;
      this.positionInited = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.TextRenderItem
 * JD-Core Version:    0.7.0.1
 */