package com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id.Companion;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView.OnSetNickNameListener;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.AbsVideoFeedsUGView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelperFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView$OnSetNickNameListener;", "rootView", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "adHeaderdownloadView", "Landroid/widget/FrameLayout;", "adverSign", "Landroid/widget/TextView;", "biuLayout", "Landroid/view/ViewGroup;", "contentLayout", "danmakuContainer", "getDanmakuContainer", "()Landroid/widget/FrameLayout;", "setDanmakuContainer", "(Landroid/widget/FrameLayout;)V", "followBtn", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsFollowButton;", "footerBiuCountTextView", "footerBuiBtn", "Landroid/widget/ImageView;", "footerCommentBtn", "footerCommentBtnBg", "footerCommentBtnText", "footerDiversion", "footerLikeBtn", "footerLikeCountTextView", "footerViewGroup", "footerWriteCommentBar", "gameBarBtn", "gameBarContainer", "gameBarContent", "gameBarDownloadView", "gameBarThumbnail", "Lcom/tencent/image/URLImageView;", "gameBarTitle", "headerAccountIconImageView", "Lcom/tencent/mobileqq/kandian/biz/common/widget/IReadInJoyHeadImageView;", "headerAccountLayout", "headerAccountNameTextView", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView;", "headerAdBarTitleLayout", "headerAdContainer", "headerAdMore", "headerAdThumbnail", "headerAdTips", "headerAdTitle", "headerDiversion", "headerSmallGameAdContainer", "headerSoftAdContainer", "headerViewGroup", "hearAdBarIvDownload", "isShowingContent", "", "()Z", "setShowingContent", "(Z)V", "mAdBarCloseSmallV3", "mAdBarDescSmallV3", "mAdBarExpandLayoutSmallV3", "mAdBarThumbnailDescSmallV3", "mAdBarTipsPromotionSmallV3", "mAdBarTipsSmallV3", "mAdBarTitleSmallV3", "mAdBarTitleSmallV4", "mBigCardNormalView", "mBigCardNormalViewAms184", "mBigCardNormalViewAms65", "mBigCardNormalViewTest", "mHeadAdBarThumbnailSmallV3", "mHeadAdBarThumbnailSmallV4", "mSoftAdDownloadViewBig", "mSoftAdDownloadViewSmallV3", "mVideoFeedsHeaderTopAdContainerSmall", "mVideoFeedsHeaderTopAdContainerSmallV3", "Landroid/widget/LinearLayout;", "mVideoFeedsHeaderTopAdContainerSmallV4", "shareBtn", "shareGuideBtn", "shareLayout", "shuntBarCloseBtn", "shuntBarContainer", "shuntBarThumbnail", "shuntBarTitle", "smallGameBtnText", "smallGameDivider", "softAdBigCard", "softAdThumbnailCloseBtn", "strongShuntBarCloseBtn", "strongShuntBarContainer", "strongShuntBarJumpBtn", "strongShuntBarSubTitle", "strongShuntBarThumbnail", "strongShuntBarTitle", "strongShuntBarViewStub", "Landroid/view/ViewStub;", "titleTextView", "ugViewShoot", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/AbsVideoFeedsUGView;", "ugViewTop", "videoFeedsAccessibilityHelper", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelper;", "onSetNickName", "", "nickName", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public class VideoItemHolder
  extends BaseVideoItemHolder
  implements AbsReadInJoyNickNameTextView.OnSetNickNameListener
{
  @JvmField
  @Nullable
  public View A;
  @JvmField
  @Nullable
  public TextView A;
  @JvmField
  @Nullable
  public View B;
  @JvmField
  @Nullable
  public TextView B;
  @JvmField
  @NotNull
  public View C;
  @JvmField
  @Nullable
  public TextView C;
  @JvmField
  @Nullable
  public TextView D;
  @JvmField
  @Nullable
  public TextView E;
  @JvmField
  @Nullable
  public TextView F;
  @JvmField
  @Nullable
  public TextView G;
  @JvmField
  @Nullable
  public TextView H;
  @JvmField
  @Nullable
  public TextView I;
  @JvmField
  @Nullable
  public TextView J;
  @JvmField
  @Nullable
  public TextView K;
  @JvmField
  @Nullable
  public TextView L;
  @JvmField
  @Nullable
  public TextView M;
  @JvmField
  @Nullable
  public TextView N;
  @JvmField
  @Nullable
  public TextView O;
  @JvmField
  @Nullable
  public ViewStub a;
  @JvmField
  @Nullable
  public FrameLayout a;
  @JvmField
  @Nullable
  public AbsReadInJoyNickNameTextView a;
  @JvmField
  @Nullable
  public IReadInJoyHeadImageView a;
  @JvmField
  @Nullable
  public AbsVideoFeedsUGView a;
  private final IVideoFeedsAccessibilityHelper jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAccessibilityHelper;
  @JvmField
  @Nullable
  public IVideoFeedsFollowButton a;
  private boolean jdField_a_of_type_Boolean;
  @JvmField
  @Nullable
  public FrameLayout b;
  @JvmField
  @Nullable
  public AbsVideoFeedsUGView b;
  @JvmField
  @Nullable
  public FrameLayout c;
  @JvmField
  @Nullable
  public FrameLayout d;
  @JvmField
  @Nullable
  public LinearLayout d;
  @JvmField
  @Nullable
  public URLImageView d;
  @Nullable
  private FrameLayout e;
  @JvmField
  @Nullable
  public LinearLayout e;
  @JvmField
  @Nullable
  public URLImageView e;
  @JvmField
  @Nullable
  public URLImageView f;
  @JvmField
  @Nullable
  public URLImageView g;
  @JvmField
  @Nullable
  public URLImageView h;
  @JvmField
  @Nullable
  public URLImageView i;
  @JvmField
  @Nullable
  public ViewGroup j;
  @JvmField
  @Nullable
  public ViewGroup k;
  @JvmField
  @Nullable
  public ImageView k;
  @JvmField
  @Nullable
  public ViewGroup l;
  @JvmField
  @Nullable
  public ImageView l;
  @JvmField
  @Nullable
  public ViewGroup m;
  @JvmField
  @Nullable
  public ImageView m;
  @JvmField
  @Nullable
  public ViewGroup n;
  @JvmField
  @Nullable
  public ImageView n;
  @JvmField
  @Nullable
  public ViewGroup o;
  @JvmField
  @Nullable
  public ImageView o;
  @JvmField
  @Nullable
  public View p;
  @JvmField
  @Nullable
  public ViewGroup p;
  @JvmField
  @Nullable
  public View q;
  @JvmField
  @Nullable
  public ViewGroup q;
  @JvmField
  @Nullable
  public View r;
  @JvmField
  @Nullable
  public ViewGroup r;
  @JvmField
  @Nullable
  public View s;
  @JvmField
  @Nullable
  public ViewGroup s;
  @JvmField
  @Nullable
  public View t;
  @JvmField
  @Nullable
  public ViewGroup t;
  @JvmField
  @Nullable
  public View u;
  @JvmField
  @Nullable
  public ViewGroup u;
  @JvmField
  @Nullable
  public View v;
  @JvmField
  @Nullable
  public ViewGroup v;
  @JvmField
  @Nullable
  public TextView v;
  @JvmField
  @Nullable
  public View w;
  @JvmField
  @Nullable
  public ViewGroup w;
  @JvmField
  @Nullable
  public TextView w;
  @JvmField
  @Nullable
  public View x;
  @JvmField
  @Nullable
  public ViewGroup x;
  @JvmField
  @Nullable
  public TextView x;
  @JvmField
  @Nullable
  public View y;
  @JvmField
  @Nullable
  public ViewGroup y;
  @JvmField
  @Nullable
  public TextView y;
  @JvmField
  @Nullable
  public View z;
  @JvmField
  @Nullable
  public TextView z;
  
  public VideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    this.C = paramView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAccessibilityHelper = ((IVideoFeedsAccessibilityHelperFactory)QRoute.api(IVideoFeedsAccessibilityHelperFactory.class)).get();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_x_of_type_AndroidViewView = this.C.findViewById(RR.id.a.X());
    this.v = ((TextView)this.C.findViewById(RR.id.a.z()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView = ((AbsVideoFeedsUGView)this.C.findViewById(RR.id.a.A()));
    this.b = ((AbsVideoFeedsUGView)this.C.findViewById(RR.id.a.B()));
    this.j = ((ViewGroup)this.C.findViewById(RR.id.a.C()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView = ((AbsReadInJoyNickNameTextView)this.C.findViewById(RR.id.a.D()));
    paramView = this.C.findViewById(RR.id.a.E());
    if (paramView != null)
    {
      if (paramView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView = ((IReadInJoyHeadImageView)paramView);
        View localView = this.C.findViewById(RR.id.a.F());
        paramView = localView;
        if (!(localView instanceof IVideoFeedsFollowButton)) {
          paramView = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton = ((IVideoFeedsFollowButton)paramView);
        this.jdField_l_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(RR.id.a.G()));
        this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(RR.id.a.H()));
        this.jdField_n_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(RR.id.a.I()));
        this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(RR.id.a.J()));
        this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(RR.id.a.K()));
        this.k = ((ImageView)this.C.findViewById(RR.id.a.L()));
        this.w = ((TextView)this.C.findViewById(RR.id.a.M()));
        this.jdField_p_of_type_AndroidViewView = this.C.findViewById(RR.id.a.N());
        this.jdField_x_of_type_AndroidWidgetTextView = ((TextView)this.C.findViewById(RR.id.a.O()));
        this.y = ((TextView)this.C.findViewById(RR.id.a.P()));
        this.r = ((ViewGroup)this.C.findViewById(RR.id.a.Q()));
        this.s = ((ViewGroup)this.C.findViewById(RR.id.a.R()));
        this.jdField_p_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(RR.id.a.S()));
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.C.findViewById(RR.id.a.T()));
        this.o = ((ViewGroup)this.C.findViewById(RR.id.a.U()));
        this.q = this.C.findViewById(RR.id.a.V());
        this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(RR.id.a.W()));
        this.e = ((FrameLayout)this.C.findViewById(RR.id.a.Y()));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView, (AbsReadInJoyNickNameTextView.OnSetNickNameListener)this);
        VideoReport.setElementId(this.j, "puin_button");
        VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton, "follow_button");
        VideoReport.setElementId(this.jdField_p_of_type_AndroidViewView, "write_comment_button");
        VideoReport.setElementId(this.jdField_m_of_type_AndroidViewViewGroup, "comment_button");
        VideoReport.setElementId(this.jdField_m_of_type_AndroidWidgetImageView, "like_button");
        VideoReport.setElementId(this.jdField_l_of_type_AndroidWidgetImageView, "biu_button");
        VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, "card");
        VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, ReportPolicy.REPORT_POLICY_NONE);
        VideoReport.setElementId(this.g, "card");
        VideoReport.setElementId(this.i, "card");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public void a(@Nullable String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAccessibilityHelper.b((View)localObject, paramString);
      IVideoFeedsAccessibilityHelper localIVideoFeedsAccessibilityHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAccessibilityHelper;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView;
      if (localObject != null) {
        localObject = ((IReadInJoyHeadImageView)localObject).a();
      } else {
        localObject = null;
      }
      localIVideoFeedsAccessibilityHelper.c((View)localObject, paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder
 * JD-Core Version:    0.7.0.1
 */