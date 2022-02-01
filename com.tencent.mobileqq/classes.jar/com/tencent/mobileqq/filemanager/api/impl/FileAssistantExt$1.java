package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

class FileAssistantExt$1
  extends GameCenterObserver
{
  FileAssistantExt$1(FileAssistantExt paramFileAssistantExt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("FileAssistantExt", 1, " fileRedTouch get push GameCenterObserver ");
    paramBundle = FileAssistantExt.a(this.a).obtainMessage(1);
    FileAssistantExt.a(this.a).sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileAssistantExt.1
 * JD-Core Version:    0.7.0.1
 */