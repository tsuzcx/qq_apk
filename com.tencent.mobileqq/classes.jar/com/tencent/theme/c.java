package com.tencent.theme;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;

public class c
  extends SparseArray<ColorStateList>
{
  SparseArray<Integer> a;
  SparseArray<ColorStateList> b;
  SkinEngine c;
  
  public c(SkinEngine paramSkinEngine, Resources paramResources, SparseArray<ColorStateList> paramSparseArray, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramSkinEngine;
    this.b = paramSparseArray;
    this.a = new SparseArray(paramInt1 + 10);
    long l1 = SystemClock.uptimeMillis();
    paramSkinEngine = new TypedValue();
    while (paramInt2 <= paramInt3)
    {
      try
      {
        paramResources.getValue(paramInt2, paramSkinEngine, true);
        if ((paramSkinEngine.type >= 28) && (paramSkinEngine.type <= 31))
        {
          paramInt2 += 1;
          continue;
        }
        if (paramSkinEngine.string.toString().endsWith(".xml")) {
          this.a.put(paramSkinEngine.assetCookie << 24 | paramSkinEngine.data, Integer.valueOf(paramInt2));
        }
        paramInt1 = paramInt2 + 1;
      }
      catch (Resources.NotFoundException paramSparseArray)
      {
        for (;;)
        {
          paramSparseArray = paramSparseArray;
          h.a("ColorStateListPreloadIntercepter", 1, "", paramSparseArray);
          paramInt1 = paramInt2 + 1;
        }
      }
      finally {}
      paramInt2 = paramInt1;
    }
    if (SkinEngine.DEBUG)
    {
      long l2 = SystemClock.uptimeMillis();
      Log.d("SkinEngine", "int ColorStateListPreloadIntercepter cost: " + (l2 - l1));
    }
  }
  
  public ColorStateList a(int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(paramInt);
    if (localInteger == null) {
      return (ColorStateList)this.b.get(paramInt);
    }
    return this.c.b(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.c
 * JD-Core Version:    0.7.0.1
 */