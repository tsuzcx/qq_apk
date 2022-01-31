package cooperation.qzone;

import bhbq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(bhbq parambhbq) {}
  
  public void run()
  {
    boolean bool = bhbq.a(this.this$0, bhbq.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      bhbq.a(true);
      return;
    }
    try
    {
      if (bhbq.a().exists()) {
        bhbq.a().delete();
      }
      bhbq.a(this.this$0, false);
      bhbq.a(false);
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