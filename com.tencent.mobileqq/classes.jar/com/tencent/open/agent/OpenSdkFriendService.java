package com.tencent.open.agent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.settings.ServerSetting;
import java.util.ArrayList;
import java.util.List;

public class OpenSdkFriendService
{
  protected static OpenSdkFriendService a;
  protected long a;
  protected Bundle a;
  protected OpenSdkFriendService.CheckAvatarUpdateListener a;
  protected HttpCgiAsyncTask a;
  protected DbCacheManager a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  
  public static OpenSdkFriendService a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService == null) {
        jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService = new OpenSdkFriendService();
      }
      OpenSdkFriendService localOpenSdkFriendService = jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService;
      return localOpenSdkFriendService;
    }
    finally {}
  }
  
  public ArrayList<FriendGroup> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager;
    int i = 0;
    if (localObject == null) {
      return new ArrayList(0);
    }
    int j = ((DbCacheManager)localObject).a();
    localObject = new ArrayList(j);
    while (i < j)
    {
      ((ArrayList)localObject).add((FriendGroup)this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(i));
      i += 1;
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateListener = null;
    HttpCgiAsyncTask localHttpCgiAsyncTask = this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask;
    if (localHttpCgiAsyncTask != null) {
      localHttpCgiAsyncTask.a();
    }
  }
  
  public void a(Bundle paramBundle, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener, String paramString)
  {
    if ((paramBundle != null) && (paramGetFriendInfoListener != null))
    {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      this.d = paramString;
      if ("action_invite".equals(paramString))
      {
        paramString = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
        paramBundle.putString("md5str", OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").getString(this.b, ""));
      }
      else if ("action_story".equals(paramString))
      {
        paramString = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      this.c = paramString;
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask = new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.GetFriendListCallback(this, paramGetFriendInfoListener), true);
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a(paramBundle);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("getFriendListAsync params error. params=");
    paramString.append(paramBundle);
    paramString.append("; listener=");
    paramString.append(paramGetFriendInfoListener);
    LogUtility.e("OpenSdkFriendService", paramString.toString());
  }
  
  protected void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, OpenSdkFriendService.CheckAvatarUpdateListener paramCheckAvatarUpdateListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateListener = paramCheckAvatarUpdateListener;
    paramBundle.putString("time", OpensdkPreference.a(CommonDataAdapter.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.CheckAvatarUpdateCallback(this), true).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(OpensdkPreference.a(CommonDataAdapter.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        paramString1 = CacheManager.a();
        long l = this.jdField_a_of_type_Long;
        paramString2 = new StringBuilder();
        paramString2.append("invite_friend_list_");
        paramString2.append(this.b);
        this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = paramString1.a(FriendGroup.class, l, paramString2.toString());
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
    }
    finally {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initData error. appid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("; openid=");
    localStringBuilder.append(paramString2);
    LogUtility.e("OpenSdkFriendService", localStringBuilder.toString());
  }
  
  public void a(List<FriendGroup> paramList)
  {
    if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
      return;
    }
    FriendGroup[] arrayOfFriendGroup = new FriendGroup[paramList.size()];
    paramList.toArray(arrayOfFriendGroup);
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(arrayOfFriendGroup, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService
 * JD-Core Version:    0.7.0.1
 */