package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorDataTLV
{
  public long longValue;
  public String strValue;
  public int tId;
  
  public QQLiveAnchorDataTLV() {}
  
  public QQLiveAnchorDataTLV(QQLiveAnchorDataTLV paramQQLiveAnchorDataTLV)
  {
    if (paramQQLiveAnchorDataTLV == null) {
      return;
    }
    this.tId = paramQQLiveAnchorDataTLV.tId;
    this.longValue = paramQQLiveAnchorDataTLV.longValue;
    this.strValue = paramQQLiveAnchorDataTLV.strValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTLV
 * JD-Core Version:    0.7.0.1
 */