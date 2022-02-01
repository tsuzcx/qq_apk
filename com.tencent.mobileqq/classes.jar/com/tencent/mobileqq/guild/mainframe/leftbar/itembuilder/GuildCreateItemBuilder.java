package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class GuildCreateItemBuilder
  extends GuildListItemBaseBuilder
{
  public GuildCreateItemBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    super(paramGuildMainViewContext, paramGuildBaseLeftItemData);
  }
  
  private void f()
  {
    if (this.c.b() == null) {
      return;
    }
    if (QQGuildUIUtil.a()) {
      return;
    }
    Intent localIntent = new Intent();
    Object localObject = (TicketManager)this.c.a().getManager(2);
    String str = ((TicketManager)localObject).getPskey(this.c.a().getCurrentUin(), "qun.qq.com");
    localObject = ((TicketManager)localObject).getSkey(this.c.a().getCurrentUin());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://qun.qq.com/qqweb/qunpro/create?_wv=3&_wwv=128&cateid=50000&from=plus&skey=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&pskey=");
    localStringBuilder.append(str);
    localIntent.putExtra("url", localStringBuilder.toString());
    localIntent.putExtra("finish_animation_up_down_guild", true);
    this.c.b().startActivity(localIntent);
    TroopCreateUtils.a(this.c.b(), localIntent, "/base/browser");
    this.c.b().overridePendingTransition(2130772133, 2130772007);
  }
  
  public int a()
  {
    return GuildMainFrameConstants.n;
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
        paramView.setContentDescription(this.c.b().getString(2131890488));
      }
    }
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    f();
  }
  
  public void b()
  {
    Drawable localDrawable = this.c.b().getResources().getDrawable(2130840867);
    this.d.c = localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildCreateItemBuilder
 * JD-Core Version:    0.7.0.1
 */