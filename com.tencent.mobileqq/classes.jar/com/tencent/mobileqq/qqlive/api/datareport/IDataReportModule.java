package com.tencent.mobileqq.qqlive.api.datareport;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

public abstract interface IDataReportModule
  extends IQQLiveModule
{
  public abstract ReportTask newReportTask();
  
  public abstract void setLoginInfo(LoginInfo paramLoginInfo);
  
  public abstract void setRoomInfo(BaseRoomInfo paramBaseRoomInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule
 * JD-Core Version:    0.7.0.1
 */