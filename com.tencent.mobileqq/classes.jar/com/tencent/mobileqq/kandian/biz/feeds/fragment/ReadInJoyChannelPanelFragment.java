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
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ReadInJoyDynamicGridView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
  private ChannelBottomBanner jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner;
  private RIJDynamicChannelGridViewAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter;
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
  protected ReadInJoyObserver a;
  private final ArrayList<ReadInJoyStaticGridView> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private List<ChannelSection> jdField_a_of_type_JavaUtilList;
  private Map<Integer, TabChannelCoverInfo> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  
  public ReadInJoyChannelPanelFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyChannelPanelFragment.3(this);
  }
  
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
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "switchEditMode, position = ", Integer.valueOf(paramInt), ", mIsEditMode = ", Boolean.valueOf(this.jdField_c_of_type_Boolean), ", mIsEditMovingMode = ", Boolean.valueOf(this.d) });
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter.a(this.jdField_c_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)((Iterator)localObject).next()).getAdapter()).a(this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717895);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717764);
      if (this.d) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.a(paramInt);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0) && (this.jdField_a_of_type_JavaUtilList.get(0) != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717765);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.a();
    g();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter;
    if (localObject != null) {
      a((TabChannelCoverInfo)((RIJDynamicChannelGridViewAdapter)localObject).getItem(this.jdField_b_of_type_Int));
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.setVisibility(0);
    }
  }
  
  private void a(ChannelSection paramChannelSection, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.b(paramInt);
    RIJStaticChannelGridViewAdapter localRIJStaticChannelGridViewAdapter = new RIJStaticChannelGridViewAdapter(getBaseActivity(), 4, this.jdField_a_of_type_Int, new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback(this, paramChannelSection.jdField_a_of_type_Long));
    localRIJStaticChannelGridViewAdapter.c((List)localObject);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getBaseActivity()).inflate(2131560104, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localObject = (ReadInJoyStaticGridView)localRelativeLayout.findViewById(2131376219);
    ((ReadInJoyStaticGridView)localObject).setExpendable(true);
    ((ReadInJoyStaticGridView)localObject).setEditModeEnabled(false);
    ((ReadInJoyStaticGridView)localObject).setAdapter(localRIJStaticChannelGridViewAdapter);
    ((ReadInJoyStaticGridView)localObject).setTag(Long.valueOf(paramChannelSection.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout);
    ((TextView)localRelativeLayout.findViewById(2131376220)).setText(paramChannelSection.jdField_a_of_type_JavaLangString);
    ((TextView)localRelativeLayout.findViewById(2131376218)).setText(paramChannelSection.b);
    paramChannelSection = localRelativeLayout.findViewById(2131376217);
    ((ReadInJoyStaticGridView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ReadInJoyChannelPanelFragment.2(this, (ReadInJoyStaticGridView)localObject, paramChannelSection));
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
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
      ChannelCoverView.a("0X8007F02", paramTabChannelCoverInfo, ChannelCoverView.jdField_b_of_type_Int);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Int = getBaseActivity().getIntent().getIntExtra("currentIndex", 0);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "initData, currentIndex = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateChannelInfoReason, tabInfo = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    this.e = true;
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo.reason = 2;
    }
  }
  
  private void c()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().a();
    if (localBannerInfoModule != null)
    {
      a(localBannerInfoModule.a(2000000000));
      ThreadManager.getUIHandler().post(new ReadInJoyChannelPanelFragment.1(this, localBannerInfoModule));
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364467);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376238));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371675));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371482));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView = ((ReadInJoyDynamicGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371676));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner = new ChannelBottomBanner(getBaseActivity());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(getBaseActivity(), 18.0F);
      if (ChannelModeConfigHandler.a()) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(getBaseActivity(), 18.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131371482);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner, (ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter = new RIJDynamicChannelGridViewAdapter(getBaseActivity(), 4, this.jdField_a_of_type_Int, new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback(this, null), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.b());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
    int j = 1;
    ((ReadInJoyDynamicGridView)localObject).setExpendable(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter);
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i = j;
      if (((List)localObject).size() > 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
        i = j;
      }
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        a((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712666));
    localRelativeLayout.setClipChildren(false);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.setOnItemLongClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.setOnDropListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView.setOnDragListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localIterator.next();
      localReadInJoyStaticGridView.setOnItemClickListener((AdapterView.OnItemClickListener)localReadInJoyStaticGridView.getAdapter());
    }
  }
  
  private void g()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[updateChannelInfoListToCacheDBAndServer] ");
    if (this.e)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new ArrayList();
        ChannelSection localChannelSection = new ChannelSection(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
        localChannelSection.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter.a();
        ((List)localObject).add(localChannelSection);
        int i = 1;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localChannelSection = new ChannelSection(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).b);
          localChannelSection.jdField_a_of_type_JavaUtilList = ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).getAdapter()).a();
          ((List)localObject).add(localChannelSection);
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a((List)localObject, 1, true);
        this.e = false;
        return;
      }
    }
    QLog.d("ReadInJoyChannelPanelFragment", 1, "mHasChanged = false, do not need to update channel info list.");
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.c(false);
  }
  
  public int a()
  {
    return 2131562697;
  }
  
  public String a()
  {
    return getString(2131717745);
  }
  
  protected void a(View paramView)
  {
    this.jdField_c_of_type_Boolean ^= true;
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
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramTopBannerInfo.items.isEmpty())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner.a(null, paramTopBannerInfo);
    }
    if (paramTopBannerInfo.moreChannelItem != null)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramTopBannerInfo.moreChannelItem.jdField_a_of_type_JavaLangString);
      paramTopBannerInfo = paramTopBannerInfo.moreChannelItem.b;
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ReadInJoyChannelPanelFragment.4(this, paramTopBannerInfo));
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    RIJDtReportHelper.a.a(getBaseActivity(), "16");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    d();
    c();
    f();
    VideoReport.setPageId(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout, "16");
    VideoReport.setPageParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout, new RIJDtParamBuilder().a());
    VideoReport.addToDetectionWhitelist(getBaseActivity());
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.onDestroy();
    h();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = null;
  }
  
  public void onFinish()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[onFinish] ");
    super.onFinish();
    if (this.e) {
      g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ChannelBottomBanner localChannelBottomBanner = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner;
    if (localChannelBottomBanner != null) {
      localChannelBottomBanner.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ChannelBottomBanner localChannelBottomBanner = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelBottomBanner;
    if (localChannelBottomBanner != null) {
      localChannelBottomBanner.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */