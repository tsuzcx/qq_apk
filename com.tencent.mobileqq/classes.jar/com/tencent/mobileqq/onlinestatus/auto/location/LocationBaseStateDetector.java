package com.tencent.mobileqq.onlinestatus.auto.location;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.OnInnerStatusUpdateListener;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LocationBaseStateDetector
  implements AutoLocationCheckListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoStatusManager.OnInnerStatusUpdateListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener;
  private GPSDistanceDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector;
  private LocationCategoryDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector;
  private StepMovementDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector;
  private VehicleMovementDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector;
  private StepMovementDetector b;
  
  public LocationBaseStateDetector(QQAppInterface paramQQAppInterface, AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener = paramOnInnerStatusUpdateListener;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector = new VehicleMovementDetector();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector = new LocationCategoryDetector(paramOnInnerStatusUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector = new GPSDistanceDetector();
  }
  
  private void b(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool1 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
      boolean bool2 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepSensorDetector();
        if ((Constant.jdField_b_of_type_Int == 3) && (bool2)) {
          this.b = new StepSensorCounter();
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector mainSensor: " + Constant.jdField_a_of_type_Int + " secondarySensor: " + Constant.jdField_b_of_type_Int + " hasDetector: " + bool1 + " hasCounter: " + bool2 + " final sensor: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a());
        }
      }
    }
    for (;;)
    {
      if (Constant.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(this);
        if (this.b != null) {
          this.b.a(this);
        }
      }
      return;
      if (Constant.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new AccelerometerDetector();
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepEmptySensor();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector compatibility. API<19 ACCELEROMETER");
      }
      if (Constant.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new AccelerometerDetector();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepEmptySensor();
      }
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.b();
    int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a();
    if ((i == 0) && (j == 0)) {
      return 0;
    }
    return Math.max(j, i);
  }
  
  public void a()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
      if ((l < 40001L) || (l == 41042L) || (b() != 41042)) {
        break label112;
      }
      if (!ProcessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label93;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener.a();
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus ", Boolean.valueOf(bool1) });
      }
      return;
      label93:
      if (QLog.isColorLevel())
      {
        QLog.d("LocationBaseStateDetector", 2, "[status][auto] notifyCheckStatus background");
        bool1 = false;
        continue;
        label112:
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
        if ((this.b == null) || (this.b.a())) {}
        for (bool1 = true;; bool1 = false)
        {
          boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.b();
          if (QLog.isColorLevel()) {
            QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus step1:", Boolean.valueOf(bool2), " step2:", Boolean.valueOf(bool1), " dist:", Boolean.valueOf(bool3) });
          }
          if ((!bool2) || (!bool1) || (!bool3)) {
            break label237;
          }
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener.a();
          bool1 = true;
          break;
        }
      }
      else
      {
        label237:
        bool1 = false;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a(paramLong);
  }
  
  public void a(Application paramApplication)
  {
    b(paramApplication);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(paramApplication);
    if (this.b != null)
    {
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector);
      this.b.a(paramApplication);
    }
    if (Constant.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationBaseStateDetector.1(this), Constant.i);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] stopDetector. delay:", Boolean.valueOf(paramBoolean) });
    }
    if (Constant.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(paramBoolean);
      if (this.b != null) {
        this.b.a(paramBoolean);
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.c();
    int j;
    if (this.b != null)
    {
      j = this.b.c();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getNewMovementStatus mainStatus:", Integer.valueOf(i), " assistStatus:", Integer.valueOf(j) });
      }
      if ((i == 40001) && (j == 41042)) {
        i = j;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener.a());
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getNewMovementStatus  stepStatus: ", Constant.a(i), " distanceStatus:", Constant.a(j) });
      }
      if (j == 41042) {
        i = j;
      }
      return i;
    }
  }
  
  public void b()
  {
    Object localObject;
    int k;
    int i;
    if (QLog.isColorLevel())
    {
      if (!Constant.jdField_b_of_type_Boolean) {
        break label855;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a();
      k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
      j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
      i = j;
      if (this.b != null)
      {
        int m = this.b.a();
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] mainStatus:", Integer.valueOf(j), " assistStatus:", Integer.valueOf(m) });
        }
        i = j;
        if (j == 40001) {
          if (m != 41012)
          {
            i = j;
            if (m != 41013) {}
          }
          else
          {
            i = m;
          }
        }
      }
      if ((k != 41014) && (k != 41031)) {
        break label867;
      }
    }
    label855:
    label867:
    for (int j = k;; j = i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LOC : ").append(localObject).append("\n").append("          ").append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a()).append("\n").append("          updateTime : ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a()))).append("\n");
      localStringBuilder.append("STEP: ").append(Constant.a(i)).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.b()) })).append("\n");
      if (this.b != null) {
        localStringBuilder.append("STEP2: ").append(Constant.a(i)).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.b.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.b.b()) })).append("\n");
      }
      if (Constant.jdField_b_of_type_Boolean)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnInnerStatusUpdateListener.a());
        localStringBuilder.append("DIST: ").append(Constant.a(i));
      }
      localStringBuilder.append("GPS : ").append(Constant.a(k)).append(" ").append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a()) })).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b()) })).append("\n");
      if ((this.b != null) && (this.b.a() > 0L)) {
        localStringBuilder.append(" walk-time2: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.b.a()))).append("\n");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a() > 0L) {
        localStringBuilder.append(" walk-time: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a()))).append("\n");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b() > 0L) {
        localStringBuilder.append(" still-time: ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b()))).append("\n");
      }
      localStringBuilder.append("LAST: ").append(Constant.a(j)).append(" at ").append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date())).append("\n");
      localStringBuilder.append("CATE: ").append(Constant.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a()));
      localObject = localStringBuilder.toString();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.post(new LocationBaseStateDetector.2(this, (String)localObject));
      }
      QLog.d("LocationBaseStateDetector", 2, "[status][autoLoc] detect. " + (String)localObject);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a();
      break;
    }
  }
  
  public int c()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
    int k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
    int i = k;
    if (this.b != null)
    {
      int m = this.b.a();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getMovementStatus mainStatus:", Integer.valueOf(k), " assistStatus:", Integer.valueOf(m) });
      }
      i = k;
      if (k == 40001) {
        if (m != 41012)
        {
          i = k;
          if (m != 41013) {}
        }
        else
        {
          i = m;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getMovementStatus gpsStatus: ", Constant.a(j), " stepStatus: ", Integer.valueOf(i) });
    }
    if ((j == 41014) || (j == 41031)) {
      i = j;
    }
    return i;
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, "[status][auto] getCategoryStatus return status: " + i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector
 * JD-Core Version:    0.7.0.1
 */