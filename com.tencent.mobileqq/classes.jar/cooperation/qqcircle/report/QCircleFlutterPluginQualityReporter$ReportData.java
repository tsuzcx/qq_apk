package cooperation.qqcircle.report;

import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;

public class QCircleFlutterPluginQualityReporter$ReportData
{
  private String checkCode = "";
  private String clientTime = String.valueOf(System.currentTimeMillis());
  private String eventId = "";
  private String ext2;
  private String flutterVersion;
  private String md5;
  private String netWorkTyp = QCircleReportHelper.getNetworkType();
  private String pluginType = "";
  private String qua = QUA.getQUA3();
  private long retCode;
  private String timeCost = "";
  private String type;
  private String uin = QCircleHostStubUtil.getCurrentAccount();
  private String url = "";
  
  public String getCheckCode()
  {
    return this.checkCode;
  }
  
  public String getClientTime()
  {
    return this.clientTime;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public String getFlutterVersion()
  {
    return this.flutterVersion;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getNetWorkTyp()
  {
    return this.netWorkTyp;
  }
  
  public String getPluginType()
  {
    return this.pluginType;
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
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ReportData setCheckCode(String paramString)
  {
    this.checkCode = paramString;
    return this;
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
  
  public ReportData setFlutterPluginVersion(String paramString)
  {
    this.flutterVersion = paramString;
    return this;
  }
  
  public ReportData setMd5(String paramString)
  {
    this.md5 = paramString;
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
  
  public ReportData setType(String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  public ReportData setUin(String paramString)
  {
    this.uin = paramString;
    return this;
  }
  
  public ReportData setUrl(String paramString)
  {
    this.url = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter.ReportData
 * JD-Core Version:    0.7.0.1
 */