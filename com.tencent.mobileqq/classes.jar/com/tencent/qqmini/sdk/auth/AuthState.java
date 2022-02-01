package com.tencent.qqmini.sdk.auth;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AuthState
{
  public static final String IS_ONCE_SUB_ITEM_MAINTAIN = "once_sub_item_maintain";
  public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
  static final String TAG = "AuthState";
  private static volatile String sTempAllowPluginScopeName;
  private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap();
  private String mAppId;
  private Context mContext;
  private String mUin;
  
  static
  {
    initDefaultAskEveryTimeMap();
  }
  
  public AuthState() {}
  
  public AuthState(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.mUin = paramString2;
  }
  
  public static String getAllowPluginScopeName()
  {
    return sTempAllowPluginScopeName;
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return this.mContext.getSharedPreferences(this.mAppId + "_" + this.mUin, 4);
  }
  
  private static void initDefaultAskEveryTimeMap()
  {
    scopeAuthTypeMap.put("scope.getPhoneNumber", Integer.valueOf(1));
    scopeAuthTypeMap.put("scope.uploadAvatar", Integer.valueOf(1));
  }
  
  public static void setAllowPluginScopeName(String paramString)
  {
    sTempAllowPluginScopeName = paramString;
  }
  
  public void clearAll()
  {
    QMLog.i("AuthState", "clear all auth ");
    SharedPreferences localSharedPreferences = getSharedPreferences();
    Iterator localIterator = PermissionManager.g().getAllPermissions().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localSharedPreferences.edit().putInt(str, 1).commit();
    }
    localSharedPreferences.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public int getAuthFlag(String paramString)
  {
    return getSharedPreferences().getInt(paramString, 1);
  }
  
  public List<AuthStateItem> getAuthStateList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = PermissionManager.g().getAllPermissions().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)scopeAuthTypeMap.get(str);
      if ((localInteger == null) || (localInteger.intValue() != 1))
      {
        int i = getSharedPreferences().getInt(str, 1);
        if (i == 2)
        {
          if ((paramInt & 0x2) == 2) {
            localArrayList.add(new AuthStateItem(str, 2));
          }
        }
        else if (i == 1)
        {
          if ((paramInt & 0x1) == 1) {
            localArrayList.add(new AuthStateItem(str, 1));
          }
        }
        else if ((paramInt & 0x4) == 4) {
          localArrayList.add(new AuthStateItem(str, 4));
        }
      }
    }
    return localArrayList;
  }
  
  public void grantPermission(String paramString)
  {
    getSharedPreferences().edit().putInt(paramString, 2).commit();
  }
  
  public boolean isOnceSubMaintain()
  {
    return getSharedPreferences().getBoolean("once_sub_item_maintain", false);
  }
  
  public boolean isPermissionGranted(String paramString)
  {
    return 2 == (getSharedPreferences().getInt(paramString, 1) & 0x2);
  }
  
  public boolean isSynchronized()
  {
    return getSharedPreferences().getBoolean("authority_synchronized", false);
  }
  
  public void revokePermission(String paramString)
  {
    getSharedPreferences().edit().putInt(paramString, 4).commit();
  }
  
  public void setAuthState(String paramString, boolean paramBoolean)
  {
    setAuthState(paramString, paramBoolean, new AuthState.2(this));
  }
  
  public void setAuthState(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    int j = 1;
    int i = 1;
    ChannelProxy localChannelProxy;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramBoolean) {
        break label125;
      }
      grantPermission(paramString);
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (!paramString.startsWith("setting")) {
        break label139;
      }
      paramAsyncResult = new INTERFACE.StUserSettingInfo();
      paramAsyncResult.settingItem.set(paramString);
      localPermissionInfo = PermissionManager.g().getScopePermission(paramString);
      localObject = paramAsyncResult.desc;
      if (localPermissionInfo != null) {
        paramString = localPermissionInfo.description;
      }
      ((PBStringField)localObject).set(paramString);
      paramString = paramAsyncResult.authState;
      if (!paramBoolean) {
        break label133;
      }
    }
    for (;;)
    {
      paramString.set(i);
      localChannelProxy.updateUserSetting(this.mAppId, paramAsyncResult, new AuthState.3(this));
      return;
      label125:
      revokePermission(paramString);
      break;
      label133:
      i = 2;
    }
    label139:
    Object localObject = new UserAuthInfo();
    ((UserAuthInfo)localObject).scope = paramString;
    PermissionInfo localPermissionInfo = PermissionManager.g().getScopePermission(paramString);
    if (localPermissionInfo != null) {
      paramString = localPermissionInfo.description;
    }
    ((UserAuthInfo)localObject).desc = paramString;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      ((UserAuthInfo)localObject).authState = i;
      localChannelProxy.setAuth(this.mAppId, (UserAuthInfo)localObject, paramAsyncResult);
      return;
    }
  }
  
  public void setSynchronized()
  {
    getSharedPreferences().edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public boolean shouldAskEveryTime(String paramString)
  {
    paramString = (Integer)scopeAuthTypeMap.get(paramString);
    return (paramString != null) && (paramString.intValue() == 1);
  }
  
  public void updateAuthStateList(List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    int j = 0;
    int i;
    Object localObject;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject = (UserAuthInfo)paramList.get(i);
        String str = ((UserAuthInfo)localObject).scope;
        int k = ((UserAuthInfo)localObject).authState;
        if (k == 1) {
          getSharedPreferences().edit().putInt(str, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 2) {
            getSharedPreferences().edit().putInt(str, 4).commit();
          }
        }
      }
    }
    if (paramList1 != null)
    {
      i = j;
      if (i < paramList1.size())
      {
        paramList = (UserSettingInfo)paramList1.get(i);
        localObject = paramList.settingItem;
        j = paramList.authState;
        if (j == 1) {
          getSharedPreferences().edit().putInt((String)localObject, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 2) {
            getSharedPreferences().edit().putInt((String)localObject, 4).commit();
          }
        }
      }
    }
  }
  
  public void updateIsOnceSubMsgMaintain(boolean paramBoolean)
  {
    getSharedPreferences().edit().putBoolean("once_sub_item_maintain", paramBoolean).apply();
  }
  
  public void updateOnceSubMsgSetting(boolean paramBoolean, List<INTERFACE.StSubscribeMessage> paramList, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserSettingInfo localStUserSettingInfo = new INTERFACE.StUserSettingInfo();
    localStUserSettingInfo.settingItem.set("setting.onceMsgSubscribed");
    PBInt32Field localPBInt32Field = localStUserSettingInfo.authState;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localPBInt32Field.set(i);
      localStUserSettingInfo.subItems.set(paramList);
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateUserSetting(this.mAppId, localStUserSettingInfo, new AuthState.1(this, paramAsyncResult));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthState
 * JD-Core Version:    0.7.0.1
 */