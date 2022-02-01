package cooperation.qqreader.helper;

import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.utils.Config.UserConfig;

public final class GrayUpdateManager
{
  public static int a()
  {
    return Config.UserConfig.a(BaseApplicationImpl.context);
  }
  
  public static boolean a()
  {
    return (Config.UserConfig.b(BaseApplicationImpl.context) == 1) || (Config.UserConfig.c(BaseApplicationImpl.context));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.GrayUpdateManager
 * JD-Core Version:    0.7.0.1
 */