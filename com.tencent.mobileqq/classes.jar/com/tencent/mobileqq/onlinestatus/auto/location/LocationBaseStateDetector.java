package com.tencent.mobileqq.onlinestatus.auto.location;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.OnInnerStatusUpdateListener;
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
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private GPSDistanceDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector;
  private LocationCategoryDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector;
  private StepMovementDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector;
  private VehicleMovementDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector;
  private AutoStatusManager.OnInnerStatusUpdateListener jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener;
  private StepMovementDetector b;
  
  public LocationBaseStateDetector(AppInterface paramAppInterface, AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener = paramOnInnerStatusUpdateListener;
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
      if (bool1) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepSensorDetector();
      } else if (Constant.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new AccelerometerDetector();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepEmptySensor();
      }
      if ((Constant.jdField_b_of_type_Int == 3) && (bool2)) {
        this.b = new StepSensorCounter();
      }
      if (QLog.isColorLevel())
      {
        paramApplication = new StringBuilder();
        paramApplication.append("[status][step] initStepDetector mainSensor: ");
        paramApplication.append(Constant.jdField_a_of_type_Int);
        paramApplication.append(" secondarySensor: ");
        paramApplication.append(Constant.jdField_b_of_type_Int);
        paramApplication.append(" hasDetector: ");
        paramApplication.append(bool1);
        paramApplication.append(" hasCounter: ");
        paramApplication.append(bool2);
        paramApplication.append(" final sensor: ");
        paramApplication.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a());
        QLog.d("LocationBaseStateDetector", 2, paramApplication.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector compatibility. API<19 ACCELEROMETER");
      }
      if (Constant.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new AccelerometerDetector();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector = new StepEmptySensor();
      }
    }
    if (Constant.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(this);
      paramApplication = this.b;
      if (paramApplication != null) {
        paramApplication.a(this);
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
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null)
    {
      long l = ((IOnlineStatusService)((AppInterface)localObject).getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
      if ((l >= 40001L) && (l != 41042L) && (b() == 41042)) {
        if (ProcessUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp())) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener.a();
        }
      }
      for (;;)
      {
        bool1 = true;
        break label228;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LocationBaseStateDetector", 2, "[status][auto] notifyCheckStatus background");
        break;
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
        localObject = this.b;
        if ((localObject != null) && (!((StepMovementDetector)localObject).a())) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.b();
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus step1:", Boolean.valueOf(bool2), " step2:", Boolean.valueOf(bool1), " dist:", Boolean.valueOf(bool3) });
        }
        if ((!bool2) || (!bool1) || (!bool3)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener.a();
      }
      boolean bool1 = false;
      label228:
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus ", Boolean.valueOf(bool1) });
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
    StepMovementDetector localStepMovementDetector = this.b;
    if (localStepMovementDetector != null)
    {
      localStepMovementDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector);
      this.b.a(paramApplication);
    }
    if (Constant.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationBaseStateDetector.1(this), Constant.i);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] stopDetector. delay:", Boolean.valueOf(paramBoolean) });
    }
    if (Constant.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.b();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a(paramBoolean);
    StepMovementDetector localStepMovementDetector = this.b;
    if (localStepMovementDetector != null) {
      localStepMovementDetector.a(paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.c();
    StepMovementDetector localStepMovementDetector = this.b;
    int i = j;
    if (localStepMovementDetector != null)
    {
      int k = localStepMovementDetector.c();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getNewMovementStatus mainStatus:", Integer.valueOf(j), " assistStatus:", Integer.valueOf(k) });
      }
      i = j;
      if (j == 40001)
      {
        i = j;
        if (k == 41042) {
          i = k;
        }
      }
    }
    j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener.a());
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getNewMovementStatus  stepStatus: ", Constant.a(i), " distanceStatus:", Constant.a(j) });
    }
    if (j == 41042) {
      i = j;
    }
    return i;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      if (Constant.jdField_b_of_type_Boolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a();
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a();
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
      int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
      Object localObject2 = this.b;
      int i = j;
      if (localObject2 != null)
      {
        int m = ((StepMovementDetector)localObject2).a();
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
        j = i;
      } else {
        j = k;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LOC : ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("          ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a());
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("          updateTime : ");
      ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a())));
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("STEP: ");
      ((StringBuilder)localObject2).append(Constant.a(i));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a()) }));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.b()) }));
      ((StringBuilder)localObject2).append("\n");
      if (this.b != null)
      {
        ((StringBuilder)localObject2).append("STEP2: ");
        ((StringBuilder)localObject2).append(Constant.a(i));
        ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.b.a()) }));
        ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.b.b()) }));
        ((StringBuilder)localObject2).append("\n");
      }
      if (Constant.jdField_b_of_type_Boolean)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationGPSDistanceDetector.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnInnerStatusUpdateListener.a());
        ((StringBuilder)localObject2).append("DIST: ");
        ((StringBuilder)localObject2).append(Constant.a(i));
      }
      ((StringBuilder)localObject2).append("GPS : ");
      ((StringBuilder)localObject2).append(Constant.a(k));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.a()) }));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b()) }));
      ((StringBuilder)localObject2).append("\n");
      Object localObject1 = this.b;
      if ((localObject1 != null) && (((StepMovementDetector)localObject1).a() > 0L))
      {
        ((StringBuilder)localObject2).append(" walk-time2: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.b.a())));
        ((StringBuilder)localObject2).append("\n");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a() > 0L)
      {
        ((StringBuilder)localObject2).append(" walk-time: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a())));
        ((StringBuilder)localObject2).append("\n");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b() > 0L)
      {
        ((StringBuilder)localObject2).append(" still-time: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b())));
        ((StringBuilder)localObject2).append("\n");
      }
      ((StringBuilder)localObject2).append("LAST: ");
      ((StringBuilder)localObject2).append(Constant.a(j));
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()));
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("CATE: ");
      ((StringBuilder)localObject2).append(Constant.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a()));
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null) {
        ((TextView)localObject2).post(new LocationBaseStateDetector.2(this, (String)localObject1));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[status][autoLoc] detect. ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("LocationBaseStateDetector", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public int c()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationVehicleMovementDetector.b();
    int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector.a();
    StepMovementDetector localStepMovementDetector = this.b;
    int i = j;
    if (localStepMovementDetector != null)
    {
      int m = localStepMovementDetector.a();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getMovementStatus mainStatus:", Integer.valueOf(j), " assistStatus:", Integer.valueOf(m) });
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
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getMovementStatus gpsStatus: ", Constant.a(k), " stepStatus: ", Integer.valueOf(i) });
    }
    j = k;
    if (k != 41014)
    {
      if (k == 41031) {
        return k;
      }
      j = i;
    }
    return j;
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationCategoryDetector.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][auto] getCategoryStatus return status: ");
      localStringBuilder.append(i);
      QLog.d("LocationBaseStateDetector", 2, localStringBuilder.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector
 * JD-Core Version:    0.7.0.1
 */