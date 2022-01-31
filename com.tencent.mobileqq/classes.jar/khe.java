import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class khe
  implements Runnable
{
  public khe(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    FileUtils.a(this.a + File.separator, this.b, this.c);
    if (QLog.isColorLevel())
    {
      QLog.i("ScoreManager", 2, "save Config to path :" + this.a);
      QLog.i("ScoreManager", 2, "save Config to finish :" + this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khe
 * JD-Core Version:    0.7.0.1
 */