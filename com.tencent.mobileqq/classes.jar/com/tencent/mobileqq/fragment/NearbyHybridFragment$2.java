package com.tencent.mobileqq.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class NearbyHybridFragment$2
  implements Runnable
{
  public void run()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getAppRuntime("module_nearby");
    }
    if ((localObject1 instanceof INearbyAppInterface))
    {
      localObject1 = (INearbyProcManager)((INearbyAppInterface)localObject1).getManager(NearbyConstants.e);
      if (localObject1 != null)
      {
        NearbyHybridFragment.k = true;
        ((INearbyProcManager)localObject1).b();
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment", 2, "pre load now plugin!");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "pre load now plugin! err npb null;");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pre load now plugin! err runtime null or wrong! app = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.2
 * JD-Core Version:    0.7.0.1
 */