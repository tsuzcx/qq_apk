package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class PortalManager$4
  extends AvatarObserver
{
  PortalManager$4(PortalManager paramPortalManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateCustomHead isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mobileNumber = ");
      localStringBuilder.append(paramString);
      QLog.d("PortalManagerhead", 2, localStringBuilder.toString());
    }
    if (this.a.a.containsKey(paramString)) {
      ThreadManager.getSubThreadHandler().post(new PortalManager.4.1(this, paramString, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.4
 * JD-Core Version:    0.7.0.1
 */