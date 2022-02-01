package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.kandian.biz.channel.banner.ChannelBottomBanner;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.MoreChannelItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyChannelPanelFragment
  extends RIJBaseChannelPanelFragment
{
  protected ReadInJoyObserver d = new ReadInJoyChannelPanelFragment.3(this);
  private ReadInJoyDynamicGridView e;
  private RIJDynamicChannelGridViewAdapter f;
  private TextView g;
  private LinearLayout h;
  private final ArrayList<ReadInJoyStaticGridView> i = new ArrayList(5);
  private ChannelBottomBanner j;
  private TextView k;
  private boolean l;
  private boolean m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private int q;
  private List<ChannelSection> r;
  private Map<Integer, TabChannelCoverInfo> s;
  private ReadInJoyLogicEngine t;
  private ViewTreeObserver.OnPreDrawListener u;
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localTranslateAnimation.setDuration(300L);
    if (paramView != null) {
      paramView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void a(int paramInt)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "switchEditMode, position = ", Integer.valueOf(paramInt), ", mIsEditMode = ", Boolean.valueOf(this.n), ", mIsEditMovingMode = ", Boolean.valueOf(this.o) });
    this.f.a(this.n);
    Object localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)((Iterator)localObject).next()).getAdapter()).a(this.n);
    }
    if (this.n)
    {
      this.g.setText(2131915369);
      this.c.setText(2131915239);
      if (this.o) {
        this.e.a(paramInt);
      } else {
        this.e.a();
      }
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    localObject = this.r;
    if ((localObject != null) && (((List)localObject).size() > 0) && (this.r.get(0) != null)) {
      this.g.setText(((ChannelSection)this.r.get(0)).c);
    }
    this.c.setText(2131915240);
    this.e.a();
    k();
    localObject = this.f;
    if (localObject != null) {
      a((TabChannelCoverInfo)((RIJDynamicChannelGridViewAdapter)localObject).getItem(this.q));
    }
    if (this.m) {
      this.k.setVisibility(0);
    }
    if (this.l) {
      this.j.setVisibility(0);
    }
  }
  
  private void a(ChannelSection paramChannelSection, int paramInt)
  {
    Object localObject = this.t.d(paramInt);
    RIJStaticChannelGridViewAdapter localRIJStaticChannelGridViewAdapter = new RIJStaticChannelGridViewAdapter(getBaseActivity(), 4, this.a, new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback(this, paramChannelSection.a));
    localRIJStaticChannelGridViewAdapter.c((List)localObject);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getBaseActivity()).inflate(2131626151, this.h, false);
    localObject = (ReadInJoyStaticGridView)localRelativeLayout.findViewById(2131444427);
    ((ReadInJoyStaticGridView)localObject).setExpendable(true);
    ((ReadInJoyStaticGridView)localObject).setEditModeEnabled(false);
    ((ReadInJoyStaticGridView)localObject).setAdapter(localRIJStaticChannelGridViewAdapter);
    ((ReadInJoyStaticGridView)localObject).setTag(Long.valueOf(paramChannelSection.a));
    this.h.addView(localRelativeLayout);
    ((TextView)localRelativeLayout.findViewById(2131444428)).setText(paramChannelSection.b);
    ((TextView)localRelativeLayout.findViewById(2131444426)).setText(paramChannelSection.c);
    paramChannelSection = localRelativeLayout.findViewById(2131444425);
    ((ReadInJoyStaticGridView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ReadInJoyChannelPanelFragment.2(this, (ReadInJoyStaticGridView)localObject, paramChannelSection));
    this.i.add(localObject);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpToChannelPage, info: ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    if (paramTabChannelCoverInfo != null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().k();
      ReadInJoyLogicEngineEventDispatcher.a().a(paramTabChannelCoverInfo);
      ChannelCoverView.a("0X8007F02", paramTabChannelCoverInfo, ChannelCoverView.b);
    }
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateChannelInfoReason, tabInfo = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    this.p = true;
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo.reason = 2;
    }
  }
  
  private void f()
  {
    this.q = getBaseActivity().getIntent().getIntExtra("currentIndex", 0);
    this.r = this.t.H();
    this.s = new HashMap();
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "initData, currentIndex = ", Integer.valueOf(this.q) });
  }
  
  private void g()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().i();
    if (localBannerInfoModule != null)
    {
      a(localBannerInfoModule.a(2000000000));
      ThreadManager.getUIHandler().post(new ReadInJoyChannelPanelFragment.1(this, localBannerInfoModule));
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void h()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131430511);
    this.h = ((LinearLayout)this.b.findViewById(2131444446));
    this.g = ((TextView)this.b.findViewById(2131439096));
    this.k = ((TextView)this.b.findViewById(2131438857));
    this.e = ((ReadInJoyDynamicGridView)this.b.findViewById(2131439097));
    if (this.j == null)
    {
      this.j = new ChannelBottomBanner(getBaseActivity());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(getBaseActivity(), 18.0F);
      if (ChannelModeConfigHandler.a()) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(getBaseActivity(), 18.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131438857);
      localRelativeLayout.addView(this.j, (ViewGroup.LayoutParams)localObject);
    }
    this.f = new RIJDynamicChannelGridViewAdapter(getBaseActivity(), 4, this.a, new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback(this, null), this.q);
    this.f.c(this.t.J());
    Object localObject = this.e;
    int i2 = 1;
    ((ReadInJoyDynamicGridView)localObject).setExpendable(true);
    this.e.setAdapter(this.f);
    localObject = this.r;
    if (localObject != null)
    {
      int i1 = i2;
      if (((List)localObject).size() > 0)
      {
        this.g.setText(((ChannelSection)this.r.get(0)).c);
        i1 = i2;
      }
      while (i1 < this.r.size())
      {
        a((ChannelSection)this.r.get(i1), i1);
        i1 += 1;
      }
    }
    this.g.setText(HardCodeUtil.a(2131910244));
    localRelativeLayout.setClipChildren(false);
  }
  
  private void i()
  {
    this.t = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  private void j()
  {
    this.e.setOnItemLongClickListener(this.f);
    this.e.setOnItemClickListener(this.f);
    this.e.setOnDropListener(this.f);
    this.e.setOnDragListener(this.f);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localIterator.next();
      localReadInJoyStaticGridView.setOnItemClickListener((AdapterView.OnItemClickListener)localReadInJoyStaticGridView.getAdapter());
    }
  }
  
  private void k()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[updateChannelInfoListToCacheDBAndServer] ");
    if (this.p)
    {
      Object localObject = this.r;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new ArrayList();
        ChannelSection localChannelSection = new ChannelSection(((ChannelSection)this.r.get(0)).a, ((ChannelSection)this.r.get(0)).b, ((ChannelSection)this.r.get(0)).c);
        localChannelSection.d = this.f.d();
        ((List)localObject).add(localChannelSection);
        int i1 = 1;
        while (i1 < this.r.size())
        {
          localChannelSection = new ChannelSection(((ChannelSection)this.r.get(i1)).a, ((ChannelSection)this.r.get(i1)).b, ((ChannelSection)this.r.get(i1)).c);
          localChannelSection.d = ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)this.i.get(i1 - 1)).getAdapter()).d();
          ((List)localObject).add(localChannelSection);
          i1 += 1;
        }
        this.t.a((List)localObject, 1, true);
        this.p = false;
        return;
      }
    }
    QLog.d("ReadInJoyChannelPanelFragment", 1, "mHasChanged = false, do not need to update channel info list.");
  }
  
  private void l()
  {
    Object localObject = this.s;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.a = false;
        this.t.a(localTabChannelCoverInfo);
      }
    }
    this.t.c(false);
  }
  
  public int a()
  {
    return 2131629128;
  }
  
  protected void a(View paramView)
  {
    this.n ^= true;
    a(-1);
    RIJChannelReporter.a("0X8009498", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().build());
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshBanner, bannerInfo = ");
    localStringBuilder.append(paramTopBannerInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    if (paramTopBannerInfo == null)
    {
      this.l = false;
      this.m = false;
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    if (paramTopBannerInfo.items.isEmpty())
    {
      this.l = false;
      this.j.setVisibility(8);
    }
    else
    {
      this.l = true;
      this.j.setVisibility(0);
      this.j.a(null, paramTopBannerInfo);
    }
    if (paramTopBannerInfo.moreChannelItem != null)
    {
      this.m = true;
      this.k.setVisibility(0);
      this.k.setText(paramTopBannerInfo.moreChannelItem.a);
      paramTopBannerInfo = paramTopBannerInfo.moreChannelItem.b;
      this.k.setOnClickListener(new ReadInJoyChannelPanelFragment.4(this, paramTopBannerInfo));
      return;
    }
    this.m = false;
    this.k.setVisibility(8);
  }
  
  public float[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    float[] arrayOfFloat = new float[2];
    if ((paramArrayOfInt1.length >= 2) && (paramArrayOfInt2.length >= 2))
    {
      arrayOfFloat[0] = (paramArrayOfInt1[0] - paramArrayOfInt2[0]);
      arrayOfFloat[1] = (paramArrayOfInt1[1] - paramArrayOfInt2[1]);
    }
    return arrayOfFloat;
  }
  
  public String b()
  {
    return getString(2131915220);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.d);
    RIJDtReportHelper.a.a(getBaseActivity(), "16");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    f();
    h();
    g();
    j();
    VideoReport.setPageId(this.b, "16");
    VideoReport.setPageParams(this.b, new RIJDtParamBuilder().b());
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    return this.b;
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.d);
    super.onDestroy();
    l();
    this.t = null;
  }
  
  public void onFinish()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[onFinish] ");
    super.onFinish();
    if (this.p) {
      k();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ChannelBottomBanner localChannelBottomBanner = this.j;
    if (localChannelBottomBanner != null) {
      localChannelBottomBanner.d();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ChannelBottomBanner localChannelBottomBanner = this.j;
    if (localChannelBottomBanner != null) {
      localChannelBottomBanner.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */