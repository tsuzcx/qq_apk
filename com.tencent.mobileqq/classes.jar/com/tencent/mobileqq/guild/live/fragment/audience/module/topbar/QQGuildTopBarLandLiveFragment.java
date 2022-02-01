package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveRootControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQGuildTopBarLandLiveFragment
  extends QQGuildLiveBaseTopBarFragment
  implements View.OnClickListener
{
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildTopBarLandLiveFragment();
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  private void j()
  {
    if (getActivity() != null)
    {
      getActivity().setRequestedOrientation(1);
      if ((this.c != null) && (this.c.a() != null)) {
        this.c.a().b(true);
      }
    }
  }
  
  private void k()
  {
    if (getActivity() != null)
    {
      l();
      QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams = QQGuildLiveStartParamsCache.a();
      new GuildShareActionSheet(getActivity(), localQQGuildLiveRoomStartParams.getGuildInfo(), localQQGuildLiveRoomStartParams.getChannelInfo()).a();
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  private void l()
  {
    if (getActivity() != null) {
      getActivity().setRequestedOrientation(1);
    }
  }
  
  protected void a(@NonNull View paramView)
  {
    super.a(paramView);
    paramView.findViewById(2131434662).setOnClickListener(this);
    paramView.findViewById(2131434664).setOnClickListener(this);
    paramView.findViewById(2131434666).setOnClickListener(this);
  }
  
  protected int b()
  {
    return 2131625061;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434662) {
      l();
    } else if (paramView.getId() == 2131434666) {
      k();
    } else if (paramView.getId() == 2131434664) {
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLandLiveFragment
 * JD-Core Version:    0.7.0.1
 */