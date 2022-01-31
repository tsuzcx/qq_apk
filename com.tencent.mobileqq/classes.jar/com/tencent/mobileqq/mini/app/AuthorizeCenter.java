package com.tencent.mobileqq.mini.app;

import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import ajya;
import amtb;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApiScopeEntry;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.UserAuthScope;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthorizeCenter
{
  public static final int AUTH_FLAG_FALSE = 4;
  public static final int AUTH_FLAG_NONE = 1;
  public static final int AUTH_FLAG_TRUE = 2;
  public static final String KEY_API_NAME = "api_name";
  public static final String KEY_API_NAME_CLICK_ADVERT = "advert_tap";
  public static final String KEY_API_NAME_GET_ADVERT = "webapi_getadvert";
  public static final String KEY_API_NAME_GET_NAVIGATE_WX_APPINFO = "webapi_getnavigatewxaappinfo";
  public static final String KEY_API_NAME_GET_SUBJECT_ALTER_INFO = "getSubjectalterInfo";
  public static final String KEY_API_NAME_GET_USER_INFO = "webapi_getuserinfo";
  public static final String KEY_API_NAME_GET_USER_INFO_OPEN_DATA = "webapi_getuserinfo_opendata";
  public static final String KEY_API_NAME_RUN_STEP_HISTORY = "webapi_getwerunstep_history";
  public static final String KEY_API_NAME_WXA_SUBSCRIBE_BIZ = "webapi_wxa_subscribe_biz";
  public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
  public static final String KEY_IS_REQUEST_USER_INFO_AUTH_BY_USER = "from_component";
  public static final String SCOPE_ADDRESS = "scope.address";
  public static final String SCOPE_APP_MSG_SUBSCRIBED = "scope.appMsgSubscribed";
  public static final String SCOPE_CAMERA = "scope.camera";
  public static final String SCOPE_GET_PHONE_NUMBER = "scope.getPhoneNumber";
  public static final String SCOPE_INVOICE = "scope.invoice";
  public static final String SCOPE_INVOICE_TITLE = "scope.invoiceTitle";
  public static final String SCOPE_PERSONALIZE = "scope.personalize";
  public static final String SCOPE_RECORD = "scope.record";
  public static final String SCOPE_USER_INFO = "scope.userInfo";
  public static final String SCOPE_USER_LOCATION = "scope.userLocation";
  public static final String SCOPE_WEREN = "scope.qqrun";
  public static final String SCOPE_WRITE_PHOTOS_ALBUM = "scope.writePhotosAlbum";
  public static final String SETTING_ADD_FRIEND = "setting.addFriend";
  public static final String TAG = "AuthorizeCenter";
  private static ExtConfigInfo extConfigInfo;
  public static final HashMap<String, String> negativeButtonDesMap = new HashMap();
  private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap();
  public static final HashMap<String, String> scopeDescMap;
  public static final List<String> scopeList;
  private static final HashMap<String, String> scopeMap;
  public static final HashMap<String, String> scopeTitleMap;
  public static final HashMap<String, String> settingScopeTitleMap;
  private static String systemPermissionConfig = amtb.a("miniappsustempermissionconfig", "{\"chooseLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"openLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"getLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"chooseVideo\":\"android.permission.CAMERA\",\"chooseImage\":\"android.permission.CAMERA\",\"saveImageToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"saveVideoToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"startRecord\":\"android.permission.RECORD_AUDIO\",\"operateRecorder\":\"android.permission.RECORD_AUDIO\",\"joinVoIPChat\":\"android.permission.RECORD_AUDIO\",\"operateCamera\":\"android.permission.CAMERA\",\"updateCamera\":\"android.permission.CAMERA\",\"insertCamera\":\"android.permission.CAMERA\"}");
  public static final HashMap<String, String> systemPermissionMap;
  private int ANTH_DELAY = 60;
  private String appid;
  private SharedPreferences sp;
  
  static
  {
    scopeMap = new HashMap();
    scopeList = new ArrayList();
    scopeTitleMap = new HashMap();
    scopeDescMap = new HashMap();
    settingScopeTitleMap = new HashMap();
    systemPermissionMap = new HashMap();
    try
    {
      if (!TextUtils.isEmpty(systemPermissionConfig))
      {
        JSONObject localJSONObject = new JSONObject(systemPermissionConfig);
        if (localJSONObject.length() > 0)
        {
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = localJSONObject.optString(str1);
            systemPermissionMap.put(str1, str2);
            QLog.i("AuthorizeCenter", 1, "event : " + str1 + "; permissionname : " + str2);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthorizeCenter", 1, "systemPermissionConfig error", localThrowable);
      systemPermissionMap.put("chooseLocation", "android.permission.ACCESS_FINE_LOCATION");
      systemPermissionMap.put("openLocation", "android.permission.ACCESS_FINE_LOCATION");
      systemPermissionMap.put("getLocation", "android.permission.ACCESS_FINE_LOCATION");
      if (Build.VERSION.SDK_INT >= 16)
      {
        systemPermissionMap.put("chooseVideo", "android.permission.CAMERA");
        systemPermissionMap.put("chooseImage", "android.permission.CAMERA");
        systemPermissionMap.put("saveImageToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
        systemPermissionMap.put("saveVideoToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
      }
      systemPermissionMap.put("startRecord", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("operateRecorder", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("joinVoIPChat", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("operateCamera", "android.permission.CAMERA");
      systemPermissionMap.put("updateCamera", "android.permission.CAMERA");
      scopeMap.put("chooseLocation", "scope.userLocation");
      scopeMap.put("getLocation", "scope.userLocation");
      scopeMap.put("saveImageToPhotosAlbum", "scope.writePhotosAlbum");
      scopeMap.put("saveVideoToPhotosAlbum", "scope.writePhotosAlbum");
      scopeMap.put("startRecord", "scope.record");
      scopeMap.put("operateWXData", "scope.userInfo");
      scopeMap.put("chooseInvoiceTitle", "scope.invoiceTitle");
      scopeMap.put("openAddress", "scope.address");
      scopeMap.put("openWeRunSetting", "scope.qqrun");
      scopeMap.put("getNativeWeRunData", "scope.qqrun");
      scopeMap.put("subscribeAppMsg", "scope.appMsgSubscribed");
      scopeMap.put("insertCamera", "scope.camera");
      scopeMap.put("Personalize", "scope.personalize");
      scopeMap.put("getPhoneNumber", "scope.getPhoneNumber");
      scopeList.add("scope.userLocation");
      scopeList.add("scope.userInfo");
      scopeList.add("scope.address");
      scopeList.add("scope.invoiceTitle");
      scopeList.add("scope.qqrun");
      scopeList.add("scope.record");
      scopeList.add("scope.writePhotosAlbum");
      scopeList.add("scope.camera");
      scopeList.add("scope.personalize");
      scopeList.add("scope.appMsgSubscribed");
      scopeList.add("setting.addFriend");
      scopeList.add("scope.getPhoneNumber");
      scopeTitleMap.put("scope.userLocation", ajya.a(2131700813));
      scopeTitleMap.put("scope.userInfo", ajya.a(2131700812));
      scopeTitleMap.put("scope.address", ajya.a(2131700819));
      scopeTitleMap.put("scope.invoiceTitle", ajya.a(2131700824));
      scopeTitleMap.put("scope.qqrun", ajya.a(2131694279));
      scopeTitleMap.put("scope.record", ajya.a(2131700825));
      scopeTitleMap.put("scope.writePhotosAlbum", ajya.a(2131700827));
      scopeTitleMap.put("scope.camera", ajya.a(2131700833));
      scopeTitleMap.put("scope.personalize", ajya.a(2131700821));
      scopeTitleMap.put("scope.appMsgSubscribed", ajya.a(2131700837));
      scopeTitleMap.put("setting.addFriend", ajya.a(2131700835));
      scopeTitleMap.put("scope.getPhoneNumber", ajya.a(2131694278));
      scopeDescMap.put("scope.userLocation", "");
      scopeDescMap.put("scope.userInfo", ajya.a(2131694277));
      scopeDescMap.put("scope.address", "");
      scopeDescMap.put("scope.invoiceTitle", "");
      scopeDescMap.put("scope.qqrun", "");
      scopeDescMap.put("scope.record", "");
      scopeDescMap.put("scope.writePhotosAlbum", "");
      scopeDescMap.put("scope.camera", "");
      scopeDescMap.put("scope.personalize", "");
      scopeDescMap.put("scope.appMsgSubscribed", ajya.a(2131700820));
      scopeDescMap.put("setting.addFriend", "");
      scopeDescMap.put("scope.getPhoneNumber", "");
      settingScopeTitleMap.put("scope.userLocation", ajya.a(2131700814));
      settingScopeTitleMap.put("scope.userInfo", ajya.a(2131700815));
      settingScopeTitleMap.put("scope.address", ajya.a(2131700810));
      settingScopeTitleMap.put("scope.invoiceTitle", ajya.a(2131700831));
      settingScopeTitleMap.put("scope.qqrun", ajya.a(2131700811));
      settingScopeTitleMap.put("scope.record", ajya.a(2131700832));
      settingScopeTitleMap.put("scope.writePhotosAlbum", ajya.a(2131700838));
      settingScopeTitleMap.put("scope.camera", ajya.a(2131700823));
      settingScopeTitleMap.put("scope.personalize", ajya.a(2131700816));
      settingScopeTitleMap.put("scope.appMsgSubscribed", ajya.a(2131700829));
      settingScopeTitleMap.put("setting.addFriend", ajya.a(2131700836));
      negativeButtonDesMap.put("scope.appMsgSubscribed", ajya.a(2131700826));
      mergeExtConfigInfo();
    }
  }
  
  public AuthorizeCenter(Context paramContext, String paramString1, String paramString2)
  {
    this.sp = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + paramString2, 4);
    this.appid = paramString1;
  }
  
  public static void clearAuth(String paramString1, String paramString2)
  {
    QLog.i("AuthorizeCenter", 1, "clear all auth ");
    paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + paramString2, 4);
    paramString2 = scopeMap.values().iterator();
    while (paramString2.hasNext())
    {
      String str = (String)paramString2.next();
      if (paramString1.getInt(str, 1) != 1) {
        paramString1.edit().putInt(str, 1).commit();
      }
    }
    paramString1.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public static String getEventNameByScopeName(String paramString)
  {
    Iterator localIterator = scopeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static String getScopeName(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      str = getScopeNameByParams(paramString2);
      if (isScopeNameValid(str)) {
        return str;
      }
    }
    String str = null;
    try
    {
      paramString2 = new JSONObject(paramString2).optString("api_name");
      if (TextUtils.isEmpty(paramString2)) {}
      for (;;)
      {
        return (String)scopeMap.get(paramString1);
        paramString1 = paramString1 + "." + paramString2;
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        paramString2 = str;
      }
    }
  }
  
  private static String getScopeNameByParams(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("scope").getString(0);
      String str = paramString;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str = paramString.trim();
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        break label40;
      }
      localThrowable1 = localThrowable1;
      paramString = "";
    }
    label40:
    return paramString;
  }
  
  public static String getSystemPermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      paramString1 = getEventNameByScopeName(getScopeNameByParams(paramString2));
      return (String)systemPermissionMap.get(paramString1);
    }
    return (String)systemPermissionMap.get(paramString1);
  }
  
  public static boolean isInScopeList(String paramString1, String paramString2)
  {
    return !TextUtils.isEmpty(getScopeName(paramString1, paramString2));
  }
  
  public static boolean isScopeNameValid(String paramString)
  {
    Iterator localIterator = scopeList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private static void mergeExtConfigInfo()
  {
    if (extConfigInfo != null) {}
    for (;;)
    {
      return;
      String str = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).getString("MiniAppExtConfigDetail", null);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2;
        for (;;)
        {
          try
          {
            extConfigInfo = ExtConfigInfo.fromJson(new JSONObject(str));
            localObject2 = extConfigInfo.apiScopeEntries.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            ApiScopeEntry localApiScopeEntry = (ApiScopeEntry)((Iterator)localObject2).next();
            if ((localApiScopeEntry != null) && (!TextUtils.isEmpty(localApiScopeEntry.eventName)) && (!TextUtils.isEmpty(localApiScopeEntry.scope))) {
              if (TextUtils.isEmpty(localApiScopeEntry.apiName))
              {
                str = localApiScopeEntry.eventName;
                scopeMap.put(str, localApiScopeEntry.scope);
                if (!scopeList.contains(localApiScopeEntry.scope)) {
                  scopeList.add(localApiScopeEntry.scope);
                }
              }
              else
              {
                localObject1 = localApiScopeEntry.eventName + "." + localApiScopeEntry.apiName;
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e("AuthorizeCenter", 1, "mergeExtConfigInfo error:", localException);
            return;
          }
        }
        Object localObject1 = extConfigInfo.userAuthScopes.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (UserAuthScope)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((UserAuthScope)localObject2).scope)))
          {
            if (!TextUtils.isEmpty(((UserAuthScope)localObject2).desc)) {
              scopeTitleMap.put(((UserAuthScope)localObject2).scope, ((UserAuthScope)localObject2).desc);
            }
            if (!TextUtils.isEmpty(((UserAuthScope)localObject2).settingPageTitle)) {
              settingScopeTitleMap.put(((UserAuthScope)localObject2).scope, ((UserAuthScope)localObject2).settingPageTitle);
            }
            if (!scopeDescMap.containsKey(((UserAuthScope)localObject2).scope)) {
              scopeDescMap.put(((UserAuthScope)localObject2).scope, "");
            }
            if (!scopeAuthTypeMap.containsKey(((UserAuthScope)localObject2).scope)) {
              scopeAuthTypeMap.put(((UserAuthScope)localObject2).scope, Integer.valueOf(((UserAuthScope)localObject2).authType));
            }
          }
        }
      }
    }
  }
  
  public static void updateScopeDescription(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = scopeDescMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        updateScopeDescriptionMap((String)((Map.Entry)localIterator.next()).getKey(), paramJSONObject);
      }
    }
  }
  
  private static void updateScopeDescriptionMap(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has(paramString))
    {
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      if (paramJSONObject.has("desc")) {
        scopeDescMap.put(paramString, paramJSONObject.optString("desc"));
      }
    }
  }
  
  public int getAuthFlag(String paramString1, String paramString2)
  {
    String str = getScopeName(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return 2;
      if ("operateWXData".equals(paramString1)) {}
      try
      {
        paramString1 = new JSONObject(paramString2).optJSONObject("data").optString("api_name");
        if ((!"webapi_getuserinfo_opendata".equals(paramString1)) && (!"webapi_getadvert".equals(paramString1)) && (!"webapi_getwerunstep_history".equals(paramString1)) && (!"advert_tap".equals(paramString1)))
        {
          boolean bool = "webapi_getnavigatewxaappinfo".equals(paramString1);
          if (bool) {}
        }
      }
      catch (Throwable paramString1)
      {
        label93:
        break label93;
      }
    }
    return this.sp.getInt(str, 1);
  }
  
  public int getAuthFlagFromAuthorize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 2;
    }
    return this.sp.getInt(paramString, 1);
  }
  
  public List<AuthorizeCenter.AuthorizeInfo> getAuthorizeList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = scopeList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)scopeAuthTypeMap.get(str);
      if ((localInteger == null) || (localInteger.intValue() != 1))
      {
        int i = this.sp.getInt(str, 1);
        if (i == 2)
        {
          if ((paramInt & 0x2) == 2) {
            localArrayList.add(new AuthorizeCenter.AuthorizeInfo(str, 2));
          }
        }
        else if (i == 1)
        {
          if ((paramInt & 0x1) == 1) {
            localArrayList.add(new AuthorizeCenter.AuthorizeInfo(str, 1));
          }
        }
        else if ((paramInt & 0x4) == 4) {
          localArrayList.add(new AuthorizeCenter.AuthorizeInfo(str, 4));
        }
      }
    }
    return localArrayList;
  }
  
  public boolean isAuthorizeSynchronized()
  {
    return this.sp.getBoolean("authority_synchronized", false);
  }
  
  public void setAuthorize(String paramString, boolean paramBoolean)
  {
    setAuthorize(paramString, paramBoolean, new AuthorizeCenter.1(this));
  }
  
  public void setAuthorize(String paramString, boolean paramBoolean, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    int j = 1;
    int k = 2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label138;
      }
    }
    label138:
    for (int i = 2;; i = 4)
    {
      this.sp.edit().putInt(paramString, i).commit();
      if (!paramString.startsWith("setting")) {
        break;
      }
      paramMiniAppCmdInterface = new INTERFACE.StUserSettingInfo();
      paramMiniAppCmdInterface.settingItem.set(paramString);
      paramString = (String)scopeTitleMap.get(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        paramMiniAppCmdInterface.desc.set(paramString);
      }
      paramString = paramMiniAppCmdInterface.authState;
      i = k;
      if (paramBoolean) {
        i = 1;
      }
      paramString.set(i);
      MiniAppCmdUtil.getInstance().updateUserSetting(null, this.appid, paramMiniAppCmdInterface, new AuthorizeCenter.2(this));
      return;
    }
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramString);
    paramString = (String)scopeTitleMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      localStUserAuthInfo.desc.set(paramString);
    }
    paramString = localStUserAuthInfo.authState;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      paramString.set(i);
      MiniAppCmdUtil.getInstance().setAuth(null, this.appid, localStUserAuthInfo, paramMiniAppCmdInterface);
      return;
    }
  }
  
  public void setAuthorizeSynchronized()
  {
    this.sp.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public boolean shouldAskEveryTime(String paramString1, String paramString2)
  {
    paramString1 = getScopeName(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString1 = (Integer)scopeAuthTypeMap.get(paramString1);
    if ((paramString1 != null) && (paramString1.intValue() == 1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void updateAuth(String paramString, boolean paramBoolean)
  {
    if (this.sp == null) {
      return;
    }
    if (paramBoolean)
    {
      this.sp.edit().putInt(paramString, 2).commit();
      return;
    }
    this.sp.edit().putInt(paramString, 4).commit();
  }
  
  public void updateAuthList(List<INTERFACE.StUserAuthInfo> paramList, List<INTERFACE.StUserSettingInfo> paramList1)
  {
    int k = 0;
    if (paramList != null)
    {
      int i = 0;
      int j = k;
      Object localObject;
      if (i < paramList.size())
      {
        localObject = (INTERFACE.StUserAuthInfo)paramList.get(i);
        String str = ((INTERFACE.StUserAuthInfo)localObject).scope.get();
        j = ((INTERFACE.StUserAuthInfo)localObject).authState.get();
        if (j == 1) {
          this.sp.edit().putInt(str, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 2) {
            this.sp.edit().putInt(str, 4).commit();
          }
        }
      }
      if (j < paramList1.size())
      {
        paramList = (INTERFACE.StUserSettingInfo)paramList1.get(j);
        localObject = paramList.settingItem.get();
        i = paramList.authState.get();
        if (i == 1) {
          this.sp.edit().putInt((String)localObject, 2).commit();
        }
        for (;;)
        {
          j += 1;
          break;
          if (i == 2) {
            this.sp.edit().putInt((String)localObject, 4).commit();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter
 * JD-Core Version:    0.7.0.1
 */