package com.tencent.mobileqq.filemanager.settings;

import android.content.SharedPreferences;
import aptp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class FileAssistantBannerSetting$1
  implements Runnable
{
  public FileAssistantBannerSetting$1(aptp paramaptp) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("FAB_sp_file" + aptp.a(this.this$0).getCurrentAccountUin(), 4);
    aptp.a(this.this$0, localSharedPreferences.getLong("_keyFAB_local_first_show_time", 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.1
 * JD-Core Version:    0.7.0.1
 */