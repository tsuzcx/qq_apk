package com.tencent.mobileqq.guild.channel.create.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.create.AnimateHelper;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelPageListener;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppPreviewDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQGuildSubChannelCreateMainFragment
  extends BaseCreateSubChannelFragment
  implements View.OnClickListener, QQGuildAppChannelPageListener
{
  private ViewGroup d;
  private TextView e;
  private RelativeLayout f;
  private View g;
  private RelativeLayout h;
  private FrameLayout i;
  private ImageView j;
  private boolean k = false;
  
  private int a(int paramInt)
  {
    if (paramInt == 2131430522) {
      return 1;
    }
    if (paramInt == 2131430524) {
      return 2;
    }
    if (paramInt == 2131434597) {
      return 3;
    }
    if (paramInt == 2131430515) {
      return 4;
    }
    return 0;
  }
  
  public static QQGuildSubChannelCreateMainFragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildSubChannelCreateMainFragment localQQGuildSubChannelCreateMainFragment = new QQGuildSubChannelCreateMainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildSubChannelCreateMainFragment.setArguments(localBundle);
    return localQQGuildSubChannelCreateMainFragment;
  }
  
  private void a(View paramView)
  {
    this.k = true;
    int m = this.d.getMeasuredHeight();
    if (this.b.d == 6)
    {
      this.e.setText("应用子频道");
      m = i();
    }
    else
    {
      this.e.setText("创建子频道");
      AnimateHelper.a(paramView, this.j, true, 300L);
    }
    paramView = ValueAnimator.ofInt(new int[] { this.f.getMeasuredHeight(), m });
    paramView.addUpdateListener(new QQGuildSubChannelCreateMainFragment.1(this));
    paramView.setDuration(300L);
    paramView.start();
    paramView = ObjectAnimator.ofFloat(this.h, "alpha", new float[] { 1.0F, 0.0F });
    paramView.setDuration(300L);
    paramView.addListener(new QQGuildSubChannelCreateMainFragment.2(this));
    paramView.start();
    paramView = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(300L);
    paramView.addListener(new QQGuildSubChannelCreateMainFragment.3(this));
    paramView.start();
  }
  
  private void a(View paramView, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_sub_channel_type", Integer.valueOf(a(paramInt)));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView, "em_sgrp_select_channel", localHashMap);
  }
  
  private Bundle c(@Nullable IAppInfo paramIAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("appId", paramIAppInfo.a());
    localBundle.putString("iconUrl", paramIAppInfo.b());
    localBundle.putString("appName", paramIAppInfo.c());
    localBundle.putString("appDescription", paramIAppInfo.d());
    localBundle.putStringArrayList("previewUrls", new ArrayList(paramIAppInfo.e()));
    return localBundle;
  }
  
  private void d()
  {
    QQGuildSubChannelCreateFragment localQQGuildSubChannelCreateFragment = QQGuildSubChannelCreateFragment.a(this.b);
    getChildFragmentManager().beginTransaction().replace(2131439287, localQQGuildSubChannelCreateFragment).commit();
    localQQGuildSubChannelCreateFragment.a(this.c);
  }
  
  private void e()
  {
    h();
    QQGuildAppChannelListFragment localQQGuildAppChannelListFragment = QQGuildAppChannelListFragment.a(this.b);
    getChildFragmentManager().beginTransaction().replace(2131439287, localQQGuildAppChannelListFragment).commit();
    localQQGuildAppChannelListFragment.a(this);
    localQQGuildAppChannelListFragment.a(this.c);
  }
  
  private void f()
  {
    boolean bool2 = QQGuildUtil.d();
    Object localObject1 = (CreateSubChannelInfo)getArguments().getParcelable("extra_key_subchannel_info");
    Object localObject2 = Boolean.valueOf(true);
    boolean bool1;
    if ((localObject1 != null) && (QQGuildUtil.e(((CreateSubChannelInfo)localObject1).a))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject1 = new Object[4][];
    localObject1[0] = { localObject2, Integer.valueOf(2131430522), Integer.valueOf(2131430521), Integer.valueOf(2130840767), Integer.valueOf(2131890346) };
    localObject1[1] = { Boolean.valueOf(bool2), Integer.valueOf(2131430524), Integer.valueOf(2131430523), Integer.valueOf(2130840788), Integer.valueOf(2131890347) };
    localObject1[2] = { Boolean.valueOf(bool1), Integer.valueOf(2131434597), Integer.valueOf(2131434596), Integer.valueOf(2130840780), Integer.valueOf(2131890345) };
    localObject1[3] = { localObject2, Integer.valueOf(2131430515), Integer.valueOf(2131430514), Integer.valueOf(2130840779), Integer.valueOf(2131890344) };
    localObject2 = new LinearLayout[4];
    localObject2[0] = ((LinearLayout)this.d.findViewById(2131430517));
    localObject2[1] = ((LinearLayout)this.d.findViewById(2131430518));
    localObject2[2] = ((LinearLayout)this.d.findViewById(2131430519));
    localObject2[3] = ((LinearLayout)this.d.findViewById(2131430520));
    int i2 = localObject1.length;
    int n = 0;
    int i1;
    for (int m = 0;; m = i1)
    {
      i1 = m;
      if (n >= i2) {
        break;
      }
      Object localObject3 = localObject1[n];
      i1 = m;
      if (((Boolean)localObject3[0]).booleanValue())
      {
        View localView = localObject2[m];
        ImageView localImageView = (ImageView)localView.getChildAt(0);
        TextView localTextView = (TextView)localView.getChildAt(1);
        localView.setId(((Integer)localObject3[1]).intValue());
        localView.setOnClickListener(this);
        localImageView.setId(((Integer)localObject3[2]).intValue());
        localImageView.setBackgroundResource(((Integer)localObject3[3]).intValue());
        localTextView.setText(((Integer)localObject3[4]).intValue());
        a(localView, localView.getId());
        i1 = m + 1;
      }
      n += 1;
    }
    while (i1 < localObject2.length)
    {
      ((ShadowFrameLayout)localObject2[i1].getParent()).setVisibility(4);
      i1 += 1;
    }
  }
  
  private void g()
  {
    this.d = ((ViewGroup)this.a.findViewById(2131435318));
    this.e = ((TextView)this.a.findViewById(2131447585));
    j();
    f();
    this.f = ((RelativeLayout)this.a.findViewById(2131435277));
    this.g = this.a.findViewById(2131430777);
    this.h = ((RelativeLayout)this.a.findViewById(2131449019));
    this.i = ((FrameLayout)this.a.findViewById(2131439287));
    this.j = ((ImageView)this.a.findViewById(2131428362));
    this.g.setOnClickListener(this);
  }
  
  private void h()
  {
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    localLayoutParams.height = this.d.getMeasuredHeight();
    this.d.setLayoutParams(localLayoutParams);
  }
  
  private int i()
  {
    int n = this.d.getMeasuredHeight();
    List localList = ((IGPSService)a().getRuntimeService(IGPSService.class, "")).getAppInfoList();
    int m = n;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return n;
      }
      m = (localList.size() + 1) / 2;
      int i1 = ViewUtils.dip2px(79.0F);
      int i2 = ViewUtils.dip2px(199.0F);
      int i3 = ViewUtils.dip2px(304.0F);
      m = Math.max(Math.min(n, i1 + i2 * m), i3);
    }
    return m;
  }
  
  private void j()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.d, "pg_sgrp_select_channel");
    VideoReport.setPageContentId(this.d, "QQGuildSubChannelCreateMainFragment");
    HashMap localHashMap = new HashMap();
    int m;
    if (this.b.c == "main_setting") {
      m = 1;
    } else {
      m = 2;
    }
    localHashMap.put("sgrp_pg_create_source", Integer.valueOf(m));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.d, this.b.a, localHashMap);
  }
  
  public void a(@Nullable IAppInfo paramIAppInfo)
  {
    this.b.a(c(paramIAppInfo));
    paramIAppInfo = QQGuildAppSubChannelCreateDialogFragment.b(this.b);
    paramIAppInfo.a(this.c);
    paramIAppInfo.show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "QQGuildAppSubChannelCreateDialogFragment");
    this.c.b = Boolean.valueOf(false);
    this.c.a();
  }
  
  protected int b()
  {
    return 2131625128;
  }
  
  public void b(@Nullable IAppInfo paramIAppInfo)
  {
    this.b.a(c(paramIAppInfo));
    paramIAppInfo = QQGuildAppPreviewDialogFragment.b(this.b);
    paramIAppInfo.a(this.c);
    paramIAppInfo.show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "QQGuildAppPreviewDialogFragment");
    this.c.b = Boolean.valueOf(false);
    this.c.a();
  }
  
  protected void c()
  {
    ((IGPSService)a().getRuntimeService(IGPSService.class, "")).refreshAppInfoList();
    g();
  }
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      if ((paramView.getId() == 2131430777) && (this.c != null)) {
        this.c.dismiss();
      }
      if (!this.k) {
        if (paramView.getId() == 2131430522)
        {
          this.b.a(1);
          this.j.setBackgroundResource(2130840767);
          a(this.a.findViewById(2131430521));
        }
        else if (paramView.getId() == 2131430524)
        {
          this.b.a(2);
          this.j.setBackgroundResource(2130840788);
          a(this.a.findViewById(2131430523));
        }
        else if (paramView.getId() == 2131434597)
        {
          this.b.a(5);
          this.j.setBackgroundResource(2130840780);
          a(this.a.findViewById(2131434596));
        }
        else if (paramView.getId() == 2131430515)
        {
          this.b.a(6);
          a(null);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment
 * JD-Core Version:    0.7.0.1
 */