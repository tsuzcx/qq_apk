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
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, FlingExitLayout.OnGestureExitListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ITKDHippyEventDispatcherOwner
{
  private ReadInJoyCommentUtils.SecondCommentEvent a;
  private ReadInJoyCommentListView b;
  private ReadInJoySecondCommentListAdapter c;
  private ReadInJoyCommentUtils.CommentListListener d;
  private View e;
  private AbsBaseArticleInfo f;
  private TextView g;
  private int h;
  private String i;
  private String j;
  private int k = 0;
  private LayoutInflateProcessor l;
  private TimeSliceHelper m = new TimeSliceHelper();
  private boolean n = false;
  private boolean o = false;
  private View p = null;
  private CommonCommentData q;
  private boolean r = false;
  private int s = 0;
  private boolean t = false;
  private TKDTuWenSubCommentFragment u;
  private ITKDHippyEventDispatcher v = new TKDHippyEventDispatcher();
  private boolean w;
  private FlingExitLayout x;
  private ReadInJoyObserver y = new ReadInJoySecondCommentListFragment.1(this);
  private ICommentNumChangedListener z;
  
  private void a(int paramInt, CommentData paramCommentData)
  {
    CommentComponentArgs localCommentComponentArgs = new CommentComponentArgs().a(this.f).a(paramCommentData).a(s());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQBaseActivity().getString(2131915287));
    if (paramCommentData != null) {
      paramCommentData = paramCommentData.nickName;
    } else {
      paramCommentData = "";
    }
    localStringBuilder.append(paramCommentData);
    paramCommentData = localCommentComponentArgs.a(localStringBuilder.toString()).b("").a(this.a).b(paramInt);
    ReadInJoyCommentUtils.a(getQBaseActivity(), paramCommentData);
  }
  
  private void a(Intent paramIntent)
  {
    CommonCommentData localCommonCommentData = this.q;
    if (localCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", localCommonCommentData);
      paramIntent = new StringBuilder();
      paramIntent.append("read to BiuActivity second   commonCommentData :");
      paramIntent.append(this.q.toString());
      QLog.d("ReadInJoySecondCommentListFragment", 2, paramIntent.toString());
    }
  }
  
  private void a(View paramView)
  {
    this.x = ((FlingExitLayout)paramView.findViewById(2131433416));
    this.x.setOnGestureExitListener(this);
    Object localObject = getArguments();
    if (localObject != null) {
      this.w = ((Bundle)localObject).getBoolean("arg_main_comment_use_hippy", false);
    }
    boolean bool = TKDTuWenCommentUtil.isSubCommentSwitchOn();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCommentView: enableHippyComment=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("isMainCommentPageUseHippy=");
    ((StringBuilder)localObject).append(this.w);
    QLog.d("ReadInJoySecondCommentListFragment", 1, ((StringBuilder)localObject).toString());
    if ((this.w) && (bool))
    {
      j();
      return;
    }
    b(paramView);
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject);
    if (localObject == null) {
      return;
    }
    localObject = (CommentData)((ReadInJoyCommentDataManager)localObject).g(this.i);
    a(paramInt, (CommentData)localObject);
    a(paramView, (CommentData)localObject);
  }
  
  private void a(View paramView, CommentData paramCommentData)
  {
    if (paramView.getId() != 2131431060)
    {
      if (paramView.getId() == 2131431077) {
        return;
      }
      if (paramCommentData != null)
      {
        paramView = new CommentReportR5Builder(this.f, paramCommentData).a().a(this.i).b();
        PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.f), "0X8009019", "0X8009019", 0, 0, String.valueOf(this.f.mArticleID), String.valueOf(this.f.mStrategyId), this.f.innerUniqueID, paramView, false);
      }
      a(this.f);
    }
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    paramBaseCommentData = new CommentReportR5Builder(this.f, paramBaseCommentData).a().b();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.f;
    if (localAbsBaseArticleInfo != null) {
      PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(localAbsBaseArticleInfo), "c", "0X800901F", 0, 0, String.valueOf(this.f.mArticleID), String.valueOf(this.f.mStrategyId), this.f.innerUniqueID, paramBaseCommentData, false);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramAbsBaseArticleInfo.innerUniqueID).c("click_write_comment").a().a("comment_id", this.i).c());
  }
  
  private void b(View paramView)
  {
    this.v.clear();
    c(paramView);
    d(paramView);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131447534);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setVisibility(0);
    paramView.findViewById(2131430816).setOnClickListener(this);
    paramView.findViewById(2131435808).setOnClickListener(this);
    paramView.findViewById(2131447463).setOnClickListener(this);
    n();
    this.b = ((ReadInJoyCommentListView)paramView.findViewById(2131431094));
    this.x.setListView(this.b);
    this.b.setOnScrollListener(new ReadInJoySecondCommentListFragment.2(this));
    this.e = paramView.findViewById(2131431075);
    this.o = true;
    this.g = ((TextView)paramView.findViewById(2131433080));
    r();
    ReadInJoyDropFrameHelper.d().a(6666, this);
  }
  
  private void c(View paramView)
  {
    if (RIJCommentAtUi.a())
    {
      paramView = paramView.findViewById(2131431060);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  private void d(View paramView)
  {
    paramView = paramView.findViewById(2131431077);
    paramView.setVisibility(0);
    paramView.setOnClickListener(this);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject1);
    if (localObject1 == null) {
      return;
    }
    localObject1 = (CommentData)((ReadInJoyCommentDataManager)localObject1).g(this.i);
    int i1 = 4;
    int i3 = this.f.mFeedType;
    int i2 = 20;
    if (((i3 == 1) && (this.f.mSocialFeedInfo != null) && (this.f.mSocialFeedInfo.b == 5)) || (RIJFeedsType.a(this.f))) {
      i1 = 2;
    } else if ((RIJItemViewTypeUtils.o(this.f)) && (this.f.mSocialFeedInfo.s != null) && (RIJItemViewTypeUtils.b(this.f.mSocialFeedInfo.s.a))) {
      i1 = 9;
    } else {
      i2 = 19;
    }
    Object localObject2 = this.q;
    int i4 = i1;
    i3 = i2;
    if (localObject2 != null)
    {
      i4 = i1;
      i3 = i2;
      if (((CommonCommentData)localObject2).getAdTag() != -1)
      {
        i4 = this.q.getAdTag();
        i3 = this.q.getAdTag();
      }
    }
    localObject2 = ((CommentData)localObject1).getWholeStringContent();
    String str = ((CommentData)localObject1).uin;
    localObject2 = RIJCreateArticleInfoForBiu.a(new Intent(getQBaseActivity(), ReadInJoyDeliverBiuActivity.class), this.f, i4, (String)localObject2, Long.valueOf(str).longValue(), ((CommentData)localObject1).nickName, 0, i3);
    ((Intent)localObject2).putExtra("fast_biu_type", paramBoolean);
    a((Intent)localObject2);
    getQBaseActivity().startActivity((Intent)localObject2);
    getQBaseActivity().overridePendingTransition(0, 0);
    localObject1 = new CommentReportR5Builder(this.f, (BaseCommentData)localObject1).a().a(this.i).b();
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.f), "0X800901A", "0X800901A", 0, 0, String.valueOf(this.f.mArticleID), String.valueOf(this.f.mStrategyId), this.f.innerUniqueID, (String)localObject1, false);
  }
  
  private void e(View paramView)
  {
    a(paramView, 0);
  }
  
  private void j()
  {
    this.u = TKDTuWenSubCommentFragment.newInstance();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131435054, this.u);
    localFragmentTransaction.commitAllowingStateLoss();
    this.u.setHippyCommentPageListener(new ReadInJoySecondCommentListFragment.MyHippyCommentPageListener(this, null));
    this.u.getTKDHippyEventDispatcher().register(new ReadInJoySecondCommentListFragment.MyHippyCommentEventListener(this, null));
    m();
    this.u.getTKDHippyEventDispatcher().merge(this.v);
    this.v.clear();
  }
  
  private void k()
  {
    Object localObject = this.u;
    if (localObject == null) {
      return;
    }
    ((TKDTuWenSubCommentFragment)localObject).setArticleInfo(this.f);
    this.u.setContentSrc(ReadInJoyCommentHelper.a(this.h));
    this.u.setMainCommentId(this.i);
    if (!TextUtils.isEmpty(this.j))
    {
      localObject = new AnchorData();
      ((AnchorData)localObject).a = this.i;
      ((AnchorData)localObject).b = this.j;
      ((AnchorData)localObject).c = false;
      this.u.setAnchorData((AnchorData)localObject);
    }
    else
    {
      this.u.setAnchorData(null);
    }
    this.u.getTKDHippyEventDispatcher().refreshNewAndHotData(this.u.getPropsMap());
  }
  
  private void l()
  {
    this.p.findViewById(2131444985).setVisibility(0);
  }
  
  private void m()
  {
    this.p.findViewById(2131444985).setVisibility(8);
  }
  
  private void n()
  {
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.b())) {
      ((ViewStub)this.p.findViewById(2131444310)).inflate();
    }
  }
  
  private void o()
  {
    if (this.p == null) {
      return;
    }
    if ((this.s == 0) && (this.r)) {
      this.s = p();
    }
    if ((this.p.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.p.getLayoutParams();
      localLayoutParams.setMargins(0, this.s, 0, 0);
      this.p.setLayoutParams(localLayoutParams);
    }
  }
  
  private int p()
  {
    if (LiuHaiUtils.b()) {
      i1 = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    } else {
      i1 = 0;
    }
    int i1 = VideoFeedsHelper.e(getQBaseActivity()) - i1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateView | marginTop is ");
    localStringBuilder.append(i1);
    QLog.d("ReadInJoySecondCommentListFragment", 2, localStringBuilder.toString());
    return i1;
  }
  
  private void q()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.f);
    if (localReadInJoyCommentDataManager == null) {
      return;
    }
    if ((localReadInJoyCommentDataManager.a() == 1) && (localReadInJoyCommentDataManager.o() == null)) {
      ((ImageView)this.p.findViewById(2131430806)).setImageResource(2130843843);
    }
  }
  
  private void r()
  {
    this.c = new ReadInJoySecondCommentListAdapter(getQBaseActivity(), this.b, this, this.k);
    this.c.a(this.q);
    this.b.initFooterView();
    this.b.hideFooterView();
    this.b.setAdapter(this.c);
    if (this.d != null) {
      this.c.a(this.z);
    }
    this.c.a(new ReadInJoySecondCommentListFragment.3(this));
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.f;
    if (localAbsBaseArticleInfo != null) {
      a(localAbsBaseArticleInfo, this.i, this.j, this.h);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.y);
  }
  
  private int s()
  {
    if (t()) {
      return 2;
    }
    if ((RIJItemViewTypeUtils.o(this.f)) && (this.f.mSocialFeedInfo != null) && (this.f.mSocialFeedInfo.s != null) && (RIJItemViewTypeUtils.b(this.f.mSocialFeedInfo.s.a))) {
      return 9;
    }
    return 4;
  }
  
  private boolean t()
  {
    int i1 = this.f.mFeedType;
    boolean bool = true;
    if ((i1 != 1) || (this.f.mSocialFeedInfo == null) || (this.f.mSocialFeedInfo.b != 5))
    {
      if (RIJFeedsType.a(this.f)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void u()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.b;
    if (localReadInJoyCommentListView == null) {
      return;
    }
    localReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.b.setSelection(0);
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.l = paramLayoutInflateProcessor;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.z = paramICommentNumChangedListener;
    paramICommentNumChangedListener = this.c;
    if (paramICommentNumChangedListener != null) {
      paramICommentNumChangedListener.a(this.z);
    }
  }
  
  public void a(ReadInJoyCommentUtils.CommentListListener paramCommentListListener, Bundle paramBundle, ReadInJoyCommentUtils.SecondCommentEvent paramSecondCommentEvent)
  {
    this.d = paramCommentListListener;
    this.a = paramSecondCommentEvent;
    setArguments(paramBundle);
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.q = paramCommonCommentData;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    this.f = paramAbsBaseArticleInfo;
    this.h = paramInt;
    this.i = paramString1;
    this.j = paramString2;
    if (!this.o) {
      return;
    }
    if (this.u != null)
    {
      k();
      return;
    }
    ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.c;
    Object localObject = null;
    paramAbsBaseArticleInfo = localObject;
    if (localReadInJoySecondCommentListAdapter != null)
    {
      localReadInJoySecondCommentListAdapter.a(paramString1, paramString2, this.f, paramInt);
      paramString2 = this.c.f();
      paramAbsBaseArticleInfo = localObject;
      if (paramString2 != null) {
        paramAbsBaseArticleInfo = paramString2.g(paramString1);
      }
    }
    c(false);
    q();
    this.b.resetState();
    a(paramAbsBaseArticleInfo);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.g;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.g.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    String str;
    if (paramBoolean) {
      str = "downClose";
    } else {
      str = "";
    }
    this.d.a(false, null, str);
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    RIJTransMergeKanDianReport.a(1, this.k, i1);
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public boolean b()
  {
    return this.u != null;
  }
  
  public long c()
  {
    return this.m.e();
  }
  
  public void d()
  {
    if (this.n) {
      this.m.b();
    }
  }
  
  public void e()
  {
    if (this.n) {
      this.m.c();
    }
  }
  
  ReadInJoyCommentUtils.SecondCommentEvent f()
  {
    return this.a;
  }
  
  public void g()
  {
    ReadInJoyCommentUtils.CommentListListener localCommentListListener = this.d;
    if (localCommentListListener != null) {
      localCommentListListener.a(false, null, null);
    }
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    TKDTuWenSubCommentFragment localTKDTuWenSubCommentFragment = this.u;
    if (localTKDTuWenSubCommentFragment == null) {
      return this.v;
    }
    return localTKDTuWenSubCommentFragment.getTKDHippyEventDispatcher();
  }
  
  public void h()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.f);
    if (localReadInJoyCommentDataManager != null) {
      localReadInJoyCommentDataManager.g();
    }
  }
  
  public void i()
  {
    View localView = this.p;
    if ((localView != null) && (localView.findViewById(2131440504) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "hideMaskView");
      this.p.findViewById(2131440504).setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TKDTuWenSubCommentFragment localTKDTuWenSubCommentFragment = this.u;
    if (localTKDTuWenSubCommentFragment != null) {
      localTKDTuWenSubCommentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.t)
    {
      g();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    boolean bool = false;
    int i1 = 0;
    switch (i2)
    {
    default: 
    case 2131447463: 
      u();
      return;
    case 2131435808: 
      e(paramView);
      return;
    case 2131431077: 
      a(paramView, 1);
      return;
    case 2131431060: 
      a(paramView, 2);
      return;
    case 2131430816: 
    case 2131440504: 
    case 2131447534: 
      i();
      ReadInJoyCommentUtils.CommentListListener localCommentListListener = this.d;
      if (localCommentListListener != null)
      {
        localCommentListListener.a(false, null, null);
        if (paramView.getId() == 2131447534) {
          i1 = 5;
        }
        RIJTransMergeKanDianReport.a(1, this.k, i1);
        return;
      }
      break;
    case 2131429563: 
      if (BiuBehaviour.a() == 1) {
        bool = true;
      }
      d(bool);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = this.l;
    if (paramBundle != null) {
      paramLayoutInflater = paramBundle.a(2131626316, true, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramLayoutInflater = paramLayoutInflater.inflate(2131626316, paramViewGroup, false);
    }
    this.p = paramLayoutInflater;
    a(paramLayoutInflater);
    o();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (getQBaseActivity() != null) {
      super.onDestroy();
    }
    getTKDHippyEventDispatcher().clear();
    this.f = null;
    ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.c;
    if (localReadInJoySecondCommentListAdapter != null)
    {
      localReadInJoySecondCommentListAdapter.a();
      this.c = null;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.y);
    }
    this.d = null;
    ReadInJoyDropFrameHelper.d().b(6666, this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.m.c();
      if (this.n)
      {
        ReadInJoySecondCommentListAdapter localReadInJoySecondCommentListAdapter = this.c;
        if ((localReadInJoySecondCommentListAdapter != null) && (localReadInJoySecondCommentListAdapter.q() != null))
        {
          this.c.q().a(c());
          this.m.g();
        }
        this.n = false;
      }
    }
    else
    {
      this.m.b();
      this.n = true;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131429563) {
      return false;
    }
    int i1 = BiuBehaviour.b();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    d(bool);
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.t = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.t = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */