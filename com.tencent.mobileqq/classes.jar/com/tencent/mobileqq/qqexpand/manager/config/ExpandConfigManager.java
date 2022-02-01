package com.tencent.mobileqq.qqexpand.manager.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoReq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusReq;

public class ExpandConfigManager
{
  private final Object a = new Object();
  private final QQAppInterface b;
  private boolean c;
  private ExpandConfig d;
  private String e = "";
  
  public ExpandConfigManager(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private Map<String, LimitChatRes> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        LimitChatRes localLimitChatRes = new LimitChatRes();
        localLimitChatRes.a = localJSONObject.optString("name");
        if ("aioVideo".equals(localLimitChatRes.a))
        {
          localLimitChatRes.b = localJSONObject.optString("resourceURLAndroid");
          localLimitChatRes.c = localJSONObject.optString("resourceMD5Android");
          if (QLog.isColorLevel()) {
            QLog.d("expand.config.ExpandConfigManager", 2, String.format("aiovideo use android url:%s", new Object[] { localLimitChatRes.b }));
          }
        }
        else
        {
          localLimitChatRes.b = localJSONObject.optString("resourceURL");
          localLimitChatRes.c = localJSONObject.optString("resourceMD5");
        }
        if (localLimitChatRes.a()) {
          localHashMap.put(localLimitChatRes.a, localLimitChatRes);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private ExpandConfig c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start parseConfig ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("expand.config.ExpandConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ExpandSharePreUtils.a(this.b.getAccount());
    ExpandConfig localExpandConfig = new ExpandConfig();
    try
    {
      paramString = new JSONObject(paramString);
      localExpandConfig.androidExpandPlugin = paramString.optInt("androidExpandPlugin", 0);
      localExpandConfig.centerBannerList = paramString.optString("centerBannerList");
      localExpandConfig.tabIndex = paramString.optInt("tabIndex");
      localExpandConfig.testId = paramString.optInt("testId");
      localExpandConfig.testStrId = paramString.optString("testStrId");
      localExpandConfig.saveEmptyAIONode = paramString.optInt("saveEmptyAIONode", 1);
      localExpandConfig.newUserMoment = paramString.optInt("newUserMoment");
      localExpandConfig.isHasUpgradeIntroduce = paramString.optInt("upgradeIntroduce");
      localExpandConfig.flutterSettingPageTitle = paramString.optString("flutterSettingPageTitle");
      localExpandConfig.flutterMessagePageTitle = paramString.optString("flutterMessagePageTitle");
      localExpandConfig.flutterHomePageTitle = paramString.optString("flutterHomePageTitle");
      localExpandConfig.contactEntranceTitle = paramString.optString("contactEntranceTitle");
      localExpandConfig.contactEntranceLine1 = paramString.optString("contactEntranceLine1");
      localExpandConfig.contactEntranceLine2 = paramString.optString("contactEntranceLine2");
      localExpandConfig.addEntranceTitle = paramString.optString("addEntranceTitle");
      localExpandConfig.addEntranceLine1 = paramString.optString("addEntranceLine1");
      localExpandConfig.maxPlayers = paramString.optInt("maxPlayers");
      localExpandConfig.minPlayers = paramString.optInt("minPlayers");
      localExpandConfig.voiceMaxLength = paramString.optInt("voiceMaxLength");
      localExpandConfig.maxSlipTimes = paramString.optInt("maxSlipTimes");
      localExpandConfig.redisplayInterval = paramString.optInt("redisplayInterval");
      localExpandConfig.defaultDecleration = paramString.optString("defaultDecleration");
      localExpandConfig.declerationMinLen = paramString.optInt("declerationMinLen");
      localExpandConfig.isExpandEntranceOnTop = paramString.optInt("isExpandEntranceOnTop");
      localExpandConfig.mResourceURL = paramString.optString("resourceURL");
      localExpandConfig.mResourceMD5 = paramString.optString("resourceMD5");
      localExpandConfig.flutterResUrl = paramString.optString("flutterResAndroidURL_v5");
      localExpandConfig.flutterResMd5 = paramString.optString("flutterResAndroidMD5_v5");
      localExpandConfig.mShowGroup = paramString.optInt("isShowGroup");
      localExpandConfig.expandExamImg = paramString.optString("ExpandExamImg");
      localExpandConfig.exposureTimeLimit = paramString.optInt("exposureTimeLimit", 2);
      localExpandConfig.showVipIcon = paramString.optBoolean("showVipIcon", false);
      localExpandConfig.matchChatGrayTipsCount = paramString.optInt("GrayTipsMsgCount", 50);
      localExpandConfig.matchChatGrayTipsMsg = paramString.optString("GrayTipsMsg");
      localExpandConfig.matchChatGrayTipsLight = paramString.optString("GrayTipsMsgLight");
      localExpandConfig.matchChatIceBreakSwitch = paramString.optInt("IceBreakSwitch", 1);
      localExpandConfig.mBeatWarning = paramString.optString("BeatWarning");
      localExpandConfig.sendPicAndVoiceMessageLimitCount = paramString.optInt("sendPicAndVoiceMessageLimitCount", 2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseConfig config.exposureTimeLimit:");
        ((StringBuilder)localObject2).append(localExpandConfig.exposureTimeLimit);
        ((StringBuilder)localObject2).append(", config.sendPicAndVoiceMessageLimitCount = ");
        ((StringBuilder)localObject2).append(localExpandConfig.sendPicAndVoiceMessageLimitCount);
        QLog.d("expand.config.ExpandConfigManager", 2, ((StringBuilder)localObject2).toString());
      }
      localExpandConfig.defaultTags.clear();
      Object localObject2 = paramString.optJSONArray("defaultTags");
      int i;
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localExpandConfig.defaultTags.add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
      }
      localExpandConfig.searchTags.clear();
      localObject2 = paramString.optJSONArray("searchTags");
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localExpandConfig.searchTags.add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
      }
      localExpandConfig.searchHint = paramString.optString("searchHint");
      localObject2 = a(paramString.optJSONArray("ExpandMatchRes"));
      localExpandConfig.limitChatResList.putAll((Map)localObject2);
      localExpandConfig.bLimitchatOpen = paramString.optInt("ExpandMatchSwitch");
      localExpandConfig.bNuanSSfirstTab = paramString.optInt("isNuanSSFirst");
      localExpandConfig.bVoiceMatchOpen = paramString.optInt("isVoiceMatchOpen");
      localExpandConfig.bSignalBombOpen = paramString.optInt("isSignalOpen");
      localExpandConfig.coldPalaceGrayTipPosition = paramString.optInt("coldPalaceGrayTipPosition", localExpandConfig.coldPalaceGrayTipPosition);
      paramString = new StringBuilder();
      paramString.append("parseConfig config taskId=");
      paramString.append((String)localObject1);
      paramString.append(" isPlugin=");
      paramString.append(localExpandConfig.androidExpandPlugin);
      QLog.i("expand.config.ExpandConfigManager", 1, paramString.toString());
      if (QLog.isColorLevel()) {
        QLog.d("expand.config.ExpandConfigManager", 2, new Object[] { "parseConfig() ", Integer.valueOf(localExpandConfig.androidExpandPlugin), "-", localExpandConfig.flutterResUrl, "-", localExpandConfig.flutterResMd5 });
      }
      return localExpandConfig;
    }
    catch (JSONException paramString)
    {
      QLog.e("expand.config.ExpandConfigManager", 2, "parseConfig fail.", paramString);
    }
    return null;
  }
  
