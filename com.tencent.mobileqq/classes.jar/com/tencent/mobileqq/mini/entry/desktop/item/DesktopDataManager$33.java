package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$33
  implements Runnable
{
  DesktopDataManager$33(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = "/data/data/com.tencent.mobileqq/shared_prefs/" + (String)localObject + "_mini_app_recommend_exposure.xml";
        if ((FileUtils.deleteFile((String)localObject)) && (QLog.isColorLevel())) {
          QLog.d("DesktopDataManager", 2, "delete : " + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.33
 * JD-Core Version:    0.7.0.1
 */