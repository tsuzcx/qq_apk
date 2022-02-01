package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Action
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public ActionGlobalData a;
  public ActionProcess a;
  MagicfaceDecoder.MagicPlayListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = new Action.1(this);
  MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  public MagicfacePlayManager a;
  public String a;
  public List<MagicfacePlayRes> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d = false;
  
  public Action()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = ((MagicfacePlayRes)this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    if ((i > 1) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int >= 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MagicfacePlayRes localMagicfacePlayRes = (MagicfacePlayRes)localIterator.next();
        if ((localMagicfacePlayRes.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int) && (localMagicfacePlayRes.jdField_b_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = localMagicfacePlayRes;
        }
      }
    }
  }
  
  public void a(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
    if (localObject == null) {
      return;
    }
    int j = ((ActionProcess)localObject).jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int > 0)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int < 40) {
        i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int * 2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("==stopValue=");
      ((StringBuilder)localObject).append(i);
      QLog.i("Action", 2, ((StringBuilder)localObject).toString());
    }
    if ("end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString))
    {
      if (paramInt >= i) {
        d();
      }
      return;
    }
    if (("stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString)) && (paramInt >= i) && ("mic".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString)))
    {
      d();
      if (paramMagicfaceSensorOperation != null) {
        paramMagicfaceSensorOperation.a();
      }
    }
    else if ("record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString))
    {
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)
      {
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
        paramMagicfaceSensorOperation.e = paramMagicfaceSensorOperation.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
      }
    }
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.g);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsVibrator.cancel();
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Int > 0) {
      ThreadManager.getTimer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void b(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
    if (localActionProcess == null) {
      return;
    }
    if ("end".equalsIgnoreCase(localActionProcess.jdField_c_of_type_JavaLangString))
    {
      if (paramMagicfaceSensorOperation != null) {
        d();
      }
      return;
    }
    if (("stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString)) && ("touch".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int == paramInt))
    {
      d();
      if (paramMagicfaceSensorOperation != null) {
        paramMagicfaceSensorOperation.a();
      }
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action
 * JD-Core Version:    0.7.0.1
 */