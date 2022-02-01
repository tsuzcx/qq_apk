package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements DisableSlideHorizontalListView.OnOverScrollListener, ComponentInheritView
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView;
  private ComponentContentRecommendFollowGroup.FollowListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$FollowListAdapter;
  protected ReadInJoyObserver a;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private View b;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentContentRecommendFollowGroup.4(this);
    a(paramContext);
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
        String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, 3, 0, jdField_a_of_type_Int, null);
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
    this.b = paramView.findViewById(2131376254);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363495);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$FollowListAdapter = new ComponentContentRecommendFollowGroup.FollowListAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.a(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$FollowListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.b.setOnClickListener(new ComponentContentRecommendFollowGroup.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
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
      QLog.d("ComponentContentRecommendFollowGroup", 1, ((StringBuilder)localObject).toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (ViolaAccessHelper.c((String)localObject)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.c((String)localObject), null);
        return;
      }
      paramRecommendFollowInfo = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      paramRecommendFollowInfo.putExtra("url", (String)localObject);
      paramRecommendFollowInfo.putExtra("hide_operation_bar", true);
      paramRecommendFollowInfo.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      ((Activity)getContext()).startActivityForResult(paramRecommendFollowInfo, 1);
    }
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
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$FollowListAdapter.a(paramObject.jdField_b_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<RecommendFollowInfo> paramList)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    int i;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).a() != null)) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a();
    } else {
      i = 0;
    }
    paramList = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramLong2, 3, paramInt2, jdField_a_of_type_Int, paramList);
    localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
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
    ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, (String)localObject2, paramString, paramString, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), paramList, false);
  }
  
  protected void a(List<RecommendFollowInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    RecommendFollowInfo localRecommendFollowInfo;
    while (i < paramList.size())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)paramList.get(i);
      if (paramBoolean != localRecommendFollowInfo.isFollowed)
      {
        localArrayList1.add(new BatchFollowModel(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
        localArrayList2.add(localRecommendFollowInfo);
      }
      i += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)localArrayList2.get(0);
      if (paramBoolean) {
        a("0X80094DC", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
      } else {
        a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
      }
    }
    paramList = new ComponentContentRecommendFollowGroup.2(this, paramList, paramBoolean);
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().a().batchFollow(localArrayList1, paramList, 2);
      return;
    }
    ReadInJoyLogicEngine.a().a().batchUnFollow(localArrayList1, paramList, 2);
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_b_of_type_JavaLangString;
    Intent localIntent = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0, null);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */