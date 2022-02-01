package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQGuildChannelListSettingFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private QQCustomDialog A;
  private GPServiceObserver B = new QQGuildChannelListSettingFragment.2(this);
  private ItemTouchHelper C;
  private boolean D;
  private List<IGProChannelInfo> E = new ArrayList();
  private long F = 0L;
  public QQGuildObserver o = new QQGuildChannelListSettingFragment.1(this);
  private OverScrollRecyclerView p;
  private QQGuildChannelListSettingFragment.QQGuildChannelListAdapter q;
  private final List<GuildChannelInfoUIData> r = new ArrayList();
  private String s;
  private ImageView t;
  private ImageView u;
  private ActionSheet v;
  private ActionSheet w;
  private ActionSheet x;
  private ActionSheet y;
  private ActionSheet z;
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(paramContext, 1, paramContext.getResources().getString(2131889041), 1).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_guild_id", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelListSettingFragment.class);
  }
  
  private void a(GuildChannelInfoUIData paramGuildChannelInfoUIData)
  {
    if (paramGuildChannelInfoUIData == null) {
      return;
    }
    if (this.x == null)
    {
      this.x = ActionSheet.create(getActivity());
      this.x.addButton(2131890313);
      this.x.addButton(2131890315);
      this.x.addButton(2131890314, 3);
      this.x.addCancelButton(getString(2131887648));
    }
    this.x.setOnButtonClickListener(new QQGuildChannelListSettingFragment.5(this, paramGuildChannelInfoUIData));
    this.x.show();
  }
  
  private void a(GuildChannelInfoUIData paramGuildChannelInfoUIData, boolean paramBoolean)
  {
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).removeChannelCategory(this.s, paramGuildChannelInfoUIData.e, paramBoolean, new QQGuildChannelListSettingFragment.8(this));
  }
  
  private void a(List<ICategoryInfo> paramList)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("logCategoryInfo: ");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ICategoryInfo)paramList.next();
      localStringBuilder.append(((ICategoryInfo)localObject).a());
      localStringBuilder.append(":[");
      localObject = ((ICategoryInfo)localObject).c().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((IGProChannelInfo)((Iterator)localObject).next()).getChannelUin());
        localStringBuilder.append(",");
      }
      localStringBuilder.append("], ");
    }
    QLog.i("QQGuildChannelListSettingFragment", 2, localStringBuilder.toString());
  }
  
  private void a(List<String> paramList, List<CategoryChannelSortInfo> paramList1)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("  logSortResult: :[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("], ");
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (CategoryChannelSortInfo)paramList.next();
      localStringBuilder.append(paramList1.a());
      localStringBuilder.append(":[");
      paramList1 = paramList1.c().iterator();
      while (paramList1.hasNext())
      {
        localStringBuilder.append((String)paramList1.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append("], ");
    }
    QLog.i("QQGuildChannelListSettingFragment", 2, localStringBuilder.toString());
  }
  
  private boolean a(IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramIGProChannelInfo.getType() == 2) && (!QQGuildUtil.d())) {
      return true;
    }
    if ((paramIGProChannelInfo.getType() == 5) && (!QQGuildUtil.e(paramIGProChannelInfo.getGuildId()))) {
      return true;
    }
    if (paramIGProChannelInfo.getType() == 6) {}
    return false;
  }
  
  private static void b(View paramView, IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo != null)
    {
      VideoReport.setElementId(paramView, "em_sgrp_channel_mange_channel_click");
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementReuseIdentifier(paramView, paramIGProChannelInfo.getChannelUin());
      HashMap localHashMap = new HashMap();
      localHashMap.put("sgrp_sub_channel_id", paramIGProChannelInfo.getChannelUin());
      VideoReport.setElementParams(paramView, localHashMap);
    }
  }
  
  private void b(GuildChannelInfoUIData paramGuildChannelInfoUIData)
  {
    if (paramGuildChannelInfoUIData.d != 0)
    {
      if (this.y == null)
      {
        this.y = ActionSheet.create(getActivity());
        this.y.addButton(2131890311);
        this.y.addButton(2131890310, 3);
        this.y.addCancelButton(getString(2131887648));
      }
      this.y.setOnButtonClickListener(new QQGuildChannelListSettingFragment.6(this, paramGuildChannelInfoUIData));
      this.y.show();
      return;
    }
    if (this.z == null)
    {
      this.z = ActionSheet.create(getActivity());
      this.z.addButton(2131890311);
      this.z.addCancelButton(getString(2131887648));
    }
    this.z.setOnButtonClickListener(new QQGuildChannelListSettingFragment.7(this, paramGuildChannelInfoUIData));
    this.z.show();
  }
  
  private void c(GuildChannelInfoUIData paramGuildChannelInfoUIData)
  {
    if (this.A == null)
    {
      new DialogUtil();
      this.A = DialogUtil.a(getActivity(), 0, "删除后，会清空频道的聊天记录", "", null, null);
    }
    this.A.setNegativeButton(2131887648, new QQGuildChannelListSettingFragment.9(this));
    this.A.setPositiveButton(2131892267, new QQGuildChannelListSettingFragment.10(this, paramGuildChannelInfoUIData));
    this.A.show();
  }
  
  private void k()
  {
    this.s = getActivity().getIntent().getStringExtra("extra_guild_id");
    this.q = new QQGuildChannelListSettingFragment.QQGuildChannelListAdapter();
    this.q.a(this);
    this.p.setAdapter(this.q);
    Object localObject = new LinearLayoutManager(getContext());
    this.p.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.p.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    m();
  }
  
  private void m()
  {
    Object localObject1 = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.s);
    a((List)localObject1);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < ((List)localObject1).size(); j = k)
      {
        ICategoryInfo localICategoryInfo = (ICategoryInfo)((List)localObject1).get(i);
        List localList = localICategoryInfo.c();
        Object localObject2;
        if (!TextUtils.isEmpty(localICategoryInfo.a()))
        {
          localObject2 = new GuildChannelInfoUIData();
          ((GuildChannelInfoUIData)localObject2).a = 1;
          ((GuildChannelInfoUIData)localObject2).b = localICategoryInfo.a();
          ((GuildChannelInfoUIData)localObject2).e = localICategoryInfo.b();
          if (localList != null) {
            k = localList.size();
          } else {
            k = 0;
          }
          ((GuildChannelInfoUIData)localObject2).d = k;
          localArrayList.add(localObject2);
          if (localList != null)
          {
            k = j;
            if (!localList.isEmpty()) {}
          }
          else
          {
            localObject2 = new GuildChannelInfoUIData();
            ((GuildChannelInfoUIData)localObject2).a = 2;
            localArrayList.add(localObject2);
            k = j;
          }
        }
        else
        {
          this.F = localICategoryInfo.b();
          k = j;
          if (localList != null)
          {
            k = j;
            if (localList.size() > 1) {
              k = 1;
            }
          }
        }
        j = 0;
        while ((localList != null) && (j < localList.size()))
        {
          localObject2 = (IGProChannelInfo)localList.get(j);
          if (((IGProChannelInfo)localObject2).getType() == 3)
          {
            this.E.add(localObject2);
          }
          else if (!a((IGProChannelInfo)localObject2))
          {
            GuildChannelInfoUIData localGuildChannelInfoUIData = new GuildChannelInfoUIData();
            localGuildChannelInfoUIData.a = 0;
            localGuildChannelInfoUIData.c = ((IGProChannelInfo)localObject2);
            localGuildChannelInfoUIData.b = localICategoryInfo.a();
            localGuildChannelInfoUIData.e = localICategoryInfo.b();
            localArrayList.add(localGuildChannelInfoUIData);
          }
          j += 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        localObject1 = new GuildChannelInfoUIData();
        ((GuildChannelInfoUIData)localObject1).a = -1;
        localArrayList.add(0, localObject1);
      }
      localObject1 = new GuildChannelInfoUIData();
      ((GuildChannelInfoUIData)localObject1).a = -1;
      localArrayList.add(localObject1);
    }
    this.r.clear();
    this.r.addAll(localArrayList);
    this.q.a(this.r);
  }
  
  private void n()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = this.E.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(((IGProChannelInfo)((Iterator)localObject1).next()).getChannelUin());
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = null;
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
    {
      GuildChannelInfoUIData localGuildChannelInfoUIData = (GuildChannelInfoUIData)localIterator.next();
      if (localGuildChannelInfoUIData.a == 1)
      {
        localObject1 = new CategoryChannelSortInfo(localGuildChannelInfoUIData.b, localGuildChannelInfoUIData.e);
        localArrayList.add(localObject1);
      }
      else if (localGuildChannelInfoUIData.a == 0)
      {
        if (localObject1 == null) {
          ((ArrayList)localObject2).add(localGuildChannelInfoUIData.c.getChannelUin());
        } else {
          ((CategoryChannelSortInfo)localObject1).a(localGuildChannelInfoUIData.c.getChannelUin());
        }
      }
    }
    a((List)localObject2, localArrayList);
    localObject1 = (IGPSService)l().getRuntimeService(IGPSService.class, "");
    localObject2 = new CategoryChannelSortInfo("", this.F, (List)localObject2);
    ((IGPSService)localObject1).setChannelCategoryInfo(this.s, (CategoryChannelSortInfo)localObject2, localArrayList, new QQGuildChannelListSettingFragment.3(this));
  }
  
  private void o()
  {
    if (this.w == null)
    {
      this.w = ActionSheet.create(getActivity());
      this.w.addButton(2131890274);
      this.w.addButton(2131890334);
      this.w.addCancelButton(getString(2131887648));
      this.w.setOnButtonClickListener(new QQGuildChannelListSettingFragment.11(this));
    }
    this.w.show();
  }
  
  private void p()
  {
    if (this.v == null)
    {
      this.v = ActionSheet.create(getActivity());
      this.v.addButton(2131890308);
      this.v.addButton(2131890309);
      this.v.addCancelButton(getString(2131887648));
      this.v.setOnButtonClickListener(new QQGuildChannelListSettingFragment.12(this));
    }
    this.v.show();
  }
  
  private void q()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_channel_mange");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.s, null);
  }
  
  private void r()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.t, "em_sgrp_channel_mange_create_channel", null);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getResources().getString(2131890565));
    this.p = ((OverScrollRecyclerView)this.l.findViewById(2131434571));
    paramLayoutInflater = new RecycleViewDivider(getContext(), 0, 1, getResources().getColor(2131166203));
    paramLayoutInflater.a((int)(DeviceInfoUtil.a * 16.0F), 0);
    paramLayoutInflater.a(false);
    this.p.addItemDecoration(paramLayoutInflater);
    paramLayoutInflater = (GuildDefaultThemeNavBarCommon)e();
    this.t = ((ImageView)paramLayoutInflater.findViewById(2131436194));
    this.t.setOnClickListener(this);
    this.t.setBackgroundResource(0);
    this.t.setImageResource(2130840752);
    this.t.setVisibility(0);
    ((RelativeLayout.LayoutParams)this.t.getLayoutParams()).rightMargin = ((int)(DeviceInfoUtil.a * 12.0F));
    this.u = ((ImageView)paramLayoutInflater.findViewById(2131436195));
    this.u.setOnClickListener(this);
    this.u.setBackgroundResource(0);
    this.u.setImageResource(2130840766);
    this.u.setVisibility(0);
    ((RelativeLayout.LayoutParams)this.u.getLayoutParams()).rightMargin = ((int)(DeviceInfoUtil.a * 8.0F));
    k();
    q();
    r();
  }
  
  protected int b()
  {
    return 2131625007;
  }
  
  public void i()
  {
    if (this.D) {
      return;
    }
    this.D = true;
    a(getResources().getString(2131890334));
    this.t.setVisibility(8);
    this.u.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setText(getResources().getString(2131888784));
    this.d.setOnClickListener(this);
    super.a(getResources().getString(2131887648), new QQGuildChannelListSettingFragment.4(this));
    this.C = new ItemTouchHelper(new QQGuildChannelListSettingFragment.ChannelSortDragTouchCallBack(this.p, this.r));
    this.C.attachToRecyclerView(this.p);
    this.q.a(this.D);
  }
  
  public void j()
  {
    if (!this.D) {
      return;
    }
    this.D = false;
    a(getResources().getString(2131890565));
    this.t.setVisibility(0);
    this.u.setVisibility(0);
    this.d.setVisibility(8);
    h();
    this.C.attachToRecyclerView(null);
    this.C = null;
    this.q.a(this.D);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 255)
    {
      if (paramInt1 == -1) {
        m();
      }
    }
    else if ((paramInt1 == 256) && (paramInt2 == -1)) {
      m();
    }
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = l();
    paramContext.addObserver(this.o);
    ((IGPSService)paramContext.getRuntimeService(IGPSService.class, "")).addObserver(this.B);
  }
  
  public boolean onBackEvent()
  {
    if (this.D)
    {
      j();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (this.D)
    {
      if (paramView == this.d) {
        n();
      }
    }
    else if (this.t == paramView)
    {
      p();
    }
    else if (this.u == paramView)
    {
      o();
    }
    else if (paramView.getId() == 2131434563)
    {
      a((GuildChannelInfoUIData)paramView.getTag());
    }
    else if (paramView.getId() == 2131434621)
    {
      GuildChannelInfoUIData localGuildChannelInfoUIData = (GuildChannelInfoUIData)paramView.getTag();
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(BaseApplication.getContext(), this.s, localGuildChannelInfoUIData.c, localGuildChannelInfoUIData.b, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.v;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    localObject = this.w;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    localObject = this.x;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    localObject = this.A;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    localObject = this.y;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    localObject = this.z;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    AppInterface localAppInterface = l();
    localAppInterface.removeObserver(this.o);
    ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment
 * JD-Core Version:    0.7.0.1
 */