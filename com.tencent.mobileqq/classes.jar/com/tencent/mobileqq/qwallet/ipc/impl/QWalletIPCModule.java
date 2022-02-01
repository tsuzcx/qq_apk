package com.tencent.mobileqq.qwallet.ipc.impl;

import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IConditionSearchManager;
import com.qwallet.temp.IFriendsManager;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QWalletIPCModule
  extends QIPCModule
{
  private static QWalletIPCModule jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule;
  private Map<Integer, IQWalletConfigService.ConfigUpdateListener> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private QWalletIPCModule()
  {
    super("QWalletIPCModule");
  }
  
  public static QWalletIPCModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule = new QWalletIPCModule();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule;
  }
  
  private void a(Bundle paramBundle, BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("channel");
    Object localObject1 = paramBundle.getString("uin");
    Object localObject2 = paramBundle.getString("group_id");
    Object localObject3 = (IFriendsManager)paramBaseQQAppInterface.getRuntimeService(IFriendsManager.class);
    if (((i != 5) && ((i & 0x10) == 0)) || ((((IFriendsManager)localObject3).isFriend((String)localObject1)) && (!paramBaseQQAppInterface.getCurrentAccountUin().equals(localObject1))))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramBundle = null;
        localObject3 = ((IFriendsManager)localObject3).findFriendEntityByUin((String)localObject1);
        localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).TroopManager$getTroopMember(paramBaseQQAppInterface, (String)localObject2, (String)localObject1);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((Friends)localObject3).remark))) {
          paramBundle = ((Friends)localObject3).remark;
        } else if ((localObject2 != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))) {
          paramBundle = ((TroopMemberInfo)localObject2).troopnick;
        } else if (localObject3 != null) {
          paramBundle = ((Friends)localObject3).name;
        } else if (localObject2 != null) {
          if (((String)localObject1).equals(paramBaseQQAppInterface.getCurrentAccountUin())) {
            paramBundle = ((TroopMemberInfo)localObject2).friendnick;
          } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark)) {
            paramBundle = ((TroopMemberInfo)localObject2).autoremark;
          } else {
            paramBundle = ((TroopMemberInfo)localObject2).friendnick;
          }
        }
        paramBaseQQAppInterface = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramBaseQQAppInterface = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName((String)localObject1, true);
        }
      }
      else
      {
        paramBaseQQAppInterface = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName((String)localObject1, true);
      }
    }
    else
    {
      paramBaseQQAppInterface = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getDateNickName((String)localObject1);
      if (TextUtils.isEmpty(paramBaseQQAppInterface)) {
        paramBaseQQAppInterface = (BaseQQAppInterface)localObject1;
      }
    }
    paramBundle = new EIPCResult();
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("user_nick", paramBaseQQAppInterface);
    paramBundle.data = ((Bundle)localObject1);
    callbackResult(paramInt, paramBundle);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle)
  {
    if ((paramBaseQQAppInterface != null) && (paramBundle != null))
    {
      paramBundle = (HashMap)paramBundle.getSerializable("params_value");
      if (paramBundle != null)
      {
        paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
        if (paramBaseQQAppInterface != null) {
          paramBaseQQAppInterface.setConfigSession(paramBundle);
        }
      }
    }
  }
  
  private EIPCResult b(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    switch (paramBundle.getInt("oper_type", -1))
    {
    case 14: 
    case 17: 
    default: 
      return null;
    case 18: 
      paramInt = ComIPCUtilsImpl.getFileExistStatusInMainProcess(paramBundle.getString("path"));
      paramBaseQQAppInterface = new Bundle();
      paramBaseQQAppInterface.putInt("res", paramInt);
      return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
    case 16: 
      localObject1 = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      paramBundle = this.jdField_a_of_type_JavaUtilMap;
      if ((paramBundle != null) && (paramBundle.containsKey(Integer.valueOf(paramInt))))
      {
        paramBundle = (IQWalletConfigService.ConfigUpdateListener)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
        if (paramBaseQQAppInterface != null) {
          paramBaseQQAppInterface.unRegisterUpdateListener((String)localObject1, paramBundle);
        }
      }
      return null;
    case 15: 
      localObject1 = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      paramBundle = new QWalletIPCModule.5(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
      paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
      if (paramBaseQQAppInterface != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilMap;
        if ((localObject2 != null) && (!((Map)localObject2).containsKey(Integer.valueOf(paramInt)))) {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramBundle);
        }
        paramBaseQQAppInterface.registerUpdateListener((String)localObject1, paramBundle);
      }
      return null;
    case 13: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      if ((paramBaseQQAppInterface != null) && (paramBundle != null))
      {
        ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, paramBundle.msg_id.hashCode());
        ((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).QQAppInterface$refreshAppBadge(paramBaseQQAppInterface);
      }
      return null;
    case 12: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      if (paramBundle != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ActivateFriendsManag$PREF_ACTIVATE_FRIENDS());
        ((StringBuilder)localObject1).append(paramBaseQQAppInterface.getCurrentAccountUin());
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject1 = paramBaseQQAppInterface.getApp().getSharedPreferences((String)localObject1, 0);
        if (localObject1 != null)
        {
          localObject1 = ((SharedPreferences)localObject1).edit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramBundle.msg_id);
          ((StringBuilder)localObject2).append(paramBaseQQAppInterface.getCurrentAccountUin());
          ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString()).apply();
        }
        paramBaseQQAppInterface = (IQQReminderAlarmService)paramBaseQQAppInterface.getRuntimeService(IQQReminderAlarmService.class, "");
        if (paramBaseQQAppInterface != null) {
          paramBaseQQAppInterface.cancelAlarmById(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQNotifyHelper$getKey(paramBundle).hashCode());
        }
      }
      return null;
    case 11: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      paramBaseQQAppInterface = (IQQReminderAlarmService)paramBaseQQAppInterface.getRuntimeService(IQQReminderAlarmService.class, "");
      if ((paramBaseQQAppInterface != null) && (paramBundle != null)) {
        paramBaseQQAppInterface.setAlarmTimer(paramBundle);
      }
      return null;
    case 10: 
      boolean bool = paramBundle.getBoolean("req_param");
      paramBaseQQAppInterface = (IQQActivateFriendService)paramBaseQQAppInterface.getRuntimeService(IQQActivateFriendService.class);
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.setSwtichValue(bool, true);
      }
      return null;
    case 9: 
      paramBundle = new Bundle();
      paramBaseQQAppInterface = (IQQActivateFriendService)paramBaseQQAppInterface.getRuntimeService(IQQActivateFriendService.class);
      if (paramBaseQQAppInterface != null) {
        paramBundle.putBoolean("res", paramBaseQQAppInterface.getSwitchValue(true));
      } else {
        paramBundle.putBoolean("res", true);
      }
      return EIPCResult.createSuccessResult(paramBundle);
    case 8: 
      paramInt = paramBundle.getInt("req_id");
      EmojiGifHelper.a().b(paramInt);
      return null;
    case 7: 
      paramBaseQQAppInterface = (ConvertParam)paramBundle.getSerializable("req_param");
      EmojiGifHelper.a().a(paramBaseQQAppInterface, new QWalletIPCModule.4(this, paramInt));
      return null;
    case 6: 
      paramBundle = paramBundle.getString("req_param");
      paramBaseQQAppInterface = (IQWalletRedService)paramBaseQQAppInterface.getRuntimeService(IQWalletRedService.class);
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.doClick(paramBundle);
      }
      return null;
    case 5: 
      paramBundle.getInt("action");
      paramBaseQQAppInterface = (MiniAppConfig)paramBundle.getSerializable("req_param");
    case 3: 
    case 4: 
      return null;
    case 2: 
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).tryUpdateMiniApp(paramBaseQQAppInterface, paramBundle);
      return null;
    case 1: 
      paramBundle = (LaunchParam)paramBundle.getSerializable("mini_launch_param");
      MiniAppLauncher.launchMiniApp(paramBaseQQAppInterface.getApp(), paramBundle);
      callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      return null;
    }
    paramBaseQQAppInterface = paramBundle.getString("uin");
    paramBaseQQAppInterface = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramBaseQQAppInterface, true);
    paramBundle = new Bundle();
    paramBundle.putString("res", paramBaseQQAppInterface);
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private EIPCResult c(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("method_type", -1);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          paramBaseQQAppInterface = PreloadStaticApi.a((DownloadParam)paramBundle.getSerializable("download_params"));
          paramBundle = new Bundle();
          paramBundle.putSerializable("path_result", paramBaseQQAppInterface);
          return EIPCResult.createSuccessResult(paramBundle);
        }
        paramBundle = (LinkedList)paramBundle.getSerializable("download_params");
        ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, "")).getResPath(paramBundle, new QWalletIPCModule.8(this, paramInt));
        return null;
      }
      Object localObject = paramBundle.getStringArray("url");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Arrays.asList((Object[])localObject);
      }
      paramBundle = new QWalletIPCModule.6(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
      ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, "")).downloadUrls((List)localObject, paramBundle);
      return null;
    }
    paramBundle = (DownloadParam)paramBundle.getSerializable("download_params");
    ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, "")).getResPath(paramBundle, new QWalletIPCModule.7(this, paramInt));
    return null;
  }
  
  public Bundle a(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle)
  {
    paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
    Bundle localBundle = new Bundle();
    String str = paramBundle.getString("module");
    int i = paramBundle.getInt("oper_type");
    String[] arrayOfString = paramBundle.getStringArray("sub_keys");
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return localBundle;
        }
        localBundle.putString("res_get_value", paramBaseQQAppInterface.getConfig(str));
        return localBundle;
      }
      localBundle.putString("res_get_value", paramBaseQQAppInterface.getString(str, paramBundle.getString("def_value"), arrayOfString));
      return localBundle;
    }
    localBundle.putInt("res_get_value", paramBaseQQAppInterface.getInt(str, paramBundle.getInt("def_value"), arrayOfString));
    return localBundle;
  }
  
  public EIPCResult a(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramInt = paramBundle.getInt("key_func");
    Object localObject3 = (ResultReceiver)paramBundle.getParcelable("key_callback");
    Object localObject1 = (IRedPacketManager)QRoute.api(IRedPacketManager.class);
    Object localObject2 = new Bundle();
    int i = 0;
    switch (paramInt)
    {
    default: 
      return null;
    case 7: 
      paramBaseQQAppInterface = (IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
      if (paramBaseQQAppInterface != null)
      {
        localObject1 = paramBundle.getString("key_hb_list_id", "");
        localObject2 = paramBundle.getString("key_session_uin", "");
        paramBundle = paramBundle.getString("key_session_type", "");
      }
      break;
    }
    try
    {
      paramInt = Integer.parseInt(paramBundle);
    }
    catch (Exception localException)
    {
      label155:
      break label155;
    }
    paramInt = i;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("QWalletIPC sessionType");
      ((StringBuilder)localObject3).append(paramBundle);
      QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject3).toString());
      paramInt = i;
    }
    paramBaseQQAppInterface.setPasswdRedBagOpen((String)localObject1, (String)localObject2, paramInt);
    return null;
    paramInt = paramBundle.getInt("theme_id");
    ((Bundle)localObject2).putBoolean("key_theme_exist", ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).onGetThemeConfig(paramInt));
    return EIPCResult.createSuccessResult((Bundle)localObject2);
    paramBaseQQAppInterface = ((IRedPacketManager)localObject1).getPopAd(paramBundle.getInt("key_skin_id", 0), paramBundle.getInt("key_channel", 0));
    if (paramBaseQQAppInterface != null)
    {
      ((Bundle)localObject2).putString("pop_ad_tips", paramBaseQQAppInterface.optString("tips"));
      ((Bundle)localObject2).putString("pop_ad_url", paramBaseQQAppInterface.optString("url"));
      ((Bundle)localObject2).putInt("pop_ad_url_type", paramBaseQQAppInterface.optInt("urlType"));
      ((Bundle)localObject2).putInt("pop_ad_icon", paramBaseQQAppInterface.optInt("icon"));
      ((Bundle)localObject2).putString("pop_ad_bg_jump_url", paramBaseQQAppInterface.optString("bg_jump_url"));
    }
    return EIPCResult.createSuccessResult((Bundle)localObject2);
    ((IRedPacketManager)localObject1).requestRedPacketSkinList();
    return null;
    ((Bundle)localObject2).putBoolean("key_is_risk_switch_open", ((IRedPacketManager)localObject1).isRiskSwitchOpen());
    return EIPCResult.createSuccessResult((Bundle)localObject2);
    paramBaseQQAppInterface = (RedPacketInfoBase)paramBundle.getParcelable("key_red_packet_info");
    paramBundle = new QWalletIPCModule.9(this, (Bundle)localObject2, (ResultReceiver)localObject3);
    if (paramInt == 1)
    {
      ((IRedPacketManager)localObject1).getSkin(paramBaseQQAppInterface, paramBundle);
      return null;
    }
    if (paramInt == 5) {
      ((IRedPacketManager)localObject1).getVoiceRateRes(paramBaseQQAppInterface, paramBundle);
    }
    return null;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("action = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", params = ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = QWalletHelperImpl.getAppRuntime();
    if (!(localObject1 instanceof BaseQQAppInterface)) {
      return null;
    }
    Object localObject2 = (BaseQQAppInterface)localObject1;
    if ("getFilePathByResID".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCModule", 2, "onCall getFilePathByResID");
      }
      ThreadManager.post(new QWalletIPCModule.1(this, paramBundle, paramInt, (AppRuntime)localObject1), 5, null, true);
      return null;
    }
    if ((!"downloadModule".equals(paramString)) && (!"downloadRes".equals(paramString)))
    {
      if ("getVideoResPathByMID".equals(paramString))
      {
        paramString = paramBundle.getString("mid");
        paramString = ((IPreloadService)((AppRuntime)localObject1).getRuntimeService(IPreloadService.class, "")).getVideoResPathByID(paramString);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onCall getVideoResPathByMID:");
          paramBundle.append(paramString);
          QLog.d("QWalletIPCModule", 2, paramBundle.toString());
        }
        paramBundle = new Bundle();
        paramBundle.putString("path", paramString);
        return EIPCResult.createSuccessResult(paramBundle);
      }
      if ("getResourceByResID".equals(paramString))
      {
        paramString = paramBundle.getString("res_id");
        paramString = ((IPreloadService)((AppRuntime)localObject1).getRuntimeService(IPreloadService.class, "")).getResourceByResID(paramString);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onCall getResourceByResID:");
          paramBundle.append(paramString);
          QLog.d("QWalletIPCModule", 2, paramBundle.toString());
        }
        paramBundle = new Bundle();
        paramBundle.putSerializable("res_info", paramString);
        return EIPCResult.createSuccessResult(paramBundle);
      }
      if ("getResInfoByResID".equals(paramString))
      {
        paramString = paramBundle.getString("res_id");
        paramString = ((IPreloadService)((AppRuntime)localObject1).getRuntimeService(IPreloadService.class, "")).getResInfoByResId(paramString);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onCall ACTION_GET_RESINFO_BY_RESID:");
          paramBundle.append(paramString);
          QLog.d("QWalletIPCModule", 2, paramBundle.toString());
        }
        paramBundle = new Bundle();
        paramBundle.putSerializable("res_info", paramString);
        return EIPCResult.createSuccessResult(paramBundle);
      }
      if ("getResIDByBusinessID".equals(paramString))
      {
        paramBundle.getString("bid");
        paramBundle.getString("uin");
        paramString = new Bundle();
        paramString.putString("res_id", null);
        return EIPCResult.createSuccessResult(paramString);
      }
      if ("getConfig".equals(paramString)) {
        return EIPCResult.createSuccessResult(a((BaseQQAppInterface)localObject2, paramBundle));
      }
      if ("setConfigSession".equals(paramString))
      {
        a((BaseQQAppInterface)localObject2, paramBundle);
        return null;
      }
      if ("getConditionSearchManager".equals(paramString))
      {
        paramString = (ResultReceiver)paramBundle.getParcelable("receiver");
        paramBundle = (IConditionSearchManager)((BaseQQAppInterface)localObject2).getRuntimeService(IConditionSearchManager.class);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ConditionSearchManager ");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject1).toString());
        paramInt = paramBundle.checkUpdate();
        if (paramInt != paramBundle.resultOk())
        {
          int i = paramBundle.update(paramInt, true);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ConditionSearchManager | update result = ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = new Bundle();
          if (i == paramBundle.updateOk()) {
            paramBundle.addListener(new QWalletIPCModule.3(this, (Bundle)localObject1, i, paramString, paramBundle));
          }
          ((Bundle)localObject1).putInt("isUpdateSuccess", 0);
          ((Bundle)localObject1).putInt("updateResult", i);
          paramString.send(paramInt, (Bundle)localObject1);
          return null;
        }
        paramString.send(paramBundle.resultOk(), new Bundle());
        return null;
      }
      if ("getUserNick".equals(paramString))
      {
        a(paramBundle, (BaseQQAppInterface)localObject2, paramInt);
        return null;
      }
      if ("red_packet".equals(paramString)) {
        return a((BaseQQAppInterface)localObject2, paramBundle, paramInt);
      }
      if ("ComIPCUtilsImpl".equals(paramString)) {
        try
        {
          paramString = b((BaseQQAppInterface)localObject2, paramBundle, paramInt);
          return paramString;
        }
        catch (Throwable paramString)
        {
          if (-1 == paramInt) {
            return EIPCResult.createExceptionResult(paramString);
          }
          callbackResult(paramInt, EIPCResult.createExceptionResult(paramString));
          return null;
        }
      }
      if ("preloadCommon".equals(paramString)) {
        return c((BaseQQAppInterface)localObject2, paramBundle, paramInt);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onCall downloadModule:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject2).toString());
      }
      ThreadManager.post(new QWalletIPCModule.2(this, paramBundle, (AppRuntime)localObject1, paramString), 5, null, true);
      callbackResult(paramInt, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule
 * JD-Core Version:    0.7.0.1
 */