package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;

class BaseLibManager$1
  implements Runnable
{
  BaseLibManager$1(BaseLibManager paramBaseLibManager, BaseLibManager.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str2 = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "updateBaseLib start. baseLibVersion=" + str2);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "forceUpdateBaseLib current requestVersion is:" + str2);
    MiniAppCmdUtil.getInstance().updateBaseLib(str2, true, true, new BaseLibManager.1.1(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */