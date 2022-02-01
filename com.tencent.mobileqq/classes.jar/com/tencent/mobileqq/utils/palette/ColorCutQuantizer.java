package com.tencent.mobileqq.utils.palette;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer
{
  private static final Comparator<ColorCutQuantizer.Vbox> g = new ColorCutQuantizer.1();
  final int[] a;
  final int[] b;
  final List<Palette.Swatch> c;
  @Nullable
  final TimingLogger d = null;
  @Nullable
  final Palette.Filter[] e;
  private final float[] f = new float[3];
  
  ColorCutQuantizer(int[] paramArrayOfInt, int paramInt, @Nullable Palette.Filter[] paramArrayOfFilter)
  {
    this.e = paramArrayOfFilter;
    paramArrayOfFilter = new int[32768];
    this.b = paramArrayOfFilter;
    int n = 0;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      j = f(paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      paramArrayOfFilter[j] += 1;
      i += 1;
    }
    int j = 0;
    for (i = 0; j < paramArrayOfFilter.length; i = k)
    {
      if ((paramArrayOfFilter[j] > 0) && (e(j))) {
        paramArrayOfFilter[j] = 0;
      }
      k = i;
      if (paramArrayOfFilter[j] > 0) {
        k = i + 1;
      }
      j += 1;
    }
    paramArrayOfInt = new int[i];
    this.a = paramArrayOfInt;
    j = 0;
    int m;
    for (int k = 0; j < paramArrayOfFilter.length; k = m)
    {
      m = k;
      if (paramArrayOfFilter[j] > 0)
      {
        paramArrayOfInt[k] = j;
        m = k + 1;
      }
      j += 1;
    }
    if (i <= paramInt)
    {
      this.c = new ArrayList();
      i = paramArrayOfInt.length;
      paramInt = n;
      while (paramInt < i)
      {
        j = paramArrayOfInt[paramInt];
        this.c.add(new Palette.Swatch(g(j), paramArrayOfFilter[j]));
        paramInt += 1;
      }
    }
    this.c = d(paramInt);
  }
  
  static int a(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(b(paramInt1, 5, 8), b(paramInt2, 5, 8), b(paramInt3, 5, 8));
  }
  
  private List<Palette.Swatch> a(Collection<ColorCutQuantizer.Vbox> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Palette.Swatch localSwatch = ((ColorCutQuantizer.Vbox)paramCollection.next()).h();
      if (!a(localSwatch)) {
        localArrayList.add(localSwatch);
      }
    }
    return localArrayList;
  }
  
  private void a(PriorityQueue<ColorCutQuantizer.Vbox> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      ColorCutQuantizer.Vbox localVbox = (ColorCutQuantizer.Vbox)paramPriorityQueue.poll();
      if ((localVbox == null) || (!localVbox.b())) {
        break;
      }
      paramPriorityQueue.offer(localVbox.e());
      paramPriorityQueue.offer(localVbox);
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -3)
    {
      int i = paramInt2;
      int j;
      if (paramInt1 != -2)
      {
        if (paramInt1 != -1) {
          return;
        }
        while (paramInt2 <= paramInt3)
        {
          paramInt1 = paramArrayOfInt[paramInt2];
          i = c(paramInt1);
          j = b(paramInt1);
          paramArrayOfInt[paramInt2] = (a(paramInt1) | i << 10 | j << 5);
          paramInt2 += 1;
        }
      }
      while (i <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[i];
        paramInt2 = b(paramInt1);
        j = a(paramInt1);
        paramArrayOfInt[i] = (c(paramInt1) | paramInt2 << 10 | j << 5);
        i += 1;
      }
    }
  }
  
  private boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    Palette.Filter[] arrayOfFilter = this.e;
    if ((arrayOfFilter != null) && (arrayOfFilter.length > 0))
    {
      int j = arrayOfFilter.length;
      int i = 0;
      while (i < j)
      {
        if (!this.e[i].a(paramInt, paramArrayOfFloat)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean a(Palette.Swatch paramSwatch)
  {
    return a(paramSwatch.a(), paramSwatch.b());
  }
  
  static int b(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    } else {
      paramInt1 >>= paramInt2 - paramInt3;
    }
    return paramInt1 & (1 << paramInt3) - 1;
  }
  
  static int c(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private List<Palette.Swatch> d(int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(paramInt, g);
    localPriorityQueue.offer(new ColorCutQuantizer.Vbox(this, 0, this.a.length - 1));
    a(localPriorityQueue, paramInt);
    return a(localPriorityQueue);
  }
  
  private boolean e(int paramInt)
  {
    paramInt = g(paramInt);
    ColorUtils.a(paramInt, this.f);
    return a(paramInt, this.f);
  }
  
  private static int f(int paramInt)
  {
    int i = b(Color.red(paramInt), 8, 5);
    int j = b(Color.green(paramInt), 8, 5);
    return b(Color.blue(paramInt), 8, 5) | i << 10 | j << 5;
  }
  
  private static int g(int paramInt)
  {
    return a(a(paramInt), b(paramInt), c(paramInt));
  }
  
  List<Palette.Swatch> a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorCutQuantizer
 * JD-Core Version:    0.7.0.1
 */