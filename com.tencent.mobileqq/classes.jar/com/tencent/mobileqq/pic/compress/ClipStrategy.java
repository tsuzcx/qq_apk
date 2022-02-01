package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.pic.Logger;

public class ClipStrategy
{
  float a;
  int b;
  int c;
  boolean d;
  int e;
  boolean f = false;
  boolean g = false;
  
  public ClipStrategy(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = (this.b / this.c);
    this.e = paramInt3;
    if ((paramInt3 != 0) && (paramInt3 % 90 == 0)) {
      this.d = true;
    }
  }
  
  private Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap = paramBitmap;
    if (this.d) {
      localMatrix.postRotate(this.e, k >> 1, m >> 1);
    }
    for (;;)
    {
      try
      {
        if (k <= paramBitmap.getWidth()) {
          break label262;
        }
        paramInt1 = paramBitmap.getWidth();
        if (m <= paramBitmap.getHeight()) {
          break label268;
        }
        i = paramBitmap.getHeight();
        localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, i, localMatrix, true);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramBitmap.recycle();
        localOutOfMemoryError.printStackTrace();
        a("keepShortSideAndClipLongSide rotate", "cut createBitmap OutOfMemoryError");
        return null;
      }
      this.f = true;
      int j = (int)(paramInt2 * this.a);
      paramInt1 = j;
      int i = paramInt2;
      if (k > m)
      {
        paramInt1 = paramInt2;
        i = j;
      }
      paramInt2 = paramInt1;
      j = i;
      try
      {
        if (this.e / 90 % 2 != 0)
        {
          paramInt2 = i;
          j = paramInt1;
        }
        paramInt1 = j;
        if (j > localOutOfMemoryError.getWidth()) {
          paramInt1 = localOutOfMemoryError.getWidth();
        }
        i = paramInt2;
        if (paramInt2 > localOutOfMemoryError.getHeight()) {
          i = localOutOfMemoryError.getHeight();
        }
        paramBitmap = Bitmap.createBitmap(localOutOfMemoryError, 0, 0, paramInt1, i);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        if (!localOutOfMemoryError.isRecycled()) {
          localOutOfMemoryError.recycle();
        }
        paramBitmap.printStackTrace();
        a("keepShortSideAndClipLongSide clip", "cut createBitmap OutOfMemoryError");
        return null;
      }
      label262:
      paramInt1 = k;
      continue;
      label268:
      i = m;
    }
  }
  
  private boolean c(Bitmap paramBitmap)
  {
    if (d(paramBitmap))
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int k = this.b;
      if ((i > k) || (j > k)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean d(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = i;
    float f2 = j;
    float f3 = this.a;
    return (f1 > f2 * f3) || (f2 > f1 * f3);
  }
  
  private Bitmap e(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap1 = paramBitmap;
    Bitmap localBitmap2;
    if (this.d)
    {
      localMatrix.postRotate(this.e, j >> 1, k >> 1);
      int i = j;
      try
      {
        if (j > paramBitmap.getWidth()) {
          i = paramBitmap.getWidth();
        }
        j = k;
        if (k > paramBitmap.getHeight()) {
          j = paramBitmap.getHeight();
        }
        localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramBitmap.recycle();
        localOutOfMemoryError.printStackTrace();
        a("keepSide", "createBitmap OutOfMemoryError");
        localBitmap2 = null;
      }
    }
    return localBitmap2;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (c(paramBitmap)) {
      localBitmap = b(paramBitmap);
    }
    if (localBitmap == null) {
      return localBitmap;
    }
    int j = localBitmap.getWidth();
    int i = localBitmap.getHeight();
    int k;
    if (j > i)
    {
      k = i;
    }
    else
    {
      k = j;
      j = i;
    }
    if (d(localBitmap)) {
      return b(localBitmap, j, k);
    }
    if (j > this.b) {
      return a(localBitmap, j, k);
    }
    return e(localBitmap);
  }
  
  Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt2 = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    Object localObject = new Matrix();
    this.g = true;
    float f1 = this.b / (paramInt1 * 1.0F);
    if (this.d) {
      ((Matrix)localObject).postRotate(this.e, paramInt2 >> 1, i >> 1);
    }
    ((Matrix)localObject).postScale(f1, f1);
    paramInt1 = paramInt2;
    try
    {
      if (paramInt2 > paramBitmap.getWidth()) {
        paramInt1 = paramBitmap.getWidth();
      }
      paramInt2 = i;
      if (i > paramBitmap.getHeight()) {
        paramInt2 = paramBitmap.getHeight();
      }
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, (Matrix)localObject, true);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramBitmap.recycle();
      localOutOfMemoryError.printStackTrace();
      a("clipLongSide", "createBitmap OutOfMemoryError");
    }
    return null;
  }
  
  void a(String paramString1, String paramString2)
  {
    Logger.b("ClipStrategy", paramString1, paramString2);
  }
  
  Bitmap b(Bitmap paramBitmap)
  {
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    if (n > i1) {
      i = i1;
    } else {
      i = n;
    }
    int m = (int)(i * this.a);
    int k = i;
    int j = m;
    if (n > i1)
    {
      k = m;
      j = i;
    }
    int i = k;
    try
    {
      if (k > paramBitmap.getWidth()) {
        i = paramBitmap.getWidth();
      }
      k = j;
      if (j > paramBitmap.getHeight()) {
        k = paramBitmap.getHeight();
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, k);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramBitmap.recycle();
      localOutOfMemoryError.printStackTrace();
      a("clipBigImg", "createBitmap OutOfMemoryError");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.ClipStrategy
 * JD-Core Version:    0.7.0.1
 */