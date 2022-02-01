package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment.TKDTuWenSubCommentFragment;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, FlingExitLayout.OnGestureExitListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ITKDHippyEventDispatcherOwner
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TimeSliceHelper jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper = new TimeSliceHelper();
  private LayoutInflateProcessor jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
  private FlingExitLayout jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
  private ReadInJoyCommentUtils.CommentListListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener;
  private ReadInJoyCommentUtils.SecondCommentEvent jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$SecondCommentEvent;
  private ReadInJoySecondCommentListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter;
  private CommonCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
  private ITKDHippyEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher = new TKDHippyEventDispatcher();
  private TKDTuWenSubCommentFragment jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoySecondCommentListFragment.1(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e;
  
  private void a(Intent paramIntent)
  {
    CommonCommentData localCommonCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
    if (localCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", localCommonCommentData);
      paramIntent = new StringBuilder();
      paramIntent.append("read to BiuActivity second   commonCommentData :");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.toString());
      QLog.d("ReadInJoySecondCommentListFragment", 2, paramIntent.toString());
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout = ((FlingExitLayout)paramView.findViewById(2131366970));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setOnGestureExitListener(this);
    Object localObject = getArguments();
    if (localObject != null) {
      this.e = ((Bundle)localObject).getBoolean("arg_main_comment_use_hippy", false);
    }
    boolean bool = TKDTuWenCommentUtil.isSubCommentSwitchOn();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCommentView: enableHippyComment=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("isMainCommentPageUseHippy=");
    ((StringBuilder)localObject).append(this.e);
    QLog.d("ReadInJoySecondCommentListFragment", 1, ((StringBuilder)localObject).toString());
    if ((this.e) && (bool))
    {
      f();
      return;
    }
    b(paramView);
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    paramBaseCommentData = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramBaseCommentData).a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "c", "0X800901F", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramBaseCommentData, false);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramAbsBaseArticleInfo.innerUniqueID).c("click_write_comment").a().a("comment_id", this.jdField_a_of_type_JavaLangString).a());
  }
  
  private int b()
  {
    if (LiuHaiUtils.b()) {
      i = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    } else {
      i = 0;
    }
    int i = VideoFeedsHelper.b(getQBaseActivity()) - i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateView | marginTop is ");
    localStringBuilder.append(i);
    QLog.d("ReadInJoySecondCommentListFragment", 2, localStringBuilder.toString());
    return i;
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131378837);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setVisibility(0);
    paramView.findViewById(2131364710).setOnClickListener(this);
    paramView.findViewById(2131368874).setOnClickListener(this);
    paramView.findViewById(2131378784).setOnClickListener(this);
    j();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = ((ReadInJoyCommentListView)paramView.findViewById(2131364967));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout.setListView(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOnScrollListener(new ReadInJoySecondCommentListFragment.2(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364950);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366758));
    m();
    ReadInJoyDropFrameHelper.a().a(6666, this);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setVisibility(0);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject1);
    if (localObject1 == null) {
      return;
    }
    localObject1 = (CommentData)((ReadInJoyCommentDataManager)localObject1).a(this.jdField_a_of_type_JavaLangString);
    int i = 4;
    int k = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType;
    int j = 20;
    if (((k == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      i = 2;
    } else if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (RIJItemViewTypeUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))) {
      i = 9;
    } else {
      j = 19;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
    int m = i;
    k = j;
    if (localObject2 != null)
    {
      m = i;
      k = j;
      if (((CommonCommentData)localObject2).getAdTag() != -1)
      {
        m = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getAdTag();
        k = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getAdTag();
      }
    }
    localObject2 = ((CommentData)localObject1).getWholeStringContent();
    String str = ((CommentData)localObject1).uin;
    localObject2 = RIJCreateArticleInfoForBiu.a(new Intent(getQBaseActivity(), ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, m, (String)localObject2, Long.valueOf(str).longValue(), ((CommentData)localObject1).nickName, 0, k);
    ((Intent)localObject2).putExtra("fast_biu_type", paramBoolean);
    a((Intent)localObject2);
    getQBaseActivity().startActivity((Intent)localObject2);
    getQBaseActivity().overridePendingTransition(0, 0);
    localObject1 = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (BaseCommentData)localObject1).a().a(this.jdField_a_of_type_JavaLangString).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800901A", "0X800901A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment = TKDTuWenSubCommentFragment.newInstance();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131368189, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.setHippyCommentPageListener(new ReadInJoySecondCommentListFragment.MyHippyCommentPageListener(this, null));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.getTKDHippyEventDispatcher().register(new ReadInJoySecondCommentListFragment.MyHippyCommentEventListener(this, null));
    i();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.getTKDHippyEventDispatcher().merge(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment;
    if (localObject == null) {
      return;
    }
    ((TKDTuWenSubCommentFragment)localObject).setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.setContentSrc(ReadInJoyCommentHelper.a(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.setMainCommentId(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = new AnchorData();
      ((AnchorData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((AnchorData)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((AnchorData)localObject).jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.setAnchorData((AnchorData)localObject);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.setAnchorData(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.getTKDHippyEventDispatcher().refreshNewAndHotData(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment.getPropsMap());
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidViewView.findViewById(2131376704).setVisibility(0);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView.findViewById(2131376704).setVisibility(8);
  }
  
  private void j()
  {
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
      ((ViewStub)this.jdField_b_of_type_AndroidViewView.findViewById(2131376107)).inflate();
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if ((this.jdField_c_of_type_Int == 0) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_Int = b();
    }
    if ((this.jdField_b_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, this.jdField_c_of_type_Int, 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void l()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (localReadInJoyCommentDataManager == null) {
      return;
    }
    if ((localReadInJoyCommentDataManager.a() == 1) && (localReadInJoyCommentDataManager.a() == null)) {
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364703)).setImageResource(2130842887);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter = new ReadInJoySecondCommentListAdapter(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.initFooterView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.hideFooterView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter.a(new ReadInJoySecondCommentListFragment.3(this));
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      a(localAbsBaseArticleInfo, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  private void n()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localReadInJoyCommentListView == null) {
      return;
    }
    localReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setSelection(0);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
  }
  
  ReadInJoyCommentUtils.SecondCommentEvent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$SecondCommentEvent;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener = paramICommentNumChangedListener;
    paramICommentNumChangedListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter;
    if (paramICommentNumChangedListener != null) {
      paramICommentNumChangedListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener);
    }
  }
  
  public void a(ReadInJoyCommentUtils.CommentListListener paramCommentListListener, Bundle paramBundle, ReadInJoyCommentUtils.SecondCommentEvent paramSecondCommentEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener = paramCommentListListener;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$SecondCommentEvent = paramSecondCommentEvent;
    setArguments(paramBundle);
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = paramCommonCommentData;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment != null)
    {
      g();
      return;
    }
    ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter;
    Object localObject = null;
    paramAbsBaseArticleInfo = localObject;
    if (localReadInJoySecondCommentListAdapter != null)
    {
      localReadInJoySecondCommentListAdapter.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt);
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter.a();
      paramAbsBaseArticleInfo = localObject;
      if (paramString2 != null) {
        paramAbsBaseArticleInfo = paramString2.a(paramString1);
      }
    }
    c(false);
    l();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.resetState();
    a(paramAbsBaseArticleInfo);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener == null) {
      return;
    }
    String str;
    if (paramBoolean) {
      str = "downClose";
    } else {
      str = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener.a(false, null, str);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    RIJTransMergeKanDianReport.a(1, this.jdField_b_of_type_Int, i);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    ReadInJoyCommentUtils.CommentListListener localCommentListListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener;
    if (localCommentListListener != null) {
      localCommentListListener.a(false, null, null);
    }
  }
  
  public void d()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (localReadInJoyCommentDataManager != null) {
      localReadInJoyCommentDataManager.d();
    }
  }
  
  public void e()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.findViewById(2131372940) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "hideMaskView");
      this.jdField_b_of_type_AndroidViewView.findViewById(2131372940).setVisibility(8);
    }
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    TKDTuWenSubCommentFragment localTKDTuWenSubCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment;
    if (localTKDTuWenSubCommentFragment == null) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher;
    }
    return localTKDTuWenSubCommentFragment.getTKDHippyEventDispatcher();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TKDTuWenSubCommentFragment localTKDTuWenSubCommentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenSubcommentTKDTuWenSubCommentFragment;
    if (localTKDTuWenSubCommentFragment != null) {
      localTKDTuWenSubCommentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.d)
    {
      c();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 5;
    boolean bool = false;
    Object localObject;
    switch (j)
    {
    default: 
    case 2131378784: 
      n();
      return;
    case 2131368874: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramView != null)
      {
        paramView = ReadInJoyCommentDataManager.a(paramView);
        if (paramView == null) {
          return;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
          i = 2;
        } else if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (RIJItemViewTypeUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))) {
          i = 9;
        } else {
          i = 4;
        }
        localObject = (CommentData)paramView.a(this.jdField_a_of_type_JavaLangString);
        QBaseActivity localQBaseActivity = getQBaseActivity();
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getQBaseActivity().getString(2131717812));
        if (localObject != null) {
          paramView = ((CommentData)localObject).nickName;
        } else {
          paramView = "";
        }
        localStringBuilder.append(paramView);
        ReadInJoyCommentUtils.a(localQBaseActivity, localAbsBaseArticleInfo, (BaseCommentData)localObject, i, localStringBuilder.toString(), "", false, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$SecondCommentEvent, -1);
        if (localObject != null)
        {
          paramView = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (BaseCommentData)localObject).a().a(this.jdField_a_of_type_JavaLangString).a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009019", "0X8009019", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramView, false);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        return;
      }
      break;
    case 2131364710: 
    case 2131372940: 
    case 2131378837: 
      e();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener;
      if (localObject != null)
      {
        ((ReadInJoyCommentUtils.CommentListListener)localObject).a(false, null, null);
        if (paramView.getId() != 2131378837) {
          i = 0;
        }
        RIJTransMergeKanDianReport.a(1, this.jdField_b_of_type_Int, i);
        return;
      }
      break;
    case 2131363650: 
      if (BiuBehaviour.a() == 1) {
        bool = true;
      }
      d(bool);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor;
    if (paramBundle != null) {
      paramLayoutInflater = paramBundle.a(2131560269, true, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramLayoutInflater = paramLayoutInflater.inflate(2131560269, paramViewGroup, false);
    }
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
    a(paramLayoutInflater);
    k();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (getQBaseActivity() != null) {
      super.onDestroy();
    }
    getTKDHippyEventDispatcher().clear();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter;
    if (localReadInJoySecondCommentListAdapter != null)
    {
      localReadInJoySecondCommentListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter = null;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener = null;
    ReadInJoyDropFrameHelper.a().b(6666, this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.b();
      if (this.jdField_a_of_type_Boolean)
      {
        ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter;
        if ((localReadInJoySecondCommentListAdapter != null) && (localReadInJoySecondCommentListAdapter.a() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListAdapter.a().a(a());
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.c();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsTimeSliceHelper.a();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131363650) {
      return false;
    }
    int i = BiuBehaviour.b();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    d(bool);
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.d = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */