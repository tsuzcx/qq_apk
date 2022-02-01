package com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.subtopbar.QQGuildLiveBaseSubTopBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider;
import com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.GuildProfileUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import java.math.BigDecimal;

public class QQGuildSubTopBarLiveFragment
  extends QQGuildLiveBaseSubTopBarFragment
  implements View.OnClickListener
{
  private TextView a;
  private TextView d;
  private RoundCornerImageView e;
  private TipsBar f;
  private final NetworkState.NetworkStateListener g = new QQGuildSubTopBarLiveFragment.1(this);
  private QQGuildAnchorInfoVM h;
  private View i;
  
  private void a(int paramInt)
  {
    if (paramInt >= 10000)
    {
      double d1 = BigDecimal.valueOf(paramInt / 10000).setScale(1, 4).doubleValue();
      this.a.setText(getString(2131890411, new Object[] { String.valueOf(d1) }));
      return;
    }
    this.a.setText(getString(2131890410, new Object[] { String.valueOf(paramInt) }));
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 15))
    {
      this.d.setText(paramString.substring(0, 15));
      this.d.append("...");
      return;
    }
    this.d.setText(paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.i;
    if (localView != null)
    {
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 4;
      }
      localView.setVisibility(j);
    }
  }
  
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildSubTopBarLiveFragment();
  }
  
  private void e()
  {
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if ((localObject != null) && (((IGProGuildInfo)localObject).isMember()))
    {
      if (getActivity() != null)
      {
        localObject = QQGuildLiveStartParamsCache.a().getChannelInfo();
        if ((localObject != null) && (((IGProChannelInfo)localObject).getLiveAnchorTinyId() > 0L))
        {
          localObject = new GuildProfileData(((IGProChannelInfo)localObject).getGuildId(), ((IGProChannelInfo)localObject).getChannelUin(), String.valueOf(((IGProChannelInfo)localObject).getLiveAnchorTinyId()), 2, 4);
          GuildProfileUtils.a(getActivity(), (GuildProfileData)localObject);
          return;
        }
        QLog.e("QGL.QQGuildSubTopBarLiveFragment", 1, "openAnchorProfileCard channelInfo.getLiveAnchorTinyId invalid.");
      }
      return;
    }
    GuildLiveToast.b(2131890553);
  }
  
  private void g()
  {
    if (getActivity() == null) {
      return;
    }
    if (VersionUtils.e())
    {
      getActivity().startActivity(new Intent("android.settings.SETTINGS"));
      return;
    }
    getActivity().startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
  
  protected void a()
  {
    super.a();
    this.h = ((QQGuildAnchorInfoVM)QQGuildLiveViewModelProvider.a(this.b).get(QQGuildAnchorInfoVM.class));
  }
  
  protected void a(@NonNull View paramView)
  {
    this.i = paramView.findViewById(2131434645);
    this.a = ((TextView)paramView.findViewById(2131434649));
    this.d = ((TextView)paramView.findViewById(2131434646));
    this.e = ((RoundCornerImageView)paramView.findViewById(2131434651));
    this.e.setCorner(ImmersiveUtils.dpToPx(10.0F));
    this.e.setOnClickListener(this);
    this.f = ((TipsBar)paramView.findViewById(2131434652));
    this.f.setBarType(4);
    this.f.setTipsText(getString(2131892107));
    this.f.setTipsIcon(getResources().getDrawable(2130839452));
    this.f.setOnClickListener(this);
    paramView = this.f;
    int j;
    if (NetworkState.isNetSupport()) {
      j = 8;
    } else {
      j = 0;
    }
    paramView.setVisibility(j);
  }
  
  protected int b()
  {
    return 2131625059;
  }
  
  protected void cs_()
  {
    this.h.c().observe(getViewLifecycleOwner(), new QQGuildSubTopBarLiveFragment.2(this));
    this.h.b().observe(getViewLifecycleOwner(), new QQGuildSubTopBarLiveFragment.3(this));
    QQGuildLiveRoomUiData.a().f().observe(getViewLifecycleOwner(), new QQGuildSubTopBarLiveFragment.4(this));
    QQGuildLiveRoomUiData.a().c().observe(getViewLifecycleOwner(), new QQGuildSubTopBarLiveFragment.5(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434651) {
      e();
    } else if (paramView.getId() == 2131434652) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPause()
  {
    super.onPause();
    NetworkState.removeListener(this.g);
  }
  
  public void onResume()
  {
    super.onResume();
    NetworkState.addListener(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment
 * JD-Core Version:    0.7.0.1
 */