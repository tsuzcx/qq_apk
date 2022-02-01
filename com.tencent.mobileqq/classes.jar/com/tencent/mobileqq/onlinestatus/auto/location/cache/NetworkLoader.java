package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class NetworkLoader
  extends Loader
{
  private TencentSearch a;
  
  NetworkLoader(String paramString)
  {
    super(paramString);
    jdField_a_of_type_JavaLangString = "NetworkLoader";
    this.jdField_a_of_type_ComTencentLbssearchTencentSearch = new TencentSearch(BaseApplicationImpl.getContext());
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] netGet. latLng: " + paramLatLng);
    }
    this.jdField_a_of_type_ComTencentLbssearchTencentSearch.geo2address(new Geo2AddressParam(paramLatLng).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(Constant.d).setPageIndex(0)), new NetworkLoader.ResponseHandler(this, paramLatLng, paramOnPoiLoadListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.NetworkLoader
 * JD-Core Version:    0.7.0.1
 */