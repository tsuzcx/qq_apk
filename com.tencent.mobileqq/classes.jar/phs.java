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
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/RIJCommentBubbleView;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V", "mActivity", "mAdapter", "mAnchor", "Landroid/view/View;", "mArticleInfo", "mBubbleFirstPageView", "mBubbleSecondPageView", "mCommentViewItem", "mDismisListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "mFirstPagePop", "Lcom/tencent/widget/BubblePopupWindow;", "mLabel", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/ReadInJoyCommentPBModule$Label;", "mSecondPagePop", "misNeedBiu", "", "buildBubbleView", "", "isNeedBiu", "anchor", "dismissListener", "clickAuthorDelete", "", "clickBiu", "v", "clickCopy", "clickDislike", "clickNextPage", "clickPreviousPage", "clickReportOrDelete", "clickSinkButton", "clickStickyButton", "initFirstPageView", "initSecondPageView", "onClick", "reportMenuItemClick", "action", "showAuthorDeleteOption", "showSecondPage", "showSinkOption", "showStickyOption", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class phs
  implements View.OnClickListener
{
  public static final pht a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private blak jdField_a_of_type_Blak;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private pcf jdField_a_of_type_Pcf;
  private pdp jdField_a_of_type_Pdp;
  private pfk jdField_a_of_type_Pfk;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private BubblePopupWindow jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
  private View c;
  
  static
  {
    jdField_a_of_type_Pht = new pht(null);
  }
  
  public phs(@NotNull Activity paramActivity, @NotNull pcf parampcf, @NotNull pdp parampdp, @NotNull ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Pdp = parampdp;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Pcf = parampcf;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Pfk = new pfk();
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131560145, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…omment_bubble_view, null)");
    this.jdField_a_of_type_AndroidViewView = paramActivity;
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131562737, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…ble_view_next_page, null)");
    this.jdField_b_of_type_AndroidViewView = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
  }
  
  private final int a()
  {
    bkzi localbkzi = bkzi.a((Context)this.jdField_a_of_type_AndroidAppActivity);
    localbkzi.a(2131718077);
    localbkzi.a(2131718080, 3);
    localbkzi.c(2131690697);
    localbkzi.a((bkzq)new phu(this, localbkzi));
    localbkzi.show();
    return 4;
  }
  
  private final int a(View paramView)
  {
    qgx.a().a(paramView.getContext(), 2, (qha)new phv(this));
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.a();
    return 1;
  }
  
  private final void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).a();
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
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject1 = (ViewGroup)localObject1;
      localObject2 = this.jdField_b_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject2 = (ViewGroup)localObject2;
      localObject2 = this.jdField_b_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    ((BubblePopupWindow)localObject1).a((View)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).c(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).a(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.jdField_a_of_type_Blak;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    ((BubblePopupWindow)localObject1).a((blak)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    ((BubblePopupWindow)localObject1).b((View)localObject2);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((this.jdField_a_of_type_Pcf instanceof pau)) {}
    for (int i = 1;; i = 2)
    {
      pbn localpbn = this.jdField_a_of_type_Pcf.a();
      if (localpbn == null) {
        break;
      }
      localpbn.a(i, paramInt, this.jdField_a_of_type_Pdp);
      return;
    }
  }
  
  private final void a(@NonNull View paramView)
  {
    paramView = paramView.getContext().getSystemService("clipboard");
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
    paramView = (ClipboardManager)paramView;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Pdp.jdField_a_of_type_JavaLangCharSequence)) {
      paramView.setText(this.jdField_a_of_type_Pdp.jdField_a_of_type_JavaLangCharSequence);
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.a();
  }
  
  private final boolean a()
  {
    return (d()) || (c()) || (b());
  }
  
  private final int b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject).a();
    localObject = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself())
    {
      this.jdField_a_of_type_Pcf.c(this.jdField_a_of_type_Pdp);
      return 4;
    }
    this.jdField_a_of_type_Pcf.a((Context)this.jdField_a_of_type_AndroidAppActivity, (pbx)new phw(this));
    return 3;
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).a();
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
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject1 = (ViewGroup)localObject1;
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject2 = (ViewGroup)localObject2;
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    blak localblak = this.jdField_a_of_type_Blak;
    if (localblak == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    b(bool, (ArticleInfo)localObject1, (View)localObject2, localblak);
  }
  
  private final void b(boolean paramBoolean, ArticleInfo paramArticleInfo, View paramView, blak paramblak)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379857);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_copy)");
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379802);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_biu)");
    localObject = (TextView)localObject;
    if ((this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((pdo)this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e > 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      if (!paramBoolean) {
        ((TextView)localObject).setVisibility(8);
      }
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo;
      if (paramArticleInfo != null)
      {
        paramArticleInfo = paramArticleInfo.a;
        if ((paramArticleInfo != null) && (paramArticleInfo.jdField_a_of_type_Boolean == true)) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380128);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.fin…R.id.tv_report_or_delete)");
      localObject = (TextView)paramArticleInfo;
      paramArticleInfo = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mCommentViewItem.commentData");
      if (!paramArticleInfo.isMyself()) {
        break label462;
      }
      paramArticleInfo = (CharSequence)"删除";
      label270:
      ((TextView)localObject).setText(paramArticleInfo);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131379885);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.findViewById(R.id.tv_dislike)");
      localObject = (TextView)paramArticleInfo;
      paramArticleInfo = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mCommentViewItem.commentData");
      if (!paramArticleInfo.isDisliked()) {
        break label472;
      }
    }
    label462:
    label472:
    for (paramArticleInfo = (CharSequence)anvx.a(2131712394);; paramArticleInfo = (CharSequence)anvx.a(2131712516))
    {
      ((TextView)localObject).setText(paramArticleInfo);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      if (a())
      {
        paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
        if (paramArticleInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
        }
        paramArticleInfo = paramArticleInfo.findViewById(2131369529);
        Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.findViewById(R.id.iv_right)");
        paramArticleInfo = (ImageView)paramArticleInfo;
        paramArticleInfo.setVisibility(0);
        paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FastWebActivity)) {
        break label512;
      }
      paramArticleInfo = this.jdField_a_of_type_AndroidAppActivity;
      if (paramArticleInfo != null) {
        break label485;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity");
      ((TextView)localObject).setVisibility(0);
      break;
      paramArticleInfo = (CharSequence)"举报";
      break label270;
    }
    label485:
    paramArticleInfo = (FastWebActivity)paramArticleInfo;
    localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a((BubblePopupWindow)localObject);
    label512:
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    paramArticleInfo.a((View)localObject);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.c(true);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.b(paramView);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a(true);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a(paramblak);
  }
  
  private final boolean b()
  {
    return (this.jdField_a_of_type_Pcf.a()) && (this.jdField_a_of_type_Pcf.b() == 3) && (this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.level == 1) && (this.jdField_a_of_type_Pfk.c);
  }
  
  private final int c()
  {
    this.jdField_a_of_type_Pcf.e(this.jdField_a_of_type_Pdp);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131379885);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_dislike)");
    TextView localTextView = (TextView)localObject;
    localObject = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isDisliked()) {}
    for (localObject = (CharSequence)anvx.a(2131712185);; localObject = (CharSequence)anvx.a(2131712250))
    {
      localTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
      }
      ((BubblePopupWindow)localObject).a();
      return 5;
    }
  }
  
  private final void c()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = this.jdField_a_of_type_Pcf.a();
    bkzi localbkzi = bkzi.a((Context)this.jdField_a_of_type_AndroidAppActivity);
    localbkzi.a(2131718083);
    localbkzi.a(2131718087, 3);
    localbkzi.c(2131690697);
    localbkzi.a((bkzq)new phx(this, localObjectRef, localbkzi));
    localbkzi.show();
  }
  
  private final void c(boolean paramBoolean, ArticleInfo paramArticleInfo, View paramView, blak paramblak)
  {
    paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramArticleInfo = paramArticleInfo.findViewById(2131379782);
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.fi…Id(R.id.tv_author_delete)");
    paramArticleInfo = (TextView)paramArticleInfo;
    if (d())
    {
      paramView = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "mCommentViewItem.commentData");
      if (paramView.isMyself())
      {
        paramArticleInfo.setVisibility(8);
        paramArticleInfo.setOnClickListener(null);
        paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
        if (paramArticleInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
        }
        paramArticleInfo = paramArticleInfo.findViewById(2131379806);
        Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.tv_bottom)");
        paramArticleInfo = (TextView)paramArticleInfo;
        if (!c()) {
          break label383;
        }
        paramArticleInfo.setText((CharSequence)"沉底");
        paramArticleInfo.setVisibility(0);
        paramArticleInfo.setOnClickListener((View.OnClickListener)this);
        label138:
        paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
        if (paramArticleInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
        }
        paramArticleInfo = paramArticleInfo.findViewById(2131380222);
        Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.tv_top)");
        paramView = (TextView)paramArticleInfo;
        if (!b()) {
          break label407;
        }
        paramView.setVisibility(0);
        if (!this.jdField_a_of_type_Pdp.jdField_a_of_type_Boolean) {
          break label397;
        }
        paramArticleInfo = (CharSequence)"取消置顶";
        label201:
        paramView.setText(paramArticleInfo);
        paramView.setOnClickListener((View.OnClickListener)this);
      }
    }
    for (;;)
    {
      paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131369442);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.iv_left)");
      paramArticleInfo = (ImageView)paramArticleInfo;
      paramArticleInfo.setVisibility(0);
      paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo.a(paramView);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.c(true);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.a(true);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.a(paramblak);
      return;
      paramArticleInfo.setVisibility(0);
      paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      break;
      paramArticleInfo.setVisibility(8);
      paramArticleInfo.setOnClickListener(null);
      break;
      label383:
      paramArticleInfo.setVisibility(8);
      paramArticleInfo.setOnClickListener(null);
      break label138;
      label397:
      paramArticleInfo = (CharSequence)"置顶";
      break label201;
      label407:
      paramView.setVisibility(8);
      paramView.setOnClickListener(null);
    }
  }
  
  private final boolean c()
  {
    return (this.jdField_a_of_type_Pcf.a()) && (this.jdField_a_of_type_Pcf.b() == 3) && (this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.level == 1) && (this.jdField_a_of_type_Pfk.b);
  }
  
  private final int d()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    boolean bool;
    if (!this.jdField_a_of_type_Pdp.jdField_a_of_type_Boolean)
    {
      bool = true;
      localBooleanRef.element = bool;
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = this.jdField_a_of_type_Pcf.a();
      if (localBooleanRef.element) {
        break label100;
      }
      localObject2 = (pdv)((Ref.ObjectRef)localObject1).element;
      localObject1 = this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (localObject1 == null) {
        break label95;
      }
    }
    label95:
    for (Object localObject1 = ((BaseCommentData)localObject1).commentId;; localObject1 = null)
    {
      ((pdv)localObject2).b((String)localObject1, localBooleanRef.element);
      return 7;
      bool = false;
      break;
    }
    label100:
    Object localObject2 = bkzi.a((Context)this.jdField_a_of_type_AndroidAppActivity);
    ((bkzi)localObject2).a(2131718088);
    ((bkzi)localObject2).a(2131718092, 3);
    ((bkzi)localObject2).c(2131690697);
    ((bkzi)localObject2).a((bkzq)new phy(this, (Ref.ObjectRef)localObject1, localBooleanRef, (bkzi)localObject2));
    ((bkzi)localObject2).show();
    return -1;
  }
  
  private final boolean d()
  {
    return (this.jdField_a_of_type_Pcf.a()) && (this.jdField_a_of_type_Pfk.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Pdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply());
  }
  
  public final void a(boolean paramBoolean, @NotNull ArticleInfo paramArticleInfo, @NotNull View paramView, @NotNull blak paramblak)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramView, "anchor");
    Intrinsics.checkParameterIsNotNull(paramblak, "dismissListener");
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramView;
    this.jdField_a_of_type_Blak = paramblak;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    paramArticleInfo = this.jdField_a_of_type_Pcf.a();
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mAdapter.commentDataManager");
    paramArticleInfo = paramArticleInfo.a();
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mAdapter.commentDataManager.commentBubbleLabel");
    this.jdField_a_of_type_Pfk = paramArticleInfo;
    LogUtil.QLog.d("RIJCommentBubbleView", 2, "buildBubbleView  | mLabel " + this.jdField_a_of_type_Pfk);
    paramBoolean = this.jdField_a_of_type_Boolean;
    paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    paramView = this.c;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    paramblak = this.jdField_a_of_type_Blak;
    if (paramblak == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    b(paramBoolean, paramArticleInfo, paramView, paramblak);
    if (a())
    {
      paramBoolean = this.jdField_a_of_type_Boolean;
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      paramView = this.c;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
      }
      paramblak = this.jdField_a_of_type_Blak;
      if (paramblak == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
      }
      c(paramBoolean, paramArticleInfo, paramView, paramblak);
      LogUtil.QLog.d("RIJCommentBubbleView", 2, "showSecondPage");
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    int i = -1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      i = a(paramView);
      continue;
      i = c();
      continue;
      i = b();
      continue;
      b();
      continue;
      a();
      continue;
      i = a();
      continue;
      i = d();
      BubblePopupWindow localBubblePopupWindow = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (localBubblePopupWindow == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      localBubblePopupWindow.a();
      continue;
      c();
      localBubblePopupWindow = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (localBubblePopupWindow == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      localBubblePopupWindow.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phs
 * JD-Core Version:    0.7.0.1
 */