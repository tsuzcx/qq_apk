package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.LongSparseArray;

@TargetApi(16)
class d
  extends b
{
  public d(SkinEngine paramSkinEngine, Resources paramResources, LongSparseArray paramLongSparseArray, int paramInt1, int paramInt2)
  {
    super(paramSkinEngine, paramResources, paramLongSparseArray, paramInt1, paramInt2);
  }
  
  public Object get(long paramLong)
  {
    Object localObject = (Integer)this.a.get(paramLong);
    if (localObject == null) {
      return this.b.get(paramLong);
    }
    localObject = this.c.b(((Integer)localObject).intValue());
    if (localObject != null) {
      return ((SkinnableColorStateList)localObject).a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.d
 * JD-Core Version:    0.7.0.1
 */