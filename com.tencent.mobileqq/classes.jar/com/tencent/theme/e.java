package com.tencent.theme;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;

public class e
  extends SparseArray<ColorStateList>
{
  SparseArray<Integer> a;
  SparseArray<ColorStateList> b;
  SkinEngine c;
  
  public e(SkinEngine paramSkinEngine, Resources paramResources, SparseArray<ColorStateList> paramSparseArray, int paramInt1, int paramInt2)
  {
    this.c = paramSkinEngine;
    this.b = paramSparseArray;
    this.a = new SparseArray(paramInt1 + 10);
    long l1 = SystemClock.uptimeMillis();
    paramSkinEngine = new TypedValue();
    try
    {
      for (;;)
      {
        paramResources.getValue(paramInt2, paramSkinEngine, true);
        if ((paramSkinEngine.type >= 28) && (paramSkinEngine.type <= 31))
        {
          paramInt2 += 1;
        }
        else
        {
          if (paramSkinEngine.string.toString().endsWith(".xml")) {
            this.a.put(paramSkinEngine.assetCookie << 24 | paramSkinEngine.data, Integer.valueOf(paramInt2));
          }
          paramInt2 += 1;
        }
      }
      long l2;
      return;
    }
    catch (Resources.NotFoundException paramSkinEngine)
    {
      if (SkinEngine.DEBUG)
      {
        l2 = SystemClock.uptimeMillis();
        Log.d("SkinEngine", "int ColorStateListPreloadIntercepter cost: " + (l2 - l1));
      }
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
 * Qualified Name:     com.tencent.theme.e
 * JD-Core Version:    0.7.0.1
 */