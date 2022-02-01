package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public abstract class QQLiveAnchorDataBase
{
  public QQLiveErrorMsg errorMsg;
  public boolean isSuccess;
  
  public QQLiveAnchorDataBase() {}
  
  public QQLiveAnchorDataBase(QQLiveAnchorDataBase paramQQLiveAnchorDataBase)
  {
    if (paramQQLiveAnchorDataBase == null) {
      return;
    }
    this.isSuccess = paramQQLiveAnchorDataBase.isSuccess;
    this.errorMsg = new QQLiveErrorMsg(paramQQLiveAnchorDataBase.errorMsg);
  }
  
  public QQLiveAnchorDataBase(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    this.isSuccess = paramBoolean;
    this.errorMsg = paramQQLiveErrorMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase
 * JD-Core Version:    0.7.0.1
 */