package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.manager.ServerConfigManager.ConfigType;
import msf.msgsvc.msg_ctrl.MsgCtrl;

@QAPI(process={""})
public abstract interface IDep
  extends QRouteApi
{
  public abstract void addWaitingEssenceMsg(String paramString, long paramLong);
  
  public abstract void bindAnonymousInfo(MessageRecord paramMessageRecord);
  
  public abstract void consumeAllThumbsInPendingQueue();
  
  public abstract void fillStickInfo(MessageForPic paramMessageForPic, PicMessageExtraData paramPicMessageExtraData);
  
  public abstract msg_ctrl.MsgCtrl getMsgCtrlForPicMsg(String paramString);
  
  public abstract subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf();
  
  public abstract String getServerConfigValue(AppInterface paramAppInterface, ServerConfigManager.ConfigType paramConfigType, String paramString);
  
  public abstract String getZhituText();
  
  public abstract void reportEmotionPicMonitor(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IDep
 * JD-Core Version:    0.7.0.1
 */