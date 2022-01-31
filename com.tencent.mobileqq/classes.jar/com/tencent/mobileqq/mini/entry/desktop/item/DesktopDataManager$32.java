package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import bdhb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$32
  implements Runnable
{
  DesktopDataManager$32(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = "/data/data/com.tencent.mobileqq/shared_prefs/" + (String)localObject + "_mini_app_recommend_exposure.xml";
        if ((bdhb.d((String)localObject)) && (QLog.isColorLevel())) {
          QLog.d("DesktopDataManager", 2, "delete : " + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.32
 * JD-Core Version:    0.7.0.1
 */