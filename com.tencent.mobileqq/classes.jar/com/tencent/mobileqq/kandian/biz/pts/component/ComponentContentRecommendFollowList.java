package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommendFollowList
  extends RelativeLayout
  implements DisableSlideHorizontalListView.OnOverScrollListener, ComponentInheritView
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView;
  private ComponentContentRecommendFollowList.FollowListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList$FollowListAdapter;
  private ComponentNotIntrest jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
  protected ReadInJoyObserver a;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private View jdField_b_of_type_AndroidViewView;
  private Set<Long> jdField_b_of_type_JavaUtilSet = new HashSet();
  private Set<Long> c = new HashSet();
  private Set<String> d = new HashSet();
  
  public ComponentContentRecommendFollowList(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentContentRecommendFollowList.6(this);
    a(paramContext);
  }
  
  private int a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    int i = 1;
    if (localAbsBaseArticleInfo != null)
    {
      if ((localAbsBaseArticleInfo.insertAction != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.insertAction.a().getActionType() == ActionType.ACTION_DATA_CARD_FOLLOW.getActionType())) {
        return 4;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.reqSource;
      if (j == 1) {
        return i;
      }
      if (j != 5)
      {
        if (j == 6) {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i = 0;
    return i;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID != 0L) {
            break label175;
          }
          i = 1;
          localJSONObject.put("acc_rec_location", i);
          localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
          if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.insertAction == null) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.insertAction.a() == null)) {
            break label180;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.insertAction.a().toPBInt();
          localJSONObject.put("trigger_type", i);
          localJSONObject.put("scene_type", a());
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          localJSONObject.put("feeds_type", 70);
          localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
          localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ComponentContentRecommendFollowList", 1, localJSONException.getMessage());
      }
      return localJSONObject;
      label175:
      int i = -1;
      continue;
      label180:
      i = 0;
    }
  }
  
  @NotNull
  private JSONObject a(int paramInt, Long paramLong)
  {
    JSONObject localJSONObject = a();
    try
    {
      localJSONObject.put("acc_seq", paramInt + 1);
      localJSONObject.put("puin", paramLong);
      localJSONObject.put("feeds_type", 70);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        return localJSONObject;
      }
    }
    catch (JSONException paramLong)
    {
      QLog.d("ComponentContentRecommendFollowList", 1, paramLong.getMessage());
    }
    return localJSONObject;
  }
  
  private JSONObject a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    JSONObject localJSONObject = a();
    for (;;)
    {
      try
      {
        localJSONObject.put("app_type", ReadinjoyReportUtils.c());
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
          break label187;
        }
        l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
        localJSONObject.put("channel_id", l);
        if (paramRecommendFollowInfo != null)
        {
          localJSONObject.put("ugcuin", paramRecommendFollowInfo.uin);
          localJSONObject.put("puin", paramRecommendFollowInfo.uin);
          boolean bool = paramRecommendFollowInfo.isFollowed;
          int j = 2;
          if (!bool) {
            break label195;
          }
          i = 2;
          localJSONObject.put("button_type", i);
          i = j;
          if (paramRecommendFollowInfo.isFollowed) {
            i = 1;
          }
          localJSONObject.put("click_type", i);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
        {
          localJSONObject.put("scene_type", a());
          localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
          localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
          return localJSONObject;
        }
      }
      catch (JSONException paramRecommendFollowInfo)
      {
        QLog.d("ComponentContentRecommendFollowList", 1, paramRecommendFollowInfo.getMessage());
      }
      return localJSONObject;
      label187:
      long l = -1L;
      continue;
      label195:
      int i = 1;
    }
  }
  
  private void a(int paramInt, RecommendFollowInfo paramRecommendFollowInfo)
  {
    Object localObject1 = Long.valueOf(paramRecommendFollowInfo.uin);
    if (!this.jdField_b_of_type_JavaUtilSet.contains(localObject1))
    {
      this.jdField_b_of_type_JavaUtilSet.add(localObject1);
      Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      localStringBuilder.append("");
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800B96C", "0X800B96C", 0, 0, "", "", "", a(paramInt, (Long)localObject1).toString(), false);
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      ((StringBuilder)localObject2).append("");
      ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, ((StringBuilder)localObject2).toString(), "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", a(paramRecommendFollowInfo).toString(), false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (paramAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
        return;
      }
      Iterator localIterator = paramAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, 2, 0, jdField_a_of_type_Int, null);
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject1, "0X80094DB", "0X80094DB", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
      }
      paramAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo, int paramInt)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L))
    {
      JSONObject localJSONObject = a(paramInt, Long.valueOf(paramRecommendFollowInfo.uin));
      StringBuilder localStringBuilder;
      if (!this.c.contains(Long.valueOf(paramRecommendFollowInfo.uin)))
      {
        this.c.add(Long.valueOf(paramRecommendFollowInfo.uin));
        paramRecommendFollowInfo = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
        localStringBuilder.append("");
        paramRecommendFollowInfo.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800B96D", "0X800B96D", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
      paramRecommendFollowInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((paramRecommendFollowInfo != null) && (!this.d.contains(paramRecommendFollowInfo.innerUniqueID)))
      {
        this.d.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        paramRecommendFollowInfo = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
        localStringBuilder.append("");
        paramRecommendFollowInfo.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800B96B", "0X800B96B", 0, 0, "", "", "", localJSONObject.toString(), false);
        paramRecommendFollowInfo = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
        localStringBuilder.append("");
        paramRecommendFollowInfo.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X8007625", "0X8007625", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)))
    {
      this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      localStringBuilder.append("");
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800B96A", "0X800B96A", 0, 0, "", "", "", a().toString(), false);
    }
  }
  
  private void c(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L))
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", a(paramRecommendFollowInfo).toString(), false);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560131, this, true);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131376251));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376259));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369822);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376254);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371954));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363495);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList$FollowListAdapter = new ComponentContentRecommendFollowList.FollowListAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.a(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList$FollowListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ComponentContentRecommendFollowList.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.a(paramCellListener);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowList.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(getContext()))
    {
      if (paramBoolean) {
        a("0X80094DC", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      } else {
        a("0X80094DD", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      }
      if (paramRecommendFollowInfo.type == 1) {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        break;
        if (paramRecommendFollowInfo.type == 2)
        {
          b(paramRecommendFollowInfo, paramBoolean);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("followAccount, error type, info.type = ");
          localStringBuilder.append(paramRecommendFollowInfo.type);
          localStringBuilder.append(", follow = ");
          localStringBuilder.append(paramBoolean);
          QLog.e("ComponentContentRecommendFollowList", 1, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList$FollowListAdapter.notifyDataSetChanged();
      return;
    }
    QQToast.a(getContext(), 1, 2131717970, 0).a();
  }
  
  public void a(Object paramObject)
  {
    jdField_a_of_type_Int = RIJTransMergeKanDianReport.a();
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = ((IReadInJoyModel)paramObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramObject == null) {
        return;
      }
      paramObject = paramObject.mRecommendFollowInfos;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList$FollowListAdapter.a(paramObject.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    int i;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).a() != null)) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a();
    } else {
      i = 0;
    }
    localObject1 = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramLong2, 2, paramInt2, jdField_a_of_type_Int, null);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowId);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, paramString, paramString, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), (String)localObject1, false);
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.b;
    ReadInJoyUtils.b(getContext(), (String)localObject);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.a(getContext(), 1, 2131717970, 0).a();
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToProfile, info = ");
      ((StringBuilder)localObject).append(paramRecommendFollowInfo);
      QLog.d("ComponentContentRecommendFollowList", 1, ((StringBuilder)localObject).toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (ViolaAccessHelper.c((String)localObject)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.c((String)localObject), null);
        return;
      }
      Intent localIntent = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      getContext().startActivity(localIntent);
      a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0);
    }
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecommendFollowInfo.uin);
    localStringBuilder.append("");
    localUserOperationModule.request0x978((String)localObject, localStringBuilder.toString(), paramBoolean, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.2(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().a().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().a().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.5(this, paramRecommendFollowInfo), 1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList
 * JD-Core Version:    0.7.0.1
 */