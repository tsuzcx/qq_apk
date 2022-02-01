package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GuildListMgr$1$1$1
  implements Runnable
{
  GuildListMgr$1$1$1(GuildListMgr.1.1 param1, int paramInt, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.a == 0)
    {
      this.d.a.onSearchResult(this.a, this.b, this.d.c.a.a(this.d.b, this.c), true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(this.a);
    GProLog.b("GuildListMgr", true, "sdk callback", "searchSrvGuildByShowNumber", "fail", localStringBuilder.toString());
    this.d.a.onSearchResult(this.a, this.b, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr.1.1.1
 * JD-Core Version:    0.7.0.1
 */