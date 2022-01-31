package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class FileAssistantActivity$1
  implements Runnable
{
  FileAssistantActivity$1(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.app.getPreferences();
    if (!localSharedPreferences.getBoolean("_file_assistant_guid_tips_", false))
    {
      localSharedPreferences.edit().putBoolean("_file_assistant_guid_tips_", true).apply();
      this.this$0.runOnUiThread(new FileAssistantActivity.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1
 * JD-Core Version:    0.7.0.1
 */