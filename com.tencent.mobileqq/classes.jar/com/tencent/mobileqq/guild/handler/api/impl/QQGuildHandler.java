package com.tencent.mobileqq.guild.handler.api.impl;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.handler.api.IQQGuildHandler;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyGaryService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQGuildHandler
  extends BusinessHandler
  implements IQQGuildHandler
{
  protected QQGuildHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    paramAppInterface.getRuntimeService(IGuildRegisterProxyGaryService.class, "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQGuildGrayUserTypeConfig localQQGuildGrayUserTypeConfig = QQGuildGrayUserTypeConfig.a();
    localQQGuildGrayUserTypeConfig.a(paramInt1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGuildUserType -> notifyUI ");
      localStringBuilder.append(localQQGuildGrayUserTypeConfig.toString());
      localStringBuilder.append(" from:");
      localStringBuilder.append(paramInt2);
      QLog.d("QQGuildHandler", 2, localStringBuilder.toString());
    }
    notifyUI(5, true, new Object[] { localQQGuildGrayUserTypeConfig, Integer.valueOf(paramInt2) });
  }
  
  public void a(ChannelData paramChannelData)
  {
    notifyUI(7, true, paramChannelData);
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    notifyUI(10, true, paramIGProChannelInfo);
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).setMyMsgNotifyType(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin(), paramInt, new QQGuildHandler.4(this, paramISetChannelMsgNotifyTypeCallback));
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).removeChannel(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin(), new QQGuildHandler.2(this, paramIGProChannelInfo, paramIResultWithSecurityCallback));
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo, String paramString, ISetChannelNameCallback paramISetChannelNameCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).setChannelName(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin(), paramString, new QQGuildHandler.3(this, paramISetChannelNameCallback));
  }
  
  public void a(String paramString)
  {
    notifyUI(6, true, paramString);
  }
  
  public void a(String paramString, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).setChannelTalkPermission(paramString, paramInt, new QQGuildHandler.6(this, paramISetChannelTalkPermissionCallback));
  }
  
  public void a(String paramString1, ChannelCreateInfo paramChannelCreateInfo, String paramString2, long paramLong, String paramString3, ICreateChannelCallback paramICreateChannelCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).createChannel(paramString1, paramChannelCreateInfo, paramLong, new QQGuildHandler.1(this, paramString3, paramICreateChannelCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, @Nullable List<String> paramList, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).setChannelVisible(paramString1, paramString2, paramInt, paramList, new QQGuildHandler.7(this, paramIResultWithSecurityCallback));
  }
  
  public void b(IGProChannelInfo paramIGProChannelInfo, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    ((IGPSService)this.appRuntime.getRuntimeService(IGPSService.class, "")).setAdminMsgNotifyType(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin(), paramInt, new QQGuildHandler.5(this, paramISetChannelMsgNotifyTypeCallback));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QQGuildObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler
 * JD-Core Version:    0.7.0.1
 */