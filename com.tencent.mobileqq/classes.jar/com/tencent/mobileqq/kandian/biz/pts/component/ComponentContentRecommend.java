package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommend
  extends FrameLayout
  implements ComponentInheritView
{
  private static int jdField_a_of_type_Int = -1;
  public static final String a = "ComponentContentRecommend";
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ListViewForListview jdField_a_of_type_ComTencentBizWidgetsListViewForListview;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  protected ReadInJoyObserver a;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private ArrayList<RecommendFollowInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ComponentContentRecommend(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentContentRecommend.7(this);
    b(paramContext);
  }
  
  public ComponentContentRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ComponentContentRecommend.7(this);
    b(paramContext);
  }
  
  public static String a(int paramInt1, long paramLong1, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong2, int paramInt2, int paramInt3, int paramInt4, List<RecommendFollowInfo> paramList)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("algorithm_id", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJKanDianFolderStatus.reportFolderStatus);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("folder_status", localStringBuilder.toString());
        ((JSONObject)localObject).put("feeds_type", "70");
        ((JSONObject)localObject).put("time", System.currentTimeMillis());
        ((JSONObject)localObject).put("channel_id", paramInt1);
        if (NetworkState.isWifiConn())
        {
          paramInt1 = 2;
          ((JSONObject)localObject).put("network_type", paramInt1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong1);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("feeds_source", localStringBuilder.toString());
          ((JSONObject)localObject).put("imei", ReadInJoyUtils.b());
          ((JSONObject)localObject).put("imsi", ReadInJoyUtils.c());
          ((JSONObject)localObject).put("idfa", "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("rowkey", localStringBuilder.toString());
          int i = 0;
          ((JSONObject)localObject).put("comment", 0);
          if (ReadInJoyHelper.x(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label487;
          }
          paramInt1 = 1;
          ((JSONObject)localObject).put("reddot_style", paramInt1);
          ((JSONObject)localObject).put("tab_source", paramInt4);
          ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
          if (paramInt3 != 0) {
            ((JSONObject)localObject).put("select_num", paramInt3);
          }
          ((JSONObject)localObject).put("sub_type", paramInt2);
          if ((paramList != null) && (!paramList.isEmpty()))
          {
            paramAbsBaseArticleInfo = new StringBuilder();
            paramInt1 = i;
            if (paramInt1 < paramList.size())
            {
              paramAbsBaseArticleInfo.append(((RecommendFollowInfo)paramList.get(paramInt1)).uin);
              if (paramInt1 >= paramList.size() - 1) {
                break label492;
              }
              paramAbsBaseArticleInfo.append("|");
              break label492;
            }
            ((JSONObject)localObject).put("feedssource_more", paramAbsBaseArticleInfo.toString());
          }
          paramAbsBaseArticleInfo = ((JSONObject)localObject).toString();
          return paramAbsBaseArticleInfo;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          paramList = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramAbsBaseArticleInfo));
          QLog.e(paramList, 2, ((StringBuilder)localObject).toString());
        }
        return "";
      }
      paramInt1 = 1;
      continue;
      label487:
      paramInt1 = 0;
      continue;
      label492:
      paramInt1 += 1;
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
        a("0X80094DB", paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
        a(paramString, paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
      }
      paramAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    jdField_a_of_type_Int = RIJTransMergeKanDianReport.a();
    paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos;
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.jdField_a_of_type_JavaUtilList != null) && (paramIReadInJoyModel.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      paramIReadInJoyModel = new ComponentContentRecommend.1(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramIReadInJoyModel);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramIReadInJoyModel);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "setContent(): data is empty");
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong1, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong2, int paramInt2)
  {
    String str = a(paramInt1, paramLong1, paramAbsBaseArticleInfo, paramLong2, 1, 0, jdField_a_of_type_Int, null);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    localStringBuilder.append("");
    paramAbsBaseArticleInfo = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, paramAbsBaseArticleInfo, localStringBuilder.toString(), str, false);
  }
  
  private void a(String paramString, RecommendFollowInfo paramRecommendFollowInfo)
  {
    CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
    int i;
    if ((localCmpCtxt != null) && (localCmpCtxt.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a() != null)) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a().a();
    } else {
      i = 0;
    }
    a(paramString, i, paramRecommendFollowInfo.uin, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId);
  }
  
  private void b()
  {
    CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
    int i;
    if ((localCmpCtxt != null) && (localCmpCtxt.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a() != null)) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a().a();
    } else {
      i = 0;
    }
    a("0X8009494", i, 0L, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0L, 0);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560130, this, true);
  }
  
  protected BaseAdapter a()
  {
    return new ComponentContentRecommend.2(this);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369822));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369314));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379565));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)paramView.findViewById(2131370512));
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = a();
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772240);
    if (localAnimation != null)
    {
      localAnimation.setInterpolator(new LinearInterpolator());
      paramImageView.startAnimation(localAnimation);
    }
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
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpToProfile, info = ");
      localStringBuilder.append(paramRecommendFollowInfo);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      paramRecommendFollowInfo = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(paramRecommendFollowInfo)) && (ViolaAccessHelper.c(paramRecommendFollowInfo)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.c(paramRecommendFollowInfo), null);
        return;
      }
      localObject = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      ((Intent)localObject).putExtra("url", paramRecommendFollowInfo);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      ((Activity)getContext()).startActivityForResult((Intent)localObject, 1);
    }
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(getContext()))
    {
      if (paramBoolean) {
        a("0X80094DC", paramRecommendFollowInfo);
      } else {
        a("0X80094DD", paramRecommendFollowInfo);
      }
      if (paramRecommendFollowInfo.type == 1)
      {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      else if (paramRecommendFollowInfo.type == 2)
      {
        b(paramRecommendFollowInfo, paramBoolean);
      }
      else
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("followAccount, error type, info.type = ");
        localStringBuilder.append(paramRecommendFollowInfo.type);
        localStringBuilder.append(", follow = ");
        localStringBuilder.append(paramBoolean);
        QLog.e(str, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
    }
    QQToast.a(getContext(), 1, 2131717970, 0).a();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      a(paramObject);
    }
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(paramRecommendFollowInfo.uin, paramRecommendFollowInfo.isFollowed);
    ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ThreadManager.post(new ComponentContentRecommend.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecommendFollowInfo.uin);
    localStringBuilder.append("");
    localUserOperationModule.request0x978((String)localObject, localStringBuilder.toString(), paramBoolean, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.3(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().a().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().a().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.5(this, paramRecommendFollowInfo), 1);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend
 * JD-Core Version:    0.7.0.1
 */