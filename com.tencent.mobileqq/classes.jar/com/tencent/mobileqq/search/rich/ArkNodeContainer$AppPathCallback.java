package com.tencent.mobileqq.search.rich;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class ArkNodeContainer$AppPathCallback
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<ArkNodeContainer> a;
  
  public ArkNodeContainer$AppPathCallback(ArkNodeContainer paramArkNodeContainer)
  {
    this.a = new WeakReference(paramArkNodeContainer);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    ArkNodeContainer localArkNodeContainer = (ArkNodeContainer)this.a.get();
    if (localArkNodeContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localArkNodeContainer.onGetAppPathByName(paramInt, paramString, paramAppPathInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeContainer.AppPathCallback
 * JD-Core Version:    0.7.0.1
 */