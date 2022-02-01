package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GPSDistanceDetector
  implements AutoLocationInterface.AutoLocationCallback
{
  private int jdField_a_of_type_Int = 0;
  private AutoLocationCheckListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener;
  private AutoLocationInterface jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface = new AutoLocationInterface(this, Constant.F);
  private ArrayList<Location> jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  
  double a()
  {
    double d1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
      d1 = 0.0D;
    }
    double d3;
    long l;
    double d2;
    do
    {
      return d1;
      Location localLocation1 = (Location)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      Location localLocation2 = (Location)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
      d3 = LocationUtil.a(localLocation1.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, localLocation2.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      l = Math.abs(localLocation2.jdField_a_of_type_Long - localLocation1.jdField_a_of_type_Long);
      d2 = d3 / (l * 1.0D);
      d1 = d2;
    } while (!QLog.isColorLevel());
    QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getLastSampleRate. distance: " + d3, " interval: " + l, " rate: " + d2 });
    return d2;
  }
  
  public int a()
  {
    if (a()) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getFirstDelayForMoving no hit ");
    }
    return 150000;
  }
  
  public int a(int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", Constant.a(41042) });
      }
      paramInt = 41042;
    }
    do
    {
      return paramInt;
      if (paramInt != 41042) {
        break;
      }
    } while (!b());
    return 40001;
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", Constant.a(40001) });
    }
    return 40001;
  }
  
  Location a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      localObject = null;
    }
    Location localLocation;
    do
    {
      return localObject;
      localLocation = (Location)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject = localLocation;
    } while (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long <= Constant.N);
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
    }
    return null;
  }
  
  ArrayList<Location> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Location localLocation = (Location)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localLocation);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] startDetector.");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a(Constant.I);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a();
  }
  
  public void a(AutoLocationCheckListener paramAutoLocationCheckListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener = paramAutoLocationCheckListener;
  }
  
  public void a(Location paramLocation)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 2) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a(Constant.H);
    }
    b(paramLocation);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramLocation });
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    Object localObject = a();
    if (((ArrayList)localObject).size() < 2) {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isMoving size < 2");
      }
    }
    label313:
    for (;;)
    {
      return false;
      Location localLocation = (Location)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long <= Constant.H + 30000)
      {
        int i = ((ArrayList)localObject).size() - 2;
        if (i >= 0) {
          if (localLocation.jdField_a_of_type_Long - ((Location)((ArrayList)localObject).get(i)).jdField_a_of_type_Long > Constant.K) {}
        }
        for (localObject = (Location)((ArrayList)localObject).get(i);; localObject = null)
        {
          if (localObject == null) {
            break label313;
          }
          double d = LocationUtil.a(localLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((Location)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          long l = localLocation.jdField_a_of_type_Long - ((Location)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long), " time2:", Long.valueOf(((Location)localObject).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
          }
          if (l <= Constant.I + 30000)
          {
            if (d >= Constant.J) {}
            for (bool = true;; bool = false)
            {
              return bool;
              i -= 1;
              break;
            }
          }
          if (d >= Constant.G) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] stopDetector.");
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.b();
  }
  
  public void b(Location paramLocation)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Location localLocation = (Location)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long <= 420000L) {
        localArrayList.add(localLocation);
      }
      i += 1;
    }
    localArrayList.add(paramLocation);
    if (QLog.isColorLevel())
    {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", Integer.valueOf(localArrayList.size()), " location:", paramLocation });
      paramLocation = new StringBuilder(10);
      i = 0;
      while (i < localArrayList.size())
      {
        paramLocation.append(((Location)localArrayList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramLocation.toString() });
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public boolean b()
  {
    Object localObject = a();
    if (((ArrayList)localObject).size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isNotMoving size < 2");
      }
      return false;
    }
    Location localLocation = (Location)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long > Constant.H + 30000) {
      return false;
    }
    int i = ((ArrayList)localObject).size() - 2;
    if (i >= 0) {
      if (localLocation.jdField_a_of_type_Long - ((Location)((ArrayList)localObject).get(i)).jdField_a_of_type_Long <= Constant.L) {}
    }
    for (localObject = (Location)((ArrayList)localObject).get(i);; localObject = null)
    {
      if (localObject != null)
      {
        double d = LocationUtil.a(localLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((Location)localObject).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        if (QLog.isColorLevel()) {
          QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long), " time2:", Long.valueOf(((Location)localObject).jdField_a_of_type_Long) });
        }
        if (d < Constant.G)
        {
          return true;
          i -= 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long) });
      }
      return false;
    }
  }
  
  public void c()
  {
    boolean bool1 = b();
    boolean bool2 = a();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] notifyCheckStatus notmoving:", Boolean.valueOf(bool1), " isMoving:", Boolean.valueOf(bool2) });
    }
    if ((bool1) || (bool2)) {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener.a();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus listener empty");
      return;
    }
    QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus miss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.GPSDistanceDetector
 * JD-Core Version:    0.7.0.1
 */