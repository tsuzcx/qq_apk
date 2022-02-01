package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQzoneRuntimeService
  extends IRuntimeService
{
  public abstract boolean isEnableQZoneContextBox();
  
  public abstract void likeFeed(String paramString, int paramInt, boolean paramBoolean, long paramLong);
  
  public abstract ArrayList<QZoneMsgEntityNew> loadMsgFromDB();
  
  public abstract void preloadContentBox();
  
  public abstract void refreshQzoneMsg();
  
  public abstract void saveMsgToDB(IMQMsg paramIMQMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneRuntimeService
 * JD-Core Version:    0.7.0.1
 */