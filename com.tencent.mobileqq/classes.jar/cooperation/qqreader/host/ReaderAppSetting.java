package cooperation.qqreader.host;

import bizf;
import com.tencent.common.config.AppSetting;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "4515";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.c;
  }
  
  public static String getQUA()
  {
    return bizf.a();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "8.3.3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */