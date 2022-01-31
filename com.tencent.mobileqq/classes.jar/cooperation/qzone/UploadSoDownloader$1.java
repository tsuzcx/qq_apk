package cooperation.qzone;

import bjcx;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(bjcx parambjcx) {}
  
  public void run()
  {
    boolean bool = bjcx.a(this.this$0, bjcx.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      bjcx.a(true);
      return;
    }
    try
    {
      if (bjcx.a().exists()) {
        bjcx.a().delete();
      }
      bjcx.a(this.this$0, false);
      bjcx.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */