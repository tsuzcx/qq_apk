package com.tencent.mobileqq.guild.main;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.HashMap;

class QQGuildChannelAdapterNew$4
  implements View.OnClickListener
{
  QQGuildChannelAdapterNew$4(QQGuildChannelAdapterNew paramQQGuildChannelAdapterNew, View paramView, QQGuildChannelAdapterNew.GroupHolder paramGroupHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    VideoReport.reportEvent("clck", this.a, null);
    if (QQGuildChannelAdapterNew.b(this.d) != null) {
      if (this.b.a.isChecked())
      {
        QQGuildChannelAdapterNew.b(this.d).collapseGroup(this.c);
        ((IQQGuildService)this.d.b().getRuntimeService(IQQGuildService.class, "")).setCategoryCollapse(QQGuildChannelAdapterNew.c(this.d).getGuildID(), ((ICategoryInfo)QQGuildChannelAdapterNew.e(this.d).get(Integer.valueOf(this.c))).a(), true);
      }
      else
      {
        QQGuildChannelAdapterNew.b(this.d).expandGroup(this.c);
        ((IQQGuildService)this.d.b().getRuntimeService(IQQGuildService.class, "")).setCategoryCollapse(QQGuildChannelAdapterNew.c(this.d).getGuildID(), ((ICategoryInfo)QQGuildChannelAdapterNew.e(this.d).get(Integer.valueOf(this.c))).a(), false);
      }
    }
    ObjectAnimator localObjectAnimator;
    if (this.b.a.isChecked()) {
      localObjectAnimator = ObjectAnimator.ofFloat(this.b.a, "rotation", new float[] { 0.0F, -90.0F });
    } else {
      localObjectAnimator = ObjectAnimator.ofFloat(this.b.a, "rotation", new float[] { -90.0F, 0.0F });
    }
    localObjectAnimator.setDuration(150L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
    this.b.a.setChecked(true ^ this.b.a.isChecked());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew.4
 * JD-Core Version:    0.7.0.1
 */