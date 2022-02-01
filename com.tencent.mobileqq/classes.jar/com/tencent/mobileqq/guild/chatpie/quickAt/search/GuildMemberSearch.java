package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildMemberSearch
  extends SearchContext
{
  public final String a;
  public final String b;
  private final AppRuntime e;
  private List<IGProUserInfo> f;
  
  public GuildMemberSearch(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString1, @NonNull String paramString2)
  {
    this.e = paramAppRuntime;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public List<IGProUserInfo> c()
  {
    return this.f;
  }
  
  public void d()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).searchGuildUserByGuildNickname(this.a, this.b, 1, new -..Lambda.GuildMemberSearch.daT9pT0hJme9_D7Gc8AGPLUCe8Q(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.GuildMemberSearch
 * JD-Core Version:    0.7.0.1
 */