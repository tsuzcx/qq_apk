package com.tencent.mobileqq.text.style;

import android.graphics.drawable.Drawable;

public abstract interface ISmallEmojiSpan
{
  public abstract float getBottom();
  
  public abstract Drawable getDrawable();
  
  public abstract int getEId();
  
  public abstract int getEpId();
  
  public abstract float getLeft();
  
  public abstract float getRight();
  
  public abstract float getTop();
  
  public abstract void setIsAnim(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.ISmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */