package com.tencent.mobileqq.magicface.magicfaceaction;

import aemc;
import aemd;
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
  public Vibrator a;
  public ActionGlobalData a;
  public ActionProcess a;
  MagicfaceDecoder.MagicPlayListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = new aemc(this);
  public MagicfacePlayRes a;
  public MagicfacePlayManager a;
  public String a;
  public List a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new aemd(this);
  public CountDownLatch a;
  public boolean a;
  public int b;
  public volatile boolean b;
  public int c;
  public volatile boolean c;
  public boolean d;
  
  public Action()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = ((MagicfacePlayRes)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    MagicfacePlayRes localMagicfacePlayRes;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localMagicfacePlayRes = (MagicfacePlayRes)localIterator.next();
    } while ((localMagicfacePlayRes.jdField_a_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int) || (localMagicfacePlayRes.jdField_b_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = localMagicfacePlayRes;
  }
  
  public void a(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramMagicfaceSensorOperation == null);
        paramMagicfaceSensorOperation.a();
        return;
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString));
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.e = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Int > 0) {
      ThreadManager.getTimer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void b(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramMagicfaceSensorOperation == null);
        d();
        return;
        ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramMagicfaceSensorOperation == null);
    paramMagicfaceSensorOperation.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action
 * JD-Core Version:    0.7.0.1
 */