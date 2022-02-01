package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildUserLoader
  extends SearchContext
{
  public final String a;
  private final AppRuntime b;
  private final List<String> e;
  private List<IGProUserInfo> f;
  
  public GuildUserLoader(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, @NonNull List<String> paramList)
  {
    this.b = paramAppRuntime;
    this.a = paramString;
    this.e = paramList;
  }
  
  public String a()
  {
    String str = TextUtils.join("|", this.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
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
    return this.f;
  }
  
  public void d()
  {
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).fetchUserInfo(this.a, this.e, false, new -..Lambda.GuildUserLoader.Z3ufrtPXgctlrYwgLcmhpYSTHlM(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.GuildUserLoader
 * JD-Core Version:    0.7.0.1
 */