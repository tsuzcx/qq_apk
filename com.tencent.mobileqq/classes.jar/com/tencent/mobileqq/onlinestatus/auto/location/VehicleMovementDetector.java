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
    if (paramBoolean) {}
    for (int i = Constant.n;; i = Constant.m)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface.a(i);
      return;
    }
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
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation == null) {
      return 0L;
    }
    return this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation.jdField_a_of_type_Long;
  }
  
  Location a()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation != null) && (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] getLastLatLngForPOI. out of date location. location: " + this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation);
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
    if (paramDouble > Constant.w)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. Too fast rate : " + paramDouble);
      }
      return;
    }
    this.jdField_b_of_type_Double = paramDouble;
    long l1 = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) && (paramDouble > Constant.t))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. enter session rate : " + paramDouble);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(true);
      label114:
      if (!this.jdField_a_of_type_Boolean) {
        break label488;
      }
      if ((paramDouble <= Constant.v) || (paramDouble >= Constant.w)) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41014);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(false);
    }
    for (;;)
    {
      if (paramDouble >= 3.0D) {
        break label451;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. still start rate : " + paramDouble);
      }
      this.jdField_a_of_type_Long = l1;
      return;
      if ((!this.jdField_a_of_type_Boolean) || (paramDouble >= 3.0D) || (this.jdField_a_of_type_Long <= 0L)) {
        break label114;
      }
      long l2 = l1 - this.jdField_a_of_type_Long;
      if (l2 < Constant.r) {
        break label114;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.b();
      a(false);
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by still. rate : " + paramDouble + " still time: " + l2);
      break label114;
      label355:
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a != 41014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_CYCLING rate : " + paramDouble);
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41031);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationSampleModeController.a();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. STATUS_DRIVING rate : " + paramDouble);
      }
    }
    label451:
    if (QLog.isColorLevel()) {
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. still end rate : " + paramDouble);
    }
    this.jdField_a_of_type_Long = 0L;
    return;
    label488:
    if (QLog.isColorLevel()) {
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. out of session rate : " + paramDouble);
    }
    this.jdField_a_of_type_Long = 0L;
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
      if (QLog.isColorLevel()) {
        QLog.d("VehicleMovementDetector", 2, "[status][vehicle] onTriggered. leave session by step. rate : " + this.jdField_b_of_type_Double + " step time: " + paramLong2);
      }
    }
  }
  
  void a(Location paramLocation)
  {
    if ((paramLocation == null) || (paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) || ((paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude == 0.0D) && (paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude == 0.0D)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramLocation);
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
    }
    long l;
    do
    {
      do
      {
        return;
        if (paramLocation.jdField_a_of_type_Float < Constant.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect record poi loc: " + paramLocation);
          }
          this.jdField_b_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Boolean) || (paramLocation.jdField_a_of_type_Float <= Constant.s)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramLocation);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation == null) || (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. firstSet or reset mLastLocation: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation);
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
        return;
      }
      l -= this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.jdField_a_of_type_Long;
      if (l >= Constant.n * 2 / 3)
      {
        double d = LocationUtil.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramLocation.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng) / l * 3600.0D;
        if (QLog.isColorLevel()) {
          QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect. location: " + paramLocation + " internal " + l + " rate : " + d);
        }
        if (d < Constant.w) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a(d);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation = paramLocation;
          this.jdField_a_of_type_Double = d;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. dirty rate : " + d);
          }
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VehicleMovementDetector", 2, "[status][vehicle] detect ignore. mLastLocation: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocation + " internal: " + l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.VehicleMovementDetector
 * JD-Core Version:    0.7.0.1
 */