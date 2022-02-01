package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData.RepliedCommentData;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ReadInJoySecondCommentListAdapter
  extends ReadinjoyCommentListBaseAdapter
  implements ReadInJoyCommentListView.RefreshCallback
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
  private String jdField_a_of_type_JavaLangString;
  private int b = 0;
  
  public ReadInJoySecondCommentListAdapter(QBaseActivity paramQBaseActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment = paramReadInJoySecondCommentListFragment;
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
        if ((localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) {
          localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor = false;
        }
      }
    }
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
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localReadInJoySecondCommentListFragment != null) {
      return localReadInJoySecondCommentListFragment.a();
    }
    return null;
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public ReadInJoyCommentDataManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "onDestroy article=", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo });
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.ao_();
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = null;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(2, paramCommentViewItem);
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = paramOnCommentListLoadListener;
  }
  
  public void a(String paramString1, String paramString2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager = new ReadInJoyCommentReportManager(this, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramString1);
      a(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_JavaUtilList.addAll(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramString1, paramString2);
      notifyDataSetChanged();
    }
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "initCommentData article=", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "mCommentDataManager=", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager });
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void b(@NotNull CommentViewItem paramCommentViewItem)
  {
    if (!(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof SubCommentData)) {
      return;
    }
    ReadInJoyCommentReportManager.a(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData);
    paramCommentViewItem = ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).repliedCommentData;
    if (paramCommentViewItem == null) {
      return;
    }
    if (paramCommentViewItem.jdField_a_of_type_Int > 0)
    {
      QRUtils.a(1, 2131717799);
      return;
    }
    paramCommentViewItem = paramCommentViewItem.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramCommentViewItem)) {
      return;
    }
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localCommentViewItem != null) && (paramCommentViewItem.equals(CommentProteusUtil.a(localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData))))
      {
        localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAnchor = true;
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollToPosition(j);
      notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
    if (localReadInJoySecondCommentListFragment != null) {
      localReadInJoySecondCommentListFragment.e();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
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
            QLog.d("ReadInJoySecondCommentListAdapter", 1, "getView | sub comment reset NonNullView");
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager == null)
    {
      paramView = new StringBuilder();
      paramView.append("getView | mCommentDataManager is null, article=");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      QLog.w("ReadInJoySecondCommentListAdapter", 1, paramView.toString());
    }
    int i = getItemViewType(paramInt);
    if (i != 0) {
      if (i != 3)
      {
        if ((i != 4) && (i != 5)) {
          break label385;
        }
      }
      else
      {
        if (localView == null)
        {
          paramView = new ReadinjoyCommentViewHolder.ReplyNumTitleHolder();
          localView = paramView.a(this, paramInt, localView, paramViewGroup);
          paramViewGroup = paramView;
          paramView = localView;
        }
        else
        {
          paramViewGroup = (ReadinjoyCommentViewHolder.ReplyNumTitleHolder)localView.getTag();
          paramView = localView;
        }
        localView = paramView;
        if (paramViewGroup == null) {
          break label385;
        }
        paramViewGroup.a(this, paramInt);
        localView = paramView;
        break label385;
      }
    }
    if (DynamicCommentProteusHelper.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a(a(paramInt));
      if (localView != null)
      {
        paramView = localView;
        if ((localView instanceof Container)) {}
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
      }
      DynamicCommentProteusHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      localView = paramView;
    }
    else
    {
      paramViewGroup = CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, false, this);
      if (localView != null)
      {
        paramView = localView;
        if ((localView instanceof Container)) {}
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
      }
      CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, false);
      localView = paramView;
    }
    label385:
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.d(paramInt);
    }
    paramView = localView;
    if (localView == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getView | sub comment convertview is null ; position ");
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
      paramViewGroup = paramViewGroup.toString();
      QLog.d("ReadInJoySecondCommentListAdapter", 1, paramViewGroup);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, paramViewGroup);
      paramView = a();
      AIOUtils.a("ReadInJoySecondCommentListAdapter", "sub comment convertview is null", new NullPointerException(paramViewGroup));
    }
    return paramView;
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if (paramBoolean)
    {
      if (paramPair == null) {
        return;
      }
      paramPair = (List)paramPair.second;
      if (paramInt == 1)
      {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
        if (paramPair != null) {
          paramPair.c();
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null) && (paramPair != null) && (paramPair.size() > 0))
      {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
        if (!paramPair.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramPair);
          notifyDataSetChanged();
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a());
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (!paramBoolean) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentDelete | wrong firstFeedsType");
      return;
    }
    if (paramInt1 == 1)
    {
      paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
      if (paramCommentViewItem != null) {
        paramCommentViewItem.c();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
      if (!paramCommentViewItem.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
        notifyDataSetChanged();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a());
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommentListLoad sub comments ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" flowType : ");
      localStringBuilder.append(paramInt2);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, localStringBuilder.toString());
      if (!a(paramInt3))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad | wrong firstFeedsType");
        return;
      }
      if ((paramBoolean1) && (this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null))
      {
        a(paramList);
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        paramList = new StringBuilder();
        paramList.append("onCommentListLoad list size = ");
        paramList.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("ReadInJoySecondCommentListAdapter", 1, paramList.toString());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommentLoadMore sub comments ");
      localStringBuilder.append(paramBoolean1);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, localStringBuilder.toString());
      if (!a(paramInt2))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore | wrong firstFeedsType");
        return;
      }
      if (paramBoolean1)
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null))
        {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.loadMoreFail();
      }
    }
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712920), 0).a();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null) {
        paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
      } else {
        paramCommentViewItem = new ArrayList();
      }
      if ((!paramCommentViewItem.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
        notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.setSelection(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a());
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712772), 0).a();
    }
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramInt == 1)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoySecondCommentListFragment;
      if (paramString1 != null) {
        paramString1.c();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
      if (!paramString1.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramString1);
        notifyDataSetChanged();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentICommentNumChangedListener.onCommentNumChanged(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a());
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */