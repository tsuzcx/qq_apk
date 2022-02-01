package com.tencent.mobileqq.extendfriend.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.bean.entrance.BannerInfo;
import com.tencent.mobileqq.qqexpand.bean.entrance.EntranceInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.BannerManager;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceGetRsp;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceInfo;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceManager;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.GetCtrl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendCardUtils
{
  public static BannerInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("banner_mgr");
    if (paramJSONObject == null) {
      return null;
    }
    BannerInfo localBannerInfo = new BannerInfo();
    localBannerInfo.a = paramJSONObject.optString("title");
    localBannerInfo.b = paramJSONObject.optString("icon_url");
    localBannerInfo.c = paramJSONObject.optString("jump_url");
    return localBannerInfo;
  }
  
  public static ArrayList<EntranceInfo> a(Entrance.EntranceGetRsp paramEntranceGetRsp)
  {
    if ((paramEntranceGetRsp != null) && (paramEntranceGetRsp.entrance_mgr != null))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramEntranceGetRsp.entrance_mgr.entrances.size();
      int i = 0;
      while (i < j)
      {
        Entrance.EntranceInfo localEntranceInfo = (Entrance.EntranceInfo)paramEntranceGetRsp.entrance_mgr.entrances.get(i);
        EntranceInfo localEntranceInfo1 = new EntranceInfo();
        localEntranceInfo1.a = localEntranceInfo.id.get();
        localEntranceInfo1.b = localEntranceInfo.title.get();
        localEntranceInfo1.c = localEntranceInfo.subtitle.get();
        localEntranceInfo1.d = localEntranceInfo.icon_url.get();
        localEntranceInfo1.e = localEntranceInfo.backgroud_url.get();
        localEntranceInfo1.f = localEntranceInfo.jump_url.get();
        localArrayList.add(localEntranceInfo1);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendCardUtils", 1, "readFromLocal app is null");
      return null;
    }
    paramQQAppInterface = c(paramQQAppInterface);
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendCardUtils", 1, "readFromLocal sp is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getString("key_data", "");
    if (TextUtils.isEmpty(paramQQAppInterface))
    {
      QLog.e("ExtendFriendCardUtils", 1, "readFromLocal data is null");
      return null;
    }
    try
    {
      paramQQAppInterface = new JSONObject(paramQQAppInterface);
      return paramQQAppInterface;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramQQAppInterface, new Object[0]);
    }
    return null;
  }
  
  public static JSONObject a(Entrance.BannerManager paramBannerManager)
  {
    if (paramBannerManager == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("can_show", Boolean.valueOf(paramBannerManager.can_show.get()));
      localJSONObject.putOpt("title", paramBannerManager.title.get());
      localJSONObject.putOpt("icon_url", paramBannerManager.icon_url.get());
      localJSONObject.putOpt("jump_url", paramBannerManager.jump_url.get());
      return localJSONObject;
    }
    catch (JSONException paramBannerManager)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramBannerManager, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(Entrance.EntranceInfo paramEntranceInfo)
  {
    if (paramEntranceInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("id", Integer.valueOf(paramEntranceInfo.id.get()));
      localJSONObject.putOpt("title", paramEntranceInfo.title.get());
      localJSONObject.putOpt("subtitle", paramEntranceInfo.subtitle.get());
      localJSONObject.putOpt("icon_url", paramEntranceInfo.icon_url.get());
      localJSONObject.putOpt("backgroud_url", paramEntranceInfo.backgroud_url.get());
      localJSONObject.putOpt("jump_url", paramEntranceInfo.jump_url.get());
      return localJSONObject;
    }
    catch (JSONException paramEntranceInfo)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramEntranceInfo, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(Entrance.EntranceManager paramEntranceManager)
  {
    if (paramEntranceManager == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("can_show", Boolean.valueOf(paramEntranceManager.can_show.get()));
      JSONArray localJSONArray = new JSONArray();
      int j = paramEntranceManager.entrances.size();
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(a((Entrance.EntranceInfo)paramEntranceManager.entrances.get(i)));
        i += 1;
      }
      localJSONObject.putOpt("entrances", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException paramEntranceManager)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramEntranceManager, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(Entrance.GetCtrl paramGetCtrl)
  {
    if (paramGetCtrl == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("allow_force_fresh", Boolean.valueOf(paramGetCtrl.allow_force_fresh.get()));
      localJSONObject.putOpt("get_interval_ms", Integer.valueOf(paramGetCtrl.get_interval_ms.get()));
      return localJSONObject;
    }
    catch (JSONException paramGetCtrl)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramGetCtrl, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Entrance.EntranceGetRsp paramEntranceGetRsp)
  {
    boolean bool2 = true;
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendCardUtils", 1, "saveToLocal app is null");
      return;
    }
    paramQQAppInterface = c(paramQQAppInterface);
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendCardUtils", 1, "saveToLocal sp is null");
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    int i;
    if ((paramEntranceGetRsp.banner_mgr != null) && (paramEntranceGetRsp.banner_mgr.can_show.get())) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = a(paramEntranceGetRsp);
    boolean bool1;
    if ((i != 0) && (localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l;
    if (paramEntranceGetRsp.ctrl != null) {
      l = paramEntranceGetRsp.ctrl.get_interval_ms.get();
    } else {
      l = -1L;
    }
    paramQQAppInterface.putBoolean("sp_contacts_entrance_can_show", bool1);
    paramQQAppInterface.putLong("sp_contacts_entrance_update_time", NetConnInfoCenter.getServerTime());
    paramQQAppInterface.putLong("sp_contacts_entrance_expire_time", l);
    if ((paramEntranceGetRsp.ctrl != null) && (paramEntranceGetRsp.ctrl.allow_force_fresh.get())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramQQAppInterface.putBoolean("sp_contacts_entrance_allow_force_refresh", bool1);
    paramEntranceGetRsp = b(paramEntranceGetRsp);
    if (paramEntranceGetRsp != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveToLocal data: ");
        ((StringBuilder)localObject).append(paramEntranceGetRsp.toString());
        QLog.d("ExtendFriendCardUtils", 2, ((StringBuilder)localObject).toString());
      }
      paramQQAppInterface.putString("key_data", paramEntranceGetRsp.toString());
    }
    paramQQAppInterface.apply();
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    paramAppInterface = c(paramAppInterface);
    if (paramAppInterface == null) {
      return false;
    }
    return paramAppInterface.getBoolean("sp_contacts_entrance_can_show", false);
  }
  
  public static ArrayList<EntranceInfo> b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("entrance_mgr");
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray("entrances");
    if (paramJSONObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONObject.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null)
      {
        EntranceInfo localEntranceInfo = new EntranceInfo();
        localEntranceInfo.a = localJSONObject.optInt("id");
        localEntranceInfo.b = localJSONObject.optString("title");
        localEntranceInfo.c = localJSONObject.optString("subtitle");
        localEntranceInfo.d = localJSONObject.optString("icon_url");
        localEntranceInfo.e = localJSONObject.optString("backgroud_url");
        localEntranceInfo.f = localJSONObject.optString("jump_url");
        localArrayList.add(localEntranceInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static JSONObject b(Entrance.EntranceGetRsp paramEntranceGetRsp)
  {
    if (paramEntranceGetRsp == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("ctrl", a(paramEntranceGetRsp.ctrl));
      localJSONObject.putOpt("banner_mgr", a(paramEntranceGetRsp.banner_mgr));
      localJSONObject.putOpt("entrance_mgr", a(paramEntranceGetRsp.entrance_mgr));
      localJSONObject.putOpt("entrance_switch_text", paramEntranceGetRsp.entrance_switch_text.get());
      return localJSONObject;
    }
    catch (JSONException paramEntranceGetRsp)
    {
      QLog.e("ExtendFriendCardUtils", 1, paramEntranceGetRsp, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    paramAppInterface = c(paramAppInterface);
    if (paramAppInterface == null) {
      return false;
    }
    return paramAppInterface.getBoolean("sp_contacts_entrance_allow_force_refresh", false);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (StudyModeManager.h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false isStudyMode");
      }
      return false;
    }
    if (AppSetting.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false enableTalkBack");
      }
      return false;
    }
    if (!a(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false service config");
      }
      return false;
    }
    if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getExtendFriendUserSwitch(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow false user switch");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCardUtils", 2, "isEntranceReallyCanShow true");
    }
    return true;
  }
  
  private static SharedPreferences c(AppInterface paramAppInterface)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_extend_friend_entrance_local_data");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = c(paramQQAppInterface);
    boolean bool1 = true;
    if (paramQQAppInterface == null) {
      return true;
    }
    boolean bool2 = LocaleManager.c();
    if (bool2)
    {
      QLog.d("ExtendFriendCardUtils", 1, "getIfExpandContactsEntranceNeedUpdate: by change local language");
      return true;
    }
    long l1 = paramQQAppInterface.getLong("sp_contacts_entrance_expire_time", 10000L) / 1000L;
    long l2 = paramQQAppInterface.getLong("sp_contacts_entrance_update_time", 0L);
    long l3 = NetConnInfoCenter.getServerTime();
    if (l3 - l2 < l1) {
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getIfExpandContactsEntranceNeedUpdate: ");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append(" update :");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(" now：");
      paramQQAppInterface.append(l3);
      paramQQAppInterface.append(" needUpdate：");
      paramQQAppInterface.append(bool1);
      QLog.d("ExtendFriendCardUtils", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    int i;
    if (b(paramQQAppInterface)) {
      i = MatchChatMsgUtil.b(paramQQAppInterface);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getContactsTabRedPointNum: ");
      paramQQAppInterface.append(i);
      QLog.d("ExtendFriendCardUtils", 2, paramQQAppInterface.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils
 * JD-Core Version:    0.7.0.1
 */