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
  private StepMovementDetector a;
  private StepMovementDetector b;
  private VehicleMovementDetector c;
  private LocationCategoryDetector d;
  private GPSDistanceDetector e;
  private TextView f;
  private Handler g = new Handler(ThreadManagerV2.getSubThreadLooper());
  private AutoStatusManager.OnInnerStatusUpdateListener h;
  private AppInterface i;
  
  public LocationBaseStateDetector(AppInterface paramAppInterface, AutoStatusManager.OnInnerStatusUpdateListener paramOnInnerStatusUpdateListener)
  {
    this.i = paramAppInterface;
    this.h = paramOnInnerStatusUpdateListener;
    this.c = new VehicleMovementDetector();
    this.d = new LocationCategoryDetector(paramOnInnerStatusUpdateListener);
    this.e = new GPSDistanceDetector();
  }
  
  private void b(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool1 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
      boolean bool2 = paramApplication.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
      if (bool1) {
        this.a = new StepSensorDetector();
      } else if (Constant.O) {
        this.a = new AccelerometerDetector();
      } else {
        this.a = new StepEmptySensor();
      }
      if ((Constant.b == 3) && (bool2)) {
        this.b = new StepSensorCounter();
      }
      if (QLog.isColorLevel())
      {
        paramApplication = new StringBuilder();
        paramApplication.append("[status][step] initStepDetector mainSensor: ");
        paramApplication.append(Constant.a);
        paramApplication.append(" secondarySensor: ");
        paramApplication.append(Constant.b);
        paramApplication.append(" hasDetector: ");
        paramApplication.append(bool1);
        paramApplication.append(" hasCounter: ");
        paramApplication.append(bool2);
        paramApplication.append(" final sensor: ");
        paramApplication.append(this.a.j());
        QLog.d("LocationBaseStateDetector", 2, paramApplication.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, "[status][step] initStepDetector compatibility. API<19 ACCELEROMETER");
      }
      if (Constant.O) {
        this.a = new AccelerometerDetector();
      } else {
        this.a = new StepEmptySensor();
      }
    }
    if (Constant.P)
    {
      this.e.a(this);
      this.a.a(this);
      paramApplication = this.b;
      if (paramApplication != null) {
        paramApplication.a(this);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      long l = ((IOnlineStatusService)((AppInterface)localObject).getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
      if ((l >= 40001L) && (l != 41042L) && (d() == 41042)) {
        if (ProcessUtil.a(this.i.getApp())) {
          this.h.a();
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
        boolean bool2 = this.a.e();
        localObject = this.b;
        if ((localObject != null) && (!((StepMovementDetector)localObject).e())) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        boolean bool3 = this.e.e();
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][auto] notifyCheckStatus step1:", Boolean.valueOf(bool2), " step2:", Boolean.valueOf(bool1), " dist:", Boolean.valueOf(bool3) });
        }
        if ((!bool2) || (!bool1) || (!bool3)) {
          break;
        }
        this.h.a();
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
    this.d.a(paramLong);
  }
  
  public void a(Application paramApplication)
  {
    b(paramApplication);
    this.a.a(this.c);
    this.a.a(paramApplication);
    StepMovementDetector localStepMovementDetector = this.b;
    if (localStepMovementDetector != null)
    {
      localStepMovementDetector.a(this.c);
      this.b.a(paramApplication);
    }
    if (Constant.P) {
      this.e.a();
    } else {
      this.c.c();
    }
    this.g.postDelayed(new LocationBaseStateDetector.1(this), Constant.j);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] stopDetector. delay:", Boolean.valueOf(paramBoolean) });
    }
    if (Constant.P) {
      this.e.b();
    } else {
      this.c.d();
    }
    this.a.a(paramBoolean);
    StepMovementDetector localStepMovementDetector = this.b;
    if (localStepMovementDetector != null) {
      localStepMovementDetector.a(paramBoolean);
    }
    this.d.b();
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      if (Constant.P) {
        localObject1 = this.e.f();
      } else {
        localObject1 = this.c.f();
      }
      int m = this.c.j();
      int k = this.a.c();
      Object localObject2 = this.b;
      int j = k;
      if (localObject2 != null)
      {
        int n = ((StepMovementDetector)localObject2).c();
        if (QLog.isColorLevel()) {
          QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] mainStatus:", Integer.valueOf(k), " assistStatus:", Integer.valueOf(n) });
        }
        j = k;
        if (k == 40001) {
          if (n != 41012)
          {
            j = k;
            if (n != 41013) {}
          }
          else
          {
            j = n;
          }
        }
      }
      if ((m != 41014) && (m != 41031)) {
        k = j;
      } else {
        k = m;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LOC : ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("          ");
      ((StringBuilder)localObject2).append(this.d.c());
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("          updateTime : ");
      ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.c.e())));
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("STEP: ");
      ((StringBuilder)localObject2).append(Constant.c(j));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.a.a()) }));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.a.b()) }));
      ((StringBuilder)localObject2).append("\n");
      if (this.b != null)
      {
        ((StringBuilder)localObject2).append("STEP2: ");
        ((StringBuilder)localObject2).append(Constant.c(j));
        ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.b.a()) }));
        ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.b.b()) }));
        ((StringBuilder)localObject2).append("\n");
      }
      if (Constant.P)
      {
        j = this.e.a(this.h.b());
        ((StringBuilder)localObject2).append("DIST: ");
        ((StringBuilder)localObject2).append(Constant.c(j));
      }
      ((StringBuilder)localObject2).append("GPS : ");
      ((StringBuilder)localObject2).append(Constant.c(m));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " sample: %.2f", new Object[] { Double.valueOf(this.c.h()) }));
      ((StringBuilder)localObject2).append(String.format(Locale.getDefault(), " realtime: %.2f", new Object[] { Double.valueOf(this.c.i()) }));
      ((StringBuilder)localObject2).append("\n");
      Object localObject1 = this.b;
      if ((localObject1 != null) && (((StepMovementDetector)localObject1).h() > 0L))
      {
        ((StringBuilder)localObject2).append(" walk-time2: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.b.h())));
        ((StringBuilder)localObject2).append("\n");
      }
      if (this.a.h() > 0L)
      {
        ((StringBuilder)localObject2).append(" walk-time: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.a.h())));
        ((StringBuilder)localObject2).append("\n");
      }
      if (this.c.g() > 0L)
      {
        ((StringBuilder)localObject2).append(" still-time: ");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.c.g())));
        ((StringBuilder)localObject2).append("\n");
      }
      ((StringBuilder)localObject2).append("LAST: ");
      ((StringBuilder)localObject2).append(Constant.c(k));
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()));
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append("CATE: ");
      ((StringBuilder)localObject2).append(Constant.c(this.d.a()));
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.f;
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
    int j = this.a.d();
    int k = this.e.h();
    if ((j == 0) && (k == 0)) {
      return 0;
    }
    return Math.max(k, j);
  }
  
  public int d()
  {
    int k = this.a.f();
    StepMovementDetector localStepMovementDetector = this.b;
    int j = k;
    if (localStepMovementDetector != null)
    {
      int m = localStepMovementDetector.f();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getNewMovementStatus mainStatus:", Integer.valueOf(k), " assistStatus:", Integer.valueOf(m) });
      }
      j = k;
      if (k == 40001)
      {
        j = k;
        if (m == 41042) {
          j = m;
        }
      }
    }
    k = this.e.a(this.h.b());
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getNewMovementStatus  stepStatus: ", Constant.c(j), " distanceStatus:", Constant.c(k) });
    }
    if (k == 41042) {
      j = k;
    }
    return j;
  }
  
  public int e()
  {
    int m = this.c.j();
    int k = this.a.c();
    StepMovementDetector localStepMovementDetector = this.b;
    int j = k;
    if (localStepMovementDetector != null)
    {
      int n = localStepMovementDetector.c();
      if (QLog.isColorLevel()) {
        QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][step] getMovementStatus mainStatus:", Integer.valueOf(k), " assistStatus:", Integer.valueOf(n) });
      }
      j = k;
      if (k == 40001) {
        if (n != 41012)
        {
          j = k;
          if (n != 41013) {}
        }
        else
        {
          j = n;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationBaseStateDetector", 2, new Object[] { "[status][autoLoc] getMovementStatus gpsStatus: ", Constant.c(m), " stepStatus: ", Integer.valueOf(j) });
    }
    k = m;
    if (m != 41014)
    {
      if (m == 41031) {
        return m;
      }
      k = j;
    }
    return k;
  }
  
  public int f()
  {
    int j = this.d.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][auto] getCategoryStatus return status: ");
      localStringBuilder.append(j);
      QLog.d("LocationBaseStateDetector", 2, localStringBuilder.toString());
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector
 * JD-Core Version:    0.7.0.1
 */