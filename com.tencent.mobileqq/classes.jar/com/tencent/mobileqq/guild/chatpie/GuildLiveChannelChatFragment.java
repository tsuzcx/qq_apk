package com.tencent.mobileqq.guild.chatpie;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.ChatPieCache;
import com.tencent.mobileqq.activity.aio.core.GuildLiveChatPieCache;
import com.tencent.mobileqq.activity.aio.helper.AIOGuildLiveDTReportHelper;
import com.tencent.mobileqq.activity.fling.GuildLiveChatFragmentTopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveChannelInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.view.GuildLiveChannelXPanelContainer;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import com.tencent.mobileqq.guild.widget.EdgeTransparentRelativeLayout;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;

public class GuildLiveChannelChatFragment
  extends ChatFragment
{
  private IQQGuildLiveAIOListener n;
  private Runnable o;
  
  private void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    int i = paramViewGroup2.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup2.getChildAt(i);
      paramViewGroup2.removeView(localView);
      paramViewGroup3.addView(localView, 0);
      i -= 1;
    }
    i = paramViewGroup1.indexOfChild(paramViewGroup2);
    paramViewGroup1.removeView(paramViewGroup2);
    paramViewGroup2 = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup2.addRule(10);
    paramViewGroup1.addView(paramViewGroup3, i, paramViewGroup2);
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateInputHintTheme themeName = ");
    localStringBuilder.append(paramString);
    QLog.d("GuildLiveChannelChatFra", 4, localStringBuilder.toString());
    if ((this.c != null) && ((this.c instanceof GuildLiveChannelChatPie))) {
      ((GuildLiveChannelChatPie)this.c).e(paramString);
    }
  }
  
  public static GuildLiveChannelChatFragment s()
  {
    GuildLiveChannelChatFragment localGuildLiveChannelChatFragment = new GuildLiveChannelChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGuildLiveChannelChatFragment.setArguments(localBundle);
    return localGuildLiveChannelChatFragment;
  }
  
  private void t()
  {
    if (this.b != null) {
      this.b.a();
    }
  }
  
  private void u()
  {
    Runnable localRunnable = this.o;
    if (localRunnable != null)
    {
      localRunnable.run();
      this.o = null;
    }
  }
  
  private void v()
  {
    ViewGroup localViewGroup1 = (ViewGroup)this.h.findViewById(2131430542);
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getParent();
    EdgeTransparentRelativeLayout localEdgeTransparentRelativeLayout = new EdgeTransparentRelativeLayout(localViewGroup1.getContext());
    if ((localViewGroup1 instanceof RelativeLayout))
    {
      localEdgeTransparentRelativeLayout.setId(localViewGroup1.getId());
      a(localViewGroup2, localViewGroup1, localEdgeTransparentRelativeLayout);
      return;
    }
    throw new IllegalArgumentException("please modify EdgeTransparentRelativeLayout extends to class of R.id.chat_content");
  }
  
  private void w()
  {
    ViewGroup localViewGroup1 = (ViewGroup)this.h.findViewById(2131445137);
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getParent();
    GuildLiveChannelXPanelContainer localGuildLiveChannelXPanelContainer = new GuildLiveChannelXPanelContainer(localViewGroup1.getContext());
    localGuildLiveChannelXPanelContainer.setId(localViewGroup1.getId());
    a(localViewGroup2, localViewGroup1, localGuildLiveChannelXPanelContainer);
  }
  
  private void x()
  {
    this.n.c().observe(getViewLifecycleOwner(), new GuildLiveChannelChatFragment.1(this));
  }
  
  private void y()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("configXPanelContainerPaddingTop mLiveChannelAIOListener = ");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append(", mRootView = ");
    ((StringBuilder)localObject).append(this.h);
    QLog.d("GuildLiveChannelChatFra", 4, ((StringBuilder)localObject).toString());
    if (this.n != null)
    {
      if (this.h == null) {
        return;
      }
      localObject = this.h.findViewById(2131445137);
      if ((localObject instanceof GuildLiveChannelXPanelContainer)) {
        ((GuildLiveChannelXPanelContainer)localObject).setPaddingTop(this.n.cu_());
      }
    }
  }
  
  private void z()
  {
    QLog.d("GuildLiveChannelChatFra", 4, "configLiveChannelPieAioListener");
    if ((this.c != null) && ((this.c instanceof GuildLiveChannelChatPie))) {
      ((GuildLiveChannelChatPie)this.c).a(this.n);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      this.o = new GuildLiveChannelChatFragment.2(this, paramInt1, paramInt2);
      return;
    }
    GuildInputBarHelper localGuildInputBarHelper = (GuildInputBarHelper)this.c.q(145);
    if ((localGuildInputBarHelper instanceof GuildLiveChannelInputBarHelper)) {
      ((GuildLiveChannelInputBarHelper)localGuildInputBarHelper).c(paramInt1, paramInt2);
    }
    localGuildInputBarHelper.n();
    ((AIOGuildLiveDTReportHelper)this.c.q(101)).f();
  }
  
  public void a(IQQGuildLiveAIOListener paramIQQGuildLiveAIOListener)
  {
    this.n = paramIQQGuildLiveAIOListener;
  }
  
  public void d()
  {
    this.f.setChatFragmentType(BaseActivity.GUILD_LIVE_CHAT_FRAGMENT_TYPE);
  }
  
  public void e()
  {
    QLog.i("GuildLiveChannelChatFra", 4, "refreshStatusBar do nothing.");
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean i()
  {
    return super.i();
  }
  
  public void l()
  {
    t();
    super.l();
    z();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = new GuildLiveChatPieCache();
    this.b.a(this.f);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildLiveChannelChatFra", 2, "onCreateView");
    }
    StartupTracker.a(null, "AIO_onCreateView");
    if (this.h == null)
    {
      this.h = new GuildLiveChatFragmentTopGestureLayout(this.f);
      try
      {
        paramLayoutInflater = View.inflate(this.f, 2131624409, null);
        this.h.addView(paramLayoutInflater);
        a(false);
        this.i = true;
        if (!QLog.isColorLevel()) {
          break label131;
        }
        QLog.i("GuildLiveChannelChatFra", 2, "onCreateView mRootView == null");
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.i("GuildLiveChannelChatFra", 1, "onCreateView:", paramLayoutInflater);
        return null;
      }
    }
    else if (this.h.getParent() != null)
    {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
    }
    label131:
    w();
    v();
    y();
    x();
    StartupTracker.a("AIO_onCreateView", null);
    return this.h;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    t();
    super.onViewCreated(paramView, paramBundle);
    z();
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatFragment
 * JD-Core Version:    0.7.0.1
 */