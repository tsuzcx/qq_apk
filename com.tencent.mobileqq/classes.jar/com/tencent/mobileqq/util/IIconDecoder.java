package com.tencent.mobileqq.util;

import android.graphics.Bitmap;

public abstract interface IIconDecoder
{
  public abstract Bitmap a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(IIconDecoder.IIconListener paramIIconListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.IIconDecoder
 * JD-Core Version:    0.7.0.1
 */