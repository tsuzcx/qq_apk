package com.tencent.mobileqq.qqlive.data.anchor.sso;

import java.util.Arrays;

public class QQLiveAnchorDataMediaInfo
{
  public String serverPat;
  public byte[] sig;
  public String streamParam;
  public long timeout;
  public long type;
  
  public QQLiveAnchorDataMediaInfo() {}
  
  public QQLiveAnchorDataMediaInfo(QQLiveAnchorDataMediaInfo paramQQLiveAnchorDataMediaInfo)
  {
    if (paramQQLiveAnchorDataMediaInfo == null) {
      return;
    }
    if (this.sig != null)
    {
      byte[] arrayOfByte = paramQQLiveAnchorDataMediaInfo.sig;
      this.sig = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    }
    this.timeout = paramQQLiveAnchorDataMediaInfo.timeout;
    this.type = paramQQLiveAnchorDataMediaInfo.type;
    this.serverPat = paramQQLiveAnchorDataMediaInfo.serverPat;
    this.streamParam = paramQQLiveAnchorDataMediaInfo.streamParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo
 * JD-Core Version:    0.7.0.1
 */