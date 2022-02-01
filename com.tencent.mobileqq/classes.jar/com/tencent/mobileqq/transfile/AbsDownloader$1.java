package com.tencent.mobileqq.transfile;

import bdsh;
import bdub;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class AbsDownloader$1
  implements Runnable
{
  public AbsDownloader$1(bdsh parambdsh, bdub parambdub) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        QLog.e("AbsDownloader", 2, localIOException.getMessage());
      } while (this.a == null);
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */