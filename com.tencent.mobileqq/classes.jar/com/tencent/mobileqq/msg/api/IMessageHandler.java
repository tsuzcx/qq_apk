package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

@Service(process={""})
public abstract interface IMessageHandler
  extends IRuntimeService
{
  public abstract void notifyBusinessMessageForSus(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void notifyUI(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void saveTroopName(String paramString1, String paramString2);
  
  public abstract void sendGetNextGroupSystemMsg();
  
  public abstract void sendGetNextGroupSystemMsgForSus();
  
  public abstract void sendGetSystemMsg(int paramInt);
  
  public abstract void sendGetSystemMsgForSus();
  
  public abstract void sendGroupSystemMsgAction(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6);
  
  public abstract void sendGroupSystemMsgReadedReport();
  
  public abstract void sendGroupSystemMsgReadedReportInner(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageHandler
 * JD-Core Version:    0.7.0.1
 */