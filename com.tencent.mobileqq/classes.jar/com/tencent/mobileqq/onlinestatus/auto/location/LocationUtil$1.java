package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class LocationUtil$1
  implements HttpResponseListener<BaseObject>
{
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHelper", 2, "[status][util] getPoiWithLatLng onSuccess. resultCode : " + paramInt + " result : " + paramBaseObject);
    }
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null) && (paramBaseObject.result.pois.size() > 0)) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("LocationHelper", 2, "[status][util] getPoiWithLatLng invoked success. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poi_size : " + paramBaseObject.result.pois.size());
          }
          paramBaseObject = new PoiCache.PoiItem(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramBaseObject.result.ad_info, paramBaseObject.result.pois);
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache != null) {
              this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache.a(paramBaseObject);
            }
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnGetPoiWithLatLngListener.a(paramBaseObject);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("LocationHelper", 1, "putPoiCacheError", localThrowable);
            }
          }
          return;
        }
        catch (Throwable paramBaseObject)
        {
          QLog.e("LocationHelper", 1, "getPoiListenerError", paramBaseObject);
        }
      }
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocationHelper", 2, paramThrowable, new Object[] { "[status][util] getPoiWithLatLng invoked fail. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " errorCode : " + paramInt + " errorMsg : " + paramString });
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnGetPoiWithLatLngListener.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil.1
 * JD-Core Version:    0.7.0.1
 */