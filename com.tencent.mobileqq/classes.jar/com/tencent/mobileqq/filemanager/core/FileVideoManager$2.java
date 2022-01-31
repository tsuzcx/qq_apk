package com.tencent.mobileqq.filemanager.core;

import apab;
import apah;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class FileVideoManager$2
  implements Runnable
{
  public FileVideoManager$2(String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]FreeVideoControl");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.a + "]StartDownload");
    }
    if ((apab.a == null) || (apab.a(apab.a) == null) || (!apab.a(apab.a).containsKey(this.a))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]queue is zero return");
      }
    }
    do
    {
      return;
      apah localapah = (apah)apab.a(apab.a).get(this.a);
      localapah.a();
      apab.a(localapah);
      apab.a(apab.a).remove(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]removed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.2
 * JD-Core Version:    0.7.0.1
 */