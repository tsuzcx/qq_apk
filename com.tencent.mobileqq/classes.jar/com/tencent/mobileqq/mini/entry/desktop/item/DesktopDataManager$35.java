package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$35
  implements Runnable
{
  DesktopDataManager$35(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/data/data/com.tencent.mobileqq/shared_prefs/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("_mini_app_recommend_exposure.xml");
        localObject = localStringBuilder.toString();
        if ((FileUtils.deleteFile((String)localObject)) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete : ");
          localStringBuilder.append((String)localObject);
          QLog.d("DesktopDataManager", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.35
 * JD-Core Version:    0.7.0.1
 */