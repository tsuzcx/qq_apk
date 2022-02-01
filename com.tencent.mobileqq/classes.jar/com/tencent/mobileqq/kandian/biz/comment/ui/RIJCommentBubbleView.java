package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.ReportCommentDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.Label;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.MediaData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentBubbleViewHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/RIJCommentBubbleView;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "(Landroid/app/Activity;Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "mActivity", "mAdapter", "mAnchor", "Landroid/view/View;", "mArticleInfo", "mBubbleFirstPageView", "mBubbleSecondPageView", "mCommentViewItem", "mDismisListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "mFirstPagePop", "Lcom/tencent/widget/BubblePopupWindow;", "mLabel", "Lcom/tencent/mobileqq/kandian/biz/comment/data/ReadInJoyCommentPBModule$Label;", "mSecondPagePop", "mShareHelper", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2;", "misNeedBiu", "", "buildBubbleView", "", "isNeedBiu", "anchor", "dismissListener", "clickAuthorDelete", "", "clickBiu", "v", "clickBlockButton", "clickCopy", "clickDislike", "clickNextPage", "clickPatrolArbitrationButton", "clickPreviousPage", "clickReportOrDelete", "clickSinkButton", "clickStickyButton", "getShareLine", "", "", "isSubComment", "(Z)[Ljava/util/List;", "initAuthorDeleteView", "initBiuView", "initBlockUserCommentView", "initCopyView", "initDislikeView", "initFirstPageView", "initPatrolArbitrationView", "initReportOrDeleteView", "initSecondPageView", "initShareView", "initSinkView", "initStickyView", "onClick", "reportClickEventToDt", "eid", "", "actionId", "reportMenuItemClick", "action", "shareComment", "showAuthorDeleteOption", "showBlockOption", "showPatrolArbitionOption", "showSecondPage", "showSinkOption", "showStickyOption", "Companion", "SheetItemClickProcessor", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView
  implements View.OnClickListener
{
  public static final RIJCommentBubbleView.Companion a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem;
  private ReadInJoyCommentPBModule.Label jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private BubblePopupWindow jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
  private View c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiRIJCommentBubbleView$Companion = new RIJCommentBubbleView.Companion(null);
  }
  
  public RIJCommentBubbleView(@NotNull Activity paramActivity, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem = paramCommentViewItem;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label = new ReadInJoyCommentPBModule.Label();
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131560110, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…omment_bubble_view, null)");
    this.jdField_a_of_type_AndroidViewView = paramActivity;
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131562698, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…ble_view_next_page, null)");
    this.jdField_b_of_type_AndroidViewView = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
  }
  
  private final int a()
  {
    ActionSheet localActionSheet = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131718281);
    localActionSheet.addButton(2131718289, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickAuthorDelete.1(this, localActionSheet));
    localActionSheet.show();
    return 4;
  }
  
  private final int a(@NonNull View paramView)
  {
    a("share_button", "click_share");
    Object localObject1;
    String str;
    if (((RIJCommentBubbleView)this).jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 == null)
    {
      paramView = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "BaseApplicationImpl.getApplication()");
      paramView = paramView.getRuntime();
      if (paramView != null)
      {
        Object localObject2 = (QQAppInterface)paramView;
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentContent;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.shareUrl;
        str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl;
        Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
        localObject2 = (AppInterface)localObject2;
        Intrinsics.checkExpressionValueIsNotNull(paramView, "content");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "shareUrl");
        Intrinsics.checkExpressionValueIsNotNull(str, "firstPagePicUrl");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(localActivity, (AppInterface)localObject2, (ReadInJoyShareHelperV2.BaseSheetItemClickProcessor)new RIJCommentBubbleView.SheetItemClickProcessor(paramView, (String)localObject1, str, new WeakReference(this.jdField_a_of_type_AndroidAppActivity)));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      localObject1 = a(false);
      str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
      Intrinsics.checkExpressionValueIsNotNull(str, "mArticleInfo.innerUniqueID");
      paramView.a((List[])localObject1, 29, str);
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof SubCommentData))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      localObject1 = a(true);
      str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
      Intrinsics.checkExpressionValueIsNotNull(str, "mArticleInfo.innerUniqueID");
      paramView.a((List[])localObject1, 29, str);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
    }
    paramView.a().setRowVisibility(8, 0, 0);
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.dismiss();
    return 11;
  }
  
  private final void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localView = localView.findViewById(2131379597);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mBubbleFirstPageView.findViewById(R.id.tv_copy)");
    ((TextView)localView).setOnClickListener((View.OnClickListener)this);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter instanceof ReadInJoyCommentListAdapter)) {
      i = 1;
    } else {
      i = 2;
    }
    ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
    if (localReadInJoyCommentReportManager != null) {
      localReadInJoyCommentReportManager.a(i, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
    }
  }
  
  private final void a(@NonNull View paramView)
  {
    a("copy_button", "click_copy");
    paramView = paramView.getContext().getSystemService("clipboard");
    if (paramView != null)
    {
      paramView = (ClipboardManager)paramView;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_JavaLangCharSequence)) {
        paramView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_JavaLangCharSequence);
      }
      paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
      }
      paramView.dismiss();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
  }
  
  private final void a(View paramView, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    a();
    b();
    c();
    d();
    e();
    if (a())
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject1 = ((View)localObject1).findViewById(2131369483);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mBubbleFirstPageView.findViewById(R.id.iv_right)");
      localObject1 = (ImageView)localObject1;
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject1 instanceof FastWebActivity)) {
      if (localObject1 != null)
      {
        localObject1 = (FastWebActivity)localObject1;
        localObject2 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
        }
        ((FastWebActivity)localObject1).a((BubblePopupWindow)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity");
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    Object localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    ((BubblePopupWindow)localObject1).setContentView((View)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).setOutsideTouchable(true);
    localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).showAsDropDown(paramView);
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.setFocusable(true);
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.setOnDismissListener(paramOnDismissListener);
  }
  
  private final void a(String paramString1, String paramString2)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().f(paramString1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (paramString1 != null) {
      paramString1 = paramString1.innerUniqueID;
    } else {
      paramString1 = null;
    }
    VideoReport.reportEvent("clck", RIJDtParamBuilder.a(localRIJDtParamBuilder.e(paramString1).c(paramString2), null, 1, null).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).a());
  }
  
  private final void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379547);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_biu)");
    localObject = (TextView)localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mediaDataList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mediaDataList.size() > 0)) {
      if (((BaseCommentData.MediaData)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.mediaDataList.get(0)).e > 0) {
        ((TextView)localObject).setVisibility(8);
      } else {
        ((TextView)localObject).setVisibility(0);
      }
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    if (!paramBoolean) {
      ((TextView)localObject).setVisibility(8);
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.a;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.jdField_a_of_type_Boolean == true)) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  private final boolean a()
  {
    return true;
  }
  
  private final List<Integer>[] a(boolean paramBoolean)
  {
    List localList = (List)new ArrayList();
    if (!paramBoolean)
    {
      localList.add(Integer.valueOf(2));
      localList.add(Integer.valueOf(3));
    }
    localList.add(Integer.valueOf(9));
    localList.add(Integer.valueOf(10));
    localList.add(Integer.valueOf(12));
    return new List[] { localList };
  }
  
  private final int b()
  {
    a("feedback_button", "click_feedback");
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject).dismiss();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
      return 4;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a((Context)this.jdField_a_of_type_AndroidAppActivity, (ReadInJoyCommentUtils.ReportCommentDialogClickListener)new RIJCommentBubbleView.clickReportOrDelete.1(this));
    return 3;
  }
  
  private final int b(View paramView)
  {
    a("biu_button", "click_biu");
    RIJUserLevelModule.getInstance().doActionsByUserLevel(paramView.getContext(), 2, (IUserLevelCallBack)new RIJCommentBubbleView.clickBiu.1(this));
    paramView = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramView.dismiss();
    return 1;
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379803);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…id.tv_patrol_arbitration)");
    localObject = (TextView)localObject;
    if (f())
    {
      CharSequence localCharSequence = (CharSequence)RIJCommentBubbleViewHelper.a.a();
      if (!TextUtils.isEmpty(localCharSequence)) {
        ((TextView)localObject).setText(localCharSequence);
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setOnClickListener(null);
  }
  
  private final void b(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    f();
    g();
    h();
    a(paramBoolean, paramAbsBaseArticleInfo);
    i();
    paramAbsBaseArticleInfo = this.jdField_b_of_type_AndroidViewView;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.findViewById(2131369400);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mBubbleSecondPageView.findViewById(R.id.iv_left)");
    paramAbsBaseArticleInfo = (ImageView)paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo.setVisibility(0);
    paramAbsBaseArticleInfo.setOnClickListener((View.OnClickListener)this);
    paramAbsBaseArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramView = this.jdField_b_of_type_AndroidViewView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramAbsBaseArticleInfo.setContentView(paramView);
    paramAbsBaseArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setOutsideTouchable(true);
    paramAbsBaseArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setFocusable(true);
    paramAbsBaseArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setOnDismissListener(paramOnDismissListener);
  }
  
  private final boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.b() == 3) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.level == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.c);
  }
  
  private final int c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379626);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.fi…ViewById(R.id.tv_dislike)");
    localObject = (TextView)localObject;
    BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
    int i;
    if (localBaseCommentData.isDisliked()) {
      i = 2131712673;
    } else {
      i = 2131712737;
    }
    ((TextView)localObject).setText((CharSequence)HardCodeUtil.a(i));
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isDisliked()) {
      localObject = "click_cai";
    } else {
      localObject = "cancel_cai";
    }
    a("cai_button", (String)localObject);
    localObject = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject).dismiss();
    return 5;
  }
  
  private final void c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localView = localView.findViewById(2131379876);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mBubbleFirstPageView.findViewById(R.id.tv_share)");
    ((TextView)localView).setOnClickListener((View.OnClickListener)this);
  }
  
  private final boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.b() == 3) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.level == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.b);
  }
  
  private final int d()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_Boolean ^ true;
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
    if (!bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localObject != null) {
        localObject = ((BaseCommentData)localObject).commentId;
      } else {
        localObject = null;
      }
      localReadInJoyCommentDataManager.c((String)localObject, bool);
      return 7;
    }
    Object localObject = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    ((ActionSheet)localObject).setMainTitle(2131718297);
    ((ActionSheet)localObject).addButton(2131718301, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickStickyButton.1(this, localReadInJoyCommentDataManager, bool, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    return -1;
  }
  
  private final void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379851);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…R.id.tv_report_or_delete)");
    TextView localTextView = (TextView)localObject;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself()) {
      localObject = "删除";
    } else {
      localObject = "举报";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView.setOnClickListener((View.OnClickListener)this);
  }
  
  private final boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.d))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final int e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.b ^ true;
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
    if (!bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localObject != null) {
        localObject = ((BaseCommentData)localObject).commentId;
      } else {
        localObject = null;
      }
      localReadInJoyCommentDataManager.b((String)localObject, bool);
      return 10;
    }
    Object localObject = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    ((ActionSheet)localObject).setMainTitle(2131718292);
    ((ActionSheet)localObject).addButton(2131718296, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickSinkButton.1(this, localReadInJoyCommentDataManager, bool, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    return -1;
  }
  
  private final void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379527);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…Id(R.id.tv_author_delete)");
    localObject = (TextView)localObject;
    if (e())
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setOnClickListener(null);
  }
  
  private final boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorReply()))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final void f()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379549);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_block)");
    localObject = (TextView)localObject;
    if (d())
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setOnClickListener(null);
  }
  
  private final boolean f()
  {
    if ((RIJCommentBubbleViewHelper.a.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.e))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final void g()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379552);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_bottom)");
    TextView localTextView = (TextView)localObject;
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.b) {
        localObject = "取消沉底";
      } else {
        localObject = "沉底";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      localTextView.setOnClickListener((View.OnClickListener)this);
      return;
    }
    localTextView.setVisibility(8);
    localTextView.setOnClickListener(null);
  }
  
  private final void h()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379937);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_top)");
    TextView localTextView = (TextView)localObject;
    if (b())
    {
      localTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_Boolean) {
        localObject = "取消置顶";
      } else {
        localObject = "置顶";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setOnClickListener((View.OnClickListener)this);
      return;
    }
    localTextView.setVisibility(8);
    localTextView.setOnClickListener(null);
  }
  
  private final void i()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131379626);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.fi…ViewById(R.id.tv_dislike)");
    localObject = (TextView)localObject;
    BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
    int i;
    if (localBaseCommentData.isDisliked()) {
      i = 2131712877;
    } else {
      i = 2131712993;
    }
    ((TextView)localObject).setText((CharSequence)HardCodeUtil.a(i));
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
  }
  
  private final void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).dismiss();
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup)localObject1;
        localObject2 = this.jdField_b_of_type_AndroidViewView;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
        }
        localObject2 = ((View)localObject2).getParent();
        if (localObject2 != null)
        {
          localObject2 = (ViewGroup)localObject2;
          localObject2 = this.jdField_b_of_type_AndroidViewView;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
          }
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    ((BubblePopupWindow)localObject1).setContentView((View)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).setOutsideTouchable(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).setFocusable(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    ((BubblePopupWindow)localObject1).setOnDismissListener((BubblePopupWindow.OnDismissListener)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    ((BubblePopupWindow)localObject1).showAsDropDown((View)localObject2);
  }
  
  private final void k()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).dismiss();
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup)localObject1;
        localObject2 = this.jdField_a_of_type_AndroidViewView;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
        }
        localObject2 = ((View)localObject2).getParent();
        if (localObject2 != null)
        {
          localObject2 = (ViewGroup)localObject2;
          localObject2 = this.jdField_a_of_type_AndroidViewView;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
          }
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    a((View)localObject1, (BubblePopupWindow.OnDismissListener)localObject2);
  }
  
  private final void l()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
    ActionSheet localActionSheet = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131718282);
    localActionSheet.addButton(2131718286, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickBlockButton.1(this, localReadInJoyCommentDataManager, localActionSheet));
    localActionSheet.show();
  }
  
  private final void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a().c(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
    a(12);
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localBubblePopupWindow == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    localBubblePopupWindow.dismiss();
  }
  
  public final void a(boolean paramBoolean, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull View paramView, @NotNull BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramView, "anchor");
    Intrinsics.checkParameterIsNotNull(paramOnDismissListener, "dismissListener");
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramView;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mAdapter.commentDataManager");
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mAdapter.commentDataManager.commentBubbleLabel");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("buildBubbleView  | mLabel ");
    paramAbsBaseArticleInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label);
    LogUtil.QLog.d("RIJCommentBubbleView", 2, paramAbsBaseArticleInfo.toString());
    paramAbsBaseArticleInfo = this.c;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    a(paramAbsBaseArticleInfo, paramView);
    if (a())
    {
      paramBoolean = this.jdField_a_of_type_Boolean;
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      paramView = this.c;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
      }
      paramOnDismissListener = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
      if (paramOnDismissListener == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
      }
      b(paramBoolean, paramAbsBaseArticleInfo, paramView, paramOnDismissListener);
      LogUtil.QLog.d("RIJCommentBubbleView", 2, "showSecondPage");
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379937: 
      i = d();
      paramView = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131379876: 
      i = a(paramView);
      break;
    case 2131379851: 
      i = b();
      break;
    case 2131379803: 
      m();
      break;
    case 2131379626: 
      i = c();
      break;
    case 2131379597: 
      a(paramView);
      break;
    case 2131379552: 
      i = e();
      paramView = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131379549: 
      l();
      paramView = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131379547: 
      i = b(paramView);
      break;
    case 2131379527: 
      i = a();
      break;
    case 2131369483: 
      j();
      break;
    case 2131369400: 
      k();
    }
    int i = -1;
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView
 * JD-Core Version:    0.7.0.1
 */