package com.tencent.tencentmap.mapsdk.maps;

import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

public abstract interface TencentMap$InfoWindowAdapter
{
  public abstract View getInfoContents(Marker paramMarker);
  
  public abstract View getInfoWindow(Marker paramMarker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
 * JD-Core Version:    0.7.0.1
 */