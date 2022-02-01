package com.tencent.mobileqq.guild.audio.widget;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.animate.AnimationCompatUtils;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AudioSmallScreen
  extends FrameLayout
{
  private IGProGuildInfo a;
  private IGProChannelInfo b;
  private final BaseQQAppInterface c;
  private final ImageView d;
  private final ImageView e;
  private final VolumnAnimateView f;
  private Context g;
  private boolean h = false;
  private final AudioRoomObserver i = new AudioSmallScreen.4(this);
  
  public AudioSmallScreen(@NonNull Context paramContext, BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramContext);
    View.inflate(BaseApplication.getContext(), 2131624996, this);
    this.d = ((ImageView)findViewById(2131438170));
    this.e = ((ImageView)findViewById(2131435265));
    this.f = ((VolumnAnimateView)findViewById(2131449904));
    this.c = paramBaseQQAppInterface;
    this.g = paramContext;
  }
  
  private void a(int paramInt)
  {
    Animator localAnimator = AnimationCompatUtils.a(this.d, 0.0F, 1.0F);
    localAnimator.setDuration(200L);
    localAnimator.addListener(new AudioSmallScreen.3(this, paramInt));
    localAnimator.start();
  }
  
  private void a(LocalUserInfo paramLocalUserInfo, int paramInt)
  {
    if ((paramLocalUserInfo != null) && (paramLocalUserInfo.c)) {
      setMicState(paramLocalUserInfo.m);
    }
    this.f.setVolumn(paramInt);
  }
  
  private void c()
  {
    this.c.addObserver(this.i);
  }
  
  private void d()
  {
    this.c.removeObserver(this.i);
  }
  
  private void setMicState(boolean paramBoolean)
  {
    if (this.h == paramBoolean) {
      return;
    }
    this.h = paramBoolean;
    if (paramBoolean)
    {
      a(2130840726);
      return;
    }
    a(2130840725);
  }
  
  public void a()
  {
    d();
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    this.a = paramIGProGuildInfo;
    this.b = paramIGProChannelInfo;
    paramIGProGuildInfo = this.a.getAvatarUrl(0);
    paramIGProGuildInfo = ((IQQGuildAvatarApi)this.c.getRuntimeService(IQQGuildAvatarApi.class)).getAvatarDrawable(paramIGProGuildInfo, ViewUtils.dip2px(64.0F), ViewUtils.dip2px(64.0F), "audio_float");
    this.e.setImageDrawable(paramIGProGuildInfo);
    setOnClickListener(new AudioSmallScreen.1(this));
    c();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new AudioSmallScreen.2(this), 1L);
  }
  
  public void b()
  {
    boolean bool = GuildFloatWindowManager.a.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkAndForegroundApp: app foreground[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    QLog.e("AudioSmallScreen", 1, ((StringBuilder)localObject).toString());
    if (!bool)
    {
      localObject = MobileQQ.getContext();
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTabFromBackground((Context)localObject, false, 0, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen
 * JD-Core Version:    0.7.0.1
 */