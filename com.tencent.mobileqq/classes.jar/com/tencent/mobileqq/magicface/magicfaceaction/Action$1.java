package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class Action$1
  implements MagicfaceDecoder.MagicPlayListener
{
  Action$1(Action paramAction) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fun startMagicPlay begins, sumPlayTimes:");
      ((StringBuilder)localObject).append(this.a.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(",actionGlobalData.openSound:");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d);
      QLog.d("Action", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_c_of_type_Int == 0)
    {
      this.a.b();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c.length() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e > 0)
        {
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
          ((MagicfacePlayRes)localObject).e -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.a)
      {
        this.a.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h == -1) {
          this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(new long[] { 0L, 1000L }, 0);
        } else {
          this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h * 1000);
        }
      }
    }
    Object localObject = this.a;
    ((Action)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fun startMagicPlay ends, sumPlayTimes:");
      ((StringBuilder)localObject).append(this.a.jdField_c_of_type_Int);
      QLog.d("Action", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func endMagicPlay begins, isStop:");
      localStringBuilder.append(this.a.jdField_c_of_type_Boolean);
      localStringBuilder.append(",timeout:");
      localStringBuilder.append(this.a.jdField_a_of_type_Int);
      localStringBuilder.append(",playTimes:");
      localStringBuilder.append(this.a.jdField_b_of_type_Int);
      localStringBuilder.append(",sumPlayTimes:");
      localStringBuilder.append(this.a.jdField_c_of_type_Int);
      localStringBuilder.append(",isTimeout:");
      localStringBuilder.append(this.a.jdField_b_of_type_Boolean);
      QLog.d("Action", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_c_of_type_Boolean)
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    if (this.a.jdField_a_of_type_Int == -1)
    {
      if (this.a.jdField_b_of_type_Int == -1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
        return;
      }
      if (this.a.jdField_b_of_type_Int > this.a.jdField_c_of_type_Int)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
        return;
      }
      if (this.a.jdField_b_of_type_Int == this.a.jdField_c_of_type_Int)
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
        return;
      }
    }
    if (!this.a.jdField_b_of_type_Boolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action.1
 * JD-Core Version:    0.7.0.1
 */