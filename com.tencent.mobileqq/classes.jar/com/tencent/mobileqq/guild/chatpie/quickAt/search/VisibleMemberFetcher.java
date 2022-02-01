package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class VisibleMemberFetcher
  extends SearchContext
{
  public final String a;
  public final String b;
  private final AppRuntime e;
  private final List<String> f;
  private List<IGProUserInfo> g;
  
  public VisibleMemberFetcher(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString1, @NonNull String paramString2, @NonNull List<String> paramList)
  {
    this.e = paramAppRuntime;
    this.a = paramString1;
    this.b = paramString2;
    this.f = paramList;
  }
  
  public String a()
  {
    String str = TextUtils.join("|", this.f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return "";
  }
  
  public List<IGProUserInfo> c()
  {
    return this.g;
  }
  
  public void d()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).fetchVisibleMemberListByTinyId(this.a, this.b, this.f, new -..Lambda.VisibleMemberFetcher.Akt95tHNNw_RanggU4eIa-Ro9fA(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.VisibleMemberFetcher
 * JD-Core Version:    0.7.0.1
 */