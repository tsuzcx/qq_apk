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
  public static final String IS_SYS_SUB_ITEM_MAINTAIN = "sys_sub_item_maintain";
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
    Context localContext = this.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mUin);
    return localContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  private static void initDefaultAskEveryTimeMap()
  {
    HashMap localHashMap = scopeAuthTypeMap;
    Integer localInteger = Integer.valueOf(1);
    localHashMap.put("scope.getPhoneNumber", localInteger);
    scopeAuthTypeMap.put("scope.uploadAvatar", localInteger);
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
  
  public int getPermissionAuthFlag(String paramString)
  {
    return getSharedPreferences().getInt(paramString, 1);
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
  
  public boolean isSystemSubscribeMaintain()
  {
    return getSharedPreferences().getBoolean("sys_sub_item_maintain", false);
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean) {
        grantPermission(paramString);
      } else {
        revokePermission(paramString);
      }
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      boolean bool = paramString.startsWith("setting");
      int j = 1;
      int i = 1;
      if (bool)
      {
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
          i = 2;
        }
        paramString.set(i);
        localChannelProxy.updateUserSetting(this.mAppId, paramAsyncResult, new AuthState.3(this));
        return;
      }
      Object localObject = new UserAuthInfo();
      ((UserAuthInfo)localObject).scope = paramString;
      PermissionInfo localPermissionInfo = PermissionManager.g().getScopePermission(paramString);
      if (localPermissionInfo != null) {
        paramString = localPermissionInfo.description;
      }
      ((UserAuthInfo)localObject).desc = paramString;
      if (paramBoolean) {
        i = j;
      } else {
        i = 2;
      }
      ((UserAuthInfo)localObject).authState = i;
      localChannelProxy.setAuth(this.mAppId, (UserAuthInfo)localObject, paramAsyncResult);
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
      while (i < paramList.size())
      {
        localObject = (UserAuthInfo)paramList.get(i);
        String str = ((UserAuthInfo)localObject).scope;
        int k = ((UserAuthInfo)localObject).authState;
        if (k == 1) {
          getSharedPreferences().edit().putInt(str, 2).commit();
        } else if (k == 2) {
          getSharedPreferences().edit().putInt(str, 4).commit();
        }
        i += 1;
      }
    }
    if (paramList1 != null)
    {
      i = j;
      while (i < paramList1.size())
      {
        paramList = (UserSettingInfo)paramList1.get(i);
        localObject = paramList.settingItem;
        j = paramList.authState;
        if (j == 1) {
          getSharedPreferences().edit().putInt((String)localObject, 2).commit();
        } else if (j == 2) {
          getSharedPreferences().edit().putInt((String)localObject, 4).commit();
        }
        i += 1;
      }
    }
  }
  
  public void updateIsOnceSubMsgMaintain(boolean paramBoolean)
  {
    getSharedPreferences().edit().putBoolean("once_sub_item_maintain", paramBoolean).apply();
  }
  
  public void updateIsSysSubMsgMaintain(boolean paramBoolean)
  {
    getSharedPreferences().edit().putBoolean("sys_sub_item_maintain", paramBoolean).apply();
  }
  
  public void updateOnceSubMsgSetting(String paramString, boolean paramBoolean, List<INTERFACE.StSubscribeMessage> paramList, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserSettingInfo localStUserSettingInfo = new INTERFACE.StUserSettingInfo();
    if (paramString != null) {
      localStUserSettingInfo.settingItem.set(paramString);
    }
    paramString = localStUserSettingInfo.authState;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    paramString.set(i);
    if (paramList != null) {
      localStUserSettingInfo.subItems.set(paramList);
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateUserSetting(this.mAppId, localStUserSettingInfo, new AuthState.1(this, paramAsyncResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthState
 * JD-Core Version:    0.7.0.1
 */