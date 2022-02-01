package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;

public class QCircleLpReportDc010001$DataBuilder
{
  private int actionType;
  private String busiMsgId = "";
  private String eeveeMsgId = "";
  private int mainType;
  private int scene;
  private int subActionType;
  private int subType;
  private int thrActionType;
  
  public QCircleLpReportDc010001$DataBuilder() {}
  
  public QCircleLpReportDc010001$DataBuilder(QCircleLpReportDc010001DataBuilder paramQCircleLpReportDc010001DataBuilder)
  {
    if (paramQCircleLpReportDc010001DataBuilder == null) {
      return;
    }
    setActionType(paramQCircleLpReportDc010001DataBuilder.getActionType()).setSubActionType(paramQCircleLpReportDc010001DataBuilder.getSubActionType()).setThrActionType(paramQCircleLpReportDc010001DataBuilder.getThrActionType()).setMainType(paramQCircleLpReportDc010001DataBuilder.getMainType()).setSubType(paramQCircleLpReportDc010001DataBuilder.getSubType()).setBusiMsgId(paramQCircleLpReportDc010001DataBuilder.getBusiMsgId()).setEeveeMsgId(paramQCircleLpReportDc010001DataBuilder.getEeveeMsgId()).setScene(paramQCircleLpReportDc010001DataBuilder.getScene());
  }
  
  public DataBuilder setActionType(int paramInt)
  {
    this.actionType = paramInt;
    return this;
  }
  
  public DataBuilder setBusiMsgId(String paramString)
  {
    this.busiMsgId = paramString;
    return this;
  }
  
  public DataBuilder setEeveeMsgId(String paramString)
  {
    this.eeveeMsgId = paramString;
    return this;
  }
  
  public DataBuilder setMainType(int paramInt)
  {
    this.mainType = paramInt;
    return this;
  }
  
  public DataBuilder setScene(int paramInt)
  {
    this.scene = paramInt;
    return this;
  }
  
  public DataBuilder setSubActionType(int paramInt)
  {
    this.subActionType = paramInt;
    return this;
  }
  
  public DataBuilder setSubType(int paramInt)
  {
    this.subType = paramInt;
    return this;
  }
  
  public DataBuilder setThrActionType(int paramInt)
  {
    this.thrActionType = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc010001.DataBuilder
 * JD-Core Version:    0.7.0.1
 */