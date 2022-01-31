package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bglu;
import bglv;
import bgmj;
import bgnt;
import bgoj;
import bgok;
import bgor;
import bgpv;
import bgxo;
import bgxw;
import bgyu;
import bgza;
import bhaj;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDataJsPlugin
  extends BaseJsPlugin
{
  public static final String API_GET_POTENTIAL_FRIEND_LIST = "getPotentialFriendList";
  public static final String API_GET_USER_INTERACTIVE_STORAGE = "getUserInteractiveStorage";
  public static final String API_MODIFY_FRIEND_INTERACTIVE_STORAGE = "modifyFriendInteractiveStorage";
  public static final String API_ON_INTERACTIVE_STORAGE_MODIFIED = "onInteractiveStorageModified";
  public static final String API_ON_SHARE_MESSAGE_TO_FRIEND = "onShareMessageToFriend";
  public static final String API_SET_MESSAGE_TO_FRIEND_QUERY = "setMessageToFriendQuery";
  public static final String API_SHARE_MESSAGE_TO_FRIEND = "shareMessageToFriend";
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  private static final String TAG = "OpenDataJsPlugin";
  private ChannelProxy mChannelProxy;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  private void getPotentialFriendListImpl(bgok parambgok)
  {
    if (this.mMiniAppInfo == null)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      bhaj.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      parambgok.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, str, new OpenDataJsPlugin.6(this, parambgok));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, bgok parambgok)
  {
    if (this.mMiniAppInfo == null)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      bhaj.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      parambgok.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataJsPlugin.7(this, parambgok));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bgok parambgok, String paramString8, String paramString9)
  {
    if (this.mMiniAppInfo == null)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      parambgok.b();
      return;
    }
    String str1 = this.mMiniAppInfo.appId;
    String str2 = this.mMiniAppInfo.shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        parambgok.b();
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      parambgok.b();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt + "");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt, paramString2, localHashMap, new OpenDataJsPlugin.8(this, parambgok, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, bgok parambgok)
  {
    String str = "";
    ShareState localShareState = bgmj.a(this.mMiniAppContext);
    paramString5 = str;
    if (this.mMiniAppInfo != null)
    {
      paramString5 = str;
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + this.mMiniAppInfo.friendMessageQuery;
      }
      localShareState.shareAppid = this.mMiniAppInfo.appId;
    }
    localShareState.shareEvent = parambgok.jdField_a_of_type_JavaLangString;
    localShareState.shareCallbackId = parambgok.jdField_b_of_type_Int;
    localShareState.shareOpenid = paramString1;
    parambgok = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      parambgok = "miniGamePath";
    }
    boolean bool1;
    if ((URLUtil.isHttpUrl(paramString4)) || (URLUtil.isHttpsUrl(paramString4)))
    {
      bool1 = true;
      if ((TextUtils.isEmpty(paramString4)) || (!new File(bgnt.a().a(paramString4)).exists())) {
        break label355;
      }
    }
    label355:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      paramString1 = new bgoj().a(11).b(5).a(this.mMiniAppInfo.name).b(paramString3).a(this.mMiniAppInfo).a(this.mMiniAppContext.a()).d(parambgok).a(paramString2).c(localShareState.withShareTicket).h(paramString1).b(localShareState.isShareInMiniProcess);
      if ((!bgpv.a(paramString4)) && ((bool1) || (bool2))) {
        break label361;
      }
      paramString1.c(WnsUtil.defaultShareImg()).a().a();
      QMLog.e("OpenDataJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString4 + "], use default share image");
      return;
      bool1 = false;
      break;
    }
    label361:
    if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
    {
      paramString1.c(paramString4).a().a();
      return;
    }
    paramString1.c(bgnt.a().a(paramString4)).a(true).a().a();
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bgok parambgok, String paramString8, String paramString9, int paramInt2)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt2 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt2 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambgok, paramString8, paramString9);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataJsPlugin.9(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambgok, paramString8, paramString9), null, new OpenDataJsPlugin.10(this, parambgok));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bgor.a(new OpenDataJsPlugin.11(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void getFriendCloudStorage(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getFriendCloudStorage(arrayOfString, parambgok);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest getFriendCloudStorage error " + parambgok.getMessage());
      return;
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, bgok parambgok)
  {
    bhaj localbhaj = bhaj.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbhaj.i("OpenDataJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.3(this, parambgok));
      return;
    }
  }
  
  public void getGroupCloudStorage(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("shareTicket");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyList");
      if (localJSONArray != null)
      {
        localObject = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getGroupCloudStorage(str, (String[])localObject, parambgok);
        return;
        localObject = new String[0];
      }
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambgok.getMessage());
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, bgok parambgok)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        parambgok.a(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        bhaj.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        parambgok.b();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, paramString, paramArrayOfString, new OpenDataJsPlugin.2(this, parambgok));
  }
  
  public void getOpenDataContext(bgok parambgok) {}
  
  public void getPotentialFriendList(bgok parambgok)
  {
    try
    {
      getPotentialFriendListImpl(parambgok);
      return;
    }
    catch (Throwable localThrowable)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      bhaj.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      parambgok.b();
    }
  }
  
  public void getUserCloudStorage(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserCloudStorage(arrayOfString, parambgok);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambgok.getMessage());
      return;
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, bgok parambgok)
  {
    bhaj localbhaj = bhaj.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbhaj.i("OpenDataJsPlugin", str);
      if ((paramArrayOfString != null) && (parambgok.jdField_a_of_type_Bglu != null)) {
        break;
      }
      return;
    }
    parambgok = new OpenDataJsPlugin.1(this, parambgok);
    this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, parambgok);
  }
  
  public void getUserInteractiveStorage(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).getJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserInteractiveStorage(arrayOfString, parambgok);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable localThrowable)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      bhaj.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      parambgok.b();
      return;
    }
  }
  
  public void modifyFriendInteractiveStorage(bgok parambgok)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        String str6 = ((JSONObject)localObject1).getString("key");
        int m = ((JSONObject)localObject1).getInt("opNum");
        String str7 = ((JSONObject)localObject1).getString("operation");
        String str8 = ((JSONObject)localObject1).optString("title");
        String str9 = ((JSONObject)localObject1).optString("imageUrl");
        String str10 = ((JSONObject)localObject1).optString("imageUrlId");
        Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject1).optBoolean("quiet"));
        String str1 = "";
        String str2 = "";
        int k = -1;
        String str4 = "";
        String str5 = "";
        localObject1 = ((JSONObject)localObject1).optJSONObject("friendInfo");
        if (localObject1 != null)
        {
          str1 = ((JSONObject)localObject1).getString("openid");
          str2 = ((JSONObject)localObject1).getString("nickname");
        }
        localObject1 = bgxw.a(this.mMiniAppContext);
        if (localObject1 != null)
        {
          localObject1 = ((bgza)localObject1).a();
          if (localObject1 == null) {
            break label465;
          }
          localObject2 = ((bgyu)localObject1).a;
          String str3 = str4;
          localObject1 = str5;
          int j = k;
          if (localObject2 != null)
          {
            localObject2 = ((JSONObject)localObject2).optJSONArray("modifyFriendInteractiveStorageTemplates");
            str3 = str4;
            localObject1 = str5;
            j = k;
            if (localObject2 != null)
            {
              str3 = str4;
              localObject1 = str5;
              j = k;
              if (((JSONArray)localObject2).length() > 0)
              {
                i = 0;
                str3 = str4;
                localObject1 = str5;
                j = k;
                if (i < ((JSONArray)localObject2).length())
                {
                  localObject1 = ((JSONArray)localObject2).getJSONObject(i);
                  if (localObject1 == null) {
                    break label471;
                  }
                  str3 = ((JSONObject)localObject1).optString("key");
                  if ((TextUtils.isEmpty(str3)) || (!str3.equals(str6))) {
                    break label471;
                  }
                  j = ((JSONObject)localObject1).optInt("ratio");
                  str3 = ((JSONObject)localObject1).optString("action");
                  localObject1 = ((JSONObject)localObject1).optString("object");
                }
              }
            }
          }
          if (localBoolean.booleanValue())
          {
            modifyFriendInteractiveStorage(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambgok, str3, (String)localObject1);
            return;
          }
          showConfirmModificationModel(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambgok, str3, (String)localObject1, j);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        parambgok.b();
        return;
      }
      Object localObject1 = null;
      continue;
      label465:
      Object localObject2 = null;
      continue;
      label471:
      i += 1;
    }
  }
  
  public void onMessage(bgok parambgok)
  {
    Object localObject;
    if (this.mIsMiniGame) {
      localObject = (bgxo)parambgok.jdField_a_of_type_Bglu;
    }
    while (localObject != null) {
      if (((bgxo)localObject).a() == 1)
      {
        localObject = this.mMiniAppInfo;
        if ((localObject != null) && (((MiniAppInfo)localObject).whiteList != null) && (((MiniAppInfo)localObject).whiteList.contains("onMessage")))
        {
          parambgok.jdField_a_of_type_Bglu.a("onMessage", parambgok.jdField_b_of_type_JavaLangString, 0);
          sendSubscribeEvent("onMessage", parambgok.jdField_b_of_type_JavaLangString);
          return;
          localObject = null;
        }
        else
        {
          bhaj.a().e("OpenDataJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
          bhaj.a("error 开放域调用了未授权的私有API: postMessage");
        }
      }
      else
      {
        parambgok.jdField_a_of_type_Bglu.a("onMessage", parambgok.jdField_b_of_type_JavaLangString, 0);
        return;
      }
    }
    bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
  }
  
  public void removeUserCloudStorage(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        removeUserCloudStorage(arrayOfString, parambgok);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest removeUserCloudStorage error " + parambgok.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, bgok parambgok)
  {
    bhaj localbhaj = bhaj.a();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbhaj.i("OpenDataJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.5(this, parambgok));
      return;
    }
  }
  
  public void setMessageToFriendQuery(bgok parambgok)
  {
    try
    {
      int i = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optInt("shareMessageToFriendScene", -1);
      if (i == -1) {
        parambgok.b();
      }
      if (this.mMiniAppInfo != null) {
        this.mMiniAppInfo.friendMessageQuery = ("shareMessageToFriendScene=" + i);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("success", true);
      parambgok.a(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      bhaj.a("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      parambgok.b();
    }
  }
  
  public void setUserCloudStorage(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optJSONArray("KVDataList");
      HashMap localHashMap = new HashMap();
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localHashMap.put(localJSONObject.get("key").toString(), localJSONObject.get("value").toString());
          i += 1;
        }
      }
      setUserCloudStorage(localHashMap, parambgok);
      return;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest setUserCloudStorage error " + parambgok.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, bgok parambgok)
  {
    bhaj localbhaj = bhaj.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localbhaj.i("OpenDataJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, paramHashMap, new OpenDataJsPlugin.4(this, parambgok));
      return;
    }
  }
  
  public void shareMessageToFriend(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("friendInfo");
      shareMessageToFriend(localJSONObject2.getString("openid"), localJSONObject2.getString("nickname"), localJSONObject1.optString("title"), localJSONObject1.optString("imageUrl"), localJSONObject1.optString("imageUrlId"), parambgok);
      return;
    }
    catch (Throwable localThrowable)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      bhaj.a("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      parambgok.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */