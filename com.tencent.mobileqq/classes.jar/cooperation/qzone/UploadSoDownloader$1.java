package cooperation.qzone;

import bhaz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(bhaz parambhaz) {}
  
  public void run()
  {
    boolean bool = bhaz.a(this.this$0, bhaz.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      bhaz.a(true);
      return;
    }
    try
    {
      if (bhaz.a().exists()) {
        bhaz.a().delete();
      }
      bhaz.a(this.this$0, false);
      bhaz.a(false);
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