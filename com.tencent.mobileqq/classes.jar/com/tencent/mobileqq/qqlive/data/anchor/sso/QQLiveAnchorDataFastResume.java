package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorDataFastResume
  extends QQLiveAnchorDataBase
{
  public QQLiveAnchorDataFastResume() {}
  
  public QQLiveAnchorDataFastResume(QQLiveAnchorDataBase paramQQLiveAnchorDataBase)
  {
    if (paramQQLiveAnchorDataBase == null) {
      return;
    }
    this.isSuccess = paramQQLiveAnchorDataBase.isSuccess;
    this.errorMsg = new QQLiveErrorMsg(paramQQLiveAnchorDataBase.errorMsg);
  }
  
  public QQLiveAnchorDataFastResume(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume
 * JD-Core Version:    0.7.0.1
 */