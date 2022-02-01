package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Vector;

class UserSearchEngine$2
  implements IGProLoadAllMemberListCallback
{
  UserSearchEngine$2(UserSearchEngine paramUserSearchEngine) {}
  
  public void onLoadAllMemberList(int paramInt, String paramString, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    if (paramInt != 0)
    {
      paramString = new StringBuilder();
      paramString.append("guildId : ");
      paramString.append(UserSearchEngine.a(this.a));
      GProLog.a("UserSearchEngine", true, "sdk interface", "searchGuildUser---searchReturnInfo", "gain svr userlist fail", paramString.toString());
      UserSearchEngine.a(this.a, false);
      return;
    }
    this.a.f = new Vector(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */