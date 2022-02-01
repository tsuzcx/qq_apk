package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQGuildInfoFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private TextView o;
  private RelativeLayout p;
  private RelativeLayout q;
  private ImageView r;
  private RelativeLayout s;
  private ImageView t;
  private TextView u;
  private RelativeLayout v;
  private TextView w;
  private QQGuidInfoViewModel x;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("guild_name");
      if (!TextUtils.isEmpty(paramIntent)) {
        this.o.setText(paramIntent);
      }
    }
  }
  
  private void b(@Nullable IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshData GuildId: ");
      localStringBuilder.append(paramIGProGuildInfo.getGuildID());
      localStringBuilder.append(" GuildName: ");
      localStringBuilder.append(paramIGProGuildInfo.getGuildName());
      QLog.i("QQGuildInfoFragment", 2, localStringBuilder.toString());
    }
    this.o.setText(paramIGProGuildInfo.getGuildName());
    if (TextUtils.isEmpty(paramIGProGuildInfo.getProfile())) {
      this.w.setText(getString(2131890573));
    } else {
      this.w.setText(((IGuildEmotionCodecApi)QRoute.api(IGuildEmotionCodecApi.class)).toQQText(paramIGProGuildInfo.getProfile(), 20));
    }
    c(paramIGProGuildInfo);
    d(paramIGProGuildInfo);
  }
  
  private void c(@NonNull IGProGuildInfo paramIGProGuildInfo)
  {
    paramIGProGuildInfo = paramIGProGuildInfo.getAvatarUrl(0);
    int i = (int)(DeviceInfoUtil.a * 17.0F);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    try
    {
      paramIGProGuildInfo = URLDrawable.getDrawable(paramIGProGuildInfo, localURLDrawableOptions);
      paramIGProGuildInfo.setTag(new int[] { i, i });
      paramIGProGuildInfo.setDecodeHandler(QQGuildUtil.b);
      this.r.setImageDrawable(paramIGProGuildInfo);
      return;
    }
    catch (Exception paramIGProGuildInfo)
    {
      QLog.e("QQGuildInfoFragment", 1, paramIGProGuildInfo, new Object[0]);
    }
  }
  
  private void d(@NonNull IGProGuildInfo paramIGProGuildInfo)
  {
    paramIGProGuildInfo = paramIGProGuildInfo.getCoverUrl(0, 0);
    int i = (int)(DeviceInfoUtil.a * 64.0F);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    try
    {
      if (TextUtils.isEmpty(paramIGProGuildInfo))
      {
        this.t.setVisibility(4);
        this.u.setVisibility(0);
        return;
      }
      this.t.setVisibility(0);
      this.u.setVisibility(4);
      paramIGProGuildInfo = URLDrawable.getDrawable(paramIGProGuildInfo, localURLDrawableOptions);
      paramIGProGuildInfo.setTag(new int[] { i, i });
      paramIGProGuildInfo.setDecodeHandler(QQGuildUtil.d);
      this.t.setImageDrawable(paramIGProGuildInfo);
      return;
    }
    catch (Exception paramIGProGuildInfo)
    {
      QLog.e("QQGuildInfoFragment", 1, paramIGProGuildInfo, new Object[0]);
    }
  }
  
  private void j()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.b.setText("");
    this.c.setText(getString(2131916347));
    this.o = ((TextView)this.l.findViewById(2131435782));
    this.p = ((RelativeLayout)this.l.findViewById(2131434736));
    this.p.setOnClickListener(this);
    this.q = ((RelativeLayout)this.l.findViewById(2131434543));
    this.q.setOnClickListener(this);
    this.r = ((ImageView)this.l.findViewById(2131434544));
    this.s = ((RelativeLayout)this.l.findViewById(2131434589));
    this.s.setOnClickListener(this);
    this.t = ((ImageView)this.l.findViewById(2131434591));
    this.u = ((TextView)this.l.findViewById(2131434590));
    this.w = ((TextView)this.l.findViewById(2131434727));
    this.v = ((RelativeLayout)this.l.findViewById(2131434609));
    this.v.setOnClickListener(this);
  }
  
  private void k()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.p, "em_sgrp_profile_mange_name", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.q, "em_sgrp_profile_mange_portrait", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.v, "em_sgrp_profile_mange_introduction", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.s, "em_sgrp_profile_mange_cover", null);
  }
  
  void a(Context paramContext)
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildAvatarSetting(paramContext, (IGProGuildInfo)this.x.a().getValue());
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    j();
    this.x = ((QQGuidInfoViewModel)ViewModelProviderHelper.a(this, QQGuidInfoViewModel.a).get(QQGuidInfoViewModel.class));
    paramLayoutInflater = ((IGProGuildInfo)getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info")).getGuildID();
    this.x.a(paramLayoutInflater, l());
    i();
    k();
    this.x.a().observe(getViewLifecycleOwner(), new QQGuildInfoFragment.1(this));
  }
  
  protected int b()
  {
    return 2131625045;
  }
  
  void b(Context paramContext)
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildNameSetting(paramContext, (IGProGuildInfo)this.x.a().getValue());
  }
  
  void c(Context paramContext)
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildCoverSetting(paramContext, (IGProGuildInfo)this.x.a().getValue());
  }
  
  void d(Context paramContext)
  {
    if (this.x.a().getValue() != null) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildIntroSetting(paramContext, ((IGProGuildInfo)this.x.a().getValue()).getGuildID(), ((IGProGuildInfo)this.x.a().getValue()).getProfile());
    }
  }
  
  void i()
  {
    IGProGuildInfo localIGProGuildInfo = (IGProGuildInfo)this.x.a().getValue();
    if (localIGProGuildInfo == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_profile_mange");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, localIGProGuildInfo.getGuildID(), null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 255) {
      a(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != this.a) && (paramView != this.b))
    {
      if (paramView == this.p) {
        b(getActivity());
      } else if (paramView == this.q) {
        a(getActivity());
      } else if (paramView == this.s) {
        c(getActivity());
      } else if (paramView == this.v) {
        d(getActivity());
      }
    }
    else {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildInfoFragment
 * JD-Core Version:    0.7.0.1
 */