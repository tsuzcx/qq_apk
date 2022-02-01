package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildUserFetcher
  extends SearchContext
{
  public final String a;
  private final AppRuntime b;
  private List<IGProUserInfo> e;
  
  public GuildUserFetcher(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString)
  {
    this.b = paramAppRuntime;
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return "";
  }
  
  public List<IGProUserInfo> c()
  {
    return this.e;
  }
  
  public void d()
  {
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).getUserList(this.a, 100L, false, new -..Lambda.GuildUserFetcher.yFrabPcuFJXCJ9yfhLGt5q63umM(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.GuildUserFetcher
 * JD-Core Version:    0.7.0.1
 */