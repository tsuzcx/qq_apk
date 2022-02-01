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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][util] getPoiWithLatLng onSuccess. resultCode : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" result : ");
      localStringBuilder.append(paramBaseObject);
      QLog.d("LocationHelper", 2, localStringBuilder.toString());
    }
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null) && (paramBaseObject.result.pois.size() > 0)) {
        try
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][util] getPoiWithLatLng invoked success. latLng : ");
            localStringBuilder.append(this.a);
            localStringBuilder.append(" poi_size : ");
            localStringBuilder.append(paramBaseObject.result.pois.size());
            QLog.d("LocationHelper", 2, localStringBuilder.toString());
          }
          paramBaseObject = new PoiCache.PoiItem(this.a, paramBaseObject.result.ad_info, paramBaseObject.result.pois);
          try
          {
            if (this.b != null) {
              this.b.a(paramBaseObject);
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("LocationHelper", 1, "putPoiCacheError", localThrowable);
          }
          this.c.a(paramBaseObject);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][util] getPoiWithLatLng invoked fail. latLng : ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" errorCode : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg : ");
      localStringBuilder.append(paramString);
      QLog.e("LocationHelper", 2, paramThrowable, new Object[] { localStringBuilder.toString() });
    }
    this.c.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil.1
 * JD-Core Version:    0.7.0.1
 */