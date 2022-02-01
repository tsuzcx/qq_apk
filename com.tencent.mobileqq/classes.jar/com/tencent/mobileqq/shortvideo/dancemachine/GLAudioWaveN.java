package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import java.util.Random;

public class GLAudioWaveN
  extends GLImageView
{
  public static final int NUM_OF_COLUMN = 5;
  public static final int WAVE_COLUMN = 15;
  private float extraSizeH;
  private float extraSizeV;
  private float mHeightBlock;
  private Random mRandom = new Random();
  private RectF mSoundRegion;
  private float mTotalHeight;
  private float[] mWaveColumn = new float[15];
  private RectF mWaveRegion;
  private float mWidthBlock;
  private float spacing = DisplayUtils.pixelToRealPixel(2.0F);
  
  public GLAudioWaveN(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    float f1 = this.mWaveColumn.length - 1;
    float f2 = this.spacing;
    this.extraSizeH = (f1 * f2);
    this.extraSizeV = (f2 * 4.0F);
    this.mWaveRegion = new RectF();
    this.mSoundRegion = new RectF();
  }
  
  private void computeBlockSize()
  {
    int i = this.mBackGround.getWidth();
    int j = this.mBackGround.getHeight();
    this.mWidthBlock = ((this.mWaveRegion.width() - this.extraSizeH) / this.mWaveColumn.length);
    float f1 = j * 1.0F / i;
    float f2 = this.mWidthBlock;
    this.mHeightBlock = Math.min((this.mWaveRegion.height() - this.extraSizeV) / 5.0F, f1 * f2);
    this.mTotalHeight = (this.mHeightBlock * 5.0F + this.extraSizeV);
  }
  
  private void drawColumn(float paramFloat1, float paramFloat2)
  {
    float f1 = this.mWaveRegion.bottom;
    float f2 = (int)paramFloat2;
    float f3 = this.mHeightBlock;
    float f4 = this.spacing;
    this.mSoundRegion.set(paramFloat1, f1 - ((f4 + f3) * f2 + (paramFloat2 - f2) * f3), this.mWidthBlock + paramFloat1, f1);
    super.setImageClipDrawRegion(this.mSoundRegion);
    this.mSoundRegion.set(paramFloat1, f1 - this.mTotalHeight, this.mWidthBlock + paramFloat1, f1);
    super.setImageRegion(this.mSoundRegion);
    this.mEnableClip = true;
    super.draw();
  }
  
  private void generateWaveColumnValue()
  {
    int i = 0;
    while (i < this.mWaveColumn.length)
    {
      this.mRandom.setSeed(System.nanoTime());
      this.mWaveColumn[i] = (this.mRandom.nextFloat() * 5.0F);
      i += 1;
    }
  }
  
  public void draw()
  {
    generateWaveColumnValue();
    float f = this.mWaveRegion.left;
    float[] arrayOfFloat = this.mWaveColumn;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      drawColumn(f, arrayOfFloat[i]);
      f += this.spacing + this.mWidthBlock;
      i += 1;
    }
  }
  
  public void setWaveRegion(RectF paramRectF)
  {
    this.mWaveRegion.set(paramRectF);
    computeBlockSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLAudioWaveN
 * JD-Core Version:    0.7.0.1
 */