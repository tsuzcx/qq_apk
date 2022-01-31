package com.tencent.mobileqq.mini.entry.desktop.item;

import aukp;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$28
  implements Runnable
{
  DesktopDataManager$28(DesktopDataManager paramDesktopDataManager, MiniAppRedDotEntity paramMiniAppRedDotEntity) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "updateRedDotData, app is null.");
    }
    do
    {
      return;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    if (DesktopDataManager.access$3300(this.this$0, (aukp)localObject, this.val$entity))
    {
      QLog.d("DesktopDataManager", 1, "updateRedDotData, success to delete recommend appInfo: " + this.val$entity);
      return;
    }
    QLog.e("DesktopDataManager", 1, "updateRedDotData, failed to delete recommend appInfo: " + this.val$entity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.28
 * JD-Core Version:    0.7.0.1
 */