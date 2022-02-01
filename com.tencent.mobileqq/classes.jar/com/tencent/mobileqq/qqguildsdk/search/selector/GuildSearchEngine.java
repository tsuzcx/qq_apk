package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class GuildSearchEngine
  extends SearchEngine<IGProGuildInfo>
{
  private boolean a;
  private boolean g;
  
  protected abstract List<IGProGuildInfo> a();
  
  Map<Integer, String> a(IGProGuildInfo paramIGProGuildInfo, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt == 1)
    {
      localHashMap.put(Integer.valueOf(paramInt), paramIGProGuildInfo.getGuildName());
      return localHashMap;
    }
    if (paramInt == 2)
    {
      localHashMap.put(Integer.valueOf(paramInt), paramIGProGuildInfo.getShowNumber());
      return localHashMap;
    }
    if (paramInt == 3)
    {
      localHashMap.put(Integer.valueOf(1), paramIGProGuildInfo.getGuildName());
      localHashMap.put(Integer.valueOf(2), paramIGProGuildInfo.getShowNumber());
    }
    return localHashMap;
  }
  
  public void a(String paramString, int paramInt, ISearchSink<IGProGuildInfo> paramISearchSink, boolean paramBoolean)
  {
    this.g = paramBoolean;
    a(paramString, paramInt, paramISearchSink);
  }
  
  protected abstract void a(String paramString, ISearchSink paramISearchSink);
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected Runnable b()
  {
    if (!this.g) {
      return super.b();
    }
    return new GuildSearchEngine.1(this);
  }
  
  protected boolean c()
  {
    return (this.g) || (super.c());
  }
  
  protected void d()
  {
    this.f = new Vector(a());
    this.a = false;
  }
  
  protected boolean e()
  {
    return (this.a) && (!this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildSearchEngine
 * JD-Core Version:    0.7.0.1
 */