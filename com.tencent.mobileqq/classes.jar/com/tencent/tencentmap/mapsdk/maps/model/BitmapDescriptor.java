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
    hf localhf = this.a;
    if (localhf == null) {
      return null;
    }
    return localhf.a(paramContext);
  }
  
  public final hf getFormater()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */