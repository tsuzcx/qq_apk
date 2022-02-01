package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.qphone.base.util.QLog;

class VehicleMovementDetector$1
  implements AutoLocationInterface.AutoLocationCallback
{
  VehicleMovementDetector$1(VehicleMovementDetector paramVehicleMovementDetector) {}
  
  public void a(Location paramLocation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][vehicle] onLocationChanged: ");
      localStringBuilder.append(paramLocation);
      QLog.i("VehicleMovementDetector", 2, localStringBuilder.toString());
    }
    this.a.a(paramLocation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.VehicleMovementDetector.1
 * JD-Core Version:    0.7.0.1
 */