package cooperation.qqreader.host;

import bfpk;
import com.tencent.common.config.AppSetting;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "4370";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.c;
  }
  
  public static String getQUA()
  {
    return bfpk.a();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "8.2.6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */