package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class VehicleMovementDetector
  implements StepMovementDetector.StepDurationObserver
{
  private double jdField_a_of_type_Double = 0.0D;
  private long jdField_a_of_type_Long = 0L;
  private AutoStatus jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
  private AutoLocationInterface jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface = new AutoLocationInterface(new VehicleMovementDetector.1(this), Math.max(Constant.e, Constant.s));
  private AverageSampler jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler;
  private SampleModeController jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController;
  private Location jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
  private boolean jdField_a_of_type_Boolean = false;
  private double jdField_b_of_type_Double = 0.0D;
  private long jdField_b_of_type_Long = 0L;
  private Location jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
  private boolean jdField_b_of_type_Boolean = true;
  
  VehicleMovementDetector()
  {
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler = new AverageSampler("vehicle", Constant.C);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a(new VehicleMovementDetector.2(this));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController = new SampleModeController(Constant.o, Constant.p, new VehicleMovementDetector.3(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    int i;
    if (paramBoolean) {
      i = Constant.n;
    } else {
      i = Constant.m;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a(i);
  }
  
  double a()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public int a()
  {
    return Constant.q;
  }
  
  long a()
  {
    Location localLocation = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
    if (localLocation == null) {
      return 0L;
    }
    return localLocation.jdField_a_of_type_Long;
  }
  
  Location a()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
    if ((localObject != null) && (((Location)localObject).a()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][vehicle] getLastLatLngForPOI. out of date location. location: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation);
        QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation = null;
    }
    return this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("vehicle_start")) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(double paramDouble)
  {
    StringBuilder localStringBuilder;
    if (paramDouble > Constant.w)
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
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > Constant.t))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. enter session rate : ");
        localStringBuilder.append(paramDouble);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(true);
    }
    else if ((this.jdField_a_of_type_Boolean) && (paramDouble < 3.0D))
    {
      long l2 = this.jdField_a_of_type_Long;
      if (l2 > 0L)
      {
        l2 = l1 - l2;
        if (l2 >= Constant.r)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
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
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramDouble > Constant.v) && (paramDouble < Constant.w))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][vehicle] onTriggered. STATUS_DRIVING rate : ");
          localStringBuilder.append(paramDouble);
          QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41014);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
        a(false);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a != 41014)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][vehicle] onTriggered. STATUS_CYCLING rate : ");
          localStringBuilder.append(paramDouble);
          QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41031);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.a();
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
        if (this.jdField_a_of_type_Long <= 0L)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][vehicle] onTriggered. still start rate : ");
            localStringBuilder.append(paramDouble);
            QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_Long = l1;
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
        this.jdField_a_of_type_Long = 0L;
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
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_b_of_type_Long != paramLong1) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(true);
    }
    if (this.jdField_b_of_type_Double < Constant.t)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][vehicle] onTriggered. leave session by step. rate : ");
        localStringBuilder.append(this.jdField_b_of_type_Double);
        localStringBuilder.append(" step time: ");
        localStringBuilder.append(paramLong2);
        QLog.d("VehicleMovementDetector", 2, localStringBuilder.toString());
      }
    }
  }
  
  void a(Location paramLocation)
  {
    Object localObject;
    if ((paramLocation != null) && (paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng != null) && ((paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude != 0.0D) || (paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude != 0.0D)))
    {
      if (paramLocation.jdField_a_of_type_Float < Constant.e)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][vehicle] detect record poi loc: ");
          ((StringBuilder)localObject).append(paramLocation);
          QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
      }
      long l = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) && (paramLocation.jdField_a_of_type_Float > Constant.s))
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation;
      if ((localObject != null) && (!((Location)localObject).a()))
      {
        l -= this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.jdField_a_of_type_Long;
        if (l >= Constant.n * 2 / 3)
        {
          double d1 = LocationUtil.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          double d2 = l;
          Double.isNaN(d2);
          d1 = d1 / d2 * 3600.0D;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][vehicle] detect. location: ");
            ((StringBuilder)localObject).append(paramLocation);
            ((StringBuilder)localObject).append(" internal ");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(" rate : ");
            ((StringBuilder)localObject).append(d1);
            QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
          }
          if (d1 < Constant.w)
          {
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a(d1);
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
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
          }
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
          this.jdField_a_of_type_Double = d1;
          return;
        }
        if (QLog.isColorLevel())
        {
          paramLocation = new StringBuilder();
          paramLocation.append("[status][vehicle] detect ignore. mLastLocation: ");
          paramLocation.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation);
          paramLocation.append(" internal: ");
          paramLocation.append(l);
          QLog.d("VehicleMovementDetector", 2, paramLocation.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][vehicle] detect. firstSet or reset mLastLocation: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation);
        QLog.d("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][vehicle] detect. location: ");
      ((StringBuilder)localObject).append(paramLocation);
      QLog.e("VehicleMovementDetector", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  double b()
  {
    return this.jdField_a_of_type_Double;
  }
  
  int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("vehicle_getStatus")) {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a;
  }
  
  long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.VehicleMovementDetector
 * JD-Core Version:    0.7.0.1
 */