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
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
      return 0.0D;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    localObject1 = (Location)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    localObject2 = (Location)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 2);
    double d1 = LocationUtil.a(((Location)localObject1).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((Location)localObject2).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    long l = Math.abs(((Location)localObject2).jdField_a_of_type_Long - ((Location)localObject1).jdField_a_of_type_Long);
    double d2 = l;
    Double.isNaN(d2);
    d2 = d1 / (d2 * 1.0D);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[status][distance] getLastSampleRate. distance: ");
      ((StringBuilder)localObject1).append(d1);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" interval: ");
      ((StringBuilder)localObject2).append(l);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" rate: ");
      localStringBuilder.append(d2);
      QLog.d("GPSDistanceDetector", 2, new Object[] { localObject1, localObject2, localStringBuilder.toString() });
    }
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
      return 41042;
    }
    if (paramInt == 41042)
    {
      if (b()) {
        return 40001;
      }
      return paramInt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", Constant.a(40001) });
    }
    return 40001;
  }
  
  Location a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    localObject = (Location)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - ((Location)localObject).jdField_a_of_type_Long > Constant.N)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
      }
      return null;
    }
    return localObject;
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
    ArrayList localArrayList = a();
    int i = localArrayList.size();
    boolean bool3 = false;
    boolean bool2 = false;
    if (i < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isMoving size < 2");
      }
      return false;
    }
    Location localLocation = (Location)localArrayList.get(localArrayList.size() - 1);
    if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long > Constant.H + 30000) {
      return false;
    }
    Object localObject2 = null;
    i = localArrayList.size() - 2;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < 0) {
        break;
      }
      if (localLocation.jdField_a_of_type_Long - ((Location)localArrayList.get(i)).jdField_a_of_type_Long <= Constant.K)
      {
        localObject1 = (Location)localArrayList.get(i);
        break;
      }
      i -= 1;
    }
    boolean bool1 = bool3;
    if (localObject1 != null)
    {
      double d = LocationUtil.a(localLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((Location)localObject1).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      long l = localLocation.jdField_a_of_type_Long - ((Location)localObject1).jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long), " time2:", Long.valueOf(((Location)localObject1).jdField_a_of_type_Long), " interval:", Long.valueOf(l) });
      }
      if (l <= Constant.I + 30000)
      {
        bool1 = bool2;
        if (d >= Constant.J) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (d >= Constant.G) {
        bool1 = true;
      }
    }
    return bool1;
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
        paramLocation.append(((Location)localArrayList.get(i)).toString());
        paramLocation.append("\n");
        i += 1;
      }
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] newList:", paramLocation.toString() });
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = a();
    if (localArrayList.size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isNotMoving size < 2");
      }
      return false;
    }
    Location localLocation = (Location)localArrayList.get(localArrayList.size() - 1);
    if (System.currentTimeMillis() - localLocation.jdField_a_of_type_Long > Constant.H + 30000) {
      return false;
    }
    Object localObject2 = null;
    int i = localArrayList.size() - 2;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < 0) {
        break;
      }
      if (localLocation.jdField_a_of_type_Long - ((Location)localArrayList.get(i)).jdField_a_of_type_Long > Constant.L)
      {
        localObject1 = (Location)localArrayList.get(i);
        break;
      }
      i -= 1;
    }
    if (localObject1 != null)
    {
      double d = LocationUtil.a(localLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ((Location)localObject1).jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d), " size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long), " time2:", Long.valueOf(((Location)localObject1).jdField_a_of_type_Long) });
      }
      if (d < Constant.G) {
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " time1:", Long.valueOf(localLocation.jdField_a_of_type_Long) });
    }
    return false;
  }
  
  public void c()
  {
    boolean bool1 = b();
    boolean bool2 = a();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] notifyCheckStatus notmoving:", Boolean.valueOf(bool1), " isMoving:", Boolean.valueOf(bool2) });
    }
    if ((!bool1) && (!bool2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus miss");
      }
    }
    else
    {
      AutoLocationCheckListener localAutoLocationCheckListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener;
      if (localAutoLocationCheckListener != null)
      {
        localAutoLocationCheckListener.a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] notifyCheckStatus listener empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.GPSDistanceDetector
 * JD-Core Version:    0.7.0.1
 */