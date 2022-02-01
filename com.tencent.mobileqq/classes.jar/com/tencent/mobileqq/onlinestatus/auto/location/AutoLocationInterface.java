package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler.LocationChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AutoLocationInterface
  implements Handler.Callback, LocationHandler.LocationChangeListener
{
  private LocationHandler a = new LocationHandler();
  private Handler b = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  private AutoLocationInterface.AutoLocationCallback c;
  private final int d;
  private float e = 0.0F;
  private int f = 0;
  private int g = Constant.I;
  
  public AutoLocationInterface(AutoLocationInterface.AutoLocationCallback paramAutoLocationCallback, int paramInt)
  {
    this.c = paramAutoLocationCallback;
    this.d = paramInt;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] startLocationImpl.");
    }
    this.b.removeMessages(1);
    this.a.a(this);
    this.a.a(2000L, false, false);
    this.b.sendEmptyMessageDelayed(2, 10000L);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] stopLocationImpl.");
    }
    this.b.removeMessages(3);
    this.b.removeMessages(2);
    this.a.b(this);
    this.a.a();
  }
  
  public void a()
  {
    this.b.removeCallbacksAndMessages(null);
    this.b.sendEmptyMessage(1);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= Constant.I * 2)) {
      this.g = paramInt;
    } else {
      this.g = Constant.I;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, new Object[] { "[status][distance] setDistanceReqTime ", Integer.valueOf(this.g) });
    }
  }
  
  public void a(Location paramLocation, Double paramDouble, boolean paramBoolean)
  {
    float f1 = paramLocation.c;
    float f2 = this.d;
    float f3 = this.e;
    if (f1 > f2 + f3)
    {
      this.f += 1;
      if (this.f > 8L)
      {
        double d1 = f3;
        Double.isNaN(d1);
        this.e = ((float)(d1 + 10.0D));
        this.f = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLocationInterface", 2, new Object[] { "[status][locInterface] ignore location: ", paramLocation, " time:", Integer.valueOf(this.f), " adjust:", Float.valueOf(this.e) });
      }
      return;
    }
    this.f = 0;
    if (paramBoolean)
    {
      paramDouble = this.c;
      if (paramDouble != null) {
        paramDouble.a(paramLocation);
      }
    }
    this.b.sendEmptyMessage(2);
  }
  
  public void b()
  {
    this.b.removeCallbacksAndMessages(null);
    this.b.sendEmptyMessage(3);
  }
  
  public void b(int paramInt) {}
  
  public boolean c()
  {
    boolean bool;
    if ((GuardManager.sInstance != null) && (GuardManager.sInstance.isApplicationForeground())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][locInterface] isAppForeground：");
      localStringBuilder.append(bool);
      QLog.d("AutoLocationInterface", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean d()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 23) {
      i = BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    } else {
      i = 0;
    }
    if (i == 0) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][locInterface] isLocationGranted：");
      localStringBuilder.append(bool);
      QLog.d("AutoLocationInterface", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("AutoLocationInterface", 2, new Object[] { "unKnow msg:", Integer.valueOf(paramMessage.what) });
            return false;
          }
        }
        else
        {
          f();
          return false;
        }
      }
      else
      {
        f();
        this.b.removeMessages(1);
        this.b.sendEmptyMessageDelayed(1, Constant.I);
        return false;
      }
    }
    else if ((c()) && (d())) {
      e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AutoLocationInterface
 * JD-Core Version:    0.7.0.1
 */