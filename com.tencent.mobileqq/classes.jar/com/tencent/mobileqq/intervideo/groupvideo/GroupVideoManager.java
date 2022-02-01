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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
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
  implements IWatchTogetherRoomDelegate, Manager
{
  private static UpgradeablePluginManager jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(HuayangPluginNewDownloader.a(BaseApplicationImpl.getContext()), "group_video", IVPluginLoader.a());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private volatile QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final CommunicateWithPluginHandler jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler = new CommunicateWithPluginHandler();
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new GroupVideoManager.6(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public GroupVideoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    PluginManagerInterfaceImpl.a().a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler.a(paramQQAppInterface);
  }
  
  private static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("prefs_key_gvideo_entry_" + paramString, 0);
  }
  
  private GroupVideoManager.RoomCodeInfo a(String paramString1, String paramString2, String paramString3)
  {
    GroupVideoManager.RoomCodeInfo localRoomCodeInfo = new GroupVideoManager.RoomCodeInfo(null);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0")))
    {
      localRoomCodeInfo.jdField_a_of_type_Int = 0;
      localRoomCodeInfo.jdField_a_of_type_JavaLangString = paramString2;
      return localRoomCodeInfo;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("0")))
    {
      localRoomCodeInfo.jdField_a_of_type_Int = 2;
      localRoomCodeInfo.jdField_a_of_type_JavaLangString = paramString1;
      return localRoomCodeInfo;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals("0")))
    {
      localRoomCodeInfo.jdField_a_of_type_Int = 1;
      localRoomCodeInfo.jdField_a_of_type_JavaLangString = paramString3;
      return localRoomCodeInfo;
    }
    localRoomCodeInfo.jdField_a_of_type_JavaLangString = "0";
    localRoomCodeInfo.jdField_a_of_type_Int = 0;
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
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      Context localContext2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.getContext();
      Context localContext1 = localContext2;
      if ((localContext2 instanceof ContextWrapper)) {
        localContext1 = ((ContextWrapper)localContext2).getBaseContext();
      }
      if ((localContext1 instanceof JumpActivity)) {
        ((Activity)localContext1).finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    Object localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
    ((Intent)localObject).putExtra("isPreload", true);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
    localObject = (DynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
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
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("prefs_key_gvideo_roominfo_entry_" + paramString1, ((Intent)localObject).toUri(4)).commit();
      paramContext.startActivity((Intent)localObject);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("GroupVideoManager", 2, paramString1.getMessage());
      }
    }
  }
  
  private void a(Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler.a(paramBundle, paramOnOpenCloseRoomCallback);
  }
  
  private void a(GroupVideoManager.TogetherEnterRoomParam paramTogetherEnterRoomParam, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler.a(paramOnOpenCloseRoomCallback);
    QLog.i("GroupVideoManager", 2, "receive watchTogetherParam: " + paramTogetherEnterRoomParam.toString());
    paramOnOpenCloseRoomCallback = new JsonObject();
    paramOnOpenCloseRoomCallback.addProperty("isTogetherWatch", Boolean.valueOf(true));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupId", Long.valueOf(Long.parseLong(paramTogetherEnterRoomParam.g)));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupOwnerUin", Long.valueOf(Long.parseLong(paramTogetherEnterRoomParam.h)));
    paramOnOpenCloseRoomCallback.addProperty("fromGroupName", ContactUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramTogetherEnterRoomParam.g, false));
    paramOnOpenCloseRoomCallback.addProperty("sKey", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    GroupVideoManager.RoomCodeInfo localRoomCodeInfo = a(paramTogetherEnterRoomParam.jdField_b_of_type_JavaLangString, paramTogetherEnterRoomParam.d, paramTogetherEnterRoomParam.c);
    a(paramTogetherEnterRoomParam.jdField_a_of_type_AndroidContentContext, paramTogetherEnterRoomParam.jdField_a_of_type_JavaLangString, localRoomCodeInfo.jdField_a_of_type_JavaLangString, paramTogetherEnterRoomParam.e, paramTogetherEnterRoomParam.f, localRoomCodeInfo.jdField_a_of_type_Int, paramOnOpenCloseRoomCallback.toString());
  }
  
  public static void a(String paramString, GroupVideoManager.CheckListener paramCheckListener)
  {
    ThreadManager.executeOnFileThread(new GroupVideoManager.7(paramString, paramCheckListener));
  }
  
  private void b(Bundle paramBundle, long paramLong)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle.putString("bizType", "GVideo");
      paramBundle.putString("plugin_id", "Od");
      paramBundle.putString("appid", "1104763709");
      paramBundle.putInt("authtype", 1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        paramBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      }
      paramBundle.putBoolean("preload", true);
      ExecutorService localExecutorService = ThreadManagerExecutor.getExecutorService(192);
      localExecutorService.submit(new GroupVideoManager.3(this, localExecutorService.submit(new GroupVideoManager.2(this)), paramLong, paramBundle));
      return;
      paramBundle = new Bundle();
    }
  }
  
  public PushMessageDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler.a();
  }
  
  public void a(Context paramContext)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AVNotifyCenter localAVNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = paramString1;
      if (!localAVNotifyCenter.a(paramContext, (String)localObject)) {
        break label69;
      }
      QLog.i("GroupVideoManager", 1, "openNewGroupVideoLoadPage, blocked, roomCode[" + paramString1 + "]");
    }
    for (;;)
    {
      return;
      localObject = "0";
      break;
      label69:
      localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
      ((Intent)localObject).putExtra("isPreload", true);
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      localObject = (DynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
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
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("prefs_key_gvideo_roominfo_entry_" + paramString2, ((Intent)localObject).toUri(4)).commit();
        paramContext.startActivity((Intent)localObject);
        if (!(paramContext instanceof Activity)) {
          continue;
        }
        ((Activity)paramContext).overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("GroupVideoManager", 2, paramString1.getMessage());
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, PluginLoadListener paramPluginLoadListener)
  {
    IVPluginLoader.a(paramContext, "com.tencent.od").a("group_video", "openGroupvideo", paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramPluginLoadListener);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JsonObject localJsonObject = new JsonObject();
    localJsonObject.addProperty("sKey", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(paramContext, paramString1, paramString2, paramString3, paramString4, 1, localJsonObject.toString());
  }
  
  public void a(Bundle paramBundle, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      return;
    }
    QLog.e("GroupVideoManager", 2, "preload in wifi");
    b(paramBundle, paramLong);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {}
    Object localObject;
    do
    {
      int i;
      int j;
      do
      {
        return;
        localObject = paramConfig.msg_content_list.get();
        i = paramConfig.version.get();
        j = a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.i("GroupVideoManager", 2, "handleDynamicConfig, version=" + i + ", oldversion=" + j);
        }
      } while (i <= j);
      localObject = ((List)localObject).iterator();
    } while (!((Iterator)localObject).hasNext());
    paramConfig = (ConfigurationService.Content)((Iterator)localObject).next();
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("GroupVideoManager", 2, "handleDynamicConfig, contentStr=" + paramConfig);
      }
      catch (UnsupportedEncodingException paramConfig)
      {
        QLog.e("GroupVideoManager", 1, "handleDynamicConfig new String error, e=" + paramConfig.toString());
      }
      paramConfig = "";
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
    }
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 600000L)
    {
      QLog.w("GroupVideoManager", 2, "preload time less than 10 minutes, return");
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramNewTogetherRoomMessageData.g);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("GroupVideoManager", 2, "fromId not long");
      }
    }
    QLog.i("GroupVideoManager", 2, "receive preload message: " + paramNewTogetherRoomMessageData.toString());
    b(null, l1);
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    paramBundle = new GroupVideoManager.TogetherEnterRoomParam(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    paramBundle.e(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    paramBundle.f(paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    paramBundle.d(paramNewTogetherRoomMessageData.g);
    paramBundle.a(String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Long));
    paramBundle.b(paramNewTogetherRoomMessageData.c);
    paramBundle.c(String.valueOf(paramNewTogetherRoomMessageData.jdField_b_of_type_Int));
    a(paramBundle, paramOnOpenCloseRoomCallback);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      return;
    }
    GVideoGrayConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new GroupVideoManager.1(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          } while (localObject1 == null);
          localObject2 = ((RecentUserProxy)localObject1).a(false);
        } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser.getType() == 1) {
            try
            {
              ((List)localObject1).add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        localObject2 = new GroupVideoManager.4(this, paramBoolean);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject2);
        this.jdField_a_of_type_Int = 0;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject2 == null);
    ((TroopHandler)localObject2).a((List)localObject1, new GroupVideoManager.5(this));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "updateGroupVideoStateList try count:" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Int < 8) && (paramBoolean))
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject2, 1000L);
      return;
    }
    this.jdField_a_of_type_Int = 0;
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
    a();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    GVideoGrayConfig.a().b();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCommunicateWithPluginHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    PluginManagerInterfaceImpl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager
 * JD-Core Version:    0.7.0.1
 */