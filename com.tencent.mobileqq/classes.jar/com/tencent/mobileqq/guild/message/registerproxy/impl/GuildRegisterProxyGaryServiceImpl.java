package com.tencent.mobileqq.guild.message.registerproxy.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.FrameAddPushNotifier;
import com.tencent.mobileqq.activity.home.OnTabFrameAddCallback;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyGaryService;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildRegisterProxyGaryServiceImpl
  implements IGuildRegisterProxyGaryService
{
  private static final String TAG = "GuildRegisterProxyGaryServiceImpl";
  private AppInterface app;
  private OnTabFrameAddCallback frameAddCallback = new GuildRegisterProxyGaryServiceImpl.2(this);
  private QQGuildObserver guildObserver = new GuildRegisterProxyGaryServiceImpl.3(this);
  private boolean lastShowGuildTab;
  private SharedPreferences.OnSharedPreferenceChangeListener tabDataListener = new GuildRegisterProxyGaryServiceImpl.1(this);
  private SharedPreferences tabDataSharedPreferences;
  
  private void clearUnreadMsg()
  {
    IGPSService localIGPSService = (IGPSService)this.app.getRuntimeService(IGPSService.class, "");
    IGuildMsgReadedService localIGuildMsgReadedService = (IGuildMsgReadedService)this.app.getRuntimeService(IGuildMsgReadedService.class, "");
    Iterator localIterator = localIGPSService.getGuildList().iterator();
    while (localIterator.hasNext())
    {
      String str = ((IGProGuildInfo)localIterator.next()).getGuildID();
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = localIGPSService.getChannelList(str);
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((IGProChannelInfo)((Iterator)localObject).next()).getChannelUin());
        }
        if (localArrayList.size() > 0) {
          localIGuildMsgReadedService.setChannelMsgReaded(str, localArrayList, 7);
        }
      }
    }
  }
  
  private void handleUpdate(boolean paramBoolean)
  {
    boolean bool = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleUpdate lastShowGuildTab:");
    ((StringBuilder)localObject).append(this.lastShowGuildTab);
    ((StringBuilder)localObject).append(" curShowGuildTab:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("GuildRegisterProxyGaryServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.lastShowGuildTab != bool)
    {
      this.lastShowGuildTab = bool;
      localObject = (IGuildRegisterProxyMsgHandler)this.app.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName());
      if ((!paramBoolean) && (!((IGuildRegisterProxyMsgHandler)localObject).c()))
      {
        QLog.i("GuildRegisterProxyGaryServiceImpl", 1, "startAsyncStepLite");
        ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).startAsyncStepLite(this.app);
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.lastShowGuildTab = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
    this.app.addObserver(this.guildObserver);
    FrameAddPushNotifier.a().a(this.frameAddCallback);
    this.tabDataSharedPreferences = BaseApplication.getContext().getSharedPreferences("TabDataHelper_Shared_Prefs", 4);
    paramAppRuntime = this.tabDataSharedPreferences;
    if (paramAppRuntime != null)
    {
      paramAppRuntime.registerOnSharedPreferenceChangeListener(this.tabDataListener);
      return;
    }
    QLog.e("GuildRegisterProxyGaryServiceImpl", 1, "tabDataSharedPreferences is null!");
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.guildObserver);
    FrameAddPushNotifier.a().b(this.frameAddCallback);
    SharedPreferences localSharedPreferences = this.tabDataSharedPreferences;
    if (localSharedPreferences != null) {
      localSharedPreferences.unregisterOnSharedPreferenceChangeListener(this.tabDataListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.impl.GuildRegisterProxyGaryServiceImpl
 * JD-Core Version:    0.7.0.1
 */