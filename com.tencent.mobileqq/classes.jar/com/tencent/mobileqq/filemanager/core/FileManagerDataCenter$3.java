package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class FileManagerDataCenter$3
  implements Runnable
{
  FileManagerDataCenter$3(FileManagerDataCenter paramFileManagerDataCenter, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
      return;
    }
    String str1 = this.a.getString("peerUin");
    int i = this.a.getInt("peerType");
    String str2 = this.a.getString("sourceStr");
    String str3 = this.a.getString("filePath");
    long l = this.a.getLong("dataLength");
    int j = this.a.getInt("fileSourceId");
    Bundle localBundle = this.a.getBundle("otherData");
    this.this$0.a(str1, i, str3, l, j, str2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3
 * JD-Core Version:    0.7.0.1
 */