package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadInJoyCommentListAdapter
  extends ReadinjoyCommentListBaseAdapter
  implements ReadInJoyCommentListView.RefreshCallback
{
  public static int a;
  private int A = -1;
  private int B = -1;
  public int b;
  private int u;
  private LayoutInflater v;
  private ReadInJoyCommentUtils.CommentListListener w;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener x;
  private ICommentNumChangedListener y;
  private ReadInJoyCommentListFragment z;
  
  public ReadInJoyCommentListAdapter(QBaseActivity paramQBaseActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.v = LayoutInflater.from(paramQBaseActivity);
    this.c = paramQBaseActivity;
    this.z = paramReadInJoyCommentListFragment;
    this.w = paramReadInJoyCommentListFragment;
    this.g = paramReadInJoyCommentListView;
    this.g.setRefreshCallback(this);
    this.u = paramInt;
    a = paramInt;
    this.m = new DynamicCommentProteusHelper();
    this.m.a(m());
    this.o = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.h, this);
    this.p = new ListAdExposeManager(paramQBaseActivity);
    this.r = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramQBaseActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.t);
    RIJCommentAdUtils.a(paramReadInJoyCommentListView, this.p);
  }
  
  public ReadInJoyCommentListAdapter(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.v = LayoutInflater.from(paramFastWebActivity);
    this.c = paramFastWebActivity;
    this.w = paramFastWebActivity;
    this.g = paramReadInJoyCommentListView;
    this.g.setRefreshCallback(this);
    this.u = paramInt;
    a = paramInt;
    this.m = new DynamicCommentProteusHelper();
    this.m.a(m());
    this.o = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.h, this);
    this.p = new ListAdExposeManager(paramFastWebActivity);
    this.r = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramFastWebActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.t);
    RIJCommentAdUtils.a(paramReadInJoyCommentListView, this.p);
  }
  
  private void a(CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt)
  {
    this.s = 2;
    int i;
    if (RIJBiuAndCommentAladdinUtils.a()) {
      i = 2131915231;
    } else {
      i = 2131915297;
    }
    QQToast.makeText(BaseApplication.getContext(), 2, i, 0).show();
    k_(4);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommentCreate commentViewItemList size ");
      localStringBuilder.append(paramList.size());
      QLog.d("ReadInJoyCommentListAdapter", 2, localStringBuilder.toString());
      if (this.h != null)
      {
        this.h.clear();
        this.h.addAll(paramList);
        notifyDataSetChanged();
        u();
      }
    }
    c(this.f.b(paramInt));
    if (i(paramCommentViewItem)) {
      ReadInJoyCommentUtils.a(this.i.mRecommendSeq, true);
    }
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if (this.f.i() == null) {
      return;
    }
    Object localObject = this.f.i();
    if ((((ReadInJoyCommentDataManager.CommentAnchor)localObject).a) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).c != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (CommentViewItem)paramList.next();
        if ((localObject != null) && (((CommentViewItem)localObject).c != null) && (((CommentViewItem)localObject).c.isAnchor)) {
          ((CommentViewItem)localObject).c.isAnchor = false;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (r() != null))
    {
      this.A = r().getFirstVisiblePosition();
      Object localObject = r();
      int i = 0;
      localObject = ((ReadInJoyCommentListView)localObject).getChildAt(0);
      if (localObject != null) {
        i = ((View)localObject).getTop();
      }
      this.B = i;
    }
  }
  
  private void b(CommentViewItem paramCommentViewItem)
  {
    QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131910615), 0).show();
    g(paramCommentViewItem);
    c(this.f.b(this.s));
    i(paramCommentViewItem);
  }
  
  private void b(List<CommentViewItem> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
      Object localObject = localCommentViewItem.c;
      if (localObject != null)
      {
        localObject = ((BaseCommentData)localObject).commentId;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!localHashSet.contains(localObject))
          {
            this.h.add(localCommentViewItem);
            localHashSet.add(localObject);
          }
          else
          {
            i = 1;
          }
        }
        else {
          this.h.add(localCommentViewItem);
        }
      }
      else
      {
        this.h.add(localCommentViewItem);
      }
    }
    if (i != 0) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkDataDuplicate | error!!! first page comment data duplicated!");
    }
  }
  
  private void c(long paramLong)
  {
    ICommentNumChangedListener localICommentNumChangedListener = this.y;
    if (localICommentNumChangedListener != null) {
      localICommentNumChangedListener.onCommentNumChanged(paramLong);
    }
  }
  
  private boolean d(int paramInt)
  {
    if ((this.s == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5)))
    {
      this.s = paramInt;
      return true;
    }
    return this.s == paramInt;
  }
  
  private boolean e(int paramInt)
  {
    if ((paramInt == 2) && ((this.s == 2) || (this.s == 3)))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
      return true;
    }
    return this.s == paramInt;
  }
  
  private void g(CommentViewItem paramCommentViewItem)
  {
    if (this.h == null) {
      return;
    }
    int i = 0;
    while (i < this.h.size())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)this.h.get(i);
      if ((h(localCommentViewItem)) && (TextUtils.equals(localCommentViewItem.c.commentId, ((SubCommentData)paramCommentViewItem.c).parentCommentId))) {
        localCommentViewItem.a();
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  private static boolean h(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.a == 0) && (paramCommentViewItem.c != null);
  }
  
  private boolean i(CommentViewItem paramCommentViewItem)
  {
    Object localObject = n();
    if (localObject == null) {
      return false;
    }
    localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
    if (localObject == null) {
      return false;
    }
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramCommentViewItem = ((SubCommentData)localBaseCommentData).parentCommentId;
    } else {
      paramCommentViewItem = "";
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.getWholeStringContent(), localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramCommentViewItem);
    return true;
  }
  
  private void u()
  {
    Looper.myQueue().addIdleHandler(new ReadInJoyCommentListAdapter.1(this));
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((this.h != null) && (!this.h.isEmpty()) && (paramInt >= 0) && (paramInt < this.h.size())) {
      return (CommentViewItem)this.h.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.f != null)
    {
      this.f.a(this.s, 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadData | feedsType ");
      localStringBuilder.append(this.s);
      QLog.d("ReadInJoyCommentListAdapter", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    if (!b(paramLong)) {
      return;
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      BaseCommentData localBaseCommentData = ((CommentViewItem)localIterator.next()).c;
      if (a(localBaseCommentData, paramLong)) {
        localBaseCommentData.isFollowButtonShown = true;
      }
    }
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.y = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.e != null) {
      this.e.a(1, paramCommentViewItem);
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData, int paramInt)
  {
    if ((this.w != null) && (paramCommentViewItem != null) && (paramCommentViewItem.d != null) && (paramCommentViewItem.c != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.w.a(true, paramCommentViewItem.c.commentId, str);
      if (this.e != null) {
        this.e.a(paramCommentViewItem, paramInt);
      }
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.x = paramOnCommentListLoadListener;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initArticleCommentInfoModule | articleInfo ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append("; anchorData : ");
    localStringBuilder.append(paramAnchorData);
    localStringBuilder.append("; contentSrc : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" reqFeedsType Default 5 currentFeedsType ");
    localStringBuilder.append(this.s);
    QLog.d("ReadInJoyCommentListAdapter", 2, localStringBuilder.toString());
    a(paramAbsBaseArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a(paramAbsBaseArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2, true);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initArticleCommentInfoModule | reqFeedsType ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ; currentFeedsType ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" ; articleInfo ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append("; anchorData : ");
    localStringBuilder.append(paramAnchorData);
    localStringBuilder.append(";feedsType ：");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; contentSrc : ");
    localStringBuilder.append(paramInt2);
    QLog.d("ReadInJoyCommentListAdapter", 1, localStringBuilder.toString());
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.i = paramAbsBaseArticleInfo;
    this.s = paramInt1;
    this.f = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo, paramInt2);
    if (this.f != null)
    {
      this.f.a(this.l);
      paramAbsBaseArticleInfo = this.z;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.c())) {
        this.f.a(this.z.f(), paramInt1);
      }
      this.e = new ReadInJoyCommentReportManager(this, this.i, paramInt2);
      this.f.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.a)))
      {
        paramAbsBaseArticleInfo = new ReadInJoyCommentDataManager.CommentAnchor(paramAnchorData.a, paramAnchorData.b, paramAnchorData.c ^ true, paramAnchorData.c);
        this.f.a(paramAbsBaseArticleInfo);
      }
      this.f.a(paramInt1, 1);
      this.h.clear();
      notifyDataSetChanged();
    }
    RIJCommentAdUtils.h();
  }
  
  @VisibleForTesting
  boolean a(BaseCommentData paramBaseCommentData, long paramLong)
  {
    return (paramBaseCommentData != null) && (paramBaseCommentData.shouldShowFollowButton) && (String.valueOf(paramLong).equals(paramBaseCommentData.uin));
  }
  
  public void b()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.z;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.g();
    }
  }
  
  @VisibleForTesting
  boolean b(long paramLong)
  {
    return (paramLong > 0L) && (this.h != null) && (this.h.size() > 0);
  }
  
  public void c()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.z;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.h();
    }
  }
  
  public int d()
  {
    if (this.h != null)
    {
      if (this.h.isEmpty()) {
        return -1;
      }
      int i = 0;
      while (i < this.h.size())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)this.h.get(i);
        if (localCommentViewItem.a != 2)
        {
          if (localCommentViewItem.a == 1) {
            return i;
          }
          i += 1;
        }
        else
        {
          return i;
        }
      }
    }
    return -1;
  }
  
  public void e()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.z;
    long l;
    if (localReadInJoyCommentListFragment != null) {
      l = localReadInJoyCommentListFragment.k();
    } else {
      l = 0L;
    }
    if (this.f != null) {
      this.f.b(this);
    }
    if ((this.e != null) && (l > 0L)) {
      this.e.a(l, 2);
    }
    this.v = null;
    this.c = null;
    this.i = null;
    this.z = null;
    if (this.d != null)
    {
      this.d.setCurActivity(null);
      this.d = null;
    }
    RIJCommentAdUtils.g();
    if (this.r != null) {
      this.r.b();
    }
    this.w = null;
    if (this.p != null) {
      this.p.a();
    }
  }
  
  public ReadInJoyCommentDataManager f()
  {
    return this.f;
  }
  
  LayoutInflater g()
  {
    return this.v;
  }
  
  public int getCount()
  {
    if (this.h != null) {
      return this.h.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.d = m();
    View localView = paramView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localView = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localView = null;
            QLog.d("ReadInJoyCommentListAdapter", 1, "getView | first comment reset NonNullView");
          }
        }
      }
    }
    int i = getItemViewType(paramInt);
    if (i == 6) {
      return this.f.n().a(paramViewGroup, localView, this.c, a(paramInt));
    }
    if (DynamicCommentProteusHelper.b(a(paramInt)))
    {
      paramViewGroup = this.m.a(a(paramInt));
      paramView = localView;
      if (localView == null) {
        paramView = this.d.getViewFactory().inflate(this.d, paramViewGroup);
      }
      DynamicCommentProteusHelper.a(this.d, (Container)paramView, paramViewGroup, this, paramInt, i, true);
    }
    else
    {
      paramViewGroup = CommentProteusUtil.a(this.d, a(paramInt), i, true, this);
      paramView = localView;
      if (localView == null)
      {
        TraceUtils.traceBegin("ReadInJoyCommentAdapter.create convertView");
        paramView = this.d.getViewFactory().inflate(this.d, paramViewGroup);
        TraceUtils.traceEnd();
      }
      CommentProteusUtil.a(this.d, (Container)paramView, paramViewGroup, this, paramInt, i, true);
    }
    RIJCommentAdUtils.a(this, a(paramInt), paramInt, paramView);
    if (this.e != null) {
      this.e.c(paramInt);
    }
    if (this.n != null) {
      this.n.a(paramInt, paramView);
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getView | first comment convertview is null ; position ");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(" viewtype ");
      paramViewGroup.append(i);
      paramViewGroup.append("\n commentItem: ");
      if (a(paramInt) != null) {
        paramView = a(paramInt).c;
      } else {
        paramView = "commentData is null";
      }
      paramViewGroup.append(paramView);
      paramView = paramViewGroup.toString();
      QLog.d("ReadInJoyCommentListAdapter", 1, paramView);
      paramViewGroup = t();
      AIOUtils.a("ReadInJoyCommentListAdapter", "first comment convertview is null", new NullPointerException(paramView));
    }
    return paramViewGroup;
  }
  
  ReadInJoyCommentUtils.CommentComponetEventListener h()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.z;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.o();
    }
    return null;
  }
  
  public void i()
  {
    l();
  }
  
  public void j()
  {
    l();
  }
  
  public void k()
  {
    if ((r() != null) && (this.A > -1)) {
      r().setSelectionFromTop(this.A, this.B);
    }
  }
  
  @VisibleForTesting
  void k_(int paramInt)
  {
    ReadInJoyCommentUtils.CommentListListener localCommentListListener = this.w;
    if (localCommentListListener != null) {
      localCommentListListener.c(paramInt);
    }
  }
  
  public void l()
  {
    if (this.g == null) {
      return;
    }
    int k = d();
    if (this.u != 1)
    {
      this.g.smoothScrollBy(0, 0);
      this.g.smoothScrollToPosition(k);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollToComment | contentSrc ");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append("; titlePos ");
      ((StringBuilder)localObject).append(k);
      QLog.d("ReadInJoyCommentListAdapter", 2, ((StringBuilder)localObject).toString());
      return;
    }
    ListAdapter localListAdapter = this.g.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof HeaderViewListAdapter)) {
      localObject = ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof FastWebMergeAdapter))
    {
      localObject = ((FastWebMergeAdapter)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
        if ((localListAdapter instanceof WebFastAdapter))
        {
          i = localListAdapter.getCount();
          break label191;
        }
      }
    }
    int i = -1;
    label191:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollToComment | articleItemCnt: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" titlePos : ");
    ((StringBuilder)localObject).append(k);
    QLog.d("ReadInJoyCommentListAdapter", 1, ((StringBuilder)localObject).toString());
    int j = k;
    if (i != -1) {
      j = k + i;
    }
    this.g.smoothScrollBy(0, 0);
    this.g.smoothScrollToPositionFromTop(j + 1, 0);
  }
  
  public VafContext m()
  {
    if (this.d == null)
    {
      this.d = new ReadInjoyContext();
      this.d.setCurActivity(this.c);
      this.d.setContext(this.c);
      ProteusSupportUtil.a(this.d, "comment_feeds");
    }
    return this.d;
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if ((paramBoolean) && (this.f != null))
    {
      if (paramPair == null) {
        return;
      }
      Object localObject = (List)paramPair.first;
      paramPair = (List)paramPair.second;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = this.f.d(this.s);
        if ((localObject != null) && (this.h != null))
        {
          this.h.clear();
          this.h.addAll((Collection)localObject);
          notifyDataSetChanged();
        }
      }
      if ((paramPair != null) && (paramPair.size() > 0))
      {
        paramPair = paramPair.iterator();
        while (paramPair.hasNext())
        {
          localObject = (BaseCommentData)paramPair.next();
          if (this.h != null)
          {
            paramInt = 0;
            while (paramInt < this.h.size())
            {
              CommentViewItem localCommentViewItem = (CommentViewItem)this.h.get(paramInt);
              if ((localCommentViewItem != null) && (localCommentViewItem.a == 0) && (localObject != null) && (localCommentViewItem.c != null) && (TextUtils.equals(localCommentViewItem.c.commentId, ((SubCommentData)localObject).parentCommentId))) {
                localCommentViewItem.a();
              }
              paramInt += 1;
            }
            notifyDataSetChanged();
          }
        }
      }
      if (getCount() <= 0) {
        k_(2);
      }
      c(this.f.b(this.s));
      ReadInJoyCommentUtils.a(this.i.mRecommendSeq, false);
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt)
  {
    if (!e(paramInt))
    {
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("onCommentCreate | wrong feedstype , currentFeedsType ");
      paramCommentViewItem.append(this.s);
      paramCommentViewItem.append(", feedsType ");
      paramCommentViewItem.append(paramInt);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
      return;
    }
    if (paramBoolean)
    {
      a(paramCommentViewItem, paramList, paramInt);
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910308), 0).show();
  }
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt)
  {
    if (!e(paramInt))
    {
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("onCommentCreate | wrong feedstype , currentFeedsType ");
      paramCommentViewItem.append(this.s);
      paramCommentViewItem.append(", feedsType ");
      paramCommentViewItem.append(paramInt);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
      return;
    }
    this.s = 2;
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramCommentViewItem, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.f == null) {
        return;
      }
      if (!b(paramInt2))
      {
        paramCommentViewItem = new StringBuilder();
        paramCommentViewItem.append("onCommentDelete | wrong feedstype , currentFeedsType ");
        paramCommentViewItem.append(this.s);
        paramCommentViewItem.append(", feedsType ");
        paramCommentViewItem.append(paramInt2);
        QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
        return;
      }
      if (paramInt1 == 1)
      {
        paramCommentViewItem = this.f.d(paramInt2);
        if ((paramCommentViewItem != null) && (this.h != null))
        {
          this.h.clear();
          this.h.addAll(paramCommentViewItem);
          notifyDataSetChanged();
        }
      }
      else if ((paramInt1 == 2) && (this.h != null))
      {
        paramInt1 = 0;
        while (paramInt1 < this.h.size())
        {
          CommentViewItem localCommentViewItem = (CommentViewItem)this.h.get(paramInt1);
          if ((localCommentViewItem != null) && (localCommentViewItem.a == 0) && (paramCommentViewItem != null) && (paramCommentViewItem.c != null) && (localCommentViewItem.c != null) && (TextUtils.equals(localCommentViewItem.c.commentId, ((SubCommentData)paramCommentViewItem.c).parentCommentId))) {
            localCommentViewItem.a();
          }
          paramInt1 += 1;
        }
        notifyDataSetChanged();
      }
      if (getCount() <= 0) {
        k_(2);
      }
      c(this.f.b(paramInt2));
      ReadInJoyCommentUtils.a(this.i.mRecommendSeq, false);
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!d(paramInt3))
    {
      paramList = new StringBuilder();
      paramList.append("onCommentListLoad | wrong feedstype , currentFeedsType ");
      paramList.append(this.s);
      paramList.append(", feedsType ");
      paramList.append(paramInt3);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramList.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentListLoad first comments ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" feedsType : ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("\n commentDataListSize ");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject).append(i);
    QLog.d("ReadInJoyCommentListAdapter", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean1)
    {
      if (this.g != null) {
        this.g.loadMoreFail();
      }
      k_(3);
      return;
    }
    if (this.g != null) {
      this.g.loadingMoreComplete(paramBoolean2);
    }
    if ((this.h != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.h.clear();
      b(paramList);
      k_(4);
      a(paramList);
    }
    else
    {
      k_(2);
    }
    notifyDataSetChanged();
    localObject = this.x;
    if (localObject != null) {
      ((ReadInJoyCommentDataManager.OnCommentListLoadListener)localObject).onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
    }
    long l = this.f.b(this.s);
    c(l);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentListLoad | mCommentNumChangedListener onUpdate feedsType ");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append(" count : ");
    ((StringBuilder)localObject).append(l);
    QLog.d("ReadInJoyCommentListAdapter", 2, ((StringBuilder)localObject).toString());
    if (this.p != null) {
      RIJCommentAdUtils.a(this.p, 0, paramList);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {
      return;
    }
    if (!b(paramInt2))
    {
      paramList = new StringBuilder();
      paramList.append("onCommentLoadMore | wrong feedstype , currentFeedsType ");
      paramList.append(this.s);
      paramList.append(", feedsType ");
      paramList.append(paramInt2);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramList.toString());
      return;
    }
    if (paramBoolean1)
    {
      if ((this.h != null) && (paramList != null) && (this.g != null))
      {
        paramInt1 = this.h.size();
        this.h.addAll(paramList);
        this.g.loadingMoreComplete(paramBoolean2);
        notifyDataSetChanged();
        if (this.p != null) {
          RIJCommentAdUtils.a(this.p, paramInt1, paramList);
        }
      }
    }
    else if (this.g != null) {
      this.g.loadingMoreComplete(paramBoolean2);
    }
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    if (paramBoolean)
    {
      b(paramCommentViewItem);
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910403), 0).show();
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.f != null))
    {
      if (this.h == null) {
        return;
      }
      if (this.f.b(this.s) <= 0L)
      {
        this.h.clear();
      }
      else if (paramInt == 1)
      {
        paramString1 = this.f.d(this.s);
        this.h.clear();
        this.h.addAll(paramString1);
      }
      else if (paramInt == 2)
      {
        paramInt = 0;
        while (paramInt < this.h.size())
        {
          paramString2 = (CommentViewItem)this.h.get(paramInt);
          if ((paramString2 != null) && (paramString2.a == 0) && (paramString2.c != null) && (TextUtils.equals(paramString2.c.commentId, paramString1))) {
            paramString2.a();
          }
          paramInt += 1;
        }
      }
      notifyDataSetChanged();
      if (getCount() <= 0) {
        k_(2);
      }
      c(this.f.b(this.s));
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    ReadInJoyCommentDataManager.OnCommentListLoadListener localOnCommentListLoadListener = this.x;
    if (localOnCommentListLoadListener != null)
    {
      localOnCommentListLoadListener.onCommentStateError(paramInt);
      return;
    }
    if (paramInt == 1001) {
      QRUtils.a(1, 2131915274);
    }
  }
  
  public void startLoadMore(ListView paramListView)
  {
    if (this.f != null)
    {
      this.f.c(this.s);
      paramListView = new StringBuilder();
      paramListView.append("startLoadMore | feedsType ");
      paramListView.append(this.s);
      QLog.d("ReadInJoyCommentListAdapter", 2, paramListView.toString());
    }
    if (this.e != null) {
      this.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */