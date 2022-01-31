package com.tencent.mobileqq.fragment;

import atfx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class NearbyHybridFragment$2
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = localAppRuntime;
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getAppRuntime("module_nearby");
    }
    if ((localObject instanceof NearbyAppInterface))
    {
      localObject = (atfx)((NearbyAppInterface)localObject).getManager(214);
      if (localObject != null)
      {
        NearbyHybridFragment.m = true;
        ((atfx)localObject).c();
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment", 2, "pre load now plugin!");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyHybridFragment", 2, "pre load now plugin! err npb null;");
      return;
    }
    QLog.d("nearby.NearbyHybridFragment", 2, "pre load now plugin! err runtime null or wrong! app = " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.2
 * JD-Core Version:    0.7.0.1
 */