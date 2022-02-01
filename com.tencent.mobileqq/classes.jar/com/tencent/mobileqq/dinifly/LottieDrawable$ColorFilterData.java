package com.tencent.mobileqq.dinifly;

import android.graphics.ColorFilter;
import android.support.annotation.Nullable;

class LottieDrawable$ColorFilterData
{
  @Nullable
  final ColorFilter colorFilter;
  @Nullable
  final String contentName;
  final String layerName;
  
  LottieDrawable$ColorFilterData(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.layerName = paramString1;
    this.contentName = paramString2;
    this.colorFilter = paramColorFilter;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ColorFilterData)) {
        return false;
      }
      paramObject = (ColorFilterData)paramObject;
    } while ((hashCode() == paramObject.hashCode()) && (this.colorFilter == paramObject.colorFilter));
    return false;
  }
  
  public int hashCode()
  {
    int i = 17;
    if (this.layerName != null) {
      i = this.layerName.hashCode() * 527;
    }
    int j = i;
    if (this.contentName != null) {
      j = i * 31 * this.contentName.hashCode();
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable.ColorFilterData
 * JD-Core Version:    0.7.0.1
 */