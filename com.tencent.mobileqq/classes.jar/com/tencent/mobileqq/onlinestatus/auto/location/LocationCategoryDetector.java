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
  private LocationCategoryDetector.Category a;
  private AutoStatus b = new AutoStatus(40001);
  private String c;
  private Location d;
  private PoiLoader e;
  private AutoStatusManager.OnInnerStatusUpdateListener f;
  
  LocationCategoryDetector(AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.f = paramOnInnerStatusUpdateListener;
    this.e = new PoiLoader("category", Constant.m, Constant.k, Constant.l);
  }
  
  int a()
  {
    AutoStatus localAutoStatus = this.b;
    if ((localAutoStatus != null) && (localAutoStatus.a("category"))) {
      this.a = null;
    }
    localAutoStatus = this.b;
    if (localAutoStatus == null) {
      return 40001;
    }
    return localAutoStatus.a;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][category] persistPoiData. status: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" category: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject != null) && (LocationCategoryDetector.Category.a((LocationCategoryDetector.Category)localObject) == paramLong)) {
      this.e.a(this.d.a);
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
            this.c = ((StringBuilder)localObject).toString();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][category] onFetchPoi poi: ");
              ((StringBuilder)localObject).append(this.c);
              ((StringBuilder)localObject).append(" category: ");
              ((StringBuilder)localObject).append(localPoi.category);
              QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
            }
            if (localPoi.category != null)
            {
              localObject = localPoi.category.split(":");
              Iterator localIterator = Constant.T.iterator();
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
                  ((StringBuilder)localObject).append(this.c);
                  ((StringBuilder)localObject).append(" category: ");
                  ((StringBuilder)localObject).append(localPoi.category);
                  QLog.d("LocationCategoryDetector", 2, ((StringBuilder)localObject).toString());
                  localObject = localCategory;
                  break label506;
                }
              }
              localObject = null;
              label506:
              this.a = ((LocationCategoryDetector.Category)localObject);
              localObject = this.a;
              if (localObject != null)
              {
                this.b.a(LocationCategoryDetector.Category.a((LocationCategoryDetector.Category)localObject));
                paramPoiBean = this.f;
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
          paramPoiBean.append(this.c);
          paramPoiBean.append(" category: ");
          paramPoiBean.append(this.a);
          paramPoiBean.append(" status: ");
          paramPoiBean.append(this.b);
          QLog.d("LocationCategoryDetector", 2, paramPoiBean.toString());
        }
        return;
      }
    }
    this.c = null;
    this.a = null;
    this.b.a();
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
    if ((paramLocation != null) && (paramDouble <= Constant.h))
    {
      this.d = paramLocation;
      try
      {
        this.e.a(paramLocation.a, new LocationCategoryDetector.1(this));
        return;
      }
      catch (Throwable paramLocation)
      {
        QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramLocation);
        return;
      }
    }
    this.c = null;
    this.a = null;
    this.b.a();
    this.d = null;
  }
  
  void b()
  {
    this.c = "";
    this.a = null;
  }
  
  String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector
 * JD-Core Version:    0.7.0.1
 */