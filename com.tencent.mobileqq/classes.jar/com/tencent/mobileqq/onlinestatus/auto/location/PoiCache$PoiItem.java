package com.tencent.mobileqq.onlinestatus.auto.location;

import android.support.annotation.NonNull;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class PoiCache$PoiItem
{
  public final AdInfo a;
  public LatLng a;
  public final List<Poi> a;
  
  public PoiCache$PoiItem(LatLng paramLatLng, AdInfo paramAdInfo, List<Poi> paramList)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo = paramAdInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PoiItem{latLng=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    localStringBuilder.append(", poiList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", adInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiItem
 * JD-Core Version:    0.7.0.1
 */