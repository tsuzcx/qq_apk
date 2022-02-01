package com.tencent.rfw.barrage.tool;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;

public class RFWBarrageDrawableCacheManager<T>
{
  private LruCache<String, T> a = new RFWBarrageDrawableCacheManager.1(this, (int)Runtime.getRuntime().maxMemory() / 32);
  
  private static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int b(T paramT)
  {
    if ((paramT instanceof Bitmap)) {
      return a((Bitmap)paramT);
    }
    if ((paramT instanceof BitmapDrawable)) {
      return a(((BitmapDrawable)paramT).getBitmap());
    }
    return 0;
  }
  
  protected int a(T paramT)
  {
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt)
  {
    try
    {
      this.a.trimToSize(paramInt);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWBarrageDrawableCacheManager
 * JD-Core Version:    0.7.0.1
 */