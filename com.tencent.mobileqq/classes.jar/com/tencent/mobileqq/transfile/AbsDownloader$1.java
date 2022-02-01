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
      do
      {
        QLog.e("AbsDownloader", 2, localIOException.getMessage());
      } while (this.val$editor == null);
      this.val$editor.abort(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */