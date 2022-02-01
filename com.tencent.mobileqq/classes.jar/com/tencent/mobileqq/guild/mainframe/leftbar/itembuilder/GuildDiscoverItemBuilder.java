package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;

public class GuildDiscoverItemBuilder
  extends GuildListItemBaseBuilder
{
  public GuildDiscoverItemBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    super(paramGuildMainViewContext, paramGuildBaseLeftItemData);
  }
  
  public int a()
  {
    return GuildMainFrameConstants.j;
  }
  
  public View a(View paramView)
  {
    super.a(paramView);
    if (paramView == null) {
      return paramView;
    }
    if (AppSetting.e) {
      paramView.setContentDescription(this.c.b().getString(2131890489));
    }
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.c.a(2, this.d);
  }
  
  public void b()
  {
    Drawable localDrawable = this.c.b().getResources().getDrawable(2130840868);
    this.d.c = localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildDiscoverItemBuilder
 * JD-Core Version:    0.7.0.1
 */