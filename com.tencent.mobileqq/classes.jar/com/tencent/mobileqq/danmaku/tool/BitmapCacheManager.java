package com.tencent.mobileqq.danmaku.tool;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.Iterator;
import java.util.LinkedList;

public class BitmapCacheManager
{
  private final int jdField_a_of_type_Int;
  private final LinkedList<Bitmap> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b;
  private int c;
  private int d;
  
  public BitmapCacheManager()
  {
    DisplayMetrics localDisplayMetrics = DanmakuDependImp.a().a().a().getDisplayMetrics();
    this.jdField_a_of_type_Int = (localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels * 8);
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBitmap);
    if (paramBitmap != null)
    {
      this.b -= paramBitmap.getRowBytes() * paramBitmap.getHeight();
      if ((!paramBitmap.isRecycled()) && (!DanmakuDependImp.a().a().c())) {
        paramBitmap.recycle();
      }
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    this.c += 1;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
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
      this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject);
      this.b -= localObject.getRowBytes() * localObject.getHeight();
      return localObject;
    }
    try
    {
      this.d += 1;
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Logger.a("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
    }
    return localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!DanmakuDependImp.a().a().c())) {
        localBitmap.recycle();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.b += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramBitmap);
      while (this.b > this.jdField_a_of_type_Int)
      {
        paramBitmap = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
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
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.BitmapCacheManager
 * JD-Core Version:    0.7.0.1
 */