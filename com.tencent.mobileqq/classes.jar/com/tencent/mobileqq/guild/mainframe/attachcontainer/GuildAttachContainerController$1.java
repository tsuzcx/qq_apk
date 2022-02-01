package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GuildAttachContainerController$1
  extends AbsGestureListener
{
  GuildAttachContainerController$1(GuildAttachContainerController paramGuildAttachContainerController) {}
  
  public void a(NotifyData paramNotifyData)
  {
    super.a(paramNotifyData);
    this.a.k().a(paramNotifyData);
    GuildAttachContainerController.a(this.a, paramNotifyData);
    StringBuilder localStringBuilder;
    if (paramNotifyData.e() == 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNotify move end. ");
        localStringBuilder.append(paramNotifyData.toString());
        QLog.d("GuildAttachContainerController", 1, localStringBuilder.toString());
      }
      if (paramNotifyData.a() == 1)
      {
        ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).tabWidgetAnim(GuildAttachContainerController.a(this.a).b(), false);
        if (GuildAttachContainerController.b(this.a) == GuildAttachContainerController.d)
        {
          GuildAttachContainerController.c(this.a).setBackgroundColor(GuildAttachContainerController.c(this.a).getResources().getColor(2131166198));
          return;
        }
        GuildAttachContainerController.c(this.a).setBackground(GuildAttachContainerController.c(this.a).getContext().getDrawable(2130840769));
        return;
      }
      if (paramNotifyData.a() == 3)
      {
        float f1 = GuildAttachContainerController.c(this.a).getTranslationX();
        float f2 = GuildChatFrameGestureUtil.a();
        float f3 = GuildChatFrameGestureUtil.a(GuildAttachContainerController.d(this.a).b());
        if (QLog.isDebugVersion()) {
          QLog.d("GuildAttachContainerController", 1, new Object[] { " translationX=", Float.valueOf(f1), " maxTranlationX=", Float.valueOf(f3), " minTranlationX=", Float.valueOf(f2) });
        }
        if (f1 == f3)
        {
          ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).tabWidgetAnim(GuildAttachContainerController.e(this.a).b(), true);
          GuildAttachContainerController.c(this.a).setBackground(null);
          return;
        }
        if (f1 == f2)
        {
          if (GuildAttachContainerController.b(this.a) == GuildAttachContainerController.d)
          {
            GuildAttachContainerController.c(this.a).setBackgroundColor(GuildAttachContainerController.c(this.a).getResources().getColor(2131166198));
            return;
          }
          GuildAttachContainerController.c(this.a).setBackground(GuildAttachContainerController.c(this.a).getContext().getDrawable(2130840769));
        }
      }
      return;
    }
    if (((paramNotifyData.e() == 3) || (paramNotifyData.e() == 2)) && (paramNotifyData.a() == 0) && (GuildAttachContainerController.c(this.a).getTranslationX() == GuildChatFrameGestureUtil.a()) && (GuildAttachContainerController.b(this.a) == GuildAttachContainerController.d)) {
      GuildAttachContainerController.c(this.a).setBackgroundColor(GuildAttachContainerController.c(this.a).getResources().getColor(2131166198));
    }
    if (paramNotifyData.a() == 3)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNotify move end. ");
        localStringBuilder.append(paramNotifyData.toString());
        QLog.d("GuildAttachContainerController", 1, localStringBuilder.toString());
      }
      if (paramNotifyData.b() == 1000)
      {
        ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setTabWidgetVisible(GuildAttachContainerController.f(this.a).b(), true);
        GuildAttachContainerController.c(this.a).setBackground(null);
        return;
      }
      if (paramNotifyData.b() == 0)
      {
        ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setTabWidgetVisible(GuildAttachContainerController.g(this.a).b(), false);
        GuildAttachContainerController.c(this.a).setBackground(GuildAttachContainerController.c(this.a).getContext().getDrawable(2130840769));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController.1
 * JD-Core Version:    0.7.0.1
 */