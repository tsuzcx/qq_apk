package cooperation.qzone;

import blvk;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(blvk paramblvk) {}
  
  public void run()
  {
    boolean bool = blvk.a(this.this$0, blvk.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      blvk.a(true);
      return;
    }
    try
    {
      if (blvk.a().exists()) {
        blvk.a().delete();
      }
      blvk.a(this.this$0, false);
      blvk.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */