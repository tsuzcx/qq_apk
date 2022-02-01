package com.tencent.tencentmap.mapsdk.maps.model;

import android.support.annotation.NonNull;
import com.tencent.map.sdk.a.hn;
import java.util.ArrayList;
import java.util.List;

public final class LatLngBounds$Builder
{
  private final List<LatLng> a = new ArrayList();
  
  public final LatLngBounds build()
  {
    if (this.a.size() >= 2) {
      return LatLngBounds.a(this.a);
    }
    throw new hn(this.a.size());
  }
  
  @NonNull
  public final Builder include(@NonNull LatLng paramLatLng)
  {
    this.a.add(paramLatLng);
    return this;
  }
  
  @NonNull
  public final Builder include(@NonNull List<LatLng> paramList)
  {
    this.a.addAll(paramList);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder
 * JD-Core Version:    0.7.0.1
 */