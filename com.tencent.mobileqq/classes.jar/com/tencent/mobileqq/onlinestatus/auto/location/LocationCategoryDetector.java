package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.OnInnerStatusUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class LocationCategoryDetector
{
  private AutoStatus jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
  private LocationCategoryDetector.Category jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category;
  private PoiLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader;
  private Location jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
  private AutoStatusManager.OnInnerStatusUpdateListener jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener;
  private String jdField_a_of_type_JavaLangString;
  
  LocationCategoryDetector(AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener = paramOnInnerStatusUpdateListener;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader = new PoiLoader("category", Constant.l, Constant.j, Constant.k);
  }
  
  int a()
  {
    AutoStatus localAutoStatus = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus;
    if ((localAutoStatus != null) && (localAutoStatus.a("category"))) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
    }
    localAutoStatus = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus;
    if (localAutoStatus == null) {
      return 40001;
    }
    return localAutoStatus.a;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][category] persistPoiData. status: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" category: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category);
      QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category;
    if ((localObject != null) && (LocationCategoryDetector.Category.a((LocationCategoryDetector.Category)localObject) == paramLong)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.a);
    }
  }
  
  void a(PoiBean paramPoiBean)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    Object localObject;
    int i;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][category] getPoiWithLatLng onResult poi_size: ");
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null)) {
        i = paramPoiBean.poiArray.length;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramPoiBean != null) && (paramPoiBean.poiArray != null))
    {
      i = j;
      if (paramPoiBean.poiArray.length > 0)
      {
        while (i < Math.min(paramPoiBean.poiArray.length, Constant.d))
        {
          Poi localPoi = paramPoiBean.poiArray[i];
          if (localPoi._distance > Constant.g)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][category] onFetchPoi fail far poi: ");
              ((StringBuilder)localObject).append(localPoi.title);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(localPoi.category);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(localPoi._distance);
              ((StringBuilder)localObject).append(" category: ");
              ((StringBuilder)localObject).append(localPoi.category);
              QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localPoi.title);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(localPoi.category);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(localPoi._distance);
            this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][category] onFetchPoi poi: ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" category: ");
              ((StringBuilder)localObject).append(localPoi.category);
              QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
            }
            if (localPoi.category != null)
            {
              localObject = localPoi.category.split(":");
              Iterator localIterator = Constant.b.iterator();
              while (localIterator.hasNext())
              {
                LocationCategoryDetector.Category localCategory = (LocationCategoryDetector.Category)localIterator.next();
                if (LocationCategoryDetector.Category.a(localCategory, (String[])localObject))
                {
                  localObject = localCategory;
                  if (!QLog.isColorLevel()) {
                    break label506;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("[status][category] onFetchPoi success poi: ");
                  ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
                  ((StringBuilder)localObject).append(" category: ");
                  ((StringBuilder)localObject).append(localPoi.category);
                  QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
                  localObject = localCategory;
                  break label506;
                }
              }
              localObject = null;
              label506:
              this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = ((LocationCategoryDetector.Category)localObject);
              localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category;
              if (localObject != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(LocationCategoryDetector.Category.a((LocationCategoryDetector.Category)localObject));
                paramPoiBean = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener;
                if (paramPoiBean == null) {
                  break;
                }
                paramPoiBean.a();
                break;
              }
            }
          }
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          paramPoiBean = new StringBuilder();
          paramPoiBean.append("[status][category] getPoiWithLatLng onResult: ");
          paramPoiBean.append(this.jdField_a_of_type_JavaLangString);
          paramPoiBean.append(" category: ");
          paramPoiBean.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category);
          paramPoiBean.append(" status: ");
          paramPoiBean.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus);
          QLog.d("LocationCategoryDetector", 2, paramPoiBean.toString());
        }
        return;
      }
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
  }
  
  void a(Location paramLocation, double paramDouble)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][category] detect: ");
      localStringBuilder.append(paramLocation);
      localStringBuilder.append(" curRate: ");
      localStringBuilder.append(paramDouble);
      QLog.d("LocationCategoryDetector", 2, localStringBuilder.toString());
    }
    if ((paramLocation != null) && (paramDouble <= Constant.a))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a(paramLocation.a, new LocationCategoryDetector.1(this));
        return;
      }
      catch (Throwable paramLocation)
      {
        QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramLocation);
        return;
      }
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector$Category = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector
 * JD-Core Version:    0.7.0.1
 */