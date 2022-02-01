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
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
  private ReadInJoyCommentUtils.CommentListListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  public ReadInJoyCommentListAdapter(QBaseActivity paramQBaseActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramQBaseActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public ReadInJoyCommentListAdapter(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramFastWebActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a() == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a();
    if ((((ReadInJoyCommentDataManager.CommentAnchor)localObject).jdField_a_of_type_Boolean) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).b != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (CommentViewItem)paramList.next();
        if ((localObject != null) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor)) {
          ((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor = false;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (a() != null))
    {
      this.e = a().getFirstVisiblePosition();
      Object localObject = a();
      int i = 0;
      localObject = ((ReadInJoyCommentListView)localObject).getChildAt(0);
      if (localObject != null) {
        i = ((View)localObject).getTop();
      }
      this.f = i;
    }
  }
  
  private void b(List<CommentViewItem> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
      Object localObject = localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localObject != null)
      {
        localObject = ((BaseCommentData)localObject).commentId;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!localHashSet.contains(localObject))
          {
            this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
            localHashSet.add(localObject);
          }
          else
          {
            i = 1;
          }
        }
        else {
          this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
      }
    }
    if (i != 0) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkDataDuplicate | error!!! first page comment data duplicated!");
    }
  }
  
  private boolean b(int paramInt)
  {
    if ((this.c == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5)))
    {
      this.c = paramInt;
      return true;
    }
    return this.c == paramInt;
  }
  
  private boolean c(int paramInt)
  {
    if ((paramInt == 2) && ((this.c == 2) || (this.c == 3)))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
      return true;
    }
    return this.c == paramInt;
  }
  
  private void j()
  {
    Looper.myQueue().addIdleHandler(new ReadInJoyCommentListAdapter.1(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return -1;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localCommentViewItem.jdField_a_of_type_Int != 2)
        {
          if (localCommentViewItem.jdField_a_of_type_Int == 1) {
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
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  ReadInJoyCommentUtils.CommentComponetEventListener a()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public ReadInJoyCommentDataManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c, 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadData | feedsType ");
      localStringBuilder.append(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, localStringBuilder.toString());
    }
  }
  
  @VisibleForTesting
  void a(int paramInt)
  {
    ReadInJoyCommentUtils.CommentListListener localCommentListListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener;
    if (localCommentListListener != null) {
      localCommentListListener.b(paramInt);
    }
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(1, paramCommentViewItem);
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener != null) && (paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener.a(true, paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId, str);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(paramCommentViewItem, paramInt);
      }
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = paramOnCommentListLoadListener;
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
    localStringBuilder.append(this.c);
    QLog.d("ReadInJoyCommentListAdapter", 2, localStringBuilder.toString());
    a(paramAbsBaseArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initArticleCommentInfoModule | reqFeedsType ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ; currentFeedsType ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ; articleInfo ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append("; anchorData : ");
    localStringBuilder.append(paramAnchorData);
    localStringBuilder.append(";feedsType ：");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; contentSrc : ");
    localStringBuilder.append(paramInt2);
    QLog.d("ReadInJoyCommentListAdapter", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.b())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.c(), paramInt1);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager = new ReadInJoyCommentReportManager(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramAbsBaseArticleInfo = new ReadInJoyCommentDataManager.CommentAnchor(paramAnchorData.jdField_a_of_type_JavaLangString, paramAnchorData.b, paramAnchorData.jdField_a_of_type_Boolean ^ true, paramAnchorData.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.b();
    }
  }
  
  public void c()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.c();
    }
  }
  
  public void d()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    long l;
    if (localReadInJoyCommentListFragment != null) {
      l = localReadInJoyCommentListFragment.a();
    } else {
      l = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) && (l > 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(l, 2);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CommentListListener = null;
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
  }
  
  public void g()
  {
    if ((a() != null) && (this.e > -1)) {
      a().setSelectionFromTop(this.e, this.f);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = a();
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
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a().a(paramViewGroup, localView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, a(paramInt));
    }
    if (DynamicCommentProteusHelper.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a(a(paramInt));
      paramView = localView;
      if (localView == null) {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
      }
      DynamicCommentProteusHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
    }
    else
    {
      paramViewGroup = CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
      paramView = localView;
      if (localView == null)
      {
        TraceUtils.traceBegin("ReadInJoyCommentAdapter.create convertView");
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
        TraceUtils.traceEnd();
      }
      CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.c(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter$OnGetViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter$OnGetViewListener.a(paramInt, paramView);
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
        paramView = a(paramInt).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      } else {
        paramView = "commentData is null";
      }
      paramViewGroup.append(paramView);
      paramView = paramViewGroup.toString();
      QLog.d("ReadInJoyCommentListAdapter", 1, paramView);
      paramViewGroup = a();
      AIOUtils.a("ReadInJoyCommentListAdapter", "first comment convertview is null", new NullPointerException(paramView));
    }
    return paramViewGroup;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView == null) {
      return;
    }
    int k = a();
    if (this.d != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollBy(0, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollToPosition(k);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollToComment | contentSrc ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("; titlePos ");
      ((StringBuilder)localObject).append(k);
      QLog.d("ReadInJoyCommentListAdapter", 2, ((StringBuilder)localObject).toString());
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getAdapter();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollToPositionFromTop(j + 1, 0);
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null))
    {
      if (paramPair == null) {
        return;
      }
      Object localObject = (List)paramPair.first;
      paramPair = (List)paramPair.second;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c);
        if ((localObject != null) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
          notifyDataSetChanged();
        }
      }
      if ((paramPair != null) && (paramPair.size() > 0))
      {
        paramPair = paramPair.iterator();
        while (paramPair.hasNext())
        {
          localObject = (BaseCommentData)paramPair.next();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            paramInt = 0;
            while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
            {
              CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
              if ((localCommentViewItem != null) && (localCommentViewItem.jdField_a_of_type_Int == 0) && (localObject != null) && (localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (TextUtils.equals(localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId, ((SubCommentData)localObject).parentCommentId))) {
                localCommentViewItem.a();
              }
              paramInt += 1;
            }
            notifyDataSetChanged();
          }
        }
      }
      if (getCount() <= 0) {
        a(2);
      }
      paramPair = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
      if (paramPair != null) {
        paramPair.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c));
      }
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq, false);
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("onCommentCreate | wrong feedstype , currentFeedsType ");
      paramCommentViewItem.append(this.c);
      paramCommentViewItem.append(", feedsType ");
      paramCommentViewItem.append(paramInt);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
      return;
    }
    if (paramBoolean)
    {
      this.c = 2;
      int i = 2131717822;
      if (RIJBiuAndCommentAladdinUtils.a()) {
        i = 2131717756;
      }
      QQToast.a(BaseApplication.getContext(), 2, i, 0).a();
      a(4);
      Object localObject;
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCommentCreate commentViewItemList size ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("ReadInJoyCommentListAdapter", 2, ((StringBuilder)localObject).toString());
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          notifyDataSetChanged();
          j();
        }
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
      if (paramList != null) {
        paramList.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
      if (paramList != null)
      {
        localObject = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
        if ((localObject instanceof SubCommentData)) {
          paramCommentViewItem = ((SubCommentData)localObject).parentCommentId;
        } else {
          paramCommentViewItem = "";
        }
        ReadInJoyLogicEngineEventDispatcher.a().a(true, ((BaseCommentData)localObject).rowKey, ((BaseCommentData)localObject).commentId, ((BaseCommentData)localObject).getWholeStringContent(), ((BaseCommentData)localObject).level, "onCommentSend", paramList.getInt("seq"), paramCommentViewItem);
        ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq, true);
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712733), 0).a();
    }
  }
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("onCommentCreate | wrong feedstype , currentFeedsType ");
      paramCommentViewItem.append(this.c);
      paramCommentViewItem.append(", feedsType ");
      paramCommentViewItem.append(paramInt);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
      return;
    }
    this.c = 2;
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramCommentViewItem, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager == null) {
        return;
      }
      if (!a(paramInt2))
      {
        paramCommentViewItem = new StringBuilder();
        paramCommentViewItem.append("onCommentDelete | wrong feedstype , currentFeedsType ");
        paramCommentViewItem.append(this.c);
        paramCommentViewItem.append(", feedsType ");
        paramCommentViewItem.append(paramInt2);
        QLog.d("ReadInJoyCommentListAdapter", 1, paramCommentViewItem.toString());
        return;
      }
      if (paramInt1 == 1)
      {
        paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramInt2);
        if ((paramCommentViewItem != null) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
          notifyDataSetChanged();
        }
      }
      else if ((paramInt1 == 2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localCommentViewItem != null) && (localCommentViewItem.jdField_a_of_type_Int == 0) && (paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (TextUtils.equals(localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId, ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).parentCommentId))) {
            localCommentViewItem.a();
          }
          paramInt1 += 1;
        }
        notifyDataSetChanged();
      }
      if (getCount() <= 0) {
        a(2);
      }
      paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
      if (paramCommentViewItem != null) {
        paramCommentViewItem.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramInt2));
      }
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq, false);
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
    if (!b(paramInt3))
    {
      paramList = new StringBuilder();
      paramList.append("onCommentListLoad | wrong feedstype , currentFeedsType ");
      paramList.append(this.c);
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
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadMoreFail();
      }
      a(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      b(paramList);
      a(4);
      a(paramList);
    }
    else
    {
      a(2);
    }
    notifyDataSetChanged();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
    if (localObject != null) {
      ((ReadInJoyCommentDataManager.OnCommentListLoadListener)localObject).onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener.onCommentNumChanged(l);
      paramList = new StringBuilder();
      paramList.append("onCommentListLoad | mCommentNumChangedListener onUpdate feedsType ");
      paramList.append(this.c);
      paramList.append(" count : ");
      paramList.append(l);
      QLog.d("ReadInJoyCommentListAdapter", 2, paramList.toString());
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {
      return;
    }
    if (!a(paramInt2))
    {
      paramList = new StringBuilder();
      paramList.append("onCommentLoadMore | wrong feedstype , currentFeedsType ");
      paramList.append(this.c);
      paramList.append(", feedsType ");
      paramList.append(paramInt2);
      QLog.d("ReadInJoyCommentListAdapter", 1, paramList.toString());
      return;
    }
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null))
      {
        this.jdField_a_of_type_JavaUtilList.size();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
        notifyDataSetChanged();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
    }
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    int i = 0;
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131713054), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject != null) && (((CommentViewItem)localObject).jdField_a_of_type_Int == 0) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (TextUtils.equals(((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId, ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).parentCommentId))) {
            ((CommentViewItem)localObject).a();
          }
          i += 1;
        }
        notifyDataSetChanged();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
      if (localObject != null) {
        ((ICommentNumChangedListener)localObject).onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
      if (localObject != null)
      {
        BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
        if ((localBaseCommentData instanceof SubCommentData)) {
          paramCommentViewItem = ((SubCommentData)localBaseCommentData).parentCommentId;
        } else {
          paramCommentViewItem = "";
        }
        ReadInJoyLogicEngineEventDispatcher.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.getWholeStringContent(), localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramCommentViewItem);
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712831), 0).a();
    }
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null))
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c) <= 0L)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      else if (paramInt == 1)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c);
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramString1);
      }
      else if (paramInt == 2)
      {
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          paramString2 = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if ((paramString2 != null) && (paramString2.jdField_a_of_type_Int == 0) && (paramString2.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (TextUtils.equals(paramString2.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId, paramString1))) {
            paramString2.a();
          }
          paramInt += 1;
        }
      }
      notifyDataSetChanged();
      if (getCount() <= 0) {
        a(2);
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
      if (paramString1 != null) {
        paramString1.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this.c));
      }
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    ReadInJoyCommentDataManager.OnCommentListLoadListener localOnCommentListLoadListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
    if (localOnCommentListLoadListener != null)
    {
      localOnCommentListLoadListener.onCommentStateError(paramInt);
      return;
    }
    if (paramInt == 1001) {
      QRUtils.a(1, 2131717799);
    }
  }
  
  public void startLoadMore(ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.c);
      paramListView = new StringBuilder();
      paramListView.append("startLoadMore | feedsType ");
      paramListView.append(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, paramListView.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */