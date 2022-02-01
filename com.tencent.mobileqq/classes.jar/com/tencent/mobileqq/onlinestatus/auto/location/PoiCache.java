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
      if ((paramPoiItem != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiCache][");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("] from: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result: ");
        ((StringBuilder)localObject).append(paramPoiItem.jdField_a_of_type_JavaUtilList);
        ((StringBuilder)localObject).append(" size: ");
        ((StringBuilder)localObject).append(paramPoiItem.jdField_a_of_type_JavaUtilList.size());
        QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
        localObject = (Poi)paramPoiItem.jdField_a_of_type_JavaUtilList.get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiCache][");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("] from: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" first poi: ");
        localStringBuilder.append(((Poi)localObject).title);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject).category);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject)._distance);
        QLog.d("PoiCache", 2, localStringBuilder.toString());
        if (paramPoiItem.jdField_a_of_type_JavaUtilList.size() >= 2)
        {
          localObject = (Poi)paramPoiItem.jdField_a_of_type_JavaUtilList.get(1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][poiCache][");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("] from: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" second poi: ");
          localStringBuilder.append(((Poi)localObject).title);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject).category);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject)._distance);
          QLog.d("PoiCache", 2, localStringBuilder.toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiCache][");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("] from: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result: ");
        ((StringBuilder)localObject).append(paramPoiItem.jdField_a_of_type_JavaUtilList);
        ((StringBuilder)localObject).append(" adInfoCity: ");
        ((StringBuilder)localObject).append(paramPoiItem.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo.city);
        ((StringBuilder)localObject).append(" adInfoDistrict: ");
        ((StringBuilder)localObject).append(paramPoiItem.jdField_a_of_type_ComTencentLbssearchHttpresponseAdInfo.district);
        QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][poiCache][");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] from: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result: ");
      if ((paramPoiItem != null) && (paramPoiItem.jdField_a_of_type_JavaUtilList != null)) {
        paramString = "0";
      } else {
        paramString = "null";
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(PoiCache.PoiItem paramPoiItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiCache][");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("] put poiItem: ");
      localStringBuilder.append(paramPoiItem);
      QLog.d("PoiCache", 2, localStringBuilder.toString());
    }
    a("putPoiList", paramPoiItem);
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(new PoiCache.PoiKey(this, paramPoiItem.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng), paramPoiItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache
 * JD-Core Version:    0.7.0.1
 */