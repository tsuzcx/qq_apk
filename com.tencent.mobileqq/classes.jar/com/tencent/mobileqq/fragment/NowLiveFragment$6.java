package com.tencent.mobileqq.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class NowLiveFragment$6
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localObject instanceof INearbyAppInterface))
    {
      localObject = (INearbyProcManager)((INearbyAppInterface)localObject).getManager(NearbyConstants.g);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowLiveFragment", 2, "pre login now plugin!");
        }
        ((INearbyProcManager)localObject).d();
        NowLiveFragment.a(true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveFragment", 2, "pre login now plugin! err npb null;");
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre login now plugin! err runtime null or wrong! app = ");
      localStringBuilder.append(localObject);
      QLog.d("NowLiveFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.6
 * JD-Core Version:    0.7.0.1
 */