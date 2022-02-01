package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;

public class MTVBaseFilter$TextParam
{
  public boolean mChangeColor = false;
  public int mColor = 0;
  public boolean mDistortion = false;
  public int mGlitchID = -1;
  public RectF mRect;
  public boolean mShow = false;
  
  public MTVBaseFilter$TextParam() {}
  
  public MTVBaseFilter$TextParam(int paramInt1, boolean paramBoolean1, RectF paramRectF, boolean paramBoolean2, int paramInt2, boolean paramBoolean3)
  {
    this.mGlitchID = paramInt1;
    this.mRect = paramRectF;
    this.mChangeColor = paramBoolean2;
    this.mColor = paramInt2;
    this.mShow = paramBoolean1;
    this.mDistortion = paramBoolean3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter.TextParam
 * JD-Core Version:    0.7.0.1
 */