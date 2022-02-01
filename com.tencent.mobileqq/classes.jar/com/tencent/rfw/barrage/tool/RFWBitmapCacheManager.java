package com.tencent.rfw.barrage.tool;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWQQUtils;
import java.util.Iterator;
import java.util.LinkedList;

public class RFWBitmapCacheManager
{
  private final LinkedList<Bitmap> a = new LinkedList();
  private final int b;
  private int c;
  private int d;
  private int e;
  
  public RFWBitmapCacheManager()
  {
    DisplayMetrics localDisplayMetrics = RFWQQUtils.a().getDisplayMetrics();
    this.b = (localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels * 8);
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.a.remove(paramBitmap);
    if (paramBitmap != null)
    {
      this.c -= paramBitmap.getRowBytes() * paramBitmap.getHeight();
      if ((!paramBitmap.isRecycled()) && (!b())) {
        paramBitmap.recycle();
      }
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    this.d += 1;
    Iterator localIterator = this.a.iterator();
    label21:
    Bitmap localBitmap;
    for (Object localObject = null; localIterator.hasNext(); localObject = localBitmap)
    {
      localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap.getWidth() < paramInt1) || (localBitmap.getHeight() < paramInt2) || ((localObject != null) && (localObject.getHeight() * localObject.getWidth() < localBitmap.getHeight() * localBitmap.getWidth()))) {
        break label21;
      }
    }
    if (localObject != null)
    {
      this.a.remove(localObject);
      this.c -= localObject.getRowBytes() * localObject.getHeight();
      return localObject;
    }
    try
    {
      this.e += 1;
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      RFWBarrageLogger.a("RFWBitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
    }
    return localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!b())) {
        localBitmap.recycle();
      }
    }
    this.a.clear();
    this.c = 0;
    this.d = 0;
    this.e = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.c += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      this.a.addLast(paramBitmap);
      while (this.c > this.b)
      {
        paramBitmap = null;
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          if ((paramBitmap == null) || (paramBitmap.getHeight() * paramBitmap.getWidth() >= localBitmap.getHeight() * localBitmap.getWidth())) {
            paramBitmap = localBitmap;
          }
        }
        if (paramBitmap != null) {
          b(paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWBitmapCacheManager
 * JD-Core Version:    0.7.0.1
 */