package cooperation.qzone;

import bfss;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(bfss parambfss) {}
  
  public void run()
  {
    boolean bool = bfss.a(this.this$0, bfss.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      bfss.a(true);
      return;
    }
    try
    {
      if (bfss.a().exists()) {
        bfss.a().delete();
      }
      bfss.a(this.this$0, false);
      bfss.a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */