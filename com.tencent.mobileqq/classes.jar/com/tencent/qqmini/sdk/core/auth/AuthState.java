package com.tencent.qqmini.sdk.core.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AuthState
{
  public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
  static final String TAG = "AuthState";
  private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap();
  private String mAppId;
  private Context mContext;
  private String mUin;
  
  public AuthState(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.mUin = paramString2;
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return this.mContext.getSharedPreferences(this.mAppId + "_" + this.mUin, 4);
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
    setAuthState(paramString, paramBoolean, new AuthState.1(this));
  }
  
  public void setAuthState(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    int j = 1;
    int i = 1;
    ChannelProxy localChannelProxy;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramBoolean) {
        break label110;
      }
      grantPermission(paramString);
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (!paramString.startsWith("setting")) {
        break label124;
      }
      paramAsyncResult = new UserSettingInfo();
      paramAsyncResult.settingItem = paramString;
      localObject = PermissionManager.g().getScopePermission(paramString);
      if (localObject != null) {
        paramString = ((PermissionInfo)localObject).description;
      }
      paramAsyncResult.desc = paramString;
      if (!paramBoolean) {
        break label118;
      }
    }
    for (;;)
    {
      paramAsyncResult.authState = i;
      localChannelProxy.updateUserSetting(this.mAppId, paramAsyncResult, new AuthState.2(this));
      return;
      label110:
      revokePermission(paramString);
      break;
      label118:
      i = 2;
    }
    label124:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.AuthState
 * JD-Core Version:    0.7.0.1
 */