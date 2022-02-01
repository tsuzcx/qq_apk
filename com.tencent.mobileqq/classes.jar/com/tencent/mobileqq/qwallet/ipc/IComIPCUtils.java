package com.tencent.mobileqq.qwallet.ipc;

import Wallet.AcsMsg;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.Serializable;

@QAPI(process={"all"})
public abstract interface IComIPCUtils
  extends QRouteApi
{
  public abstract void cancelAlarmNotifaction(AcsMsg paramAcsMsg);
  
  public abstract String getFriendNickName(String paramString);
  
  public abstract boolean isQQReminderOpen();
  
  public abstract void recordAppStart(Serializable paramSerializable);
  
  public abstract void removeMessageRecord(AcsMsg paramAcsMsg);
  
  public abstract void setAlarmNotifaction(AcsMsg paramAcsMsg);
  
  public abstract void setQQReminderSwitch(boolean paramBoolean);
  
  public abstract void startApolloGame(StartCheckParam paramStartCheckParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
 * JD-Core Version:    0.7.0.1
 */