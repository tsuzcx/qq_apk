package cooperation.qqreader.host;

import bmsw;
import com.tencent.common.config.AppSetting;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "4745";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.c;
  }
  
  public static String getQUA()
  {
    return bmsw.a();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "8.4.5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */