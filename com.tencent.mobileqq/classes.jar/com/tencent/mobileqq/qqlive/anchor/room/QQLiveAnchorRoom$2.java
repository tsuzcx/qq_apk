package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin.Callback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;

class QQLiveAnchorRoom$2
  implements QQLiveAnchorHelperLogin.Callback
{
  QQLiveAnchorRoom$2(QQLiveAnchorRoom paramQQLiveAnchorRoom) {}
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    this.a.a(paramQQLiveErrorMsg);
  }
  
  public void a(LoginInfo paramLoginInfo)
  {
    this.a.c.uid = paramLoginInfo.uid;
    this.a.d();
    QQLiveAnchorRoom.d(this.a).getDataReportModule().setLoginInfo(paramLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.2
 * JD-Core Version:    0.7.0.1
 */