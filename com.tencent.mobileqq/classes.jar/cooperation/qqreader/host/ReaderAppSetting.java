package cooperation.qqreader.host;

import bgyi;
import com.tencent.common.config.AppSetting;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "4480";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.d;
  }
  
  public static String getQUA()
  {
    return bgyi.a();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "8.3.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */