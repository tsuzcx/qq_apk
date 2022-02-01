package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.OnInnerStatusUpdateListener;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class LocationCategoryDetector
{
  private AutoStatus jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
  private AutoStatusManager.OnInnerStatusUpdateListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener;
  private LocationCategoryDetector.Category jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category;
  private PoiLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader;
  private Location jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
  private String jdField_a_of_type_JavaLangString;
  
  LocationCategoryDetector(AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener = paramOnInnerStatusUpdateListener;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader = new PoiLoader("category", Constant.l, Constant.j, Constant.k);
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("category"))) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus == null) {
      return 40001;
    }
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] persistPoiData. status: " + paramLong + " category: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category != null) && (LocationCategoryDetector.Category.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category) == paramLong)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.a);
    }
  }
  
  void a(PoiBean paramPoiBean)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("[status][category] getPoiWithLatLng onResult poi_size: ");
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null)) {
        break label89;
      }
    }
    label89:
    for (int i = 0;; i = paramPoiBean.poiArray.length)
    {
      QLog.d("LocationCategoryDetector", 2, i);
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null))
      {
        i = j;
        if (paramPoiBean.poiArray.length > 0) {
          break;
        }
      }
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
      return;
    }
    label208:
    LocationCategoryDetector.Category localCategory;
    if (i < Math.min(paramPoiBean.poiArray.length, Constant.d))
    {
      Poi localPoi = paramPoiBean.poiArray[i];
      if (localPoi._distance > Constant.g) {
        if (QLog.isColorLevel()) {
          QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi fail far poi: " + localPoi.title + "-" + localPoi.category + "-" + localPoi._distance + " category: " + localPoi.category);
        }
      }
      do
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaLangString = (localPoi.title + "-" + localPoi.category + "-" + localPoi._distance);
        if (QLog.isColorLevel()) {
          QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
        }
      } while (localPoi.category == null);
      localObject = localPoi.category.split(":");
      Iterator localIterator = Constant.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localCategory = (LocationCategoryDetector.Category)localIterator.next();
          if (LocationCategoryDetector.Category.a(localCategory, (String[])localObject))
          {
            localObject = localCategory;
            if (QLog.isColorLevel()) {
              QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi success poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
            }
          }
        }
      }
    }
    for (Object localObject = localCategory;; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = ((LocationCategoryDetector.Category)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category == null) {
        break label208;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(LocationCategoryDetector.Category.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category));
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener.a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationCategoryDetector", 2, "[status][category] getPoiWithLatLng onResult: " + this.jdField_a_of_type_JavaLangString + " category: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category + " status: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus);
      return;
    }
  }
  
  void a(Location paramLocation, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] detect: " + paramLocation + " curRate: " + paramDouble);
    }
    if ((paramLocation == null) || (paramDouble > Constant.a))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = null;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a(paramLocation.a, new LocationCategoryDetector.1(this));
      return;
    }
    catch (Throwable paramLocation)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramLocation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector
 * JD-Core Version:    0.7.0.1
 */