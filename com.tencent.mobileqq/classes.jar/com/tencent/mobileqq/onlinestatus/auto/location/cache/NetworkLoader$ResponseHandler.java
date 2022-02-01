package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class NetworkLoader$ResponseHandler
  implements HttpResponseListener<BaseObject>
{
  private final PoiLoader.OnPoiLoadListener b;
  private final LatLng c;
  
  public NetworkLoader$ResponseHandler(NetworkLoader paramNetworkLoader, LatLng paramLatLng, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    this.c = paramLatLng;
    this.b = paramOnPoiLoadListener;
  }
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = Loader.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append("] netGet onSuccess. resultCode : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" result : ");
      localStringBuilder.append(paramBaseObject);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null) && (paramBaseObject.result.pois.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject = Loader.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][poiLoader][");
          localStringBuilder.append(this.a.b);
          localStringBuilder.append("]  netGet invoked success. latLng : ");
          localStringBuilder.append(this.c);
          localStringBuilder.append(" poi_size : ");
          localStringBuilder.append(paramBaseObject.result.pois.size());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = new Poi[paramBaseObject.result.pois.size()];
        paramBaseObject = new PoiBean(this.c, paramBaseObject.result.ad_info, (Poi[])paramBaseObject.result.pois.toArray((Object[])localObject));
        this.a.a("netGet", paramBaseObject);
        this.b.a(paramBaseObject);
      }
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    String str = Loader.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[status][poiLoader][");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] netGet invoked fail. latLng : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errorCode : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errorMsg : ");
    localStringBuilder.append(paramString);
    QLog.e(str, 1, paramThrowable, new Object[] { localStringBuilder.toString() });
    this.b.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.NetworkLoader.ResponseHandler
 * JD-Core Version:    0.7.0.1
 */