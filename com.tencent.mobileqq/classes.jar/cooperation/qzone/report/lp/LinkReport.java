package cooperation.qzone.report.lp;

import java.util.HashMap;

public class LinkReport
{
  public static void reportClickQZoneEntry(String paramString)
  {
    paramString = new LpReportInfo_DC02543(paramString, "LebaClickQZoneEntry", 0L);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
  
  public static void reportEvent(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new LpReportInfo_DC02543(paramString1, paramString2, paramLong);
    LpReportManager.getInstance().reportToDC02543(paramString1);
  }
  
  public static void reportMoreFeedEnd(String paramString, long paramLong)
  {
    paramString = new LpReportInfo_DC02543(paramString, "MoreFeedEnd", paramLong);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
  
  public static void reportMoreFeedStart(String paramString)
  {
    paramString = new LpReportInfo_DC02543(paramString, "MoreFeedStart", 0L);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
  
  public static void reportQZoneLaunch(String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    paramString = new LpReportInfo_DC02543(paramString, "qzone_launch", "0", paramLong, paramHashMap);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
  
  public static void reportRefreshFeedEnd(String paramString, long paramLong)
  {
    paramString = new LpReportInfo_DC02543(paramString, "RefreshFeedEnd", paramLong);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
  
  public static void reportRefreshFeedStart(String paramString)
  {
    paramString = new LpReportInfo_DC02543(paramString, "RefreshFeedStart", 0L);
    LpReportManager.getInstance().reportToDC02543(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.LinkReport
 * JD-Core Version:    0.7.0.1
 */