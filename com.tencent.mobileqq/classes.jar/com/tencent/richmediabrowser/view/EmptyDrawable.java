package com.tencent.richmediabrowser.view;

import android.graphics.drawable.ColorDrawable;

public class EmptyDrawable
  extends ColorDrawable
{
  private int h;
  private int w;
  
  public EmptyDrawable(int paramInt1, int paramInt2)
  {
    super(0);
    this.w = paramInt1;
    this.h = paramInt2;
  }
  
  public EmptyDrawable(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.w = paramInt2;
    this.h = paramInt3;
  }
  
  public int getIntrinsicHeight()
  {
    return this.h;
  }
  
  public int getIntrinsicWidth()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.EmptyDrawable
 * JD-Core Version:    0.7.0.1
 */