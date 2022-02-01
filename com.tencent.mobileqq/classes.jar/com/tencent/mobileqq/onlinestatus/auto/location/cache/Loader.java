package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Arrays;

abstract class Loader
{
  protected static String a = "Loader";
  protected final String b;
  
  Loader(String paramString)
  {
    this.b = paramString;
  }
  
  protected void a(String paramString, PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel())
    {
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null) && (paramPoiBean.poiArray.length > 0))
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[status][poiLoader][");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("] from: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" result: ");
        ((StringBuilder)localObject2).append(Arrays.toString(paramPoiBean.poiArray));
        ((StringBuilder)localObject2).append(" size: ");
        ((StringBuilder)localObject2).append(paramPoiBean.poiArray.length);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        localObject1 = paramPoiBean.poiArray[0];
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiLoader][");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] from: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" first poi: ");
        localStringBuilder.append(((Poi)localObject1).title);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject1).category);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject1)._distance);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
        if (paramPoiBean.poiArray.length >= 2)
        {
          localObject1 = paramPoiBean.poiArray[1];
          localObject2 = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][poiLoader][");
          localStringBuilder.append(this.b);
          localStringBuilder.append("] from: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" second poi: ");
          localStringBuilder.append(((Poi)localObject1).title);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject1).category);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject1)._distance);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[status][poiLoader][");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("] from: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" result: ");
        ((StringBuilder)localObject2).append(Arrays.toString(paramPoiBean.poiArray));
        ((StringBuilder)localObject2).append(" adInfoCity: ");
        ((StringBuilder)localObject2).append(paramPoiBean.adInfo.city);
        ((StringBuilder)localObject2).append(" adInfoDistrict: ");
        ((StringBuilder)localObject2).append(paramPoiBean.adInfo.district);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return;
      }
      Object localObject1 = a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[status][poiLoader][");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("] from: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" result: ");
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null)) {
        paramString = "0";
      } else {
        paramString = "null";
      }
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  protected boolean a(LatLng paramLatLng1, LatLng paramLatLng2, int paramInt)
  {
    boolean bool = false;
    String str;
    StringBuilder localStringBuilder;
    if ((paramLatLng1 != null) && (paramLatLng2 != null))
    {
      double d = LocationUtil.a(paramLatLng1, paramLatLng2);
      if (QLog.isColorLevel())
      {
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiLoader][");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] accept? this.latLng: ");
        localStringBuilder.append(paramLatLng1);
        localStringBuilder.append(" that.latLng: ");
        localStringBuilder.append(paramLatLng2);
        localStringBuilder.append(" distance: ");
        localStringBuilder.append(d);
        localStringBuilder.append(" acceptAccuracy: ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (d < paramInt) {
        bool = true;
      }
      return bool;
    }
    if (QLog.isColorLevel())
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] accept? fail this.latLng: ");
      localStringBuilder.append(paramLatLng1);
      localStringBuilder.append(" that.latLng: ");
      localStringBuilder.append(paramLatLng2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.Loader
 * JD-Core Version:    0.7.0.1
 */