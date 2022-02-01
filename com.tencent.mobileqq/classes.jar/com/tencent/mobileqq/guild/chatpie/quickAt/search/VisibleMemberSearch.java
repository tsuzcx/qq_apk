package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class VisibleMemberSearch
  extends SearchContext
{
  public final String a;
  public final String b;
  public final String e;
  private final AppRuntime f;
  private List<IGProUserInfo> g;
  
  public VisibleMemberSearch(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    this.f = paramAppRuntime;
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramString3;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return this.e;
  }
  
  public List<IGProUserInfo> c()
  {
    return this.g;
  }
  
  public void d()
  {
    ((IGPSService)this.f.getRuntimeService(IGPSService.class, "")).searchVisibleMemberList(this.a, this.b, 1, this.e, 100, new -..Lambda.VisibleMemberSearch.7Rs0eYQvnB1QIKGQ3xEDDPclsgQ(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.VisibleMemberSearch
 * JD-Core Version:    0.7.0.1
 */