package cooperation.qzone;

import bjhe;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UploadSoDownloader$1
  implements Runnable
{
  public UploadSoDownloader$1(bjhe parambjhe) {}
  
  public void run()
  {
    boolean bool = bjhe.a(this.this$0, bjhe.a().getAbsolutePath());
    QLog.d("UploadEnv", 1, "check so md5 result: " + bool);
    if (bool)
    {
      bjhe.a(true);
      return;
    }
    try
    {
      if (bjhe.a().exists()) {
        bjhe.a().delete();
      }
      bjhe.a(this.this$0, false);
      bjhe.a(false);
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