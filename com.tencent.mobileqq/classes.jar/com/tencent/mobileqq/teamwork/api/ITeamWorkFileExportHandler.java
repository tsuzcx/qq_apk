package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.ToServiceMsg;

@QAPI(process={"all"})
public abstract interface ITeamWorkFileExportHandler
  extends QRouteApi
{
  public abstract void fileExportDownloadRequest(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2);
  
  public abstract void notifyUI(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler
 * JD-Core Version:    0.7.0.1
 */