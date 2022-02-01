package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class VehicleMovementDetector
  implements StepMovementDetector.StepDurationObserver
{
  private Location a;
  private Location b;
  private AutoStatus c = new AutoStatus(40001);
  private double d = 0.0D;
  private double e = 0.0D;
  private AutoLocationInterface f = new AutoLocationInterface(new VehicleMovementDetector.1(this), Math.max(Constant.e, Constant.t));
  private AverageSampler g;
  private SampleModeController h;
  private boolean i = false;
  private long j = 0L;
  private long k = 0L;
  private boolean l = true;
  
  VehicleMovementDetector()
  {
    a(false);
    this.g = new AverageSampler("vehicle", Constant.D);
    this.g.a(new VehicleMovementDetector.2(this));
    this.h = new SampleModeController(Constant.p, Constant.q, new VehicleMovementDetector.3(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    int m;
    if (paramBoolean) {
      m = Constant.o;
    } else {
      m = Constant.n;
    }
    this.f.a(m);
  }
  
  void a(double paramDouble)
  {
    StringBuilder localStringBuilder;
    if (paramDouble > Constant.x)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. Too fast rate : ");
        localStringBuilder.append(paramDouble);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
      return;
    }
    this.e = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.i) && (paramDouble > Constant.u))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. enter session rate : ");
        localStringBuilder.append(paramDouble);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
      this.i = true;
      this.h.b();
      a(true);
    }
    else if ((this.i) && (paramDouble < 3.0D))
    {
      long l2 = this.j;
      if (l2 > 0L)
      {
        l2 = l1 - l2;
        if (l2 >= Constant.s)
        {
          this.i = false;
          this.c.a();
          this.h.b();
          a(false);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][vehicle] onTriggered. leave session by still. rate : ");
            localStringBuilder.append(paramDouble);
            localStringBuilder.append(" still time: ");
            localStringBuilder.append(l2);
            QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
          }
        }
      }
    }
    if (this.i)
    {
      if ((paramDouble > Constant.w) && (paramDouble < Constant.x))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][vehicle] onTriggered. STATUS_DRIVING rate : ");
          localStringBuilder.append(paramDouble);
          QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
        }
        this.c.a(41014);
        this.h.b();
        a(false);
      }
      else if (this.c.a != 41014)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][vehicle] onTriggered. STATUS_CYCLING rate : ");
          localStringBuilder.append(paramDouble);
          QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
        }
        this.c.a(41031);
        this.h.a();
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. STATUS_DRIVING rate : ");
        localStringBuilder.append(paramDouble);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
      if (paramDouble < 3.0D)
      {
        if (this.j <= 0L)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][vehicle] onTriggered. still start rate : ");
            localStringBuilder.append(paramDouble);
            QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
          }
          this.j = l1;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][vehicle] onTriggered. still end rate : ");
          localStringBuilder.append(paramDouble);
          QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
        }
        this.j = 0L;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. out of session rate : ");
        localStringBuilder.append(paramDouble);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
      this.j = 0L;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.k != paramLong1) && (!this.l))
    {
      this.k = paramLong1;
      this.h.b();
      a(true);
    }
    if (this.e < Constant.u)
    {
      this.i = false;
      this.c.a();
      this.h.b();
      a(false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. leave session by step. rate : ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" step time: ");
        localStringBuilder.append(paramLong2);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
    }
  }
  
  void a(Location paramLocation)
  {
    Object localObject;
    if ((paramLocation != null) && (paramLocation.a != null) && ((paramLocation.a.latitude != 0.0D) || (paramLocation.a.longitude != 0.0D)))
    {
      if (paramLocation.c < Constant.e)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][vehicle] detect record poi loc: ");
          ((StringBuilder)localObject).append(paramLocation);
          QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
        }
        this.b = paramLocation;
      }
      long l1 = System.currentTimeMillis();
      if ((!this.i) && (paramLocation.c > Constant.t))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][vehicle] detect. location: ");
          ((StringBuilder)localObject).append(paramLocation);
          QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = this.a;
      if ((localObject != null) && (!((Location)localObject).a()))
      {
        l1 -= this.a.d;
        if (l1 >= Constant.o * 2 / 3)
        {
          double d1 = LocationUtil.a(this.a.a, paramLocation.a);
          double d2 = l1;
          Double.isNaN(d2);
          d1 = d1 / d2 * 3600.0D;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][vehicle] detect. location: ");
            ((StringBuilder)localObject).append(paramLocation);
            ((StringBuilder)localObject).append(" internal ");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append(" rate : ");
            ((StringBuilder)localObject).append(d1);
            QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
          }
          if (d1 < Constant.x)
          {
            this.g.a(d1);
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][vehicle] detect ignore. dirty rate : ");
              ((StringBuilder)localObject).append(d1);
              QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
            }
            this.g.a();
          }
          this.a = paramLocation;
          this.d = d1;
          return;
        }
        if (QLog.isColorLevel())
        {
          paramLocation = new StringBuilder();
          paramLocation.append("[status][vehicle] detect ignore. mLastLocation: ");
          paramLocation.append(this.a);
          paramLocation.append(" internal: ");
          paramLocation.append(l1);
          QLog.d("VehicleMovementDetector", 2, paramLocation.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][vehicle] detect. firstSet or reset mLastLocation: ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
      }
      this.a = paramLocation;
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][vehicle] detect. location: ");
      ((StringBuilder)localObject).append(paramLocation);
      QLog.e("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
    }
    this.g.a();
    this.c.a();
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public int b()
  {
    return Constant.r;
  }
  
  void c()
  {
    this.f.a();
    if (this.c.a("vehicle_start")) {
      this.i = false;
    }
  }
  
  void d()
  {
    this.f.b();
  }
  
  long e()
  {
    Location localLocation = this.b;
    if (localLocation == null) {
      return 0L;
    }
    return localLocation.d;
  }
  
  Location f()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((Location)localObject).a()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][vehicle] getLastLatLngForPOI. out of date location. location: ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
      }
      this.b = null;
    }
    return this.b;
  }
  
  long g()
  {
    return this.j;
  }
  
  double h()
  {
    return this.e;
  }
  
  double i()
  {
    return this.d;
  }
  
  int j()
  {
    if (this.c.a("vehicle_getStatus")) {
      this.i = false;
    }
    return this.c.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.VehicleMovementDetector
 * JD-Core Version:    0.7.0.1
 */