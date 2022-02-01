package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchRequestModel;
import com.tencent.mobileqq.qqguildsdk.search.model.UserSearchResultModel;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UserSearchEngine
  extends SearchEngine<GProUser>
{
  private String a = "";
  private String g = "";
  private IGProLoadAllMemberListCallback h = a();
  private boolean i = false;
  
  private IGProLoadAllMemberListCallback a()
  {
    return new UserSearchEngine.2(this);
  }
  
  private List<ISearchResultModel<IGProUserInfo>> b(SearchRequestModel paramSearchRequestModel)
  {
    return UserSearchResultModel.b(a(paramSearchRequestModel));
  }
  
  Map<Integer, String> a(GProUser paramGProUser, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt == 1)
    {
      localHashMap.put(Integer.valueOf(paramInt), paramGProUser.getNickName());
      return localHashMap;
    }
    if (paramInt == 2)
    {
      localHashMap.put(Integer.valueOf(paramInt), GProConvert.a(paramGProUser.getTinyId()));
      return localHashMap;
    }
    if (paramInt == 3)
    {
      localHashMap.put(Integer.valueOf(1), paramGProUser.getNickName());
      localHashMap.put(Integer.valueOf(2), GProConvert.a(paramGProUser.getTinyId()));
    }
    return localHashMap;
  }
  
  protected abstract void a(String paramString, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback);
  
  public void a(String paramString1, String paramString2, ISearchSink paramISearchSink, int paramInt)
  {
    this.a = paramString1;
    a(paramString2, paramInt, paramISearchSink);
  }
  
  protected Runnable b()
  {
    return new UserSearchEngine.1(this);
  }
  
  protected void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(this.a);
    GProLog.a("UserSearchEngine", false, "sdk interface", "searchGuildUser---fetchCache", "fetch new userlist", localStringBuilder.toString());
    a(this.a, this.h);
    this.i = true;
  }
  
  protected boolean e()
  {
    boolean bool2 = this.a.equals(this.g);
    boolean bool1 = true;
    int j = bool2 ^ true;
    this.g = this.a;
    if (j != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(this.a);
      GProLog.a("UserSearchEngine", false, "sdk interface", "searchGuildUser---needCleanCache", "enter new guild aio", localStringBuilder.toString());
    }
    if (this.i)
    {
      if (j != 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine
 * JD-Core Version:    0.7.0.1
 */