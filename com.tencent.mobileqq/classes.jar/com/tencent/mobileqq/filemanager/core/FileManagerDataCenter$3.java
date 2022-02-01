package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class FileManagerDataCenter$3
  implements Runnable
{
  FileManagerDataCenter$3(FileManagerDataCenter paramFileManagerDataCenter, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
      return;
    }
    localObject = ((Bundle)localObject).getString("peerUin");
    int i = this.a.getInt("peerType");
    String str1 = this.a.getString("sourceStr");
    String str2 = this.a.getString("filePath");
    long l = this.a.getLong("dataLength");
    int j = this.a.getInt("fileSourceId");
    Bundle localBundle = this.a.getBundle("otherData");
    this.this$0.a((String)localObject, i, str2, l, j, str1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3
 * JD-Core Version:    0.7.0.1
 */