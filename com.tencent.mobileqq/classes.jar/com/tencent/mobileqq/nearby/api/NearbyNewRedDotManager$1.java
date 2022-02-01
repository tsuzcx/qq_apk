package com.tencent.mobileqq.nearby.api;

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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RedpointObserver.onDataChange: isSucc=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("NearbyNewRedDotManager", 1, ((StringBuilder)localObject).toString());
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      QLog.i("NearbyNewRedDotManager", 1, "RedpointObserver.onDataChange: is destroy");
      return;
    }
    List localList = this.a.c((QQAppInterface)localObject);
    NearbyNewRedDotManager.a(this.a, (QQAppInterface)localObject, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyNewRedDotManager.1
 * JD-Core Version:    0.7.0.1
 */