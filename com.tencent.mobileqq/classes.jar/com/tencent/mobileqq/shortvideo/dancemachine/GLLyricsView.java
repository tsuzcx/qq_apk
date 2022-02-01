package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;

public class GLLyricsView
  extends GLImageView
{
  private Bitmap mBitmap;
  private Canvas mCanvas;
  private boolean mNeedDrawText;
  private Paint mShadowPaint;
  private Paint mStrokePaint;
  private Paint mTextPaint = new Paint();
  private int textColor;
  private int textShadowPadding = 0;
  private int textSize = 0;
  private String textString;
  private float totalWidth = 0.0F;
  
  public GLLyricsView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    initView(4);
  }
  
  public void clearTextCache()
  {
    this.textString = null;
    this.totalWidth = 0.0F;
  }
  
  public void draw()
  {
    if (this.mNeedDrawText) {
      drawText();
    }
    super.draw();
  }
  
  public void drawText()
  {
    this.mBitmap = Bitmap.createBitmap((int)(getTextWidth() + this.textShadowPadding), this.textSize + this.textShadowPadding, Bitmap.Config.ARGB_8888);
    this.mCanvas = new Canvas(this.mBitmap);
    this.mTextPaint.setTextSize(this.textSize);
    this.mTextPaint.setColor(this.textColor);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setFakeBoldText(true);
    this.mTextPaint.setDither(true);
    float f = Math.abs(this.mTextPaint.getFontMetrics().ascent) + this.textShadowPadding / 2;
    if (this.mStrokePaint == null)
    {
      this.mStrokePaint = new TextPaint();
      this.mStrokePaint.setTextSize(this.textSize);
      this.mStrokePaint.setFakeBoldText(true);
      this.mStrokePaint.setAntiAlias(true);
      this.mStrokePaint.setColor(-12779354);
      this.mStrokePaint.setStrokeWidth(15.0F);
      this.mStrokePaint.setStyle(Paint.Style.STROKE);
      this.mStrokePaint.setStrokeJoin(Paint.Join.ROUND);
      this.mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
    }
    if (this.mShadowPaint == null)
    {
      this.mShadowPaint = new TextPaint();
      this.mShadowPaint.setTextSize(this.textSize);
      this.mShadowPaint.setFakeBoldText(true);
      this.mShadowPaint.setAntiAlias(true);
      this.mShadowPaint.setStrokeWidth(30.0F);
      this.mShadowPaint.setColor(-9636865);
      this.mShadowPaint.setStyle(Paint.Style.STROKE);
      this.mShadowPaint.setStrokeJoin(Paint.Join.ROUND);
      this.mShadowPaint.setStrokeCap(Paint.Cap.ROUND);
      this.mShadowPaint.setShadowLayer(20.0F, 0.0F, 0.0F, -9636865);
    }
    this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, f, this.mShadowPaint);
    this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, f, this.mStrokePaint);
    this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, f, this.mTextPaint);
    super.setImageBitmap(this.mBitmap);
    this.mNeedDrawText = false;
  }
  
  public int getShadowPadding()
  {
    return this.textShadowPadding;
  }
  
  public int getTextHeight()
  {
    return this.textSize;
  }
  
  public float getTextWidth()
  {
    if (this.totalWidth == 0.0F)
    {
      this.mTextPaint.setTextSize(this.textSize);
      this.totalWidth = this.mTextPaint.measureText(this.textString);
    }
    return this.totalWidth;
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {}
  
  public void setImageRes(String paramString) {}
  
  public void setShadowPadding(int paramInt)
  {
    this.textShadowPadding = paramInt;
  }
  
  public void setText(String paramString, int paramInt)
  {
    this.textString = paramString;
    this.textColor = paramInt;
    this.mNeedDrawText = true;
  }
  
  public void setTextSize(int paramInt)
  {
    this.textSize = paramInt;
  }
  
  public void setmStrokePaint(Paint paramPaint1, Paint paramPaint2)
  {
    this.mStrokePaint = paramPaint1;
    this.mShadowPaint = paramPaint2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsView
 * JD-Core Version:    0.7.0.1
 */