package com.tencent.mobileqq.fragment;

import axoc;
import axut;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class NowLiveFragment$6
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localObject instanceof NearbyAppInterface))
    {
      localObject = (axut)((NearbyAppInterface)localObject).getManager(axoc.i);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowLiveFragment", 2, "pre login now plugin!");
        }
        ((axut)localObject).d();
      }
    }
    while (!QLog.isColorLevel())
    {
      NowLiveFragment.a(true);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("NowLiveFragment", 2, "pre login now plugin! err npb null;");
      return;
    }
    QLog.d("NowLiveFragment", 2, "pre login now plugin! err runtime null or wrong! app = " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.6
 * JD-Core Version:    0.7.0.1
 */