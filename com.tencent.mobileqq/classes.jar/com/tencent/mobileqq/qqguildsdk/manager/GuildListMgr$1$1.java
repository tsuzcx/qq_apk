package com.tencent.mobileqq.qqguildsdk.manager;

import android.os.Handler;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.IGProSearchGuildCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import java.util.ArrayList;

class GuildListMgr$1$1
  implements IGProSearchGuildCallback
{
  GuildListMgr$1$1(GuildListMgr.1 param1, ISearchSink paramISearchSink, String paramString) {}
  
  public void onSearchGuildResult(int paramInt, String paramString, ArrayList<GProGuild> paramArrayList)
  {
    GuildListMgr.1.a(this.c).post(new GuildListMgr.1.1.1(this, paramInt, paramString, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr.1.1
 * JD-Core Version:    0.7.0.1
 */