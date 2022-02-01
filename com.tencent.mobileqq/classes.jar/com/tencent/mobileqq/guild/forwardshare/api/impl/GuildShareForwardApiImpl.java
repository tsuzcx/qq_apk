package com.tencent.mobileqq.guild.forwardshare.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GuildShareForwardApiImpl
  implements IGuildShareForwardApi
{
  private static final String TAG = "GuildShareForwardApiImpl";
  private AppInterface mApp;
  private HashMap<Long, IGuildSendMessageHandler.SendTextMsgParams> mLeaveMessageMap = new HashMap();
  private GuildMessageObserver mMessageObserver = new GuildShareForwardApiImpl.1(this);
  
  public void ShareForwardMsg(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return;
    }
    IGuildSendMessageHandler localIGuildSendMessageHandler = (IGuildSendMessageHandler)((AppInterface)localObject).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName());
    localObject = new IGuildSendMessageHandler.SendTextMsgParams();
    String str = paramBundle.getString("detail_url");
    ((IGuildSendMessageHandler.SendTextMsgParams)localObject).c = paramString1;
    ((IGuildSendMessageHandler.SendTextMsgParams)localObject).b = paramString2;
    ((IGuildSendMessageHandler.SendTextMsgParams)localObject).d = str;
    ((IGuildSendMessageHandler.SendTextMsgParams)localObject).e = new ArrayList();
    long l = localIGuildSendMessageHandler.b(this.mApp, (IGuildSendMessageHandler.SendTextMsgParams)localObject);
    paramString1 = paramBundle.getString("share_leave_message");
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((IGuildSendMessageHandler.SendTextMsgParams)localObject).d = paramString1;
    this.mLeaveMessageMap.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("uinque:");
      paramString1.append(l);
      paramString1.append("params:");
      paramString1.append(((IGuildSendMessageHandler.SendTextMsgParams)localObject).d);
      QLog.i("GuildShareForwardApiImpl", 2, paramString1.toString());
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      this.mApp.addObserver(this.mMessageObserver);
    }
  }
  
  public void onDestroy()
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.mMessageObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.forwardshare.api.impl.GuildShareForwardApiImpl
 * JD-Core Version:    0.7.0.1
 */