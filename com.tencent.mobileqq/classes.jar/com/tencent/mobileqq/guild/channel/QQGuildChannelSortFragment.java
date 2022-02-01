package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class QQGuildChannelSortFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private static Field t;
  private OverScrollRecyclerView o;
  private QQGuildChannelSortFragment.QQGuildChannelListAdapter p;
  private final List<GuildChannelInfoUIData> q = new ArrayList();
  private String r;
  private QQGuildChannelSortFragment.ChannelSortDragTouchCallBack s;
  private ItemTouchHelper u;
  private List<IGProChannelInfo> v = new ArrayList();
  private long w = 0L;
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(paramContext, 1, paramContext.getResources().getString(2131889041), 1).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_guild_id", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelSortFragment.class);
  }
  
  private static float b(ItemTouchHelper paramItemTouchHelper)
  {
    Field localField = t;
    if (localField != null) {
      try
      {
        localField.setAccessible(true);
        float f = t.getFloat(paramItemTouchHelper);
        return f;
      }
      catch (IllegalAccessException paramItemTouchHelper)
      {
        QLog.e("QQGuildChannelListSettingFragment", 1, paramItemTouchHelper, new Object[0]);
      }
    }
    return 0.0F;
  }
  
  private void b(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.o.getLayoutParams()).topMargin = paramInt;
  }
  
  private void i()
  {
    this.r = getActivity().getIntent().getStringExtra("extra_guild_id");
    this.p = new QQGuildChannelSortFragment.QQGuildChannelListAdapter();
    this.o.setAdapter(this.p);
    j();
  }
  
  private void j()
  {
    List localList1 = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.r);
    ArrayList localArrayList = new ArrayList();
    if (localList1 != null)
    {
      int i = 0;
      int j = 0;
      while (i < localList1.size())
      {
        ICategoryInfo localICategoryInfo = (ICategoryInfo)localList1.get(i);
        List localList2 = localICategoryInfo.c();
        Object localObject;
        if (!TextUtils.isEmpty(localICategoryInfo.a()))
        {
          localObject = new GuildChannelInfoUIData();
          ((GuildChannelInfoUIData)localObject).a = 1;
          ((GuildChannelInfoUIData)localObject).b = localICategoryInfo.a();
          ((GuildChannelInfoUIData)localObject).e = localICategoryInfo.b();
          localArrayList.add(localObject);
        }
        else
        {
          this.w = localICategoryInfo.b();
          j = 1;
        }
        int k = 0;
        while ((localList2 != null) && (k < localList2.size()))
        {
          localObject = (IGProChannelInfo)localList2.get(k);
          if (((IGProChannelInfo)localObject).getType() == 3)
          {
            this.v.add(localObject);
          }
          else
          {
            GuildChannelInfoUIData localGuildChannelInfoUIData = new GuildChannelInfoUIData();
            localGuildChannelInfoUIData.a = 0;
            localGuildChannelInfoUIData.c = ((IGProChannelInfo)localObject);
            localGuildChannelInfoUIData.b = localICategoryInfo.a();
            localGuildChannelInfoUIData.e = localICategoryInfo.b();
            localArrayList.add(localGuildChannelInfoUIData);
          }
          k += 1;
        }
        i += 1;
      }
      if (j != 0) {
        b((int)(DeviceInfoUtil.a * 12.0F));
      } else {
        b(0);
      }
    }
    this.q.clear();
    this.q.addAll(localArrayList);
    this.p.a(this.q);
  }
  
  private void k()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < this.v.size())
    {
      localArrayList2.add(((IGProChannelInfo)this.v.get(i)).getChannelUin());
      i += 1;
    }
    Object localObject = null;
    i = j;
    while (i < this.q.size())
    {
      GuildChannelInfoUIData localGuildChannelInfoUIData = (GuildChannelInfoUIData)this.q.get(i);
      if (localGuildChannelInfoUIData.a == 1)
      {
        String str = localGuildChannelInfoUIData.b;
        if (localObject != null) {
          localArrayList1.add(localObject);
        }
        localObject = new CategoryChannelSortInfo(str, localGuildChannelInfoUIData.e);
      }
      else if (localObject == null)
      {
        localArrayList2.add(localGuildChannelInfoUIData.c.getChannelUin());
      }
      else
      {
        ((CategoryChannelSortInfo)localObject).a(localGuildChannelInfoUIData.c.getChannelUin());
      }
      i += 1;
    }
    if (localObject != null) {
      localArrayList1.add(localObject);
    }
    localObject = new CategoryChannelSortInfo("", this.w, localArrayList2);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setChannelCategoryInfo(this.r, (CategoryChannelSortInfo)localObject, localArrayList1, new QQGuildChannelSortFragment.1(this));
  }
  
  private void m()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_channel_sort");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.r, null);
  }
  
  private void n()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.d, "em_sgrp_channel_sort_submit", null);
  }
  
  private void o()
  {
    try
    {
      if (t == null)
      {
        t = ItemTouchHelper.class.getDeclaredField("mInitialTouchX");
        return;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d.setOnClickListener(this);
    this.d.setText(getContext().getString(2131888784));
    this.d.setVisibility(0);
    a(getResources().getString(2131890334));
    this.a.setText(2131887648);
    this.a.setOnClickListener(this);
    this.o = ((OverScrollRecyclerView)this.l.findViewById(2131434571));
    paramLayoutInflater = new RecycleViewDivider(getContext(), 0, 1, getResources().getColor(2131166203));
    paramLayoutInflater.a((int)(DeviceInfoUtil.a * 16.0F), 0);
    this.o.addItemDecoration(paramLayoutInflater);
    this.s = new QQGuildChannelSortFragment.ChannelSortDragTouchCallBack(this.o, this.q);
    o();
    this.u = new ItemTouchHelper(this.s);
    this.u.attachToRecyclerView(this.o);
    this.s.a(this.u);
    paramLayoutInflater = new LinearLayoutManager(getContext());
    this.o.setLayoutManager(paramLayoutInflater);
    paramLayoutInflater = new DefaultItemAnimator();
    paramLayoutInflater.setSupportsChangeAnimations(false);
    this.o.setItemAnimator(paramLayoutInflater);
    i();
    m();
    n();
  }
  
  protected int b()
  {
    return 2131625007;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a) {
      getActivity().finish();
    } else if (paramView == this.d) {
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelSortFragment
 * JD-Core Version:    0.7.0.1
 */