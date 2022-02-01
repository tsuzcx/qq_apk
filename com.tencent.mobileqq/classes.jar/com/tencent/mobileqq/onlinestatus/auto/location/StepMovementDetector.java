package com.tencent.mobileqq.onlinestatus.auto.location;

import android.app.Application;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;

public abstract class StepMovementDetector
  implements SensorEventListener, Handler.Callback
{
  protected volatile double a;
  protected int a;
  protected long a;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected volatile AutoStatus a;
  private AutoLocationCheckListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener;
  private AverageSampler jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler = new AverageSampler("step", Constant.B);
  private StepMovementDetector.StepDurationObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector$StepDurationObserver;
  protected String a;
  private double b;
  protected int b;
  protected long b;
  private double jdField_c_of_type_Double = 0.0D;
  protected int c;
  private long jdField_c_of_type_Long = 0L;
  private volatile int d;
  
  StepMovementDetector(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "SensorMovementDetector";
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a(new StepMovementDetector.1(this));
    this.d = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    this.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] realStopDetector");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_c_of_type_Double = 0.0D;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] resetTimeAndStep time:", Long.valueOf(this.jdField_a_of_type_Long), " lastDetectTime:", Double.valueOf(this.jdField_a_of_type_Double) });
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void e()
  {
    boolean bool = a();
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] notifyCheckStatus notmoving:", Boolean.valueOf(bool), " status:", Constant.a(i) });
    }
    if ((!bool) && (i != 41042))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] notifyCheckStatus ismoving or not right status");
      }
    }
    else
    {
      AutoLocationCheckListener localAutoLocationCheckListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener;
      if (localAutoLocationCheckListener != null)
      {
        localAutoLocationCheckListener.a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] notifyCheckStatus listener empty");
      }
    }
  }
  
  double a()
  {
    return this.jdField_c_of_type_Double;
  }
  
  public int a()
  {
    double d1 = System.currentTimeMillis();
    double d2 = this.jdField_a_of_type_Double;
    Double.isNaN(d1);
    d1 -= d2;
    if ((this.jdField_a_of_type_Double > 0.0D) && (d1 > Constant.y * Constant.B))
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] reset internal: ");
        localStringBuilder.append(d1);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.jdField_a_of_type_Int;
  }
  
  long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Double > 0.0D)
      {
        double d1 = l;
        double d2 = this.jdField_a_of_type_Double;
        Double.isNaN(d1);
        d1 -= d2;
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAverageSampler.a(d1);
        this.jdField_b_of_type_Double = d1;
      }
      this.jdField_a_of_type_Double = l;
      a(1);
      return;
    }
    finally {}
  }
  
  void a(double paramDouble)
  {
    String str;
    StringBuilder localStringBuilder;
    if ((paramDouble > Constant.z) && (paramDouble < Constant.A))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_RUNNING");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41013);
    }
    else if ((paramDouble > Constant.x) && (paramDouble < Constant.y))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_WALKING");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41012);
    }
    else if ((paramDouble > Constant.A) && (paramDouble < Constant.x))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_WALKING fast");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.jdField_a_of_type_Int == 40001) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(41012);
      }
    }
    else if (paramDouble > Constant.y)
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_IDLE");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a();
    }
    else if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] onTriggered too quick average: ");
      localStringBuilder.append(paramDouble);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    b();
    this.jdField_c_of_type_Double = paramDouble;
  }
  
  protected void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      d();
    }
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int += paramInt;
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 60000L)
    {
      this.jdField_a_of_type_Int += paramInt;
      return;
    }
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long > 60000L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L))
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_a_of_type_Long), " step:", Integer.valueOf(paramInt) });
      }
    }
    else
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 60000L);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_a_of_type_Long), " step:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  void a(Application paramApplication)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] startDetect sensor: ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      d();
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      if (QLog.isColorLevel())
      {
        paramApplication = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][step] already startDetect sensor: ");
        ((StringBuilder)localObject).append(getClass().getSimpleName());
        QLog.d(paramApplication, 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      a(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramApplication.getApplicationContext().getSystemService("sensor"));
    paramApplication = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(this.d);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, paramApplication, 2);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("step");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(0);
  }
  
  public void a(AutoLocationCheckListener paramAutoLocationCheckListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener = paramAutoLocationCheckListener;
  }
  
  void a(StepMovementDetector.StepDurationObserver paramStepDurationObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector$StepDurationObserver = paramStepDurationObserver;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] stopDetect sensor: ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d(str, 2, new Object[] { localStringBuilder.toString(), " delay:", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
    } else {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    c();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] isNotMoving mLast1MinSteps ", Integer.valueOf(this.jdField_a_of_type_Int), " last2:", Integer.valueOf(this.jdField_b_of_type_Int), " time:", Long.valueOf(this.jdField_b_of_type_Long) });
    }
    return (this.jdField_b_of_type_Int < Constant.M) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 60000L) && (this.jdField_a_of_type_Int < Constant.M) && (this.jdField_b_of_type_Long > 0L);
  }
  
  double b()
  {
    double d1 = System.currentTimeMillis();
    double d2 = this.jdField_a_of_type_Double;
    Double.isNaN(d1);
    d1 -= d2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] getLastRealTimeInternal internal:", Double.valueOf(d1), " mLastRealTimeInternal:", Double.valueOf(this.jdField_b_of_type_Double) });
    }
    if ((this.jdField_a_of_type_Double > 0.0D) && (d1 > Constant.y * Constant.B)) {
      return d1;
    }
    return this.jdField_b_of_type_Double;
  }
  
  public int b()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] timeout ", Long.valueOf(this.jdField_a_of_type_Long) });
      }
      return 70000;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] check ", Integer.valueOf(this.jdField_a_of_type_Int), " ", Integer.valueOf(this.jdField_b_of_type_Int), " ", Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if ((this.jdField_a_of_type_Int < Constant.M) && (this.jdField_b_of_type_Int < Constant.M))
    {
      if (this.jdField_c_of_type_Int >= Constant.M) {
        return 0;
      }
      return 70000;
    }
    return 0;
  }
  
  boolean b()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.jdField_a_of_type_Int != 41012) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.jdField_a_of_type_Int != 41013))
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] recordStepStartTime. stop status: ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_c_of_type_Long = 0L;
      return false;
    }
    if (this.jdField_c_of_type_Long <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] recordStepStartTime. start step mStatus: ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector$StepDurationObserver;
    if ((localObject != null) && (((StepMovementDetector.StepDurationObserver)localObject).a()))
    {
      long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
      if (l >= this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector$StepDurationObserver.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] mDurationObserver onTriggered start:", Long.valueOf(this.jdField_c_of_type_Long), " duration:", Long.valueOf(l) });
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationStepMovementDetector$StepDurationObserver.a(this.jdField_c_of_type_Long, l);
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int j = 40001;
    if (l1 - l2 > 180000L)
    {
      d();
      return 40001;
    }
    int i;
    if (this.jdField_a_of_type_Int < Constant.M)
    {
      i = j;
      if (this.jdField_b_of_type_Int < Constant.M) {}
    }
    else
    {
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      i = j;
      if (l1 - l2 > 60000L)
      {
        i = j;
        if (l2 > 0L) {
          i = 41042;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] getStatusNew last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_b_of_type_Long) });
    }
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationAutoLocationCheckListener != null)) {
        e();
      }
    }
    else {
      b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepMovementDetector
 * JD-Core Version:    0.7.0.1
 */