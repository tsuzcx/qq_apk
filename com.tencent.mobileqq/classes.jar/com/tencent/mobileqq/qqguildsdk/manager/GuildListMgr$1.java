package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.search.selector.GuildSearchEngine;
import java.util.List;

class GuildListMgr$1
  extends GuildSearchEngine
{
  GuildListMgr$1(GuildListMgr paramGuildListMgr) {}
  
  protected List<IGProGuildInfo> a()
  {
    return this.a.b();
  }
  
  protected void a(String paramString, ISearchSink paramISearchSink)
  {
    GuildListMgr.a(this.a).a(paramString, new GuildListMgr.1.1(this, paramISearchSink, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr.1
 * JD-Core Version:    0.7.0.1
 */