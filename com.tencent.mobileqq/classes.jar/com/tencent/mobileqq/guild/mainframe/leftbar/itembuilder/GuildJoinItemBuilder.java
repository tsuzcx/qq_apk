package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildJoinMFData;
import mqq.app.AppRuntime;

public class GuildJoinItemBuilder
  extends GuildListItemBaseBuilder
{
  public GuildJoinItemBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    super(paramGuildMainViewContext, paramGuildBaseLeftItemData);
  }
  
  private void f()
  {
    GuildJoinMFData localGuildJoinMFData = (GuildJoinMFData)this.d;
    if ((TextUtils.isEmpty(localGuildJoinMFData.g)) && (localGuildJoinMFData.f != null) && (localGuildJoinMFData.f.extras != null) && (!TextUtils.isEmpty(localGuildJoinMFData.f.extras.getString("share_element_info_head_url")))) {
      localGuildJoinMFData.g = localGuildJoinMFData.f.extras.getString("share_element_info_head_url");
    }
  }
  
  public int a()
  {
    return GuildMainFrameConstants.l;
  }
  
  public View a(View paramView)
  {
    super.a(paramView);
    if (this.d != null)
    {
      if (paramView == null) {
        return paramView;
      }
      if (AppSetting.e) {
        paramView.setContentDescription(((GuildJoinMFData)this.d).h);
      }
    }
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.c.a(1, this.d);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((GuildJoinMFData)this.d).g = paramString1;
    ((GuildJoinMFData)this.d).h = paramString2;
  }
  
  public void b()
  {
    f();
    Drawable localDrawable = ((IQQGuildAvatarApi)this.c.a().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(((GuildJoinMFData)this.d).g, 0, false);
    this.d.c = localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildJoinItemBuilder
 * JD-Core Version:    0.7.0.1
 */