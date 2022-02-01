package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.QQSchemaInfo;
import java.util.ArrayList;

public class QQSchemaBuilder
{
  private ArrayList<QQSchemaInfo> qqSchemaInfos = new ArrayList();
  private ReportKey reportKey;
  
  public QQSchemaBuilder addItemInfo(QQSchemaInfo paramQQSchemaInfo)
  {
    this.qqSchemaInfos.add(paramQQSchemaInfo);
    return this;
  }
  
  public QQSchemaInfo build()
  {
    QQSchemaInfo localQQSchemaInfo = new QQSchemaInfo();
    localQQSchemaInfo.appid = this.reportKey.pageAppId;
    localQQSchemaInfo.schema_url = this.reportKey.schemaUrl;
    return localQQSchemaInfo;
  }
  
  public QQSchemaBuilder setReportKey(ReportKey paramReportKey)
  {
    this.reportKey = paramReportKey;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.QQSchemaBuilder
 * JD-Core Version:    0.7.0.1
 */