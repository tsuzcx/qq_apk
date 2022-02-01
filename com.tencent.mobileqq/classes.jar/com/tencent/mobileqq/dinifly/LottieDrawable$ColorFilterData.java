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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ColorFilterData)) {
      return false;
    }
    paramObject = (ColorFilterData)paramObject;
    return (hashCode() == paramObject.hashCode()) && (this.colorFilter == paramObject.colorFilter);
  }
  
  public int hashCode()
  {
    String str = this.layerName;
    int i;
    if (str != null) {
      i = 527 * str.hashCode();
    } else {
      i = 17;
    }
    str = this.contentName;
    int j = i;
    if (str != null) {
      j = i * 31 * str.hashCode();
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable.ColorFilterData
 * JD-Core Version:    0.7.0.1
 */