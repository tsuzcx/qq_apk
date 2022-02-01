package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView;
import com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentLikeView.OnLikeStateChangeLinstener;
import com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ReadinjoyCommentListBaseAdapter
  extends BaseAdapter
  implements ReadInJoyCommentDataManager.OnDataChangeListener, ReadInJoyCommentLikeView.OnLikeStateChangeLinstener, ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener
{
  protected VafContext a;
  QBaseActivity a;
  protected INegativeHelper a;
  protected DynamicCommentProteusHelper a;
  protected ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener a;
  protected ReadInJoyCommentItemHeightHelper a;
  protected ReadInJoyCommentReportManager a;
  protected ReadinjoyCommentListBaseAdapter.OnGetViewListener a;
  protected ReadInJoyCommentDataManager a;
  protected CommonCommentData a;
  protected ReadInJoyCommentListView a;
  protected AbsBaseArticleInfo a;
  protected AbsListView.OnScrollListener a;
  protected List<CommentViewItem> a;
  protected boolean a;
  protected int c = -1;
  
  public ReadinjoyCommentListBaseAdapter()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadinjoyCommentListBaseAdapter.1(this);
  }
  
  private int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper;
    int j = 0;
    if (localObject == null) {
      return 0;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(0) != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView.getChildAt(0).getTop();
    } else {
      i = 0;
    }
    while (j < paramInt)
    {
      i += this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper.a(j);
      j += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("calculateScrollYOffsetHeight | firstVisiblePos ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" totalHeight ");
    ((StringBuilder)localObject).append(i);
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager;
    if (localObject != null)
    {
      ((ReadInJoyCommentDataManager)localObject).b_(paramString, paramInt1);
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
      if (localObject != null)
      {
        if ((this instanceof ReadInJoyCommentListAdapter)) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = 2;
        }
        ((ReadInJoyCommentReportManager)localObject).a(paramInt1, paramString);
      }
    }
  }
  
  abstract LayoutInflater a();
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
    localView.setTag("non_null_convertview");
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "createNotNullView");
    return localView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public QBaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  }
  
  public ReadInJoyCommentReportManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
  }
  
  abstract ReadInJoyCommentUtils.CommentComponetEventListener a();
  
  public CommentViewItem a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Click more button in  commentLineId is :");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("     mViewState is :");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("ReadinjoyCommentListBaseAdapter", 2, String.format(((StringBuilder)localObject1).toString(), new Object[0]));
    }
    boolean bool = paramString.contains("-");
    Object localObject2 = "";
    if (bool) {
      localObject1 = paramString.split("-")[1];
    } else {
      localObject1 = "";
    }
    bool = ((String)localObject1).contains(":");
    String str = localObject1.split(":")[0];
    paramString = (String)localObject2;
    if (((String)localObject1).contains(":")) {
      paramString = localObject1.split(":")[1];
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CommentViewItem)((Iterator)localObject1).next();
      BaseCommentData localBaseCommentData = ((CommentViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localBaseCommentData != null) {
        if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
        {
          SubCommentData localSubCommentData = (SubCommentData)((CommentViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
          if ((localBaseCommentData.commentId.equals(paramString)) && (localSubCommentData.parentCommentId.equals(str)))
          {
            localBaseCommentData.maxLine = 100;
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(str, paramString, ((CommentViewItem)localObject2).b);
            return null;
          }
        }
        else if ((bool) && ((((CommentViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) && (paramInt == 1))
        {
          if ((localBaseCommentData.commentId.equals(str)) && (((CommentData)((CommentViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).subCommentNum > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.b(str, paramString, ((CommentViewItem)localObject2).b);
            return localObject2;
          }
        }
        else if ((!bool) && (localBaseCommentData.commentId.equals(str)))
        {
          localBaseCommentData.maxLine = 100;
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager.a(str, ((CommentViewItem)localObject2).b);
        }
      }
    }
    return null;
  }
  
  public abstract ReadInJoyCommentDataManager a();
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
  }
  
  public void a(Activity paramActivity, View paramView, CommentViewItem paramCommentViewItem, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    new RIJCommentBubbleView(paramActivity, this, paramCommentViewItem, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramView, paramOnDismissListener);
    RIJTransMergeKanDianReport.a("0X800824A");
  }
  
  public void a(Context paramContext, ReadInJoyCommentUtils.ReportCommentDialogClickListener paramReportCommentDialogClickListener)
  {
    if (paramContext == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(2131717820);
    int[] arrayOfInt = new int[7];
    int[] tmp27_25 = arrayOfInt;
    tmp27_25[0] = 2131717813;
    int[] tmp33_27 = tmp27_25;
    tmp33_27[1] = 2131717814;
    int[] tmp39_33 = tmp33_27;
    tmp39_33[2] = 2131717815;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[3] = 2131717816;
    int[] tmp51_45 = tmp45_39;
    tmp51_45[4] = 2131717817;
    int[] tmp57_51 = tmp51_45;
    tmp57_51[5] = 2131717818;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[6] = 2131717819;
    tmp63_57;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localActionSheet.addButton(arrayOfInt[i]);
      i += 1;
    }
    localActionSheet.addCancelButton(2131690728);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.4(this, localActionSheet, arrayOfInt, paramContext, paramReportCommentDialogClickListener));
  }
  
  public void a(Intent paramIntent)
  {
    CommonCommentData localCommonCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
    if (localCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", localCommonCommentData);
      paramIntent = new StringBuilder();
      paramIntent.append("readToBiuActivity   commonCommentData :");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.toString());
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, paramIntent.toString());
    }
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentItemHeightHelper$OnScrollYOffsetListener = paramOnScrollYOffsetListener;
  }
  
  public void a(ReadinjoyCommentListBaseAdapter.OnGetViewListener paramOnGetViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter$OnGetViewListener = paramOnGetViewListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
      int i;
      if ((paramCommentViewItem != null) && (paramCommentViewItem.getAdTag() != -1)) {
        i = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getAdTag();
      } else if (((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
        i = 2;
      } else if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (RIJItemViewTypeUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))) {
        i = 9;
      } else {
        i = 4;
      }
      if (TextUtils.isEmpty(localBaseCommentData.nickName)) {
        paramCommentViewItem = "";
      } else {
        paramCommentViewItem = localBaseCommentData.nickName;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131717812));
      localStringBuilder.append(paramCommentViewItem);
      paramCommentViewItem = localStringBuilder.toString();
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localBaseCommentData, i, paramCommentViewItem, null, false, a(), -1, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(a(), 3, new ReadinjoyCommentListBaseAdapter.3(this, paramString, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager;
    if (localReadInJoyCommentDataManager != null) {
      return localReadInJoyCommentDataManager.a();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentTypeChanged | changeToType ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, ((StringBuilder)localObject).toString());
    this.c = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        ((List)localObject).clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(paramInt));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a().a(false, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).b(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localObject != null) {
      ((ReadInJoyCommentListView)localObject).resetFooterView();
    }
  }
  
  public abstract void c();
  
  public void c(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      if ((paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.ksHomePage))) {
        ReadInJoyCommentUtils.b(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.ksHomePage, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      } else {
        ReadInJoyCommentUtils.a(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.uin, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      }
      ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
      if (localReadInJoyCommentReportManager != null) {
        localReadInJoyCommentReportManager.b(paramCommentViewItem);
      }
    }
  }
  
  public void d(CommentViewItem paramCommentViewItem)
  {
    Object localObject = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    ((ActionSheet)localObject).setMainTitle(2131717847);
    ((ActionSheet)localObject).addButton(2131717846, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    if (!((ActionSheet)localObject).isShowing()) {
      ((ActionSheet)localObject).show();
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.2(this, paramCommentViewItem, (ActionSheet)localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).a(paramCommentViewItem);
    }
  }
  
  public void e(CommentViewItem paramCommentViewItem)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if (paramCommentViewItem != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject == null) {
        return;
      }
      localObject = ReadInJoyCommentUtils.a((AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
      int i = ((Integer)((Pair)localObject).first).intValue();
      int j = ((Integer)((Pair)localObject).second).intValue();
      localObject = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      String str1 = ((BaseCommentData)localObject).getWholeStringContent();
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = RIJCreateArticleInfoForBiu.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.overridePendingTransition(0, 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
      if (localObject != null) {
        ((ReadInJoyCommentReportManager)localObject).c(paramCommentViewItem);
      }
    }
  }
  
  public void f(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject1 = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (((BaseCommentData)localObject1).isDisliked()) {
      i = 2131712789;
    } else {
      i = 2131712886;
    }
    Object localObject2 = HardCodeUtil.a(i);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, (CharSequence)localObject2, 0).a();
    localObject2 = a();
    int i = 1;
    if (localObject2 != null) {
      ((ReadInJoyCommentDataManager)localObject2).a_(((BaseCommentData)localObject1).commentId, ((BaseCommentData)localObject1).isDisliked() ^ true);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
    if (localObject1 != null)
    {
      if (!(this instanceof ReadInJoyCommentListAdapter)) {
        i = 2;
      }
      ((ReadInJoyCommentReportManager)localObject1).b(i, paramCommentViewItem);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return -1;
      }
      localObject = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject == null) {
        return -1;
      }
      if (DynamicCommentProteusHelper.a((CommentViewItem)localObject)) {
        return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper.a((CommentViewItem)localObject);
      }
      return ((CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public int getViewTypeCount()
  {
    DynamicCommentProteusHelper localDynamicCommentProteusHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDynamicCommentProteusHelper;
    int i;
    if (localDynamicCommentProteusHelper != null) {
      i = localDynamicCommentProteusHelper.a();
    } else {
      i = 0;
    }
    return i + 8;
  }
  
  public void i()
  {
    int j = this.c;
    int i = 2;
    if (j == 2) {
      i = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onChangeCommentTypeClick | curType ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("; changeToType ");
    ((StringBuilder)localObject).append(i);
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, ((StringBuilder)localObject).toString());
    this.c = i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        ((List)localObject).clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager.a().a(false, this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentReportManager;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).b(i);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyTuwenViewReadInJoyCommentListView;
    if (localObject != null) {
      ((ReadInJoyCommentListView)localObject).resetFooterView();
    }
    if ((i == 3) && ((this instanceof ReadInJoyCommentListAdapter))) {
      ((ReadInJoyCommentListAdapter)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */