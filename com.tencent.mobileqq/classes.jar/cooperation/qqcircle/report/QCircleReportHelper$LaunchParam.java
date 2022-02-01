package cooperation.qqcircle.report;

public class QCircleReportHelper$LaunchParam
{
  public String launchFrom;
  public String launchId;
  public int launchScene;
  public String toUin;
  
  public static LaunchParam wrap(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.launchFrom = paramString1;
    localLaunchParam.launchId = paramString2;
    localLaunchParam.toUin = paramString3;
    localLaunchParam.launchScene = paramInt;
    return localLaunchParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.LaunchParam
 * JD-Core Version:    0.7.0.1
 */