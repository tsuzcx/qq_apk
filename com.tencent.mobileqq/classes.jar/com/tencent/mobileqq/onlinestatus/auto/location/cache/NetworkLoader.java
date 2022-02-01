package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.app.MobileQQ;

class NetworkLoader
  extends Loader
{
  private TencentSearch c;
  
  NetworkLoader(String paramString)
  {
    super(paramString);
    a = "NetworkLoader";
    this.c = new TencentSearch(MobileQQ.sMobileQQ);
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] netGet. latLng: ");
      localStringBuilder.append(paramLatLng);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    this.c.geo2address(new Geo2AddressParam(paramLatLng).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(Constant.d).setPageIndex(0)), new NetworkLoader.ResponseHandler(this, paramLatLng, paramOnPoiLoadListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.NetworkLoader
 * JD-Core Version:    0.7.0.1
 */