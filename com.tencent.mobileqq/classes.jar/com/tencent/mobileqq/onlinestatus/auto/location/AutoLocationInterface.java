package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.location.Location;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler.LocationChangeListener;
import com.tencent.qphone.base.util.QLog;

public class AutoLocationInterface
  implements Handler.Callback, LocationHandler.LocationChangeListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  private AutoLocationInterface.AutoLocationCallback jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface$AutoLocationCallback;
  private LocationHandler jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler = new LocationHandler();
  private int b = 0;
  private int c = Constant.H;
  
  public AutoLocationInterface(AutoLocationInterface.AutoLocationCallback paramAutoLocationCallback, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface$AutoLocationCallback = paramAutoLocationCallback;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] startLocationImpl.");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler.a(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler.a(2000L, false, false);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 10000L);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] stopLocationImpl.");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler.b(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= Constant.H * 2)) {
      this.c = paramInt;
    } else {
      this.c = Constant.H;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, new Object[] { "[status][distance] setDistanceReqTime ", Integer.valueOf(this.c) });
    }
  }
  
  public void a(Location paramLocation, Double paramDouble, boolean paramBoolean)
  {
    float f1 = paramLocation.jdField_a_of_type_Float;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = this.jdField_a_of_type_Float;
    if (f1 > f2 + f3)
    {
      this.b += 1;
      if (this.b > 8L)
      {
        double d = f3;
        Double.isNaN(d);
        this.jdField_a_of_type_Float = ((float)(d + 10.0D));
        this.b = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLocationInterface", 2, new Object[] { "[status][locInterface] ignore location: ", paramLocation, " time:", Integer.valueOf(this.b), " adjust:", Float.valueOf(this.jdField_a_of_type_Float) });
      }
      return;
    }
    this.b = 0;
    if (paramBoolean)
    {
      paramDouble = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationInterface$AutoLocationCallback;
      if (paramDouble != null) {
        paramDouble.a(paramLocation);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b(int paramInt) {}
  
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
          d();
          return false;
        }
      }
      else
      {
        d();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, Constant.H);
        return false;
      }
    }
    else {
      c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AutoLocationInterface
 * JD-Core Version:    0.7.0.1
 */