package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import mqq.app.AppRuntime;

class FileAssistantActivity$1
  implements Runnable
{
  FileAssistantActivity$1(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.getAppRuntime().getPreferences();
    boolean bool = localSharedPreferences.getBoolean("_file_assistant_guid_tips_", false);
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.this$0.p.getRuntimeService(IQFileConfigManager.class, "");
    this.this$0.T = localIQFileConfigManager.getFileAssistantTipsConfig();
    this.this$0.runOnUiThread(new FileAssistantActivity.1.1(this));
    if (!bool)
    {
      localSharedPreferences.edit().putBoolean("_file_assistant_guid_tips_", true).apply();
      this.this$0.runOnUiThread(new FileAssistantActivity.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1
 * JD-Core Version:    0.7.0.1
 */