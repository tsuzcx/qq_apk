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
    jdField_a_of_type_JavaLangString = "MemoryLoader";
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(paramInt);
  }
  
  public void a(LatLng paramLatLng, int paramInt, PoiBean paramPoiBean)
  {
    if (a(paramLatLng, paramInt, new MemoryLoader.1(this, paramLatLng, paramInt, paramPoiBean)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memPut [fail already exist]. latLng: " + paramLatLng + " acceptAccuracy: " + paramInt + " poiBean: " + paramPoiBean);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memPut poiBean: " + paramPoiBean);
    }
    a("memPut", paramPoiBean);
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramPoiBean.latLng, paramPoiBean);
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.keySet().iterator();
    LatLng localLatLng;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localLatLng = (LatLng)((Iterator)localObject).next();
    } while (!a(localLatLng, paramLatLng, paramInt));
    for (localObject = (PoiBean)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localLatLng);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memGet latLng: " + paramLatLng + " result: " + localObject);
      }
      a("memGet", (PoiBean)localObject);
      if (localObject != null) {
        paramOnPoiLoadListener.a((PoiBean)localObject);
      }
      return localObject != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.MemoryLoader
 * JD-Core Version:    0.7.0.1
 */