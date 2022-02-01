package com.tencent.mobileqq.onlinestatus.auto.location;

import android.support.annotation.NonNull;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class PoiCache$PoiItem
{
  public LatLng a;
  public final List<Poi> b;
  public final AdInfo c;
  
  public PoiCache$PoiItem(LatLng paramLatLng, AdInfo paramAdInfo, List<Poi> paramList)
  {
    this.a = paramLatLng;
    this.b = paramList;
    this.c = paramAdInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PoiItem{latLng=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", poiList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", adInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiItem
 * JD-Core Version:    0.7.0.1
 */