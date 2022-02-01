package com.tencent.mobileqq.nearby;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NearbyNewRedDotManager$1
  extends RedpointObserver
{
  NearbyNewRedDotManager$1(NearbyNewRedDotManager paramNearbyNewRedDotManager) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NearbyNewRedDotManager", 1, "RedpointObserver.onDataChange: isSucc=" + paramBoolean);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null)
    {
      QLog.i("NearbyNewRedDotManager", 1, "RedpointObserver.onDataChange: is destroy");
      return;
    }
    List localList = this.a.a(localQQAppInterface);
    NearbyNewRedDotManager.a(this.a, localQQAppInterface, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyNewRedDotManager.1
 * JD-Core Version:    0.7.0.1
 */