package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildMFData;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import mqq.app.AppRuntime;

public class GuildListItemBuilder
  extends GuildListItemBaseBuilder
{
  public GuildListItemBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    super(paramGuildMainViewContext, paramGuildBaseLeftItemData);
  }
  
  public int a()
  {
    return GuildMainFrameConstants.m;
  }
  
  @RequiresApi(api=23)
  public View a(View paramView)
  {
    super.a(paramView);
    if (this.d != null)
    {
      if (paramView == null) {
        return paramView;
      }
      Object localObject = ((GuildBaseListItemLayout)paramView).getHolder();
      GuildMFData localGuildMFData = (GuildMFData)this.d;
      localObject = a(paramView, (GuildBaseItemViewHolder)localObject, localGuildMFData.g);
      if (AppSetting.e) {
        paramView.setContentDescription(String.format(this.c.b().getString(2131890487), new Object[] { localGuildMFData.h, localObject }));
      }
    }
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.c.a(1, this.d);
  }
  
  public int b(GuildListItemBaseBuilder paramGuildListItemBaseBuilder)
  {
    if (((this.d instanceof GuildMFData)) && ((paramGuildListItemBaseBuilder.d instanceof GuildMFData)))
    {
      if (((GuildMFData)this.d).f == ((GuildMFData)paramGuildListItemBaseBuilder.d).f) {
        return 0;
      }
      if (((GuildMFData)this.d).f > ((GuildMFData)paramGuildListItemBaseBuilder.d).f) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    IGProGuildInfo localIGProGuildInfo = ((IGPSService)this.c.a().getRuntimeService(IGPSService.class, "")).getGuildInfo(this.d.b);
    if (localIGProGuildInfo != null)
    {
      localObject = localIGProGuildInfo.getAvatarUrl(100);
      ((GuildMFData)this.d).f = localIGProGuildInfo.getJoinTime();
      ((GuildMFData)this.d).h = localIGProGuildInfo.getGuildName();
    }
    else
    {
      localObject = "";
    }
    Object localObject = ((IQQGuildAvatarApi)this.c.a().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable((String)localObject, 2, false);
    this.d.c = ((Drawable)localObject);
    ((GuildMFData)this.d).g = ((IGuildUnreadCntService)this.c.a().getRuntimeService(IGuildUnreadCntService.class, "")).getGuildUnreadCnt(this.d.b);
  }
  
  public void c()
  {
    ((IGuildMsgReadedService)this.c.a().getRuntimeService(IGuildMsgReadedService.class, "")).setGuildReaded(this.d.b, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBuilder
 * JD-Core Version:    0.7.0.1
 */