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
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/RIJCommentBubbleView;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "(Landroid/app/Activity;Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "mActivity", "mAdapter", "mAnchor", "Landroid/view/View;", "mArticleInfo", "mBubbleFirstPageView", "mBubbleSecondPageView", "mCommentViewItem", "mDismisListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "mFirstPagePop", "Lcom/tencent/widget/BubblePopupWindow;", "mLabel", "Lcom/tencent/mobileqq/kandian/biz/comment/data/ReadInJoyCommentPBModule$Label;", "mSecondPagePop", "mShareHelper", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2;", "mShowShare", "", "misNeedBiu", "buildBubbleView", "", "isNeedBiu", "showShare", "anchor", "dismissListener", "clickAuthorDelete", "", "clickBiu", "v", "clickBlockButton", "clickCopy", "clickDislike", "clickNextPage", "clickPatrolArbitrationButton", "clickPreviousPage", "clickReportOrDelete", "clickSinkButton", "clickStickyButton", "getOffsetY", "getShareLine", "", "", "isSubComment", "(Z)[Ljava/util/List;", "initAuthorDeleteView", "initBiuView", "initBlockUserCommentView", "initCopyView", "initDislikeView", "initFirstPageView", "initPatrolArbitrationView", "initReportOrDeleteView", "initSecondPageView", "initShareView", "initSinkView", "initStickyView", "isListView", "view", "", "onClick", "reportClickEventToDt", "eid", "", "actionId", "reportMenuItemClick", "action", "shareComment", "showAuthorDeleteOption", "showBlockOption", "showPatrolArbitionOption", "showSecondPage", "showSinkOption", "showStickyOption", "Companion", "SheetItemClickProcessor", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView
  implements View.OnClickListener
{
  public static final RIJCommentBubbleView.Companion a = new RIJCommentBubbleView.Companion(null);
  private CommentViewItem b;
  private Activity c;
  private ReadinjoyCommentListBaseAdapter d;
  private AbsBaseArticleInfo e;
  private View f;
  private View g;
  private BubblePopupWindow h;
  private BubblePopupWindow i;
  private View j;
  private BubblePopupWindow.OnDismissListener k;
  private boolean l;
  private boolean m;
  private ReadInJoyCommentPBModule.Label n;
  private ReadInJoyShareHelperV2 o;
  
  public RIJCommentBubbleView(@NotNull Activity paramActivity, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.b = paramCommentViewItem;
    this.c = paramActivity;
    this.d = paramReadinjoyCommentListBaseAdapter;
    this.e = paramAbsBaseArticleInfo;
    this.l = true;
    this.m = true;
    this.n = new ReadInJoyCommentPBModule.Label();
    paramActivity = LayoutInflater.from((Context)this.c).inflate(2131626157, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…omment_bubble_view, null)");
    this.f = paramActivity;
    paramActivity = LayoutInflater.from((Context)this.c).inflate(2131629129, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…ble_view_next_page, null)");
    this.g = paramActivity;
    this.h = new BubblePopupWindow(-2, -2);
    this.i = new BubblePopupWindow(-2, -2);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int i1;
    if ((this.d instanceof ReadInJoyCommentListAdapter)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.d.q();
    if (localReadInJoyCommentReportManager != null) {
      localReadInJoyCommentReportManager.a(i1, paramInt, this.b);
    }
  }
  
  private final void a(@NonNull View paramView)
  {
    a("copy_button", "click_copy");
    paramView = paramView.getContext().getSystemService("clipboard");
    if (paramView != null)
    {
      paramView = (ClipboardManager)paramView;
      if (!TextUtils.isEmpty(this.b.e)) {
        paramView.setText(this.b.e);
      }
      paramView = this.h;
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
    b();
    c();
    d();
    e();
    f();
    if (a())
    {
      localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject1 = ((View)localObject1).findViewById(2131436554);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mBubbleFirstPageView.findViewById(R.id.iv_right)");
      localObject1 = (ImageView)localObject1;
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    Object localObject1 = this.c;
    if ((localObject1 instanceof FastWebActivity)) {
      if (localObject1 != null)
      {
        localObject1 = (FastWebActivity)localObject1;
        localObject2 = this.h;
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
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    Object localObject2 = this.f;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    ((BubblePopupWindow)localObject1).setContentView((View)localObject2);
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).setOutsideTouchable(true);
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).showAsDropDown(paramView, 0, t());
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.setFocusable(true);
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.setOnDismissListener(paramOnDismissListener);
  }
  
  private final void a(String paramString1, String paramString2)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().f(paramString1);
    paramString1 = this.b.d;
    if (paramString1 != null) {
      paramString1 = paramString1.innerUniqueID;
    } else {
      paramString1 = null;
    }
    VideoReport.reportEvent("clck", RIJDtParamBuilder.a(localRIJDtParamBuilder.e(paramString1).c(paramString2), null, 1, null).a(this.b.c).c());
  }
  
  private final void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448299);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_biu)");
    localObject = (TextView)localObject;
    if ((this.b.c.mediaDataList != null) && (this.b.c.mediaDataList.size() > 0)) {
      if (((BaseCommentData.MediaData)this.b.c.mediaDataList.get(0)).i > 0) {
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
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.t;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.f == true)) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  private final void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    g();
    h();
    i();
    a(paramBoolean, paramAbsBaseArticleInfo);
    j();
    paramAbsBaseArticleInfo = this.g;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.findViewById(2131436434);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mBubbleSecondPageView.findViewById(R.id.iv_left)");
    paramAbsBaseArticleInfo = (ImageView)paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo.setVisibility(0);
    paramAbsBaseArticleInfo.setOnClickListener((View.OnClickListener)this);
    paramAbsBaseArticleInfo = this.i;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramView = this.g;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramAbsBaseArticleInfo.setContentView(paramView);
    paramAbsBaseArticleInfo = this.i;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setOutsideTouchable(true);
    paramAbsBaseArticleInfo = this.i;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setFocusable(true);
    paramAbsBaseArticleInfo = this.i;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramAbsBaseArticleInfo.setOnDismissListener(paramOnDismissListener);
  }
  
  private final boolean a()
  {
    return true;
  }
  
  private final boolean a(Object paramObject)
  {
    return ((paramObject instanceof AdapterView)) || ((paramObject instanceof RecyclerView));
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
  
  private final int b(@NonNull View paramView)
  {
    a("share_button", "click_share");
    Object localObject1;
    String str;
    if (((RIJCommentBubbleView)this).o == null)
    {
      paramView = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "BaseApplicationImpl.getApplication()");
      paramView = paramView.getRuntime();
      if (paramView != null)
      {
        Object localObject2 = (QQAppInterface)paramView;
        paramView = this.b.c.commentContent;
        localObject1 = this.b.c.shareUrl;
        str = this.e.mFirstPagePicUrl;
        Activity localActivity = this.c;
        localObject2 = (AppInterface)localObject2;
        Intrinsics.checkExpressionValueIsNotNull(paramView, "content");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "shareUrl");
        Intrinsics.checkExpressionValueIsNotNull(str, "firstPagePicUrl");
        this.o = new ReadInJoyShareHelperV2(localActivity, (AppInterface)localObject2, (ReadInJoyShareHelperV2.BaseSheetItemClickProcessor)new RIJCommentBubbleView.SheetItemClickProcessor(paramView, (String)localObject1, str, new WeakReference(this.c)));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
    }
    if ((this.b.c instanceof CommentData))
    {
      paramView = this.o;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      localObject1 = a(false);
      str = this.e.innerUniqueID;
      Intrinsics.checkExpressionValueIsNotNull(str, "mArticleInfo.innerUniqueID");
      paramView.a((List[])localObject1, 29, str);
    }
    else if ((this.b.c instanceof SubCommentData))
    {
      paramView = this.o;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      localObject1 = a(true);
      str = this.e.innerUniqueID;
      Intrinsics.checkExpressionValueIsNotNull(str, "mArticleInfo.innerUniqueID");
      paramView.a((List[])localObject1, 29, str);
    }
    paramView = this.o;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
    }
    paramView.a().setRowVisibility(8, 0, 0);
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.dismiss();
    return 11;
  }
  
  private final void b()
  {
    View localView = this.f;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localView = localView.findViewById(2131448355);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mBubbleFirstPageView.findViewById(R.id.tv_copy)");
    ((TextView)localView).setOnClickListener((View.OnClickListener)this);
  }
  
  private final int c(View paramView)
  {
    a("biu_button", "click_biu");
    RIJUserLevelModule.getInstance().doActionsByUserLevel(paramView.getContext(), 2, (IUserLevelCallBack)new RIJCommentBubbleView.clickBiu.1(this));
    paramView = this.i;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    paramView.dismiss();
    return 1;
  }
  
  private final void c()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131448634);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…id.tv_patrol_arbitration)");
    localObject = (TextView)localObject;
    if (o())
    {
      CharSequence localCharSequence = (CharSequence)RIJCommentBubbleViewHelper.a.c();
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
  
  private final void d()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131448744);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_share)");
    localObject = (TextView)localObject;
    if (this.m)
    {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  private final void e()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131448707);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…R.id.tv_report_or_delete)");
    TextView localTextView = (TextView)localObject;
    localObject = this.b.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself()) {
      localObject = "删除";
    } else {
      localObject = "举报";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView.setOnClickListener((View.OnClickListener)this);
  }
  
  private final void f()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131448278);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.fin…Id(R.id.tv_author_delete)");
    localObject = (TextView)localObject;
    if (n())
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setOnClickListener(null);
  }
  
  private final void g()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448301);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_block)");
    localObject = (TextView)localObject;
    if (m())
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setOnClickListener(null);
  }
  
  private final void h()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448304);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_bottom)");
    TextView localTextView = (TextView)localObject;
    if (l())
    {
      if (this.b.l) {
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
  
  private final void i()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448823);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.findViewById(R.id.tv_top)");
    TextView localTextView = (TextView)localObject;
    if (k())
    {
      localTextView.setVisibility(0);
      if (this.b.k) {
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
  
  private final void j()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448392);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.fi…ViewById(R.id.tv_dislike)");
    localObject = (TextView)localObject;
    BaseCommentData localBaseCommentData = this.b.c;
    Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
    int i1;
    if (localBaseCommentData.isDisliked()) {
      i1 = 2131910447;
    } else {
      i1 = 2131910557;
    }
    ((TextView)localObject).setText((CharSequence)HardCodeUtil.a(i1));
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
  }
  
  private final boolean k()
  {
    return (this.d.p()) && (this.d.o() == 3) && (this.b.c.level == 1) && (this.n.c);
  }
  
  private final boolean l()
  {
    return (this.d.p()) && (this.d.o() == 3) && (this.b.c.level == 1) && (this.n.b);
  }
  
  private final boolean m()
  {
    if ((this.d.p()) && (this.n.d))
    {
      BaseCommentData localBaseCommentData = this.b.c;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean n()
  {
    if ((this.d.p()) && (this.n.a) && (!this.b.c.isAuthorReply()))
    {
      BaseCommentData localBaseCommentData = this.b.c;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean o()
  {
    if ((RIJCommentBubbleViewHelper.a.b()) && (this.n.e))
    {
      BaseCommentData localBaseCommentData = this.b.c;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final int p()
  {
    ActionSheet localActionSheet = ActionSheet.create((Context)this.c);
    localActionSheet.setMainTitle(2131915773);
    localActionSheet.addButton(2131915781, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickAuthorDelete.1(this, localActionSheet));
    localActionSheet.show();
    return 4;
  }
  
  private final int q()
  {
    a("feedback_button", "click_feedback");
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject).dismiss();
    localObject = this.b.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself())
    {
      this.d.d(this.b);
      return 4;
    }
    this.d.a((Context)this.c, (ReadInJoyCommentUtils.ReportCommentDialogClickListener)new RIJCommentBubbleView.clickReportOrDelete.1(this));
    return 3;
  }
  
  private final int r()
  {
    this.d.f(this.b);
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    localObject = ((View)localObject).findViewById(2131448392);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleSecondPageView.fi…ViewById(R.id.tv_dislike)");
    localObject = (TextView)localObject;
    BaseCommentData localBaseCommentData = this.b.c;
    Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
    int i1;
    if (localBaseCommentData.isDisliked()) {
      i1 = 2131910251;
    } else {
      i1 = 2131910312;
    }
    ((TextView)localObject).setText((CharSequence)HardCodeUtil.a(i1));
    localObject = this.b.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isDisliked()) {
      localObject = "click_cai";
    } else {
      localObject = "cancel_cai";
    }
    a("cai_button", (String)localObject);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject).dismiss();
    return 5;
  }
  
  private final void s()
  {
    Object localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).dismiss();
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.g;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup)localObject1;
        localObject2 = this.g;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
        }
        localObject2 = ((View)localObject2).getParent();
        if (localObject2 != null)
        {
          localObject2 = (ViewGroup)localObject2;
          localObject2 = this.g;
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
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    Object localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    ((BubblePopupWindow)localObject1).setContentView((View)localObject2);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).setOutsideTouchable(true);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).setFocusable(true);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    ((BubblePopupWindow)localObject1).setOnDismissListener((BubblePopupWindow.OnDismissListener)localObject2);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    ((BubblePopupWindow)localObject1).showAsDropDown((View)localObject2, 0, t());
  }
  
  private final int t()
  {
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    localObject = ((View)localObject).getParent();
    boolean bool = localObject instanceof View;
    ViewParent localViewParent1 = null;
    if (!bool) {
      localObject = null;
    }
    for (localObject = (View)localObject; (localObject != null) && (!a(((View)localObject).getParent())); localObject = (View)localObject)
    {
      ViewParent localViewParent2 = ((View)localObject).getParent();
      localObject = localViewParent2;
      if (!(localViewParent2 instanceof View)) {
        localObject = null;
      }
    }
    if (localObject != null) {
      localViewParent1 = ((View)localObject).getParent();
    }
    int i1;
    if (a(localViewParent1))
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      i1 = ((View)localObject).getTop();
    }
    else
    {
      i1 = 0;
    }
    if (i1 > 0) {
      return 0;
    }
    return -i1;
  }
  
  private final void u()
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).dismiss();
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup)localObject1;
        localObject2 = this.f;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
        }
        localObject2 = ((View)localObject2).getParent();
        if (localObject2 != null)
        {
          localObject2 = (ViewGroup)localObject2;
          localObject2 = this.f;
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
    localObject1 = this.j;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    Object localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    a((View)localObject1, (BubblePopupWindow.OnDismissListener)localObject2);
  }
  
  private final int v()
  {
    boolean bool = this.b.k ^ true;
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.d.f();
    if (!bool)
    {
      localObject = this.b.c;
      if (localObject != null) {
        localObject = ((BaseCommentData)localObject).commentId;
      } else {
        localObject = null;
      }
      localReadInJoyCommentDataManager.c((String)localObject, bool);
      return 7;
    }
    Object localObject = ActionSheet.create((Context)this.c);
    ((ActionSheet)localObject).setMainTitle(2131915789);
    ((ActionSheet)localObject).addButton(2131915793, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickStickyButton.1(this, localReadInJoyCommentDataManager, bool, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    return -1;
  }
  
  private final int w()
  {
    boolean bool = this.b.l ^ true;
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.d.f();
    if (!bool)
    {
      localObject = this.b.c;
      if (localObject != null) {
        localObject = ((BaseCommentData)localObject).commentId;
      } else {
        localObject = null;
      }
      localReadInJoyCommentDataManager.b((String)localObject, bool);
      return 10;
    }
    Object localObject = ActionSheet.create((Context)this.c);
    ((ActionSheet)localObject).setMainTitle(2131915784);
    ((ActionSheet)localObject).addButton(2131915788, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickSinkButton.1(this, localReadInJoyCommentDataManager, bool, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    return -1;
  }
  
  private final void x()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.d.f();
    ActionSheet localActionSheet = ActionSheet.create((Context)this.c);
    localActionSheet.setMainTitle(2131915774);
    localActionSheet.addButton(2131915778, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickBlockButton.1(this, localReadInJoyCommentDataManager, localActionSheet));
    localActionSheet.show();
  }
  
  private final void y()
  {
    this.d.f().c(this.b);
    a(12);
    BubblePopupWindow localBubblePopupWindow = this.h;
    if (localBubblePopupWindow == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    localBubblePopupWindow.dismiss();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull View paramView, @NotNull BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramView, "anchor");
    Intrinsics.checkParameterIsNotNull(paramOnDismissListener, "dismissListener");
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.j = paramView;
    this.k = paramOnDismissListener;
    this.e = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.d.f();
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mAdapter.commentDataManager");
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.b();
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mAdapter.commentDataManager.commentBubbleLabel");
    this.n = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("buildBubbleView  | mLabel ");
    paramAbsBaseArticleInfo.append(this.n);
    LogUtil.QLog.d("RIJCommentBubbleView", 2, paramAbsBaseArticleInfo.toString());
    paramAbsBaseArticleInfo = this.j;
    if (paramAbsBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    paramView = this.k;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    a(paramAbsBaseArticleInfo, paramView);
    if (a())
    {
      paramBoolean1 = this.l;
      paramAbsBaseArticleInfo = this.e;
      paramView = this.j;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
      }
      paramOnDismissListener = this.k;
      if (paramOnDismissListener == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
      }
      a(paramBoolean1, paramAbsBaseArticleInfo, paramView, paramOnDismissListener);
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
    case 2131448823: 
      i1 = v();
      paramView = this.i;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131448744: 
      i1 = b(paramView);
      break;
    case 2131448707: 
      i1 = q();
      break;
    case 2131448634: 
      y();
      break;
    case 2131448392: 
      i1 = r();
      break;
    case 2131448355: 
      a(paramView);
      break;
    case 2131448304: 
      i1 = w();
      paramView = this.i;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131448301: 
      x();
      paramView = this.i;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView.dismiss();
      break;
    case 2131448299: 
      i1 = c(paramView);
      break;
    case 2131448278: 
      i1 = p();
      break;
    case 2131436554: 
      s();
      break;
    case 2131436434: 
      u();
    }
    int i1 = -1;
    a(i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView
 * JD-Core Version:    0.7.0.1
 */