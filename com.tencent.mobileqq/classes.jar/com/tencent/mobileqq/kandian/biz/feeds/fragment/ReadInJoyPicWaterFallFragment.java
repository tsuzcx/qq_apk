package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.report.DistinctEventReporter;
import com.tencent.mobileqq.kandian.base.report.DistinctEventReporter.IReporter;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RecyclerViewWithHeaderFooterFix;
import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.SimpleFeedbackPopupWindow;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<ReadInJoyPicWaterFallFragment.ClassData>
  implements DistinctEventReporter.IReporter
{
  static final int d = Color.parseColor("#999999");
  static final int e = Color.parseColor("#262626");
  int jdField_a_of_type_Int = 2;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  protected DistinctEventReporter a;
  private SimpleFeedbackPopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizDislikeSimpleFeedbackPopupWindow;
  protected ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface a;
  protected ReadInJoyPicWaterFallFragment.WaterFallPicAdapter a;
  protected ReadInjoyXRecyclerView a;
  ArrayList<ReadInJoyPicWaterFallFragment.ClassData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected Map<Long, BaseReportData> a;
  protected Set<Long> a;
  int c;
  private int jdField_f_of_type_Int = 41522;
  private boolean jdField_f_of_type_Boolean;
  
  public ReadInJoyPicWaterFallFragment()
  {
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap = null;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369249);
    Object localObject = (LinearLayout)paramView.findViewById(2131369251);
    localObject = (ImageView)paramView.findViewById(2131369250);
    paramView = (TextView)paramView.findViewById(2131369202);
    localTextView.setText(a().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.5(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.d) {
      AccessibilityUtil.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = RIJFeedsType.c(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    String str = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, bool ^ true, NetworkUtil.isWifiConnected(null), (String)localObject, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    JSONObject localJSONObject = new JSONObject();
    localObject = localJSONObject;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        localObject = new JSONObject(str);
        try
        {
          ((JSONObject)localObject).put("feeds_type", paramInt2);
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
    }
    catch (JSONException localJSONException2)
    {
      localObject = localJSONObject;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.c(paramAbsBaseArticleInfo), "0X8007625", "0X8007625", 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.businessId), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((JSONObject)localObject).toString(), false);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(0L);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(120L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(120L);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ReadInJoyPicWaterFallFragment.ClassData> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131560205, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378810);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      Utils.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131365132);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView = new ReadInJoyPicWaterFallFragment.1(this, paramViewGroup.getContext());
    paramViewGroup = new ReadInJoyPicWaterFallFragment.2(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(a());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, AIOUtils.b(3.0F, getResources()), 0, AIOUtils.b(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView.setAdapter(new ReadInJoyPicWaterFallFragment.ClassificationAdapter(this, null));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    else
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(a());
      paramChannelClassificationListView.setPadding(0, AIOUtils.b(3.0F, getResources()), 0, AIOUtils.b(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter = new ReadInJoyPicWaterFallFragment.WaterFallPicAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().addOnScrollListener(new ReadInJoyPicWaterFallFragment.3(this));
    this.c = AIOUtils.b(3.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().addItemDecoration(new ReadInJoyPicWaterFallFragment.SpaceItemDecoration(this, this.c));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.a().getItemAnimator();
    i();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController);
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeSimpleFeedbackPopupWindow = new SimpleFeedbackPopupWindow(a(), new ReadInJoyPicWaterFallFragment.4(this));
    return paramLayoutInflater;
  }
  
  public ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface = new ReadInJoyPicWaterFallFragment.6(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = a().getIntent();
    this.jdField_f_of_type_Int = localIntent.getIntExtra("channel_id", 41522);
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  protected void a(View paramView, int paramInt)
  {
    paramView = ((ReadInJoyPicWaterFallFragment.ClassData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtra("channel_id", paramView.mChannelCoverId);
      localIntent.putExtra("sub_channel_name", paramView.mChannelCoverName);
      localIntent.putExtra("is_sub_channel", true);
      QPublicFragmentActivity.start(a(), localIntent, ReadInJoyPicWaterFallFragment.class);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      if ((localMap != null) && ((localMap.containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID)) ^ true))) {
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramAbsBaseArticleInfo, paramInt, RIJTransMergeKanDianReport.a(), System.currentTimeMillis()), 5, null, true);
      }
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    new RIJFrameworkReportManager().a(paramMap, paramBoolean, paramMap1, paramString, a(), b());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter;
    if (paramActivity != null) {
      paramActivity.notifyDataSetChanged();
    }
  }
  
  public int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  protected boolean f()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelWaterFallViewController.k();
    }
    DistinctEventReporter localDistinctEventReporter = this.jdField_a_of_type_ComTencentMobileqqKandianBaseReportDistinctEventReporter;
    if (localDistinctEventReporter != null)
    {
      localDistinctEventReporter.reportDelay();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseReportDistinctEventReporter.clearAll();
    }
  }
  
  public boolean g()
  {
    return a() instanceof SplashActivity;
  }
  
  public boolean onBackEvent()
  {
    b();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseReportDistinctEventReporter = new DistinctEventReporter(this);
    RIJDtReportHelper.a.a(a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyPicWaterFallFragment.WaterFallPicAdapter localWaterFallPicAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter;
    if (localWaterFallPicAdapter != null) {
      localWaterFallPicAdapter.notifyDataSetChanged();
    }
    if (f()) {
      Utils.a(this);
    }
  }
  
  public void reportIt(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation"))
    {
      GalleryReportedUtils.a((GalleryReportedUtils.ReportData)paramObject);
      return;
    }
    if (paramString.equals("exp_subchannel"))
    {
      paramString = (ReadInJoyPicWaterFallFragment.ClassData)paramObject;
      GalleryReportedUtils.a(a(), "0X8009A70", b(), paramString.a.mChannelCoverId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */