package cooperation.qqreader.host;

import com.tencent.common.config.AppSetting;
import cooperation.qzone.QUA;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "5105";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.d;
  }
  
  public static String getQUA()
  {
    return QUA.getQUA3();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "8.5.5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */