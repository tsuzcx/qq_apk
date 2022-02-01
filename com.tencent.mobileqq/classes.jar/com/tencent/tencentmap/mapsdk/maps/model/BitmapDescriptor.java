package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.sdk.a.hf;

public final class BitmapDescriptor
{
  private hf a = null;
  
  BitmapDescriptor(hf paramhf)
  {
    this.a = paramhf;
  }
  
  public final Bitmap getBitmap(Context paramContext)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramContext);
  }
  
  public final hf getFormater()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */