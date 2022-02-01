package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorDataEnter
  extends QQLiveAnchorDataBase
{
  public QQLiveAnchorDataMediaInfo mediaInfo;
  public QQLiveAnchorDataRoomInfo roomInfo;
  public QQLiveAnchorDataTrtcInfo trtcInfo;
  public QQLiveAnchorDataUserInfo userInfo;
  
  public QQLiveAnchorDataEnter() {}
  
  public QQLiveAnchorDataEnter(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    super(paramQQLiveAnchorDataEnter);
    if (paramQQLiveAnchorDataEnter == null) {
      return;
    }
    this.roomInfo = new QQLiveAnchorDataRoomInfo(paramQQLiveAnchorDataEnter.roomInfo);
    this.userInfo = new QQLiveAnchorDataUserInfo(paramQQLiveAnchorDataEnter.userInfo);
    this.mediaInfo = new QQLiveAnchorDataMediaInfo(paramQQLiveAnchorDataEnter.mediaInfo);
    this.trtcInfo = new QQLiveAnchorDataTrtcInfo(paramQQLiveAnchorDataEnter.trtcInfo);
  }
  
  public QQLiveAnchorDataEnter(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter
 * JD-Core Version:    0.7.0.1
 */