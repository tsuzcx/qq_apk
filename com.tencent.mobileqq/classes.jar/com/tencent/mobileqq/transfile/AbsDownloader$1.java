package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class AbsDownloader$1
  implements Runnable
{
  AbsDownloader$1(AbsDownloader paramAbsDownloader, DiskCache.Editor paramEditor) {}
  
  public void run()
  {
    try
    {
      this.val$editor.commit();
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("AbsDownloader", 2, localIOException.getMessage());
      DiskCache.Editor localEditor = this.val$editor;
      if (localEditor != null) {
        localEditor.abort(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */