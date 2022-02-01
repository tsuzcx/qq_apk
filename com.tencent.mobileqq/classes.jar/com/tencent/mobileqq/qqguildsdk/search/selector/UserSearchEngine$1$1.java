package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.List;

class UserSearchEngine$1$1
  implements Runnable
{
  UserSearchEngine$1$1(UserSearchEngine.1 param1, List paramList) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId : ");
    localStringBuilder.append(UserSearchEngine.a(this.b.this$0));
    localStringBuilder.append("， key:");
    localStringBuilder.append(this.b.this$0.c);
    localStringBuilder.append(", res.size() : ");
    localStringBuilder.append(this.a.size());
    GProLog.a("UserSearchEngine", false, "sdk interface", "searchGuildUser---searchReturnInfo", "return search result", localStringBuilder.toString());
    this.b.this$0.e.onSearchResult(0, "", this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine.1.1
 * JD-Core Version:    0.7.0.1
 */