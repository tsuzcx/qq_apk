package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.SystemClock;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;

@TargetApi(16)
public class b
  extends LongSparseArray
{
  LongSparseArray<Integer> a;
  LongSparseArray<ColorStateList> b;
  SkinEngine c;
  
  public b(SkinEngine paramSkinEngine, Resources paramResources, LongSparseArray paramLongSparseArray, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramSkinEngine;
    this.b = paramLongSparseArray;
    this.a = new LongSparseArray(paramInt1 + 10);
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
          this.a.put(paramSkinEngine.assetCookie << 32 | paramSkinEngine.data, Integer.valueOf(paramInt2));
        }
        paramInt1 = paramInt2 + 1;
      }
      catch (Resources.NotFoundException paramLongSparseArray)
      {
        for (;;)
        {
          paramLongSparseArray = paramLongSparseArray;
          h.a("ColorStateListPreloadIntercepter", 1, "", paramLongSparseArray);
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
  
  public Object get(long paramLong)
  {
    Integer localInteger = (Integer)this.a.get(paramLong);
    if (localInteger == null) {
      return this.b.get(paramLong);
    }
    return this.c.b(localInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.b
 * JD-Core Version:    0.7.0.1
 */