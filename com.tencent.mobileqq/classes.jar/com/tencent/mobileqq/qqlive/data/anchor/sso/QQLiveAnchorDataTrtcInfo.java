package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorDataTrtcInfo
{
  public String businessInfo;
  public String sig;
  public QQLiveAnchorDataStreamInfo streamInfo = new QQLiveAnchorDataStreamInfo();
  public long timeout;
  public String trtcStr;
  
  public QQLiveAnchorDataTrtcInfo() {}
  
  public QQLiveAnchorDataTrtcInfo(QQLiveAnchorDataTrtcInfo paramQQLiveAnchorDataTrtcInfo)
  {
    if (paramQQLiveAnchorDataTrtcInfo == null) {
      return;
    }
    this.sig = paramQQLiveAnchorDataTrtcInfo.sig;
    this.timeout = paramQQLiveAnchorDataTrtcInfo.timeout;
    this.businessInfo = paramQQLiveAnchorDataTrtcInfo.businessInfo;
    this.trtcStr = paramQQLiveAnchorDataTrtcInfo.trtcStr;
    this.streamInfo = new QQLiveAnchorDataStreamInfo(paramQQLiveAnchorDataTrtcInfo.streamInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo
 * JD-Core Version:    0.7.0.1
 */