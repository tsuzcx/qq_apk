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
  protected HttpCgiAsyncTask b;
  protected OpenSdkFriendService.CheckAvatarUpdateListener c;
  protected long d;
  protected String e;
  protected String f;
  protected DbCacheManager g;
  protected Bundle h;
  protected String i;
  protected String j;
  
  public static OpenSdkFriendService a()
  {
    try
    {
      if (a == null) {
        a = new OpenSdkFriendService();
      }
      OpenSdkFriendService localOpenSdkFriendService = a;
      return localOpenSdkFriendService;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener, String paramString)
  {
    if ((paramBundle != null) && (paramGetFriendInfoListener != null))
    {
      this.h = paramBundle;
      this.j = paramString;
      if ("action_invite".equals(paramString))
      {
        paramString = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
        paramBundle.putString("md5str", OpensdkPreference.a(CommonDataAdapter.a().b(), "invite_friend_list_md5").getString(this.f, ""));
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
      this.i = paramString;
      this.b = new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.GetFriendListCallback(this, paramGetFriendInfoListener), true);
      this.b.a(paramBundle);
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
    if ("action_invite".equals(this.j))
    {
      SharedPreferences.Editor localEditor = OpensdkPreference.a(CommonDataAdapter.a().b(), "invite_friend_list_md5").edit();
      localEditor.putString(this.f, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, OpenSdkFriendService.CheckAvatarUpdateListener paramCheckAvatarUpdateListener)
  {
    this.c = paramCheckAvatarUpdateListener;
    paramBundle.putString("time", OpensdkPreference.a(CommonDataAdapter.a().b(), "prefer_last_avatar_update_time").getString(this.f, "0"));
    new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.CheckAvatarUpdateCallback(this), true).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      this.d = Long.parseLong(OpensdkPreference.a(CommonDataAdapter.a().b(), "uin_openid_store").getString(paramString2, ""));
      this.e = paramString1;
      this.f = paramString2;
      try
      {
        paramString1 = CacheManager.a();
        long l = this.d;
        paramString2 = new StringBuilder();
        paramString2.append("invite_friend_list_");
        paramString2.append(this.f);
        this.g = paramString1.a(FriendGroup.class, l, paramString2.toString());
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
    if (this.g == null) {
      return;
    }
    FriendGroup[] arrayOfFriendGroup = new FriendGroup[paramList.size()];
    paramList.toArray(arrayOfFriendGroup);
    this.g.a(arrayOfFriendGroup, 2);
  }
  
  public ArrayList<FriendGroup> b()
  {
    Object localObject = this.g;
    int k = 0;
    if (localObject == null) {
      return new ArrayList(0);
    }
    int m = ((DbCacheManager)localObject).i();
    localObject = new ArrayList(m);
    while (k < m)
    {
      ((ArrayList)localObject).add((FriendGroup)this.g.a(k));
      k += 1;
    }
    return localObject;
  }
  
  public void c()
  {
    this.c = null;
    HttpCgiAsyncTask localHttpCgiAsyncTask = this.b;
    if (localHttpCgiAsyncTask != null) {
      localHttpCgiAsyncTask.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService
 * JD-Core Version:    0.7.0.1
 */