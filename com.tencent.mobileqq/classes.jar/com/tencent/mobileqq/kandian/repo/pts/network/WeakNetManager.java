package com.tencent.mobileqq.kandian.repo.pts.network;

import android.os.Handler;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.glue.pts.WeakNetHelper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class WeakNetManager
{
  private static WeakNetManager jdField_a_of_type_ComTencentMobileqqKandianRepoPtsNetworkWeakNetManager;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public static WeakNetManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianRepoPtsNetworkWeakNetManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianRepoPtsNetworkWeakNetManager == null) {
          jdField_a_of_type_ComTencentMobileqqKandianRepoPtsNetworkWeakNetManager = new WeakNetManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianRepoPtsNetworkWeakNetManager;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (!WeakNetHelper.a(paramToServiceMsg))
      {
        QLog.d("WeakNetManager", 1, "no need to show toast delay.");
        return;
      }
      long l = WeakNetHelper.a();
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new WeakNetManager.1(this, l);
      }
      RIJThreadHandler.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetManager", 2, "removeCallbacks in showToastDelay.");
      }
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
      RIJThreadHandler.b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
      QLog.d("WeakNetManager", 1, new Object[] { "showToastDelay, delayTime = ", Long.valueOf(l) });
      return;
    }
    finally {}
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == paramToServiceMsg)
      {
        RIJThreadHandler.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = null;
        QLog.d("WeakNetManager", 1, "removeCallbacks in cancelToastRunnable.");
      }
      else
      {
        QLog.d("WeakNetManager", 1, "no need to cancel toastRunnable.");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager
 * JD-Core Version:    0.7.0.1
 */