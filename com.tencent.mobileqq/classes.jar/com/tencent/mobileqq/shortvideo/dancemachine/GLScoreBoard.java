package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;

public class GLScoreBoard
  extends GLFrameImage
{
  public static final int MAX_SCORE = 99999;
  private float heightBoard;
  private boolean mHasComputeWidth = false;
  private int mInterval;
  private float mNumberImageSlope = 0.25F;
  private RectF mNumberRegion = new RectF();
  private float mNumberWidthSize;
  private RectF mParentSize = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private int mScore;
  private RectF mScoreBoardSize = new RectF();
  private int[] number = new int[5];
  private float widthBoard;
  private float xOffsetFromParent = 0.0F;
  private float yOffsetFromParent = 0.0F;
  
  public GLScoreBoard(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    setTemporaryRelease(false);
  }
  
  private void computeNumberWidthSize()
  {
    if (!this.mHasComputeWidth)
    {
      GLImage localGLImage = getImageByIndex(0);
      this.mNumberWidthSize = (localGLImage.getWidth() * 1.0F / localGLImage.getHeight() * this.mScoreBoardSize.height());
      this.mHasComputeWidth = true;
    }
  }
  
  private void computeOffsetFromParen()
  {
    this.xOffsetFromParent = (this.mScoreBoardSize.left - this.mParentSize.left);
    this.yOffsetFromParent = (this.mScoreBoardSize.top - this.mParentSize.top);
  }
  
  private void computeScoreNumberAndDraw()
  {
    this.mScoreBoardSize.left = (this.mParentSize.left + this.xOffsetFromParent);
    this.mScoreBoardSize.top = (this.mParentSize.top + this.yOffsetFromParent);
    Object localObject = this.mScoreBoardSize;
    ((RectF)localObject).right = (((RectF)localObject).left + this.widthBoard);
    localObject = this.mScoreBoardSize;
    ((RectF)localObject).bottom = (((RectF)localObject).top + this.heightBoard);
    localObject = this.number;
    int j = this.mScore;
    int k = j / 10000;
    int i = 4;
    localObject[4] = k;
    j %= 10000;
    localObject[3] = (j / 1000);
    j %= 1000;
    localObject[2] = (j / 100);
    j %= 100;
    localObject[1] = (j / 10);
    localObject[0] = (j % 10);
    if (localObject[4] == 0)
    {
      if (localObject[3] == 0) {
        if (localObject[2] == 0)
        {
          if (localObject[1] == 0) {
            i = 1;
          } else {
            i = 2;
          }
        }
        else {
          i = 3;
        }
      }
    }
    else {
      i = 5;
    }
    float f1 = i;
    float f2 = this.mNumberWidthSize;
    j = i - 1;
    f2 = f2 * f1 + this.mInterval * j;
    float f3;
    float f4;
    if (this.mScoreBoardSize.width() >= f2)
    {
      f1 = this.mNumberWidthSize;
      f3 = this.mScoreBoardSize.top;
      f4 = this.mScoreBoardSize.bottom;
      f2 = (this.mScoreBoardSize.width() - f2) / 2.0F + this.mScoreBoardSize.left - this.mNumberImageSlope * f1;
    }
    else
    {
      f2 = j * this.mInterval;
      float f5 = (this.mScoreBoardSize.width() - f2) / f1;
      localObject = getImageByIndex(0);
      f1 = ((GLImage)localObject).getHeight() * 1.0F / ((GLImage)localObject).getWidth() * f5;
      if (f1 >= this.mScoreBoardSize.height())
      {
        f1 = this.mScoreBoardSize.top;
        f3 = this.mScoreBoardSize.bottom;
      }
      else
      {
        f2 = (this.mScoreBoardSize.height() - f1) / 2.0F;
        f1 = this.mScoreBoardSize.top + f2;
        f3 = this.mScoreBoardSize.bottom - f2;
      }
      f2 = this.mScoreBoardSize.left;
      f4 = f3;
      f3 = f1;
      f1 = f5;
    }
    j = i;
    while (j > 0)
    {
      if (j == i) {
        k = 0;
      } else {
        k = this.mInterval;
      }
      int m = this.number[(j - 1)];
      f2 += k;
      this.mNumberRegion.set(f2, f3, f2 + f1, f4);
      super.setImageClipDrawRegion(this.mNumberRegion);
      super.setImageRegion(this.mNumberRegion);
      super.setCurrentImage(m);
      super.draw();
      f2 = this.mNumberRegion.right;
      j -= 1;
    }
  }
  
  public void changeParentSize(RectF paramRectF)
  {
    this.mParentSize.set(paramRectF);
  }
  
  public void draw()
  {
    computeNumberWidthSize();
    computeScoreNumberAndDraw();
  }
  
  public int getScore()
  {
    return this.mScore;
  }
  
  public void setNumberImageSlope(float paramFloat)
  {
    this.mNumberImageSlope = paramFloat;
  }
  
  public void setNumberInterval(int paramInt)
  {
    this.mInterval = paramInt;
  }
  
  public void setScore(int paramInt)
  {
    this.mScore = paramInt;
    if (this.mScore > 99999) {
      this.mScore = 99999;
    }
  }
  
  public void setScoreBoardSize(RectF paramRectF)
  {
    if (!this.mScoreBoardSize.equals(paramRectF))
    {
      this.mScoreBoardSize.set(paramRectF);
      this.widthBoard = this.mScoreBoardSize.width();
      this.heightBoard = this.mScoreBoardSize.height();
    }
    computeOffsetFromParen();
  }
  
  public void setScoreBoardSize(RectF paramRectF1, RectF paramRectF2)
  {
    this.mParentSize.set(paramRectF2);
    setScoreBoardSize(paramRectF1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard
 * JD-Core Version:    0.7.0.1
 */