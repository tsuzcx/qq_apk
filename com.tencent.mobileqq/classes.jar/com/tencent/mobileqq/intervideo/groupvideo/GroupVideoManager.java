package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloaderUtil;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.intervideo.yiqikan.IWatchTogetherRoomDelegate;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.mobileqq.intervideo.yiqikan.PushMessageDelegate;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class GroupVideoManager
  implements IGroupVideoManager, IWatchTogetherRoomDelegate, Manager
{
  private static UpgradeablePluginManager h = new UpgradeablePluginManager(HuayangPluginNewDownloaderUtil.a(BaseApplicationImpl.getContext()), "group_video", IVPluginLoader.b());
  private volatile boolean a = false;
  private long b = 0L;
  private volatile QQAppInterface c;
  private Handler d = new Handler(Looper.getMainLooper());
  private QQProgressDialog e;
  private int f;
  private final CommunicateWithPluginHandler g = new CommunicateWithPluginHandler();
  private INetEventHandler i = new GroupVideoManager.6(this);
  
  public GroupVideoManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    AppNetConnInfo.registerNetChangeReceiver(this.c.getApp(), this.i);
    PluginManagerInterfaceImpl.a().a(paramQQAppInterface);
    this.g.a(paramQQAppInterface);
  }
  
  private static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prefs_key_gvideo_entry_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  private GroupVideoManager.RoomCodeInfo a(String paramString1, String paramString2, String paramString3)
  {
    GroupVideoManager.RoomCodeInfo localRoomCodeInfo = new GroupVideoManager.RoomCodeInfo(null);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0")))
    {
      localRoomCodeInfo.b = 0;
      localRoomCodeInfo.a = paramString2;
      return localRoomCodeInfo;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("0")))
    {
      localRoomCodeInfo.b = 2;
      localRoomCodeInfo.a = paramString1;
      return localRoomCodeInfo;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals("0")))
    {
      localRoomCodeInfo.b = 1;
      localRoomCodeInfo.a = paramString3;
      return localRoomCodeInfo;
    }
    localRoomCodeInfo.a = "0";
    localRoomCodeInfo.b = 0;
    QLog.e("GroupVideoManager", 2, "房间号没有给");
    return localRoomCodeInfo;
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    TicketManager localTicketManager = (TicketManager)paramAppInterface.getManager(2);
    if ((localTicketManager != null) && (!TextUtils.isEmpty(paramAppInterface.getAccount()))) {
      return localTicketManager.getSkey(paramAppInterface.getAccount());
    }
    QLog.e("GroupVideoManager", 1, "get sKey error");
    return "";
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    Object localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
    ((Intent)localObject).putExtra("isPreload", true);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
    boolean bool = paramContext instanceof Activity;
    if (bool) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
    localObject = (IDynamicNowManager)this.c.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
    localObject = new Intent(paramContext, ODLoadingActivity.class);
    ((Intent)localObject).putExtra("bizType", "GVideo");
    ((Intent)localObject).putExtra("plugin_id", "Od");
    ((Intent)localObject).putExtra("appid", "1104763709");
    ((Intent)localObject).putExtra("authtype", 1);
    ((Intent)localObject).putExtra("isGroupCode", paramInt);
    ((Intent)localObject).putExtra("roomCodeType", paramInt);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("roomid", Long.valueOf(paramString2));
    ((Intent)localObject).putExtra("fromId", paramString3);
    ((Intent)localObject).putExtra("extra", paramString5);
    ((Intent)localObject).putExtra("ts_click_millisecond", System.currentTimeMillis());
    ((Intent)localObject).putExtra("openType", paramString4);
    ((Intent)localObject).putExtra("show_status_bar", true);
    ((Intent)localObject).setFlags(268435456);
    try
    {
      paramString2 = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramString3 = new StringBuilder();
      paramString3.append("prefs_key_gvideo_roominfo_entry_");
      paramString3.append(paramString1);
      paramString2.putString(paramString3.toString(), ((Intent)localObject).toUri(4)).commit();
    }
    catch (Exception paramString1)
    {
      QLog.e("GroupVideoManager", 2, paramString1.getMessage());
    }
    paramContext.startActivity((Intent)localObject);
    if (bool) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  private void a(Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.g.a(paramBundle, paramOnOpenCloseRoomCallback);
  }
  
  private void a(TogetherEnterRoomParam paramTogetherEnterRoomParam, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.g.a(paramOnOpenCloseRoomCallback);
    paramOnOpenCloseRoomCallback = new StringBuilder();
    paramOnOpenCloseRoomCallback.append("receive watchTogetherParam: ");
    paramOnOpenCloseRoomCallback.append(paramTogetherEnterRoomParam.toString());
    QLog.i("GroupVideoManager", 2, paramOnOpenCloseRoomCallback.toString());
    paramOnOpenCloseRoomCallback = new JsonObject();
    paramOnOpenCloseRoomCallback.addProperty("isTogetherWatch", Boolean.valueOf(true));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupId", Long.valueOf(Long.parseLong(paramTogetherEnterRoomParam.h)));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupOwnerUin", Long.valueOf(Long.parseLong(paramTogetherEnterRoomParam.i)));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupName", ContactUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramTogetherEnterRoomParam.h, false));
    paramOnOpenCloseRoomCallback.addProperty("sKey", a(this.c));
    GroupVideoManager.RoomCodeInfo localRoomCodeInfo = a(paramTogetherEnterRoomParam.c, paramTogetherEnterRoomParam.e, paramTogetherEnterRoomParam.d);
    a(paramTogetherEnterRoomParam.a, paramTogetherEnterRoomParam.b, localRoomCodeInfo.a, paramTogetherEnterRoomParam.f, paramTogetherEnterRoomParam.g, localRoomCodeInfo.b, paramOnOpenCloseRoomCallback.toString());
  }
  
  public static void a(String paramString, IGroupVideoManager.CheckListener paramCheckListener)
  {
    ThreadManager.executeOnFileThread(new GroupVideoManager.7(paramString, paramCheckListener));
  }
  
  private void b(Bundle paramBundle, long paramLong)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putString("bizType", "GVideo");
    paramBundle.putString("plugin_id", "Od");
    paramBundle.putString("appid", "1104763709");
    paramBundle.putInt("authtype", 1);
    if (this.c != null) {
      paramBundle.putString("uin", this.c.getCurrentUin());
    }
    paramBundle.putBoolean("preload", true);
    ExecutorService localExecutorService = ThreadManagerExecutor.getExecutorService(192);
    localExecutorService.submit(new GroupVideoManager.3(this, localExecutorService.submit(new GroupVideoManager.2(this)), paramLong, paramBundle));
  }
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      Context localContext = this.e.getContext();
      localObject = localContext;
      if ((localContext instanceof ContextWrapper)) {
        localObject = ((ContextWrapper)localContext).getBaseContext();
      }
      if ((localObject instanceof JumpActivity)) {
        ((Activity)localObject).finish();
      }
      this.e = null;
    }
  }
  
  public PushMessageDelegate a()
  {
    return this.g.b();
  }
  
  public void a(Context paramContext)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AVNotifyCenter localAVNotifyCenter = this.c.getAVNotifyCenter();
    if (paramInt == 1) {
      localObject = paramString1;
    } else {
      localObject = "0";
    }
    if (localAVNotifyCenter.a(paramContext, (String)localObject))
    {
      paramContext = new StringBuilder();
      paramContext.append("openNewGroupVideoLoadPage, blocked, roomCode[");
      paramContext.append(paramString1);
      paramContext.append("]");
      QLog.i("GroupVideoManager", 1, paramContext.toString());
      return;
    }
    Object localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
    ((Intent)localObject).putExtra("isPreload", true);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
    boolean bool = paramContext instanceof Activity;
    if (bool) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
    localObject = (IDynamicNowManager)this.c.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
    localObject = new Intent(paramContext, ODLoadingActivity.class);
    ((Intent)localObject).putExtra("bizType", "GVideo");
    ((Intent)localObject).putExtra("plugin_id", "Od");
    ((Intent)localObject).putExtra("appid", "1104763709");
    ((Intent)localObject).putExtra("authtype", 1);
    ((Intent)localObject).putExtra("roomCodeType", paramInt);
    ((Intent)localObject).putExtra("uin", paramString2);
    ((Intent)localObject).putExtra("roomid", Long.valueOf(paramString1));
    ((Intent)localObject).putExtra("fromId", paramString4);
    ((Intent)localObject).putExtra("openType", paramString6);
    ((Intent)localObject).putExtra("action", paramString3);
    ((Intent)localObject).putExtra("backType", paramString5);
    ((Intent)localObject).putExtra("extra", paramString7);
    ((Intent)localObject).putExtra("ts_click_millisecond", System.currentTimeMillis());
    ((Intent)localObject).putExtra("show_status_bar", true);
    ((Intent)localObject).setFlags(268435456);
    try
    {
      paramString1 = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramString3 = new StringBuilder();
      paramString3.append("prefs_key_gvideo_roominfo_entry_");
      paramString3.append(paramString2);
      paramString1.putString(paramString3.toString(), ((Intent)localObject).toUri(4)).commit();
    }
    catch (Exception paramString1)
    {
      QLog.e("GroupVideoManager", 2, paramString1.getMessage());
    }
    paramContext.startActivity((Intent)localObject);
    if (bool) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, PluginLoadListener paramPluginLoadListener)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a("group_video", "openGroupvideo", paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramPluginLoadListener);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JsonObject localJsonObject = new JsonObject();
    localJsonObject.addProperty("sKey", a(this.c));
    a(paramContext, paramString1, paramString2, paramString3, paramString4, 1, localJsonObject.toString());
  }
  
  public void a(Bundle paramBundle, long paramLong)
  {
    if (this.c == null) {
      return;
    }
    if (NetworkUtil.isWifiEnabled(this.c.getApp()))
    {
      QLog.e("GroupVideoManager", 2, "preload in wifi");
      b(paramBundle, paramLong);
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {
      return;
    }
    Object localObject = paramConfig.msg_content_list.get();
    int j = paramConfig.version.get();
    int k = a(BaseApplicationImpl.getContext(), this.c.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleDynamicConfig, version=");
      paramConfig.append(j);
      paramConfig.append(", oldversion=");
      paramConfig.append(k);
      QLog.i("GroupVideoManager", 2, paramConfig.toString());
    }
    if (j > k)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramConfig = (ConfigurationService.Content)((Iterator)localObject).next();
        StringBuilder localStringBuilder;
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (paramConfig != null) {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
            }
            catch (UnsupportedEncodingException paramConfig)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("handleDynamicConfig new String error, e=");
              localStringBuilder.append(paramConfig.toString());
              QLog.e("GroupVideoManager", 1, localStringBuilder.toString());
            }
          } else {
            paramConfig = "";
          }
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleDynamicConfig, contentStr=");
          localStringBuilder.append(paramConfig);
          QLog.i("GroupVideoManager", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if (SystemClock.elapsedRealtime() - this.b < 600000L)
    {
      QLog.w("GroupVideoManager", 2, "preload time less than 10 minutes, return");
      return;
    }
    this.b = SystemClock.elapsedRealtime();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramNewTogetherRoomMessageData.l);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label49:
      StringBuilder localStringBuilder;
      break label49;
    }
    QLog.e("GroupVideoManager", 2, "fromId not long");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive preload message: ");
    localStringBuilder.append(paramNewTogetherRoomMessageData.toString());
    QLog.i("GroupVideoManager", 2, localStringBuilder.toString());
    b(null, l1);
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    paramBundle = new TogetherEnterRoomParam(BaseActivity.sTopActivity, this.c.getCurrentUin());
    paramBundle.e(paramNewTogetherRoomMessageData.a);
    paramBundle.f(paramNewTogetherRoomMessageData.b);
    paramBundle.d(paramNewTogetherRoomMessageData.l);
    paramBundle.a(String.valueOf(paramNewTogetherRoomMessageData.d));
    paramBundle.b(paramNewTogetherRoomMessageData.f);
    paramBundle.c(String.valueOf(paramNewTogetherRoomMessageData.e));
    a(paramBundle, paramOnOpenCloseRoomCallback);
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {
      return;
    }
    if (NetworkUtil.isWifiEnabled(this.c.getApp())) {
      GVideoGrayConfig.a().a(this.c, paramString, new GroupVideoManager.1(this, paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c == null) {
      return;
    }
    Object localObject1 = this.c.getProxyManager().g();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((RecentUserProxy)localObject1).a(false);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      RecentUser localRecentUser;
      if (((Iterator)localObject2).hasNext())
      {
        localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser.getType() != 1) {}
      }
      else
      {
        try
        {
          ((List)localObject1).add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
        }
        catch (NumberFormatException localNumberFormatException) {}
        localObject2 = new GroupVideoManager.4(this, paramBoolean);
        if (((List)localObject1).size() > 0)
        {
          this.d.removeCallbacks((Runnable)localObject2);
          this.f = 0;
          if (this.c == null) {
            return;
          }
          localObject2 = (GVideoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
          if (localObject2 != null) {
            ((GVideoHandler)localObject2).a((List)localObject1, new GroupVideoManager.5(this));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateGroupVideoStateList try count:");
            ((StringBuilder)localObject1).append(this.f);
            QLog.d("GroupVideoManager", 2, ((StringBuilder)localObject1).toString());
          }
          int j = this.f;
          if ((j < 8) && (paramBoolean))
          {
            this.f = (j + 1);
            this.d.postDelayed((Runnable)localObject2, 1000L);
            return;
          }
          this.f = 0;
        }
        return;
      }
    }
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    a(paramBundle, paramOnOpenCloseRoomCallback);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "onDestroy");
    }
    c();
    AppNetConnInfo.unregisterNetEventHandler(this.i);
    this.d.removeCallbacksAndMessages(null);
    GVideoGrayConfig.a().c();
    a(this.c.getApp());
    this.g.a();
    this.c = null;
    PluginManagerInterfaceImpl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager
 * JD-Core Version:    0.7.0.1
 */