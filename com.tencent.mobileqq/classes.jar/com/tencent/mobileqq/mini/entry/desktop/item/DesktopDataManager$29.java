package com.tencent.mobileqq.mini.entry.desktop.item;

import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$29
  implements Runnable
{
  DesktopDataManager$29(DesktopDataManager paramDesktopDataManager, MiniAppRedDotEntity paramMiniAppRedDotEntity) {}
  
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
    if (DesktopDataManager.access$3400(this.this$0, (awgf)localObject, this.val$entity))
    {
      QLog.d("DesktopDataManager", 1, "updateRedDotData, success to delete recommend appInfo: " + this.val$entity);
      return;
    }
    QLog.e("DesktopDataManager", 1, "updateRedDotData, failed to delete recommend appInfo: " + this.val$entity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.29
 * JD-Core Version:    0.7.0.1
 */