package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildAioMsgFilterApi
  extends QRouteApi
{
  public abstract IGuildAioMsgFilterApi.MsgSeqItem getCurAioLatestMsgSeqItem();
  
  public abstract IGuildAioMsgFilterApi.MsgSeqItem getLatestMsgSeqItem();
  
  public abstract IGuildAioMsgFilterApi.MsgSeqItem getOnlinePushLatestMsgSeqItem(String paramString);
  
  public abstract IGuildAioMsgFilterApi.MsgSeqItem getReadLatestMsgSeqItem();
  
  public abstract void resetCurAioLatestMsgSeqItem();
  
  public abstract void updateCurAioLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean);
  
  public abstract void updateLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean);
  
  public abstract void updateOnlinePushLatestMsgSeqItem(String paramString, IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean);
  
  public abstract void updateReadLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
 * JD-Core Version:    0.7.0.1
 */