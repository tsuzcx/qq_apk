package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class MessageHandlerImpl
  implements IMessageHandler
{
  private QQAppInterface app;
  
  public void notifyBusinessMessageForSus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).a(paramInt, paramBoolean, paramObject);
      }
    }
  }
  
  public void notifyUI(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramBaseQQAppInterface).getMsgHandler().notifyUI(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void saveTroopName(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null) {
      localQQAppInterface.getMsgHandler().c(paramString1, paramString2);
    }
  }
  
  public void sendGetNextGroupSystemMsg()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).c(0);
      }
    }
  }
  
  public void sendGetNextGroupSystemMsgForSus()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).c(3);
      }
    }
  }
  
  public void sendGetSystemMsg(int paramInt)
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).a(paramInt);
      }
    }
  }
  
  public void sendGetSystemMsgForSus()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).a(3, 3, true);
      }
    }
  }
  
  public void sendGroupSystemMsgAction(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6);
      }
    }
  }
  
  public void sendGroupSystemMsgReadedReport()
  {
    sendGroupSystemMsgReadedReportInner(false);
  }
  
  public void sendGroupSystemMsgReadedReportInner(boolean paramBoolean)
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMsgHandler().a();
      if (localObject != null) {
        ((SystemMessageProcessor)localObject).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageHandlerImpl
 * JD-Core Version:    0.7.0.1
 */