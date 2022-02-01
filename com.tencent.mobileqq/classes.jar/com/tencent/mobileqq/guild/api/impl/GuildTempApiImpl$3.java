package com.tencent.mobileqq.guild.api.impl;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

class GuildTempApiImpl$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GuildTempApiImpl$3(GuildTempApiImpl paramGuildTempApiImpl, TabWidget paramTabWidget, MainFragment paramMainFragment) {}
  
  private void a()
  {
    try
    {
      if (!GuildTempApiImpl.access$400(this.c))
      {
        int i = this.a.getHeight();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("hideTabWidgetInstantly, height2 = ");
        ((StringBuilder)localObject1).append(i);
        QLog.d("GuildTempApiImpl", 2, ((StringBuilder)localObject1).toString());
        localObject1 = this.a;
        float f = i;
        ((TabWidget)localObject1).setTranslationY(f);
        this.b.K.setTranslationY(f);
      }
      return;
    }
    finally {}
  }
  
  public void onGlobalLayout()
  {
    a();
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    GuildTempApiImpl.access$302(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTempApiImpl.3
 * JD-Core Version:    0.7.0.1
 */