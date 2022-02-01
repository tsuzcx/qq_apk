package com.tencent.mobileqq.guild.share.live;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;

public class GuildLiveShareActionRunnable
{
  private final String a;
  private final Activity b;
  private final IShareActionHelper c = (IShareActionHelper)QRoute.api(IShareActionHelper.class);
  
  public GuildLiveShareActionRunnable(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    this.a = paramString;
    this.b = paramActivity;
  }
  
  public void a()
  {
    this.c.doShareTextBySelect("guildShare", this.b, this.a);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c.doShareTextDirectly("guildShare", this.b, this.a, paramInt, paramString);
  }
  
  public void b()
  {
    this.c.doSharTextToWeChat("guildShare", 9, this.b, String.valueOf(System.currentTimeMillis()), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.live.GuildLiveShareActionRunnable
 * JD-Core Version:    0.7.0.1
 */