package com.tencent.mobileqq.filemanager.core;

import aqsz;
import aqtf;
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
    if ((aqsz.a == null) || (aqsz.a(aqsz.a) == null) || (!aqsz.a(aqsz.a).containsKey(this.a))) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]queue is zero return");
      }
    }
    do
    {
      return;
      aqtf localaqtf = (aqtf)aqsz.a(aqsz.a).get(this.a);
      localaqtf.a();
      aqsz.a(localaqtf);
      aqsz.a(aqsz.a).remove(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]removed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.2
 * JD-Core Version:    0.7.0.1
 */