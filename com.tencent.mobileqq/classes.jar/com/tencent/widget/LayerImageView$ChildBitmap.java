package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

class LayerImageView$ChildBitmap
{
  private Bitmap a;
  private Rect b;
  private int c;
  private int d;
  private int e;
  private Bitmap.Config f;
  
  private LayerImageView$ChildBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.a = paramBitmap;
    this.b = new Rect(0, 0, 0, 0);
    if (paramBitmap != null)
    {
      this.d = paramBitmap.getScaledWidth(paramInt);
      this.e = paramBitmap.getScaledHeight(paramInt);
      this.c = 0;
      this.f = paramBitmap.getConfig();
      return;
    }
    this.c = 4;
  }
  
  private void a(Rect paramRect)
  {
    this.b.set(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.LayerImageView.ChildBitmap
 * JD-Core Version:    0.7.0.1
 */