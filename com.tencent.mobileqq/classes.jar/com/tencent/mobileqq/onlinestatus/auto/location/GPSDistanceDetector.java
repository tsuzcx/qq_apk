package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GPSDistanceDetector
  implements AutoLocationInterface.AutoLocationCallback
{
  private AutoLocationCheckListener a;
  private ArrayList<Location> b = new ArrayList(6);
  private AutoLocationInterface c = new AutoLocationInterface(this, Constant.G);
  private int d = 0;
  
  public int a(int paramInt)
  {
    if (d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", Constant.c(41042) });
      }
      return 41042;
    }
    if (paramInt == 41042)
    {
      if (e()) {
        return 40001;
      }
      return paramInt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus status:", Constant.c(40001) });
    }
    return 40001;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] startDetector.");
    }
    this.c.a(Constant.J);
    this.c.a();
  }
  
  public void a(AutoLocationCheckListener paramAutoLocationCheckListener)
  {
    this.a = paramAutoLocationCheckListener;
  }
  
  public void a(Location paramLocation)
  {
    this.d += 1;
    if (this.d >= 2) {
      this.c.a(Constant.I);
    }
    b(paramLocation);
    i();
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] getStatus. locate success. curLoc: ", paramLocation });
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] stopDetector.");
    }
    this.d = 0;
    this.c.b();
  }
  
  public void b(Location paramLocation)
  {
    int j = this.b.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Location localLocation = (Location)this.b.get(i);
      if (System.currentTimeMillis() - localLocation.d <= 420000L) {
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
    this.b = localArrayList;
  }
  
  ArrayList<Location> c()
  {
    ArrayList localArrayList = new ArrayList(this.b.size());
    int i = 0;
    while (i < this.b.size())
    {
      Location localLocation = (Location)this.b.get(i);
      if (System.currentTimeMillis() - localLocation.d <= 420000L) {
        localArrayList.add(localLocation);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = c();
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
    if (System.currentTimeMillis() - localLocation.d > Constant.I + 30000) {
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
      if (localLocation.d - ((Location)localArrayList.get(i)).d <= Constant.L)
      {
        localObject1 = (Location)localArrayList.get(i);
        break;
      }
      i -= 1;
    }
    boolean bool1 = bool3;
    if (localObject1 != null)
    {
      double d1 = LocationUtil.a(localLocation.a, ((Location)localObject1).a);
      long l = localLocation.d - ((Location)localObject1).d;
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isMoving distance:", Double.valueOf(d1), " size:", Integer.valueOf(this.b.size()), " time1:", Long.valueOf(localLocation.d), " time2:", Long.valueOf(((Location)localObject1).d), " interval:", Long.valueOf(l) });
      }
      if (l <= Constant.J + 30000)
      {
        bool1 = bool2;
        if (d1 >= Constant.K) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (d1 >= Constant.H) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    ArrayList localArrayList = c();
    if (localArrayList.size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] isNotMoving size < 2");
      }
      return false;
    }
    Location localLocation = (Location)localArrayList.get(localArrayList.size() - 1);
    if (System.currentTimeMillis() - localLocation.d > Constant.I + 30000) {
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
      if (localLocation.d - ((Location)localArrayList.get(i)).d > Constant.M)
      {
        localObject1 = (Location)localArrayList.get(i);
        break;
      }
      i -= 1;
    }
    if (localObject1 != null)
    {
      double d1 = LocationUtil.a(localLocation.a, ((Location)localObject1).a);
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving distance:", Double.valueOf(d1), " size:", Integer.valueOf(this.b.size()), " time1:", Long.valueOf(localLocation.d), " time2:", Long.valueOf(((Location)localObject1).d) });
      }
      if (d1 < Constant.H) {
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, new Object[] { "[status][distance] isNotMoving not hit record size:", Integer.valueOf(this.b.size()), " time1:", Long.valueOf(localLocation.d) });
    }
    return false;
  }
  
  Location f()
  {
    if (this.b.size() < 1) {
      return null;
    }
    Object localObject = this.b;
    localObject = (Location)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (System.currentTimeMillis() - ((Location)localObject).d > Constant.Q)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GPSDistanceDetector", 2, "[status][distance] getLastLatLngForPOI. timeout");
      }
      return null;
    }
    return localObject;
  }
  
  double g()
  {
    if (this.b.size() < 2) {
      return 0.0D;
    }
    Object localObject1 = this.b;
    localObject1 = (Location)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
    Object localObject2 = this.b;
    localObject2 = (Location)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 2);
    double d1 = LocationUtil.a(((Location)localObject1).a, ((Location)localObject2).a);
    long l = Math.abs(((Location)localObject2).d - ((Location)localObject1).d);
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
  
  public int h()
  {
    if (d()) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GPSDistanceDetector", 2, "[status][distance] getFirstDelayForMoving no hit ");
    }
    return 150000;
  }
  
  public void i()
  {
    boolean bool1 = e();
    boolean bool2 = d();
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
      AutoLocationCheckListener localAutoLocationCheckListener = this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.GPSDistanceDetector
 * JD-Core Version:    0.7.0.1
 */