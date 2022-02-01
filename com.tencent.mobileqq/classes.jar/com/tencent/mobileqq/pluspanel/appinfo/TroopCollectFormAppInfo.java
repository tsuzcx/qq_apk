package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.text.TextUtils;
import ayfu;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class TroopCollectFormAppInfo
  extends PlusPanelAppInfo
{
  @NotNull
  private HashMap<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.substring(paramString1.indexOf("?") + 1);
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramString1.split("&");
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          paramString1 = arrayOfString[i].split("=");
          if (paramString1.length != 2) {
            break label193;
          }
          Object localObject = paramString1[0];
          String str = URLDecoder.decode(paramString1[1]);
          if (!localObject.contains("extraData"))
          {
            paramString1 = str;
            if (!localObject.contains("path")) {}
          }
          else
          {
            paramString1 = str.replace("$GCODE$", "groupid=" + paramString2 + "&groupname=" + paramString3 + "&uinType=" + this.uinType);
          }
          localHashMap.put(localObject, paramString1);
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.qphone.base.util.QLog.e("TroopCollectFormAppInfo", 1, "troopFormLog openTroopFormMiniAppInTroopAIO, " + com.tencent.qphone.base.util.QLog.getStackTraceString(paramString1));
      }
      return localHashMap;
      label193:
      i += 1;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    com.tencent.TMG.utils.QLog.i("TroopCollectFormAppInfo", 1, "troopFormLog openTroopFormMiniAppInTroopAIO:url :" + paramString1);
    if (paramString1.startsWith("mqqapi://microapp/open?"))
    {
      paramString1 = a(paramString1, paramString2, paramString3);
      if (!TextUtils.isEmpty((CharSequence)paramString1.get("appid"))) {
        a(paramContext, paramString1);
      }
      return;
    }
    MiniAppLauncher.startMiniApp(paramContext, paramString1, 2016, null);
  }
  
  private void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = ((String)paramHashMap.get("appid"));
    String str1 = (String)paramHashMap.get("path");
    String str2 = (String)paramHashMap.get("extraData");
    String str3 = (String)paramHashMap.get("envVersion");
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        localLaunchParam.entryPath = URLDecoder.decode(str1.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), "UTF-8");
      }
      if (!TextUtils.isEmpty(str2)) {
        localLaunchParam.navigateExtData = URLDecoder.decode(str2, "UTF-8");
      }
      if (!TextUtils.isEmpty(str3)) {
        localLaunchParam.envVersion = URLDecoder.decode(str3, "UTF-8");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        com.tencent.qphone.base.util.QLog.e("TroopCollectFormAppInfo", 1, "troopFormLog openTroopFormMiniAppInTroopAIO, " + com.tencent.qphone.base.util.QLog.getStackTraceString(localUnsupportedEncodingException));
      }
    }
    localLaunchParam.scene = 2016;
    com.tencent.TMG.utils.QLog.i("TroopCollectFormAppInfo", 1, "troopFormLog openTroopFormMiniAppInTroopAIO:argumentMap :" + paramHashMap.toString());
    MiniAppLauncher.launchMiniAppById(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.navigateExtData, localLaunchParam.envVersion, localLaunchParam.reportData, localLaunchParam.scene);
  }
  
  public int defaultDrawableID()
  {
    return 2130844135;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1108961705;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690720);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    a(paramBaseChatPie.getActivity(), this.url, paramSessionInfo.troopUin, paramSessionInfo.curFriendNick);
    bcef.b(paramBaseChatPie.app, "dc00898", "", paramSessionInfo.curFriendUin, "0X8009FCD", "0X8009FCD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopCollectFormAppInfo
 * JD-Core Version:    0.7.0.1
 */