  private void m()
  {
    if (this.b == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "checkPullUserCategory app is null!");
      return;
    }
    k();
  }
  
  public ExpandConfig a()
  {
    return this.d;
  }
  
  public void a(IConfigCallback paramIConfigCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getABTestConfig ");
    }
    ExtendFriendABTestConfig.GetTabTestInfoReq localGetTabTestInfoReq = new ExtendFriendABTestConfig.GetTabTestInfoReq();
    localGetTabTestInfoReq.version.set("1");
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a(this.b);
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.Tab.GetGrayPolicyInfo", localGetTabTestInfoReq.toByteArray(), 1, new ExpandConfigManager.3(this, paramIConfigCallback));
  }
  
  public void a(String arg1)
  {
    QLog.i("expand.config.ExpandConfigManager", 1, "new config coming");
    ExpandConfig localExpandConfig = c(???);
    synchronized (this.a)
    {
      this.d = localExpandConfig;
      this.c = true;
      return;
    }
  }
  
  public ExpandConfig b()
  {
    if (!c()) {
      d();
    }
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    if (this.c) {
      return;
    }
    m();
    try
    {
      ??? = ConfigUtil.a(this.b.getApp(), this.b.getCurrentAccountUin(), "extend_friend_config_785");
      Object localObject1 = ???;
      if (??? == null)
      {
        QLog.e("expand.config.ExpandConfigManager", 2, "Load config is empty!!!");
        localObject1 = "{\n\"//\":\"850实验新用户进入新扩列界面时有个引导时刻：1:有这个引导时刻，0:无该引导时刻\",\n\"newUserMoment\": 1,\n\"//\":\"850实验是否出现升级提示: 0: 不出现  1:出现\",\n\"upgradeIntroduce\": 0,\n\"//\":\"实验对照组ID\",\n\"testStrId\":\"local\",\n\"//\":\"联系人入口、添加入口的开关、文案分别配置\",\n\"addEntranceTitle\":\"扩列匹配\",\n\n\"isVoiceMatchOpen\":1,\n\"//\":\"扩列中间自研模块的配置项\",\n\"centerBannerList\":[\n]\n}";
      }
      ??? = c((String)localObject1);
      localObject1 = ???;
      if (??? == null)
      {
        QLog.e("expand.config.ExpandConfigManager", 2, "Load error config!!!");
        localObject1 = c("{\n\"//\":\"850实验新用户进入新扩列界面时有个引导时刻：1:有这个引导时刻，0:无该引导时刻\",\n\"newUserMoment\": 1,\n\"//\":\"850实验是否出现升级提示: 0: 不出现  1:出现\",\n\"upgradeIntroduce\": 0,\n\"//\":\"实验对照组ID\",\n\"testStrId\":\"local\",\n\"//\":\"联系人入口、添加入口的开关、文案分别配置\",\n\"addEntranceTitle\":\"扩列匹配\",\n\n\"isVoiceMatchOpen\":1,\n\"//\":\"扩列中间自研模块的配置项\",\n\"centerBannerList\":[\n]\n}");
      }
      synchronized (this.a)
      {
        if (!this.c)
        {
          this.d = ((ExpandConfig)localObject1);
          this.c = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("expand.config.ExpandConfigManagerexpand.enter.", 2, "initConfig");
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("expand.config.ExpandConfigManager", 2, localException.getMessage(), localException);
      }
    }
  }
  
  public boolean e()
  {
    ExpandConfig localExpandConfig = this.d;
    return (localExpandConfig != null) && (localExpandConfig.androidExpandPlugin == 0) && (!TextUtils.isEmpty(this.d.flutterResUrl)) && (!TextUtils.isEmpty(this.d.flutterResMd5));
  }
  
  public boolean f()
  {
    ExpandConfig localExpandConfig = this.d;
    return (localExpandConfig != null) && (localExpandConfig.androidExpandPlugin == 1);
  }
  
  public boolean g()
  {
    return true;
  }
  
  public boolean h()
  {
    boolean bool3 = c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      ExpandConfig localExpandConfig = this.d;
      bool1 = bool2;
      if (localExpandConfig != null)
      {
        bool1 = bool2;
        if (localExpandConfig.saveEmptyAIONode == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int i()
  {
    if (c())
    {
      ExpandConfig localExpandConfig = this.d;
      if (localExpandConfig != null) {
        return localExpandConfig.isHasUpgradeIntroduce;
      }
    }
    return 0;
  }
  
  public boolean j()
  {
    boolean bool3 = c();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      ExpandConfig localExpandConfig = this.d;
      bool1 = bool2;
      if (localExpandConfig != null)
      {
        if (localExpandConfig.newUserMoment == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void k()
  {
    if (!ExpandSharePreUtils.f(this.b.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("expand.config.ExpandConfigManager", 2, "getUserCategoryConfig() return(no need request).");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getUserCategory ");
    }
    ExtendFriendUserCategory.GetUserStatusReq localGetUserStatusReq = new ExtendFriendUserCategory.GetUserStatusReq();
    localGetUserStatusReq.ReqUserCategory.set(true);
    localGetUserStatusReq.ReqUsedNewMatchFlag.set(true);
    localGetUserStatusReq.ReqHasPersonalLabelsFlag.set(true);
    localGetUserStatusReq.ReqForbiddenInfo.set(false);
    localGetUserStatusReq.ReqLastLoginTime.set(true);
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a(this.b);
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getUserCategory cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.UserInfo.GetUserStatus", localGetUserStatusReq.toByteArray(), new ExpandConfigManager.1(this));
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.config.ExpandConfigManager", 2, "getForbiddenInfo ");
    }
    ExtendFriendUserCategory.GetUserStatusReq localGetUserStatusReq = new ExtendFriendUserCategory.GetUserStatusReq();
    localGetUserStatusReq.ReqForbiddenInfo.set(true);
    ExpandCmdHandler localExpandCmdHandler = ExpandCmdHandler.a(this.b);
    if (localExpandCmdHandler == null)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getForbiddenInfo cmdHandler is null!");
      return;
    }
    localExpandCmdHandler.a("QQExpand.UserInfo.GetUserStatus", localGetUserStatusReq.toByteArray(), new ExpandConfigManager.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager
 * JD-Core Version:    0.7.0.1
 */