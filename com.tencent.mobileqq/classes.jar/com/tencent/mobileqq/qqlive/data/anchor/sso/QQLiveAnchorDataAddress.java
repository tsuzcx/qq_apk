package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorDataAddress
{
  public int bitrate;
  public String format;
  public String url;
  
  public QQLiveAnchorDataAddress() {}
  
  public QQLiveAnchorDataAddress(QQLiveAnchorDataAddress paramQQLiveAnchorDataAddress)
  {
    if (paramQQLiveAnchorDataAddress == null) {
      return;
    }
    this.url = paramQQLiveAnchorDataAddress.url;
    this.bitrate = paramQQLiveAnchorDataAddress.bitrate;
    this.format = paramQQLiveAnchorDataAddress.format;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAddress
 * JD-Core Version:    0.7.0.1
 */