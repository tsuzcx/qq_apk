package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorDataPrepare
  extends QQLiveAnchorDataBase
{
  public QQLiveAnchorDataRoomAttr roomAttr;
  public QQLiveAnchorDataRoomInfo roomInfo;
  
  public QQLiveAnchorDataPrepare() {}
  
  public QQLiveAnchorDataPrepare(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    super(paramQQLiveAnchorDataPrepare);
    if (paramQQLiveAnchorDataPrepare == null) {
      return;
    }
    this.roomAttr = new QQLiveAnchorDataRoomAttr(paramQQLiveAnchorDataPrepare.roomAttr);
    this.roomInfo = new QQLiveAnchorDataRoomInfo(paramQQLiveAnchorDataPrepare.roomInfo);
  }
  
  public QQLiveAnchorDataPrepare(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare
 * JD-Core Version:    0.7.0.1
 */