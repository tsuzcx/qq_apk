package com.tencent.mobileqq.filemanager.settings;

import java.io.File;

class QQFMSettings$4
  implements Runnable
{
  QQFMSettings$4(QQFMSettings paramQQFMSettings, String paramString, File paramFile, int paramInt, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    QQFMSettings.a(this.this$0, localFile, this.b, new QQFMSettings.4.1(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.4
 * JD-Core Version:    0.7.0.1
 */