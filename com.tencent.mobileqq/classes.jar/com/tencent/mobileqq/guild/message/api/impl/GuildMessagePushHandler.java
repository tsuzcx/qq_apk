package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.GuildMessageCache;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.GuildOnlineMessageProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.IGuildPushMessageHandler;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.registerproxy.GuildPullMsgParam;
import com.tencent.mobileqq.guild.message.registerproxy.GuildPullMsgParam.PullMsgChannelInfo;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.group_pro_proto.msgpush.msgpush.MsgOnlinePush;

@KeepClassConstructor
public class GuildMessagePushHandler
  extends BaseGuildMessageHandler
  implements IGuildPushMessageHandler
{
  private final AppInterface a;
  private Set<String> b;
  private boolean c = false;
  private boolean d = false;
  private GPServiceObserver e = new GuildMessagePushHandler.1(this);
  
  public GuildMessagePushHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
    b();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (c()) {
      return;
    }
    msgpush.MsgOnlinePush localMsgOnlinePush = new msgpush.MsgOnlinePush();
    try
    {
      paramObject = (msgpush.MsgOnlinePush)localMsgOnlinePush.mergeFrom((byte[])paramObject);
      if ((!paramObject.msgs.has()) && (!paramObject.compress_msg.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildMessagePushHandler", 2, "handleOnlinePush: pushMsg is null or doesn't has msg.");
        }
        return;
      }
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("GuildMessagePushHandler", 2, new Object[] { "handleOnlinePush: muteGeneralFlag:", Integer.valueOf(paramObject.general_flag.get()) });
      }
      ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(2).a(new Object[] { paramFromServiceMsg, paramObject, Integer.valueOf(GuildOnlineMessageProcessor.c) });
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildMessagePushHandler", 2, "handleOnlinePush: exception occurs while parsing the pb bytes.", paramFromServiceMsg);
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (c()) {
      return;
    }
    if (!a(false)) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("GuildMessagePushHandler", 1, "handleNewGuildOrChannelAdded. guildid empty OR channelList is NULL.");
      return;
    }
    try
    {
      localObject1 = (IGuildRegisterProxyMsgHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName());
      Object localObject2 = (IGuildMsgSeqTimeService)this.a.getRuntimeService(IGuildMsgSeqTimeService.class, "");
      Object localObject3 = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
      ArrayList localArrayList = new ArrayList();
      GuildPullMsgParam localGuildPullMsgParam = new GuildPullMsgParam();
      localGuildPullMsgParam.a = Long.parseLong(paramString);
      localArrayList.add(localGuildPullMsgParam);
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (IGProChannelInfo)((Iterator)localObject3).next();
        if (paramBoolean) {
          ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.a).a(10014).a(10014).a(10014, ((IGProChannelInfo)localObject4).getChannelUin());
        }
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem1 = new IGuildMsgSeqTimeService.MsgSeqTimeItem(((IGProChannelInfo)localObject4).getLastMsgSeq(), ((IGProChannelInfo)localObject4).getLastCntMsgSeq(), ((IGProChannelInfo)localObject4).getLastMsgTime(), ((IGProChannelInfo)localObject4).getMsgMeta());
        ((IGuildMsgSeqTimeService)localObject2).setLastSvrMsgSeq(paramString, ((IGProChannelInfo)localObject4).getChannelUin(), localMsgSeqTimeItem1);
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem2 = new IGuildMsgSeqTimeService.MsgSeqTimeItem(((IGProChannelInfo)localObject4).getReadMsgSeq(), ((IGProChannelInfo)localObject4).getReadCntMsgSeq(), ((IGProChannelInfo)localObject4).getReadMsgTime(), ((IGProChannelInfo)localObject4).getReadMsgMeta());
        ((IGuildMsgSeqTimeService)localObject2).setReadedMsgSeq(paramString, ((IGProChannelInfo)localObject4).getChannelUin(), localMsgSeqTimeItem2, true);
        long l = Long.parseLong(((IGProChannelInfo)localObject4).getChannelUin());
        localObject4 = new GuildPullMsgParam.PullMsgChannelInfo(l, ((IGProChannelInfo)localObject4).getLastMsgSeq(), ((IGProChannelInfo)localObject4).getLastMsgTime());
        localGuildPullMsgParam.b.add(localObject4);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleNewGuildOrChannelAdded. PullMsgChannelInfo: channelIdL = ");
          ((StringBuilder)localObject4).append(l);
          ((StringBuilder)localObject4).append(", LastSvrMsgSeqItem toString: ");
          ((StringBuilder)localObject4).append(localMsgSeqTimeItem1.toString());
          ((StringBuilder)localObject4).append(", msgSeqReadedItem toString: ");
          ((StringBuilder)localObject4).append(localMsgSeqTimeItem2.toString());
          QLog.d("GuildMessagePushHandler", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleNewGuildOrChannelAdded. pullChannelMsgs: key = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", paramListSize: ");
        ((StringBuilder)localObject2).append(localGuildPullMsgParam.b.size());
        QLog.d("GuildMessagePushHandler", 2, ((StringBuilder)localObject2).toString());
      }
      ((IGuildRegisterProxyMsgHandler)localObject1).b(localArrayList);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNewGuildOrChannelAdded. invalid key or channelId. ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("GuildMessagePushHandler", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildMessagePushHandler", 2, "checkReadyToReceiveMsg: isGpsObserverAdded = false. Try to add observer.");
      }
      b();
    }
    IGuildRegisterProxyMsgHandler localIGuildRegisterProxyMsgHandler = (IGuildRegisterProxyMsgHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName());
    if ((TextUtils.isEmpty(((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId())) && (!this.d))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildMessagePushHandler", 2, "handleNewGuildOrChannelAdded. selfTid is empty, do sendRegisterProxy.");
      }
      this.d = true;
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).startAsyncStepLite(this.a);
      return false;
    }
    return true;
  }
  
  private void b()
  {
    try
    {
      ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).addObserver(this.e);
      this.c = true;
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGPSObserver exception! Try again in 2sec. ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GuildMessagePushHandler", 1, localStringBuilder.toString());
      ThreadManager.getUIHandler().postDelayed(new GuildMessagePushHandler.2(this), 2000L);
    }
  }
  
  private boolean c()
  {
    if (!((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      QLog.e("GuildMessagePushHandler", 1, "filterHandleOnlinePush notshowguildtab");
      return true;
    }
    return false;
  }
  
  public void a()
  {
    Object localObject1 = ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleOnlinePushAfterSyncMsg, msglist size:");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    QLog.i("GuildMessagePushHandler", 1, ((StringBuilder)localObject2).toString());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Object[])((Iterator)localObject1).next();
      ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(2).a((Object[])localObject2);
    }
    ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().c();
  }
  
  public Set<String> getPushCommandList()
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("MsgPush.PushGroupProMsg");
    }
    return this.b;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildMessageObserver.class;
  }
  
  public void onDestroy() {}
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(paramToServiceMsg))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("cmdfilter error=");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("GuildMessagePushHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      if ("MsgPush.PushGroupProMsg".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessagePushHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessagePushHandler
 * JD-Core Version:    0.7.0.1
 */