package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class FileAssistantActivity$6
  extends Handler
{
  FileAssistantActivity$6(FileAssistantActivity paramFileAssistantActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    FileAssistantActivity.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.6
 * JD-Core Version:    0.7.0.1
 */