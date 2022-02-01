package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.Set;

class MemoryLoader
  extends Loader
{
  private LRULinkedHashMap<LatLng, PoiBean> a;
  
  MemoryLoader(String paramString, int paramInt)
  {
    super(paramString);
    Loader.a = "MemoryLoader";
    this.a = new LRULinkedHashMap(paramInt);
  }
  
  public void a(LatLng paramLatLng, int paramInt, PoiBean paramPoiBean)
  {
    Object localObject;
    if (a(paramLatLng, paramInt, new MemoryLoader.1(this, paramLatLng, paramInt, paramPoiBean)))
    {
      if (QLog.isColorLevel())
      {
        localObject = Loader.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiLoader][");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] memPut [fail already exist]. latLng: ");
        localStringBuilder.append(paramLatLng);
        localStringBuilder.append(" acceptAccuracy: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" poiBean: ");
        localStringBuilder.append(paramPoiBean);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramLatLng = Loader.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][poiLoader][");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] memPut poiBean: ");
      ((StringBuilder)localObject).append(paramPoiBean);
      QLog.d(paramLatLng, 2, ((StringBuilder)localObject).toString());
    }
    a("memPut", paramPoiBean);
    this.a.put(paramPoiBean.latLng, paramPoiBean);
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    Object localObject1 = this.a.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LatLng)((Iterator)localObject1).next();
      if (a((LatLng)localObject2, paramLatLng, paramInt))
      {
        localObject1 = (PoiBean)this.a.get(localObject2);
        break label67;
      }
    }
    localObject1 = null;
    label67:
    if (QLog.isColorLevel())
    {
      localObject2 = Loader.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] memGet latLng: ");
      localStringBuilder.append(paramLatLng);
      localStringBuilder.append(" result: ");
      localStringBuilder.append(localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    a("memGet", (PoiBean)localObject1);
    if (localObject1 != null) {
      paramOnPoiLoadListener.a((PoiBean)localObject1);
    }
    return localObject1 != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.MemoryLoader
 * JD-Core Version:    0.7.0.1
 */