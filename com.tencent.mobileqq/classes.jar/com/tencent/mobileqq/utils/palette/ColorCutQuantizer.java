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
  private static final Comparator<ColorCutQuantizer.Vbox> jdField_a_of_type_JavaUtilComparator = new ColorCutQuantizer.1();
  @Nullable
  final TimingLogger jdField_a_of_type_AndroidUtilTimingLogger = null;
  final List<Palette.Swatch> jdField_a_of_type_JavaUtilList;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  final int[] jdField_a_of_type_ArrayOfInt;
  @Nullable
  final Palette.Filter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter;
  final int[] b;
  
  ColorCutQuantizer(int[] paramArrayOfInt, int paramInt, @Nullable Palette.Filter[] paramArrayOfFilter)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter = paramArrayOfFilter;
    paramArrayOfFilter = new int[32768];
    this.b = paramArrayOfFilter;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      j = d(paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      paramArrayOfFilter[j] += 1;
      i += 1;
    }
    int j = 0;
    for (i = 0; j < paramArrayOfFilter.length; i = k)
    {
      if ((paramArrayOfFilter[j] > 0) && (a(j))) {
        paramArrayOfFilter[j] = 0;
      }
      k = i;
      if (paramArrayOfFilter[j] > 0) {
        k = i + 1;
      }
      j += 1;
    }
    paramArrayOfInt = new int[i];
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
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
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      i = paramArrayOfInt.length;
      paramInt = n;
      while (paramInt < i)
      {
        j = paramArrayOfInt[paramInt];
        this.jdField_a_of_type_JavaUtilList.add(new Palette.Swatch(e(j), paramArrayOfFilter[j]));
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilList = a(paramInt);
  }
  
  static int a(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(b(paramInt1, 5, 8), b(paramInt2, 5, 8), b(paramInt3, 5, 8));
  }
  
  private List<Palette.Swatch> a(int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(paramInt, jdField_a_of_type_JavaUtilComparator);
    localPriorityQueue.offer(new ColorCutQuantizer.Vbox(this, 0, this.jdField_a_of_type_ArrayOfInt.length - 1));
    a(localPriorityQueue, paramInt);
    return a(localPriorityQueue);
  }
  
  private List<Palette.Swatch> a(Collection<ColorCutQuantizer.Vbox> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Palette.Swatch localSwatch = ((ColorCutQuantizer.Vbox)paramCollection.next()).a();
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
      if ((localVbox == null) || (!localVbox.a())) {
        break;
      }
      paramPriorityQueue.offer(localVbox.a());
      paramPriorityQueue.offer(localVbox);
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      int j;
      while (i <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[i];
        paramInt2 = b(paramInt1);
        j = a(paramInt1);
        paramArrayOfInt[i] = (c(paramInt1) | paramInt2 << 10 | j << 5);
        i += 1;
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
  }
  
  private boolean a(int paramInt)
  {
    paramInt = e(paramInt);
    ColorUtils.a(paramInt, this.jdField_a_of_type_ArrayOfFloat);
    return a(paramInt, this.jdField_a_of_type_ArrayOfFloat);
  }
  
  private boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter.length > 0)
      {
        j = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsPalettePalette$Filter[i].a(paramInt, paramArrayOfFloat)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(Palette.Swatch paramSwatch)
  {
    return a(paramSwatch.a(), paramSwatch.a());
  }
  
  static int b(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    }
    for (;;)
    {
      return paramInt1 & (1 << paramInt3) - 1;
      paramInt1 >>= paramInt2 - paramInt3;
    }
  }
  
  static int c(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private static int d(int paramInt)
  {
    return b(Color.red(paramInt), 8, 5) << 10 | b(Color.green(paramInt), 8, 5) << 5 | b(Color.blue(paramInt), 8, 5);
  }
  
  private static int e(int paramInt)
  {
    return a(a(paramInt), b(paramInt), c(paramInt));
  }
  
  List<Palette.Swatch> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorCutQuantizer
 * JD-Core Version:    0.7.0.1
 */