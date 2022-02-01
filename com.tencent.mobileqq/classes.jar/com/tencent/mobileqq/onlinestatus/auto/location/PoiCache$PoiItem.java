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
    return "PoiItem{latLng=" + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + ", poiList=" + this.jdField_a_of_type_JavaUtilList + ", adInfo=" + this.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiItem
 * JD-Core Version:    0.7.0.1
 */