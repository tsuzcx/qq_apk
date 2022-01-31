package com.tencent.mobileqq.filemanager.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aptp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class FileAssistantBannerSetting$3
  implements Runnable
{
  public FileAssistantBannerSetting$3(aptp paramaptp) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("FAB_sp_file" + aptp.a(this.this$0).getCurrentAccountUin(), 4).edit().putLong("_keyFAB_local_first_show_time", aptp.a(this.this$0)).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.3
 * JD-Core Version:    0.7.0.1
 */