package com.tencent.mobileqq.utils.palette;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class Palette
{
  static final Palette.Filter jdField_a_of_type_ComTencentMobileqqUtilsPalettePalette$Filter = new Palette.1();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final Palette.Swatch jdField_a_of_type_ComTencentMobileqqUtilsPalettePalette$Swatch;
  private final SimpleArrayMap<Target, Palette.Swatch> jdField_a_of_type_ComTencentMobileqqUtilsPaletteSimpleArrayMap;
  private final List<Palette.Swatch> jdField_a_of_type_JavaUtilList;
  private final List<Target> b;
  
  Palette(List<Palette.Swatch> paramList, List<Target> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteSimpleArrayMap = new SimpleArrayMap();
    this.jdField_a_of_type_ComTencentMobileqqUtilsPalettePalette$Swatch = b();
  }
  
  private float a(Palette.Swatch paramSwatch, Target paramTarget)
  {
    float[] arrayOfFloat = paramSwatch.a();
    Palette.Swatch localSwatch = this.jdField_a_of_type_ComTencentMobileqqUtilsPalettePalette$Swatch;
    int i;
    if (localSwatch != null) {
      i = localSwatch.b();
    } else {
      i = 1;
    }
    float f1 = paramTarget.g();
    float f3 = 0.0F;
    if (f1 > 0.0F)
    {
      f1 = paramTarget.g();
      f1 = (1.0F - Math.abs(arrayOfFloat[1] - paramTarget.b())) * f1;
    }
    else
    {
      f1 = 0.0F;
    }
    float f2;
    if (paramTarget.h() > 0.0F) {
      f2 = paramTarget.h() * (1.0F - Math.abs(arrayOfFloat[2] - paramTarget.e()));
    } else {
      f2 = 0.0F;
    }
    if (paramTarget.i() > 0.0F) {
      f3 = paramTarget.i() * (paramSwatch.b() / i);
    }
    return f1 + f2 + f3;
  }
  
  @NonNull
  public static Palette.Builder a(@NonNull Bitmap paramBitmap)
  {
    return new Palette.Builder(paramBitmap);
  }
  
  @Nullable
  private Palette.Swatch a(Target paramTarget)
  {
    Palette.Swatch localSwatch = b(paramTarget);
    if ((localSwatch != null) && (paramTarget.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localSwatch.a(), true);
    }
    return localSwatch;
  }
  
  private boolean a(Palette.Swatch paramSwatch, Target paramTarget)
  {
    float[] arrayOfFloat = paramSwatch.a();
    return (arrayOfFloat[1] >= paramTarget.a()) && (arrayOfFloat[1] <= paramTarget.c()) && (arrayOfFloat[2] >= paramTarget.d()) && (arrayOfFloat[2] <= paramTarget.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramSwatch.a()));
  }
  
  @Nullable
  private Palette.Swatch b()
  {
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int j = -2147483648;
    Object localObject = null;
    int i = 0;
    while (i < m)
    {
      Palette.Swatch localSwatch = (Palette.Swatch)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localSwatch.b() > j)
      {
        k = localSwatch.b();
        localObject = localSwatch;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  @Nullable
  private Palette.Swatch b(Target paramTarget)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    float f1 = 0.0F;
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Palette.Swatch localSwatch = (Palette.Swatch)this.jdField_a_of_type_JavaUtilList.get(i);
      float f2 = f1;
      Object localObject2 = localObject1;
      if (a(localSwatch, paramTarget))
      {
        float f3 = a(localSwatch, paramTarget);
        if (localObject1 != null)
        {
          f2 = f1;
          localObject2 = localObject1;
          if (f3 <= f1) {}
        }
        else
        {
          localObject2 = localSwatch;
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  @Nullable
  public Palette.Swatch a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilsPalettePalette$Swatch;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      Target localTarget = (Target)this.b.get(i);
      localTarget.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteSimpleArrayMap.b(localTarget, a(localTarget));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette
 * JD-Core Version:    0.7.0.1
 */