package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.helper.GuildInboxSelectHelper;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildInBoxMFData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildInboxItemBuilder
  extends GuildListItemBaseBuilder
{
  public GuildInboxItemBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    super(paramGuildMainViewContext, paramGuildBaseLeftItemData);
  }
  
  private void f()
  {
    Object localObject = (GuildInboxSelectHelper)this.c.a(GuildMainFrameConstants.h);
    ((GuildInboxSelectHelper)localObject).a(GuildInboxSelectHelper.c);
    if (((GuildInboxSelectHelper)localObject).i() != 0)
    {
      localObject = this.c.e();
      if (localObject != null)
      {
        ((GuildAttachContainerController)localObject).a(GuildAttachContainerController.f, null);
        ((GuildAttachContainerController)localObject).d(true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("GuildInboxItemBuilder", 1, "showLastSelectNotice attachContainerController is null");
      }
    }
  }
  
  public int a()
  {
    return GuildMainFrameConstants.k;
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
      String str = a(paramView, ((GuildBaseListItemLayout)paramView).getHolder(), ((GuildInBoxMFData)this.d).f);
      if (AppSetting.e) {
        paramView.setContentDescription(String.format(this.c.b().getString(2131890495), new Object[] { str }));
      }
    }
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.c.a(3, this.d);
    f();
  }
  
  public void b()
  {
    GuildInBoxMFData localGuildInBoxMFData = (GuildInBoxMFData)this.d;
    localGuildInBoxMFData.c = this.c.b().getResources().getDrawable(2130840869);
    localGuildInBoxMFData.f = ((IGuildInboxRedService)this.c.a().getRuntimeService(IGuildInboxRedService.class, "")).getNoticeRedCount();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateItemData ");
      localStringBuilder.append(localGuildInBoxMFData.f);
      QLog.d("GuildInboxItemBuilder", 1, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    ((IGuildInboxRedService)this.c.a().getRuntimeService(IGuildInboxRedService.class, "")).clearNoticeRedPoint(1);
    if (QLog.isColorLevel()) {
      QLog.d("GuildInboxItemBuilder", 1, "unreadViewDragDone clearNoticeRedPoint");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildInboxItemBuilder
 * JD-Core Version:    0.7.0.1
 */