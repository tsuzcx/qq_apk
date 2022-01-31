package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import behp;
import behq;
import bejl;
import beki;
import bekr;
import bekz;
import bely;
import besj;
import besl;
import betc;
import beuw;
import bevt;
import bevz;
import bexk;
import bfhp;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
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
  
  private void getPotentialFriendListImpl(bekr parambekr)
  {
    if (this.mMiniAppInfo == null)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      bexk.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      parambekr.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, str, new OpenDataJsPlugin.7(this, parambekr));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, bekr parambekr)
  {
    if (this.mMiniAppInfo == null)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      bexk.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      parambekr.b();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataJsPlugin.8(this, parambekr));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bekr parambekr, String paramString8, String paramString9)
  {
    if (this.mMiniAppInfo == null)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      parambekr.b();
      return;
    }
    String str1 = this.mMiniAppInfo.appId;
    String str2 = this.mMiniAppInfo.shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        parambekr.b();
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      parambekr.b();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt + "");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt, paramString2, localHashMap, new OpenDataJsPlugin.9(this, parambekr, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, bekr parambekr)
  {
    String str = "";
    besl localbesl = (besl)this.mMiniAppContext.a(beki.a());
    paramString5 = str;
    if (this.mMiniAppInfo != null)
    {
      paramString5 = str;
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + this.mMiniAppInfo.friendMessageQuery;
      }
      localbesl.jdField_c_of_type_JavaLangString = this.mMiniAppInfo.appId;
    }
    localbesl.jdField_a_of_type_JavaLangString = parambekr.jdField_a_of_type_JavaLangString;
    localbesl.jdField_c_of_type_Int = parambekr.jdField_b_of_type_Int;
    localbesl.jdField_b_of_type_JavaLangString = paramString1;
    str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "miniGamePath";
    }
    paramString5 = new OpenDataJsPlugin.6(this, parambekr);
    boolean bool1;
    if ((URLUtil.isHttpUrl(paramString4)) || (URLUtil.isHttpsUrl(paramString4)))
    {
      bool1 = true;
      if ((TextUtils.isEmpty(paramString4)) || (!new File(bejl.a().a(paramString4)).exists())) {
        break label416;
      }
    }
    label416:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      parambekr = new besj();
      parambekr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.mMiniAppContext.a();
      parambekr.jdField_a_of_type_Int = 11;
      parambekr.jdField_b_of_type_Int = 5;
      parambekr.jdField_a_of_type_AndroidAppActivity = this.mMiniAppContext.a();
      parambekr.jdField_a_of_type_JavaLangString = paramString3;
      parambekr.jdField_c_of_type_JavaLangString = str;
      parambekr.d = "";
      parambekr.e = "";
      parambekr.f = "";
      parambekr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = null;
      parambekr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = paramString2;
      parambekr.jdField_b_of_type_Boolean = localbesl.h;
      parambekr.g = paramString1;
      if ((!bely.a(paramString4)) && ((bool1) || (bool2))) {
        break label422;
      }
      parambekr.jdField_b_of_type_JavaLangString = bfhp.a();
      this.mShareProxy.onJsShareAppMessage(parambekr, paramString5);
      betc.d("OpenDataJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString4 + "], use default share image");
      return;
      bool1 = false;
      break;
    }
    label422:
    if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
    {
      parambekr.jdField_b_of_type_JavaLangString = paramString4;
      this.mShareProxy.onJsShareAppMessage(parambekr, paramString5);
      return;
    }
    parambekr.jdField_b_of_type_JavaLangString = bejl.a().a(paramString4);
    this.mShareProxy.onJsShareAppMessage(parambekr, paramString5);
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, bekr parambekr, String paramString8, String paramString9, int paramInt2)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt2 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt2 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambekr, paramString8, paramString9);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataJsPlugin.10(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, parambekr, paramString8, paramString9), null, new OpenDataJsPlugin.11(this, parambekr));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bekz.a(new OpenDataJsPlugin.12(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void getFriendCloudStorage(bekr parambekr)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        getFriendCloudStorage(arrayOfString, parambekr);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest getFriendCloudStorage error " + parambekr.getMessage());
      return;
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, bekr parambekr)
  {
    bexk localbexk = bexk.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(bevz.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbexk.i("OpenDataJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(bevz.a().a(), paramArrayOfString, new OpenDataJsPlugin.3(this, parambekr));
      return;
    }
  }
  
  public void getGroupCloudStorage(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
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
        getGroupCloudStorage(str, (String[])localObject, parambekr);
        return;
        localObject = new String[0];
      }
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambekr.getMessage());
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, bekr parambekr)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        parambekr.a(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        bexk.a().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        parambekr.b();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(bevz.a().a(), paramString, paramArrayOfString, new OpenDataJsPlugin.2(this, parambekr));
  }
  
  public void getOpenDataContext(bekr parambekr) {}
  
  public void getPotentialFriendList(bekr parambekr)
  {
    try
    {
      getPotentialFriendListImpl(parambekr);
      return;
    }
    catch (Throwable localThrowable)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      bexk.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      parambekr.b();
    }
  }
  
  public void getUserCloudStorage(bekr parambekr)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        getUserCloudStorage(arrayOfString, parambekr);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + parambekr.getMessage());
      return;
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, bekr parambekr)
  {
    bexk localbexk = bexk.a();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(bevz.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbexk.i("OpenDataJsPlugin", str);
      if ((paramArrayOfString != null) && (parambekr.jdField_a_of_type_Behp != null)) {
        break;
      }
      return;
    }
    parambekr = new OpenDataJsPlugin.1(this, parambekr);
    this.mChannelProxy.getUserCloudStorage(bevz.a().a(), paramArrayOfString, parambekr);
  }
  
  public void getUserInteractiveStorage(bekr parambekr)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).getJSONArray("keyList");
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
        getUserInteractiveStorage(arrayOfString, parambekr);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable localThrowable)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      bexk.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      parambekr.b();
      return;
    }
  }
  
  public void modifyFriendInteractiveStorage(bekr parambekr)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
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
        if (bevz.a().a() != null)
        {
          localObject2 = bevz.a().a().a;
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
                    break label452;
                  }
                  str3 = ((JSONObject)localObject1).optString("key");
                  if ((TextUtils.isEmpty(str3)) || (!str3.equals(str6))) {
                    break label452;
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
            modifyFriendInteractiveStorage(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambekr, str3, (String)localObject1);
            return;
          }
          showConfirmModificationModel(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, parambekr, str3, (String)localObject1, j);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        parambekr.b();
        return;
      }
      Object localObject2 = null;
      continue;
      label452:
      i += 1;
    }
  }
  
  public void onMessage(bekr parambekr)
  {
    Object localObject;
    if (this.mIsMiniGame) {
      localObject = (beuw)parambekr.jdField_a_of_type_Behp;
    }
    while (localObject != null) {
      if (((beuw)localObject).a() == 1)
      {
        localObject = this.mMiniAppInfo;
        if ((localObject != null) && (((MiniAppInfo)localObject).whiteList != null) && (((MiniAppInfo)localObject).whiteList.contains("onMessage")))
        {
          parambekr.jdField_a_of_type_Behp.a("onMessage", parambekr.jdField_b_of_type_JavaLangString, 0);
          sendSubscribeEvent("onMessage", parambekr.jdField_b_of_type_JavaLangString);
          return;
          localObject = null;
        }
        else
        {
          bexk.a().e("OpenDataJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
          bexk.a("error 开放域调用了未授权的私有API: postMessage");
        }
      }
      else
      {
        parambekr.jdField_a_of_type_Behp.a("onMessage", parambekr.jdField_b_of_type_JavaLangString, 0);
        return;
      }
    }
    bexk.a().e("OpenDataJsPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
  }
  
  public void removeUserCloudStorage(bekr parambekr)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optJSONArray("keyList");
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
        removeUserCloudStorage(arrayOfString, parambekr);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest removeUserCloudStorage error " + parambekr.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, bekr parambekr)
  {
    bexk localbexk = bexk.a();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(bevz.a().a()).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localbexk.i("OpenDataJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(bevz.a().a(), paramArrayOfString, new OpenDataJsPlugin.5(this, parambekr));
      return;
    }
  }
  
  public void setMessageToFriendQuery(bekr parambekr)
  {
    try
    {
      int i = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optInt("shareMessageToFriendScene", -1);
      if (i == -1) {
        parambekr.b();
      }
      if (this.mMiniAppInfo != null) {
        this.mMiniAppInfo.friendMessageQuery = ("shareMessageToFriendScene=" + i);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("success", true);
      parambekr.a(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      bexk.a("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      parambekr.b();
    }
  }
  
  public void setUserCloudStorage(bekr parambekr)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambekr.jdField_b_of_type_JavaLangString).optJSONArray("KVDataList");
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
      setUserCloudStorage(localHashMap, parambekr);
      return;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest setUserCloudStorage error " + parambekr.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, bekr parambekr)
  {
    bexk localbexk = bexk.a();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(bevz.a().a()).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localbexk.i("OpenDataJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(bevz.a().a(), paramHashMap, new OpenDataJsPlugin.4(this, parambekr));
      return;
    }
  }
  
  public void shareMessageToFriend(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambekr.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("friendInfo");
      shareMessageToFriend(localJSONObject2.getString("openid"), localJSONObject2.getString("nickname"), localJSONObject1.optString("title"), localJSONObject1.optString("imageUrl"), localJSONObject1.optString("imageUrlId"), parambekr);
      return;
    }
    catch (Throwable localThrowable)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      bexk.a("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      parambekr.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */