package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.IRichMediaIpSaver;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.utils.VipUtils;
import mqq.app.AppRuntime;

public class PttTempApiImpl
  implements IPttTempApi
{
  public void addAIOMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramMessageRecord, paramString);
    }
  }
  
  public MessageForPtt createPttMessage(AppRuntime paramAppRuntime, String paramString, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      return ChatActivityFacade.a((QQAppInterface)paramAppRuntime, paramString, paramBaseSessionInfo, paramInt1, paramInt2);
    }
    return null;
  }
  
  public void doOnPttSrvAddressError(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      FMTSrvAddrProvider.getInstance().getPttIpSaver().a(0);
      return;
    }
    FMTSrvAddrProvider.getInstance().onFailed(16, paramString);
  }
  
  public Message getLastMessage(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)paramAppRuntime).getMessageFacade().getLastMessage(paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord getMsgItemByUniseq(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramString, paramInt, paramLong);
    }
    return null;
  }
  
  public int getPttVipFlag(AppRuntime paramAppRuntime, String paramString)
  {
    return VipUtils.a(paramAppRuntime, paramString);
  }
  
  public boolean isHotChat(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return ((HotChatManager)paramAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramString);
  }
  
  public void sendMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver)
  {
    if (paramAppRuntime != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      ((QQAppInterface)paramAppRuntime).getMessageFacade().b(paramMessageRecord, (MessageObserver)paramBaseMessageObserver);
    }
  }
  
  public void setJsPttLocalPath(String paramString)
  {
    ((IPublicAccountH5AbilityPtt)QRoute.api(IPublicAccountH5AbilityPtt.class)).setLocalPathForPtt(paramString);
  }
  
  public void setJsPttServerId(String paramString) {}
  
  public void updateMsgContentByUniseq(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = (QQMessageFacade)paramAppRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.a(paramString, paramInt, paramLong, paramArrayOfByte);
  }
  
  public void updatePttRecordMessage(AppRuntime paramAppRuntime, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramAppRuntime != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      ChatActivityFacade.a((QQAppInterface)paramAppRuntime, paramBaseSessionInfo, paramString, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.PttTempApiImpl
 * JD-Core Version:    0.7.0.1
 */