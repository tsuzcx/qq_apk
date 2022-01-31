import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class jhg
  implements Runnable
{
  public jhg(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    FileUtils.a(this.a + File.separator, this.b, this.c);
    if (QLog.isColorLevel())
    {
      QLog.i("EffectConfigBase", 2, "save Config to path :" + this.a);
      QLog.i("EffectConfigBase", 2, "save Config to finish :" + this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhg
 * JD-Core Version:    0.7.0.1
 */