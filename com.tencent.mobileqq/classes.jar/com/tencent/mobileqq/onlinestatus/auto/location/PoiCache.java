package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.List;

public class PoiCache
{
  private int jdField_a_of_type_Int;
  private LRULinkedHashMap<PoiCache.PoiKey, PoiCache.PoiItem> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private final String jdField_a_of_type_JavaLangString;
  
  private void a(String paramString, PoiCache.PoiItem paramPoiItem)
  {
    if (QLog.isColorLevel())
    {
      if ((paramPoiItem != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label98;
      }
      localObject = new StringBuilder().append("[status][poiCache][").append(this.jdField_a_of_type_JavaLangString).append("] from: ").append(paramString).append(" result: ");
      if ((paramPoiItem != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList != null)) {
        break label92;
      }
    }
    label92:
    for (paramString = "null";; paramString = "0")
    {
      QLog.d("PoiCache", 2, paramString);
      return;
    }
    label98:
    QLog.d("PoiCache", 2, "[status][poiCache][" + this.jdField_a_of_type_JavaLangString + "] from: " + paramString + " result: " + paramPoiItem.jdField_a_of_type_JavaUtilList + " size: " + paramPoiItem.jdField_a_of_type_JavaUtilList.size());
    Object localObject = (Poi)paramPoiItem.jdField_a_of_type_JavaUtilList.get(0);
    QLog.d("PoiCache", 2, "[status][poiCache][" + this.jdField_a_of_type_JavaLangString + "] from: " + paramString + " first poi: " + ((Poi)localObject).title + "-" + ((Poi)localObject).category + "-" + ((Poi)localObject)._distance);
    if (paramPoiItem.jdField_a_of_type_JavaUtilList.size() >= 2)
    {
      localObject = (Poi)paramPoiItem.jdField_a_of_type_JavaUtilList.get(1);
      QLog.d("PoiCache", 2, "[status][poiCache][" + this.jdField_a_of_type_JavaLangString + "] from: " + paramString + " second poi: " + ((Poi)localObject).title + "-" + ((Poi)localObject).category + "-" + ((Poi)localObject)._distance);
    }
    QLog.d("PoiCache", 2, "[status][poiCache][" + this.jdField_a_of_type_JavaLangString + "] from: " + paramString + " result: " + paramPoiItem.jdField_a_of_type_JavaUtilList + " adInfoCity: " + paramPoiItem.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo.city + " adInfoDistrict: " + paramPoiItem.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo.district);
  }
  
  public void a(PoiCache.PoiItem paramPoiItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiCache", 2, "[status][poiCache][" + this.jdField_a_of_type_JavaLangString + "] put poiItem: " + paramPoiItem);
    }
    a("putPoiList", paramPoiItem);
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(new PoiCache.PoiKey(this, paramPoiItem.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng), paramPoiItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache
 * JD-Core Version:    0.7.0.1
 */