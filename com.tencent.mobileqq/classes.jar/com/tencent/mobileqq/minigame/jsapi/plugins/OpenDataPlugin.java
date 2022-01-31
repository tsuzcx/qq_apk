package com.tencent.mobileqq.minigame.jsapi.plugins;

import ajyc;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bbjw;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDataPlugin
  extends BaseJsPlugin
{
  public static final String API_GET_FRIEND_CLOUD_STORAGE = "getFriendCloudStorage";
  public static final String API_GET_GROUP_CLOUD_STORAGE = "getGroupCloudStorage";
  public static final String API_GET_OPENDATA_CONTEXT = "getOpenDataContext";
  public static final String API_GET_POTENTIAL_FRIEND_LIST = "getPotentialFriendList";
  public static final String API_GET_USER_CLOUD_STORAGE = "getUserCloudStorage";
  public static final String API_GET_USER_INTERACTIVE_STORAGE = "getUserInteractiveStorage";
  public static final String API_MODIFY_FRIEND_INTERACTIVE_STORAGE = "modifyFriendInteractiveStorage";
  public static final String API_ON_INTERACTIVE_STORAGE_MODIFIED = "onInteractiveStorageModified";
  public static final String API_ON_MESSAGE = "onMessage";
  public static final String API_ON_SHARE_MESSAGE_TO_FRIEND = "onShareMessageToFriend";
  public static final String API_REMOVE_USER_CLOUD_STORAGE = "removeUserCloudStorage";
  public static final String API_SET_MESSAGE_TO_FRIEND_QUERY = "setMessageToFriendQuery";
  public static final String API_SET_USER_CLOUD_STORAGE = "setUserCloudStorage";
  public static final String API_SHARE_MESSAGE_TO_FRIEND = "shareMessageToFriend";
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  private static final Set<String> S_EVENT_MAP = new OpenDataPlugin.1();
  private static final String TAG = "OpenDataPlugin";
  
  private void getPotentialFriendList(JsRuntime paramJsRuntime, int paramInt)
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.getAppInfo() == null))
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getPotentialFriendList", null, paramInt);
      return;
    }
    String str = this.jsPluginEngine.getAppInfo().appId;
    MiniAppCmdUtil.getInstance().getPotentialFriendList(null, str, new OpenDataPlugin.3(this, paramJsRuntime, paramInt));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt)
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.getAppInfo() == null))
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getUserInteractiveStorage", null, paramInt);
      return;
    }
    String str = this.jsPluginEngine.getAppInfo().appId;
    MiniAppCmdUtil.getInstance().getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataPlugin.4(this, paramJsRuntime, paramInt));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, JsRuntime paramJsRuntime, int paramInt2, String paramString8, String paramString9)
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.getAppInfo() == null))
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt2);
      return;
    }
    String str1 = this.jsPluginEngine.getAppInfo().appId;
    String str2 = this.jsPluginEngine.getAppInfo().shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt2);
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt2);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt1 + "");
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt1, paramString2, localHashMap, new OpenDataPlugin.5(this, paramJsRuntime, paramInt2, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void setMessageToFriendQuery(JsRuntime paramJsRuntime, int paramInt) {}
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, JsRuntime paramJsRuntime, int paramInt, String paramString6)
  {
    MiniAppInfo localMiniAppInfo = this.jsPluginEngine.getAppInfo();
    String str = "";
    paramString5 = str;
    if (localMiniAppInfo != null)
    {
      paramString5 = str;
      if (!TextUtils.isEmpty(localMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + localMiniAppInfo.friendMessageQuery;
      }
      getGameBrandRuntime().shareAppid = localMiniAppInfo.appId;
    }
    getGameBrandRuntime().shareEvent = paramString6;
    getGameBrandRuntime().shareCallbackId = paramInt;
    getGameBrandRuntime().shareOpenid = paramString1;
    boolean bool1;
    if (TextUtils.isEmpty(paramString5))
    {
      paramString5 = "miniGamePath";
      paramJsRuntime = new OpenDataPlugin.2(this, paramJsRuntime, paramString6, paramInt);
      if ((!URLUtil.isHttpUrl(paramString4)) && (!URLUtil.isHttpsUrl(paramString4))) {
        break label314;
      }
      bool1 = true;
      label147:
      if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (TextUtils.isEmpty(paramString4)) || (!new File(MiniAppFileManager.getInstance().getAbsolutePath(paramString4)).exists())) {
        break label320;
      }
    }
    label314:
    label320:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      if ((!bbjw.a(paramString4)) && ((bool1) || (bool2))) {
        break label326;
      }
      this.jsPluginEngine.appBrandRuntime.startShare(paramString3, GameWnsUtils.defaultShareImg(), paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
      QLog.e("OpenDataPlugin", 1, "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString4 + "], use default share image");
      return;
      break;
      bool1 = false;
      break label147;
    }
    label326:
    if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
    {
      this.jsPluginEngine.appBrandRuntime.startShare(paramString3, paramString4, paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
      return;
    }
    this.jsPluginEngine.appBrandRuntime.getApkgInfo();
    paramString4 = MiniAppFileManager.getInstance().getAbsolutePath(paramString4);
    this.jsPluginEngine.appBrandRuntime.startShare(paramString3, paramString4, paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, JsRuntime paramJsRuntime, int paramInt2, String paramString8, String paramString9, int paramInt3)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt3 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt3 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramJsRuntime, paramInt2, paramString8, paramString9);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataPlugin.6(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramJsRuntime, paramInt2, paramString8, paramString9), null, new OpenDataPlugin.7(this, paramJsRuntime, paramInt2));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppBrandTask.runTaskOnUiThread(new OpenDataPlugin.8(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(GameInfoManager.g().getAppId()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().getFriendCloudStorage(GameInfoManager.g().getAppId(), paramArrayOfString, new OpenDataPlugin.11(this, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getGroupCloudStorage", paramString, ajyc.a(2131707853), paramInt);
        return;
      }
      catch (JSONException paramString)
      {
        GameLog.getInstance().e("OpenDataPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getGroupCloudStorage", null, paramInt);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(GameInfoManager.g().getAppId(), paramString, paramArrayOfString, new OpenDataPlugin.10(this, paramJsRuntime, paramInt));
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(GameInfoManager.g().getAppId()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      if ((paramArrayOfString != null) && (paramJsRuntime != null)) {
        break;
      }
      return;
    }
    paramJsRuntime = new OpenDataPlugin.9(this, paramJsRuntime, paramInt);
    MiniAppCmdUtil.getInstance().getUserCloudStorage(GameInfoManager.g().getAppId(), paramArrayOfString, paramJsRuntime);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine == null)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest" + paramString1 + " error, jsPluginEngine null");
      return "{}";
    }
    if ("getUserCloudStorage".equals(paramString1)) {}
    int i;
    label124:
    Object localObject1;
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
        if (paramString2 == null) {
          continue;
        }
        paramString1 = new String[paramString2.length()];
        i = 0;
        if (i >= paramString2.length()) {
          break label1981;
        }
        paramString1[i] = ((String)paramString2.get(i));
        i += 1;
        continue;
        getUserCloudStorage(paramString1, paramJsRuntime, paramInt);
      }
      catch (Throwable paramString1)
      {
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getUserCloudStorage error " + paramString1.getMessage());
        continue;
      }
      return "{}";
      paramString1 = new String[0];
      continue;
      if ("getFriendCloudStorage".equals(paramString1)) {
        for (;;)
        {
          try
          {
            paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
            if (paramString2 == null) {
              break label289;
            }
            paramString1 = new String[paramString2.length()];
            i = 0;
            if (i >= paramString2.length()) {
              break label1984;
            }
            paramString1[i] = ((String)paramString2.get(i));
            i += 1;
            continue;
            label242:
            getFriendCloudStorage(paramString1, paramJsRuntime, paramInt);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getFriendCloudStorage error " + paramString1.getMessage());
          }
          break;
          label289:
          paramString1 = new String[0];
        }
      }
      if ("getGroupCloudStorage".equals(paramString1)) {
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramString2);
            paramString2 = paramString1.optString("shareTicket");
            localObject1 = paramString1.optJSONArray("keyList");
            if (localObject1 == null) {
              break label430;
            }
            paramString1 = new String[((JSONArray)localObject1).length()];
            i = 0;
            if (i >= ((JSONArray)localObject1).length()) {
              break label1987;
            }
            paramString1[i] = ((String)((JSONArray)localObject1).get(i));
            i += 1;
            continue;
            label382:
            getGroupCloudStorage(paramString2, paramString1, paramJsRuntime, paramInt);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getUserCloudStorage error " + paramString1.getMessage());
          }
          break;
          label430:
          paramString1 = new String[0];
        }
      }
      if ("removeUserCloudStorage".equals(paramString1)) {
        for (;;)
        {
          try
          {
            paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
            if (paramString2 == null) {
              break label555;
            }
            paramString1 = new String[paramString2.length()];
            i = 0;
            if (i >= paramString2.length()) {
              break label1990;
            }
            paramString1[i] = ((String)paramString2.get(i));
            i += 1;
            continue;
            label508:
            removeUserCloudStorage(paramString1, paramJsRuntime, paramInt);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest removeUserCloudStorage error " + paramString1.getMessage());
          }
          break;
          label555:
          paramString1 = new String[0];
        }
      }
      if ("setUserCloudStorage".equals(paramString1))
      {
        try
        {
          paramString1 = new JSONObject(paramString2).optJSONArray("KVDataList");
          paramString2 = new HashMap();
          if (paramString1 != null)
          {
            i = 0;
            while (i < paramString1.length())
            {
              localObject1 = paramString1.getJSONObject(i);
              paramString2.put(((JSONObject)localObject1).get("key").toString(), ((JSONObject)localObject1).get("value").toString());
              i += 1;
            }
          }
          setUserCloudStorage(paramString2, paramJsRuntime, paramInt);
        }
        catch (Throwable paramString1)
        {
          GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest setUserCloudStorage error " + paramString1.getMessage());
        }
      }
      else if ("onMessage".equals(paramString1))
      {
        if (this.isGameRuntime) {
          paramString1 = (GameJsRuntime)paramJsRuntime;
        }
        for (;;)
        {
          if (paramString1 != null)
          {
            if (paramString1.getTargetContextType() == 1)
            {
              if ((this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.whiteList != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.whiteList.contains("onMessage")))
              {
                paramJsRuntime.evaluateSubcribeJS("onMessage", paramString2, 0);
                break;
                paramString1 = null;
                continue;
              }
              GameLog.getInstance().e("OpenDataPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
              GameLog.vconsoleLog("error 开放域调用了未授权的私有API: postMessage");
              break;
            }
            paramJsRuntime.evaluateSubcribeJS("onMessage", paramString2, 0);
            break;
          }
        }
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
      }
      else if ("modifyFriendInteractiveStorage".equals(paramString1))
      {
        String str4;
        int m;
        String str5;
        String str6;
        String str7;
        String str8;
        Boolean localBoolean;
        String str1;
        int j;
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(paramString2);
            str4 = ((JSONObject)localObject1).getString("key");
            m = ((JSONObject)localObject1).getInt("opNum");
            str5 = ((JSONObject)localObject1).getString("operation");
            str6 = ((JSONObject)localObject1).optString("title");
            str7 = ((JSONObject)localObject1).optString("imageUrl");
            str8 = ((JSONObject)localObject1).optString("imageUrlId");
            localBoolean = Boolean.valueOf(((JSONObject)localObject1).optBoolean("quiet"));
            paramString1 = "";
            paramString2 = "";
            int k = -1;
            String str2 = "";
            String str3 = "";
            localObject1 = ((JSONObject)localObject1).optJSONObject("friendInfo");
            if (localObject1 != null)
            {
              paramString1 = ((JSONObject)localObject1).getString("openid");
              paramString2 = ((JSONObject)localObject1).getString("nickname");
            }
            Object localObject2 = ((GameActivity)this.jsPluginEngine.getActivityContext()).getGameConfigJson();
            str1 = str2;
            localObject1 = str3;
            j = k;
            if (localObject2 != null)
            {
              localObject2 = ((JSONObject)localObject2).optJSONArray("modifyFriendInteractiveStorageTemplates");
              str1 = str2;
              localObject1 = str3;
              j = k;
              if (localObject2 != null)
              {
                str1 = str2;
                localObject1 = str3;
                j = k;
                if (((JSONArray)localObject2).length() > 0)
                {
                  i = 0;
                  str1 = str2;
                  localObject1 = str3;
                  j = k;
                  if (i < ((JSONArray)localObject2).length())
                  {
                    localObject1 = ((JSONArray)localObject2).getJSONObject(i);
                    if (localObject1 == null) {
                      break label1342;
                    }
                    str1 = ((JSONObject)localObject1).optString("key");
                    if ((TextUtils.isEmpty(str1)) || (!str1.equals(str4))) {
                      break label1342;
                    }
                    j = ((JSONObject)localObject1).optInt("ratio");
                    str1 = ((JSONObject)localObject1).optString("action");
                    localObject1 = ((JSONObject)localObject1).optString("object");
                  }
                }
              }
            }
            if (!localBoolean.booleanValue()) {
              break label1351;
            }
            modifyFriendInteractiveStorage(str4, m, str5, paramString1, paramString2, str6, str7, str8, localBoolean, paramJsRuntime, paramInt, str1, (String)localObject1);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramString1.getMessage());
            GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramString1.getMessage());
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt);
          }
          break;
          label1342:
          i += 1;
        }
        label1351:
        showConfirmModificationModel(str4, m, str5, paramString1, paramString2, str6, str7, str8, localBoolean, paramJsRuntime, paramInt, str1, (String)localObject1, j);
      }
      else
      {
        if (!"getUserInteractiveStorage".equals(paramString1)) {
          break;
        }
      }
    }
    label1539:
    label1697:
    label1981:
    label1984:
    label1987:
    label1990:
    label1993:
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramString2 = new JSONObject(paramString2).getJSONArray("keyList");
              if (paramString2 == null) {
                break label1539;
              }
              paramString1 = new String[paramString2.length()];
              i = 0;
              if (i >= paramString2.length()) {
                break label1993;
              }
              paramString1[i] = ((String)paramString2.get(i));
              i += 1;
              continue;
              getUserInteractiveStorage(paramString1, paramJsRuntime, paramInt);
            }
            catch (Throwable paramString1)
            {
              GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramString1.getMessage());
              GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramString1.getMessage());
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getUserInteractiveStorage", null, paramInt);
            }
            break;
            paramString1 = new String[0];
            continue;
            if (!"shareMessageToFriend".equals(paramString1)) {
              break label1697;
            }
            try
            {
              paramString2 = new JSONObject(paramString2);
              localObject1 = paramString2.getJSONObject("friendInfo");
              shareMessageToFriend(((JSONObject)localObject1).getString("openid"), ((JSONObject)localObject1).getString("nickname"), paramString2.optString("title"), paramString2.optString("imageUrl"), paramString2.optString("imageUrlId"), paramJsRuntime, paramInt, paramString1);
            }
            catch (Throwable paramString1)
            {
              GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramString1.getMessage());
              GameLog.vconsoleLog("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + paramString1.getMessage());
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "shareMessageToFriend", null, paramInt);
            }
          }
          break;
          if (!"getPotentialFriendList".equals(paramString1)) {
            break label1791;
          }
          try
          {
            getPotentialFriendList(paramJsRuntime, paramInt);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + paramString1.getMessage());
            GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + paramString1.getMessage());
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getPotentialFriendList", null, paramInt);
          }
        }
        break;
        label1791:
        if (!"setMessageToFriendQuery".equals(paramString1)) {
          break;
        }
        try
        {
          i = new JSONObject(paramString2).optInt("shareMessageToFriendScene", -1);
          if (i == -1) {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "setMessageToFriendQuery", null, paramInt);
          }
          paramString1 = this.jsPluginEngine.getAppInfo();
          if (paramString1 != null) {
            paramString1.friendMessageQuery = ("shareMessageToFriendScene=" + i);
          }
          paramString1 = new JSONObject();
          paramString1.put("success", true);
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "getPotentialFriendList", paramString1, paramInt);
        }
        catch (Throwable paramString1)
        {
          GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + paramString1.getMessage());
          GameLog.vconsoleLog("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + paramString1.getMessage());
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "setMessageToFriendQuery", null, paramInt);
        }
      }
      break label124;
      break;
      break label242;
      break label382;
      break label508;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(GameInfoManager.g().getAppId()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().removeUserCloudStorage(GameInfoManager.g().getAppId(), paramArrayOfString, new OpenDataPlugin.13(this, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(GameInfoManager.g().getAppId()).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().setUserCloudStorage(GameInfoManager.g().getAppId(), paramHashMap, new OpenDataPlugin.12(this, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin
 * JD-Core Version:    0.7.0.1
 */