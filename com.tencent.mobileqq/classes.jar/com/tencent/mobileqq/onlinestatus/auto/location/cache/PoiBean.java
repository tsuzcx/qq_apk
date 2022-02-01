package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import android.support.annotation.NonNull;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Arrays;

public class PoiBean
{
  public final AdInfo adInfo;
  public final LatLng latLng;
  public final Poi[] poiArray;
  
  public PoiBean(LatLng paramLatLng, AdInfo paramAdInfo, Poi[] paramArrayOfPoi)
  {
    this.latLng = paramLatLng;
    this.poiArray = paramArrayOfPoi;
    this.adInfo = paramAdInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PoiBean{latLng=");
    localStringBuilder.append(this.latLng);
    localStringBuilder.append(", poiList=");
    localStringBuilder.append(Arrays.toString(this.poiArray));
    localStringBuilder.append(", adInfo=");
    localStringBuilder.append(this.adInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean
 * JD-Core Version:    0.7.0.1
 */