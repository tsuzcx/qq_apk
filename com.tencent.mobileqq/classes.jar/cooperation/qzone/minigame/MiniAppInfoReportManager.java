package cooperation.qzone.minigame;

public class MiniAppInfoReportManager
{
  private static String miniAppInfo;
  
  public static String getMiniAppInfo()
  {
    if (miniAppInfo != null) {
      return miniAppInfo;
    }
    return "";
  }
  
  public static void setMiniAppInfo(String paramString)
  {
    miniAppInfo = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.minigame.MiniAppInfoReportManager
 * JD-Core Version:    0.7.0.1
 */