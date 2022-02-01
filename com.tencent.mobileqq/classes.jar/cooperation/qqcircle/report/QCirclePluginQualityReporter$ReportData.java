package cooperation.qqcircle.report;

import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;

public class QCirclePluginQualityReporter$ReportData
{
  private String clientTime = String.valueOf(System.currentTimeMillis());
  private String eventId = "";
  private String ext1 = "";
  private String ext2 = "";
  private String flutterVersion;
  private String netWorkTyp = QCircleReportHelper.getNetworkType();
  private String pluginType = "";
  private long pluginVersion;
  private String qua = QUA.getQUA3();
  private long retCode;
  private String timeCost = "";
  private String uin = QCircleHostStubUtil.getCurrentAccount();
  
  public String getClientTime()
  {
    return this.clientTime;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public String getExt1()
  {
    return this.ext1;
  }
  
  public String getExt2()
  {
    return this.ext2;
  }
  
  public String getNetWorkTyp()
  {
    return this.netWorkTyp;
  }
  
  public String getPluginType()
  {
    return this.pluginType;
  }
  
  public long getPluginVersion()
  {
    return this.pluginVersion;
  }
  
  public String getQua()
  {
    return this.qua;
  }
  
  public long getRetCode()
  {
    return this.retCode;
  }
  
  public String getTimeCost()
  {
    return this.timeCost;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public ReportData setClientTime(String paramString)
  {
    this.clientTime = paramString;
    return this;
  }
  
  public ReportData setEventId(String paramString)
  {
    this.eventId = paramString;
    return this;
  }
  
  public ReportData setExt1(String paramString)
  {
    this.ext1 = paramString;
    return this;
  }
  
  public ReportData setExt2(String paramString)
  {
    this.ext2 = paramString;
    return this;
  }
  
  public ReportData setFlutterPluginVersion(String paramString)
  {
    this.flutterVersion = paramString;
    return this;
  }
  
  public ReportData setNetWorkTyp(String paramString)
  {
    this.netWorkTyp = paramString;
    return this;
  }
  
  public ReportData setPluginType(String paramString)
  {
    this.pluginType = paramString;
    return this;
  }
  
  public ReportData setPluginVersion(long paramLong)
  {
    this.pluginVersion = paramLong;
    return this;
  }
  
  public ReportData setQua(String paramString)
  {
    this.qua = paramString;
    return this;
  }
  
  public ReportData setRetCode(long paramLong)
  {
    this.retCode = paramLong;
    return this;
  }
  
  public ReportData setTimeCost(String paramString)
  {
    this.timeCost = paramString;
    return this;
  }
  
  public ReportData setUin(String paramString)
  {
    this.uin = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData
 * JD-Core Version:    0.7.0.1
 */