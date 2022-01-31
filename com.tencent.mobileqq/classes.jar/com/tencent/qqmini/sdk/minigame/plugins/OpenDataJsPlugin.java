package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bghn;
import bgho;
import bgic;
import bgjm;
import bgkc;
import bgkd;
import bgkk;
import bglo;
import bgth;
import bgtp;
import bgun;
import bgut;
import bgwc;
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
  
  private void getPotentialFriendListImpl(bgkd parambgkd)
  {
    if (this.mMiniAppInfo == null)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      parambgkd.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, str, new OpenDataJsPlugin.6(this, parambgkd));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, bgkd parambgkd)
  {
    if (this.mMiniAppInfo == null)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      parambgkd.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataJsPlugin.7(this, parambgkd));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bgkd parambgkd, String paramString8, String paramString9)
  {
    if (this.mMiniAppInfo == null)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      bgwc.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      parambgkd.b();
      return;
    }
    String str1 = this.mMiniAppInfo.appId;
    String str2 = this.mMiniAppInfo.shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        bgwc.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        parambgkd.b();
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      bgwc.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      parambgkd.b();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt + "");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt, paramString2, localHashMap, new OpenDataJsPlugin.8(this, parambgkd, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, bgkd parambgkd)
  {
    String str = "";
    ShareState localShareState = bgic.a(this.mMiniAppContext);
    paramString5 = str;
    if (this.mMiniAppInfo != null)
    {
      paramString5 = str;
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + this.mMiniAppInfo.friendMessageQuery;
      }
      localShareState.shareAppid = this.mMiniAppInfo.appId;
    }
    localShareState.shareEvent = parambgkd.jdField_a_of_type_JavaLangString;
    localShareState.shareCallbackId = parambgkd.jdField_b_of_type_Int;
    localShareState.shareOpenid = paramString1;
    parambgkd = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      parambgkd = "miniGamePath";
    }
    boolean bool1;
    if ((URLUtil.isHttpUrl(paramString4)) || (URLUtil.isHttpsUrl(paramString4)))
    {
      bool1 = true;
      if ((TextUtils.isEmpty(paramString4)) || (!new File(bgjm.a().a(paramString4)).exists())) {
        break label355;
      }
    }
    label355:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      paramString1 = new bgkc().a(11).b(5).a(this.mMiniAppInfo.name).b(paramString3).a(this.mMiniAppInfo).a(this.mMiniAppContext.a()).d(parambgkd).a(paramString2).c(localShareState.withShareTicket).h(paramString1).b(localShareState.isShareInMiniProcess);
      if ((!bglo.a(paramString4)) && ((bool1) || (bool2))) {
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
    paramString1.c(bgjm.a().a(paramString4)).a(true).a().a();
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bgkd parambgkd, String paramString8, String paramString9, int paramInt2)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt2 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt2 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambgkd, paramString8, paramString9);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataJsPlugin.9(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambgkd, paramString8, paramString9), null, new OpenDataJsPlugin.10(this, parambgkd));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bgkk.a(new OpenDataJsPlugin.11(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void getFriendCloudStorage(bgkd parambgkd)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        getFriendCloudStorage(arrayOfString, parambgkd);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest getFriendCloudStorage error " + parambgkd.getMessage());
      return;
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, bgkd parambgkd)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbgwc.i("OpenDataJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.3(this, parambgkd));
      return;
    }
  }
  
  public void getGroupCloudStorage(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
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
        getGroupCloudStorage(str, (String[])localObject, parambgkd);
        return;
        localObject = new String[0];
      }
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambgkd.getMessage());
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, bgkd parambgkd)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        parambgkd.a(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        bgwc.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        parambgkd.b();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, paramString, paramArrayOfString, new OpenDataJsPlugin.2(this, parambgkd));
  }
  
  public void getOpenDataContext(bgkd parambgkd) {}
  
  public void getPotentialFriendList(bgkd parambgkd)
  {
    try
    {
      getPotentialFriendListImpl(parambgkd);
      return;
    }
    catch (Throwable localThrowable)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      parambgkd.b();
    }
  }
  
  public void getUserCloudStorage(bgkd parambgkd)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        getUserCloudStorage(arrayOfString, parambgkd);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambgkd.getMessage());
      return;
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, bgkd parambgkd)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbgwc.i("OpenDataJsPlugin", str);
      if ((paramArrayOfString != null) && (parambgkd.jdField_a_of_type_Bghn != null)) {
        break;
      }
      return;
    }
    parambgkd = new OpenDataJsPlugin.1(this, parambgkd);
    this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, parambgkd);
  }
  
  public void getUserInteractiveStorage(bgkd parambgkd)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).getJSONArray("keyList");
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
        getUserInteractiveStorage(arrayOfString, parambgkd);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable localThrowable)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      parambgkd.b();
      return;
    }
  }
  
  public void modifyFriendInteractiveStorage(bgkd parambgkd)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
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
        localObject1 = bgtp.a(this.mMiniAppContext);
        if (localObject1 != null)
        {
          localObject1 = ((bgut)localObject1).a();
          if (localObject1 == null) {
            break label465;
          }
          localObject2 = ((bgun)localObject1).a;
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
            modifyFriendInteractiveStorage(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambgkd, str3, (String)localObject1);
            return;
          }
          showConfirmModificationModel(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambgkd, str3, (String)localObject1, j);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        bgwc.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        parambgkd.b();
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
  
  public void onMessage(bgkd parambgkd)
  {
    Object localObject;
    if (this.mIsMiniGame) {
      localObject = (bgth)parambgkd.jdField_a_of_type_Bghn;
    }
    while (localObject != null) {
      if (((bgth)localObject).a() == 1)
      {
        localObject = this.mMiniAppInfo;
        if ((localObject != null) && (((MiniAppInfo)localObject).whiteList != null) && (((MiniAppInfo)localObject).whiteList.contains("onMessage")))
        {
          parambgkd.jdField_a_of_type_Bghn.a("onMessage", parambgkd.jdField_b_of_type_JavaLangString, 0);
          sendSubscribeEvent("onMessage", parambgkd.jdField_b_of_type_JavaLangString);
          return;
          localObject = null;
        }
        else
        {
          bgwc.a().e("OpenDataJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
          bgwc.a("error 开放域调用了未授权的私有API: postMessage");
        }
      }
      else
      {
        parambgkd.jdField_a_of_type_Bghn.a("onMessage", parambgkd.jdField_b_of_type_JavaLangString, 0);
        return;
      }
    }
    bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
  }
  
  public void removeUserCloudStorage(bgkd parambgkd)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        removeUserCloudStorage(arrayOfString, parambgkd);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest removeUserCloudStorage error " + parambgkd.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, bgkd parambgkd)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbgwc.i("OpenDataJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.5(this, parambgkd));
      return;
    }
  }
  
  public void setMessageToFriendQuery(bgkd parambgkd)
  {
    try
    {
      int i = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).optInt("shareMessageToFriendScene", -1);
      if (i == -1) {
        parambgkd.b();
      }
      if (this.mMiniAppInfo != null) {
        this.mMiniAppInfo.friendMessageQuery = ("shareMessageToFriendScene=" + i);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("success", true);
      parambgkd.a(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      bgwc.a("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      parambgkd.b();
    }
  }
  
  public void setUserCloudStorage(bgkd parambgkd)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString).optJSONArray("KVDataList");
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
      setUserCloudStorage(localHashMap, parambgkd);
      return;
    }
    catch (Throwable parambgkd)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest setUserCloudStorage error " + parambgkd.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, bgkd parambgkd)
  {
    bgwc localbgwc = bgwc.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localbgwc.i("OpenDataJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, paramHashMap, new OpenDataJsPlugin.4(this, parambgkd));
      return;
    }
  }
  
  public void shareMessageToFriend(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("friendInfo");
      shareMessageToFriend(localJSONObject2.getString("openid"), localJSONObject2.getString("nickname"), localJSONObject1.optString("title"), localJSONObject1.optString("imageUrl"), localJSONObject1.optString("imageUrlId"), parambgkd);
      return;
    }
    catch (Throwable localThrowable)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      bgwc.a("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      parambgkd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */