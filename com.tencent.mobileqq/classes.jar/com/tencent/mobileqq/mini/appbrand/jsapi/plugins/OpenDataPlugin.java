package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import anni;
import bgsp;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDataPlugin
  extends BaseJsPlugin
{
  public static final String API_CAN_USE_COMPONENT = "canUseComponent";
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
  
  private boolean miniAppNotPageWebviewCall(JsRuntime paramJsRuntime, int paramInt)
  {
    if ((!this.isGameRuntime) && (!(paramJsRuntime instanceof PageWebview)))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getUserCloudStorage", null, "forbidden", paramInt);
      return true;
    }
    return false;
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
    boolean bool = com.tencent.qqmini.sdk.utils.OpenDataDomainUtil.getInstance().isDomainValid(paramString6);
    if ((!TextUtils.isEmpty(paramString6)) && (new File(MiniAppFileManager.getInstance().getAbsolutePath(paramString6)).exists())) {}
    for (int i = 1; (StringUtil.isEmpty(paramString6)) || ((!bool) && (i == 0)); i = 0)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , image illegal");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , image illegal");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt2);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt1 + "");
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt1, paramString2, localHashMap, new OpenDataPlugin.5(this, paramJsRuntime, paramInt2, paramString1, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7));
  }
  
  private void setMessageToFriendQuery(JsRuntime paramJsRuntime, int paramInt) {}
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, JsRuntime paramJsRuntime, int paramInt, String paramString6)
  {
    Object localObject = this.jsPluginEngine.getAppInfo();
    paramString5 = "";
    if (localObject != null) {
      if (!TextUtils.isEmpty(((MiniAppInfo)localObject).friendMessageQuery)) {
        paramString5 = "" + ((MiniAppInfo)localObject).friendMessageQuery;
      }
    }
    for (localObject = ((MiniAppInfo)localObject).appId;; localObject = null)
    {
      label123:
      boolean bool2;
      if (getGameBrandRuntime() != null)
      {
        getGameBrandRuntime().shareAppid = ((String)localObject);
        getGameBrandRuntime().shareEvent = paramString6;
        getGameBrandRuntime().shareCallbackId = paramInt;
        getGameBrandRuntime().shareOpenid = paramString1;
        if (!TextUtils.isEmpty(paramString5)) {
          break label370;
        }
        if (getGameBrandRuntime() == null) {
          break label363;
        }
        paramString5 = "miniGamePath";
        paramJsRuntime = new OpenDataPlugin.2(this, paramJsRuntime, paramString6, paramInt);
        bool2 = com.tencent.mobileqq.mini.utils.OpenDataDomainUtil.getInstance().isDomainValid(paramString4);
        if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (TextUtils.isEmpty(paramString4)) || (!new File(MiniAppFileManager.getInstance().getAbsolutePath(paramString4)).exists())) {
          break label373;
        }
      }
      label363:
      label370:
      label373:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString2 = new ShareChatModel(0, 0L, paramString2);
        if ((!bgsp.a(paramString4)) && ((bool2) || (bool1))) {
          break label379;
        }
        this.jsPluginEngine.appBrandRuntime.startShare(paramString3, GameWnsUtils.defaultShareImg(), paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
        QLog.e("OpenDataPlugin", 1, "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool2 + "] [isLocalResourceExists=" + bool1 + "] [imageUrl=" + paramString4 + "], use default share image");
        return;
        getAppBrandRuntime().getPageWebView().shareEvent = paramString6;
        getAppBrandRuntime().getPageWebView().shareCallbackId = paramInt;
        getAppBrandRuntime().getPageWebView().shareAppid = ((String)localObject);
        getAppBrandRuntime().getPageWebView().shareOpenid = paramString1;
        break;
        paramString5 = "";
        break label123;
        break label123;
      }
      label379:
      if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
      {
        this.jsPluginEngine.appBrandRuntime.startShare(paramString3, paramString4, paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
        return;
      }
      this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      paramString4 = MiniAppFileManager.getInstance().getAbsolutePath(paramString4);
      this.jsPluginEngine.appBrandRuntime.startShare(paramString3, paramString4, paramString5, "", "", "", null, paramString2, 11, 5, paramString1, paramJsRuntime);
      return;
      paramString5 = "";
    }
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
  
  public void getFriendCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt, String paramString)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(paramString).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().getFriendCloudStorage(paramString, paramArrayOfString, new OpenDataPlugin.11(this, paramString, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString1, String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("state", "fail");
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getGroupCloudStorage", paramString1, anni.a(2131706625), paramInt);
        return;
      }
      catch (JSONException paramString1)
      {
        GameLog.getInstance().e("OpenDataPlugin", "getGroupCloudStorage error " + paramString1.getMessage());
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getGroupCloudStorage", null, paramInt);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(paramString2, paramString1, paramArrayOfString, new OpenDataPlugin.10(this, paramString2, paramJsRuntime, paramInt));
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt, String paramString)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(paramString).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      if ((paramArrayOfString != null) && (paramJsRuntime != null)) {
        break;
      }
      return;
    }
    paramJsRuntime = new OpenDataPlugin.9(this, paramString, paramJsRuntime, paramInt);
    MiniAppCmdUtil.getInstance().getUserCloudStorage(paramString, paramArrayOfString, paramJsRuntime);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("OpenDataPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.getAppInfo() == null))
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest" + paramString1 + " error, jsPluginEngine null or AppInfo null");
      return "{}";
    }
    Object localObject1 = this.jsPluginEngine.getAppInfo().appId;
    if ("getUserCloudStorage".equals(paramString1)) {}
    int i;
    label208:
    label338:
    Object localObject2;
    label387:
    label622:
    String str1;
    for (;;)
    {
      try
      {
        if (miniAppNotPageWebviewCall(paramJsRuntime, paramInt)) {
          return "";
        }
        paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
        if (paramString2 == null) {
          continue;
        }
        paramString1 = new String[paramString2.length()];
        i = 0;
        if (i >= paramString2.length()) {
          break label2356;
        }
        paramString1[i] = ((String)paramString2.get(i));
        i += 1;
        continue;
        getUserCloudStorage(paramString1, paramJsRuntime, paramInt, (String)localObject1);
      }
      catch (Throwable paramString1)
      {
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getUserCloudStorage error " + paramString1.getMessage());
        continue;
      }
      return "";
      paramString1 = new String[0];
      continue;
      if ("getFriendCloudStorage".equals(paramString1)) {
        for (;;)
        {
          try
          {
            if (miniAppNotPageWebviewCall(paramJsRuntime, paramInt)) {
              return "";
            }
            paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
            if (paramString2 == null) {
              break label387;
            }
            paramString1 = new String[paramString2.length()];
            i = 0;
            if (i >= paramString2.length()) {
              break label2359;
            }
            paramString1[i] = ((String)paramString2.get(i));
            i += 1;
            continue;
            getFriendCloudStorage(paramString1, paramJsRuntime, paramInt, (String)localObject1);
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getFriendCloudStorage error " + paramString1.getMessage());
          }
          break;
          paramString1 = new String[0];
        }
      }
      Object localObject3;
      if ("getGroupCloudStorage".equals(paramString1))
      {
        try
        {
          if (miniAppNotPageWebviewCall(paramJsRuntime, paramInt)) {
            return "";
          }
          paramString1 = new JSONObject(paramString2);
          localObject2 = paramString1.optString("shareTicket");
          localObject3 = paramString1.optJSONArray("keyList");
          if (localObject3 != null)
          {
            paramString2 = new String[((JSONArray)localObject3).length()];
            i = 0;
            for (;;)
            {
              paramString1 = paramString2;
              if (i >= ((JSONArray)localObject3).length()) {
                break;
              }
              paramString2[i] = ((String)((JSONArray)localObject3).get(i));
              i += 1;
            }
          }
          paramString1 = new String[0];
          getGroupCloudStorage((String)localObject2, paramString1, paramJsRuntime, paramInt, (String)localObject1);
        }
        catch (Throwable paramString1)
        {
          GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest getUserCloudStorage error " + paramString1.getMessage());
        }
      }
      else
      {
        if ("removeUserCloudStorage".equals(paramString1)) {
          for (;;)
          {
            try
            {
              paramString2 = new JSONObject(paramString2).optJSONArray("keyList");
              if (paramString2 == null) {
                break label671;
              }
              paramString1 = new String[paramString2.length()];
              i = 0;
              if (i >= paramString2.length()) {
                break label2362;
              }
              paramString1[i] = ((String)paramString2.get(i));
              i += 1;
              continue;
              removeUserCloudStorage(paramString1, paramJsRuntime, paramInt, (String)localObject1);
            }
            catch (Throwable paramString1)
            {
              GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest removeUserCloudStorage error " + paramString1.getMessage());
            }
            break;
            label671:
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
                localObject2 = paramString1.getJSONObject(i);
                paramString2.put(((JSONObject)localObject2).get("key").toString(), ((JSONObject)localObject2).get("value").toString());
                i += 1;
              }
            }
            setUserCloudStorage(paramString2, paramJsRuntime, paramInt, (String)localObject1);
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
          String str2;
          int m;
          String str3;
          String str4;
          String str5;
          String str6;
          Boolean localBoolean;
          int j;
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject(paramString2);
              str2 = ((JSONObject)localObject1).getString("key");
              m = ((JSONObject)localObject1).getInt("opNum");
              str3 = ((JSONObject)localObject1).getString("operation");
              str4 = ((JSONObject)localObject1).optString("title");
              str5 = ((JSONObject)localObject1).optString("imageUrl");
              str6 = ((JSONObject)localObject1).optString("imageUrlId");
              localBoolean = Boolean.valueOf(((JSONObject)localObject1).optBoolean("quiet"));
              paramString1 = "";
              paramString2 = "";
              int k = -1;
              localObject3 = "";
              str1 = "";
              localObject1 = ((JSONObject)localObject1).optJSONObject("friendInfo");
              if (localObject1 != null)
              {
                paramString1 = ((JSONObject)localObject1).getString("openid");
                paramString2 = ((JSONObject)localObject1).getString("nickname");
              }
              Object localObject4 = ((GameActivity)this.jsPluginEngine.getActivityContext()).getGameConfigJson();
              localObject2 = localObject3;
              localObject1 = str1;
              j = k;
              if (localObject4 != null)
              {
                localObject4 = ((JSONObject)localObject4).optJSONArray("modifyFriendInteractiveStorageTemplates");
                localObject2 = localObject3;
                localObject1 = str1;
                j = k;
                if (localObject4 != null)
                {
                  localObject2 = localObject3;
                  localObject1 = str1;
                  j = k;
                  if (((JSONArray)localObject4).length() > 0)
                  {
                    i = 0;
                    localObject2 = localObject3;
                    localObject1 = str1;
                    j = k;
                    if (i < ((JSONArray)localObject4).length())
                    {
                      localObject1 = ((JSONArray)localObject4).getJSONObject(i);
                      if (localObject1 == null) {
                        break label1460;
                      }
                      localObject2 = ((JSONObject)localObject1).optString("key");
                      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(str2))) {
                        break label1460;
                      }
                      j = ((JSONObject)localObject1).optInt("ratio");
                      localObject2 = ((JSONObject)localObject1).optString("action");
                      localObject1 = ((JSONObject)localObject1).optString("object");
                    }
                  }
                }
              }
              if (!localBoolean.booleanValue()) {
                break label1469;
              }
              modifyFriendInteractiveStorage(str2, m, str3, paramString1, paramString2, str4, str5, str6, localBoolean, paramJsRuntime, paramInt, (String)localObject2, (String)localObject1);
            }
            catch (Throwable paramString1)
            {
              GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramString1.getMessage());
              GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramString1.getMessage());
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "modifyFriendInteractiveStorage", null, paramInt);
            }
            break;
            label1460:
            i += 1;
          }
          label1469:
          showConfirmModificationModel(str2, m, str3, paramString1, paramString2, str4, str5, str6, localBoolean, paramJsRuntime, paramInt, (String)localObject2, (String)localObject1, j);
        }
        else
        {
          if ("getUserInteractiveStorage".equals(paramString1)) {
            for (;;)
            {
              try
              {
                paramString2 = new JSONObject(paramString2).getJSONArray("keyList");
                if (paramString2 == null) {
                  break label1657;
                }
                paramString1 = new String[paramString2.length()];
                i = 0;
                if (i >= paramString2.length()) {
                  break label2365;
                }
                paramString1[i] = ((String)paramString2.get(i));
                i += 1;
                continue;
                label1571:
                getUserInteractiveStorage(paramString1, paramJsRuntime, paramInt);
              }
              catch (Throwable paramString1)
              {
                GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramString1.getMessage());
                GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramString1.getMessage());
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getUserInteractiveStorage", null, paramInt);
              }
              break;
              label1657:
              paramString1 = new String[0];
            }
          }
          if ("shareMessageToFriend".equals(paramString1))
          {
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
          else if ("getPotentialFriendList".equals(paramString1))
          {
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
          else if ("setMessageToFriendQuery".equals(paramString1))
          {
            try
            {
              i = new JSONObject(paramString2).optInt("shareMessageToFriendScene", -1);
              if (i == -1) {
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "setMessageToFriendQuery", null, paramInt);
              }
              paramString2 = this.jsPluginEngine.getAppInfo();
              if (paramString2 != null)
              {
                if (!isMiniGameRuntime()) {
                  break label2087;
                }
                paramString2.friendMessageQuery = ("shareMessageToFriendScene=" + i);
              }
              label1998:
              paramString1 = new JSONObject();
              paramString1.put("success", true);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "setMessageToFriendQuery", paramString1, paramInt);
            }
            catch (Throwable paramString1)
            {
              GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error ", paramString1);
              GameLog.vconsoleLog("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + paramString1.getMessage());
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "setMessageToFriendQuery", null, paramInt);
            }
            continue;
            label2087:
            localObject1 = AppBrandUtil.getQueryJson(this.jsPluginEngine.appBrandRuntime.getCurPage().getUrl());
            ((JSONObject)localObject1).put("shareMessageToFriendScene", i);
            localObject2 = new StringBuilder(AppBrandUtil.getUrlWithoutParams(this.jsPluginEngine.appBrandRuntime.getCurPage().getUrl()));
            localObject3 = ((JSONObject)localObject1).keys();
            i = 0;
            label2151:
            if (((Iterator)localObject3).hasNext())
            {
              str1 = (String)((Iterator)localObject3).next();
              if (TextUtils.isEmpty(str1)) {
                break label2353;
              }
              if (i != 0) {
                break label2371;
              }
            }
          }
        }
      }
    }
    label2353:
    label2356:
    label2359:
    label2362:
    label2365:
    label2368:
    label2371:
    for (paramString1 = "?";; paramString1 = "&")
    {
      for (;;)
      {
        ((StringBuilder)localObject2).append(paramString1).append(str1).append("=").append(((JSONObject)localObject1).getString(str1));
        i += 1;
        break label2368;
        paramString2.friendMessageQuery = ((StringBuilder)localObject2).toString();
        QLog.d("OpenDataPlugin", 1, "friendMessageQuery : " + paramString2.friendMessageQuery);
        break label1998;
        if (!"canUseComponent".endsWith(paramString1)) {
          break;
        }
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("canUse", true);
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "canUseComponent", paramString1, paramInt);
        }
        catch (Throwable paramString1)
        {
          QLog.e("OpenDataPlugin", 1, "canUseComponent error," + paramString1);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "canUseComponent", null, paramInt);
        }
      }
      break label208;
      break label2368;
      break;
      break label338;
      break label622;
      break label1571;
      break label2151;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, JsRuntime paramJsRuntime, int paramInt, String paramString)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(paramString).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().removeUserCloudStorage(paramString, paramArrayOfString, new OpenDataPlugin.13(this, paramString, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, JsRuntime paramJsRuntime, int paramInt, String paramString)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(paramString).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localGameLog.i("OpenDataPlugin", str);
      MiniAppCmdUtil.getInstance().setUserCloudStorage(paramString, paramHashMap, new OpenDataPlugin.12(this, paramString, paramJsRuntime, paramInt));
      return;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin
 * JD-Core Version:    0.7.0.1
 */