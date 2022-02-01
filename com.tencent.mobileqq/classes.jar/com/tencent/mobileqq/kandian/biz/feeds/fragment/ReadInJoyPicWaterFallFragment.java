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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  static final int v = Color.parseColor("#999999");
  static final int w = Color.parseColor("#262626");
  private View A;
  private SimpleFeedbackPopupWindow B;
  int m = 2;
  protected ReadInjoyXRecyclerView n;
  protected ReadInJoyPicWaterFallFragment.WaterFallPicAdapter o;
  protected ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface p;
  int q;
  ArrayList<ReadInJoyPicWaterFallFragment.ClassData> r = new ArrayList();
  protected Set<Long> s = null;
  protected Map<Long, BaseReportData> t = null;
  protected DistinctEventReporter u;
  private RecyclerView.ItemAnimator x;
  private int y = 41522;
  private boolean z;
  
  private void A()
  {
    this.x.setAddDuration(120L);
    this.x.setChangeDuration(250L);
    this.x.setMoveDuration(250L);
    this.x.setRemoveDuration(120L);
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131436227);
    Object localObject = (LinearLayout)paramView.findViewById(2131436229);
    localObject = (ImageView)paramView.findViewById(2131436228);
    paramView = (TextView)paramView.findViewById(2131436180);
    localTextView.setText(v().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.5(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.e) {
      AccessibilityUtil.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = RIJFeedsType.k(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    String str = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, bool ^ true, NetworkUtil.isWifiConnected(null), (String)localObject, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
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
    PublicAccountReportUtils.a(null, RIJFeedsType.k(paramAbsBaseArticleInfo), "0X8007625", "0X8007625", 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.businessId), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((JSONObject)localObject).toString(), false);
  }
  
  private void z()
  {
    this.x.setAddDuration(0L);
    this.x.setChangeDuration(0L);
    this.x.setMoveDuration(0L);
    this.x.setRemoveDuration(0L);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ReadInJoyPicWaterFallFragment.ClassData> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(v()).inflate(2131626252, null);
    this.A = paramLayoutInflater.findViewById(2131447492);
    if (a())
    {
      this.A.setVisibility(0);
      a(paramLayoutInflater);
      Utils.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131431280);
    this.n = new ReadInJoyPicWaterFallFragment.1(this, paramViewGroup.getContext());
    paramViewGroup = new ReadInJoyPicWaterFallFragment.2(this, this.m, 1);
    if (this.a != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(v());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, AIOUtils.b(3.0F, getResources()), 0, AIOUtils.b(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.a, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.a.setAdapter(new ReadInJoyPicWaterFallFragment.ClassificationAdapter(this, null));
      this.n.getRecyclerView().a(paramChannelClassificationListView);
    }
    else
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(v());
      paramChannelClassificationListView.setPadding(0, AIOUtils.b(3.0F, getResources()), 0, AIOUtils.b(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.n.getRecyclerView().a(paramChannelClassificationListView);
    }
    this.n.getRecyclerView().setLayoutManager(paramViewGroup);
    this.o = new ReadInJoyPicWaterFallFragment.WaterFallPicAdapter(this);
    this.n.getRecyclerView().setAdapter(this.o);
    this.n.getRecyclerView().addOnScrollListener(new ReadInJoyPicWaterFallFragment.3(this));
    this.q = AIOUtils.b(3.0F, getResources());
    this.n.getRecyclerView().addItemDecoration(new ReadInJoyPicWaterFallFragment.SpaceItemDecoration(this, this.q));
    this.x = this.n.getRecyclerView().getItemAnimator();
    z();
    this.n.setBackgroundColor(Color.parseColor("#f7f7f7"));
    this.n.setRefreshCallback(this.c);
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    paramBundle.addView(this.n, paramViewGroup);
    this.B = new SimpleFeedbackPopupWindow(v(), new ReadInJoyPicWaterFallFragment.4(this));
    return paramLayoutInflater;
  }
  
  protected void a(View paramView, int paramInt)
  {
    paramView = ((ReadInJoyPicWaterFallFragment.ClassData)this.r.get(paramInt)).c;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtra("channel_id", paramView.mChannelCoverId);
      localIntent.putExtra("sub_channel_name", paramView.mChannelCoverName);
      localIntent.putExtra("is_sub_channel", true);
      QPublicFragmentActivity.start(v(), localIntent, ReadInJoyPicWaterFallFragment.class);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Map localMap = this.t;
      if ((localMap != null) && ((localMap.containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID)) ^ true))) {
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramAbsBaseArticleInfo, paramInt, RIJTransMergeKanDianReport.b(), System.currentTimeMillis()), 5, null, true);
      }
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    new RIJFrameworkReportManager().a(paramMap, paramBoolean, paramMap1, paramString, v(), d());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.o;
    if (paramActivity != null) {
      paramActivity.notifyDataSetChanged();
    }
  }
  
  protected boolean a()
  {
    return this.z;
  }
  
  public int d()
  {
    return this.y;
  }
  
  public void n()
  {
    if (this.c != null) {
      this.c.cR_();
    }
    DistinctEventReporter localDistinctEventReporter = this.u;
    if (localDistinctEventReporter != null)
    {
      localDistinctEventReporter.reportDelay();
      this.u.clearAll();
    }
  }
  
  public boolean onBackEvent()
  {
    f();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.u = new DistinctEventReporter(this);
    RIJDtReportHelper.a.a(v());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyPicWaterFallFragment.WaterFallPicAdapter localWaterFallPicAdapter = this.o;
    if (localWaterFallPicAdapter != null) {
      localWaterFallPicAdapter.notifyDataSetChanged();
    }
    if (a()) {
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
      GalleryReportedUtils.a(v(), "0X8009A70", d(), paramString.c.mChannelCoverId);
    }
  }
  
  protected void w()
  {
    super.w();
    Intent localIntent = v().getIntent();
    this.y = localIntent.getIntExtra("channel_id", 41522);
    this.z = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  public ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface x()
  {
    if (this.p == null) {
      this.p = new ReadInJoyPicWaterFallFragment.6(this);
    }
    return this.p;
  }
  
  public boolean y()
  {
    return v() instanceof SplashActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */