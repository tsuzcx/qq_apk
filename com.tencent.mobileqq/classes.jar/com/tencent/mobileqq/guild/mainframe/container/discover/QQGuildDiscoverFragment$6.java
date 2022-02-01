package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.container.GuildFacadeFrameController;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.DiscoverGuildBean;
import com.tencent.mobileqq.guild.mainframe.container.discover.shareelement.ShareElementInfo;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

class QQGuildDiscoverFragment$6
  implements QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener
{
  QQGuildDiscoverFragment$6(QQGuildDiscoverFragment paramQQGuildDiscoverFragment) {}
  
  public void a(int paramInt, View paramView, ImageView paramImageView, DiscoverGuildBean paramDiscoverGuildBean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("imageView:");
    ((StringBuilder)localObject).append(paramImageView);
    ((StringBuilder)localObject).append("  guildBean:");
    ((StringBuilder)localObject).append(paramDiscoverGuildBean);
    QLog.i("GuildDiscover.QQGuildDiscoverFragment", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("imageView, height=");
      ((StringBuilder)localObject).append(paramImageView.getHeight());
      ((StringBuilder)localObject).append(", width = ");
      ((StringBuilder)localObject).append(paramImageView.getWidth());
      QLog.i("GuildDiscover", 2, ((StringBuilder)localObject).toString());
    }
    QQGuildDiscoverFragment.a(this.a, paramView);
    if ((((IGPSService)QQGuildDiscoverFragment.m(this.a).a().getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(paramDiscoverGuildBean.a)) == null) && (QQGuildDiscoverFragment.m(this.a).d().i() != null)) {
      QQGuildDiscoverFragment.m(this.a).d().i().a(paramDiscoverGuildBean.g);
    }
    localObject = ObjectAnimator.ofFloat(QQGuildDiscoverFragment.n(this.a), "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(350L);
    ((ObjectAnimator)localObject).setInterpolator(new DecelerateInterpolator(2.0F));
    ((ObjectAnimator)localObject).addListener(new QQGuildDiscoverFragment.6.1(this));
    ((ObjectAnimator)localObject).start();
    GuildDiscoverAnimationManager.a = true;
    if ((paramInt & 0x1) == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    localObject = new Bundle();
    ShareElementInfo localShareElementInfo = new ShareElementInfo();
    localShareElementInfo.a(paramImageView, paramInt);
    ((Bundle)localObject).putParcelable("share_element_info", localShareElementInfo);
    ((Bundle)localObject).putBoolean("share_element_info_from", true);
    ((Bundle)localObject).putString("share_element_info_view_url", paramDiscoverGuildBean.g);
    ((Bundle)localObject).putString("share_element_info_head_url", QQGuildUIUtil.a(paramDiscoverGuildBean.f, 100));
    GuildDiscoverAnimationManager.e.put(String.valueOf(paramDiscoverGuildBean.a), localObject);
    paramImageView = new JoinGuildParam();
    paramImageView.guildId = String.valueOf(paramDiscoverGuildBean.a);
    paramImageView.joinSignature = paramDiscoverGuildBean.i;
    paramImageView.from = 246617;
    paramImageView.extras = ((Bundle)localObject);
    ((GuildLeftItemViewExtHelper)QQGuildDiscoverFragment.m(this.a).a(GuildMainFrameConstants.d)).a(paramImageView);
    paramView.setVisibility(4);
    QQGuildDiscoverFragment.a(this.a, paramView, paramDiscoverGuildBean.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment.6
 * JD-Core Version:    0.7.0.1
 */