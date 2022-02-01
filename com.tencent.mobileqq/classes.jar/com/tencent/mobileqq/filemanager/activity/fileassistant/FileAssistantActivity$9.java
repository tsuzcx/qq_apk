package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

class FileAssistantActivity$9
  extends GameCenterObserver
{
  FileAssistantActivity$9(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch get push GameCenterObserver ");
    paramBundle = this.a.a.obtainMessage(1);
    this.a.a.sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.9
 * JD-Core Version:    0.7.0.1
 */